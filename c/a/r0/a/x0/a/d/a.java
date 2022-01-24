package c.a.r0.a.x0.a.d;

import c.a.r0.a.a1.d;
import c.a.r0.a.o2.b;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static File a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9707b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9708c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9709d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9710e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9711f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9712g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9713h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9714i;

    /* renamed from: j  reason: collision with root package name */
    public static String f9715j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(766415825, "Lc/a/r0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(766415825, "Lc/a/r0/a/x0/a/d/a;");
                return;
            }
        }
        a = d.g();
        f9707b = "swan_core";
        f9708c = "extension_core";
        f9709d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9710e = "cloneFolder_";
        f9711f = f9709d + File.separator + f9710e;
        f9712g = "clone_pkg_folder";
        f9713h = "clone_core_folder";
        f9714i = "clone_dynamic_lib_folder";
        f9715j = "clone_sp_folder";
        k = "clone_db_folder";
        l = "cloneZip.zip";
        m = "clone_zipFiles";
    }

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(b.w());
            if (c.a.r0.w.d.l(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
