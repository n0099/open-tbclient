package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ai afI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ai aiVar) {
        this.afI = aiVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afI.vo();
    }
}
