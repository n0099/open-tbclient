package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3096a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3096a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0302a interfaceC0302a;
        a.InterfaceC0302a interfaceC0302a2;
        interfaceC0302a = this.f3096a.h;
        if (interfaceC0302a != null) {
            interfaceC0302a2 = this.f3096a.h;
            interfaceC0302a2.a();
        }
        this.f3096a.dismiss();
    }
}
