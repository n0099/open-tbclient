package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f4383a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4384b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private LinearLayout f;
    private InterfaceC0285a g;
    private InterfaceC0285a h;
    private boolean i;
    private boolean j;

    /* renamed from: com.baidu.platform.comapi.walknavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0285a {
        void a();
    }

    public a(Context context, int i) {
        super(context);
        if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
            Resources.Theme newTheme = com.baidu.platform.comapi.wnplatform.o.a.a.b().newTheme();
            newTheme.applyStyle(i, true);
            com.baidu.platform.comapi.wnplatform.o.a.a.a(this, newTheme);
        }
    }

    public a(Context context) {
        super(context);
    }

    public a(Activity activity) {
        this(activity, R.id.BOTH);
        View a2 = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.array.Mask_X005, null);
        setContentView(a2);
        this.f4383a = (TextView) a2.findViewById(R.dimen.T_X03);
        this.f4384b = (TextView) a2.findViewById(R.dimen.T_X06);
        this.c = (TextView) a2.findViewById(R.dimen.T_X10);
        this.d = (TextView) a2.findViewById(R.dimen._bottom_enter_anim_place_holder_height);
        this.e = (LinearLayout) a2.findViewById(R.dimen.T_X09);
        this.f = (LinearLayout) a2.findViewById(R.dimen.abc_action_bar_content_inset_material);
        this.c.setOnClickListener(new b(this));
        this.d.setOnClickListener(new c(this));
        this.i = false;
        this.j = false;
        this.f4383a.setVisibility(8);
        this.f4384b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        setCanceledOnTouchOutside(false);
    }

    public a a(String str) {
        if (str == null) {
            this.f4384b.setVisibility(8);
            this.f4384b.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f4384b.setVisibility(0);
            this.f4384b.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a b(String str) {
        if (str == null) {
            this.f4383a.setVisibility(8);
            this.f4383a.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f4383a.setVisibility(0);
            this.f4383a.setText(str, TextView.BufferType.SPANNABLE);
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

    public a a(InterfaceC0285a interfaceC0285a) {
        this.g = interfaceC0285a;
        return this;
    }

    public a b(InterfaceC0285a interfaceC0285a) {
        this.h = interfaceC0285a;
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
