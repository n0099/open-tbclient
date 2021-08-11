package com.baidu.fsg.base.restnet.rest;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.LogUtil;
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
    public static final String f39224a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f39225b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f39226c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final int f39227d;

    /* renamed from: e  reason: collision with root package name */
    public final int f39228e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1348486770, "Lcom/baidu/fsg/base/restnet/rest/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1348486770, "Lcom/baidu/fsg/base/restnet/rest/g;");
                return;
            }
        }
        f39225b = new HashSet<>();
        f39226c = new HashSet<>();
        f39225b.add(UnknownHostException.class);
        f39225b.add(SocketException.class);
        f39225b.add(ProtocolException.class);
        f39226c.add(SSLException.class);
        f39226c.add(SocketTimeoutException.class);
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
        this.f39227d = i2;
        this.f39228e = i3;
    }

    public boolean a(Exception exc, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, exc, i2)) == null) {
            boolean z = false;
            if (i2 <= this.f39227d && (a(f39225b, exc) || !a(f39226c, exc))) {
                z = true;
            }
            String str = f39224a;
            LogUtil.d(str, f39224a + " retryRequest is called ,retry flag is " + z);
            if (z) {
                SystemClock.sleep(this.f39228e);
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
