package com.baidu.location.a;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class e implements Runnable {
    final /* synthetic */ Location a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Location location) {
        this.b = dVar;
        this.a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.a);
    }
}
