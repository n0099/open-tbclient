package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0194a interfaceC0194a;
        a.InterfaceC0194a interfaceC0194a2;
        interfaceC0194a = this.a.g;
        if (interfaceC0194a != null) {
            interfaceC0194a2 = this.a.g;
            interfaceC0194a2.a();
        }
        this.a.dismiss();
    }
}
