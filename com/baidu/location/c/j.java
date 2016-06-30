package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e Ha;
    final /* synthetic */ Location Hk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Ha = eVar;
        this.Hk = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ha.c(this.Hk);
    }
}
