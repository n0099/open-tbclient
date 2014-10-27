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
    private static long jK = 10000;
    private static a jL = null;
    private static long jM = 300000;
    private LocationManager jS;
    private boolean jN = true;
    private LocationClient jO = null;
    private BDLocationListener jP = null;
    private String jQ = "baidu";
    private boolean jR = true;
    private int errorCode = 0;
    private Address jT = null;
    private f jU = null;
    public long jV = 0;
    private ArrayList<SoftReference<d>> jW = null;
    private Context mContext = null;
    private Handler handler = null;
    private final LocationListener jX = new b(this);

    private a() {
    }

    public static synchronized a dE() {
        a aVar;
        synchronized (a.class) {
            if (jL == null) {
                jL = new a();
            }
            aVar = jL;
        }
        return aVar;
    }

    public void initial(Context context, String str) {
        initial(context, str, true);
    }

    public void initial(Context context, String str, boolean z) {
        if (context == null) {
            throw new InvalidParameterException("context is null");
        }
        this.jW = new ArrayList<>();
        this.mContext = context;
        this.jQ = str;
        this.jR = z;
        dF();
        dG();
    }

    public void setBaiduOn(boolean z) {
        this.jN = z;
    }

    private void dF() {
        this.handler = new Handler(new c(this));
    }

    private void dG() {
        try {
            this.jS = (LocationManager) this.mContext.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            if (this.jN) {
                this.jP = new e(this, null);
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName(this.jQ);
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(500);
                locationClientOption.disableCache(this.jR);
                this.jO = new LocationClient(this.mContext);
                this.jO.registerLocationListener(this.jP);
                this.jO.setLocOption(locationClientOption);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public Address getAddress(boolean z) {
        if (System.currentTimeMillis() - this.jV > jM) {
            this.jT = null;
        }
        if (this.jT != null && !z) {
            return this.jT;
        }
        this.jT = null;
        dI();
        return null;
    }

    public Address a(boolean z, d dVar) {
        boolean z2;
        if (System.currentTimeMillis() - this.jV > jM) {
            this.jT = null;
        }
        if (this.jT != null && !z) {
            return this.jT;
        }
        if (dVar != null) {
            int i = 0;
            while (true) {
                if (i < this.jW.size()) {
                    d dVar2 = this.jW.get(i).get();
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
                if (this.jW.size() >= 100) {
                    this.jW.remove(0);
                }
                this.jW.add(new SoftReference<>(dVar));
            }
            dI();
        }
        return null;
    }

    public void a(d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jW.size()) {
                SoftReference<d> softReference = this.jW.get(i2);
                d dVar2 = softReference.get();
                if (dVar2 == null || !dVar2.equals(dVar)) {
                    i = i2 + 1;
                } else {
                    this.jW.remove(softReference);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void dH() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.jS != null) {
            try {
                this.jS.removeUpdates(this.jX);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.jO != null && this.jO.isStarted()) {
            this.jO.stop();
        }
        if (this.jU != null) {
            this.jU.cancel();
            this.jU = null;
        }
    }

    private void dI() {
        try {
            this.jT = null;
            if (this.handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            if (this.jS != null) {
                this.jS.removeUpdates(this.jX);
            }
            if (this.jN) {
                if (!this.jO.isStarted()) {
                    this.jO.start();
                }
                this.jO.requestLocation();
            }
            this.errorCode = 4;
            if (this.jS != null && !this.jS.isProviderEnabled("gps") && !this.jS.isProviderEnabled("network")) {
                this.errorCode = 3;
                if (!this.jN) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(0), 100L);
                    return;
                }
            }
            if (this.jS != null && this.jS.isProviderEnabled("gps")) {
                this.jS.requestLocationUpdates("gps", 10000L, 100.0f, this.jX);
            } else {
                this.errorCode = 1;
            }
            if (this.jS != null && this.jS.isProviderEnabled("network")) {
                this.jS.requestLocationUpdates("network", 10000L, 100.0f, this.jX);
            } else {
                this.errorCode = 2;
            }
            this.handler.sendMessageDelayed(this.handler.obtainMessage(0), jK);
        } catch (Exception e) {
            dH();
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
        if (this.jW == null) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < this.jW.size()) {
                d dVar = this.jW.get(i3).get();
                if (dVar != null) {
                    try {
                        dVar.OnLocationGeted(i, str, address);
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                    }
                }
                i2 = i3 + 1;
            } else {
                this.jW.clear();
                return;
            }
        }
    }
}
