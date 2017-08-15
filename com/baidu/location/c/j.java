package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e OR;
    final /* synthetic */ Location Pa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.OR = eVar;
        this.Pa = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.OR.c(this.Pa);
    }
}
