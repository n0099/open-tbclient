package c.a.s0.a.x0.a.d;

import c.a.s0.a.a1.d;
import c.a.s0.a.o2.b;
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
    public static String f9807b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9808c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9809d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9810e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9811f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9812g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9813h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9814i;

    /* renamed from: j  reason: collision with root package name */
    public static String f9815j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(260857200, "Lc/a/s0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(260857200, "Lc/a/s0/a/x0/a/d/a;");
                return;
            }
        }
        a = d.g();
        f9807b = "swan_core";
        f9808c = "extension_core";
        f9809d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9810e = "cloneFolder_";
        f9811f = f9809d + File.separator + f9810e;
        f9812g = "clone_pkg_folder";
        f9813h = "clone_core_folder";
        f9814i = "clone_dynamic_lib_folder";
        f9815j = "clone_sp_folder";
        k = "clone_db_folder";
        l = "cloneZip.zip";
        m = "clone_zipFiles";
    }

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(b.w());
            if (c.a.s0.w.d.l(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
