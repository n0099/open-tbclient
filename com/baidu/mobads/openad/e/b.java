package com.baidu.mobads.openad.e;

import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
class b extends TimerTask {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
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
        atomicInteger = this.a.h;
        if (atomicInteger.get() == 0) {
            eventHandler = this.a.b;
            if (eventHandler != null) {
                a aVar = this.a;
                i2 = this.a.d;
                i3 = this.a.e;
                aVar.f = i2 - i3;
                eventHandler4 = this.a.b;
                i4 = this.a.f;
                eventHandler4.onTimer(i4);
            }
            i = this.a.e;
            if (i > 0) {
                a.f(this.a);
                return;
            }
            this.a.stop();
            eventHandler2 = this.a.b;
            if (eventHandler2 != null) {
                eventHandler3 = this.a.b;
                eventHandler3.onTimerComplete();
            }
        }
    }
}
