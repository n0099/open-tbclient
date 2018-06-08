package com.baidu.location.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.support.v4.app.NotificationCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private LocationClient Xd;
    private AlarmManager Xf;
    private C0067a Xg;
    private Context f;
    private boolean n;
    private ArrayList<BDNotifyListener> a = null;
    private float b = Float.MAX_VALUE;
    private BDLocation Xc = null;
    private long d = 0;
    private int g = 0;
    private long h = 0;
    private boolean i = false;
    private PendingIntent Xe = null;
    private b Xh = new b();

    /* renamed from: com.baidu.location.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0067a extends BroadcastReceiver {
        public C0067a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (a.this.a == null || a.this.a.isEmpty()) {
                return;
            }
            a.this.Xd.requestNotifyLocation();
        }
    }

    /* loaded from: classes.dex */
    public class b implements BDLocationListener {
        public b() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (a.this.a == null || a.this.a.size() <= 0) {
                return;
            }
            a.this.a(bDLocation);
        }
    }

    public a(Context context, LocationClient locationClient) {
        this.Xd = null;
        this.f = null;
        this.Xf = null;
        this.Xg = null;
        this.n = false;
        this.f = context;
        this.Xd = locationClient;
        this.Xd.registerNotifyLocationListener(this.Xh);
        this.Xf = (AlarmManager) this.f.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.Xg = new C0067a();
        this.n = false;
    }

    private void a(long j) {
        try {
            if (this.Xe != null) {
                this.Xf.cancel(this.Xe);
            }
            this.Xe = PendingIntent.getBroadcast(this.f, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), 134217728);
            if (this.Xe == null) {
                return;
            }
            this.Xf.set(0, System.currentTimeMillis() + j, this.Xe);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
        float f;
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != 161 && bDLocation.getLocType() != 65) {
            a(120000L);
        } else if (System.currentTimeMillis() - this.d < TbConfig.NOTIFY_SOUND_INTERVAL || this.a == null) {
        } else {
            this.Xc = bDLocation;
            this.d = System.currentTimeMillis();
            float[] fArr = new float[1];
            float f2 = Float.MAX_VALUE;
            Iterator<BDNotifyListener> it = this.a.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                BDNotifyListener next = it.next();
                Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), next.mLatitudeC, next.mLongitudeC, fArr);
                f2 = (fArr[0] - next.mRadius) - bDLocation.getRadius();
                if (f2 > 0.0f) {
                    if (f2 < f) {
                    }
                } else if (next.Notified < 3) {
                    next.Notified++;
                    next.onNotify(bDLocation, fArr[0]);
                    if (next.Notified < 3) {
                        this.i = true;
                    }
                }
                f2 = f;
            }
            if (f < this.b) {
                this.b = f;
            }
            this.g = 0;
            c();
        }
    }

    private boolean b() {
        boolean z = false;
        if (this.a == null || this.a.isEmpty()) {
            return false;
        }
        Iterator<BDNotifyListener> it = this.a.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().Notified < 3 ? true : z2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c() {
        boolean z;
        int i = 10000;
        if (!b()) {
            return;
        }
        int i2 = this.b > 5000.0f ? 600000 : this.b > 1000.0f ? BdStatisticsManager.UPLOAD_TIMER_INTERVAL : this.b > 500.0f ? 60000 : 10000;
        if (this.i) {
            this.i = false;
        } else {
            i = i2;
        }
        if (this.g != 0) {
            if (i > (this.h + this.g) - System.currentTimeMillis()) {
                z = false;
                if (z) {
                    return;
                }
                this.g = i;
                this.h = System.currentTimeMillis();
                a(this.g);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    public int a(BDNotifyListener bDNotifyListener) {
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.n) {
            this.f.registerReceiver(this.Xg, new IntentFilter("android.com.baidu.location.TIMER.NOTIFY"));
            this.n = true;
        }
        if (bDNotifyListener.mCoorType != null) {
            if (!bDNotifyListener.mCoorType.equals("gcj02")) {
                double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
                bDNotifyListener.mLongitudeC = coorEncrypt[0];
                bDNotifyListener.mLatitudeC = coorEncrypt[1];
            }
            if (this.Xc == null || System.currentTimeMillis() - this.d > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.Xd.requestNotifyLocation();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.Xc.getLatitude(), this.Xc.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - this.Xc.getRadius();
                if (radius > 0.0f) {
                    if (radius < this.b) {
                        this.b = radius;
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(this.Xc, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.i = true;
                    }
                }
            }
            c();
        }
        return 1;
    }

    public void a() {
        if (this.Xe != null) {
            this.Xf.cancel(this.Xe);
        }
        this.Xc = null;
        this.d = 0L;
        if (this.n) {
            this.f.unregisterReceiver(this.Xg);
        }
        this.n = false;
    }

    public void b(BDNotifyListener bDNotifyListener) {
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.Xc == null || System.currentTimeMillis() - this.d > ReportUserInfoModel.TIME_INTERVAL) {
            this.Xd.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.Xc.getLatitude(), this.Xc.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.Xc.getRadius();
            if (radius > 0.0f) {
                if (radius < this.b) {
                    this.b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.Xc, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.i = true;
                }
            }
        }
        c();
    }

    public int c(BDNotifyListener bDNotifyListener) {
        if (this.a == null) {
            return 0;
        }
        if (this.a.contains(bDNotifyListener)) {
            this.a.remove(bDNotifyListener);
        }
        if (this.a.size() == 0 && this.Xe != null) {
            this.Xf.cancel(this.Xe);
        }
        return 1;
    }
}
