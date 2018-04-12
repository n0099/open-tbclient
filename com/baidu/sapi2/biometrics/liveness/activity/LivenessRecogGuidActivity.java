package com.baidu.sapi2.biometrics.liveness.activity;

import android.content.Context;
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
import com.baidu.fsg.biometrics.base.c.a;
import com.baidu.fsg.biometrics.base.d.d;
import com.baidu.fsg.biometrics.base.d.g;
import com.baidu.fsg.biometrics.base.d.h;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.biometrics.liveness.SapiLivenessRecogManager;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.biometrics.liveness.beans.b;
import com.baidu.sapi2.biometrics.liveness.callback.LivenessRecogCallback;
import com.baidu.sapi2.biometrics.liveness.f;
import com.baidu.sapi2.biometrics.liveness.result.LivenessRecogResult;
import com.baidu.sapi2.biometrics.liveness.utils.SapiStatService;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessRecogType;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessSerializableMap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class LivenessRecogGuidActivity extends LivenessBaseActivity {
    public static final String EXTRA_PARAM_SWITCH_RECORD_VIDEO = "extra_switch_record_video";
    private Button a;
    private ImageView b;
    private TextView c;
    private ImageView d;
    private LivenessRecogCallback e;
    private String f = null;
    private boolean g = false;
    private Map<String, String> h = new HashMap();

    @Override // com.baidu.sapi2.biometrics.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.livenessRecogDTO != null) {
            b();
            if (!this.g) {
                setContentView(R.layout.layout_sapi_liveness_guide_page);
            } else {
                setContentView(R.layout.layout_sapi_liveness_record_video_guide_page);
            }
            a();
        }
    }

    private void a() {
        this.a = (Button) findViewById(R.id.btn_start_photo);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogGuidActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RimStatisticsUtil.onEvent(f.c);
                LogUtil.d("hello", "onEvent(StatServiceEvent.ENTERLIVENESS):  用户点击立即验证");
                LivenessRecogGuidActivity.this.d();
            }
        });
        this.b = (ImageView) findViewById(R.id.sapi_bio_title_btn_left);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogGuidActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                LivenessRecogGuidActivity.this.c();
                LivenessRecogGuidActivity.this.finish();
            }
        });
        this.c = (TextView) findViewById(R.id.tv_name);
        this.f = this.livenessRecogDTO.realName;
        this.d = (ImageView) findViewById(R.id.guide_imageview);
        if (!TextUtils.isEmpty(this.f)) {
            String format = String.format(getString(R.string.sapi_liveness_guide_photo_tip), this.f);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.sapi_liveness_recog_guide_tip_color));
            if (format.indexOf("*") > 0) {
                spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf("*"), format.indexOf("*") + this.f.length(), 33);
            } else {
                spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf(this.f), format.indexOf(this.f) + this.f.length(), 33);
            }
            this.c.setText(spannableStringBuilder);
        } else {
            this.c.setText(String.format(getString(R.string.sapi_liveness_guide_photo_tip), ""));
        }
        this.d.setImageBitmap(a(R.drawable.sapi_liveness_recognized_time_out_guide));
        d.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
    }

    private Bitmap a(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i, options);
        options.inSampleSize = 2;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(getResources(), i, options);
    }

    private void b() {
        this.e = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        this.g = b.a().a(getActivity()).getSwitchRecordVideo() && this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultMsg(a.ERROR_MSG_USER_CANCEL);
            livenessRecogResult.setResultCode(-204);
            this.e.b(livenessRecogResult);
        }
        RimStatisticsUtil.onEvent(f.m);
        LogUtil.d("hello", "onEvent(StatServiceEvent.CANCELLIVENESS):  用户取消");
        RimStatisticsUtil.getInstance().triggerSending();
        LogUtil.d("hello", "triggerSending:发送日志");
        a((Context) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        startActivityForResult(new Intent(this, LivenessRecogActivity.class), 1001);
        System.gc();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            if (i2 == -1) {
                finish();
            } else if (intent != null) {
                this.h = ((LivenessSerializableMap) intent.getExtras().getSerializable(LivenessRecogActivity.f.L)).getMap();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c();
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    private void a(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(LivenessRecogActivity.f.t, "1");
        hashMap.put("liveness_guide_cancel", "1");
        hashMap.put(LivenessRecogActivity.f.i, "-204");
        hashMap.put("uid", str);
        if (this.livenessRecogDTO != null) {
            hashMap.put(LivenessRecogActivity.f.D, this.livenessRecogDTO.processid);
        }
        hashMap.put(LivenessRecogActivity.f.E, str2);
        hashMap.put(LivenessRecogActivity.f.p, "0");
        hashMap.put(LivenessRecogActivity.f.o, "0");
        hashMap.put("tpl", "frfsd_ai");
        hashMap.put(LivenessRecogActivity.f.G, h.f(context));
        hashMap.put(LivenessRecogActivity.f.H, h.b());
        hashMap.put(LivenessRecogActivity.f.I, h.a());
        hashMap.put(LivenessRecogActivity.f.J, g.a(context));
        SapiStatService.onEvent(LivenessRecogActivity.f.K, hashMap, context);
    }

    private void a(Context context) {
        if (this.h != null && this.h.size() > 0) {
            this.h.put("liveness_guide_cancel", "1");
            SapiStatService.onEvent(LivenessRecogActivity.f.K, this.h, context);
        } else if (this.livenessRecogDTO != null) {
            a(context, this.livenessRecogDTO.uid, this.livenessRecogDTO.getSpno());
        }
    }
}
