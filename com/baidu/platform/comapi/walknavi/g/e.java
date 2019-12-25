package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e implements a.InterfaceC0137a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0137a
    public void a() {
        a.CountDownTimerC0134a countDownTimerC0134a;
        a.CountDownTimerC0134a countDownTimerC0134a2;
        a.CountDownTimerC0134a countDownTimerC0134a3;
        countDownTimerC0134a = this.a.q;
        if (countDownTimerC0134a != null) {
            countDownTimerC0134a2 = this.a.q;
            countDownTimerC0134a2.onFinish();
            countDownTimerC0134a3 = this.a.q;
            countDownTimerC0134a3.cancel();
            return;
        }
        this.a.q();
    }
}
