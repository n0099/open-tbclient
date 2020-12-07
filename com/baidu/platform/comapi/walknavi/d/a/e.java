package com.baidu.platform.comapi.walknavi.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f2985a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f2985a = dVar;
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
