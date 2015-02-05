package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    public static int AC = 0;
    public static int AD = 1;
    public static int AE = 2;
    private PendingIntent AA;
    private long AB;
    private AlarmManager Az;
    private Context mContext;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.AA = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Az = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Az != null) {
            this.AB = j2;
            if (i == AC) {
                this.Az.set(i2, j, this.AA);
            } else if (i == AD) {
                this.Az.setRepeating(i2, j, j2, this.AA);
            } else if (i == AE) {
                this.Az.setInexactRepeating(i2, j, j2, this.AA);
            } else {
                this.Az.set(i2, j, this.AA);
            }
        }
    }

    public void cancel() {
        if (this.Az != null && this.AA != null) {
            this.Az.cancel(this.AA);
        }
    }

    public void kU() {
        if (this.Az != null && this.AA != null) {
            if (this.AB <= 0) {
                this.AB = 3600000L;
            }
            a(AD, 1, System.currentTimeMillis() + this.AB, this.AB);
        }
    }

    public long kV() {
        if (this.AB <= 0) {
            this.AB = 3600000L;
        }
        return this.AB;
    }
}
