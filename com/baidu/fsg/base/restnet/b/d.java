package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public class d implements com.baidu.fsg.base.restnet.rest.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.rest.c f39273a;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.http.a f39274b;

    /* renamed from: c  reason: collision with root package name */
    public String f39275c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f39276d;

    /* renamed from: e  reason: collision with root package name */
    public String f39277e;

    /* renamed from: f  reason: collision with root package name */
    public String f39278f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f39279g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f39280h;

    /* renamed from: i  reason: collision with root package name */
    public int f39281i;

    public d(com.baidu.fsg.base.restnet.rest.c cVar, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, str, httpMethod, list, restMultipartEntity, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39274b = new com.baidu.fsg.base.restnet.http.a();
        this.f39281i = -1;
        this.f39273a = cVar;
        this.f39275c = str2;
        this.f39276d = httpMethod;
        this.f39277e = str;
        this.f39279g = list;
        this.f39280h = restMultipartEntity;
    }

    public RestMultipartEntity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39280h : (RestMultipartEntity) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f39281i = i2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f39277e = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.http.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39274b : (com.baidu.fsg.base.restnet.http.a) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f39278f = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public HttpDefines.HttpMethod c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39276d : (HttpDefines.HttpMethod) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39277e : (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.rest.e e() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Thread.currentThread().isInterrupted()) {
                return null;
            }
            return this.f39273a.a(this);
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39275c : (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f39273a.a();
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f39281i : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c() == HttpDefines.HttpMethod.POST : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c() == HttpDefines.HttpMethod.GET : invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f39278f : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            List<RestNameValuePair> list = this.f39279g;
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (RestNameValuePair restNameValuePair : this.f39279g) {
                String name = restNameValuePair.getName();
                String value = restNameValuePair.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    try {
                        sb.append(URLEncoder.encode(name, this.f39275c));
                        sb.append(com.alipay.sdk.encrypt.a.f35879h);
                        sb.append(URLEncoder.encode(value, this.f39275c));
                        sb.append(Typography.amp);
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (sb.length() > 1) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
