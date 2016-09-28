package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Mn = 0;
    public static int Mo = 1;
    public static int Mp = 2;
    private AlarmManager Mk;
    private PendingIntent Ml;
    private long Mm;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Ml = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Mk = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Mk != null) {
            this.Mm = j2;
            if (i == Mn) {
                this.Mk.set(i2, j, this.Ml);
            } else if (i == Mo) {
                this.Mk.setRepeating(i2, j, j2, this.Ml);
            } else if (i == Mp) {
                this.Mk.setInexactRepeating(i2, j, j2, this.Ml);
            } else {
                this.Mk.set(i2, j, this.Ml);
            }
        }
    }

    public void cancel() {
        if (this.Mk != null && this.Ml != null) {
            this.Mk.cancel(this.Ml);
        }
    }

    public void ns() {
        if (this.Mk != null && this.Ml != null) {
            if (this.Mm <= 0) {
                this.Mm = 3600000L;
            }
            a(Mo, 1, System.currentTimeMillis() + this.Mm, this.Mm);
        }
    }

    public long nt() {
        if (this.Mm <= 0) {
            this.Mm = 3600000L;
        }
        return this.Mm;
    }
}
