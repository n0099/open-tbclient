package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements a.InterfaceC0233a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0233a
    public void a() {
        a.CountDownTimerC0230a countDownTimerC0230a;
        a.CountDownTimerC0230a countDownTimerC0230a2;
        a.CountDownTimerC0230a countDownTimerC0230a3;
        countDownTimerC0230a = this.a.q;
        if (countDownTimerC0230a != null) {
            countDownTimerC0230a2 = this.a.q;
            countDownTimerC0230a2.onFinish();
            countDownTimerC0230a3 = this.a.q;
            countDownTimerC0230a3.cancel();
            return;
        }
        this.a.q();
    }
}
