package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        Context context;
        RelativeLayout relativeLayout2;
        if (com.baidu.platform.comapi.walknavi.b.a().E() == 4) {
            this.a.c.setChecked(false);
        } else if (com.baidu.platform.comapi.walknavi.b.a().C().a("WALKNAVI_VOICE_ON_OFF", true)) {
            this.a.c.setChecked(true);
        } else {
            this.a.c.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().C().a("WALKNAVI_STREET_POI_ON_OFF", true)) {
            this.a.d.setChecked(true);
        } else {
            this.a.d.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().C().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
            this.a.e.setChecked(true);
        } else {
            this.a.e.setChecked(false);
        }
        try {
            context = this.a.i;
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(context, R.anim.abc_popup_enter);
            relativeLayout2 = this.a.D;
            relativeLayout2.setAnimation(c);
        } catch (Exception e) {
        }
        relativeLayout = this.a.D;
        relativeLayout.setVisibility(0);
    }
}
