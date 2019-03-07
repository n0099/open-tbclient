package com.baidu.searchbox.v8engine;

import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.smallgame.sdk.Log;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class WebGLImageLoader {
    public static final String BDFILE = "bdfile://";
    public static final String DATA_URL = "data:";
    private static String TAG = "WebGLImageLoader";
    private static Handler mHandler;
    private static HandlerThread mIOThread;

    public static void LoadImage(WebGLImage webGLImage) {
        if (webGLImage.src().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            loadNetImage(webGLImage.src(), webGLImage);
        } else if (webGLImage.src().startsWith(BDFILE)) {
            loadBdfileImage(webGLImage);
        } else if (webGLImage.src().startsWith(DATA_URL)) {
            loadDataImage(webGLImage);
        } else {
            loadLocalImage(webGLImage);
        }
    }

    private static void initIOThreadIfNeeded() {
        if (mIOThread == null) {
            mIOThread = new HandlerThread("LoadAssetImage");
            mIOThread.start();
            mHandler = new Handler(mIOThread.getLooper());
        }
    }

    public static void runInIOThread(Runnable runnable) {
        initIOThreadIfNeeded();
        mHandler.post(runnable);
    }

    public static void loadBdfileImage(final WebGLImage webGLImage) {
        initIOThreadIfNeeded();
        V8Engine v8Engine = V8Engine.getInstance();
        if (v8Engine == null) {
            Log.e(TAG, "LoadBdfileImage->v8Engine is null");
            return;
        }
        final String bdFileRealPath = v8Engine.getBdFileRealPath();
        mHandler.post(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.1
            @Override // java.lang.Runnable
            public void run() {
                String substring = WebGLImage.this.src().substring(WebGLImageLoader.BDFILE.length());
                if (!substring.startsWith(File.separator)) {
                    substring = "/" + substring;
                }
                String str = bdFileRealPath + substring;
                if (new File(str).exists()) {
                    WebGLImage.this.onLoadSuccess(str, false);
                } else {
                    WebGLImage.this.onLoadFailed("file is not exists");
                }
            }
        });
    }

    public static void loadDataImage(final WebGLImage webGLImage) {
        initIOThreadIfNeeded();
        mHandler.post(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.2
            @Override // java.lang.Runnable
            public void run() {
                if (WebGLImage.this.loadDataURL()) {
                    WebGLImage.this.onLoadSuccess(WebGLImage.this.src(), true);
                } else {
                    WebGLImage.this.onLoadFailed("cannot decode data");
                }
            }
        });
    }

    public static void loadLocalImage(final WebGLImage webGLImage) {
        initIOThreadIfNeeded();
        mHandler.post(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImageLoader.3
            @Override // java.lang.Runnable
            public void run() {
                String str = WebGLImage.this.basePath() + WebGLImage.this.src();
                if (new File(str).exists()) {
                    WebGLImage.this.onLoadSuccess(str, false);
                } else {
                    WebGLImage.this.onLoadFailed("file is not exists");
                }
            }
        });
    }

    public static void loadNetImage(String str, WebGLImage webGLImage) {
        V8Engine v8Engine = V8Engine.getInstance();
        if (v8Engine == null) {
            Log.e(TAG, "loadNetImage->v8Engine is null");
            return;
        }
        V8FileSystemDelegatePolicy fileSystemDelegatePolicy = v8Engine.getFileSystemDelegatePolicy();
        if (fileSystemDelegatePolicy == null) {
            Log.e(TAG, "fileSystemDelegatePolicy is null", new Throwable());
        } else {
            fileSystemDelegatePolicy.loadFileFromUrl(str, webGLImage.mNetFileCallback);
        }
    }
}
