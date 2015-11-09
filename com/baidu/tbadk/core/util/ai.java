package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ af aaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar) {
        this.aaO = afVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaO.uv();
    }
}
