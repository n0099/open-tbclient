package com.baidu.apollon.restnet;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class RestResponseEntity<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HttpStatus f3836a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.apollon.restnet.http.a f3837b;

    /* renamed from: c  reason: collision with root package name */
    public T f3838c;

    /* renamed from: d  reason: collision with root package name */
    public String f3839d;

    public RestResponseEntity(HttpStatus httpStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpStatus};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3836a = httpStatus;
    }

    public HttpStatus a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3836a : (HttpStatus) invokeV.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            com.baidu.apollon.restnet.http.a aVar = this.f3837b;
            return aVar != null ? aVar.c(str) : "";
        }
        return (String) invokeL.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f3839d = str;
        }
    }

    public T getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3838c : (T) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.f3836a.toString());
            sb.append(' ');
            sb.append(this.f3836a.getReasonPhrase());
            sb.append(',');
            T body = getBody();
            com.baidu.apollon.restnet.http.a aVar = this.f3837b;
            if (body != null) {
                sb.append(body);
                if (aVar != null) {
                    sb.append(',');
                }
            }
            if (aVar != null) {
                sb.append(aVar);
            }
            sb.append(Typography.greater);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public List<String> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            com.baidu.apollon.restnet.http.a aVar = this.f3837b;
            if (aVar != null) {
                return aVar.get((Object) str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public RestResponseEntity(T t, HttpStatus httpStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, httpStatus};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f3836a = httpStatus;
        this.f3838c = t;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3839d : (String) invokeV.objValue;
    }

    public RestResponseEntity(com.baidu.apollon.restnet.http.a aVar, HttpStatus httpStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, httpStatus};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3837b = aVar;
        this.f3836a = httpStatus;
    }

    public RestResponseEntity(T t, com.baidu.apollon.restnet.http.a aVar, HttpStatus httpStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, aVar, httpStatus};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f3837b = aVar;
        this.f3838c = t;
        this.f3836a = httpStatus;
    }
}
