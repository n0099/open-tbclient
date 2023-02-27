package com.baidu.pass.biometrics.face.liveness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricOperation;
import com.baidu.pass.biometrics.base.callback.PassBiometricCallback;
import com.baidu.pass.biometrics.base.debug.Log;
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
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.face.api.FaceApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PassFaceRecogManager implements PassBiometric {
    public static final long e = 300;
    public static PassFaceRecogManager f = null;
    public static final int g = 30000;
    public static final float h = 0.6f;
    public static final int i = 40;
    public static final int j = 220;
    public static final float k = 0.8f;
    public static final int l = 20;
    public static final int m = 200;
    public static final float n = 0.6f;
    public static final float o = 0.7f;
    public static final int p = 3;
    public static final float q = 1.0f;
    public static final float r = 0.3f;
    public static final int s = 1126;
    public static final int t = 0;
    public static final boolean u = false;
    public static final boolean v = false;
    public PassBiometricConfiguration a;
    public boolean b;
    public PassFaceRecogCallback c;
    public long d;

    /* loaded from: classes2.dex */
    public class a implements IInitCallback {
        public final /* synthetic */ Context a;
        public final /* synthetic */ PassFaceRecogResult b;
        public final /* synthetic */ PassFaceRecogCallback c;

        public a(Context context, PassFaceRecogResult passFaceRecogResult, PassFaceRecogCallback passFaceRecogCallback) {
            this.a = context;
            this.b = passFaceRecogResult;
            this.c = passFaceRecogCallback;
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initFailure(int i, String str) {
            if (i == -1) {
                this.b.setResultCode(PassBiometricResult.ERROR_CODE_LACK_SO_ERROR);
                this.b.setResultMsg(PassBiometricResult.ERROR_MSG_LACK_SO_ERROR);
            } else {
                this.b.setResultCode(PassBiometricResult.ERROR_CODE_SYSTEM_VERSION_LOW_ERROR);
                this.b.setResultMsg(PassBiometricResult.ERROR_MSG_SYSTEM_VERSION_LOW_ERROR);
            }
            this.c.onFailure(this.b);
        }

        @Override // com.baidu.pass.face.platform.listener.IInitCallback
        public void initSuccess() {
            PassFaceRecogManager.this.b = true;
            Intent intent = new Intent(this.a, PassLivenessRecogActivity.class);
            if (!(this.a instanceof Activity)) {
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            this.a.startActivity(intent);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpHandlerWrap {
        public b(boolean z) {
            super(z);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                LocalConfigOptions.getInstance(PassFaceRecogManager.this.a.getApplication()).setBioOptions(SdkConfigOptions.fromOnLineJSON(new JSONObject(str)));
            } catch (JSONException e) {
                onFailure(e, e.hashCode(), str);
            }
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            LocalConfigOptions.getInstance(PassFaceRecogManager.this.a.getApplication()).setBioOptions(LocalConfigOptions.getInstance(PassFaceRecogManager.this.a.getApplication()).getBioOptions());
        }
    }

    private void b() {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("appid", this.a.appId);
        httpHashMapWrap.put("tpl", this.a.tpl);
        new HttpClientWrap(this.a.getApplication()).get("https://wappass.bdimg.com/static/appsapi/appdistribute/android.txt", httpHashMapWrap, null, new b(true));
    }

    private Map<String, String> c() {
        Map<String, String> map;
        PassBiometricConfiguration passBiometricConfiguration = this.a;
        if (passBiometricConfiguration != null && (map = passBiometricConfiguration.faceResPaths) != null) {
            return map;
        }
        return a();
    }

    private void d() {
        this.d = System.currentTimeMillis();
    }

    private boolean e() {
        if (System.currentTimeMillis() - this.d < 300) {
            return true;
        }
        return false;
    }

    public static synchronized PassFaceRecogManager getInstance() {
        PassFaceRecogManager passFaceRecogManager;
        synchronized (PassFaceRecogManager.class) {
            if (f == null) {
                f = new PassFaceRecogManager();
            }
            passFaceRecogManager = f;
        }
        return passFaceRecogManager;
    }

    public void cleanPassFaceRecogCallback() {
        this.c = null;
    }

    public PassBiometricConfiguration getConfiguration() {
        return this.a;
    }

    public PassFaceRecogCallback getPassFaceRecogCallback() {
        return this.c;
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void setAgreeDangerousProtocol(boolean z) {
        PassBiometricConfiguration configuration = getConfiguration();
        if (configuration != null) {
            configuration.setAgreeDangerousProtocol(z);
        }
    }

    private Map<String, String> a() {
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

    private boolean f() {
        try {
            d.a();
            FaceConfig faceConfig = new FaceConfig();
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
            ArrayList arrayList = new ArrayList();
            arrayList.add(LivenessTypeEnum.Eye);
            arrayList.add(LivenessTypeEnum.Mouth);
            arrayList.add(LivenessTypeEnum.HeadLeft);
            arrayList.add(LivenessTypeEnum.HeadRight);
            faceConfig.setLivenessTypeList(arrayList);
            faceConfig.setLivenessRandom(false);
            faceConfig.setSound(false);
            faceConfig.setTimeDetectModule(30000L);
            faceConfig.setCacheImageNum(3);
            faceConfig.setFaceFarRatio(0.3f);
            faceConfig.setFaceClosedRatio(1.0f);
            faceConfig.setResPaths(c());
            faceConfig.setIsCompressImage(true);
            faceConfig.setCompressValue(s);
            faceConfig.setOutputImageType(0);
            FaceSDKManager.getInstance().setFaceConfig(faceConfig);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void a(PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
        try {
            if (passFaceRecogDTO == null) {
                passFaceRecogResult.setResultCode(-205);
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                    return;
                }
                return;
            }
            if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
                if (TextUtils.isEmpty(passFaceRecogDTO.bduss) || TextUtils.isEmpty(passFaceRecogDTO.stoken)) {
                    passFaceRecogResult.setResultCode(101);
                    passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NO_LOGIN);
                    if (passFaceRecogCallback != null) {
                        passFaceRecogCallback.onFailure(passFaceRecogResult);
                        return;
                    }
                    return;
                }
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                if (TextUtils.isEmpty(passFaceRecogDTO.authToken)) {
                    passFaceRecogResult.setResultCode(-205);
                    if (passFaceRecogCallback != null) {
                        passFaceRecogCallback.onFailure(passFaceRecogResult);
                        return;
                    }
                    return;
                }
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
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
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_OUTER && TextUtils.isEmpty(passFaceRecogDTO.exUid)) {
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
            } else if (!f()) {
                passFaceRecogResult.setResultCode(PassBiometricResult.ERROR_CODE_CONFIG_ERROR);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_CONFIG_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            } else if (this.b) {
                Intent intent = new Intent(context, PassLivenessRecogActivity.class);
                if (!(context instanceof Activity)) {
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } else if (this.a == null) {
                passFaceRecogResult.setResultCode(PassBiometricResult.ERROR_CODE_NOT_INIT_PASS_SDK);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NOT_INIT_PASS_SDK);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            } else if (!this.a.isAgreeDangerousProtocol()) {
                passFaceRecogResult.setResultCode(-208);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_DANGEROUS_PROTOCOL_ERROR);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            } else {
                try {
                    if (!F.getInstance().cp(context)) {
                        FH.setAgreePolicy(context, this.a.isAgreeDangerousProtocol());
                    }
                } catch (Exception e2) {
                    Log.e(e2.getMessage(), new Object[0]);
                }
                FaceSDKManager.getInstance().initialize(this.a.getApplication(), this.a.licenseID, this.a.licenseFileName, new a(context, passFaceRecogResult, passFaceRecogCallback));
            }
        } catch (NoClassDefFoundError unused) {
            passFaceRecogResult.setResultCode(PassBiometricResult.ERROR_CODE_NOT_IMPORT_VIS_SDK);
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_NOT_IMPORT_VIS_SDK);
            passFaceRecogCallback.onFailure(passFaceRecogResult);
        }
    }

    private void a(PassFaceRecogDTO passFaceRecogDTO) {
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

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void config(PassBiometricConfiguration passBiometricConfiguration) {
        if (passBiometricConfiguration != null) {
            if (!TextUtils.isEmpty(passBiometricConfiguration.tpl) && !TextUtils.isEmpty(passBiometricConfiguration.appId) && !TextUtils.isEmpty(passBiometricConfiguration.appSignKey)) {
                this.a = passBiometricConfiguration;
                FaceApi.setFaceLicenseId("pass_auth_id_01");
                ResUtils.setApplicationContext(passBiometricConfiguration.getApplication());
                BeanConstants.tpl = passBiometricConfiguration.tpl;
                BeanConstants.appid = passBiometricConfiguration.appId;
                BeanConstants.appSignKey = passBiometricConfiguration.appSignKey;
                b();
                return;
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        }
        throw new IllegalArgumentException("PassBiometricConfiguration can't be null");
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
        if (passBiometricCallback != null) {
            if (passBiometricOperation != null) {
                if (passBiometricDto != null) {
                    if (((PassFaceOperation) passBiometricOperation).operationType != PassFaceOperation.OperationType.RECOGNIZE || e()) {
                        return;
                    }
                    d();
                    PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) passBiometricDto;
                    a(passFaceRecogDTO);
                    a((PassFaceRecogCallback) passBiometricCallback, passFaceRecogDTO, context);
                    return;
                }
                throw new IllegalArgumentException(PassBiometricDto.class.getSimpleName() + " can't be null");
            }
            throw new IllegalArgumentException(PassBiometricOperation.class.getSimpleName() + " can't be null");
        }
        throw new IllegalArgumentException(PassBiometricCallback.class.getSimpleName() + " can't be null");
    }
}
