package c.a.n0.a.n0.a.d;

import c.a.n0.a.e2.b;
import c.a.n0.a.q0.d;
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
    public static String f5494b;

    /* renamed from: c  reason: collision with root package name */
    public static String f5495c;

    /* renamed from: d  reason: collision with root package name */
    public static String f5496d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5497e;

    /* renamed from: f  reason: collision with root package name */
    public static String f5498f;

    /* renamed from: g  reason: collision with root package name */
    public static String f5499g;

    /* renamed from: h  reason: collision with root package name */
    public static String f5500h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-611641525, "Lc/a/n0/a/n0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-611641525, "Lc/a/n0/a/n0/a/d/a;");
                return;
            }
        }
        a = d.g();
        f5494b = "swan_core";
        f5495c = "extension_core";
        f5496d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f5497e = "cloneFolder_";
        f5498f = f5496d + File.separator + f5497e;
        f5499g = "clone_pkg_folder";
        f5500h = "clone_core_folder";
        i = "clone_dynamic_lib_folder";
        j = "clone_sp_folder";
        k = "clone_db_folder";
        l = "cloneZip.zip";
        m = "clone_zipFiles";
    }

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(b.w());
            if (c.a.n0.w.d.l(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
