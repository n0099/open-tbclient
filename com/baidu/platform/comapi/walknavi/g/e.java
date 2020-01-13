package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements a.InterfaceC0139a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0139a
    public void a() {
        a.CountDownTimerC0136a countDownTimerC0136a;
        a.CountDownTimerC0136a countDownTimerC0136a2;
        a.CountDownTimerC0136a countDownTimerC0136a3;
        countDownTimerC0136a = this.a.q;
        if (countDownTimerC0136a != null) {
            countDownTimerC0136a2 = this.a.q;
            countDownTimerC0136a2.onFinish();
            countDownTimerC0136a3 = this.a.q;
            countDownTimerC0136a3.cancel();
            return;
        }
        this.a.q();
    }
}
