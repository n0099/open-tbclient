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
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final String o = "APPKEY_ERROR";
    public static final String p = "SUCCESS";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f36242c;

    /* renamed from: d  reason: collision with root package name */
    public String f36243d;

    /* renamed from: e  reason: collision with root package name */
    public String f36244e;

    /* renamed from: f  reason: collision with root package name */
    public String f36245f;

    /* renamed from: g  reason: collision with root package name */
    public String f36246g;

    /* renamed from: h  reason: collision with root package name */
    public String f36247h;

    /* renamed from: i  reason: collision with root package name */
    public String f36248i;

    /* renamed from: j  reason: collision with root package name */
    public String f36249j;
    public String k;

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
        this.k = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f36245f;
            return str == null ? "0" : str;
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "1".equals(this.f36244e) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36240a ? com.alipay.security.mobile.module.a.a.a(this.f36242c) ? 2 : 1 : o.equals(this.f36241b) ? 3 : 2 : invokeV.intValue;
    }
}
