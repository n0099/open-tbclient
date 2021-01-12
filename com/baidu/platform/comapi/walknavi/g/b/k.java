package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.f4306a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        context = this.f4306a.l;
        if (context != null) {
            context2 = this.f4306a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(context2, R.attr.actionBarPopupTheme);
            relativeLayout = this.f4306a.G;
            relativeLayout.setAnimation(c);
            relativeLayout2 = this.f4306a.G;
            relativeLayout2.setVisibility(8);
        }
    }
}
