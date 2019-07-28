package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d implements a.InterfaceC0080a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0080a
    public void a() {
        a.CountDownTimerC0077a countDownTimerC0077a;
        a.CountDownTimerC0077a countDownTimerC0077a2;
        countDownTimerC0077a = this.a.q;
        if (countDownTimerC0077a != null) {
            countDownTimerC0077a2 = this.a.q;
            countDownTimerC0077a2.cancel();
        }
    }
}
