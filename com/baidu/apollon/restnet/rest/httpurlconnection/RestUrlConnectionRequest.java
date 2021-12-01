package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestMultipartEntity;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.apollon.restnet.rest.RestHttpNetwork;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes8.dex */
public class RestUrlConnectionRequest implements com.baidu.apollon.restnet.rest.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RestHttpNetwork a;

    /* renamed from: b  reason: collision with root package name */
    public final com.baidu.apollon.restnet.http.a f33167b;

    /* renamed from: c  reason: collision with root package name */
    public String f33168c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f33169d;

    /* renamed from: e  reason: collision with root package name */
    public String f33170e;

    /* renamed from: f  reason: collision with root package name */
    public String f33171f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f33172g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f33173h;

    /* renamed from: i  reason: collision with root package name */
    public int f33174i;

    public RestUrlConnectionRequest(RestHttpNetwork restHttpNetwork, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {restHttpNetwork, str, httpMethod, list, restMultipartEntity, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33167b = new com.baidu.apollon.restnet.http.a();
        this.f33174i = -1;
        this.a = restHttpNetwork;
        this.f33168c = str2;
        this.f33169d = httpMethod;
        this.f33170e = str;
        this.f33172g = list;
        this.f33173h = restMultipartEntity;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public com.baidu.apollon.restnet.http.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33167b : (com.baidu.apollon.restnet.http.a) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public HttpDefines.HttpMethod b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33169d : (HttpDefines.HttpMethod) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33170e : (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public e d() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (Thread.currentThread().isInterrupted()) {
                return null;
            }
            return this.a.a(this);
        }
        return (e) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33168c : (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.a();
        }
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33174i : invokeV.intValue;
    }

    public String getProcessedParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            List<RestNameValuePair> list = this.f33172g;
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (RestNameValuePair restNameValuePair : this.f33172g) {
                String name = restNameValuePair.getName();
                String value = restNameValuePair.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    try {
                        sb.append(URLEncoder.encode(name, this.f33168c));
                        sb.append(com.alipay.sdk.encrypt.a.f31351h);
                        sb.append(URLEncoder.encode(value, this.f33168c));
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

    @Override // com.baidu.apollon.restnet.rest.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f33171f : (String) invokeV.objValue;
    }

    public RestMultipartEntity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33173h : (RestMultipartEntity) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? b() == HttpDefines.HttpMethod.POST : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? b() == HttpDefines.HttpMethod.GET : invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f33174i = i2;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f33170e = str;
        }
    }

    @Override // com.baidu.apollon.restnet.rest.d
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f33171f = str;
        }
    }
}
