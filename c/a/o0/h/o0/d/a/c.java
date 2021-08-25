package c.a.o0.h.o0.d.a;

import android.text.TextUtils;
import c.a.o0.a.a2.d;
import c.a.o0.a.a2.e;
import c.a.o0.a.k;
import c.a.o0.h.s.a;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1762353200, "Lc/a/o0/h/o0/d/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1762353200, "Lc/a/o0/h/o0/d/a/c;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    public static PathType a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return PathType.ERROR;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                return PathType.RELATIVE;
            }
            return PathType.NETWORK;
        }
        return (PathType) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        File h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            e r = d.g().r();
            if (r.e() && r.Z() != null && (h2 = a.d.h(r.getAppId(), r.Z())) != null && h2.exists()) {
                return "file://" + h2.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}
