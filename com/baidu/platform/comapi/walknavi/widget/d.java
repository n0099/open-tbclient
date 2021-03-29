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
    public Activity f10228a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.g.a f10229b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f10230c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f10231d;

    /* renamed from: e  reason: collision with root package name */
    public View f10232e;

    /* renamed from: f  reason: collision with root package name */
    public View f10233f;

    public d(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        this.f10228a = (Activity) context;
        this.f10229b = aVar;
        a(view);
    }

    public void b(int i) {
        this.f10231d.setTextColor(i);
    }

    public void c() {
        if (this.f10232e.getVisibility() == 8) {
            this.f10232e.setVisibility(0);
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f10228a, R.attr.SapiSdkActionText);
            this.f10232e.setAnimation(c2);
            c2.setAnimationListener(new e(this));
            c2.start();
        }
    }

    public void d() {
        if (this.f10232e.getVisibility() == 0) {
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f10228a, R.attr.SapiSdkDividerColor);
            c2.setAnimationListener(new f(this));
            this.f10232e.startAnimation(c2);
        }
    }

    private void a(View view) {
        this.f10233f = view.findViewById(R.dimen.abc_action_bar_stacked_tab_max_width);
        this.f10230c = (ImageView) view.findViewById(R.dimen.M_W_X006);
        this.f10231d = (TextView) view.findViewById(R.dimen.M_W_X007);
        View findViewById = view.findViewById(R.dimen.M_W_X005);
        this.f10232e = findViewById;
        findViewById.setVisibility(8);
    }

    public void a(int i, String str) {
        if (i == 2130837576) {
            this.f10231d.setVisibility(8);
        } else {
            this.f10231d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9825a) {
            this.f10230c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10228a, i));
        } else {
            this.f10230c.setImageResource(i);
        }
        if (i != 2130837603 && i != 2130837604) {
            this.f10231d.setText(str);
        } else {
            this.f10231d.setText("步行导航开始");
        }
    }

    public void a(int i) {
        this.f10233f.setBackgroundColor(i);
    }
}
