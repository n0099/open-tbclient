package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements Runnable {
    final /* synthetic */ am abq;
    private final /* synthetic */ String abr;
    private final /* synthetic */ String abv;
    private final /* synthetic */ int abw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(am amVar, String str, String str2, int i) {
        this.abq = amVar;
        this.abv = str;
        this.abr = str2;
        this.abw = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abq.c(this.abv, this.abr, this.abw);
    }
}
