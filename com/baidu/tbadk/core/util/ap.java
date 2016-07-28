package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ am Yp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.Yp = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yp.tO();
    }
}
