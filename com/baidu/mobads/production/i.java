package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;
import com.baidu.mobads.production.b;
/* loaded from: classes3.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3492a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3492a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b.f3466a != null) {
                IXMonitorActivation xMonitorActivation = b.f3466a.getXMonitorActivation(this.f3492a.f3489a, this.f3492a.f3490b.s);
                xMonitorActivation.setIXActivateListener(new b.a(this.f3492a.f3490b.f));
                xMonitorActivation.startMonitor();
            }
        } catch (Exception e) {
            this.f3492a.f3490b.s.e(e);
        }
    }
}
