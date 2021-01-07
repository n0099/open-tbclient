package com.baidu.platform.comapi.walknavi.widget;

import android.annotation.TargetApi;
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
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mapapi.walknavi.model.a;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d extends com.baidu.platform.comapi.walknavi.g.c.b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f4605a;

    /* renamed from: b  reason: collision with root package name */
    private com.baidu.platform.comapi.walknavi.g.a f4606b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private View h;
    private RelativeLayout i;
    private View j;
    private boolean k = false;
    private int l = 0;
    private a.c m;

    public d(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        this.f4605a = (Activity) context;
        this.f4606b = aVar;
        a(view);
    }

    private void a(View view) {
        this.i = (RelativeLayout) view.findViewById(R.dimen.abc_dialog_fixed_height_minor);
        WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
        if (n == null || !n.getIsCustomWNaviGuideLayout()) {
            b(view);
        } else if (!i()) {
            b(view);
        }
    }

    private void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        if (walkNaviDisplayOption != null && walkNaviDisplayOption.getWNaviTextTypeface() != null) {
            this.d.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.e.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.f.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.g.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
        }
    }

    private boolean i() {
        WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
        if (n == null) {
            Log.e("CustomWNaviView", "Load TopGuide layout failed,WalkNaviDisplayOption is null.");
            return false;
        }
        int topGuideLayout = n.getTopGuideLayout();
        if (topGuideLayout == 0) {
            Log.e("CustomWNaviView", "TopGuide layout resource is empty.");
            return false;
        } else if (this.i == null) {
            Log.e("CustomWNaviView", "TopGuide layout add failed.");
            return false;
        } else {
            View inflate = LayoutInflater.from(this.f4605a).inflate(topGuideLayout, (ViewGroup) this.i, false);
            if (inflate == null) {
                Log.e("CustomWNaviView", "Load topGuide layout failed,please checking layout.");
                return false;
            } else if (!com.baidu.platform.comapi.walknavi.g.d.d.a().a(this.f4605a, 1, topGuideLayout, this)) {
                Log.e("CustomWNaviView", "Parser topGuide layout failed,please checking layout.");
                return false;
            } else if (this.m == null) {
                Log.e("CustomWNaviView", "Parser topGuide layout failed,missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else if (TextUtils.isEmpty(this.m.a()) || TextUtils.isEmpty(this.m.b()) || TextUtils.isEmpty(this.m.c()) || TextUtils.isEmpty(this.m.d()) || TextUtils.isEmpty(this.m.e()) || TextUtils.isEmpty(this.m.f()) || TextUtils.isEmpty(this.m.g()) || TextUtils.isEmpty(this.m.h())) {
                Log.e("CustomWNaviView", "TopGuide layout missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else {
                try {
                    this.j = inflate.findViewById(Integer.parseInt(this.m.a().replace("@", "")));
                    this.h = inflate.findViewById(Integer.parseInt(this.m.d().replace("@", "")));
                    this.c = (ImageView) inflate.findViewById(Integer.parseInt(this.m.c().replace("@", "")));
                    this.e = (TextView) inflate.findViewById(Integer.parseInt(this.m.e().replace("@", "")));
                    this.d = (TextView) inflate.findViewById(Integer.parseInt(this.m.f().replace("@", "")));
                    this.f = (TextView) inflate.findViewById(Integer.parseInt(this.m.f().replace("@", "")));
                    this.g = (TextView) inflate.findViewById(Integer.parseInt(this.m.f().replace("@", "")));
                    this.l = Integer.parseInt(this.m.b().replace("@", ""));
                    if (this.d == null || this.j == null || this.c == null || this.h == null || this.e == null || this.l == 0 || this.f == null || this.g == null) {
                        Log.e("CustomWNaviView", "TopGuide layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                        return false;
                    }
                    this.i.removeAllViews();
                    this.i.addView(inflate);
                    this.k = true;
                    this.i.setBackgroundColor(0);
                    this.h.setVisibility(8);
                    a(n);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("CustomWNaviView", "TopGuide layout control type error.");
                    return false;
                }
            }
        }
    }

    private void b(View view) {
        if (view != null) {
            this.c = (ImageView) view.findViewById(R.dimen.M_W_X015);
            this.d = (TextView) view.findViewById(R.dimen.M_W_X016);
            this.e = (TextView) view.findViewById(R.dimen.abc_dialog_fixed_width_major);
            this.h = view.findViewById(R.dimen.M_W_X012);
            this.f = (TextView) view.findViewById(R.dimen.M_W_X013);
            this.g = (TextView) view.findViewById(R.dimen.M_W_X014);
            this.h.setVisibility(8);
            a(com.baidu.platform.comapi.walknavi.b.a().n());
        }
    }

    public void c() {
        if (this.h.getVisibility() == 8) {
            this.d.setVisibility(8);
            this.e.setVisibility(4);
            this.h.setVisibility(0);
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f4605a, R.attr.absListViewStyle);
            this.h.setAnimation(c);
            c.setAnimationListener(new e(this));
            c.start();
        }
    }

    public void d() {
        if (this.h.getVisibility() == 0) {
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f4605a, R.attr.actionBarDivider);
            c.setAnimationListener(new f(this));
            this.h.startAnimation(c);
        }
    }

    public void a(int i, String str) {
        if (i == 2130837582) {
            this.d.setVisibility(8);
            this.e.setVisibility(4);
        } else {
            this.d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f4195a) {
            this.c.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.f4605a, i));
        } else {
            this.c.setImageResource(i);
        }
        if (i == 2130837638 || i == 2130837639) {
            this.d.setText("步行导航开始");
        } else {
            this.d.setText(str);
        }
    }

    public void a(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            this.e.setText("全程剩余:" + str + " " + str2);
        }
    }

    public void g() {
        this.e.setVisibility(4);
    }

    public void h() {
        if (this.h.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
    }

    public void a(int i) {
        if (this.k && this.j != null) {
            this.j.setBackgroundColor(i);
        } else {
            this.i.setBackgroundColor(i);
        }
    }

    @TargetApi(16)
    public void b(int i) {
        if (this.k && this.j != null && this.l != 0) {
            this.j.setBackgroundResource(this.l);
        } else {
            this.i.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.f4605a, i));
        }
    }

    public void a(a.c cVar) {
        this.m = cVar;
    }
}
