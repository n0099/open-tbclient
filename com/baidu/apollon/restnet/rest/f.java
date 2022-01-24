package com.baidu.apollon.restnet.rest;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class f<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "f";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Class<T> f32645b;

    /* renamed from: c  reason: collision with root package name */
    public final AbstractHttpMessageConverter<?> f32646c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1270742388, "Lcom/baidu/apollon/restnet/rest/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1270742388, "Lcom/baidu/apollon/restnet/rest/f;");
        }
    }

    public f(Class<T> cls, AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, abstractHttpMessageConverter};
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
        if (abstractHttpMessageConverter != null) {
            this.f32645b = cls;
            this.f32646c = abstractHttpMessageConverter;
            return;
        }
        throw new IllegalArgumentException("'messageConverters' must not be empty");
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
                    Log.isLoggable(a, 3);
                }
                return (T) this.f32646c.a(this.f32645b, eVar);
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32646c.a() : (String) invokeV.objValue;
    }
}
