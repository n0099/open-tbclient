package com.baidu.pass.biometrics.face.liveness.e;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.pass.biometrics.R;
import com.baidu.pass.utils.CommonViewUtility;
/* loaded from: classes2.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public Context f9241a;

    /* renamed from: b  reason: collision with root package name */
    public ViewSwitcher f9242b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f9243c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9244d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9245e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9246f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9247g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9248h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;

    public a(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9241a = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.f9242b = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9244d = (TextView) findViewById(R.id.dialog_title);
        this.f9245e = (TextView) findViewById(R.id.dialog_msg);
        this.f9246f = (TextView) findViewById(R.id.msg_text);
        this.f9247g = (TextView) findViewById(R.id.pass_bio_dialog_time_left);
        this.f9248h = (TextView) findViewById(R.id.pass_bio_dialog_time_center);
        this.i = (TextView) findViewById(R.id.pass_bio_dialog_time_right);
        this.j = (TextView) findViewById(R.id.positive_btn);
        this.k = (TextView) findViewById(R.id.negative_btn);
        this.l = (TextView) findViewById(R.id.neutral_btn);
        this.m = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
        this.f9243c = (LinearLayout) findViewById(R.id.pass_bio_dialog_ll_content);
        CommonViewUtility.setViewClickAlpha(this.j, 0.2f);
        CommonViewUtility.setViewClickAlpha(this.k, 0.2f);
        CommonViewUtility.setViewClickAlpha(this.l, 0.2f);
    }

    public void b(String str) {
        this.f9244d.setText(str);
    }

    public void c(String str) {
        this.f9245e.setVisibility(0);
        this.f9245e.setText(str);
    }

    public void b(boolean z) {
        if (z) {
            this.f9244d.setVisibility(0);
        } else {
            this.f9244d.setVisibility(8);
        }
    }

    public void c(int i) {
        this.m.setVisibility(0);
    }

    public void b(int i) {
        this.f9246f.setText(i);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.j.setText(str);
        this.j.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.l.setText(str);
        this.l.setOnClickListener(onClickListener);
    }

    public void a(int i) {
        if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
            this.f9242b.setDisplayedChild(0);
        } else {
            this.f9242b.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9246f.setVisibility(0);
        this.f9246f.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.k.setText(str);
        this.k.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9243c.setBackgroundDrawable(this.f9241a.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9244d.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f9245e.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9246f.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
            this.f9247g.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
            this.f9248h.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
            this.i.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
            this.k.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.j.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.l.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.k.setBackgroundDrawable(this.f9241a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.j.setBackgroundDrawable(this.f9241a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.l.setBackgroundDrawable(this.f9241a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            return;
        }
        this.f9243c.setBackgroundDrawable(this.f9241a.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9244d.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9245e.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9246f.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
        this.f9247g.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
        this.f9248h.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
        this.i.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
        this.k.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.j.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.l.setTextColor(this.f9241a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.k.setBackgroundDrawable(this.f9241a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.j.setBackgroundDrawable(this.f9241a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.l.setBackgroundDrawable(this.f9241a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
    }
}
