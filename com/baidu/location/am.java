package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class am {
    private e f;
    private Context g;
    private AlarmManager m;
    private ao n;
    private boolean p;
    private String a = "baidu_location_service";
    private ArrayList b = null;
    private float c = Float.MAX_VALUE;
    private a d = null;
    private long e = 0;
    private int h = 0;
    private long i = 0;
    private boolean j = false;
    private boolean k = false;
    private PendingIntent l = null;
    private an o = new an(this);

    public am(Context context, e eVar) {
        this.f = null;
        this.g = null;
        this.m = null;
        this.n = null;
        this.p = false;
        this.g = context;
        this.f = eVar;
        this.f.a(this.o);
        this.m = (AlarmManager) this.g.getSystemService("alarm");
        this.n = new ao(this);
        this.p = false;
    }

    private void a(long j) {
        if (this.j) {
            this.m.cancel(this.l);
        }
        this.l = PendingIntent.getBroadcast(this.g, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), 134217728);
        this.m.set(0, System.currentTimeMillis() + j, this.l);
        ap.a(this.a, "timer start:" + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        float f;
        ap.a(this.a, "notify new loation");
        this.j = false;
        if (aVar.d() != 61 && aVar.d() != 161 && aVar.d() != 65) {
            a(120000L);
        } else if (System.currentTimeMillis() - this.e < 5000 || this.b == null) {
        } else {
            this.d = aVar;
            this.e = System.currentTimeMillis();
            float[] fArr = new float[1];
            float f2 = Float.MAX_VALUE;
            Iterator it = this.b.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                d dVar = (d) it.next();
                Location.distanceBetween(aVar.a(), aVar.b(), dVar.f, dVar.g, fArr);
                f2 = (fArr[0] - dVar.c) - aVar.c();
                ap.a(this.a, "distance:" + f2);
                if (f2 > 0.0f) {
                    if (f2 < f) {
                    }
                } else if (dVar.h < 3) {
                    dVar.h++;
                    dVar.a(aVar, fArr[0]);
                    if (dVar.h < 3) {
                        this.k = true;
                    }
                }
                f2 = f;
            }
            if (f < this.c) {
                this.c = f;
            }
            this.h = 0;
            c();
        }
    }

    private boolean b() {
        boolean z = false;
        if (this.b == null || this.b.isEmpty()) {
            return false;
        }
        Iterator it = this.b.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = ((d) it.next()).h < 3 ? true : z2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c() {
        boolean z;
        int i = VersionUtils.CUR_DEVELOPMENT;
        if (!b()) {
            return;
        }
        int i2 = this.c > 5000.0f ? 600000 : this.c > 1000.0f ? 120000 : this.c > 500.0f ? 60000 : 10000;
        if (this.k) {
            this.k = false;
        } else {
            i = i2;
        }
        if (this.h != 0) {
            if (i > (this.i + this.h) - System.currentTimeMillis()) {
                z = false;
                if (z) {
                    return;
                }
                this.h = i;
                this.i = System.currentTimeMillis();
                a(this.h);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    public int a(d dVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(dVar);
        dVar.i = true;
        dVar.j = this;
        if (!this.p) {
            this.g.registerReceiver(this.n, new IntentFilter("android.com.baidu.location.TIMER.NOTIFY"));
            this.p = true;
        }
        if (dVar.e != null) {
            if (!dVar.e.equals("gcj02")) {
                double[] a = Jni.a(dVar.b, dVar.a, dVar.e + "2gcj");
                dVar.g = a[0];
                dVar.f = a[1];
                ap.a(this.a, dVar.e + "2gcj");
                ap.a(this.a, "coor:" + dVar.b + "," + dVar.a + ":" + dVar.g + "," + dVar.f);
            }
            if (this.d == null || System.currentTimeMillis() - this.e > 30000) {
                this.f.a();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.d.a(), this.d.b(), dVar.f, dVar.g, fArr);
                float c = (fArr[0] - dVar.c) - this.d.c();
                if (c > 0.0f) {
                    if (c < this.c) {
                        this.c = c;
                    }
                } else if (dVar.h < 3) {
                    dVar.h++;
                    dVar.a(this.d, fArr[0]);
                    if (dVar.h < 3) {
                        this.k = true;
                    }
                }
            }
            c();
        }
        return 1;
    }

    public void a() {
        if (this.j) {
            this.m.cancel(this.l);
        }
        this.d = null;
        this.e = 0L;
        if (this.p) {
            ap.a(this.a, "unregister...");
            this.g.unregisterReceiver(this.n);
        }
        this.p = false;
    }

    public int b(d dVar) {
        if (this.b == null) {
            return 0;
        }
        if (this.b.contains(dVar)) {
            this.b.remove(dVar);
        }
        if (this.b.size() == 0 && this.j) {
            this.m.cancel(this.l);
        }
        return 1;
    }
}
