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
    public String f45301a;

    /* renamed from: b  reason: collision with root package name */
    public String f45302b;

    /* renamed from: c  reason: collision with root package name */
    public String f45303c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f45304d;

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
        this.f45301a = str;
        this.f45304d = intentFilter;
        this.f45302b = str2;
        this.f45303c = str3;
    }

    public final boolean a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar != null) {
                try {
                    if (!TextUtils.isEmpty(gVar.f45301a) && !TextUtils.isEmpty(gVar.f45302b) && !TextUtils.isEmpty(gVar.f45303c) && gVar.f45301a.equals(this.f45301a) && gVar.f45302b.equals(this.f45302b) && gVar.f45303c.equals(this.f45303c)) {
                        if (gVar.f45304d != null && this.f45304d != null) {
                            return this.f45304d == gVar.f45304d;
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
                return "PluginloaderIntentFilter:" + this.f45301a + "-" + this.f45302b + "-" + this.f45303c + "-" + this.f45304d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
