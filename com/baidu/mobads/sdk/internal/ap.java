package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a;
    public static final String b = "pauseDlByPk";
    public static final String c = "cancelDlByPk";
    public static final String d = "resumeDownload";
    public static final String e = "getDownloadStatus";
    public static ap g;
    public transient /* synthetic */ FieldHolder $fh;
    public aq f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833692928, "Lcom/baidu/mobads/sdk/internal/ap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833692928, "Lcom/baidu/mobads/sdk/internal/ap;");
                return;
            }
        }
        a = w.p;
    }

    public ap(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = aq.a(context, a);
    }

    public static ap a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (g == null) {
                synchronized (ap.class) {
                    if (g == null) {
                        g = new ap(context);
                    }
                }
            }
            return g;
        }
        return (ap) invokeL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.f.a(null, c, str);
        }
    }

    public int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (bs.a(context, str)) {
                    return 103;
                }
                Object b2 = this.f.b(null, e, str);
                if (b2 instanceof Integer) {
                    return ((Integer) b2).intValue();
                }
                return -1;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.f.a(null, b, str, 1);
        }
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, str, str2)) == null) {
            if (context != null && jSONObject != null) {
                Object b2 = this.f.b(null, d, context, jSONObject, str, str2);
                if (b2 instanceof Boolean) {
                    return ((Boolean) b2).booleanValue();
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
