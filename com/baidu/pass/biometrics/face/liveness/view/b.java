package com.baidu.pass.biometrics.face.liveness.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatDialog;
import com.baidu.pass.biometrics.face.R;
/* loaded from: classes14.dex */
public class b extends AppCompatDialog {

    /* renamed from: a  reason: collision with root package name */
    private ViewSwitcher f2809a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;

    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f2809a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.b = (TextView) findViewById(R.id.title_text);
        this.c = (TextView) findViewById(R.id.msg_text);
        this.d = (TextView) findViewById(R.id.positive_btn);
        this.e = (TextView) findViewById(R.id.negative_btn);
        this.f = (TextView) findViewById(R.id.neutral_btn);
    }

    public void b(String str) {
        this.b.setText(str);
    }

    public void c(int i) {
        this.b.setVisibility(i);
    }

    public void b(int i) {
        this.c.setVisibility(i);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.d.setText(str);
        this.d.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.f.setText(str);
        this.f.setOnClickListener(onClickListener);
    }

    public void a(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 2) {
            i = 2;
        }
        if (i == 2) {
            this.f2809a.setDisplayedChild(0);
        } else {
            this.f2809a.setDisplayedChild(1);
        }
    }

    public void a(String str) {
        this.c.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.e.setText(str);
        this.e.setOnClickListener(onClickListener);
    }
}
