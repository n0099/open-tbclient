package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements a.InterfaceC0302a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f4559a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0302a
    public void a() {
        a.CountDownTimerC0299a countDownTimerC0299a;
        a.CountDownTimerC0299a countDownTimerC0299a2;
        countDownTimerC0299a = this.f4559a.o;
        if (countDownTimerC0299a != null) {
            countDownTimerC0299a2 = this.f4559a.o;
            countDownTimerC0299a2.cancel();
        }
    }
}
