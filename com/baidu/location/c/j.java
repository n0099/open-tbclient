package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e aCI;
    final /* synthetic */ Location aCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.aCI = eVar;
        this.aCQ = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCI.d(this.aCQ);
    }
}
