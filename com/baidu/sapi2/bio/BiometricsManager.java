package com.baidu.sapi2.bio;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
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
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.g;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BiometricsManager implements NoProguard {
    public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
    public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
    public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG = "faceDetect";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY = "outer";
    public static final String PASS_PRODUCT_ID = "pp";
    public static final String TAG = "BiometricsManager";

    /* renamed from: a  reason: collision with root package name */
    public static final String f11083a = "刷脸核验规则说明";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11084b = "scene:certlogin";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11085c = "scene:uncertlogin";

    /* renamed from: d  reason: collision with root package name */
    public static BiometricsManager f11086d;

    /* loaded from: classes2.dex */
    public class a extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f11087a;

        public a(PassFaceRecogCallback passFaceRecogCallback) {
            this.f11087a = passFaceRecogCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f11087a.onFailure(passFaceRecogResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            this.f11087a.onSuccess(passFaceRecogResult);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f11089a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11090b;

        public b(Activity activity, String str) {
            this.f11089a = activity;
            this.f11090b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            String explainCameraDeatilUrl = SapiAccountManager.getInstance().getAccountService().getExplainCameraDeatilUrl();
            CoreViewRouter.getInstance().loadRemoteProcessWebViewActivity(this.f11089a, BiometricsManager.f11083a, explainCameraDeatilUrl + "&notLogin=1");
            SapiStatUtil.statExplainCamera("seeDetail", this.f11090b);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassBiometric f11092a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassFaceOperation f11093b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f11094c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogDTO f11095d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f11096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11097f;

        public c(PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Activity activity, String str) {
            this.f11092a = passBiometric;
            this.f11093b = passFaceOperation;
            this.f11094c = passFaceRecogCallback;
            this.f11095d = passFaceRecogDTO;
            this.f11096e = activity;
            this.f11097f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BiometricsManager.this.a(this.f11092a, this.f11093b, this.f11094c, this.f11095d, this.f11096e);
            SapiContext.getInstance().setIsAlreadyShowExplainCamera(true);
            SapiStatUtil.statExplainCamera("agree", this.f11097f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f11099a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11100b;

        public d(PassFaceRecogCallback passFaceRecogCallback, String str) {
            this.f11099a = passFaceRecogCallback;
            this.f11100b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            this.f11099a.onFailure(passFaceRecogResult);
            SapiStatUtil.statExplainCamera("refuse", this.f11100b);
        }
    }

    /* loaded from: classes2.dex */
    public class e {
        public static final String p = "bduss";
        public static final String q = "certinfo";
        public static final String r = "authtoken";
        public static final String s = "faceDetect";
        public static final String t = "outer";

        /* renamed from: a  reason: collision with root package name */
        public String f11102a;

        /* renamed from: b  reason: collision with root package name */
        public int f11103b;

        /* renamed from: c  reason: collision with root package name */
        public int f11104c;

        /* renamed from: d  reason: collision with root package name */
        public String f11105d;

        /* renamed from: e  reason: collision with root package name */
        public int f11106e;

        /* renamed from: f  reason: collision with root package name */
        public String f11107f;

        /* renamed from: g  reason: collision with root package name */
        public String f11108g;

        /* renamed from: h  reason: collision with root package name */
        public String f11109h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public List<PassNameValuePair> n = new ArrayList();

        public e() {
        }
    }

    public static String buildSubPro(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = SchemeCollecter.CLASSIFY_EMPTY;
        }
        return "pp-pp-" + str + "-{tpl:" + SapiAccountManager.getInstance().getConfignation().tpl + ",scene:" + str2 + "}";
    }

    public static BiometricsManager getInstance() {
        if (f11086d == null) {
            f11086d = new BiometricsManager();
        }
        return f11086d;
    }

    public void livenessRecognize(Activity activity, PassFaceRecogType passFaceRecogType, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, PassFaceRecogCallback passFaceRecogCallback) {
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
        if (!TextUtils.isEmpty(str) && (str.contains(f11084b) || str.contains(f11085c))) {
            Log.e(TAG, "scene:certlogin and scene:uncertlogin");
        }
        if (a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, str)) {
            return;
        }
        a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
    }

    public void livenessRecognizeWithFaceLive(Activity activity, PassFaceRecogType passFaceRecogType, int i, PassFaceRecogCallback passFaceRecogCallback) {
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
        PassFaceOperation passFaceOperation = new PassFaceOperation();
        passFaceOperation.operationType = PassFaceOperation.OperationType.RECOGNIZE;
        passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, "pp");
        passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(activity));
        passFaceRecogDTO.livenessType = passFaceRecogType;
        passFaceRecogDTO.passProductId = "pp";
        passFaceRecogDTO.quality = i;
        if (a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, "pp")) {
            return;
        }
        a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
    }

    public void recogWithAuthToken(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_AUTHTOKEN, str, map, str2, "", "", str3, "", "", "", "", passFaceRecogCallback);
    }

    public void recogWithBduss(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_BDUSS, str, map, str2, str3, str4, "", "", "", "", "", passFaceRecogCallback);
    }

    public void recogWithCertInfo(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_CERTINFO, str, map, str2, "", "", "", "", str3, str4, str5, passFaceRecogCallback);
    }

    public void recogWithFaceDetect(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        HashMap hashMap = map == null ? new HashMap() : map;
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("authsid", str4);
        }
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_FACEDETECT, str, hashMap, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
    }

    public void recogWithFaceLive(Activity activity, int i, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognizeWithFaceLive(activity, PassFaceRecogType.RECOG_TYPE_FACEIMAGE, i, passFaceRecogCallback);
    }

    public void recogWithFaceOuter(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(g.J);
        if (!TextUtils.isEmpty(deviceInfo)) {
            passFaceRecogDTO.di = deviceInfo;
        }
        passBiometric.execute(passFaceOperation, new a(passFaceRecogCallback), passFaceRecogDTO, context);
    }

    private boolean a(Activity activity, PassFaceRecogCallback passFaceRecogCallback, PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogDTO passFaceRecogDTO, String str) {
        boolean z = false;
        if (SapiUtils.checkRequestPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE, activity) || SapiContext.getInstance().getIsAlreadyShowExplainCamera()) {
            return false;
        }
        String string = activity.getResources().getString(d.b.a0.a.g.sapi_sdk_explain_camera_content);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new b(activity, str), 89, string.length(), 33);
        new CommonDialog.Builder(activity).setDarkMode((SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) ? true : true).setTitle(activity.getResources().getString(d.b.a0.a.g.sapi_sdk_explain_camera_title)).setMessage(spannableStringBuilder).setNegativeButton(activity.getResources().getString(d.b.a0.a.g.sapi_sdk_explain_camera_defuse), new d(passFaceRecogCallback, str)).setPositiveBtn(activity.getResources().getString(d.b.a0.a.g.sapi_sdk_explain_camera_agree), new c(passBiometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity, str)).build().show();
        return true;
    }
}
