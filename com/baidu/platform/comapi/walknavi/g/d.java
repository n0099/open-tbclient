package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements a.InterfaceC0194a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0194a
    public void a() {
        a.CountDownTimerC0191a countDownTimerC0191a;
        a.CountDownTimerC0191a countDownTimerC0191a2;
        countDownTimerC0191a = this.a.q;
        if (countDownTimerC0191a != null) {
            countDownTimerC0191a2 = this.a.q;
            countDownTimerC0191a2.cancel();
        }
    }
}
