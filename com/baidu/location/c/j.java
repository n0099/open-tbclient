package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e OP;
    final /* synthetic */ Location OY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.OP = eVar;
        this.OY = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.OP.c(this.OY);
    }
}
