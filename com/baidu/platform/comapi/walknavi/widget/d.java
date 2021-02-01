package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.platform.comapi.walknavi.g.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f4390a;

    /* renamed from: b  reason: collision with root package name */
    private com.baidu.platform.comapi.walknavi.g.a f4391b;
    private ImageView c;
    private TextView d;
    private View e;
    private View f;

    public d(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        this.f4390a = (Activity) context;
        this.f4391b = aVar;
        a(view);
    }

    private void a(View view) {
        this.f = view.findViewById(R.dimen.abc_action_bar_subtitle_bottom_margin_material);
        this.c = (ImageView) view.findViewById(R.dimen.M_W_X006);
        this.d = (TextView) view.findViewById(R.dimen.M_W_X007);
        this.e = view.findViewById(R.dimen.M_W_X005);
        this.e.setVisibility(8);
    }

    public void c() {
        if (this.e.getVisibility() == 8) {
            this.e.setVisibility(0);
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f4390a, R.attr.absListViewStyle);
            this.e.setAnimation(c);
            c.setAnimationListener(new e(this));
            c.start();
        }
    }

    public void d() {
        if (this.e.getVisibility() == 0) {
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f4390a, R.attr.actionBarDivider);
            c.setAnimationListener(new f(this));
            this.e.startAnimation(c);
        }
    }

    public void a(int i, String str) {
        if (i == 2130837576) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f4146a) {
            this.c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f4390a, i));
        } else {
            this.c.setImageResource(i);
        }
        if (i == 2130837603 || i == 2130837604) {
            this.d.setText("步行导航开始");
        } else {
            this.d.setText(str);
        }
    }

    public void a(int i) {
        this.f.setBackgroundColor(i);
    }

    public void b(int i) {
        this.d.setTextColor(i);
    }
}
