package c.a.n0.a.x0.a.d;

import c.a.n0.a.a1.e;
import c.a.n0.a.k2.b;
import c.a.n0.t.d;
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
    public static File f9416a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9417b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9418c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9419d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9420e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9421f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9422g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9423h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9424i;

    /* renamed from: j  reason: collision with root package name */
    public static String f9425j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1506316971, "Lc/a/n0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1506316971, "Lc/a/n0/a/x0/a/d/a;");
                return;
            }
        }
        f9416a = e.g();
        f9417b = "swan_core";
        f9418c = "extension_core";
        f9419d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9420e = "cloneFolder_";
        f9421f = f9419d + File.separator + f9420e;
        f9422g = "clone_pkg_folder";
        f9423h = "clone_core_folder";
        f9424i = "clone_dynamic_lib_folder";
        f9425j = "clone_sp_folder";
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
