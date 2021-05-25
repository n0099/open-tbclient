package com.baidu.pass.biometrics.face.liveness.e;

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
    public ViewSwitcher f9112a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9113b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9114c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9115d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9116e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9117f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9118g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9119h;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9119h = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f9113b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
        this.f9112a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9114c = (TextView) findViewById(R.id.title_text);
        this.f9115d = (TextView) findViewById(R.id.msg_text);
        this.f9116e = (TextView) findViewById(R.id.positive_btn);
        this.f9117f = (TextView) findViewById(R.id.negative_btn);
        this.f9118g = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.f9114c.setText(str);
    }

    public void c(int i2) {
        this.f9114c.setVisibility(i2);
    }

    public void b(int i2) {
        this.f9115d.setVisibility(i2);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f9116e.setText(str);
        this.f9116e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f9118g.setText(str);
        this.f9118g.setOnClickListener(onClickListener);
    }

    public void a(int i2) {
        if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
            this.f9112a.setDisplayedChild(0);
        } else {
            this.f9112a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9115d.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f9117f.setText(str);
        this.f9117f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9113b.setBackgroundDrawable(this.f9119h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9114c.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
            this.f9115d.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9117f.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9116e.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.f9118g.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9117f.setBackgroundDrawable(this.f9119h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.f9116e.setBackgroundDrawable(this.f9119h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.f9118g.setBackgroundDrawable(this.f9119h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            return;
        }
        this.f9113b.setBackgroundDrawable(this.f9119h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9114c.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9115d.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9117f.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9118g.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9116e.setTextColor(this.f9119h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.f9117f.setBackgroundDrawable(this.f9119h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.f9116e.setBackgroundDrawable(this.f9119h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.f9118g.setBackgroundDrawable(this.f9119h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
    }
}
