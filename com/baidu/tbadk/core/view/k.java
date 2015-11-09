package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ i adM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.adM = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.adM.vv();
    }
}
