package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements a.InterfaceC0172a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0172a
    public void a() {
        a.CountDownTimerC0169a countDownTimerC0169a;
        a.CountDownTimerC0169a countDownTimerC0169a2;
        countDownTimerC0169a = this.a.q;
        if (countDownTimerC0169a != null) {
            countDownTimerC0169a2 = this.a.q;
            countDownTimerC0169a2.cancel();
        }
    }
}
