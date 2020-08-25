package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class f implements a.InterfaceC0254a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0254a
    public void a() {
        a.CountDownTimerC0251a countDownTimerC0251a;
        a.CountDownTimerC0251a countDownTimerC0251a2;
        a.CountDownTimerC0251a countDownTimerC0251a3;
        countDownTimerC0251a = this.a.o;
        if (countDownTimerC0251a != null) {
            countDownTimerC0251a2 = this.a.o;
            countDownTimerC0251a2.onFinish();
            countDownTimerC0251a3 = this.a.o;
            countDownTimerC0251a3.cancel();
            return;
        }
        this.a.q();
    }
}
