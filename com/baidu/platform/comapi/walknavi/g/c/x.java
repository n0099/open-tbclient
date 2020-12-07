package com.baidu.platform.comapi.walknavi.g.c;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3052a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(c cVar) {
        this.f3052a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.g.a aVar;
        com.baidu.platform.comapi.walknavi.g.a aVar2;
        aVar = this.f3052a.m;
        if (aVar != null) {
            System.out.println("mBarQuitBtn onClick showQuitDialog");
            aVar2 = this.f3052a.m;
            aVar2.a(false, R.raw.aiapp_guide);
        }
    }
}
