package com.alipay.security.mobile.module.deviceinfo;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Base64;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f2075a = 300000;

    /* renamed from: b  reason: collision with root package name */
    public Context f2076b;

    /* renamed from: c  reason: collision with root package name */
    public String f2077c;

    /* renamed from: d  reason: collision with root package name */
    public String f2078d;

    /* renamed from: e  reason: collision with root package name */
    public String f2079e;

    /* renamed from: f  reason: collision with root package name */
    public String f2080f;

    /* renamed from: g  reason: collision with root package name */
    public String f2081g;

    /* renamed from: h  reason: collision with root package name */
    public String f2082h;
    public String i;
    public String j;
    public String k;
    public String l;
    public volatile int m = 0;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x01bc: INVOKE  (r0v62 boolean A[REMOVE]) = (r0v61 android.net.NetworkInfo) type: VIRTUAL call: android.net.NetworkInfo.isConnected():boolean)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x011c: INVOKE  (r9v14 double A[REMOVE]) = (r0v43 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x012f: INVOKE  (r9v15 double A[REMOVE]) = (r0v43 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0182: ARITH  (r8v2 double A[REMOVE]) = (r2v6 int) / (14400.0d double))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0193: ARITH  (r8v4 double A[REMOVE]) = (r0v41 int) / (14400.0d double))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0201: INVOKE  (r0v56 int A[REMOVE]) = (r0v55 android.net.wifi.WifiInfo) type: VIRTUAL call: android.net.wifi.WifiInfo.getRssi():int)] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ab A[Catch: Exception -> 0x0210, TryCatch #0 {Exception -> 0x0210, blocks: (B:85:0x01a3, B:87:0x01ab, B:88:0x01ca, B:90:0x01d2, B:92:0x01e0), top: B:102:0x01a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d2 A[Catch: Exception -> 0x0210, TryCatch #0 {Exception -> 0x0210, blocks: (B:85:0x01a3, B:87:0x01ab, B:88:0x01ca, B:90:0x01d2, B:92:0x01e0), top: B:102:0x01a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x021d A[Catch: all -> 0x0227, TRY_LEAVE, TryCatch #9 {all -> 0x0227, blocks: (B:96:0x0214, B:99:0x021d), top: B:120:0x0214 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(Context context) {
        Exception exc;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        CdmaCellLocation cdmaCellLocation;
        CdmaCellLocation cdmaCellLocation2;
        TelephonyManager telephonyManager;
        e eVar = new e();
        eVar.f2076b = context;
        boolean z = false;
        if (!b.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            try {
                TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
                String str9 = "";
                if ((telephonyManager2.getPhoneType() == 2 ? (char) 2 : (char) 1) == 2) {
                    try {
                        cdmaCellLocation = (CdmaCellLocation) telephonyManager2.getCellLocation();
                    } catch (Exception e2) {
                        e = e2;
                        str8 = "";
                        str4 = str8;
                        str3 = str4;
                    }
                    if (cdmaCellLocation != null) {
                        str4 = String.valueOf(cdmaCellLocation.getNetworkId());
                        try {
                            String networkOperator = telephonyManager2.getNetworkOperator();
                            str8 = (networkOperator == null || networkOperator.equals("")) ? "" : networkOperator.substring(0, 3);
                            try {
                                str3 = String.valueOf(cdmaCellLocation.getSystemId());
                                try {
                                    str9 = String.valueOf(cdmaCellLocation.getBaseStationId());
                                } catch (Exception e3) {
                                    e = e3;
                                    e.fillInStackTrace();
                                    str = str9;
                                    str9 = str8;
                                    eVar.g(str9);
                                    eVar.h(str3);
                                    eVar.i(str);
                                    eVar.j(str4);
                                    if (!b.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                                    }
                                    if (b.b(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                                    }
                                    if (b.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                                    }
                                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                    if (telephonyManager == null) {
                                    }
                                    return eVar;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                str3 = "";
                            }
                        } catch (Exception e5) {
                            e = e5;
                            str8 = "";
                            str3 = str8;
                        }
                        str = str9;
                        str9 = str8;
                    } else {
                        str = "";
                        str4 = str;
                        str3 = str4;
                    }
                } else {
                    try {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager2.getCellLocation();
                        if (gsmCellLocation != null) {
                            String networkOperator2 = telephonyManager2.getNetworkOperator();
                            if (networkOperator2 == null || networkOperator2.equals("")) {
                                str6 = "";
                                str2 = str6;
                            } else {
                                str2 = telephonyManager2.getNetworkOperator().substring(0, 3);
                                try {
                                    str6 = telephonyManager2.getNetworkOperator().substring(3, 5);
                                } catch (Exception e6) {
                                    exc = e6;
                                    str = "";
                                    str3 = str;
                                    exc.fillInStackTrace();
                                    String str10 = str2;
                                    str4 = "";
                                    str9 = str10;
                                    eVar.g(str9);
                                    eVar.h(str3);
                                    eVar.i(str);
                                    eVar.j(str4);
                                    if (!b.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                                    }
                                    if (b.b(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                                    }
                                    if (b.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                                    }
                                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                    if (telephonyManager == null) {
                                    }
                                    return eVar;
                                }
                            }
                            try {
                                str7 = String.valueOf(gsmCellLocation.getCid());
                            } catch (Exception e7) {
                                exc = e7;
                                str3 = str6;
                                str = "";
                            }
                            try {
                                str5 = String.valueOf(gsmCellLocation.getLac());
                                str9 = str2;
                            } catch (Exception e8) {
                                exc = e8;
                                str = str7;
                                str3 = str6;
                                exc.fillInStackTrace();
                                String str102 = str2;
                                str4 = "";
                                str9 = str102;
                                eVar.g(str9);
                                eVar.h(str3);
                                eVar.i(str);
                                eVar.j(str4);
                                if (!b.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                                }
                                if (b.b(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                                }
                                if (b.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                                }
                                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                if (telephonyManager == null) {
                                }
                                return eVar;
                            }
                        } else {
                            str5 = "";
                            str6 = str5;
                            str7 = str6;
                        }
                        str4 = str5;
                        str = str7;
                        str3 = str6;
                    } catch (Exception e9) {
                        exc = e9;
                        str = "";
                        str2 = str;
                        str3 = str2;
                    }
                }
                eVar.g(str9);
                eVar.h(str3);
                eVar.i(str);
                eVar.j(str4);
            } catch (Throwable unused) {
            }
        }
        if (!b.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("network")) {
                    com.alipay.security.mobile.module.deviceinfo.listener.a aVar = new com.alipay.security.mobile.module.deviceinfo.listener.a();
                    locationManager.requestLocationUpdates("network", 300000L, 0.0f, aVar, Looper.getMainLooper());
                    locationManager.removeUpdates(aVar);
                    Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                    if (lastKnownLocation != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(lastKnownLocation.getLatitude());
                        eVar.b(sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(lastKnownLocation.getLongitude());
                        eVar.a(sb2.toString());
                        z = true;
                    }
                }
                TelephonyManager telephonyManager3 = (TelephonyManager) context.getSystemService("phone");
                if (!z && telephonyManager3.getPhoneType() == 2 && (cdmaCellLocation2 = (CdmaCellLocation) telephonyManager3.getCellLocation()) != null && com.alipay.security.mobile.module.a.a.a(eVar.g()) && com.alipay.security.mobile.module.a.a.a(eVar.f())) {
                    int baseStationLatitude = cdmaCellLocation2.getBaseStationLatitude();
                    int baseStationLongitude = cdmaCellLocation2.getBaseStationLongitude();
                    if (Integer.MAX_VALUE != baseStationLatitude && Integer.MAX_VALUE != baseStationLongitude) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(baseStationLatitude / 14400.0d);
                        eVar.b(sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(baseStationLongitude / 14400.0d);
                        eVar.a(sb4.toString());
                    }
                }
            } catch (Exception e10) {
                e10.fillInStackTrace();
            }
        }
        try {
            if (b.b(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(networkInfo.isConnected());
                eVar.e(sb5.toString());
            }
            if (b.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    eVar.c(connectionInfo.getBSSID());
                    eVar.d(Base64.encodeToString(connectionInfo.getSSID().getBytes(), 8));
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(connectionInfo.getRssi());
                    eVar.f(sb6.toString());
                }
            }
        } catch (Exception e11) {
            e11.fillInStackTrace();
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                telephonyManager.listen(new f(eVar, telephonyManager), 256);
            }
        } catch (Throwable unused2) {
        }
        return eVar;
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(String str) {
        this.f2077c = str;
    }

    public boolean a() {
        return this.m != 0;
    }

    public double b() {
        return this.m;
    }

    public String b(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || !wifiManager.isWifiEnabled()) {
                return "";
            }
            int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
        } catch (Exception unused) {
            return "";
        }
    }

    public void b(String str) {
        this.f2078d = str;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0048: IGET  (r2v4 int A[REMOVE]) = (r2v3 android.net.wifi.ScanResult) android.net.wifi.ScanResult.level int)] */
    public List<Map<String, String>> c() {
        WifiManager wifiManager;
        List<ScanResult> scanResults;
        ArrayList arrayList = new ArrayList();
        Context context = this.f2076b;
        if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || (scanResults = wifiManager.getScanResults()) == null) {
            return arrayList;
        }
        for (ScanResult scanResult : scanResults) {
            HashMap hashMap = new HashMap();
            String str = scanResult.BSSID;
            if (str == null) {
                str = "";
            }
            hashMap.put("wifiMac", str);
            hashMap.put("ssid", scanResult.SSID);
            StringBuilder sb = new StringBuilder();
            sb.append(scanResult.level);
            hashMap.put("rssi", sb.toString());
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public void c(String str) {
        this.f2079e = str;
    }

    public void d(String str) {
        this.f2080f = str;
    }

    public boolean d() {
        LocationManager locationManager;
        Context context = this.f2076b;
        if (context == null || (locationManager = (LocationManager) context.getSystemService("location")) == null) {
            return false;
        }
        return locationManager.isProviderEnabled("gps");
    }

    public void e(String str) {
        this.f2081g = str;
    }

    public boolean e() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        WifiManager wifiManager2;
        List<WifiConfiguration> configuredNetworks;
        Context context = this.f2076b;
        if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return false;
        }
        Context context2 = this.f2076b;
        String ssid = connectionInfo.getSSID();
        WifiConfiguration wifiConfiguration = null;
        if (context2 != null && ssid != null && (wifiManager2 = (WifiManager) context2.getSystemService("wifi")) != null && (configuredNetworks = wifiManager2.getConfiguredNetworks()) != null) {
            Iterator<WifiConfiguration> it = configuredNetworks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WifiConfiguration next = it.next();
                if (next.SSID.equals(ssid)) {
                    wifiConfiguration = next;
                    break;
                }
            }
        }
        if (wifiConfiguration == null) {
            return false;
        }
        char c2 = 3;
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            c2 = 2;
        } else if (!wifiConfiguration.allowedKeyManagement.get(2) && !wifiConfiguration.allowedKeyManagement.get(3)) {
            c2 = wifiConfiguration.wepKeys[0] != null ? (char) 1 : (char) 0;
        }
        return c2 != 0;
    }

    public String f() {
        return this.f2077c;
    }

    public void f(String str) {
        this.f2082h = str;
    }

    public String g() {
        return this.f2078d;
    }

    public void g(String str) {
        this.i = str;
    }

    public String h() {
        return this.f2079e;
    }

    public void h(String str) {
        this.j = str;
    }

    public String i() {
        return this.f2080f;
    }

    public void i(String str) {
        this.k = str;
    }

    public String j() {
        return this.f2081g;
    }

    public void j(String str) {
        this.l = str;
    }

    public String k() {
        return this.f2082h;
    }

    public String l() {
        return this.i;
    }

    public String m() {
        return this.j;
    }

    public String n() {
        return this.k;
    }

    public String o() {
        return this.l;
    }
}
