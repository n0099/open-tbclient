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
    private static long ut = 10000;
    private static a uu = null;
    private static long uv = 300000;
    private LocationManager mLocationManager;
    private boolean uw = true;
    private LocationClient ux = null;
    private BDLocationListener uy = null;
    private String uz = "baidu";
    private boolean uA = true;
    private int errorCode = 0;
    private Address uB = null;
    private f uC = null;
    public long uD = 0;
    private ArrayList<SoftReference<d>> uE = null;
    private Context mContext = null;
    private Handler handler = null;
    private final LocationListener uF = new b(this);

    private a() {
    }

    public static synchronized a gK() {
        a aVar;
        synchronized (a.class) {
            if (uu == null) {
                uu = new a();
            }
            aVar = uu;
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
        this.uE = new ArrayList<>();
        this.mContext = context;
        this.uz = str;
        this.uA = z;
        gL();
        gM();
    }

    public void y(boolean z) {
        this.uw = z;
    }

    private void gL() {
        this.handler = new Handler(new c(this));
    }

    private void gM() {
        try {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            if (this.uw) {
                this.uy = new e(this, null);
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setIgnoreKillProcess(true);
                locationClientOption.setProdName(this.uz);
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType(BDGeofence.COORD_TYPE_BD09LL);
                locationClientOption.setScanSpan(500);
                this.ux = new LocationClient(this.mContext);
                this.ux.registerLocationListener(this.uy);
                this.ux.setLocOption(locationClientOption);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public Address z(boolean z) {
        if (System.currentTimeMillis() - this.uD > uv) {
            this.uB = null;
        }
        if (this.uB != null && !z) {
            return this.uB;
        }
        this.uB = null;
        gO();
        return null;
    }

    public Address a(boolean z, d dVar) {
        boolean z2;
        if (System.currentTimeMillis() - this.uD > uv) {
            this.uB = null;
        }
        if (this.uB != null && !z) {
            return this.uB;
        }
        if (dVar != null) {
            int i = 0;
            while (true) {
                if (i < this.uE.size()) {
                    d dVar2 = this.uE.get(i).get();
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
                if (this.uE.size() >= 100) {
                    this.uE.remove(0);
                }
                this.uE.add(new SoftReference<>(dVar));
            }
            gO();
        }
        return null;
    }

    public void a(d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.uE.size()) {
                SoftReference<d> softReference = this.uE.get(i2);
                d dVar2 = softReference.get();
                if (dVar2 == null || !dVar2.equals(dVar)) {
                    i = i2 + 1;
                } else {
                    this.uE.remove(softReference);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void gN() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.uF);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.ux != null && this.ux.isStarted()) {
            this.ux.stop();
        }
        if (this.uC != null) {
            this.uC.cancel();
            this.uC = null;
        }
    }

    private void gO() {
        try {
            this.uB = null;
            if (this.handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            if (this.mLocationManager != null) {
                this.mLocationManager.removeUpdates(this.uF);
            }
            if (this.uw) {
                if (!this.ux.isStarted()) {
                    this.ux.start();
                }
                this.ux.requestLocation();
            }
            this.errorCode = 4;
            if (this.mLocationManager != null && !this.mLocationManager.isProviderEnabled("gps") && !this.mLocationManager.isProviderEnabled("network")) {
                this.errorCode = 3;
                if (!this.uw) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(0), 100L);
                    return;
                }
            }
            if (this.mLocationManager != null && this.mLocationManager.isProviderEnabled("gps")) {
                this.mLocationManager.requestLocationUpdates("gps", 10000L, 100.0f, this.uF);
            } else {
                this.errorCode = 1;
            }
            if (this.mLocationManager != null && this.mLocationManager.isProviderEnabled("network")) {
                this.mLocationManager.requestLocationUpdates("network", 10000L, 100.0f, this.uF);
            } else {
                this.errorCode = 2;
            }
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), ut);
        } catch (Exception e) {
            gN();
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
        if (this.uE == null) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < this.uE.size()) {
                d dVar = this.uE.get(i3).get();
                if (dVar != null) {
                    try {
                        dVar.b(i, str, address);
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                    }
                }
                i2 = i3 + 1;
            } else {
                this.uE.clear();
                return;
            }
        }
    }
}
