package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Pm = 0;
    public static int Pn = 1;
    public static int Po = 2;
    private AlarmManager Pj;
    private PendingIntent Pk;
    private long Pl;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Pk = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Pj = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Pj != null) {
            this.Pl = j2;
            if (i == Pm) {
                this.Pj.set(i2, j, this.Pk);
            } else if (i == Pn) {
                this.Pj.setRepeating(i2, j, j2, this.Pk);
            } else if (i == Po) {
                this.Pj.setInexactRepeating(i2, j, j2, this.Pk);
            } else {
                this.Pj.set(i2, j, this.Pk);
            }
        }
    }

    public void cancel() {
        if (this.Pj != null && this.Pk != null) {
            this.Pj.cancel(this.Pk);
        }
    }

    public void pq() {
        if (this.Pj != null && this.Pk != null) {
            if (this.Pl <= 0) {
                this.Pl = 3600000L;
            }
            a(Pn, 1, System.currentTimeMillis() + this.Pl, this.Pl);
        }
    }

    public long pr() {
        if (this.Pl <= 0) {
            this.Pl = 3600000L;
        }
        return this.Pl;
    }
}
