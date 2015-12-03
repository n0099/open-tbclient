package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ j aeJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aeJ = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeJ.wb();
    }
}
