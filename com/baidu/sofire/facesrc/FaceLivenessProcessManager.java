package com.baidu.sofire.facesrc;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.sofire.ac.IFaceProcessInfo;
import com.baidu.sofire.ac.IVideoRecordProcess;
import com.baidu.sofire.ac.RecordCallback;
import com.baidu.sofire.core.ForHostApp;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.PrivacyPolicyUtil;
import com.baidu.sofire.utility.SdkFacePrivateConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FaceLivenessProcessManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONFIG_JSON_KEY_BACK_FRAME = "3";
    public static final String CONFIG_JSON_KEY_CLOUD_REQUEST = "6";
    public static final String CONFIG_JSON_KEY_CONTINUE_WHEN_UNKNOWN = "2";
    public static final String CONFIG_JSON_KEY_DEVICE_CHECK = "1";
    public static final String CONFIG_JSON_KEY_FACE_INFO_INTERVAL = "7";
    public static final String CONFIG_JSON_KEY_FIRST_FRAME = "8";
    public static final String CONFIG_JSON_KEY_HOST_ARRAY = "9";
    public static final String CONFIG_JSON_KEY_NO_PLUGIN_BLOCK = "10";
    public static final String CONFIG_JSON_KEY_PLUGIN_PROCESS = "4";
    public static final String CONFIG_JSON_KEY_SINGLE_SENSOR_DATA = "5";
    public static final int ON_END_NETWORK_ERROR = -19;
    public static final int ON_END_STATUS_CODE_ALREADY_IN_PROCESS = -1;
    public static final int ON_END_STATUS_CODE_BUILD_DATA_ERROR = -2;
    public static final int ON_END_STATUS_CODE_CAMERA_ERROR = -5;
    public static final int ON_END_STATUS_CODE_CANCEL = -6;
    public static final int ON_END_STATUS_CODE_DEVICE_CHECK_FAIL = -3;
    public static final int ON_END_STATUS_CODE_DEVICE_CHECK_UNKNOWN_BLOCK = -4;
    public static final int ON_END_STATUS_CODE_INNER_EXCEPTION_AFTER_COLLECT_BACK = -12;
    public static final int ON_END_STATUS_CODE_INNER_EXCEPTION_BEFORE_COLLECT = -9;
    public static final int ON_END_STATUS_CODE_INNER_EXCEPTION_ON_LIVENESS_COMLETION = -10;
    public static final int ON_END_STATUS_CODE_INNER_EXCEPTION_ON_PREVIEW_FRAME = -11;
    public static final int ON_END_STATUS_CODE_NO_SAFE_MODULE = -15;
    public static final int ON_END_STATUS_CODE_RECORD_ERROR = -17;
    public static final int ON_END_STATUS_CODE_RELEASE_CALLED = -16;
    public static final int ON_END_STATUS_CODE_RESULT = 1;
    public static final int ON_END_STATUS_CODE_RESULT_NULL = -8;
    public static final int ON_END_STATUS_CODE_THREAD_ERROR = -7;
    public static final int ON_END_STATUS_FACE_SDK_NOT_READY = -20;
    public static final int ON_END_STATUS_FACE_TIMEOUT = -18;
    public static final int ON_END_STATUS_NEVER_INIT = -13;
    public static final int ON_END_STATUS_NOT_AGREE_POLICY = -14;
    public static String sApikey = null;
    public static int sFaceSdkExistsCheckFlug = -1;
    public static boolean sFaceSdkInitCheckFlug = false;
    public static int sFaceSdkVersionCheckFlug = -1;
    public static FaceLivenessProcessManager sInstance;
    public static String sLicenseId;
    public static String sSecretKey;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public IFaceProcess mProcess;
    public IVideoRecordProcess mRecordProcess;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1401444262, "Lcom/baidu/sofire/facesrc/FaceLivenessProcessManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1401444262, "Lcom/baidu/sofire/facesrc/FaceLivenessProcessManager;");
        }
    }

    public FaceLivenessProcessManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    private void callbackInProcess(Activity activity, FaceProcessCallback faceProcessCallback, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65538, this, activity, faceProcessCallback, i) == null) || activity == null || faceProcessCallback == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(this, faceProcessCallback, i) { // from class: com.baidu.sofire.facesrc.FaceLivenessProcessManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FaceLivenessProcessManager this$0;
            public final /* synthetic */ FaceProcessCallback val$callback;
            public final /* synthetic */ int val$code;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, faceProcessCallback, Integer.valueOf(i)};
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
                this.val$callback = faceProcessCallback;
                this.val$code = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.val$callback.onEnd(this.val$code, null);
                }
            }
        });
    }

    private boolean checkFaceSdk() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                if (sFaceSdkExistsCheckFlug == -1 && Class.forName("com.baidu.pass.face.platform.FaceSDKManager") != null) {
                    sFaceSdkExistsCheckFlug = 1;
                }
                if (sFaceSdkExistsCheckFlug != 1) {
                    return false;
                }
                if (sFaceSdkVersionCheckFlug == -1) {
                    if (!"4.1.1".equals(FaceSDKManager.getSecDecouplingVersion()) && !CommonMethods.compareVersion(FaceSDKManager.getSecDecouplingVersion(), "4.1.1")) {
                        i = 0;
                        sFaceSdkVersionCheckFlug = i;
                    }
                    i = 1;
                    sFaceSdkVersionCheckFlug = i;
                }
                return sFaceSdkVersionCheckFlug == 1;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static synchronized boolean checkFaceSdkInit() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (FaceLivenessProcessManager.class) {
                if (!sFaceSdkInitCheckFlug) {
                    sFaceSdkInitCheckFlug = FaceSDKManager.getInstance().getInitFlag();
                }
                z = sFaceSdkInitCheckFlug;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static synchronized FaceLivenessProcessManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (FaceLivenessProcessManager.class) {
                if (context == null) {
                    return sInstance;
                }
                if (sInstance == null) {
                    sInstance = new FaceLivenessProcessManager(context);
                }
                return sInstance;
            }
        }
        return (FaceLivenessProcessManager) invokeL.objValue;
    }

    public static String getLicenseId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? sLicenseId : (String) invokeV.objValue;
    }

    public static String getsApikey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? sApikey : (String) invokeV.objValue;
    }

    public static String getsSecretKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? sSecretKey : (String) invokeV.objValue;
    }

    public static synchronized FaceLivenessProcessManager peekInstance() {
        InterceptResult invokeV;
        FaceLivenessProcessManager faceLivenessProcessManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (FaceLivenessProcessManager.class) {
                faceLivenessProcessManager = sInstance;
            }
            return faceLivenessProcessManager;
        }
        return (FaceLivenessProcessManager) invokeV.objValue;
    }

    public static void setLicenseId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            sLicenseId = str;
        }
    }

    public static void setsApikey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            sApikey = str;
        }
    }

    public static void setsSecretKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            sSecretKey = str;
        }
    }

    public void cancelCurrentFaceLivenessProcess() {
        IFaceProcess iFaceProcess;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iFaceProcess = this.mProcess) == null) {
            return;
        }
        iFaceProcess.cancel();
        this.mProcess = null;
    }

    public synchronized IVideoRecordProcess getVideoRecordProcess(Activity activity, SurfaceHolder surfaceHolder, RecordCallback recordCallback, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, surfaceHolder, recordCallback, i)) == null) {
            synchronized (this) {
                if (ForHostApp.peekInstance() != null && ForHostApp.hostContext != null) {
                    if (!PrivacyPolicyUtil.check(ForHostApp.hostContext)) {
                        callbackInProcess(activity, recordCallback, -14);
                        return null;
                    } else if (this.mRecordProcess != null) {
                        callbackInProcess(activity, recordCallback, -1);
                        return null;
                    } else {
                        VideoRecordProcess videoRecordProcess = new VideoRecordProcess(this, activity, surfaceHolder, recordCallback, i);
                        this.mRecordProcess = videoRecordProcess;
                        return videoRecordProcess;
                    }
                }
                callbackInProcess(activity, recordCallback, -13);
                return null;
            }
        }
        return (IVideoRecordProcess) invokeLLLI.objValue;
    }

    public synchronized IVideoRecordProcess getVideoRecordTextureProcess(Activity activity, TextureView textureView, RecordCallback recordCallback, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, activity, textureView, recordCallback, i)) == null) {
            synchronized (this) {
                if (ForHostApp.peekInstance() != null && ForHostApp.hostContext != null) {
                    if (!PrivacyPolicyUtil.check(ForHostApp.hostContext)) {
                        callbackInProcess(activity, recordCallback, -14);
                        return null;
                    } else if (this.mRecordProcess != null) {
                        callbackInProcess(activity, recordCallback, -1);
                        return null;
                    } else {
                        VideoRecordTextureProcess videoRecordTextureProcess = new VideoRecordTextureProcess(this, activity, textureView, recordCallback, i);
                        this.mRecordProcess = videoRecordTextureProcess;
                        return videoRecordTextureProcess;
                    }
                }
                callbackInProcess(activity, recordCallback, -13);
                return null;
            }
        }
        return (IVideoRecordProcess) invokeLLLI.objValue;
    }

    public void processEnd(FaceLivenessProcess faceLivenessProcess) {
        IFaceProcess iFaceProcess;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, faceLivenessProcess) == null) && (iFaceProcess = this.mProcess) != null && faceLivenessProcess == iFaceProcess) {
            this.mProcess = null;
        }
    }

    public void setSdkFaceConfig(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            SdkFacePrivateConfig sdkFacePrivateConfig = SdkFacePrivateConfig.getInstance(this.mContext);
            try {
                sdkFacePrivateConfig.setDeviceCheckFlag(jSONObject.getInt("1") == 1);
            } catch (JSONException e) {
                CommonMethods.handleNuLException(e);
            }
            try {
                sdkFacePrivateConfig.setUnknownContinueFlag(jSONObject.getInt("2") == 1);
            } catch (JSONException e2) {
                CommonMethods.handleNuLException(e2);
            }
            try {
                sdkFacePrivateConfig.setBackFrameFlag(jSONObject.getInt("3") == 1);
            } catch (JSONException e3) {
                CommonMethods.handleNuLException(e3);
            }
            try {
                sdkFacePrivateConfig.setPluginProcessFlag(jSONObject.getInt("4") == 1);
            } catch (JSONException e4) {
                CommonMethods.handleNuLException(e4);
            }
            try {
                sdkFacePrivateConfig.setSingleSensorFlag(jSONObject.getInt("5") == 1);
            } catch (JSONException e5) {
                CommonMethods.handleNuLException(e5);
            }
            try {
                sdkFacePrivateConfig.setSingleSensorFlag(jSONObject.getInt("5") == 1);
            } catch (JSONException e6) {
                CommonMethods.handleNuLException(e6);
            }
            try {
                sdkFacePrivateConfig.setFaceInfoInterval(jSONObject.getLong("7"));
            } catch (JSONException e7) {
                CommonMethods.handleNuLException(e7);
            }
            try {
                sdkFacePrivateConfig.setFirstFrameFlag(jSONObject.getInt("8") == 1);
            } catch (JSONException e8) {
                CommonMethods.handleNuLException(e8);
            }
            try {
                sdkFacePrivateConfig.setHostArray(jSONObject.getJSONArray("9").toString());
            } catch (JSONException e9) {
                CommonMethods.handleNuLException(e9);
            }
            try {
                sdkFacePrivateConfig.setBlockWhenNoPlugin(jSONObject.getInt("10") == 1);
            } catch (JSONException e10) {
                CommonMethods.handleNuLException(e10);
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public void setSoundEnable(boolean z) {
        IFaceProcess iFaceProcess;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (iFaceProcess = this.mProcess) == null) {
            return;
        }
        iFaceProcess.setSoundEnable(z);
    }

    public synchronized boolean startFaceSurfaceLiveness(Activity activity, SurfaceHolder surfaceHolder, FaceProcessCallback faceProcessCallback, int i, IFaceProcessInfo iFaceProcessInfo, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, surfaceHolder, faceProcessCallback, Integer.valueOf(i), iFaceProcessInfo, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            synchronized (this) {
                if (!CommonMethods.isNetworkAvailable(activity.getApplicationContext())) {
                    callbackInProcess(activity, faceProcessCallback, -19);
                    return false;
                }
                if (ForHostApp.peekInstance() != null && ForHostApp.hostContext != null) {
                    if (!PrivacyPolicyUtil.check(ForHostApp.hostContext)) {
                        callbackInProcess(activity, faceProcessCallback, -14);
                        return false;
                    } else if (!checkFaceSdk()) {
                        callbackInProcess(activity, faceProcessCallback, -20);
                        return false;
                    } else if (this.mProcess != null) {
                        callbackInProcess(activity, faceProcessCallback, -1);
                        return false;
                    } else {
                        FaceLivenessProcess faceLivenessProcess = new FaceLivenessProcess(this, activity, surfaceHolder, faceProcessCallback, i, iFaceProcessInfo, z, i2);
                        this.mProcess = faceLivenessProcess;
                        faceLivenessProcess.start();
                        return true;
                    }
                }
                callbackInProcess(activity, faceProcessCallback, -13);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public synchronized boolean startFaceTextureLiveness(Activity activity, TextureView textureView, FaceProcessCallback faceProcessCallback, int i, IFaceProcessInfo iFaceProcessInfo, boolean z, boolean z2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{activity, textureView, faceProcessCallback, Integer.valueOf(i), iFaceProcessInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            synchronized (this) {
                if (!CommonMethods.isNetworkAvailable(activity.getApplicationContext())) {
                    callbackInProcess(activity, faceProcessCallback, -19);
                    return false;
                }
                if (ForHostApp.peekInstance() != null && ForHostApp.hostContext != null) {
                    if (!PrivacyPolicyUtil.check(ForHostApp.hostContext)) {
                        callbackInProcess(activity, faceProcessCallback, -14);
                        return false;
                    } else if (!checkFaceSdk()) {
                        callbackInProcess(activity, faceProcessCallback, -20);
                        return false;
                    } else if (this.mProcess != null) {
                        callbackInProcess(activity, faceProcessCallback, -1);
                        return false;
                    } else {
                        FaceTextureLivenessProcess faceTextureLivenessProcess = new FaceTextureLivenessProcess(this, activity, textureView, faceProcessCallback, i, iFaceProcessInfo, 1, z, z2, i2);
                        this.mProcess = faceTextureLivenessProcess;
                        faceTextureLivenessProcess.start();
                        return true;
                    }
                }
                callbackInProcess(activity, faceProcessCallback, -13);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    private void callbackInProcess(Activity activity, RecordCallback recordCallback, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, this, activity, recordCallback, i) == null) || activity == null || recordCallback == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(this, recordCallback, i) { // from class: com.baidu.sofire.facesrc.FaceLivenessProcessManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FaceLivenessProcessManager this$0;
            public final /* synthetic */ RecordCallback val$callback;
            public final /* synthetic */ int val$code;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, recordCallback, Integer.valueOf(i)};
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
                this.val$callback = recordCallback;
                this.val$code = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.val$callback.onEnd(this.val$code, null);
                }
            }
        });
    }

    public void processEnd(IVideoRecordProcess iVideoRecordProcess) {
        IVideoRecordProcess iVideoRecordProcess2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, iVideoRecordProcess) == null) && (iVideoRecordProcess2 = this.mRecordProcess) != null && iVideoRecordProcess == iVideoRecordProcess2) {
            this.mRecordProcess = null;
        }
    }

    public void processEnd(IFaceProcess iFaceProcess) {
        IFaceProcess iFaceProcess2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, iFaceProcess) == null) && (iFaceProcess2 = this.mProcess) != null && iFaceProcess == iFaceProcess2) {
            this.mProcess = null;
        }
    }
}
