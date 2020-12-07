package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3037a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3037a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        View view;
        context = this.f3037a.f3036a.l;
        if (context != null) {
            context2 = this.f3037a.f3036a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(context2, R.layout.abc_action_menu_item_layout);
            view = this.f3037a.f3036a.ah;
            view.startAnimation(c);
            c.setAnimationListener(new j(this));
        }
    }
}
