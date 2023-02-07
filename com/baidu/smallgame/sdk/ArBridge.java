package com.baidu.smallgame.sdk;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.view.OrientationEventListener;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.tieba.ce0;
import com.baidu.tieba.de0;
import com.baidu.tieba.mm1;
import com.baidu.tieba.nm1;
import com.baidu.tieba.om1;
import com.baidu.tieba.qm1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
@NotProguard
/* loaded from: classes3.dex */
public class ArBridge {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int INVALID_MESSAGE_ID = -1;
    public static final String TAG = "EngineLogger";
    public transient /* synthetic */ FieldHolder $fh;
    public long mCurrentGLThreadID;
    public nm1 mDataStore;
    public AtomicBoolean mDestroyed;
    public int mDeviceOrientation;
    public EGLContext mEglContext;
    public boolean mFirstFrameFinished;
    public FirstFrameListener mFirstFrameListener;
    public ce0 mGameRecorder;
    public boolean mHasResumeByUser;
    public int mImuType;
    public boolean mIsInitNative;
    public long mNativeARBridge;
    public OrientationEventListener mOrientationEventListener;
    public List<Runnable> mPendingRunnables;
    public final PerformanceJsonBean mPerformanceJsonBean;
    public int mScreenHeight;
    public int mScreenTextureId;
    public int mScreenWidth;
    public qm1 mStuckScreenHandler;
    public TouchOrientation mTouchOrientation;
    public b mVideoCallback;

    @NotProguard
    /* loaded from: classes3.dex */
    public interface FirstFrameListener {
        void onFirstFrameFinished();
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str, int i, String str2);
    }

    public static native boolean libraryHasLoaded();

    private native void nativeFinalize();

    private native long nativeInitializeAR();

    private native void nativeInterruptLoading();

    private native void nativeSetDisplayMetrics(long j, float f, float f2, float f3, float f4, float f5);

    private native void nativeSetSize(long j, float f, float f2);

    private native void nativeSetup(Object obj);

    public native int getCaseId();

    public native int getMessageID();

    public native void nativeClearScreen();

    public native void nativeCreateCase(String str, int i, HashMap<String, Object> hashMap, int i2, int i3);

    public native void nativeDensity(float f);

    public native void nativeDestroyCase();

    public native int nativeGetFps();

    public native boolean nativeIsFlipYNeeded();

    public native boolean nativeIsRenderCallbackQueueEmpty();

    public native void nativeOnPause();

    public native void nativeOnPauseByUser();

    public native void nativeOnResume();

    public native void nativeOnResumeByUser();

    public native void nativeReset();

    public native void nativeSetCameraDefaultPos();

    public native void nativeSetEuler(float f, float f2, float f3, String str);

    public native void nativeSetFrustum(float f, float f2);

    public native void nativeSetSlamRelocationType(int i);

    public native void nativeSetTargetInfo(HashMap<String, Object> hashMap);

    public native void nativeSmallGameDestroy(long j);

    public native void nativeSmallGameOnInit(long j);

    public native void nativeSmallGameOnPause();

    public native void nativeSmallGameOnPauseOnGLThread();

    public native void nativeSmallGameOnResume();

    public native boolean nativeSmallGameShouldSwapBuffer();

    public native int nativeSmallGameUpdate();

    public native void nativeUpdate();

    public native void nativeUpdateRMatrix(float[] fArr);

    public native void nativeUpdateRTMatrix(float[] fArr);

    public native void nativeUpdateRecordingStatus(boolean z);

    public native void nativeUpdateSLAMMatrix(float[] fArr);

    public native void onTouchEventNative(int i, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, long j, int i4);

    public native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    @Deprecated
    public void setEnginGLJniEnv() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
        }
    }

    public void setScreenShotStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
        }
    }

    public native boolean updateFrameBuffers(int[] iArr);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class TouchOrientation {
        public static final /* synthetic */ TouchOrientation[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TouchOrientation SCREEN_ORIENTATION_LANDSCAPE;
        public static final TouchOrientation SCREEN_ORIENTATION_NOT_DEFINED;
        public static final TouchOrientation SCREEN_ORIENTATION_PORTRAIT;
        public static final TouchOrientation SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
        public static final TouchOrientation SCREEN_ORIENTATION_REVERSE_PORTRAIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1467545191, "Lcom/baidu/smallgame/sdk/ArBridge$TouchOrientation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1467545191, "Lcom/baidu/smallgame/sdk/ArBridge$TouchOrientation;");
                    return;
                }
            }
            SCREEN_ORIENTATION_PORTRAIT = new TouchOrientation("SCREEN_ORIENTATION_PORTRAIT", 0);
            SCREEN_ORIENTATION_LANDSCAPE = new TouchOrientation("SCREEN_ORIENTATION_LANDSCAPE", 1);
            SCREEN_ORIENTATION_REVERSE_PORTRAIT = new TouchOrientation("SCREEN_ORIENTATION_REVERSE_PORTRAIT", 2);
            SCREEN_ORIENTATION_REVERSE_LANDSCAPE = new TouchOrientation("SCREEN_ORIENTATION_REVERSE_LANDSCAPE", 3);
            TouchOrientation touchOrientation = new TouchOrientation("SCREEN_ORIENTATION_NOT_DEFINED", 4);
            SCREEN_ORIENTATION_NOT_DEFINED = touchOrientation;
            $VALUES = new TouchOrientation[]{SCREEN_ORIENTATION_PORTRAIT, SCREEN_ORIENTATION_LANDSCAPE, SCREEN_ORIENTATION_REVERSE_PORTRAIT, SCREEN_ORIENTATION_REVERSE_LANDSCAPE, touchOrientation};
        }

        public TouchOrientation(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TouchOrientation valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (TouchOrientation) Enum.valueOf(TouchOrientation.class, str);
            }
            return (TouchOrientation) invokeL.objValue;
        }

        public static TouchOrientation[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (TouchOrientation[]) $VALUES.clone();
            }
            return (TouchOrientation[]) invokeV.objValue;
        }
    }

    public ArBridge() {
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
        this.mPendingRunnables = new LinkedList();
        this.mIsInitNative = false;
        this.mDestroyed = new AtomicBoolean(true);
        this.mScreenTextureId = -1;
        this.mNativeARBridge = 0L;
        this.mFirstFrameFinished = false;
        this.mCurrentGLThreadID = -1L;
        this.mDeviceOrientation = -1;
        this.mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
        this.mHasResumeByUser = false;
        this.mImuType = 0;
        this.mPerformanceJsonBean = new PerformanceJsonBean();
        this.mGameRecorder = new ce0(V8Engine.getAppContext());
        this.mNativeARBridge = nativeInitializeAR();
        Log.e(TAG, "initialize ar bridge. nativePtr: " + this.mNativeARBridge);
        this.mStuckScreenHandler = new mm1();
    }

    public static void exceptionCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            Log.e(TAG, str, new Throwable());
        }
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, sharedPreferences) == null) && this.mDataStore == null) {
            nm1 nm1Var = new nm1();
            this.mDataStore = nm1Var;
            nm1Var.c(sharedPreferences);
        }
    }

    public void setDensity(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048624, this, f) == null) {
            nativeDensity(f);
        }
    }

    public void setFirstFrameListener(FirstFrameListener firstFrameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, firstFrameListener) == null) {
            this.mFirstFrameListener = firstFrameListener;
        }
    }

    public void setGLThreadID(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            this.mCurrentGLThreadID = j;
        }
    }

    public void setGameRecordCallback(de0 de0Var) {
        ce0 ce0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, de0Var) == null) && (ce0Var = this.mGameRecorder) != null) {
            ce0Var.C(de0Var);
        }
    }

    public void setImuType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.mImuType = i;
        }
    }

    public void setOnStuckScreenListener(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, om1Var) == null) {
            this.mStuckScreenHandler.b(om1Var);
        }
    }

    public void setSlamRelocationType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            nativeSetSlamRelocationType(i);
        }
    }

    public void setStuckScreenLimitTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048636, this, j) == null) {
            this.mStuckScreenHandler.c(j);
        }
    }

    public void setTouchOrientation(TouchOrientation touchOrientation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, touchOrientation) == null) {
            this.mTouchOrientation = touchOrientation;
        }
    }

    public synchronized void setVideoUpdateCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bVar) == null) {
            synchronized (this) {
                this.mVideoCallback = bVar;
            }
        }
    }

    @Deprecated
    public void surfaceViewCapture(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048647, this, aVar) == null) && aVar != null) {
            aVar.a(null);
        }
    }

    public boolean updateFbos(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, iArr)) == null) {
            return updateFrameBuffers(iArr);
        }
        return invokeL.booleanValue;
    }

    public void updateRMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, fArr) == null) {
            nativeUpdateRMatrix(fArr);
        }
    }

    public void updateRTMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, fArr) == null) {
            nativeUpdateRTMatrix(fArr);
        }
    }

    public void updateSLAMMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, fArr) == null) {
            nativeUpdateSLAMMatrix(fArr);
        }
    }

    public static String getValue(Object obj, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, obj, i, str)) == null) {
            ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
            if (arBridge == null) {
                return "";
            }
            return arBridge.getValue(i, str);
        }
        return (String) invokeLIL.objValue;
    }

    public void setValue(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048638, this, i, str, str2) == null) {
            nm1 nm1Var = this.mDataStore;
            if (nm1Var != null) {
                nm1Var.d(i, str, str2);
            } else {
                Log.e("ArBridge", "set value error!");
            }
        }
    }

    private void onFirstFrameFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Log.i(TAG, "onFirstFrameFinished");
            ce0 ce0Var = this.mGameRecorder;
            if (ce0Var != null && this.mEglContext != null) {
                ce0Var.t(nativeIsFlipYNeeded(), this.mEglContext, this.mScreenWidth, this.mScreenHeight, V8Engine.getAppContext());
            }
            FirstFrameListener firstFrameListener = this.mFirstFrameListener;
            if (firstFrameListener != null) {
                firstFrameListener.onFirstFrameFinished();
                this.mFirstFrameListener = null;
                this.mFirstFrameFinished = true;
            }
        }
    }

    public void smallGameDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            Log.w(TAG, "[V8Dispose][ArBridge] MiniGameDestroy, destroyed=" + this.mDestroyed);
            if (!this.mDestroyed.getAndSet(true)) {
                nativeSmallGameDestroy(this.mNativeARBridge);
                this.mNativeARBridge = 0L;
                this.mGameRecorder.I();
                this.mGameRecorder.x();
            }
        }
    }

    public static void setValue(Object obj, int i, String str, String str2) {
        ArBridge arBridge;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65547, null, obj, i, str, str2) != null) || (arBridge = (ArBridge) ((WeakReference) obj).get()) == null) {
            return;
        }
        arBridge.setValue(i, str, str2);
    }

    public static void updateVideoFrame(Object obj, String str, int i, String str2) {
        ArBridge arBridge;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65548, null, obj, str, i, str2) != null) || (arBridge = (ArBridge) ((WeakReference) obj).get()) == null) {
            return;
        }
        arBridge.updateVideoFrame(str, i, str2);
    }

    public void clearARMemory() {
        nm1 nm1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (nm1Var = this.mDataStore) != null) {
            nm1Var.a();
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finalize();
            synchronized (this) {
                if (this.mIsInitNative) {
                    try {
                        nativeFinalize();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public ce0 getGameRecorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mGameRecorder;
        }
        return (ce0) invokeV.objValue;
    }

    public int getImuType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImuType;
        }
        return invokeV.intValue;
    }

    public JSONArray getPerformanceJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPerformanceJsonBean.toJSONArray();
        }
        return (JSONArray) invokeV.objValue;
    }

    public PerformanceJsonBean getPerformanceJsonBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mPerformanceJsonBean;
        }
        return (PerformanceJsonBean) invokeV.objValue;
    }

    public int getScreenTextureId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mScreenTextureId;
        }
        return invokeV.intValue;
    }

    public qm1 getStuckScreenHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mStuckScreenHandler;
        }
        return (qm1) invokeV.objValue;
    }

    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mDestroyed.get();
        }
        return invokeV.booleanValue;
    }

    public boolean isRenderCallbackQueueEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return nativeIsRenderCallbackQueueEmpty();
        }
        return invokeV.booleanValue;
    }

    public long nativePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mNativeARBridge;
        }
        return invokeV.longValue;
    }

    public void notifyFrameUpdated() {
        ce0 ce0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (ce0Var = this.mGameRecorder) != null) {
            ce0Var.u(getScreenTextureId());
        }
    }

    public void setCameraDefaultPos() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            nativeSetCameraDefaultPos();
        }
    }

    public boolean shouldSwapBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return nativeSmallGameShouldSwapBuffer();
        }
        return invokeV.booleanValue;
    }

    public void smallGameOnInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            nativeSmallGameOnInit(this.mNativeARBridge);
            this.mDestroyed.set(false);
        }
    }

    public void smallGameOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnPause.");
            nativeSmallGameOnPause();
        }
    }

    public void smallGameOnPauseOnGLThrad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnPauseOnGLThrad.");
            nativeSmallGameOnPauseOnGLThread();
        }
    }

    public void smallGameOnResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnResume.");
            nativeSmallGameOnResume();
        }
    }

    public void smallGameUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.mScreenTextureId = nativeSmallGameUpdate();
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            nativeUpdate();
        }
    }

    public String getValue(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, str)) == null) {
            nm1 nm1Var = this.mDataStore;
            if (nm1Var != null) {
                return nm1Var.b(i, str);
            }
            Log.e("ArBridge", "get value error!");
            return "";
        }
        return (String) invokeIL.objValue;
    }

    public void setSize(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            nativeSetSize(this.mNativeARBridge, f, f2);
        }
    }

    public void setDisplayMetrics(float f, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            nativeSetDisplayMetrics(this.mNativeARBridge, f, f2, f3, f4, f5);
        }
    }

    public void setEglContextToRecorder(EGLContext eGLContext, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048626, this, eGLContext, i, i2) == null) {
            this.mEglContext = eGLContext;
            if (i > 0 && i2 > 0) {
                this.mScreenWidth = i;
                this.mScreenHeight = i2;
            }
            Log.i(TAG, "set eglContext:" + this.mEglContext);
        }
    }

    public void updateVideoFrame(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048654, this, str, i, str2) == null) {
            Log.i(TAG, "updateVideoFrame:" + i + "     ;avideoPath:" + str2);
            b bVar = this.mVideoCallback;
            if (bVar != null) {
                bVar.a(str, i, str2);
            }
        }
    }
}
