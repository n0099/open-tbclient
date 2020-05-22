package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements a.InterfaceC0227a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0227a
    public void a() {
        a.CountDownTimerC0224a countDownTimerC0224a;
        a.CountDownTimerC0224a countDownTimerC0224a2;
        countDownTimerC0224a = this.a.q;
        if (countDownTimerC0224a != null) {
            countDownTimerC0224a2 = this.a.q;
            countDownTimerC0224a2.cancel();
        }
    }
}
