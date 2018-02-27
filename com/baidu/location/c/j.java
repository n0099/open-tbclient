package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ Location aCF;
    final /* synthetic */ e aCx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.aCx = eVar;
        this.aCF = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCx.d(this.aCF);
    }
}
