package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ am XG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.XG = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.XG.tP();
    }
}
