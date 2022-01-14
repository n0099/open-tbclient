package c.a.r0.a.x0.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.w.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(766375494, "Lc/a/r0/a/x0/a/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(766375494, "Lc/a/r0/a/x0/a/c$b;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (c) invokeV.objValue;
    }

    public final boolean a(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
            if (file != null && file.exists() && file2 != null) {
                if (!file2.exists()) {
                    d.l(file2);
                }
                String[] list = file.list();
                if (list != null && list.length != 0) {
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str)) {
                            File file3 = new File(file, str);
                            if (file3.exists()) {
                                boolean isFile = file3.isFile();
                                File file4 = new File(file2, str);
                                if (file4.exists()) {
                                    d.j(file4);
                                }
                                if (isFile) {
                                    d.h(file4);
                                    d.f(file3, file4);
                                } else if (file3.isDirectory()) {
                                    d.e(file3, file4);
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean b(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            if (file.exists() && file.isDirectory()) {
                File file2 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
                File file3 = new File(c.a.r0.a.o2.h.c.e());
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    d.l(file2);
                    d.l(file3);
                    File file4 = null;
                    for (File file5 : listFiles) {
                        String name = file5.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (name.endsWith(ActivityChooserModel.HISTORY_FILE_EXTENSION)) {
                                file4 = new File(file2, name);
                            } else if (name.endsWith(SwanKV.PREFS_SUFFIX)) {
                                file4 = new File(file3, name);
                            }
                            if (file4 != null) {
                                if (file4.exists()) {
                                    d.L(file4);
                                }
                                if (file5.isFile()) {
                                    d.h(file4);
                                    d.f(file5, file4);
                                } else {
                                    d.e(file5, file4);
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            return a(new File(file, c.a.r0.a.x0.a.d.a.f9571h), c.a.r0.a.x0.a.d.a.a);
        }
        return invokeLL.booleanValue;
    }

    public boolean f(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            boolean a2 = a(new File(file, c.a.r0.a.x0.a.d.a.k), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "databases"));
            SwanAppDbControl.f(AppRuntime.getAppContext()).p();
            c.a.r0.q.g.e.a.a().release();
            c.a.r0.a.c1.a.g0().F();
            return a2;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            return a(new File(file, c.a.r0.a.x0.a.d.a.f9572i), AppRuntime.getAppContext().getFilesDir());
        }
        return invokeLL.booleanValue;
    }

    public boolean h(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, file)) == null) {
            if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
                return false;
            }
            return b(new File(file, c.a.r0.a.x0.a.d.a.f9573j));
        }
        return invokeLL.booleanValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            c.a.r0.a.x0.a.a.n().p("installSwanApp start, appKey = " + str);
            File a2 = c.a.r0.a.x0.a.d.a.a();
            if (a2 != null && a2.exists()) {
                File file = new File(a2, c.a.r0.a.x0.a.d.a.m);
                if (!file.exists()) {
                    c.a.r0.a.x0.a.a.n().p("installSwanApp clone_zipFiles file not exists");
                    return false;
                }
                File a3 = c.a.r0.a.x0.a.b.a(d.G(file), a2);
                if (a3 != null && a3.exists()) {
                    File file2 = new File(c.a.r0.a.x0.a.d.a.f9567d);
                    if (file2.exists()) {
                        d.L(file2);
                    }
                    if (!d.l(file2)) {
                        c.a.r0.a.x0.a.a.n().p("installSwanApp root cache dir create fail");
                        return false;
                    }
                    boolean z = d.W(a3.getAbsolutePath(), c.a.r0.a.x0.a.d.a.f9567d) == null;
                    if (z) {
                        d.j(file);
                        d.j(a3);
                    }
                    c.a.r0.a.x0.a.a.n().p("unzip file status = " + z);
                    File file3 = new File(c.a.r0.a.x0.a.d.a.f9567d);
                    String[] list = file3.list();
                    if (list != null && list.length != 0) {
                        int length = list.length;
                        int i2 = 0;
                        while (true) {
                            str2 = null;
                            if (i2 >= length) {
                                str3 = null;
                                break;
                            }
                            String str4 = list[i2];
                            if (!TextUtils.isEmpty(str4) && str4.startsWith(c.a.r0.a.x0.a.d.a.f9568e)) {
                                str2 = str4.substring(c.a.r0.a.x0.a.d.a.f9568e.length());
                                str3 = str4;
                                break;
                            }
                            i2++;
                        }
                        if (TextUtils.equals(str, str2) && !TextUtils.isEmpty(str3)) {
                            File file4 = new File(c.a.r0.a.x0.a.d.a.f9567d, str3);
                            boolean j2 = j(str, file4);
                            boolean e2 = e(str, file4);
                            boolean h2 = h(str, file4);
                            boolean f2 = f(str, file4);
                            boolean d2 = d(str);
                            boolean g2 = g(str, file4);
                            c.a.r0.a.x0.a.a.n().p("installSwanPkg = " + j2 + " ; installCore = " + e2 + " ; installSp = " + h2 + " ; installDb = " + f2 + " ; installAbTest = " + d2 + " ; installDynamicLib = " + g2);
                            return d.j(file3);
                        }
                        c.a.r0.a.x0.a.a.n().p("installSwanApp install appKey not match zip file appKey");
                        return false;
                    }
                    c.a.r0.a.x0.a.a.n().p("installSwanApp unzip file length invalid");
                    return false;
                }
                c.a.r0.a.x0.a.a.n().p("installSwanApp cloneZip.zip file not exists");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean j(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            return a(new File(file, c.a.r0.a.x0.a.d.a.f9570g), c.a.r0.a.x0.a.d.a.a);
        }
        return invokeLL.booleanValue;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
