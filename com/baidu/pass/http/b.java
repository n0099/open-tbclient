package com.baidu.pass.http;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PassHttpClient f9312a;

    public b(PassHttpClient passHttpClient) {
        this.f9312a = passHttpClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        try {
            dVar = this.f9312a.f9310c;
            if (dVar != null) {
                dVar2 = this.f9312a.f9310c;
                if (dVar2.a() != null) {
                    dVar3 = this.f9312a.f9310c;
                    dVar3.a().disconnect();
                    dVar4 = this.f9312a.f9310c;
                    dVar4.b();
                }
            }
        } catch (Exception unused) {
        }
    }
}
