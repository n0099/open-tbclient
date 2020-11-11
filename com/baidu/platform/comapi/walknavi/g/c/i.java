package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3035a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        View view;
        context = this.f3035a.f3034a.l;
        if (context != null) {
            context2 = this.f3035a.f3034a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(context2, R.layout.abc_action_menu_item_layout);
            view = this.f3035a.f3034a.ah;
            view.startAnimation(c);
            c.setAnimationListener(new j(this));
        }
    }
}
