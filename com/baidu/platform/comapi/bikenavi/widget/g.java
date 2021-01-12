package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g extends com.baidu.platform.comapi.walknavi.g.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f4174a;

    /* renamed from: b  reason: collision with root package name */
    private com.baidu.platform.comapi.bikenavi.c.b f4175b;
    private ImageView c;
    private TextView d;
    private View e;

    public g(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f4174a = (Activity) context;
        this.f4175b = bVar;
        a(view);
    }

    private void a(View view) {
        this.c = (ImageView) view.findViewById(R.dimen.M_W_X006);
        this.d = (TextView) view.findViewById(R.dimen.M_W_X007);
        this.e = view.findViewById(R.dimen.M_W_X005);
        this.e.setVisibility(8);
    }

    public void c() {
        if (this.e.getVisibility() == 8) {
            this.e.setVisibility(0);
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f4174a, R.attr.absListViewStyle);
            this.e.setAnimation(c);
            c.setAnimationListener(new h(this));
            c.start();
        }
    }

    public void d() {
        if (this.e.getVisibility() == 0) {
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.f4174a, R.attr.actionBarDivider);
            c.setAnimationListener(new i(this));
            this.e.startAnimation(c);
        }
    }

    public void a(int i, String str) {
        if (i == R.animator.mtrl_fab_transformation_sheet_collapse_spec || i == R.animator.design_fab_show_motion_spec) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
            this.c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.b().getDrawable(i));
        } else {
            this.c.setImageResource(i);
        }
        this.d.setText(str);
    }
}
