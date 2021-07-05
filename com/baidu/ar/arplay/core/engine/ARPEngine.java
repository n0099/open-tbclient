package com.baidu.ar.arplay.core.engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPContent;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.engine3d.AbstractARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.ar.arplay.core.renderer.ARPFilter;
import com.baidu.ar.arplay.core.renderer.ARPRenderer;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.sapi2.activity.OauthActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ARPEngine implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENGINE_3D_CLASS_NAME = "com.baidu.ar.arplay.core.engine3d.ARPEngine3D";
    public static final String LOWEST_VERSION_KEY = "compatible_version";
    public static final String TAG = "ARPEngine";
    public static ARPEngine self;
    public transient /* synthetic */ FieldHolder $fh;
    public ARPContent mARPContent;
    public ARPDataInteraction mARPDataInteraction;
    public AbstractARPEngine3D mARPEngine3D;
    public ARPEngineParams mARPEngineParams;
    public ARPFilter mARPFilter;
    public ARPRenderer mARPRenderer;
    public volatile boolean mIsEngineCreated;
    public boolean mIsInitNative;
    public boolean mIsPaused;
    public boolean mScenePausedByUser;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1512562321, "Lcom/baidu/ar/arplay/core/engine/ARPEngine;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1512562321, "Lcom/baidu/ar/arplay/core/engine/ARPEngine;");
        }
    }

    public ARPEngine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsInitNative = false;
        this.mIsEngineCreated = false;
        this.mIsPaused = false;
        this.mARPContent = new ARPContent();
        this.mARPFilter = new ARPFilter();
        this.mARPRenderer = new ARPRenderer();
        ARPDataInteraction aRPDataInteraction = new ARPDataInteraction();
        this.mARPDataInteraction = aRPDataInteraction;
        this.mARPContent.registerCaseLoadListener(aRPDataInteraction);
        initEngine3DInstance();
    }

    private boolean createApp(int i2, int i3, int i4, int i5, float f2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), str})) == null) {
            com.baidu.ar.arplay.c.b.b(TAG, "createApp [width*height]: [" + i2 + "*" + i3 + PreferencesUtil.RIGHT_MOUNT);
            boolean nativeCreateApp = nativeCreateApp(i2, i3, i4, i5, f2, str);
            this.mIsEngineCreated = true;
            ARPContent aRPContent = this.mARPContent;
            if (aRPContent != null) {
                aRPContent.setEngineCreated(this.mIsEngineCreated);
            }
            return nativeCreateApp;
        }
        return invokeCommon.booleanValue;
    }

    public static synchronized ARPEngine getInstance() {
        InterceptResult invokeV;
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (ARPEngine.class) {
                if (self == null) {
                    self = new ARPEngine();
                }
                aRPEngine = self;
            }
            return aRPEngine;
        }
        return (ARPEngine) invokeV.objValue;
    }

    private void initEngine3DInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            try {
                Object newInstance = Class.forName(ENGINE_3D_CLASS_NAME).newInstance();
                if (newInstance instanceof IARPEngine3D) {
                    this.mARPEngine3D = (AbstractARPEngine3D) newInstance;
                }
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static native boolean libraryHasLoaded();

    private native boolean nativeSetup(Object obj, String str);

    public static synchronized void releaseInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (ARPEngine.class) {
                if (self != null) {
                    self.destroy();
                }
                self = null;
            }
        }
    }

    public void addAlgoType(int[] iArr, int i2) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, iArr, i2) == null) || (aRPDataInteraction = this.mARPDataInteraction) == null) {
            return;
        }
        aRPDataInteraction.addAlgoType(iArr, i2);
    }

    public String adjustFilterWithCasePathParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ARPFilter aRPFilter = this.mARPFilter;
            if (aRPFilter != null) {
                aRPFilter.adjustFilterWithCasePathParam(str);
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void adjustFilterWithFloatArrayParam(String str, String str2, float[] fArr, long j) {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, fArr, Long.valueOf(j)}) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.adjustFilterWithFloatArrayParam(str, str2, fArr, j);
    }

    public void adjustFilterWithFloatParam(String str, String str2, float f2, long j) {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Float.valueOf(f2), Long.valueOf(j)}) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.adjustFilterWithFloatParam(str, str2, f2, j);
    }

    public void adjustFilterWithIntParam(String str, String str2, int i2, long j) {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.adjustFilterWithIntParam(str, str2, i2, j);
    }

    public String adjustFilterWithJsonPathParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            ARPFilter aRPFilter = this.mARPFilter;
            if (aRPFilter != null) {
                return aRPFilter.adjustFilterWithJsonPathParam(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void adjustFilterWithStringParam(String str, String str2, String str3, long j) {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Long.valueOf(j)}) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.adjustFilterWithStringParam(str, str2, str3, j);
    }

    public void clearARMemory() {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aRPDataInteraction = this.mARPDataInteraction) == null) {
            return;
        }
        aRPDataInteraction.clearARMemory();
    }

    public void clearAlgoCache() {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aRPDataInteraction = this.mARPDataInteraction) == null) {
            return;
        }
        aRPDataInteraction.clearAlgoCache();
    }

    public boolean createEngine(ARPEngineParams aRPEngineParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aRPEngineParams)) == null) {
            synchronized (this) {
                boolean z = false;
                if (aRPEngineParams == null) {
                    return false;
                }
                this.mARPEngineParams = aRPEngineParams;
                if (!this.mIsInitNative) {
                    z = nativeSetup(new WeakReference(this), "5.1.0");
                    this.mIsInitNative = true;
                }
                if (!this.mIsEngineCreated) {
                    z = createApp(this.mARPEngineParams.getInputWidth(), this.mARPEngineParams.getInputHeight(), this.mARPEngineParams.getOutputWidth(), this.mARPEngineParams.getOutputHeight(), this.mARPEngineParams.getDensity(), this.mARPEngineParams.getShaderDBPath());
                    if (this.mARPDataInteraction != null) {
                        this.mARPDataInteraction.setup();
                    }
                }
                if (this.mARPEngine3D != null) {
                    this.mARPEngine3D.setIsActiveByARPlayVersionCase(isDriverdByARPVersion());
                }
                this.mARPContent.setIsFrontCamera(this.mARPEngineParams.isIsFrontCamera());
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.d
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                com.baidu.ar.arplay.c.b.b(TAG, "destroy");
                if (this.mARPRenderer != null) {
                    this.mARPRenderer.destroy();
                }
            }
        }
    }

    public synchronized void destroyEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                com.baidu.ar.arplay.c.b.b(TAG, "destroyEngine");
                this.mIsEngineCreated = false;
                if (this.mARPFilter != null) {
                    this.mARPFilter.destroy();
                }
                if (this.mARPContent != null) {
                    this.mARPContent.setEngineCreated(this.mIsEngineCreated);
                    this.mARPContent.destroy();
                }
                if (this.mARPEngine3D != null) {
                    this.mARPEngine3D.destroy();
                }
                nativeSetEngineBlendState(0);
                nativeDestroyEngine();
                if (this.mARPDataInteraction != null) {
                    this.mARPDataInteraction.destroy();
                }
            }
        }
    }

    public void destroyMockAlgoHandle(long j) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048588, this, j) == null) || (aRPDataInteraction = this.mARPDataInteraction) == null) {
            return;
        }
        aRPDataInteraction.destroyMockAlgoHandle(j);
    }

    public void disableCaseLutTexture() {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.disableCaseLutTexture();
    }

    public void disableFilterByAuthCode(int i2) {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.disableFilterByAuthCode(i2);
    }

    public IARPRenderer getARPRenderer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mARPRenderer : (IARPRenderer) invokeV.objValue;
    }

    public IARPScene getCurrentScene() {
        InterceptResult invokeV;
        AbstractARPEngine3D abstractARPEngine3D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (isEngineCanAccess() && (abstractARPEngine3D = this.mARPEngine3D) != null) {
                return abstractARPEngine3D.getCurrentScene();
            }
            return null;
        }
        return (IARPScene) invokeV.objValue;
    }

    public float[] getWindowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ARPContent aRPContent = this.mARPContent;
            return aRPContent != null ? aRPContent.getWindowSize() : new float[0];
        }
        return (float[]) invokeV.objValue;
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, sharedPreferences) == null) || (aRPDataInteraction = this.mARPDataInteraction) == null) {
            return;
        }
        aRPDataInteraction.initDataStore(sharedPreferences);
    }

    public void initWorldAxis() {
        AbstractARPEngine3D abstractARPEngine3D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (abstractARPEngine3D = this.mARPEngine3D) == null) {
            return;
        }
        abstractARPEngine3D.initWorldAxis();
    }

    public boolean isAppControllerInterrupt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? nativeIsAppControllerInterrupt() : invokeV.booleanValue;
    }

    public boolean isDriverdByARPVersion() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Object sharedEnvironmentValue = ARPScriptEnvironment.getInstance().getSharedEnvironmentValue("caseinfo");
            if (sharedEnvironmentValue != null && (sharedEnvironmentValue instanceof HashMap)) {
                HashMap hashMap = (HashMap) sharedEnvironmentValue;
                return (hashMap.get(LOWEST_VERSION_KEY) instanceof String) && (str = (String) hashMap.get(LOWEST_VERSION_KEY)) != "" && str.compareTo(OauthActivity.N) >= 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isEngineCanAccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mIsEngineCreated && this.mARPContent.isCaseCreated() : invokeV.booleanValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mIsPaused : invokeV.booleanValue;
    }

    public synchronized int loadCaseWithResPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            synchronized (this) {
                if (this.mARPContent == null || this.mARPRenderer == null) {
                    return -1;
                }
                return this.mARPContent.loadCaseWithResPath(str, this.mARPRenderer.getCameraPreviewWidth(), this.mARPRenderer.getCameraPreviewHeight());
            }
        }
        return invokeL.intValue;
    }

    public synchronized void loadTempleteWithResPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            synchronized (this) {
                if (this.mARPContent != null && this.mARPRenderer != null) {
                    this.mARPContent.loadTempleteWithResPath(str, this.mARPRenderer.getCameraPreviewWidth(), this.mARPRenderer.getCameraPreviewHeight());
                }
            }
        }
    }

    public long mockFaceAlgoHandle(long j, float[] fArr) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048602, this, j, fArr)) == null) {
            ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
            if (aRPDataInteraction != null) {
                return aRPDataInteraction.mockFaceAlgoHandle(j, fArr);
            }
            return -1L;
        }
        return invokeJL.longValue;
    }

    public native boolean nativeCreateApp(int i2, int i3, int i4, int i5, float f2, String str);

    public native void nativeDestroyEngine();

    public native boolean nativeIsAppControllerInterrupt();

    public native void nativeOnPause();

    public native void nativeOnResume();

    public native void nativeSetConfig(String str, String str2);

    public native void nativeSetEngineBlendState(int i2);

    public native void nativeSetLocalDeviceGrade(int i2);

    public synchronized void onCaseLoadCompleted(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, map) == null) {
            synchronized (this) {
                if (map == null) {
                    return;
                }
                if (this.mARPContent != null && this.mARPContent.checkValid(ARPContent.b.ek)) {
                    if (this.mARPRenderer != null) {
                        this.mARPRenderer.clearAllAsyncRenderTask();
                    }
                    this.mARPContent.onCaseLoadCompleted(map);
                }
                if (this.mIsPaused) {
                    nativeOnPause();
                }
            }
        }
    }

    public void onCaseUnloadCompleted() {
        ARPContent aRPContent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (aRPContent = this.mARPContent) == null) {
            return;
        }
        aRPContent.onCaseUnloadCompleted();
    }

    public void onGestureUpdate(int i2, long j, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, int i5, float f10) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i4), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Integer.valueOf(i5), Float.valueOf(f10)}) == null) && isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onGestureUpdate(i2, j, i3, f2, f3, f4, f5, i4, f6, f7, f8, f9, i5, f10);
        }
    }

    public void onGestureUpdateWithScaleFinish(int i2, long j, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, int i5, float f10, boolean z) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i4), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Integer.valueOf(i5), Float.valueOf(f10), Boolean.valueOf(z)}) == null) && isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onGestureUpdateWithScaleFinish(i2, j, i3, f2, f3, f4, f5, i4, f6, f7, f8, f9, i5, f10, z);
        }
    }

    public synchronized void onTempleLoadCompleted(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, map) == null) {
            synchronized (this) {
                if (map == null) {
                    return;
                }
                if (this.mARPContent != null) {
                    if (this.mARPRenderer != null) {
                        this.mARPRenderer.clearAllAsyncRenderTask();
                    }
                    this.mARPContent.onTempleLoadCompleted(map);
                }
            }
        }
    }

    public void onTouchUpdate(int i2, float f2, float f3, float f4, float f5, long j, int i3, float f6) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Long.valueOf(j), Integer.valueOf(i3), Float.valueOf(f6)}) == null) && isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onTouchUpdate(i2, f2, f3, f4, f5, j, i3, f6);
        }
    }

    public synchronized void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            synchronized (this) {
                this.mIsPaused = true;
                if (isEngineCanAccess()) {
                    nativeOnPause();
                }
                if (this.mARPRenderer != null) {
                    this.mARPRenderer.pause();
                }
            }
        }
    }

    public synchronized void pauseScene() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            synchronized (this) {
                this.mIsPaused = true;
                if (isEngineCanAccess()) {
                    nativeOnPause();
                }
                this.mScenePausedByUser = true;
            }
        }
    }

    public void removeAlgoType(int[] iArr) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, iArr) == null) || (aRPDataInteraction = this.mARPDataInteraction) == null) {
            return;
        }
        aRPDataInteraction.removeAlgoType(iArr);
    }

    public synchronized void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            synchronized (this) {
                if (!this.mScenePausedByUser) {
                    resumeScene();
                }
                if (this.mARPRenderer != null) {
                    this.mARPRenderer.resume();
                }
            }
        }
    }

    public synchronized void resumeScene() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            synchronized (this) {
                this.mIsPaused = false;
                if (isEngineCanAccess()) {
                    nativeOnResume();
                }
                this.mScenePausedByUser = false;
            }
        }
    }

    public void sceneRotateToCamera() {
        AbstractARPEngine3D abstractARPEngine3D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (abstractARPEngine3D = this.mARPEngine3D) == null) {
            return;
        }
        abstractARPEngine3D.sceneRotateToCamera();
    }

    public void sceneWorldPositionToOrigin() {
        AbstractARPEngine3D abstractARPEngine3D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (abstractARPEngine3D = this.mARPEngine3D) == null) {
            return;
        }
        abstractARPEngine3D.sceneWorldPositionToOrigin();
    }

    public synchronized void setAlgoDataHandle(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
            synchronized (this) {
                if (this.mARPDataInteraction != null) {
                    this.mARPDataInteraction.setAlgoDataHandle(j);
                }
            }
        }
    }

    public void setAuthPic(Bitmap bitmap, float[] fArr) {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048625, this, bitmap, fArr) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.setAuthPic(bitmap, fArr);
    }

    public void setConfig(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, str, str2) == null) {
            com.baidu.ar.arplay.c.b.b(TAG, "syncServerConfig :" + str2);
            nativeSetConfig(str, str2);
        }
    }

    public void setContext(SoftReference<Context> softReference) {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, softReference) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.setContext(softReference);
    }

    public void setEngineBlendState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            nativeSetEngineBlendState(i2);
        }
    }

    public void setFaceLandMarkFrameAcheMode(int i2) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048629, this, i2) == null) || (aRPDataInteraction = this.mARPDataInteraction) == null) {
            return;
        }
        aRPDataInteraction.setFaceLandMarkFrameAcheMode(i2);
    }

    public synchronized void setHtmlUpdateCallback(ARPDataInteraction.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, aVar) == null) {
            synchronized (this) {
                if (this.mARPDataInteraction != null) {
                    this.mARPDataInteraction.setHtmlUpdateCallback(aVar);
                }
            }
        }
    }

    public void setInteraction(ARPDataInteraction.b bVar) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, bVar) == null) || (aRPDataInteraction = this.mARPDataInteraction) == null) {
            return;
        }
        aRPDataInteraction.setInteraction(bVar);
    }

    public void setIsFrontCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.mARPContent.setIsFrontCamera(z);
        }
    }

    public void setLocalDeviceGrade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            com.baidu.ar.arplay.c.b.b(TAG, "setLocalDeviceGrade :" + i2);
            nativeSetLocalDeviceGrade(i2);
        }
    }

    public void setPreviewSize(int i2, int i3) {
        ARPContent aRPContent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048634, this, i2, i3) == null) || (aRPContent = this.mARPContent) == null) {
            return;
        }
        aRPContent.setPreviewSize(i2, i3);
    }

    public synchronized void setVideoUpdateCallback(ARPDataInteraction.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, cVar) == null) {
            synchronized (this) {
                if (this.mARPDataInteraction != null) {
                    this.mARPDataInteraction.setVideoUpdateCallback(cVar);
                }
            }
        }
    }

    public void setWatermark(String str, Bitmap bitmap, float[] fArr) {
        ARPFilter aRPFilter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048636, this, str, bitmap, fArr) == null) || (aRPFilter = this.mARPFilter) == null) {
            return;
        }
        aRPFilter.setWatermark(str, bitmap, fArr);
    }

    public void setWindowSize(int i2, int i3) {
        ARPContent aRPContent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048637, this, i2, i3) == null) || (aRPContent = this.mARPContent) == null) {
            return;
        }
        aRPContent.setWindowSize(i2, i3);
    }

    public synchronized void unloadCase() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            synchronized (this) {
                if (this.mARPContent != null && this.mARPContent.checkValid(ARPContent.b.ej)) {
                    if (this.mARPRenderer != null) {
                        this.mARPRenderer.clearAllAsyncRenderTask();
                    }
                    this.mARPContent.unloadCase();
                }
            }
        }
    }

    public synchronized void unloadTemplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            synchronized (this) {
                com.baidu.ar.arplay.c.b.b(TAG, "unloadTemplete");
                this.mARPContent.unloadTemplete();
            }
        }
    }

    public void updateAlgoDataToNode(int i2, int i3, byte[] bArr) {
        ARPDataInteraction aRPDataInteraction;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048640, this, i2, i3, bArr) == null) {
            com.baidu.ar.arplay.c.b.c(TAG, "updateAlgoDataToNode");
            if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
                aRPDataInteraction.updateAlgoDataToNode(i2, i3, bArr);
            }
        }
    }

    public void updateNodeUniform(String str, HashMap<String, Object> hashMap) {
        AbstractARPEngine3D abstractARPEngine3D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048641, this, str, hashMap) == null) || !isEngineCanAccess() || isAppControllerInterrupt() || (abstractARPEngine3D = this.mARPEngine3D) == null) {
            return;
        }
        abstractARPEngine3D.updateNodeUniform(str, hashMap);
    }
}
