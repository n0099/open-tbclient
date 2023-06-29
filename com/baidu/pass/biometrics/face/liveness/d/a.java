package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.pass.utils.CommonViewUtility;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends Dialog {
    public Context a;
    public ViewSwitcher b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;

    public a(Context context) {
        super(context, R.style.obfuscated_res_0x7f10015b);
        this.a = context;
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
            this.b.setDisplayedChild(0);
        } else {
            this.b.setDisplayedChild(1);
        }
    }

    public void b(int i) {
        this.f.setText(i);
    }

    public void c(int i) {
        this.m.setVisibility(0);
    }

    private void a() {
        setContentView(R.layout.obfuscated_res_0x7f0d0523);
        setCanceledOnTouchOutside(false);
        this.b = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f092908);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0908b4);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0908ab);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0917cd);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091a14);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091a13);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091a15);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091cb7);
        this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0918c4);
        this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f0918d9);
        this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0924d9);
        this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091a12);
        CommonViewUtility.setViewClickAlpha(this.j, 0.2f);
        CommonViewUtility.setViewClickAlpha(this.k, 0.2f);
        CommonViewUtility.setViewClickAlpha(this.l, 0.2f);
    }

    public void a(String str) {
        this.f.setVisibility(0);
        this.f.setText(str);
    }

    public void b(String str) {
        this.d.setText(str);
    }

    public void c(String str) {
        this.e.setVisibility(0);
        this.e.setText(str);
    }

    public void a(String str, View.OnClickListener onClickListener) {
        this.k.setText(str);
        this.k.setOnClickListener(onClickListener);
    }

    public void b(String str, View.OnClickListener onClickListener) {
        this.l.setText(str);
        this.l.setOnClickListener(onClickListener);
    }

    public void c(String str, View.OnClickListener onClickListener) {
        this.j.setText(str);
        this.j.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        if (z) {
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810f1));
            this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060918));
            this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06090d));
            this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060917));
            this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060917));
            this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060917));
            this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060917));
            this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060911));
            this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060915));
            this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060915));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810eb));
            this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810ed));
            this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810ed));
            return;
        }
        this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810f0));
        this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060918));
        this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06090c));
        this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060916));
        this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060916));
        this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060916));
        this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060916));
        this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060910));
        this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060914));
        this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060914));
        this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810ea));
        this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810ec));
        this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810ec));
    }

    public void b(boolean z) {
        if (z) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }
}
