package com.baidu.sofire.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45214a;

    public a(Context context) {
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
        this.f45214a = context;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                a2 = f.a(this.f45214a, c.b() + "p/1/r", str, false, false);
            } catch (Throwable unused) {
                c.a();
            }
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            return new JSONObject(a2).getInt("response") == 1;
        }
        return invokeL.booleanValue;
    }
}
