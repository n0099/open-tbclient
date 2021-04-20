package com.baidu.mobads.container.util.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.cache.LruDiskCache;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class CacheEngine {
    public static final int MAX_DISK_CACHE = 50000000;
    public static final int MAX_MEMORY_CACHE = 6;
    public static final String TAG = "CacheEngine";
    public static volatile CacheEngine mInstance;
    public final LruDiskCache diskCache;
    public String mPicDir;
    public final LruCache<String, CacheResource<?>> memoryCache;

    /* loaded from: classes2.dex */
    public interface CacheListener {
        void onCacheComplete();

        void onCacheFailed();
    }

    /* loaded from: classes2.dex */
    public interface Parser<T> {
        T parseFromBytes(byte[] bArr);

        <D> T rawGet(D d2);
    }

    public CacheEngine(String str) {
        this.memoryCache = new LruCache<>(6);
        this.diskCache = LruDiskCache.open(str, MAX_DISK_CACHE);
    }

    public static String convertUrlToFilename(String str) {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
    }

    public static CacheEngine getInstance(Context context) {
        if (mInstance == null) {
            synchronized (CacheEngine.class) {
                if (mInstance == null && context != null) {
                    mInstance = new CacheEngine(context.getApplicationContext(), 6, MAX_DISK_CACHE);
                }
            }
        }
        return mInstance;
    }

    private CacheResource<File> loadFromDiskCache(String str) {
        return this.diskCache.fetch(str);
    }

    private CacheResource<?> loadFromMemoryCache(String str) {
        return this.memoryCache.get(str);
    }

    public void close() {
        this.memoryCache.evictAll();
        this.diskCache.close();
    }

    public String getFilePath(String str) {
        String convertUrlToFilename = convertUrlToFilename(str);
        return this.mPicDir + convertUrlToFilename;
    }

    public boolean isDataExistsForKey(String str) {
        boolean z = load(convertUrlToFilename(str)) != null;
        return (z || this.diskCache.restoreCompleted) ? z : new File(getFilePath(str)).exists();
    }

    public CacheResource<?> load(String str) {
        CacheResource<?> loadFromMemoryCache = loadFromMemoryCache(str);
        return loadFromMemoryCache != null ? loadFromMemoryCache : loadFromDiskCache(str);
    }

    public void release(CacheResource<?> cacheResource) {
        if (cacheResource != null) {
            cacheResource.recycle();
        }
    }

    public Bitmap retrieveBitmapForKey(String str) {
        return (Bitmap) retrieveDataForKey(str, new Parser<Bitmap>() { // from class: com.baidu.mobads.container.util.cache.CacheEngine.1
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.baidu.mobads.container.util.cache.CacheEngine.Parser
            public /* bridge */ /* synthetic */ Bitmap rawGet(Object obj) {
                return rawGet((AnonymousClass1) obj);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.mobads.container.util.cache.CacheEngine.Parser
            public Bitmap parseFromBytes(byte[] bArr) {
                if (bArr == null) {
                    return null;
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    return BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                } catch (OutOfMemoryError unused) {
                    RemoteXAdLogger.getInstance().e(CacheEngine.TAG, "图片请求失败，OOM");
                    return null;
                } catch (Throwable unused2) {
                    RemoteXAdLogger.getInstance().e(CacheEngine.TAG, "图片请求失败，解析异常");
                    return null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.mobads.container.util.cache.CacheEngine.Parser
            public <D> Bitmap rawGet(D d2) {
                if (d2 instanceof Bitmap) {
                    return (Bitmap) d2;
                }
                return null;
            }
        });
    }

    public byte[] retrieveDataForKey(String str) {
        CacheResource<?> load = load(convertUrlToFilename(str));
        if (load != null) {
            return load.getByte();
        }
        return null;
    }

    public void storeBitmap(String str, Bitmap bitmap) {
        storeData(str, new CacheResource<>(bitmap), true, (CacheListener) null);
    }

    public void storeData(String str, byte[] bArr, boolean z, CacheListener cacheListener) {
        storeData(str, new CacheResource<>(bArr), z, cacheListener);
    }

    private void storeData(String str, CacheResource<?> cacheResource, boolean z, final CacheListener cacheListener) {
        try {
            final String convertUrlToFilename = convertUrlToFilename(str);
            if (z) {
                this.memoryCache.put(convertUrlToFilename, cacheResource);
            }
            File file = new File(this.diskCache.getCachePath() + convertUrlToFilename);
            if (cacheListener != null) {
                this.diskCache.addListeners(new LruDiskCache.OnCacheListener() { // from class: com.baidu.mobads.container.util.cache.CacheEngine.2
                    @Override // com.baidu.mobads.container.util.cache.LruDiskCache.OnCacheListener
                    public void onCacheComplete(String str2, CacheResource<File> cacheResource2) {
                        if (convertUrlToFilename.equals(str2)) {
                            cacheListener.onCacheComplete();
                            CacheEngine.this.diskCache.removeListener(this);
                        }
                    }

                    @Override // com.baidu.mobads.container.util.cache.LruDiskCache.OnCacheListener
                    public void onCacheFailed(String str2, CacheResource<File> cacheResource2) {
                        if (convertUrlToFilename.equals(str2)) {
                            cacheListener.onCacheFailed();
                            CacheEngine.this.diskCache.removeListener(this);
                        }
                    }

                    @Override // com.baidu.mobads.container.util.cache.LruDiskCache.OnCacheListener
                    public void onResourceEvicted(String str2, CacheResource<File> cacheResource2) {
                    }
                });
            }
            this.diskCache.store(cacheResource.getByte(), new CacheResource<>(file));
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d("Failed to cache resource.", th);
        }
    }

    public CacheEngine(Context context, int i, int i2) {
        String storagePath = SdcardUtils.getStoragePath(context);
        this.mPicDir = storagePath + MaterialLoader.IMAGE_CACHE_PATH;
        this.memoryCache = new LruCache<>(i);
        this.diskCache = LruDiskCache.open(this.mPicDir, i2);
    }

    private <T> T retrieveDataForKey(String str, Parser<T> parser) {
        CacheResource<?> load = load(convertUrlToFilename(str));
        if (load != null) {
            if (File.class.equals(load.getResourceClass())) {
                return parser.parseFromBytes(load.getByte());
            }
            if (Byte.TYPE.equals(load.getResourceClass())) {
                return null;
            }
            return parser.rawGet(load.get());
        }
        if (!this.diskCache.restoreCompleted) {
            File file = new File(getFilePath(str));
            if (file.exists()) {
                return parser.parseFromBytes(new CacheResource(file).getByte());
            }
        }
        return null;
    }
}
