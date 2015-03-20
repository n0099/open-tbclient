package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ab implements a0, n {
    public static final String gC = "android.com.baidu.location.TIMER.NOTIFY";
    private AlarmManager gA;
    private b gH;
    private boolean gL;
    private LocationClient gM;
    private Context gz;
    private ArrayList gE = null;
    private float gI = Float.MAX_VALUE;
    private BDLocation gF = null;
    private long gK = 0;
    private int gy = 0;
    private long gG = 0;
    private boolean gJ = false;
    private PendingIntent gD = null;
    private a gB = new a();

    /* loaded from: classes.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        public void a(BDLocation bDLocation) {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (ab.this.gE == null || ab.this.gE.size() <= 0) {
                return;
            }
            ab.this.m125int(bDLocation);
        }
    }

    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ab.this.gE == null || ab.this.gE.isEmpty()) {
                return;
            }
            ab.this.gM.requestNotifyLocation();
        }
    }

    public ab(Context context, LocationClient locationClient) {
        this.gM = null;
        this.gz = null;
        this.gA = null;
        this.gH = null;
        this.gL = false;
        this.gz = context;
        this.gM = locationClient;
        this.gM.registerNotifyLocationListener(this.gB);
        this.gA = (AlarmManager) this.gz.getSystemService("alarm");
        this.gH = new b();
        this.gL = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bl() {
        boolean z;
        int i = 10000;
        if (!bn()) {
            return;
        }
        int i2 = this.gI > 5000.0f ? 600000 : this.gI > 1000.0f ? 120000 : this.gI > 500.0f ? GroupInfoActivityConfig.JOIN_BUTTON_DISABLE_MAX_DURATION : 10000;
        if (this.gJ) {
            this.gJ = false;
        } else {
            i = i2;
        }
        if (this.gy != 0) {
            if (i > (this.gG + this.gy) - System.currentTimeMillis()) {
                z = false;
                if (z) {
                    return;
                }
                this.gy = i;
                this.gG = System.currentTimeMillis();
                m123if(this.gy);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    private boolean bn() {
        boolean z = false;
        if (this.gE == null || this.gE.isEmpty()) {
            return false;
        }
        Iterator it = this.gE.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = ((BDNotifyListener) it.next()).Notified < 3 ? true : z2;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m123if(long j) {
        try {
            if (this.gD != null) {
                this.gA.cancel(this.gD);
            }
            this.gD = PendingIntent.getBroadcast(this.gz, 0, new Intent(gC), 134217728);
            if (this.gD == null) {
                return;
            }
            this.gA.set(0, System.currentTimeMillis() + j, this.gD);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m125int(BDLocation bDLocation) {
        float f;
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != 161 && bDLocation.getLocType() != 65) {
            m123if(120000L);
        } else if (System.currentTimeMillis() - this.gK < TbConfig.NOTIFY_SOUND_INTERVAL || this.gE == null) {
        } else {
            this.gF = bDLocation;
            this.gK = System.currentTimeMillis();
            float[] fArr = new float[1];
            float f2 = Float.MAX_VALUE;
            Iterator it = this.gE.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                BDNotifyListener bDNotifyListener = (BDNotifyListener) it.next();
                Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                f2 = (fArr[0] - bDNotifyListener.mRadius) - bDLocation.getRadius();
                if (f2 > 0.0f) {
                    if (f2 < f) {
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(bDLocation, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.gJ = true;
                    }
                }
                f2 = f;
            }
            if (f < this.gI) {
                this.gI = f;
            }
            this.gy = 0;
            bl();
        }
    }

    public void bm() {
        if (this.gD != null) {
            this.gA.cancel(this.gD);
        }
        this.gF = null;
        this.gK = 0L;
        if (this.gL) {
            this.gz.unregisterReceiver(this.gH);
        }
        this.gL = false;
    }

    /* renamed from: do  reason: not valid java name */
    public int m126do(BDNotifyListener bDNotifyListener) {
        if (this.gE == null) {
            this.gE = new ArrayList();
        }
        this.gE.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.gL) {
            this.gz.registerReceiver(this.gH, new IntentFilter(gC));
            this.gL = true;
        }
        if (bDNotifyListener.mCoorType != null) {
            if (!bDNotifyListener.mCoorType.equals(BDGeofence.COORD_TYPE_GCJ)) {
                double[] m20if = Jni.m20if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
                bDNotifyListener.mLongitudeC = m20if[0];
                bDNotifyListener.mLatitudeC = m20if[1];
            }
            if (this.gF == null || System.currentTimeMillis() - this.gK > 30000) {
                this.gM.requestNotifyLocation();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.gF.getLatitude(), this.gF.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - this.gF.getRadius();
                if (radius > 0.0f) {
                    if (radius < this.gI) {
                        this.gI = radius;
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(this.gF, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.gJ = true;
                    }
                }
            }
            bl();
        }
        return 1;
    }

    /* renamed from: for  reason: not valid java name */
    public int m127for(BDNotifyListener bDNotifyListener) {
        if (this.gE == null) {
            return 0;
        }
        if (this.gE.contains(bDNotifyListener)) {
            this.gE.remove(bDNotifyListener);
        }
        if (this.gE.size() == 0 && this.gD != null) {
            this.gA.cancel(this.gD);
        }
        return 1;
    }

    /* renamed from: if  reason: not valid java name */
    public void m128if(BDNotifyListener bDNotifyListener) {
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals(BDGeofence.COORD_TYPE_GCJ)) {
            double[] m20if = Jni.m20if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = m20if[0];
            bDNotifyListener.mLatitudeC = m20if[1];
        }
        if (this.gF == null || System.currentTimeMillis() - this.gK > 300000) {
            this.gM.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.gF.getLatitude(), this.gF.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.gF.getRadius();
            if (radius > 0.0f) {
                if (radius < this.gI) {
                    this.gI = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.gF, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.gJ = true;
                }
            }
        }
        bl();
    }
}
