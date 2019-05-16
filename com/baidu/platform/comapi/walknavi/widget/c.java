package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0075a interfaceC0075a;
        a.InterfaceC0075a interfaceC0075a2;
        interfaceC0075a = this.a.h;
        if (interfaceC0075a != null) {
            interfaceC0075a2 = this.a.h;
            interfaceC0075a2.a();
        }
        this.a.dismiss();
    }
}
