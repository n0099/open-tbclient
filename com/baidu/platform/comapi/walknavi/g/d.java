package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements a.InterfaceC0289a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4337a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f4337a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0289a
    public void a() {
        a.CountDownTimerC0286a countDownTimerC0286a;
        a.CountDownTimerC0286a countDownTimerC0286a2;
        countDownTimerC0286a = this.f4337a.q;
        if (countDownTimerC0286a != null) {
            countDownTimerC0286a2 = this.f4337a.q;
            countDownTimerC0286a2.cancel();
        }
    }
}
