package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements a.InterfaceC0291a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f3061a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0291a
    public void a() {
        a.CountDownTimerC0288a countDownTimerC0288a;
        a.CountDownTimerC0288a countDownTimerC0288a2;
        a.CountDownTimerC0288a countDownTimerC0288a3;
        countDownTimerC0288a = this.f3061a.o;
        if (countDownTimerC0288a != null) {
            countDownTimerC0288a2 = this.f3061a.o;
            countDownTimerC0288a2.onFinish();
            countDownTimerC0288a3 = this.f3061a.o;
            countDownTimerC0288a3.cancel();
            return;
        }
        this.f3061a.q();
    }
}
