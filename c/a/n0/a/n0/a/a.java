package c.a.n0.a.n0.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.d.e0;
import c.a.n0.w.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.n0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0379a implements e0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5492b;

        public C0379a(a aVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5492b = aVar;
            this.a = file;
        }

        @Override // c.a.n0.a.f.d.e0.a
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!c.a.n0.a.a.a) {
                    d.L(this.a);
                }
                a aVar = this.f5492b;
                aVar.p("upload file: done. feedback data = " + str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-611741438, "Lc/a/n0/a/n0/a/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-611741438, "Lc/a/n0/a/n0/a/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1858579264, "Lc/a/n0/a/n0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1858579264, "Lc/a/n0/a/n0/a/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public /* synthetic */ a(C0379a c0379a) {
        this();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean b(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            File q = q(str, file, c.a.n0.a.n0.a.d.a.f5500h);
            if (q == null) {
                return false;
            }
            File file2 = new File(c.a.n0.a.n0.a.d.a.a, str);
            if (file2.exists()) {
                File file3 = new File(q, str);
                d.l(file3);
                d.e(file2, file3);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean c(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, file)) == null) {
            File q = q(str, file, c.a.n0.a.n0.a.d.a.k);
            if (q == null) {
                return false;
            }
            j("ai_apps.db", q);
            j("ai_apps_pms.db", q);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean d(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, file)) == null) {
            File q = q(str, new File(file, c.a.n0.a.n0.a.d.a.i), "swan_plugin_workspace");
            if (q == null) {
                return false;
            }
            File q2 = c.a.n0.a.q0.d.q();
            if (q2.exists()) {
                d.e(q2, q);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean e(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, file)) == null) {
            File q = q(str, file, c.a.n0.a.n0.a.d.a.j);
            if (context == null || q == null) {
                return false;
            }
            return m(context, str, q, new File(c.a.n0.a.e2.h.c.e()), SwanKV.PREFS_SUFFIX) | m(context, str, q, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ActivityChooserModel.HISTORY_FILE_EXTENSION);
        }
        return invokeLLL.booleanValue;
    }

    public void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            p("cloneSwanApp: start");
            r(h(context, str), str);
            p("cloneSwanApp: end");
        }
    }

    public final void g(Context context, String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, str, file) == null) {
            boolean i = i(str, file);
            boolean b2 = b(c.a.n0.a.n0.a.d.a.f5494b, file);
            boolean b3 = b(c.a.n0.a.n0.a.d.a.f5495c, file);
            boolean e2 = e(context, str, file);
            boolean c2 = c(str, file);
            boolean a2 = a(str);
            boolean d2 = d(str, file);
            p("cloneSwanPkg = " + i + " ; cloneSwanCore = " + b2 + " ; cloneExtensionCore = " + b3 + " ; cloneSp = " + e2 + " ; cloneDb = " + c2 + " ; cloneAbTest = " + a2 + " ; cloneDynamicLib = " + d2);
        }
    }

    public File h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                p("appKey is empty");
                return null;
            }
            p("cloneFilesAndMakeZip start, appKey = " + str);
            File file = new File(c.a.n0.a.n0.a.d.a.f5498f + str);
            if (!l(file)) {
                p("delete old tmp dir failed");
                return null;
            }
            File a2 = c.a.n0.a.n0.a.d.a.a();
            if (a2 == null) {
                p("dest zip dir is null");
                return null;
            }
            File file2 = new File(a2, c.a.n0.a.n0.a.d.a.l);
            if (file2.exists()) {
                d.L(file2);
            }
            d.h(file2);
            g(context, str, file);
            o(file.getParentFile(), file2);
            p("cloneFilesAndMakeZip end, appKey = " + str);
            return file2;
        }
        return (File) invokeLL.objValue;
    }

    public boolean i(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, file)) == null) {
            File q = q(str, file, c.a.n0.a.n0.a.d.a.f5499g);
            if (q == null) {
                return false;
            }
            File file2 = new File(c.a.n0.a.n0.a.d.a.a, str);
            if (file2.exists()) {
                File file3 = new File(q, str);
                d.l(file3);
                d.e(file2, file3);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void j(String str, File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, file) == null) || TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return;
        }
        File databasePath = AppRuntime.getApplication().getDatabasePath(str);
        if (databasePath.exists()) {
            d.f(databasePath, new File(file, str));
        }
    }

    public final void k(String str, File file, File file2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048586, this, str, file, file2, str2) == null) || TextUtils.isEmpty(str) || file == null || !file.exists() || file2 == null || !file2.exists()) {
            return;
        }
        String str3 = str + str2;
        File file3 = new File(file, str3);
        if (file3.exists()) {
            d.f(file3, new File(file2, str3));
        }
    }

    public boolean l(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, file)) == null) {
            if (file == null) {
                return false;
            }
            d.j(file);
            return d.l(file);
        }
        return invokeL.booleanValue;
    }

    public final boolean m(@NonNull Context context, @NonNull String str, @NonNull File file, @Nullable File file2, @NonNull String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048588, this, context, str, file, file2, str2)) == null) {
            if (file2 != null && file2.exists() && file2.isDirectory()) {
                String[] strArr = {"aiapp_" + str, "aiapp_setting_" + str, "searchbox_webapps_sp", "searchbox_sconsole_sp", "aiapp_open_stat", QuickPersistConfig.SP_FILE_STARTUP, "com.baidu.searchbox_aiapp_openstat", "aiapps_favorite", "aiapps_guide_dialog_sp", "key_pms_sp_name", context.getPackageName() + "_preferences", "abtesting"};
                for (int i = 0; i < 12; i++) {
                    k(strArr[i], file2, file, str2);
                }
                return true;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final void o(File file, File file2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, file, file2) == null) {
            boolean X = d.X(file.getAbsolutePath(), file2.getAbsolutePath());
            if (X) {
                d.j(file);
            }
            p("zip file status = " + X);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && !TextUtils.isEmpty(str) && a) {
            Log.d("SwanAppCloneModule", str);
        }
    }

    public File q(String str, File file, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, file, str2)) == null) {
            if (TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(str2)) {
                return null;
            }
            File file2 = new File(file, str2);
            if (d.l(file2)) {
                return file2;
            }
            return null;
        }
        return (File) invokeLLL.objValue;
    }

    public boolean r(File file, String str) {
        InterceptResult invokeLL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, file, str)) == null) {
            if (file != null && file.exists()) {
                File file2 = new File(c.a.n0.a.n0.a.d.a.a, str);
                String str2 = (!file2.exists() || (list = file2.list()) == null || list.length <= 0) ? "-1" : list[0];
                p("upload file: ready");
                e0 u = c.a.n0.a.s0.a.u();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("aiappid", str);
                hashMap.put("aiappversion", str2);
                u.c(hashMap, file, new C0379a(this, file));
                return true;
            }
            p("no zip file");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
