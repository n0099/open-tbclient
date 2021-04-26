package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.platform.comapi.walknavi.g.c.a;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h implements a.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10016a;

    public h(c cVar) {
        this.f10016a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.a.c
    public void a(int i2, int i3) {
        Context context;
        ImageView imageView;
        Context context2;
        TextView textView;
        View view;
        Context context3;
        View view2;
        View view3;
        View view4;
        TextView textView2;
        TextView textView3;
        if (i2 != -1) {
            context = this.f10016a.l;
            if (context == null) {
                return;
            }
            com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.calorieAnimation");
            int a2 = com.baidu.platform.comapi.walknavi.g.c.a.a().a(i2);
            if (a2 != -1) {
                imageView = this.f10016a.ae;
                context2 = this.f10016a.l;
                imageView.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(context2, a2));
                if (i3 >= 1) {
                    textView2 = this.f10016a.af;
                    textView2.setVisibility(0);
                    textView3 = this.f10016a.af;
                    textView3.setText("×" + i3);
                } else {
                    textView = this.f10016a.af;
                    textView.setVisibility(8);
                }
                view = this.f10016a.ab;
                if (view.getVisibility() != 8) {
                    return;
                }
                context3 = this.f10016a.l;
                Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(context3, R.attr.SapiSdkHint);
                view2 = this.f10016a.ab;
                view2.setAnimation(c2);
                view3 = this.f10016a.ab;
                view3.setVisibility(0);
                view4 = this.f10016a.ab;
                view4.postDelayed(new i(this), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            }
        }
    }
}
