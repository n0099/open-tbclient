package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ ak abB;
    private final /* synthetic */ String abC;
    private final /* synthetic */ String abF;
    private final /* synthetic */ int abG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar, String str, String str2, int i) {
        this.abB = akVar;
        this.abF = str;
        this.abC = str2;
        this.abG = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abB.d(this.abF, this.abC, this.abG);
    }
}
