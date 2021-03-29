package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class d implements a.InterfaceC0128a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10131a;

    public d(a aVar) {
        this.f10131a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0128a
    public void a() {
        a.CountDownTimerC0125a countDownTimerC0125a;
        a.CountDownTimerC0125a countDownTimerC0125a2;
        countDownTimerC0125a = this.f10131a.q;
        if (countDownTimerC0125a != null) {
            countDownTimerC0125a2 = this.f10131a.q;
            countDownTimerC0125a2.cancel();
        }
    }
}
