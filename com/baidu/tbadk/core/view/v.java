package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final /* synthetic */ t Zj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.Zj = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Zj.ut();
    }
}
