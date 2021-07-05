package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10356a;

    /* renamed from: b  reason: collision with root package name */
    public String f10357b;

    /* renamed from: c  reason: collision with root package name */
    public String f10358c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f10359d;

    public g(String str, IntentFilter intentFilter, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, intentFilter, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10356a = str;
        this.f10359d = intentFilter;
        this.f10357b = str2;
        this.f10358c = str3;
    }

    public final boolean a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar != null) {
                try {
                    if (!TextUtils.isEmpty(gVar.f10356a) && !TextUtils.isEmpty(gVar.f10357b) && !TextUtils.isEmpty(gVar.f10358c) && gVar.f10356a.equals(this.f10356a) && gVar.f10357b.equals(this.f10357b) && gVar.f10358c.equals(this.f10358c)) {
                        if (gVar.f10359d != null && this.f10359d != null) {
                            return this.f10359d == gVar.f10359d;
                        }
                        return true;
                    }
                    return false;
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return "PluginloaderIntentFilter:" + this.f10356a + "-" + this.f10357b + "-" + this.f10358c + "-" + this.f10359d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
