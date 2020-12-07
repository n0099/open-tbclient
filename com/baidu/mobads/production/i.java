package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;
import com.baidu.mobads.production.b;
/* loaded from: classes7.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2418a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b.f2396a != null) {
                IXMonitorActivation xMonitorActivation = b.f2396a.getXMonitorActivation(this.f2418a.f2416a, this.f2418a.b.s);
                xMonitorActivation.setIXActivateListener(new b.a(this.f2418a.b.f));
                xMonitorActivation.startMonitor();
            }
        } catch (Exception e) {
            this.f2418a.b.s.e(e);
        }
    }
}
