package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ af aaI;
    private final /* synthetic */ String aaJ;
    private final /* synthetic */ String aaM;
    private final /* synthetic */ int aaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar, String str, String str2, int i) {
        this.aaI = afVar;
        this.aaM = str;
        this.aaJ = str2;
        this.aaN = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaI.d(this.aaM, this.aaJ, this.aaN);
    }
}
