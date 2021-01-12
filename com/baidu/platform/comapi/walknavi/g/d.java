package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d implements a.InterfaceC0285a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4334a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f4334a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0285a
    public void a() {
        a.CountDownTimerC0282a countDownTimerC0282a;
        a.CountDownTimerC0282a countDownTimerC0282a2;
        countDownTimerC0282a = this.f4334a.q;
        if (countDownTimerC0282a != null) {
            countDownTimerC0282a2 = this.f4334a.q;
            countDownTimerC0282a2.cancel();
        }
    }
}
