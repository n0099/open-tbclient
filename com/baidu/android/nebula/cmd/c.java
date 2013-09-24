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
    final /* synthetic */ GeoLocation f579a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GeoLocation geoLocation, Looper looper) {
        super(looper);
        this.f579a = geoLocation;
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
        this.f579a.mLocMgr = BDLocationManager.b(this.f579a.mContext);
        synchronized (this.f579a) {
            GeoLocation geoLocation = this.f579a;
            bDLocationManager = this.f579a.mLocMgr;
            geoLocation.mLocInfo = bDLocationManager.b();
            cVar = this.f579a.mLocInfo;
            if (cVar != null) {
                this.f579a.mErrcode = 0;
                timer = this.f579a.mTimeoutTm;
                if (timer != null) {
                    timer2 = this.f579a.mTimeoutTm;
                    timer2.cancel();
                }
                this.f579a.notifyAll();
                return;
            }
            this.f579a.mLocListener = new d(this);
            bDLocationManager2 = this.f579a.mLocMgr;
            z = this.f579a.mGpsEnabled;
            bDLocationManager2.a(z);
            bDLocationManager3 = this.f579a.mLocMgr;
            dVar = this.f579a.mLocListener;
            bDLocationManager3.a(dVar);
            bDLocationManager4 = this.f579a.mLocMgr;
            bDLocationManager4.c();
        }
    }
}
