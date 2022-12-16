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
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.searchbox.anr.impl.ANRMonitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public static k b;
    public transient /* synthetic */ FieldHolder $fh;
    public WifiManager c;
    public a d;
    public j e;
    public long f;
    public long g;
    public boolean h;
    public ConnectivityManager i;
    public Handler j;
    public boolean k;
    public long l;
    public long m;

    /* renamed from: com.baidu.location.c.k$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public long b;
        public boolean c;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
            this.b = 0L;
            this.c = false;
        }

        public /* synthetic */ a(k kVar, AnonymousClass1 anonymousClass1) {
            this(kVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                k.a = System.currentTimeMillis() / 1000;
                this.a.j.post(new l(this, intent.getBooleanExtra("resultsUpdated", true)));
            } else if (action.equals(McastConfig.ACTION_NETWORK_STATE_CHANGED) && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.b >= 5000) {
                this.b = System.currentTimeMillis();
                if (this.c) {
                    return;
                }
                this.c = true;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037753384, "Lcom/baidu/location/c/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037753384, "Lcom/baidu/location/c/k;");
        }
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0L;
        this.g = 0L;
        this.h = false;
        this.i = null;
        this.j = new Handler();
        this.k = false;
        this.l = 0L;
        this.m = 0L;
    }

    public static synchronized k a() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k();
                }
                kVar = b;
            }
            return kVar;
        }
        return (k) invokeV.objValue;
    }

    private String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf((int) (j & 255)));
            stringBuffer.append(IStringUtil.EXTENSION_SEPARATOR);
            stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
            stringBuffer.append(IStringUtil.EXTENSION_SEPARATOR);
            stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
            stringBuffer.append(IStringUtil.EXTENSION_SEPARATOR);
            stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
            return stringBuffer.toString();
        }
        return (String) invokeJ.objValue;
    }

    public static boolean a(j jVar, j jVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jVar, jVar2)) == null) {
            boolean a2 = a(jVar, jVar2, com.baidu.location.e.k.az);
            long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.b.b.c;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 30000 || !a2 || jVar2.g() - jVar.g() <= 30) {
                return a2;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(j jVar, j jVar2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{jVar, jVar2, Float.valueOf(f)})) == null) {
            if (jVar != null && jVar2 != null) {
                List<ScanResult> list = jVar.a;
                List<ScanResult> list2 = jVar2.a;
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
                        int i = 0;
                        for (int i2 = 0; i2 < size; i2++) {
                            String str = list.get(i2) != null ? list.get(i2).BSSID : null;
                            if (str != null) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= size2) {
                                        break;
                                    }
                                    String str2 = list2.get(i3) != null ? list2.get(i3).BSSID : null;
                                    if (str2 != null && str.equals(str2)) {
                                        i++;
                                        break;
                                    }
                                    i3++;
                                }
                            }
                        }
                        if (i >= size * f) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (wifiManager = this.c) == null) {
            return;
        }
        try {
            j a2 = a(wifiManager, System.currentTimeMillis());
            if (a2.a != null) {
                j jVar = this.e;
                if (jVar == null || !a2.a(jVar)) {
                    this.e = a2;
                }
            }
        } catch (Exception unused) {
        }
    }

    public j a(WifiManager wifiManager, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, wifiManager, j)) == null) {
            j jVar = new j(null, 0L);
            return (wifiManager == null || com.baidu.location.e.k.f == 4) ? jVar : new j(wifiManager.getScanResults(), j);
        }
        return (j) invokeLJ.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l = 0L;
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.h) {
                    return;
                }
                if (com.baidu.location.f.isServing) {
                    this.c = (WifiManager) com.baidu.location.f.getServiceContext().getApplicationContext().getSystemService("wifi");
                    this.d = new a(this, null);
                    try {
                        com.baidu.location.f.getServiceContext().registerReceiver(this.d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                    } catch (Exception unused) {
                    }
                    this.h = true;
                }
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.h) {
                    try {
                        com.baidu.location.f.getServiceContext().unregisterReceiver(this.d);
                        a = 0L;
                    } catch (Exception unused) {
                    }
                    this.d = null;
                    this.c = null;
                    this.h = false;
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.g;
            if (currentTimeMillis - j <= 0 || currentTimeMillis - j > 5000) {
                this.g = currentTimeMillis;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f;
            if (currentTimeMillis - j > 0) {
                long j2 = this.l;
                if (currentTimeMillis - j <= j2 + 5000 || currentTimeMillis - (a * 1000) <= j2 + 5000) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 28 && currentTimeMillis - j < ANRMonitor.ANR_TIMEOUT_MS) {
                    return false;
                }
                if (i() && currentTimeMillis - this.f <= this.l + 10000) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            WifiManager wifiManager = this.c;
            if (wifiManager != null) {
                try {
                    if (!wifiManager.isWifiEnabled()) {
                        if (Build.VERSION.SDK_INT <= 17) {
                            return "";
                        }
                        if (!this.c.isScanAlwaysAvailable()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.m;
            if (currentTimeMillis < 0 || currentTimeMillis > 2000) {
                this.m = System.currentTimeMillis();
                try {
                    if ((this.c.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.c.isScanAlwaysAvailable())) && com.baidu.location.e.k.f != 4) {
                        this.c.startScan();
                        this.f = System.currentTimeMillis();
                        return true;
                    }
                } catch (Exception | NoSuchMethodError unused) {
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                if (this.i == null) {
                    this.i = (ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity");
                }
                if (this.i != null) {
                    return this.i.getNetworkInfo(1).isConnected();
                }
                return false;
            } catch (Error | Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public boolean j() {
        InterceptResult invokeV;
        j n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                if ((!this.c.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.c.isScanAlwaysAvailable())) || i() || (n = n()) == null) {
                    return false;
                }
                return n.e();
            } catch (Exception | NoSuchMethodError unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public WifiInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            WifiManager wifiManager = this.c;
            if (wifiManager != null && com.baidu.location.e.k.f != 4) {
                try {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null && connectionInfo.getBSSID() != null && connectionInfo.getRssi() > -100) {
                        String bssid = connectionInfo.getBSSID();
                        if (bssid != null) {
                            String replace = bssid.replace(":", "");
                            if (!"000000000000".equals(replace) && !"".equals(replace)) {
                                if (replace.equals("020000000000")) {
                                }
                            }
                            return null;
                        }
                        return connectionInfo;
                    }
                } catch (Error | Exception unused) {
                }
            }
            return null;
        }
        return (WifiInfo) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            WifiInfo k = a().k();
            if (k != null && k.getBSSID() != null) {
                String replace = k.getBSSID().replace(":", "");
                int rssi = k.getRssi();
                String m = a().m();
                if (rssi < 0) {
                    rssi = -rssi;
                }
                if (replace != null && rssi < 100 && !replace.equals("020000000000")) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            WifiManager wifiManager = this.c;
            if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
                return null;
            }
            return a(dhcpInfo.gateway);
        }
        return (String) invokeV.objValue;
    }

    public j n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            j jVar = this.e;
            return (jVar == null || !jVar.j()) ? p() : this.e;
        }
        return (j) invokeV.objValue;
    }

    public j o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            j jVar = this.e;
            return (jVar == null || !jVar.k()) ? p() : this.e;
        }
        return (j) invokeV.objValue;
    }

    public j p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            WifiManager wifiManager = this.c;
            if (wifiManager != null) {
                try {
                    return a(wifiManager, this.f);
                } catch (Exception unused) {
                }
            }
            return a((WifiManager) null, 0L);
        }
        return (j) invokeV.objValue;
    }
}
