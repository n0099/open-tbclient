package com.baidu.fsg.face.liveness.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.c.a;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class LivenessRecogGuidActivity extends LivenessBaseActivity {
    public static final String EXTRA_PARAM_SWITCH_RECORD_VIDEO = "extra_switch_record_video";

    /* renamed from: a  reason: collision with root package name */
    public Button f5828a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f5829b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f5830c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f5831d;

    /* renamed from: e  reason: collision with root package name */
    public LivenessRecogCallback f5832e;

    /* renamed from: f  reason: collision with root package name */
    public String f5833f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5834g = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f5832e != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultMsg(a.ERROR_MSG_USER_CANCEL);
            livenessRecogResult.setResultCode(-204);
            this.f5832e.b(livenessRecogResult);
        }
        LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
        RimStatisticsUtil.onEventWithValue(d.n, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
        LogUtil.d("hello", "onEvent(StatServiceEvent.CANCELLIVENESS):  用户取消");
        RimStatisticsUtil.getInstance().triggerSending();
        LogUtil.d("hello", "triggerSending:发送日志");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        startActivityForResult(new Intent(this, LivenessRecogActivity.class), 1001);
        System.gc();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001 && i3 == -1) {
            finish();
        }
    }

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
        b();
        if (!this.f5834g) {
            setContentView(R.layout.layout_sapi_liveness_guide_page);
        } else {
            setContentView(R.layout.layout_sapi_liveness_record_video_guide_page);
        }
        a();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            c();
            finish();
        }
        return super.onKeyUp(i2, keyEvent);
    }

    private void a() {
        Button button = (Button) findViewById(R.id.btn_start_photo);
        this.f5828a = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogGuidActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogDTO livenessRecogDTO = LivenessRecogGuidActivity.this.livenessRecogDTO;
                RimStatisticsUtil.onEventWithValue(d.f6031c, livenessRecogDTO != null ? livenessRecogDTO.getSpno() : "");
                LogUtil.d("hello", "onEvent(StatServiceEvent.ENTERLIVENESS):  用户点击立即验证");
                LivenessRecogGuidActivity.this.d();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.sapi_bio_title_btn_left);
        this.f5829b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessRecogGuidActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogGuidActivity.this.c();
                LivenessRecogGuidActivity.this.finish();
            }
        });
        this.f5830c = (TextView) findViewById(R.id.tv_name);
        this.f5833f = this.livenessRecogDTO.realName;
        this.f5831d = (ImageView) findViewById(R.id.guide_imageview);
        if (!TextUtils.isEmpty(this.f5833f)) {
            String format = String.format(getString(R.string.sapi_liveness_guide_photo_tip), this.f5833f);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.sapi_liveness_recog_guide_tip_color));
            if (format.indexOf("*") > 0) {
                spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf("*"), format.indexOf("*") + this.f5833f.length(), 33);
            } else {
                spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf(this.f5833f), format.indexOf(this.f5833f) + this.f5833f.length(), 33);
            }
            this.f5830c.setText(spannableStringBuilder);
        } else {
            this.f5830c.setText(String.format(getString(R.string.sapi_liveness_guide_photo_tip), ""));
        }
        this.f5831d.setImageBitmap(a(R.drawable.sapi_liveness_recognized_time_out_guide));
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
    }

    private void b() {
        this.f5832e = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        this.f5834g = c.a().a(getActivity()).getSwitchRecordVideo() && this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS;
    }

    private Bitmap a(int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i2, options);
        options.inSampleSize = 2;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(getResources(), i2, options);
    }
}
