package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ k ajD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.ajD = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ajD.wt();
    }
}
