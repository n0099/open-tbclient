package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;
import com.baidu.mobads.production.b;
/* loaded from: classes14.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3455a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b.f3429a != null) {
                IXMonitorActivation xMonitorActivation = b.f3429a.getXMonitorActivation(this.f3455a.f3452a, this.f3455a.f3453b.s);
                xMonitorActivation.setIXActivateListener(new b.a(this.f3455a.f3453b.f));
                xMonitorActivation.startMonitor();
            }
        } catch (Exception e) {
            this.f3455a.f3453b.s.e(e);
        }
    }
}
