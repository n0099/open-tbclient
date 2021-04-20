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
/* loaded from: classes2.dex */
public class ConstrastLoadingTipsView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f6071a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f6072b;

    /* renamed from: c  reason: collision with root package name */
    public b f6073c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6074d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f6075e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f6076f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f6077g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f6078h;
    public a i;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public class b extends CountDownTimer {
        public b(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ConstrastLoadingTipsView.this.f6071a.setVisibility(8);
            ConstrastLoadingTipsView.this.f6072b.setVisibility(0);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            TextView textView = ConstrastLoadingTipsView.this.f6071a;
            textView.setText((j / 1000) + "");
        }
    }

    public ConstrastLoadingTipsView(Context context) {
        super(context);
        a();
    }

    public void initData(UploadContrastPortraitModel uploadContrastPortraitModel) {
        UploadContrastPortraitModel.ConfirmBean confirmBean = uploadContrastPortraitModel.getConfirmBean();
        if (confirmBean.tips_sec == 0) {
            confirmBean.tips_sec = 5;
        }
        b bVar = new b((confirmBean.tips_sec * 1000) + 1000, 1000L);
        this.f6073c = bVar;
        bVar.start();
        if (!TextUtils.isEmpty(confirmBean.confirm_msg)) {
            this.f6074d.setText(confirmBean.confirm_msg);
        }
        if (!TextUtils.isEmpty(confirmBean.cancel_msg)) {
            this.f6075e.setText(confirmBean.cancel_msg);
        }
        TextView textView = this.f6071a;
        textView.setText(confirmBean.tips_sec + "");
        if (!uploadContrastPortraitModel.isContrastPass()) {
            this.f6076f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(confirmBean.tip_msg)) {
            this.f6078h.setText(confirmBean.tip_msg);
        }
        if (TextUtils.isEmpty(confirmBean.title_tips)) {
            return;
        }
        this.f6077g.setText(confirmBean.title_tips);
    }

    public void setOnClickListener(a aVar) {
        this.i = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.f6073c.start();
        }
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rim_face_result_tips_pages, this);
        this.f6071a = (TextView) findViewById(R.id.rim_face_result_tips_time_tv);
        this.f6072b = (LinearLayout) findViewById(R.id.rim_face_result_tips_btn_ll);
        this.f6074d = (TextView) findViewById(R.id.rim_face_result_tips_confirm);
        this.f6075e = (TextView) findViewById(R.id.rim_face_result_tips_cancel);
        this.f6076f = (ImageView) findViewById(R.id.rim_face_result_tips_pages_img);
        this.f6078h = (TextView) findViewById(R.id.rim_face_result_tips_pages_tips_msg);
        this.f6077g = (TextView) findViewById(R.id.rim_face_result_tips_pages_tips_title);
        this.f6071a.setVisibility(0);
        this.f6072b.setVisibility(8);
        this.f6074d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConstrastLoadingTipsView.this.i.a();
            }
        });
        this.f6075e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.ConstrastLoadingTipsView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConstrastLoadingTipsView.this.i.b();
            }
        });
    }

    public ConstrastLoadingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
