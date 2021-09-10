package com.alipay.security.mobile.module.http.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f36195c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f36196d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f36197e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final String f36198f = "APPKEY_ERROR";

    /* renamed from: g  reason: collision with root package name */
    public static final String f36199g = "SUCCESS";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f36200h;

    /* renamed from: i  reason: collision with root package name */
    public String f36201i;

    /* renamed from: j  reason: collision with root package name */
    public String f36202j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = "";
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36193a ? com.alipay.security.mobile.module.a.a.a(this.f36200h) ? 2 : 1 : f36198f.equals(this.f36194b) ? 3 : 2 : invokeV.intValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "1".equals(this.f36202j) : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.k;
            return str == null ? "0" : str;
        }
        return (String) invokeV.objValue;
    }
}
