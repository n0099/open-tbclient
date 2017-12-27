package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e aBi;
    final /* synthetic */ Location aBq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.aBi = eVar;
        this.aBq = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aBi.d(this.aBq);
    }
}
