package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e MM;
    final /* synthetic */ Location MU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.MM = eVar;
        this.MU = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.MM.c(this.MU);
    }
}
