package com.baidu.android.nebula.cmd;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends TimerTask {
    final /* synthetic */ GeoLocation a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GeoLocation geoLocation) {
        this.a = geoLocation;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        synchronized (this.a) {
            this.a.mErrcode = 3;
            this.a.notifyAll();
        }
    }
}
