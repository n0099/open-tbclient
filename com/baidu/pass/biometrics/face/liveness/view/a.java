package com.baidu.pass.biometrics.face.liveness.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatDialog;
import com.baidu.pass.biometrics.face.R;
import com.baidu.pass.utils.CommonViewUtility;
/* loaded from: classes7.dex */
public class a extends AppCompatDialog {

    /* renamed from: a  reason: collision with root package name */
    private ViewSwitcher f4088a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4089b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;

    public a(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        getDelegate().setLocalNightMode(1);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.f4088a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f4089b = (TextView) findViewById(R.id.dialog_title);
        this.c = (TextView) findViewById(R.id.dialog_msg);
        this.d = (TextView) findViewById(R.id.msg_text);
        this.e = (TextView) findViewById(R.id.positive_btn);
        this.f = (TextView) findViewById(R.id.negative_btn);
        this.g = (TextView) findViewById(R.id.neutral_btn);
        this.h = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
        CommonViewUtility.setViewClickAlpha(this.e, 0.2f);
        CommonViewUtility.setViewClickAlpha(this.f, 0.2f);
        CommonViewUtility.setViewClickAlpha(this.g, 0.2f);
    }

    public void b(String str) {
        this.d.setVisibility(0);
        this.d.setText(str);
    }

    public void c(String str) {
        this.f4089b.setText(str);
    }

    public void c(int i) {
        this.h.setVisibility(0);
    }

    public void b(int i) {
        this.d.setText(i);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.e.setText(str);
        this.e.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.g.setText(str);
        this.g.setOnClickListener(onClickListener);
    }

    public void a(String str) {
        this.c.setVisibility(0);
        this.c.setText(str);
    }

    public void a(boolean z) {
        if (z) {
            this.f4089b.setVisibility(0);
        } else {
            this.f4089b.setVisibility(8);
        }
    }

    public void a(int i) {
        if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
            this.f4088a.setDisplayedChild(0);
        } else {
            this.f4088a.setDisplayedChild(1);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.f.setText(str);
        this.f.setOnClickListener(onClickListener);
    }
}
