package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0254a interfaceC0254a;
        a.InterfaceC0254a interfaceC0254a2;
        interfaceC0254a = this.a.h;
        if (interfaceC0254a != null) {
            interfaceC0254a2 = this.a.h;
            interfaceC0254a2.a();
        }
        this.a.dismiss();
    }
}
