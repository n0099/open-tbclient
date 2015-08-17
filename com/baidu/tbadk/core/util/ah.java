package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ ae aaF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar) {
        this.aaF = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaF.us();
    }
}
