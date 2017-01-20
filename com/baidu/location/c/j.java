package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e IP;
    final /* synthetic */ Location IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.IP = eVar;
        this.IZ = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.IP.c(this.IZ);
    }
}
