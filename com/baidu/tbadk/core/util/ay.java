package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ av Jp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(av avVar) {
        this.Jp = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Jp.pq();
    }
}
