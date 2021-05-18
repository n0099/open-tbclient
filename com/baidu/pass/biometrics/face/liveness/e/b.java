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
    public ViewSwitcher f9212a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9213b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9214c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9215d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9216e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9217f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9218g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9219h;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9219h = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f9213b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
        this.f9212a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9214c = (TextView) findViewById(R.id.title_text);
        this.f9215d = (TextView) findViewById(R.id.msg_text);
        this.f9216e = (TextView) findViewById(R.id.positive_btn);
        this.f9217f = (TextView) findViewById(R.id.negative_btn);
        this.f9218g = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.f9214c.setText(str);
    }

    public void c(int i2) {
        this.f9214c.setVisibility(i2);
    }

    public void b(int i2) {
        this.f9215d.setVisibility(i2);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f9216e.setText(str);
        this.f9216e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f9218g.setText(str);
        this.f9218g.setOnClickListener(onClickListener);
    }

    public void a(int i2) {
        if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
            this.f9212a.setDisplayedChild(0);
        } else {
            this.f9212a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9215d.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f9217f.setText(str);
        this.f9217f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9213b.setBackgroundDrawable(this.f9219h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9214c.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
            this.f9215d.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9217f.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9216e.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.f9218g.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9217f.setBackgroundDrawable(this.f9219h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.f9216e.setBackgroundDrawable(this.f9219h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.f9218g.setBackgroundDrawable(this.f9219h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            return;
        }
        this.f9213b.setBackgroundDrawable(this.f9219h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9214c.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9215d.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9217f.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9218g.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9216e.setTextColor(this.f9219h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.f9217f.setBackgroundDrawable(this.f9219h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.f9216e.setBackgroundDrawable(this.f9219h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.f9218g.setBackgroundDrawable(this.f9219h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
    }
}
