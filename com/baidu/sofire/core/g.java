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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.b.o;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class g {
    private String b;
    private boolean c;
    private Map<String, ApkInfo> g = new ConcurrentHashMap();
    private Map<String, ApkInfo> h = new ConcurrentHashMap();
    private Map<String, MyReceiver> i = new HashMap();
    private static g d = null;
    private static Application e = null;
    private static Random f = new Random();
    public static List<Integer> a = new ArrayList();

    public static g a(Context context, boolean z) {
        if (d == null) {
            e = (Application) context.getApplicationContext();
            d = new g();
        }
        return d;
    }

    public static g a() {
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r0.intentFilters.add(r7);
        r1 = a(r7.d);
        com.baidu.sofire.b.a("filter key:" + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        if (r1.equals("____") != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (r6.i.keySet().contains(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        if ("android.intent.action.PACKAGE_REMOVED__package".equals(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
        r3 = new com.baidu.sofire.MyReceiver();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        com.baidu.sofire.core.g.e.registerReceiver(r3, r7.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(h hVar) {
        ApkInfo apkInfo;
        String a2;
        MyReceiver myReceiver;
        boolean z;
        if (hVar.d != null && (apkInfo = this.h.get(hVar.a)) != null) {
            if (apkInfo.intentFilters == null) {
                apkInfo.intentFilters = new ArrayList();
            }
            int i = 0;
            while (true) {
                if (i >= apkInfo.intentFilters.size()) {
                    break;
                } else if (hVar.a(apkInfo.intentFilters.get(i))) {
                    break;
                } else {
                    i++;
                }
            }
        }
        e.registerReceiver(myReceiver, hVar.d);
        this.i.put(a2, myReceiver);
        if (z) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e2) {
                com.baidu.sofire.b.e.a(e2);
            }
            e.registerReceiver(myReceiver, hVar.d);
        }
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
                    sb.append(BaseRequestAction.SPLITE);
                }
            } else {
                sb.append(BaseRequestAction.SPLITE);
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
                    sb.append(BaseRequestAction.SPLITE);
                }
            } else {
                sb.append(BaseRequestAction.SPLITE);
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
                    sb.append(BaseRequestAction.SPLITE);
                }
            } else {
                sb.append(BaseRequestAction.SPLITE);
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
                    sb.append(BaseRequestAction.SPLITE);
                }
            } else {
                sb.append(BaseRequestAction.SPLITE);
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public synchronized void b(h hVar) {
        if (hVar != null) {
            try {
                if (hVar.d != null) {
                    ApkInfo apkInfo = this.h.get(hVar.a);
                    if (apkInfo != null && apkInfo.intentFilters != null) {
                        ArrayList<Integer> arrayList = new ArrayList();
                        for (int i = 0; i < apkInfo.intentFilters.size(); i++) {
                            if (hVar.a(apkInfo.intentFilters.get(i))) {
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
                    String a2 = a(hVar.d);
                    com.baidu.sofire.b.a("removeOneRegisterReceiver:" + a2);
                    if (!TextUtils.isEmpty(a2) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a2)) {
                        Iterator<ApkInfo> it = b().iterator();
                        loop2: while (true) {
                            if (it.hasNext()) {
                                ApkInfo next = it.next();
                                if (next.intentFilters != null && next.intentFilters.size() > 0) {
                                    for (h hVar2 : next.intentFilters) {
                                        String a3 = a(hVar2.d);
                                        if (!TextUtils.isEmpty(a3) && a3.equals(a2)) {
                                            com.baidu.sofire.b.a("removeOneRegisterReceiver also have:" + a2);
                                            break loop2;
                                        }
                                    }
                                    continue;
                                }
                            } else {
                                com.baidu.sofire.b.a("removeOneRegisterReceiver remove:" + a2);
                                e.unregisterReceiver(this.i.get(a2));
                                this.i.remove(a2);
                                break;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }

    public List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.h.keySet()) {
                arrayList.add(this.h.get(str));
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

    public boolean a(ApkInfo apkInfo, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.c = z2;
        this.b = apkInfo.versionName;
        boolean a2 = a(apkInfo);
        com.baidu.sofire.b.a("LoadApk cost time:" + (System.currentTimeMillis() - currentTimeMillis));
        return a2;
    }

    private synchronized boolean a(ApkInfo apkInfo) {
        boolean z;
        PackageInfo packageInfo;
        boolean z2;
        if (apkInfo != null) {
            if (!TextUtils.isEmpty(apkInfo.pkgPath)) {
                ApkInfo apkInfo2 = this.g.get(apkInfo.pkgPath);
                if (apkInfo2 != null) {
                    if (apkInfo2.versionName.equals(apkInfo.versionName)) {
                        com.baidu.sofire.b.a("tmpInfo.versionName.equals(apkInfo.versionName) already loaded!");
                        z2 = true;
                    } else {
                        a(apkInfo.pkgPath);
                    }
                }
                if (!com.baidu.sofire.b.e.a(new File(apkInfo.pkgPath))) {
                    com.baidu.sofire.b.a("!f.isFile() || !f.canRead() || !f.exists()");
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", Integer.valueOf(apkInfo.key));
                    hashMap.put("2", apkInfo.versionName);
                    com.baidu.sofire.b.e.a(e.getApplicationContext(), "1003117", hashMap);
                    z2 = false;
                } else {
                    apkInfo.hostContext = e;
                    if (apkInfo.apkParseSuc == 1) {
                        com.baidu.sofire.b.a("=1");
                        if (TextUtils.isEmpty(apkInfo.packageName) || TextUtils.isEmpty(apkInfo.pkgPath)) {
                            throw new RuntimeException("packageName or pkgPath miss");
                        }
                        apkInfo.dataDir = e.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                        String str = apkInfo.dataDir + "/dex";
                        String str2 = (apkInfo.dataDir + "/lib/" + this.b) + "/" + f.nextInt();
                        f(str);
                        com.baidu.sofire.b.e.a(str, false);
                        f(str2);
                        a(apkInfo, str2, str, false);
                        this.g.put(apkInfo.pkgPath, apkInfo);
                        this.h.put(apkInfo.packageName, apkInfo);
                        a(apkInfo, apkInfo.className);
                        z = false;
                    } else {
                        z = false;
                    }
                    if (apkInfo.apkParseSuc != 1 || z) {
                        com.baidu.sofire.b.a("!=1" + z);
                        PackageInfo packageInfo2 = apkInfo.cloudPkgInfo;
                        if (packageInfo2 != null && !TextUtils.isEmpty(packageInfo2.packageName) && !TextUtils.isEmpty(packageInfo2.versionName)) {
                            com.baidu.sofire.b.a("init by use cloud info");
                            packageInfo = packageInfo2;
                        } else {
                            PackageInfo packageArchiveInfo = e.getPackageManager().getPackageArchiveInfo(apkInfo.pkgPath, 1);
                            if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                                com.baidu.sofire.b.a("init by request cloud");
                                packageArchiveInfo = a(apkInfo.packageName, apkInfo.apkMD5);
                                if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                                    throw new Exception("requestCloudPackageInfo failed");
                                }
                            }
                            packageInfo = packageArchiveInfo;
                        }
                        if (TextUtils.isEmpty(packageInfo.packageName) || !packageInfo.packageName.startsWith("com.baidu.sofire")) {
                            throw new Exception("package name check failed");
                        }
                        if (apkInfo.apkParseSuc != 1 && apkInfo.initStatus != 1) {
                            Pair<Boolean, String> b = b(apkInfo.apkMD5, apkInfo.pkgPath);
                            com.baidu.sofire.b.a("verify md5:result=" + b.first);
                            if (!((Boolean) b.first).booleanValue()) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("0", 3);
                                hashMap2.put("1", Integer.valueOf(apkInfo.key));
                                hashMap2.put("2", packageInfo.versionName);
                                hashMap2.put("3", Base64.encodeToString(((String) b.second).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                com.baidu.sofire.b.e.a(e.getApplicationContext(), "1003117", hashMap2);
                                z2 = false;
                            }
                        }
                        apkInfo.packageName = packageInfo.packageName;
                        com.baidu.sofire.b.a("p=" + packageInfo.packageName + ", v=" + packageInfo.versionName);
                        apkInfo.className = packageInfo.applicationInfo.className;
                        apkInfo.versionName = packageInfo.versionName;
                        apkInfo.activities = packageInfo.activities;
                        apkInfo.applicationTheme = packageInfo.applicationInfo.theme;
                        apkInfo.dataDir = e.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                        String str3 = apkInfo.dataDir + "/dex";
                        String str4 = (apkInfo.dataDir + "/lib/" + this.b) + "/" + f.nextInt();
                        f(str3);
                        com.baidu.sofire.b.e.a(str3, false);
                        f(str4);
                        a(apkInfo, str4, str3, true);
                        this.g.put(apkInfo.pkgPath, apkInfo);
                        this.h.put(apkInfo.packageName, apkInfo);
                        a(apkInfo, packageInfo.applicationInfo.className);
                    }
                    z2 = true;
                }
            }
        }
        z2 = false;
        return z2;
    }

    private PackageInfo a(String str, String str2) {
        int i = 0;
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PushConstants.URI_PACKAGE_NAME, str);
            jSONObject.put(Config.MODEL, str2);
            jSONArray.put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            com.baidu.sofire.b.a(jSONArray2);
            String a2 = com.baidu.sofire.b.h.a(e, com.baidu.sofire.b.e.e(e) + "p/1/pdl", jSONArray2, false, true);
            com.baidu.sofire.b.a("check local:after java decrypt ResponseDataJsonString=" + a2);
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

    private Pair<Boolean, String> b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(false, "");
        }
        File file = new File(str2);
        if (!com.baidu.sofire.b.e.a(file)) {
            return new Pair<>(false, "");
        }
        String a2 = o.a(file);
        if (TextUtils.isEmpty(a2)) {
            return new Pair<>(false, "");
        }
        if (!a2.equalsIgnoreCase(str)) {
            return new Pair<>(false, a2);
        }
        return new Pair<>(true, "");
    }

    private boolean a(ApkInfo apkInfo, String str) {
        try {
            com.baidu.sofire.b.a("" + str);
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
            com.baidu.sofire.f.a(Application.class, e, application);
            a(application, e);
            application.onCreate();
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.a(th.getMessage(), th);
            return false;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void a(ApkInfo apkInfo, String str, String str2, boolean z) {
        HashSet<String> hashSet = new HashSet<>();
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
        com.baidu.sofire.b.a("app lib path" + str7);
        try {
            String absolutePath = new File(str2, "apkDex").getAbsolutePath();
            com.baidu.sofire.b.e.d(absolutePath);
            f(absolutePath);
            apkInfo.classLoader = new f(apkInfo.pkgPath, absolutePath, str7, pathClassLoader);
            Class<?> loadClass = apkInfo.classLoader.loadClass("com.baidu.sofire.engine.EngineImpl");
            com.baidu.sofire.b.a("success load EngineImpl " + loadClass);
            if (loadClass == null || TextUtils.isEmpty(loadClass.getName())) {
                throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
        } finally {
        }
    }

    public boolean a(String str) {
        ApkInfo apkInfo = this.g.get(str);
        if (apkInfo != null) {
            this.g.remove(str);
            this.h.remove(apkInfo.packageName);
            com.baidu.sofire.b.e.d(apkInfo.dataDir);
            if (e != null) {
                com.baidu.sofire.b.e.d(e.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            return true;
        }
        return false;
    }

    public boolean b(String str) {
        ApkInfo apkInfo = this.h.get(str);
        if (apkInfo != null) {
            this.g.remove(apkInfo.pkgPath);
            this.h.remove(str);
            com.baidu.sofire.b.e.d(apkInfo.dataDir);
            if (e != null) {
                com.baidu.sofire.b.e.d(e.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            com.baidu.sofire.b.a("after unload mApkInfoMapPath size:" + this.g.size());
            com.baidu.sofire.b.a("after unload mApkInfoMapPkgName size:" + this.h.size());
            return true;
        }
        return false;
    }

    public ApkInfo c(String str) {
        try {
            return this.g.get(str);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return null;
        }
    }

    public ApkInfo d(String str) {
        try {
            return this.h.get(str);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return null;
        }
    }

    public String e(String str) {
        ApkInfo apkInfo = this.h.get(str);
        if (apkInfo == null) {
            return null;
        }
        return apkInfo.pkgPath;
    }

    protected void a(Application application, Context context) {
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

    public static boolean f(String str) {
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1007=4, 1015=5, 1016=4, 1018=4, 1019=4, 1021=4, 1022=4] */
    private void a(com.baidu.sofire.core.ApkInfo r16, java.lang.String r17, java.util.HashSet<java.lang.String> r18, java.lang.StringBuilder r19, boolean r20, boolean r21) {
        /*
            r15 = this;
            r5 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = ""
            r0 = r16
            java.lang.String r1 = r0.versionName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1e
            r0 = r16
            java.lang.String r1 = r0.versionName
            java.lang.String r4 = "."
            java.lang.String r6 = ""
            java.lang.String r4 = r1.replace(r4, r6)
        L1e:
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r1]
            java.util.zip.ZipFile r8 = new java.util.zip.ZipFile     // Catch: java.io.FileNotFoundException -> L166 java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r0 = r16
            java.lang.String r1 = r0.pkgPath     // Catch: java.io.FileNotFoundException -> L166 java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r8.<init>(r1)     // Catch: java.io.FileNotFoundException -> L166 java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
        L2b:
            java.util.Enumeration r9 = r8.entries()     // Catch: java.lang.Throwable -> L378 java.io.EOFException -> L397 java.util.zip.ZipException -> L3bb
        L2f:
            boolean r1 = r9.hasMoreElements()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r1 == 0) goto L367
            java.lang.Object r1 = r9.nextElement()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r10 = r1.getName()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r5 = "lib/"
            boolean r5 = r10.startsWith(r5)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r5 == 0) goto L3da
            boolean r5 = r1.isDirectory()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r5 != 0) goto L3da
            if (r20 == 0) goto L3da
            java.lang.String r11 = android.os.Build.CPU_ABI     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r5 = 0
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L28c
            r12 = 8
            if (r7 < r12) goto L5b
            java.lang.String r5 = android.os.Build.CPU_ABI2     // Catch: java.lang.Throwable -> L28c
        L5b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r7.<init>()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r12 = "e: "
            java.lang.StringBuilder r7 = r7.append(r12)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r7 = r7.toString()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            com.baidu.sofire.b.a(r7)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            boolean r7 = r10.contains(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r7 != 0) goto La5
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r7 != 0) goto L84
            boolean r7 = r10.contains(r5)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r7 != 0) goto La5
        L84:
            java.lang.String r7 = "armeabi"
            boolean r7 = r10.contains(r7)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r7 == 0) goto L2f
            java.lang.String r7 = "armeabi-v7a"
            boolean r7 = r7.equalsIgnoreCase(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r7 != 0) goto La5
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r7 != 0) goto L2f
            java.lang.String r7 = "armeabi-v7a"
            boolean r5 = r7.equalsIgnoreCase(r5)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            if (r5 == 0) goto L2f
        La5:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r5.<init>()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r0 = r17
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r7 = 3
            java.lang.String r7 = r10.substring(r7)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r11 = ".so"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r12.<init>()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.StringBuilder r12 = r12.append(r4)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r13 = ".so"
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r12 = r12.toString()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r7 = r7.replace(r11, r12)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r7 = r5.toString()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r5.<init>()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r11 = "l="
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r0 = r17
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r11 = ", n="
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r11 = ", f="
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r5 = r5.toString()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            com.baidu.sofire.b.a(r5)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r5 = 0
            r11 = 47
            int r11 = r7.lastIndexOf(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.lang.String r5 = r7.substring(r5, r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r11 = 47
            int r11 = r5.lastIndexOf(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            int r11 = r11 + 1
            java.lang.String r11 = r5.substring(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r0 = r18
            r0.add(r11)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            f(r5)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.io.File r5 = new java.io.File     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r5.<init>(r7)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            r5.delete()     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.io.InputStream r5 = r8.getInputStream(r1)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L38d java.io.EOFException -> L3b5 java.util.zip.ZipException -> L3cd
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L38d java.io.EOFException -> L3b5 java.util.zip.ZipException -> L3cd
        L137:
            int r3 = r5.read(r6)     // Catch: java.util.zip.ZipException -> L142 java.lang.Throwable -> L37b java.io.EOFException -> L39d
            if (r3 <= 0) goto L298
            r11 = 0
            r2.write(r6, r11, r3)     // Catch: java.util.zip.ZipException -> L142 java.lang.Throwable -> L37b java.io.EOFException -> L39d
            goto L137
        L142:
            r1 = move-exception
            r10 = r2
            r11 = r5
            r12 = r8
        L146:
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L391
            if (r12 == 0) goto L15b
            r12.close()
        L15b:
            if (r11 == 0) goto L160
            r11.close()
        L160:
            if (r10 == 0) goto L165
            r10.close()
        L165:
            return
        L166:
            r1 = move-exception
            java.lang.String r7 = r1.getMessage()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.io.File r1 = new java.io.File     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r0 = r16
            android.content.Context r8 = r0.hostContext     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.io.File r8 = r8.getFilesDir()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r9 = ".b"
            r1.<init>(r8, r9)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            boolean r8 = r1.exists()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            if (r8 != 0) goto L1a0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r1.<init>()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r7 = "--backupDir not exists"
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.io.FileNotFoundException r7 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r7.<init>(r1)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            throw r7     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
        L19b:
            r1 = move-exception
            r10 = r3
            r11 = r2
            r12 = r5
            goto L146
        L1a0:
            java.io.File r8 = new java.io.File     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r9.<init>()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r0 = r16
            int r10 = r0.key     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r10 = "-"
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r0 = r16
            java.lang.String r10 = r0.versionName     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r9 = r9.toString()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r8.<init>(r1, r9)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            boolean r1 = r8.exists()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            if (r1 != 0) goto L20a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r1.<init>()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r7 = "--backupFile not exists"
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.io.FileNotFoundException r7 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r7.<init>(r1)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            throw r7     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
        L1e5:
            r1 = move-exception
            r10 = r3
            r11 = r2
            r12 = r5
        L1e9:
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L391
            if (r12 == 0) goto L1fe
            r12.close()
        L1fe:
            if (r11 == 0) goto L203
            r11.close()
        L203:
            if (r10 == 0) goto L165
            r10.close()
            goto L165
        L20a:
            java.io.File r1 = new java.io.File     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r0 = r16
            java.lang.String r9 = r0.pkgPath     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r1.<init>(r9)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            com.baidu.sofire.b.e.a(r8, r1)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r0 = r16
            java.lang.String r9 = r0.pkgPath     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r10 = 1
            com.baidu.sofire.b.e.a(r9, r10)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            com.baidu.sofire.c.a(r1)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r0 = r16
            android.content.Context r9 = r0.hostContext     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r0 = r16
            int r10 = r0.key     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            com.baidu.sofire.c.a(r9, r10, r1, r8)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            boolean r1 = r1.exists()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            if (r1 == 0) goto L272
            java.util.zip.ZipFile r8 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L23d
            r0 = r16
            java.lang.String r1 = r0.pkgPath     // Catch: java.lang.Throwable -> L23d
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L23d
            goto L2b
        L23d:
            r1 = move-exception
            java.io.FileNotFoundException r8 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r9.<init>()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r7 = r9.append(r7)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r9 = "--"
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r1 = r1.getMessage()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r1 = r7.append(r1)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r8.<init>(r1)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            throw r8     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
        L260:
            r1 = move-exception
            r8 = r5
        L262:
            if (r8 == 0) goto L267
            r8.close()
        L267:
            if (r2 == 0) goto L26c
            r2.close()
        L26c:
            if (r3 == 0) goto L271
            r3.close()
        L271:
            throw r1
        L272:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r8.<init>()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r8 = "--file not exists after copy"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            java.lang.String r7 = r7.toString()     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            r1.<init>(r7)     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
            throw r1     // Catch: java.util.zip.ZipException -> L19b java.io.EOFException -> L1e5 java.lang.Throwable -> L260
        L28c:
            r7 = move-exception
            com.baidu.sofire.b.e.a(r7)     // Catch: java.util.zip.ZipException -> L292 java.lang.Throwable -> L378 java.io.EOFException -> L3af
            goto L5b
        L292:
            r1 = move-exception
            r10 = r3
            r11 = r2
            r12 = r8
            goto L146
        L298:
            if (r2 == 0) goto L29d
            r2.close()     // Catch: java.util.zip.ZipException -> L142 java.lang.Throwable -> L37b java.io.EOFException -> L39d
        L29d:
            if (r5 == 0) goto L2a2
            r5.close()     // Catch: java.util.zip.ZipException -> L142 java.lang.Throwable -> L37b java.io.EOFException -> L39d
        L2a2:
            r3 = 1
            com.baidu.sofire.b.e.a(r7, r3)     // Catch: java.util.zip.ZipException -> L142 java.lang.Throwable -> L37b java.io.EOFException -> L39d
            r3 = r5
        L2a7:
            r7 = 0
            java.lang.String r5 = ".dex"
            boolean r5 = r10.endsWith(r5)     // Catch: java.lang.Throwable -> L3d3
            if (r5 == 0) goto L345
            boolean r5 = r1.isDirectory()     // Catch: java.lang.Throwable -> L3d3
            if (r5 != 0) goto L345
            if (r21 == 0) goto L345
            r0 = r16
            java.lang.String r10 = r0.dataDir     // Catch: java.lang.Throwable -> L3d3
            f(r10)     // Catch: java.lang.Throwable -> L3d3
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L3d3
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d3
            r11.<init>()     // Catch: java.lang.Throwable -> L3d3
            r0 = r16
            int r12 = r0.key     // Catch: java.lang.Throwable -> L3d3
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L3d3
            java.lang.String r12 = "-"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L3d3
            r0 = r16
            java.lang.String r12 = r0.versionName     // Catch: java.lang.Throwable -> L3d3
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L3d3
            java.lang.String r12 = ".dex"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L3d3
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L3d3
            r5.<init>(r10, r11)     // Catch: java.lang.Throwable -> L3d3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d7
            r7.<init>()     // Catch: java.lang.Throwable -> L3d7
            java.lang.String r10 = "e: "
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch: java.lang.Throwable -> L3d7
            java.lang.String r10 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L3d7
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch: java.lang.Throwable -> L3d7
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L3d7
            com.baidu.sofire.b.a(r7)     // Catch: java.lang.Throwable -> L3d7
            java.io.InputStream r3 = r8.getInputStream(r1)     // Catch: java.lang.Throwable -> L3d7
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3d7
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L3d7
        L310:
            int r2 = r3.read(r6)     // Catch: java.lang.Throwable -> L31b
            if (r2 <= 0) goto L34a
            r7 = 0
            r1.write(r6, r7, r2)     // Catch: java.lang.Throwable -> L31b
            goto L310
        L31b:
            r2 = move-exception
            r14 = r2
            r2 = r1
            r1 = r14
        L31f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
            r7.<init>()     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
            java.lang.String r10 = "unable extracting dex file for "
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
            java.lang.StringBuilder r1 = r7.append(r1)     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
            com.baidu.sofire.b.a(r1)     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
            if (r5 == 0) goto L345
            boolean r1 = r5.exists()     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
            if (r1 == 0) goto L345
            r5.delete()     // Catch: java.lang.Throwable -> L380 java.io.EOFException -> L3a3 java.util.zip.ZipException -> L3c1
        L345:
            r14 = r2
            r2 = r3
            r3 = r14
            goto L2f
        L34a:
            if (r1 == 0) goto L34f
            r1.close()     // Catch: java.lang.Throwable -> L31b
        L34f:
            if (r3 == 0) goto L354
            r3.close()     // Catch: java.lang.Throwable -> L31b
        L354:
            java.lang.String r2 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L31b
            r0 = r19
            r0.append(r2)     // Catch: java.lang.Throwable -> L31b
            java.lang.String r2 = r19.toString()     // Catch: java.lang.Throwable -> L31b
            r7 = 1
            com.baidu.sofire.b.e.a(r2, r7)     // Catch: java.lang.Throwable -> L31b
            r2 = r1
            goto L345
        L367:
            if (r8 == 0) goto L36c
            r8.close()
        L36c:
            if (r2 == 0) goto L371
            r2.close()
        L371:
            if (r3 == 0) goto L165
            r3.close()
            goto L165
        L378:
            r1 = move-exception
            goto L262
        L37b:
            r1 = move-exception
            r3 = r2
            r2 = r5
            goto L262
        L380:
            r1 = move-exception
            r14 = r2
            r2 = r3
            r3 = r14
            goto L262
        L386:
            r2 = move-exception
            r14 = r2
            r2 = r3
            r3 = r1
            r1 = r14
            goto L262
        L38d:
            r1 = move-exception
            r2 = r5
            goto L262
        L391:
            r1 = move-exception
            r3 = r10
            r2 = r11
            r8 = r12
            goto L262
        L397:
            r1 = move-exception
            r10 = r3
            r11 = r2
            r12 = r8
            goto L1e9
        L39d:
            r1 = move-exception
            r10 = r2
            r11 = r5
            r12 = r8
            goto L1e9
        L3a3:
            r1 = move-exception
            r10 = r2
            r11 = r3
            r12 = r8
            goto L1e9
        L3a9:
            r2 = move-exception
            r10 = r1
            r11 = r3
            r12 = r8
            goto L1e9
        L3af:
            r1 = move-exception
            r10 = r3
            r11 = r2
            r12 = r8
            goto L1e9
        L3b5:
            r1 = move-exception
            r10 = r3
            r11 = r5
            r12 = r8
            goto L1e9
        L3bb:
            r1 = move-exception
            r10 = r3
            r11 = r2
            r12 = r8
            goto L146
        L3c1:
            r1 = move-exception
            r10 = r2
            r11 = r3
            r12 = r8
            goto L146
        L3c7:
            r2 = move-exception
            r10 = r1
            r11 = r3
            r12 = r8
            goto L146
        L3cd:
            r1 = move-exception
            r10 = r3
            r11 = r5
            r12 = r8
            goto L146
        L3d3:
            r1 = move-exception
            r5 = r7
            goto L31f
        L3d7:
            r1 = move-exception
            goto L31f
        L3da:
            r14 = r3
            r3 = r2
            r2 = r14
            goto L2a7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.g.a(com.baidu.sofire.core.ApkInfo, java.lang.String, java.util.HashSet, java.lang.StringBuilder, boolean, boolean):void");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1111=4] */
    /* JADX WARN: Can't wrap try/catch for region: R(10:5|(1:102)(7:10|11|12|(1:14)|15|(4:22|(3:23|24|(1:26)(1:27))|(1:29)|30)|66)|31|32|33|(9:38|39|40|(3:42|43|(1:45)(1:46))|(1:48)|49|(1:51)|52|53)|78|64|65|66) */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x022c, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x022d, code lost:
        r3 = r1;
        r1 = r2;
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ApkInfo apkInfo, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z, boolean z2) {
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
                    com.baidu.sofire.b.a("extracting: " + name);
                    String str3 = Build.CPU_ABI;
                    String str4 = Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null;
                    com.baidu.sofire.b.a("e: " + name);
                    if (name.contains(str3) || ((!TextUtils.isEmpty(str4) && name.contains(str4)) || (name.contains(com.baidu.fsg.face.base.d.h.a) && (com.baidu.fsg.face.base.d.h.b.equalsIgnoreCase(str3) || (!TextUtils.isEmpty(str4) && com.baidu.fsg.face.base.d.h.b.equalsIgnoreCase(str4)))))) {
                        String str5 = str + name.substring(3).replace(PluginInstallerService.APK_LIB_SUFFIX, str2 + PluginInstallerService.APK_LIB_SUFFIX);
                        com.baidu.sofire.b.a("l=" + str + ", n=" + name + ", f=" + str5);
                        String substring = str5.substring(0, str5.lastIndexOf(47));
                        hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                        f(substring);
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
                                if (zipInputStream != null) {
                                }
                                if (fileOutputStream3 != null) {
                                }
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        com.baidu.sofire.b.e.a(str5, true);
                    }
                } else {
                    fileOutputStream = fileOutputStream3;
                }
                if (name.endsWith(".dex") && !nextEntry.isDirectory() && z2) {
                    String str6 = apkInfo.dataDir;
                    f(str6);
                    File file3 = new File(str6, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".dex");
                    try {
                        com.baidu.sofire.b.a("dex is extracting: " + file3.getAbsolutePath());
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
                                    com.baidu.sofire.b.a("unable extracting dex file for " + th.getMessage());
                                    if (file != null && file.exists()) {
                                        file.delete();
                                    }
                                    fileOutputStream3 = fileOutputStream2;
                                    zipInputStream.closeEntry();
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileOutputStream3 = fileOutputStream2;
                                    if (zipInputStream != null) {
                                        zipInputStream.close();
                                    }
                                    if (fileOutputStream3 != null) {
                                        fileOutputStream3.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                        if (fileOutputStream4 != null) {
                            fileOutputStream4.close();
                        }
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
        if (zipInputStream != null) {
            zipInputStream.close();
        }
        if (fileOutputStream3 != null) {
            fileOutputStream3.close();
        }
    }
}
