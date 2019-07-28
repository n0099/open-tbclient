package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0080a interfaceC0080a;
        a.InterfaceC0080a interfaceC0080a2;
        interfaceC0080a = this.a.g;
        if (interfaceC0080a != null) {
            interfaceC0080a2 = this.a.g;
            interfaceC0080a2.a();
        }
        this.a.dismiss();
    }
}
