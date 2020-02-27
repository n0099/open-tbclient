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
        a.InterfaceC0148a interfaceC0148a;
        a.InterfaceC0148a interfaceC0148a2;
        interfaceC0148a = this.a.g;
        if (interfaceC0148a != null) {
            interfaceC0148a2 = this.a.g;
            interfaceC0148a2.a();
        }
        this.a.dismiss();
    }
}
