package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10225a;

    public b(a aVar) {
        this.f10225a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0127a interfaceC0127a;
        a.InterfaceC0127a interfaceC0127a2;
        interfaceC0127a = this.f10225a.f10223g;
        if (interfaceC0127a != null) {
            interfaceC0127a2 = this.f10225a.f10223g;
            interfaceC0127a2.a();
        }
        this.f10225a.dismiss();
    }
}
