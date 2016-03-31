package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ al abO;
    private final /* synthetic */ String abP;
    private final /* synthetic */ String abS;
    private final /* synthetic */ int abT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar, String str, String str2, int i) {
        this.abO = alVar;
        this.abS = str;
        this.abP = str2;
        this.abT = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abO.c(this.abS, this.abP, this.abT);
    }
}
