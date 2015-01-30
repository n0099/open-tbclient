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
    private static long jQ = 10000;
    private static a jR = null;
    private static long jS = 300000;
    private LocationManager mLocationManager;
    private boolean jT = true;
    private LocationClient jU = null;
    private BDLocationListener jV = null;
    private String jW = "baidu";
    private boolean jX = true;
    private int errorCode = 0;
    private Address jY = null;
    private f jZ = null;
    public long kb = 0;
    private ArrayList<SoftReference<d>> kc = null;
    private Context mContext = null;
    private Handler handler = null;
    private final LocationListener kd = new b(this);

    private a() {
    }

    public static synchronized a dB() {
        a aVar;
        synchronized (a.class) {
            if (jR == null) {
                jR = new a();
            }
            aVar = jR;
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
        this.kc = new ArrayList<>();
        this.mContext = context;
        this.jW = str;
        this.jX = z;
        dC();
        dD();
    }

    public void y(boolean z) {
        this.jT = z;
    }

    private void dC() {
        this.handler = new Handler(new c(this));
    }

    private void dD() {
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            if (this.jT) {
                this.jV = new e(this, null);
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName(this.jW);
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(500);
                locationClientOption.disableCache(this.jX);
                this.jU = new LocationClient(this.mContext);
                this.jU.registerLocationListener(this.jV);
                this.jU.setLocOption(locationClientOption);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public Address z(boolean z) {
        if (System.currentTimeMillis() - this.kb > jS) {
            this.jY = null;
        }
        if (this.jY != null && !z) {
            return this.jY;
        }
        this.jY = null;
        dF();
        return null;
    }

    public Address a(boolean z, d dVar) {
        boolean z2;
        if (System.currentTimeMillis() - this.kb > jS) {
            this.jY = null;
        }
        if (this.jY != null && !z) {
            return this.jY;
        }
        if (dVar != null) {
            int i = 0;
            while (true) {
                if (i < this.kc.size()) {
                    d dVar2 = this.kc.get(i).get();
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
                if (this.kc.size() >= 100) {
                    this.kc.remove(0);
                }
                this.kc.add(new SoftReference<>(dVar));
            }
            dF();
        }
        return null;
    }

    public void a(d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kc.size()) {
                SoftReference<d> softReference = this.kc.get(i2);
                d dVar2 = softReference.get();
                if (dVar2 == null || !dVar2.equals(dVar)) {
                    i = i2 + 1;
                } else {
                    this.kc.remove(softReference);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void dE() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.kd);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.jU != null && this.jU.isStarted()) {
            this.jU.stop();
        }
        if (this.jZ != null) {
            this.jZ.cancel();
            this.jZ = null;
        }
    }

    private void dF() {
        try {
            this.jY = null;
            if (this.handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.kd);
            }
            if (this.jT) {
                if (!this.jU.isStarted()) {
                    this.jU.start();
                }
                this.jU.requestLocation();
            }
            this.errorCode = 4;
            if (this.mLocationManager != null && !this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network")) {
                this.errorCode = 3;
                if (!this.jT) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(0), 100L);
                    return;
                }
            }
            if (this.mLocationManager != null && this.mLocationManager.isProviderEnabled("gps")) {
                this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, this.kd);
            } else {
                this.errorCode = 1;
            }
            if (this.mLocationManager != null && this.mLocationManager.isProviderEnabled("network")) {
                this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, this.kd);
            } else {
                this.errorCode = 2;
            }
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), jQ);
        } catch (Exception e) {
            dE();
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
        if (this.kc == null) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < this.kc.size()) {
                d dVar = this.kc.get(i3).get();
                if (dVar != null) {
                    try {
                        dVar.b(i, str, address);
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                    }
                }
                i2 = i3 + 1;
            } else {
                this.kc.clear();
                return;
            }
        }
    }
}
