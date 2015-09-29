package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ i adG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.adG = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.adG.vu();
    }
}
