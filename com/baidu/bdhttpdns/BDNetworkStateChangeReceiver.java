package com.baidu.bdhttpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import c.a.i.j;
import c.a.i.k;
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
/* loaded from: classes10.dex */
public class BDNetworkStateChangeReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32926b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32927c;

    /* renamed from: d  reason: collision with root package name */
    public String f32928d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32929e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32930f;

    /* loaded from: classes10.dex */
    public class a implements Callable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BDNetworkStateChangeReceiver f32931e;

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
            this.f32931e = bDNetworkStateChangeReceiver;
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
                    this.f32931e.f32930f = false;
                }
                try {
                    new DatagramSocket().connect(inetSocketAddress);
                } catch (SocketException unused2) {
                    this.f32931e.f32929e = false;
                }
                k.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(this.f32931e.f32930f), Boolean.valueOf(this.f32931e.f32929e));
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
        this.a = false;
        this.f32926b = true;
        this.f32927c = true;
        this.f32928d = "";
        this.f32929e = true;
        this.f32930f = true;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            k.a("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.f32926b), Boolean.valueOf(this.f32927c));
            i b2 = i.b();
            b2.r();
            BDHttpDns j2 = BDHttpDns.j(context);
            refreshIpReachable();
            ArrayList<String> e2 = j2.a().e();
            if (this.f32926b) {
                j2.a().b();
                j2.d().b();
            }
            if (this.f32927c) {
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
            this.f32926b = z;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f32927c = z;
        }
    }

    public boolean isIPv6Only() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.f32930f && this.f32929e : invokeV.booleanValue;
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
            if (!this.a) {
                this.a = true;
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
                if (!this.f32928d.equals(str) && str != "") {
                    k.a("Current net type: %s.", str);
                    a(context);
                }
                this.f32928d = str;
            } else {
                extraInfo = networkInfo2.getExtraInfo();
            }
            str = extraInfo.toString();
            if (!this.f32928d.equals(str)) {
                k.a("Current net type: %s.", str);
                a(context);
            }
            this.f32928d = str;
        }
    }

    public void refreshIpReachable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Executors.newFixedThreadPool(1).submit(new a(this));
        }
    }
}
