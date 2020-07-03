package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends Dialog {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private LinearLayout f;
    private InterfaceC0233a g;
    private InterfaceC0233a h;
    private boolean i;
    private boolean j;

    /* renamed from: com.baidu.platform.comapi.walknavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0233a {
        void a();
    }

    public a(Context context, int i) {
        super(context);
        if (com.baidu.platform.comapi.bikenavi.a.a.a) {
            Resources.Theme newTheme = com.baidu.platform.comapi.wnplatform.o.a.a.b().newTheme();
            newTheme.applyStyle(i, true);
            com.baidu.platform.comapi.wnplatform.o.a.a.a(this, newTheme);
        }
    }

    public a(Context context) {
        super(context);
    }

    public a(Activity activity) {
        this(activity, R.dimen.pass_liveness_face_round_width);
        View a = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.layout.abc_action_mode_bar, null);
        setContentView(a);
        this.a = (TextView) a.findViewById(R.raw.lottie_use_home_cj_n_2);
        this.b = (TextView) a.findViewById(R.raw.lottie_use_home_refresh_n_2);
        this.c = (TextView) a.findViewById(R.raw.lottie_use_message_cj_n_2);
        this.d = (TextView) a.findViewById(R.raw.lottie_use_my_cj_n_1);
        this.e = (LinearLayout) a.findViewById(R.raw.lottie_use_message_cj_n_1);
        this.f = (LinearLayout) a.findViewById(R.raw.lottie_use_my_cj_n_2);
        this.c.setOnClickListener(new b(this));
        this.d.setOnClickListener(new c(this));
        this.i = false;
        this.j = false;
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        setCanceledOnTouchOutside(false);
    }

    public a a(String str) {
        if (str == null) {
            this.b.setVisibility(8);
            this.b.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.b.setVisibility(0);
            this.b.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a b(String str) {
        if (str == null) {
            this.a.setVisibility(8);
            this.a.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.a.setVisibility(0);
            this.a.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a c(String str) {
        if (str == null) {
            this.i = false;
            this.c.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.i = true;
            this.c.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public a d(String str) {
        if (str == null) {
            this.j = false;
            this.d.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.j = true;
            this.d.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public a a() {
        this.c.setTextColor(-12352272);
        return this;
    }

    public a b() {
        this.d.setTextColor(-12352272);
        return this;
    }

    public a a(InterfaceC0233a interfaceC0233a) {
        this.g = interfaceC0233a;
        return this;
    }

    public a b(InterfaceC0233a interfaceC0233a) {
        this.h = interfaceC0233a;
        return this;
    }

    public a a(boolean z) {
        super.setCancelable(z);
        return this;
    }

    private void d() {
        if (!this.i) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        } else if (!this.j) {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.d.setVisibility(0);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public TextView c() {
        return this.d;
    }
}
