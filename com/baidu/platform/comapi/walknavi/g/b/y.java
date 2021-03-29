package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10121a;

    public y(c cVar) {
        this.f10121a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.g.a aVar;
        com.baidu.platform.comapi.walknavi.g.a aVar2;
        aVar = this.f10121a.m;
        if (aVar != null) {
            System.out.println("mBarQuit onClick showQuitDialog");
            aVar2 = this.f10121a.m;
            aVar2.a(false, R.drawable.res_0x7f080001_avd_hide_password__1);
        }
    }
}
