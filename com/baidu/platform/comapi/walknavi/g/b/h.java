package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.g.c.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h implements a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2978a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.f2978a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.a.c
    public void a(int i, int i2) {
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
        if (i != -1) {
            context = this.f2978a.l;
            if (context != null) {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.calorieAnimation");
                int a2 = com.baidu.platform.comapi.walknavi.g.c.a.a().a(i);
                if (a2 != -1) {
                    imageView = this.f2978a.ae;
                    context2 = this.f2978a.l;
                    imageView.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(context2, a2));
                    if (i2 >= 1) {
                        textView2 = this.f2978a.af;
                        textView2.setVisibility(0);
                        textView3 = this.f2978a.af;
                        textView3.setText("×" + i2);
                    } else {
                        textView = this.f2978a.af;
                        textView.setVisibility(8);
                    }
                    view = this.f2978a.ab;
                    if (view.getVisibility() == 8) {
                        context3 = this.f2978a.l;
                        Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(context3, R.attr.actionBarStyle);
                        view2 = this.f2978a.ab;
                        view2.setAnimation(c);
                        view3 = this.f2978a.ab;
                        view3.setVisibility(0);
                        view4 = this.f2978a.ab;
                        view4.postDelayed(new i(this), 4000L);
                    }
                }
            }
        }
    }
}
