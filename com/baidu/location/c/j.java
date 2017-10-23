package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e MD;
    final /* synthetic */ Location ML;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.MD = eVar;
        this.ML = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.MD.c(this.ML);
    }
}
