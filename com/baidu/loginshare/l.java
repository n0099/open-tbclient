package com.baidu.loginshare;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Token token;
        Context context;
        Context context2;
        try {
            sleep(100L);
            token = this.a.e;
            if (token == null) {
                context = this.a.a;
                if (context != null) {
                    com.baidu.share.c cVar = new com.baidu.share.c();
                    cVar.a = h.a();
                    context2 = this.a.a;
                    com.baidu.share.b.a(context2).a(cVar);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
