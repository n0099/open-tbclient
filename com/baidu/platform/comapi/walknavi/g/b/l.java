package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f9660a;

    public l(c cVar) {
        this.f9660a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        Context context;
        RelativeLayout relativeLayout2;
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            this.f9660a.f9644c.setChecked(false);
        } else if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_VOICE_ON_OFF", true)) {
            this.f9660a.f9644c.setChecked(true);
        } else {
            this.f9660a.f9644c.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_STREET_POI_ON_OFF", true)) {
            this.f9660a.f9645d.setChecked(true);
        } else {
            this.f9660a.f9645d.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
            this.f9660a.f9646e.setChecked(true);
        } else {
            this.f9660a.f9646e.setChecked(false);
        }
        try {
            context = this.f9660a.l;
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(context, R.attr.SapiSdkDividerPadding);
            relativeLayout2 = this.f9660a.G;
            relativeLayout2.setAnimation(c2);
        } catch (Exception unused) {
        }
        relativeLayout = this.f9660a.G;
        relativeLayout.setVisibility(0);
    }
}
