package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ al Xo;
    private final /* synthetic */ String Xp;
    private final /* synthetic */ String Xs;
    private final /* synthetic */ int Xt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar, String str, String str2, int i) {
        this.Xo = alVar;
        this.Xs = str;
        this.Xp = str2;
        this.Xt = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Xo.c(this.Xs, this.Xp, this.Xt);
    }
}
