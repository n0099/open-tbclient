package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e OO;
    final /* synthetic */ Location OX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.OO = eVar;
        this.OX = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.OO.c(this.OX);
    }
}
