package com.baidu.mobads.openad.e;

import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
class b extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2387a = aVar;
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
        atomicInteger = this.f2387a.h;
        if (atomicInteger.get() == 0) {
            eventHandler = this.f2387a.b;
            if (eventHandler != null) {
                a aVar = this.f2387a;
                i2 = this.f2387a.d;
                i3 = this.f2387a.e;
                aVar.f = i2 - i3;
                eventHandler4 = this.f2387a.b;
                i4 = this.f2387a.f;
                eventHandler4.onTimer(i4);
            }
            i = this.f2387a.e;
            if (i > 0) {
                a.f(this.f2387a);
                return;
            }
            this.f2387a.stop();
            eventHandler2 = this.f2387a.b;
            if (eventHandler2 != null) {
                eventHandler3 = this.f2387a.b;
                eventHandler3.onTimerComplete();
            }
        }
    }
}
