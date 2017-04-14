package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ai afW;
    private final /* synthetic */ String afX;
    private final /* synthetic */ String aga;
    private final /* synthetic */ int agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar, String str, String str2, int i) {
        this.afW = aiVar;
        this.aga = str;
        this.afX = str2;
        this.agb = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afW.c(this.aga, this.afX, this.agb);
    }
}
