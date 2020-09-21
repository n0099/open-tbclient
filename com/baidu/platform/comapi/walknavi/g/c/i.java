package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        View view;
        context = this.a.a.l;
        if (context != null) {
            context2 = this.a.a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(context2, R.layout.abc_action_menu_item_layout);
            view = this.a.a.ah;
            view.startAnimation(c);
            c.setAnimationListener(new j(this));
        }
    }
}
