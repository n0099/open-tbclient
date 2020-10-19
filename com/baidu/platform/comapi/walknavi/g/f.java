package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements a.InterfaceC0267a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3059a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f3059a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0267a
    public void a() {
        a.CountDownTimerC0264a countDownTimerC0264a;
        a.CountDownTimerC0264a countDownTimerC0264a2;
        a.CountDownTimerC0264a countDownTimerC0264a3;
        countDownTimerC0264a = this.f3059a.o;
        if (countDownTimerC0264a != null) {
            countDownTimerC0264a2 = this.f3059a.o;
            countDownTimerC0264a2.onFinish();
            countDownTimerC0264a3 = this.f3059a.o;
            countDownTimerC0264a3.cancel();
            return;
        }
        this.f3059a.q();
    }
}
