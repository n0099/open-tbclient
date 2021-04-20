package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class RimLivenessBaseDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f6201a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f6202b;

    /* renamed from: c  reason: collision with root package name */
    public Button f6203c;

    /* renamed from: d  reason: collision with root package name */
    public Button f6204d;

    public RimLivenessBaseDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.rim_liveness_alert_dialog_base);
        this.f6201a = (TextView) findViewById(R.id.dialog_title);
        this.f6202b = (LinearLayout) findViewById(R.id.dialog_content);
        this.f6203c = (Button) findViewById(R.id.positive_btn);
        this.f6204d = (Button) findViewById(R.id.negative_btn);
        setCancelable(false);
    }

    public void addContentView(int i) {
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.f6202b, true);
    }

    public void setNegativeBtnClickListener(CharSequence charSequence, View.OnClickListener onClickListener) {
        findViewById(R.id.btn_line).setVisibility(0);
        this.f6204d.setVisibility(0);
        this.f6204d.setText(charSequence);
        this.f6204d.setOnClickListener(onClickListener);
    }

    public void setPositiveBtnClickListener(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.f6203c.setText(charSequence);
        this.f6203c.setOnClickListener(onClickListener);
    }

    public void setTextViewContent(CharSequence charSequence) {
        TextView textView = new TextView(getContext());
        textView.setText(charSequence);
        textView.setGravity(17);
        textView.setTextColor(getContext().getResources().getColor(R.color.sapi_dialog_title_text_color));
        textView.setTextSize(1, getContext().getResources().getDimension(R.dimen.rim_base_level16Font));
        textView.setLineSpacing(1.0f, 1.2f);
        int dimension = (int) getContext().getResources().getDimension(R.dimen.rim_dimen_20dp);
        textView.setPadding(dimension, dimension, dimension, dimension);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f6202b.addView(textView);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f6201a.setText(charSequence);
    }

    public RimLivenessBaseDialog(Context context, int i) {
        super(context, i);
        a();
    }
}
