package com.baidu.adp.lib.d;

import android.content.Context;
import android.location.Address;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDGeofence;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import java.lang.ref.SoftReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static long vh = 10000;
    private static a vi = null;
    private static long vj = 300000;
    private LocationManager mLocationManager;
    private boolean vk = true;
    private LocationClient vl = null;
    private BDLocationListener vm = null;
    private String vn = "baidu";
    private boolean vo = true;
    private int errorCode = 0;
    private Address vp = null;
    private f vq = null;
    public long vr = 0;
    private ArrayList<SoftReference<d>> vs = null;
    private Context mContext = null;
    private Handler handler = null;
    private final LocationListener vt = new b(this);

    private a() {
    }

    public static synchronized a gZ() {
        a aVar;
        synchronized (a.class) {
            if (vi == null) {
                vi = new a();
            }
            aVar = vi;
        }
        return aVar;
    }

    public void s(Context context, String str) {
        b(context, str, true);
    }

    public void b(Context context, String str, boolean z) {
        if (context == null) {
            throw new InvalidParameterException("context is null");
        }
        this.vs = new ArrayList<>();
        this.mContext = context;
        this.vn = str;
        this.vo = z;
        ha();
        hb();
    }

    public void y(boolean z) {
        this.vk = z;
    }

    private void ha() {
        this.handler = new Handler(new c(this));
    }

    private void hb() {
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            if (this.vk) {
                this.vm = new e(this, null);
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName(this.vn);
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                locationClientOption.setScanSpan(500);
                this.vl = new LocationClient(this.mContext);
                this.vl.registerLocationListener(this.vm);
                this.vl.setLocOption(locationClientOption);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public Address z(boolean z) {
        if (System.currentTimeMillis() - this.vr > vj) {
            this.vp = null;
        }
        if (this.vp != null && !z) {
            return this.vp;
        }
        this.vp = null;
        hd();
        return null;
    }

    public Address a(boolean z, d dVar) {
        boolean z2;
        if (System.currentTimeMillis() - this.vr > vj) {
            this.vp = null;
        }
        if (this.vp != null && !z) {
            return this.vp;
        }
        if (dVar != null) {
            int i = 0;
            while (true) {
                if (i < this.vs.size()) {
                    d dVar2 = this.vs.get(i).get();
                    if (dVar2 == null || !dVar2.equals(dVar)) {
                        i++;
                    } else {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                if (this.vs.size() >= 100) {
                    this.vs.remove(0);
                }
                this.vs.add(new SoftReference<>(dVar));
            }
            hd();
        }
        return null;
    }

    public void a(d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.vs.size()) {
                SoftReference<d> softReference = this.vs.get(i2);
                d dVar2 = softReference.get();
                if (dVar2 == null || !dVar2.equals(dVar)) {
                    i = i2 + 1;
                } else {
                    this.vs.remove(softReference);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void hc() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.vt);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.vl != null && this.vl.isStarted()) {
            this.vl.stop();
        }
        if (this.vq != null) {
            this.vq.cancel();
            this.vq = null;
        }
    }

    private void hd() {
        try {
            this.vp = null;
            if (this.handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.vt);
            }
            if (this.vk) {
                if (!this.vl.isStarted()) {
                    this.vl.start();
                }
                this.vl.requestLocation();
            }
            this.errorCode = 4;
            if (this.mLocationManager != null && !this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network")) {
                this.errorCode = 3;
                if (!this.vk) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(0), 100L);
                    return;
                }
            }
            if (this.mLocationManager != null && this.mLocationManager.isProviderEnabled("gps")) {
                this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, this.vt);
            } else {
                this.errorCode = 1;
            }
            if (this.mLocationManager != null && this.mLocationManager.isProviderEnabled("network")) {
                this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, this.vt);
            } else {
                this.errorCode = 2;
            }
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), vh);
        } catch (Exception e) {
            hc();
            this.errorCode = 5;
            if (this.handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), 100L);
        }
    }

    public void a(int i, String str, Address address) {
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.vs == null) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < this.vs.size()) {
                d dVar = this.vs.get(i3).get();
                if (dVar != null) {
                    try {
                        dVar.b(i, str, address);
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                    }
                }
                i2 = i3 + 1;
            } else {
                this.vs.clear();
                return;
            }
        }
    }
}
