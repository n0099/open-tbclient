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
        a.InterfaceC0227a interfaceC0227a;
        a.InterfaceC0227a interfaceC0227a2;
        interfaceC0227a = this.a.g;
        if (interfaceC0227a != null) {
            interfaceC0227a2 = this.a.g;
            interfaceC0227a2.a();
        }
        this.a.dismiss();
    }
}
