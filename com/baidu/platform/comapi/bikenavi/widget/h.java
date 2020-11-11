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
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class h extends com.baidu.platform.comapi.walknavi.g.c.b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f2853a;
    private com.baidu.platform.comapi.bikenavi.c.b b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;
    private RelativeLayout h;
    private a.c i = null;
    private boolean j = false;

    public h(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f2853a = (Activity) context;
        this.b = bVar;
        a(view);
        g();
    }

    private void a(View view) {
        this.h = (RelativeLayout) view.findViewById(2131165220);
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
            View inflate = LayoutInflater.from(this.f2853a).inflate(a2, (ViewGroup) this.h, false);
            if (inflate == null) {
                Log.e("CustomWNaviView", "Load BikeTopGuide layout failed,please checking layout.");
                return false;
            } else if (!com.baidu.platform.comapi.walknavi.g.d.d.a().a(this.f2853a, 4, a2, this)) {
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
                    this.g = inflate.findViewById(Integer.parseInt(this.i.b().replace(UgcConstant.AT_RULE_TAG, "")));
                    this.c = (ImageView) inflate.findViewById(Integer.parseInt(this.i.a().replace(UgcConstant.AT_RULE_TAG, "")));
                    this.d = (TextView) inflate.findViewById(Integer.parseInt(this.i.c().replace(UgcConstant.AT_RULE_TAG, "")));
                    this.e = (TextView) inflate.findViewById(Integer.parseInt(this.i.d().replace(UgcConstant.AT_RULE_TAG, "")));
                    this.f = (TextView) inflate.findViewById(Integer.parseInt(this.i.e().replace(UgcConstant.AT_RULE_TAG, "")));
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
            this.g = view.findViewById(2131165221);
            this.c = (ImageView) view.findViewById(2131165224);
            this.d = (TextView) view.findViewById(2131165225);
            this.e = (TextView) view.findViewById(2131165222);
            this.f = (TextView) view.findViewById(2131165223);
        }
    }

    public void c() {
        if (this.g.getVisibility() == 8) {
            this.g.setVisibility(0);
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f2853a, R.layout.abc_action_bar_title_item);
            this.g.setAnimation(c);
            c.setAnimationListener(new i(this));
            c.start();
        }
    }

    public void d() {
        if (this.g.getVisibility() == 0) {
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f2853a, R.layout.abc_action_menu_item_layout);
            c.setAnimationListener(new j(this));
            this.g.startAnimation(c);
        }
    }

    public void a(int i, String str) {
        if (i == R.drawable.abc_btn_radio_material || i == R.drawable.abc_action_bar_item_background_material) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f2826a) {
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
