package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7997a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7998b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7999c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8000d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8001e;

    /* renamed from: f  reason: collision with root package name */
    public final String f8002f;

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7997a = false;
        this.f7998b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f7999c = this.f7998b + File.separator + "BaiduMapSDKNew";
        this.f8000d = context.getCacheDir().getAbsolutePath();
        this.f8001e = "";
        this.f8002f = "";
    }

    public g(String str, boolean z, String str2, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), str2, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7997a = z;
        this.f7998b = str;
        this.f7999c = this.f7998b + File.separator + "BaiduMapSDKNew";
        this.f8000d = this.f7999c + File.separator + SapiOptions.KEY_CACHE;
        this.f8001e = context.getCacheDir().getAbsolutePath();
        this.f8002f = str2;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7998b : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f7998b + File.separator + "BaiduMapSDKNew";
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8000d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8001e : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == null || !g.class.isInstance(obj)) {
                return false;
            }
            return this.f7998b.equals(((g) obj).f7998b);
        }
        return invokeL.booleanValue;
    }
}
