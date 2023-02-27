package com.baidu.android.pushservice.x;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public g a(Context context, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i, str)) == null) {
            if (i != 200) {
                switch (i) {
                    case 100:
                        return new j(context, i, str);
                    case 101:
                        return new e(context, i, str);
                    case 102:
                        return new b(context, i, str);
                    case 103:
                        return new f(context, i, str);
                    case 104:
                        return new c(context, i, str);
                    default:
                        return null;
                }
            }
            return new i(context, i, str);
        }
        return (g) invokeLIL.objValue;
    }
}
