package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ai afX;
    private final /* synthetic */ String afY;
    private final /* synthetic */ String agb;
    private final /* synthetic */ int agc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar, String str, String str2, int i) {
        this.afX = aiVar;
        this.agb = str;
        this.afY = str2;
        this.agc = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afX.c(this.agb, this.afY, this.agc);
    }
}
