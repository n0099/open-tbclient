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
    public ViewSwitcher f9690a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9691b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9692c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9693d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9694e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9695f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9696g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9697h;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9697h = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f9691b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
        this.f9690a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9692c = (TextView) findViewById(R.id.title_text);
        this.f9693d = (TextView) findViewById(R.id.msg_text);
        this.f9694e = (TextView) findViewById(R.id.positive_btn);
        this.f9695f = (TextView) findViewById(R.id.negative_btn);
        this.f9696g = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.f9692c.setText(str);
    }

    public void c(int i) {
        this.f9692c.setVisibility(i);
    }

    public void b(int i) {
        this.f9693d.setVisibility(i);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f9694e.setText(str);
        this.f9694e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f9696g.setText(str);
        this.f9696g.setOnClickListener(onClickListener);
    }

    public void a(int i) {
        if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
            this.f9690a.setDisplayedChild(0);
        } else {
            this.f9690a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9693d.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f9695f.setText(str);
        this.f9695f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9691b.setBackgroundDrawable(this.f9697h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9692c.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
            this.f9693d.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9695f.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9694e.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.f9696g.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9695f.setBackgroundDrawable(this.f9697h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.f9694e.setBackgroundDrawable(this.f9697h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.f9696g.setBackgroundDrawable(this.f9697h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            return;
        }
        this.f9691b.setBackgroundDrawable(this.f9697h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9692c.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9693d.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9695f.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9696g.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9694e.setTextColor(this.f9697h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.f9695f.setBackgroundDrawable(this.f9697h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.f9694e.setBackgroundDrawable(this.f9697h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.f9696g.setBackgroundDrawable(this.f9697h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
    }
}
