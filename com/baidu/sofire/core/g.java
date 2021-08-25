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
    public String f45186a;

    /* renamed from: b  reason: collision with root package name */
    public String f45187b;

    /* renamed from: c  reason: collision with root package name */
    public String f45188c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f45189d;

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
        this.f45186a = str;
        this.f45189d = intentFilter;
        this.f45187b = str2;
        this.f45188c = str3;
    }

    public final boolean a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar != null) {
                try {
                    if (!TextUtils.isEmpty(gVar.f45186a) && !TextUtils.isEmpty(gVar.f45187b) && !TextUtils.isEmpty(gVar.f45188c) && gVar.f45186a.equals(this.f45186a) && gVar.f45187b.equals(this.f45187b) && gVar.f45188c.equals(this.f45188c)) {
                        if (gVar.f45189d != null && this.f45189d != null) {
                            return this.f45189d == gVar.f45189d;
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
                return "PluginloaderIntentFilter:" + this.f45186a + "-" + this.f45187b + "-" + this.f45188c + "-" + this.f45189d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
