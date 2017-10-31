package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e LW;
    final /* synthetic */ Location Me;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.LW = eVar;
        this.Me = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.LW.c(this.Me);
    }
}
