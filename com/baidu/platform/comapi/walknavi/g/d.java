package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d implements a.InterfaceC0073a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0073a
    public void a() {
        a.CountDownTimerC0070a countDownTimerC0070a;
        a.CountDownTimerC0070a countDownTimerC0070a2;
        countDownTimerC0070a = this.a.q;
        if (countDownTimerC0070a != null) {
            countDownTimerC0070a2 = this.a.q;
            countDownTimerC0070a2.cancel();
        }
    }
}
