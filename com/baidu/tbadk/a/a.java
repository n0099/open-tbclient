package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int QD = 0;
    public static int QE = 1;
    public static int QF = 2;
    private AlarmManager QB;
    private PendingIntent QC;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.QC = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.QB = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.QB != null) {
            this.timeInterval = j2;
            if (i == QD) {
                this.QB.set(i2, j, this.QC);
            } else if (i == QE) {
                this.QB.setRepeating(i2, j, j2, this.QC);
            } else if (i == QF) {
                this.QB.setInexactRepeating(i2, j, j2, this.QC);
            } else {
                this.QB.set(i2, j, this.QC);
            }
        }
    }

    public void cancel() {
        if (this.QB != null && this.QC != null) {
            this.QB.cancel(this.QC);
        }
    }

    public void nE() {
        if (this.QB != null && this.QC != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(QE, 1, System.currentTimeMillis() + this.timeInterval, this.timeInterval);
        }
    }

    public long nF() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
