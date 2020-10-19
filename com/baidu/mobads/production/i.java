package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;
import com.baidu.mobads.production.b;
/* loaded from: classes7.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2414a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b.f2392a != null) {
                IXMonitorActivation xMonitorActivation = b.f2392a.getXMonitorActivation(this.f2414a.f2412a, this.f2414a.b.s);
                xMonitorActivation.setIXActivateListener(new b.a(this.f2414a.b.f));
                xMonitorActivation.startMonitor();
            }
        } catch (Exception e) {
            this.f2414a.b.s.e(e);
        }
    }
}
