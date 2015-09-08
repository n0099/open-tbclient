package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Sg = 0;
    public static int Sh = 1;
    public static int Si = 2;
    private AlarmManager Sd;
    private PendingIntent Se;
    private long Sf;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Se = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Sd = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Sd != null) {
            this.Sf = j2;
            if (i == Sg) {
                this.Sd.set(i2, j, this.Se);
            } else if (i == Sh) {
                this.Sd.setRepeating(i2, j, j2, this.Se);
            } else if (i == Si) {
                this.Sd.setInexactRepeating(i2, j, j2, this.Se);
            } else {
                this.Sd.set(i2, j, this.Se);
            }
        }
    }

    public void cancel() {
        if (this.Sd != null && this.Se != null) {
            this.Sd.cancel(this.Se);
        }
    }

    public void ql() {
        if (this.Sd != null && this.Se != null) {
            if (this.Sf <= 0) {
                this.Sf = 3600000L;
            }
            a(Sh, 1, System.currentTimeMillis() + this.Sf, this.Sf);
        }
    }

    public long qm() {
        if (this.Sf <= 0) {
            this.Sf = 3600000L;
        }
        return this.Sf;
    }
}
