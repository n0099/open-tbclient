package com.baidu.android.nebula.cmd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.nebula.util.BDLocationManager;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GeoLocation f546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GeoLocation geoLocation, Looper looper) {
        super(looper);
        this.f546a = geoLocation;
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
        this.f546a.mLocMgr = BDLocationManager.b(this.f546a.mContext);
        synchronized (this.f546a) {
            GeoLocation geoLocation = this.f546a;
            bDLocationManager = this.f546a.mLocMgr;
            geoLocation.mLocInfo = bDLocationManager.b();
            cVar = this.f546a.mLocInfo;
            if (cVar != null) {
                this.f546a.mErrcode = 0;
                timer = this.f546a.mTimeoutTm;
                if (timer != null) {
                    timer2 = this.f546a.mTimeoutTm;
                    timer2.cancel();
                }
                this.f546a.notifyAll();
                return;
            }
            this.f546a.mLocListener = new j(this);
            bDLocationManager2 = this.f546a.mLocMgr;
            z = this.f546a.mGpsEnabled;
            bDLocationManager2.a(z);
            bDLocationManager3 = this.f546a.mLocMgr;
            eVar = this.f546a.mLocListener;
            bDLocationManager3.a(eVar);
            bDLocationManager4 = this.f546a.mLocMgr;
            bDLocationManager4.c();
        }
    }
}
