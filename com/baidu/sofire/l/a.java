package com.baidu.sofire.l;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.sofire.ac.F;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a c;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public SharedPreferences.Editor b;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        SharedPreferences platformPrivateSharedPreferences = F.getInstance().getPlatformPrivateSharedPreferences(context);
        this.a = platformPrivateSharedPreferences;
        this.b = platformPrivateSharedPreferences.edit();
    }
}
