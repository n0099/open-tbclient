package com.baidu.searchbox.v8engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.bean.ImageBitmapBean;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.util.BitmapReferenceMap;
import com.baidu.searchbox.v8engine.util.DeviceInfo;
import com.baidu.smallgame.sdk.Log;
import com.baidu.smallgame.sdk.c.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpHost;
@NotProguard
/* loaded from: classes5.dex */
public class WebGLImageLoader {
    private static final String ASSET_URL = "asset://";
    static final String BDFILE = "bdfile://";
    static final String DATA_URL = "data:";
    private static final boolean DEBUG = false;
    private static final boolean USE_CACHE = true;
    private static ExecutorService sExecutorService;
    private static String TAG = "WebGLImageLoader";
    private static BitmapReferenceMap sReferenceMap = new BitmapReferenceMap();

    public static void loadImage(WebGLImage webGLImage) {
        ImageBitmapBean bitmapBean = getBitmapBean(webGLImage);
        if (bitmapBean != null && bitmapBean.getBitmap() != null) {
            loadCacheImage(webGLImage, bitmapBean.getBitmap());
        } else if (webGLImage.src().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            loadNetImage(webGLImage);
        } else if (webGLImage.src().startsWith(BDFILE)) {
            loadBdfileImage(webGLImage);
        } else if (webGLImage.src().startsWith(DATA_URL)) {
            loadDataImage(webGLImage);
        } else {
            loadLocalImage(webGLImage);
        }
    }

    public static void recycleBitmap(String str) {
        synchronized (BitmapReferenceMap.class) {
            ImageBitmapBean decrease = sReferenceMap.decrease(str);
            if (decrease != null) {
                decrease.resetIfNoUsed();
            }
        }
    }

    static ImageBitmapBean getBitmapBean(WebGLImage webGLImage) {
        initializeIfNeeded();
        String src = webGLImage.src();
        String oldSrc = webGLImage.oldSrc();
        ImageBitmapBean imageBitmapBean = null;
        synchronized (BitmapReferenceMap.class) {
            if (!src.equals(oldSrc)) {
                ImageBitmapBean imageBitmapBean2 = sReferenceMap.get(oldSrc);
                if (imageBitmapBean2 != null) {
                    imageBitmapBean2.decreaseRefCount();
                    if (imageBitmapBean2.resetIfNoUsed()) {
                        sReferenceMap.remove(oldSrc);
                    }
                }
                imageBitmapBean = sReferenceMap.get(src);
                if (imageBitmapBean != null) {
                    imageBitmapBean.increaseRefCount();
                }
            }
        }
        return imageBitmapBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadImageFromConvertedSource(WebGLImage webGLImage, int i, String str, Object obj) {
        Bitmap bitmap;
        ImageBitmapBean imageBitmapBean = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (Build.VERSION.SDK_INT >= 19) {
            options.inPremultiplied = false;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (a.kh(str2)) {
                bitmap = BitmapFactory.decodeFile(str2, options);
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeFile(str2);
                }
            } else {
                bitmap = null;
            }
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
        } else if (obj instanceof InputStream) {
            InputStream inputStream = (InputStream) obj;
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeStream(inputStream);
            }
        } else {
            bitmap = null;
        }
        synchronized (BitmapReferenceMap.class) {
            if (bitmap != null) {
                imageBitmapBean = sReferenceMap.get(str);
                if (imageBitmapBean != null && imageBitmapBean.getBitmap() != null) {
                    bitmap.recycle();
                    bitmap = imageBitmapBean.getBitmap();
                } else {
                    imageBitmapBean = new ImageBitmapBean(str, bitmap);
                    sReferenceMap.put(str, imageBitmapBean);
                }
            }
            if (imageBitmapBean != null) {
                imageBitmapBean.increaseRefCount();
            }
        }
        loadBitmapData(webGLImage, i, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadBitmapData(WebGLImage webGLImage, int i, Bitmap bitmap) {
        if (bitmap != null && webGLImage.setBitmapData(bitmap)) {
            webGLImage.onLoadSuccess(i);
        } else {
            webGLImage.onLoadFailed(i, "load bitmap failed, src is " + webGLImage.src());
        }
    }

    private static void initializeIfNeeded() {
        if (sExecutorService == null) {
            int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
            sExecutorService = Executors.newFixedThreadPool(numberOfCPUCores < 2 ? 1 : numberOfCPUCores / 2);
        }
    }

    public static void runInIOThread(Runnable runnable) {
        initializeIfNeeded();
        sExecutorService.submit(runnable);
    }

    public static void loadCacheImage(final WebGLImage webGLImage, final Bitmap bitmap) {
        final int imageId = webGLImage.getImageId();
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

    public static void loadAssetImage(final WebGLImage webGLImage) {
        final String src = webGLImage.src();
        final String replace = src.substring(src.indexOf("//") + 2).replace("./", "");
        final int imageId = webGLImage.getImageId();
        runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.5
            @Override // java.lang.Runnable
            public void run() {
                InputStream inputStream = null;
                try {
                    try {
                        inputStream = V8Engine.getAppContext().getResources().getAssets().open(replace);
                        WebGLImageLoader.loadImageFromConvertedSource(webGLImage, imageId, src, inputStream);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        WebGLImageLoader.loadBitmapData(webGLImage, imageId, null);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
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

    /* loaded from: classes5.dex */
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
