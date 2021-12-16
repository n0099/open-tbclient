package c.a.q0.a.x0.a.d;

import c.a.q0.a.a1.d;
import c.a.q0.a.o2.b;
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
    public static String f9043b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9044c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9045d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9046e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9047f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9048g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9049h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9050i;

    /* renamed from: j  reason: collision with root package name */
    public static String f9051j;

    /* renamed from: k  reason: collision with root package name */
    public static String f9052k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1271974450, "Lc/a/q0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1271974450, "Lc/a/q0/a/x0/a/d/a;");
                return;
            }
        }
        a = d.g();
        f9043b = "swan_core";
        f9044c = "extension_core";
        f9045d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9046e = "cloneFolder_";
        f9047f = f9045d + File.separator + f9046e;
        f9048g = "clone_pkg_folder";
        f9049h = "clone_core_folder";
        f9050i = "clone_dynamic_lib_folder";
        f9051j = "clone_sp_folder";
        f9052k = "clone_db_folder";
        l = "cloneZip.zip";
        m = "clone_zipFiles";
    }

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(b.w());
            if (c.a.q0.w.d.l(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
