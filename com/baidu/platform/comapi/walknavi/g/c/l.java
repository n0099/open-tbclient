package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3040a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.f3040a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        Context context;
        RelativeLayout relativeLayout2;
        if (com.baidu.platform.comapi.walknavi.b.a().M() == 4) {
            this.f3040a.c.setChecked(false);
        } else if (com.baidu.platform.comapi.walknavi.b.a().K().a("WALKNAVI_VOICE_ON_OFF", true)) {
            this.f3040a.c.setChecked(true);
        } else {
            this.f3040a.c.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().K().a("WALKNAVI_STREET_POI_ON_OFF", true)) {
            this.f3040a.d.setChecked(true);
        } else {
            this.f3040a.d.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().K().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
            this.f3040a.e.setChecked(true);
        } else {
            this.f3040a.e.setChecked(false);
        }
        try {
            context = this.f3040a.l;
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(context, R.layout.abc_action_menu_layout);
            relativeLayout2 = this.f3040a.H;
            relativeLayout2.setAnimation(c);
        } catch (Exception e) {
        }
        relativeLayout = this.f3040a.H;
        relativeLayout.setVisibility(0);
    }
}
