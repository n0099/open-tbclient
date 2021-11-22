package com.baidu.sofire.core;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f43979a;

    /* renamed from: b  reason: collision with root package name */
    public String f43980b;

    /* renamed from: c  reason: collision with root package name */
    public String f43981c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f43982d;

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
        this.f43979a = str;
        this.f43982d = intentFilter;
        this.f43980b = str2;
        this.f43981c = str3;
    }

    public final boolean a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar != null) {
                try {
                    if (!TextUtils.isEmpty(gVar.f43979a) && !TextUtils.isEmpty(gVar.f43980b) && !TextUtils.isEmpty(gVar.f43981c) && gVar.f43979a.equals(this.f43979a) && gVar.f43980b.equals(this.f43980b) && gVar.f43981c.equals(this.f43981c)) {
                        if (gVar.f43982d != null && this.f43982d != null) {
                            return this.f43982d == gVar.f43982d;
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
                return "PluginloaderIntentFilter:" + this.f43979a + "-" + this.f43980b + "-" + this.f43981c + "-" + this.f43982d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
