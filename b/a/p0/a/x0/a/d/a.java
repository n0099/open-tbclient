package b.a.p0.a.x0.a.d;

import b.a.p0.a.a1.e;
import b.a.p0.a.k2.b;
import b.a.p0.t.d;
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
    public static File f8935a;

    /* renamed from: b  reason: collision with root package name */
    public static String f8936b;

    /* renamed from: c  reason: collision with root package name */
    public static String f8937c;

    /* renamed from: d  reason: collision with root package name */
    public static String f8938d;

    /* renamed from: e  reason: collision with root package name */
    public static String f8939e;

    /* renamed from: f  reason: collision with root package name */
    public static String f8940f;

    /* renamed from: g  reason: collision with root package name */
    public static String f8941g;

    /* renamed from: h  reason: collision with root package name */
    public static String f8942h;

    /* renamed from: i  reason: collision with root package name */
    public static String f8943i;
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
        f8935a = e.g();
        f8936b = "swan_core";
        f8937c = "extension_core";
        f8938d = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
        f8939e = "cloneFolder_";
        f8940f = f8938d + File.separator + f8939e;
        f8941g = "clone_pkg_folder";
        f8942h = "clone_core_folder";
        f8943i = "clone_dynamic_lib_folder";
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
            if (d.k(file)) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }
}
