package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e WR;
    final /* synthetic */ Location WZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.WR = eVar;
        this.WZ = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.WR.c(this.WZ);
    }
}
