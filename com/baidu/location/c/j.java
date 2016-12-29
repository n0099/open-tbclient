package com.baidu.location.c;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e JH;
    final /* synthetic */ Location JQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Location location) {
        this.JH = eVar;
        this.JQ = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.JH.c(this.JQ);
    }
}
