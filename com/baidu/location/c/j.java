package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ e WU;
    final /* synthetic */ Location Xc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.WU = eVar;
        this.Xc = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.WU.c(this.Xc);
    }
}
