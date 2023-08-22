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
/* loaded from: classes3.dex */
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
        super(context, R.style.obfuscated_res_0x7f10015c);
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
        setContentView(R.layout.obfuscated_res_0x7f0d053c);
        setCanceledOnTouchOutside(false);
        this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091a65);
        this.a = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f09298f);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0925c1);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0925bc);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091814);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091d10);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091912);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091927);
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
            this.b.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081123));
            this.d.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060926));
            this.e.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f06091a));
            this.g.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f06091e));
            this.f.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060922));
            this.h.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f06091e));
            this.g.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08111d));
            this.f.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08111f));
            this.h.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08111d));
            return;
        }
        this.b.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081122));
        this.d.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060925));
        this.e.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060919));
        this.g.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f06091d));
        this.h.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f06091d));
        this.f.setTextColor(this.i.getResources().getColor(R.color.obfuscated_res_0x7f060921));
        this.g.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08111c));
        this.f.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08111e));
        this.h.setBackgroundDrawable(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08111c));
    }
}
