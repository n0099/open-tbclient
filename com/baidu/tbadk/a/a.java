package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Nk = 0;
    public static int Nl = 1;
    public static int Nm = 2;
    private AlarmManager Nh;
    private PendingIntent Ni;
    private long Nj;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Ni = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Nh = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Nh != null) {
            this.Nj = j2;
            if (i == Nk) {
                this.Nh.set(i2, j, this.Ni);
            } else if (i == Nl) {
                this.Nh.setRepeating(i2, j, j2, this.Ni);
            } else if (i == Nm) {
                this.Nh.setInexactRepeating(i2, j, j2, this.Ni);
            } else {
                this.Nh.set(i2, j, this.Ni);
            }
        }
    }

    public void cancel() {
        if (this.Nh != null && this.Ni != null) {
            this.Nh.cancel(this.Ni);
        }
    }

    public void oN() {
        if (this.Nh != null && this.Ni != null) {
            if (this.Nj <= 0) {
                this.Nj = 3600000L;
            }
            a(Nl, 1, System.currentTimeMillis() + this.Nj, this.Nj);
        }
    }

    public long oO() {
        if (this.Nj <= 0) {
            this.Nj = 3600000L;
        }
        return this.Nj;
    }
}
