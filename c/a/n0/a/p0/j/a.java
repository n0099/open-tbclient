package c.a.n0.a.p0.j;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k;
import c.a.n0.a.k2.g.h;
import c.a.n0.a.v1.c.c;
import c.a.n0.a.v1.c.f.e;
import c.a.n0.t.d;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7726a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.p0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0341a implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0341a() {
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

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? TextUtils.isDigitsOnly(str) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                long lastModified = file.lastModified();
                long lastModified2 = file2.lastModified();
                if (lastModified == lastModified2) {
                    return 0;
                }
                return lastModified - lastModified2 > 0 ? -1 : 1;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-661112551, "Lc/a/n0/a/p0/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-661112551, "Lc/a/n0/a/p0/j/a;");
                return;
            }
        }
        f7726a = k.f6803a;
    }

    public static void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, bundle) == null) || bundle == null) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            c.a.n0.a.v1.c.a e2 = c.a.n0.a.v1.c.a.e();
            c cVar = new c(18, bundle);
            cVar.f(true);
            e2.h(cVar);
            return;
        }
        String string = bundle.getString("arg_dst_folder");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        b(new File(string), bundle.getLongArray("arg_ignore_vers"));
    }

    public static void b(File file, long... jArr) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, file, jArr) == null) {
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_dst_folder", file.getPath());
                if (jArr != null && jArr.length > 0) {
                    bundle.putLongArray("arg_ignore_vers", jArr);
                }
                a(bundle);
            } else if (file != null && file.exists() && file.isDirectory()) {
                ArrayList arrayList = new ArrayList();
                if (jArr != null) {
                    for (long j2 : jArr) {
                        if (j2 > 0) {
                            arrayList.add(Long.valueOf(j2));
                        }
                    }
                }
                arrayList.addAll(e());
                arrayList.addAll(d(file, 3));
                if (f7726a) {
                    String str = "deleteOldExtensionCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(arrayList.toArray());
                }
                for (File file2 : file.listFiles()) {
                    if (!g(file2, arrayList)) {
                        if (f7726a) {
                            String str2 = "deleteOldExtensionCores deleteFolder: " + file2;
                        }
                        d.K(file2);
                    }
                }
            }
        }
    }

    @NonNull
    public static String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 1 ? "key_is_need_update_game_ext_preset" : "key_is_need_update_preset" : (String) invokeI.objValue;
    }

    public static List<Long> d(File file, int i2) {
        InterceptResult invokeLI;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, file, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 <= 0 || file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles(new C0341a())) == null) {
                return arrayList;
            }
            Arrays.sort(listFiles, new b());
            int min = Math.min(listFiles.length, i2);
            for (int i3 = 0; i3 < min; i3++) {
                try {
                    arrayList.add(Long.valueOf(Long.parseLong(listFiles[i3].getName())));
                } catch (NumberFormatException e2) {
                    c.a.n0.a.e0.d.i("ExtCore-Utils", "get extension version fail", e2);
                }
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public static ArrayList<Long> e() {
        InterceptResult invokeV;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (c.a.n0.a.v1.c.f.c cVar : e.k().q()) {
                SwanAppCores n = cVar.n();
                if (n != null && cVar.H() && (extensionCore = n.getExtensionCore()) != null && !arrayList.contains(Long.valueOf(extensionCore.extensionCoreVersionCode))) {
                    arrayList.add(Long.valueOf(extensionCore.extensionCoreVersionCode));
                }
            }
            if (f7726a) {
                String str = "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            if (i2 == 1) {
                return c.a.n0.a.u1.a.a.y();
            }
            return c.a.n0.a.u1.a.a.x();
        }
        return invokeI.booleanValue;
    }

    public static boolean g(File file, List<Long> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, list)) == null) {
            if (list == null) {
                return false;
            }
            String name = file.getName();
            for (Long l : list) {
                if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? h.a().getBoolean(c(i2), false) : invokeI.booleanValue;
    }

    public static void i(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            h.a().putBoolean(c(i2), z);
        }
    }
}
