package com.baidu.searchbox.v8engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.bean.ImageBean;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.util.BitmapReferenceMap;
import com.baidu.searchbox.v8engine.util.BitmapSourceQueue;
import com.baidu.searchbox.v8engine.util.StringBitmapLruCache;
import com.baidu.smallgame.sdk.Log;
import com.baidu.smallgame.sdk.b.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@NotProguard
/* loaded from: classes2.dex */
public class WebGLImageLoader {
    static final String BDFILE = "bdfile://";
    static final String DATA_URL = "data:";
    private static final boolean DEBUG = false;
    private static final int lruCacheMaxSize = 51200;
    public static StringBitmapLruCache sBitmapLruCache;
    public static BitmapSourceQueue sContinuousQueue;
    private static ExecutorService sExecutorService;
    private static String TAG = "WebGLImageLoader";
    public static BitmapReferenceMap sReferenceMap = new BitmapReferenceMap();
    public static Map<String, Integer> sContinuousRefMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadImage(WebGLImage webGLImage) {
        switch (webGLImage.getImageType()) {
            case HTTP:
                loadNetImage(webGLImage);
                return;
            case BDFILE:
                loadBdfileImage(webGLImage);
                return;
            case BASE64:
                loadDataImage(webGLImage);
                return;
            case LOCAL:
                loadLocalImage(webGLImage);
                return;
            case CACHE:
                loadCacheImage(webGLImage);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImageBean.ImageBitmapBean isWebGLImageInCache(WebGLImage webGLImage) {
        initializeIfNeeded();
        String src = webGLImage.src();
        String beforeSrc = webGLImage.beforeSrc();
        ImageBean.ImageBitmapBean imageBitmapBean = null;
        synchronized (WebGLImageLoader.class) {
            if (!src.equals(beforeSrc)) {
                ImageBean.ImageBitmapBean imageBitmapBean2 = sReferenceMap.get(beforeSrc);
                if (imageBitmapBean2 != null) {
                    int bitmapByteCount = imageBitmapBean2.getBitmapByteCount();
                    imageBitmapBean2.decreaseRefCount();
                    if (imageBitmapBean2.resetIfNoUsed()) {
                        V8Engine.nativeNotifyGCMemoryFree(bitmapByteCount);
                        sReferenceMap.remove(beforeSrc);
                    }
                }
                imageBitmapBean = sReferenceMap.get(src);
                if ((imageBitmapBean == null || imageBitmapBean.getBitmap() == null) && (imageBitmapBean = sBitmapLruCache.get(src)) != null && imageBitmapBean.getBitmap() != null) {
                    sReferenceMap.put(src, imageBitmapBean);
                }
                if (imageBitmapBean != null) {
                    imageBitmapBean.increaseRefCount();
                    putBitmapToLruCache(src, imageBitmapBean);
                }
            }
        }
        return imageBitmapBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadImageFromConvertedSource(WebGLImage webGLImage, int i, String str, Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean z;
        ImageBean.ImageBitmapBean imageBitmapBean = null;
        int i2 = 0;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (Build.VERSION.SDK_INT >= 19) {
            options.inPremultiplied = false;
        }
        if (obj instanceof String) {
            if (a.existsFile((String) obj)) {
                bitmap = BitmapFactory.decodeFile((String) obj, options);
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeFile((String) obj);
                }
            } else {
                bitmap = null;
            }
        } else if (obj instanceof byte[]) {
            bitmap = BitmapFactory.decodeByteArray((byte[]) obj, 0, ((byte[]) obj).length, options);
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeByteArray((byte[]) obj, 0, ((byte[]) obj).length);
            }
        } else {
            bitmap = null;
        }
        synchronized (WebGLImageLoader.class) {
            if (bitmap != null) {
                imageBitmapBean = sReferenceMap.get(str);
                if (imageBitmapBean != null && imageBitmapBean.getBitmap() != null) {
                    bitmap.recycle();
                    bitmap2 = imageBitmapBean.getBitmap();
                    z = false;
                } else {
                    imageBitmapBean = new ImageBean.ImageBitmapBean(str, bitmap, webGLImage.getEnginePtr());
                    i2 = bitmap.getByteCount();
                    sReferenceMap.put(str, imageBitmapBean);
                    bitmap2 = bitmap;
                    z = true;
                }
            } else {
                bitmap2 = bitmap;
                z = false;
            }
            if (imageBitmapBean != null) {
                imageBitmapBean.increaseRefCount();
                putBitmapToLruCache(str, imageBitmapBean);
            }
        }
        if (z) {
            V8Engine.notifyGCAllocate(webGLImage.getEnginePtr(), i2);
        }
        loadBitmapData(webGLImage, i, bitmap2);
    }

    private static void putBitmapToLruCache(String str, ImageBean.ImageBitmapBean imageBitmapBean) {
        sContinuousQueue.puts(str);
        Integer num = sContinuousRefMap.get(str);
        if (num == null) {
            num = 0;
        }
        Map<String, Integer> map = sContinuousRefMap;
        Integer valueOf = Integer.valueOf(num.intValue() + 1);
        map.put(str, valueOf);
        sBitmapLruCache.putIfMatchLruRuler(str, imageBitmapBean, valueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadBitmapData(WebGLImage webGLImage, int i, Bitmap bitmap) {
        if (bitmap != null && webGLImage.loadBitmapData(bitmap)) {
            webGLImage.onLoadSuccess(i);
        } else {
            webGLImage.onLoadFailed(i, "load bitmap failed, src is " + webGLImage.src());
        }
    }

    private static void initializeIfNeeded() {
        if (sExecutorService == null) {
            sExecutorService = Executors.newFixedThreadPool(5);
            sBitmapLruCache = new StringBitmapLruCache(Math.min((int) ((Runtime.getRuntime().maxMemory() / StringBitmapLruCache.BYTE_COUNT) / 8), (int) lruCacheMaxSize));
            sContinuousQueue = new BitmapSourceQueue();
        }
    }

    public static void runInIOThread(Runnable runnable) {
        initializeIfNeeded();
        sExecutorService.submit(runnable);
    }

    public static void loadCacheImage(final WebGLImage webGLImage) {
        final int imageId = webGLImage.getImageId();
        final Bitmap bitmap = webGLImage.getBitmap();
        runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.1
            @Override // java.lang.Runnable
            public void run() {
                WebGLImageLoader.loadBitmapData(WebGLImage.this, imageId, bitmap);
            }
        });
    }

    public static void loadBdfileImage(final WebGLImage webGLImage) {
        final V8Engine v8Engine = V8Engine.getInstance();
        if (v8Engine == null) {
            Log.e(TAG, "LoadBdfileImage->v8Engine is null");
            return;
        }
        final String src = webGLImage.src();
        final int imageId = webGLImage.getImageId();
        runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.2
            @Override // java.lang.Runnable
            public void run() {
                WebGLImageLoader.loadImageFromConvertedSource(webGLImage, imageId, src, WebGLImageLoader.getRealBdFilePath(V8Engine.this, src));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static String getRealBdFilePath(V8Engine v8Engine, String str) {
        String bdFileRealPath = v8Engine.getBdFileRealPath();
        String substring = str.substring(BDFILE.length());
        if (!substring.startsWith(File.separator)) {
            substring = "/" + substring;
        }
        return bdFileRealPath + substring;
    }

    public static void loadDataImage(final WebGLImage webGLImage) {
        final String src = webGLImage.src();
        final int imageId = webGLImage.getImageId();
        runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.3
            @Override // java.lang.Runnable
            public void run() {
                WebGLImageLoader.loadImageFromConvertedSource(webGLImage, imageId, src, Base64.decode(src.substring(src.indexOf(";base64,") + 8), 0));
            }
        });
    }

    public static void loadLocalImage(final WebGLImage webGLImage) {
        final String basePath = webGLImage.basePath();
        final String src = webGLImage.src();
        final int imageId = webGLImage.getImageId();
        runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.4
            @Override // java.lang.Runnable
            public void run() {
                WebGLImageLoader.loadImageFromConvertedSource(webGLImage, imageId, src, basePath + src);
            }
        });
    }

    public static void loadNetImage(WebGLImage webGLImage) {
        V8Engine v8Engine = V8Engine.getInstance();
        if (v8Engine == null) {
            Log.e(TAG, "loadNetImage->v8Engine is null");
            return;
        }
        V8FileSystemDelegatePolicy fileSystemDelegatePolicy = v8Engine.getFileSystemDelegatePolicy();
        if (fileSystemDelegatePolicy == null) {
            Log.e(TAG, "fileSystemDelegatePolicy is null", new Throwable());
        } else {
            fileSystemDelegatePolicy.loadFileFromUrl(webGLImage.src(), new NetValueCallback(webGLImage));
        }
    }

    /* loaded from: classes2.dex */
    public static class NetValueCallback implements ValueCallback<String> {
        private final WebGLImage mImage;
        private final int mImageId;
        private final String mSrc;

        NetValueCallback(WebGLImage webGLImage) {
            this.mImage = webGLImage;
            this.mSrc = this.mImage.src();
            this.mImageId = this.mImage.getImageId();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        public void onReceiveValue(final String str) {
            WebGLImageLoader.runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.NetValueCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    WebGLImageLoader.loadImageFromConvertedSource(NetValueCallback.this.mImage, NetValueCallback.this.mImageId, NetValueCallback.this.mSrc, str);
                }
            });
        }
    }
}
