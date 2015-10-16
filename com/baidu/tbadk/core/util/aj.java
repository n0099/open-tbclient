package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ af aaK;
    private final /* synthetic */ String aaL;
    private final /* synthetic */ String aaO;
    private final /* synthetic */ int aaP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar, String str, String str2, int i) {
        this.aaK = afVar;
        this.aaO = str;
        this.aaL = str2;
        this.aaP = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaK.d(this.aaO, this.aaL, this.aaP);
    }
}
