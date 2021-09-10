package c.a.p0.a.x0.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.e;
import c.a.p0.a.k;
import c.a.p0.a.p.d.e0;
import c.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9683a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.x0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0455a implements e0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f9684a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f9685b;

        public C0455a(a aVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9685b = aVar;
            this.f9684a = file;
        }

        @Override // c.a.p0.a.p.d.e0.a
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!k.f7077a) {
                    d.K(this.f9684a);
                }
                a aVar = this.f9685b;
                aVar.p("upload file: done. feedback data = " + str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f9686a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1777433162, "Lc/a/p0/a/x0/a/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1777433162, "Lc/a/p0/a/x0/a/a$b;");
                    return;
                }
            }
            f9686a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1893120376, "Lc/a/p0/a/x0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1893120376, "Lc/a/p0/a/x0/a/a;");
                return;
            }
        }
        f9683a = k.f7077a;
    }

    public /* synthetic */ a(C0455a c0455a) {
        this();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f9686a : (a) invokeV.objValue;
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
            File q = q(str, file, c.a.p0.a.x0.a.d.a.f9697h);
            if (q == null) {
                return false;
            }
            File file2 = new File(c.a.p0.a.x0.a.d.a.f9690a, str);
            if (file2.exists()) {
                File file3 = new File(q, str);
                d.k(file3);
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
            File q = q(str, file, c.a.p0.a.x0.a.d.a.k);
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
            File q = q(str, new File(file, c.a.p0.a.x0.a.d.a.f9698i), "swan_plugin_workspace");
            if (q == null) {
                return false;
            }
            File q2 = e.q();
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
            File q = q(str, file, c.a.p0.a.x0.a.d.a.f9699j);
            if (context == null || q == null) {
                return false;
            }
            return m(context, str, q, new File(c.a.p0.a.k2.h.c.A()), ".kv") | m(context, str, q, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ActivityChooserModel.HISTORY_FILE_EXTENSION);
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
            boolean i2 = i(str, file);
            boolean b2 = b(c.a.p0.a.x0.a.d.a.f9691b, file);
            boolean b3 = b(c.a.p0.a.x0.a.d.a.f9692c, file);
            boolean e2 = e(context, str, file);
            boolean c2 = c(str, file);
            boolean a2 = a(str);
            boolean d2 = d(str, file);
            p("cloneSwanPkg = " + i2 + " ; cloneSwanCore = " + b2 + " ; cloneExtensionCore = " + b3 + " ; cloneSp = " + e2 + " ; cloneDb = " + c2 + " ; cloneAbTest = " + a2 + " ; cloneDynamicLib = " + d2);
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
            File file = new File(c.a.p0.a.x0.a.d.a.f9695f + str);
            if (!l(file)) {
                p("delete old tmp dir failed");
                return null;
            }
            File a2 = c.a.p0.a.x0.a.d.a.a();
            if (a2 == null) {
                p("dest zip dir is null");
                return null;
            }
            File file2 = new File(a2, c.a.p0.a.x0.a.d.a.l);
            if (file2.exists()) {
                d.K(file2);
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
            File q = q(str, file, c.a.p0.a.x0.a.d.a.f9696g);
            if (q == null) {
                return false;
            }
            File file2 = new File(c.a.p0.a.x0.a.d.a.f9690a, str);
            if (file2.exists()) {
                File file3 = new File(q, str);
                d.k(file3);
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
            d.i(file);
            return d.k(file);
        }
        return invokeL.booleanValue;
    }

    public final boolean m(@NonNull Context context, @NonNull String str, @NonNull File file, @Nullable File file2, @NonNull String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048588, this, context, str, file, file2, str2)) == null) {
            if (file2 != null && file2.exists() && file2.isDirectory()) {
                String[] strArr = {"aiapp_" + str, "aiapp_setting_" + str, "searchbox_webapps_sp", "searchbox_sconsole_sp", "aiapp_open_stat", QuickPersistConfig.SP_FILE_STARTUP, "com.baidu.searchbox_aiapp_openstat", "aiapps_favorite", "aiapps_guide_dialog_sp", "key_pms_sp_name", context.getPackageName() + "_preferences", "abtesting"};
                for (int i2 = 0; i2 < 12; i2++) {
                    k(strArr[i2], file2, file, str2);
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
            boolean W = d.W(file.getAbsolutePath(), file2.getAbsolutePath());
            if (W) {
                d.i(file);
            }
            p("zip file status = " + W);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = f9683a;
    }

    public File q(String str, File file, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, file, str2)) == null) {
            if (TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(str2)) {
                return null;
            }
            File file2 = new File(file, str2);
            if (d.k(file2)) {
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
                File file2 = new File(c.a.p0.a.x0.a.d.a.f9690a, str);
                String str2 = (!file2.exists() || (list = file2.list()) == null || list.length <= 0) ? "-1" : list[0];
                p("upload file: ready");
                e0 t = c.a.p0.a.c1.a.t();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("aiappid", str);
                hashMap.put("aiappversion", str2);
                t.c(hashMap, file, new C0455a(this, file));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
