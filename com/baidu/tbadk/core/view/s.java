package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ q aeu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.aeu = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeu.vC();
    }
}
