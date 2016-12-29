package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ aj abg;
    private final /* synthetic */ String abh;
    private final /* synthetic */ String abk;
    private final /* synthetic */ int abl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar, String str, String str2, int i) {
        this.abg = ajVar;
        this.abk = str;
        this.abh = str2;
        this.abl = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abg.c(this.abk, this.abh, this.abl);
    }
}
