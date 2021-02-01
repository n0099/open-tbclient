package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4389a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f4389a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0289a interfaceC0289a;
        a.InterfaceC0289a interfaceC0289a2;
        interfaceC0289a = this.f4389a.h;
        if (interfaceC0289a != null) {
            interfaceC0289a2 = this.f4389a.h;
            interfaceC0289a2.a();
        }
        this.f4389a.dismiss();
    }
}
