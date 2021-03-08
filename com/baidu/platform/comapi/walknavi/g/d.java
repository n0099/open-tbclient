package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements a.InterfaceC0295a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3002a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f3002a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0295a
    public void a() {
        a.CountDownTimerC0292a countDownTimerC0292a;
        a.CountDownTimerC0292a countDownTimerC0292a2;
        countDownTimerC0292a = this.f3002a.q;
        if (countDownTimerC0292a != null) {
            countDownTimerC0292a2 = this.f3002a.q;
            countDownTimerC0292a2.cancel();
        }
    }
}
