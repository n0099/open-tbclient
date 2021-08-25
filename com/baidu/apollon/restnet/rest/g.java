package com.baidu.apollon.restnet.rest;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f38006a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f38007b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f38008c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final int f38009d;

    /* renamed from: e  reason: collision with root package name */
    public final int f38010e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1270742357, "Lcom/baidu/apollon/restnet/rest/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1270742357, "Lcom/baidu/apollon/restnet/rest/g;");
                return;
            }
        }
        f38007b = new HashSet<>();
        f38008c = new HashSet<>();
        f38007b.add(UnknownHostException.class);
        f38007b.add(SocketException.class);
        f38007b.add(ProtocolException.class);
        f38008c.add(SSLException.class);
        f38008c.add(SocketTimeoutException.class);
    }

    public g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38009d = i2;
        this.f38010e = i3;
    }

    public boolean a(Exception exc, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, exc, i2)) == null) {
            boolean z = false;
            if (i2 <= this.f38009d && (a(f38007b, exc) || !a(f38008c, exc))) {
                z = true;
            }
            String str = f38006a;
            LogUtil.d(str, f38006a + " retryRequest is called ,retry flag is " + z);
            if (z) {
                SystemClock.sleep(this.f38010e);
            } else {
                exc.printStackTrace();
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public boolean a(HashSet<Class<?>> hashSet, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashSet, th)) == null) {
            Iterator<Class<?>> it = hashSet.iterator();
            while (it.hasNext()) {
                if (it.next().isInstance(th)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
