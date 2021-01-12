package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f4386a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0285a interfaceC0285a;
        a.InterfaceC0285a interfaceC0285a2;
        interfaceC0285a = this.f4386a.h;
        if (interfaceC0285a != null) {
            interfaceC0285a2 = this.f4386a.h;
            interfaceC0285a2.a();
        }
        this.f4386a.dismiss();
    }
}
