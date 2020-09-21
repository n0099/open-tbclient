package com.baidu.pass.http;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements Runnable {
    final /* synthetic */ PassHttpClient a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PassHttpClient passHttpClient) {
        this.a = passHttpClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        try {
            dVar = this.a.c;
            if (dVar != null) {
                dVar2 = this.a.c;
                if (dVar2.a() != null) {
                    dVar3 = this.a.c;
                    dVar3.a().disconnect();
                    dVar4 = this.a.c;
                    dVar4.b();
                }
            }
        } catch (Exception e) {
        }
    }
}
