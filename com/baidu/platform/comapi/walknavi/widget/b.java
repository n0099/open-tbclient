package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3093a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0291a interfaceC0291a;
        a.InterfaceC0291a interfaceC0291a2;
        interfaceC0291a = this.f3093a.g;
        if (interfaceC0291a != null) {
            interfaceC0291a2 = this.f3093a.g;
            interfaceC0291a2.a();
        }
        this.f3093a.dismiss();
    }
}
