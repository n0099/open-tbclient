package com.baidu.sofire.b;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.k.k;
import com.baidu.sofire.k.q;
import com.baidu.sofire.k.t;
import com.baidu.sofire.k.u;
import com.baidu.sofire.rp.Report;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.i1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public static b d;
    public static Context e;
    public static int f;
    public static List<Integer> g;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public com.baidu.sofire.j.a b;
    public com.baidu.sofire.c.a c;

    /* renamed from: com.baidu.sofire.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0174b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ b b;

        /* renamed from: com.baidu.sofire.b.b$b$a */
        /* loaded from: classes4.dex */
        public class a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;
            public final /* synthetic */ ApkInfo b;
            public final /* synthetic */ File c;
            public final /* synthetic */ RunnableC0174b d;

            public a(RunnableC0174b runnableC0174b, i iVar, ApkInfo apkInfo, File file) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0174b, iVar, apkInfo, file};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = runnableC0174b;
                this.a = iVar;
                this.b = apkInfo;
                this.c = file;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ApkInfo b;
                String str;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b = this.a.b(this.d.a)) != null && (str = b.versionName) != null && str.equals(this.b.versionName)) {
                    this.a.d(this.d.a);
                    RunnableC0174b runnableC0174b = this.d;
                    runnableC0174b.b.c.a(runnableC0174b.a);
                    com.baidu.sofire.k.b.p(b.e);
                    File file = new File(this.b.pkgPath);
                    if (file.exists()) {
                        com.baidu.sofire.a.c.a(file);
                        file.delete();
                    }
                    if (this.c.exists()) {
                        File file2 = this.c;
                        File file3 = new File(file2, this.b.key + "." + this.b.versionName + ".b");
                        if (com.baidu.sofire.k.b.a(file3)) {
                            file3.delete();
                        }
                    }
                    if (file.getParentFile() != null) {
                        com.baidu.sofire.k.b.d(file.getParentFile().getAbsolutePath());
                    }
                }
            }
        }

        public RunnableC0174b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            i a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (TextUtils.isEmpty(this.a) || (a2 = i.a(b.e.getApplicationContext())) == null) {
                        return;
                    }
                    ApkInfo b = a2.b(this.a);
                    if (b == null) {
                        ApkInfo b2 = this.b.c.b(this.a);
                        if (b2 == null) {
                            return;
                        }
                        File parentFile = new File(b2.pkgPath).getParentFile();
                        if (parentFile.exists()) {
                            File file = new File(parentFile, b2.key + "." + b2.versionName + ".b");
                            if (com.baidu.sofire.k.b.a(file)) {
                                file.delete();
                            }
                        }
                        b bVar = this.b;
                        String str = this.a;
                        String str2 = b2.pkgPath;
                        bVar.getClass();
                        bVar.c.a(str);
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            com.baidu.sofire.a.c.a(file2);
                            file2.delete();
                            if (file2.getParentFile() != null) {
                                com.baidu.sofire.k.b.d(file2.getParentFile().getAbsolutePath());
                            }
                        }
                        String canonicalPath = new File(b.e.getFilesDir(), "sofire_tmp").getCanonicalPath();
                        com.baidu.sofire.k.b.d(canonicalPath + i1.j + b2.key);
                        com.baidu.sofire.k.b.d(b.e.getFileStreamPath(b2.packageName).getAbsolutePath());
                        return;
                    }
                    File parentFile2 = new File(b.pkgPath).getParentFile();
                    Class<?> a3 = ((h) b.classLoader).a(com.baidu.sofire.k.b.b(b.es));
                    Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, b.e);
                    if (invoke == null) {
                        return;
                    }
                    new Timer().schedule(new a(this, a2, b, parentFile2), 600000L);
                    com.baidu.sofire.k.b.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                    a2.d(this.a);
                    this.b.c.a(this.a);
                    com.baidu.sofire.k.b.p(b.e);
                    File file3 = new File(b.pkgPath);
                    if (file3.exists()) {
                        com.baidu.sofire.a.c.a(file3);
                        file3.delete();
                    }
                    if (parentFile2.exists()) {
                        File file4 = new File(parentFile2, b.key + "." + b.versionName + ".b");
                        if (com.baidu.sofire.k.b.a(file4)) {
                            file4.delete();
                        }
                    }
                    if (file3.getParentFile() != null) {
                        com.baidu.sofire.k.b.d(file3.getParentFile().getAbsolutePath());
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Comparator<ApkInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public a(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(ApkInfo apkInfo, ApkInfo apkInfo2) {
            InterceptResult invokeLL;
            int i;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, apkInfo, apkInfo2)) == null) {
                ApkInfo apkInfo3 = apkInfo;
                ApkInfo apkInfo4 = apkInfo2;
                int i4 = apkInfo3.priority;
                if (i4 != -1 || apkInfo4.priority == -1) {
                    if ((i4 != -1 && apkInfo4.priority == -1) || i4 < (i = apkInfo4.priority)) {
                        return -1;
                    }
                    if (i4 <= i) {
                        List list = this.a;
                        if (list != null && list.contains(Integer.valueOf(apkInfo3.key))) {
                            i2 = this.a.indexOf(Integer.valueOf(apkInfo3.key));
                        } else {
                            i2 = -1;
                        }
                        List list2 = this.a;
                        if (list2 != null && list2.contains(Integer.valueOf(apkInfo4.key))) {
                            i3 = this.a.indexOf(Integer.valueOf(apkInfo4.key));
                        } else {
                            i3 = -1;
                        }
                        if (i2 != -1 && i3 == -1) {
                            return -1;
                        }
                        if ((i2 != -1 || i3 == -1) && i2 <= i3) {
                            if (i2 < i3) {
                                return -1;
                            }
                            return 0;
                        }
                    }
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2073990773, "Lcom/baidu/sofire/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2073990773, "Lcom/baidu/sofire/b/b;");
                return;
            }
        }
        g = new ArrayList();
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        Context applicationContext = context.getApplicationContext();
        e = applicationContext;
        this.c = com.baidu.sofire.c.a.a(applicationContext);
        com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(e);
        this.b = a2;
        SharedPreferences g2 = a2.g();
        if (g2 != null) {
            g2.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public void c(String str) {
        i iVar;
        ApkInfo b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (iVar = i.g) == null || (b = iVar.b(str)) == null) {
                    return;
                }
                Class<?> a2 = ((h) b.classLoader).a(com.baidu.sofire.k.b.b(b.es));
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, e);
                if (invoke == null) {
                    return;
                }
                com.baidu.sofire.k.b.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                iVar.d(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized b a(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b(context.getApplicationContext());
                }
                bVar = d;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65539, null, i) == null) && f == 0) {
            f = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8 A[Catch: all -> 0x0117, IllegalArgumentException -> 0x012f, IllegalAccessException -> 0x0147, InvocationTargetException -> 0x015f, NoSuchMethodException -> 0x0176, TRY_LEAVE, TryCatch #7 {NoSuchMethodException -> 0x0176, blocks: (B:16:0x005a, B:18:0x005f, B:21:0x0075, B:23:0x007b, B:26:0x0091, B:28:0x0095, B:31:0x00ab, B:41:0x00c8, B:44:0x00df, B:46:0x00f5, B:34:0x00b3, B:36:0x00bb), top: B:90:0x005a, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df A[Catch: all -> 0x0117, IllegalArgumentException -> 0x012f, IllegalAccessException -> 0x0147, InvocationTargetException -> 0x015f, NoSuchMethodException -> 0x0176, TRY_ENTER, TRY_LEAVE, TryCatch #7 {NoSuchMethodException -> 0x0176, blocks: (B:16:0x005a, B:18:0x005f, B:21:0x0075, B:23:0x007b, B:26:0x0091, B:28:0x0095, B:31:0x00ab, B:41:0x00c8, B:44:0x00df, B:46:0x00f5, B:34:0x00b3, B:36:0x00bb), top: B:90:0x005a, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            } else {
                str2 = " ";
            }
            hashMap.put("1", str2);
            hashMap.put("2", "1");
            if (Math.random() > 0.9d) {
                com.baidu.sofire.k.b.a(e, "1003136", (Map<String, Object>) hashMap, true);
            }
            if (TextUtils.isEmpty(str)) {
                hashMap.put("3", "1");
                com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                return new Pair<>(1, null);
            }
            try {
                try {
                    try {
                        try {
                            i iVar = i.g;
                            if (iVar == null) {
                                Pair<Integer, Object> pair = new Pair<>(3, null);
                                try {
                                    hashMap.put("3", Integer.toString(4));
                                    com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                } catch (Throwable unused) {
                                }
                                return pair;
                            } else if (iVar.b(i)) {
                                Pair<Integer, Object> pair2 = new Pair<>(3, null);
                                try {
                                    hashMap.put("3", Integer.toString(2));
                                    com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                } catch (Throwable unused2) {
                                }
                                return pair2;
                            } else if (!this.a) {
                                Pair<Integer, Object> pair3 = new Pair<>(3, null);
                                try {
                                    hashMap.put("3", Integer.toString(3));
                                    com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                } catch (Throwable unused3) {
                                }
                                return pair3;
                            } else {
                                ApkInfo a2 = iVar.a(i);
                                if (a2 == null && ((a2 = this.c.b(i)) == null || iVar.b(a2.packageName) == null)) {
                                    z = false;
                                    if (z) {
                                        Pair<Integer, Object> pair4 = new Pair<>(4, null);
                                        try {
                                            hashMap.put("3", Integer.toString(5));
                                            com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                        } catch (Throwable unused4) {
                                        }
                                        return pair4;
                                    }
                                    ApkInfo b = iVar.b(a2.packageName);
                                    Class<?> a3 = ((h) b.classLoader).a(com.baidu.sofire.k.b.b(b.es));
                                    return new Pair<>(0, com.baidu.sofire.k.b.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, e), str, clsArr, objArr));
                                }
                                z = true;
                                if (z) {
                                }
                            }
                        } catch (NoSuchMethodException unused5) {
                            Pair<Integer, Object> pair5 = new Pair<>(2, null);
                            try {
                                hashMap.put("3", Integer.toString(6));
                                com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                            } catch (Throwable unused6) {
                            }
                            return pair5;
                        }
                    } catch (IllegalAccessException unused7) {
                        Pair<Integer, Object> pair6 = new Pair<>(2, null);
                        try {
                            hashMap.put("3", Integer.toString(8));
                            com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                        } catch (Throwable unused8) {
                        }
                        return pair6;
                    }
                } catch (IllegalArgumentException unused9) {
                    Pair<Integer, Object> pair7 = new Pair<>(2, null);
                    try {
                        hashMap.put("3", Integer.toString(9));
                        com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                    } catch (Throwable unused10) {
                    }
                    return pair7;
                } catch (InvocationTargetException unused11) {
                    Pair<Integer, Object> pair8 = new Pair<>(2, null);
                    try {
                        hashMap.put("3", Integer.toString(7));
                        com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, true);
                    } catch (Throwable unused12) {
                    }
                    return pair8;
                }
            }
        } else {
            return (Pair) invokeCommon.objValue;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.a) {
                    this.a = true;
                    q.f(e);
                    com.baidu.sofire.k.b.m(e);
                    this.b.a(true);
                    JSONObject n = com.baidu.sofire.k.b.n(e);
                    if (n == null) {
                        k.a = this.b.a.getBoolean("s_n_m_c_s", true);
                    }
                    Context context = e;
                    if (!TextUtils.isEmpty("3.6.0.4")) {
                        Report report = Report.getInstance(context);
                        try {
                            com.baidu.sofire.k.b.p(context);
                            report.i("sofire", "com.baidu.sofire", "3.6.0.4", "1003003", "1003002");
                        } catch (Throwable unused) {
                        }
                    }
                    com.baidu.sofire.j.a aVar = this.b;
                    aVar.b.putString("ssv", "3.6.0.4");
                    aVar.b.commit();
                    Report.getInstance(e).n();
                    Iterator it = ((ArrayList) this.c.b()).iterator();
                    while (true) {
                        String str = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        ApkInfo apkInfo = (ApkInfo) it.next();
                        try {
                            str = new File(e.getFilesDir(), "sofire_tmp").getCanonicalPath();
                        } catch (IOException unused2) {
                            int i = com.baidu.sofire.a.b.a;
                        }
                        if (str != null) {
                            apkInfo.dataDir = str + i1.j + apkInfo.key;
                            StringBuilder sb = new StringBuilder();
                            sb.append(apkInfo.dataDir);
                            sb.append("/lib");
                            com.baidu.sofire.k.b.d(sb.toString());
                        }
                    }
                    this.c.a();
                    if (!this.b.a.getBoolean("iio", false)) {
                        com.baidu.sofire.j.a aVar2 = this.b;
                        aVar2.b.putBoolean("iio", true);
                        aVar2.b.commit();
                    } else {
                        com.baidu.sofire.c.a aVar3 = this.c;
                        aVar3.getClass();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("n", (Integer) 0);
                        try {
                            aVar3.b.update("pgn", contentValues, "n=-1", null);
                        } catch (Throwable unused3) {
                            int i2 = com.baidu.sofire.a.b.a;
                        }
                    }
                    u.a(e).b(new U(e, 1, false, n));
                }
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            try {
                ApkInfo b = this.c.b(i);
                if (b == null) {
                    return;
                }
                this.c.a(i);
                File file = new File(b.pkgPath);
                if (file.exists()) {
                    com.baidu.sofire.a.c.a(file);
                    file.delete();
                    if (file.getParentFile() != null) {
                        com.baidu.sofire.k.b.d(file.getParentFile().getAbsolutePath());
                    }
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x01e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        String str2;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, callback, clsArr, objArr}) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", Integer.toString(i));
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                } else {
                    str2 = " ";
                }
                hashMap.put("1", str2);
                hashMap.put("2", "0");
                if (Math.random() > 0.9d) {
                    com.baidu.sofire.k.b.a(e, "1003136", (Map<String, Object>) hashMap, true);
                }
                if (TextUtils.isEmpty(str)) {
                    if (callback != null) {
                        callback.onError(1);
                    }
                    hashMap.put("3", "11");
                    com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, false);
                    return;
                }
                try {
                    if (callback != null) {
                        try {
                            try {
                                try {
                                    try {
                                        callback.onBegin(new Object[0]);
                                    } catch (IllegalArgumentException unused) {
                                        if (callback != null) {
                                            try {
                                                callback.onError(2);
                                            } catch (Throwable th) {
                                                th = th;
                                                i2 = 17;
                                                if (i2 != 0) {
                                                }
                                                throw th;
                                            }
                                        }
                                        hashMap.put("3", Integer.toString(17));
                                        com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, false);
                                        return;
                                    }
                                } catch (NoSuchMethodException unused2) {
                                    if (callback != null) {
                                        try {
                                            callback.onError(2);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            i2 = 14;
                                            if (i2 != 0) {
                                                try {
                                                    hashMap.put("3", Integer.toString(i2));
                                                    com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, false);
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    hashMap.put("3", Integer.toString(14));
                                    com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, false);
                                    return;
                                }
                            } catch (IllegalAccessException unused4) {
                                if (callback != null) {
                                    try {
                                        callback.onError(2);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        i2 = 16;
                                        if (i2 != 0) {
                                        }
                                        throw th;
                                    }
                                }
                                hashMap.put("3", Integer.toString(16));
                                com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, false);
                                return;
                            }
                        } catch (InvocationTargetException unused5) {
                            if (callback != null) {
                                try {
                                    callback.onError(2);
                                } catch (Throwable th4) {
                                    th = th4;
                                    i2 = 15;
                                    if (i2 != 0) {
                                    }
                                    throw th;
                                }
                            }
                            hashMap.put("3", Integer.toString(15));
                            com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        }
                    }
                    i a2 = i.a(e.getApplicationContext());
                    if (a2.b(i)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (a2.b(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                            SystemClock.sleep(300L);
                        }
                    }
                    if (a2.b(i)) {
                        if (callback != null) {
                            callback.onError(3);
                        }
                        try {
                            hashMap.put("3", Integer.toString(12));
                            com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused6) {
                            return;
                        }
                    }
                    if (!this.a) {
                        b(3);
                        a();
                    }
                    ApkInfo apkInfo = null;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    while (System.currentTimeMillis() - currentTimeMillis2 <= 15000) {
                        apkInfo = a2.a(i);
                        if (apkInfo == null) {
                            apkInfo = this.c.b(i);
                            if (apkInfo != null) {
                                if (a2.b(apkInfo.packageName) == null) {
                                    if (apkInfo.initStatus == -1) {
                                        break;
                                    }
                                }
                            }
                            if (U.sFinishOnce) {
                                break;
                                break;
                            }
                            SystemClock.sleep(1000L);
                        }
                        z = true;
                    }
                    z = false;
                    if (!z) {
                        if (callback != null) {
                            callback.onError(4);
                        }
                        try {
                            hashMap.put("3", Integer.toString(13));
                            com.baidu.sofire.k.b.a(e, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused7) {
                            return;
                        }
                    }
                    ApkInfo b = a2.b(apkInfo.packageName);
                    Class<?> a3 = ((h) b.classLoader).a(com.baidu.sofire.k.b.b(b.es));
                    Object a4 = com.baidu.sofire.k.b.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, e), str, clsArr, objArr);
                    if (callback != null) {
                        callback.onEnd(a4);
                    }
                } catch (Throwable unused8) {
                }
            } catch (Throwable unused9) {
                int i3 = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IF, IF, IF, NOP, INVOKE, IF, NOP] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01dc, code lost:
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i, String str, String str2, String str3, PackageInfo packageInfo) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        File file;
        ApkInfo b;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, str2, str3, packageInfo}) == null) {
            try {
                ApkInfo b2 = this.c.b(i);
                if (b2 != null) {
                    if (!com.baidu.sofire.k.b.b(str, b2.versionName)) {
                        return;
                    }
                    a(i);
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            File file2 = null;
            InputStream inputStream2 = null;
            try {
                if (!TextUtils.isEmpty(str)) {
                    File file3 = new File(new File(e.getFilesDir(), "sofire_tmp"), ".tmp");
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    File file4 = new File(file3, t.a());
                    if (!file4.exists()) {
                        file4.mkdirs();
                    }
                    file = new File(file4, i + "." + str + ".p");
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            inputStream2 = e.getAssets().open(String.valueOf(i));
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            boolean z = true;
                            com.baidu.sofire.k.b.a(file.getAbsolutePath(), true);
                            String a3 = com.baidu.sofire.k.j.a(file);
                            if (a3 != null && a3.equalsIgnoreCase(str2)) {
                                ApkInfo apkInfo = new ApkInfo(i, str, file.getAbsolutePath());
                                apkInfo.apkMD5 = a3;
                                apkInfo.priority = 1;
                                apkInfo.es = str3;
                                this.c.a(apkInfo);
                                if (this.c.c(i) == 3) {
                                    z = false;
                                }
                                if (this.b.n() && z) {
                                    File file5 = new File(file.getParentFile(), i + "." + str + ".b");
                                    if (!com.baidu.sofire.k.b.a(file5)) {
                                        com.baidu.sofire.a.a.a(file, file5);
                                    }
                                    com.baidu.sofire.a.c.a(e, i, file, file5);
                                } else {
                                    File parentFile = file.getParentFile();
                                    if (parentFile.exists()) {
                                        File file6 = new File(parentFile, i + "." + str + ".b");
                                        if (com.baidu.sofire.k.b.a(file6)) {
                                            com.baidu.sofire.a.c.a(file6);
                                            file6.delete();
                                        }
                                    }
                                }
                            }
                            file.delete();
                            if (file.getParentFile() != null) {
                                com.baidu.sofire.k.b.d(file.getParentFile().getAbsolutePath());
                            }
                            try {
                                inputStream2.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (IOException unused3) {
                                return;
                            }
                        } catch (Throwable unused4) {
                            inputStream = null;
                            file2 = file;
                            try {
                                int i3 = com.baidu.sofire.a.b.a;
                                if (file2 != null && file2.exists()) {
                                    com.baidu.sofire.a.c.a(file2);
                                    this.c.a(i);
                                    file2.delete();
                                    if (file2.getParentFile() != null) {
                                        com.baidu.sofire.k.b.d(file2.getParentFile().getAbsolutePath());
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            return;
                                        } catch (IOException unused6) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                                if (fileOutputStream == null) {
                                    return;
                                }
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException unused7) {
                                    return;
                                }
                            } finally {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused8) {
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused9) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused10) {
                        inputStream = null;
                        fileOutputStream = null;
                    }
                } else {
                    file = null;
                    fileOutputStream = null;
                }
                b = this.c.b(i);
            } catch (Throwable unused11) {
                inputStream = null;
                fileOutputStream = null;
            }
            if (b != null && com.baidu.sofire.k.b.e(b.pkgPath)) {
                synchronized (this) {
                    a2 = a(i, str, false, packageInfo);
                }
                if (a2) {
                    g.add(Integer.valueOf(i));
                    com.baidu.sofire.j.a aVar = this.b;
                    aVar.b.putString("g_l_l_p_v_" + i, str);
                    aVar.b.commit();
                } else if (file != null && file.exists()) {
                    com.baidu.sofire.a.c.a(file);
                    this.c.a(i);
                    file.delete();
                    if (file.getParentFile() != null) {
                        com.baidu.sofire.k.b.d(file.getParentFile().getAbsolutePath());
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused12) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException unused13) {
                            return;
                        }
                    }
                    return;
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused14) {
                    }
                }
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
                return;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused15) {
                }
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if ("3".equals(str) && "925fc15df8a49bed0b3eca8d2b44cb7b".equals(str2)) {
                        return;
                    }
                    com.baidu.sofire.k.b.b = str;
                    com.baidu.sofire.k.b.c = str2;
                    com.baidu.sofire.j.a aVar = this.b;
                    SharedPreferences.Editor editor = aVar.b;
                    editor.putString("svi_n", str + "-" + str2);
                    aVar.b.commit();
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if ("3".equals(str) && "925fc15df8a49bed0b3eca8d2b44cb7b".equals(str2)) {
                        return;
                    }
                    com.baidu.sofire.j.a aVar = this.b;
                    SharedPreferences.Editor editor = aVar.b;
                    editor.putString("svi", str + "-" + str2);
                    aVar.b.commit();
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void a(JSONObject jSONObject) {
        String str;
        String str2;
        PackageInfo packageInfo;
        HashMap<Integer, ApkInfo> hashMap;
        ApkInfo apkInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("6");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("errno");
                int optInt2 = optJSONObject.optInt("l");
                if (optInt == 1) {
                    try {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("detail");
                        str = optJSONObject2.optString("es");
                        try {
                            PackageInfo packageInfo2 = new PackageInfo();
                            packageInfo2.packageName = optJSONObject2.optString("p");
                            packageInfo2.versionName = optJSONObject2.optString("v");
                            ApplicationInfo applicationInfo = new ApplicationInfo();
                            String optString = optJSONObject2.optString("n");
                            applicationInfo.className = optString;
                            if (!TextUtils.isEmpty(optString) && applicationInfo.className.startsWith(".")) {
                                applicationInfo.className = packageInfo2.packageName + applicationInfo.className;
                            }
                            applicationInfo.theme = optJSONObject2.optInt("t");
                            packageInfo2.applicationInfo = applicationInfo;
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("a");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                    if (jSONObject2 != null) {
                                        ActivityInfo activityInfo = new ActivityInfo();
                                        String optString2 = jSONObject2.optString("n");
                                        activityInfo.name = optString2;
                                        if (!TextUtils.isEmpty(optString2) && activityInfo.name.startsWith(".")) {
                                            activityInfo.name = packageInfo2.packageName + activityInfo.name;
                                        }
                                        activityInfo.packageName = packageInfo2.packageName;
                                        activityInfo.theme = jSONObject2.optInt("t");
                                        activityInfo.labelRes = jSONObject2.optInt("l");
                                        if (!TextUtils.isEmpty(activityInfo.name)) {
                                            arrayList.add(activityInfo);
                                        }
                                    }
                                }
                                if (arrayList.size() > 0) {
                                    packageInfo2.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                                }
                            }
                            str2 = str;
                            packageInfo = packageInfo2;
                        } catch (Throwable unused) {
                            int i3 = com.baidu.sofire.a.b.a;
                            str2 = str;
                            packageInfo = null;
                            hashMap = com.baidu.sofire.k.b.o;
                            if (hashMap != null) {
                                a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, str2, packageInfo);
                            }
                        }
                    } catch (Throwable unused2) {
                        str = "";
                    }
                    hashMap = com.baidu.sofire.k.b.o;
                    if (hashMap != null && (apkInfo = hashMap.get(Integer.valueOf(optInt2))) != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                        a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, str2, packageInfo);
                    }
                }
            }
            HashMap<Integer, ApkInfo> hashMap2 = com.baidu.sofire.k.b.o;
            if (hashMap2 != null) {
                hashMap2.clear();
                com.baidu.sofire.k.b.o = null;
            }
        } catch (Throwable unused3) {
            int i4 = com.baidu.sofire.a.b.a;
        }
    }

    public synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        InterceptResult invokeILL;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, str, packageInfo)) == null) {
            synchronized (this) {
                a2 = a(i, str, false, (PackageInfo) null);
            }
            return a2;
        }
        return invokeILL.booleanValue;
    }

    public final synchronized boolean a(int i, String str, boolean z, PackageInfo packageInfo) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), packageInfo})) == null) {
            synchronized (this) {
                if (z) {
                    try {
                        if (this.c.d(i) != 1) {
                            return false;
                        }
                    } catch (Throwable unused) {
                        int i2 = com.baidu.sofire.a.b.a;
                        return false;
                    }
                }
                ApkInfo b = this.c.b(i);
                if (b == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", i + "");
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.k.b.a(e, "1003105", (Map<String, Object>) hashMap, false);
                    }
                    return false;
                } else if (!com.baidu.sofire.k.b.a(new File(b.pkgPath))) {
                    this.c.c(i, -1);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", 3);
                    hashMap2.put("1", i + "");
                    hashMap2.put("2", str);
                    if (!z) {
                        com.baidu.sofire.k.b.a(e, "1003105", (Map<String, Object>) hashMap2, false);
                    }
                    return false;
                } else {
                    if (packageInfo != null) {
                        b.cloudPkgInfo = packageInfo;
                    }
                    i a2 = i.a(e.getApplicationContext());
                    if (!a2.a(b, false)) {
                        this.c.c(i, -1);
                        a2.c(b.pkgPath);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("0", 4);
                        hashMap3.put("1", i + "");
                        hashMap3.put("2", str);
                        if (!z) {
                            com.baidu.sofire.k.b.a(e, "1003105", (Map<String, Object>) hashMap3, false);
                        }
                        return false;
                    }
                    String str4 = "com.baidu.sofire.engine.EngineImpl";
                    String str5 = "setSecurityVerifyInfo";
                    String str6 = "init";
                    if (!TextUtils.isEmpty(b.es)) {
                        String[] split = b.es.split("#");
                        if (split.length >= 4) {
                            if (split[1].startsWith("c")) {
                                str4 = split[1].substring(1);
                            }
                            if (split[2].startsWith("m")) {
                                str5 = split[2].substring(1);
                            }
                            if (split[3].startsWith("m")) {
                                str6 = split[3].substring(1);
                            }
                        }
                    }
                    String[] o = com.baidu.sofire.k.b.o(e);
                    if (o.length == 2 && !TextUtils.isEmpty(o[0]) && !TextUtils.isEmpty(o[1])) {
                        str2 = o[0];
                        str3 = o[1];
                    } else {
                        str2 = "3";
                        str3 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                    }
                    ApkInfo apkInfo = a2.c.get(b.pkgPath);
                    h hVar = (h) apkInfo.classLoader;
                    Class<?> a3 = hVar.a(str4);
                    if (a3 == null) {
                        Class<?> a4 = hVar.a("java.lang.String");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("0", 9);
                        hashMap4.put("1", i + "");
                        hashMap4.put("2", str);
                        hashMap4.put("3", Base64.encodeToString(("classloader=" + hVar + ",StringClass=" + a4).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                        if (!z) {
                            com.baidu.sofire.k.b.a(e, "1003105", (Map<String, Object>) hashMap4, false);
                        }
                        this.c.c(i, -1);
                        return false;
                    }
                    Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, e);
                    com.baidu.sofire.k.b.a(invoke, str5, new Class[]{String.class, String.class}, str2, str3);
                    if (!((Boolean) com.baidu.sofire.k.b.a(invoke, str6, new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.TRUE)).booleanValue()) {
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("0", 6);
                        hashMap5.put("1", i + "");
                        hashMap5.put("2", str);
                        if (!z) {
                            com.baidu.sofire.k.b.a(e, "1003105", (Map<String, Object>) hashMap5, false);
                        }
                        this.c.c(i, -1);
                        a2.c(apkInfo.pkgPath);
                        return false;
                    }
                    apkInfo.initStatus = 1;
                    apkInfo.apkParseSuc = 1;
                    this.c.a(apkInfo);
                    int c = this.c.c(apkInfo.key);
                    if (c < 3 && c != -1) {
                        this.c.b(apkInfo.key, c + 1);
                    }
                    HashMap hashMap6 = new HashMap();
                    hashMap6.put("0", 0);
                    hashMap6.put("1", Integer.valueOf(i));
                    hashMap6.put("2", str);
                    if (!z) {
                        com.baidu.sofire.k.b.a(e, "1003105", (Map<String, Object>) hashMap6, false);
                    }
                    com.baidu.sofire.k.b.p(e);
                    return true;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.c.a();
            this.a = true;
            try {
                i a3 = i.a(e);
                if (a3 != null) {
                    if (a3.b(str) != null) {
                        return true;
                    }
                    if (this.c == null) {
                        this.c = com.baidu.sofire.c.a.a(e);
                    }
                    ApkInfo b = this.c.b(str);
                    if (b != null) {
                        if (this.b.n()) {
                            File file = new File(b.pkgPath);
                            File parentFile = file.getParentFile();
                            File file2 = new File(parentFile, b.key + "." + b.versionName + ".b");
                            if (!com.baidu.sofire.k.b.a(file2)) {
                                com.baidu.sofire.a.a.a(file, file2);
                            }
                            com.baidu.sofire.a.c.a(e, b.key, file, file2);
                        }
                        int i = b.key;
                        String str2 = b.versionName;
                        synchronized (this) {
                            a2 = a(i, str2, false, (PackageInfo) null);
                        }
                        if (a2) {
                            return true;
                        }
                    }
                    if (a3.b(str) != null) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        ApkInfo apkInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                List<ApkInfo> b = this.c.b();
                List<Integer> f2 = this.b.f();
                List<Integer> e2 = this.b.e();
                int i = 0;
                while (true) {
                    ArrayList arrayList = (ArrayList) e2;
                    if (i >= arrayList.size()) {
                        break;
                    }
                    ArrayList arrayList2 = (ArrayList) f2;
                    if (!arrayList2.contains(arrayList.get(i))) {
                        arrayList2.add(arrayList.get(i));
                    }
                    i++;
                }
                Collections.sort(b, new a(this, f2));
                Iterator it = ((ArrayList) b).iterator();
                while (it.hasNext()) {
                    ApkInfo apkInfo2 = (ApkInfo) it.next();
                    i iVar = i.g;
                    if (iVar != null) {
                        apkInfo = iVar.b(apkInfo2.packageName);
                    } else {
                        apkInfo = null;
                    }
                    if (apkInfo == null) {
                        if (this.c.c(apkInfo2.key) == 3) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (this.b.n() && z) {
                            File file = new File(apkInfo2.pkgPath);
                            File file2 = new File(file.getParentFile(), apkInfo2.key + "." + apkInfo2.versionName + ".b");
                            if (!com.baidu.sofire.k.b.a(file2)) {
                                com.baidu.sofire.a.a.a(file, file2);
                            }
                            com.baidu.sofire.a.c.a(e, apkInfo2.key, file, file2);
                        } else {
                            File parentFile = new File(apkInfo2.pkgPath).getParentFile();
                            if (parentFile.exists()) {
                                File file3 = new File(parentFile, apkInfo2.key + "." + apkInfo2.versionName + ".b");
                                if (com.baidu.sofire.k.b.a(file3)) {
                                    com.baidu.sofire.a.c.a(file3);
                                    file3.delete();
                                }
                            }
                        }
                        int i2 = apkInfo2.key;
                        String str = apkInfo2.versionName;
                        synchronized (this) {
                            a(i2, str, false, (PackageInfo) null);
                        }
                    }
                }
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            try {
                u.a(e).a(new RunnableC0174b(this, str));
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, sharedPreferences, str) == null) && str != null) {
            try {
                if (str.equals("xytk")) {
                    c.a = this.b.c.getString("xytk", "");
                }
                if (str.equals("xyus")) {
                    this.b.a();
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }
}
