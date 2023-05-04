package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.pass.utils.CommonViewUtility;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
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
        super(context, R.style.obfuscated_res_0x7f10014f);
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
        setContentView(R.layout.obfuscated_res_0x7f0d04fb);
        setCanceledOnTouchOutside(false);
        this.b = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f0927f0);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090887);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09087e);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091718);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091942);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091941);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091943);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091bd2);
        this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f091808);
        this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09181a);
        this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0923d6);
        this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091940);
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
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f43));
            this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060790));
            this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060785));
            this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078f));
            this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078f));
            this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078f));
            this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078f));
            this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060789));
            this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078d));
            this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078d));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f3d));
            this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f3f));
            this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f3f));
            return;
        }
        this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f42));
        this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060790));
        this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060784));
        this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078e));
        this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078e));
        this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078e));
        this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078e));
        this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060788));
        this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078c));
        this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078c));
        this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f3c));
        this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f3e));
        this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f3e));
    }

    public void b(boolean z) {
        if (z) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }
}
