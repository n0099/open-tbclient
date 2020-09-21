package com.baidu.fsg.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.o;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.view.LoadingDialog;
import com.baidu.sapi2.biometrics.liveness.R;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class LivenessVideoLoadingActivity extends LivenessBaseActivity {
    public static final String KEY_VIDEOGETPORTRAITMODEL = "VideoGetPortraitModel";
    public static final String TAG = "LivenessVideoLoadingActivity";
    private LoadingDialog a;

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.livenessRecogDTO != null) {
            setContentView(R.layout.layout_sapi_liveness_loading);
            a();
            c();
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity
    protected boolean isRequestedOrientation() {
        return false;
    }

    private void a() {
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
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

    private void b() {
        if (this.a != null) {
            if (!isFinishing() || !this.a.isShowing()) {
                this.a.dismiss();
                finish();
            }
        }
    }

    private void c() {
        o oVar = (o) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 9, TAG);
        oVar.setResponseCallback(this);
        oVar.execBean();
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        switch (i) {
            case 9:
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(this.livenessRecogDTO.spParams + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(d.J, 0, arrayList);
                }
                if (obj != null && (obj instanceof VideoGetPortraitModel)) {
                    VideoGetPortraitModel videoGetPortraitModel = (VideoGetPortraitModel) obj;
                    b();
                    if (this.livenessRecogDTO != null && this.livenessRecogDTO.showGuidePage) {
                        Intent intent = new Intent(this, LivenessVideoGuidActivity.class);
                        intent.putExtra(KEY_VIDEOGETPORTRAITMODEL, videoGetPortraitModel);
                        intent.setFlags(268435456);
                        startActivity(intent);
                        return;
                    }
                    b();
                    Intent intent2 = new Intent(this, LivenessVideoActivity.class);
                    intent2.putExtra(KEY_VIDEOGETPORTRAITMODEL, videoGetPortraitModel);
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                    return;
                }
                return;
            default:
                super.handleResponse(i, obj, str);
                return;
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        switch (i) {
            case 9:
                if (this.livenessRecogDTO != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.livenessRecogDTO.getSpno() + "");
                    arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
                    RimStatisticsUtil.onEventEndWithValues(d.e, i2, arrayList);
                }
                b();
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultCode(i2);
                livenessRecogResult.setResultMsg(str);
                SapiLivenessRecogManager.getInstance().getLivenessRecogCallback().b(livenessRecogResult);
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
                return;
            default:
                super.handleFailure(i, i2, str);
                return;
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(TAG);
    }
}
