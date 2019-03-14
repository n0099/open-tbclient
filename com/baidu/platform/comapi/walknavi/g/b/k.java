package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        context = this.a.l;
        if (context != null) {
            context2 = this.a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(context2, R.anim.abc_popup_exit);
            relativeLayout = this.a.G;
            relativeLayout.setAnimation(c);
            relativeLayout2 = this.a.G;
            relativeLayout2.setVisibility(8);
        }
    }
}
