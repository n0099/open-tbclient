package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i {

    /* renamed from: new  reason: not valid java name */
    public static final String f181new = "android.com.baidu.location.TIMER.NOTIFY";
    private boolean c;
    private LocationClient d;

    /* renamed from: else  reason: not valid java name */
    private b f186else;

    /* renamed from: for  reason: not valid java name */
    private AlarmManager f187for;

    /* renamed from: if  reason: not valid java name */
    private Context f189if;

    /* renamed from: do  reason: not valid java name */
    private String f185do = f.v;

    /* renamed from: byte  reason: not valid java name */
    private ArrayList f182byte = null;

    /* renamed from: goto  reason: not valid java name */
    private float f188goto = Float.MAX_VALUE;

    /* renamed from: case  reason: not valid java name */
    private BDLocation f183case = null;
    private long b = 0;
    private int a = 0;

    /* renamed from: char  reason: not valid java name */
    private long f184char = 0;

    /* renamed from: void  reason: not valid java name */
    private boolean f193void = false;

    /* renamed from: long  reason: not valid java name */
    private boolean f191long = false;

    /* renamed from: try  reason: not valid java name */
    private PendingIntent f192try = null;

    /* renamed from: int  reason: not valid java name */
    private a f190int = new a();

    /* loaded from: classes.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            i.this.a(bDLocation);
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j.a(i.this.f185do, "timer expire,request location...");
            if (i.this.f182byte == null || i.this.f182byte.isEmpty()) {
                return;
            }
            i.this.d.requestNotifyLocation();
        }
    }

    public i(Context context, LocationClient locationClient) {
        this.d = null;
        this.f189if = null;
        this.f187for = null;
        this.f186else = null;
        this.c = false;
        this.f189if = context;
        this.d = locationClient;
        this.d.registerNotifyLocationListener(this.f190int);
        this.f187for = (AlarmManager) this.f189if.getSystemService("alarm");
        this.f186else = new b();
        this.c = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        boolean z;
        int i = 10000;
        if (!m228do()) {
            return;
        }
        int i2 = this.f188goto > 5000.0f ? 600000 : this.f188goto > 1000.0f ? 120000 : this.f188goto > 500.0f ? 60000 : 10000;
        if (this.f191long) {
            this.f191long = false;
        } else {
            i = i2;
        }
        if (this.a != 0) {
            if (i > (this.f184char + this.a) - System.currentTimeMillis()) {
                z = false;
                if (z) {
                    return;
                }
                this.a = i;
                this.f184char = System.currentTimeMillis();
                a(this.a);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    private void a(long j) {
        if (this.f193void) {
            this.f187for.cancel(this.f192try);
        }
        this.f192try = PendingIntent.getBroadcast(this.f189if, 0, new Intent(f181new), 134217728);
        this.f187for.set(0, System.currentTimeMillis() + j, this.f192try);
        j.a(this.f185do, "timer start:" + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
        float f;
        j.a(this.f185do, "notify new loation");
        this.f193void = false;
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != 161 && bDLocation.getLocType() != 65) {
            a(120000L);
        } else if (System.currentTimeMillis() - this.b < 5000 || this.f182byte == null) {
        } else {
            this.f183case = bDLocation;
            this.b = System.currentTimeMillis();
            float[] fArr = new float[1];
            float f2 = Float.MAX_VALUE;
            Iterator it = this.f182byte.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                BDNotifyListener bDNotifyListener = (BDNotifyListener) it.next();
                Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                f2 = (fArr[0] - bDNotifyListener.mRadius) - bDLocation.getRadius();
                j.a(this.f185do, "distance:" + f2);
                if (f2 > 0.0f) {
                    if (f2 < f) {
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(bDLocation, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.f191long = true;
                    }
                }
                f2 = f;
            }
            if (f < this.f188goto) {
                this.f188goto = f;
            }
            this.a = 0;
            a();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private boolean m228do() {
        boolean z = false;
        if (this.f182byte == null || this.f182byte.isEmpty()) {
            return false;
        }
        Iterator it = this.f182byte.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = ((BDNotifyListener) it.next()).Notified < 3 ? true : z2;
        }
    }

    public void a(BDNotifyListener bDNotifyListener) {
        j.a(this.f185do, bDNotifyListener.mCoorType + "2gcj");
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] m2if = Jni.m2if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = m2if[0];
            bDNotifyListener.mLatitudeC = m2if[1];
            j.a(this.f185do, bDNotifyListener.mCoorType + "2gcj");
            j.a(this.f185do, "coor:" + bDNotifyListener.mLongitude + "," + bDNotifyListener.mLatitude + ":" + bDNotifyListener.mLongitudeC + "," + bDNotifyListener.mLatitudeC);
        }
        if (this.f183case == null || System.currentTimeMillis() - this.b > 300000) {
            this.d.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f183case.getLatitude(), this.f183case.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f183case.getRadius();
            if (radius > 0.0f) {
                if (radius < this.f188goto) {
                    this.f188goto = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.f183case, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.f191long = true;
                }
            }
        }
        a();
    }

    /* renamed from: do  reason: not valid java name */
    public int m230do(BDNotifyListener bDNotifyListener) {
        if (this.f182byte == null) {
            return 0;
        }
        if (this.f182byte.contains(bDNotifyListener)) {
            this.f182byte.remove(bDNotifyListener);
        }
        if (this.f182byte.size() == 0 && this.f193void) {
            this.f187for.cancel(this.f192try);
        }
        return 1;
    }

    /* renamed from: if  reason: not valid java name */
    public int m231if(BDNotifyListener bDNotifyListener) {
        if (this.f182byte == null) {
            this.f182byte = new ArrayList();
        }
        this.f182byte.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.c) {
            this.f189if.registerReceiver(this.f186else, new IntentFilter(f181new));
            this.c = true;
        }
        if (bDNotifyListener.mCoorType != null) {
            if (!bDNotifyListener.mCoorType.equals("gcj02")) {
                double[] m2if = Jni.m2if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
                bDNotifyListener.mLongitudeC = m2if[0];
                bDNotifyListener.mLatitudeC = m2if[1];
                j.a(this.f185do, bDNotifyListener.mCoorType + "2gcj");
                j.a(this.f185do, "coor:" + bDNotifyListener.mLongitude + "," + bDNotifyListener.mLatitude + ":" + bDNotifyListener.mLongitudeC + "," + bDNotifyListener.mLatitudeC);
            }
            if (this.f183case == null || System.currentTimeMillis() - this.b > 30000) {
                this.d.requestNotifyLocation();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.f183case.getLatitude(), this.f183case.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f183case.getRadius();
                if (radius > 0.0f) {
                    if (radius < this.f188goto) {
                        this.f188goto = radius;
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(this.f183case, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.f191long = true;
                    }
                }
            }
            a();
        }
        return 1;
    }

    /* renamed from: if  reason: not valid java name */
    public void m232if() {
        if (this.f193void) {
            this.f187for.cancel(this.f192try);
        }
        this.f183case = null;
        this.b = 0L;
        if (this.c) {
            j.a(this.f185do, "unregister...");
            this.f189if.unregisterReceiver(this.f186else);
        }
        this.c = false;
    }
}
