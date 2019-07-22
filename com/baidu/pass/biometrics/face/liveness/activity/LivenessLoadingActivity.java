package com.baidu.pass.biometrics.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.R;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.LoadingDialog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessLoadingActivity extends LivenessBaseActivity {
    public static final String CLOSE_LOADING_ACTION = "com.baidu.sapi2.biometrics.liveness.close.loading";
    public static final String TAG = "LivenessLoadingActivity";
    private static final String TYPE_AUTHTOKEN = "authtoken";
    private static final String TYPE_BDUSS = "bduss";
    private static final String TYPE_CERTINFO = "certinfo";
    private static final String TYPE_OUTER = "outer";
    private LivenessStat livenessStat = new LivenessStat();
    private LoadingDialog processDialog;
    private PassFaceRecogDTO requestBean;

    @Override // com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity, com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.livenessStat.timePointStart = System.currentTimeMillis();
        if (this.passFaceRecogDTO == null) {
            failFinish();
            return;
        }
        setContentView(R.layout.layout_pass_liveness_loading);
        initViews();
        initData();
        if (this.requestBean == null) {
            failFinish();
        } else {
            getPortrait();
        }
    }

    private void initData() {
        this.requestBean = (PassFaceRecogDTO) BeanDataCache.getInstance().getCacheData(BeanDataCache.KEY);
    }

    private void getPortrait() {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) BeanDataCache.getInstance().getCacheData(BeanDataCache.KEY);
        if (passFaceRecogDTO != null) {
            httpHashMapWrap.put("processid", passFaceRecogDTO.processid);
            if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
                httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc()));
                httpHashMapWrap.put("type", "bduss");
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
                httpHashMapWrap.put("type", "certinfo");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", passFaceRecogDTO.realName);
                    jSONObject.put("cert", passFaceRecogDTO.idCardNum);
                    httpHashMapWrap.put("certinfo", PassBioDataEncryptor.encryptParams(jSONObject.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                httpHashMapWrap.put("authtoken", passFaceRecogDTO.authToken);
                httpHashMapWrap.put("type", "authtoken");
            } else if (passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_OUTER) {
                httpHashMapWrap.put("exuid", passFaceRecogDTO.exUid);
                httpHashMapWrap.put("type", "outer");
            }
            httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
            String nonce = HttpClientWrap.getNonce(this, passFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
            if (!TextUtils.isEmpty(nonce)) {
                httpHashMapWrap.put("nonce", nonce);
            }
            httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        }
        new HttpClientWrap(this).post(getPortraitUrl(), httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessLoadingActivity.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                LivenessLoadingActivity.this.closeLoading();
                Intent intent = new Intent(LivenessLoadingActivity.this, LivenessRecogActivity.class);
                intent.setFlags(268435456);
                intent.putExtra(LivenessRecogActivity.EXTRA_TIME_POINT_START, LivenessLoadingActivity.this.livenessStat.timePointStart);
                LivenessLoadingActivity.this.startActivity(intent);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                LivenessLoadingActivity.this.closeLoading();
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-206);
                PassFaceRecogCallback passFaceRecogCallback = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
                if (passFaceRecogCallback != null) {
                    passFaceRecogCallback.onFailure(passFaceRecogResult);
                }
                LivenessLoadingActivity.this.livenessStat.asyncGetPortraitType = 0;
                LivenessLoadingActivity.this.onStat(passFaceRecogResult.getResultCode());
            }
        });
    }

    public String getAtbc() {
        StringBuilder sb = new StringBuilder();
        PassFaceRecogDTO passFaceRecogDTO = (PassFaceRecogDTO) BeanDataCache.getInstance().getCacheData(BeanDataCache.KEY);
        if (passFaceRecogDTO != null) {
            sb.append("bduss=" + passFaceRecogDTO.bduss);
            sb.append(";stoken=" + passFaceRecogDTO.stoken);
        }
        return sb.toString();
    }

    public String getPortraitUrl() {
        return this.configuration.passDomain + PassBioEnv.GET_ASYNC_SERVER_GET_PORTRAIT;
    }

    private void initViews() {
        PassBioDisplayUtil.enableStatusBarTint(this, getResources().getColor(R.color.pass_bio_liveness_guide_bg_color));
        showLoading(this);
    }

    private void showLoading(Context context) {
        if (this.processDialog == null) {
            this.processDialog = new LoadingDialog(context);
            this.processDialog.setMessage(context.getString(R.string.pass_liveness_recog_loading));
            this.processDialog.setCancelable(false);
        }
        if ((context instanceof Activity) && !((Activity) context).isFinishing() && this.processDialog != null && !this.processDialog.isShowing()) {
            this.processDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeLoading() {
        if (this.processDialog != null) {
            if (!isFinishing() || !this.processDialog.isShowing()) {
                this.processDialog.dismiss();
                finish();
            }
        }
    }

    private void failFinish() {
        PassFaceRecogCallback passFaceRecogCallback = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-205);
            passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
            passFaceRecogCallback.onFailure(passFaceRecogResult);
        }
        onStat(-205);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStat(int i) {
        this.livenessStat.timePointEnd = System.currentTimeMillis();
        this.livenessStat.errCode = i;
        this.livenessStat.recogType = this.passFaceRecogDTO != null ? this.passFaceRecogDTO.livenessType.getRecogTypeName() : "unknown_type";
        this.livenessStat.onStat(this);
    }
}
