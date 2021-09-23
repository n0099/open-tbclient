package c.a.p0.a.x0.a.d;

import c.a.p0.a.a1.e;
import c.a.p0.a.k2.b;
import c.a.p0.t.d;
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

    /* renamed from: a  reason: collision with root package name */
    public static File f9698a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9699b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9700c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9701d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9702e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9703f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9704g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9705h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9706i;

    /* renamed from: j  reason: collision with root package name */
    public static String f9707j;
    public static String k;
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
        f9698a = e.g();
        f9699b = "swan_core";
        f9700c = "extension_core";
        f9701d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9702e = "cloneFolder_";
        f9703f = f9701d + File.separator + f9702e;
        f9704g = "clone_pkg_folder";
        f9705h = "clone_core_folder";
        f9706i = "clone_dynamic_lib_folder";
        f9707j = "clone_sp_folder";
        k = "clone_db_folder";
        l = "cloneZip.zip";
        m = "clone_zipFiles";
    }

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(b.w());
            if (d.k(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
