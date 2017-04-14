package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ k ajR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.ajR = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ajR.wP();
    }
}
