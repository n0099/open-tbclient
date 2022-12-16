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
import com.baidu.sofire.k.m;
import com.baidu.sofire.k.p;
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
/* loaded from: classes3.dex */
public class d implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public static d d;
    public static Context e;
    public static int f;
    public static List<Integer> g;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public com.baidu.sofire.j.a b;
    public com.baidu.sofire.c.a c;

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ d b;

        /* loaded from: classes3.dex */
        public class a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;
            public final /* synthetic */ ApkInfo b;
            public final /* synthetic */ File c;
            public final /* synthetic */ b d;

            public a(b bVar, k kVar, ApkInfo apkInfo, File file) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, kVar, apkInfo, file};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = bVar;
                this.a = kVar;
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
                    b bVar = this.d;
                    bVar.b.c.a(bVar.a);
                    com.baidu.sofire.k.a.q(d.e);
                    File file = new File(this.b.pkgPath);
                    if (file.exists()) {
                        com.baidu.sofire.a.c.a(file);
                        file.delete();
                    }
                    if (this.c.exists()) {
                        File file2 = this.c;
                        File file3 = new File(file2, this.b.key + "-" + this.b.versionName);
                        if (com.baidu.sofire.k.a.a(file3)) {
                            file3.delete();
                        }
                    }
                    String sb = new StringBuilder(this.d.a).reverse().toString();
                    ApkInfo b2 = this.d.b.c.b(sb);
                    if (b2 != null) {
                        this.d.b.a(sb, b2.pkgPath);
                    }
                }
            }
        }

        public b(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (TextUtils.isEmpty(this.a) || (a2 = k.a(d.e.getApplicationContext())) == null) {
                        return;
                    }
                    File file = new File(d.e.getFilesDir(), ".b");
                    ApkInfo b = a2.b(this.a);
                    if (b == null) {
                        ApkInfo b2 = this.b.c.b(this.a);
                        if (b2 == null) {
                            return;
                        }
                        this.b.a(this.a, b2.pkgPath);
                        if (file.exists()) {
                            File file2 = new File(file, b2.key + "-" + b2.versionName);
                            if (com.baidu.sofire.k.a.a(file2)) {
                                file2.delete();
                            }
                        }
                        String canonicalPath = d.e.getFilesDir().getCanonicalPath();
                        com.baidu.sofire.k.a.c(canonicalPath + i1.j + b2.key);
                        com.baidu.sofire.k.a.c(d.e.getFileStreamPath(b2.packageName).getAbsolutePath());
                        String sb = new StringBuilder(this.a).reverse().toString();
                        ApkInfo b3 = this.b.c.b(sb);
                        if (b3 != null) {
                            this.b.a(sb, b3.pkgPath);
                            return;
                        }
                        return;
                    }
                    Class<?> a3 = ((j) b.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                    Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, d.e);
                    if (invoke == null) {
                        return;
                    }
                    new Timer().schedule(new a(this, a2, b, file), 600000L);
                    com.baidu.sofire.k.a.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                    a2.d(this.a);
                    this.b.c.a(this.a);
                    com.baidu.sofire.k.a.q(d.e);
                    File file3 = new File(b.pkgPath);
                    if (file3.exists()) {
                        com.baidu.sofire.a.c.a(file3);
                        file3.delete();
                    }
                    if (file.exists()) {
                        File file4 = new File(file, b.key + "-" + b.versionName);
                        if (com.baidu.sofire.k.a.a(file4)) {
                            file4.delete();
                        }
                    }
                    String sb2 = new StringBuilder(this.a).reverse().toString();
                    ApkInfo b4 = this.b.c.b(sb2);
                    if (b4 != null) {
                        this.b.a(sb2, b4.pkgPath);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Comparator<ApkInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public a(d dVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2073990835, "Lcom/baidu/sofire/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2073990835, "Lcom/baidu/sofire/b/d;");
                return;
            }
        }
        g = new ArrayList();
    }

    public d(Context context) {
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
        k kVar;
        ApkInfo b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (kVar = k.f) == null || (b2 = kVar.b(str)) == null) {
                    return;
                }
                Class<?> a2 = ((j) b2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, e);
                if (invoke == null) {
                    return;
                }
                com.baidu.sofire.k.a.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                kVar.d(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized d a(Context context) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d(context.getApplicationContext());
                }
                dVar = d;
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            try {
                p.a(e).a(new b(this, str));
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65539, null, i) == null) && f == 0) {
            f = i;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
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
            com.baidu.sofire.k.a.a(e, "1003136", (Map<String, Object>) hashMap, true);
            if (TextUtils.isEmpty(str)) {
                hashMap.put("3", "1");
                com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                return new Pair<>(1, null);
            }
            try {
                try {
                    try {
                        try {
                            try {
                                if (this.c.e(i)) {
                                    Pair<Integer, Object> pair = new Pair<>(3, null);
                                    try {
                                        hashMap.put("3", Integer.toString(2));
                                        com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                    } catch (Throwable unused) {
                                    }
                                    return pair;
                                } else if (!this.a) {
                                    Pair<Integer, Object> pair2 = new Pair<>(3, null);
                                    try {
                                        hashMap.put("3", Integer.toString(3));
                                        com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                    } catch (Throwable unused2) {
                                    }
                                    return pair2;
                                } else {
                                    k kVar = k.f;
                                    if (kVar == null) {
                                        Pair<Integer, Object> pair3 = new Pair<>(3, null);
                                        try {
                                            hashMap.put("3", Integer.toString(4));
                                            com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                        } catch (Throwable unused3) {
                                        }
                                        return pair3;
                                    }
                                    ApkInfo b2 = this.c.b(i);
                                    if (b2 != null && kVar.b(b2.packageName) != null) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        Pair<Integer, Object> pair4 = new Pair<>(4, null);
                                        try {
                                            hashMap.put("3", Integer.toString(5));
                                            com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                        } catch (Throwable unused4) {
                                        }
                                        return pair4;
                                    }
                                    Class<?> a2 = ((j) kVar.b(b2.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                    return new Pair<>(0, com.baidu.sofire.k.a.a(a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, e), str, clsArr, objArr));
                                }
                            } catch (IllegalAccessException unused5) {
                                Pair<Integer, Object> pair5 = new Pair<>(2, null);
                                try {
                                    hashMap.put("3", Integer.toString(8));
                                    com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                                } catch (Throwable unused6) {
                                }
                                return pair5;
                            }
                        } catch (NoSuchMethodException unused7) {
                            Pair<Integer, Object> pair6 = new Pair<>(2, null);
                            try {
                                hashMap.put("3", Integer.toString(6));
                                com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                            } catch (Throwable unused8) {
                            }
                            return pair6;
                        }
                    } catch (InvocationTargetException unused9) {
                        Pair<Integer, Object> pair7 = new Pair<>(2, null);
                        try {
                            hashMap.put("3", Integer.toString(7));
                            com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                        } catch (Throwable unused10) {
                        }
                        return pair7;
                    }
                } catch (IllegalArgumentException unused11) {
                    Pair<Integer, Object> pair8 = new Pair<>(2, null);
                    try {
                        hashMap.put("3", Integer.toString(9));
                        com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                    } catch (Throwable unused12) {
                    }
                    return pair8;
                } catch (Throwable unused13) {
                    Pair<Integer, Object> pair9 = new Pair<>(3, null);
                    try {
                        hashMap.put("3", Integer.toString(10));
                        com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                    } catch (Throwable unused14) {
                    }
                    return pair9;
                }
            } catch (Throwable th) {
                if (i != 0) {
                    try {
                        hashMap.put("3", Integer.toString(i));
                        com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, true);
                    } catch (Throwable unused15) {
                    }
                }
                throw th;
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.a) {
                    this.a = true;
                    m.k(e);
                    com.baidu.sofire.k.a.n(e);
                    this.b.a(true);
                    JSONObject o = com.baidu.sofire.k.a.o(e);
                    Context context = e;
                    if (!TextUtils.isEmpty("3.5.9.6")) {
                        Report report = Report.getInstance(context);
                        try {
                            com.baidu.sofire.k.a.q(context);
                            report.i("sofire", "com.baidu.sofire", "3.5.9.6", "1003003", "1003002");
                        } catch (Throwable unused) {
                        }
                    }
                    com.baidu.sofire.j.a aVar = this.b;
                    aVar.b.putString("ssv", "3.5.9.6");
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
                            str = e.getFilesDir().getCanonicalPath();
                        } catch (IOException unused2) {
                            int i = com.baidu.sofire.a.b.a;
                        }
                        if (str != null) {
                            apkInfo.dataDir = str + i1.j + apkInfo.key;
                            StringBuilder sb = new StringBuilder();
                            sb.append(apkInfo.dataDir);
                            sb.append("/lib");
                            com.baidu.sofire.k.a.c(sb.toString());
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
                        aVar3.b.update("pgn", contentValues, "n=-1", null);
                    }
                    p.a(e).b(new U(e, 1, false, o));
                }
            }
        }
    }

    public void b() {
        ApkInfo apkInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                List<ApkInfo> b2 = this.c.b();
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
                Collections.sort(b2, new a(this, f2));
                Iterator it = ((ArrayList) b2).iterator();
                while (it.hasNext()) {
                    ApkInfo apkInfo2 = (ApkInfo) it.next();
                    k kVar = k.f;
                    if (kVar != null) {
                        apkInfo = kVar.b(apkInfo2.packageName);
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
                            File file = new File(e.getFilesDir(), ".b");
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            File file2 = new File(apkInfo2.pkgPath);
                            File file3 = new File(file, apkInfo2.key + "-" + apkInfo2.versionName);
                            if (!com.baidu.sofire.k.a.a(file3)) {
                                com.baidu.sofire.k.a.a(file2, file3);
                            }
                            com.baidu.sofire.a.c.a(e, apkInfo2.key, file2, file3);
                        } else {
                            File file4 = new File(e.getFilesDir(), ".b");
                            if (file4.exists()) {
                                File file5 = new File(file4, apkInfo2.key + "-" + apkInfo2.versionName);
                                if (com.baidu.sofire.k.a.a(file5)) {
                                    com.baidu.sofire.a.c.a(file5);
                                    file5.delete();
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

    /* JADX WARN: Removed duplicated region for block: B:117:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        String str2;
        int i2;
        Context context;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, callback, clsArr, objArr}) == null) {
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
                com.baidu.sofire.k.a.a(e, "1003136", (Map<String, Object>) hashMap, false);
                if (TextUtils.isEmpty(str)) {
                    if (callback != null) {
                        callback.onError(1);
                    }
                    hashMap.put("3", "11");
                    com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, false);
                    return;
                }
                try {
                    if (callback != null) {
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
                                    context = e;
                                    com.baidu.sofire.k.a.a(context, "1003141", (Map<String, Object>) hashMap, false);
                                    return;
                                }
                            } catch (IllegalAccessException unused2) {
                                if (callback != null) {
                                    try {
                                        callback.onError(2);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        i2 = 16;
                                        if (i2 != 0) {
                                        }
                                        throw th;
                                    }
                                }
                                hashMap.put("3", Integer.toString(16));
                                context = e;
                                com.baidu.sofire.k.a.a(context, "1003141", (Map<String, Object>) hashMap, false);
                                return;
                            } catch (InvocationTargetException unused3) {
                                if (callback != null) {
                                    try {
                                        callback.onError(2);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        i2 = 15;
                                        if (i2 != 0) {
                                        }
                                        throw th;
                                    }
                                }
                                hashMap.put("3", Integer.toString(15));
                                context = e;
                                com.baidu.sofire.k.a.a(context, "1003141", (Map<String, Object>) hashMap, false);
                                return;
                            }
                        } catch (NoSuchMethodException unused4) {
                            if (callback != null) {
                                try {
                                    callback.onError(2);
                                } catch (Throwable th4) {
                                    th = th4;
                                    i2 = 14;
                                    if (i2 != 0) {
                                        try {
                                            hashMap.put("3", Integer.toString(i2));
                                            com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, false);
                                        } catch (Throwable unused5) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            hashMap.put("3", Integer.toString(14));
                            context = e;
                            com.baidu.sofire.k.a.a(context, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused6) {
                            i2 = 18;
                            if (callback != null) {
                                try {
                                    callback.onError(3);
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (i2 != 0) {
                                    }
                                    throw th;
                                }
                            }
                            hashMap.put("3", Integer.toString(18));
                            context = e;
                            com.baidu.sofire.k.a.a(context, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        }
                    }
                    if (this.c.e(i)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (this.c.e(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                            SystemClock.sleep(300L);
                        }
                    }
                    if (this.c.e(i)) {
                        if (callback != null) {
                            callback.onError(3);
                        }
                        try {
                            hashMap.put("3", Integer.toString(12));
                            com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused7) {
                            return;
                        }
                    }
                    if (!this.a) {
                        a(3);
                        a();
                    }
                    k a2 = k.a(e.getApplicationContext());
                    ApkInfo apkInfo = null;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    while (System.currentTimeMillis() - currentTimeMillis2 <= 15000) {
                        apkInfo = this.c.b(i);
                        if (apkInfo != null) {
                            if (a2.b(apkInfo.packageName) != null) {
                                z = true;
                                break;
                            } else if (apkInfo.initStatus == -1) {
                                break;
                            }
                        }
                        SystemClock.sleep(1000L);
                    }
                    z = false;
                    if (!z) {
                        if (callback != null) {
                            callback.onError(4);
                        }
                        try {
                            hashMap.put("3", Integer.toString(13));
                            com.baidu.sofire.k.a.a(e, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused8) {
                            return;
                        }
                    }
                    Class<?> a3 = ((j) a2.b(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                    Object a4 = com.baidu.sofire.k.a.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, e), str, clsArr, objArr);
                    if (callback != null) {
                        callback.onEnd(a4);
                    }
                } catch (Throwable unused9) {
                }
            } catch (Throwable unused10) {
                int i3 = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IF, IF, IF, NOP, INVOKE, IF, NOP] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ad, code lost:
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i, String str, String str2, PackageInfo packageInfo) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        ApkInfo b2;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, str2, packageInfo}) == null) {
            try {
                ApkInfo b3 = this.c.b(i);
                if (b3 != null) {
                    if (!com.baidu.sofire.k.a.b(str, b3.versionName)) {
                        return;
                    }
                    ApkInfo b4 = this.c.b(i);
                    if (b4 != null) {
                        this.c.a(i);
                        File file = new File(b4.pkgPath);
                        if (file.exists()) {
                            com.baidu.sofire.a.c.a(file);
                            file.delete();
                        }
                    }
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            File file2 = null;
            InputStream inputStream2 = null;
            try {
                if (!TextUtils.isEmpty(str)) {
                    File file3 = new File(e.getFilesDir(), ".tmp");
                    if (!file3.exists()) {
                        file3.mkdir();
                    }
                    File file4 = new File(file3, i + "-" + str + ".zip");
                    try {
                        fileOutputStream = new FileOutputStream(file4);
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
                            com.baidu.sofire.k.a.a(file4.getAbsolutePath(), true);
                            String a3 = com.baidu.sofire.k.j.a(file4);
                            if (a3 != null && a3.equalsIgnoreCase(str2)) {
                                ApkInfo apkInfo = new ApkInfo(i, str, file4.getAbsolutePath());
                                apkInfo.apkMD5 = a3;
                                apkInfo.priority = 1;
                                this.c.a(apkInfo);
                                if (this.c.c(i) == 3) {
                                    z = false;
                                }
                                if (this.b.n() && z) {
                                    File file5 = new File(e.getFilesDir(), ".b");
                                    if (!file5.exists()) {
                                        file5.mkdir();
                                    }
                                    File file6 = new File(file5, i + "-" + str);
                                    if (!com.baidu.sofire.k.a.a(file6)) {
                                        com.baidu.sofire.k.a.a(file4, file6);
                                    }
                                    com.baidu.sofire.a.c.a(e, i, file4, file6);
                                } else {
                                    File file7 = new File(e.getFilesDir(), ".b");
                                    if (file7.exists()) {
                                        File file8 = new File(file7, i + "-" + str);
                                        if (com.baidu.sofire.k.a.a(file8)) {
                                            com.baidu.sofire.a.c.a(file8);
                                            file8.delete();
                                        }
                                    }
                                }
                            }
                            file4.delete();
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
                            file2 = file4;
                            try {
                                int i3 = com.baidu.sofire.a.b.a;
                                if (file2 != null && file2.exists()) {
                                    com.baidu.sofire.a.c.a(file2);
                                    this.c.a(i);
                                    file2.delete();
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
                    fileOutputStream = null;
                }
                b2 = this.c.b(i);
            } catch (Throwable unused11) {
                inputStream = null;
                fileOutputStream = null;
            }
            if (b2 != null && com.baidu.sofire.k.a.d(b2.pkgPath)) {
                synchronized (this) {
                    a2 = a(i, str, false, packageInfo);
                }
                if (a2) {
                    g.add(Integer.valueOf(i));
                    com.baidu.sofire.j.a aVar = this.b;
                    aVar.b.putString("g_l_l_p_v_" + i, str);
                    aVar.b.commit();
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused12) {
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
                } catch (IOException unused13) {
                }
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            try {
                this.c.a(str);
                File file = new File(str2);
                if (file.exists()) {
                    com.baidu.sofire.a.c.a(file);
                    file.delete();
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void a(JSONObject jSONObject) {
        ApkInfo apkInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, jSONObject) != null) || jSONObject == null) {
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
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("detail");
                    PackageInfo packageInfo = new PackageInfo();
                    packageInfo.packageName = optJSONObject2.optString("p");
                    packageInfo.versionName = optJSONObject2.optString("v");
                    ApplicationInfo applicationInfo = new ApplicationInfo();
                    String optString = optJSONObject2.optString("n");
                    applicationInfo.className = optString;
                    if (!TextUtils.isEmpty(optString) && applicationInfo.className.startsWith(".")) {
                        applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                    }
                    applicationInfo.theme = optJSONObject2.optInt("t");
                    packageInfo.applicationInfo = applicationInfo;
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("a");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            try {
                                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                if (jSONObject2 != null) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    String optString2 = jSONObject2.optString("n");
                                    activityInfo.name = optString2;
                                    if (!TextUtils.isEmpty(optString2) && activityInfo.name.startsWith(".")) {
                                        activityInfo.name = packageInfo.packageName + activityInfo.name;
                                    }
                                    activityInfo.packageName = packageInfo.packageName;
                                    activityInfo.theme = jSONObject2.optInt("t");
                                    activityInfo.labelRes = jSONObject2.optInt("l");
                                    if (!TextUtils.isEmpty(activityInfo.name)) {
                                        arrayList.add(activityInfo);
                                    }
                                }
                            } catch (Throwable unused) {
                                int i3 = com.baidu.sofire.a.b.a;
                            }
                        }
                        if (arrayList.size() > 0) {
                            packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                        }
                    }
                    HashMap<Integer, ApkInfo> hashMap = com.baidu.sofire.k.a.o;
                    if (hashMap != null && (apkInfo = hashMap.get(Integer.valueOf(optInt2))) != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                        try {
                            a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                        } catch (Throwable unused2) {
                            int i4 = com.baidu.sofire.a.b.a;
                            return;
                        }
                    }
                }
            }
            HashMap<Integer, ApkInfo> hashMap2 = com.baidu.sofire.k.a.o;
            if (hashMap2 != null) {
                hashMap2.clear();
                com.baidu.sofire.k.a.o = null;
            }
        } catch (Throwable unused3) {
        }
    }

    public synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        InterceptResult invokeILL;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, str, packageInfo)) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), packageInfo})) == null) {
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
                ApkInfo b2 = this.c.b(i);
                if (b2 == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", i + "");
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.k.a.a(e, "1003105", (Map<String, Object>) hashMap, false);
                    }
                    return false;
                } else if (!com.baidu.sofire.k.a.a(new File(b2.pkgPath))) {
                    this.c.d(i, -1);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", 3);
                    hashMap2.put("1", i + "");
                    hashMap2.put("2", str);
                    if (!z) {
                        com.baidu.sofire.k.a.a(e, "1003105", (Map<String, Object>) hashMap2, false);
                    }
                    return false;
                } else {
                    if (packageInfo != null) {
                        b2.cloudPkgInfo = packageInfo;
                    }
                    k a2 = k.a(e.getApplicationContext());
                    if (!a2.a(b2, false)) {
                        this.c.d(i, -1);
                        a2.c(b2.pkgPath);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("0", 4);
                        hashMap3.put("1", i + "");
                        hashMap3.put("2", str);
                        if (!z) {
                            com.baidu.sofire.k.a.a(e, "1003105", (Map<String, Object>) hashMap3, false);
                        }
                        return false;
                    }
                    String[] p = com.baidu.sofire.k.a.p(e);
                    if (p.length == 2 && !TextUtils.isEmpty(p[0]) && !TextUtils.isEmpty(p[1])) {
                        str2 = p[0];
                        str3 = p[1];
                    } else {
                        str2 = "3";
                        str3 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                    }
                    ApkInfo apkInfo = a2.c.get(b2.pkgPath);
                    j jVar = (j) apkInfo.classLoader;
                    Class<?> a3 = jVar.a("com.baidu.sofire.engine.EngineImpl");
                    if (a3 == null) {
                        Class<?> a4 = jVar.a("java.lang.String");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("0", 9);
                        hashMap4.put("1", i + "");
                        hashMap4.put("2", str);
                        hashMap4.put("3", Base64.encodeToString(("classloader=" + jVar + ",StringClass=" + a4).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                        if (!z) {
                            com.baidu.sofire.k.a.a(e, "1003105", (Map<String, Object>) hashMap4, false);
                        }
                        this.c.d(i, -1);
                        return false;
                    }
                    Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, e);
                    com.baidu.sofire.k.a.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
                    if (!((Boolean) com.baidu.sofire.k.a.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.TRUE)).booleanValue()) {
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("0", 6);
                        hashMap5.put("1", i + "");
                        hashMap5.put("2", str);
                        if (!z) {
                            com.baidu.sofire.k.a.a(e, "1003105", (Map<String, Object>) hashMap5, false);
                        }
                        this.c.d(i, -1);
                        a2.c(apkInfo.pkgPath);
                        return false;
                    }
                    apkInfo.initStatus = 1;
                    apkInfo.apkParseSuc = 1;
                    this.c.a(apkInfo);
                    int c = this.c.c(apkInfo.key);
                    if (c < 3 && c != -1) {
                        this.c.c(apkInfo.key, c + 1);
                    }
                    HashMap hashMap6 = new HashMap();
                    hashMap6.put("0", 0);
                    hashMap6.put("1", Integer.valueOf(i));
                    hashMap6.put("2", str);
                    if (!z) {
                        com.baidu.sofire.k.a.a(e, "1003105", (Map<String, Object>) hashMap6, false);
                    }
                    com.baidu.sofire.k.a.q(e);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.c.a();
            this.a = true;
            try {
                k a3 = k.a(e);
                if (a3 != null) {
                    if (a3.b(str) != null) {
                        return true;
                    }
                    if (this.c == null) {
                        this.c = com.baidu.sofire.c.a.a(e);
                    }
                    ApkInfo b2 = this.c.b(str);
                    if (b2 != null) {
                        if (this.b.n()) {
                            File file = new File(e.getFilesDir(), ".b");
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            File file2 = new File(b2.pkgPath);
                            File file3 = new File(file, b2.key + "-" + b2.versionName);
                            if (!com.baidu.sofire.k.a.a(file3)) {
                                com.baidu.sofire.k.a.a(file2, file3);
                            }
                            com.baidu.sofire.a.c.a(e, b2.key, file2, file3);
                        }
                        int i = b2.key;
                        String str2 = b2.versionName;
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

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if ("3".equals(str) && "925fc15df8a49bed0b3eca8d2b44cb7b".equals(str2)) {
                        return;
                    }
                    com.baidu.sofire.k.a.b = str;
                    com.baidu.sofire.k.a.c = str2;
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

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
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

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, sharedPreferences, str) == null) && str != null) {
            try {
                if (str.equals("xytk")) {
                    e.a = this.b.c.getString("xytk", "");
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
