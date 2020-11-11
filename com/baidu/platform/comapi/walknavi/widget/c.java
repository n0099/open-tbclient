package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3094a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0293a interfaceC0293a;
        a.InterfaceC0293a interfaceC0293a2;
        interfaceC0293a = this.f3094a.h;
        if (interfaceC0293a != null) {
            interfaceC0293a2 = this.f3094a.h;
            interfaceC0293a2.a();
        }
        this.f3094a.dismiss();
    }
}
