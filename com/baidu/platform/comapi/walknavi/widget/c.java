package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3092a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0281a interfaceC0281a;
        a.InterfaceC0281a interfaceC0281a2;
        interfaceC0281a = this.f3092a.h;
        if (interfaceC0281a != null) {
            interfaceC0281a2 = this.f3092a.h;
            interfaceC0281a2.a();
        }
        this.f3092a.dismiss();
    }
}
