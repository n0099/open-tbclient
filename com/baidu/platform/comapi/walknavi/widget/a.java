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
    public TextView f10139a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f10140b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10141c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f10142d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f10143e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f10144f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0127a f10145g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0127a f10146h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10147i;
    public boolean j;

    /* renamed from: com.baidu.platform.comapi.walknavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0127a {
        void a();
    }

    public a(Context context, int i2) {
        super(context);
        if (com.baidu.platform.comapi.bikenavi.a.a.f9734a) {
            Resources.Theme newTheme = com.baidu.platform.comapi.wnplatform.o.a.a.b().newTheme();
            newTheme.applyStyle(i2, true);
            com.baidu.platform.comapi.wnplatform.o.a.a.a(this, newTheme);
        }
    }

    public a c(String str) {
        if (str == null) {
            this.f10147i = false;
            this.f10141c.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f10147i = true;
            this.f10141c.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public a d(String str) {
        if (str == null) {
            this.j = false;
            this.f10142d.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.j = true;
            this.f10142d.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public a a(String str) {
        if (str == null) {
            this.f10140b.setVisibility(8);
            this.f10140b.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f10140b.setVisibility(0);
            this.f10140b.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a b(String str) {
        if (str == null) {
            this.f10139a.setVisibility(8);
            this.f10139a.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f10139a.setVisibility(0);
            this.f10139a.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a(Context context) {
        super(context);
    }

    private void d() {
        if (!this.f10147i) {
            this.f10141c.setVisibility(8);
            this.f10142d.setVisibility(8);
            this.f10143e.setVisibility(8);
            this.f10144f.setVisibility(8);
        } else if (!this.j) {
            this.f10141c.setVisibility(0);
            this.f10142d.setVisibility(8);
            this.f10143e.setVisibility(8);
            this.f10144f.setVisibility(8);
        } else {
            this.f10141c.setVisibility(0);
            this.f10142d.setVisibility(0);
            this.f10143e.setVisibility(8);
            this.f10144f.setVisibility(8);
        }
    }

    public a a() {
        this.f10141c.setTextColor(-12352272);
        return this;
    }

    public a b() {
        this.f10142d.setTextColor(-12352272);
        return this;
    }

    public TextView c() {
        return this.f10142d;
    }

    public a(Activity activity) {
        this(activity, R.id.BOTH);
        View a2 = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.array.Mask_X005, null);
        setContentView(a2);
        this.f10139a = (TextView) a2.findViewById(R.dimen.T_X03);
        this.f10140b = (TextView) a2.findViewById(R.dimen.T_X06);
        this.f10141c = (TextView) a2.findViewById(R.dimen.T_X10);
        this.f10142d = (TextView) a2.findViewById(R.dimen.T_X11);
        this.f10143e = (LinearLayout) a2.findViewById(R.dimen.T_X09);
        this.f10144f = (LinearLayout) a2.findViewById(R.dimen._bottom_enter_anim_place_holder_height);
        this.f10141c.setOnClickListener(new b(this));
        this.f10142d.setOnClickListener(new c(this));
        this.f10147i = false;
        this.j = false;
        this.f10139a.setVisibility(8);
        this.f10140b.setVisibility(8);
        this.f10141c.setVisibility(8);
        this.f10142d.setVisibility(8);
        this.f10143e.setVisibility(8);
        this.f10144f.setVisibility(8);
        setCanceledOnTouchOutside(false);
    }

    public a a(InterfaceC0127a interfaceC0127a) {
        this.f10145g = interfaceC0127a;
        return this;
    }

    public a b(InterfaceC0127a interfaceC0127a) {
        this.f10146h = interfaceC0127a;
        return this;
    }

    public a a(boolean z) {
        super.setCancelable(z);
        return this;
    }
}
