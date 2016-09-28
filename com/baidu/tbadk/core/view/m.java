package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ k afm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.afm = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afm.wo();
    }
}
