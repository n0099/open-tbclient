package com.baidu.bdhttpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import c.a.j.j;
import c.a.j.k;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class BDNetworkStateChangeReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f38256a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38257b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38258c;

    /* renamed from: d  reason: collision with root package name */
    public String f38259d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38260e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38261f;

    /* loaded from: classes5.dex */
    public class a implements Callable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BDNetworkStateChangeReceiver f38262e;

        public a(BDNetworkStateChangeReceiver bDNetworkStateChangeReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDNetworkStateChangeReceiver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38262e = bDNetworkStateChangeReceiver;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                InetSocketAddress inetSocketAddress = new InetSocketAddress("2001:4860:4860::8888", (int) Constants.SOCKET_PORT_SSL);
                try {
                    new DatagramSocket().connect(new InetSocketAddress("180.76.76.76", 80));
                } catch (SocketException unused) {
                    this.f38262e.f38261f = false;
                }
                try {
                    new DatagramSocket().connect(inetSocketAddress);
                } catch (SocketException unused2) {
                    this.f38262e.f38260e = false;
                }
                k.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(this.f38262e.f38261f), Boolean.valueOf(this.f38262e.f38260e));
                return null;
            }
            return invokeV.objValue;
        }
    }

    public BDNetworkStateChangeReceiver() {
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
        this.f38256a = false;
        this.f38257b = true;
        this.f38258c = true;
        this.f38259d = "";
        this.f38260e = true;
        this.f38261f = true;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            k.a("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.f38257b), Boolean.valueOf(this.f38258c));
            i b2 = i.b();
            b2.r();
            BDHttpDns j2 = BDHttpDns.j(context);
            refreshIpReachable();
            ArrayList<String> e2 = j2.a().e();
            if (this.f38257b) {
                j2.a().b();
                j2.d().b();
            }
            if (this.f38258c) {
                if (isIPv6Only()) {
                    k.a("Now the network is Ipv6 Only, Will not send prefetch request. ", new Object[0]);
                } else if (e2 == null || e2.isEmpty()) {
                } else {
                    b2.o(e2, new j(context));
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f38257b = z;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f38258c = z;
        }
    }

    public boolean isIPv6Only() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.f38261f && this.f38260e : invokeV.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:13|(1:(6:40|19|20|(1:23)|25|26)(1:39))(1:17)|18|19|20|(1:23)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        r6 = r0;
        r0 = r9;
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0070, code lost:
        r0 = r9;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        String str;
        ConnectivityManager connectivityManager;
        String extraInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, intent) == null) {
            String str2 = "";
            if (!this.f38256a) {
                this.f38256a = true;
                return;
            }
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (RuntimeException e2) {
                e = e2;
            }
            if (connectivityManager == null) {
                a(context);
                return;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                extraInfo = networkInfo.getExtraInfo();
            } else if (networkInfo2 == null || networkInfo2.getState() != NetworkInfo.State.CONNECTED) {
                str = "";
                if (!this.f38259d.equals(str) && str != "") {
                    k.a("Current net type: %s.", str);
                    a(context);
                }
                this.f38259d = str;
            } else {
                extraInfo = networkInfo2.getExtraInfo();
            }
            str = extraInfo.toString();
            if (!this.f38259d.equals(str)) {
                k.a("Current net type: %s.", str);
                a(context);
            }
            this.f38259d = str;
        }
    }

    public void refreshIpReachable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Executors.newFixedThreadPool(1).submit(new a(this));
        }
    }
}
