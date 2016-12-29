package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ aj abg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.abg = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abg.uX();
    }
}
