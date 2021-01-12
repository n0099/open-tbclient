package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements a.InterfaceC0285a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4335a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f4335a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0285a
    public void a() {
        a.CountDownTimerC0282a countDownTimerC0282a;
        a.CountDownTimerC0282a countDownTimerC0282a2;
        a.CountDownTimerC0282a countDownTimerC0282a3;
        countDownTimerC0282a = this.f4335a.q;
        if (countDownTimerC0282a != null) {
            countDownTimerC0282a2 = this.f4335a.q;
            countDownTimerC0282a2.onFinish();
            countDownTimerC0282a3 = this.f4335a.q;
            countDownTimerC0282a3.cancel();
            return;
        }
        this.f4335a.q();
    }
}
