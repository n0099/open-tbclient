package com.baidu.android.procmo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ ProcessMonitor xc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ProcessMonitor processMonitor) {
        this.xc = processMonitor;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String iH;
        ProcessMonitor processMonitor = this.xc;
        str = this.xc.wZ;
        processMonitor.exitIfRunning(str);
        iH = this.xc.iH();
        this.xc.aN(iH);
    }
}
