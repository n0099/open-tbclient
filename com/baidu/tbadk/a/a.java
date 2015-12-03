package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Sj = 0;
    public static int Sk = 1;
    public static int Sl = 2;
    private AlarmManager Sg;
    private PendingIntent Sh;
    private long Si;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Sh = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Sg = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Sg != null) {
            this.Si = j2;
            if (i == Sj) {
                this.Sg.set(i2, j, this.Sh);
            } else if (i == Sk) {
                this.Sg.setRepeating(i2, j, j2, this.Sh);
            } else if (i == Sl) {
                this.Sg.setInexactRepeating(i2, j, j2, this.Sh);
            } else {
                this.Sg.set(i2, j, this.Sh);
            }
        }
    }

    public void cancel() {
        if (this.Sg != null && this.Sh != null) {
            this.Sg.cancel(this.Sh);
        }
    }

    public void qm() {
        if (this.Sg != null && this.Sh != null) {
            if (this.Si <= 0) {
                this.Si = 3600000L;
            }
            a(Sk, 1, System.currentTimeMillis() + this.Si, this.Si);
        }
    }

    public long qn() {
        if (this.Si <= 0) {
            this.Si = 3600000L;
        }
        return this.Si;
    }
}
