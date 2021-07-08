package com.baidu.sapi2.bio;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.b0.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BiometricsManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
    public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
    public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG = "faceDetect";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY = "outer";
    public static final String PASS_PRODUCT_ID = "pp";
    public static final String TAG = "BiometricsManager";

    /* renamed from: a  reason: collision with root package name */
    public static final String f9936a = "刷脸核验规则说明";

    /* renamed from: b  reason: collision with root package name */
    public static final String f9937b = "scene:certlogin";

    /* renamed from: c  reason: collision with root package name */
    public static final String f9938c = "scene:uncertlogin";

    /* renamed from: d  reason: collision with root package name */
    public static BiometricsManager f9939d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f9940a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BiometricsManager f9941b;

        public a(BiometricsManager biometricsManager, PassFaceRecogCallback passFaceRecogCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager, passFaceRecogCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9941b = biometricsManager;
            this.f9940a = passFaceRecogCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.f9940a.onFailure(passFaceRecogResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                this.f9940a.onSuccess(passFaceRecogResult);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f9942a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9943b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BiometricsManager f9944c;

        public b(BiometricsManager biometricsManager, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9944c = biometricsManager;
            this.f9942a = activity;
            this.f9943b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String explainCameraDeatilUrl = SapiAccountManager.getInstance().getAccountService().getExplainCameraDeatilUrl();
                CoreViewRouter.getInstance().loadRemoteProcessWebViewActivity(this.f9942a, BiometricsManager.f9936a, explainCameraDeatilUrl + "&notLogin=1");
                SapiStatUtil.statExplainCamera("seeDetail", this.f9943b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassBiometric f9945a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassFaceOperation f9946b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f9947c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogDTO f9948d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9949e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9950f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BiometricsManager f9951g;

        public c(BiometricsManager biometricsManager, PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager, passBiometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9951g = biometricsManager;
            this.f9945a = passBiometric;
            this.f9946b = passFaceOperation;
            this.f9947c = passFaceRecogCallback;
            this.f9948d = passFaceRecogDTO;
            this.f9949e = activity;
            this.f9950f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f9951g.a(this.f9945a, this.f9946b, this.f9947c, this.f9948d, this.f9949e);
                SapiContext.getInstance().setIsAlreadyShowExplainCamera(true);
                SapiStatUtil.statExplainCamera("agree", this.f9950f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f9952a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9953b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BiometricsManager f9954c;

        public d(BiometricsManager biometricsManager, PassFaceRecogCallback passFaceRecogCallback, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager, passFaceRecogCallback, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9954c = biometricsManager;
            this.f9952a = passFaceRecogCallback;
            this.f9953b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-307);
                this.f9952a.onFailure(passFaceRecogResult);
                SapiStatUtil.statExplainCamera("refuse", this.f9953b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String p = "bduss";
        public static final String q = "certinfo";
        public static final String r = "authtoken";
        public static final String s = "faceDetect";
        public static final String t = "outer";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f9955a;

        /* renamed from: b  reason: collision with root package name */
        public int f9956b;

        /* renamed from: c  reason: collision with root package name */
        public int f9957c;

        /* renamed from: d  reason: collision with root package name */
        public String f9958d;

        /* renamed from: e  reason: collision with root package name */
        public int f9959e;

        /* renamed from: f  reason: collision with root package name */
        public String f9960f;

        /* renamed from: g  reason: collision with root package name */
        public String f9961g;

        /* renamed from: h  reason: collision with root package name */
        public String f9962h;

        /* renamed from: i  reason: collision with root package name */
        public String f9963i;
        public String j;
        public String k;
        public String l;
        public String m;
        public List<PassNameValuePair> n;
        public final /* synthetic */ BiometricsManager o;

        public e(BiometricsManager biometricsManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = biometricsManager;
            this.n = new ArrayList();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1984747234, "Lcom/baidu/sapi2/bio/BiometricsManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1984747234, "Lcom/baidu/sapi2/bio/BiometricsManager;");
        }
    }

    public BiometricsManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String buildSubPro(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "empty";
            }
            return "pp-pp-" + str + "-{tpl:" + SapiAccountManager.getInstance().getConfignation().tpl + ",scene:" + str2 + "}";
        }
        return (String) invokeLL.objValue;
    }

    public static BiometricsManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f9939d == null) {
                f9939d = new BiometricsManager();
            }
            return f9939d;
        }
        return (BiometricsManager) invokeV.objValue;
    }

    public void livenessRecognize(Activity activity, PassFaceRecogType passFaceRecogType, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, passFaceRecogType, str, map, str2, str3, str4, str5, str6, str7, str8, str9, passFaceRecogCallback}) == null) {
            PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
            PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
            PassFaceOperation passFaceOperation = new PassFaceOperation();
            passFaceOperation.operationType = PassFaceOperation.OperationType.RECOGNIZE;
            passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, str);
            passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(activity));
            passFaceRecogDTO.imageFlag = str2;
            if (map != null) {
                passFaceRecogDTO.extraParamsMap.putAll(map);
            }
            passFaceRecogDTO.livenessType = passFaceRecogType;
            if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
                passFaceRecogDTO.realName = str7;
                passFaceRecogDTO.idCardNum = str8;
                passFaceRecogDTO.phoneNum = str9;
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
                SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str3);
                if (accountFromBduss != null) {
                    passFaceRecogDTO.bduss = accountFromBduss.bduss;
                    passFaceRecogDTO.uid = accountFromBduss.uid;
                    passFaceRecogDTO.stoken = str4;
                }
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                passFaceRecogDTO.authToken = str5;
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
                passFaceRecogDTO.exUid = str6;
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER) {
                passFaceRecogDTO.exUid = str6;
            }
            passFaceRecogDTO.passProductId = str;
            if (!TextUtils.isEmpty(str) && (str.contains(f9937b) || str.contains(f9938c))) {
                Log.e(TAG, "scene:certlogin and scene:uncertlogin");
            }
            if (a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, str)) {
                return;
            }
            a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
        }
    }

    public void livenessRecognizeWithFaceLive(Activity activity, PassFaceRecogType passFaceRecogType, int i2, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, passFaceRecogType, i2, passFaceRecogCallback) == null) {
            PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
            PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
            PassFaceOperation passFaceOperation = new PassFaceOperation();
            passFaceOperation.operationType = PassFaceOperation.OperationType.RECOGNIZE;
            passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, "pp");
            passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(activity));
            passFaceRecogDTO.livenessType = passFaceRecogType;
            passFaceRecogDTO.passProductId = "pp";
            passFaceRecogDTO.quality = i2;
            if (a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, "pp")) {
                return;
            }
            a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
        }
    }

    public void recogWithAuthToken(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, map, str2, str3, passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_AUTHTOKEN, str, map, str2, "", "", str3, "", "", "", "", passFaceRecogCallback);
        }
    }

    public void recogWithBduss(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, str, map, str2, str3, str4, passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_BDUSS, str, map, str2, str3, str4, "", "", "", "", "", passFaceRecogCallback);
        }
    }

    public void recogWithCertInfo(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, str, map, str2, str3, str4, str5, passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_CERTINFO, str, map, str2, "", "", "", "", str3, str4, str5, passFaceRecogCallback);
        }
    }

    public void recogWithFaceDetect(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{activity, str, map, str2, str3, str4, passFaceRecogCallback}) == null) {
            HashMap hashMap = map == null ? new HashMap() : map;
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("authsid", str4);
            }
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_FACEDETECT, str, hashMap, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
        }
    }

    public void recogWithFaceLive(Activity activity, int i2, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, activity, i2, passFaceRecogCallback) == null) {
            livenessRecognizeWithFaceLive(activity, PassFaceRecogType.RECOG_TYPE_FACEIMAGE, i2, passFaceRecogCallback);
        }
    }

    public void recogWithFaceOuter(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{activity, str, map, str2, str3, passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, this, passBiometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, context) == null) {
            String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.FACE_CERT);
            if (!TextUtils.isEmpty(deviceInfo)) {
                passFaceRecogDTO.di = deviceInfo;
            }
            passBiometric.execute(passFaceOperation, new a(this, passFaceRecogCallback), passFaceRecogDTO, context);
        }
    }

    private boolean a(Activity activity, PassFaceRecogCallback passFaceRecogCallback, PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogDTO passFaceRecogDTO, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{activity, passFaceRecogCallback, passBiometric, passFaceOperation, passFaceRecogDTO, str})) == null) {
            boolean z = false;
            if (SapiUtils.checkRequestPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE, activity) || SapiContext.getInstance().getIsAlreadyShowExplainCamera()) {
                return false;
            }
            String string = activity.getResources().getString(g.sapi_sdk_explain_camera_content);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new b(this, activity, str), 89, string.length(), 33);
            new CommonDialog.Builder(activity).setDarkMode((SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) ? true : true).setTitle(activity.getResources().getString(g.sapi_sdk_explain_camera_title)).setMessage(spannableStringBuilder).setNegativeButton(activity.getResources().getString(g.sapi_sdk_explain_camera_defuse), new d(this, passFaceRecogCallback, str)).setPositiveBtn(activity.getResources().getString(g.sapi_sdk_explain_camera_agree), new c(this, passBiometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity, str)).build().show();
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
