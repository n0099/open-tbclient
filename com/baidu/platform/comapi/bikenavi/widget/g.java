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
    public Activity f9435a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.platform.comapi.bikenavi.c.b f9436b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f9437c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9438d;

    /* renamed from: e  reason: collision with root package name */
    public View f9439e;

    public g(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f9435a = (Activity) context;
        this.f9436b = bVar;
        a(view);
    }

    public void c() {
        if (this.f9439e.getVisibility() == 8) {
            this.f9439e.setVisibility(0);
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f9435a, R.attr.SapiSdkActionText);
            this.f9439e.setAnimation(c2);
            c2.setAnimationListener(new h(this));
            c2.start();
        }
    }

    public void d() {
        if (this.f9439e.getVisibility() == 0) {
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f9435a, R.attr.SapiSdkDividerColor);
            c2.setAnimationListener(new i(this));
            this.f9439e.startAnimation(c2);
        }
    }

    private void a(View view) {
        this.f9437c = (ImageView) view.findViewById(R.dimen.M_W_X006);
        this.f9438d = (TextView) view.findViewById(R.dimen.M_W_X007);
        View findViewById = view.findViewById(R.dimen.M_W_X005);
        this.f9439e = findViewById;
        findViewById.setVisibility(8);
    }

    public void a(int i, String str) {
        if (i != R.animator.mtrl_fab_transformation_sheet_collapse_spec && i != R.animator.design_fab_show_motion_spec) {
            this.f9438d.setVisibility(0);
        } else {
            this.f9438d.setVisibility(8);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9383a) {
            this.f9437c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.b().getDrawable(i));
        } else {
            this.f9437c.setImageResource(i);
        }
        this.f9438d.setText(str);
    }
}
