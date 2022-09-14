package com.baidu.sapi2.bio;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
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
    public static final String a = "刷脸核验规则说明";
    public static final String b = "scene:certlogin";
    public static final String c = "scene:uncertlogin";
    public static BiometricsManager d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a extends PassFaceRecogCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassFaceRecogCallback a;
        public final /* synthetic */ BiometricsManager b;

        public a(BiometricsManager biometricsManager, PassFaceRecogCallback passFaceRecogCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager, passFaceRecogCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = biometricsManager;
            this.a = passFaceRecogCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, passFaceRecogResult) == null) {
                this.a.onFailure(passFaceRecogResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                this.a.onSuccess(passFaceRecogResult);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ BiometricsManager d;

        public b(BiometricsManager biometricsManager, boolean z, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager, Boolean.valueOf(z), activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = biometricsManager;
            this.a = z;
            this.b = activity;
            this.c = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            SapiAccountManager sapiAccountManager;
            SapiAccountService accountService;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sapiAccountManager = SapiAccountManager.getInstance()) == null || (accountService = sapiAccountManager.getAccountService()) == null) {
                return;
            }
            String str = accountService.getExplainCameraDeatilUrl() + "&notLogin=1";
            if (sapiAccountManager.getConfignation() == null) {
                return;
            }
            if (this.a) {
                Log.e("eeeee", "当前进程");
                CoreViewRouter.getInstance().loadCurrentProcessWebviewActivity(this.b, BiometricsManager.a, str);
            } else {
                Log.e("eeeee", "独立进程");
                CoreViewRouter.getInstance().loadRemoteProcessWebViewActivity(this.b, BiometricsManager.a, str);
            }
            SapiStatUtil.statExplainCamera("seeDetail", this.c);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassBiometric a;
        public final /* synthetic */ PassFaceOperation b;
        public final /* synthetic */ PassFaceRecogCallback c;
        public final /* synthetic */ PassFaceRecogDTO d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ BiometricsManager g;

        public c(BiometricsManager biometricsManager, PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager, passBiometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = biometricsManager;
            this.a = passBiometric;
            this.b = passFaceOperation;
            this.c = passFaceRecogCallback;
            this.d = passFaceRecogDTO;
            this.e = activity;
            this.f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.g.a(this.a, this.b, this.c, this.d, this.e);
                SapiContext.getInstance().setIsAlreadyShowExplainCamera(true);
                SapiStatUtil.statExplainCamera("agree", this.f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassFaceRecogCallback a;
        public final /* synthetic */ String b;
        public final /* synthetic */ BiometricsManager c;

        public d(BiometricsManager biometricsManager, PassFaceRecogCallback passFaceRecogCallback, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biometricsManager, passFaceRecogCallback, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = biometricsManager;
            this.a = passFaceRecogCallback;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                this.a.onFailure(passFaceRecogResult);
                SapiStatUtil.statExplainCamera("refuse", this.b);
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
        public String a;
        public int b;
        public int c;
        public String d;
        public int e;
        public String f;
        public String g;
        public String h;
        public String i;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String buildSubPro(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = SchemeCollecter.CLASSIFY_EMPTY;
            }
            return "pp-pp-" + str + "-{tpl:" + SapiAccountManager.getInstance().getConfignation().tpl + ",scene:" + str2 + "}";
        }
        return (String) invokeLL.objValue;
    }

    public static BiometricsManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (d == null) {
                d = new BiometricsManager();
            }
            return d;
        }
        return (BiometricsManager) invokeV.objValue;
    }

    public void livenessRecognize(Activity activity, PassFaceRecogType passFaceRecogType, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, passFaceRecogType, str, map, str2, str3, str4, str5, str6, str7, str8, str9, Boolean.valueOf(z), Boolean.valueOf(z2), passFaceRecogCallback}) == null) {
            livenessRecognize(activity, passFaceRecogType, str, map, str2, str3, str4, str5, str6, str7, str8, str9, z, z2, null, passFaceRecogCallback);
        }
    }

    public void livenessRecognizeWithFaceLive(Activity activity, PassFaceRecogType passFaceRecogType, int i, boolean z, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, passFaceRecogType, Integer.valueOf(i), Boolean.valueOf(z), passFaceRecogCallback}) == null) {
            PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
            PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
            PassFaceOperation passFaceOperation = new PassFaceOperation();
            passFaceOperation.operationType = PassFaceOperation.OperationType.RECOGNIZE;
            passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, "pp");
            passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(activity));
            passFaceRecogDTO.livenessType = passFaceRecogType;
            passFaceRecogDTO.passProductId = "pp";
            passFaceRecogDTO.quality = i;
            if (a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, "pp", z)) {
                return;
            }
            a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
        }
    }

    public void recogWithAuthToken(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, str, map, str2, str3, passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_AUTHTOKEN, str, map, str2, "", "", str3, "", "", "", "", false, false, passFaceRecogCallback);
        }
    }

    public void recogWithBduss(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, str, map, str2, str3, str4, passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_BDUSS, str, map, str2, str3, str4, "", "", "", "", "", false, false, passFaceRecogCallback);
        }
    }

    public void recogWithCertInfo(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, boolean z, String str5, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{activity, str, map, str2, str3, str4, Boolean.valueOf(z), str5, passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_CERTINFO, str, map, str2, "", "", "", "", str3, str4, str5, z, false, passFaceRecogCallback);
        }
    }

    public void recogWithFaceDetect(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{activity, str, map, str2, str3, str4, passFaceRecogCallback}) == null) {
            HashMap hashMap = map == null ? new HashMap() : map;
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("authsid", str4);
            }
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_FACEDETECT, str, hashMap, str2, "", "", "", str3, "", "", "", false, false, passFaceRecogCallback);
        }
    }

    public void recogWithFaceLive(Activity activity, int i, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, activity, i, passFaceRecogCallback) == null) {
            livenessRecognizeWithFaceLive(activity, PassFaceRecogType.RECOG_TYPE_FACEIMAGE, i, false, passFaceRecogCallback);
        }
    }

    public void recogWithFaceOuter(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{activity, str, map, str2, str3, passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", false, false, passFaceRecogCallback);
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

    public void livenessRecognize(Activity activity, PassFaceRecogType passFaceRecogType, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, Bundle bundle, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, passFaceRecogType, str, map, str2, str3, str4, str5, str6, str7, str8, str9, Boolean.valueOf(z), Boolean.valueOf(z2), bundle, passFaceRecogCallback}) == null) {
            PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
            PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
            PassFaceOperation passFaceOperation = new PassFaceOperation();
            passFaceOperation.operationType = PassFaceOperation.OperationType.RECOGNIZE;
            passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, str);
            passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(activity));
            passFaceRecogDTO.imageFlag = str2;
            passFaceRecogDTO.needAuthorizeCertInfo = z;
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
            passFaceRecogDTO.extraParams = bundle;
            if (!TextUtils.isEmpty(str) && (str.contains(b) || str.contains(c))) {
                Log.e(TAG, "scene:certlogin and scene:uncertlogin");
            }
            if (a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, str, z2)) {
                return;
            }
            a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
        }
    }

    public void recogWithBduss(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, boolean z, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{activity, str, map, str2, str3, str4, Boolean.valueOf(z), passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_BDUSS, str, map, str2, str3, str4, "", "", "", "", "", false, z, passFaceRecogCallback);
        }
    }

    public void recogWithFaceOuter(Activity activity, String str, Map<String, String> map, String str2, String str3, boolean z, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{activity, str, map, str2, str3, Boolean.valueOf(z), passFaceRecogCallback}) == null) {
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", false, z, passFaceRecogCallback);
        }
    }

    public void recogWithFaceDetect(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, boolean z, PassFaceRecogCallback passFaceRecogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, str, map, str2, str3, str4, Boolean.valueOf(z), passFaceRecogCallback}) == null) {
            HashMap hashMap = map == null ? new HashMap() : map;
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("authsid", str4);
            }
            livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_FACEDETECT, str, hashMap, str2, "", "", "", str3, "", "", "", false, z, passFaceRecogCallback);
        }
    }

    private boolean a(Activity activity, PassFaceRecogCallback passFaceRecogCallback, PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogDTO passFaceRecogDTO, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{activity, passFaceRecogCallback, passBiometric, passFaceOperation, passFaceRecogDTO, str, Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            if (SapiUtils.checkRequestPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE, activity) || SapiContext.getInstance().getIsAlreadyShowExplainCamera()) {
                return false;
            }
            if (activity == null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
                return true;
            } else if (!activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
                String string = activity.getResources().getString(R.string.obfuscated_res_0x7f0f107c);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                spannableStringBuilder.setSpan(new b(this, z, activity, str), 89, string.length(), 33);
                new CommonDialog.Builder(activity).setDarkMode((SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) ? true : true).setTitle(activity.getResources().getString(R.string.obfuscated_res_0x7f0f107e)).setMessage(spannableStringBuilder).setNegativeButton(activity.getResources().getString(R.string.obfuscated_res_0x7f0f107d), new d(this, passFaceRecogCallback, str)).setPositiveBtn(activity.getResources().getString(R.string.obfuscated_res_0x7f0f107b), new c(this, passBiometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity, str)).build().show();
                return true;
            } else {
                PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
                passFaceRecogResult2.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                passFaceRecogCallback.onFailure(passFaceRecogResult2);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }
}
