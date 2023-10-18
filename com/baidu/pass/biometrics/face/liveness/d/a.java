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
        super(context, R.style.obfuscated_res_0x7f10015c);
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
        setContentView(R.layout.obfuscated_res_0x7f0d053f);
        setCanceledOnTouchOutside(false);
        this.b = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f092982);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0908d2);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0908c9);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091835);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091a97);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091a96);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091a98);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091d26);
        this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f091941);
        this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f091956);
        this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092571);
        this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091a95);
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
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08113e));
            this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060928));
            this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06091d));
            this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060927));
            this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060927));
            this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060927));
            this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060927));
            this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060921));
            this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060925));
            this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060925));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081138));
            this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08113a));
            this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08113a));
            return;
        }
        this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08113d));
        this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060928));
        this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06091c));
        this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060926));
        this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060926));
        this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060926));
        this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060926));
        this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060920));
        this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060924));
        this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060924));
        this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081137));
        this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081139));
        this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081139));
    }

    public void b(boolean z) {
        if (z) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }
}
