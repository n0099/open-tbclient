package com.baidu.adp.framework.client.socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ g dn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dn = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dn.az();
    }
}
