package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ k ajp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.ajp = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ajp.wc();
    }
}
