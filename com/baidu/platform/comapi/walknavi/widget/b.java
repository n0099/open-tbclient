package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0139a interfaceC0139a;
        a.InterfaceC0139a interfaceC0139a2;
        interfaceC0139a = this.a.g;
        if (interfaceC0139a != null) {
            interfaceC0139a2 = this.a.g;
            interfaceC0139a2.a();
        }
        this.a.dismiss();
    }
}
