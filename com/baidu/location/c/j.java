package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e JG;
    final /* synthetic */ Location JP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.JG = eVar;
        this.JP = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.JG.c(this.JP);
    }
}
