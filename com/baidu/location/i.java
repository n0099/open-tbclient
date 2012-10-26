package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.baidu.tieba.data.Config;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i {

    /* renamed from: new  reason: not valid java name */
    public static final String f165new = "android.com.baidu.location.TIMER.NOTIFY";
    private boolean c;
    private LocationClient d;

    /* renamed from: else  reason: not valid java name */
    private b f170else;

    /* renamed from: for  reason: not valid java name */
    private AlarmManager f171for;

    /* renamed from: if  reason: not valid java name */
    private Context f173if;

    /* renamed from: do  reason: not valid java name */
    private String f169do = f.g;

    /* renamed from: byte  reason: not valid java name */
    private ArrayList f166byte = null;

    /* renamed from: goto  reason: not valid java name */
    private float f172goto = Float.MAX_VALUE;

    /* renamed from: case  reason: not valid java name */
    private BDLocation f167case = null;
    private long b = 0;
    private int a = 0;

    /* renamed from: char  reason: not valid java name */
    private long f168char = 0;

    /* renamed from: void  reason: not valid java name */
    private boolean f177void = false;

    /* renamed from: long  reason: not valid java name */
    private boolean f175long = false;

    /* renamed from: try  reason: not valid java name */
    private PendingIntent f176try = null;

    /* renamed from: int  reason: not valid java name */
    private a f174int = new a();

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
            j.a(i.this.f169do, "timer expire,request location...");
            if (i.this.f166byte == null || i.this.f166byte.isEmpty()) {
                return;
            }
            i.this.d.requestNotifyLocation();
        }
    }

    public i(Context context, LocationClient locationClient) {
        this.d = null;
        this.f173if = null;
        this.f171for = null;
        this.f170else = null;
        this.c = false;
        this.f173if = context;
        this.d = locationClient;
        this.d.registerNotifyLocationListener(this.f174int);
        this.f171for = (AlarmManager) this.f173if.getSystemService("alarm");
        this.f170else = new b();
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
        if (!m177do()) {
            return;
        }
        int i2 = this.f172goto > 5000.0f ? 600000 : this.f172goto > 1000.0f ? 120000 : this.f172goto > 500.0f ? Config.SYNC_TIME_INTERVAL : 10000;
        if (this.f175long) {
            this.f175long = false;
        } else {
            i = i2;
        }
        if (this.a != 0) {
            if (i > (this.f168char + this.a) - System.currentTimeMillis()) {
                z = false;
                if (z) {
                    return;
                }
                this.a = i;
                this.f168char = System.currentTimeMillis();
                a(this.a);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    private void a(long j) {
        if (this.f177void) {
            this.f171for.cancel(this.f176try);
        }
        this.f176try = PendingIntent.getBroadcast(this.f173if, 0, new Intent(f165new), 134217728);
        this.f171for.set(0, System.currentTimeMillis() + j, this.f176try);
        j.a(this.f169do, "timer start:" + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
        float f;
        j.a(this.f169do, "notify new loation");
        this.f177void = false;
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != 161 && bDLocation.getLocType() != 65) {
            a(120000L);
        } else if (System.currentTimeMillis() - this.b < 5000 || this.f166byte == null) {
        } else {
            this.f167case = bDLocation;
            this.b = System.currentTimeMillis();
            float[] fArr = new float[1];
            float f2 = Float.MAX_VALUE;
            Iterator it = this.f166byte.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                BDNotifyListener bDNotifyListener = (BDNotifyListener) it.next();
                Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                f2 = (fArr[0] - bDNotifyListener.mRadius) - bDLocation.getRadius();
                j.a(this.f169do, "distance:" + f2);
                if (f2 > 0.0f) {
                    if (f2 < f) {
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(bDLocation, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.f175long = true;
                    }
                }
                f2 = f;
            }
            if (f < this.f172goto) {
                this.f172goto = f;
            }
            this.a = 0;
            a();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private boolean m177do() {
        boolean z = false;
        if (this.f166byte == null || this.f166byte.isEmpty()) {
            return false;
        }
        Iterator it = this.f166byte.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = ((BDNotifyListener) it.next()).Notified < 3 ? true : z2;
        }
    }

    public void a(BDNotifyListener bDNotifyListener) {
        j.a(this.f169do, bDNotifyListener.mCoorType + "2gcj");
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] m1if = Jni.m1if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = m1if[0];
            bDNotifyListener.mLatitudeC = m1if[1];
            j.a(this.f169do, bDNotifyListener.mCoorType + "2gcj");
            j.a(this.f169do, "coor:" + bDNotifyListener.mLongitude + "," + bDNotifyListener.mLatitude + ":" + bDNotifyListener.mLongitudeC + "," + bDNotifyListener.mLatitudeC);
        }
        if (this.f167case == null || System.currentTimeMillis() - this.b > 300000) {
            this.d.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f167case.getLatitude(), this.f167case.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f167case.getRadius();
            if (radius > 0.0f) {
                if (radius < this.f172goto) {
                    this.f172goto = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.f167case, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.f175long = true;
                }
            }
        }
        a();
    }

    /* renamed from: do  reason: not valid java name */
    public int m179do(BDNotifyListener bDNotifyListener) {
        if (this.f166byte == null) {
            return 0;
        }
        if (this.f166byte.contains(bDNotifyListener)) {
            this.f166byte.remove(bDNotifyListener);
        }
        if (this.f166byte.size() == 0 && this.f177void) {
            this.f171for.cancel(this.f176try);
        }
        return 1;
    }

    /* renamed from: if  reason: not valid java name */
    public int m180if(BDNotifyListener bDNotifyListener) {
        if (this.f166byte == null) {
            this.f166byte = new ArrayList();
        }
        this.f166byte.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.c) {
            this.f173if.registerReceiver(this.f170else, new IntentFilter(f165new));
            this.c = true;
        }
        if (bDNotifyListener.mCoorType != null) {
            if (!bDNotifyListener.mCoorType.equals("gcj02")) {
                double[] m1if = Jni.m1if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
                bDNotifyListener.mLongitudeC = m1if[0];
                bDNotifyListener.mLatitudeC = m1if[1];
                j.a(this.f169do, bDNotifyListener.mCoorType + "2gcj");
                j.a(this.f169do, "coor:" + bDNotifyListener.mLongitude + "," + bDNotifyListener.mLatitude + ":" + bDNotifyListener.mLongitudeC + "," + bDNotifyListener.mLatitudeC);
            }
            if (this.f167case == null || System.currentTimeMillis() - this.b > 30000) {
                this.d.requestNotifyLocation();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.f167case.getLatitude(), this.f167case.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f167case.getRadius();
                if (radius > 0.0f) {
                    if (radius < this.f172goto) {
                        this.f172goto = radius;
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(this.f167case, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.f175long = true;
                    }
                }
            }
            a();
        }
        return 1;
    }

    /* renamed from: if  reason: not valid java name */
    public void m181if() {
        if (this.f177void) {
            this.f171for.cancel(this.f176try);
        }
        this.f167case = null;
        this.b = 0L;
        if (this.c) {
            j.a(this.f169do, "unregister...");
            this.f173if.unregisterReceiver(this.f170else);
        }
        this.c = false;
    }
}
