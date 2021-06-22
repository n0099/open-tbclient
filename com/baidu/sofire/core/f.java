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
import com.baidu.sofire.utility.o;
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
    public static f f10276e;

    /* renamed from: f  reason: collision with root package name */
    public static Application f10277f;

    /* renamed from: c  reason: collision with root package name */
    public String f10280c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10281d;

    /* renamed from: g  reason: collision with root package name */
    public static Random f10278g = new Random();

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f10275b = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, ApkInfo> f10282h = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ApkInfo> f10279a = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    public Map<String, MyReceiver> f10283i = new HashMap();

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (f10276e == null) {
                f10277f = (Application) context.getApplicationContext();
                f10276e = new f();
            }
            fVar = f10276e;
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
            com.baidu.sofire.utility.c.a();
            return false;
        }
    }

    public final synchronized void b(g gVar) {
        try {
            if (gVar.f10287d == null) {
                return;
            }
            ApkInfo apkInfo = this.f10279a.get(gVar.f10284a);
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
            String a2 = a(gVar.f10287d);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            for (ApkInfo apkInfo2 : b()) {
                if (apkInfo2.intentFilters != null && apkInfo2.intentFilters.size() > 0) {
                    for (g gVar2 : apkInfo2.intentFilters) {
                        String a3 = a(gVar2.f10287d);
                        if (!TextUtils.isEmpty(a3) && a3.equals(a2)) {
                            return;
                        }
                    }
                    continue;
                }
            }
            f10277f.unregisterReceiver(this.f10283i.get(a2));
            this.f10283i.remove(a2);
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public final ApkInfo c(String str) {
        try {
            return this.f10282h.get(str);
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return null;
        }
    }

    public final ApkInfo d(String str) {
        try {
            return this.f10279a.get(str);
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return null;
        }
    }

    public final boolean e(String str) {
        try {
            ApkInfo apkInfo = this.f10279a.get(str);
            if (apkInfo != null) {
                Class<?> a2 = ((e) apkInfo.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, f10277f);
                if (invoke != null) {
                    com.baidu.sofire.utility.c.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                }
                this.f10282h.remove(apkInfo.pkgPath);
                this.f10279a.remove(str);
                return true;
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return false;
        }
    }

    public static f a() {
        return f10276e;
    }

    public final synchronized void a(g gVar) {
        try {
            if (gVar.f10287d == null) {
                return;
            }
            ApkInfo apkInfo = this.f10279a.get(gVar.f10284a);
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
                String a2 = a(gVar.f10287d);
                if (!TextUtils.isEmpty(a2) && !a2.equals("____")) {
                    if (!this.f10283i.keySet().contains(a2)) {
                        MyReceiver myReceiver = new MyReceiver();
                        if (!com.baidu.sofire.utility.c.a(f10277f, myReceiver, gVar.f10287d)) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException unused) {
                                com.baidu.sofire.utility.c.a();
                            }
                            com.baidu.sofire.utility.c.a(f10277f, myReceiver, gVar.f10287d);
                        }
                        this.f10283i.put(a2, myReceiver);
                    }
                }
            }
        } catch (Throwable unused2) {
            com.baidu.sofire.utility.c.a();
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
            for (String str : this.f10279a.keySet()) {
                arrayList.add(this.f10279a.get(str));
            }
            return arrayList;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            try {
                return new ArrayList();
            } catch (Throwable unused2) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
    }

    public final boolean b(String str) {
        ApkInfo apkInfo = this.f10279a.get(str);
        if (apkInfo != null) {
            this.f10282h.remove(apkInfo.pkgPath);
            this.f10279a.remove(str);
            com.baidu.sofire.mutiprocess.b.b(str);
            com.baidu.sofire.utility.c.d(apkInfo.dataDir);
            Application application = f10277f;
            if (application != null) {
                com.baidu.sofire.utility.c.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                return true;
            }
            return true;
        }
        return false;
    }

    public final boolean a(ApkInfo apkInfo, boolean z) {
        System.currentTimeMillis();
        this.f10281d = z;
        this.f10280c = apkInfo.versionName;
        return a(apkInfo);
    }

    private synchronized boolean a(ApkInfo apkInfo) {
        boolean z;
        if (apkInfo != null) {
            if (!TextUtils.isEmpty(apkInfo.pkgPath)) {
                ApkInfo apkInfo2 = this.f10282h.get(apkInfo.pkgPath);
                if (apkInfo2 != null) {
                    if (apkInfo2.versionName.equals(apkInfo.versionName)) {
                        return true;
                    }
                    a(apkInfo.pkgPath);
                }
                if (!com.baidu.sofire.utility.c.a(new File(apkInfo.pkgPath))) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", Integer.valueOf(apkInfo.key));
                    hashMap.put("2", apkInfo.versionName);
                    com.baidu.sofire.utility.c.a(f10277f.getApplicationContext(), "1003117", (Map<String, Object>) hashMap, false);
                    return false;
                }
                apkInfo.hostContext = f10277f;
                if (apkInfo.apkParseSuc == 1) {
                    try {
                        if (!TextUtils.isEmpty(apkInfo.packageName) && !TextUtils.isEmpty(apkInfo.pkgPath)) {
                            if (!a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                                return false;
                            }
                            apkInfo.dataDir = f10277f.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                            String str = apkInfo.dataDir + "/dex";
                            String str2 = (apkInfo.dataDir + "/lib/" + this.f10280c) + "/" + f10278g.nextInt();
                            f(str);
                            com.baidu.sofire.utility.c.a(str, false);
                            f(str2);
                            a(apkInfo, str2, str);
                            this.f10282h.put(apkInfo.pkgPath, apkInfo);
                            this.f10279a.put(apkInfo.packageName, apkInfo);
                            a(apkInfo, apkInfo.className);
                        } else {
                            throw new RuntimeException("packageName or pkgPath miss");
                        }
                    } catch (Throwable unused) {
                        a(apkInfo.pkgPath);
                        com.baidu.sofire.utility.c.a();
                        z = true;
                    }
                }
                z = false;
                if (apkInfo.apkParseSuc != 1 || z) {
                    PackageInfo packageInfo = apkInfo.cloudPkgInfo;
                    if ((packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) && (((packageInfo = f10277f.getPackageManager().getPackageArchiveInfo(apkInfo.pkgPath, 1)) == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) && ((packageInfo = a(apkInfo.packageName, apkInfo.apkMD5)) == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)))) {
                        throw new Exception("requestCloudPackageInfo failed");
                    }
                    if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.baidu.sofire")) {
                        if (!a(apkInfo.key, packageInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                            return false;
                        }
                        apkInfo.packageName = packageInfo.packageName;
                        apkInfo.className = packageInfo.applicationInfo.className;
                        apkInfo.versionName = packageInfo.versionName;
                        apkInfo.activities = packageInfo.activities;
                        apkInfo.applicationTheme = packageInfo.applicationInfo.theme;
                        apkInfo.dataDir = f10277f.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                        String str3 = apkInfo.dataDir + "/dex";
                        String str4 = (apkInfo.dataDir + "/lib/" + this.f10280c) + "/" + f10278g.nextInt();
                        f(str3);
                        com.baidu.sofire.utility.c.a(str3, false);
                        f(str4);
                        a(apkInfo, str4, str3);
                        this.f10282h.put(apkInfo.pkgPath, apkInfo);
                        this.f10279a.put(apkInfo.packageName, apkInfo);
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
            JSONArray jSONArray2 = new JSONArray(com.baidu.sofire.utility.f.a(f10277f, com.baidu.sofire.utility.c.b() + "p/1/pdl", jSONArray.toString(), false, true));
            if (jSONArray2.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = jSONArray2.optJSONObject(0);
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
            com.baidu.sofire.utility.c.a();
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
                str2 = str5;
            }
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            File file = new File(str3);
            if (!com.baidu.sofire.utility.c.a(file)) {
                pair = new Pair(Boolean.FALSE, "");
            } else {
                String a2 = o.a(file);
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
        if (((Boolean) pair.first).booleanValue()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("0", 3);
        hashMap.put("1", Integer.valueOf(i2));
        hashMap.put("2", str);
        hashMap.put("3", Base64.encodeToString(((String) pair.second).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
        com.baidu.sofire.utility.c.a(f10277f.getApplicationContext(), "1003117", (Map<String, Object>) hashMap, false);
        return false;
    }

    public static boolean a(ApkInfo apkInfo, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
            com.baidu.sofire.e.a(Application.class, f10277f, application);
            Application application2 = f10277f;
            Class<?> cls = application2.getClass();
            for (Class<Application> cls2 = Application.class; cls2 != null; cls2 = cls2.getSuperclass()) {
                Field declaredField = cls2.getDeclaredField("mBase");
                declaredField.setAccessible(true);
                if (declaredField.getType().isAssignableFrom(cls)) {
                    declaredField.set(application, application2);
                }
            }
            application.onCreate();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void a(ApkInfo apkInfo, String str, String str2) throws Throwable {
        f10277f.getFilesDir();
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
        try {
            try {
                File file = new File(str2, "apkDex");
                String absolutePath = file.getAbsolutePath();
                com.baidu.sofire.utility.c.d(absolutePath);
                f(absolutePath);
                if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
                    long freeSpace = file.getFreeSpace();
                    File file2 = new File(apkInfo.pkgPath);
                    if (file2.exists() && file2.isFile()) {
                        long length = file2.length();
                        StringBuilder sb = new StringBuilder("V5 freeSpace=");
                        sb.append(freeSpace);
                        sb.append(",fileSize=");
                        sb.append(length);
                        com.baidu.sofire.b.a();
                        if (freeSpace < length * 2) {
                            throw new Exception("Have no space to load plugin.");
                        }
                    }
                }
                e eVar = new e(apkInfo.pkgPath, absolutePath, a2, classLoader);
                apkInfo.classLoader = eVar;
                Class<?> loadClass = eVar.loadClass("com.baidu.sofire.engine.EngineImpl");
                if (loadClass == null || TextUtils.isEmpty(loadClass.getName())) {
                    throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.d(new File(str2, "apkDex").getAbsolutePath());
                String absolutePath2 = new File(str2, "dexDex").getAbsolutePath();
                com.baidu.sofire.utility.c.d(absolutePath2);
                f(absolutePath2);
                str3 = a(apkInfo, str, false);
                e eVar2 = new e(str3, absolutePath2, a2, classLoader);
                apkInfo.classLoader = eVar2;
                Class<?> loadClass2 = eVar2.loadClass("com.baidu.sofire.engine.EngineImpl");
                File file3 = new File(str3);
                if (file3.exists()) {
                    file3.delete();
                }
                if (loadClass2 == null || TextUtils.isEmpty(loadClass2.getName())) {
                    throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                }
            }
        } catch (Throwable unused2) {
            if (apkInfo != null) {
                try {
                    com.baidu.sofire.utility.c.d(apkInfo.dataDir);
                    if (f10277f != null) {
                        com.baidu.sofire.utility.c.d(f10277f.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                    }
                } catch (Throwable unused3) {
                    com.baidu.sofire.utility.c.a();
                }
            }
            if (apkInfo != null) {
                throw new RuntimeException("can't load EngineImpl by both dexFile:" + str3 + " and ZipFile:" + apkInfo.pkgPath);
            }
            throw new RuntimeException("can't load EngineImpl by both dexFile:" + str3 + " and ZipFile:null");
        }
    }

    public final boolean a(String str) {
        ApkInfo apkInfo = this.f10282h.get(str);
        if (apkInfo != null) {
            this.f10282h.remove(str);
            this.f10279a.remove(apkInfo.packageName);
            com.baidu.sofire.mutiprocess.b.b(apkInfo.packageName);
            com.baidu.sofire.utility.c.d(apkInfo.dataDir);
            Application application = f10277f;
            if (application != null) {
                com.baidu.sofire.utility.c.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:25|(1:74)(3:32|(2:34|(1:72)(3:36|(1:38)|39))(1:73)|52)|40|41|(4:46|47|48|(2:50|51)(2:53|(2:55|56)(1:57)))|52) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014f, code lost:
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0280 A[Catch: all -> 0x028d, TRY_ENTER, TryCatch #7 {all -> 0x028d, blocks: (B:125:0x0280, B:128:0x0289), top: B:149:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0289 A[Catch: all -> 0x028d, TRY_LEAVE, TryCatch #7 {all -> 0x028d, blocks: (B:125:0x0280, B:128:0x0289), top: B:149:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0299 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0273 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            com.baidu.sofire.utility.c.a();
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
                                com.baidu.sofire.utility.c.a(file2, file3);
                                com.baidu.sofire.utility.c.a(apkInfo.pkgPath, true);
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
                                            com.baidu.sofire.utility.c.a();
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
                                            if (a(zipFile5, nextElement, file4)) {
                                                str2 = file4.getAbsolutePath();
                                            } else if (file4.exists()) {
                                                file4.delete();
                                            }
                                        } catch (Throwable unused5) {
                                            if (file4 != null && file4.exists()) {
                                                file4.delete();
                                            }
                                            str4 = str3;
                                        }
                                    }
                                    str4 = str3;
                                } catch (EOFException unused6) {
                                    zipFile3 = zipFile5;
                                    str4 = str2;
                                    if (zipFile3 != null) {
                                    }
                                    str2 = str4;
                                    z2 = true;
                                    if (z2) {
                                    }
                                } catch (ZipException unused7) {
                                    zipFile2 = zipFile5;
                                    str4 = str2;
                                    if (zipFile2 != null) {
                                    }
                                    str2 = str4;
                                    z2 = true;
                                    if (z2) {
                                    }
                                }
                            } catch (EOFException unused8) {
                            } catch (ZipException unused9) {
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
                        } catch (Throwable unused10) {
                            com.baidu.sofire.utility.c.a();
                        }
                        z2 = false;
                    } catch (Throwable th2) {
                        th = th2;
                        zipFile = zipFile5;
                        if (zipFile != null) {
                        }
                        throw th;
                    }
                } catch (EOFException unused11) {
                    zipFile3 = zipFile5;
                    str4 = "";
                } catch (ZipException unused12) {
                    zipFile2 = zipFile5;
                    str4 = "";
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile = null;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Throwable unused13) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                throw th;
            }
        } catch (EOFException unused14) {
            str4 = "";
            zipFile3 = null;
            if (zipFile3 != null) {
            }
            str2 = str4;
            z2 = true;
            if (z2) {
            }
        } catch (ZipException unused15) {
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
            String p = com.baidu.sofire.utility.c.p(context);
            if (TextUtils.isEmpty(p) || !collection.contains(p)) {
                boolean d2 = com.baidu.sofire.utility.c.d();
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
            return p;
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
                com.baidu.sofire.utility.c.a(file.getAbsolutePath(), true);
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable unused2) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (Throwable unused3) {
                    com.baidu.sofire.utility.c.a();
                }
                return true;
            } catch (Throwable unused4) {
                inputStream = inputStream2;
                try {
                    com.baidu.sofire.utility.c.a();
                    return false;
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused5) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused6) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                }
            }
        } catch (Throwable unused7) {
            fileOutputStream = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(9:12|(3:17|(3:55|56|57)(3:19|20|(3:52|53|54)(3:22|23|(1:25)))|49)|26|27|28|(4:33|34|35|(1:37)(2:38|(1:40)))|47|48|49) */
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
                            file2.delete();
                            file2.createNewFile();
                            if (a(file2, zipInputStream)) {
                                str3 = file2.getAbsolutePath();
                            } else if (file2.exists()) {
                                file2.delete();
                            }
                        } catch (Throwable unused) {
                            file = file2;
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
                    } catch (Throwable unused2) {
                        com.baidu.sofire.utility.c.a();
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
                                        } catch (Throwable unused3) {
                                            com.baidu.sofire.utility.c.a();
                                        }
                                    }
                                } finally {
                                    try {
                                        zipInputStream.close();
                                    } catch (Throwable unused4) {
                                        com.baidu.sofire.utility.c.a();
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
                } catch (Throwable unused5) {
                    com.baidu.sofire.utility.c.a();
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
            com.baidu.sofire.utility.c.a(file.getAbsolutePath(), true);
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
                com.baidu.sofire.utility.c.a();
            }
            return true;
        } catch (Throwable unused3) {
            try {
                com.baidu.sofire.utility.c.a();
                return false;
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused4) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
            }
        }
    }
}
