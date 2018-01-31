package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e aBk;
    final /* synthetic */ Location aBs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.aBk = eVar;
        this.aBs = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aBk.d(this.aBs);
    }
}
