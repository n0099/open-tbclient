package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends Dialog {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private LinearLayout f;
    private InterfaceC0089a g;
    private InterfaceC0089a h;
    private boolean i;
    private boolean j;

    /* renamed from: com.baidu.platform.comapi.walknavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0089a {
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
        View a = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.layout.abc_action_menu_layout, null);
        setContentView(a);
        this.a = (TextView) a.findViewById(2131165234);
        this.b = (TextView) a.findViewById(2131165237);
        this.c = (TextView) a.findViewById(2131165241);
        this.d = (TextView) a.findViewById(2131165242);
        this.e = (LinearLayout) a.findViewById(2131165240);
        this.f = (LinearLayout) a.findViewById(2131165243);
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

    public a a(InterfaceC0089a interfaceC0089a) {
        this.g = interfaceC0089a;
        return this;
    }

    public a b(InterfaceC0089a interfaceC0089a) {
        this.h = interfaceC0089a;
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
