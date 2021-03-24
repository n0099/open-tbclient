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
    public TextView f10217a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f10218b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10219c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f10220d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f10221e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f10222f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0127a f10223g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0127a f10224h;
    public boolean i;
    public boolean j;

    /* renamed from: com.baidu.platform.comapi.walknavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0127a {
        void a();
    }

    public a(Context context, int i) {
        super(context);
        if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
            Resources.Theme newTheme = com.baidu.platform.comapi.wnplatform.o.a.a.b().newTheme();
            newTheme.applyStyle(i, true);
            com.baidu.platform.comapi.wnplatform.o.a.a.a(this, newTheme);
        }
    }

    public a c(String str) {
        if (str == null) {
            this.i = false;
            this.f10219c.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.i = true;
            this.f10219c.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public a d(String str) {
        if (str == null) {
            this.j = false;
            this.f10220d.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.j = true;
            this.f10220d.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public a a(String str) {
        if (str == null) {
            this.f10218b.setVisibility(8);
            this.f10218b.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f10218b.setVisibility(0);
            this.f10218b.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a b(String str) {
        if (str == null) {
            this.f10217a.setVisibility(8);
            this.f10217a.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f10217a.setVisibility(0);
            this.f10217a.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a(Context context) {
        super(context);
    }

    private void d() {
        if (!this.i) {
            this.f10219c.setVisibility(8);
            this.f10220d.setVisibility(8);
            this.f10221e.setVisibility(8);
            this.f10222f.setVisibility(8);
        } else if (!this.j) {
            this.f10219c.setVisibility(0);
            this.f10220d.setVisibility(8);
            this.f10221e.setVisibility(8);
            this.f10222f.setVisibility(8);
        } else {
            this.f10219c.setVisibility(0);
            this.f10220d.setVisibility(0);
            this.f10221e.setVisibility(8);
            this.f10222f.setVisibility(8);
        }
    }

    public a a() {
        this.f10219c.setTextColor(-12352272);
        return this;
    }

    public a b() {
        this.f10220d.setTextColor(-12352272);
        return this;
    }

    public TextView c() {
        return this.f10220d;
    }

    public a(Activity activity) {
        this(activity, R.id.BOTH);
        View a2 = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.array.Mask_X005, null);
        setContentView(a2);
        this.f10217a = (TextView) a2.findViewById(R.dimen.T_X03);
        this.f10218b = (TextView) a2.findViewById(R.dimen.T_X06);
        this.f10219c = (TextView) a2.findViewById(R.dimen.T_X10);
        this.f10220d = (TextView) a2.findViewById(R.dimen.T_X11);
        this.f10221e = (LinearLayout) a2.findViewById(R.dimen.T_X09);
        this.f10222f = (LinearLayout) a2.findViewById(R.dimen._bottom_enter_anim_place_holder_height);
        this.f10219c.setOnClickListener(new b(this));
        this.f10220d.setOnClickListener(new c(this));
        this.i = false;
        this.j = false;
        this.f10217a.setVisibility(8);
        this.f10218b.setVisibility(8);
        this.f10219c.setVisibility(8);
        this.f10220d.setVisibility(8);
        this.f10221e.setVisibility(8);
        this.f10222f.setVisibility(8);
        setCanceledOnTouchOutside(false);
    }

    public a a(InterfaceC0127a interfaceC0127a) {
        this.f10223g = interfaceC0127a;
        return this;
    }

    public a b(InterfaceC0127a interfaceC0127a) {
        this.f10224h = interfaceC0127a;
        return this;
    }

    public a a(boolean z) {
        super.setCancelable(z);
        return this;
    }
}
