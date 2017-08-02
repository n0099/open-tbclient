package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e No;
    final /* synthetic */ Location Nx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.No = eVar;
        this.Nx = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.No.c(this.Nx);
    }
}
