package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Si = 0;
    public static int Sj = 1;
    public static int Sk = 2;
    private AlarmManager Sf;
    private PendingIntent Sg;
    private long Sh;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Sg = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Sf = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Sf != null) {
            this.Sh = j2;
            if (i == Si) {
                this.Sf.set(i2, j, this.Sg);
            } else if (i == Sj) {
                this.Sf.setRepeating(i2, j, j2, this.Sg);
            } else if (i == Sk) {
                this.Sf.setInexactRepeating(i2, j, j2, this.Sg);
            } else {
                this.Sf.set(i2, j, this.Sg);
            }
        }
    }

    public void cancel() {
        if (this.Sf != null && this.Sg != null) {
            this.Sf.cancel(this.Sg);
        }
    }

    public void qo() {
        if (this.Sf != null && this.Sg != null) {
            if (this.Sh <= 0) {
                this.Sh = 3600000L;
            }
            a(Sj, 1, System.currentTimeMillis() + this.Sh, this.Sh);
        }
    }

    public long qp() {
        if (this.Sh <= 0) {
            this.Sh = 3600000L;
        }
        return this.Sh;
    }
}
