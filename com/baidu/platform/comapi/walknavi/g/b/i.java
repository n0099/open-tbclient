package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f9657a;

    public i(h hVar) {
        this.f9657a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        View view;
        context = this.f9657a.f9656a.l;
        if (context == null) {
            return;
        }
        context2 = this.f9657a.f9656a.l;
        Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(context2, R.attr.SapiSdkDividerColor);
        view = this.f9657a.f9656a.ab;
        view.startAnimation(c2);
        c2.setAnimationListener(new j(this));
    }
}
