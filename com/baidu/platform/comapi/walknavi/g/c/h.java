package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.g.d.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class h implements a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3034a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.f3034a = cVar;
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
            context = this.f3034a.l;
            if (context != null) {
                com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG.calorieAnimation");
                int a2 = com.baidu.platform.comapi.walknavi.g.d.a.a().a(i);
                if (a2 != -1) {
                    imageView = this.f3034a.am;
                    context2 = this.f3034a.l;
                    imageView.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(context2, a2));
                    if (i2 >= 1) {
                        textView2 = this.f3034a.an;
                        textView2.setVisibility(0);
                        textView3 = this.f3034a.an;
                        textView3.setText("×" + i2);
                    } else {
                        textView = this.f3034a.an;
                        textView.setVisibility(8);
                    }
                    view = this.f3034a.ah;
                    if (view.getVisibility() == 8) {
                        context3 = this.f3034a.l;
                        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(context3, R.layout.abc_activity_chooser_view_list_item);
                        view2 = this.f3034a.ah;
                        view2.setAnimation(c);
                        view3 = this.f3034a.ah;
                        view3.setVisibility(0);
                        view4 = this.f3034a.ah;
                        view4.postDelayed(new i(this), 4000L);
                    }
                }
            }
        }
    }
}
