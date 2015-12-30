package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    private AlarmManager Sw;
    private PendingIntent Sx;
    private long Sy;
    private Context mContext;
    public static int Sz = 0;
    public static int SA = 1;
    public static int SB = 2;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Sx = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Sw = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Sw != null) {
            this.Sy = j2;
            if (i == Sz) {
                this.Sw.set(i2, j, this.Sx);
            } else if (i == SA) {
                this.Sw.setRepeating(i2, j, j2, this.Sx);
            } else if (i == SB) {
                this.Sw.setInexactRepeating(i2, j, j2, this.Sx);
            } else {
                this.Sw.set(i2, j, this.Sx);
            }
        }
    }

    public void cancel() {
        if (this.Sw != null && this.Sx != null) {
            this.Sw.cancel(this.Sx);
        }
    }

    public void pK() {
        if (this.Sw != null && this.Sx != null) {
            if (this.Sy <= 0) {
                this.Sy = 3600000L;
            }
            a(SA, 1, System.currentTimeMillis() + this.Sy, this.Sy);
        }
    }

    public long pL() {
        if (this.Sy <= 0) {
            this.Sy = 3600000L;
        }
        return this.Sy;
    }
}
