package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.fsg.face.liveness.datamodel.UploadContrastPortraitModel;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes16.dex */
public class ConstrastLoadingTipsView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1737a;
    private LinearLayout b;
    private b c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private a i;

    /* loaded from: classes16.dex */
    public interface a {
        void a();

        void b();
    }

    public ConstrastLoadingTipsView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rim_face_result_tips_pages, this);
        this.f1737a = (TextView) findViewById(R.id.rim_face_result_tips_time_tv);
        this.b = (LinearLayout) findViewById(R.id.rim_face_result_tips_btn_ll);
        this.d = (TextView) findViewById(R.id.rim_face_result_tips_confirm);
        this.e = (TextView) findViewById(R.id.rim_face_result_tips_cancel);
        this.f = (ImageView) findViewById(R.id.rim_face_result_tips_pages_img);
        this.h = (TextView) findViewById(R.id.rim_face_result_tips_pages_tips_msg);
        this.g = (TextView) findViewById(R.id.rim_face_result_tips_pages_tips_title);
        this.f1737a.setVisibility(0);
        this.b.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConstrastLoadingTipsView.this.i.a();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConstrastLoadingTipsView.this.i.b();
            }
        });
    }

    public void initData(UploadContrastPortraitModel uploadContrastPortraitModel) {
        UploadContrastPortraitModel.ConfirmBean confirmBean = uploadContrastPortraitModel.getConfirmBean();
        if (confirmBean.tips_sec == 0) {
            confirmBean.tips_sec = 5;
        }
        this.c = new b((confirmBean.tips_sec * 1000) + 1000, 1000L);
        this.c.start();
        if (!TextUtils.isEmpty(confirmBean.confirm_msg)) {
            this.d.setText(confirmBean.confirm_msg);
        }
        if (!TextUtils.isEmpty(confirmBean.cancel_msg)) {
            this.e.setText(confirmBean.cancel_msg);
        }
        this.f1737a.setText(confirmBean.tips_sec + "");
        if (!uploadContrastPortraitModel.isContrastPass()) {
            this.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(confirmBean.tip_msg)) {
            this.h.setText(confirmBean.tip_msg);
        }
        if (!TextUtils.isEmpty(confirmBean.title_tips)) {
            this.g.setText(confirmBean.title_tips);
        }
    }

    public ConstrastLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void setOnClickListener(a aVar) {
        this.i = aVar;
    }

    /* loaded from: classes16.dex */
    private class b extends CountDownTimer {
        public b(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            ConstrastLoadingTipsView.this.f1737a.setText((j / 1000) + "");
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ConstrastLoadingTipsView.this.f1737a.setVisibility(8);
            ConstrastLoadingTipsView.this.b.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.c.start();
        }
    }
}
