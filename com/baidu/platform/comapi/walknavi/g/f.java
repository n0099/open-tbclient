package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class f implements a.InterfaceC0302a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3063a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f3063a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0302a
    public void a() {
        a.CountDownTimerC0299a countDownTimerC0299a;
        a.CountDownTimerC0299a countDownTimerC0299a2;
        a.CountDownTimerC0299a countDownTimerC0299a3;
        countDownTimerC0299a = this.f3063a.o;
        if (countDownTimerC0299a != null) {
            countDownTimerC0299a2 = this.f3063a.o;
            countDownTimerC0299a2.onFinish();
            countDownTimerC0299a3 = this.f3063a.o;
            countDownTimerC0299a3.cancel();
            return;
        }
        this.f3063a.q();
    }
}
