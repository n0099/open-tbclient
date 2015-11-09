package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int RU = 0;
    public static int RV = 1;
    public static int RW = 2;
    private AlarmManager RR;
    private PendingIntent RS;
    private long RT;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.RS = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.RR = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.RR != null) {
            this.RT = j2;
            if (i == RU) {
                this.RR.set(i2, j, this.RS);
            } else if (i == RV) {
                this.RR.setRepeating(i2, j, j2, this.RS);
            } else if (i == RW) {
                this.RR.setInexactRepeating(i2, j, j2, this.RS);
            } else {
                this.RR.set(i2, j, this.RS);
            }
        }
    }

    public void cancel() {
        if (this.RR != null && this.RS != null) {
            this.RR.cancel(this.RS);
        }
    }

    public void qf() {
        if (this.RR != null && this.RS != null) {
            if (this.RT <= 0) {
                this.RT = 3600000L;
            }
            a(RV, 1, System.currentTimeMillis() + this.RT, this.RT);
        }
    }

    public long qg() {
        if (this.RT <= 0) {
            this.RT = 3600000L;
        }
        return this.RT;
    }
}
