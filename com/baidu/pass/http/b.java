package com.baidu.pass.http;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PassHttpClient f9753a;

    public b(PassHttpClient passHttpClient) {
        this.f9753a = passHttpClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        try {
            dVar = this.f9753a.f9751c;
            if (dVar != null) {
                dVar2 = this.f9753a.f9751c;
                if (dVar2.a() != null) {
                    dVar3 = this.f9753a.f9751c;
                    dVar3.a().disconnect();
                    dVar4 = this.f9753a.f9751c;
                    dVar4.b();
                }
            }
        } catch (Exception unused) {
        }
    }
}
