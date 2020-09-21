package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f implements a.InterfaceC0252a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0252a
    public void a() {
        a.CountDownTimerC0249a countDownTimerC0249a;
        a.CountDownTimerC0249a countDownTimerC0249a2;
        a.CountDownTimerC0249a countDownTimerC0249a3;
        countDownTimerC0249a = this.a.o;
        if (countDownTimerC0249a != null) {
            countDownTimerC0249a2 = this.a.o;
            countDownTimerC0249a2.onFinish();
            countDownTimerC0249a3 = this.a.o;
            countDownTimerC0249a3.cancel();
            return;
        }
        this.a.q();
    }
}
