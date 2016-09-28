package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e JF;
    final /* synthetic */ Location JO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.JF = eVar;
        this.JO = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.JF.c(this.JO);
    }
}
