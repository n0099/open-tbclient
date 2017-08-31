package com.baidu.tbadk.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Qx = 0;
    public static int Qy = 1;
    public static int Qz = 2;
    private PendingIntent Qw;
    private AlarmManager mAlarmManager;
    private Context mContext;
    private long timeInterval;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Qw = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.mAlarmManager = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.mAlarmManager != null) {
            this.timeInterval = j2;
            if (i == Qx) {
                this.mAlarmManager.set(i2, j, this.Qw);
            } else if (i == Qy) {
                this.mAlarmManager.setRepeating(i2, j, j2, this.Qw);
            } else if (i == Qz) {
                this.mAlarmManager.setInexactRepeating(i2, j, j2, this.Qw);
            } else {
                this.mAlarmManager.set(i2, j, this.Qw);
            }
        }
    }

    public void cancel() {
        if (this.mAlarmManager != null && this.Qw != null) {
            this.mAlarmManager.cancel(this.Qw);
        }
    }

    public void ny() {
        if (this.mAlarmManager != null && this.Qw != null) {
            if (this.timeInterval <= 0) {
                this.timeInterval = 3600000L;
            }
            a(Qy, 1, this.timeInterval + System.currentTimeMillis(), this.timeInterval);
        }
    }

    public long nz() {
        if (this.timeInterval <= 0) {
            this.timeInterval = 3600000L;
        }
        return this.timeInterval;
    }
}
