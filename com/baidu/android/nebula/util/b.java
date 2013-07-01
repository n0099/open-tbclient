package com.baidu.android.nebula.util;

import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BDLocationManager f290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BDLocationManager bDLocationManager) {
        this.f290a = bDLocationManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.location.e eVar;
        com.baidu.location.e eVar2;
        com.baidu.location.e eVar3;
        eVar = this.f290a.d;
        if (eVar != null) {
            eVar2 = this.f290a.d;
            if (eVar2.b() == 1) {
                eVar3 = this.f290a.d;
                eVar3.d();
            }
            this.f290a.k = SystemClock.elapsedRealtime();
            this.f290a.i = true;
        }
    }
}
