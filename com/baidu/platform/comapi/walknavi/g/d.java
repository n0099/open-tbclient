package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements a.InterfaceC0148a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0148a
    public void a() {
        a.CountDownTimerC0145a countDownTimerC0145a;
        a.CountDownTimerC0145a countDownTimerC0145a2;
        countDownTimerC0145a = this.a.q;
        if (countDownTimerC0145a != null) {
            countDownTimerC0145a2 = this.a.q;
            countDownTimerC0145a2.cancel();
        }
    }
}
