package com.baidu.ar.arplay.core.renderer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.c.b;
import com.baidu.ar.arplay.core.engine.d;
import com.baidu.ar.arplay.core.engine.e;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.AssetUriLoader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes.dex */
public class ARPRenderer implements d, IARPRenderer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FRAME_COUNT = 100;
    public static final String TAG = "ARPRenderer";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasSetup;
    public boolean hasSetupPipeline;
    public int mCutSnapHeight;
    public int mCutSnapStartX;
    public int mCutSnapStartY;
    public int mCutSnapWidth;
    public String mDefaultLuaPath;
    public final Queue<Runnable> mDrawQueue;
    public boolean mFrontCamera;
    public int mInputTexHeight;
    public int mInputTexWidth;
    public boolean mIsCutSnapShot;
    public OnNeedCacheFrameListener mIsNeedCacheFrameListener;
    public long mLastAlgoPTS;
    public long mLastFramePTS;
    public boolean mNeedSyncRender;
    public OnRenderFinishedListener mOnRenderFinishedListener;
    public OnRenderStartedListener mOnRenderStartedListener;
    public Object[] mPipelineLock;
    public HashMap<String, List<PixelReadListener>> mPixelListenerHash;
    public int mRotation;
    public Object[] mRunnableLock;
    public TakePictureCallback mTakePictureCallback;
    public int mTotalFrameCount;
    public long mTotalFrameTimeInMS;
    public SoftReference<Context> softContext;
    public float[] texMatrix;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1550885583, "Lcom/baidu/ar/arplay/core/renderer/ARPRenderer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1550885583, "Lcom/baidu/ar/arplay/core/renderer/ARPRenderer;");
        }
    }

    public ARPRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hasSetup = false;
        this.hasSetupPipeline = false;
        this.mLastFramePTS = -1L;
        this.mTotalFrameTimeInMS = 0L;
        this.mTotalFrameCount = 0;
        this.mInputTexWidth = 720;
        this.mInputTexHeight = 1280;
        this.softContext = null;
        this.mTakePictureCallback = null;
        this.mRotation = 0;
        this.mIsCutSnapShot = false;
        this.mNeedSyncRender = false;
        this.mCutSnapStartX = 0;
        this.mCutSnapStartY = 0;
        this.mCutSnapWidth = 0;
        this.mCutSnapHeight = 0;
        this.mLastAlgoPTS = -1L;
        this.mRunnableLock = new Object[0];
        this.mPipelineLock = new Object[0];
        float[] fArr = new float[16];
        this.texMatrix = fArr;
        Matrix.setIdentityM(fArr, 0);
        this.hasSetup = false;
        this.mDrawQueue = new LinkedList();
        this.mPixelListenerHash = new HashMap<>();
    }

    public static void copyNativeBytebuffer(ByteBuffer byteBuffer, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65538, null, byteBuffer, bArr, i, i2) == null) {
            nativeCopyBytebuffer(byteBuffer, bArr, i, i2);
        }
    }

    private void destroyGLContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Log.d(TAG, "calling nativeDestroyInputSource");
            nativeDestroyInputSource();
            Log.d(TAG, "calling nativeRemoveOutputAllTarget");
            nativeRemoveOutputAllTarget();
            if (this.hasSetupPipeline) {
                Log.d(TAG, "calling nativeReleasePipeline");
                nativeReleasePipeline();
            }
            Log.d(TAG, "calling nativeContextDestroy");
            nativeContextDestroy();
            Log.d(TAG, "end of destroyGLContext");
            releaseEffectFilterRegisterHelper();
        }
    }

    private int getInputHeight(PixelReadParams pixelReadParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, pixelReadParams)) == null) {
            int i = this.mInputTexHeight;
            if (pixelReadParams.getPreFilterID().equals("") || pixelReadParams.getPreFilterID().equals("camera")) {
                if (!needRotate(pixelReadParams.getPixelRotate().getValue())) {
                    return i;
                }
            } else if (!needSwapResolution()) {
                return i;
            }
            return this.mInputTexWidth;
        }
        return invokeL.intValue;
    }

    private int getInputWidth(PixelReadParams pixelReadParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, pixelReadParams)) == null) {
            int i = this.mInputTexWidth;
            if (pixelReadParams.getPreFilterID().equals("") || pixelReadParams.getPreFilterID().equals("camera")) {
                if (!needRotate(pixelReadParams.getPixelRotate().getValue())) {
                    return i;
                }
            } else if (!needSwapResolution()) {
                return i;
            }
            return this.mInputTexHeight;
        }
        return invokeL.intValue;
    }

    private String getPixelReadParamHash(PixelReadParams pixelReadParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, pixelReadParams)) == null) {
            if (pixelReadParams == null) {
                return null;
            }
            int outputWidth = pixelReadParams.getOutputWidth();
            int outputHeight = pixelReadParams.getOutputHeight();
            PixelType pixelType = pixelReadParams.getPixelType();
            String preFilterID = pixelReadParams.getPreFilterID();
            preFilterID = (preFilterID.equals("") || preFilterID.equals("camera")) ? "camera" : "camera";
            int value = pixelReadParams.getFrameType().getValue();
            return Integer.toString(outputWidth) + Integer.toString(outputHeight) + Integer.toString(pixelType.getValue()) + preFilterID + value;
        }
        return (String) invokeL.objValue;
    }

    private void multiplyPointWithMatrix(PointF pointF, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, pointF, fArr) == null) || fArr == null || fArr.length < 6) {
            return;
        }
        float f = fArr[0];
        float f2 = pointF.x;
        float f3 = fArr[4];
        float f4 = pointF.y;
        pointF.set((f * f2) + (f3 * f4), (fArr[1] * f2) + (fArr[5] * f4));
    }

    private native String nativeAddOutputSurface(Surface surface, int i, int i2, int i3, int i4);

    private native String nativeAddOutputTexture(int i, int i2, int i3, int i4, int i5, int i6);

    private native void nativeAdjustFilterWithAssetTextureParam(String str, String str2, Bitmap bitmap);

    private native String nativeAdjustFilterWithCasePathParam(String str);

    private native void nativeAdjustFilterWithFloatArrayParam(String str, String str2, float[] fArr);

    private native void nativeAdjustFilterWithFloatParam(String str, String str2, float f);

    private native void nativeAdjustFilterWithIntParam(String str, String str2, int i);

    private native String nativeAdjustFilterWithJsonPathParam(String str);

    private native void nativeAdjustFilterWithStringParam(String str, String str2, String str3);

    private native void nativeBindTargetSurface(Surface surface);

    private native void nativeClearCaptureData();

    private native void nativeConnectCameraWithTarget();

    private native void nativeContextDestroy();

    private native boolean nativeContextInit(long j, String str);

    private native void nativeContextPurge();

    public static native void nativeCopyBytebuffer(ByteBuffer byteBuffer, byte[] bArr, int i, int i2);

    private native void nativeCreateInputSource(int i, int i2);

    private native void nativeCreatePixelReaderByPreFilterID(int i, int i2, int i3, int i4, float f, float f2, String str, int i5);

    private native void nativeCreateSyncInputSource(int i, int i2);

    private native void nativeDestroyAllPixelReader();

    private native void nativeDestroyInputSource();

    private native void nativeDestroyPixelReaderByPreFilterID(int i, int i2, int i3, int i4, float f, float f2, String str, int i5);

    private native void nativeDisableCaseLutTexture();

    private native void nativeDisableFilterByAuthCode(int i);

    private native long nativeFetchTexture(int i, int i2, int i3);

    private native long nativeGetEGLContext();

    private native int nativeGetTextureId(long j);

    private native void nativeLoadDefaultFilterLuaPath(String str);

    private native void nativePauseRender();

    private native void nativeReleaseEffectFilterRegisterHelper();

    private native void nativeReleasePipeline();

    private native void nativeRemoveOutputAllTarget();

    private native void nativeRemoveOutputTargetByAddr(String str);

    private native void nativeResumeRender();

    private native void nativeReturnTexture(long j);

    private native void nativeRunLuaScriptStr(String str);

    private native void nativeSetAlgoPts(long j);

    private native void nativeSetAuthPic(Bitmap bitmap, float[] fArr);

    private native void nativeSetCaptureData(int i);

    private native void nativeSetInputSourceRotation(int i);

    private native void nativeSetInputTexture(int i, int i2, int i3, int i4);

    private native void nativeSetIsDumpAlgoPixel(boolean z);

    private native void nativeSetIsRender(boolean z);

    private native void nativeSetPixelReaderRotation(int i);

    private native void nativeSetPixelReaderRotationByPixelInfo(int i, int i2, int i3, int i4, float f, float f2, String str, int i5, int i6);

    private native void nativeSetSnapShotPic(Bitmap bitmap, int i, int i2);

    private native void nativeSetSourceSyncProperty(boolean z);

    private native void nativeSwapBuffer();

    private native void nativeUpdateInputTexture(long j);

    private native void nativeUpdateOutputSurfaceRotation(String str, int i);

    private native void nativeUpdateTextureMatrix(float[] fArr);

    private native void nativeUploadPixelToTextureFromPath(long j, String str);

    public static boolean needRotate(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65596, null, i)) == null) ? i == PixelRotation.RotateLeft.getValue() || i == PixelRotation.RotateRight.getValue() || i == PixelRotation.RotateRightFlipVertical.getValue() || i == PixelRotation.RotateRightFlipHorizontal.getValue() : invokeI.booleanValue;
    }

    private boolean needSwapResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, this)) == null) {
            PointF pointF = new PointF(1.0f, 0.0f);
            PointF pointF2 = new PointF(0.0f, 1.0f);
            multiplyPointWithMatrix(pointF, this.texMatrix);
            multiplyPointWithMatrix(pointF2, this.texMatrix);
            return ((double) Math.abs(pointF.x)) < 1.0E-6d && ((double) Math.abs(Math.abs(pointF.y) - 1.0f)) < 1.0E-6d && ((double) Math.abs(Math.abs(pointF2.x) - 1.0f)) < 1.0E-6d && ((double) Math.abs(pointF2.y)) < 1.0E-6d;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"NewApi"})
    private boolean prepareGLContext(EGLContext eGLContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, this, eGLContext)) == null) {
            Log.d(TAG, "calling nativeContextInit");
            boolean nativeContextInit = nativeContextInit(eGLContext != null ? Build.VERSION.SDK_INT > 20 ? eGLContext.getNativeHandle() : eGLContext.getHandle() : 0L, "5.1.0");
            Log.d(TAG, "end of prepareGLContext");
            return nativeContextInit;
        }
        return invokeL.booleanValue;
    }

    private void runAllDrawQueue() {
        Queue<Runnable> queue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65599, this) == null) || (queue = this.mDrawQueue) == null) {
            return;
        }
        synchronized (queue) {
            while (!this.mDrawQueue.isEmpty()) {
                this.mDrawQueue.poll().run();
            }
        }
    }

    private void snapShot(TakePictureCallback takePictureCallback, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65600, this, takePictureCallback, i, i2, i3) == null) {
            this.mTakePictureCallback = takePictureCallback;
            this.mRotation = i3;
            nativeSetSnapShotPic(SnapShot.getCacheBitmap(i, i2), i, i2);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public String addOutputSurface(Surface surface, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, surface, i, i2)) == null) ? !this.hasSetup ? "" : addOutputSurface(surface, i, i2, PixelRotation.NoRotation, OutputFillMode.KeepRatioCrop) : (String) invokeLII.objValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public String addOutputSurface(Surface surface, int i, int i2, PixelRotation pixelRotation) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{surface, Integer.valueOf(i), Integer.valueOf(i2), pixelRotation})) == null) ? !this.hasSetup ? "" : addOutputSurface(surface, i, i2, pixelRotation, OutputFillMode.KeepRatioCrop) : (String) invokeCommon.objValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public String addOutputSurface(Surface surface, int i, int i2, PixelRotation pixelRotation, OutputFillMode outputFillMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{surface, Integer.valueOf(i), Integer.valueOf(i2), pixelRotation, outputFillMode})) == null) {
            if (this.hasSetup) {
                Log.d(TAG, String.format("addOutputSurface[%s | %dx%d %s %s]", surface, Integer.valueOf(i), Integer.valueOf(i2), pixelRotation, outputFillMode));
                return nativeAddOutputSurface(surface, i, i2, pixelRotation.getValue(), outputFillMode.getValue());
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public String addOutputTarget(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i, i2, i3, i4)) == null) ? addOutputTarget(i, i2, i3, i4, PixelRotation.NoRotation) : (String) invokeIIII.objValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public String addOutputTarget(int i, int i2, int i3, int i4, PixelRotation pixelRotation) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), pixelRotation})) == null) ? addOutputTarget(i, i2, i3, i4, pixelRotation, OutputFillMode.KeepRatioCrop) : (String) invokeCommon.objValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public String addOutputTarget(int i, int i2, int i3, int i4, PixelRotation pixelRotation, OutputFillMode outputFillMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), pixelRotation, outputFillMode})) == null) {
            Log.d(TAG, String.format("test addOutputTarget: %d [%dx%d] %s %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), pixelRotation, outputFillMode));
            return nativeAddOutputTexture(i, i2, i3, i4, pixelRotation.getValue(), outputFillMode.getValue());
        }
        return (String) invokeCommon.objValue;
    }

    public String adjustFilterWithCasePathParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? nativeAdjustFilterWithCasePathParam(str) : (String) invokeL.objValue;
    }

    public void adjustFilterWithFloatArrayParam(String str, String str2, float[] fArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, fArr, Long.valueOf(j)}) == null) {
            nativeAdjustFilterWithFloatArrayParam(str, str2, fArr);
        }
    }

    public void adjustFilterWithFloatParam(String str, String str2, float f, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Float.valueOf(f), Long.valueOf(j)}) == null) {
            nativeAdjustFilterWithFloatParam(str, str2, f);
        }
    }

    public void adjustFilterWithIntParam(String str, String str2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            nativeAdjustFilterWithIntParam(str, str2, i);
        }
    }

    public String adjustFilterWithJsonPathParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? nativeAdjustFilterWithJsonPathParam(str) : (String) invokeL.objValue;
    }

    public void adjustFilterWithStringParam(String str, String str2, String str3, long j) {
        SoftReference<Context> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, Long.valueOf(j)}) == null) {
            if (!str3.contains(AssetUriLoader.ASSET_PATH_SEGMENT) || (softReference = this.softContext) == null || softReference.get() == null || this.softContext.get().getAssets() == null) {
                nativeAdjustFilterWithStringParam(str, str2, str3);
                return;
            }
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(this.softContext.get().getAssets().open(str3.substring(str3.lastIndexOf(AssetUriLoader.ASSET_PATH_SEGMENT) + 13 + 1)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bitmap != null) {
                String str4 = "texture_width";
                String str5 = "texture_height";
                String str6 = "texture_byte_array";
                if (str2.contains("/")) {
                    String substring = str2.substring(0, str2.lastIndexOf("/") + 1);
                    str4 = substring + "texture_width";
                    str5 = substring + "texture_height";
                    str6 = substring + "texture_byte_array";
                }
                nativeAdjustFilterWithFloatParam(str, str4, bitmap.getWidth());
                nativeAdjustFilterWithFloatParam(str, str5, bitmap.getHeight());
                nativeAdjustFilterWithAssetTextureParam(str, str6, bitmap);
                bitmap.recycle();
            }
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void bindTargetSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surface) == null) {
            nativeBindTargetSurface(surface);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void cancelAysncRenderTask(Runnable runnable) {
        Queue<Runnable> queue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, runnable) == null) || (queue = this.mDrawQueue) == null || runnable == null) {
            return;
        }
        synchronized (queue) {
            if (!this.mDrawQueue.isEmpty()) {
                this.mDrawQueue.remove(runnable);
            }
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void clearAllAsyncRenderTask() {
        Queue<Runnable> queue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (queue = this.mDrawQueue) == null) {
            return;
        }
        synchronized (queue) {
            if (!this.mDrawQueue.isEmpty()) {
                this.mDrawQueue.clear();
            }
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void clearCaptureData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            nativeClearCaptureData();
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void connectCameraWithTarget() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            nativeConnectCameraWithTarget();
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void createInputSource(PixelRotation pixelRotation, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pixelRotation, eVar) == null) {
            String str = TAG;
            Log.d(str, "calling nativeCreateInputSource: " + eVar);
            nativeCreateInputSource(pixelRotation.getValue(), eVar.getValue());
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void createPixelReaderByPreFilterID(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, pixelReadParams, pixelReadListener) == null) || pixelReadParams == null || pixelReadListener == null) {
            return;
        }
        int outputWidth = pixelReadParams.getOutputWidth();
        int outputHeight = pixelReadParams.getOutputHeight();
        PixelRotation pixelRotate = pixelReadParams.getPixelRotate();
        PixelType pixelType = pixelReadParams.getPixelType();
        int value = pixelReadParams.getFrameType().getValue();
        float inputWidth = outputWidth / getInputWidth(pixelReadParams);
        float inputHeight = outputHeight / getInputHeight(pixelReadParams);
        String pixelReadParamHash = getPixelReadParamHash(pixelReadParams);
        synchronized (this.mPipelineLock) {
            if (this.mPixelListenerHash.containsKey(pixelReadParamHash)) {
                this.mPixelListenerHash.get(pixelReadParamHash).add(pixelReadListener);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(pixelReadListener);
            this.mPixelListenerHash.put(pixelReadParamHash, arrayList);
            nativeCreatePixelReaderByPreFilterID(outputWidth, outputHeight, pixelRotate.getValue(), pixelType.getValue(), inputWidth, inputHeight, pixelReadParams.getPreFilterID(), value);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void createSyncInputSource(PixelRotation pixelRotation, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, pixelRotation, eVar) == null) {
            String str = TAG;
            Log.d(str, "calling createSyncInputSource: " + eVar);
            nativeCreateSyncInputSource(pixelRotation.getValue(), eVar.getValue());
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public long createTexture(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048596, this, i, i2, i3)) == null) ? nativeFetchTexture(i, i2, i3) : invokeIII.longValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.hasSetup) {
            ARPMessage.getInstance().release();
            this.mDrawQueue.clear();
            Log.d(TAG, "ARPFilter destroy: ");
            destroyGLContext();
            this.mOnRenderStartedListener = null;
            this.mOnRenderFinishedListener = null;
            this.mIsNeedCacheFrameListener = null;
            SnapShot.destroyCache();
            this.hasSetup = false;
            this.mNeedSyncRender = false;
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void destroyAllPixelReader() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.mPixelListenerHash == null) {
            return;
        }
        synchronized (this.mPipelineLock) {
            this.mPixelListenerHash.clear();
        }
        nativeDestroyAllPixelReader();
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void destroyPixelReaderByPreFilterID(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, pixelReadParams, pixelReadListener) == null) || pixelReadParams == null || pixelReadListener == null) {
            return;
        }
        String pixelReadParamHash = getPixelReadParamHash(pixelReadParams);
        synchronized (this.mPipelineLock) {
            if (this.mPixelListenerHash.containsKey(pixelReadParamHash)) {
                List<PixelReadListener> list = this.mPixelListenerHash.get(pixelReadParamHash);
                if (list.size() > 1) {
                    list.remove(pixelReadListener);
                    return;
                }
                this.mPixelListenerHash.remove(pixelReadParamHash);
                int outputWidth = pixelReadParams.getOutputWidth();
                int outputHeight = pixelReadParams.getOutputHeight();
                nativeDestroyPixelReaderByPreFilterID(outputWidth, outputHeight, pixelReadParams.getPixelRotate().getValue(), pixelReadParams.getPixelType().getValue(), outputWidth / getInputWidth(pixelReadParams), outputHeight / getInputHeight(pixelReadParams), pixelReadParams.getPreFilterID(), pixelReadParams.getFrameType().getValue());
            }
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void destroyTexture(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            nativeReturnTexture(j);
        }
    }

    public void disableCaseLutTexture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            nativeDisableCaseLutTexture();
        }
    }

    public void disableFilterByAuthCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            nativeDisableFilterByAuthCode(i);
        }
    }

    public int getCameraPreviewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mInputTexHeight : invokeV.intValue;
    }

    public int getCameraPreviewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mInputTexWidth : invokeV.intValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public String getDefaultLuaPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mDefaultLuaPath : (String) invokeV.objValue;
    }

    public long getNativeEGLContextHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? nativeGetEGLContext() : invokeV.longValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void getSnapShot(TakePictureCallback takePictureCallback, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048607, this, takePictureCallback, i, i2, i3) == null) {
            this.mIsCutSnapShot = false;
            snapShot(takePictureCallback, i, i2, i3);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void getSnapShot(TakePictureCallback takePictureCallback, int i, int i2, int i3, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{takePictureCallback, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), rect}) == null) {
            this.mIsCutSnapShot = true;
            int i4 = rect.left;
            this.mCutSnapStartX = i4;
            int i5 = rect.top;
            this.mCutSnapStartY = i5;
            this.mCutSnapWidth = rect.right - i4;
            this.mCutSnapHeight = rect.bottom - i5;
            snapShot(takePictureCallback, i, i2, i3);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public int getTextureId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048609, this, j)) == null) ? nativeGetTextureId(j) : invokeJ.intValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public boolean isFrontCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mFrontCamera : invokeV.booleanValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void loadDefaultFilterLuaPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            ARPMessage.getInstance().setUp();
            synchronized (this.mPipelineLock) {
                nativeLoadDefaultFilterLuaPath(str);
                this.hasSetupPipeline = true;
                this.mDefaultLuaPath = str;
            }
        }
    }

    public native void nativeRunSyncOnIOContext(Runnable runnable);

    public native void nativeRunSyncOnRenderContext(Runnable runnable);

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void onFrameRenderFinished(long j) {
        OnRenderFinishedListener onRenderFinishedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048614, this, j) == null) || (onRenderFinishedListener = this.mOnRenderFinishedListener) == null) {
            return;
        }
        onRenderFinishedListener.onRenderFinished(j);
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void onFrameRenderStarted(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
            OnRenderStartedListener onRenderStartedListener = this.mOnRenderStartedListener;
            if (onRenderStartedListener != null) {
                onRenderStartedListener.onRenderStarted(j);
            }
            runAllDrawQueue();
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void onSnapShotFinished(Bitmap bitmap, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048616, this, bitmap, j) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), (android.graphics.Matrix) null, false);
            if (this.mIsCutSnapShot) {
                Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, this.mCutSnapStartX, this.mCutSnapStartY, this.mCutSnapWidth, this.mCutSnapHeight, (android.graphics.Matrix) null, false);
                if (createBitmap != null && !createBitmap.equals(createBitmap2) && !createBitmap.isRecycled()) {
                    createBitmap.recycle();
                }
                createBitmap = createBitmap2;
            }
            TakePictureCallback takePictureCallback = this.mTakePictureCallback;
            if (takePictureCallback != null) {
                takePictureCallback.onPictureTake(true, createBitmap, j);
            }
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            Log.d(TAG, "ARPFilter pause: ");
            nativePauseRender();
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public boolean pixelReadCallback(ByteBuffer byteBuffer, long j, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{byteBuffer, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            PixelReadParams pixelReadParams = new PixelReadParams(PixelType.valueOf(i4));
            pixelReadParams.setOutputWidth(i);
            pixelReadParams.setOutputHeight(i2);
            pixelReadParams.setPreFilterID(str);
            pixelReadParams.setFrameType(PixelReadParams.FrameType.values()[i6]);
            String pixelReadParamHash = getPixelReadParamHash(pixelReadParams);
            Boolean bool = Boolean.FALSE;
            OnNeedCacheFrameListener onNeedCacheFrameListener = this.mIsNeedCacheFrameListener;
            if (onNeedCacheFrameListener != null && this.mNeedSyncRender && j != this.mLastAlgoPTS) {
                bool = Boolean.valueOf(onNeedCacheFrameListener.isNeedCacheFrame(j));
            }
            this.mLastAlgoPTS = j;
            if (this.mPixelListenerHash.containsKey(pixelReadParamHash)) {
                FramePixels framePixels = new FramePixels(PixelType.values()[i4], byteBuffer, i, i2);
                framePixels.setCameraFrame(true);
                framePixels.setFrontCamera(this.mFrontCamera);
                framePixels.setOrientation(OrientationManager.getGlobalOrientation());
                framePixels.setTimestamp(j);
                framePixels.setPixelLength(i5);
                framePixels.setTextureID(i7);
                framePixels.setFrameType(PixelReadParams.FrameType.values()[i6]);
                List<PixelReadListener> list = this.mPixelListenerHash.get(pixelReadParamHash);
                if (list != null) {
                    for (PixelReadListener pixelReadListener : list) {
                        if (pixelReadListener != null) {
                            pixelReadListener.onPixelRead(framePixels);
                        }
                    }
                }
            }
            return bool.booleanValue();
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void purgeMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            nativeContextPurge();
        }
    }

    public void releaseEffectFilterRegisterHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            nativeReleaseEffectFilterRegisterHelper();
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void removeAllOutputTarget() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            nativeRemoveOutputAllTarget();
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void removeOutputTargetByAddr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            nativeRemoveOutputTargetByAddr(str);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public synchronized void render(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j) == null) {
            synchronized (this) {
                if (this.mTotalFrameCount > 0) {
                    this.mTotalFrameTimeInMS += System.currentTimeMillis() - this.mLastFramePTS;
                }
                this.mLastFramePTS = System.currentTimeMillis();
                int i = this.mTotalFrameCount;
                this.mTotalFrameCount = i + 1;
                if (i == 100) {
                    b.c(TAG, String.format("Average Frame Time: %.2f, FPS: %.2f", Float.valueOf(((float) this.mTotalFrameTimeInMS) / 100.0f), Float.valueOf((1000.0f / ((float) this.mTotalFrameTimeInMS)) * 100.0f)));
                    this.mTotalFrameCount = 0;
                    this.mTotalFrameTimeInMS = 0L;
                }
                if (this.hasSetup) {
                    nativeUpdateInputTexture(j);
                }
            }
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            Log.d(TAG, "ARPFilter resume: ");
            nativeResumeRender();
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void runAsyncOnRenderContext(Runnable runnable) {
        Queue<Runnable> queue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, runnable) == null) || (queue = this.mDrawQueue) == null || runnable == null) {
            return;
        }
        synchronized (queue) {
            this.mDrawQueue.add(runnable);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void runLuaScriptStr(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ARPMessage.getInstance().setUp();
        synchronized (this.mPipelineLock) {
            nativeRunLuaScriptStr(str);
            this.hasSetupPipeline = true;
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void runSyncOnIOContext(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, runnable) == null) || runnable == null) {
            return;
        }
        String str = TAG;
        b.c(str, "runSyncOnRenderContext: " + Thread.currentThread().getId());
        synchronized (this.mRunnableLock) {
            nativeRunSyncOnIOContext(runnable);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void runSyncOnRenderContext(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, runnable) == null) || runnable == null) {
            return;
        }
        String str = TAG;
        b.c(str, "runSyncOnRenderContext: " + Thread.currentThread().getId());
        synchronized (this.mRunnableLock) {
            nativeRunSyncOnRenderContext(runnable);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setAlgoPts(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            nativeSetAlgoPts(j);
        }
    }

    public void setAuthPic(Bitmap bitmap, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, bitmap, fArr) == null) {
            nativeSetAuthPic(bitmap, fArr);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setCameraFace(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.mFrontCamera = z;
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setCaptureData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            nativeSetCaptureData(i);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setContext(SoftReference<Context> softReference) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, softReference) == null) || softReference == null) {
            return;
        }
        this.softContext = softReference;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setInputMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, fArr) == null) {
            System.arraycopy(fArr, 0, this.texMatrix, 0, 16);
            nativeUpdateTextureMatrix(this.texMatrix);
        }
    }

    public void setInputSourceRotation(PixelRotation pixelRotation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, pixelRotation) == null) {
            nativeSetInputSourceRotation(pixelRotation.getValue());
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setInputTexture(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048636, this, i, i2, i3, i4) == null) {
            Log.d(TAG, String.format("setInputTexture: %d %d [%dx%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
            this.mInputTexWidth = i3;
            this.mInputTexHeight = i4;
            nativeSetInputTexture(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setIsDumpAlgoPixel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            nativeSetIsDumpAlgoPixel(z);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setIsRender(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            nativeSetIsRender(z);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setOnNeedCacheFrameListener(OnNeedCacheFrameListener onNeedCacheFrameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onNeedCacheFrameListener) == null) {
            this.mIsNeedCacheFrameListener = onNeedCacheFrameListener;
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setOnRenderFinishedListener(OnRenderFinishedListener onRenderFinishedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, onRenderFinishedListener) == null) {
            this.mOnRenderFinishedListener = onRenderFinishedListener;
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setOnRenderStartedListener(OnRenderStartedListener onRenderStartedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onRenderStartedListener) == null) {
            this.mOnRenderStartedListener = onRenderStartedListener;
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setPixelReaderRotation(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048642, this, pixelReadParams, pixelRotation) == null) || pixelReadParams == null) {
            return;
        }
        String pixelReadParamHash = getPixelReadParamHash(pixelReadParams);
        synchronized (this.mPipelineLock) {
            if (this.mPixelListenerHash.containsKey(pixelReadParamHash)) {
                int outputWidth = pixelReadParams.getOutputWidth();
                int outputHeight = pixelReadParams.getOutputHeight();
                nativeSetPixelReaderRotationByPixelInfo(outputWidth, outputHeight, pixelReadParams.getPixelRotate().getValue(), pixelReadParams.getPixelType().getValue(), outputWidth / getInputWidth(pixelReadParams), outputHeight / getInputHeight(pixelReadParams), pixelReadParams.getPreFilterID(), pixelRotation.getValue(), pixelReadParams.getFrameType().getValue());
            }
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setPixelReaderRotation(PixelRotation pixelRotation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, pixelRotation) == null) {
            nativeSetPixelReaderRotation(pixelRotation.getValue());
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void setSourceSyncProperty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.mNeedSyncRender = z;
            nativeSetSourceSyncProperty(z);
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public synchronized boolean setUpEGLEnv(EGLContext eGLContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, eGLContext)) == null) {
            synchronized (this) {
                if (this.hasSetup) {
                    return true;
                }
                if (prepareGLContext(eGLContext)) {
                    this.hasSetup = true;
                    this.mLastFramePTS = -1L;
                    this.mTotalFrameTimeInMS = 0L;
                    this.mTotalFrameCount = 0;
                    this.hasSetupPipeline = false;
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void swapBuffer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            nativeSwapBuffer();
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void updateOutputSurfaceRotation(String str, PixelRotation pixelRotation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, str, pixelRotation) == null) {
            nativeUpdateOutputSurfaceRotation(str, pixelRotation.getValue());
        }
    }

    @Override // com.baidu.ar.arplay.core.renderer.IARPRenderer
    public void uploadPixelToTextureFromPath(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048648, this, j, str) == null) {
            nativeUploadPixelToTextureFromPath(j, str);
        }
    }
}
