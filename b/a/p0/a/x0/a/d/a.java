package b.a.p0.a.x0.a.d;

import b.a.p0.a.a1.d;
import b.a.p0.a.o2.b;
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
    public static File f9279a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9280b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9281c;

    /* renamed from: d  reason: collision with root package name */
    public static String f9282d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9283e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9284f;

    /* renamed from: g  reason: collision with root package name */
    public static String f9285g;

    /* renamed from: h  reason: collision with root package name */
    public static String f9286h;

    /* renamed from: i  reason: collision with root package name */
    public static String f9287i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1520361868, "Lb/a/p0/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1520361868, "Lb/a/p0/a/x0/a/d/a;");
                return;
            }
        }
        f9279a = d.g();
        f9280b = "swan_core";
        f9281c = "extension_core";
        f9282d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f9283e = "cloneFolder_";
        f9284f = f9282d + File.separator + f9283e;
        f9285g = "clone_pkg_folder";
        f9286h = "clone_core_folder";
        f9287i = "clone_dynamic_lib_folder";
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
            if (b.a.p0.w.d.l(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
