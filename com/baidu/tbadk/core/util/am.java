package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ai afI;
    private final /* synthetic */ String afJ;
    private final /* synthetic */ String afM;
    private final /* synthetic */ int afN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar, String str, String str2, int i) {
        this.afI = aiVar;
        this.afM = str;
        this.afJ = str2;
        this.afN = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afI.c(this.afM, this.afJ, this.afN);
    }
}
