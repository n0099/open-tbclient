package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0105a interfaceC0105a;
        a.InterfaceC0105a interfaceC0105a2;
        interfaceC0105a = this.a.g;
        if (interfaceC0105a != null) {
            interfaceC0105a2 = this.a.g;
            interfaceC0105a2.a();
        }
        this.a.dismiss();
    }
}
