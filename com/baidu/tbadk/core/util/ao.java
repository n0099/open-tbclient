package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ ak acf;
    private final /* synthetic */ String acg;
    private final /* synthetic */ String acj;
    private final /* synthetic */ int ack;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar, String str, String str2, int i) {
        this.acf = akVar;
        this.acj = str;
        this.acg = str2;
        this.ack = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acf.d(this.acj, this.acg, this.ack);
    }
}
