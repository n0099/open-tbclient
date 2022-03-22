package c.a.n0.a.x.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.x.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0536a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f7087b;

        public RunnableC0536a(String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f7087b = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (a.class) {
                    c.a.n0.w.d.S(this.a, this.f7087b, true);
                }
                a.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Comparator<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Long l, Long l2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l, l2)) == null) ? l2.compareTo(l) : invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622827828, "Lc/a/n0/a/x/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622827828, "Lc/a/n0/a/x/i/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
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

    public static File b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            String f2 = f();
            if (f2 == null) {
                return null;
            }
            File file = new File(f2 + File.separator + j);
            if (file.exists()) {
                c.a.n0.w.d.L(file);
            }
            c.a.n0.w.d.h(file);
            return file;
        }
        return (File) invokeJ.objValue;
    }

    public static void c() {
        c.a.n0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null || TextUtils.isEmpty(a0.getAppId())) {
            return;
        }
        File file = new File(c.a.n0.a.q0.d.g().getPath() + File.separator + "launch_tips");
        if (file.exists() && file.isDirectory()) {
            c.a.n0.w.d.j(file);
        }
    }

    public static File d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) {
            File[] g2 = g();
            if (g2 != null && g2.length != 0) {
                File file = null;
                for (File file2 : g2) {
                    try {
                        long parseLong = Long.parseLong(file2.getName());
                        if (parseLong == j) {
                            file = file2;
                        } else if (j - parseLong >= 259200000) {
                            c.a.n0.w.d.j(file2);
                        }
                    } catch (NumberFormatException unused) {
                        c.a.n0.w.d.j(file2);
                    }
                }
                return file == null ? b(j) : file;
            }
            return b(j);
        }
        return (File) invokeJ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            File[] g2 = g();
            if (g2 == null) {
                return null;
            }
            TreeMap treeMap = new TreeMap(new b());
            long i = i(System.currentTimeMillis());
            for (File file : g2) {
                try {
                    long parseLong = Long.parseLong(file.getName());
                    if (i - parseLong >= 259200000) {
                        c.a.n0.w.d.j(file);
                    } else {
                        List<String> F = c.a.n0.w.d.F(file);
                        if (F != null && F.size() > 0) {
                            treeMap.put(Long.valueOf(parseLong), F);
                        }
                    }
                } catch (NumberFormatException unused) {
                    c.a.n0.w.d.j(file);
                }
            }
            if (treeMap.size() == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder("\n（二）历史日志");
            for (Map.Entry entry : treeMap.entrySet()) {
                sb.append("\n----------【");
                sb.append(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(((Long) entry.getKey()).longValue())));
                sb.append("】----------");
                for (String str : (List) entry.getValue()) {
                    if (!TextUtils.isEmpty(str)) {
                        sb.append("\n");
                        sb.append(str);
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                return null;
            }
            String appId = a0.getAppId();
            if (TextUtils.isEmpty(appId)) {
                return null;
            }
            return c.a.n0.a.q0.d.g().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
        }
        return (String) invokeV.objValue;
    }

    public static File[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String f2 = f();
            if (f2 == null) {
                return null;
            }
            File file = new File(f2);
            if (file.exists() && file.isDirectory()) {
                return file.listFiles();
            }
            return null;
        }
        return (File[]) invokeV.objValue;
    }

    public static void h(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65545, null, j, str) == null) {
            long i = i(j);
            if (i == -1) {
                if (a) {
                    Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                    return;
                }
                return;
            }
            File d2 = d(i);
            if (d2 == null || !d2.exists()) {
                return;
            }
            q.k(new RunnableC0536a(str, d2), "saveLaunchTipsLog");
        }
    }

    public static long i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            try {
                Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(j)));
                if (parse == null) {
                    return -1L;
                }
                return parse.getTime();
            } catch (ParseException e2) {
                if (c.a.n0.a.a.a) {
                    e2.printStackTrace();
                }
                return -1L;
            }
        }
        return invokeJ.longValue;
    }
}
