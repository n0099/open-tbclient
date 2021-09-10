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
    public final com.baidu.fsg.base.restnet.rest.c f39384a;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.fsg.base.restnet.http.a f39385b;

    /* renamed from: c  reason: collision with root package name */
    public String f39386c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f39387d;

    /* renamed from: e  reason: collision with root package name */
    public String f39388e;

    /* renamed from: f  reason: collision with root package name */
    public String f39389f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f39390g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f39391h;

    /* renamed from: i  reason: collision with root package name */
    public int f39392i;

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
        this.f39385b = new com.baidu.fsg.base.restnet.http.a();
        this.f39392i = -1;
        this.f39384a = cVar;
        this.f39386c = str2;
        this.f39387d = httpMethod;
        this.f39388e = str;
        this.f39390g = list;
        this.f39391h = restMultipartEntity;
    }

    public RestMultipartEntity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39391h : (RestMultipartEntity) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f39392i = i2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f39388e = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.http.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39385b : (com.baidu.fsg.base.restnet.http.a) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f39389f = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public HttpDefines.HttpMethod c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39387d : (HttpDefines.HttpMethod) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39388e : (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public com.baidu.fsg.base.restnet.rest.e e() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Thread.currentThread().isInterrupted()) {
                return null;
            }
            return this.f39384a.a(this);
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39386c : (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f39384a.a();
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.d
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f39392i : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f39389f : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            List<RestNameValuePair> list = this.f39390g;
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (RestNameValuePair restNameValuePair : this.f39390g) {
                String name = restNameValuePair.getName();
                String value = restNameValuePair.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    try {
                        sb.append(URLEncoder.encode(name, this.f39386c));
                        sb.append(com.alipay.sdk.encrypt.a.f35988h);
                        sb.append(URLEncoder.encode(value, this.f39386c));
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
