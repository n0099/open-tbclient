package com.baidu.pass.biometrics.face.liveness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
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
import com.baidu.pass.biometrics.base.utils.SoUtils;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PassFaceRecogManager implements PassBiometric {

    /* renamed from: d  reason: collision with root package name */
    public static final long f9599d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static PassFaceRecogManager f9600e;

    /* renamed from: a  reason: collision with root package name */
    public PassBiometricConfiguration f9601a;

    /* renamed from: b  reason: collision with root package name */
    public PassFaceRecogCallback f9602b;

    /* renamed from: c  reason: collision with root package name */
    public long f9603c;

    /* loaded from: classes2.dex */
    public class a extends HttpHandlerWrap {
        public a(boolean z) {
            super(z);
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            LocalConfigOptions.getInstance(PassFaceRecogManager.this.f9601a.getApplication()).setBioOptions(LocalConfigOptions.getInstance(PassFaceRecogManager.this.f9601a.getApplication()).getBioOptions());
        }

        @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                LocalConfigOptions.getInstance(PassFaceRecogManager.this.f9601a.getApplication()).setBioOptions(SdkConfigOptions.fromOnLineJSON(new JSONObject(str)));
            } catch (JSONException e2) {
                onFailure(e2, e2.hashCode(), str);
            }
        }
    }

    private void b() {
        this.f9603c = System.currentTimeMillis();
    }

    private boolean c() {
        return System.currentTimeMillis() - this.f9603c < 300;
    }

    public static synchronized PassFaceRecogManager getInstance() {
        PassFaceRecogManager passFaceRecogManager;
        synchronized (PassFaceRecogManager.class) {
            if (f9600e == null) {
                f9600e = new PassFaceRecogManager();
            }
            passFaceRecogManager = f9600e;
        }
        return passFaceRecogManager;
    }

    public void cleanPassFaceRecogCallback() {
        this.f9602b = null;
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void config(PassBiometricConfiguration passBiometricConfiguration) {
        if (passBiometricConfiguration != null) {
            if (!TextUtils.isEmpty(passBiometricConfiguration.tpl) && !TextUtils.isEmpty(passBiometricConfiguration.appId) && !TextUtils.isEmpty(passBiometricConfiguration.appSignKey)) {
                this.f9601a = passBiometricConfiguration;
                ResUtils.setApplicationContext(passBiometricConfiguration.getApplication());
                BeanConstants.tpl = passBiometricConfiguration.tpl;
                BeanConstants.appid = passBiometricConfiguration.appId;
                BeanConstants.appSignKey = passBiometricConfiguration.appSignKey;
                a();
                SoUtils.load(passBiometricConfiguration.getApplication());
                return;
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        }
        throw new IllegalArgumentException("PassBiometricConfiguration can't be null");
    }

    @Override // com.baidu.pass.biometrics.base.PassBiometric
    public void execute(PassBiometricOperation passBiometricOperation, PassBiometricCallback passBiometricCallback, PassBiometricDto passBiometricDto, Context context) {
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

    public PassBiometricConfiguration getConfiguration() {
        return this.f9601a;
    }

    public PassFaceRecogCallback getPassFaceRecogCallback() {
        return this.f9602b;
    }

    private void a(PassFaceRecogCallback passFaceRecogCallback, PassFaceRecogDTO passFaceRecogDTO, Context context) {
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
        this.f9602b = passFaceRecogCallback;
        Intent intent = new Intent(context, PassLivenessRecogActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
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
        com.baidu.pass.biometrics.face.liveness.a.a.b().a("request_data", passFaceRecogDTO);
    }

    private void a() {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("appid", this.f9601a.appId);
        httpHashMapWrap.put("tpl", this.f9601a.tpl);
        new HttpClientWrap(this.f9601a.getApplication()).get("https://wappass.bdimg.com/static/appsapi/appdistribute/android.txt", httpHashMapWrap, null, new a(true));
    }
}
