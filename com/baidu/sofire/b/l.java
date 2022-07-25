package com.baidu.sofire.b;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public IntentFilter d;

    public l(String str, IntentFilter intentFilter, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, intentFilter, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.d = intentFilter;
        this.b = str2;
        this.c = str3;
    }

    public boolean a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            if (lVar != null) {
                try {
                    if (!TextUtils.isEmpty(lVar.a) && !TextUtils.isEmpty(lVar.b) && !TextUtils.isEmpty(lVar.c) && lVar.a.equals(this.a) && lVar.b.equals(this.b) && lVar.c.equals(this.c)) {
                        IntentFilter intentFilter = lVar.d;
                        if (intentFilter != null) {
                            IntentFilter intentFilter2 = this.d;
                            return intentFilter2 == null || intentFilter2 == intentFilter;
                        }
                        return true;
                    }
                    return false;
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return "PluginloaderIntentFilter:" + this.a + "-" + this.b + "-" + this.c + "-" + this.d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
