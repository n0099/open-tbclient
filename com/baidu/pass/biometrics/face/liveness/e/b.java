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
    public ViewSwitcher f9249a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9250b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9251c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9252d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9253e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9254f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9255g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9256h;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        this.f9256h = context;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f9250b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
        this.f9249a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f9251c = (TextView) findViewById(R.id.title_text);
        this.f9252d = (TextView) findViewById(R.id.msg_text);
        this.f9253e = (TextView) findViewById(R.id.positive_btn);
        this.f9254f = (TextView) findViewById(R.id.negative_btn);
        this.f9255g = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.f9251c.setText(str);
    }

    public void c(int i) {
        this.f9251c.setVisibility(i);
    }

    public void b(int i) {
        this.f9252d.setVisibility(i);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f9253e.setText(str);
        this.f9253e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f9255g.setText(str);
        this.f9255g.setOnClickListener(onClickListener);
    }

    public void a(int i) {
        if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
            this.f9249a.setDisplayedChild(0);
        } else {
            this.f9249a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.f9252d.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f9254f.setText(str);
        this.f9254f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.f9250b.setBackgroundDrawable(this.f9256h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
            this.f9251c.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
            this.f9252d.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
            this.f9254f.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9253e.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
            this.f9255g.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
            this.f9254f.setBackgroundDrawable(this.f9256h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            this.f9253e.setBackgroundDrawable(this.f9256h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
            this.f9255g.setBackgroundDrawable(this.f9256h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
            return;
        }
        this.f9250b.setBackgroundDrawable(this.f9256h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
        this.f9251c.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        this.f9252d.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
        this.f9254f.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9255g.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
        this.f9253e.setTextColor(this.f9256h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
        this.f9254f.setBackgroundDrawable(this.f9256h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        this.f9253e.setBackgroundDrawable(this.f9256h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        this.f9255g.setBackgroundDrawable(this.f9256h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
    }
}
