package c.a.p0.a.x0.a.d;

import c.a.p0.a.a1.d;
import c.a.p0.a.o2.b;
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
    public static String f8734b;

    /* renamed from: c  reason: collision with root package name */
    public static String f8735c;

    /* renamed from: d  reason: collision with root package name */
    public static String f8736d;

    /* renamed from: e  reason: collision with root package name */
    public static String f8737e;

    /* renamed from: f  reason: collision with root package name */
    public static String f8738f;

    /* renamed from: g  reason: collision with root package name */
    public static String f8739g;

    /* renamed from: h  reason: collision with root package name */
    public static String f8740h;

    /* renamed from: i  reason: collision with root package name */
    public static String f8741i;

    /* renamed from: j  reason: collision with root package name */
    public static String f8742j;

    /* renamed from: k  reason: collision with root package name */
    public static String f8743k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1777533075, "Lc/a/p0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1777533075, "Lc/a/p0/a/x0/a/d/a;");
                return;
            }
        }
        a = d.g();
        f8734b = "swan_core";
        f8735c = "extension_core";
        f8736d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f8737e = "cloneFolder_";
        f8738f = f8736d + File.separator + f8737e;
        f8739g = "clone_pkg_folder";
        f8740h = "clone_core_folder";
        f8741i = "clone_dynamic_lib_folder";
        f8742j = "clone_sp_folder";
        f8743k = "clone_db_folder";
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
