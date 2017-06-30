package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements Runnable {
    final /* synthetic */ be agL;
    private final /* synthetic */ be.a agM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(be beVar, be.a aVar) {
        this.agL = beVar;
        this.agM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.agL.b(this.agM);
    }
}
