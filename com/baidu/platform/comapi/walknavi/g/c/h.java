package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.g.d.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements a.c {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.d.a.c
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
                com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG.calorieAnimation");
                int a = com.baidu.platform.comapi.walknavi.g.d.a.a().a(i);
                if (a != -1) {
                    imageView = this.a.am;
                    context2 = this.a.l;
                    imageView.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(context2, a));
                    if (i2 >= 1) {
                        textView2 = this.a.an;
                        textView2.setVisibility(0);
                        textView3 = this.a.an;
                        textView3.setText("×" + i2);
                    } else {
                        textView = this.a.an;
                        textView.setVisibility(8);
                    }
                    view = this.a.ah;
                    if (view.getVisibility() == 8) {
                        context3 = this.a.l;
                        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(context3, R.layout.abc_activity_chooser_view_list_item);
                        view2 = this.a.ah;
                        view2.setAnimation(c);
                        view3 = this.a.ah;
                        view3.setVisibility(0);
                        view4 = this.a.ah;
                        view4.postDelayed(new i(this), 4000L);
                    }
                }
            }
        }
    }
}
