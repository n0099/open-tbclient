package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.g.c.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class h implements a.c {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.a = cVar;
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
            context = this.a.l;
            if (context != null) {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.calorieAnimation");
                int a = com.baidu.platform.comapi.walknavi.g.c.a.a().a(i);
                if (a != -1) {
                    imageView = this.a.ae;
                    context2 = this.a.l;
                    imageView.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(context2, a));
                    if (i2 >= 1) {
                        textView2 = this.a.af;
                        textView2.setVisibility(0);
                        textView3 = this.a.af;
                        textView3.setText("×" + i2);
                    } else {
                        textView = this.a.af;
                        textView.setVisibility(8);
                    }
                    view = this.a.ab;
                    if (view.getVisibility() == 8) {
                        context3 = this.a.l;
                        Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(context3, R.anim.abc_slide_in_top);
                        view2 = this.a.ab;
                        view2.setAnimation(c);
                        view3 = this.a.ab;
                        view3.setVisibility(0);
                        view4 = this.a.ab;
                        view4.postDelayed(new i(this), 4000L);
                    }
                }
            }
        }
    }
}
