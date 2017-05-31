package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ai afg;
    private final /* synthetic */ String afh;
    private final /* synthetic */ String afk;
    private final /* synthetic */ int afl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar, String str, String str2, int i) {
        this.afg = aiVar;
        this.afk = str;
        this.afh = str2;
        this.afl = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afg.c(this.afk, this.afh, this.afl);
    }
}
