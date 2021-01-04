package com.baidu.mobads.openad.e;

import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
class b extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3460a = aVar;
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
        atomicInteger = this.f3460a.h;
        if (atomicInteger.get() == 0) {
            eventHandler = this.f3460a.f3459b;
            if (eventHandler != null) {
                a aVar = this.f3460a;
                i2 = this.f3460a.d;
                i3 = this.f3460a.e;
                aVar.f = i2 - i3;
                eventHandler4 = this.f3460a.f3459b;
                i4 = this.f3460a.f;
                eventHandler4.onTimer(i4);
            }
            i = this.f3460a.e;
            if (i > 0) {
                a.f(this.f3460a);
                return;
            }
            this.f3460a.stop();
            eventHandler2 = this.f3460a.f3459b;
            if (eventHandler2 != null) {
                eventHandler3 = this.f3460a.f3459b;
                eventHandler3.onTimerComplete();
            }
        }
    }
}
