package com.baidu.platform.comapi.walknavi.d.a;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9987a;

    public e(d dVar) {
        this.f9987a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(200L);
            com.baidu.platform.comapi.walknavi.d.a.e.a.a().b();
        } catch (Exception e2) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("statistic exception when destroy: " + e2.getMessage());
        }
    }
}
