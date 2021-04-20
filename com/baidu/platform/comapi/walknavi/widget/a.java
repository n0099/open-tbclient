package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f9776a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f9777b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9778c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9779d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f9780e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f9781f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0127a f9782g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0127a f9783h;
    public boolean i;
    public boolean j;

    /* renamed from: com.baidu.platform.comapi.walknavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0127a {
        void a();
    }

    public a(Context context, int i) {
        super(context);
        if (com.baidu.platform.comapi.bikenavi.a.a.f9383a) {
            Resources.Theme newTheme = com.baidu.platform.comapi.wnplatform.o.a.a.b().newTheme();
            newTheme.applyStyle(i, true);
            com.baidu.platform.comapi.wnplatform.o.a.a.a(this, newTheme);
        }
    }

    public a c(String str) {
        if (str == null) {
            this.i = false;
            this.f9778c.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.i = true;
            this.f9778c.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public a d(String str) {
        if (str == null) {
            this.j = false;
            this.f9779d.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.j = true;
            this.f9779d.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public a a(String str) {
        if (str == null) {
            this.f9777b.setVisibility(8);
            this.f9777b.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f9777b.setVisibility(0);
            this.f9777b.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a b(String str) {
        if (str == null) {
            this.f9776a.setVisibility(8);
            this.f9776a.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f9776a.setVisibility(0);
            this.f9776a.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a(Context context) {
        super(context);
    }

    private void d() {
        if (!this.i) {
            this.f9778c.setVisibility(8);
            this.f9779d.setVisibility(8);
            this.f9780e.setVisibility(8);
            this.f9781f.setVisibility(8);
        } else if (!this.j) {
            this.f9778c.setVisibility(0);
            this.f9779d.setVisibility(8);
            this.f9780e.setVisibility(8);
            this.f9781f.setVisibility(8);
        } else {
            this.f9778c.setVisibility(0);
            this.f9779d.setVisibility(0);
            this.f9780e.setVisibility(8);
            this.f9781f.setVisibility(8);
        }
    }

    public a a() {
        this.f9778c.setTextColor(-12352272);
        return this;
    }

    public a b() {
        this.f9779d.setTextColor(-12352272);
        return this;
    }

    public TextView c() {
        return this.f9779d;
    }

    public a(Activity activity) {
        this(activity, R.id.BOTH);
        View a2 = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.array.Mask_X005, null);
        setContentView(a2);
        this.f9776a = (TextView) a2.findViewById(R.dimen.T_X03);
        this.f9777b = (TextView) a2.findViewById(R.dimen.T_X06);
        this.f9778c = (TextView) a2.findViewById(R.dimen.T_X10);
        this.f9779d = (TextView) a2.findViewById(R.dimen.T_X11);
        this.f9780e = (LinearLayout) a2.findViewById(R.dimen.T_X09);
        this.f9781f = (LinearLayout) a2.findViewById(R.dimen._bottom_enter_anim_place_holder_height);
        this.f9778c.setOnClickListener(new b(this));
        this.f9779d.setOnClickListener(new c(this));
        this.i = false;
        this.j = false;
        this.f9776a.setVisibility(8);
        this.f9777b.setVisibility(8);
        this.f9778c.setVisibility(8);
        this.f9779d.setVisibility(8);
        this.f9780e.setVisibility(8);
        this.f9781f.setVisibility(8);
        setCanceledOnTouchOutside(false);
    }

    public a a(InterfaceC0127a interfaceC0127a) {
        this.f9782g = interfaceC0127a;
        return this;
    }

    public a b(InterfaceC0127a interfaceC0127a) {
        this.f9783h = interfaceC0127a;
        return this;
    }

    public a a(boolean z) {
        super.setCancelable(z);
        return this;
    }
}
