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
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.g.n;
import com.baidu.sofire.g.r;
import com.baidu.sofire.rp.Report;
import com.tencent.connect.common.Constants;
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
    public static Context f11328b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f11329c = false;

    /* renamed from: d  reason: collision with root package name */
    public static List<Integer> f11330d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public static c f11331f;

    /* renamed from: h  reason: collision with root package name */
    public static int f11332h;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sofire.e f11333a;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f11334e = false;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.sofire.g f11335g;
    public com.baidu.sofire.a.a i;

    public c(Context context) {
        com.baidu.sofire.b.a();
        Context applicationContext = context.getApplicationContext();
        f11328b = applicationContext;
        this.i = com.baidu.sofire.a.a.a(applicationContext);
        this.f11333a = new com.baidu.sofire.e(f11328b);
        com.baidu.sofire.g gVar = new com.baidu.sofire.g(f11328b);
        this.f11335g = gVar;
        SharedPreferences sharedPreferences = gVar.f11414a;
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public final synchronized void b() {
        String str;
        try {
            if (this.f11334e) {
                return;
            }
            this.f11334e = true;
            r.a(f11328b);
            com.baidu.sofire.g.d.o(f11328b);
            this.f11333a.a(true);
            com.baidu.sofire.h.a.a().a(f11328b, null);
            JSONObject p = com.baidu.sofire.g.d.p(f11328b);
            com.baidu.sofire.g.d.e(f11328b);
            new StringBuilder().append(this.f11334e);
            com.baidu.sofire.b.a();
            com.baidu.sofire.e eVar = this.f11333a;
            eVar.f11400c.putString("ssv", "3.5.7.3");
            eVar.f11400c.commit();
            Report.getInstance(f11328b).n();
            for (ApkInfo apkInfo : this.i.a()) {
                try {
                    str = f11328b.getFilesDir().getCanonicalPath();
                } catch (IOException unused) {
                    com.baidu.sofire.g.d.a();
                    str = null;
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/." + apkInfo.key;
                    StringBuilder sb = new StringBuilder();
                    sb.append(apkInfo.dataDir);
                    sb.append("/lib");
                    com.baidu.sofire.g.d.d(sb.toString());
                }
            }
            this.i.d();
            com.baidu.sofire.b.a();
            new StringBuilder().append(this.f11333a.a());
            com.baidu.sofire.b.a();
            if (!this.f11333a.a()) {
                com.baidu.sofire.e eVar2 = this.f11333a;
                eVar2.f11400c.putBoolean("iio", true);
                eVar2.f11400c.commit();
            } else {
                com.baidu.sofire.a.a aVar = this.i;
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", (Integer) 0);
                aVar.f11295c.update("pgn", contentValues, "n=-1", null);
            }
            new U(f11328b, 1, false, p).start();
        } catch (Throwable unused2) {
            com.baidu.sofire.g.d.a();
        }
    }

    public final void c() {
        boolean z;
        try {
            List<ApkInfo> a2 = this.i.a();
            new StringBuilder("all=").append(a2);
            com.baidu.sofire.b.a();
            final List<Integer> r = this.f11333a.r();
            List<Integer> q = this.f11333a.q();
            for (int i = 0; i < q.size(); i++) {
                if (!r.contains(q.get(i))) {
                    r.add(q.get(i));
                }
            }
            Collections.sort(a2, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.core.c.1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ApkInfo apkInfo, ApkInfo apkInfo2) {
                    int i2;
                    int i3;
                    ApkInfo apkInfo3 = apkInfo;
                    ApkInfo apkInfo4 = apkInfo2;
                    if (apkInfo3.priority != -1 || apkInfo4.priority == -1) {
                        if ((apkInfo3.priority == -1 || apkInfo4.priority != -1) && (i2 = apkInfo3.priority) >= (i3 = apkInfo4.priority)) {
                            if (i2 > i3) {
                                return 1;
                            }
                            List list = r;
                            int indexOf = (list == null || !list.contains(Integer.valueOf(apkInfo3.key))) ? -1 : r.indexOf(Integer.valueOf(apkInfo3.key));
                            List list2 = r;
                            int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo4.key))) ? -1 : r.indexOf(Integer.valueOf(apkInfo4.key));
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
                    if (this.i.g(apkInfo.key) == 3) {
                        com.baidu.sofire.b.a();
                        z = false;
                    } else {
                        z = true;
                    }
                    if (this.f11333a.c() && z) {
                        File file = new File(f11328b.getFilesDir(), ".b");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(apkInfo.pkgPath);
                        File file3 = new File(file, apkInfo.key + "-" + apkInfo.versionName);
                        if (!com.baidu.sofire.g.d.a(file3)) {
                            com.baidu.sofire.g.d.a(file2, file3);
                        }
                        com.baidu.sofire.c.a(f11328b, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(f11328b.getFilesDir(), ".b");
                        if (file4.exists()) {
                            File file5 = new File(file4, apkInfo.key + "-" + apkInfo.versionName);
                            if (com.baidu.sofire.g.d.a(file5)) {
                                com.baidu.sofire.c.a(file5);
                                boolean delete = file5.delete();
                                StringBuilder sb = new StringBuilder();
                                sb.append(file5.getAbsolutePath());
                                sb.append(" s=");
                                sb.append(delete);
                                com.baidu.sofire.b.a();
                            }
                        }
                    }
                    a(apkInfo.key, apkInfo.versionName, null);
                }
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            try {
                if (str.equals("xytk")) {
                    com.baidu.sofire.b.a();
                    d.f11344a = this.f11335g.a();
                }
                if (str.equals("xyus")) {
                    this.f11333a.l();
                    com.baidu.sofire.b.a();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
        }
    }

    public static c a() {
        return f11331f;
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f11331f == null) {
                f11331f = new c(context.getApplicationContext());
            }
            cVar = f11331f;
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
                                com.baidu.sofire.g.d.a();
                            }
                        }
                        if (arrayList.size() > 0) {
                            packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                        }
                    }
                    if (com.baidu.sofire.g.d.f11424h != null && (apkInfo = com.baidu.sofire.g.d.f11424h.get(Integer.valueOf(optInt2))) != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                        try {
                            a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                        } catch (Throwable unused2) {
                            com.baidu.sofire.g.d.a();
                            return;
                        }
                    }
                }
            }
            if (com.baidu.sofire.g.d.f11424h != null) {
                com.baidu.sofire.g.d.f11424h.clear();
                com.baidu.sofire.g.d.f11424h = null;
            }
        } catch (Throwable unused3) {
        }
    }

    public static void c(String str) {
        f a2;
        ApkInfo d2;
        new StringBuilder().append(str);
        com.baidu.sofire.b.a();
        try {
            if (TextUtils.isEmpty(str) || (a2 = f.a()) == null || (d2 = a2.d(str)) == null) {
                return;
            }
            Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
            Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f11328b);
            if (invoke == null) {
                return;
            }
            new StringBuilder().append(com.baidu.sofire.g.d.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
            com.baidu.sofire.b.a();
            a2.b(str);
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.c();
        }
    }

    public final boolean b(String str) {
        this.i.d();
        this.f11334e = true;
        return a(f11328b, str);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IF, IF, IF, NOP, INVOKE, IF, NOP] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01d9, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, String str, String str2, PackageInfo packageInfo) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        boolean z;
        try {
            ApkInfo a2 = this.i.a(i);
            if (a2 != null) {
                if (!com.baidu.sofire.g.d.b(str, a2.versionName)) {
                    return;
                }
                ApkInfo a3 = this.i.a(i);
                if (a3 != null) {
                    this.i.h(i);
                    File file = new File(a3.pkgPath);
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.getAbsolutePath());
                    sb.append(", e=");
                    sb.append(file.exists());
                    com.baidu.sofire.b.a();
                    if (file.exists()) {
                        com.baidu.sofire.c.a(file);
                        boolean delete = file.delete();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(file.getAbsolutePath());
                        sb2.append(" s=");
                        sb2.append(delete);
                        com.baidu.sofire.b.a();
                    }
                }
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        File file2 = null;
        InputStream inputStream2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                fileOutputStream = null;
            } else {
                File file3 = new File(f11328b.getFilesDir(), ".tmp");
                if (!file3.exists()) {
                    file3.mkdir();
                }
                File file4 = new File(file3, i + "-" + str + ".zip");
                try {
                    fileOutputStream = new FileOutputStream(file4);
                    try {
                        inputStream2 = f11328b.getAssets().open(String.valueOf(i));
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
                        com.baidu.sofire.g.d.a(file4.getAbsolutePath(), true);
                        String a4 = n.a(file4);
                        if (a4 != null && a4.equalsIgnoreCase(str2)) {
                            ApkInfo apkInfo = new ApkInfo(i, str, file4.getAbsolutePath());
                            apkInfo.apkMD5 = a4;
                            apkInfo.priority = 1;
                            this.i.a(apkInfo);
                            if (this.i.g(i) == 3) {
                                com.baidu.sofire.b.a();
                            } else {
                                z = true;
                            }
                            if (this.f11333a.c() && z) {
                                File file5 = new File(f11328b.getFilesDir(), ".b");
                                if (!file5.exists()) {
                                    file5.mkdir();
                                }
                                File file6 = new File(file5, i + "-" + str);
                                if (!com.baidu.sofire.g.d.a(file6)) {
                                    com.baidu.sofire.g.d.a(file4, file6);
                                }
                                com.baidu.sofire.c.a(f11328b, i, file4, file6);
                            } else {
                                File file7 = new File(f11328b.getFilesDir(), ".b");
                                if (file7.exists()) {
                                    File file8 = new File(file7, i + "-" + str);
                                    if (com.baidu.sofire.g.d.a(file8)) {
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
                            com.baidu.sofire.g.d.a();
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
                            this.i.h(i);
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
            ApkInfo a5 = this.i.a(i);
            if (a5 != null && com.baidu.sofire.g.d.c(a5.pkgPath)) {
                if (a(i, str, packageInfo)) {
                    f11330d.add(Integer.valueOf(i));
                    com.baidu.sofire.e eVar = this.f11333a;
                    eVar.f11400c.putString("g_l_l_p_v_" + i, str);
                    eVar.f11400c.commit();
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

    public final synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        return a(i, str, false, packageInfo);
    }

    private synchronized boolean a(int i, String str, boolean z, PackageInfo packageInfo) {
        String str2;
        String str3;
        try {
            new StringBuilder().append(i);
            com.baidu.sofire.b.a();
            if (!z || this.i.c(i) == 1) {
                ApkInfo a2 = this.i.a(i);
                if (a2 == null) {
                    com.baidu.sofire.b.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", String.valueOf(i));
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.g.d.a(f11328b, "1003105", (Map<String, Object>) hashMap, false);
                    }
                    return false;
                }
                File file = new File(a2.pkgPath);
                file.getAbsolutePath();
                com.baidu.sofire.b.a();
                if (!com.baidu.sofire.g.d.a(file)) {
                    com.baidu.sofire.b.a();
                    this.i.f(i);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", 3);
                    hashMap2.put("1", String.valueOf(i));
                    hashMap2.put("2", str);
                    if (!z) {
                        com.baidu.sofire.g.d.a(f11328b, "1003105", (Map<String, Object>) hashMap2, false);
                    }
                    return false;
                }
                if (packageInfo != null) {
                    a2.cloudPkgInfo = packageInfo;
                }
                f a3 = f.a(f11328b.getApplicationContext());
                com.baidu.sofire.b.a();
                if (!a3.a(a2, false)) {
                    this.i.f(i);
                    a3.a(a2.pkgPath);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("0", 4);
                    hashMap3.put("1", String.valueOf(i));
                    hashMap3.put("2", str);
                    if (!z) {
                        com.baidu.sofire.g.d.a(f11328b, "1003105", (Map<String, Object>) hashMap3, false);
                    }
                    com.baidu.sofire.b.a();
                    return false;
                }
                com.baidu.sofire.b.a();
                String[] h2 = com.baidu.sofire.g.d.h(f11328b);
                if (h2 != null && h2.length == 2 && !TextUtils.isEmpty(h2[0]) && !TextUtils.isEmpty(h2[1])) {
                    str2 = h2[0];
                    str3 = h2[1];
                } else {
                    str2 = com.baidu.sofire.g.d.f11421e;
                    str3 = com.baidu.sofire.g.d.f11422f;
                }
                StringBuilder sb = new StringBuilder("ak=");
                sb.append(str2);
                sb.append(", sk=");
                sb.append(str3);
                com.baidu.sofire.b.a();
                ApkInfo c2 = a3.c(a2.pkgPath);
                e eVar = (e) c2.classLoader;
                Class<?> a4 = eVar.a("com.baidu.sofire.engine.EngineImpl");
                if (a4 == null) {
                    com.baidu.sofire.b.a();
                    Class<?> a5 = eVar.a("java.lang.String");
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("0", 9);
                    hashMap4.put("1", String.valueOf(i));
                    hashMap4.put("2", str);
                    hashMap4.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a5).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
                    if (!z) {
                        com.baidu.sofire.g.d.a(f11328b, "1003105", (Map<String, Object>) hashMap4, false);
                    }
                    this.i.f(i);
                    return false;
                }
                Object invoke = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, f11328b);
                new StringBuilder("ai=").append(invoke);
                com.baidu.sofire.b.a();
                try {
                    com.baidu.sofire.g.d.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
                } catch (Throwable unused) {
                    com.baidu.sofire.g.d.a();
                }
                if (!((Boolean) com.baidu.sofire.g.d.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.TRUE)).booleanValue()) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("0", 6);
                    hashMap5.put("1", String.valueOf(i));
                    hashMap5.put("2", str);
                    if (!z) {
                        com.baidu.sofire.g.d.a(f11328b, "1003105", (Map<String, Object>) hashMap5, false);
                    }
                    this.i.f(i);
                    a3.a(c2.pkgPath);
                    com.baidu.sofire.b.a();
                    return false;
                }
                c2.initStatus = 1;
                c2.apkParseSuc = 1;
                this.i.a(c2);
                com.baidu.sofire.b.a();
                int g2 = this.i.g(c2.key);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(c2.key);
                sb2.append(" ");
                sb2.append(g2);
                com.baidu.sofire.b.a();
                if (g2 < 3 && g2 != -1) {
                    this.i.b(c2.key, g2 + 1);
                }
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 0);
                hashMap6.put("1", Integer.valueOf(i));
                hashMap6.put("2", str);
                if (!z) {
                    com.baidu.sofire.g.d.a(f11328b, "1003105", (Map<String, Object>) hashMap6, false);
                }
                com.baidu.sofire.g.d.d(f11328b);
                return true;
            }
            return false;
        } catch (Throwable unused2) {
            com.baidu.sofire.g.d.a();
            return false;
        }
    }

    public final void a(String str, String str2) {
        try {
            this.i.a(str);
            File file = new File(str2);
            StringBuilder sb = new StringBuilder("f=");
            sb.append(file.getAbsolutePath());
            sb.append(", e=");
            sb.append(file.exists());
            com.baidu.sofire.b.a();
            if (file.exists()) {
                com.baidu.sofire.c.a(file);
                boolean delete = file.delete();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file.getAbsolutePath());
                sb2.append(" s=");
                sb2.append(delete);
                com.baidu.sofire.b.a();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0381 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:99:0x0391 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x004d: IGET  (r15v12 int A[REMOVE]) = (r2v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0119: IGET  (r9v12 int A[REMOVE]) = (r2v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02a2: IGET  (r8v25 int A[REMOVE]) = (r2v9 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0364: IGET  (r4v1 int A[REMOVE]) = (r2v9 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x03e6: IGET  (r8v5 int A[REMOVE]) = (r2v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x03a8: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:104:0x03a3 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0194 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0196 A[Catch: all -> 0x0391, TryCatch #9 {all -> 0x0391, blocks: (B:24:0x012b, B:31:0x0158, B:33:0x0164, B:35:0x016c, B:37:0x0175, B:39:0x017f, B:42:0x018c, B:46:0x0196, B:48:0x01a2, B:41:0x0188), top: B:130:0x0106 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026f A[Catch: all -> 0x0383, TRY_LEAVE, TryCatch #2 {all -> 0x0383, blocks: (B:61:0x024c, B:63:0x026f, B:60:0x0249), top: B:116:0x0249 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02ba A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:65:0x029a, B:67:0x02ba, B:69:0x02c0, B:71:0x02cf), top: B:114:0x026d }] */
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
        Class cls;
        Integer num;
        String str4;
        String str5;
        Object obj3;
        int i;
        File file;
        Class[] clsArr;
        ApkInfo apkInfo2 = apkInfo;
        new StringBuilder().append(apkInfo2);
        com.baidu.sofire.b.a();
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
        if (!com.baidu.sofire.g.d.a(file2)) {
            com.baidu.sofire.b.a();
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
            hashMap.put("3", Base64.encodeToString(sb2.toString().getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
            com.baidu.sofire.g.d.a(f11328b, "1003106", (Map<String, Object>) hashMap, false);
            return false;
        }
        if (!this.i.b(apkInfo2.key)) {
            this.i.a(apkInfo2);
        }
        f a3 = f.a(f11328b.getApplicationContext());
        ?? r152 = 1;
        try {
            this.i.a(apkInfo2.key, 1);
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
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(apkInfo2.key);
                Object obj4 = "1";
                try {
                    hashMap2.put(obj4, sb3.toString());
                    hashMap2.put("2", apkInfo2.versionName);
                    com.baidu.sofire.g.d.a(f11328b, "1003106", (Map<String, Object>) hashMap2, false);
                    com.baidu.sofire.b.a();
                    com.baidu.sofire.c.a(file2);
                    file2.delete();
                    a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                    this.i.a(apkInfo2.key, 0);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    a2 = obj4;
                    r152 = "2";
                    charSequence = "\r";
                    obj = "3";
                    str2 = a2;
                    r15 = r152;
                    obj2 = "0";
                    try {
                        th.getMessage();
                        com.baidu.sofire.b.a();
                        com.baidu.sofire.c.a(file2);
                        c(apkInfo2.packageName);
                        file2.delete();
                        a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                        this.i.a(apkInfo2.key, 0);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put(obj2, 5);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(apkInfo2.key);
                        hashMap3.put(str2, sb4.toString());
                        hashMap3.put(r15, apkInfo2.versionName);
                        hashMap3.put(obj, Base64.encodeToString(com.baidu.sofire.b.a(th).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace(charSequence, ""));
                        com.baidu.sofire.g.d.a(f11328b, "1003106", (Map<String, Object>) hashMap3, false);
                        return false;
                    } catch (Throwable unused) {
                        com.baidu.sofire.g.d.a();
                        return false;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                a2 = "1";
            }
        } else {
            str2 = "1";
            r15 = "2";
            String[] h2 = com.baidu.sofire.g.d.h(f11328b);
            if (h2 == null) {
                cls = String.class;
                num = 0;
            } else {
                num = 0;
                cls = String.class;
                if (h2.length == 2 && !TextUtils.isEmpty(h2[0]) && !TextUtils.isEmpty(h2[1])) {
                    str4 = h2[0];
                    str5 = h2[1];
                    apkInfo2 = a3.c(apkInfo2.pkgPath);
                    if (apkInfo2 != null) {
                        return false;
                    }
                    e eVar = (e) apkInfo2.classLoader;
                    Class<?> a4 = eVar.a("com.baidu.sofire.engine.EngineImpl");
                    if (a4 == null) {
                        com.baidu.sofire.b.a();
                        Class<?> a5 = eVar.a("java.lang.String");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("0", 6);
                        StringBuilder sb5 = new StringBuilder();
                        obj3 = "0";
                        try {
                            sb5.append(apkInfo2.key);
                            hashMap4.put(str2, sb5.toString());
                            hashMap4.put(r15, apkInfo2.versionName);
                            hashMap4.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a5).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
                            com.baidu.sofire.g.d.a(f11328b, "1003106", (Map<String, Object>) hashMap4, false);
                            com.baidu.sofire.c.a(file2);
                            file2.delete();
                            this.i.a(apkInfo2.key, 0);
                            return false;
                        } catch (Throwable th7) {
                            th = th7;
                            charSequence = "\r";
                            obj = "3";
                        }
                    } else {
                        obj3 = "0";
                        obj = "3";
                        try {
                            obj2 = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, f11328b);
                            try {
                                clsArr = new Class[]{cls, cls};
                                charSequence = "\r";
                            } catch (Throwable unused2) {
                                charSequence = "\r";
                            }
                            try {
                                try {
                                    com.baidu.sofire.g.d.a(obj2, "setSecurityVerifyInfo", clsArr, str4, str5);
                                } catch (Throwable unused3) {
                                    try {
                                        com.baidu.sofire.g.d.a();
                                        if (((Boolean) com.baidu.sofire.g.d.a(obj2, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, num, Boolean.TRUE)).booleanValue()) {
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                    }
                                }
                                if (((Boolean) com.baidu.sofire.g.d.a(obj2, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, num, Boolean.TRUE)).booleanValue()) {
                                    com.baidu.sofire.b.a();
                                    com.baidu.sofire.c.a(file2);
                                    c(apkInfo2.packageName);
                                    file2.delete();
                                    a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                                    this.i.a(apkInfo2.key, 0);
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put(obj3, 4);
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(apkInfo2.key);
                                    hashMap5.put(str2, sb6.toString());
                                    hashMap5.put(r15, apkInfo2.versionName);
                                    com.baidu.sofire.g.d.a(f11328b, "1003106", (Map<String, Object>) hashMap5, false);
                                    return false;
                                }
                                if (apkInfo2.isMem) {
                                    com.baidu.sofire.c.a(file2);
                                    file2.delete();
                                    com.baidu.sofire.g.d.d(apkInfo2.dataDir);
                                    if (f.f11369b != null) {
                                        f.f11369b.add(Integer.valueOf(apkInfo2.key));
                                    }
                                }
                                com.baidu.sofire.b.a();
                                try {
                                    ApkInfo a6 = this.i.a(apkInfo2.key);
                                    new StringBuilder().append(a6);
                                    com.baidu.sofire.b.a();
                                    if (a6 == null || a6.versionName.equals(apkInfo2.versionName)) {
                                        i = 1;
                                        file = null;
                                    } else {
                                        file = new File(a6.pkgPath);
                                        i = 1;
                                    }
                                    apkInfo2.initStatus = i;
                                    apkInfo2.apkParseSuc = i;
                                    long a7 = this.i.a(apkInfo2);
                                    if (a7 > 0 && file != null && file.exists()) {
                                        com.baidu.sofire.c.a(file);
                                        new StringBuilder().append(file.delete());
                                        com.baidu.sofire.b.a();
                                    }
                                    int a8 = this.i.a(apkInfo2.key, 0);
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append(a7);
                                    sb7.append(", c=");
                                    sb7.append(a8);
                                    com.baidu.sofire.b.a();
                                    com.baidu.sofire.g.d.d(f11328b);
                                    HashMap hashMap6 = new HashMap();
                                    hashMap6.put(obj3, num);
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append(apkInfo2.key);
                                    hashMap6.put(str2, sb8.toString());
                                    hashMap6.put(r15, apkInfo2.versionName);
                                    com.baidu.sofire.g.d.a(f11328b, "1003106", (Map<String, Object>) hashMap6, false);
                                    return true;
                                } catch (Throwable unused4) {
                                    com.baidu.sofire.g.d.a();
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
                    obj2 = obj3;
                    th.getMessage();
                    com.baidu.sofire.b.a();
                    com.baidu.sofire.c.a(file2);
                    c(apkInfo2.packageName);
                    file2.delete();
                    a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                    this.i.a(apkInfo2.key, 0);
                    HashMap hashMap32 = new HashMap();
                    hashMap32.put(obj2, 5);
                    StringBuilder sb42 = new StringBuilder();
                    sb42.append(apkInfo2.key);
                    hashMap32.put(str2, sb42.toString());
                    hashMap32.put(r15, apkInfo2.versionName);
                    hashMap32.put(obj, Base64.encodeToString(com.baidu.sofire.b.a(th).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace(charSequence, ""));
                    com.baidu.sofire.g.d.a(f11328b, "1003106", (Map<String, Object>) hashMap32, false);
                    return false;
                }
            }
            str4 = com.baidu.sofire.g.d.f11421e;
            str5 = com.baidu.sofire.g.d.f11422f;
            apkInfo2 = a3.c(apkInfo2.pkgPath);
            if (apkInfo2 != null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x0245 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        ApkInfo apkInfo;
        boolean z;
        try {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            com.baidu.sofire.g.d.a(f11328b, "1003136", (Map<String, Object>) hashMap, false);
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
                hashMap.put("3", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                return;
            }
            int i2 = 18;
            if (callback != null) {
                try {
                    callback.onBegin(new Object[0]);
                } catch (IllegalAccessException e2) {
                    try {
                        e2.getMessage();
                        com.baidu.sofire.b.c();
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th) {
                                th = th;
                                i2 = 16;
                                if (i2 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(16));
                            com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IllegalArgumentException e3) {
                    try {
                        e3.getMessage();
                        com.baidu.sofire.b.c();
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th3) {
                                th = th3;
                                i2 = 17;
                                if (i2 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(17));
                            com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (NoSuchMethodException e4) {
                    try {
                        e4.getMessage();
                        com.baidu.sofire.b.c();
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th5) {
                                th = th5;
                                i2 = 14;
                                if (i2 != 0) {
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(14));
                            com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (InvocationTargetException e5) {
                    try {
                        e5.getMessage();
                        com.baidu.sofire.b.c();
                        if (callback != null) {
                            try {
                                callback.onError(2);
                            } catch (Throwable th7) {
                                th = th7;
                                i2 = 15;
                                if (i2 != 0) {
                                    try {
                                        hashMap.put("3", Integer.toString(i2));
                                        com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                                    } catch (Throwable unused4) {
                                    }
                                }
                                throw th;
                            }
                        }
                        try {
                            hashMap.put("3", Integer.toString(15));
                            com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused5) {
                            return;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } catch (Throwable th9) {
                    try {
                        th9.getMessage();
                        com.baidu.sofire.b.c();
                        if (callback != null) {
                            callback.onError(3);
                        }
                        try {
                            hashMap.put("3", Integer.toString(18));
                            com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                            return;
                        } catch (Throwable unused6) {
                            return;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        if (i2 != 0) {
                        }
                        throw th;
                    }
                }
            }
            boolean d2 = this.i.d(i);
            com.baidu.sofire.b.a();
            if (d2) {
                long currentTimeMillis = System.currentTimeMillis();
                while (this.i.d(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                    com.baidu.sofire.b.a();
                    SystemClock.sleep(300L);
                }
            }
            com.baidu.sofire.b.a();
            if (this.i.d(i)) {
                if (callback != null) {
                    callback.onError(3);
                }
                try {
                    hashMap.put("3", Integer.toString(12));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                    return;
                } catch (Throwable unused7) {
                    return;
                }
            }
            if (!this.f11334e) {
                a(3);
                b();
            }
            f a2 = f.a(f11328b.getApplicationContext());
            ApkInfo apkInfo2 = null;
            long currentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - currentTimeMillis2 > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
                    apkInfo = apkInfo2;
                    break;
                }
                com.baidu.sofire.b.a();
                apkInfo = this.i.a(i);
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
                apkInfo2 = apkInfo;
            }
            z = false;
            if (!z) {
                if (callback != null) {
                    callback.onError(4);
                }
                try {
                    hashMap.put("3", Integer.toString(13));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, false);
                    return;
                } catch (Throwable unused8) {
                    return;
                }
            }
            Class<?> a3 = ((e) a2.d(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
            Object a4 = com.baidu.sofire.g.d.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f11328b), str, clsArr, objArr);
            try {
                new StringBuilder().append(a4);
                com.baidu.sofire.b.a();
            } catch (Throwable unused9) {
                com.baidu.sofire.g.d.a();
            }
            if (callback != null) {
                callback.onEnd(a4);
            }
        } catch (Throwable unused10) {
            com.baidu.sofire.g.d.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        new StringBuilder().append(str);
        com.baidu.sofire.b.a();
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.toString(i));
        hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
        hashMap.put("2", "1");
        com.baidu.sofire.g.d.a(f11328b, "1003136", (Map<String, Object>) hashMap, true);
        if (TextUtils.isEmpty(str)) {
            hashMap.put("3", "1");
            com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
            return new Pair<>(1, null);
        }
        int i2 = 10;
        try {
            boolean d2 = this.i.d(i);
            new StringBuilder().append(d2);
            com.baidu.sofire.b.a();
            if (d2) {
                Pair<Integer, Object> pair = new Pair<>(3, null);
                try {
                    hashMap.put("3", Integer.toString(2));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused) {
                }
                return pair;
            } else if (!this.f11334e) {
                Pair<Integer, Object> pair2 = new Pair<>(3, null);
                try {
                    hashMap.put("3", Integer.toString(3));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused2) {
                }
                return pair2;
            } else {
                f a2 = f.a();
                if (a2 == null) {
                    Pair<Integer, Object> pair3 = new Pair<>(3, null);
                    try {
                        hashMap.put("3", Integer.toString(4));
                        com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                    } catch (Throwable unused3) {
                    }
                    return pair3;
                }
                ApkInfo a3 = this.i.a(i);
                if (!((a3 == null || a2.d(a3.packageName) == null) ? false : true)) {
                    Pair<Integer, Object> pair4 = new Pair<>(4, null);
                    try {
                        hashMap.put("3", Integer.toString(5));
                        com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                    } catch (Throwable unused4) {
                    }
                    return pair4;
                }
                Class<?> a4 = ((e) a2.d(a3.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object a5 = com.baidu.sofire.g.d.a(a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, f11328b), str, clsArr, objArr);
                try {
                    new StringBuilder().append(a5);
                    com.baidu.sofire.b.a();
                } catch (Throwable unused5) {
                    com.baidu.sofire.g.d.a();
                }
                return new Pair<>(0, a5);
            }
        } catch (IllegalAccessException e2) {
            try {
                e2.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair5 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(8));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused6) {
                }
                return pair5;
            } catch (Throwable th) {
                th = th;
                i2 = 8;
                if (i2 != 0) {
                }
                throw th;
            }
        } catch (IllegalArgumentException e3) {
            try {
                e3.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair6 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(9));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused7) {
                }
                return pair6;
            } catch (Throwable th2) {
                th = th2;
                i2 = 9;
                if (i2 != 0) {
                    try {
                        hashMap.put("3", Integer.toString(i2));
                        com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                    } catch (Throwable unused8) {
                    }
                }
                throw th;
            }
        } catch (NoSuchMethodException e4) {
            try {
                e4.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair7 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(6));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused9) {
                }
                return pair7;
            } catch (Throwable th3) {
                th = th3;
                i2 = 6;
                if (i2 != 0) {
                }
                throw th;
            }
        } catch (InvocationTargetException e5) {
            try {
                e5.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair8 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(7));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused10) {
                }
                return pair8;
            } catch (Throwable th4) {
                th = th4;
                i2 = 7;
                if (i2 != 0) {
                }
                throw th;
            }
        } catch (Throwable th5) {
            try {
                th5.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair9 = new Pair<>(3, null);
                try {
                    hashMap.put("3", Integer.toString(10));
                    com.baidu.sofire.g.d.a(f11328b, "1003141", (Map<String, Object>) hashMap, true);
                } catch (Throwable unused11) {
                }
                return pair9;
            } catch (Throwable th6) {
                th = th6;
                if (i2 != 0) {
                }
                throw th;
            }
        }
    }

    public final void a(final String str) {
        try {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            new Thread() { // from class: com.baidu.sofire.core.c.2
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    super.run();
                    try {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        final f a2 = f.a(c.f11328b.getApplicationContext());
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(", h=");
                        sb.append(a2);
                        com.baidu.sofire.b.a();
                        if (a2 == null) {
                            return;
                        }
                        final File file = new File(c.f11328b.getFilesDir(), ".b");
                        final ApkInfo d2 = a2.d(str);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(", i=");
                        sb2.append(d2);
                        com.baidu.sofire.b.a();
                        if (d2 == null) {
                            ApkInfo b2 = c.this.i.b(str);
                            if (b2 == null) {
                                return;
                            }
                            c.this.a(str, b2.pkgPath);
                            if (file.exists()) {
                                File file2 = new File(file, b2.key + "-" + b2.versionName);
                                if (com.baidu.sofire.g.d.a(file2)) {
                                    boolean delete = file2.delete();
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(file2.getAbsolutePath());
                                    sb3.append(" s=");
                                    sb3.append(delete);
                                    com.baidu.sofire.b.a();
                                }
                            }
                            if (b2 != null) {
                                String canonicalPath = c.f11328b.getFilesDir().getCanonicalPath();
                                com.baidu.sofire.g.d.d(canonicalPath + "/." + b2.key);
                                com.baidu.sofire.g.d.d(c.f11328b.getFileStreamPath(b2.packageName).getAbsolutePath());
                            }
                            String sb4 = new StringBuilder(str).reverse().toString();
                            ApkInfo b3 = c.this.i.b(sb4);
                            if (b3 != null) {
                                c.this.a(sb4, b3.pkgPath);
                                return;
                            }
                            return;
                        }
                        Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                        Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, c.f11328b);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        sb5.append(", i=");
                        sb5.append(invoke);
                        com.baidu.sofire.b.a();
                        if (invoke == null) {
                            return;
                        }
                        new StringBuilder("t:").append(System.currentTimeMillis());
                        com.baidu.sofire.b.a();
                        new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.core.c.2.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public final void run() {
                                String str2;
                                new StringBuilder().append(System.currentTimeMillis());
                                com.baidu.sofire.b.a();
                                ApkInfo d3 = a2.d(str);
                                if (d3 == null || (str2 = d3.versionName) == null || !str2.equals(d2.versionName)) {
                                    return;
                                }
                                a2.b(str);
                                c.this.i.a(str);
                                com.baidu.sofire.g.d.d(c.f11328b);
                                File file3 = new File(d2.pkgPath);
                                StringBuilder sb6 = new StringBuilder("f=");
                                sb6.append(file3.getAbsolutePath());
                                sb6.append(", e=");
                                sb6.append(file3.exists());
                                com.baidu.sofire.b.a();
                                if (file3.exists()) {
                                    com.baidu.sofire.c.a(file3);
                                    boolean delete2 = file3.delete();
                                    StringBuilder sb7 = new StringBuilder("d: ");
                                    sb7.append(file3.getAbsolutePath());
                                    sb7.append(" s=");
                                    sb7.append(delete2);
                                    com.baidu.sofire.b.a();
                                }
                                if (file.exists()) {
                                    File file4 = file;
                                    File file5 = new File(file4, d2.key + "-" + d2.versionName);
                                    if (com.baidu.sofire.g.d.a(file5)) {
                                        boolean delete3 = file5.delete();
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append(file5.getAbsolutePath());
                                        sb8.append(" s=");
                                        sb8.append(delete3);
                                        com.baidu.sofire.b.a();
                                    }
                                }
                                String sb9 = new StringBuilder(str).reverse().toString();
                                ApkInfo b4 = c.this.i.b(sb9);
                                if (b4 != null) {
                                    c.this.a(sb9, b4.pkgPath);
                                }
                            }
                        }, 600000L);
                        Object a4 = com.baidu.sofire.g.d.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str);
                        sb6.append("object=");
                        sb6.append(a4);
                        com.baidu.sofire.b.a();
                        a2.b(str);
                        c.this.i.a(str);
                        com.baidu.sofire.g.d.d(c.f11328b);
                        File file3 = new File(d2.pkgPath);
                        StringBuilder sb7 = new StringBuilder("f=");
                        sb7.append(file3.getAbsolutePath());
                        sb7.append(", e=");
                        sb7.append(file3.exists());
                        com.baidu.sofire.b.a();
                        if (file3.exists()) {
                            com.baidu.sofire.c.a(file3);
                            boolean delete2 = file3.delete();
                            StringBuilder sb8 = new StringBuilder("d: ");
                            sb8.append(file3.getAbsolutePath());
                            sb8.append(" s=");
                            sb8.append(delete2);
                            com.baidu.sofire.b.a();
                        }
                        if (file.exists()) {
                            File file4 = new File(file, d2.key + "-" + d2.versionName);
                            if (com.baidu.sofire.g.d.a(file4)) {
                                boolean delete3 = file4.delete();
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append(file4.getAbsolutePath());
                                sb9.append(" s=");
                                sb9.append(delete3);
                                com.baidu.sofire.b.a();
                            }
                        }
                        String sb10 = new StringBuilder(str).reverse().toString();
                        ApkInfo b4 = c.this.i.b(sb10);
                        if (b4 != null) {
                            c.this.a(sb10, b4.pkgPath);
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                        com.baidu.sofire.b.c();
                    }
                }
            }.start();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public static void a(int i) {
        if (f11332h == 0) {
            f11332h = i;
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
            if (this.i == null) {
                this.i = com.baidu.sofire.a.a.a(f11328b);
            }
            ApkInfo b2 = this.i.b(str);
            new StringBuilder("push::").append(b2);
            com.baidu.sofire.b.a();
            if (b2 != null) {
                if (this.f11333a.c()) {
                    File file = new File(f11328b.getFilesDir(), ".b");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(b2.pkgPath);
                    File file3 = new File(file, b2.key + "-" + b2.versionName);
                    if (!com.baidu.sofire.g.d.a(file3)) {
                        com.baidu.sofire.g.d.a(file2, file3);
                    }
                    com.baidu.sofire.c.a(f11328b, b2.key, file2, file3);
                }
                if (a(b2.key, b2.versionName, null)) {
                    return true;
                }
            }
            return a2.d(str) != null;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return false;
        }
    }
}
