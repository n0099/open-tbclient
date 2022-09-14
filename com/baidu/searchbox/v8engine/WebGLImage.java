package com.baidu.searchbox.v8engine;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
@NotProguard
/* loaded from: classes2.dex */
public class WebGLImage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "WebGLImage";
    public static HandlerThread sBackgroundThread;
    public static Handler sHandler;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBasePath;
    public String mBeforeSrc;
    public long mEnginePtr;
    public String mErrorMsg;
    public int mHeight;
    public int mImageId;
    public long mNativePtr;
    public String mSrc;
    public int mWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(554033768, "Lcom/baidu/searchbox/v8engine/WebGLImage;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(554033768, "Lcom/baidu/searchbox/v8engine/WebGLImage;");
        }
    }

    public WebGLImage(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSrc = "";
        this.mWidth = 0;
        this.mHeight = 0;
        this.mNativePtr = 0L;
        this.mEnginePtr = 0L;
        this.mBasePath = "";
        this.mNativePtr = j;
        this.mEnginePtr = j2;
        this.mBasePath = str;
    }

    public static byte[] compressCanvas(Bitmap bitmap, int i, int i2, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), str, Float.valueOf(f)})) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Bitmap.CompressFormat compressFormat = toCompressFormat(str);
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
            bitmap.compress(compressFormat, (int) (f * 100.0f), byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static WebGLImage create(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) ? new WebGLImage(j, j2, str) : (WebGLImage) invokeCommon.objValue;
    }

    public static String getValidFileType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String str2 = "jpg";
            if (!"jpg".equalsIgnoreCase(str) && !"image/jpg".equalsIgnoreCase(str)) {
                str2 = "jpeg";
                if (!"jpeg".equalsIgnoreCase(str) && !"image/jpeg".equalsIgnoreCase(str)) {
                    return "png";
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    private native void nativeOnLoadFailed(long j, String str, int i);

    private native void nativeOnLoadSuccess(long j, int i);

    public static native boolean nativeReadPixels(long j, Bitmap bitmap, int i, int i2, int i3, int i4);

    private void postImageJSCallback(V8Engine v8Engine, JSEvent jSEvent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65544, this, v8Engine, jSEvent, i) == null) {
            v8Engine.postSuspendableTaskOnJSThread(new Runnable(this, jSEvent, i) { // from class: com.baidu.searchbox.v8engine.WebGLImage.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebGLImage this$0;
                public final /* synthetic */ JSEvent val$event;
                public final /* synthetic */ int val$imageId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSEvent, Integer.valueOf(i)};
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
                    this.val$event = jSEvent;
                    this.val$imageId = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.invokeCallback(this.val$event, this.val$imageId);
                    }
                }
            });
        }
    }

    public static Bitmap readCanvas(long j, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i != -1 && i2 != -1) {
                try {
                    bitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                    try {
                        if (nativeReadPixels(j, bitmap, i, i2, i3, i4)) {
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
        return (Bitmap) invokeCommon.objValue;
    }

    public static void recycleBitmap(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            WebGLImageLoader.recycleBitmap(str);
        }
    }

    public static void saveBitmapData(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, bArr, str) == null) {
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
    }

    public static String saveTempFilePath(long j, byte[] bArr, String str) {
        InterceptResult invokeCommon;
        File createTempFile;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), bArr, str})) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                File file = new File(V8Engine.getInstance(j).getBdFileRealPath(), "tmp");
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
                String str2 = "bdfile://tmp/" + createTempFile.getName();
                fileOutputStream.close();
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
        return (String) invokeCommon.objValue;
    }

    public static Bitmap.CompressFormat toCompressFormat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (!"jpg".equalsIgnoreCase(str) && !"jpeg".equalsIgnoreCase(str)) {
                return Bitmap.CompressFormat.PNG;
            }
            return Bitmap.CompressFormat.JPEG;
        }
        return (Bitmap.CompressFormat) invokeL.objValue;
    }

    public static String toDataURL(long j, int i, int i2, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Float.valueOf(f)})) == null) {
            try {
                Bitmap readCanvas = readCanvas(j, 0, 0, i, i2);
                if (f <= 0.0f || f > 1.0f) {
                    f = 0.92f;
                }
                String validFileType = getValidFileType(str);
                String str2 = FileUtils.IMAGE_FILE_START + validFileType;
                byte[] compressCanvas = compressCanvas(readCanvas, i, i2, validFileType, f);
                return WebGLImageLoader.DATA_URL + str2 + ";base64," + Base64.encodeToString(compressCanvas, 2);
            } catch (Throwable th) {
                Log.e("V8", th.getMessage(), th);
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String toTempFilePathAsync(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, String str, float f, JsFunction jsFunction, JsFunction jsFunction2, JsFunction jsFunction3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, Float.valueOf(f), jsFunction, jsFunction2, jsFunction3})) == null) {
            Log.e("V8", "toTempFilePathAsync-- " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i6 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + f + StringUtil.ARRAY_ELEMENT_SEPARATOR + jsFunction + StringUtil.ARRAY_ELEMENT_SEPARATOR + jsFunction2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + jsFunction3);
            if (sBackgroundThread == null) {
                HandlerThread handlerThread = new HandlerThread(NotificationCompat.WearableExtender.KEY_BACKGROUND);
                sBackgroundThread = handlerThread;
                handlerThread.start();
                sHandler = new Handler(sBackgroundThread.getLooper());
            }
            sHandler.post(new Runnable((i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0 || i5 <= 0 || i6 <= 0) ? null : readCanvas(j, i, i2, i3, i4), i5, i6, str, f, j2, jsFunction, jsFunction2, jsFunction3) { // from class: com.baidu.searchbox.v8engine.WebGLImage.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap val$bitmap;
                public final /* synthetic */ JsFunction val$complete;
                public final /* synthetic */ int val$destHeight;
                public final /* synthetic */ int val$destWidth;
                public final /* synthetic */ JsFunction val$fail;
                public final /* synthetic */ String val$fileType;
                public final /* synthetic */ long val$nativeEnginePtr;
                public final /* synthetic */ float val$quality;
                public final /* synthetic */ JsFunction val$success;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, Integer.valueOf(i5), Integer.valueOf(i6), str, Float.valueOf(f), Long.valueOf(j2), jsFunction, jsFunction2, jsFunction3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i7 = newInitContext.flag;
                        if ((i7 & 1) != 0) {
                            int i8 = i7 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$bitmap = r6;
                    this.val$destWidth = i5;
                    this.val$destHeight = i6;
                    this.val$fileType = str;
                    this.val$quality = f;
                    this.val$nativeEnginePtr = j2;
                    this.val$success = jsFunction;
                    this.val$fail = jsFunction2;
                    this.val$complete = jsFunction3;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, IF] complete} */
                @Override // java.lang.Runnable
                public void run() {
                    JsFunction jsFunction4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CanvasResult canvasResult = new CanvasResult();
                        try {
                        } catch (Throwable th) {
                            try {
                                Log.e("V8", "toTempFilePathAsync--FAILED-" + th.getMessage(), th);
                                if (this.val$fail != null) {
                                    canvasResult.tempFilePath = null;
                                    canvasResult.errMsg = "CanvastoTempFilePath failed";
                                    this.val$fail.call(canvasResult);
                                }
                                if (jsFunction4 == null) {
                                    return;
                                }
                            } finally {
                                Log.e("V8", "toTempFilePathAsync--Complete: ");
                                jsFunction4 = this.val$complete;
                                if (jsFunction4 != null) {
                                    jsFunction4.call(canvasResult);
                                }
                            }
                        }
                        if (this.val$bitmap != null) {
                            String saveTempFilePath = WebGLImage.saveTempFilePath(this.val$nativeEnginePtr, WebGLImage.compressCanvas(this.val$bitmap, this.val$destWidth, this.val$destHeight, this.val$fileType, this.val$quality), this.val$fileType);
                            Log.e("V8", "toTempFilePathAsync--Success: " + saveTempFilePath);
                            if (this.val$success != null) {
                                canvasResult.tempFilePath = saveTempFilePath;
                                canvasResult.errMsg = "CanvastoTempFilePath: success";
                                this.val$success.call(canvasResult);
                            }
                            Log.e("V8", "toTempFilePathAsync--Complete: ");
                            JsFunction jsFunction5 = this.val$complete;
                            if (jsFunction5 == null) {
                                return;
                            }
                            return;
                        }
                        throw new Exception();
                    }
                }
            });
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static String toTempFilePathInternal(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, String str, float f, JsFunction jsFunction, JsFunction jsFunction2, JsFunction jsFunction3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, Float.valueOf(f), jsFunction, jsFunction2, jsFunction3, Boolean.valueOf(z)})) == null) {
            String validFileType = getValidFileType(str);
            float f2 = (f <= 0.0f || f > 1.0f) ? 0.92f : f;
            if (z) {
                return toTempFilePathSync(j, j2, i, i2, i3, i4, i5, i6, validFileType, f2);
            }
            return toTempFilePathAsync(j, j2, i, i2, i3, i4, i5, i6, validFileType, f2, jsFunction, jsFunction2, jsFunction3);
        }
        return (String) invokeCommon.objValue;
    }

    public static String toTempFilePathSync(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, Float.valueOf(f)})) != null) {
            return (String) invokeCommon.objValue;
        }
        Log.e("V8", "toTempFilePathSync-- " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i6 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + f);
        try {
            if (i == -1 || i2 == -1) {
                throw new Exception("The x or y must be legal");
            }
            if (i3 != -1 && i4 != -1 && i5 != -1 && i6 != -1) {
                try {
                    return saveTempFilePath(j2, compressCanvas(readCanvas(j, i, i2, i3, i4), i5, i6, str, f), str);
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBasePath : (String) invokeV.objValue;
    }

    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mNativePtr = 0L;
        }
    }

    public long getEnginePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEnginePtr : invokeV.longValue;
    }

    public int getImageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mImageId : invokeV.intValue;
    }

    public int height() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHeight : invokeV.intValue;
    }

    public void invokeCallback(JSEvent jSEvent, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, jSEvent, i) == null) || jSEvent == null || jSEvent.type == null) {
            return;
        }
        V8Engine v8Engine = V8Engine.getInstance(this.mEnginePtr);
        if (v8Engine != null && v8Engine.isPaused()) {
            postImageJSCallback(v8Engine, jSEvent, i);
        } else if (this.mNativePtr == 0) {
        } else {
            if (jSEvent.type.equals("load")) {
                nativeOnLoadSuccess(this.mNativePtr, i);
            } else {
                nativeOnLoadFailed(this.mNativePtr, this.mErrorMsg, i);
            }
        }
    }

    public native boolean nativeLoadAsset(long j, Bitmap bitmap);

    public long nativePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mNativePtr : invokeV.longValue;
    }

    public String oldSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mBeforeSrc : (String) invokeV.objValue;
    }

    public void onLoadFailed(int i, String str) {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
            this.mErrorMsg = str;
            JSEvent jSEvent = new JSEvent("error", this, null);
            try {
                v8Engine = V8Engine.getInstance(this.mEnginePtr);
            } catch (Exception e) {
                Log.e("V8", e.getMessage(), e);
            }
            if (v8Engine != null) {
                postImageJSCallback(v8Engine, jSEvent, i);
                Log.d(TAG, "onLoadFailed: " + str);
                return;
            }
            throw new Exception("can't get the v8engine instance.");
        }
    }

    public void onLoadSuccess(int i) {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            JSEvent jSEvent = new JSEvent("load", this, null);
            try {
                v8Engine = V8Engine.getInstance(this.mEnginePtr);
            } catch (Exception e) {
                Log.e("V8", e.getMessage(), e);
            }
            if (v8Engine != null) {
                postImageJSCallback(v8Engine, jSEvent, i);
                Log.d(TAG, "onLoadSuccess: " + this.mSrc);
                return;
            }
            throw new Exception("can't get the v8engine instance.");
        }
    }

    public boolean setBitmapData(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bitmap)) == null) {
            long j = this.mNativePtr;
            return j != 0 && nativeLoadAsset(j, bitmap);
        }
        return invokeL.booleanValue;
    }

    public void setImageId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mImageId = i;
        }
    }

    public void setSrc(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null) {
            return;
        }
        this.mBeforeSrc = this.mSrc;
        this.mSrc = str.trim();
        WebGLImageLoader.loadImage(this);
    }

    public String src() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mSrc : (String) invokeV.objValue;
    }

    public int width() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mWidth : invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public static class CanvasResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @V8JavascriptField
        public String errMsg;
        @V8JavascriptField
        public String tempFilePath;

        public CanvasResult(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.tempFilePath = null;
            this.errMsg = null;
            this.tempFilePath = str;
            this.errMsg = str2;
        }

        public CanvasResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tempFilePath = null;
            this.errMsg = null;
        }
    }
}
