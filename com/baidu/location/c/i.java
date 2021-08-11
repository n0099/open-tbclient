package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f40993a;

    /* renamed from: b  reason: collision with root package name */
    public static i f40994b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public WifiManager f40995c;

    /* renamed from: d  reason: collision with root package name */
    public a f40996d;

    /* renamed from: e  reason: collision with root package name */
    public h f40997e;

    /* renamed from: f  reason: collision with root package name */
    public long f40998f;

    /* renamed from: g  reason: collision with root package name */
    public long f40999g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41000h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f41001i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41002j;
    public long k;
    public long l;

    /* renamed from: com.baidu.location.c.i$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f41003a;

        /* renamed from: b  reason: collision with root package name */
        public long f41004b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41005c;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41003a = iVar;
            this.f41004b = 0L;
            this.f41005c = false;
        }

        public /* synthetic */ a(i iVar, AnonymousClass1 anonymousClass1) {
            this(iVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                i.f40993a = System.currentTimeMillis() / 1000;
                this.f41003a.f41001i.post(new j(this, intent.getBooleanExtra("resultsUpdated", true)));
            } else if (action.equals(McastConfig.ACTION_NETWORK_STATE_CHANGED) && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.f41004b >= 5000) {
                this.f41004b = System.currentTimeMillis();
                if (this.f41005c) {
                    return;
                }
                this.f41005c = true;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037753322, "Lcom/baidu/location/c/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037753322, "Lcom/baidu/location/c/i;");
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40995c = null;
        this.f40996d = null;
        this.f40997e = null;
        this.f40998f = 0L;
        this.f40999g = 0L;
        this.f41000h = false;
        this.f41001i = new Handler();
        this.f41002j = false;
        this.k = 0L;
        this.l = 0L;
    }

    public static synchronized i a() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (i.class) {
                if (f40994b == null) {
                    f40994b = new i();
                }
                iVar = f40994b;
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }

    private String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf((int) (j2 & 255)));
            stringBuffer.append('.');
            stringBuffer.append(String.valueOf((int) ((j2 >> 8) & 255)));
            stringBuffer.append('.');
            stringBuffer.append(String.valueOf((int) ((j2 >> 16) & 255)));
            stringBuffer.append('.');
            stringBuffer.append(String.valueOf((int) ((j2 >> 24) & 255)));
            return stringBuffer.toString();
        }
        return (String) invokeJ.objValue;
    }

    public static boolean a(h hVar, h hVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hVar, hVar2)) == null) {
            boolean a2 = a(hVar, hVar2, 0.7f);
            long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.b.a.f40772c;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 30000 || !a2 || hVar2.g() - hVar.g() <= 30) {
                return a2;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(h hVar, h hVar2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{hVar, hVar2, Float.valueOf(f2)})) == null) {
            if (hVar != null && hVar2 != null) {
                List<ScanResult> list = hVar.f40988a;
                List<ScanResult> list2 = hVar2.f40988a;
                if (list == list2) {
                    return true;
                }
                if (list != null && list2 != null) {
                    int size = list.size();
                    int size2 = list2.size();
                    if (size == 0 && size2 == 0) {
                        return true;
                    }
                    if (size != 0 && size2 != 0) {
                        int i2 = 0;
                        for (int i3 = 0; i3 < size; i3++) {
                            String str = list.get(i3) != null ? list.get(i3).BSSID : null;
                            if (str != null) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= size2) {
                                        break;
                                    }
                                    String str2 = list2.get(i4) != null ? list2.get(i4).BSSID : null;
                                    if (str2 != null && str.equals(str2)) {
                                        i2++;
                                        break;
                                    }
                                    i4++;
                                }
                            }
                        }
                        if (i2 >= size * f2) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.getType() == 1;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (wifiManager = this.f40995c) == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                h hVar = new h(scanResults, System.currentTimeMillis());
                h hVar2 = this.f40997e;
                if (hVar2 == null || !hVar.a(hVar2)) {
                    this.f40997e = hVar;
                }
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = 0L;
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f41000h) {
                    return;
                }
                if (com.baidu.location.f.isServing) {
                    this.f40995c = (WifiManager) com.baidu.location.f.getServiceContext().getApplicationContext().getSystemService("wifi");
                    this.f40996d = new a(this, null);
                    try {
                        com.baidu.location.f.getServiceContext().registerReceiver(this.f40996d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                    } catch (Exception unused) {
                    }
                    this.f41000h = true;
                }
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f41000h) {
                    try {
                        com.baidu.location.f.getServiceContext().unregisterReceiver(this.f40996d);
                        f40993a = 0L;
                    } catch (Exception unused) {
                    }
                    this.f40996d = null;
                    this.f40995c = null;
                    this.f41000h = false;
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f40999g;
            if (currentTimeMillis - j2 <= 0 || currentTimeMillis - j2 > 5000) {
                this.f40999g = currentTimeMillis;
                b();
                return f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f40995c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f40998f;
            if (currentTimeMillis - j2 > 0) {
                long j3 = this.k;
                if (currentTimeMillis - j2 <= j3 + 5000 || currentTimeMillis - (f40993a * 1000) <= j3 + 5000) {
                    return false;
                }
                if (i() && currentTimeMillis - this.f40998f <= this.k + 10000) {
                    return false;
                }
            }
            return h();
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            WifiManager wifiManager = this.f40995c;
            if (wifiManager != null) {
                try {
                    if (!wifiManager.isWifiEnabled()) {
                        if (Build.VERSION.SDK_INT <= 17) {
                            return "";
                        }
                        if (!this.f40995c.isScanAlwaysAvailable()) {
                            return "";
                        }
                    }
                    return "&wifio=1";
                } catch (Exception | NoSuchMethodError unused) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.l;
            if (currentTimeMillis < 0 || currentTimeMillis > 2000) {
                this.l = System.currentTimeMillis();
                try {
                    if (!this.f40995c.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.f40995c.isScanAlwaysAvailable())) {
                        return false;
                    }
                    this.f40995c.startScan();
                    this.f40998f = System.currentTimeMillis();
                    return true;
                } catch (Exception | NoSuchMethodError unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                if ((this.f40995c.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.f40995c.isScanAlwaysAvailable())) && !i()) {
                    return new h(this.f40995c.getScanResults(), 0L).e();
                }
                return false;
            } catch (Exception | NoSuchMethodError unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public WifiInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WifiManager wifiManager = this.f40995c;
            if (wifiManager == null) {
                return null;
            }
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null && connectionInfo.getBSSID() != null && connectionInfo.getRssi() > -100) {
                    String bssid = connectionInfo.getBSSID();
                    if (bssid != null) {
                        String replace = bssid.replace(":", "");
                        if (!"000000000000".equals(replace)) {
                            if ("".equals(replace)) {
                            }
                        }
                        return null;
                    }
                    return connectionInfo;
                }
            } catch (Error | Exception unused) {
            }
            return null;
        }
        return (WifiInfo) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            WifiInfo k = a().k();
            if (k != null && k.getBSSID() != null) {
                String replace = k.getBSSID().replace(":", "");
                int rssi = k.getRssi();
                String m = a().m();
                if (rssi < 0) {
                    rssi = -rssi;
                }
                if (replace != null && rssi < 100) {
                    stringBuffer.append("&wf=");
                    stringBuffer.append(replace);
                    stringBuffer.append(";");
                    stringBuffer.append("" + rssi + ";");
                    String ssid = k.getSSID();
                    if (ssid != null && (ssid.contains("&") || ssid.contains(";"))) {
                        ssid = ssid.replace("&", "_");
                    }
                    stringBuffer.append(ssid);
                    stringBuffer.append("&wf_n=1");
                    if (m != null) {
                        stringBuffer.append("&wf_gw=");
                        stringBuffer.append(m);
                    }
                    return stringBuffer.toString();
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        DhcpInfo dhcpInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            WifiManager wifiManager = this.f40995c;
            if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
                return null;
            }
            return a(dhcpInfo.gateway);
        }
        return (String) invokeV.objValue;
    }

    public h n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            h hVar = this.f40997e;
            return (hVar == null || !hVar.j()) ? p() : this.f40997e;
        }
        return (h) invokeV.objValue;
    }

    public h o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            h hVar = this.f40997e;
            return (hVar == null || !hVar.k()) ? p() : this.f40997e;
        }
        return (h) invokeV.objValue;
    }

    public h p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            WifiManager wifiManager = this.f40995c;
            if (wifiManager != null) {
                try {
                    return new h(wifiManager.getScanResults(), this.f40998f);
                } catch (Exception unused) {
                }
            }
            return new h(null, 0L);
        }
        return (h) invokeV.objValue;
    }
}
