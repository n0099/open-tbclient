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
/* loaded from: classes6.dex */
public class RimLivenessBaseDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f2431a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f2432b;
    private Button c;
    private Button d;

    public RimLivenessBaseDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    public RimLivenessBaseDialog(Context context, int i) {
        super(context, i);
        a();
    }

    private void a() {
        setContentView(R.layout.rim_liveness_alert_dialog_base);
        this.f2431a = (TextView) findViewById(R.id.dialog_title);
        this.f2432b = (LinearLayout) findViewById(R.id.dialog_content);
        this.c = (Button) findViewById(R.id.positive_btn);
        this.d = (Button) findViewById(R.id.negative_btn);
        setCancelable(false);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f2431a.setText(charSequence);
    }

    public void addContentView(int i) {
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.f2432b, true);
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
        this.f2432b.addView(textView);
    }

    public void setPositiveBtnClickListener(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.c.setText(charSequence);
        this.c.setOnClickListener(onClickListener);
    }

    public void setNegativeBtnClickListener(CharSequence charSequence, View.OnClickListener onClickListener) {
        findViewById(R.id.btn_line).setVisibility(0);
        this.d.setVisibility(0);
        this.d.setText(charSequence);
        this.d.setOnClickListener(onClickListener);
    }
}
