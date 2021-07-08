package com.baidu.mobads.container.util.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.cache.LruDiskCache;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class CacheEngine {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_DISK_CACHE = 50000000;
    public static final int MAX_MEMORY_CACHE = 6;
    public static final String TAG = "CacheEngine";
    public static volatile CacheEngine mInstance;
    public transient /* synthetic */ FieldHolder $fh;
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.memoryCache = new LruCache<>(6);
        this.diskCache = LruDiskCache.open(str, MAX_DISK_CACHE);
    }

    public static String convertUrlToFilename(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim() : (String) invokeL.objValue;
    }

    public static CacheEngine getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (mInstance == null) {
                synchronized (CacheEngine.class) {
                    if (mInstance == null && context != null) {
                        mInstance = new CacheEngine(context.getApplicationContext(), 6, MAX_DISK_CACHE);
                    }
                }
            }
            return mInstance;
        }
        return (CacheEngine) invokeL.objValue;
    }

    private CacheResource<File> loadFromDiskCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) ? this.diskCache.fetch(str) : (CacheResource) invokeL.objValue;
    }

    private CacheResource<?> loadFromMemoryCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) ? this.memoryCache.get(str) : (CacheResource) invokeL.objValue;
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.memoryCache.evictAll();
            this.diskCache.close();
        }
    }

    public String getFilePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String convertUrlToFilename = convertUrlToFilename(str);
            return this.mPicDir + convertUrlToFilename;
        }
        return (String) invokeL.objValue;
    }

    public boolean isDataExistsForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = load(convertUrlToFilename(str)) != null;
            return (z || this.diskCache.restoreCompleted) ? z : new File(getFilePath(str)).exists();
        }
        return invokeL.booleanValue;
    }

    public CacheResource<?> load(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            CacheResource<?> loadFromMemoryCache = loadFromMemoryCache(str);
            return loadFromMemoryCache != null ? loadFromMemoryCache : loadFromDiskCache(str);
        }
        return (CacheResource) invokeL.objValue;
    }

    public void release(CacheResource<?> cacheResource) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cacheResource) == null) || cacheResource == null) {
            return;
        }
        cacheResource.recycle();
    }

    public Bitmap retrieveBitmapForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? (Bitmap) retrieveDataForKey(str, new Parser<Bitmap>(this) { // from class: com.baidu.mobads.container.util.cache.CacheEngine.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CacheEngine this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.baidu.mobads.container.util.cache.CacheEngine.Parser
            public /* bridge */ /* synthetic */ Bitmap rawGet(Object obj) {
                return rawGet((AnonymousClass1) obj);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.mobads.container.util.cache.CacheEngine.Parser
            public Bitmap parseFromBytes(byte[] bArr) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, bArr)) == null) {
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
                return (Bitmap) invokeL2.objValue;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.mobads.container.util.cache.CacheEngine.Parser
            public <D> Bitmap rawGet(D d2) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2)) == null) {
                    if (d2 instanceof Bitmap) {
                        return (Bitmap) d2;
                    }
                    return null;
                }
                return (Bitmap) invokeL2.objValue;
            }
        }) : (Bitmap) invokeL.objValue;
    }

    public byte[] retrieveDataForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            CacheResource<?> load = load(convertUrlToFilename(str));
            if (load != null) {
                return load.getByte();
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public void storeBitmap(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, bitmap) == null) {
            storeData(str, new CacheResource<>(bitmap), true, (CacheListener) null);
        }
    }

    public void storeData(String str, byte[] bArr, boolean z, CacheListener cacheListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, bArr, Boolean.valueOf(z), cacheListener}) == null) {
            storeData(str, new CacheResource<>(bArr), z, cacheListener);
        }
    }

    private void storeData(String str, CacheResource<?> cacheResource, boolean z, CacheListener cacheListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, cacheResource, Boolean.valueOf(z), cacheListener}) == null) {
            try {
                String convertUrlToFilename = convertUrlToFilename(str);
                if (z) {
                    this.memoryCache.put(convertUrlToFilename, cacheResource);
                }
                File file = new File(this.diskCache.getCachePath() + convertUrlToFilename);
                if (cacheListener != null) {
                    this.diskCache.addListeners(new LruDiskCache.OnCacheListener(this, convertUrlToFilename, cacheListener) { // from class: com.baidu.mobads.container.util.cache.CacheEngine.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CacheEngine this$0;
                        public final /* synthetic */ String val$convert_key;
                        public final /* synthetic */ CacheListener val$listener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, convertUrlToFilename, cacheListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$convert_key = convertUrlToFilename;
                            this.val$listener = cacheListener;
                        }

                        @Override // com.baidu.mobads.container.util.cache.LruDiskCache.OnCacheListener
                        public void onCacheComplete(String str2, CacheResource<File> cacheResource2) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, str2, cacheResource2) == null) && this.val$convert_key.equals(str2)) {
                                this.val$listener.onCacheComplete();
                                this.this$0.diskCache.removeListener(this);
                            }
                        }

                        @Override // com.baidu.mobads.container.util.cache.LruDiskCache.OnCacheListener
                        public void onCacheFailed(String str2, CacheResource<File> cacheResource2) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, cacheResource2) == null) && this.val$convert_key.equals(str2)) {
                                this.val$listener.onCacheFailed();
                                this.this$0.diskCache.removeListener(this);
                            }
                        }

                        @Override // com.baidu.mobads.container.util.cache.LruDiskCache.OnCacheListener
                        public void onResourceEvicted(String str2, CacheResource<File> cacheResource2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str2, cacheResource2) == null) {
                            }
                        }
                    });
                }
                this.diskCache.store(cacheResource.getByte(), new CacheResource<>(file));
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d("Failed to cache resource.", th);
            }
        }
    }

    public CacheEngine(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String storagePath = SdcardUtils.getStoragePath(context);
        this.mPicDir = storagePath + MaterialLoader.IMAGE_CACHE_PATH;
        this.memoryCache = new LruCache<>(i2);
        this.diskCache = LruDiskCache.open(this.mPicDir, i3);
    }

    private <T> T retrieveDataForKey(String str, Parser<T> parser) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, parser)) == null) {
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
        return (T) invokeLL.objValue;
    }
}
