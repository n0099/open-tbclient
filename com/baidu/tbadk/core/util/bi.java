package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements Runnable {
    final /* synthetic */ bg Yk;
    private final /* synthetic */ bg.a Yl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar, bg.a aVar) {
        this.Yk = bgVar;
        this.Yl = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yk.b(this.Yl);
    }
}
