package com.baidu.bdhttpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.np;
import com.baidu.tieba.op;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class BDNetworkStateChangeReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean isIPv4Reachable = true;
    public static boolean isIPv6Reachable = true;
    public transient /* synthetic */ FieldHolder $fh;
    public String beforeNetInfo;
    public boolean clearCache;
    public boolean httpDnsPrefetch;
    public boolean isFirstNotify;
    public ExecutorService mService;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2008299385, "Lcom/baidu/bdhttpdns/BDNetworkStateChangeReceiver;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2008299385, "Lcom/baidu/bdhttpdns/BDNetworkStateChangeReceiver;");
        }
    }

    /* loaded from: classes.dex */
    public class a implements Callable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(BDNetworkStateChangeReceiver bDNetworkStateChangeReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDNetworkStateChangeReceiver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object call() {
            InterceptResult invokeV;
            DatagramSocket datagramSocket;
            DatagramSocket datagramSocket2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                InetSocketAddress inetSocketAddress = new InetSocketAddress("2001:4860:4860::8888", 443);
                InetSocketAddress inetSocketAddress2 = new InetSocketAddress("180.76.76.76", 80);
                try {
                    datagramSocket = new DatagramSocket();
                } catch (SocketException unused) {
                    datagramSocket = null;
                }
                try {
                    datagramSocket.connect(inetSocketAddress2);
                    boolean unused2 = BDNetworkStateChangeReceiver.isIPv4Reachable = true;
                } catch (SocketException unused3) {
                    boolean unused4 = BDNetworkStateChangeReceiver.isIPv4Reachable = false;
                    if (datagramSocket != null) {
                    }
                    datagramSocket2 = new DatagramSocket();
                    try {
                        datagramSocket2.connect(inetSocketAddress);
                        boolean unused5 = BDNetworkStateChangeReceiver.isIPv6Reachable = true;
                    } catch (SocketException unused6) {
                        datagramSocket = datagramSocket2;
                        boolean unused7 = BDNetworkStateChangeReceiver.isIPv6Reachable = false;
                        datagramSocket2 = datagramSocket;
                        if (datagramSocket2 != null) {
                        }
                        op.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(BDNetworkStateChangeReceiver.isIPv4Reachable), Boolean.valueOf(BDNetworkStateChangeReceiver.isIPv6Reachable));
                        return null;
                    }
                    if (datagramSocket2 != null) {
                    }
                    op.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(BDNetworkStateChangeReceiver.isIPv4Reachable), Boolean.valueOf(BDNetworkStateChangeReceiver.isIPv6Reachable));
                    return null;
                }
                if (datagramSocket != null) {
                    try {
                        datagramSocket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    datagramSocket2 = new DatagramSocket();
                    datagramSocket2.connect(inetSocketAddress);
                    boolean unused52 = BDNetworkStateChangeReceiver.isIPv6Reachable = true;
                } catch (SocketException unused8) {
                }
                if (datagramSocket2 != null) {
                    try {
                        datagramSocket2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                op.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(BDNetworkStateChangeReceiver.isIPv4Reachable), Boolean.valueOf(BDNetworkStateChangeReceiver.isIPv6Reachable));
                return null;
            }
            return invokeV.objValue;
        }
    }

    public BDNetworkStateChangeReceiver() {
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
        this.isFirstNotify = false;
        this.clearCache = true;
        this.httpDnsPrefetch = true;
        this.beforeNetInfo = "";
        this.mService = Executors.newFixedThreadPool(1);
    }

    public static boolean isIPv4Reachable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return isIPv4Reachable;
        }
        return invokeV.booleanValue;
    }

    public static boolean isIPv6Reachable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return isIPv6Reachable;
        }
        return invokeV.booleanValue;
    }

    public boolean isClearCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.clearCache;
        }
        return invokeV.booleanValue;
    }

    public boolean isHttpDnsPrefetch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.httpDnsPrefetch;
        }
        return invokeV.booleanValue;
    }

    public boolean isIPv6Only() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!isIPv4Reachable && isIPv6Reachable) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void refreshIpReachable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mService.submit(new a(this));
        }
    }

    public void setClearCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.clearCache = z;
        }
    }

    public void setHttpDnsPrefetch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.httpDnsPrefetch = z;
        }
    }

    private void processCacheOnNetworkChange(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            op.a("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.clearCache), Boolean.valueOf(this.httpDnsPrefetch));
            HttpDnsClient z = HttpDnsClient.z();
            z.x();
            BDHttpDns h = BDHttpDns.h(context);
            refreshIpReachable();
            ArrayList<String> b = h.e().b();
            if (this.clearCache) {
                h.e().a();
                h.d().a();
            }
            if (this.httpDnsPrefetch && b != null && !b.isEmpty()) {
                z.O(b, new np(context));
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, intent) == null) {
            String str2 = "";
            if (!this.isFirstNotify) {
                this.isFirstNotify = true;
                return;
            }
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (RuntimeException e) {
                e = e;
            }
            if (connectivityManager == null) {
                processCacheOnNetworkChange(context);
                return;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                str = networkInfo.getExtraInfo().toString();
            } else if (networkInfo2 == null || networkInfo2.getState() != NetworkInfo.State.CONNECTED) {
                str = "";
            } else {
                str = networkInfo2.getExtraInfo().toString();
            }
            try {
                if (!this.beforeNetInfo.equals(str) && str != "") {
                    op.a("Current net type: %s.", str);
                    processCacheOnNetworkChange(context);
                }
            } catch (RuntimeException e2) {
                String str3 = str;
                e = e2;
                str2 = str3;
                e.printStackTrace();
                try {
                    processCacheOnNetworkChange(context);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                str = str2;
                this.beforeNetInfo = str;
            }
            this.beforeNetInfo = str;
        }
    }
}
