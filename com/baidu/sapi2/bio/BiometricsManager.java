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
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.a0.a.g;
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
    public static final String f9764a = "刷脸核验规则说明";

    /* renamed from: b  reason: collision with root package name */
    public static final String f9765b = "scene:certlogin";

    /* renamed from: c  reason: collision with root package name */
    public static final String f9766c = "scene:uncertlogin";

    /* renamed from: d  reason: collision with root package name */
    public static BiometricsManager f9767d;

    /* loaded from: classes2.dex */
    public class a extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f9768a;

        public a(PassFaceRecogCallback passFaceRecogCallback) {
            this.f9768a = passFaceRecogCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f9768a.onFailure(passFaceRecogResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            this.f9768a.onSuccess(passFaceRecogResult);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f9770a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9771b;

        public b(Activity activity, String str) {
            this.f9770a = activity;
            this.f9771b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            String explainCameraDeatilUrl = SapiAccountManager.getInstance().getAccountService().getExplainCameraDeatilUrl();
            CoreViewRouter.getInstance().loadRemoteProcessWebViewActivity(this.f9770a, BiometricsManager.f9764a, explainCameraDeatilUrl + "&notLogin=1");
            SapiStatUtil.statExplainCamera("seeDetail", this.f9771b);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassBiometric f9773a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PassFaceOperation f9774b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f9775c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogDTO f9776d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9778f;

        public c(PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Activity activity, String str) {
            this.f9773a = passBiometric;
            this.f9774b = passFaceOperation;
            this.f9775c = passFaceRecogCallback;
            this.f9776d = passFaceRecogDTO;
            this.f9777e = activity;
            this.f9778f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BiometricsManager.this.a(this.f9773a, this.f9774b, this.f9775c, this.f9776d, this.f9777e);
            SapiContext.getInstance().setIsAlreadyShowExplainCamera(true);
            SapiStatUtil.statExplainCamera("agree", this.f9778f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassFaceRecogCallback f9780a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9781b;

        public d(PassFaceRecogCallback passFaceRecogCallback, String str) {
            this.f9780a = passFaceRecogCallback;
            this.f9781b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            this.f9780a.onFailure(passFaceRecogResult);
            SapiStatUtil.statExplainCamera("refuse", this.f9781b);
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
        public String f9783a;

        /* renamed from: b  reason: collision with root package name */
        public int f9784b;

        /* renamed from: c  reason: collision with root package name */
        public int f9785c;

        /* renamed from: d  reason: collision with root package name */
        public String f9786d;

        /* renamed from: e  reason: collision with root package name */
        public int f9787e;

        /* renamed from: f  reason: collision with root package name */
        public String f9788f;

        /* renamed from: g  reason: collision with root package name */
        public String f9789g;

        /* renamed from: h  reason: collision with root package name */
        public String f9790h;

        /* renamed from: i  reason: collision with root package name */
        public String f9791i;
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
            str = "empty";
        }
        return "pp-pp-" + str + "-{tpl:" + SapiAccountManager.getInstance().getConfignation().tpl + ",scene:" + str2 + "}";
    }

    public static BiometricsManager getInstance() {
        if (f9767d == null) {
            f9767d = new BiometricsManager();
        }
        return f9767d;
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
        if (!TextUtils.isEmpty(str) && (str.contains(f9765b) || str.contains(f9766c))) {
            Log.e(TAG, "scene:certlogin and scene:uncertlogin");
        }
        if (a(activity, passFaceRecogCallback, biometric, passFaceOperation, passFaceRecogDTO, str)) {
            return;
        }
        a(biometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity);
    }

    public void livenessRecognizeWithFaceLive(Activity activity, PassFaceRecogType passFaceRecogType, int i2, PassFaceRecogCallback passFaceRecogCallback) {
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

    public void recogWithFaceLive(Activity activity, int i2, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognizeWithFaceLive(activity, PassFaceRecogType.RECOG_TYPE_FACEIMAGE, i2, passFaceRecogCallback);
    }

    public void recogWithFaceOuter(Activity activity, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(activity, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PassBiometric passBiometric, PassFaceOperation passFaceOperation, PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.FACE_CERT);
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
        String string = activity.getResources().getString(g.sapi_sdk_explain_camera_content);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new b(activity, str), 89, string.length(), 33);
        new CommonDialog.Builder(activity).setDarkMode((SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) ? true : true).setTitle(activity.getResources().getString(g.sapi_sdk_explain_camera_title)).setMessage(spannableStringBuilder).setNegativeButton(activity.getResources().getString(g.sapi_sdk_explain_camera_defuse), new d(passFaceRecogCallback, str)).setPositiveBtn(activity.getResources().getString(g.sapi_sdk_explain_camera_agree), new c(passBiometric, passFaceOperation, passFaceRecogCallback, passFaceRecogDTO, activity, str)).build().show();
        return true;
    }
}
