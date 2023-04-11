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
        setContentView(R.layout.obfuscated_res_0x7f0d04f3);
        setCanceledOnTouchOutside(false);
        this.b = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f0927d4);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090884);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09087b);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f09170a);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091935);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091934);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091936);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091bc2);
        this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0917fa);
        this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09180c);
        this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0923be);
        this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091933);
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
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f14));
            this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078c));
            this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060781));
            this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078b));
            this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078b));
            this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078b));
            this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078b));
            this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060785));
            this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060789));
            this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060789));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f0e));
            this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f10));
            this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f10));
            return;
        }
        this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f13));
        this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078c));
        this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060780));
        this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078a));
        this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078a));
        this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078a));
        this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06078a));
        this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060784));
        this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060788));
        this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060788));
        this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f0d));
        this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f0f));
        this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f0f));
    }

    public void b(boolean z) {
        if (z) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }
}
