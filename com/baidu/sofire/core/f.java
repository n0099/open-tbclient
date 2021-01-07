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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.i.p;
import com.xiaomi.mipush.sdk.Constants;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
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
/* loaded from: classes15.dex */
public final class f {
    private String c;
    private boolean d;
    private static f e = null;
    private static Application f = null;
    private static Random g = new Random();

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f5511b = new ArrayList();
    private Map<String, ApkInfo> h = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ApkInfo> f5512a = new ConcurrentHashMap();
    private Map<String, MyReceiver> i = new HashMap();

    public static f a(Context context) {
        if (e == null) {
            f = (Application) context.getApplicationContext();
            e = new f();
        }
        return e;
    }

    public static f a() {
        return e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r0.intentFilters.add(r7);
        r1 = a(r7.d);
        new java.lang.StringBuilder().append(r1);
        com.baidu.sofire.b.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r1.equals("____") != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
        if (r6.i.keySet().contains(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
        r3 = new com.baidu.sofire.MyReceiver();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
        if (com.baidu.sofire.i.e.a(com.baidu.sofire.core.f.f, r3, r7.d) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
        if (r0 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
        java.lang.Thread.sleep(com.baidu.android.imsdk.internal.IMConnection.RETRY_DELAY_TIMES);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0099, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009c, code lost:
        com.baidu.sofire.i.e.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(g gVar) {
        ApkInfo apkInfo;
        String a2;
        MyReceiver myReceiver;
        if (gVar.d != null && (apkInfo = this.f5512a.get(gVar.f5513a)) != null) {
            if (apkInfo.intentFilters == null) {
                apkInfo.intentFilters = new ArrayList();
            }
            int i = 0;
            while (true) {
                if (i >= apkInfo.intentFilters.size()) {
                    break;
                } else if (gVar.a(apkInfo.intentFilters.get(i))) {
                    break;
                } else {
                    i++;
                }
            }
        }
        com.baidu.sofire.i.e.a(f, myReceiver, gVar.d);
        this.i.put(a2, myReceiver);
    }

    private static String a(IntentFilter intentFilter) {
        if (intentFilter == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int countActions = intentFilter.countActions();
            if (countActions > 0) {
                ArrayList<String> arrayList = new ArrayList();
                for (int i = 0; i < countActions; i++) {
                    String action = intentFilter.getAction(i);
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
                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                }
            } else {
                sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            }
            int countCategories = intentFilter.countCategories();
            if (countCategories > 0) {
                ArrayList<String> arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < countCategories; i2++) {
                    String category = intentFilter.getCategory(i2);
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
                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                }
            } else {
                sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            }
            if (intentFilter.countDataTypes() > 0) {
                ArrayList<String> arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < countCategories; i3++) {
                    String dataType = intentFilter.getDataType(i3);
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
                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                }
            } else {
                sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            }
            int countDataSchemes = intentFilter.countDataSchemes();
            if (countDataSchemes > 0) {
                ArrayList<String> arrayList4 = new ArrayList();
                for (int i4 = 0; i4 < countDataSchemes; i4++) {
                    String dataScheme = intentFilter.getDataScheme(i4);
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
                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                }
            } else {
                sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public final synchronized void b(g gVar) {
        try {
            if (gVar.d != null) {
                ApkInfo apkInfo = this.f5512a.get(gVar.f5513a);
                if (apkInfo != null && apkInfo.intentFilters != null) {
                    ArrayList<Integer> arrayList = new ArrayList();
                    for (int i = 0; i < apkInfo.intentFilters.size(); i++) {
                        if (gVar.a(apkInfo.intentFilters.get(i))) {
                            arrayList.add(Integer.valueOf(i));
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
                String a2 = a(gVar.d);
                new StringBuilder().append(a2);
                com.baidu.sofire.b.a();
                if (!TextUtils.isEmpty(a2)) {
                    Iterator<ApkInfo> it = b().iterator();
                    loop2: while (true) {
                        if (it.hasNext()) {
                            ApkInfo next = it.next();
                            if (next.intentFilters != null && next.intentFilters.size() > 0) {
                                for (g gVar2 : next.intentFilters) {
                                    String a3 = a(gVar2.d);
                                    if (!TextUtils.isEmpty(a3) && a3.equals(a2)) {
                                        new StringBuilder().append(a2);
                                        com.baidu.sofire.b.a();
                                        break loop2;
                                    }
                                }
                                continue;
                            }
                        } else {
                            new StringBuilder().append(a2);
                            com.baidu.sofire.b.a();
                            f.unregisterReceiver(this.i.get(a2));
                            this.i.remove(a2);
                            break;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    public final List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f5512a.keySet()) {
                arrayList.add(this.f5512a.get(str));
            }
            return arrayList;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            try {
                return new ArrayList();
            } catch (Throwable th2) {
                com.baidu.sofire.i.e.a();
                return null;
            }
        }
    }

    public final boolean a(ApkInfo apkInfo, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.d = z;
        this.c = apkInfo.versionName;
        boolean a2 = a(apkInfo);
        new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.sofire.b.a();
        return a2;
    }

    private synchronized boolean a(ApkInfo apkInfo) {
        boolean z;
        boolean z2;
        if (apkInfo != null) {
            if (!TextUtils.isEmpty(apkInfo.pkgPath)) {
                ApkInfo apkInfo2 = this.h.get(apkInfo.pkgPath);
                if (apkInfo2 != null) {
                    if (apkInfo2.versionName.equals(apkInfo.versionName)) {
                        com.baidu.sofire.b.a();
                        z2 = true;
                    } else {
                        a(apkInfo.pkgPath);
                    }
                }
                if (!com.baidu.sofire.i.e.a(new File(apkInfo.pkgPath))) {
                    com.baidu.sofire.b.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", Integer.valueOf(apkInfo.key));
                    hashMap.put("2", apkInfo.versionName);
                    com.baidu.sofire.i.e.a(f.getApplicationContext(), "1003117", hashMap);
                    z2 = false;
                } else {
                    apkInfo.hostContext = f;
                    if (apkInfo.apkParseSuc == 1) {
                        com.baidu.sofire.b.a();
                        if (TextUtils.isEmpty(apkInfo.packageName) || TextUtils.isEmpty(apkInfo.pkgPath)) {
                            throw new RuntimeException("packageName or pkgPath miss");
                        }
                        if (a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                            apkInfo.dataDir = f.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                            String str = apkInfo.dataDir + "/dex";
                            String str2 = (apkInfo.dataDir + "/lib/" + this.c) + "/" + g.nextInt();
                            f(str);
                            com.baidu.sofire.i.e.a(str, false);
                            f(str2);
                            a(apkInfo, str2, str);
                            this.h.put(apkInfo.pkgPath, apkInfo);
                            this.f5512a.put(apkInfo.packageName, apkInfo);
                            a(apkInfo, apkInfo.className);
                            z = false;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z = false;
                    }
                    if (apkInfo.apkParseSuc != 1 || z) {
                        com.baidu.sofire.b.a();
                        PackageInfo packageInfo = apkInfo.cloudPkgInfo;
                        if (packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName) && !TextUtils.isEmpty(packageInfo.versionName)) {
                            com.baidu.sofire.b.a();
                        } else {
                            packageInfo = f.getPackageManager().getPackageArchiveInfo(apkInfo.pkgPath, 1);
                            if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                                com.baidu.sofire.b.a();
                                packageInfo = a(apkInfo.packageName, apkInfo.apkMD5);
                                if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                                    throw new Exception("requestCloudPackageInfo failed");
                                }
                            }
                        }
                        if (TextUtils.isEmpty(packageInfo.packageName) || !packageInfo.packageName.startsWith("com.baidu.sofire")) {
                            throw new Exception("package name check failed");
                        }
                        if (a(apkInfo.key, packageInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                            apkInfo.packageName = packageInfo.packageName;
                            new StringBuilder("p=").append(packageInfo.packageName).append(", v=").append(packageInfo.versionName);
                            com.baidu.sofire.b.a();
                            apkInfo.className = packageInfo.applicationInfo.className;
                            apkInfo.versionName = packageInfo.versionName;
                            apkInfo.activities = packageInfo.activities;
                            apkInfo.applicationTheme = packageInfo.applicationInfo.theme;
                            apkInfo.dataDir = f.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                            String str3 = apkInfo.dataDir + "/dex";
                            String str4 = (apkInfo.dataDir + "/lib/" + this.c) + "/" + g.nextInt();
                            f(str3);
                            com.baidu.sofire.i.e.a(str3, false);
                            f(str4);
                            a(apkInfo, str4, str3);
                            this.h.put(apkInfo.pkgPath, apkInfo);
                            this.f5512a.put(apkInfo.packageName, apkInfo);
                            a(apkInfo, packageInfo.applicationInfo.className);
                        } else {
                            z2 = false;
                        }
                    }
                    z2 = true;
                }
            }
        }
        z2 = false;
        return z2;
    }

    private static PackageInfo a(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pk", str);
            jSONObject.put("m", str2);
            jSONArray.put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            com.baidu.sofire.b.a();
            String a2 = com.baidu.sofire.i.i.a(f, com.baidu.sofire.i.e.b() + "p/1/pdl", jSONArray2, false, true);
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
            applicationInfo.className = optJSONObject.optString("n");
            if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(".")) {
                applicationInfo.className = packageInfo.packageName + applicationInfo.className;
            }
            applicationInfo.theme = optJSONObject.optInt("t");
            packageInfo.applicationInfo = applicationInfo;
            JSONArray optJSONArray = optJSONObject.optJSONArray("a");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        ActivityInfo activityInfo = new ActivityInfo();
                        activityInfo.name = jSONObject2.optString("n");
                        if (!TextUtils.isEmpty(activityInfo.name) && activityInfo.name.startsWith(".")) {
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
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return null;
        }
    }

    private static boolean a(int i, String str, String str2, String str3) {
        Pair pair;
        String str4 = i + str;
        if (U.sRealtimeMd5Map != null) {
            String str5 = U.sRealtimeMd5Map.get(str4);
            if (!TextUtils.isEmpty(str5)) {
                str2 = str5;
                com.baidu.sofire.b.a();
            }
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            pair = new Pair(false, "");
        } else {
            File file = new File(str3);
            if (!com.baidu.sofire.i.e.a(file)) {
                pair = new Pair(false, "");
            } else {
                String a2 = p.a(file);
                if (TextUtils.isEmpty(a2)) {
                    pair = new Pair(false, "");
                } else if (!a2.equalsIgnoreCase(str2)) {
                    pair = new Pair(false, a2);
                } else {
                    pair = new Pair(true, "");
                }
            }
        }
        new StringBuilder(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(pair.first);
        com.baidu.sofire.b.a();
        if (((Boolean) pair.first).booleanValue()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("0", 3);
        hashMap.put("1", Integer.valueOf(i));
        hashMap.put("2", str);
        hashMap.put("3", Base64.encodeToString(((String) pair.second).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
        com.baidu.sofire.i.e.a(f.getApplicationContext(), "1003117", hashMap);
        return false;
    }

    private static boolean a(ApkInfo apkInfo, String str) {
        try {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
            com.baidu.sofire.f.a(Application.class, f, application);
            a(application, f);
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
        String str3 = (Build.VERSION.SDK_INT >= 25 || TextUtils.isEmpty(System.getProperty("java.library.path"))) ? "" : "";
        if (!TextUtils.isEmpty(a2)) {
            str3 = !TextUtils.isEmpty(str3) ? a2 + ":" + str3 : a2;
        }
        apkInfo.libPath = str3;
        ClassLoader classLoader = getClass().getClassLoader();
        new StringBuilder().append(str3);
        com.baidu.sofire.b.a();
        String str4 = "";
        try {
            String absolutePath = new File(str2, "apkDex").getAbsolutePath();
            com.baidu.sofire.i.e.d(absolutePath);
            f(absolutePath);
            apkInfo.classLoader = new e(apkInfo.pkgPath, absolutePath, str3, classLoader);
            Class<?> loadClass = apkInfo.classLoader.loadClass("com.baidu.sofire.engine.EngineImpl");
            new StringBuilder().append(loadClass);
            com.baidu.sofire.b.a();
            if (loadClass == null || TextUtils.isEmpty(loadClass.getName())) {
                throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.a();
            try {
                com.baidu.sofire.i.e.d(new File(str2, "apkDex").getAbsolutePath());
                String absolutePath2 = new File(str2, "dexDex").getAbsolutePath();
                com.baidu.sofire.i.e.d(absolutePath2);
                f(absolutePath2);
                str4 = a(apkInfo, str, false);
                new StringBuilder().append(str4);
                com.baidu.sofire.b.a();
                apkInfo.classLoader = new e(str4, absolutePath2, str3, classLoader);
                Class<?> loadClass2 = apkInfo.classLoader.loadClass("com.baidu.sofire.engine.EngineImpl");
                new StringBuilder().append(loadClass2);
                com.baidu.sofire.b.a();
                new StringBuilder().append(str4);
                com.baidu.sofire.b.a();
                File file = new File(str4);
                if (file.exists()) {
                    file.delete();
                }
                if (loadClass2 == null || TextUtils.isEmpty(loadClass2.getName())) {
                    throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                }
            } catch (Throwable th2) {
                String str5 = str4;
                com.baidu.sofire.b.a();
                if (apkInfo != null) {
                    try {
                        com.baidu.sofire.i.e.d(apkInfo.dataDir);
                        if (f != null) {
                            com.baidu.sofire.i.e.d(f.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                        }
                    } catch (Throwable th3) {
                        com.baidu.sofire.i.e.a();
                    }
                }
                if (apkInfo != null) {
                    throw new RuntimeException("can't load EngineImpl by both dexFile:" + str5 + " and ZipFile:" + apkInfo.pkgPath);
                }
                throw new RuntimeException("can't load EngineImpl by both dexFile:" + str5 + " and ZipFile:null");
            }
        }
    }

    public final boolean a(String str) {
        ApkInfo apkInfo = this.h.get(str);
        if (apkInfo != null) {
            this.h.remove(str);
            this.f5512a.remove(apkInfo.packageName);
            com.baidu.sofire.mutiprocess.b.b(apkInfo.packageName);
            com.baidu.sofire.i.e.d(apkInfo.dataDir);
            if (f != null) {
                com.baidu.sofire.i.e.d(f.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            return true;
        }
        return false;
    }

    public final boolean b(String str) {
        ApkInfo apkInfo = this.f5512a.get(str);
        if (apkInfo != null) {
            this.h.remove(apkInfo.pkgPath);
            this.f5512a.remove(str);
            com.baidu.sofire.mutiprocess.b.b(str);
            com.baidu.sofire.i.e.d(apkInfo.dataDir);
            if (f != null) {
                com.baidu.sofire.i.e.d(f.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            new StringBuilder().append(this.h.size());
            com.baidu.sofire.b.a();
            new StringBuilder().append(this.f5512a.size());
            com.baidu.sofire.b.a();
            return true;
        }
        return false;
    }

    public final ApkInfo c(String str) {
        try {
            return this.h.get(str);
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return null;
        }
    }

    public final ApkInfo d(String str) {
        try {
            return this.f5512a.get(str);
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return null;
        }
    }

    private static void a(Application application, Context context) {
        Class<?> cls = context.getClass();
        for (Class<Application> cls2 = Application.class; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField("mBase");
                declaredField.setAccessible(true);
                if (declaredField.getType().isAssignableFrom(cls)) {
                    declaredField.set(application, context);
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
        }
    }

    private static boolean f(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [977=4, 979=5, 981=5, 982=6] */
    /* JADX WARN: Can't wrap try/catch for region: R(6:20|(3:27|(3:29|30|(1:37)(4:32|33|(1:35)|36))(1:39)|38)|40|41|(6:48|49|50|51|53|(3:62|63|64)(3:55|56|(3:58|59|60)(1:61)))|38) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:5|(1:174)(1:9)|(7:10|11|12|13|14|(4:18|(5:82|83|84|85|87)(6:20|(3:27|(3:29|30|(1:37)(4:32|33|(1:35)|36))(1:39)|38)|40|41|(6:48|49|50|51|53|(3:62|63|64)(3:55|56|(3:58|59|60)(1:61)))|38)|15|16)|91)|(2:95|(8:97|(3:101|(2:104|102)|105)|106|107|108|109|110|(2:112|113)(1:114)))|119|108|109|110|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02a6, code lost:
        com.baidu.sofire.i.e.a();
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02cd, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02ce, code lost:
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(ApkInfo apkInfo, String str, boolean z) throws Throwable {
        ZipFile zipFile;
        String str2;
        String str3;
        boolean z2;
        HashMap hashMap;
        ZipFile zipFile2 = null;
        if (apkInfo == null) {
            return "";
        }
        String replace = (!z || TextUtils.isEmpty(apkInfo.versionName)) ? "" : apkInfo.versionName.replace(".", "");
        try {
            try {
                zipFile = new ZipFile(apkInfo.pkgPath);
            } catch (FileNotFoundException e2) {
                String message = e2.getMessage();
                File file = new File(apkInfo.hostContext.getFilesDir(), ".b");
                if (!file.exists()) {
                    throw new FileNotFoundException(message + "--backupDir not exists");
                }
                File file2 = new File(file, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                if (!file2.exists()) {
                    throw new FileNotFoundException(message + "--backupFile not exists");
                }
                File file3 = new File(apkInfo.pkgPath);
                com.baidu.sofire.i.e.a(file2, file3);
                com.baidu.sofire.i.e.a(apkInfo.pkgPath, true);
                com.baidu.sofire.c.a(file3);
                com.baidu.sofire.c.a(apkInfo.hostContext, apkInfo.key, file3, file2);
                if (!file3.exists()) {
                    throw new FileNotFoundException(message + "--file not exists after copy");
                }
                zipFile = new ZipFile(apkInfo.pkgPath);
            }
            try {
                try {
                    hashMap = new HashMap();
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    str3 = "";
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            String name = nextElement.getName();
                            if (name.contains(IStringUtil.TOP_PATH)) {
                                try {
                                    zipFile.close();
                                    return "";
                                } catch (Throwable th) {
                                    com.baidu.sofire.i.e.a();
                                    return "";
                                }
                            }
                            if (!TextUtils.isEmpty(name) && name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && !nextElement.isDirectory() && z) {
                                String[] split = name.split("/");
                                if (split.length == 3) {
                                    String str4 = split[1];
                                    if (!TextUtils.isEmpty(str4)) {
                                        List list = (List) hashMap.get(str4);
                                        if (list == null) {
                                            list = new ArrayList();
                                            hashMap.put(str4, list);
                                        }
                                        list.add(nextElement);
                                    }
                                }
                            }
                            if (name.endsWith(".dex") && !nextElement.isDirectory() && !z) {
                                String str5 = apkInfo.dataDir;
                                f(str5);
                                File file4 = new File(str5, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".dex");
                                try {
                                    new StringBuilder("e: ").append(file4.getAbsolutePath());
                                    com.baidu.sofire.b.a();
                                    if (a(zipFile, nextElement, file4)) {
                                        str3 = file4.getAbsolutePath();
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
                                }
                            }
                        } catch (EOFException e3) {
                            if (zipFile == null) {
                                try {
                                    zipFile.close();
                                    z2 = true;
                                    str2 = str3;
                                } catch (Throwable th3) {
                                    com.baidu.sofire.i.e.a();
                                    z2 = true;
                                    str2 = str3;
                                }
                            } else {
                                z2 = true;
                                str2 = str3;
                            }
                            if (!z2) {
                            }
                        } catch (ZipException e4) {
                            zipFile2 = zipFile;
                            str2 = str3;
                            if (zipFile2 == null) {
                                try {
                                    zipFile2.close();
                                    z2 = true;
                                } catch (Throwable th4) {
                                    com.baidu.sofire.i.e.a();
                                    z2 = true;
                                }
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Throwable th6) {
                            com.baidu.sofire.i.e.a();
                        }
                    }
                    throw th;
                }
            } catch (EOFException e5) {
                str3 = "";
            } catch (ZipException e6) {
                zipFile2 = zipFile;
                str2 = "";
            }
        } catch (EOFException e7) {
            zipFile = null;
            str3 = "";
            if (zipFile == null) {
            }
            if (!z2) {
            }
        } catch (ZipException e8) {
            str2 = "";
            if (zipFile2 == null) {
            }
            if (!z2) {
            }
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            if (zipFile != null) {
            }
            throw th;
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
                        a(zipFile, zipEntry, new File(file5, name2.substring(name2.lastIndexOf("/") + 1).replace(PluginInstallerService.APK_LIB_SUFFIX, replace + PluginInstallerService.APK_LIB_SUFFIX)));
                    }
                }
                str2 = file5.getAbsolutePath();
                zipFile.close();
                z2 = false;
                return !z2 ? a(apkInfo, str, replace, z) : str2;
            }
        }
        str2 = str3;
        zipFile.close();
        z2 = false;
        if (!z2) {
        }
    }

    private static String a(Context context, Collection<String> collection) {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 21) {
            String p = com.baidu.sofire.i.e.p(context);
            if (TextUtils.isEmpty(p) || !collection.contains(p)) {
                boolean d = com.baidu.sofire.i.e.d();
                if (d) {
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
                if (!d && collection.contains("armeabi") && Build.SUPPORTED_ABIS != null && Build.SUPPORTED_ABIS.length > 0 && !IDevices.ABI_MIPS.equals(Build.SUPPORTED_ABIS[0])) {
                    return "armeabi";
                }
            } else {
                return p;
            }
        } else if (collection.contains(Build.CPU_ABI)) {
            return Build.CPU_ABI;
        } else {
            if (collection.contains(Build.CPU_ABI2)) {
                return Build.CPU_ABI2;
            }
            if (collection.contains("armeabi") && !IDevices.ABI_MIPS.equals(Build.CPU_ABI)) {
                return "armeabi";
            }
        }
        return "";
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1055=4] */
    private static boolean a(java.util.zip.ZipFile r7, java.util.zip.ZipEntry r8, java.io.File r9) {
        /*
            r3 = 0
            r1 = 1
            r0 = 0
            if (r8 != 0) goto L6
        L5:
            return r0
        L6:
            java.io.InputStream r4 = r7.getInputStream(r8)     // Catch: java.lang.Throwable -> L77
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L7b
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L7b
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L1e
        L13:
            int r5 = r4.read(r3)     // Catch: java.lang.Throwable -> L1e
            if (r5 <= 0) goto L33
            r6 = 0
            r2.write(r3, r6, r5)     // Catch: java.lang.Throwable -> L1e
            goto L13
        L1e:
            r1 = move-exception
            r1 = r2
        L20:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L74
            if (r4 == 0) goto L28
            r4.close()     // Catch: java.lang.Throwable -> L52
        L28:
            if (r1 == 0) goto L5
            r1.close()     // Catch: java.lang.Throwable -> L2e
            goto L5
        L2e:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L5
        L33:
            r2.flush()     // Catch: java.lang.Throwable -> L1e
            java.lang.String r3 = r9.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            r5 = 1
            com.baidu.sofire.i.e.a(r3, r5)     // Catch: java.lang.Throwable -> L1e
            if (r4 == 0) goto L43
            r4.close()     // Catch: java.lang.Throwable -> L48
        L43:
            r2.close()     // Catch: java.lang.Throwable -> L4d
        L46:
            r0 = r1
            goto L5
        L48:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L43
        L4d:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L46
        L52:
            r2 = move-exception
            com.baidu.sofire.i.e.a()
            goto L28
        L57:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L5a:
            if (r4 == 0) goto L5f
            r4.close()     // Catch: java.lang.Throwable -> L65
        L5f:
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.lang.Throwable -> L6a
        L64:
            throw r0
        L65:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L5f
        L6a:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L64
        L6f:
            r0 = move-exception
            r2 = r3
            goto L5a
        L72:
            r0 = move-exception
            goto L5a
        L74:
            r0 = move-exception
            r2 = r1
            goto L5a
        L77:
            r1 = move-exception
            r1 = r3
            r4 = r3
            goto L20
        L7b:
            r1 = move-exception
            r1 = r3
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.f.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(9:11|(3:16|(3:57|58|59)(4:18|19|20|(3:54|55|56)(3:22|23|(1:25)))|50)|26|27|28|(4:33|34|35|(1:37)(2:38|(1:40)))|48|49|50) */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e9, code lost:
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ea, code lost:
        r2 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(ApkInfo apkInfo, String str, String str2, boolean z) throws Throwable {
        if (apkInfo == null) {
            return "";
        }
        String str3 = "";
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (!name.contains(IStringUtil.TOP_PATH)) {
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
                        if (name.endsWith(".dex") && !nextEntry.isDirectory() && !z) {
                            String str5 = apkInfo.dataDir;
                            f(str5);
                            File file = new File(str5, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".dex");
                            try {
                                new StringBuilder().append(file.getAbsolutePath());
                                com.baidu.sofire.b.a();
                                file.delete();
                                file.createNewFile();
                                if (a(file, zipInputStream)) {
                                    str3 = file.getAbsolutePath();
                                } else if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Throwable th) {
                                th = th;
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
                            return "";
                        } catch (Throwable th2) {
                            com.baidu.sofire.i.e.a();
                            return "";
                        }
                    }
                } else {
                    try {
                        zipInputStream.close();
                    } catch (Throwable th3) {
                        com.baidu.sofire.i.e.a();
                    }
                    if (z && arrayList.size() > 0) {
                        String a2 = a(apkInfo.hostContext, arrayList);
                        if (!TextUtils.isEmpty(a2)) {
                            File file2 = new File(str, a2);
                            f(file2.getAbsolutePath());
                            zipInputStream = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
                            while (true) {
                                try {
                                    ZipEntry nextEntry2 = zipInputStream.getNextEntry();
                                    if (nextEntry2 != null) {
                                        String name2 = nextEntry2.getName();
                                        if (name2.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name2.endsWith(PluginInstallerService.APK_LIB_SUFFIX) && !nextEntry2.isDirectory()) {
                                            String[] split2 = name2.split("/");
                                            if (split2.length != 3) {
                                                zipInputStream.closeEntry();
                                            } else if (a2.equals(split2[1])) {
                                                File file3 = new File(file2, name2.substring(name2.lastIndexOf("/") + 1).replace(PluginInstallerService.APK_LIB_SUFFIX, str2 + PluginInstallerService.APK_LIB_SUFFIX));
                                                new StringBuilder("l=").append(str).append(", n=").append(name2).append(", f=").append(file3);
                                                com.baidu.sofire.b.a();
                                                file3.delete();
                                                file3.createNewFile();
                                                a(file3, zipInputStream);
                                            }
                                        }
                                        zipInputStream.closeEntry();
                                    } else {
                                        String absolutePath = file2.getAbsolutePath();
                                        try {
                                            zipInputStream.close();
                                            return absolutePath;
                                        } catch (Throwable th4) {
                                            com.baidu.sofire.i.e.a();
                                            return absolutePath;
                                        }
                                    }
                                } finally {
                                }
                            }
                        } else {
                            return str3;
                        }
                    } else {
                        return str3;
                    }
                }
            } finally {
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static boolean a(java.io.File r6, java.util.zip.ZipInputStream r7) {
        /*
            r0 = 1
            r1 = 0
            r3 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L50
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L50
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L17
        Lc:
            int r4 = r7.read(r3)     // Catch: java.lang.Throwable -> L17
            if (r4 <= 0) goto L23
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L17
            goto Lc
        L17:
            r0 = move-exception
            r0 = r2
        L19:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L21
            r0.close()     // Catch: java.lang.Throwable -> L37
        L21:
            r0 = r1
        L22:
            return r0
        L23:
            r2.flush()     // Catch: java.lang.Throwable -> L17
            java.lang.String r3 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L17
            r4 = 1
            com.baidu.sofire.i.e.a(r3, r4)     // Catch: java.lang.Throwable -> L17
            r2.close()     // Catch: java.lang.Throwable -> L32
            goto L22
        L32:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L22
        L37:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L21
        L3c:
            r0 = move-exception
            r1 = r0
            r2 = r3
        L3f:
            if (r2 == 0) goto L44
            r2.close()     // Catch: java.lang.Throwable -> L45
        L44:
            throw r1
        L45:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L44
        L4a:
            r0 = move-exception
            r1 = r0
            goto L3f
        L4d:
            r1 = move-exception
            r2 = r0
            goto L3f
        L50:
            r0 = move-exception
            r0 = r3
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.f.a(java.io.File, java.util.zip.ZipInputStream):boolean");
    }

    public final boolean e(String str) {
        try {
            ApkInfo apkInfo = this.f5512a.get(str);
            if (apkInfo != null) {
                Class<?> a2 = ((e) apkInfo.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, f);
                if (invoke != null) {
                    com.baidu.sofire.i.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                }
                this.h.remove(apkInfo.pkgPath);
                this.f5512a.remove(str);
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return false;
        }
    }
}
