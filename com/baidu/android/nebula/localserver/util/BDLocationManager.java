package com.baidu.android.nebula.localserver.util;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.util.NoProGuard;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class BDLocationManager {
    private static BDLocationManager b;
    private static int g = 2000;
    private Context a;
    private b c;
    private String f;
    private LocationClient d = null;
    private boolean h = false;
    private boolean i = true;
    private long j = 0;
    private ArrayList e = new ArrayList();

    /* loaded from: classes.dex */
    public class BaiduLocationListener implements NoProGuard, BDLocationListener {
        private boolean canRelocation = true;

        public BaiduLocationListener() {
        }

        private void reLocationRequest() {
            if (this.canRelocation) {
                this.canRelocation = false;
                BDLocationManager.this.a(1000L);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            BDLocationManager.this.h = false;
            if (bDLocation == null) {
                Log.d("BDLocationManager", "BaiduLocationListener return null");
                return;
            }
            int locType = bDLocation.getLocType();
            if (locType == 61 || locType == 161 || locType == 65) {
                b bVar = BDLocationManager.this.c;
                if (bVar == null) {
                    bVar = new b();
                }
                bVar.a = System.currentTimeMillis();
                bVar.b = bDLocation.getLongitude();
                bVar.c = bDLocation.getLatitude();
                bVar.d = 1000.0d;
                bVar.e = bDLocation.getAddrStr();
                if (bVar.b < 1.0E-4d && bVar.c < 1.0E-4d) {
                    BDLocationManager.this.c = null;
                    reLocationRequest();
                    return;
                }
                BDLocationManager.this.c = bVar;
                this.canRelocation = true;
            } else if (locType == 63) {
                reLocationRequest();
            } else if (locType == 167) {
                Log.e("BDLocationManager", "server location error. error code:" + locType);
            } else {
                Log.e("BDLocationManager", "location fail. error code: " + locType);
            }
            synchronized (BDLocationManager.this.e) {
                Iterator it = BDLocationManager.this.e.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(BDLocationManager.this.c);
                }
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    private BDLocationManager(Context context) {
        this.f = null;
        this.a = context.getApplicationContext();
        this.f = com.baidu.android.pushservice.util.d.a(context, context.getPackageName(), "LocServiceName");
        d();
    }

    public static synchronized void a() {
        synchronized (BDLocationManager.class) {
            if (b != null) {
                b.d.stop();
                b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (!this.h && this.d != null) {
            if (this.c != null && System.currentTimeMillis() - this.c.a <= g) {
                return;
            }
            Thread thread = new Thread(new a(this, j));
            thread.setName("requestLocation");
            thread.start();
        }
        if (!this.h || System.currentTimeMillis() - this.j <= 32000) {
            return;
        }
        this.h = false;
    }

    public static boolean a(Context context) {
        try {
            return Class.forName("com.baidu.location.LocationClient") != null;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static synchronized BDLocationManager b(Context context) {
        BDLocationManager bDLocationManager;
        synchronized (BDLocationManager.class) {
            if (b == null) {
                b = new BDLocationManager(context.getApplicationContext());
            }
            bDLocationManager = b;
        }
        return bDLocationManager;
    }

    private void d() {
        this.d = new LocationClient(this.a);
        this.d.registerLocationListener(new BaiduLocationListener());
        this.d.setLocOption(e());
        this.d.start();
    }

    private LocationClientOption e() {
        LocationClientOption locationClientOption = new LocationClientOption();
        locationClientOption.setOpenGps(false);
        locationClientOption.setAddrType("detail");
        locationClientOption.setCoorType("bd09");
        locationClientOption.setProdName("bd_service_android");
        if (this.f != null) {
            locationClientOption.setServiceName(this.f);
        }
        return locationClientOption;
    }

    public void a(c cVar) {
        synchronized (this.e) {
            if (!this.e.contains(cVar)) {
                this.e.add(cVar);
            }
        }
    }

    public void a(boolean z) {
        LocationClientOption e = e();
        e.setOpenGps(z);
        this.d.setLocOption(e);
    }

    public b b() {
        b bVar = this.c;
        if (bVar == null || System.currentTimeMillis() - bVar.a <= g) {
            return bVar;
        }
        return null;
    }

    public void b(c cVar) {
        synchronized (this.e) {
            this.e.remove(cVar);
        }
    }

    public void c() {
        if (!this.i) {
            a(0L);
            return;
        }
        a(1000L);
        this.i = false;
    }
}
