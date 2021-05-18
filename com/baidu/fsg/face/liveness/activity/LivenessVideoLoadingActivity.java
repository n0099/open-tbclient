package com.baidu.fsg.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.FaceSDKBeansFactory;
import com.baidu.fsg.face.liveness.beans.o;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.view.LoadingDialog;
import com.baidu.sapi2.biometrics.liveness.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LivenessVideoLoadingActivity extends LivenessBaseActivity {
    public static final String KEY_VIDEOGETPORTRAITMODEL = "VideoGetPortraitModel";
    public static final String TAG = "LivenessVideoLoadingActivity";

    /* renamed from: a  reason: collision with root package name */
    public LoadingDialog f5919a;

    private void a() {
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
        a(this);
    }

    private void b() {
        if (this.f5919a != null) {
            if (isFinishing() && this.f5919a.isShowing()) {
                return;
            }
            this.f5919a.dismiss();
            finish();
        }
    }

    private void c() {
        o oVar = (o) FaceSDKBeansFactory.getInstance().getBean(getActivity(), 9, TAG);
        oVar.setResponseCallback(this);
        oVar.execBean();
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 != 9) {
            super.handleFailure(i2, i3, str);
            return;
        }
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventEndWithValues(d.f6033e, i3, arrayList);
        }
        b();
        LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
        livenessRecogResult.setResultCode(i3);
        livenessRecogResult.setResultMsg(str);
        SapiLivenessRecogManager.getInstance().getLivenessRecogCallback().b(livenessRecogResult);
        RimStatisticsUtil.getInstance().triggerSending();
        LogUtil.d("hello", "triggerSending():  发送日志");
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        if (i2 != 9) {
            super.handleResponse(i2, obj, str);
            return;
        }
        if (this.livenessRecogDTO != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.livenessRecogDTO.getSpno() + "");
            arrayList.add(this.livenessRecogDTO.spParams + "");
            arrayList.add(TextUtils.isEmpty(this.livenessRecogDTO.processid) ? "" : this.livenessRecogDTO.processid);
            RimStatisticsUtil.onEventEndWithValues(d.J, 0, arrayList);
        }
        if (obj == null || !(obj instanceof VideoGetPortraitModel)) {
            return;
        }
        VideoGetPortraitModel videoGetPortraitModel = (VideoGetPortraitModel) obj;
        b();
        LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
        if (livenessRecogDTO != null && livenessRecogDTO.showGuidePage) {
            Intent intent = new Intent(this, LivenessVideoGuidActivity.class);
            intent.putExtra(KEY_VIDEOGETPORTRAITMODEL, videoGetPortraitModel);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            startActivity(intent);
            return;
        }
        b();
        Intent intent2 = new Intent(this, LivenessVideoActivity.class);
        intent2.putExtra(KEY_VIDEOGETPORTRAITMODEL, videoGetPortraitModel);
        intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        startActivity(intent2);
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity
    public boolean isRequestedOrientation() {
        return false;
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.livenessRecogDTO == null) {
            return;
        }
        setContentView(R.layout.layout_sapi_liveness_loading);
        a();
        c();
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(TAG);
    }

    private void a(Context context) {
        LoadingDialog loadingDialog;
        if (this.f5919a == null) {
            LoadingDialog loadingDialog2 = new LoadingDialog(context);
            this.f5919a = loadingDialog2;
            loadingDialog2.setMessage(context.getString(R.string.sapi_liveness_recog_loading));
            this.f5919a.setCancelable(false);
        }
        if (((Activity) context).isFinishing() || (loadingDialog = this.f5919a) == null || loadingDialog.isShowing()) {
            return;
        }
        this.f5919a.show();
    }
}
