package com.baidu.searchbox.v8engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.smallgame.sdk.Log;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
@NotProguard
/* loaded from: classes2.dex */
public class WebGLImage extends EventTargetImpl {
    private static final String TAG = "WebGLImage";
    private static HandlerThread sBackgroundThread = null;
    private static Handler sHandler = null;
    private String mBasePath;
    private long mEnginePtr;
    private String mErrorMsg;
    private int mHeight;
    private long mNativePtr;
    ValueCallback<String> mNetFileCallback;
    private String mPath;
    private String mSrc;
    private int mWidth;
    public boolean shouldCache;

    private native void nativeDecodeImage(long j, boolean z, String str);

    private native void nativeOnLoadFailed(long j, String str);

    private native void nativeOnLoadSuccess(long j, String str, int i, int i2);

    private static native boolean nativeReadPixels(long j, Bitmap bitmap, int i, int i2, int i3, int i4);

    public native boolean nativeLoadAsset(long j, Bitmap bitmap, String str);

    private WebGLImage(long j, long j2, String str) {
        super(V8Engine.getInstance(j2));
        this.mSrc = "";
        this.mWidth = 0;
        this.mHeight = 0;
        this.mNativePtr = 0L;
        this.mEnginePtr = 0L;
        this.mBasePath = "";
        this.shouldCache = true;
        this.mNetFileCallback = new ValueCallback<String>() { // from class: com.baidu.searchbox.v8engine.WebGLImage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(final String str2) {
                WebGLImageLoader.runInIOThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImage.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TextUtils.isEmpty(str2)) {
                            WebGLImage.this.onLoadFailed("get file from net error");
                        } else {
                            WebGLImage.this.onLoadSuccess(str2, false);
                        }
                    }
                });
            }
        };
        this.mNativePtr = j;
        this.mEnginePtr = j2;
        this.mBasePath = str;
    }

    public static WebGLImage create(long j, long j2, String str) {
        return new WebGLImage(j, j2, str);
    }

    public void detach() {
        this.mNativePtr = 0L;
    }

    public void setSrc(String str) {
        if (str != null && !this.mSrc.equals(str)) {
            this.mSrc = str;
            WebGLImageLoader.LoadImage(this);
        }
    }

    public int width() {
        return this.mWidth;
    }

    public int height() {
        return this.mHeight;
    }

    public String src() {
        return this.mSrc;
    }

    public long nativePtr() {
        return this.mNativePtr;
    }

    public String basePath() {
        return this.mBasePath;
    }

    public boolean loadAsset() {
        try {
            InputStream open = V8Engine.getAppContext().getAssets().open(this.mSrc);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            this.mWidth = decodeStream.getWidth();
            this.mHeight = decodeStream.getHeight();
            boolean nativeLoadAsset = this.mNativePtr != 0 ? nativeLoadAsset(this.mNativePtr, decodeStream, this.mSrc) : false;
            open.close();
            return nativeLoadAsset;
        } catch (Exception e) {
            Log.e("V8", e.getMessage(), e);
            return false;
        }
    }

    public boolean loadDataURL() {
        try {
            byte[] decode = Base64.decode(this.mSrc.substring(this.mSrc.indexOf(";base64,") + 8), 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            this.mWidth = decodeByteArray.getWidth();
            this.mHeight = decodeByteArray.getHeight();
            if (this.mNativePtr != 0) {
                return nativeLoadAsset(this.mNativePtr, decodeByteArray, this.mSrc);
            }
            return false;
        } catch (Exception e) {
            Log.e("V8", e.getMessage(), e);
            return false;
        }
    }

    public void loadImageFromCacheSuccess(String str, int i, int i2, boolean z) {
        this.mPath = str;
        this.mWidth = i;
        this.mHeight = i2;
        dispatchSuccessEvent(str, z);
    }

    public void onLoadSuccess(String str, boolean z) {
        this.mPath = str;
        if (!z) {
            try {
                if (this.mNativePtr != 0) {
                    nativeDecodeImage(this.mNativePtr, this.shouldCache, this.mPath);
                }
            } catch (Exception e) {
                Log.e("V8", e.getMessage(), e);
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.mWidth = options.outWidth;
        this.mHeight = options.outHeight;
        dispatchSuccessEvent(str, z);
    }

    private void dispatchSuccessEvent(String str, boolean z) {
        V8Engine v8Engine;
        try {
            v8Engine = V8Engine.getInstance(this.mEnginePtr);
        } catch (Exception e) {
            Log.e("V8", e.getMessage(), e);
        }
        if (v8Engine != null) {
            postImageJSCallback(v8Engine, true);
            Log.d(TAG, "onLoadSuccess: " + str + " isAsset: " + z);
            dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            return;
        }
        throw new Exception("can't get the v8engine instance.");
    }

    public void onLoadFailed(String str) {
        V8Engine v8Engine;
        this.mErrorMsg = str;
        try {
            v8Engine = V8Engine.getInstance(this.mEnginePtr);
        } catch (Exception e) {
            Log.e("V8", e.getMessage(), e);
        }
        if (v8Engine != null) {
            postImageJSCallback(v8Engine, false);
            Log.d(TAG, "onLoadFailed: " + str);
            dispatchEvent(new JSEvent("error", str));
            return;
        }
        throw new Exception("can't get the v8engine instance.");
    }

    private void postImageJSCallback(V8Engine v8Engine, final boolean z) {
        v8Engine.postSuspendableTaskOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImage.2
            @Override // java.lang.Runnable
            public void run() {
                WebGLImage.this.invokeCallback(z);
            }
        });
    }

    public void invokeCallback(boolean z) {
        V8Engine v8Engine = V8Engine.getInstance(this.mEnginePtr);
        if (v8Engine != null && v8Engine.isPaused()) {
            postImageJSCallback(v8Engine, z);
        } else if (this.mNativePtr != 0) {
            if (z) {
                nativeOnLoadSuccess(this.mNativePtr, this.mPath, this.mWidth, this.mHeight);
            } else {
                nativeOnLoadFailed(this.mNativePtr, this.mErrorMsg);
            }
        }
    }

    public static Bitmap readCanvas(long j, int i, int i2, int i3, int i4) {
        Bitmap bitmap;
        if (i == -1 || i2 == -1) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            try {
                if (!nativeReadPixels(j, bitmap, i, i2, i3, i4)) {
                    throw new RuntimeException("Failed to read pixels from native canvas");
                }
                return bitmap;
            } catch (Throwable th) {
                th = th;
                Log.e("V8", th.getMessage(), th);
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            bitmap = null;
        }
    }

    public static byte[] compressCanvas(Bitmap bitmap, int i, int i2, String str, float f) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = toCompressFormat(str);
        if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
            bitmap.recycle();
            bitmap = createScaledBitmap;
        }
        bitmap.compress(compressFormat, (int) (100.0f * f), byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String saveTempFilePath(long j, byte[] bArr, String str) throws Throwable {
        File createTempFile;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File file = new File(V8Engine.getInstance(j).getBdFileRealPath());
            if (!file.exists()) {
                file.mkdirs();
            }
            createTempFile = File.createTempFile("tmp_", "." + str, file);
            Log.e("V8", "saveTempFilePath--file : " + createTempFile);
            fileOutputStream = new FileOutputStream(createTempFile);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            String str2 = WebGLImageLoader.BDFILE + createTempFile.getName();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=4] */
    private static void saveBitmapData(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        try {
            File createTempFile = File.createTempFile("tmp_", "." + str, new File("/sdcard"));
            Log.e("V8", "saveBitmapData--file : " + createTempFile);
            fileOutputStream = new FileOutputStream(createTempFile);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    Log.d("V8", th2.getMessage(), th2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                Log.d("V8", th.getMessage(), th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th4) {
                        Log.d("V8", th4.getMessage(), th4);
                    }
                }
            } catch (Throwable th5) {
                FileOutputStream fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th6) {
                        Log.d("V8", th6.getMessage(), th6);
                    }
                }
                throw th5;
            }
        }
    }

    public static String toDataURL(long j, int i, int i2, String str, float f) {
        try {
            Bitmap readCanvas = readCanvas(j, 0, 0, i, i2);
            f = (f <= 0.0f || f > 1.0f) ? 0.92f : 0.92f;
            String validFileType = getValidFileType(str);
            return WebGLImageLoader.DATA_URL + (FileUtils.IMAGE_FILE_START + validFileType) + ";base64," + Base64.encodeToString(compressCanvas(readCanvas, i, i2, validFileType, f), 0);
        } catch (Throwable th) {
            Log.e("V8", th.getMessage(), th);
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private static class CanvasResult {
        @V8JavascriptField
        public String errMsg;
        @V8JavascriptField
        public String tempFilePath;

        CanvasResult(String str, String str2) {
            this.tempFilePath = null;
            this.errMsg = null;
            this.tempFilePath = str;
            this.errMsg = str2;
        }

        CanvasResult() {
            this.tempFilePath = null;
            this.errMsg = null;
        }
    }

    public static String toTempFilePathInternal(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, String str, float f, JsFunction jsFunction, JsFunction jsFunction2, JsFunction jsFunction3, boolean z) {
        String validFileType = getValidFileType(str);
        float f2 = (f <= 0.0f || f > 1.0f) ? 0.92f : f;
        if (z) {
            return toTempFilePathSync(j, j2, i, i2, i3, i4, i5, i6, validFileType, f2);
        }
        return toTempFilePathAsync(j, j2, i, i2, i3, i4, i5, i6, validFileType, f2, jsFunction, jsFunction2, jsFunction3);
    }

    public static String toTempFilePathAsync(long j, final long j2, int i, int i2, int i3, int i4, final int i5, final int i6, final String str, final float f, final JsFunction jsFunction, final JsFunction jsFunction2, final JsFunction jsFunction3) {
        Log.e("V8", "toTempFilePathAsync-- " + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + i6 + ", " + str + ", " + f + ", " + jsFunction + ", " + jsFunction2 + ", " + jsFunction3);
        if (sBackgroundThread == null) {
            sBackgroundThread = new HandlerThread("background");
            sBackgroundThread.start();
            sHandler = new Handler(sBackgroundThread.getLooper());
        }
        final Bitmap readCanvas = (i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0 || i5 <= 0 || i6 <= 0) ? null : readCanvas(j, i, i2, i3, i4);
        sHandler.post(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImage.3
            /* JADX DEBUG: Another duplicated slice has different insns count: {[CONST_STR, CONST_STR, INVOKE, IGET]}, finally: {[CONST_STR, CONST_STR, INVOKE, IGET, IGET, INVOKE, IF] complete} */
            @Override // java.lang.Runnable
            public void run() {
                CanvasResult canvasResult = new CanvasResult();
                try {
                    if (readCanvas == null) {
                        throw new Exception();
                    }
                    String saveTempFilePath = WebGLImage.saveTempFilePath(j2, WebGLImage.compressCanvas(readCanvas, i5, i6, str, f), str);
                    Log.e("V8", "toTempFilePathAsync--Success: " + saveTempFilePath);
                    if (jsFunction != null) {
                        canvasResult.tempFilePath = saveTempFilePath;
                        canvasResult.errMsg = "CanvastoTempFilePath: success";
                        jsFunction.call(canvasResult);
                    }
                    Log.e("V8", "toTempFilePathAsync--Complete: ");
                    if (jsFunction3 != null) {
                        jsFunction3.call(canvasResult);
                    }
                } catch (Throwable th) {
                    try {
                        Log.e("V8", "toTempFilePathAsync--FAILED-" + th.getMessage(), th);
                        if (jsFunction2 != null) {
                            canvasResult.tempFilePath = null;
                            canvasResult.errMsg = "CanvastoTempFilePath failed";
                            jsFunction2.call(canvasResult);
                        }
                    } finally {
                        Log.e("V8", "toTempFilePathAsync--Complete: ");
                        if (jsFunction3 != null) {
                            jsFunction3.call(canvasResult);
                        }
                    }
                }
            }
        });
        return null;
    }

    public static String toTempFilePathSync(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, String str, float f) {
        Log.e("V8", "toTempFilePathSync-- " + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + i6 + ", " + str + ", " + f);
        try {
            if (i == -1 || i2 == -1) {
                throw new Exception("The x or y must be legal");
            }
            if (i3 == -1 || i4 == -1 || i5 == -1 || i6 == -1) {
                throw new Exception("The width or height must be legal");
            }
            return saveTempFilePath(j2, compressCanvas(readCanvas(j, i, i2, i3, i4), i5, i6, str, f), str);
        } catch (Throwable th) {
            Log.e("V8", th.getMessage(), th);
            V8Engine.getInstance(j2).throwJSException(JSExceptionType.Error, th.getMessage());
            return null;
        }
    }

    private static Bitmap.CompressFormat toCompressFormat(String str) {
        return ("jpg".equalsIgnoreCase(str) || "jpeg".equalsIgnoreCase(str)) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
    }

    private static String getValidFileType(String str) {
        if ("jpg".equalsIgnoreCase(str) || "image/jpg".equalsIgnoreCase(str)) {
            return "jpg";
        }
        if ("jpeg".equalsIgnoreCase(str) || "image/jpeg".equalsIgnoreCase(str)) {
            return "jpeg";
        }
        return "png";
    }
}
