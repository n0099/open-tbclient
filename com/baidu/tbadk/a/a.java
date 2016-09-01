package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Mo = 0;
    public static int Mp = 1;
    public static int Mq = 2;
    private AlarmManager Ml;
    private PendingIntent Mm;
    private long Mn;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Mm = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Ml = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Ml != null) {
            this.Mn = j2;
            if (i == Mo) {
                this.Ml.set(i2, j, this.Mm);
            } else if (i == Mp) {
                this.Ml.setRepeating(i2, j, j2, this.Mm);
            } else if (i == Mq) {
                this.Ml.setInexactRepeating(i2, j, j2, this.Mm);
            } else {
                this.Ml.set(i2, j, this.Mm);
            }
        }
    }

    public void cancel() {
        if (this.Ml != null && this.Mm != null) {
            this.Ml.cancel(this.Mm);
        }
    }

    public void ns() {
        if (this.Ml != null && this.Mm != null) {
            if (this.Mn <= 0) {
                this.Mn = 3600000L;
            }
            a(Mp, 1, System.currentTimeMillis() + this.Mn, this.Mn);
        }
    }

    public long nt() {
        if (this.Mn <= 0) {
            this.Mn = 3600000L;
        }
        return this.Mn;
    }
}
