package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements Runnable {
    final /* synthetic */ bg acL;
    private final /* synthetic */ bg.a acM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar, bg.a aVar) {
        this.acL = bgVar;
        this.acM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acL.b(this.acM);
    }
}
