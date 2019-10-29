package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e implements a.InterfaceC0121a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0121a
    public void a() {
        a.CountDownTimerC0118a countDownTimerC0118a;
        a.CountDownTimerC0118a countDownTimerC0118a2;
        a.CountDownTimerC0118a countDownTimerC0118a3;
        countDownTimerC0118a = this.a.q;
        if (countDownTimerC0118a != null) {
            countDownTimerC0118a2 = this.a.q;
            countDownTimerC0118a2.onFinish();
            countDownTimerC0118a3 = this.a.q;
            countDownTimerC0118a3.cancel();
            return;
        }
        this.a.q();
    }
}
