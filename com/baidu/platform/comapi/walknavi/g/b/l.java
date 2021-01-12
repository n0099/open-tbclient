package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.f4307a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        Context context;
        RelativeLayout relativeLayout2;
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            this.f4307a.c.setChecked(false);
        } else if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_VOICE_ON_OFF", true)) {
            this.f4307a.c.setChecked(true);
        } else {
            this.f4307a.c.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_STREET_POI_ON_OFF", true)) {
            this.f4307a.d.setChecked(true);
        } else {
            this.f4307a.d.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
            this.f4307a.e.setChecked(true);
        } else {
            this.f4307a.e.setChecked(false);
        }
        try {
            context = this.f4307a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(context, R.attr.actionBarItemBackground);
            relativeLayout2 = this.f4307a.G;
            relativeLayout2.setAnimation(c);
        } catch (Exception e) {
        }
        relativeLayout = this.f4307a.G;
        relativeLayout.setVisibility(0);
    }
}
