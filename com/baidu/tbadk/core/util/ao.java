package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ al abO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.abO = alVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abO.wj();
    }
}
