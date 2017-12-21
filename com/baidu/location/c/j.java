package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e Mp;
    final /* synthetic */ Location Mx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Mp = eVar;
        this.Mx = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Mp.c(this.Mx);
    }
}
