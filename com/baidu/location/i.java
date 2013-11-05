package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i {

    /* renamed from: new  reason: not valid java name */
    public static final String f217new = "android.com.baidu.location.TIMER.NOTIFY";
    private boolean c;
    private LocationClient d;

    /* renamed from: else  reason: not valid java name */
    private b f222else;

    /* renamed from: for  reason: not valid java name */
    private AlarmManager f223for;

    /* renamed from: if  reason: not valid java name */
    private Context f225if;

    /* renamed from: do  reason: not valid java name */
    private String f221do = f.v;

    /* renamed from: byte  reason: not valid java name */
    private ArrayList f218byte = null;

    /* renamed from: goto  reason: not valid java name */
    private float f224goto = Float.MAX_VALUE;

    /* renamed from: case  reason: not valid java name */
    private BDLocation f219case = null;
    private long b = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f918a = 0;

    /* renamed from: char  reason: not valid java name */
    private long f220char = 0;

    /* renamed from: void  reason: not valid java name */
    private boolean f229void = false;

    /* renamed from: long  reason: not valid java name */
    private boolean f227long = false;

    /* renamed from: try  reason: not valid java name */
    private PendingIntent f228try = null;

    /* renamed from: int  reason: not valid java name */
    private a f226int = new a();

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
            j.a(i.this.f221do, "timer expire,request location...");
            if (i.this.f218byte == null || i.this.f218byte.isEmpty()) {
                return;
            }
            i.this.d.requestNotifyLocation();
        }
    }

    public i(Context context, LocationClient locationClient) {
        this.d = null;
        this.f225if = null;
        this.f223for = null;
        this.f222else = null;
        this.c = false;
        this.f225if = context;
        this.d = locationClient;
        this.d.registerNotifyLocationListener(this.f226int);
        this.f223for = (AlarmManager) this.f225if.getSystemService("alarm");
        this.f222else = new b();
        this.c = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        boolean z;
        int i = VersionUtils.CUR_DEVELOPMENT;
        if (!m244do()) {
            return;
        }
        int i2 = this.f224goto > 5000.0f ? 600000 : this.f224goto > 1000.0f ? 120000 : this.f224goto > 500.0f ? 60000 : 10000;
        if (this.f227long) {
            this.f227long = false;
        } else {
            i = i2;
        }
        if (this.f918a != 0) {
            if (i > (this.f220char + this.f918a) - System.currentTimeMillis()) {
                z = false;
                if (z) {
                    return;
                }
                this.f918a = i;
                this.f220char = System.currentTimeMillis();
                a(this.f918a);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    private void a(long j) {
        if (this.f229void) {
            this.f223for.cancel(this.f228try);
        }
        this.f228try = PendingIntent.getBroadcast(this.f225if, 0, new Intent(f217new), 134217728);
        this.f223for.set(0, System.currentTimeMillis() + j, this.f228try);
        j.a(this.f221do, "timer start:" + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
        float f;
        j.a(this.f221do, "notify new loation");
        this.f229void = false;
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != 161 && bDLocation.getLocType() != 65) {
            a(120000L);
        } else if (System.currentTimeMillis() - this.b < 5000 || this.f218byte == null) {
        } else {
            this.f219case = bDLocation;
            this.b = System.currentTimeMillis();
            float[] fArr = new float[1];
            float f2 = Float.MAX_VALUE;
            Iterator it = this.f218byte.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                BDNotifyListener bDNotifyListener = (BDNotifyListener) it.next();
                Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                f2 = (fArr[0] - bDNotifyListener.mRadius) - bDLocation.getRadius();
                j.a(this.f221do, "distance:" + f2);
                if (f2 > 0.0f) {
                    if (f2 < f) {
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(bDLocation, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.f227long = true;
                    }
                }
                f2 = f;
            }
            if (f < this.f224goto) {
                this.f224goto = f;
            }
            this.f918a = 0;
            a();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private boolean m244do() {
        boolean z = false;
        if (this.f218byte == null || this.f218byte.isEmpty()) {
            return false;
        }
        Iterator it = this.f218byte.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = ((BDNotifyListener) it.next()).Notified < 3 ? true : z2;
        }
    }

    public void a(BDNotifyListener bDNotifyListener) {
        j.a(this.f221do, bDNotifyListener.mCoorType + "2gcj");
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] m18if = Jni.m18if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = m18if[0];
            bDNotifyListener.mLatitudeC = m18if[1];
            j.a(this.f221do, bDNotifyListener.mCoorType + "2gcj");
            j.a(this.f221do, "coor:" + bDNotifyListener.mLongitude + "," + bDNotifyListener.mLatitude + ":" + bDNotifyListener.mLongitudeC + "," + bDNotifyListener.mLatitudeC);
        }
        if (this.f219case == null || System.currentTimeMillis() - this.b > 300000) {
            this.d.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f219case.getLatitude(), this.f219case.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f219case.getRadius();
            if (radius > 0.0f) {
                if (radius < this.f224goto) {
                    this.f224goto = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.f219case, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.f227long = true;
                }
            }
        }
        a();
    }

    /* renamed from: do  reason: not valid java name */
    public int m246do(BDNotifyListener bDNotifyListener) {
        if (this.f218byte == null) {
            return 0;
        }
        if (this.f218byte.contains(bDNotifyListener)) {
            this.f218byte.remove(bDNotifyListener);
        }
        if (this.f218byte.size() == 0 && this.f229void) {
            this.f223for.cancel(this.f228try);
        }
        return 1;
    }

    /* renamed from: if  reason: not valid java name */
    public int m247if(BDNotifyListener bDNotifyListener) {
        if (this.f218byte == null) {
            this.f218byte = new ArrayList();
        }
        this.f218byte.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.c) {
            this.f225if.registerReceiver(this.f222else, new IntentFilter(f217new));
            this.c = true;
        }
        if (bDNotifyListener.mCoorType != null) {
            if (!bDNotifyListener.mCoorType.equals("gcj02")) {
                double[] m18if = Jni.m18if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
                bDNotifyListener.mLongitudeC = m18if[0];
                bDNotifyListener.mLatitudeC = m18if[1];
                j.a(this.f221do, bDNotifyListener.mCoorType + "2gcj");
                j.a(this.f221do, "coor:" + bDNotifyListener.mLongitude + "," + bDNotifyListener.mLatitude + ":" + bDNotifyListener.mLongitudeC + "," + bDNotifyListener.mLatitudeC);
            }
            if (this.f219case == null || System.currentTimeMillis() - this.b > 30000) {
                this.d.requestNotifyLocation();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.f219case.getLatitude(), this.f219case.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f219case.getRadius();
                if (radius > 0.0f) {
                    if (radius < this.f224goto) {
                        this.f224goto = radius;
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(this.f219case, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.f227long = true;
                    }
                }
            }
            a();
        }
        return 1;
    }

    /* renamed from: if  reason: not valid java name */
    public void m248if() {
        if (this.f229void) {
            this.f223for.cancel(this.f228try);
        }
        this.f219case = null;
        this.b = 0L;
        if (this.c) {
            j.a(this.f221do, "unregister...");
            this.f225if.unregisterReceiver(this.f222else);
        }
        this.c = false;
    }
}
