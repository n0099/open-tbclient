package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0252a interfaceC0252a;
        a.InterfaceC0252a interfaceC0252a2;
        interfaceC0252a = this.a.h;
        if (interfaceC0252a != null) {
            interfaceC0252a2 = this.a.h;
            interfaceC0252a2.a();
        }
        this.a.dismiss();
    }
}
