package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
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
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, com.baidu.searchbox.dns.d.a> I;
    public final Object J;

    /* renamed from: com.baidu.searchbox.dns.d.b$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static b K;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1218011033, "Lcom/baidu/searchbox/dns/d/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1218011033, "Lcom/baidu/searchbox/dns/d/b$a;");
                    return;
                }
            }
            K = new b(null);
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.J = new Object();
        this.I = new HashMap<>(10);
    }

    public static b o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a.K;
        }
        return (b) invokeV.objValue;
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public com.baidu.searchbox.dns.d.a a(String str, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (!TextUtils.isEmpty(str)) {
                synchronized (this.J) {
                    if (this.I.get(str) == null) {
                        if (DnsUtil.DEBUG) {
                            Log.d(DnsUtil.TAG, " creat dns transmit task isBatch: " + z + " host: " + str);
                        }
                        return new com.baidu.searchbox.dns.d.a(z, str, i);
                    }
                    return null;
                }
            }
            return null;
        }
        return (com.baidu.searchbox.dns.d.a) invokeCommon.objValue;
    }

    public void a(String str, com.baidu.searchbox.dns.d.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) && !TextUtils.isEmpty(str) && aVar != null) {
            synchronized (this.J) {
                this.I.put(str, aVar);
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " add dns transmit task: " + str);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !TextUtils.isEmpty(str)) {
            synchronized (this.J) {
                this.I.remove(str);
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " remove dns transmit task: " + str);
            }
        }
    }
}
