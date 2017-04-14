package com.baidu.tbadk.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int QW = 0;
    public static int QX = 1;
    public static int QY = 2;
    private AlarmManager QU;
    private PendingIntent QV;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.QV = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.QU = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.QU != null) {
            this.timeInterval = j2;
            if (i == QW) {
                this.QU.set(i2, j, this.QV);
            } else if (i == QX) {
                this.QU.setRepeating(i2, j, j2, this.QV);
            } else if (i == QY) {
                this.QU.setInexactRepeating(i2, j, j2, this.QV);
            } else {
                this.QU.set(i2, j, this.QV);
            }
        }
    }

    public void cancel() {
        if (this.QU != null && this.QV != null) {
            this.QU.cancel(this.QV);
        }
    }

    public void ob() {
        if (this.QU != null && this.QV != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(QX, 1, System.currentTimeMillis() + this.timeInterval, this.timeInterval);
        }
    }

    public long oc() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
