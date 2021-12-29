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
    public static String f9778b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9779c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9780d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9781e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9782f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9783g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9784h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9785i;

    /* renamed from: j  reason: collision with root package name */
    public static String f9786j;

    /* renamed from: k  reason: collision with root package name */
    public static String f9787k;
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
        f9778b = "swan_core";
        f9779c = "extension_core";
        f9780d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9781e = "cloneFolder_";
        f9782f = f9780d + File.separator + f9781e;
        f9783g = "clone_pkg_folder";
        f9784h = "clone_core_folder";
        f9785i = "clone_dynamic_lib_folder";
        f9786j = "clone_sp_folder";
        f9787k = "clone_db_folder";
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
