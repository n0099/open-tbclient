package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2995a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(c cVar) {
        this.f2995a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.g.a aVar;
        com.baidu.platform.comapi.walknavi.g.a aVar2;
        aVar = this.f2995a.m;
        if (aVar != null) {
            System.out.println("mBarQuit onClick showQuitDialog");
            aVar2 = this.f2995a.m;
            aVar2.a(false, R.drawable.res_0x7f080001_avd_hide_password__1);
        }
    }
}
