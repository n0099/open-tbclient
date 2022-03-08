package c.a.p0.a.n0.a.d;

import c.a.p0.a.e2.b;
import c.a.p0.a.q0.d;
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
    public static String f6535b;

    /* renamed from: c  reason: collision with root package name */
    public static String f6536c;

    /* renamed from: d  reason: collision with root package name */
    public static String f6537d;

    /* renamed from: e  reason: collision with root package name */
    public static String f6538e;

    /* renamed from: f  reason: collision with root package name */
    public static String f6539f;

    /* renamed from: g  reason: collision with root package name */
    public static String f6540g;

    /* renamed from: h  reason: collision with root package name */
    public static String f6541h;

    /* renamed from: i  reason: collision with root package name */
    public static String f6542i;

    /* renamed from: j  reason: collision with root package name */
    public static String f6543j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1622758775, "Lc/a/p0/a/n0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1622758775, "Lc/a/p0/a/n0/a/d/a;");
                return;
            }
        }
        a = d.g();
        f6535b = "swan_core";
        f6536c = "extension_core";
        f6537d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f6538e = "cloneFolder_";
        f6539f = f6537d + File.separator + f6538e;
        f6540g = "clone_pkg_folder";
        f6541h = "clone_core_folder";
        f6542i = "clone_dynamic_lib_folder";
        f6543j = "clone_sp_folder";
        k = "clone_db_folder";
        l = "cloneZip.zip";
        m = "clone_zipFiles";
    }

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(b.w());
            if (c.a.p0.w.d.l(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
