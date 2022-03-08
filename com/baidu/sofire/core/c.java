package com.baidu.sofire.core;

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
import com.baidu.sofire.rp.Report;
import com.baidu.sofire.utility.q;
import com.baidu.sofire.utility.u;
import com.baidu.sofire.utility.z;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.r1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class c implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static Context f37042b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f37043c;

    /* renamed from: d  reason: collision with root package name */
    public static List<Integer> f37044d;

    /* renamed from: f  reason: collision with root package name */
    public static c f37045f;

    /* renamed from: g  reason: collision with root package name */
    public static int f37046g;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.sofire.h.a a;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f37047e;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.sofire.a.a f37048h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1595443385, "Lcom/baidu/sofire/core/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1595443385, "Lcom/baidu/sofire/core/c;");
                return;
            }
        }
        f37044d = new ArrayList();
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37047e = false;
        Context applicationContext = context.getApplicationContext();
        f37042b = applicationContext;
        this.f37048h = com.baidu.sofire.a.a.a(applicationContext);
        com.baidu.sofire.h.a a = com.baidu.sofire.h.a.a(f37042b);
        this.a = a;
        SharedPreferences sharedPreferences = a.f37109c;
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public final synchronized void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                try {
                    if (this.f37047e) {
                        return;
                    }
                    this.f37047e = true;
                    u.a(f37042b);
                    com.baidu.sofire.utility.c.n(f37042b);
                    this.a.a(true);
                    com.baidu.sofire.k.a.a().a(f37042b, null);
                    JSONObject o = com.baidu.sofire.utility.c.o(f37042b);
                    com.baidu.sofire.utility.c.d(f37042b);
                    com.baidu.sofire.h.a aVar = this.a;
                    aVar.f37108b.putString("ssv", "3.5.8.8");
                    aVar.f37108b.commit();
                    Report.getInstance(f37042b).n();
                    for (ApkInfo apkInfo : this.f37048h.a()) {
                        try {
                            str = f37042b.getFilesDir().getCanonicalPath();
                        } catch (IOException unused) {
                            com.baidu.sofire.utility.c.a();
                            str = null;
                        }
                        if (str != null) {
                            apkInfo.dataDir = str + r1.k + apkInfo.key;
                            StringBuilder sb = new StringBuilder();
                            sb.append(apkInfo.dataDir);
                            sb.append("/lib");
                            com.baidu.sofire.utility.c.d(sb.toString());
                        }
                    }
                    this.f37048h.d();
                    if (!this.a.a.getBoolean("iio", false)) {
                        com.baidu.sofire.h.a aVar2 = this.a;
                        aVar2.f37108b.putBoolean("iio", true);
                        aVar2.f37108b.commit();
                    } else {
                        com.baidu.sofire.a.a aVar3 = this.f37048h;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("n", (Integer) 0);
                        aVar3.f36989c.update("pgn", contentValues, "n=-1", null);
                    }
                    z.a(f37042b).b(new U(f37042b, 1, false, o));
                } catch (Throwable unused2) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                List<ApkInfo> a = this.f37048h.a();
                List<Integer> q = this.a.q();
                List<Integer> p = this.a.p();
                for (int i2 = 0; i2 < p.size(); i2++) {
                    if (!q.contains(p.get(i2))) {
                        q.add(p.get(i2));
                    }
                }
                Collections.sort(a, new Comparator<ApkInfo>(this, q) { // from class: com.baidu.sofire.core.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f37049b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, q};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37049b = this;
                        this.a = q;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(ApkInfo apkInfo, ApkInfo apkInfo2) {
                        int i3;
                        int i4;
                        ApkInfo apkInfo3 = apkInfo;
                        ApkInfo apkInfo4 = apkInfo2;
                        if (apkInfo3.priority != -1 || apkInfo4.priority == -1) {
                            if ((apkInfo3.priority == -1 || apkInfo4.priority != -1) && (i3 = apkInfo3.priority) >= (i4 = apkInfo4.priority)) {
                                if (i3 > i4) {
                                    return 1;
                                }
                                List list = this.a;
                                int indexOf = (list == null || !list.contains(Integer.valueOf(apkInfo3.key))) ? -1 : this.a.indexOf(Integer.valueOf(apkInfo3.key));
                                List list2 = this.a;
                                int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo4.key))) ? -1 : this.a.indexOf(Integer.valueOf(apkInfo4.key));
                                if (indexOf == -1 || indexOf2 != -1) {
                                    if ((indexOf != -1 || indexOf2 == -1) && indexOf <= indexOf2) {
                                        return indexOf < indexOf2 ? -1 : 0;
                                    }
                                    return 1;
                                }
                                return -1;
                            }
                            return -1;
                        }
                        return 1;
                    }
                });
                for (ApkInfo apkInfo : a) {
                    f a2 = f.a();
                    if ((a2 != null ? a2.d(apkInfo.packageName) : null) == null) {
                        boolean z = this.f37048h.g(apkInfo.key) != 3;
                        if (this.a.b() && z) {
                            File file = new File(f37042b.getFilesDir(), ".b");
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            File file2 = new File(apkInfo.pkgPath);
                            File file3 = new File(file, apkInfo.key + "-" + apkInfo.versionName);
                            if (!com.baidu.sofire.utility.c.a(file3)) {
                                com.baidu.sofire.utility.c.a(file2, file3);
                            }
                            com.baidu.sofire.c.a(f37042b, apkInfo.key, file2, file3);
                        } else {
                            File file4 = new File(f37042b.getFilesDir(), ".b");
                            if (file4.exists()) {
                                File file5 = new File(file4, apkInfo.key + "-" + apkInfo.versionName);
                                if (com.baidu.sofire.utility.c.a(file5)) {
                                    com.baidu.sofire.c.a(file5);
                                    file5.delete();
                                }
                            }
                        }
                        a(apkInfo.key, apkInfo.versionName, null);
                    }
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, sharedPreferences, str) == null) || str == null) {
            return;
        }
        try {
            if (str.equals("xytk")) {
                d.a = this.a.E();
            }
            if (str.equals("xyus")) {
                this.a.k();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f37045f : (c) invokeV.objValue;
    }

    public static synchronized c a(Context context) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (c.class) {
                if (f37045f == null) {
                    f37045f = new c(context.getApplicationContext());
                }
                cVar = f37045f;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void a(JSONObject jSONObject) {
        ApkInfo apkInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("6");
            if (optJSONArray == null) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
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
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            try {
                                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i3);
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
                                com.baidu.sofire.utility.c.a();
                            }
                        }
                        if (arrayList.size() > 0) {
                            packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                        }
                    }
                    if (com.baidu.sofire.utility.c.f37179h != null && (apkInfo = com.baidu.sofire.utility.c.f37179h.get(Integer.valueOf(optInt2))) != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                        try {
                            a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                        } catch (Throwable unused2) {
                            com.baidu.sofire.utility.c.a();
                            return;
                        }
                    }
                }
            }
            if (com.baidu.sofire.utility.c.f37179h != null) {
                com.baidu.sofire.utility.c.f37179h.clear();
                com.baidu.sofire.utility.c.f37179h = null;
            }
        } catch (Throwable unused3) {
        }
    }

    public static void c(String str) {
        f a;
        ApkInfo d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (a = f.a()) == null || (d2 = a.d(str)) == null) {
                    return;
                }
                Class<?> a2 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, f37042b);
                if (invoke == null) {
                    return;
                }
                com.baidu.sofire.utility.c.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                a.b(str);
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.f37048h.d();
            this.f37047e = true;
            return a(f37042b, str);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IF, IF, IF, NOP, INVOKE, IF, NOP] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a7, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i2, String str, String str2, PackageInfo packageInfo) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i2), str, str2, packageInfo}) != null) {
            return;
        }
        try {
            ApkInfo a = this.f37048h.a(i2);
            if (a != null) {
                if (!com.baidu.sofire.utility.c.b(str, a.versionName)) {
                    return;
                }
                ApkInfo a2 = this.f37048h.a(i2);
                if (a2 != null) {
                    this.f37048h.h(i2);
                    File file = new File(a2.pkgPath);
                    if (file.exists()) {
                        com.baidu.sofire.c.a(file);
                        file.delete();
                    }
                }
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        File file2 = null;
        InputStream inputStream2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                fileOutputStream = null;
            } else {
                File file3 = new File(f37042b.getFilesDir(), ".tmp");
                if (!file3.exists()) {
                    file3.mkdir();
                }
                File file4 = new File(file3, i2 + "-" + str + ".zip");
                try {
                    fileOutputStream = new FileOutputStream(file4);
                    try {
                        inputStream2 = f37042b.getAssets().open(String.valueOf(i2));
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            z = false;
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        com.baidu.sofire.utility.c.a(file4.getAbsolutePath(), true);
                        String a3 = q.a(file4);
                        if (a3 != null && a3.equalsIgnoreCase(str2)) {
                            ApkInfo apkInfo = new ApkInfo(i2, str, file4.getAbsolutePath());
                            apkInfo.apkMD5 = a3;
                            apkInfo.priority = 1;
                            this.f37048h.a(apkInfo);
                            if (this.f37048h.g(i2) != 3) {
                                z = true;
                            }
                            if (this.a.b() && z) {
                                File file5 = new File(f37042b.getFilesDir(), ".b");
                                if (!file5.exists()) {
                                    file5.mkdir();
                                }
                                File file6 = new File(file5, i2 + "-" + str);
                                if (!com.baidu.sofire.utility.c.a(file6)) {
                                    com.baidu.sofire.utility.c.a(file4, file6);
                                }
                                com.baidu.sofire.c.a(f37042b, i2, file4, file6);
                            } else {
                                File file7 = new File(f37042b.getFilesDir(), ".b");
                                if (file7.exists()) {
                                    File file8 = new File(file7, i2 + "-" + str);
                                    if (com.baidu.sofire.utility.c.a(file8)) {
                                        com.baidu.sofire.c.a(file8);
                                        file8.delete();
                                    }
                                }
                            }
                        }
                        file4.delete();
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException unused2) {
                            }
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
                            com.baidu.sofire.utility.c.a();
                            if (file2 == null || !file2.exists()) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException unused5) {
                                        return;
                                    }
                                }
                                return;
                            }
                            com.baidu.sofire.c.a(file2);
                            this.f37048h.h(i2);
                            file2.delete();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException unused7) {
                                    return;
                                }
                            }
                            return;
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
            }
            ApkInfo a4 = this.f37048h.a(i2);
            if (a4 != null && com.baidu.sofire.utility.c.c(a4.pkgPath)) {
                if (a(i2, str, packageInfo)) {
                    f37044d.add(Integer.valueOf(i2));
                    com.baidu.sofire.h.a aVar = this.a;
                    aVar.f37108b.putString("g_l_l_p_v_" + i2, str);
                    aVar.f37108b.commit();
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused11) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException unused12) {
                        return;
                    }
                }
                return;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused13) {
                }
            }
        } catch (Throwable unused14) {
            inputStream = null;
            fileOutputStream = null;
        }
    }

    public final synchronized boolean a(int i2, String str, PackageInfo packageInfo) {
        InterceptResult invokeILL;
        boolean a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, str, packageInfo)) == null) {
            synchronized (this) {
                a = a(i2, str, false, packageInfo);
            }
            return a;
        }
        return invokeILL.booleanValue;
    }

    private synchronized boolean a(int i2, String str, boolean z, PackageInfo packageInfo) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z), packageInfo})) == null) {
            synchronized (this) {
                if (z) {
                    try {
                        if (this.f37048h.c(i2) != 1) {
                            return false;
                        }
                    } catch (Throwable unused) {
                        com.baidu.sofire.utility.c.a();
                        return false;
                    }
                }
                ApkInfo a = this.f37048h.a(i2);
                if (a == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", String.valueOf(i2));
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.utility.c.a(f37042b, "1003105", (Map<String, Object>) hashMap, false);
                    }
                    return false;
                } else if (!com.baidu.sofire.utility.c.a(new File(a.pkgPath))) {
                    this.f37048h.f(i2);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", 3);
                    hashMap2.put("1", String.valueOf(i2));
                    hashMap2.put("2", str);
                    if (!z) {
                        com.baidu.sofire.utility.c.a(f37042b, "1003105", (Map<String, Object>) hashMap2, false);
                    }
                    return false;
                } else {
                    if (packageInfo != null) {
                        a.cloudPkgInfo = packageInfo;
                    }
                    f a2 = f.a(f37042b.getApplicationContext());
                    if (!a2.a(a, false)) {
                        this.f37048h.f(i2);
                        a2.a(a.pkgPath);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("0", 4);
                        hashMap3.put("1", String.valueOf(i2));
                        hashMap3.put("2", str);
                        if (!z) {
                            com.baidu.sofire.utility.c.a(f37042b, "1003105", (Map<String, Object>) hashMap3, false);
                        }
                        return false;
                    }
                    String[] g2 = com.baidu.sofire.utility.c.g(f37042b);
                    if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                        str2 = g2[0];
                        str3 = g2[1];
                    } else {
                        str2 = com.baidu.sofire.utility.c.f37176e;
                        str3 = com.baidu.sofire.utility.c.f37177f;
                    }
                    ApkInfo c2 = a2.c(a.pkgPath);
                    e eVar = (e) c2.classLoader;
                    Class<?> a3 = eVar.a("com.baidu.sofire.engine.EngineImpl");
                    if (a3 == null) {
                        Class<?> a4 = eVar.a("java.lang.String");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("0", 9);
                        hashMap4.put("1", String.valueOf(i2));
                        hashMap4.put("2", str);
                        hashMap4.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a4).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
                        if (!z) {
                            com.baidu.sofire.utility.c.a(f37042b, "1003105", (Map<String, Object>) hashMap4, false);
                        }
                        this.f37048h.f(i2);
                        return false;
                    }
                    Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f37042b);
                    try {
                        com.baidu.sofire.utility.c.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
                    } catch (Throwable unused2) {
                        com.baidu.sofire.utility.c.a();
                    }
                    if (!((Boolean) com.baidu.sofire.utility.c.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.TRUE)).booleanValue()) {
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("0", 6);
                        hashMap5.put("1", String.valueOf(i2));
                        hashMap5.put("2", str);
                        if (!z) {
                            com.baidu.sofire.utility.c.a(f37042b, "1003105", (Map<String, Object>) hashMap5, false);
                        }
                        this.f37048h.f(i2);
                        a2.a(c2.pkgPath);
                        return false;
                    }
                    c2.initStatus = 1;
                    c2.apkParseSuc = 1;
                    this.f37048h.a(c2);
                    int g3 = this.f37048h.g(c2.key);
                    if (g3 < 3 && g3 != -1) {
                        this.f37048h.b(c2.key, g3 + 1);
                    }
                    HashMap hashMap6 = new HashMap();
                    hashMap6.put("0", 0);
                    hashMap6.put("1", Integer.valueOf(i2));
                    hashMap6.put("2", str);
                    if (!z) {
                        com.baidu.sofire.utility.c.a(f37042b, "1003105", (Map<String, Object>) hashMap6, false);
                    }
                    com.baidu.sofire.utility.c.c(f37042b);
                    return true;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            try {
                this.f37048h.a(str);
                File file = new File(str2);
                if (file.exists()) {
                    com.baidu.sofire.c.a(file);
                    file.delete();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:100:0x034f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x033f */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0043: IGET  (r15v12 int A[REMOVE]) = (r2v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x010f: IGET  (r9v12 int A[REMOVE]) = (r2v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x028e: IGET  (r8v24 int A[REMOVE]) = (r2v9 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0322: IGET  (r4v2 int A[REMOVE]) = (r2v9 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x039e: IGET  (r8v5 int A[REMOVE]) = (r2v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0366: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:105:0x0361 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0189 A[Catch: all -> 0x034f, TryCatch #7 {all -> 0x034f, blocks: (B:26:0x0121, B:33:0x014b, B:35:0x0157, B:37:0x015f, B:39:0x0168, B:41:0x0172, B:44:0x017f, B:48:0x0189, B:50:0x0195, B:43:0x017b), top: B:132:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x025e A[Catch: all -> 0x0341, TRY_LEAVE, TryCatch #1 {all -> 0x0341, blocks: (B:63:0x023b, B:65:0x025e, B:62:0x0238), top: B:120:0x0238 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a6 A[Catch: all -> 0x033f, TryCatch #13 {all -> 0x033f, blocks: (B:67:0x0286, B:69:0x02a6, B:71:0x02ac, B:73:0x02bb), top: B:143:0x025c }] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(ApkInfo apkInfo, String str) {
        InterceptResult invokeLL;
        CharSequence charSequence;
        Object obj;
        String str2;
        Object obj2;
        String str3;
        boolean a;
        Class cls;
        Integer num;
        String str4;
        String str5;
        Object obj3;
        int i2;
        File file;
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048582, this, apkInfo, str)) != null) {
            return invokeLL.booleanValue;
        }
        ApkInfo apkInfo2 = apkInfo;
        if (apkInfo2 == null) {
            return false;
        }
        File file2 = new File(apkInfo2.pkgPath);
        ?? r15 = 1;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                charSequence = StringUtils.CR;
                obj = "3";
                obj2 = "0";
                str2 = str3;
            }
        } catch (Throwable th2) {
            th = th2;
            charSequence = StringUtils.CR;
            obj = "3";
            r15 = "2";
            str2 = "1";
        }
        if (!com.baidu.sofire.utility.c.a(file2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", 1);
            StringBuilder sb = new StringBuilder();
            sb.append(apkInfo2.key);
            hashMap.put("1", sb.toString());
            hashMap.put("2", apkInfo2.versionName);
            StringBuilder sb2 = new StringBuilder("nowTime:");
            sb2.append(System.currentTimeMillis());
            sb2.append(", nowFileInfo: path=");
            sb2.append(file2.getAbsolutePath());
            sb2.append(", exists=");
            sb2.append(file2.exists());
            sb2.append(", canRead=");
            sb2.append(file2.canRead());
            sb2.append(", isFile=");
            sb2.append(file2.isFile());
            sb2.append(",length");
            sb2.append(file2.length());
            sb2.append(" - ");
            sb2.append(str);
            hashMap.put("3", Base64.encodeToString(sb2.toString().getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
            com.baidu.sofire.utility.c.a(f37042b, "1003106", (Map<String, Object>) hashMap, false);
            return false;
        }
        if (!this.f37048h.b(apkInfo2.key)) {
            this.f37048h.a(apkInfo2);
        }
        f a2 = f.a(f37042b.getApplicationContext());
        ?? r152 = 1;
        try {
            this.f37048h.a(apkInfo2.key, 1);
            c(apkInfo2.packageName);
            a = a2.a(apkInfo2, true);
            try {
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            obj = "3";
            obj2 = "0";
            str2 = "1";
            r15 = "2";
            charSequence = StringUtils.CR;
        }
        if (!a) {
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(apkInfo2.key);
                Object obj4 = "1";
                try {
                    hashMap2.put(obj4, sb3.toString());
                    hashMap2.put("2", apkInfo2.versionName);
                    com.baidu.sofire.utility.c.a(f37042b, "1003106", (Map<String, Object>) hashMap2, false);
                    com.baidu.sofire.c.a(file2);
                    file2.delete();
                    a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                    this.f37048h.a(apkInfo2.key, 0);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    a = obj4;
                    r152 = "2";
                    charSequence = StringUtils.CR;
                    obj = "3";
                    str2 = a;
                    r15 = r152;
                    obj2 = "0";
                    try {
                        com.baidu.sofire.c.a(file2);
                        c(apkInfo2.packageName);
                        file2.delete();
                        a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                        this.f37048h.a(apkInfo2.key, 0);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put(obj2, 5);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(apkInfo2.key);
                        hashMap3.put(str2, sb4.toString());
                        hashMap3.put(r15, apkInfo2.versionName);
                        hashMap3.put(obj, Base64.encodeToString(com.baidu.sofire.b.a(th).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(charSequence, ""));
                        com.baidu.sofire.utility.c.a(f37042b, "1003106", (Map<String, Object>) hashMap3, false);
                        return false;
                    } catch (Throwable unused) {
                        com.baidu.sofire.utility.c.a();
                        return false;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                a = "1";
            }
        } else {
            str2 = "1";
            r15 = "2";
            String[] g2 = com.baidu.sofire.utility.c.g(f37042b);
            if (g2 == null) {
                cls = String.class;
                num = 0;
            } else {
                num = 0;
                cls = String.class;
                if (g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                    str4 = g2[0];
                    str5 = g2[1];
                    apkInfo2 = a2.c(apkInfo2.pkgPath);
                    if (apkInfo2 != null) {
                        return false;
                    }
                    e eVar = (e) apkInfo2.classLoader;
                    Class<?> a3 = eVar.a("com.baidu.sofire.engine.EngineImpl");
                    if (a3 == null) {
                        Class<?> a4 = eVar.a("java.lang.String");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("0", 6);
                        StringBuilder sb5 = new StringBuilder();
                        obj3 = "0";
                        try {
                            sb5.append(apkInfo2.key);
                            hashMap4.put(str2, sb5.toString());
                            hashMap4.put(r15, apkInfo2.versionName);
                            hashMap4.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a4).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
                            com.baidu.sofire.utility.c.a(f37042b, "1003106", (Map<String, Object>) hashMap4, false);
                            com.baidu.sofire.c.a(file2);
                            file2.delete();
                            this.f37048h.a(apkInfo2.key, 0);
                            return false;
                        } catch (Throwable th7) {
                            th = th7;
                            charSequence = StringUtils.CR;
                            obj = "3";
                        }
                    } else {
                        obj3 = "0";
                        obj = "3";
                        try {
                            obj2 = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f37042b);
                            try {
                                clsArr = new Class[]{cls, cls};
                                charSequence = StringUtils.CR;
                            } catch (Throwable unused2) {
                                charSequence = StringUtils.CR;
                            }
                            try {
                                com.baidu.sofire.utility.c.a(obj2, "setSecurityVerifyInfo", clsArr, str4, str5);
                            } catch (Throwable unused3) {
                                try {
                                    com.baidu.sofire.utility.c.a();
                                    if (((Boolean) com.baidu.sofire.utility.c.a(obj2, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, num, Boolean.TRUE)).booleanValue()) {
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                            }
                            try {
                                if (((Boolean) com.baidu.sofire.utility.c.a(obj2, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, num, Boolean.TRUE)).booleanValue()) {
                                    com.baidu.sofire.c.a(file2);
                                    c(apkInfo2.packageName);
                                    file2.delete();
                                    a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                                    this.f37048h.a(apkInfo2.key, 0);
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put(obj3, 4);
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(apkInfo2.key);
                                    hashMap5.put(str2, sb6.toString());
                                    hashMap5.put(r15, apkInfo2.versionName);
                                    com.baidu.sofire.utility.c.a(f37042b, "1003106", (Map<String, Object>) hashMap5, false);
                                    return false;
                                }
                                if (apkInfo2.isMem) {
                                    com.baidu.sofire.c.a(file2);
                                    file2.delete();
                                    com.baidu.sofire.utility.c.d(apkInfo2.dataDir);
                                    if (f.f37073b != null) {
                                        f.f37073b.add(Integer.valueOf(apkInfo2.key));
                                    }
                                }
                                try {
                                    ApkInfo a5 = this.f37048h.a(apkInfo2.key);
                                    if (a5 == null || a5.versionName.equals(apkInfo2.versionName)) {
                                        i2 = 1;
                                        file = null;
                                    } else {
                                        file = new File(a5.pkgPath);
                                        i2 = 1;
                                    }
                                    apkInfo2.initStatus = i2;
                                    apkInfo2.apkParseSuc = i2;
                                    if (this.f37048h.a(apkInfo2) > 0 && file != null && file.exists()) {
                                        com.baidu.sofire.c.a(file);
                                        file.delete();
                                    }
                                    this.f37048h.a(apkInfo2.key, 0);
                                    com.baidu.sofire.utility.c.c(f37042b);
                                    HashMap hashMap6 = new HashMap();
                                    hashMap6.put(obj3, num);
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append(apkInfo2.key);
                                    hashMap6.put(str2, sb7.toString());
                                    hashMap6.put(r15, apkInfo2.versionName);
                                    com.baidu.sofire.utility.c.a(f37042b, "1003106", (Map<String, Object>) hashMap6, false);
                                    return true;
                                } catch (Throwable unused4) {
                                    com.baidu.sofire.utility.c.a();
                                    return true;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            charSequence = StringUtils.CR;
                        }
                    }
                    obj2 = obj3;
                    com.baidu.sofire.c.a(file2);
                    c(apkInfo2.packageName);
                    file2.delete();
                    a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                    this.f37048h.a(apkInfo2.key, 0);
                    HashMap hashMap32 = new HashMap();
                    hashMap32.put(obj2, 5);
                    StringBuilder sb42 = new StringBuilder();
                    sb42.append(apkInfo2.key);
                    hashMap32.put(str2, sb42.toString());
                    hashMap32.put(r15, apkInfo2.versionName);
                    hashMap32.put(obj, Base64.encodeToString(com.baidu.sofire.b.a(th).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(charSequence, ""));
                    com.baidu.sofire.utility.c.a(f37042b, "1003106", (Map<String, Object>) hashMap32, false);
                    return false;
                }
            }
            str4 = com.baidu.sofire.utility.c.f37176e;
            str5 = com.baidu.sofire.utility.c.f37177f;
            apkInfo2 = a2.c(apkInfo2.pkgPath);
            if (apkInfo2 != null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i2, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, callback, clsArr, objArr}) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", Integer.toString(i2));
                hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
                hashMap.put("2", "0");
                com.baidu.sofire.utility.c.a(f37042b, "1003136", (Map<String, Object>) hashMap, false);
                if (TextUtils.isEmpty(str)) {
                    if (callback != null) {
                        callback.onError(1);
                    }
                    hashMap.put("3", "11");
                    com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                    return;
                }
                int i3 = 18;
                if (callback != null) {
                    try {
                        callback.onBegin(new Object[0]);
                    } catch (IllegalAccessException unused) {
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th) {
                                th = th;
                                i3 = 16;
                                if (i3 != 0) {
                                    try {
                                        hashMap.put("3", Integer.toString(i3));
                                        com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                                    } catch (Throwable unused2) {
                                    }
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(16));
                            com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    } catch (IllegalArgumentException unused4) {
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th2) {
                                th = th2;
                                i3 = 17;
                                if (i3 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(17));
                            com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused5) {
                            return;
                        }
                    } catch (NoSuchMethodException unused6) {
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th3) {
                                th = th3;
                                i3 = 14;
                                if (i3 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(14));
                            com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused7) {
                            return;
                        }
                    } catch (InvocationTargetException unused8) {
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th4) {
                                th = th4;
                                i3 = 15;
                                if (i3 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(15));
                            com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused9) {
                            return;
                        }
                    } catch (Throwable unused10) {
                        if (callback != null) {
                            try {
                                callback.onError(3);
                            } catch (Throwable th5) {
                                th = th5;
                                if (i3 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(18));
                            com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused11) {
                            return;
                        }
                    }
                }
                if (this.f37048h.d(i2)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (this.f37048h.d(i2) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                        SystemClock.sleep(300L);
                    }
                }
                if (this.f37048h.d(i2)) {
                    if (callback != null) {
                        callback.onError(3);
                    }
                    try {
                        hashMap.put("3", Integer.toString(12));
                        com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                        return;
                    } catch (Throwable unused12) {
                        return;
                    }
                }
                if (!this.f37047e) {
                    a(3);
                    b();
                }
                f a = f.a(f37042b.getApplicationContext());
                ApkInfo apkInfo = null;
                long currentTimeMillis2 = System.currentTimeMillis();
                while (System.currentTimeMillis() - currentTimeMillis2 <= 15000) {
                    apkInfo = this.f37048h.a(i2);
                    if (apkInfo != null) {
                        if (a.d(apkInfo.packageName) == null) {
                            if (apkInfo.initStatus == -1) {
                                break;
                            }
                        } else {
                            z = true;
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
                        com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, false);
                        return;
                    } catch (Throwable unused13) {
                        return;
                    }
                }
                Class<?> a2 = ((e) a.d(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object a3 = com.baidu.sofire.utility.c.a(a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, f37042b), str, clsArr, objArr);
                if (callback != null) {
                    callback.onEnd(a3);
                }
            } catch (Throwable unused14) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Integer, Object> a(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, clsArr, objArr})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i2));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "1");
            com.baidu.sofire.utility.c.a(f37042b, "1003136", (Map<String, Object>) hashMap, true);
            if (TextUtils.isEmpty(str)) {
                hashMap.put("3", "1");
                com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                return new Pair<>(1, null);
            }
            int i3 = 10;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    if (this.f37048h.d(i2)) {
                                        Pair<Integer, Object> pair = new Pair<>(3, null);
                                        try {
                                            hashMap.put("3", Integer.toString(2));
                                            com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                                        } catch (Throwable unused) {
                                        }
                                        return pair;
                                    } else if (!this.f37047e) {
                                        Pair<Integer, Object> pair2 = new Pair<>(3, null);
                                        try {
                                            hashMap.put("3", Integer.toString(3));
                                            com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                                        } catch (Throwable unused2) {
                                        }
                                        return pair2;
                                    } else {
                                        f a = f.a();
                                        if (a == null) {
                                            Pair<Integer, Object> pair3 = new Pair<>(3, null);
                                            try {
                                                hashMap.put("3", Integer.toString(4));
                                                com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                                            } catch (Throwable unused3) {
                                            }
                                            return pair3;
                                        }
                                        ApkInfo a2 = this.f37048h.a(i2);
                                        if (!((a2 == null || a.d(a2.packageName) == null) ? false : true)) {
                                            Pair<Integer, Object> pair4 = new Pair<>(4, null);
                                            try {
                                                hashMap.put("3", Integer.toString(5));
                                                com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                                            } catch (Throwable unused4) {
                                            }
                                            return pair4;
                                        }
                                        Class<?> a3 = ((e) a.d(a2.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                        return new Pair<>(0, com.baidu.sofire.utility.c.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f37042b), str, clsArr, objArr));
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    i3 = 9;
                                    if (i3 != 0) {
                                        try {
                                            hashMap.put("3", Integer.toString(i3));
                                            com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                                        } catch (Throwable unused5) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (i3 != 0) {
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i3 = 6;
                            if (i3 != 0) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        i3 = 7;
                        if (i3 != 0) {
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    i3 = 8;
                    if (i3 != 0) {
                    }
                    throw th;
                }
            } catch (IllegalAccessException unused6) {
                Pair<Integer, Object> pair5 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(8));
                    com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused7) {
                }
                return pair5;
            } catch (IllegalArgumentException unused8) {
                Pair<Integer, Object> pair6 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(9));
                    com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused9) {
                }
                return pair6;
            } catch (NoSuchMethodException unused10) {
                Pair<Integer, Object> pair7 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(6));
                    com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused11) {
                }
                return pair7;
            } catch (InvocationTargetException unused12) {
                Pair<Integer, Object> pair8 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(7));
                    com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused13) {
                }
                return pair8;
            } catch (Throwable unused14) {
                Pair<Integer, Object> pair9 = new Pair<>(3, null);
                try {
                    hashMap.put("3", Integer.toString(10));
                    com.baidu.sofire.utility.c.a(f37042b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused15) {
                }
                return pair9;
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                z.a(f37042b).a(new Runnable(this, str) { // from class: com.baidu.sofire.core.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f37050b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37050b = this;
                        this.a = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        f a;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (TextUtils.isEmpty(this.a) || (a = f.a(c.f37042b.getApplicationContext())) == null) {
                                    return;
                                }
                                File file = new File(c.f37042b.getFilesDir(), ".b");
                                ApkInfo d2 = a.d(this.a);
                                if (d2 == null) {
                                    ApkInfo b2 = this.f37050b.f37048h.b(this.a);
                                    if (b2 == null) {
                                        return;
                                    }
                                    this.f37050b.a(this.a, b2.pkgPath);
                                    if (file.exists()) {
                                        File file2 = new File(file, b2.key + "-" + b2.versionName);
                                        if (com.baidu.sofire.utility.c.a(file2)) {
                                            file2.delete();
                                        }
                                    }
                                    if (b2 != null) {
                                        String canonicalPath = c.f37042b.getFilesDir().getCanonicalPath();
                                        com.baidu.sofire.utility.c.d(canonicalPath + r1.k + b2.key);
                                        com.baidu.sofire.utility.c.d(c.f37042b.getFileStreamPath(b2.packageName).getAbsolutePath());
                                    }
                                    String sb = new StringBuilder(this.a).reverse().toString();
                                    ApkInfo b3 = this.f37050b.f37048h.b(sb);
                                    if (b3 != null) {
                                        this.f37050b.a(sb, b3.pkgPath);
                                        return;
                                    }
                                    return;
                                }
                                Class<?> a2 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, c.f37042b);
                                if (invoke == null) {
                                    return;
                                }
                                new Timer().schedule(new TimerTask(this, a, d2, file) { // from class: com.baidu.sofire.core.c.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ f a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ ApkInfo f37051b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ File f37052c;

                                    /* renamed from: d  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass2 f37053d;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, a, d2, file};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f37053d = this;
                                        this.a = a;
                                        this.f37051b = d2;
                                        this.f37052c = file;
                                    }

                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public final void run() {
                                        ApkInfo d3;
                                        String str2;
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (d3 = this.a.d(this.f37053d.a)) == null || (str2 = d3.versionName) == null || !str2.equals(this.f37051b.versionName)) {
                                            return;
                                        }
                                        this.a.b(this.f37053d.a);
                                        this.f37053d.f37050b.f37048h.a(this.f37053d.a);
                                        com.baidu.sofire.utility.c.c(c.f37042b);
                                        File file3 = new File(this.f37051b.pkgPath);
                                        if (file3.exists()) {
                                            com.baidu.sofire.c.a(file3);
                                            file3.delete();
                                        }
                                        if (this.f37052c.exists()) {
                                            File file4 = this.f37052c;
                                            File file5 = new File(file4, this.f37051b.key + "-" + this.f37051b.versionName);
                                            if (com.baidu.sofire.utility.c.a(file5)) {
                                                file5.delete();
                                            }
                                        }
                                        String sb2 = new StringBuilder(this.f37053d.a).reverse().toString();
                                        ApkInfo b4 = this.f37053d.f37050b.f37048h.b(sb2);
                                        if (b4 != null) {
                                            this.f37053d.f37050b.a(sb2, b4.pkgPath);
                                        }
                                    }
                                }, 600000L);
                                com.baidu.sofire.utility.c.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                                a.b(this.a);
                                this.f37050b.f37048h.a(this.a);
                                com.baidu.sofire.utility.c.c(c.f37042b);
                                File file3 = new File(d2.pkgPath);
                                if (file3.exists()) {
                                    com.baidu.sofire.c.a(file3);
                                    file3.delete();
                                }
                                if (file.exists()) {
                                    File file4 = new File(file, d2.key + "-" + d2.versionName);
                                    if (com.baidu.sofire.utility.c.a(file4)) {
                                        file4.delete();
                                    }
                                }
                                String sb2 = new StringBuilder(this.a).reverse().toString();
                                ApkInfo b4 = this.f37050b.f37048h.b(sb2);
                                if (b4 != null) {
                                    this.f37050b.a(sb2, b4.pkgPath);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65541, null, i2) == null) && f37046g == 0) {
            f37046g = i2;
        }
    }

    private boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, context, str)) == null) {
            try {
                f a = f.a(context);
                if (a == null) {
                    return false;
                }
                if (a.d(str) != null) {
                    return true;
                }
                if (this.f37048h == null) {
                    this.f37048h = com.baidu.sofire.a.a.a(f37042b);
                }
                ApkInfo b2 = this.f37048h.b(str);
                if (b2 != null) {
                    if (this.a.b()) {
                        File file = new File(f37042b.getFilesDir(), ".b");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(b2.pkgPath);
                        File file3 = new File(file, b2.key + "-" + b2.versionName);
                        if (!com.baidu.sofire.utility.c.a(file3)) {
                            com.baidu.sofire.utility.c.a(file2, file3);
                        }
                        com.baidu.sofire.c.a(f37042b, b2.key, file2, file3);
                    }
                    if (a(b2.key, b2.versionName, null)) {
                        return true;
                    }
                }
                return a.d(str) != null;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
