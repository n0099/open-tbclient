package com.baidu.fsg.base.restnet;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.restnet.http.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.List;
/* loaded from: classes4.dex */
public class RestResponseEntity<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T mBody;
    public a mHeaders;
    public final HttpStatus mStatusCode;

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
        this.mStatusCode = httpStatus;
    }

    public RestResponseEntity(a aVar, HttpStatus httpStatus) {
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
        this.mHeaders = aVar;
        this.mStatusCode = httpStatus;
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
        this.mStatusCode = httpStatus;
        this.mBody = t;
    }

    public RestResponseEntity(T t, a aVar, HttpStatus httpStatus) {
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
        this.mHeaders = aVar;
        this.mBody = t;
        this.mStatusCode = httpStatus;
    }

    public T getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBody : (T) invokeV.objValue;
    }

    public String getFirstHeaderValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            a aVar = this.mHeaders;
            return aVar != null ? aVar.getFirst(str) : "";
        }
        return (String) invokeL.objValue;
    }

    public List<String> getHeaderValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            a aVar = this.mHeaders;
            if (aVar != null) {
                return aVar.get((Object) str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public HttpStatus getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mStatusCode : (HttpStatus) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.mStatusCode.toString());
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(this.mStatusCode.getReasonPhrase());
            sb.append(',');
            T body = getBody();
            a aVar = this.mHeaders;
            if (body != null) {
                sb.append(body);
                if (aVar != null) {
                    sb.append(',');
                }
            }
            if (aVar != null) {
                sb.append(aVar);
            }
            sb.append('>');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
