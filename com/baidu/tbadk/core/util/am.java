package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ aj acB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.acB = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acB.vQ();
    }
}
