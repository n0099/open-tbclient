package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d implements a.InterfaceC0075a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0075a
    public void a() {
        a.CountDownTimerC0072a countDownTimerC0072a;
        a.CountDownTimerC0072a countDownTimerC0072a2;
        countDownTimerC0072a = this.a.q;
        if (countDownTimerC0072a != null) {
            countDownTimerC0072a2 = this.a.q;
            countDownTimerC0072a2.cancel();
        }
    }
}
