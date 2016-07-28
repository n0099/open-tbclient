package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ Location HC;
    final /* synthetic */ e Ht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Ht = eVar;
        this.HC = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ht.c(this.HC);
    }
}
