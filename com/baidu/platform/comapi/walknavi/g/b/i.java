package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f4304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f4304a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        View view;
        context = this.f4304a.f4303a.l;
        if (context != null) {
            context2 = this.f4304a.f4303a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(context2, R.attr.actionBarDivider);
            view = this.f4304a.f4303a.ab;
            view.startAnimation(c);
            c.setAnimationListener(new j(this));
        }
    }
}
