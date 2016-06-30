package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Kd = 0;
    public static int Ke = 1;
    public static int Kf = 2;
    private AlarmManager Ka;
    private PendingIntent Kb;
    private long Kc;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Kb = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Ka = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Ka != null) {
            this.Kc = j2;
            if (i == Kd) {
                this.Ka.set(i2, j, this.Kb);
            } else if (i == Ke) {
                this.Ka.setRepeating(i2, j, j2, this.Kb);
            } else if (i == Kf) {
                this.Ka.setInexactRepeating(i2, j, j2, this.Kb);
            } else {
                this.Ka.set(i2, j, this.Kb);
            }
        }
    }

    public void cancel() {
        if (this.Ka != null && this.Kb != null) {
            this.Ka.cancel(this.Kb);
        }
    }

    public void mH() {
        if (this.Ka != null && this.Kb != null) {
            if (this.Kc <= 0) {
                this.Kc = 3600000L;
            }
            a(Ke, 1, System.currentTimeMillis() + this.Kc, this.Kc);
        }
    }

    public long mI() {
        if (this.Kc <= 0) {
            this.Kc = 3600000L;
        }
        return this.Kc;
    }
}
