package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e aBh;
    final /* synthetic */ Location aBp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.aBh = eVar;
        this.aBp = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aBh.d(this.aBp);
    }
}
