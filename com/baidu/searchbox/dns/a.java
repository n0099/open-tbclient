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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f38948b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f38949c = "android.net.conn.CONNECTIVITY_CHANGE";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38950d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager f38951e;

    /* renamed from: f  reason: collision with root package name */
    public C1773a f38952f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38953g;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1773a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f38954h;

        public C1773a(a aVar) {
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
            this.f38954h = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                a aVar = this.f38954h;
                aVar.f38950d = aVar.c();
                if (DnsUtil.DEBUG) {
                    String str = " action: " + intent.getAction() + " isConnected: " + this.f38954h.f38950d + " isSticky: " + isInitialStickyBroadcast();
                }
                if (!this.f38954h.f38950d || isInitialStickyBroadcast()) {
                    return;
                }
                boolean z = DnsUtil.DEBUG;
                com.baidu.searchbox.dns.a.a.e().clear();
                b.d();
            }
        }

        public /* synthetic */ C1773a(a aVar, AnonymousClass1 anonymousClass1) {
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
        this.f38953g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            NetworkInfo activeNetworkInfo = this.f38951e.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return invokeV.booleanValue;
    }

    public synchronized void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f38953g) {
                    this.mContext.unregisterReceiver(this.f38952f);
                    this.f38953g = false;
                }
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f38948b : (a) invokeV.objValue;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f38948b == null) {
                synchronized (a.class) {
                    if (f38948b == null) {
                        f38948b = new a(context);
                    }
                }
            }
            return f38948b;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.f38953g) {
                    this.f38951e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(f38949c);
                    C1773a c1773a = new C1773a(this, null);
                    this.f38952f = c1773a;
                    this.mContext.registerReceiver(c1773a, intentFilter);
                    this.f38953g = true;
                }
            }
        }
    }
}
