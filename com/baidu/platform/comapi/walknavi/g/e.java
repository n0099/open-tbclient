package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements a.InterfaceC0293a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3060a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0293a
    public void a() {
        a.CountDownTimerC0290a countDownTimerC0290a;
        a.CountDownTimerC0290a countDownTimerC0290a2;
        countDownTimerC0290a = this.f3060a.o;
        if (countDownTimerC0290a != null) {
            countDownTimerC0290a2 = this.f3060a.o;
            countDownTimerC0290a2.cancel();
        }
    }
}
