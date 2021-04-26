package com.baidu.sofire.core;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.util.devices.IDevices;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.g.n;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: e  reason: collision with root package name */
    public static f f11191e;

    /* renamed from: f  reason: collision with root package name */
    public static Application f11192f;

    /* renamed from: c  reason: collision with root package name */
    public String f11195c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11196d;

    /* renamed from: g  reason: collision with root package name */
    public static Random f11193g = new Random();

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f11190b = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, ApkInfo> f11197h = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ApkInfo> f11194a = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    public Map<String, MyReceiver> f11198i = new HashMap();

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (f11191e == null) {
                f11192f = (Application) context.getApplicationContext();
                f11191e = new f();
            }
            fVar = f11191e;
        }
        return fVar;
    }

    public static boolean f(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return false;
        }
    }

    public final synchronized void b(g gVar) {
        try {
            if (gVar.f11202d == null) {
                return;
            }
            ApkInfo apkInfo = this.f11194a.get(gVar.f11199a);
            if (apkInfo != null && apkInfo.intentFilters != null) {
                ArrayList<Integer> arrayList = new ArrayList();
                for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                    if (gVar.a(apkInfo.intentFilters.get(i2))) {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                for (Integer num : arrayList) {
                    int intValue = num.intValue();
                    if (apkInfo != null && apkInfo.intentFilters != null) {
                        apkInfo.intentFilters.remove(intValue);
                    }
                }
                if (apkInfo != null && apkInfo.intentFilters != null && apkInfo.intentFilters.size() == 0) {
                    apkInfo.intentFilters = null;
                }
            }
            String a2 = a(gVar.f11202d);
            new StringBuilder().append(a2);
            com.baidu.sofire.b.a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            for (ApkInfo apkInfo2 : b()) {
                if (apkInfo2.intentFilters != null && apkInfo2.intentFilters.size() > 0) {
                    for (g gVar2 : apkInfo2.intentFilters) {
                        String a3 = a(gVar2.f11202d);
                        if (!TextUtils.isEmpty(a3) && a3.equals(a2)) {
                            new StringBuilder().append(a2);
                            com.baidu.sofire.b.a();
                            return;
                        }
                    }
                    continue;
                }
            }
            new StringBuilder().append(a2);
            com.baidu.sofire.b.a();
            f11192f.unregisterReceiver(this.f11198i.get(a2));
            this.f11198i.remove(a2);
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public final ApkInfo c(String str) {
        try {
            return this.f11197h.get(str);
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return null;
        }
    }

    public final ApkInfo d(String str) {
        try {
            return this.f11194a.get(str);
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return null;
        }
    }

    public final boolean e(String str) {
        try {
            ApkInfo apkInfo = this.f11194a.get(str);
            if (apkInfo != null) {
                Class<?> a2 = ((e) apkInfo.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, f11192f);
                if (invoke != null) {
                    com.baidu.sofire.g.d.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                }
                this.f11197h.remove(apkInfo.pkgPath);
                this.f11194a.remove(str);
                return true;
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return false;
        }
    }

    public static f a() {
        return f11191e;
    }

    public final synchronized void a(g gVar) {
        try {
            if (gVar.f11202d == null) {
                return;
            }
            ApkInfo apkInfo = this.f11194a.get(gVar.f11199a);
            if (apkInfo != null) {
                if (apkInfo.intentFilters == null) {
                    apkInfo.intentFilters = new ArrayList();
                }
                for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                    if (gVar.a(apkInfo.intentFilters.get(i2))) {
                        return;
                    }
                }
                apkInfo.intentFilters.add(gVar);
                String a2 = a(gVar.f11202d);
                new StringBuilder().append(a2);
                com.baidu.sofire.b.a();
                if (!TextUtils.isEmpty(a2) && !a2.equals("____")) {
                    if (!this.f11198i.keySet().contains(a2)) {
                        MyReceiver myReceiver = new MyReceiver();
                        if (!com.baidu.sofire.g.d.a(f11192f, myReceiver, gVar.f11202d)) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException unused) {
                                com.baidu.sofire.g.d.a();
                            }
                            com.baidu.sofire.g.d.a(f11192f, myReceiver, gVar.f11202d);
                        }
                        this.f11198i.put(a2, myReceiver);
                    }
                }
            }
        } catch (Throwable unused2) {
            com.baidu.sofire.g.d.a();
        }
    }

    public static String a(IntentFilter intentFilter) {
        if (intentFilter == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int countActions = intentFilter.countActions();
            if (countActions > 0) {
                ArrayList<String> arrayList = new ArrayList();
                for (int i2 = 0; i2 < countActions; i2++) {
                    String action = intentFilter.getAction(i2);
                    if (!TextUtils.isEmpty(action)) {
                        arrayList.add(action);
                    }
                }
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList);
                    for (String str : arrayList) {
                        sb.append(str);
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            int countCategories = intentFilter.countCategories();
            if (countCategories > 0) {
                ArrayList<String> arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < countCategories; i3++) {
                    String category = intentFilter.getCategory(i3);
                    if (!TextUtils.isEmpty(category)) {
                        arrayList2.add(category);
                    }
                }
                if (arrayList2.size() > 0) {
                    Collections.sort(arrayList2);
                    for (String str2 : arrayList2) {
                        sb.append(str2);
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            if (intentFilter.countDataTypes() > 0) {
                ArrayList<String> arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < countCategories; i4++) {
                    String dataType = intentFilter.getDataType(i4);
                    if (!TextUtils.isEmpty(dataType)) {
                        arrayList3.add(dataType);
                    }
                }
                if (arrayList3.size() > 0) {
                    Collections.sort(arrayList3);
                    for (String str3 : arrayList3) {
                        sb.append(str3);
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            int countDataSchemes = intentFilter.countDataSchemes();
            if (countDataSchemes > 0) {
                ArrayList<String> arrayList4 = new ArrayList();
                for (int i5 = 0; i5 < countDataSchemes; i5++) {
                    String dataScheme = intentFilter.getDataScheme(i5);
                    if (!TextUtils.isEmpty(dataScheme)) {
                        arrayList4.add(dataScheme);
                    }
                }
                if (arrayList4.size() > 0) {
                    Collections.sort(arrayList4);
                    for (String str4 : arrayList4) {
                        sb.append(str4);
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f11194a.keySet()) {
                arrayList.add(this.f11194a.get(str));
            }
            return arrayList;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            try {
                return new ArrayList();
            } catch (Throwable unused2) {
                com.baidu.sofire.g.d.a();
                return null;
            }
        }
    }

    public final boolean b(String str) {
        ApkInfo apkInfo = this.f11194a.get(str);
        if (apkInfo != null) {
            this.f11197h.remove(apkInfo.pkgPath);
            this.f11194a.remove(str);
            com.baidu.sofire.mutiprocess.b.b(str);
            com.baidu.sofire.g.d.d(apkInfo.dataDir);
            Application application = f11192f;
            if (application != null) {
                com.baidu.sofire.g.d.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            new StringBuilder().append(this.f11197h.size());
            com.baidu.sofire.b.a();
            new StringBuilder().append(this.f11194a.size());
            com.baidu.sofire.b.a();
            return true;
        }
        return false;
    }

    public final boolean a(ApkInfo apkInfo, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f11196d = z;
        this.f11195c = apkInfo.versionName;
        boolean a2 = a(apkInfo);
        new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.sofire.b.a();
        return a2;
    }

    private synchronized boolean a(ApkInfo apkInfo) {
        boolean z;
        if (apkInfo != null) {
            if (!TextUtils.isEmpty(apkInfo.pkgPath)) {
                ApkInfo apkInfo2 = this.f11197h.get(apkInfo.pkgPath);
                if (apkInfo2 != null) {
                    if (apkInfo2.versionName.equals(apkInfo.versionName)) {
                        com.baidu.sofire.b.a();
                        return true;
                    }
                    a(apkInfo.pkgPath);
                }
                if (!com.baidu.sofire.g.d.a(new File(apkInfo.pkgPath))) {
                    com.baidu.sofire.b.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", Integer.valueOf(apkInfo.key));
                    hashMap.put("2", apkInfo.versionName);
                    com.baidu.sofire.g.d.a(f11192f.getApplicationContext(), "1003117", (Map<String, Object>) hashMap, false);
                    return false;
                }
                apkInfo.hostContext = f11192f;
                if (apkInfo.apkParseSuc == 1) {
                    com.baidu.sofire.b.a();
                    try {
                        if (!TextUtils.isEmpty(apkInfo.packageName) && !TextUtils.isEmpty(apkInfo.pkgPath)) {
                            if (!a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                                return false;
                            }
                            apkInfo.dataDir = f11192f.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                            String str = apkInfo.dataDir + "/dex";
                            String str2 = (apkInfo.dataDir + "/lib/" + this.f11195c) + "/" + f11193g.nextInt();
                            f(str);
                            com.baidu.sofire.g.d.a(str, false);
                            f(str2);
                            a(apkInfo, str2, str);
                            this.f11197h.put(apkInfo.pkgPath, apkInfo);
                            this.f11194a.put(apkInfo.packageName, apkInfo);
                            a(apkInfo, apkInfo.className);
                        } else {
                            throw new RuntimeException("packageName or pkgPath miss");
                        }
                    } catch (Throwable unused) {
                        a(apkInfo.pkgPath);
                        com.baidu.sofire.g.d.a();
                        z = true;
                    }
                }
                z = false;
                if (apkInfo.apkParseSuc != 1 || z) {
                    com.baidu.sofire.b.a();
                    PackageInfo packageInfo = apkInfo.cloudPkgInfo;
                    if (packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName) && !TextUtils.isEmpty(packageInfo.versionName)) {
                        com.baidu.sofire.b.a();
                    } else {
                        packageInfo = f11192f.getPackageManager().getPackageArchiveInfo(apkInfo.pkgPath, 1);
                        if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                            com.baidu.sofire.b.a();
                            packageInfo = a(apkInfo.packageName, apkInfo.apkMD5);
                            if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                                throw new Exception("requestCloudPackageInfo failed");
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.baidu.sofire")) {
                        if (!a(apkInfo.key, packageInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                            return false;
                        }
                        apkInfo.packageName = packageInfo.packageName;
                        StringBuilder sb = new StringBuilder("p=");
                        sb.append(packageInfo.packageName);
                        sb.append(", v=");
                        sb.append(packageInfo.versionName);
                        com.baidu.sofire.b.a();
                        apkInfo.className = packageInfo.applicationInfo.className;
                        apkInfo.versionName = packageInfo.versionName;
                        apkInfo.activities = packageInfo.activities;
                        apkInfo.applicationTheme = packageInfo.applicationInfo.theme;
                        apkInfo.dataDir = f11192f.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                        String str3 = apkInfo.dataDir + "/dex";
                        String str4 = (apkInfo.dataDir + "/lib/" + this.f11195c) + "/" + f11193g.nextInt();
                        f(str3);
                        com.baidu.sofire.g.d.a(str3, false);
                        f(str4);
                        a(apkInfo, str4, str3);
                        this.f11197h.put(apkInfo.pkgPath, apkInfo);
                        this.f11194a.put(apkInfo.packageName, apkInfo);
                        a(apkInfo, packageInfo.applicationInfo.className);
                    } else {
                        throw new Exception("package name check failed");
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static PackageInfo a(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pk", str);
            jSONObject.put("m", str2);
            jSONArray.put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            com.baidu.sofire.b.a();
            String a2 = com.baidu.sofire.g.g.a(f11192f, com.baidu.sofire.g.d.b() + "p/1/pdl", jSONArray2, false, true);
            new StringBuilder().append(a2);
            com.baidu.sofire.b.a();
            JSONArray jSONArray3 = new JSONArray(a2);
            if (jSONArray3.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = jSONArray3.optJSONObject(0);
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.packageName = optJSONObject.optString("p");
            packageInfo.versionName = optJSONObject.optString("v");
            ApplicationInfo applicationInfo = new ApplicationInfo();
            String optString = optJSONObject.optString("n");
            applicationInfo.className = optString;
            if (!TextUtils.isEmpty(optString) && applicationInfo.className.startsWith(".")) {
                applicationInfo.className = packageInfo.packageName + applicationInfo.className;
            }
            applicationInfo.theme = optJSONObject.optInt("t");
            packageInfo.applicationInfo = applicationInfo;
            JSONArray optJSONArray = optJSONObject.optJSONArray("a");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
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
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
            return packageInfo;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return null;
        }
    }

    public static boolean a(int i2, String str, String str2, String str3) {
        Pair pair;
        String str4 = i2 + str;
        Map<String, String> map = U.sRealtimeMd5Map;
        if (map != null) {
            String str5 = map.get(str4);
            if (!TextUtils.isEmpty(str5)) {
                com.baidu.sofire.b.a();
                str2 = str5;
            }
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            File file = new File(str3);
            if (!com.baidu.sofire.g.d.a(file)) {
                pair = new Pair(Boolean.FALSE, "");
            } else {
                String a2 = n.a(file);
                if (TextUtils.isEmpty(a2)) {
                    pair = new Pair(Boolean.FALSE, "");
                } else if (!a2.equalsIgnoreCase(str2)) {
                    pair = new Pair(Boolean.FALSE, a2);
                } else {
                    pair = new Pair(Boolean.TRUE, "");
                }
            }
        } else {
            pair = new Pair(Boolean.FALSE, "");
        }
        new StringBuilder("_").append(pair.first);
        com.baidu.sofire.b.a();
        if (((Boolean) pair.first).booleanValue()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("0", 3);
        hashMap.put("1", Integer.valueOf(i2));
        hashMap.put("2", str);
        hashMap.put("3", Base64.encodeToString(((String) pair.second).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
        com.baidu.sofire.g.d.a(f11192f.getApplicationContext(), "1003117", (Map<String, Object>) hashMap, false);
        return false;
    }

    public static boolean a(ApkInfo apkInfo, String str) {
        try {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
            com.baidu.sofire.f.a(Application.class, f11192f, application);
            a(application, f11192f);
            application.onCreate();
            return true;
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.c();
            return false;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    private void a(ApkInfo apkInfo, String str, String str2) throws Throwable {
        String a2 = a(apkInfo, str, true);
        String str3 = "";
        String str4 = (Build.VERSION.SDK_INT >= 25 || TextUtils.isEmpty(System.getProperty("java.library.path"))) ? "" : "";
        if (TextUtils.isEmpty(a2)) {
            a2 = str4;
        } else if (!TextUtils.isEmpty(str4)) {
            a2 = a2 + ":" + str4;
        }
        apkInfo.libPath = a2;
        ClassLoader classLoader = f.class.getClassLoader();
        new StringBuilder().append(a2);
        com.baidu.sofire.b.a();
        try {
            String absolutePath = new File(str2, "apkDex").getAbsolutePath();
            com.baidu.sofire.g.d.d(absolutePath);
            f(absolutePath);
            e eVar = new e(apkInfo.pkgPath, absolutePath, a2, classLoader);
            apkInfo.classLoader = eVar;
            Class<?> loadClass = eVar.loadClass("com.baidu.sofire.engine.EngineImpl");
            new StringBuilder().append(loadClass);
            com.baidu.sofire.b.a();
            if (loadClass == null || TextUtils.isEmpty(loadClass.getName())) {
                throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.a();
            try {
                com.baidu.sofire.g.d.d(new File(str2, "apkDex").getAbsolutePath());
                String absolutePath2 = new File(str2, "dexDex").getAbsolutePath();
                com.baidu.sofire.g.d.d(absolutePath2);
                f(absolutePath2);
                str3 = a(apkInfo, str, false);
                new StringBuilder().append(str3);
                com.baidu.sofire.b.a();
                e eVar2 = new e(str3, absolutePath2, a2, classLoader);
                apkInfo.classLoader = eVar2;
                Class<?> loadClass2 = eVar2.loadClass("com.baidu.sofire.engine.EngineImpl");
                new StringBuilder().append(loadClass2);
                com.baidu.sofire.b.a();
                new StringBuilder().append(str3);
                com.baidu.sofire.b.a();
                File file = new File(str3);
                if (file.exists()) {
                    file.delete();
                }
                if (loadClass2 == null || TextUtils.isEmpty(loadClass2.getName())) {
                    throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                }
            } catch (Throwable unused2) {
                com.baidu.sofire.b.a();
                if (apkInfo != null) {
                    try {
                        com.baidu.sofire.g.d.d(apkInfo.dataDir);
                        if (f11192f != null) {
                            com.baidu.sofire.g.d.d(f11192f.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                        }
                    } catch (Throwable unused3) {
                        com.baidu.sofire.g.d.a();
                    }
                }
                if (apkInfo != null) {
                    throw new RuntimeException("can't load EngineImpl by both dexFile:" + str3 + " and ZipFile:" + apkInfo.pkgPath);
                }
                throw new RuntimeException("can't load EngineImpl by both dexFile:" + str3 + " and ZipFile:null");
            }
        }
    }

    public final boolean a(String str) {
        ApkInfo apkInfo = this.f11197h.get(str);
        if (apkInfo != null) {
            this.f11197h.remove(str);
            this.f11194a.remove(apkInfo.packageName);
            com.baidu.sofire.mutiprocess.b.b(apkInfo.packageName);
            com.baidu.sofire.g.d.d(apkInfo.dataDir);
            Application application = f11192f;
            if (application != null) {
                com.baidu.sofire.g.d.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                return true;
            }
            return true;
        }
        return false;
    }

    public static void a(Application application, Context context) {
        Class<?> cls = context.getClass();
        for (Class<Application> cls2 = Application.class; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField("mBase");
                declaredField.setAccessible(true);
                if (declaredField.getType().isAssignableFrom(cls)) {
                    declaredField.set(application, context);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:25|(1:76)(3:32|(2:34|(1:74)(3:36|(1:38)|39))(1:75)|52)|40|41|(4:46|47|48|(2:50|51)(2:53|(2:55|56)(1:57)))|52) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0160, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0161, code lost:
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02a1 A[Catch: all -> 0x02ae, TRY_ENTER, TryCatch #10 {all -> 0x02ae, blocks: (B:128:0x02a1, B:131:0x02aa), top: B:154:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02aa A[Catch: all -> 0x02ae, TRY_LEAVE, TryCatch #10 {all -> 0x02ae, blocks: (B:128:0x02a1, B:131:0x02aa), top: B:154:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0294 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(ApkInfo apkInfo, String str, boolean z) throws Throwable {
        String str2;
        boolean z2;
        ZipFile zipFile;
        ZipFile zipFile2;
        ZipFile zipFile3;
        ZipFile zipFile4;
        String str3;
        String str4 = "";
        if (apkInfo == null) {
            return "";
        }
        String replace = (!z || TextUtils.isEmpty(apkInfo.versionName)) ? "" : apkInfo.versionName.replace(".", "");
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        try {
            try {
                try {
                    zipFile4 = new ZipFile(apkInfo.pkgPath);
                } catch (FileNotFoundException e2) {
                    String message = e2.getMessage();
                    File file = new File(apkInfo.hostContext.getFilesDir(), ".b");
                    try {
                        if (file.exists()) {
                            File file2 = new File(file, apkInfo.key + "-" + apkInfo.versionName);
                            if (file2.exists()) {
                                File file3 = new File(apkInfo.pkgPath);
                                com.baidu.sofire.g.d.a(file2, file3);
                                com.baidu.sofire.g.d.a(apkInfo.pkgPath, true);
                                com.baidu.sofire.c.a(file3);
                                com.baidu.sofire.c.a(apkInfo.hostContext, apkInfo.key, file3, file2);
                                if (file3.exists()) {
                                    try {
                                        zipFile4 = new ZipFile(apkInfo.pkgPath);
                                    } catch (Throwable th) {
                                        throw new FileNotFoundException(message + "--" + th.getMessage());
                                    }
                                } else {
                                    throw new FileNotFoundException(message + "--file not exists after copy");
                                }
                            } else {
                                throw new FileNotFoundException(message + "--backupFile not exists");
                            }
                        } else {
                            throw new FileNotFoundException(message + "--backupDir not exists");
                        }
                    } catch (EOFException unused2) {
                        str4 = "";
                        zipFile3 = null;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                        str2 = str4;
                        z2 = true;
                        if (z2) {
                        }
                    } catch (ZipException unused3) {
                        str4 = "";
                        zipFile2 = null;
                        if (zipFile2 != null) {
                            zipFile2.close();
                        }
                        str2 = str4;
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
                ZipFile zipFile5 = zipFile4;
                try {
                    try {
                        HashMap hashMap = new HashMap();
                        Enumeration<? extends ZipEntry> entries = zipFile5.entries();
                        str2 = "";
                        while (entries.hasMoreElements()) {
                            try {
                                ZipEntry nextElement = entries.nextElement();
                                String name = nextElement.getName();
                                try {
                                    if (name.contains(IStringUtil.TOP_PATH)) {
                                        try {
                                            zipFile5.close();
                                        } catch (Throwable unused4) {
                                            com.baidu.sofire.g.d.a();
                                        }
                                        return str4;
                                    }
                                    if (TextUtils.isEmpty(name) || !name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) || nextElement.isDirectory() || !z) {
                                        str3 = str4;
                                    } else {
                                        String[] split = name.split("/");
                                        str3 = str4;
                                        if (split.length == 3) {
                                            String str5 = split[1];
                                            if (!TextUtils.isEmpty(str5)) {
                                                List list = (List) hashMap.get(str5);
                                                if (list == null) {
                                                    list = new ArrayList();
                                                    hashMap.put(str5, list);
                                                }
                                                list.add(nextElement);
                                            }
                                        }
                                        str4 = str3;
                                    }
                                    if (name.endsWith(".dex") && !nextElement.isDirectory() && !z) {
                                        String str6 = apkInfo.dataDir;
                                        f(str6);
                                        File file4 = new File(str6, apkInfo.key + "-" + apkInfo.versionName + ".dex");
                                        try {
                                            new StringBuilder("e: ").append(file4.getAbsolutePath());
                                            com.baidu.sofire.b.a();
                                            if (a(zipFile5, nextElement, file4)) {
                                                str2 = file4.getAbsolutePath();
                                            } else if (file4.exists()) {
                                                file4.delete();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            new StringBuilder().append(th.getMessage());
                                            com.baidu.sofire.b.a();
                                            if (file4 != null && file4.exists()) {
                                                file4.delete();
                                            }
                                            str4 = str3;
                                        }
                                    }
                                    str4 = str3;
                                } catch (EOFException unused5) {
                                    zipFile3 = zipFile5;
                                    str4 = str2;
                                    if (zipFile3 != null) {
                                    }
                                    str2 = str4;
                                    z2 = true;
                                    if (z2) {
                                    }
                                } catch (ZipException unused6) {
                                    zipFile2 = zipFile5;
                                    str4 = str2;
                                    if (zipFile2 != null) {
                                    }
                                    str2 = str4;
                                    z2 = true;
                                    if (z2) {
                                    }
                                }
                            } catch (EOFException unused7) {
                            } catch (ZipException unused8) {
                            }
                        }
                        if (z && hashMap.size() > 0) {
                            String a2 = a(apkInfo.hostContext, hashMap.keySet());
                            if (!TextUtils.isEmpty(a2)) {
                                File file5 = new File(str, a2);
                                f(file5.getAbsolutePath());
                                List<ZipEntry> list2 = (List) hashMap.get(a2);
                                if (list2 != null && list2.size() > 0) {
                                    for (ZipEntry zipEntry : list2) {
                                        String name2 = zipEntry.getName();
                                        String substring = name2.substring(name2.lastIndexOf("/") + 1);
                                        if (!a(zipFile5, zipEntry, new File(file5, substring.replace(".so", replace + ".so")))) {
                                            throw new RuntimeException("UnZip so failed.Report space left.");
                                        }
                                    }
                                }
                                str2 = file5.getAbsolutePath();
                            }
                        }
                        try {
                            zipFile5.close();
                        } catch (Throwable unused9) {
                            com.baidu.sofire.g.d.a();
                        }
                        z2 = false;
                    } catch (Throwable th3) {
                        th = th3;
                        zipFile = zipFile5;
                        if (zipFile != null) {
                        }
                        throw th;
                    }
                } catch (EOFException unused10) {
                    zipFile3 = zipFile5;
                    str4 = "";
                } catch (ZipException unused11) {
                    zipFile2 = zipFile5;
                    str4 = "";
                }
            } catch (Throwable th4) {
                th = th4;
                zipFile = null;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Throwable unused12) {
                        com.baidu.sofire.g.d.a();
                    }
                }
                throw th;
            }
        } catch (EOFException unused13) {
            str4 = "";
            zipFile3 = null;
            if (zipFile3 != null) {
            }
            str2 = str4;
            z2 = true;
            if (z2) {
            }
        } catch (ZipException unused14) {
            str4 = "";
            zipFile2 = null;
            if (zipFile2 != null) {
            }
            str2 = str4;
            z2 = true;
            if (z2) {
            }
        }
        return z2 ? a(apkInfo, str, replace, z) : str2;
    }

    public static String a(Context context, Collection<String> collection) {
        String[] strArr;
        String[] strArr2;
        if (Build.VERSION.SDK_INT >= 21) {
            String q = com.baidu.sofire.g.d.q(context);
            if (TextUtils.isEmpty(q) || !collection.contains(q)) {
                boolean d2 = com.baidu.sofire.g.d.d();
                if (d2) {
                    strArr = Build.SUPPORTED_64_BIT_ABIS;
                } else {
                    strArr = Build.SUPPORTED_32_BIT_ABIS;
                }
                if (strArr != null && strArr.length > 0) {
                    for (String str : strArr) {
                        if (collection.contains(str)) {
                            return str;
                        }
                    }
                }
                return (d2 || !collection.contains("armeabi") || (strArr2 = Build.SUPPORTED_ABIS) == null || strArr2.length <= 0 || IDevices.ABI_MIPS.equals(strArr2[0])) ? "" : "armeabi";
            }
            return q;
        } else if (collection.contains(Build.CPU_ABI)) {
            return Build.CPU_ABI;
        } else {
            if (collection.contains(Build.CPU_ABI2)) {
                return Build.CPU_ABI2;
            }
            return (!collection.contains("armeabi") || IDevices.ABI_MIPS.equals(Build.CPU_ABI)) ? "" : "armeabi";
        }
    }

    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        FileOutputStream fileOutputStream;
        if (zipEntry == null) {
            return false;
        }
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable unused) {
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                com.baidu.sofire.g.d.a(file.getAbsolutePath(), true);
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable unused2) {
                        com.baidu.sofire.g.d.a();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (Throwable unused3) {
                    com.baidu.sofire.g.d.a();
                }
                return true;
            } catch (Throwable unused4) {
                inputStream = inputStream2;
                try {
                    com.baidu.sofire.g.d.a();
                    return false;
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused5) {
                            com.baidu.sofire.g.d.a();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused6) {
                            com.baidu.sofire.g.d.a();
                        }
                    }
                }
            }
        } catch (Throwable unused7) {
            fileOutputStream = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(9:12|(3:17|(3:57|58|59)(3:19|20|(3:54|55|56)(3:22|23|(1:25)))|51)|26|27|28|(4:33|34|35|(1:37)(2:38|(1:40)))|49|50|51) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ce, code lost:
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(ApkInfo apkInfo, String str, String str2, boolean z) throws Throwable {
        if (apkInfo == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
        String str3 = "";
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (name.contains(IStringUtil.TOP_PATH)) {
                        return "";
                    }
                    if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && !nextEntry.isDirectory() && z) {
                        String[] split = name.split("/");
                        if (split.length != 3) {
                            zipInputStream.closeEntry();
                        } else {
                            String str4 = split[1];
                            if (TextUtils.isEmpty(str4)) {
                                zipInputStream.closeEntry();
                            } else if (!arrayList.contains(str4)) {
                                arrayList.add(str4);
                            }
                        }
                    }
                    File file = null;
                    if (name.endsWith(".dex") && !nextEntry.isDirectory() && !z) {
                        String str5 = apkInfo.dataDir;
                        f(str5);
                        File file2 = new File(str5, apkInfo.key + "-" + apkInfo.versionName + ".dex");
                        try {
                            new StringBuilder().append(file2.getAbsolutePath());
                            com.baidu.sofire.b.a();
                            file2.delete();
                            file2.createNewFile();
                            if (a(file2, zipInputStream)) {
                                str3 = file2.getAbsolutePath();
                            } else if (file2.exists()) {
                                file2.delete();
                            }
                        } catch (Throwable th) {
                            th = th;
                            file = file2;
                            new StringBuilder().append(th.getMessage());
                            com.baidu.sofire.b.a();
                            if (file != null && file.exists()) {
                                file.delete();
                            }
                            zipInputStream.closeEntry();
                        }
                    }
                    zipInputStream.closeEntry();
                } else {
                    try {
                        zipInputStream.close();
                    } catch (Throwable unused) {
                        com.baidu.sofire.g.d.a();
                    }
                    if (z && arrayList.size() > 0) {
                        String a2 = a(apkInfo.hostContext, arrayList);
                        if (!TextUtils.isEmpty(a2)) {
                            File file3 = new File(str, a2);
                            f(file3.getAbsolutePath());
                            zipInputStream = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
                            while (true) {
                                try {
                                    ZipEntry nextEntry2 = zipInputStream.getNextEntry();
                                    if (nextEntry2 != null) {
                                        String name2 = nextEntry2.getName();
                                        if (name2.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name2.endsWith(".so") && !nextEntry2.isDirectory()) {
                                            String[] split2 = name2.split("/");
                                            if (split2.length != 3) {
                                                zipInputStream.closeEntry();
                                            } else if (a2.equals(split2[1])) {
                                                String substring = name2.substring(name2.lastIndexOf("/") + 1);
                                                File file4 = new File(file3, substring.replace(".so", str2 + ".so"));
                                                StringBuilder sb = new StringBuilder("l=");
                                                sb.append(str);
                                                sb.append(", n=");
                                                sb.append(name2);
                                                sb.append(", f=");
                                                sb.append(file4);
                                                com.baidu.sofire.b.a();
                                                file4.delete();
                                                file4.createNewFile();
                                                if (!a(file4, zipInputStream)) {
                                                    throw new RuntimeException("Stream UnZip so failed.Report space left.");
                                                }
                                                zipInputStream.closeEntry();
                                            }
                                        }
                                        zipInputStream.closeEntry();
                                    } else {
                                        str3 = file3.getAbsolutePath();
                                        try {
                                            zipInputStream.close();
                                            break;
                                        } catch (Throwable unused2) {
                                            com.baidu.sofire.g.d.a();
                                        }
                                    }
                                } finally {
                                    try {
                                        zipInputStream.close();
                                    } catch (Throwable unused3) {
                                        com.baidu.sofire.g.d.a();
                                    }
                                }
                            }
                        }
                    }
                    return str3;
                }
            } finally {
                try {
                    zipInputStream.close();
                } catch (Throwable unused4) {
                    com.baidu.sofire.g.d.a();
                }
            }
        }
    }

    public static boolean a(File file, ZipInputStream zipInputStream) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable unused) {
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = zipInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            com.baidu.sofire.g.d.a(file.getAbsolutePath(), true);
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
                com.baidu.sofire.g.d.a();
            }
            return true;
        } catch (Throwable unused3) {
            try {
                com.baidu.sofire.g.d.a();
                return false;
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused4) {
                        com.baidu.sofire.g.d.a();
                    }
                }
            }
        }
    }
}
