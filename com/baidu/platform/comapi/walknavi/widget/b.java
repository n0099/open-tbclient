package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4385a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0285a interfaceC0285a;
        a.InterfaceC0285a interfaceC0285a2;
        interfaceC0285a = this.f4385a.g;
        if (interfaceC0285a != null) {
            interfaceC0285a2 = this.f4385a.g;
            interfaceC0285a2.a();
        }
        this.f4385a.dismiss();
    }
}
