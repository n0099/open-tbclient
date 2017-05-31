package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ Location NA;
    final /* synthetic */ e Nr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Nr = eVar;
        this.NA = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Nr.c(this.NA);
    }
}
