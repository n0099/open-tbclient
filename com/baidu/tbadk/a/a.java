package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Ni = 0;
    public static int Nj = 1;
    public static int Nk = 2;
    private AlarmManager Nf;
    private PendingIntent Ng;
    private long Nh;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Ng = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Nf = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Nf != null) {
            this.Nh = j2;
            if (i == Ni) {
                this.Nf.set(i2, j, this.Ng);
            } else if (i == Nj) {
                this.Nf.setRepeating(i2, j, j2, this.Ng);
            } else if (i == Nk) {
                this.Nf.setInexactRepeating(i2, j, j2, this.Ng);
            } else {
                this.Nf.set(i2, j, this.Ng);
            }
        }
    }

    public void cancel() {
        if (this.Nf != null && this.Ng != null) {
            this.Nf.cancel(this.Ng);
        }
    }

    public void oN() {
        if (this.Nf != null && this.Ng != null) {
            if (this.Nh <= 0) {
                this.Nh = 3600000L;
            }
            a(Nj, 1, System.currentTimeMillis() + this.Nh, this.Nh);
        }
    }

    public long oO() {
        if (this.Nh <= 0) {
            this.Nh = 3600000L;
        }
        return this.Nh;
    }
}
