package com.baidu.tbadk.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Qp = 0;
    public static int Qq = 1;
    public static int Qr = 2;
    private AlarmManager Qn;
    private PendingIntent Qo;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Qo = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Qn = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Qn != null) {
            this.timeInterval = j2;
            if (i == Qp) {
                this.Qn.set(i2, j, this.Qo);
            } else if (i == Qq) {
                this.Qn.setRepeating(i2, j, j2, this.Qo);
            } else if (i == Qr) {
                this.Qn.setInexactRepeating(i2, j, j2, this.Qo);
            } else {
                this.Qn.set(i2, j, this.Qo);
            }
        }
    }

    public void cancel() {
        if (this.Qn != null && this.Qo != null) {
            this.Qn.cancel(this.Qo);
        }
    }

    public void nI() {
        if (this.Qn != null && this.Qo != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(Qq, 1, System.currentTimeMillis() + this.timeInterval, this.timeInterval);
        }
    }

    public long nJ() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
