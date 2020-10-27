package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements a.InterfaceC0281a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3058a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0281a
    public void a() {
        a.CountDownTimerC0278a countDownTimerC0278a;
        a.CountDownTimerC0278a countDownTimerC0278a2;
        countDownTimerC0278a = this.f3058a.o;
        if (countDownTimerC0278a != null) {
            countDownTimerC0278a2 = this.f3058a.o;
            countDownTimerC0278a2.cancel();
        }
    }
}
