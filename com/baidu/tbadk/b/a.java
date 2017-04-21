package com.baidu.tbadk.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int QY = 0;
    public static int QZ = 1;
    public static int Ra = 2;
    private AlarmManager QW;
    private PendingIntent QX;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.QX = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.QW = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.QW != null) {
            this.timeInterval = j2;
            if (i == QY) {
                this.QW.set(i2, j, this.QX);
            } else if (i == QZ) {
                this.QW.setRepeating(i2, j, j2, this.QX);
            } else if (i == Ra) {
                this.QW.setInexactRepeating(i2, j, j2, this.QX);
            } else {
                this.QW.set(i2, j, this.QX);
            }
        }
    }

    public void cancel() {
        if (this.QW != null && this.QX != null) {
            this.QW.cancel(this.QX);
        }
    }

    public void ob() {
        if (this.QW != null && this.QX != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(QZ, 1, System.currentTimeMillis() + this.timeInterval, this.timeInterval);
        }
    }

    public long oc() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
