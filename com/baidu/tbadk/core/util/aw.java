package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ at Vb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(at atVar) {
        this.Vb = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Vb.sN();
    }
}
