package com.baidu.searchbox.v8engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.bean.ImageBitmapBean;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.util.BitmapReferenceMap;
import com.baidu.searchbox.v8engine.util.DeviceInfo;
import com.baidu.smallgame.sdk.Log;
import d.a.g0.a.e.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@NotProguard
/* loaded from: classes2.dex */
public class WebGLImageLoader {
    public static final String ASSET_URL = "asset://";
    public static final String BDFILE = "bdfile://";
    public static final String DATA_URL = "data:";
    public static final boolean DEBUG = false;
    public static String TAG = "WebGLImageLoader";
    public static final boolean USE_CACHE = true;
    public static ExecutorService sExecutorService;
    public static BitmapReferenceMap sReferenceMap = new BitmapReferenceMap();

    /* loaded from: classes2.dex */
    public static class NetValueCallback implements ValueCallback<String> {
        public final WebGLImage mImage;
        public final int mImageId;
        public final String mSrc;

        public NetValueCallback(WebGLImage webGLImage) {
            this.mImage = webGLImage;
            this.mSrc = webGLImage.src();
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

    public static ImageBitmapBean getBitmapBean(WebGLImage webGLImage) {
        ImageBitmapBean imageBitmapBean;
        initializeIfNeeded();
        String src = webGLImage.src();
        String oldSrc = webGLImage.oldSrc();
        synchronized (BitmapReferenceMap.class) {
            if (src.equals(oldSrc)) {
                imageBitmapBean = null;
            } else {
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

    @NonNull
    public static String getRealBdFilePath(V8Engine v8Engine, String str) {
        String bdFileRealPath = v8Engine.getBdFileRealPath();
        String substring = str.substring(9);
        if (!substring.startsWith(File.separator)) {
            substring = "/" + substring;
        }
        return bdFileRealPath + substring;
    }

    public static void initializeIfNeeded() {
        if (sExecutorService == null) {
            int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
            sExecutorService = Executors.newFixedThreadPool(numberOfCPUCores < 2 ? 1 : numberOfCPUCores / 2);
        }
    }

    public static void loadAssetImage(final WebGLImage webGLImage) {
        final String src = webGLImage.src();
        final String replace = src.substring(src.indexOf("//") + 2).replace("./", "");
        final int imageId = webGLImage.getImageId();
        runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.5
            /* JADX WARN: Removed duplicated region for block: B:30:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                InputStream inputStream;
                Throwable th;
                try {
                    try {
                        try {
                            inputStream = V8Engine.getAppContext().getResources().getAssets().open(replace);
                            try {
                                WebGLImageLoader.loadImageFromConvertedSource(webGLImage, imageId, src, inputStream);
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                WebGLImageLoader.loadBitmapData(webGLImage, imageId, null);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        inputStream = null;
                    } catch (Throwable th3) {
                        inputStream = null;
                        th = th3;
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
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

    public static void loadBitmapData(WebGLImage webGLImage, int i2, Bitmap bitmap) {
        if (bitmap != null && webGLImage.setBitmapData(bitmap)) {
            webGLImage.onLoadSuccess(i2);
            return;
        }
        webGLImage.onLoadFailed(i2, "load bitmap failed, src is " + webGLImage.src());
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

    public static void loadDataImage(final WebGLImage webGLImage) {
        final String src = webGLImage.src();
        final int imageId = webGLImage.getImageId();
        runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.3
            @Override // java.lang.Runnable
            public void run() {
                String str = src;
                WebGLImageLoader.loadImageFromConvertedSource(webGLImage, imageId, src, Base64.decode(str.substring(str.indexOf(";base64,") + 8), 0));
            }
        });
    }

    public static void loadImage(WebGLImage webGLImage) {
        ImageBitmapBean bitmapBean = getBitmapBean(webGLImage);
        if (bitmapBean != null && bitmapBean.getBitmap() != null) {
            loadCacheImage(webGLImage, bitmapBean.getBitmap());
        } else if (webGLImage.src().startsWith("http")) {
            loadNetImage(webGLImage);
        } else if (webGLImage.src().startsWith(BDFILE)) {
            loadBdfileImage(webGLImage);
        } else if (webGLImage.src().startsWith(DATA_URL)) {
            loadDataImage(webGLImage);
        } else {
            loadLocalImage(webGLImage);
        }
    }

    public static void loadImageFromConvertedSource(WebGLImage webGLImage, int i2, String str, Object obj) {
        Bitmap decodeStream;
        Bitmap decodeStream2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (Build.VERSION.SDK_INT >= 19) {
            options.inPremultiplied = false;
        }
        ImageBitmapBean imageBitmapBean = null;
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (a.b(str2)) {
                decodeStream = BitmapFactory.decodeFile(str2, options);
                if (decodeStream == null) {
                    decodeStream = BitmapFactory.decodeFile(str2);
                }
            }
            decodeStream = null;
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            decodeStream = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeStream == null) {
                decodeStream2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                decodeStream = decodeStream2;
            }
        } else {
            if (obj instanceof InputStream) {
                InputStream inputStream = (InputStream) obj;
                decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                if (decodeStream == null) {
                    decodeStream2 = BitmapFactory.decodeStream(inputStream);
                    decodeStream = decodeStream2;
                }
            }
            decodeStream = null;
        }
        synchronized (BitmapReferenceMap.class) {
            if (decodeStream != null) {
                try {
                    imageBitmapBean = sReferenceMap.get(str);
                    if (imageBitmapBean != null && imageBitmapBean.getBitmap() != null) {
                        decodeStream.recycle();
                        decodeStream = imageBitmapBean.getBitmap();
                    } else {
                        imageBitmapBean = new ImageBitmapBean(str, decodeStream);
                        sReferenceMap.put(str, imageBitmapBean);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (imageBitmapBean != null) {
                imageBitmapBean.increaseRefCount();
            }
        }
        loadBitmapData(webGLImage, i2, decodeStream);
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

    public static void recycleBitmap(String str) {
        synchronized (BitmapReferenceMap.class) {
            ImageBitmapBean decrease = sReferenceMap.decrease(str);
            if (decrease != null) {
                decrease.resetIfNoUsed();
            }
        }
    }

    public static void runInIOThread(Runnable runnable) {
        initializeIfNeeded();
        sExecutorService.submit(runnable);
    }
}
