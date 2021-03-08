package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements a.InterfaceC0295a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3003a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3003a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0295a
    public void a() {
        a.CountDownTimerC0292a countDownTimerC0292a;
        a.CountDownTimerC0292a countDownTimerC0292a2;
        a.CountDownTimerC0292a countDownTimerC0292a3;
        countDownTimerC0292a = this.f3003a.q;
        if (countDownTimerC0292a != null) {
            countDownTimerC0292a2 = this.f3003a.q;
            countDownTimerC0292a2.onFinish();
            countDownTimerC0292a3 = this.f3003a.q;
            countDownTimerC0292a3.cancel();
            return;
        }
        this.f3003a.q();
    }
}
