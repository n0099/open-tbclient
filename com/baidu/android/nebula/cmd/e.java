package com.baidu.android.nebula.cmd;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GeoLocation f547a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GeoLocation geoLocation) {
        this.f547a = geoLocation;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        synchronized (this.f547a) {
            this.f547a.mErrcode = 3;
            this.f547a.notifyAll();
        }
    }
}
