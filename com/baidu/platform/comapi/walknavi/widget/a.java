package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f4601a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4602b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private LinearLayout f;
    private InterfaceC0302a g;
    private InterfaceC0302a h;
    private boolean i;
    private boolean j;

    /* renamed from: com.baidu.platform.comapi.walknavi.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0302a {
        void a();
    }

    public a(Context context, int i) {
        super(context);
    }

    public a(Context context) {
        super(context);
    }

    public a(Activity activity) {
        this(activity, R.id.BOTH);
        View a2 = com.baidu.platform.comapi.wnplatform.p.a.a.a(activity, R.array.Mask_X007, null);
        requestWindowFeature(1);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        setContentView(a2);
        this.f4601a = (TextView) a2.findViewById(R.dimen.abc_action_bar_content_inset_material);
        this.f4602b = (TextView) a2.findViewById(R.dimen.abc_action_bar_default_padding_end_material);
        this.c = (TextView) a2.findViewById(R.dimen.abc_action_bar_overflow_padding_end_material);
        this.d = (TextView) a2.findViewById(R.dimen.abc_action_bar_overflow_padding_start_material);
        this.e = (LinearLayout) a2.findViewById(R.dimen.abc_action_bar_icon_vertical_padding_material);
        this.f = (LinearLayout) a2.findViewById(R.dimen.abc_action_bar_stacked_max_height);
        this.c.setOnClickListener(new b(this));
        this.d.setOnClickListener(new c(this));
        this.i = false;
        this.j = false;
        this.f4601a.setVisibility(8);
        this.f4602b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        setCanceledOnTouchOutside(false);
    }

    public a a(String str) {
        if (str == null) {
            this.f4602b.setVisibility(8);
            this.f4602b.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f4602b.setVisibility(0);
            this.f4602b.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public a b(String str) {
        if (str == null) {
            this.f4601a.setVisibility(8);
            this.f4601a.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f4601a.setVisibility(0);
            this.f4601a.setText(str, TextView.BufferType.SPANNABLE);
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

    public a a(InterfaceC0302a interfaceC0302a) {
        this.g = interfaceC0302a;
        return this;
    }

    public a b(InterfaceC0302a interfaceC0302a) {
        this.h = interfaceC0302a;
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
