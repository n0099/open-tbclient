package com.baidu.android.nebula.cmd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.nebula.util.BDLocationManager;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GeoLocation f279a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GeoLocation geoLocation, Looper looper) {
        super(looper);
        this.f279a = geoLocation;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        BDLocationManager bDLocationManager;
        com.baidu.android.nebula.util.c cVar;
        BDLocationManager bDLocationManager2;
        boolean z;
        BDLocationManager bDLocationManager3;
        com.baidu.android.nebula.util.e eVar;
        BDLocationManager bDLocationManager4;
        Timer timer;
        Timer timer2;
        this.f279a.mLocMgr = BDLocationManager.b(this.f279a.mContext);
        synchronized (this.f279a) {
            GeoLocation geoLocation = this.f279a;
            bDLocationManager = this.f279a.mLocMgr;
            geoLocation.mLocInfo = bDLocationManager.b();
            cVar = this.f279a.mLocInfo;
            if (cVar != null) {
                this.f279a.mErrcode = 0;
                timer = this.f279a.mTimeoutTm;
                if (timer != null) {
                    timer2 = this.f279a.mTimeoutTm;
                    timer2.cancel();
                }
                this.f279a.notifyAll();
                return;
            }
            this.f279a.mLocListener = new d(this);
            bDLocationManager2 = this.f279a.mLocMgr;
            z = this.f279a.mGpsEnabled;
            bDLocationManager2.a(z);
            bDLocationManager3 = this.f279a.mLocMgr;
            eVar = this.f279a.mLocListener;
            bDLocationManager3.a(eVar);
            bDLocationManager4 = this.f279a.mLocMgr;
            bDLocationManager4.c();
        }
    }
}
