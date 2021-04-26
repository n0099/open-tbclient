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
    public ViewSwitcher f9591a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9592b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9593c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9594d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9595e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9596f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9597g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9598h;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9598h = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f9592b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
        this.f9591a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9593c = (TextView) findViewById(R.id.title_text);
        this.f9594d = (TextView) findViewById(R.id.msg_text);
        this.f9595e = (TextView) findViewById(R.id.positive_btn);
        this.f9596f = (TextView) findViewById(R.id.negative_btn);
        this.f9597g = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.f9593c.setText(str);
    }

    public void c(int i2) {
        this.f9593c.setVisibility(i2);
    }

    public void b(int i2) {
        this.f9594d.setVisibility(i2);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f9595e.setText(str);
        this.f9595e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f9597g.setText(str);
        this.f9597g.setOnClickListener(onClickListener);
    }

    public void a(int i2) {
        if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
            this.f9591a.setDisplayedChild(0);
        } else {
            this.f9591a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9594d.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f9596f.setText(str);
        this.f9596f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9592b.setBackgroundDrawable(this.f9598h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9593c.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
            this.f9594d.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9596f.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9595e.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.f9597g.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9596f.setBackgroundDrawable(this.f9598h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.f9595e.setBackgroundDrawable(this.f9598h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.f9597g.setBackgroundDrawable(this.f9598h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            return;
        }
        this.f9592b.setBackgroundDrawable(this.f9598h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9593c.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9594d.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9596f.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9597g.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9595e.setTextColor(this.f9598h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.f9596f.setBackgroundDrawable(this.f9598h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.f9595e.setBackgroundDrawable(this.f9598h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.f9597g.setBackgroundDrawable(this.f9598h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
    }
}
