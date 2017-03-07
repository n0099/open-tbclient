package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e NV;
    final /* synthetic */ Location Oe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.NV = eVar;
        this.Oe = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.NV.c(this.Oe);
    }
}
