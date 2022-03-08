package com.baidu.searchbox.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f36940b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f36941c = "android.net.conn.CONNECTIVITY_CHANGE";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36942d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f36943e;

    /* renamed from: f  reason: collision with root package name */
    public C1842a f36944f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36945g;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1842a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f36946h;

        public C1842a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36946h = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                a aVar = this.f36946h;
                aVar.f36942d = aVar.c();
                if (DnsUtil.DEBUG) {
                    String str = " action: " + intent.getAction() + " isConnected: " + this.f36946h.f36942d + " isSticky: " + isInitialStickyBroadcast();
                }
                DnsUtil.initNetworkStackType();
                if (!this.f36946h.f36942d || isInitialStickyBroadcast()) {
                    return;
                }
                boolean z = DnsUtil.DEBUG;
                com.baidu.searchbox.dns.a.a.e().clear();
                b.d();
            }
        }

        public /* synthetic */ C1842a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(727494170, "Lcom/baidu/searchbox/dns/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(727494170, "Lcom/baidu/searchbox/dns/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        this.f36945g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            NetworkInfo activeNetworkInfo = this.f36943e.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return invokeV.booleanValue;
    }

    public synchronized void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f36945g) {
                    this.mContext.unregisterReceiver(this.f36944f);
                    this.f36945g = false;
                }
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f36940b : (a) invokeV.objValue;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f36940b == null) {
                synchronized (a.class) {
                    if (f36940b == null) {
                        f36940b = new a(context);
                    }
                }
            }
            return f36940b;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.f36945g) {
                    this.f36943e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(f36941c);
                    C1842a c1842a = new C1842a(this, null);
                    this.f36944f = c1842a;
                    this.mContext.registerReceiver(c1842a, intentFilter);
                    this.f36945g = true;
                }
            }
        }
    }
}
