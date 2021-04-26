package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.comapi.walknavi.g.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f10150a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.g.a f10151b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f10152c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f10153d;

    /* renamed from: e  reason: collision with root package name */
    public View f10154e;

    /* renamed from: f  reason: collision with root package name */
    public View f10155f;

    public d(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        this.f10150a = (Activity) context;
        this.f10151b = aVar;
        a(view);
    }

    public void b(int i2) {
        this.f10153d.setTextColor(i2);
    }

    public void c() {
        if (this.f10154e.getVisibility() == 8) {
            this.f10154e.setVisibility(0);
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f10150a, R.attr.SapiSdkActionText);
            this.f10154e.setAnimation(c2);
            c2.setAnimationListener(new e(this));
            c2.start();
        }
    }

    public void d() {
        if (this.f10154e.getVisibility() == 0) {
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f10150a, R.attr.SapiSdkDividerColor);
            c2.setAnimationListener(new f(this));
            this.f10154e.startAnimation(c2);
        }
    }

    private void a(View view) {
        this.f10155f = view.findViewById(R.dimen.abc_action_bar_stacked_tab_max_width);
        this.f10152c = (ImageView) view.findViewById(R.dimen.M_W_X006);
        this.f10153d = (TextView) view.findViewById(R.dimen.M_W_X007);
        View findViewById = view.findViewById(R.dimen.M_W_X005);
        this.f10154e = findViewById;
        findViewById.setVisibility(8);
    }

    public void a(int i2, String str) {
        if (i2 == 2130837576) {
            this.f10153d.setVisibility(8);
        } else {
            this.f10153d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9734a) {
            this.f10152c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10150a, i2));
        } else {
            this.f10152c.setImageResource(i2);
        }
        if (i2 != 2130837603 && i2 != 2130837604) {
            this.f10153d.setText(str);
        } else {
            this.f10153d.setText("步行导航开始");
        }
    }

    public void a(int i2) {
        this.f10155f.setBackgroundColor(i2);
    }
}
