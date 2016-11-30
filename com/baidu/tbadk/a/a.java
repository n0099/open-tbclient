package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int Mq = 0;
    public static int Mr = 1;
    public static int Ms = 2;
    private AlarmManager Mn;
    private PendingIntent Mo;
    private long Mp;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Mo = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Mn = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Mn != null) {
            this.Mp = j2;
            if (i == Mq) {
                this.Mn.set(i2, j, this.Mo);
            } else if (i == Mr) {
                this.Mn.setRepeating(i2, j, j2, this.Mo);
            } else if (i == Ms) {
                this.Mn.setInexactRepeating(i2, j, j2, this.Mo);
            } else {
                this.Mn.set(i2, j, this.Mo);
            }
        }
    }

    public void cancel() {
        if (this.Mn != null && this.Mo != null) {
            this.Mn.cancel(this.Mo);
        }
    }

    public void nw() {
        if (this.Mn != null && this.Mo != null) {
            if (this.Mp <= 0) {
                this.Mp = 3600000L;
            }
            a(Mr, 1, System.currentTimeMillis() + this.Mp, this.Mp);
        }
    }

    public long nx() {
        if (this.Mp <= 0) {
            this.Mp = 3600000L;
        }
        return this.Mp;
    }
}
