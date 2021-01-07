package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;
import com.baidu.mobads.production.b;
/* loaded from: classes3.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3493a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3493a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b.f3467a != null) {
                IXMonitorActivation xMonitorActivation = b.f3467a.getXMonitorActivation(this.f3493a.f3490a, this.f3493a.f3491b.s);
                xMonitorActivation.setIXActivateListener(new b.a(this.f3493a.f3491b.f));
                xMonitorActivation.startMonitor();
            }
        } catch (Exception e) {
            this.f3493a.f3491b.s.e(e);
        }
    }
}
