package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;
import com.baidu.mobads.production.b;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b.a != null) {
                IXMonitorActivation xMonitorActivation = b.a.getXMonitorActivation(this.a.a, this.a.b.s);
                xMonitorActivation.setIXActivateListener(new b.a(this.a.b.f));
                xMonitorActivation.startMonitor();
            }
        } catch (Exception e) {
            this.a.b.s.e(e);
        }
    }
}
