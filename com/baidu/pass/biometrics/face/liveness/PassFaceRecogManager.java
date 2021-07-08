package com.baidu.pass.biometrics.face.liveness;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.pass.biometrics.face.liveness.c.e;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PassFaceRecogManager implements PassBiometric {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final long f9169e = 300;

    /* renamed from: f  reason: collision with root package name */
    public static PassFaceRecogManager f9170f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PassBiometricConfiguration f9171a;

    /* renamed from: b  reason: collision with root package name */
    public PassFaceRecogCallback f9172b;

    /* renamed from: c  reason: collision with root package name */
    public long f9173c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9174d;

    /* loaded from: classes2.dex */
    public class a implements IInitCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogManager f9175a;

        public a(PassFaceRecogManager passFaceRecogManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passFaceRecogManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9175a = passFaceRecogManager;
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initFailure(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f9175a.f9174d = false;
            }
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9175a.f9174d = true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IInitCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9176a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogResult f9177b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f9178c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogManager f9179d;

        public b(PassFaceRecogManager passFaceRecogManager, Context context, PassFaceRecogResult passFaceRecogResult, PassFaceRecogCallback passFaceRecogCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passFaceRecogManager, context, passFaceRecogResult, passFaceRecogCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9179d = passFaceRecogManager;
            this.f9176a = context;
            this.f9177b = passFaceRecogResult;
            this.f9178c = passFaceRecogCallback;
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initFailure(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f9177b.setResultCode(-207);
                this.f9177b.setResultMsg(PassBiometricResult.ERROR_MSG_SO_ERROR);
                this.f9178c.onFailure(this.f9177b);
            }
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9179d.f9174d = true;
                Intent intent = new Intent(this.f9176a, PassLivenessRecogActivity.class);
                if (!(this.f9176a instanceof Activity)) {
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                this.f9176a.startActivity(intent);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogManager f9180a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PassFaceRecogManager passFaceRecogManager, boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passFaceRecogManager, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9180a = passFaceRecogManager;
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                LocalConfigOptions.getInstance(this.f9180a.f9171a.getApplication()).setBioOptions(LocalConfigOptions.getInstance(this.f9180a.f9171a.getApplication()).getBioOptions());
            }
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                try {
                    LocalConfigOptions.getInstance(this.f9180a.f9171a.getApplication()).setBioOptions(SdkConfigOptions.fromOnLineJSON(new JSONObject(str)));
                } catch (JSONException e2) {
                    onFailure(e2, e2.hashCode(), str);
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f9173c = System.currentTimeMillis();
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? System.currentTimeMillis() - this.f9173c < 300 : invokeV.booleanValue;
    }

    public static synchronized PassFaceRecogManager getInstance() {
        InterceptResult invokeV;
        PassFaceRecogManager passFaceRecogManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (PassFaceRecogManager.class) {
                if (f9170f == null) {
                    f9170f = new PassFaceRecogManager();
                }
                passFaceRecogManager = f9170f;
            }
            return passFaceRecogManager;
        }
        return (PassFaceRecogManager) invokeV.objValue;
    }

    public void cleanPassFaceRecogCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9172b = null;
        }
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void config(PassBiometricConfiguration passBiometricConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passBiometricConfiguration) == null) {
            if (passBiometricConfiguration != null) {
                if (!TextUtils.isEmpty(passBiometricConfiguration.tpl) && !TextUtils.isEmpty(passBiometricConfiguration.appId) && !TextUtils.isEmpty(passBiometricConfiguration.appSignKey)) {
                    this.f9171a = passBiometricConfiguration;
                    ResUtils.setApplicationContext(passBiometricConfiguration.getApplication());
                    BeanConstants.tpl = passBiometricConfiguration.tpl;
                    BeanConstants.appid = passBiometricConfiguration.appId;
                    BeanConstants.appSignKey = passBiometricConfiguration.appSignKey;
                    a();
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
                if (((PassFaceOperation) passBiometricOperation).operationType != PassFaceOperation.OperationType.RECOGNIZE || c()) {
                    return;
                }
                b();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f9171a : (PassBiometricConfiguration) invokeV.objValue;
    }

    public PassFaceRecogCallback getPassFaceRecogCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f9172b : (PassFaceRecogCallback) invokeV.objValue;
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
        if (interceptable == null || interceptable.invokeLLL(65539, this, passFaceRecogCallback, passFaceRecogDTO, context) == null) {
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
            this.f9172b = passFaceRecogCallback;
            if (!e.a(context)) {
                passFaceRecogResult.setResultCode(-207);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SO_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            } else if (this.f9174d) {
                Intent intent = new Intent(context, PassLivenessRecogActivity.class);
                if (!(context instanceof Activity)) {
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                context.startActivity(intent);
            } else if (this.f9171a.isAgreeDangerousProtocol()) {
                FaceSDKManager faceSDKManager = FaceSDKManager.getInstance();
                Application application = this.f9171a.getApplication();
                PassBiometricConfiguration passBiometricConfiguration = this.f9171a;
                faceSDKManager.initialize(application, passBiometricConfiguration.licenseID, passBiometricConfiguration.licenseFileName, new b(this, context, passFaceRecogResult, passFaceRecogCallback));
            } else {
                passFaceRecogResult.setResultCode(-208);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_DANGEROUS_PROTOCOL_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            }
        }
    }

    private void a(PassFaceRecogDTO passFaceRecogDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, passFaceRecogDTO) == null) {
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
            com.baidu.pass.biometrics.face.liveness.a.a.b().a("request_data", passFaceRecogDTO);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("appid", this.f9171a.appId);
            httpHashMapWrap.put("tpl", this.f9171a.tpl);
            new HttpClientWrap(this.f9171a.getApplication()).get("https://wappass.bdimg.com/static/appsapi/appdistribute/android.txt", httpHashMapWrap, null, new c(this, true));
        }
    }
}
