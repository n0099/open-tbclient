package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d implements a.InterfaceC0089a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0089a
    public void a() {
        a.CountDownTimerC0086a countDownTimerC0086a;
        a.CountDownTimerC0086a countDownTimerC0086a2;
        countDownTimerC0086a = this.a.q;
        if (countDownTimerC0086a != null) {
            countDownTimerC0086a2 = this.a.q;
            countDownTimerC0086a2.cancel();
        }
    }
}
