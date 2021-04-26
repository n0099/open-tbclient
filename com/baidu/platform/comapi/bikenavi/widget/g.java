package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class g extends com.baidu.platform.comapi.walknavi.g.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f9789a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.platform.comapi.bikenavi.c.b f9790b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f9791c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9792d;

    /* renamed from: e  reason: collision with root package name */
    public View f9793e;

    public g(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f9789a = (Activity) context;
        this.f9790b = bVar;
        a(view);
    }

    public void c() {
        if (this.f9793e.getVisibility() == 8) {
            this.f9793e.setVisibility(0);
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f9789a, R.attr.SapiSdkActionText);
            this.f9793e.setAnimation(c2);
            c2.setAnimationListener(new h(this));
            c2.start();
        }
    }

    public void d() {
        if (this.f9793e.getVisibility() == 0) {
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f9789a, R.attr.SapiSdkDividerColor);
            c2.setAnimationListener(new i(this));
            this.f9793e.startAnimation(c2);
        }
    }

    private void a(View view) {
        this.f9791c = (ImageView) view.findViewById(R.dimen.M_W_X006);
        this.f9792d = (TextView) view.findViewById(R.dimen.M_W_X007);
        View findViewById = view.findViewById(R.dimen.M_W_X005);
        this.f9793e = findViewById;
        findViewById.setVisibility(8);
    }

    public void a(int i2, String str) {
        if (i2 != R.animator.mtrl_extended_fab_show_motion_spec && i2 != R.animator.design_fab_show_motion_spec) {
            this.f9792d.setVisibility(0);
        } else {
            this.f9792d.setVisibility(8);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9734a) {
            this.f9791c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.b().getDrawable(i2));
        } else {
            this.f9791c.setImageResource(i2);
        }
        this.f9792d.setText(str);
    }
}
