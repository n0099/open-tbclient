package com.baidu.android.nebula.cmd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.nebula.util.BDLocationManager;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GeoLocation f668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GeoLocation geoLocation, Looper looper) {
        super(looper);
        this.f668a = geoLocation;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        BDLocationManager bDLocationManager;
        com.baidu.android.nebula.util.c cVar;
        BDLocationManager bDLocationManager2;
        boolean z;
        BDLocationManager bDLocationManager3;
        com.baidu.android.nebula.util.d dVar;
        BDLocationManager bDLocationManager4;
        Timer timer;
        Timer timer2;
        this.f668a.mLocMgr = BDLocationManager.b(this.f668a.mContext);
        synchronized (this.f668a) {
            GeoLocation geoLocation = this.f668a;
            bDLocationManager = this.f668a.mLocMgr;
            geoLocation.mLocInfo = bDLocationManager.b();
            cVar = this.f668a.mLocInfo;
            if (cVar != null) {
                this.f668a.mErrcode = 0;
                timer = this.f668a.mTimeoutTm;
                if (timer != null) {
                    timer2 = this.f668a.mTimeoutTm;
                    timer2.cancel();
                }
                this.f668a.notifyAll();
                return;
            }
            this.f668a.mLocListener = new d(this);
            bDLocationManager2 = this.f668a.mLocMgr;
            z = this.f668a.mGpsEnabled;
            bDLocationManager2.a(z);
            bDLocationManager3 = this.f668a.mLocMgr;
            dVar = this.f668a.mLocListener;
            bDLocationManager3.a(dVar);
            bDLocationManager4 = this.f668a.mLocMgr;
            bDLocationManager4.c();
        }
    }
}
