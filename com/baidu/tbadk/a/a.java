package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int LB = 0;
    public static int LC = 1;
    public static int LD = 2;
    private PendingIntent LA;
    private AlarmManager Lz;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.LA = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Lz = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Lz != null) {
            this.timeInterval = j2;
            if (i == LB) {
                this.Lz.set(i2, j, this.LA);
            } else if (i == LC) {
                this.Lz.setRepeating(i2, j, j2, this.LA);
            } else if (i == LD) {
                this.Lz.setInexactRepeating(i2, j, j2, this.LA);
            } else {
                this.Lz.set(i2, j, this.LA);
            }
        }
    }

    public void cancel() {
        if (this.Lz != null && this.LA != null) {
            this.Lz.cancel(this.LA);
        }
    }

    public void nq() {
        if (this.Lz != null && this.LA != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(LC, 1, System.currentTimeMillis() + this.timeInterval, this.timeInterval);
        }
    }

    public long nr() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
