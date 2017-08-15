package com.baidu.tbadk.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Rw = 0;
    public static int Rx = 1;
    public static int Ry = 2;
    private AlarmManager Ru;
    private PendingIntent Rv;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Rv = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Ru = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Ru != null) {
            this.timeInterval = j2;
            if (i == Rw) {
                this.Ru.set(i2, j, this.Rv);
            } else if (i == Rx) {
                this.Ru.setRepeating(i2, j, j2, this.Rv);
            } else if (i == Ry) {
                this.Ru.setInexactRepeating(i2, j, j2, this.Rv);
            } else {
                this.Ru.set(i2, j, this.Rv);
            }
        }
    }

    public void cancel() {
        if (this.Ru != null && this.Rv != null) {
            this.Ru.cancel(this.Rv);
        }
    }

    public void nD() {
        if (this.Ru != null && this.Rv != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(Rx, 1, this.timeInterval + System.currentTimeMillis(), this.timeInterval);
        }
    }

    public long nE() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
