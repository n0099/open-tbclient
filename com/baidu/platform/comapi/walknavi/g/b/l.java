package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10102a;

    public l(c cVar) {
        this.f10102a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        Context context;
        RelativeLayout relativeLayout2;
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            this.f10102a.f10086c.setChecked(false);
        } else if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_VOICE_ON_OFF", true)) {
            this.f10102a.f10086c.setChecked(true);
        } else {
            this.f10102a.f10086c.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_STREET_POI_ON_OFF", true)) {
            this.f10102a.f10087d.setChecked(true);
        } else {
            this.f10102a.f10087d.setChecked(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
            this.f10102a.f10088e.setChecked(true);
        } else {
            this.f10102a.f10088e.setChecked(false);
        }
        try {
            context = this.f10102a.l;
            Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(context, R.attr.SapiSdkDividerPadding);
            relativeLayout2 = this.f10102a.G;
            relativeLayout2.setAnimation(c2);
        } catch (Exception unused) {
        }
        relativeLayout = this.f10102a.G;
        relativeLayout.setVisibility(0);
    }
}
