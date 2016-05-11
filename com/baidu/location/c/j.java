package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e Hd;
    final /* synthetic */ Location Hm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Hd = eVar;
        this.Hm = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Hd.c(this.Hm);
    }
}
