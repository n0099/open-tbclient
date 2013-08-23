package com.baidu.android.nebula.cmd;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GeoLocation f566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GeoLocation geoLocation) {
        this.f566a = geoLocation;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        synchronized (this.f566a) {
            this.f566a.mErrcode = 3;
            this.f566a.notifyAll();
        }
    }
}
