package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements a.InterfaceC0148a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0148a
    public void a() {
        a.CountDownTimerC0145a countDownTimerC0145a;
        a.CountDownTimerC0145a countDownTimerC0145a2;
        a.CountDownTimerC0145a countDownTimerC0145a3;
        countDownTimerC0145a = this.a.q;
        if (countDownTimerC0145a != null) {
            countDownTimerC0145a2 = this.a.q;
            countDownTimerC0145a2.onFinish();
            countDownTimerC0145a3 = this.a.q;
            countDownTimerC0145a3.cancel();
            return;
        }
        this.a.q();
    }
}
