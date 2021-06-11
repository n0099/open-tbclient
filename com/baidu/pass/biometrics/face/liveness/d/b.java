package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.pass.biometrics.R;
/* loaded from: classes2.dex */
public class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public ViewSwitcher f9171a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9172b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9173c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9174d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9175e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9176f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9177g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9178h;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9178h = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f9172b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
        this.f9171a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9173c = (TextView) findViewById(R.id.title_text);
        this.f9174d = (TextView) findViewById(R.id.msg_text);
        this.f9175e = (TextView) findViewById(R.id.positive_btn);
        this.f9176f = (TextView) findViewById(R.id.negative_btn);
        this.f9177g = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.f9173c.setText(str);
    }

    public void c(int i2) {
        this.f9173c.setVisibility(i2);
    }

    public void b(int i2) {
        this.f9174d.setVisibility(i2);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f9175e.setText(str);
        this.f9175e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f9177g.setText(str);
        this.f9177g.setOnClickListener(onClickListener);
    }

    public void a(int i2) {
        if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
            this.f9171a.setDisplayedChild(0);
        } else {
            this.f9171a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9174d.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f9176f.setText(str);
        this.f9176f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9172b.setBackgroundDrawable(this.f9178h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9173c.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
            this.f9174d.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9176f.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9175e.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.f9177g.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9176f.setBackgroundDrawable(this.f9178h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.f9175e.setBackgroundDrawable(this.f9178h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.f9177g.setBackgroundDrawable(this.f9178h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            return;
        }
        this.f9172b.setBackgroundDrawable(this.f9178h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9173c.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9174d.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9176f.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9177g.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9175e.setTextColor(this.f9178h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.f9176f.setBackgroundDrawable(this.f9178h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.f9175e.setBackgroundDrawable(this.f9178h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.f9177g.setBackgroundDrawable(this.f9178h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
    }
}
