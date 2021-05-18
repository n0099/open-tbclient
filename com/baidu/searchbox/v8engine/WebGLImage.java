package com.baidu.searchbox.v8engine;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.smallgame.sdk.Log;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
@NotProguard
/* loaded from: classes2.dex */
public class WebGLImage {
    public static final boolean DEBUG = false;
    public static final String TAG = "WebGLImage";
    public static HandlerThread sBackgroundThread;
    public static Handler sHandler;
    public String mBasePath;
    public String mBeforeSrc;
    public long mEnginePtr;
    public String mErrorMsg;
    public int mImageId;
    public long mNativePtr;
    public String mSrc = "";
    public int mWidth = 0;
    public int mHeight = 0;

    public WebGLImage(long j, long j2, String str) {
        this.mNativePtr = 0L;
        this.mEnginePtr = 0L;
        this.mBasePath = "";
        this.mNativePtr = j;
        this.mEnginePtr = j2;
        this.mBasePath = str;
    }

    public static byte[] compressCanvas(Bitmap bitmap, int i2, int i3, String str, float f2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = toCompressFormat(str);
        if (i2 != bitmap.getWidth() || i3 != bitmap.getHeight()) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, false);
            bitmap.recycle();
            bitmap = createScaledBitmap;
        }
        bitmap.compress(compressFormat, (int) (f2 * 100.0f), byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static WebGLImage create(long j, long j2, String str) {
        return new WebGLImage(j, j2, str);
    }

    public static String getValidFileType(String str) {
        String str2 = "jpg";
        if (!"jpg".equalsIgnoreCase(str) && !"image/jpg".equalsIgnoreCase(str)) {
            str2 = "jpeg";
            if (!"jpeg".equalsIgnoreCase(str) && !"image/jpeg".equalsIgnoreCase(str)) {
                return "png";
            }
        }
        return str2;
    }

    private native void nativeOnLoadFailed(long j, String str, int i2);

    private native void nativeOnLoadSuccess(long j, int i2);

    public static native boolean nativeReadPixels(long j, Bitmap bitmap, int i2, int i3, int i4, int i5);

    private void postImageJSCallback(V8Engine v8Engine, final JSEvent jSEvent, final int i2) {
        v8Engine.postSuspendableTaskOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImage.1
            @Override // java.lang.Runnable
            public void run() {
                WebGLImage.this.invokeCallback(jSEvent, i2);
            }
        });
    }

    public static Bitmap readCanvas(long j, int i2, int i3, int i4, int i5) {
        Bitmap bitmap;
        if (i2 != -1 && i3 != -1) {
            try {
                bitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                try {
                    if (nativeReadPixels(j, bitmap, i2, i3, i4, i5)) {
                        return bitmap;
                    }
                    throw new RuntimeException("Failed to read pixels from native canvas");
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
        return null;
    }

    public static void recycleBitmap(String str) {
        WebGLImageLoader.recycleBitmap(str);
    }

    public static void saveBitmapData(byte[] bArr, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File createTempFile = File.createTempFile("tmp_", "." + str, new File("/sdcard"));
                Log.e("V8", "saveBitmapData--file : " + createTempFile);
                FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        Log.d("V8", th.getMessage(), th);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                Log.d("V8", th3.getMessage(), th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                Log.d("V8", th4.getMessage(), th4);
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static String saveTempFilePath(long j, byte[] bArr, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(V8Engine.getInstance(j).getBdFileRealPath(), "tmp");
            if (!file.exists()) {
                file.mkdirs();
            }
            File createTempFile = File.createTempFile("tmp_", "." + str, file);
            Log.e("V8", "saveTempFilePath--file : " + createTempFile);
            FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile);
            try {
                fileOutputStream2.write(bArr);
                String str2 = "bdfile://tmp/" + createTempFile.getName();
                fileOutputStream2.close();
                return str2;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap.CompressFormat toCompressFormat(String str) {
        if (!"jpg".equalsIgnoreCase(str) && !"jpeg".equalsIgnoreCase(str)) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static String toDataURL(long j, int i2, int i3, String str, float f2) {
        try {
            Bitmap readCanvas = readCanvas(j, 0, 0, i2, i3);
            if (f2 <= 0.0f || f2 > 1.0f) {
                f2 = 0.92f;
            }
            String validFileType = getValidFileType(str);
            String str2 = FileUtils.IMAGE_FILE_START + validFileType;
            byte[] compressCanvas = compressCanvas(readCanvas, i2, i3, validFileType, f2);
            return WebGLImageLoader.DATA_URL + str2 + ";base64," + Base64.encodeToString(compressCanvas, 2);
        } catch (Throwable th) {
            Log.e("V8", th.getMessage(), th);
            return null;
        }
    }

    public static String toTempFilePathAsync(long j, final long j2, int i2, int i3, int i4, int i5, final int i6, final int i7, final String str, final float f2, final JsFunction jsFunction, final JsFunction jsFunction2, final JsFunction jsFunction3) {
        Log.e("V8", "toTempFilePathAsync-- " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i6 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i7 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + jsFunction + StringUtil.ARRAY_ELEMENT_SEPARATOR + jsFunction2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + jsFunction3);
        if (sBackgroundThread == null) {
            HandlerThread handlerThread = new HandlerThread(NotificationCompat.WearableExtender.KEY_BACKGROUND);
            sBackgroundThread = handlerThread;
            handlerThread.start();
            sHandler = new Handler(sBackgroundThread.getLooper());
        }
        final Bitmap readCanvas = (i2 < 0 || i3 < 0 || i4 <= 0 || i5 <= 0 || i6 <= 0 || i7 <= 0) ? null : readCanvas(j, i2, i3, i4, i5);
        sHandler.post(new Runnable() { // from class: com.baidu.searchbox.v8engine.WebGLImage.2
            /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, IF] complete} */
            @Override // java.lang.Runnable
            public void run() {
                JsFunction jsFunction4;
                CanvasResult canvasResult = new CanvasResult();
                try {
                } catch (Throwable th) {
                    try {
                        Log.e("V8", "toTempFilePathAsync--FAILED-" + th.getMessage(), th);
                        if (jsFunction2 != null) {
                            canvasResult.tempFilePath = null;
                            canvasResult.errMsg = "CanvastoTempFilePath failed";
                            jsFunction2.call(canvasResult);
                        }
                        if (jsFunction4 == null) {
                            return;
                        }
                    } finally {
                        Log.e("V8", "toTempFilePathAsync--Complete: ");
                        jsFunction4 = jsFunction3;
                        if (jsFunction4 != null) {
                            jsFunction4.call(canvasResult);
                        }
                    }
                }
                if (readCanvas != null) {
                    String saveTempFilePath = WebGLImage.saveTempFilePath(j2, WebGLImage.compressCanvas(readCanvas, i6, i7, str, f2), str);
                    Log.e("V8", "toTempFilePathAsync--Success: " + saveTempFilePath);
                    if (jsFunction != null) {
                        canvasResult.tempFilePath = saveTempFilePath;
                        canvasResult.errMsg = "CanvastoTempFilePath: success";
                        jsFunction.call(canvasResult);
                    }
                    Log.e("V8", "toTempFilePathAsync--Complete: ");
                    JsFunction jsFunction5 = jsFunction3;
                    if (jsFunction5 == null) {
                        return;
                    }
                    return;
                }
                throw new Exception();
            }
        });
        return null;
    }

    public static String toTempFilePathInternal(long j, long j2, int i2, int i3, int i4, int i5, int i6, int i7, String str, float f2, JsFunction jsFunction, JsFunction jsFunction2, JsFunction jsFunction3, boolean z) {
        String validFileType = getValidFileType(str);
        float f3 = (f2 <= 0.0f || f2 > 1.0f) ? 0.92f : f2;
        if (z) {
            return toTempFilePathSync(j, j2, i2, i3, i4, i5, i6, i7, validFileType, f3);
        }
        return toTempFilePathAsync(j, j2, i2, i3, i4, i5, i6, i7, validFileType, f3, jsFunction, jsFunction2, jsFunction3);
    }

    public static String toTempFilePathSync(long j, long j2, int i2, int i3, int i4, int i5, int i6, int i7, String str, float f2) {
        Log.e("V8", "toTempFilePathSync-- " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i6 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i7 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2);
        try {
            if (i2 == -1 || i3 == -1) {
                throw new Exception("The x or y must be legal");
            }
            if (i4 != -1 && i5 != -1 && i6 != -1 && i7 != -1) {
                try {
                    return saveTempFilePath(j2, compressCanvas(readCanvas(j, i2, i3, i4, i5), i6, i7, str, f2), str);
                } catch (Throwable th) {
                    th = th;
                    Log.e("V8", th.getMessage(), th);
                    V8Engine v8Engine = V8Engine.getInstance(j2);
                    if (v8Engine != null) {
                        v8Engine.throwJSException(JSExceptionType.Error, th.getMessage());
                        return null;
                    }
                    return null;
                }
            }
            throw new Exception("The width or height must be legal");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String basePath() {
        return this.mBasePath;
    }

    public void detach() {
        this.mNativePtr = 0L;
    }

    public long getEnginePtr() {
        return this.mEnginePtr;
    }

    public int getImageId() {
        return this.mImageId;
    }

    public int height() {
        return this.mHeight;
    }

    public void invokeCallback(JSEvent jSEvent, int i2) {
        if (jSEvent == null || jSEvent.type == null) {
            return;
        }
        V8Engine v8Engine = V8Engine.getInstance(this.mEnginePtr);
        if (v8Engine != null && v8Engine.isPaused()) {
            postImageJSCallback(v8Engine, jSEvent, i2);
        } else if (this.mNativePtr == 0) {
        } else {
            if (jSEvent.type.equals("load")) {
                nativeOnLoadSuccess(this.mNativePtr, i2);
            } else {
                nativeOnLoadFailed(this.mNativePtr, this.mErrorMsg, i2);
            }
        }
    }

    public native boolean nativeLoadAsset(long j, Bitmap bitmap);

    public long nativePtr() {
        return this.mNativePtr;
    }

    public String oldSrc() {
        return this.mBeforeSrc;
    }

    public void onLoadFailed(int i2, String str) {
        V8Engine v8Engine;
        this.mErrorMsg = str;
        JSEvent jSEvent = new JSEvent("error", this, null);
        try {
            v8Engine = V8Engine.getInstance(this.mEnginePtr);
        } catch (Exception e2) {
            Log.e("V8", e2.getMessage(), e2);
        }
        if (v8Engine != null) {
            postImageJSCallback(v8Engine, jSEvent, i2);
            Log.d(TAG, "onLoadFailed: " + str);
            return;
        }
        throw new Exception("can't get the v8engine instance.");
    }

    public void onLoadSuccess(int i2) {
        V8Engine v8Engine;
        JSEvent jSEvent = new JSEvent("load", this, null);
        try {
            v8Engine = V8Engine.getInstance(this.mEnginePtr);
        } catch (Exception e2) {
            Log.e("V8", e2.getMessage(), e2);
        }
        if (v8Engine != null) {
            postImageJSCallback(v8Engine, jSEvent, i2);
            Log.d(TAG, "onLoadSuccess: " + this.mSrc);
            return;
        }
        throw new Exception("can't get the v8engine instance.");
    }

    public boolean setBitmapData(Bitmap bitmap) {
        long j = this.mNativePtr;
        return j != 0 && nativeLoadAsset(j, bitmap);
    }

    public void setImageId(int i2) {
        this.mImageId = i2;
    }

    public void setSrc(String str) {
        if (str == null) {
            return;
        }
        this.mBeforeSrc = this.mSrc;
        this.mSrc = str.trim();
        WebGLImageLoader.loadImage(this);
    }

    public String src() {
        return this.mSrc;
    }

    public int width() {
        return this.mWidth;
    }

    /* loaded from: classes2.dex */
    public static class CanvasResult {
        @V8JavascriptField
        public String errMsg;
        @V8JavascriptField
        public String tempFilePath;

        public CanvasResult(String str, String str2) {
            this.tempFilePath = null;
            this.errMsg = null;
            this.tempFilePath = str;
            this.errMsg = str2;
        }

        public CanvasResult() {
            this.tempFilePath = null;
            this.errMsg = null;
        }
    }
}
