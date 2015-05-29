package com.baidu.tbadk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.coreExtra.service.LocationReportService;
/* loaded from: classes.dex */
public class a {
    private AlarmManager Nv;
    private PendingIntent Nw;
    private long Nx;
    private Context mContext;
    public static int Ny = 0;
    public static int Nz = 1;
    public static int NA = 2;

    public a(Context context) {
        if (context != null) {
            this.mContext = context;
            this.Nw = PendingIntent.getService(this.mContext, 0, new Intent(this.mContext, LocationReportService.class), 0);
            this.Nv = (AlarmManager) this.mContext.getSystemService("alarm");
        }
    }

    public void a(int i, int i2, long j, long j2) {
        if (this.Nv != null) {
            this.Nx = j2;
            if (i == Ny) {
                this.Nv.set(i2, j, this.Nw);
            } else if (i == Nz) {
                this.Nv.setRepeating(i2, j, j2, this.Nw);
            } else if (i == NA) {
                this.Nv.setInexactRepeating(i2, j, j2, this.Nw);
            } else {
                this.Nv.set(i2, j, this.Nw);
            }
        }
    }

    public void cancel() {
        if (this.Nv != null && this.Nw != null) {
            this.Nv.cancel(this.Nw);
        }
    }

    public void pn() {
        if (this.Nv != null && this.Nw != null) {
            if (this.Nx <= 0) {
                this.Nx = 3600000L;
            }
            a(Nz, 1, System.currentTimeMillis() + this.Nx, this.Nx);
        }
    }

    public long po() {
        if (this.Nx <= 0) {
            this.Nx = 3600000L;
        }
        return this.Nx;
    }
}
