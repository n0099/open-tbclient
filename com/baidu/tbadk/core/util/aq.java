package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements Runnable {
    final /* synthetic */ am XG;
    private final /* synthetic */ String XH;
    private final /* synthetic */ String XK;
    private final /* synthetic */ int XL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(am amVar, String str, String str2, int i) {
        this.XG = amVar;
        this.XK = str;
        this.XH = str2;
        this.XL = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.XG.c(this.XK, this.XH, this.XL);
    }
}
