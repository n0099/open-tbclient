package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e Mo;
    final /* synthetic */ Location Mw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Mo = eVar;
        this.Mw = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Mo.c(this.Mw);
    }
}
