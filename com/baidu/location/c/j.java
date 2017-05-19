package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e ND;
    final /* synthetic */ Location NM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.ND = eVar;
        this.NM = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ND.c(this.NM);
    }
}
