package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3038a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3038a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0295a interfaceC0295a;
        a.InterfaceC0295a interfaceC0295a2;
        interfaceC0295a = this.f3038a.g;
        if (interfaceC0295a != null) {
            interfaceC0295a2 = this.f3038a.g;
            interfaceC0295a2.a();
        }
        this.f3038a.dismiss();
    }
}
