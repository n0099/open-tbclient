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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final long f2110a = 300000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f2111b;

    /* renamed from: c  reason: collision with root package name */
    public String f2112c;

    /* renamed from: d  reason: collision with root package name */
    public String f2113d;

    /* renamed from: e  reason: collision with root package name */
    public String f2114e;

    /* renamed from: f  reason: collision with root package name */
    public String f2115f;

    /* renamed from: g  reason: collision with root package name */
    public String f2116g;

    /* renamed from: h  reason: collision with root package name */
    public String f2117h;

    /* renamed from: i  reason: collision with root package name */
    public String f2118i;
    public String j;
    public String k;
    public String l;
    public volatile int m;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 0;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x01c0: INVOKE  (r0v64 boolean A[REMOVE]) = (r0v63 android.net.NetworkInfo) type: VIRTUAL call: android.net.NetworkInfo.isConnected():boolean)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0120: INVOKE  (r9v14 double A[REMOVE]) = (r0v45 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0133: INVOKE  (r9v15 double A[REMOVE]) = (r0v45 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0186: ARITH  (r8v2 double A[REMOVE]) = (r2v6 int) / (14400.0d double))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0197: ARITH  (r8v4 double A[REMOVE]) = (r0v43 int) / (14400.0d double))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0205: INVOKE  (r0v58 int A[REMOVE]) = (r0v57 android.net.wifi.WifiInfo) type: VIRTUAL call: android.net.wifi.WifiInfo.getRssi():int)] */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0221 A[Catch: all -> 0x022b, TRY_LEAVE, TryCatch #5 {all -> 0x022b, blocks: (B:98:0x0218, B:101:0x0221), top: B:118:0x0218 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01af A[Catch: Exception -> 0x0214, TryCatch #6 {Exception -> 0x0214, blocks: (B:87:0x01a7, B:89:0x01af, B:90:0x01ce, B:92:0x01d6, B:94:0x01e4), top: B:120:0x01a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d6 A[Catch: Exception -> 0x0214, TryCatch #6 {Exception -> 0x0214, blocks: (B:87:0x01a7, B:89:0x01af, B:90:0x01ce, B:92:0x01d6, B:94:0x01e4), top: B:120:0x01a7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        String str4;
        CdmaCellLocation cdmaCellLocation;
        Exception exc;
        String str5;
        String str6;
        String str7;
        String str8;
        CdmaCellLocation cdmaCellLocation2;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            e eVar = new e();
            eVar.f2111b = context;
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
                            str = "";
                            str2 = str;
                            str3 = str2;
                        }
                        if (cdmaCellLocation != null) {
                            str2 = String.valueOf(cdmaCellLocation.getNetworkId());
                            try {
                                String networkOperator = telephonyManager2.getNetworkOperator();
                                str = (networkOperator == null || networkOperator.equals("")) ? "" : networkOperator.substring(0, 3);
                                try {
                                    str3 = String.valueOf(cdmaCellLocation.getSystemId());
                                } catch (Exception e3) {
                                    e = e3;
                                    str3 = "";
                                }
                            } catch (Exception e4) {
                                e = e4;
                                str = "";
                                str3 = str;
                            }
                            try {
                                str9 = String.valueOf(cdmaCellLocation.getBaseStationId());
                            } catch (Exception e5) {
                                e = e5;
                                e.fillInStackTrace();
                                str4 = str9;
                                str9 = str;
                                eVar.g(str9);
                                eVar.h(str3);
                                eVar.i(str4);
                                eVar.j(str2);
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
                            str4 = str9;
                            str9 = str;
                        } else {
                            str4 = "";
                            str2 = str4;
                            str3 = str2;
                        }
                    } else {
                        try {
                            GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager2.getCellLocation();
                            if (gsmCellLocation != null) {
                                String networkOperator2 = telephonyManager2.getNetworkOperator();
                                if (networkOperator2 == null || networkOperator2.equals("")) {
                                    str7 = "";
                                    str5 = str7;
                                } else {
                                    str5 = telephonyManager2.getNetworkOperator().substring(0, 3);
                                    try {
                                        str7 = telephonyManager2.getNetworkOperator().substring(3, 5);
                                    } catch (Exception e6) {
                                        exc = e6;
                                        str4 = "";
                                        str3 = str4;
                                        exc.fillInStackTrace();
                                        String str10 = str5;
                                        str2 = "";
                                        str9 = str10;
                                        eVar.g(str9);
                                        eVar.h(str3);
                                        eVar.i(str4);
                                        eVar.j(str2);
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
                                    str8 = String.valueOf(gsmCellLocation.getCid());
                                    try {
                                        str6 = String.valueOf(gsmCellLocation.getLac());
                                        str9 = str5;
                                    } catch (Exception e7) {
                                        exc = e7;
                                        str4 = str8;
                                        str3 = str7;
                                        exc.fillInStackTrace();
                                        String str102 = str5;
                                        str2 = "";
                                        str9 = str102;
                                        eVar.g(str9);
                                        eVar.h(str3);
                                        eVar.i(str4);
                                        eVar.j(str2);
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
                                } catch (Exception e8) {
                                    exc = e8;
                                    str3 = str7;
                                    str4 = "";
                                }
                            } else {
                                str6 = "";
                                str7 = str6;
                                str8 = str7;
                            }
                            str2 = str6;
                            str4 = str8;
                            str3 = str7;
                        } catch (Exception e9) {
                            exc = e9;
                            str4 = "";
                            str5 = str4;
                            str3 = str5;
                        }
                    }
                    eVar.g(str9);
                    eVar.h(str3);
                    eVar.i(str4);
                    eVar.j(str2);
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
        return (e) invokeL.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.m = i2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f2112c = str;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m != 0 : invokeV.booleanValue;
    }

    public double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : invokeV.doubleValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f2113d = str;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x004c: IGET  (r2v4 int A[REMOVE]) = (r2v3 android.net.wifi.ScanResult) android.net.wifi.ScanResult.level int)] */
    public List<Map<String, String>> c() {
        InterceptResult invokeV;
        WifiManager wifiManager;
        List<ScanResult> scanResults;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Context context = this.f2111b;
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
        return (List) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f2114e = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f2115f = str;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        LocationManager locationManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = this.f2111b;
            if (context == null || (locationManager = (LocationManager) context.getSystemService("location")) == null) {
                return false;
            }
            return locationManager.isProviderEnabled("gps");
        }
        return invokeV.booleanValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f2116g = str;
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        WifiManager wifiManager2;
        List<WifiConfiguration> configuredNetworks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Context context = this.f2111b;
            if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return false;
            }
            Context context2 = this.f2111b;
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
        return invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f2112c : (String) invokeV.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f2117h = str;
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f2113d : (String) invokeV.objValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f2118i = str;
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f2114e : (String) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.j = str;
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f2115f : (String) invokeV.objValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.k = str;
        }
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f2116g : (String) invokeV.objValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.l = str;
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f2117h : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f2118i : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.l : (String) invokeV.objValue;
    }
}
