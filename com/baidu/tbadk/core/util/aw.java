package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ at Vd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(at atVar) {
        this.Vd = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Vd.sN();
    }
}
