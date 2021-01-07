package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.model.a;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class h extends com.baidu.platform.comapi.walknavi.g.c.b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f4228a;

    /* renamed from: b  reason: collision with root package name */
    private com.baidu.platform.comapi.bikenavi.c.b f4229b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;
    private RelativeLayout h;
    private a.c i = null;
    private boolean j = false;

    public h(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f4228a = (Activity) context;
        this.f4229b = bVar;
        a(view);
        g();
    }

    private void a(View view) {
        this.h = (RelativeLayout) view.findViewById(R.dimen.M_W_X011);
        BNavigatorWrapper.getWNavigator();
        com.baidu.mapapi.bikenavi.model.b p = com.baidu.platform.comapi.walknavi.b.a().p();
        if (p == null || !p.b()) {
            b(view);
            return;
        }
        if (!a(p)) {
            b(view);
        }
        this.g.setVisibility(8);
    }

    private boolean a(com.baidu.mapapi.bikenavi.model.b bVar) {
        if (bVar == null) {
            Log.e("CustomWNaviView", "Load BikeTopGuide layout failed,BikeNaviDisplayOption is null.");
            return false;
        }
        int a2 = bVar.a();
        if (a2 == 0) {
            Log.e("CustomWNaviView", "BikeTopGuide layout resource is empty.");
            return false;
        } else if (this.h == null) {
            Log.e("CustomWNaviView", "BikeTopGuide layout add failed.");
            return false;
        } else {
            View inflate = LayoutInflater.from(this.f4228a).inflate(a2, (ViewGroup) this.h, false);
            if (inflate == null) {
                Log.e("CustomWNaviView", "Load BikeTopGuide layout failed,please checking layout.");
                return false;
            } else if (!com.baidu.platform.comapi.walknavi.g.d.d.a().a(this.f4228a, 4, a2, this)) {
                Log.e("CustomWNaviView", "Parser BikeTopGuide layout failed,please checking layout.");
                return false;
            } else if (this.i == null) {
                Log.e("CustomWNaviView", "Parser BikeTopGuide layout failed,missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else if (TextUtils.isEmpty(this.i.b()) || TextUtils.isEmpty(this.i.a()) || TextUtils.isEmpty(this.i.c()) || TextUtils.isEmpty(this.i.d()) || TextUtils.isEmpty(this.i.e())) {
                Log.e("CustomWNaviView", "BikeTopGuide layout missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else {
                try {
                    this.g = inflate.findViewById(Integer.parseInt(this.i.b().replace("@", "")));
                    this.c = (ImageView) inflate.findViewById(Integer.parseInt(this.i.a().replace("@", "")));
                    this.d = (TextView) inflate.findViewById(Integer.parseInt(this.i.c().replace("@", "")));
                    this.e = (TextView) inflate.findViewById(Integer.parseInt(this.i.d().replace("@", "")));
                    this.f = (TextView) inflate.findViewById(Integer.parseInt(this.i.e().replace("@", "")));
                    if (this.d == null || this.c == null || this.g == null || this.e == null || this.f == null) {
                        Log.e("CustomWNaviView", "BikeTopGuide layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                        return false;
                    }
                    this.h.removeAllViews();
                    this.h.addView(inflate);
                    this.j = true;
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("CustomWNaviView", "BikeTopGuide layout control type error.");
                    return false;
                }
            }
        }
    }

    private void b(View view) {
        if (view != null) {
            this.g = view.findViewById(R.dimen.M_W_X012);
            this.c = (ImageView) view.findViewById(R.dimen.M_W_X015);
            this.d = (TextView) view.findViewById(R.dimen.M_W_X016);
            this.e = (TextView) view.findViewById(R.dimen.M_W_X013);
            this.f = (TextView) view.findViewById(R.dimen.M_W_X014);
        }
    }

    public void c() {
        if (this.g.getVisibility() == 8) {
            this.g.setVisibility(0);
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f4228a, R.attr.absListViewStyle);
            this.g.setAnimation(c);
            c.setAnimationListener(new i(this));
            c.start();
        }
    }

    public void d() {
        if (this.g.getVisibility() == 0) {
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f4228a, R.attr.actionBarDivider);
            c.setAnimationListener(new j(this));
            this.g.startAnimation(c);
        }
    }

    public void a(int i, String str) {
        if (i == R.animator.mtrl_fab_transformation_sheet_collapse_spec || i == R.animator.design_fab_show_motion_spec) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f4195a) {
            this.c.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.b().getDrawable(i));
        } else {
            this.c.setImageResource(i);
        }
        this.d.setText(str);
    }

    private void g() {
        BNavigatorWrapper.getWNavigator();
        com.baidu.mapapi.bikenavi.model.b p = com.baidu.platform.comapi.walknavi.b.a().p();
        if (p != null && p.g() != null) {
            if (this.d != null) {
                this.d.setTypeface(p.g());
            }
            if (this.e != null) {
                this.e.setTypeface(p.g());
            }
            if (this.f != null) {
                this.f.setTypeface(p.g());
            }
        }
    }

    public void a(a.c cVar) {
        this.i = cVar;
    }
}
