package b.a.p0.c.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f10123a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f10124b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f10125c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1008600389, "Lb/a/p0/c/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1008600389, "Lb/a/p0/c/a/b;");
                return;
            }
        }
        f10123a = b.a.p0.a.c1.a.o().t();
        f10124b = f10123a + "/bdtls";
        f10125c = new byte[]{0, -98};
    }
}
