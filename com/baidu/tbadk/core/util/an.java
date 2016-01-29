package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ aj acB;
    private final /* synthetic */ String acC;
    private final /* synthetic */ String acF;
    private final /* synthetic */ int acG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar, String str, String str2, int i) {
        this.acB = ajVar;
        this.acF = str;
        this.acC = str2;
        this.acG = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acB.d(this.acF, this.acC, this.acG);
    }
}
