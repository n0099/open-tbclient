package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45302a;

    /* renamed from: b  reason: collision with root package name */
    public String f45303b;

    /* renamed from: c  reason: collision with root package name */
    public String f45304c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f45305d;

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
        this.f45302a = str;
        this.f45305d = intentFilter;
        this.f45303b = str2;
        this.f45304c = str3;
    }

    public final boolean a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar != null) {
                try {
                    if (!TextUtils.isEmpty(gVar.f45302a) && !TextUtils.isEmpty(gVar.f45303b) && !TextUtils.isEmpty(gVar.f45304c) && gVar.f45302a.equals(this.f45302a) && gVar.f45303b.equals(this.f45303b) && gVar.f45304c.equals(this.f45304c)) {
                        if (gVar.f45305d != null && this.f45305d != null) {
                            return this.f45305d == gVar.f45305d;
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
                return "PluginloaderIntentFilter:" + this.f45302a + "-" + this.f45303b + "-" + this.f45304c + "-" + this.f45305d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
