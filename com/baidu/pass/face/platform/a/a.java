package com.baidu.pass.face.platform.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
    public static HashMap b;
    public static ArrayList c;
    public static HashMap d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-360335294, "Lcom/baidu/pass/face/platform/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-360335294, "Lcom/baidu/pass/face/platform/a/a;");
                return;
            }
        }
        b = new HashMap();
        c = new ArrayList();
        d = new HashMap();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            HashMap hashMap = d;
            if (hashMap != null && !hashMap.containsKey(str)) {
                d.put(str, 1);
                return;
            }
            HashMap hashMap2 = d;
            if (hashMap2 == null || !hashMap2.containsKey(str)) {
                return;
            }
            d.put(str, Integer.valueOf(((Integer) d.get(str)).intValue() + 1));
        }
    }

    public static void a(String str, Object obj) {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, obj) == null) || (hashMap = b) == null || hashMap.containsKey(str)) {
            return;
        }
        b.put(str, obj);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            b = new HashMap();
            c = new ArrayList();
            d = new HashMap();
        }
    }

    public static void b(String str, Object obj) {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, obj) == null) || (hashMap = b) == null) {
            return;
        }
        hashMap.put(str, obj);
    }
}
