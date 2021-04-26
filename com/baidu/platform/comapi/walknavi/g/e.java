package com.baidu.platform.comapi.walknavi.g;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class e implements a.InterfaceC0127a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10050a;

    public e(a aVar) {
        this.f10050a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0127a
    public void a() {
        a.CountDownTimerC0124a countDownTimerC0124a;
        a.CountDownTimerC0124a countDownTimerC0124a2;
        a.CountDownTimerC0124a countDownTimerC0124a3;
        countDownTimerC0124a = this.f10050a.q;
        if (countDownTimerC0124a != null) {
            countDownTimerC0124a2 = this.f10050a.q;
            countDownTimerC0124a2.onFinish();
            countDownTimerC0124a3 = this.f10050a.q;
            countDownTimerC0124a3.cancel();
            return;
        }
        this.f10050a.q();
    }
}
