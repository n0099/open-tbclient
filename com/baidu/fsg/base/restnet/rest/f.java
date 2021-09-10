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
/* loaded from: classes5.dex */
public class f<T> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39439a = "f";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Class<T> f39440b;

    /* renamed from: c  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.a.a<?> f39441c;

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
        this.f39440b = cls;
        this.f39441c = aVar;
    }

    private boolean b(e eVar) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, eVar)) == null) {
            HttpStatus e2 = eVar.e();
            return (e2 == HttpStatus.NO_CONTENT || e2 == HttpStatus.NOT_MODIFIED || eVar.d().h() == 0) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public T a(e eVar) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            if (b(eVar)) {
                if (eVar.d().i() == null) {
                    Log.isLoggable(f39439a, 3);
                }
                return (T) this.f39441c.a(this.f39440b, eVar);
            }
            return null;
        }
        return (T) invokeL.objValue;
    }
}
