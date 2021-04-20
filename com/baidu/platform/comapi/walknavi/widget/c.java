package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9785a;

    public c(a aVar) {
        this.f9785a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0127a interfaceC0127a;
        a.InterfaceC0127a interfaceC0127a2;
        interfaceC0127a = this.f9785a.f9783h;
        if (interfaceC0127a != null) {
            interfaceC0127a2 = this.f9785a.f9783h;
            interfaceC0127a2.a();
        }
        this.f9785a.dismiss();
    }
}
