package com.baidu.location.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.location.BDLocation;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<BDNotifyListener> a;
    private BDLocation aeA;
    private LocationClient aeB;
    private PendingIntent aeC;
    private AlarmManager aeD;
    private float b;
    private long d;
    private Context f;
    private int g;
    private long h;
    private boolean i;

    private void a(long j) {
        try {
            if (this.aeC != null) {
                this.aeD.cancel(this.aeC);
            }
            this.aeC = PendingIntent.getBroadcast(this.f, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), 134217728);
            if (this.aeC == null) {
                return;
            }
            this.aeD.set(0, System.currentTimeMillis() + j, this.aeC);
        } catch (Exception e) {
        }
    }

    private boolean a() {
        boolean z = false;
        if (this.a == null || this.a.isEmpty()) {
            return false;
        }
        Iterator<BDNotifyListener> it = this.a.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().Notified < 3 ? true : z2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        boolean z;
        int i = 10000;
        if (!a()) {
            return;
        }
        int i2 = this.b > 5000.0f ? 600000 : this.b > 1000.0f ? BdStatisticsManager.UPLOAD_TIMER_INTERVAL : this.b > 500.0f ? 60000 : 10000;
        if (this.i) {
            this.i = false;
        } else {
            i = i2;
        }
        if (this.g != 0) {
            if (i > (this.h + this.g) - System.currentTimeMillis()) {
                z = false;
                if (z) {
                    return;
                }
                this.g = i;
                this.h = System.currentTimeMillis();
                a(this.g);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    public void a(BDNotifyListener bDNotifyListener) {
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.aeA == null || System.currentTimeMillis() - this.d > ReportUserInfoModel.TIME_INTERVAL) {
            this.aeB.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.aeA.getLatitude(), this.aeA.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.aeA.getRadius();
            if (radius > 0.0f) {
                if (radius < this.b) {
                    this.b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.aeA, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.i = true;
                }
            }
        }
        b();
    }
}
