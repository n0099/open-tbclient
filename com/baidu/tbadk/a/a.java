package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Kc = 0;
    public static int Kd = 1;
    public static int Ke = 2;
    private AlarmManager JZ;
    private PendingIntent Ka;
    private long Kb;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Ka = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.JZ = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.JZ != null) {
            this.Kb = j2;
            if (i == Kc) {
                this.JZ.set(i2, j, this.Ka);
            } else if (i == Kd) {
                this.JZ.setRepeating(i2, j, j2, this.Ka);
            } else if (i == Ke) {
                this.JZ.setInexactRepeating(i2, j, j2, this.Ka);
            } else {
                this.JZ.set(i2, j, this.Ka);
            }
        }
    }

    public void cancel() {
        if (this.JZ != null && this.Ka != null) {
            this.JZ.cancel(this.Ka);
        }
    }

    public void mx() {
        if (this.JZ != null && this.Ka != null) {
            if (this.Kb <= 0) {
                this.Kb = 3600000L;
            }
            a(Kd, 1, System.currentTimeMillis() + this.Kb, this.Kb);
        }
    }

    public long my() {
        if (this.Kb <= 0) {
            this.Kb = 3600000L;
        }
        return this.Kb;
    }
}
