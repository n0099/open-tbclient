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
import android.util.Log;
import android.util.Pair;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.mobstat.Config;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.b.h;
import com.baidu.sofire.b.n;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    private String c;
    private boolean d;
    private static e e = null;
    private static Application f = null;
    private static Random g = new Random();
    public static List<Integer> b = new ArrayList();
    private Map<String, ApkInfo> h = new ConcurrentHashMap();
    public Map<String, ApkInfo> a = new ConcurrentHashMap();
    private Map<String, MyReceiver> i = new HashMap();

    public static e a(Context context) {
        if (e == null) {
            f = (Application) context.getApplicationContext();
            e = new e();
        }
        return e;
    }

    public static e a() {
        return e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r0.intentFilters.add(r7);
        r1 = a(r7.d);
        new java.lang.StringBuilder().append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (r1.equals("____") != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r6.i.keySet().contains(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        if ("android.intent.action.PACKAGE_REMOVED__package".equals(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        r3 = new com.baidu.sofire.MyReceiver();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        com.baidu.sofire.core.e.f.registerReceiver(r3, r7.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009d, code lost:
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(f fVar) {
        ApkInfo apkInfo;
        String a;
        MyReceiver myReceiver;
        boolean z;
        if (fVar.d != null && (apkInfo = this.a.get(fVar.a)) != null) {
            if (apkInfo.intentFilters == null) {
                apkInfo.intentFilters = new ArrayList();
            }
            int i = 0;
            while (true) {
                if (i >= apkInfo.intentFilters.size()) {
                    break;
                } else if (fVar.a(apkInfo.intentFilters.get(i))) {
                    break;
                } else {
                    i++;
                }
            }
        }
        f.registerReceiver(myReceiver, fVar.d);
        this.i.put(a, myReceiver);
        if (z) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e2) {
                com.baidu.sofire.b.e.a(e2);
            }
            f.registerReceiver(myReceiver, fVar.d);
        }
        this.i.put(a, myReceiver);
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
                    sb.append("_");
                }
            } else {
                sb.append("_");
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
                    sb.append("_");
                }
            } else {
                sb.append("_");
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
                    sb.append("_");
                }
            } else {
                sb.append("_");
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
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public final synchronized void b(f fVar) {
        try {
            if (fVar.d != null) {
                ApkInfo apkInfo = this.a.get(fVar.a);
                if (apkInfo != null && apkInfo.intentFilters != null) {
                    ArrayList<Integer> arrayList = new ArrayList();
                    for (int i = 0; i < apkInfo.intentFilters.size(); i++) {
                        if (fVar.a(apkInfo.intentFilters.get(i))) {
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
                String a = a(fVar.d);
                new StringBuilder().append(a);
                if (!TextUtils.isEmpty(a) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a)) {
                    Iterator<ApkInfo> it = b().iterator();
                    loop2: while (true) {
                        if (it.hasNext()) {
                            ApkInfo next = it.next();
                            if (next.intentFilters != null && next.intentFilters.size() > 0) {
                                for (f fVar2 : next.intentFilters) {
                                    String a2 = a(fVar2.d);
                                    if (!TextUtils.isEmpty(a2) && a2.equals(a)) {
                                        new StringBuilder().append(a);
                                        break loop2;
                                    }
                                }
                                continue;
                            }
                        } else {
                            new StringBuilder().append(a);
                            f.unregisterReceiver(this.i.get(a));
                            this.i.remove(a);
                            break;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public final List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.a.keySet()) {
                arrayList.add(this.a.get(str));
            }
            return arrayList;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            try {
                return new ArrayList();
            } catch (Throwable th2) {
                com.baidu.sofire.b.e.a(th2);
                return null;
            }
        }
    }

    public final boolean a(ApkInfo apkInfo, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.d = z;
        this.c = apkInfo.versionName;
        boolean a = a(apkInfo);
        new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis);
        return a;
    }

    private synchronized boolean a(ApkInfo apkInfo) {
        boolean z;
        PackageInfo packageInfo;
        Pair pair;
        boolean z2;
        if (apkInfo != null) {
            if (!TextUtils.isEmpty(apkInfo.pkgPath)) {
                ApkInfo apkInfo2 = this.h.get(apkInfo.pkgPath);
                if (apkInfo2 != null) {
                    if (apkInfo2.versionName.equals(apkInfo.versionName)) {
                        z2 = true;
                    } else {
                        a(apkInfo.pkgPath);
                    }
                }
                if (!com.baidu.sofire.b.e.a(new File(apkInfo.pkgPath))) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", Integer.valueOf(apkInfo.key));
                    hashMap.put("2", apkInfo.versionName);
                    com.baidu.sofire.b.e.a(f.getApplicationContext(), "1003117", hashMap);
                    z2 = false;
                } else {
                    apkInfo.hostContext = f;
                    if (apkInfo.apkParseSuc != 1) {
                        z = false;
                    } else if (TextUtils.isEmpty(apkInfo.packageName) || TextUtils.isEmpty(apkInfo.pkgPath)) {
                        throw new RuntimeException("packageName or pkgPath miss");
                    } else {
                        apkInfo.dataDir = f.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                        String str = apkInfo.dataDir + "/dex";
                        String str2 = (apkInfo.dataDir + "/lib/" + this.c) + "/" + g.nextInt();
                        e(str);
                        com.baidu.sofire.b.e.a(str, false);
                        e(str2);
                        a(apkInfo, str2, str);
                        this.h.put(apkInfo.pkgPath, apkInfo);
                        this.a.put(apkInfo.packageName, apkInfo);
                        a(apkInfo, apkInfo.className);
                        z = false;
                    }
                    if (apkInfo.apkParseSuc != 1 || z) {
                        PackageInfo packageInfo2 = apkInfo.cloudPkgInfo;
                        if (packageInfo2 == null || TextUtils.isEmpty(packageInfo2.packageName) || TextUtils.isEmpty(packageInfo2.versionName)) {
                            PackageInfo packageArchiveInfo = f.getPackageManager().getPackageArchiveInfo(apkInfo.pkgPath, 1);
                            if ((packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) && ((packageArchiveInfo = a(apkInfo.packageName, apkInfo.apkMD5)) == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName))) {
                                throw new Exception("requestCloudPackageInfo failed");
                            }
                            packageInfo = packageArchiveInfo;
                        } else {
                            packageInfo = packageInfo2;
                        }
                        if (TextUtils.isEmpty(packageInfo.packageName) || !packageInfo.packageName.startsWith("com.baidu.sofire")) {
                            throw new Exception("package name check failed");
                        }
                        if (apkInfo.apkParseSuc != 1 && apkInfo.initStatus != 1) {
                            String str3 = apkInfo.apkMD5;
                            String str4 = apkInfo.pkgPath;
                            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                                pair = new Pair(false, "");
                            } else {
                                File file = new File(str4);
                                if (!com.baidu.sofire.b.e.a(file)) {
                                    pair = new Pair(false, "");
                                } else {
                                    String a = n.a(file);
                                    if (TextUtils.isEmpty(a)) {
                                        pair = new Pair(false, "");
                                    } else if (!a.equalsIgnoreCase(str3)) {
                                        pair = new Pair(false, a);
                                    } else {
                                        pair = new Pair(true, "");
                                    }
                                }
                            }
                            new StringBuilder().append(pair.first);
                            if (!((Boolean) pair.first).booleanValue()) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("0", 3);
                                hashMap2.put("1", Integer.valueOf(apkInfo.key));
                                hashMap2.put("2", packageInfo.versionName);
                                hashMap2.put("3", Base64.encodeToString(((String) pair.second).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                com.baidu.sofire.b.e.a(f.getApplicationContext(), "1003117", hashMap2);
                                z2 = false;
                            }
                        }
                        apkInfo.packageName = packageInfo.packageName;
                        new StringBuilder("p=").append(packageInfo.packageName).append(", v=").append(packageInfo.versionName);
                        apkInfo.className = packageInfo.applicationInfo.className;
                        apkInfo.versionName = packageInfo.versionName;
                        apkInfo.activities = packageInfo.activities;
                        apkInfo.applicationTheme = packageInfo.applicationInfo.theme;
                        apkInfo.dataDir = f.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                        String str5 = apkInfo.dataDir + "/dex";
                        String str6 = (apkInfo.dataDir + "/lib/" + this.c) + "/" + g.nextInt();
                        e(str5);
                        com.baidu.sofire.b.e.a(str5, false);
                        e(str6);
                        a(apkInfo, str6, str5);
                        this.h.put(apkInfo.pkgPath, apkInfo);
                        this.a.put(apkInfo.packageName, apkInfo);
                        a(apkInfo, packageInfo.applicationInfo.className);
                    }
                    z2 = true;
                }
            }
        }
        z2 = false;
        return z2;
    }

    private static PackageInfo a(String str, String str2) {
        int i = 0;
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PushConstants.URI_PACKAGE_NAME, str);
            jSONObject.put(Config.MODEL, str2);
            jSONArray.put(jSONObject);
            String a = h.a(f, com.baidu.sofire.b.e.a() + "p/1/pdl", jSONArray.toString(), false, false);
            new StringBuilder().append(a);
            JSONArray jSONArray2 = new JSONArray(a);
            if (jSONArray2.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = jSONArray2.optJSONObject(0);
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
            JSONArray optJSONArray = optJSONObject.optJSONArray(Config.APP_VERSION_CODE);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
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
                    i = i2 + 1;
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
            return packageInfo;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return null;
        }
    }

    private static boolean a(ApkInfo apkInfo, String str) {
        try {
            new StringBuilder().append(str);
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
            return false;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void a(ApkInfo apkInfo, String str, String str2) throws Throwable {
        HashSet hashSet = new HashSet();
        a(apkInfo, str, hashSet, new StringBuilder(), true, false);
        String str3 = ":" + System.getProperty("java.library.path");
        if (Build.VERSION.SDK_INT >= 25) {
            str3 = "";
        }
        String str4 = "";
        if (hashSet.contains(Build.CPU_ABI)) {
            String str5 = str + "/" + Build.CPU_ABI;
            String str6 = null;
            try {
                if (Build.VERSION.SDK_INT >= 8 && hashSet.contains(Build.CPU_ABI2)) {
                    str6 = str + "/" + Build.CPU_ABI2;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
            str4 = str6 != null ? str5 + ":" + str6 + str3 : str5 + str3;
        } else {
            try {
                if (Build.VERSION.SDK_INT >= 8 && hashSet.contains(Build.CPU_ABI2)) {
                    str4 = str + "/" + Build.CPU_ABI2 + str3;
                }
            } catch (Throwable th2) {
                com.baidu.sofire.b.e.a(th2);
            }
        }
        String str7 = (TextUtils.isEmpty(str4) && ((com.baidu.fsg.face.base.d.h.b.equals(Build.CPU_ABI) && hashSet.contains(com.baidu.fsg.face.base.d.h.a)) || (Build.VERSION.SDK_INT >= 8 && com.baidu.fsg.face.base.d.h.b.equals(Build.CPU_ABI2) && hashSet.contains(com.baidu.fsg.face.base.d.h.a)))) ? str + "/armeabi" + str3 : str4;
        apkInfo.libPath = str7;
        PathClassLoader pathClassLoader = new PathClassLoader(apkInfo.hostContext.getPackageResourcePath(), getClass().getClassLoader());
        new StringBuilder().append(str7);
        try {
            String absolutePath = new File(str2, "apkDex").getAbsolutePath();
            com.baidu.sofire.b.e.b(absolutePath);
            e(absolutePath);
            apkInfo.classLoader = new d(apkInfo.pkgPath, absolutePath, str7, pathClassLoader);
            Class<?> loadClass = apkInfo.classLoader.loadClass("com.baidu.sofire.engine.EngineImpl");
            new StringBuilder().append(loadClass);
            if (loadClass == null || TextUtils.isEmpty(loadClass.getName())) {
                throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
        } finally {
        }
    }

    public final boolean a(String str) {
        ApkInfo apkInfo = this.h.get(str);
        if (apkInfo != null) {
            this.h.remove(str);
            this.a.remove(apkInfo.packageName);
            com.baidu.sofire.b.e.b(apkInfo.dataDir);
            if (f != null) {
                com.baidu.sofire.b.e.b(f.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            return true;
        }
        return false;
    }

    public final boolean b(String str) {
        ApkInfo apkInfo = this.a.get(str);
        if (apkInfo != null) {
            this.h.remove(apkInfo.pkgPath);
            this.a.remove(str);
            com.baidu.sofire.b.e.b(apkInfo.dataDir);
            if (f != null) {
                com.baidu.sofire.b.e.b(f.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            new StringBuilder().append(this.h.size());
            new StringBuilder().append(this.a.size());
            return true;
        }
        return false;
    }

    public final ApkInfo c(String str) {
        try {
            return this.h.get(str);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return null;
        }
    }

    public final ApkInfo d(String str) {
        try {
            return this.a.get(str);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return null;
        }
    }

    private static void a(Application application, Context context) {
        Class<?> cls = context.getClass();
        for (Class cls2 = Application.class; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField("mBase");
                declaredField.setAccessible(true);
                if (declaredField.getType().isAssignableFrom(cls)) {
                    declaredField.set(application, context);
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }

    private static boolean e(String str) {
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
            Log.e("Utilities", "ensureDirectory - " + th);
            return false;
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1004=4, 1010=4, 1011=4, 1013=4, 1014=4, 1016=4, 1017=4] */
    private static void a(com.baidu.sofire.core.ApkInfo r15, java.lang.String r16, java.util.HashSet<java.lang.String> r17, java.lang.StringBuilder r18, boolean r19, boolean r20) throws java.lang.Throwable {
        /*
            r6 = 0
            r2 = 0
            r4 = 0
            java.lang.String r3 = ""
            java.lang.String r1 = r15.versionName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1a
            java.lang.String r1 = r15.versionName
            java.lang.String r3 = "."
            java.lang.String r5 = ""
            java.lang.String r3 = r1.replace(r3, r5)
        L1a:
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r1]
            java.util.zip.ZipFile r8 = new java.util.zip.ZipFile     // Catch: java.io.FileNotFoundException -> L13b java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r1 = r15.pkgPath     // Catch: java.io.FileNotFoundException -> L13b java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r8.<init>(r1)     // Catch: java.io.FileNotFoundException -> L13b java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
        L25:
            java.util.Enumeration r9 = r8.entries()     // Catch: java.lang.Throwable -> L318 java.io.EOFException -> L337 java.util.zip.ZipException -> L35b
        L29:
            boolean r1 = r9.hasMoreElements()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r1 == 0) goto L309
            java.lang.Object r1 = r9.nextElement()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r10 = r1.getName()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r6 = "lib/"
            boolean r6 = r10.startsWith(r6)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r6 == 0) goto L380
            boolean r6 = r1.isDirectory()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r6 != 0) goto L380
            if (r19 == 0) goto L380
            java.lang.String r11 = android.os.Build.CPU_ABI     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r6 = 0
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L24f
            r12 = 8
            if (r7 < r12) goto L55
            java.lang.String r6 = android.os.Build.CPU_ABI2     // Catch: java.lang.Throwable -> L24f
        L55:
            boolean r7 = r10.contains(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r7 != 0) goto L88
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r7 != 0) goto L67
            boolean r7 = r10.contains(r6)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r7 != 0) goto L88
        L67:
            java.lang.String r7 = "armeabi"
            boolean r7 = r10.contains(r7)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r7 == 0) goto L29
            java.lang.String r7 = "armeabi-v7a"
            boolean r7 = r7.equalsIgnoreCase(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r7 != 0) goto L88
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r7 != 0) goto L29
            java.lang.String r7 = "armeabi-v7a"
            boolean r6 = r7.equalsIgnoreCase(r6)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            if (r6 == 0) goto L29
        L88:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r6.<init>()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r0 = r16
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r7 = 3
            java.lang.String r7 = r10.substring(r7)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r11 = ".so"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r12.<init>()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.StringBuilder r12 = r12.append(r3)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r13 = ".so"
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r12 = r12.toString()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r7 = r7.replace(r11, r12)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r7 = r6.toString()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r11 = "l="
            r6.<init>(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r0 = r16
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r11 = ", n="
            java.lang.StringBuilder r6 = r6.append(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.StringBuilder r6 = r6.append(r10)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r11 = ", f="
            java.lang.StringBuilder r6 = r6.append(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r6.append(r7)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r6 = 0
            r11 = 47
            int r11 = r7.lastIndexOf(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.lang.String r6 = r7.substring(r6, r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r11 = 47
            int r11 = r6.lastIndexOf(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            int r11 = r11 + 1
            java.lang.String r11 = r6.substring(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r0 = r17
            r0.add(r11)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            e(r6)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.io.File r6 = new java.io.File     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r6.<init>(r7)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            r6.delete()     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.io.InputStream r6 = r8.getInputStream(r1)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L32d java.io.EOFException -> L355 java.util.zip.ZipException -> L36d
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L32d java.io.EOFException -> L355 java.util.zip.ZipException -> L36d
        L10e:
            int r4 = r6.read(r5)     // Catch: java.util.zip.ZipException -> L119 java.lang.Throwable -> L31b java.io.EOFException -> L33d
            if (r4 <= 0) goto L25b
            r11 = 0
            r2.write(r5, r11, r4)     // Catch: java.util.zip.ZipException -> L119 java.lang.Throwable -> L31b java.io.EOFException -> L33d
            goto L10e
        L119:
            r1 = move-exception
            r9 = r2
            r10 = r6
            r11 = r8
        L11d:
            r1 = r15
            r2 = r16
            r4 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L331
            if (r11 == 0) goto L130
            r11.close()
        L130:
            if (r10 == 0) goto L135
            r10.close()
        L135:
            if (r9 == 0) goto L13a
            r9.close()
        L13a:
            return
        L13b:
            r1 = move-exception
            java.lang.String r7 = r1.getMessage()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.io.File r1 = new java.io.File     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            android.content.Context r8 = r15.hostContext     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.io.File r8 = r8.getFilesDir()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r9 = ".b"
            r1.<init>(r8, r9)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            boolean r8 = r1.exists()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            if (r8 != 0) goto L173
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r1.<init>()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r7 = "--backupDir not exists"
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.io.FileNotFoundException r7 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r7.<init>(r1)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            throw r7     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
        L16e:
            r1 = move-exception
            r9 = r4
            r10 = r2
            r11 = r6
            goto L11d
        L173:
            java.io.File r8 = new java.io.File     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r9.<init>()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            int r10 = r15.key     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r10 = "-"
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r10 = r15.versionName     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r9 = r9.toString()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r8.<init>(r1, r9)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            boolean r1 = r8.exists()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            if (r1 != 0) goto L1d7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r1.<init>()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r7 = "--backupFile not exists"
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.io.FileNotFoundException r7 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r7.<init>(r1)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            throw r7     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
        L1b4:
            r1 = move-exception
            r9 = r4
            r10 = r2
            r11 = r6
        L1b8:
            r1 = r15
            r2 = r16
            r4 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L331
            if (r11 == 0) goto L1cb
            r11.close()
        L1cb:
            if (r10 == 0) goto L1d0
            r10.close()
        L1d0:
            if (r9 == 0) goto L13a
            r9.close()
            goto L13a
        L1d7:
            java.io.File r1 = new java.io.File     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r9 = r15.pkgPath     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r1.<init>(r9)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            com.baidu.sofire.b.e.a(r8, r1)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r9 = r15.pkgPath     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r10 = 1
            com.baidu.sofire.b.e.a(r9, r10)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            com.baidu.sofire.c.a(r1)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            android.content.Context r9 = r15.hostContext     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            int r10 = r15.key     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            com.baidu.sofire.c.a(r9, r10, r1, r8)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            boolean r1 = r1.exists()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            if (r1 == 0) goto L235
            java.util.zip.ZipFile r8 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L200
            java.lang.String r1 = r15.pkgPath     // Catch: java.lang.Throwable -> L200
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L200
            goto L25
        L200:
            r1 = move-exception
            java.io.FileNotFoundException r8 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r9.<init>()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r7 = r9.append(r7)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r9 = "--"
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r1 = r1.getMessage()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r1 = r7.append(r1)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r8.<init>(r1)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            throw r8     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
        L223:
            r1 = move-exception
            r8 = r6
        L225:
            if (r8 == 0) goto L22a
            r8.close()
        L22a:
            if (r2 == 0) goto L22f
            r2.close()
        L22f:
            if (r4 == 0) goto L234
            r4.close()
        L234:
            throw r1
        L235:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r8.<init>()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r8 = "--file not exists after copy"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            java.lang.String r7 = r7.toString()     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            r1.<init>(r7)     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
            throw r1     // Catch: java.util.zip.ZipException -> L16e java.io.EOFException -> L1b4 java.lang.Throwable -> L223
        L24f:
            r7 = move-exception
            com.baidu.sofire.b.e.a(r7)     // Catch: java.util.zip.ZipException -> L255 java.lang.Throwable -> L318 java.io.EOFException -> L34f
            goto L55
        L255:
            r1 = move-exception
            r9 = r4
            r10 = r2
            r11 = r8
            goto L11d
        L25b:
            r2.close()     // Catch: java.util.zip.ZipException -> L119 java.lang.Throwable -> L31b java.io.EOFException -> L33d
            if (r6 == 0) goto L263
            r6.close()     // Catch: java.util.zip.ZipException -> L119 java.lang.Throwable -> L31b java.io.EOFException -> L33d
        L263:
            r4 = 1
            com.baidu.sofire.b.e.a(r7, r4)     // Catch: java.util.zip.ZipException -> L119 java.lang.Throwable -> L31b java.io.EOFException -> L33d
            r4 = r6
        L268:
            r7 = 0
            java.lang.String r6 = ".dex"
            boolean r6 = r10.endsWith(r6)     // Catch: java.lang.Throwable -> L373
            if (r6 == 0) goto L304
            boolean r6 = r1.isDirectory()     // Catch: java.lang.Throwable -> L373
            if (r6 != 0) goto L304
            if (r20 == 0) goto L304
            java.lang.String r10 = r15.dataDir     // Catch: java.lang.Throwable -> L373
            e(r10)     // Catch: java.lang.Throwable -> L373
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L373
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L373
            r11.<init>()     // Catch: java.lang.Throwable -> L373
            int r12 = r15.key     // Catch: java.lang.Throwable -> L373
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L373
            java.lang.String r12 = "-"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L373
            java.lang.String r12 = r15.versionName     // Catch: java.lang.Throwable -> L373
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L373
            java.lang.String r12 = ".dex"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L373
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L373
            r6.<init>(r10, r11)     // Catch: java.lang.Throwable -> L373
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L379
            java.lang.String r10 = "e: "
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L379
            java.lang.String r10 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L379
            r7.append(r10)     // Catch: java.lang.Throwable -> L379
            java.io.InputStream r4 = r8.getInputStream(r1)     // Catch: java.lang.Throwable -> L379
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L379
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L379
        L2bf:
            int r2 = r4.read(r5)     // Catch: java.lang.Throwable -> L2ca
            if (r2 <= 0) goto L2ea
            r7 = 0
            r1.write(r5, r7, r2)     // Catch: java.lang.Throwable -> L2ca
            goto L2bf
        L2ca:
            r2 = move-exception
            r14 = r2
            r2 = r6
            r6 = r4
            r4 = r1
            r1 = r14
        L2d0:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32d java.io.EOFException -> L355 java.util.zip.ZipException -> L36d
            r7.<init>()     // Catch: java.lang.Throwable -> L32d java.io.EOFException -> L355 java.util.zip.ZipException -> L36d
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L32d java.io.EOFException -> L355 java.util.zip.ZipException -> L36d
            r7.append(r1)     // Catch: java.lang.Throwable -> L32d java.io.EOFException -> L355 java.util.zip.ZipException -> L36d
            if (r2 == 0) goto L2e7
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L32d java.io.EOFException -> L355 java.util.zip.ZipException -> L36d
            if (r1 == 0) goto L2e7
            r2.delete()     // Catch: java.lang.Throwable -> L32d java.io.EOFException -> L355 java.util.zip.ZipException -> L36d
        L2e7:
            r2 = r6
            goto L29
        L2ea:
            r1.close()     // Catch: java.lang.Throwable -> L2ca
            if (r4 == 0) goto L2f2
            r4.close()     // Catch: java.lang.Throwable -> L2ca
        L2f2:
            java.lang.String r2 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L2ca
            r0 = r18
            r0.append(r2)     // Catch: java.lang.Throwable -> L2ca
            java.lang.String r2 = r18.toString()     // Catch: java.lang.Throwable -> L2ca
            r7 = 1
            com.baidu.sofire.b.e.a(r2, r7)     // Catch: java.lang.Throwable -> L2ca
            r2 = r1
        L304:
            r14 = r2
            r2 = r4
            r4 = r14
            goto L29
        L309:
            r8.close()
            if (r2 == 0) goto L311
            r2.close()
        L311:
            if (r4 == 0) goto L13a
            r4.close()
            goto L13a
        L318:
            r1 = move-exception
            goto L225
        L31b:
            r1 = move-exception
            r4 = r2
            r2 = r6
            goto L225
        L320:
            r1 = move-exception
            r14 = r2
            r2 = r4
            r4 = r14
            goto L225
        L326:
            r2 = move-exception
            r14 = r2
            r2 = r4
            r4 = r1
            r1 = r14
            goto L225
        L32d:
            r1 = move-exception
            r2 = r6
            goto L225
        L331:
            r1 = move-exception
            r4 = r9
            r2 = r10
            r8 = r11
            goto L225
        L337:
            r1 = move-exception
            r9 = r4
            r10 = r2
            r11 = r8
            goto L1b8
        L33d:
            r1 = move-exception
            r9 = r2
            r10 = r6
            r11 = r8
            goto L1b8
        L343:
            r1 = move-exception
            r9 = r2
            r10 = r4
            r11 = r8
            goto L1b8
        L349:
            r2 = move-exception
            r9 = r1
            r10 = r4
            r11 = r8
            goto L1b8
        L34f:
            r1 = move-exception
            r9 = r4
            r10 = r2
            r11 = r8
            goto L1b8
        L355:
            r1 = move-exception
            r9 = r4
            r10 = r6
            r11 = r8
            goto L1b8
        L35b:
            r1 = move-exception
            r9 = r4
            r10 = r2
            r11 = r8
            goto L11d
        L361:
            r1 = move-exception
            r9 = r2
            r10 = r4
            r11 = r8
            goto L11d
        L367:
            r2 = move-exception
            r9 = r1
            r10 = r4
            r11 = r8
            goto L11d
        L36d:
            r1 = move-exception
            r9 = r4
            r10 = r6
            r11 = r8
            goto L11d
        L373:
            r1 = move-exception
            r6 = r4
            r4 = r2
            r2 = r7
            goto L2d0
        L379:
            r1 = move-exception
            r14 = r6
            r6 = r4
            r4 = r2
            r2 = r14
            goto L2d0
        L380:
            r14 = r4
            r4 = r2
            r2 = r14
            goto L268
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.e.a(com.baidu.sofire.core.ApkInfo, java.lang.String, java.util.HashSet, java.lang.StringBuilder, boolean, boolean):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:5|(1:97)(7:10|11|12|(1:14)|15|(3:22|(3:23|24|(1:26)(1:27))|28)|62)|29|30|31|(8:36|37|38|(3:40|41|(1:43)(1:44))|45|(1:47)|48|49)|73|60|61|62) */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01c8, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01c9, code lost:
        r2 = r0;
        r0 = r1;
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(ApkInfo apkInfo, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z, boolean z2) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        File file;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
        FileOutputStream fileOutputStream3 = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && !nextEntry.isDirectory() && z) {
                    new StringBuilder().append(name);
                    String str3 = Build.CPU_ABI;
                    String str4 = null;
                    if (Build.VERSION.SDK_INT >= 8) {
                        str4 = Build.CPU_ABI2;
                    }
                    if (name.contains(str3) || ((!TextUtils.isEmpty(str4) && name.contains(str4)) || (name.contains(com.baidu.fsg.face.base.d.h.a) && (com.baidu.fsg.face.base.d.h.b.equalsIgnoreCase(str3) || (!TextUtils.isEmpty(str4) && com.baidu.fsg.face.base.d.h.b.equalsIgnoreCase(str4)))))) {
                        String str5 = str + name.substring(3).replace(PluginInstallerService.APK_LIB_SUFFIX, str2 + PluginInstallerService.APK_LIB_SUFFIX);
                        new StringBuilder("l=").append(str).append(", n=").append(name).append(", f=").append(str5);
                        String substring = str5.substring(0, str5.lastIndexOf(47));
                        hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                        e(substring);
                        File file2 = new File(str5);
                        file2.delete();
                        file2.createNewFile();
                        fileOutputStream = new FileOutputStream(str5);
                        while (true) {
                            try {
                                int read = zipInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            } catch (Throwable th2) {
                                fileOutputStream3 = fileOutputStream;
                                th = th2;
                                zipInputStream.close();
                                if (fileOutputStream3 != null) {
                                }
                                throw th;
                            }
                        }
                        fileOutputStream.close();
                        com.baidu.sofire.b.e.a(str5, true);
                    }
                } else {
                    fileOutputStream = fileOutputStream3;
                }
                if (name.endsWith(".dex") && !nextEntry.isDirectory() && z2) {
                    String str6 = apkInfo.dataDir;
                    e(str6);
                    File file3 = new File(str6, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".dex");
                    try {
                        new StringBuilder().append(file3.getAbsolutePath());
                        file3.delete();
                        file3.createNewFile();
                        FileOutputStream fileOutputStream4 = new FileOutputStream(file3);
                        while (true) {
                            try {
                                int read2 = zipInputStream.read(bArr);
                                if (read2 <= 0) {
                                    break;
                                }
                                fileOutputStream4.write(bArr, 0, read2);
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream2 = fileOutputStream4;
                                file = file3;
                                try {
                                    new StringBuilder().append(th.getMessage());
                                    if (file != null && file.exists()) {
                                        file.delete();
                                    }
                                    fileOutputStream3 = fileOutputStream2;
                                    zipInputStream.closeEntry();
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileOutputStream3 = fileOutputStream2;
                                    zipInputStream.close();
                                    if (fileOutputStream3 != null) {
                                        fileOutputStream3.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                        fileOutputStream4.close();
                        if (sb.length() > 0) {
                            sb.setLength(0);
                        }
                        sb.append(file3.getAbsolutePath());
                        com.baidu.sofire.b.e.a(sb.toString(), true);
                        fileOutputStream = fileOutputStream4;
                    } catch (Throwable th5) {
                        file = file3;
                        fileOutputStream2 = fileOutputStream;
                        th = th5;
                    }
                }
                fileOutputStream3 = fileOutputStream;
                zipInputStream.closeEntry();
            } catch (Throwable th6) {
                th = th6;
            }
        }
        zipInputStream.close();
        if (fileOutputStream3 != null) {
            fileOutputStream3.close();
        }
    }
}
