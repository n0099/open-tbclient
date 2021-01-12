package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(c cVar) {
        this.f4324a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.g.a aVar;
        com.baidu.platform.comapi.walknavi.g.a aVar2;
        aVar = this.f4324a.m;
        if (aVar != null) {
            System.out.println("mBarQuitBtn onClick showQuitDialog");
            aVar2 = this.f4324a.m;
            aVar2.a(false, R.drawable.res_0x7f080001_avd_hide_password__1);
        }
    }
}
