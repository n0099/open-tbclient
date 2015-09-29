package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int RS = 0;
    public static int RT = 1;
    public static int RU = 2;
    private AlarmManager RP;
    private PendingIntent RQ;
    private long RR;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.RQ = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.RP = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.RP != null) {
            this.RR = j2;
            if (i == RS) {
                this.RP.set(i2, j, this.RQ);
            } else if (i == RT) {
                this.RP.setRepeating(i2, j, j2, this.RQ);
            } else if (i == RU) {
                this.RP.setInexactRepeating(i2, j, j2, this.RQ);
            } else {
                this.RP.set(i2, j, this.RQ);
            }
        }
    }

    public void cancel() {
        if (this.RP != null && this.RQ != null) {
            this.RP.cancel(this.RQ);
        }
    }

    public void qh() {
        if (this.RP != null && this.RQ != null) {
            if (this.RR <= 0) {
                this.RR = 3600000L;
            }
            a(RT, 1, System.currentTimeMillis() + this.RR, this.RR);
        }
    }

    public long qi() {
        if (this.RR <= 0) {
            this.RR = 3600000L;
        }
        return this.RR;
    }
}
