package com.baidu.pass.biometrics.face.liveness;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricOperation;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.pass.biometrics.base.dynamicupdate.LocalConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.pass.biometrics.face.liveness.c.d;
import com.baidu.pass.biometrics.face.liveness.c.e;
import com.baidu.pass.biometrics.face.liveness.c.f;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.enums.HeadPose;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PassFaceRecogManager implements PassBiometric {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long f = 300;
    public static PassFaceRecogManager g = null;
    public static final int h = 30000;
    public static final float i = 0.6f;
    public static final int j = 40;
    public static final int k = 220;
    public static final float l = 0.8f;
    public static final int m = 20;
    public static final int n = 200;
    public static final float o = 0.6f;
    public static final float p = 0.7f;
    public static final int q = 3;
    public static final float r = 1.0f;
    public static final float s = 0.3f;
    public static final boolean t = false;
    public static final boolean u = false;
    public transient /* synthetic */ FieldHolder $fh;
    public PassBiometricConfiguration a;
    public boolean b;
    public PassFaceRecogCallback c;
    public long d;
    public List<LivenessTypeEnum> e;

    /* loaded from: classes2.dex */
    public class a implements IInitCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassFaceRecogManager a;

        public a(PassFaceRecogManager passFaceRecogManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passFaceRecogManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passFaceRecogManager;
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initFailure(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.b = false;
            }
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IInitCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ PassFaceRecogResult b;
        public final /* synthetic */ PassFaceRecogCallback c;
        public final /* synthetic */ PassFaceRecogManager d;

        public b(PassFaceRecogManager passFaceRecogManager, Context context, PassFaceRecogResult passFaceRecogResult, PassFaceRecogCallback passFaceRecogCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passFaceRecogManager, context, passFaceRecogResult, passFaceRecogCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = passFaceRecogManager;
            this.a = context;
            this.b = passFaceRecogResult;
            this.c = passFaceRecogCallback;
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initFailure(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (i == -1) {
                    this.b.setResultCode(PassBiometricResult.ERROR_CODE_LACK_SO_ERROR);
                    this.b.setResultMsg(PassBiometricResult.ERROR_MSG_LACK_SO_ERROR);
                } else {
                    this.b.setResultCode(PassBiometricResult.ERROR_CODE_SYSTEM_VERSION_LOW_ERROR);
                    this.b.setResultMsg(PassBiometricResult.ERROR_MSG_SYSTEM_VERSION_LOW_ERROR);
                }
                this.c.onFailure(this.b);
            }
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d.b = true;
                Intent intent = new Intent(this.a, PassLivenessRecogActivity.class);
                if (!(this.a instanceof Activity)) {
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                this.a.startActivity(intent);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassFaceRecogManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PassFaceRecogManager passFaceRecogManager, boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passFaceRecogManager, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passFaceRecogManager;
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                LocalConfigOptions.getInstance(this.a.a.getApplication()).setBioOptions(LocalConfigOptions.getInstance(this.a.a.getApplication()).getBioOptions());
            }
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                try {
                    LocalConfigOptions.getInstance(this.a.a.getApplication()).setBioOptions(SdkConfigOptions.fromOnLineJSON(new JSONObject(str)));
                } catch (JSONException e) {
                    onFailure(e, e.hashCode(), str);
                }
            }
        }
    }

    public PassFaceRecogManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("appid", this.a.appId);
            httpHashMapWrap.put("tpl", this.a.tpl);
            new HttpClientWrap(this.a.getApplication()).get("https://wappass.bdimg.com/static/appsapi/appdistribute/android.txt", httpHashMapWrap, null, new c(this, true));
        }
    }

    private Map<String, String> c() {
        InterceptResult invokeV;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            PassBiometricConfiguration passBiometricConfiguration = this.a;
            return (passBiometricConfiguration == null || (map = passBiometricConfiguration.faceResPaths) == null) ? a() : map;
        }
        return (Map) invokeV.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.d = System.currentTimeMillis();
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? System.currentTimeMillis() - this.d < 300 : invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            try {
                d.a();
                FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
                faceConfig.setBlurnessValue(0.6f);
                faceConfig.setBrightnessValue(40.0f);
                faceConfig.setBrightnessMaxValue(220.0f);
                faceConfig.setOcclusionLeftEyeValue(0.8f);
                faceConfig.setOcclusionRightEyeValue(0.8f);
                faceConfig.setOcclusionNoseValue(0.8f);
                faceConfig.setOcclusionMouthValue(0.8f);
                faceConfig.setOcclusionLeftContourValue(0.8f);
                faceConfig.setOcclusionRightContourValue(0.8f);
                faceConfig.setOcclusionChinValue(0.8f);
                faceConfig.setHeadPitchValue(20);
                faceConfig.setHeadYawValue(20);
                faceConfig.setHeadRollValue(20);
                faceConfig.setMinFaceSize(200);
                faceConfig.setNotFaceValue(0.6f);
                faceConfig.setEyeClosedValue(0.7f);
                faceConfig.setLivenessTypeList(this.e);
                faceConfig.setLivenessRandom(false);
                faceConfig.setSound(false);
                faceConfig.setTimeDetectModule(30000L);
                faceConfig.setCacheImageNum(3);
                faceConfig.setFaceFarRatio(0.3f);
                faceConfig.setFaceClosedRatio(1.0f);
                faceConfig.setResPaths(c());
                FaceSDKManager.getInstance().setFaceConfig(faceConfig);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static synchronized PassFaceRecogManager getInstance() {
        InterceptResult invokeV;
        PassFaceRecogManager passFaceRecogManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (PassFaceRecogManager.class) {
                if (g == null) {
                    g = new PassFaceRecogManager();
                }
                passFaceRecogManager = g;
            }
            return passFaceRecogManager;
        }
        return (PassFaceRecogManager) invokeV.objValue;
    }

    public void cleanPassFaceRecogCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = null;
        }
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void config(PassBiometricConfiguration passBiometricConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passBiometricConfiguration) == null) {
            if (passBiometricConfiguration != null) {
                if (!TextUtils.isEmpty(passBiometricConfiguration.tpl) && !TextUtils.isEmpty(passBiometricConfiguration.appId) && !TextUtils.isEmpty(passBiometricConfiguration.appSignKey)) {
                    this.a = passBiometricConfiguration;
                    ResUtils.setApplicationContext(passBiometricConfiguration.getApplication());
                    BeanConstants.tpl = passBiometricConfiguration.tpl;
                    BeanConstants.appid = passBiometricConfiguration.appId;
                    BeanConstants.appSignKey = passBiometricConfiguration.appSignKey;
                    b();
                    if (passBiometricConfiguration.isAgreeDangerousProtocol()) {
                        FaceSDKManager.getInstance().initialize(passBiometricConfiguration.getApplication(), passBiometricConfiguration.licenseID, passBiometricConfiguration.licenseFileName, new a(this));
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            throw new IllegalArgumentException("PassBiometricConfiguration can't be null");
        }
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, passBiometricOperation, passBiometricCallback, passBiometricDto, context) == null) {
            if (passBiometricCallback == null) {
                throw new IllegalArgumentException(PassBiometricCallback.class.getSimpleName() + " can't be null");
            } else if (passBiometricOperation == null) {
                throw new IllegalArgumentException(PassBiometricOperation.class.getSimpleName() + " can't be null");
            } else if (passBiometricDto != null) {
                if (((PassFaceOperation) passBiometricOperation).operationType != PassFaceOperation.OperationType.RECOGNIZE || e()) {
                    return;
                }
                d();
                PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) passBiometricDto;
                a(passFaceRecogDTO);
                a((PassFaceRecogCallback) passBiometricCallback, passFaceRecogDTO, context);
            } else {
                throw new IllegalArgumentException(PassBiometricDto.class.getSimpleName() + " can't be null");
            }
        }
    }

    public PassBiometricConfiguration getConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (PassBiometricConfiguration) invokeV.objValue;
    }

    public PassFaceRecogCallback getPassFaceRecogCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (PassFaceRecogCallback) invokeV.objValue;
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void setAgreeDangerousProtocol(boolean z) {
        PassBiometricConfiguration configuration;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (configuration = getConfiguration()) == null) {
            return;
        }
        configuration.setAgreeDangerousProtocol(z);
    }

    private void a(PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, passFaceRecogCallback, passFaceRecogDTO, context) == null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            if (passFaceRecogDTO == null) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
            PassFaceRecogType passFaceRecogType = passFaceRecogDTO.livenessType;
            if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
                if (TextUtils.isEmpty(passFaceRecogDTO.bduss) || TextUtils.isEmpty(passFaceRecogDTO.stoken)) {
                    passFaceRecogResult.setResultCode(101);
                    passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NO_LOGIN);
                    if (passFaceRecogCallback != null) {
                        passFaceRecogCallback.onFailure(passFaceRecogResult);
                        return;
                    }
                    return;
                }
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                if (TextUtils.isEmpty(passFaceRecogDTO.authToken)) {
                    passFaceRecogResult.setResultCode(-205);
                    if (passFaceRecogCallback != null) {
                        passFaceRecogCallback.onFailure(passFaceRecogResult);
                        return;
                    }
                    return;
                }
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
                if ((TextUtils.isEmpty(passFaceRecogDTO.realName) || TextUtils.isEmpty(passFaceRecogDTO.idCardNum)) && TextUtils.isEmpty(passFaceRecogDTO.getAccessToken())) {
                    passFaceRecogResult.setResultCode(-205);
                    if (passFaceRecogCallback != null) {
                        passFaceRecogCallback.onFailure(passFaceRecogResult);
                        return;
                    }
                    return;
                } else if (TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                    passFaceRecogDTO.exUid = "1";
                }
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
            this.c = passFaceRecogCallback;
            if (!e.a(context)) {
                passFaceRecogResult.setResultCode(-207);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SO_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
                return;
            }
            a(context, passFaceRecogDTO);
            if (!f()) {
                passFaceRecogResult.setResultCode(PassBiometricResult.ERROR_CODE_CONFIG_ERROR);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_CONFIG_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            } else if (this.b) {
                Intent intent = new Intent(context, PassLivenessRecogActivity.class);
                if (!(context instanceof Activity)) {
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } else {
                PassBiometricConfiguration passBiometricConfiguration = this.a;
                if (passBiometricConfiguration != null && passBiometricConfiguration.isAgreeDangerousProtocol()) {
                    FaceSDKManager faceSDKManager = FaceSDKManager.getInstance();
                    Application application = this.a.getApplication();
                    PassBiometricConfiguration passBiometricConfiguration2 = this.a;
                    faceSDKManager.initialize(application, passBiometricConfiguration2.licenseID, passBiometricConfiguration2.licenseFileName, new b(this, context, passFaceRecogResult, passFaceRecogCallback));
                    return;
                }
                passFaceRecogResult.setResultCode(-208);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_DANGEROUS_PROTOCOL_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            }
        }
    }

    private void a(Context context, PassFaceRecogDTO passFaceRecogDTO) {
        List<Integer> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, passFaceRecogDTO) == null) {
            List<LivenessTypeEnum> list2 = this.e;
            if (list2 == null) {
                this.e = new ArrayList();
            } else {
                list2.clear();
            }
            List<HeadPose> list3 = passFaceRecogDTO.poseList;
            if (list3 != null && !list3.isEmpty()) {
                f.b(this.e, passFaceRecogDTO.poseList);
                return;
            }
            SdkConfigOptions.LivenessConfigOption livenessConfigOption = LocalConfigOptions.getInstance(context).getBioOptions().livenessConfigOption;
            if (livenessConfigOption != null && (list = livenessConfigOption.action) != null && !list.isEmpty()) {
                try {
                    f.a(this.e, livenessConfigOption.action);
                    return;
                } catch (Exception unused) {
                    f.b(this.e);
                    return;
                }
            }
            f.b(this.e);
        }
    }

    private Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("key", "pass-key.face-android");
            hashMap.put(ConstPath.KEY_DETECT, "detect/detect_rgb-customized-pa-faceid4_0.model.int8.0.0.6.1.pass.mml");
            hashMap.put(ConstPath.KEY_ALIGN, "align/align-customized-pa-offlineCapture_withScore_quant_20200909.model.int8.6.4.7.1.pass.mml");
            hashMap.put(ConstPath.KEY_BLUR, "blur/blur-customized-pa-blurnet_9768.model.int8-3.0.9.1.pass.mml");
            hashMap.put(ConstPath.KEY_OCCLU, "occlusion/occlusion-customized-pa-occ.model.float32.2.0.6.1.pass.mml");
            hashMap.put(ConstPath.KEY_EYES, "eyes_close/eyes-customized-pa-caiji.model.float32.1.0.3.1.pass.mml");
            hashMap.put("mouth", "mouth_close/mouth-customized-pa-caiji.model.float32.1.0.3.1.pass.mml");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    private void a(PassFaceRecogDTO passFaceRecogDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, passFaceRecogDTO) == null) {
            if (TextUtils.isEmpty(passFaceRecogDTO.passProductId) && (passFaceRecogDTO.extraParamsMap.isEmpty() || TextUtils.isEmpty(passFaceRecogDTO.extraParamsMap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID)))) {
                throw new IllegalArgumentException("PassFaceRecogDTO.passProductId can't be empty");
            }
            if (TextUtils.isEmpty(passFaceRecogDTO.serviceType)) {
                passFaceRecogDTO.serviceType = "1008";
            }
            if (TextUtils.isEmpty(passFaceRecogDTO.extraParamsMap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID))) {
                passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, passFaceRecogDTO.passProductId);
            }
            passFaceRecogDTO.processid = PassBiometricUtil.getUUID();
            com.baidu.pass.biometrics.face.liveness.a.a.b().a(com.baidu.pass.biometrics.face.liveness.a.a.c, passFaceRecogDTO);
        }
    }
}
