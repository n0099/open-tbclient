package com.baidu.platform.comapi.walknavi.g.c;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3053a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(c cVar) {
        this.f3053a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.g.a aVar;
        com.baidu.platform.comapi.walknavi.g.a aVar2;
        aVar = this.f3053a.m;
        if (aVar != null) {
            System.out.println("mBarQuit onClick showQuitDialog");
            aVar2 = this.f3053a.m;
            aVar2.a(false, R.raw.aiapp_guide);
        }
    }
}
