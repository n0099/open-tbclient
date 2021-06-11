package com.baidu.pass.biometrics.face.liveness.d;

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
    public Context f9162a;

    /* renamed from: b  reason: collision with root package name */
    public ViewSwitcher f9163b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f9164c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9165d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9166e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9167f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9168g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9169h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f9170i;
    public TextView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;

    public a(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9162a = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.f9163b = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9165d = (TextView) findViewById(R.id.dialog_title);
        this.f9166e = (TextView) findViewById(R.id.dialog_msg);
        this.f9167f = (TextView) findViewById(R.id.msg_text);
        this.f9168g = (TextView) findViewById(R.id.pass_bio_dialog_time_left);
        this.f9169h = (TextView) findViewById(R.id.pass_bio_dialog_time_center);
        this.f9170i = (TextView) findViewById(R.id.pass_bio_dialog_time_right);
        this.j = (TextView) findViewById(R.id.positive_btn);
        this.k = (TextView) findViewById(R.id.negative_btn);
        this.l = (TextView) findViewById(R.id.neutral_btn);
        this.m = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
        this.f9164c = (LinearLayout) findViewById(R.id.pass_bio_dialog_ll_content);
        CommonViewUtility.setViewClickAlpha(this.j, 0.2f);
        CommonViewUtility.setViewClickAlpha(this.k, 0.2f);
        CommonViewUtility.setViewClickAlpha(this.l, 0.2f);
    }

    public void b(String str) {
        this.f9165d.setText(str);
    }

    public void c(String str) {
        this.f9166e.setVisibility(0);
        this.f9166e.setText(str);
    }

    public void b(boolean z) {
        if (z) {
            this.f9165d.setVisibility(0);
        } else {
            this.f9165d.setVisibility(8);
        }
    }

    public void c(int i2) {
        this.m.setVisibility(0);
    }

    public void b(int i2) {
        this.f9167f.setText(i2);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.j.setText(str);
        this.j.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.l.setText(str);
        this.l.setOnClickListener(onClickListener);
    }

    public void a(int i2) {
        if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
            this.f9163b.setDisplayedChild(0);
        } else {
            this.f9163b.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9167f.setVisibility(0);
        this.f9167f.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.k.setText(str);
        this.k.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9164c.setBackgroundDrawable(this.f9162a.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9165d.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f9166e.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9167f.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
            this.f9168g.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
            this.f9169h.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
            this.f9170i.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
            this.k.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.j.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.l.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.k.setBackgroundDrawable(this.f9162a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.j.setBackgroundDrawable(this.f9162a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.l.setBackgroundDrawable(this.f9162a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            return;
        }
        this.f9164c.setBackgroundDrawable(this.f9162a.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9165d.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9166e.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9167f.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
        this.f9168g.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
        this.f9169h.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
        this.f9170i.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
        this.k.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.j.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.l.setTextColor(this.f9162a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.k.setBackgroundDrawable(this.f9162a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.j.setBackgroundDrawable(this.f9162a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.l.setBackgroundDrawable(this.f9162a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
    }
}
