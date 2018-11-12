package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements a.InterfaceC0105a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0105a
    public void a() {
        a.CountDownTimerC0103a countDownTimerC0103a;
        a.CountDownTimerC0103a countDownTimerC0103a2;
        countDownTimerC0103a = this.a.q;
        if (countDownTimerC0103a != null) {
            countDownTimerC0103a2 = this.a.q;
            countDownTimerC0103a2.cancel();
        }
    }
}
