package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ k agi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.agi = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.agi.wT();
    }
}
