package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements a.InterfaceC0291a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3060a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0291a
    public void a() {
        a.CountDownTimerC0288a countDownTimerC0288a;
        a.CountDownTimerC0288a countDownTimerC0288a2;
        countDownTimerC0288a = this.f3060a.o;
        if (countDownTimerC0288a != null) {
            countDownTimerC0288a2 = this.f3060a.o;
            countDownTimerC0288a2.cancel();
        }
    }
}
