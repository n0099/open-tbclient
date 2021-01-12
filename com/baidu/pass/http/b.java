package com.baidu.pass.http;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PassHttpClient f4100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PassHttpClient passHttpClient) {
        this.f4100a = passHttpClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        try {
            dVar = this.f4100a.c;
            if (dVar != null) {
                dVar2 = this.f4100a.c;
                if (dVar2.a() != null) {
                    dVar3 = this.f4100a.c;
                    dVar3.a().disconnect();
                    dVar4 = this.f4100a.c;
                    dVar4.b();
                }
            }
        } catch (Exception e) {
        }
    }
}
