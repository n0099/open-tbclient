package com.baidu.location.b;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements Runnable {
    final /* synthetic */ Location a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Location location) {
        this.b = gVar;
        this.a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.a);
    }
}
