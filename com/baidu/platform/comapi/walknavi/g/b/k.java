package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10101a;

    public k(c cVar) {
        this.f10101a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        context = this.f10101a.l;
        if (context == null) {
            return;
        }
        context2 = this.f10101a.l;
        Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(context2, R.attr.SapiSdkDividerWidth);
        relativeLayout = this.f10101a.G;
        relativeLayout.setAnimation(c2);
        relativeLayout2 = this.f10101a.G;
        relativeLayout2.setVisibility(8);
    }
}
