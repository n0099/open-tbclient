package com.baidu.mobads.openad.e;

import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
class b extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3423a = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        AtomicInteger atomicInteger;
        IOAdTimer.EventHandler eventHandler;
        int i;
        IOAdTimer.EventHandler eventHandler2;
        IOAdTimer.EventHandler eventHandler3;
        int i2;
        int i3;
        IOAdTimer.EventHandler eventHandler4;
        int i4;
        atomicInteger = this.f3423a.h;
        if (atomicInteger.get() == 0) {
            eventHandler = this.f3423a.f3422b;
            if (eventHandler != null) {
                a aVar = this.f3423a;
                i2 = this.f3423a.d;
                i3 = this.f3423a.e;
                aVar.f = i2 - i3;
                eventHandler4 = this.f3423a.f3422b;
                i4 = this.f3423a.f;
                eventHandler4.onTimer(i4);
            }
            i = this.f3423a.e;
            if (i > 0) {
                a.f(this.f3423a);
                return;
            }
            this.f3423a.stop();
            eventHandler2 = this.f3423a.f3422b;
            if (eventHandler2 != null) {
                eventHandler3 = this.f3423a.f3422b;
                eventHandler3.onTimerComplete();
            }
        }
    }
}
