package com.baidu.tbadk.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int PW = 0;
    public static int PX = 1;
    public static int PY = 2;
    private AlarmManager PU;
    private PendingIntent PV;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.PV = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.PU = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.PU != null) {
            this.timeInterval = j2;
            if (i == PW) {
                this.PU.set(i2, j, this.PV);
            } else if (i == PX) {
                this.PU.setRepeating(i2, j, j2, this.PV);
            } else if (i == PY) {
                this.PU.setInexactRepeating(i2, j, j2, this.PV);
            } else {
                this.PU.set(i2, j, this.PV);
            }
        }
    }

    public void cancel() {
        if (this.PU != null && this.PV != null) {
            this.PU.cancel(this.PV);
        }
    }

    public void nw() {
        if (this.PU != null && this.PV != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(PX, 1, System.currentTimeMillis() + this.timeInterval, this.timeInterval);
        }
    }

    public long nx() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
