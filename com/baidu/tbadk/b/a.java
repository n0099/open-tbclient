package com.baidu.tbadk.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Ru = 0;
    public static int Rv = 1;
    public static int Rw = 2;
    private AlarmManager Rs;
    private PendingIntent Rt;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Rt = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Rs = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Rs != null) {
            this.timeInterval = j2;
            if (i == Ru) {
                this.Rs.set(i2, j, this.Rt);
            } else if (i == Rv) {
                this.Rs.setRepeating(i2, j, j2, this.Rt);
            } else if (i == Rw) {
                this.Rs.setInexactRepeating(i2, j, j2, this.Rt);
            } else {
                this.Rs.set(i2, j, this.Rt);
            }
        }
    }

    public void cancel() {
        if (this.Rs != null && this.Rt != null) {
            this.Rs.cancel(this.Rt);
        }
    }

    public void nD() {
        if (this.Rs != null && this.Rt != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(Rv, 1, this.timeInterval + System.currentTimeMillis(), this.timeInterval);
        }
    }

    public long nE() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
