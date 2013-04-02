package com.baidu.android.nebula.cmd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.nebula.localserver.util.BDLocationManager;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ GeoLocation a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GeoLocation geoLocation, Looper looper) {
        super(looper);
        this.a = geoLocation;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        BDLocationManager bDLocationManager;
        com.baidu.android.nebula.localserver.util.b bVar;
        BDLocationManager bDLocationManager2;
        boolean z;
        BDLocationManager bDLocationManager3;
        com.baidu.android.nebula.localserver.util.c cVar;
        BDLocationManager bDLocationManager4;
        Timer timer;
        Timer timer2;
        this.a.mLocMgr = BDLocationManager.b(this.a.mContext);
        synchronized (this.a) {
            GeoLocation geoLocation = this.a;
            bDLocationManager = this.a.mLocMgr;
            geoLocation.mLocInfo = bDLocationManager.b();
            bVar = this.a.mLocInfo;
            if (bVar != null) {
                this.a.mErrcode = 0;
                timer = this.a.mTimeoutTm;
                if (timer != null) {
                    timer2 = this.a.mTimeoutTm;
                    timer2.cancel();
                }
                this.a.notifyAll();
                return;
            }
            this.a.mLocListener = new d(this);
            bDLocationManager2 = this.a.mLocMgr;
            z = this.a.mGpsEnabled;
            bDLocationManager2.a(z);
            bDLocationManager3 = this.a.mLocMgr;
            cVar = this.a.mLocListener;
            bDLocationManager3.a(cVar);
            bDLocationManager4 = this.a.mLocMgr;
            bDLocationManager4.c();
        }
    }
}
