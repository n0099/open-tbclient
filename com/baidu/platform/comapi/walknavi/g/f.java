package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements a.InterfaceC0293a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f3061a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0293a
    public void a() {
        a.CountDownTimerC0290a countDownTimerC0290a;
        a.CountDownTimerC0290a countDownTimerC0290a2;
        a.CountDownTimerC0290a countDownTimerC0290a3;
        countDownTimerC0290a = this.f3061a.o;
        if (countDownTimerC0290a != null) {
            countDownTimerC0290a2 = this.f3061a.o;
            countDownTimerC0290a2.onFinish();
            countDownTimerC0290a3 = this.f3061a.o;
            countDownTimerC0290a3.cancel();
            return;
        }
        this.f3061a.q();
    }
}
