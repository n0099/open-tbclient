package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e OI;
    final /* synthetic */ Location OT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.OI = eVar;
        this.OT = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.OI.c(this.OT);
    }
}
