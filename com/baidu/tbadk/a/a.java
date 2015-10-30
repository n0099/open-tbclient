package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int RT = 0;
    public static int RU = 1;
    public static int RV = 2;
    private AlarmManager RQ;
    private PendingIntent RR;
    private long RS;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.RR = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.RQ = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.RQ != null) {
            this.RS = j2;
            if (i == RT) {
                this.RQ.set(i2, j, this.RR);
            } else if (i == RU) {
                this.RQ.setRepeating(i2, j, j2, this.RR);
            } else if (i == RV) {
                this.RQ.setInexactRepeating(i2, j, j2, this.RR);
            } else {
                this.RQ.set(i2, j, this.RR);
            }
        }
    }

    public void cancel() {
        if (this.RQ != null && this.RR != null) {
            this.RQ.cancel(this.RR);
        }
    }

    public void qe() {
        if (this.RQ != null && this.RR != null) {
            if (this.RS <= 0) {
                this.RS = 3600000L;
            }
            a(RU, 1, System.currentTimeMillis() + this.RS, this.RS);
        }
    }

    public long qf() {
        if (this.RS <= 0) {
            this.RS = 3600000L;
        }
        return this.RS;
    }
}
