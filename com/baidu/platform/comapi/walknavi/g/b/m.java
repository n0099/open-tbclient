package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        context = this.a.i;
        if (context != null) {
            context2 = this.a.i;
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(context2, R.anim.abc_popup_exit);
            relativeLayout = this.a.D;
            relativeLayout.setAnimation(c);
            relativeLayout2 = this.a.D;
            relativeLayout2.setVisibility(8);
        }
    }
}
