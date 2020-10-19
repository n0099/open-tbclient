package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3091a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0267a interfaceC0267a;
        a.InterfaceC0267a interfaceC0267a2;
        interfaceC0267a = this.f3091a.g;
        if (interfaceC0267a != null) {
            interfaceC0267a2 = this.f3091a.g;
            interfaceC0267a2.a();
        }
        this.f3091a.dismiss();
    }
}
