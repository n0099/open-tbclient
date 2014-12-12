package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int AF = 0;
    public static int AG = 1;
    public static int AH = 2;
    private AlarmManager AC;
    private PendingIntent AD;
    private long AE;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.AD = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.AC = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.AC != null) {
            this.AE = j2;
            if (i == AF) {
                this.AC.set(i2, j, this.AD);
            } else if (i == AG) {
                this.AC.setRepeating(i2, j, j2, this.AD);
            } else if (i == AH) {
                this.AC.setInexactRepeating(i2, j, j2, this.AD);
            } else {
                this.AC.set(i2, j, this.AD);
            }
        }
    }

    public void cancel() {
        if (this.AC != null && this.AD != null) {
            this.AC.cancel(this.AD);
        }
    }

    public void lb() {
        if (this.AC != null && this.AD != null) {
            if (this.AE <= 0) {
                this.AE = 3600000L;
            }
            a(AG, 1, System.currentTimeMillis() + this.AE, this.AE);
        }
    }

    public long lc() {
        if (this.AE <= 0) {
            this.AE = 3600000L;
        }
        return this.AE;
    }
}
