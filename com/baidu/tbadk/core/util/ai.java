package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ af aaI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar) {
        this.aaI = afVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaI.uv();
    }
}
