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
    public Activity f9876a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.platform.comapi.bikenavi.c.b f9877b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f9878c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9879d;

    /* renamed from: e  reason: collision with root package name */
    public View f9880e;

    public g(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f9876a = (Activity) context;
        this.f9877b = bVar;
        a(view);
    }

    public void c() {
        if (this.f9880e.getVisibility() == 8) {
            this.f9880e.setVisibility(0);
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f9876a, R.attr.SapiSdkActionText);
            this.f9880e.setAnimation(c2);
            c2.setAnimationListener(new h(this));
            c2.start();
        }
    }

    public void d() {
        if (this.f9880e.getVisibility() == 0) {
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f9876a, R.attr.SapiSdkDividerColor);
            c2.setAnimationListener(new i(this));
            this.f9880e.startAnimation(c2);
        }
    }

    private void a(View view) {
        this.f9878c = (ImageView) view.findViewById(R.dimen.M_W_X006);
        this.f9879d = (TextView) view.findViewById(R.dimen.M_W_X007);
        View findViewById = view.findViewById(R.dimen.M_W_X005);
        this.f9880e = findViewById;
        findViewById.setVisibility(8);
    }

    public void a(int i, String str) {
        if (i != R.animator.mtrl_fab_transformation_sheet_collapse_spec && i != R.animator.design_fab_show_motion_spec) {
            this.f9879d.setVisibility(0);
        } else {
            this.f9879d.setVisibility(8);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
            this.f9878c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.b().getDrawable(i));
        } else {
            this.f9878c.setImageResource(i);
        }
        this.f9879d.setText(str);
    }
}
