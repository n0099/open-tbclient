package c.a.p0.a.h0.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.v2.q;
import com.baidu.mobads.container.util.AdIconUtil;
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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6013a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f6015f;

        public a(String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6014e = str;
            this.f6015f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (b.class) {
                    c.a.p0.t.d.R(this.f6014e, this.f6015f, true);
                }
                b.c();
            }
        }
    }

    /* renamed from: c.a.p0.a.h0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0219b implements Comparator<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0219b() {
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
        public int compare(Long l, Long l2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l, l2)) == null) ? l2.compareTo(l) : invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1086928271, "Lc/a/p0/a/h0/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1086928271, "Lc/a/p0/a/h0/i/b;");
                return;
            }
        }
        f6013a = k.f7085a;
    }

    public b() {
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

    public static File b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) {
            String f2 = f();
            if (f2 == null) {
                return null;
            }
            File file = new File(f2 + File.separator + j2);
            if (file.exists()) {
                c.a.p0.t.d.K(file);
            }
            c.a.p0.t.d.h(file);
            return file;
        }
        return (File) invokeJ.objValue;
    }

    public static void c() {
        c.a.p0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (Q = c.a.p0.a.a2.e.Q()) == null || TextUtils.isEmpty(Q.getAppId())) {
            return;
        }
        File file = new File(c.a.p0.a.a1.e.g().getPath() + File.separator + "launch_tips");
        if (file.exists() && file.isDirectory()) {
            c.a.p0.t.d.i(file);
        }
    }

    public static File d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j2)) == null) {
            File[] g2 = g();
            if (g2 != null && g2.length != 0) {
                File file = null;
                for (File file2 : g2) {
                    try {
                        long parseLong = Long.parseLong(file2.getName());
                        if (parseLong == j2) {
                            file = file2;
                        } else if (j2 - parseLong >= 259200000) {
                            c.a.p0.t.d.i(file2);
                        }
                    } catch (NumberFormatException unused) {
                        c.a.p0.t.d.i(file2);
                    }
                }
                return file == null ? b(j2) : file;
            }
            return b(j2);
        }
        return (File) invokeJ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            File[] g2 = g();
            if (g2 == null) {
                return null;
            }
            TreeMap treeMap = new TreeMap(new C0219b());
            long i2 = i(System.currentTimeMillis());
            for (File file : g2) {
                try {
                    long parseLong = Long.parseLong(file.getName());
                    if (i2 - parseLong >= 259200000) {
                        c.a.p0.t.d.i(file);
                    } else {
                        List<String> E = c.a.p0.t.d.E(file);
                        if (E != null && E.size() > 0) {
                            treeMap.put(Long.valueOf(parseLong), E);
                        }
                    }
                } catch (NumberFormatException unused) {
                    c.a.p0.t.d.i(file);
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
                        sb.append(StringUtils.LF);
                        sb.append(str);
                    }
                }
            }
            sb.append(StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q == null) {
                return null;
            }
            String appId = Q.getAppId();
            if (TextUtils.isEmpty(appId)) {
                return null;
            }
            return c.a.p0.a.a1.e.g().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
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

    public static void h(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65545, null, j2, str) == null) {
            long i2 = i(j2);
            if (i2 == -1) {
                boolean z = f6013a;
                return;
            }
            File d2 = d(i2);
            if (d2 == null || !d2.exists()) {
                return;
            }
            q.j(new a(str, d2), "saveLaunchTipsLog");
        }
    }

    public static long i(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j2)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            try {
                Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(j2)));
                if (parse == null) {
                    return -1L;
                }
                return parse.getTime();
            } catch (ParseException e2) {
                if (k.f7085a) {
                    e2.printStackTrace();
                }
                return -1L;
            }
        }
        return invokeJ.longValue;
    }
}
