package com.baidu.searchbox.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 5000;
    public static volatile a b = null;
    public static String c = "android.net.conn.CONNECTIVITY_CHANGE";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean d;
    public ConnectivityManager e;
    public C0135a f;
    public boolean g;
    public Context mContext;

    /* renamed from: com.baidu.searchbox.dns.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.searchbox.dns.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0135a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a h;

        public C0135a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                a aVar = this.h;
                aVar.d = aVar.c();
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + this.h.d + " isSticky: " + isInitialStickyBroadcast());
                }
                DnsUtil.initNetworkStackType();
                if (!this.h.d || isInitialStickyBroadcast()) {
                    return;
                }
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, "clear dns cache and force update domain");
                }
                com.baidu.searchbox.dns.a.a.e().clear();
                b.d();
            }
        }

        public /* synthetic */ C0135a(a aVar, AnonymousClass1 anonymousClass1) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            NetworkInfo activeNetworkInfo = this.e.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return invokeV.booleanValue;
    }

    public synchronized void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.g) {
                    this.mContext.unregisterReceiver(this.f);
                    this.g = false;
                }
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? b : (a) invokeV.objValue;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null) {
                        b = new a(context);
                    }
                }
            }
            return b;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.g) {
                    this.e = (ConnectivityManager) this.mContext.getSystemService("connectivity");
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(c);
                    C0135a c0135a = new C0135a(this, null);
                    this.f = c0135a;
                    this.mContext.registerReceiver(c0135a, intentFilter);
                    this.g = true;
                }
            }
        }
    }
}
