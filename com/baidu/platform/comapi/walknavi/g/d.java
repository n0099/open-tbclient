package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class d implements a.InterfaceC0127a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10130a;

    public d(a aVar) {
        this.f10130a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0127a
    public void a() {
        a.CountDownTimerC0124a countDownTimerC0124a;
        a.CountDownTimerC0124a countDownTimerC0124a2;
        countDownTimerC0124a = this.f10130a.q;
        if (countDownTimerC0124a != null) {
            countDownTimerC0124a2 = this.f10130a.q;
            countDownTimerC0124a2.cancel();
        }
    }
}
