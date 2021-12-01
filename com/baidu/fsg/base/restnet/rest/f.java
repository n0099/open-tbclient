package com.baidu.fsg.base.restnet.rest;

import android.util.Log;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "f";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Class<T> f34250b;

    /* renamed from: c  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.a.a<?> f34251c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1348486801, "Lcom/baidu/fsg/base/restnet/rest/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1348486801, "Lcom/baidu/fsg/base/restnet/rest/f;");
        }
    }

    public f(Class<T> cls, com.baidu.fsg.base.restnet.a.a<?> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (cls == null) {
            throw new IllegalArgumentException("'responseType' must not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("'messageConverters' must not be empty");
        }
        this.f34250b = cls;
        this.f34251c = aVar;
    }

    private boolean b(e eVar) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, eVar)) == null) {
            HttpStatus statusCode = eVar.getStatusCode();
            return (statusCode == HttpStatus.NO_CONTENT || statusCode == HttpStatus.NOT_MODIFIED || eVar.a().i() == 0) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public T a(e eVar) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            if (b(eVar)) {
                if (eVar.a().j() == null) {
                    Log.isLoggable(a, 3);
                }
                return (T) this.f34251c.a(this.f34250b, eVar);
            }
            return null;
        }
        return (T) invokeL.objValue;
    }
}
