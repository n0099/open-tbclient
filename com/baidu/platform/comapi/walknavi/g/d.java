package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d implements a.InterfaceC0121a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0121a
    public void a() {
        a.CountDownTimerC0118a countDownTimerC0118a;
        a.CountDownTimerC0118a countDownTimerC0118a2;
        countDownTimerC0118a = this.a.q;
        if (countDownTimerC0118a != null) {
            countDownTimerC0118a2 = this.a.q;
            countDownTimerC0118a2.cancel();
        }
    }
}
