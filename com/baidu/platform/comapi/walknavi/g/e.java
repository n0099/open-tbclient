package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e implements a.InterfaceC0089a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0089a
    public void a() {
        a.CountDownTimerC0086a countDownTimerC0086a;
        a.CountDownTimerC0086a countDownTimerC0086a2;
        a.CountDownTimerC0086a countDownTimerC0086a3;
        countDownTimerC0086a = this.a.q;
        if (countDownTimerC0086a != null) {
            countDownTimerC0086a2 = this.a.q;
            countDownTimerC0086a2.onFinish();
            countDownTimerC0086a3 = this.a.q;
            countDownTimerC0086a3.cancel();
            return;
        }
        this.a.q();
    }
}
