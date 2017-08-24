package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e OT;
    final /* synthetic */ Location Pc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.OT = eVar;
        this.Pc = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.OT.c(this.Pc);
    }
}
