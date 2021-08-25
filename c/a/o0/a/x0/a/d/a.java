package c.a.o0.a.x0.a.d;

import c.a.o0.a.a1.e;
import c.a.o0.a.k2.b;
import c.a.o0.t.d;
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
    public static File f9662a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9663b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9664c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9665d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9666e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9667f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9668g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9669h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9670i;

    /* renamed from: j  reason: collision with root package name */
    public static String f9671j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2011875596, "Lc/a/o0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2011875596, "Lc/a/o0/a/x0/a/d/a;");
                return;
            }
        }
        f9662a = e.g();
        f9663b = "swan_core";
        f9664c = "extension_core";
        f9665d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9666e = "cloneFolder_";
        f9667f = f9665d + File.separator + f9666e;
        f9668g = "clone_pkg_folder";
        f9669h = "clone_core_folder";
        f9670i = "clone_dynamic_lib_folder";
        f9671j = "clone_sp_folder";
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
