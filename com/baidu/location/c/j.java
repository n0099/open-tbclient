package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e Ok;
    final /* synthetic */ Location Ot;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Ok = eVar;
        this.Ot = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ok.c(this.Ot);
    }
}
