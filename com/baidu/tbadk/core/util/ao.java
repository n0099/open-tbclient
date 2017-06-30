package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ ak afO;
    private final /* synthetic */ String afP;
    private final /* synthetic */ String afS;
    private final /* synthetic */ int afT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar, String str, String str2, int i) {
        this.afO = akVar;
        this.afS = str;
        this.afP = str2;
        this.afT = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afO.c(this.afS, this.afP, this.afT);
    }
}
