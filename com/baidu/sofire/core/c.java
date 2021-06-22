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
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.rp.Report;
import com.baidu.sofire.utility.o;
import com.baidu.sofire.utility.s;
import com.baidu.sofire.utility.x;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public static Context f10234b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10235c = false;

    /* renamed from: d  reason: collision with root package name */
    public static List<Integer> f10236d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public static c f10237f;

    /* renamed from: g  reason: collision with root package name */
    public static int f10238g;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sofire.h.a f10239a;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f10240e = false;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.sofire.a.a f10241h;

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        f10234b = applicationContext;
        this.f10241h = com.baidu.sofire.a.a.a(applicationContext);
        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(f10234b);
        this.f10239a = a2;
        SharedPreferences sharedPreferences = a2.f10323c;
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public final synchronized void b() {
        String str;
        try {
            if (this.f10240e) {
                return;
            }
            this.f10240e = true;
            s.a(f10234b);
            com.baidu.sofire.utility.c.n(f10234b);
            this.f10239a.a(true);
            com.baidu.sofire.j.a.a().a(f10234b, null);
            JSONObject o = com.baidu.sofire.utility.c.o(f10234b);
            com.baidu.sofire.utility.c.d(f10234b);
            com.baidu.sofire.h.a aVar = this.f10239a;
            aVar.f10322b.putString("ssv", "3.5.8.6");
            aVar.f10322b.commit();
            Report.getInstance(f10234b).n();
            for (ApkInfo apkInfo : this.f10241h.a()) {
                try {
                    str = f10234b.getFilesDir().getCanonicalPath();
                } catch (IOException unused) {
                    com.baidu.sofire.utility.c.a();
                    str = null;
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/." + apkInfo.key;
                    StringBuilder sb = new StringBuilder();
                    sb.append(apkInfo.dataDir);
                    sb.append("/lib");
                    com.baidu.sofire.utility.c.d(sb.toString());
                }
            }
            this.f10241h.d();
            if (!this.f10239a.f10321a.getBoolean("iio", false)) {
                com.baidu.sofire.h.a aVar2 = this.f10239a;
                aVar2.f10322b.putBoolean("iio", true);
                aVar2.f10322b.commit();
            } else {
                com.baidu.sofire.a.a aVar3 = this.f10241h;
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", (Integer) 0);
                aVar3.f10170c.update("pgn", contentValues, "n=-1", null);
            }
            x.a(f10234b).b(new U(f10234b, 1, false, o));
        } catch (Throwable unused2) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public final void c() {
        try {
            List<ApkInfo> a2 = this.f10241h.a();
            final List<Integer> q = this.f10239a.q();
            List<Integer> p = this.f10239a.p();
            for (int i2 = 0; i2 < p.size(); i2++) {
                if (!q.contains(p.get(i2))) {
                    q.add(p.get(i2));
                }
            }
            Collections.sort(a2, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.core.c.1
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
                            List list = q;
                            int indexOf = (list == null || !list.contains(Integer.valueOf(apkInfo3.key))) ? -1 : q.indexOf(Integer.valueOf(apkInfo3.key));
                            List list2 = q;
                            int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo4.key))) ? -1 : q.indexOf(Integer.valueOf(apkInfo4.key));
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
            for (ApkInfo apkInfo : a2) {
                f a3 = f.a();
                if ((a3 != null ? a3.d(apkInfo.packageName) : null) == null) {
                    boolean z = this.f10241h.g(apkInfo.key) != 3;
                    if (this.f10239a.b() && z) {
                        File file = new File(f10234b.getFilesDir(), ".b");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(apkInfo.pkgPath);
                        File file3 = new File(file, apkInfo.key + "-" + apkInfo.versionName);
                        if (!com.baidu.sofire.utility.c.a(file3)) {
                            com.baidu.sofire.utility.c.a(file2, file3);
                        }
                        com.baidu.sofire.c.a(f10234b, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(f10234b.getFilesDir(), ".b");
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

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            try {
                if (str.equals("xytk")) {
                    d.f10250a = this.f10239a.E();
                }
                if (str.equals("xyus")) {
                    this.f10239a.k();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public static c a() {
        return f10237f;
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f10237f == null) {
                f10237f = new c(context.getApplicationContext());
            }
            cVar = f10237f;
        }
        return cVar;
    }

    public final void a(JSONObject jSONObject) {
        ApkInfo apkInfo;
        if (jSONObject == null) {
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
                    if (com.baidu.sofire.utility.c.f10406h != null && (apkInfo = com.baidu.sofire.utility.c.f10406h.get(Integer.valueOf(optInt2))) != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                        try {
                            a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                        } catch (Throwable unused2) {
                            com.baidu.sofire.utility.c.a();
                            return;
                        }
                    }
                }
            }
            if (com.baidu.sofire.utility.c.f10406h != null) {
                com.baidu.sofire.utility.c.f10406h.clear();
                com.baidu.sofire.utility.c.f10406h = null;
            }
        } catch (Throwable unused3) {
        }
    }

    public static void c(String str) {
        f a2;
        ApkInfo d2;
        try {
            if (TextUtils.isEmpty(str) || (a2 = f.a()) == null || (d2 = a2.d(str)) == null) {
                return;
            }
            Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
            Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f10234b);
            if (invoke == null) {
                return;
            }
            com.baidu.sofire.utility.c.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
            a2.b(str);
        } catch (Throwable unused) {
        }
    }

    public final boolean b(String str) {
        this.f10241h.d();
        this.f10240e = true;
        return a(f10234b, str);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IF, IF, IF, NOP, INVOKE, IF, NOP] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a3, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i2, String str, String str2, PackageInfo packageInfo) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        boolean z;
        try {
            ApkInfo a2 = this.f10241h.a(i2);
            if (a2 != null) {
                if (!com.baidu.sofire.utility.c.b(str, a2.versionName)) {
                    return;
                }
                ApkInfo a3 = this.f10241h.a(i2);
                if (a3 != null) {
                    this.f10241h.h(i2);
                    File file = new File(a3.pkgPath);
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
                File file3 = new File(f10234b.getFilesDir(), ".tmp");
                if (!file3.exists()) {
                    file3.mkdir();
                }
                File file4 = new File(file3, i2 + "-" + str + ".zip");
                try {
                    fileOutputStream = new FileOutputStream(file4);
                    try {
                        inputStream2 = f10234b.getAssets().open(String.valueOf(i2));
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
                        String a4 = o.a(file4);
                        if (a4 != null && a4.equalsIgnoreCase(str2)) {
                            ApkInfo apkInfo = new ApkInfo(i2, str, file4.getAbsolutePath());
                            apkInfo.apkMD5 = a4;
                            apkInfo.priority = 1;
                            this.f10241h.a(apkInfo);
                            if (this.f10241h.g(i2) != 3) {
                                z = true;
                            }
                            if (this.f10239a.b() && z) {
                                File file5 = new File(f10234b.getFilesDir(), ".b");
                                if (!file5.exists()) {
                                    file5.mkdir();
                                }
                                File file6 = new File(file5, i2 + "-" + str);
                                if (!com.baidu.sofire.utility.c.a(file6)) {
                                    com.baidu.sofire.utility.c.a(file4, file6);
                                }
                                com.baidu.sofire.c.a(f10234b, i2, file4, file6);
                            } else {
                                File file7 = new File(f10234b.getFilesDir(), ".b");
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
                            this.f10241h.h(i2);
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
            ApkInfo a5 = this.f10241h.a(i2);
            if (a5 != null && com.baidu.sofire.utility.c.c(a5.pkgPath)) {
                if (a(i2, str, packageInfo)) {
                    f10236d.add(Integer.valueOf(i2));
                    com.baidu.sofire.h.a aVar = this.f10239a;
                    aVar.f10322b.putString("g_l_l_p_v_" + i2, str);
                    aVar.f10322b.commit();
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
        return a(i2, str, false, packageInfo);
    }

    private synchronized boolean a(int i2, String str, boolean z, PackageInfo packageInfo) {
        String str2;
        String str3;
        if (z) {
            try {
                if (this.f10241h.c(i2) != 1) {
                    return false;
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return false;
            }
        }
        ApkInfo a2 = this.f10241h.a(i2);
        if (a2 == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", 1);
            hashMap.put("1", String.valueOf(i2));
            hashMap.put("2", str);
            if (!z) {
                com.baidu.sofire.utility.c.a(f10234b, "1003105", (Map<String, Object>) hashMap, false);
            }
            return false;
        } else if (!com.baidu.sofire.utility.c.a(new File(a2.pkgPath))) {
            this.f10241h.f(i2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("0", 3);
            hashMap2.put("1", String.valueOf(i2));
            hashMap2.put("2", str);
            if (!z) {
                com.baidu.sofire.utility.c.a(f10234b, "1003105", (Map<String, Object>) hashMap2, false);
            }
            return false;
        } else {
            if (packageInfo != null) {
                a2.cloudPkgInfo = packageInfo;
            }
            f a3 = f.a(f10234b.getApplicationContext());
            if (!a3.a(a2, false)) {
                this.f10241h.f(i2);
                a3.a(a2.pkgPath);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 4);
                hashMap3.put("1", String.valueOf(i2));
                hashMap3.put("2", str);
                if (!z) {
                    com.baidu.sofire.utility.c.a(f10234b, "1003105", (Map<String, Object>) hashMap3, false);
                }
                return false;
            }
            String[] g2 = com.baidu.sofire.utility.c.g(f10234b);
            if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                str2 = g2[0];
                str3 = g2[1];
            } else {
                str2 = com.baidu.sofire.utility.c.f10403e;
                str3 = com.baidu.sofire.utility.c.f10404f;
            }
            ApkInfo c2 = a3.c(a2.pkgPath);
            e eVar = (e) c2.classLoader;
            Class<?> a4 = eVar.a("com.baidu.sofire.engine.EngineImpl");
            if (a4 == null) {
                Class<?> a5 = eVar.a("java.lang.String");
                HashMap hashMap4 = new HashMap();
                hashMap4.put("0", 9);
                hashMap4.put("1", String.valueOf(i2));
                hashMap4.put("2", str);
                hashMap4.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a5).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
                if (!z) {
                    com.baidu.sofire.utility.c.a(f10234b, "1003105", (Map<String, Object>) hashMap4, false);
                }
                this.f10241h.f(i2);
                return false;
            }
            Object invoke = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, f10234b);
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
                    com.baidu.sofire.utility.c.a(f10234b, "1003105", (Map<String, Object>) hashMap5, false);
                }
                this.f10241h.f(i2);
                a3.a(c2.pkgPath);
                return false;
            }
            c2.initStatus = 1;
            c2.apkParseSuc = 1;
            this.f10241h.a(c2);
            int g3 = this.f10241h.g(c2.key);
            if (g3 < 3 && g3 != -1) {
                this.f10241h.b(c2.key, g3 + 1);
            }
            HashMap hashMap6 = new HashMap();
            hashMap6.put("0", 0);
            hashMap6.put("1", Integer.valueOf(i2));
            hashMap6.put("2", str);
            if (!z) {
                com.baidu.sofire.utility.c.a(f10234b, "1003105", (Map<String, Object>) hashMap6, false);
            }
            com.baidu.sofire.utility.c.c(f10234b);
            return true;
        }
    }

    public final void a(String str, String str2) {
        try {
            this.f10241h.a(str);
            File file = new File(str2);
            if (file.exists()) {
                com.baidu.sofire.c.a(file);
                file.delete();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x033c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:98:0x034c */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x003f: IGET  (r15v12 int A[REMOVE]) = (r2v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x010b: IGET  (r9v12 int A[REMOVE]) = (r2v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x028b: IGET  (r8v24 int A[REMOVE]) = (r2v9 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x031f: IGET  (r4v2 int A[REMOVE]) = (r2v9 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x039b: IGET  (r8v5 int A[REMOVE]) = (r2v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0363: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:103:0x035e */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0183 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0185 A[Catch: all -> 0x034c, TryCatch #4 {all -> 0x034c, blocks: (B:24:0x011d, B:31:0x0147, B:33:0x0153, B:35:0x015b, B:37:0x0164, B:39:0x016e, B:42:0x017b, B:46:0x0185, B:48:0x0191, B:41:0x0177), top: B:121:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025b A[Catch: all -> 0x033e, TRY_LEAVE, TryCatch #12 {all -> 0x033e, blocks: (B:61:0x0238, B:63:0x025b, B:60:0x0235), top: B:134:0x0235 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a3 A[Catch: all -> 0x033c, TryCatch #10 {all -> 0x033c, blocks: (B:65:0x0283, B:67:0x02a3, B:69:0x02a9, B:71:0x02b8), top: B:132:0x0259 }] */
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
        CharSequence charSequence;
        Object obj;
        String str2;
        Object obj2;
        String str3;
        boolean a2;
        HashMap hashMap;
        StringBuilder sb;
        Object obj3;
        Class cls;
        Integer num;
        String str4;
        String str5;
        Object obj4;
        int i2;
        File file;
        Class[] clsArr;
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
                charSequence = "\r";
                obj = "3";
                obj2 = "0";
                str2 = str3;
            }
        } catch (Throwable th2) {
            th = th2;
            charSequence = "\r";
            obj = "3";
            r15 = "2";
            str2 = "1";
        }
        if (!com.baidu.sofire.utility.c.a(file2)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("0", 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(apkInfo2.key);
            hashMap2.put("1", sb2.toString());
            hashMap2.put("2", apkInfo2.versionName);
            StringBuilder sb3 = new StringBuilder("nowTime:");
            sb3.append(System.currentTimeMillis());
            sb3.append(", nowFileInfo: path=");
            sb3.append(file2.getAbsolutePath());
            sb3.append(", exists=");
            sb3.append(file2.exists());
            sb3.append(", canRead=");
            sb3.append(file2.canRead());
            sb3.append(", isFile=");
            sb3.append(file2.isFile());
            sb3.append(",length");
            sb3.append(file2.length());
            sb3.append(" - ");
            sb3.append(str);
            hashMap2.put("3", Base64.encodeToString(sb3.toString().getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
            com.baidu.sofire.utility.c.a(f10234b, "1003106", (Map<String, Object>) hashMap2, false);
            return false;
        }
        if (!this.f10241h.b(apkInfo2.key)) {
            this.f10241h.a(apkInfo2);
        }
        f a3 = f.a(f10234b.getApplicationContext());
        ?? r152 = 1;
        try {
            this.f10241h.a(apkInfo2.key, 1);
            c(apkInfo2.packageName);
            a2 = a3.a(apkInfo2, true);
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
            charSequence = "\r";
        }
        if (!a2) {
            try {
                hashMap = new HashMap();
                hashMap.put("0", 2);
                sb = new StringBuilder();
                sb.append(apkInfo2.key);
                obj3 = "1";
            } catch (Throwable th5) {
                th = th5;
                a2 = "1";
            }
            try {
                hashMap.put(obj3, sb.toString());
                hashMap.put("2", apkInfo2.versionName);
                com.baidu.sofire.utility.c.a(f10234b, "1003106", (Map<String, Object>) hashMap, false);
                com.baidu.sofire.c.a(file2);
                file2.delete();
                a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                this.f10241h.a(apkInfo2.key, 0);
                return false;
            } catch (Throwable th6) {
                th = th6;
                a2 = obj3;
                r152 = "2";
                charSequence = "\r";
                obj = "3";
                str2 = a2;
                r15 = r152;
                obj2 = "0";
                try {
                    com.baidu.sofire.c.a(file2);
                    c(apkInfo2.packageName);
                    file2.delete();
                    a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                    this.f10241h.a(apkInfo2.key, 0);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(obj2, 5);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(apkInfo2.key);
                    hashMap3.put(str2, sb4.toString());
                    hashMap3.put(r15, apkInfo2.versionName);
                    hashMap3.put(obj, Base64.encodeToString(com.baidu.sofire.b.a(th).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace(charSequence, ""));
                    com.baidu.sofire.utility.c.a(f10234b, "1003106", (Map<String, Object>) hashMap3, false);
                    return false;
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                    return false;
                }
            }
        }
        str2 = "1";
        r15 = "2";
        String[] g2 = com.baidu.sofire.utility.c.g(f10234b);
        if (g2 == null) {
            cls = String.class;
            num = 0;
        } else {
            num = 0;
            cls = String.class;
            if (g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                str4 = g2[0];
                str5 = g2[1];
                apkInfo2 = a3.c(apkInfo2.pkgPath);
                if (apkInfo2 != null) {
                    return false;
                }
                e eVar = (e) apkInfo2.classLoader;
                Class<?> a4 = eVar.a("com.baidu.sofire.engine.EngineImpl");
                if (a4 == null) {
                    Class<?> a5 = eVar.a("java.lang.String");
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("0", 6);
                    StringBuilder sb5 = new StringBuilder();
                    obj4 = "0";
                    try {
                        sb5.append(apkInfo2.key);
                        hashMap4.put(str2, sb5.toString());
                        hashMap4.put(r15, apkInfo2.versionName);
                        hashMap4.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a5).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
                        com.baidu.sofire.utility.c.a(f10234b, "1003106", (Map<String, Object>) hashMap4, false);
                        com.baidu.sofire.c.a(file2);
                        file2.delete();
                        this.f10241h.a(apkInfo2.key, 0);
                        return false;
                    } catch (Throwable th7) {
                        th = th7;
                        charSequence = "\r";
                        obj = "3";
                    }
                } else {
                    obj4 = "0";
                    obj = "3";
                    try {
                        obj2 = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, f10234b);
                        try {
                            clsArr = new Class[]{cls, cls};
                            charSequence = "\r";
                        } catch (Throwable unused2) {
                            charSequence = "\r";
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
                                this.f10241h.a(apkInfo2.key, 0);
                                HashMap hashMap5 = new HashMap();
                                hashMap5.put(obj4, 4);
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(apkInfo2.key);
                                hashMap5.put(str2, sb6.toString());
                                hashMap5.put(r15, apkInfo2.versionName);
                                com.baidu.sofire.utility.c.a(f10234b, "1003106", (Map<String, Object>) hashMap5, false);
                                return false;
                            }
                            if (apkInfo2.isMem) {
                                com.baidu.sofire.c.a(file2);
                                file2.delete();
                                com.baidu.sofire.utility.c.d(apkInfo2.dataDir);
                                if (f.f10275b != null) {
                                    f.f10275b.add(Integer.valueOf(apkInfo2.key));
                                }
                            }
                            try {
                                ApkInfo a6 = this.f10241h.a(apkInfo2.key);
                                if (a6 == null || a6.versionName.equals(apkInfo2.versionName)) {
                                    i2 = 1;
                                    file = null;
                                } else {
                                    file = new File(a6.pkgPath);
                                    i2 = 1;
                                }
                                apkInfo2.initStatus = i2;
                                apkInfo2.apkParseSuc = i2;
                                if (this.f10241h.a(apkInfo2) > 0 && file != null && file.exists()) {
                                    com.baidu.sofire.c.a(file);
                                    file.delete();
                                }
                                this.f10241h.a(apkInfo2.key, 0);
                                com.baidu.sofire.utility.c.c(f10234b);
                                HashMap hashMap6 = new HashMap();
                                hashMap6.put(obj4, num);
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(apkInfo2.key);
                                hashMap6.put(str2, sb7.toString());
                                hashMap6.put(r15, apkInfo2.versionName);
                                com.baidu.sofire.utility.c.a(f10234b, "1003106", (Map<String, Object>) hashMap6, false);
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
                        charSequence = "\r";
                    }
                }
                obj2 = obj4;
                com.baidu.sofire.c.a(file2);
                c(apkInfo2.packageName);
                file2.delete();
                a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                this.f10241h.a(apkInfo2.key, 0);
                HashMap hashMap32 = new HashMap();
                hashMap32.put(obj2, 5);
                StringBuilder sb42 = new StringBuilder();
                sb42.append(apkInfo2.key);
                hashMap32.put(str2, sb42.toString());
                hashMap32.put(r15, apkInfo2.versionName);
                hashMap32.put(obj, Base64.encodeToString(com.baidu.sofire.b.a(th).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace(charSequence, ""));
                com.baidu.sofire.utility.c.a(f10234b, "1003106", (Map<String, Object>) hashMap32, false);
                return false;
            }
        }
        str4 = com.baidu.sofire.utility.c.f10403e;
        str5 = com.baidu.sofire.utility.c.f10404f;
        apkInfo2 = a3.c(apkInfo2.pkgPath);
        if (apkInfo2 != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i2, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        boolean z;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i2));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            com.baidu.sofire.utility.c.a(f10234b, "1003136", (Map<String, Object>) hashMap, false);
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
                hashMap.put("3", "11");
                com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
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
                                    com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
                                } catch (Throwable unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    try {
                        hashMap.put("3", Integer.toString(16));
                        com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
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
                        com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
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
                        com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
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
                        com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
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
                        com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
                        return;
                    } catch (Throwable unused11) {
                        return;
                    }
                }
            }
            if (this.f10241h.d(i2)) {
                long currentTimeMillis = System.currentTimeMillis();
                while (this.f10241h.d(i2) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                    SystemClock.sleep(300L);
                }
            }
            if (this.f10241h.d(i2)) {
                if (callback != null) {
                    callback.onError(3);
                }
                try {
                    hashMap.put("3", Integer.toString(12));
                    com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
                    return;
                } catch (Throwable unused12) {
                    return;
                }
            }
            if (!this.f10240e) {
                a(3);
                b();
            }
            f a2 = f.a(f10234b.getApplicationContext());
            ApkInfo apkInfo = null;
            long currentTimeMillis2 = System.currentTimeMillis();
            while (System.currentTimeMillis() - currentTimeMillis2 <= 15000) {
                apkInfo = this.f10241h.a(i2);
                if (apkInfo != null) {
                    if (a2.d(apkInfo.packageName) == null) {
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
                    com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, false);
                    return;
                } catch (Throwable unused13) {
                    return;
                }
            }
            Class<?> a3 = ((e) a2.d(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
            Object a4 = com.baidu.sofire.utility.c.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f10234b), str, clsArr, objArr);
            if (callback != null) {
                callback.onEnd(a4);
            }
        } catch (Throwable unused14) {
            com.baidu.sofire.utility.c.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Integer, Object> a(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.toString(i2));
        hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
        hashMap.put("2", "1");
        com.baidu.sofire.utility.c.a(f10234b, "1003136", (Map<String, Object>) hashMap, true);
        if (TextUtils.isEmpty(str)) {
            hashMap.put("3", "1");
            com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
            return new Pair<>(1, null);
        }
        int i3 = 10;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                if (this.f10241h.d(i2)) {
                                    Pair<Integer, Object> pair = new Pair<>(3, null);
                                    try {
                                        hashMap.put("3", Integer.toString(2));
                                        com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
                                    } catch (Throwable unused) {
                                    }
                                    return pair;
                                } else if (!this.f10240e) {
                                    Pair<Integer, Object> pair2 = new Pair<>(3, null);
                                    try {
                                        hashMap.put("3", Integer.toString(3));
                                        com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
                                    } catch (Throwable unused2) {
                                    }
                                    return pair2;
                                } else {
                                    f a2 = f.a();
                                    if (a2 == null) {
                                        Pair<Integer, Object> pair3 = new Pair<>(3, null);
                                        try {
                                            hashMap.put("3", Integer.toString(4));
                                            com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
                                        } catch (Throwable unused3) {
                                        }
                                        return pair3;
                                    }
                                    ApkInfo a3 = this.f10241h.a(i2);
                                    if (!((a3 == null || a2.d(a3.packageName) == null) ? false : true)) {
                                        Pair<Integer, Object> pair4 = new Pair<>(4, null);
                                        try {
                                            hashMap.put("3", Integer.toString(5));
                                            com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
                                        } catch (Throwable unused4) {
                                        }
                                        return pair4;
                                    }
                                    Class<?> a4 = ((e) a2.d(a3.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                    return new Pair<>(0, com.baidu.sofire.utility.c.a(a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, f10234b), str, clsArr, objArr));
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (i3 != 0) {
                                    try {
                                        hashMap.put("3", Integer.toString(i3));
                                        com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
                                    } catch (Throwable unused5) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i3 = 6;
                            if (i3 != 0) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i3 = 7;
                        if (i3 != 0) {
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    i3 = 8;
                    if (i3 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                i3 = 9;
                if (i3 != 0) {
                }
                throw th;
            }
        } catch (IllegalAccessException unused6) {
            Pair<Integer, Object> pair5 = new Pair<>(2, null);
            try {
                hashMap.put("3", Integer.toString(8));
                com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
            } catch (Throwable unused7) {
            }
            return pair5;
        } catch (IllegalArgumentException unused8) {
            Pair<Integer, Object> pair6 = new Pair<>(2, null);
            try {
                hashMap.put("3", Integer.toString(9));
                com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
            } catch (Throwable unused9) {
            }
            return pair6;
        } catch (NoSuchMethodException unused10) {
            Pair<Integer, Object> pair7 = new Pair<>(2, null);
            try {
                hashMap.put("3", Integer.toString(6));
                com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
            } catch (Throwable unused11) {
            }
            return pair7;
        } catch (InvocationTargetException unused12) {
            Pair<Integer, Object> pair8 = new Pair<>(2, null);
            try {
                hashMap.put("3", Integer.toString(7));
                com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
            } catch (Throwable unused13) {
            }
            return pair8;
        } catch (Throwable unused14) {
            Pair<Integer, Object> pair9 = new Pair<>(3, null);
            try {
                hashMap.put("3", Integer.toString(10));
                com.baidu.sofire.utility.c.a(f10234b, "1003141", (Map<String, Object>) hashMap, true);
            } catch (Throwable unused15) {
            }
            return pair9;
        }
    }

    public final void a(final String str) {
        try {
            x.a(f10234b).a(new Runnable() { // from class: com.baidu.sofire.core.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    final f a2;
                    try {
                        if (TextUtils.isEmpty(str) || (a2 = f.a(c.f10234b.getApplicationContext())) == null) {
                            return;
                        }
                        final File file = new File(c.f10234b.getFilesDir(), ".b");
                        final ApkInfo d2 = a2.d(str);
                        if (d2 == null) {
                            ApkInfo b2 = c.this.f10241h.b(str);
                            if (b2 == null) {
                                return;
                            }
                            c.this.a(str, b2.pkgPath);
                            if (file.exists()) {
                                File file2 = new File(file, b2.key + "-" + b2.versionName);
                                if (com.baidu.sofire.utility.c.a(file2)) {
                                    file2.delete();
                                }
                            }
                            if (b2 != null) {
                                String canonicalPath = c.f10234b.getFilesDir().getCanonicalPath();
                                com.baidu.sofire.utility.c.d(canonicalPath + "/." + b2.key);
                                com.baidu.sofire.utility.c.d(c.f10234b.getFileStreamPath(b2.packageName).getAbsolutePath());
                            }
                            String sb = new StringBuilder(str).reverse().toString();
                            ApkInfo b3 = c.this.f10241h.b(sb);
                            if (b3 != null) {
                                c.this.a(sb, b3.pkgPath);
                                return;
                            }
                            return;
                        }
                        Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                        Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, c.f10234b);
                        if (invoke == null) {
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.core.c.2.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public final void run() {
                                String str2;
                                ApkInfo d3 = a2.d(str);
                                if (d3 == null || (str2 = d3.versionName) == null || !str2.equals(d2.versionName)) {
                                    return;
                                }
                                a2.b(str);
                                c.this.f10241h.a(str);
                                com.baidu.sofire.utility.c.c(c.f10234b);
                                File file3 = new File(d2.pkgPath);
                                if (file3.exists()) {
                                    com.baidu.sofire.c.a(file3);
                                    file3.delete();
                                }
                                if (file.exists()) {
                                    File file4 = file;
                                    File file5 = new File(file4, d2.key + "-" + d2.versionName);
                                    if (com.baidu.sofire.utility.c.a(file5)) {
                                        file5.delete();
                                    }
                                }
                                String sb2 = new StringBuilder(str).reverse().toString();
                                ApkInfo b4 = c.this.f10241h.b(sb2);
                                if (b4 != null) {
                                    c.this.a(sb2, b4.pkgPath);
                                }
                            }
                        }, 600000L);
                        com.baidu.sofire.utility.c.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                        a2.b(str);
                        c.this.f10241h.a(str);
                        com.baidu.sofire.utility.c.c(c.f10234b);
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
                        String sb2 = new StringBuilder(str).reverse().toString();
                        ApkInfo b4 = c.this.f10241h.b(sb2);
                        if (b4 != null) {
                            c.this.a(sb2, b4.pkgPath);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public static void a(int i2) {
        if (f10238g == 0) {
            f10238g = i2;
        }
    }

    private boolean a(Context context, String str) {
        try {
            f a2 = f.a(context);
            if (a2 == null) {
                return false;
            }
            if (a2.d(str) != null) {
                return true;
            }
            if (this.f10241h == null) {
                this.f10241h = com.baidu.sofire.a.a.a(f10234b);
            }
            ApkInfo b2 = this.f10241h.b(str);
            if (b2 != null) {
                if (this.f10239a.b()) {
                    File file = new File(f10234b.getFilesDir(), ".b");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(b2.pkgPath);
                    File file3 = new File(file, b2.key + "-" + b2.versionName);
                    if (!com.baidu.sofire.utility.c.a(file3)) {
                        com.baidu.sofire.utility.c.a(file2, file3);
                    }
                    com.baidu.sofire.c.a(f10234b, b2.key, file2, file3);
                }
                if (a(b2.key, b2.versionName, null)) {
                    return true;
                }
            }
            return a2.d(str) != null;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return false;
        }
    }
}
