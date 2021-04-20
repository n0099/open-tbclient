package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9784a;

    public b(a aVar) {
        this.f9784a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0127a interfaceC0127a;
        a.InterfaceC0127a interfaceC0127a2;
        interfaceC0127a = this.f9784a.f9782g;
        if (interfaceC0127a != null) {
            interfaceC0127a2 = this.f9784a.f9782g;
            interfaceC0127a2.a();
        }
        this.f9784a.dismiss();
    }
}
