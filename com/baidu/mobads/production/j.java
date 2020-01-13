package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class j implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.b();
            this.a.l();
            this.a.k();
            this.a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.a.s.e(e);
        }
    }
}
