package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10226a;

    public b(a aVar) {
        this.f10226a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0128a interfaceC0128a;
        a.InterfaceC0128a interfaceC0128a2;
        interfaceC0128a = this.f10226a.f10224g;
        if (interfaceC0128a != null) {
            interfaceC0128a2 = this.f10226a.f10224g;
            interfaceC0128a2.a();
        }
        this.f10226a.dismiss();
    }
}
