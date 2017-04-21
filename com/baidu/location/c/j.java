package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e Om;
    final /* synthetic */ Location Ov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.Om = eVar;
        this.Ov = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Om.c(this.Ov);
    }
}
