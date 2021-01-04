package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4602a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4602a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0302a interfaceC0302a;
        a.InterfaceC0302a interfaceC0302a2;
        interfaceC0302a = this.f4602a.g;
        if (interfaceC0302a != null) {
            interfaceC0302a2 = this.f4602a.g;
            interfaceC0302a2.a();
        }
        this.f4602a.dismiss();
    }
}
