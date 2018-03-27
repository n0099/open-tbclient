package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ Location aCG;
    final /* synthetic */ e aCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.aCy = eVar;
        this.aCG = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCy.d(this.aCG);
    }
}
