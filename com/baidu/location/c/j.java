package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e JI;
    final /* synthetic */ Location JR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.JI = eVar;
        this.JR = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.JI.c(this.JR);
    }
}
