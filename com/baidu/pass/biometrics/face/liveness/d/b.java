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
    public ViewSwitcher f9162a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9163b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9164c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9165d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9166e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9167f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9168g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9169h;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9169h = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f9163b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
        this.f9162a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9164c = (TextView) findViewById(R.id.title_text);
        this.f9165d = (TextView) findViewById(R.id.msg_text);
        this.f9166e = (TextView) findViewById(R.id.positive_btn);
        this.f9167f = (TextView) findViewById(R.id.negative_btn);
        this.f9168g = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.f9164c.setText(str);
    }

    public void c(int i2) {
        this.f9164c.setVisibility(i2);
    }

    public void b(int i2) {
        this.f9165d.setVisibility(i2);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f9166e.setText(str);
        this.f9166e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f9168g.setText(str);
        this.f9168g.setOnClickListener(onClickListener);
    }

    public void a(int i2) {
        if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
            this.f9162a.setDisplayedChild(0);
        } else {
            this.f9162a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9165d.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f9167f.setText(str);
        this.f9167f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9163b.setBackgroundDrawable(this.f9169h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9164c.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
            this.f9165d.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9167f.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9166e.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.f9168g.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9167f.setBackgroundDrawable(this.f9169h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.f9166e.setBackgroundDrawable(this.f9169h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.f9168g.setBackgroundDrawable(this.f9169h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            return;
        }
        this.f9163b.setBackgroundDrawable(this.f9169h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9164c.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9165d.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9167f.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9168g.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9166e.setTextColor(this.f9169h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.f9167f.setBackgroundDrawable(this.f9169h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.f9166e.setBackgroundDrawable(this.f9169h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.f9168g.setBackgroundDrawable(this.f9169h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
    }
}
