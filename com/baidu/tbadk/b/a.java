package com.baidu.tbadk.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Qc = 0;
    public static int Qd = 1;
    public static int Qe = 2;
    private AlarmManager Qa;
    private PendingIntent Qb;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Qb = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Qa = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Qa != null) {
            this.timeInterval = j2;
            if (i == Qc) {
                this.Qa.set(i2, j, this.Qb);
            } else if (i == Qd) {
                this.Qa.setRepeating(i2, j, j2, this.Qb);
            } else if (i == Qe) {
                this.Qa.setInexactRepeating(i2, j, j2, this.Qb);
            } else {
                this.Qa.set(i2, j, this.Qb);
            }
        }
    }

    public void cancel() {
        if (this.Qa != null && this.Qb != null) {
            this.Qa.cancel(this.Qb);
        }
    }

    public void nA() {
        if (this.Qa != null && this.Qb != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(Qd, 1, System.currentTimeMillis() + this.timeInterval, this.timeInterval);
        }
    }

    public long nB() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
