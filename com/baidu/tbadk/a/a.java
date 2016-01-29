package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int RR = 0;
    public static int RS = 1;
    public static int RT = 2;
    private AlarmManager RO;
    private PendingIntent RP;
    private long RQ;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.RP = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.RO = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.RO != null) {
            this.RQ = j2;
            if (i == RR) {
                this.RO.set(i2, j, this.RP);
            } else if (i == RS) {
                this.RO.setRepeating(i2, j, j2, this.RP);
            } else if (i == RT) {
                this.RO.setInexactRepeating(i2, j, j2, this.RP);
            } else {
                this.RO.set(i2, j, this.RP);
            }
        }
    }

    public void cancel() {
        if (this.RO != null && this.RP != null) {
            this.RO.cancel(this.RP);
        }
    }

    public void qd() {
        if (this.RO != null && this.RP != null) {
            if (this.RQ <= 0) {
                this.RQ = 3600000L;
            }
            a(RS, 1, System.currentTimeMillis() + this.RQ, this.RQ);
        }
    }

    public long qe() {
        if (this.RQ <= 0) {
            this.RQ = 3600000L;
        }
        return this.RQ;
    }
}
