package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class df {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "error_message";
    public static final String b = "error_code";
    public static volatile df d;
    public transient /* synthetic */ FieldHolder $fh;
    public final br c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833695501, "Lcom/baidu/mobads/sdk/internal/df;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833695501, "Lcom/baidu/mobads/sdk/internal/df;");
        }
    }

    public df() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = br.a();
    }

    public static df a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (df.class) {
                    if (d == null) {
                        d = new df();
                    }
                }
            }
            return d;
        }
        return (df) invokeV.objValue;
    }

    public String a(bn bnVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bnVar, str)) == null) {
            if (bnVar == null) {
                return "";
            }
            return a(bnVar.b() + "", bnVar.c(), str);
        }
        return (String) invokeLL.objValue;
    }

    public String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append("ErrorCode: [");
                sb.append(str);
                sb.append("];");
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append("ErrorDesc: [");
                sb.append(str2);
                sb.append("];");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append(" Extra: [");
                sb.append(str3);
                sb.append("];");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:13:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(Map<String, Object> map) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            if (map != null) {
                try {
                    if (map.containsKey("msg")) {
                        str = a((bn) map.get("msg"), "");
                    } else if (map.containsKey("error_message")) {
                        str = (String) map.get("error_message");
                    }
                } catch (Exception unused) {
                }
                if (str != null) {
                    return "";
                }
                return str;
            }
            str = "";
            if (str != null) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
