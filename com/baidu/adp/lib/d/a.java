package com.baidu.adp.lib.d;

import android.content.Context;
import android.location.Address;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import java.lang.ref.SoftReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static long jO = 10000;
    private static a jP = null;
    private static long jQ = 300000;
    private LocationManager mLocationManager;
    private boolean jR = true;
    private LocationClient mLocationClient = null;
    private BDLocationListener jS = null;
    private String jT = "baidu";
    private boolean jU = true;
    private int errorCode = 0;
    private Address jV = null;
    private f jW = null;
    public long jX = 0;
    private ArrayList<SoftReference<d>> jY = null;
    private Context mContext = null;
    private Handler handler = null;
    private final LocationListener jZ = new b(this);

    private a() {
    }

    public static synchronized a dD() {
        a aVar;
        synchronized (a.class) {
            if (jP == null) {
                jP = new a();
            }
            aVar = jP;
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
        this.jY = new ArrayList<>();
        this.mContext = context;
        this.jT = str;
        this.jU = z;
        dE();
        dF();
    }

    public void y(boolean z) {
        this.jR = z;
    }

    private void dE() {
        this.handler = new Handler(new c(this));
    }

    private void dF() {
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            if (this.jR) {
                this.jS = new e(this, null);
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName(this.jT);
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(500);
                locationClientOption.disableCache(this.jU);
                this.mLocationClient = new LocationClient(this.mContext);
                this.mLocationClient.registerLocationListener(this.jS);
                this.mLocationClient.setLocOption(locationClientOption);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public Address z(boolean z) {
        if (System.currentTimeMillis() - this.jX > jQ) {
            this.jV = null;
        }
        if (this.jV != null && !z) {
            return this.jV;
        }
        this.jV = null;
        dH();
        return null;
    }

    public Address a(boolean z, d dVar) {
        boolean z2;
        if (System.currentTimeMillis() - this.jX > jQ) {
            this.jV = null;
        }
        if (this.jV != null && !z) {
            return this.jV;
        }
        if (dVar != null) {
            int i = 0;
            while (true) {
                if (i < this.jY.size()) {
                    d dVar2 = this.jY.get(i).get();
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
                if (this.jY.size() >= 100) {
                    this.jY.remove(0);
                }
                this.jY.add(new SoftReference<>(dVar));
            }
            dH();
        }
        return null;
    }

    public void a(d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jY.size()) {
                SoftReference<d> softReference = this.jY.get(i2);
                d dVar2 = softReference.get();
                if (dVar2 == null || !dVar2.equals(dVar)) {
                    i = i2 + 1;
                } else {
                    this.jY.remove(softReference);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void dG() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.jZ);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.mLocationClient != null && this.mLocationClient.isStarted()) {
            this.mLocationClient.stop();
        }
        if (this.jW != null) {
            this.jW.cancel();
            this.jW = null;
        }
    }

    private void dH() {
        try {
            this.jV = null;
            if (this.handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.jZ);
            }
            if (this.jR) {
                if (!this.mLocationClient.isStarted()) {
                    this.mLocationClient.start();
                }
                this.mLocationClient.requestLocation();
            }
            this.errorCode = 4;
            if (this.mLocationManager != null && !this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network")) {
                this.errorCode = 3;
                if (!this.jR) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(0), 100L);
                    return;
                }
            }
            if (this.mLocationManager != null && this.mLocationManager.isProviderEnabled("gps")) {
                this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, this.jZ);
            } else {
                this.errorCode = 1;
            }
            if (this.mLocationManager != null && this.mLocationManager.isProviderEnabled("network")) {
                this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, this.jZ);
            } else {
                this.errorCode = 2;
            }
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), jO);
        } catch (Exception e) {
            dG();
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
        if (this.jY == null) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < this.jY.size()) {
                d dVar = this.jY.get(i3).get();
                if (dVar != null) {
                    try {
                        dVar.b(i, str, address);
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                    }
                }
                i2 = i3 + 1;
            } else {
                this.jY.clear();
                return;
            }
        }
    }
}
