package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int xt = 0;
    public static int xu = 1;
    public static int xv = 2;
    private Context mContext;
    private AlarmManager xq;
    private PendingIntent xr;
    private long xs;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.xr = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.xq = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.xq != null) {
            this.xs = j2;
            if (i == xt) {
                this.xq.set(i2, j, this.xr);
            } else if (i == xu) {
                this.xq.setRepeating(i2, j, j2, this.xr);
            } else if (i == xv) {
                this.xq.setInexactRepeating(i2, j, j2, this.xr);
            } else {
                this.xq.set(i2, j, this.xr);
            }
        }
    }

    public void cancel() {
        if (this.xq != null && this.xr != null) {
            this.xq.cancel(this.xr);
        }
    }

    public void iP() {
        if (this.xq != null && this.xr != null) {
            if (this.xs <= 0) {
                this.xs = 3600000L;
            }
            a(xu, 1, System.currentTimeMillis() + this.xs, this.xs);
        }
    }

    public long iQ() {
        if (this.xs <= 0) {
            this.xs = 3600000L;
        }
        return this.xs;
    }
}
