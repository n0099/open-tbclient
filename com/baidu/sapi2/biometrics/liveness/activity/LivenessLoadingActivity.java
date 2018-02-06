package com.baidu.sapi2.biometrics.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.biometrics.base.d.d;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.biometrics.liveness.SapiLivenessRecogManager;
import com.baidu.sapi2.biometrics.liveness.beans.b;
import com.baidu.sapi2.biometrics.liveness.beans.e;
import com.baidu.sapi2.biometrics.liveness.beans.g;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
import com.baidu.sapi2.biometrics.liveness.f;
import com.baidu.sapi2.biometrics.liveness.result.LivenessRecogResult;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessRecogType;
import com.baidu.sapi2.biometrics.liveness.view.LoadingDialog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessLoadingActivity extends LivenessBaseActivity {
    public static final String CLOSE_LOADING_ACTION = "com.baidu.sapi2.biometrics.liveness.close.loading";
    public static final String TAG = "LivenessLoadingActivity";
    private LoadingDialog a;
    private g b;
    private e c;
    private LivenessRecogDTO d;
    private boolean e;

    @Override // com.baidu.sapi2.biometrics.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.livenessRecogDTO != null) {
            setContentView(R.layout.layout_sapi_liveness_loading);
            b();
            a();
            if (this.d == null) {
                finish();
            }
            if (this.d.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                this.b.execBean();
                RimStatisticsUtil.onEventStart(f.b);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态开始  ");
                return;
            }
            RimStatisticsUtil.onEventStart(f.d);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
            this.c.execBean();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
    @Override // com.baidu.sapi2.biometrics.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResponse(int i, Object obj, String str) {
        int optInt;
        switch (i) {
            case 1:
                RimStatisticsUtil.onEventEnd(f.b, 0);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  0");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        optInt = new JSONObject(str).optInt("reviewing");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.e = optInt == 1;
                    if (!this.e) {
                        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                        livenessRecogResult.setResultCode(LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING);
                        livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_VIDEO_IS_REVIEWING);
                        SapiLivenessRecogManager.getInstance().getLivenessRecogCallback().b(livenessRecogResult);
                        c();
                        RimStatisticsUtil.getInstance().triggerSending();
                        LogUtil.d("hello", "triggerSending():  发送日志");
                        return;
                    }
                    RimStatisticsUtil.onEventStart(f.d);
                    this.c = new e(this);
                    this.c.setResponseCallback(this);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
                    this.c.execBean();
                    return;
                }
                optInt = 0;
                this.e = optInt == 1;
                if (!this.e) {
                }
            case 2:
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(f.d, 0, arrayList);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  0");
                }
                if (this.d.showGuidePage) {
                    if (this.d.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS && !TextUtils.isEmpty(str)) {
                        try {
                            this.livenessRecogDTO.realName = new JSONObject(str).optString("display_name");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    c();
                    Intent intent = new Intent(this, LivenessRecogGuidActivity.class);
                    intent.setFlags(268435456);
                    startActivity(intent);
                    return;
                }
                c();
                Intent intent2 = new Intent(this, LivenessRecogActivity.class);
                intent2.setFlags(268435456);
                startActivity(intent2);
                return;
            default:
                super.handleResponse(i, obj, str);
                return;
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        switch (i) {
            case 1:
                c();
                RimStatisticsUtil.onEventEnd(f.b, i2);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  " + i2);
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i2);
                livenessRecogResult.setResultMsg(str);
                SapiLivenessRecogManager.getInstance().getLivenessRecogCallback().b(livenessRecogResult);
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
                return;
            case 2:
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(f.d, i2, arrayList);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  " + i2 + str);
                }
                c();
                LivenessRecogResult livenessRecogResult2 = new LivenessRecogResult();
                livenessRecogResult2.setResultCode(i2);
                livenessRecogResult2.setResultMsg(str);
                SapiLivenessRecogManager.getInstance().getLivenessRecogCallback().b(livenessRecogResult2);
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
                return;
            default:
                super.handleFailure(i, i2, str);
                return;
        }
    }

    private void a() {
        this.b = new g(this);
        this.b.setResponseCallback(this);
        this.c = new e(this);
        this.c.setResponseCallback(this);
        this.d = (LivenessRecogDTO) b.a().a(b.a);
    }

    private void b() {
        d.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
        a(this);
    }

    private void a(Context context) {
        if (this.a == null) {
            this.a = new LoadingDialog(context);
            this.a.setMessage(context.getString(R.string.sapi_liveness_recog_loading));
            this.a.setCancelable(false);
        }
        if (!((Activity) context).isFinishing() && this.a != null && !this.a.isShowing()) {
            this.a.show();
        }
    }

    private void c() {
        if (this.a != null) {
            if (!isFinishing() || !this.a.isShowing()) {
                this.a.dismiss();
                finish();
            }
        }
    }
}
