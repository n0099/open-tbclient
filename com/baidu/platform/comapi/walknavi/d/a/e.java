package com.baidu.platform.comapi.walknavi.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements Runnable {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(200L);
            com.baidu.platform.comapi.walknavi.d.a.e.a.a().b();
        } catch (Exception e) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("statistic exception when destroy: " + e.getMessage());
        }
    }
}
