package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements a.InterfaceC0267a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3058a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0267a
    public void a() {
        a.CountDownTimerC0264a countDownTimerC0264a;
        a.CountDownTimerC0264a countDownTimerC0264a2;
        countDownTimerC0264a = this.f3058a.o;
        if (countDownTimerC0264a != null) {
            countDownTimerC0264a2 = this.f3058a.o;
            countDownTimerC0264a2.cancel();
        }
    }
}
