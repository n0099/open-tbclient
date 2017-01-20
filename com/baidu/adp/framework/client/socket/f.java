package com.baidu.adp.framework.client.socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e hr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.hr = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hr.bo();
    }
}
