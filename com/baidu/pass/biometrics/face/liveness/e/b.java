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
    public ViewSwitcher f9691a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9692b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9693c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9694d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9695e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9696f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9697g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9698h;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9698h = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f9692b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
        this.f9691a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9693c = (TextView) findViewById(R.id.title_text);
        this.f9694d = (TextView) findViewById(R.id.msg_text);
        this.f9695e = (TextView) findViewById(R.id.positive_btn);
        this.f9696f = (TextView) findViewById(R.id.negative_btn);
        this.f9697g = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.f9693c.setText(str);
    }

    public void c(int i) {
        this.f9693c.setVisibility(i);
    }

    public void b(int i) {
        this.f9694d.setVisibility(i);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f9695e.setText(str);
        this.f9695e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f9697g.setText(str);
        this.f9697g.setOnClickListener(onClickListener);
    }

    public void a(int i) {
        if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
            this.f9691a.setDisplayedChild(0);
        } else {
            this.f9691a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9694d.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f9696f.setText(str);
        this.f9696f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9692b.setBackgroundDrawable(this.f9698h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9693c.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
            this.f9694d.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9696f.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9695e.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.f9697g.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9696f.setBackgroundDrawable(this.f9698h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.f9695e.setBackgroundDrawable(this.f9698h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.f9697g.setBackgroundDrawable(this.f9698h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            return;
        }
        this.f9692b.setBackgroundDrawable(this.f9698h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9693c.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9694d.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9696f.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9697g.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9695e.setTextColor(this.f9698h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.f9696f.setBackgroundDrawable(this.f9698h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.f9695e.setBackgroundDrawable(this.f9698h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.f9697g.setBackgroundDrawable(this.f9698h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
    }
}
