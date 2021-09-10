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
    public static File f9690a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9691b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9692c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9693d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9694e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9695f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9696g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9697h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9698i;

    /* renamed from: j  reason: collision with root package name */
    public static String f9699j;
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
        f9690a = e.g();
        f9691b = "swan_core";
        f9692c = "extension_core";
        f9693d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9694e = "cloneFolder_";
        f9695f = f9693d + File.separator + f9694e;
        f9696g = "clone_pkg_folder";
        f9697h = "clone_core_folder";
        f9698i = "clone_dynamic_lib_folder";
        f9699j = "clone_sp_folder";
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
