package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends Dialog {
    public ViewSwitcher a;
    public LinearLayout b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public Context i;

    public b(Context context) {
        super(context, R.style.obfuscated_res_0x7f10014f);
        this.i = context;
        a();
    }

    public void a(int i) {
        int min;
        if (i < 1) {
            min = 1;
        } else {
            min = Math.min(i, 2);
        }
        if (min == 2) {
            this.a.setDisplayedChild(0);
        } else {
            this.a.setDisplayedChild(1);
        }
    }

    public void b(int i) {
        this.e.setVisibility(i);
    }

    public void c(int i) {
        this.d.setVisibility(i);
    }

    private void a() {
        setContentView(R.layout.obfuscated_res_0x7f0d04f3);
        setCanceledOnTouchOutside(false);
        this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091930);
        this.a = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f0927e6);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f09242e);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092429);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091706);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091bd3);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0917f7);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091809);
    }

    public void a(Drawable drawable) {
        this.c.setVisibility(0);
        this.c.setBackgroundDrawable(drawable);
    }

    public void b(String str) {
        this.d.setText(str);
    }

    public void a(String str) {
        this.e.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.g.setText(str);
        this.g.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.h.setText(str);
        this.h.setOnClickListener(onClickListener);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.f.setText(str);
        this.f.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.b.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f27));
            this.d.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f06078e));
            this.e.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060782));
            this.g.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060786));
            this.f.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f06078a));
            this.h.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060786));
            this.g.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f21));
            this.f.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f23));
            this.h.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f21));
            return;
        }
        this.b.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f26));
        this.d.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f06078d));
        this.e.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060781));
        this.g.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060785));
        this.h.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060785));
        this.f.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060789));
        this.g.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f20));
        this.f.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f22));
        this.h.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f20));
    }
}
