package com.baidu.fsg.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.c.a;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.beans.g;
import com.baidu.fsg.face.liveness.beans.i;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.fsg.face.liveness.view.LoadingDialog;
import com.baidu.sapi2.biometrics.liveness.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LivenessLoadingActivity extends LivenessBaseActivity {
    public static final String CLOSE_LOADING_ACTION = "com.baidu.sapi2.biometrics.liveness.close.loading";
    public static final String TAG = "LivenessLoadingActivity";

    /* renamed from: a  reason: collision with root package name */
    private LoadingDialog f1648a;
    private i b;
    private g c;
    private LivenessRecogDTO d;
    private boolean e;

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.livenessRecogDTO == null) {
            LivenessRecogCallback livenessRecogCallback = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            if (livenessRecogCallback != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(-206);
                livenessRecogResult.setResultMsg(a.ERROR_MSG_SERVER_ERROR);
                livenessRecogCallback.b(livenessRecogResult);
            }
            finish();
            return;
        }
        setContentView(R.layout.layout_sapi_liveness_loading);
        b();
        a();
        if (this.d == null) {
            finish();
        }
        if (this.d.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
            this.b.execBean();
            RimStatisticsUtil.onEventStart(d.b);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态开始  ");
            return;
        }
        RimStatisticsUtil.onEventStart(d.e);
        LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
        this.c.execBean();
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity
    protected boolean isRequestedOrientation() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResponse(int i, Object obj, String str) {
        int optInt;
        switch (i) {
            case 1:
                RimStatisticsUtil.onEventEndWithValue(d.b, 0, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  0");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        optInt = new JSONObject(str).optInt("reviewing");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.e = optInt != 1;
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
                    RimStatisticsUtil.onEventStart(d.e);
                    this.c = new g(this);
                    this.c.setResponseCallback(this);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
                    this.c.execBean();
                    return;
                }
                optInt = 0;
                this.e = optInt != 1;
                if (!this.e) {
                }
            case 2:
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(d.e, 0, arrayList);
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
                RimStatisticsUtil.onEventEndWithValue(d.b, i2, this.livenessRecogDTO != null ? this.livenessRecogDTO.getSpno() : "");
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
                    RimStatisticsUtil.onEventEndWithValues(d.e, i2, arrayList);
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
        this.b = new i(this);
        this.b.setResponseCallback(this);
        this.c = new g(this);
        this.c.setResponseCallback(this);
        this.d = (LivenessRecogDTO) c.a().a("request_data");
    }

    private void b() {
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
        a(this);
    }

    private void a(Context context) {
        if (this.f1648a == null) {
            this.f1648a = new LoadingDialog(context);
            this.f1648a.setMessage(context.getString(R.string.sapi_liveness_recog_loading));
            this.f1648a.setCancelable(false);
        }
        if ((context instanceof Activity) && isUseable((Activity) context) && !this.f1648a.isShowing()) {
            this.f1648a.show();
        }
    }

    private void c() {
        if (isUseable(this) && this.f1648a.isShowing()) {
            this.f1648a.dismiss();
            finish();
        }
    }

    public boolean isUseable(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isRestricted()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                if (activity.isDestroyed()) {
                    return false;
                }
            } catch (Error e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }
}
