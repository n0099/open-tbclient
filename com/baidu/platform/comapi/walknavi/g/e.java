package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements a.InterfaceC0289a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f4338a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0289a
    public void a() {
        a.CountDownTimerC0286a countDownTimerC0286a;
        a.CountDownTimerC0286a countDownTimerC0286a2;
        a.CountDownTimerC0286a countDownTimerC0286a3;
        countDownTimerC0286a = this.f4338a.q;
        if (countDownTimerC0286a != null) {
            countDownTimerC0286a2 = this.f4338a.q;
            countDownTimerC0286a2.onFinish();
            countDownTimerC0286a3 = this.f4338a.q;
            countDownTimerC0286a3.cancel();
            return;
        }
        this.f4338a.q();
    }
}
