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
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.b.j;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.mipush.sdk.Constants;
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
    private String b;
    private boolean c;
    private Map<String, ApkInfo> g = new ConcurrentHashMap();
    private Map<String, ApkInfo> h = new ConcurrentHashMap();
    private Map<String, MyReceiver> i = new HashMap();
    private static e PM = null;
    private static Application PN = null;
    private static Random f = new Random();
    public static List<Integer> a = new ArrayList();

    public static e aq(Context context) {
        if (PM == null) {
            PN = (Application) context.getApplicationContext();
            PM = new e();
        }
        return PM;
    }

    public static e np() {
        return PM;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r0.intentFilters.add(r7);
        r1 = a(r7.PO);
        r0 = r1;
        com.baidu.sofire.b.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (r1.equals("____") != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (r6.i.keySet().contains(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
        if ("android.intent.action.PACKAGE_REMOVED__package".equals(r1) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
        r3 = new com.baidu.sofire.MyReceiver();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
        com.baidu.sofire.core.e.PN.registerReceiver(r3, r7.PO);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a4, code lost:
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(f fVar) {
        ApkInfo apkInfo;
        String a2;
        MyReceiver myReceiver;
        boolean z;
        if (fVar.PO != null && (apkInfo = this.h.get(fVar.a)) != null) {
            if (apkInfo.intentFilters == null) {
                apkInfo.intentFilters = new ArrayList();
            }
            int i = 0;
            while (true) {
                if (i >= apkInfo.intentFilters.size()) {
                    break;
                } else if (fVar.c(apkInfo.intentFilters.get(i))) {
                    break;
                } else {
                    i++;
                }
            }
        }
        if (z) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                com.baidu.sofire.b.d.a(e);
            }
            PN.registerReceiver(myReceiver, fVar.PO);
        }
        this.i.put(a2, myReceiver);
        PN.registerReceiver(myReceiver, fVar.PO);
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
        if (fVar != null) {
            try {
                if (fVar.PO != null) {
                    ApkInfo apkInfo = this.h.get(fVar.a);
                    if (apkInfo != null && apkInfo.intentFilters != null) {
                        ArrayList<Integer> arrayList = new ArrayList();
                        for (int i = 0; i < apkInfo.intentFilters.size(); i++) {
                            if (fVar.c(apkInfo.intentFilters.get(i))) {
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
                    String a2 = a(fVar.PO);
                    String str = a2;
                    com.baidu.sofire.b.a();
                    if (!TextUtils.isEmpty(a2) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a2)) {
                        Iterator<ApkInfo> it = b().iterator();
                        loop2: while (true) {
                            if (it.hasNext()) {
                                ApkInfo next = it.next();
                                if (next.intentFilters != null && next.intentFilters.size() > 0) {
                                    for (f fVar2 : next.intentFilters) {
                                        String a3 = a(fVar2.PO);
                                        if (!TextUtils.isEmpty(a3) && a3.equals(a2)) {
                                            String str2 = a2;
                                            com.baidu.sofire.b.a();
                                            break loop2;
                                        }
                                    }
                                    continue;
                                }
                            } else {
                                String str3 = a2;
                                com.baidu.sofire.b.a();
                                PN.unregisterReceiver(this.i.get(a2));
                                this.i.remove(a2);
                                break;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
            }
        }
    }

    public final List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.h.keySet()) {
                arrayList.add(this.h.get(str));
            }
            return arrayList;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            try {
                return new ArrayList();
            } catch (Throwable th2) {
                com.baidu.sofire.b.d.a(th2);
                return null;
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0017: ARITH  (r0v1 long A[REMOVE]) = (wrap: long : 0x0013: INVOKE  (r4v0 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long) - (r0v0 long))] */
    public final boolean a(ApkInfo apkInfo, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.c = z;
        this.b = apkInfo.versionName;
        boolean b = b(apkInfo);
        new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis).toString();
        com.baidu.sofire.b.a();
        return b;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x02ec: IGET  (r6v4 java.lang.Object A[REMOVE]) = (r4v37 android.util.Pair) android.util.Pair.first java.lang.Object)] */
    private synchronized boolean b(ApkInfo apkInfo) {
        boolean z;
        PackageInfo packageInfo;
        Pair pair;
        boolean z2;
        if (apkInfo != null) {
            if (!TextUtils.isEmpty(apkInfo.pkgPath)) {
                ApkInfo apkInfo2 = this.g.get(apkInfo.pkgPath);
                if (apkInfo2 != null) {
                    if (apkInfo2.versionName.equals(apkInfo.versionName)) {
                        com.baidu.sofire.b.a();
                        z2 = true;
                    } else {
                        a(apkInfo.pkgPath);
                    }
                }
                if (!com.baidu.sofire.b.d.o(new File(apkInfo.pkgPath))) {
                    com.baidu.sofire.b.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", Integer.valueOf(apkInfo.key));
                    hashMap.put("2", apkInfo.versionName);
                    com.baidu.sofire.b.d.a(PN.getApplicationContext(), "1003117", hashMap);
                    z2 = false;
                } else {
                    apkInfo.hostContext = PN;
                    if (apkInfo.apkParseSuc == 1) {
                        com.baidu.sofire.b.a();
                        if (TextUtils.isEmpty(apkInfo.packageName) || TextUtils.isEmpty(apkInfo.pkgPath)) {
                            throw new RuntimeException("packageName or pkgPath miss");
                        }
                        apkInfo.dataDir = PN.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                        String str = apkInfo.dataDir + "/dex";
                        String str2 = (apkInfo.dataDir + "/lib/" + this.b) + "/" + f.nextInt();
                        bU(str);
                        com.baidu.sofire.b.d.a(str, false);
                        bU(str2);
                        a(apkInfo, str2, str, false);
                        this.g.put(apkInfo.pkgPath, apkInfo);
                        this.h.put(apkInfo.packageName, apkInfo);
                        a(apkInfo, apkInfo.className);
                        z = false;
                    } else {
                        z = false;
                    }
                    if (apkInfo.apkParseSuc != 1 || z) {
                        String str3 = "!=1" + z;
                        com.baidu.sofire.b.a();
                        PackageInfo packageInfo2 = apkInfo.cloudPkgInfo;
                        if (packageInfo2 != null && !TextUtils.isEmpty(packageInfo2.packageName) && !TextUtils.isEmpty(packageInfo2.versionName)) {
                            com.baidu.sofire.b.a();
                            packageInfo = packageInfo2;
                        } else {
                            PackageInfo packageArchiveInfo = PN.getPackageManager().getPackageArchiveInfo(apkInfo.pkgPath, 1);
                            if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                                com.baidu.sofire.b.a();
                                packageArchiveInfo = L(apkInfo.packageName, apkInfo.apkMD5);
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
                            String str4 = apkInfo.apkMD5;
                            String str5 = apkInfo.pkgPath;
                            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                                pair = new Pair(false, "");
                            } else {
                                File file = new File(str5);
                                if (com.baidu.sofire.b.d.o(file)) {
                                    String a2 = j.a(file);
                                    pair = TextUtils.isEmpty(a2) ? new Pair(false, "") : !a2.equalsIgnoreCase(str4) ? new Pair(false, a2) : new Pair(true, "");
                                } else {
                                    pair = new Pair(false, "");
                                }
                            }
                            new StringBuilder().append(pair.first).toString();
                            com.baidu.sofire.b.a();
                            if (!((Boolean) pair.first).booleanValue()) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("0", 3);
                                hashMap2.put("1", Integer.valueOf(apkInfo.key));
                                hashMap2.put("2", packageInfo.versionName);
                                hashMap2.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, Base64.encodeToString(((String) pair.second).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                com.baidu.sofire.b.d.a(PN.getApplicationContext(), "1003117", hashMap2);
                                z2 = false;
                            }
                        }
                        apkInfo.packageName = packageInfo.packageName;
                        String str6 = "p=" + packageInfo.packageName + ", v=" + packageInfo.versionName;
                        com.baidu.sofire.b.a();
                        apkInfo.className = packageInfo.applicationInfo.className;
                        apkInfo.versionName = packageInfo.versionName;
                        apkInfo.activities = packageInfo.activities;
                        apkInfo.applicationTheme = packageInfo.applicationInfo.theme;
                        apkInfo.dataDir = PN.getFilesDir().getCanonicalPath() + "/." + apkInfo.key;
                        String str7 = apkInfo.dataDir + "/dex";
                        String str8 = (apkInfo.dataDir + "/lib/" + this.b) + "/" + f.nextInt();
                        bU(str7);
                        com.baidu.sofire.b.d.a(str7, false);
                        bU(str8);
                        a(apkInfo, str8, str7, true);
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

    private static PackageInfo L(String str, String str2) {
        String str3;
        String str4;
        try {
            StringBuilder sb = new StringBuilder();
            Application application = PN;
            String sb2 = sb.append(com.baidu.sofire.b.d.a()).append("plugin/v1/plugins/detail").toString();
            String[] e = com.baidu.sofire.b.d.e(PN);
            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                str3 = e[0];
                str4 = e[1];
            } else {
                str3 = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                str4 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pk", str);
            jSONObject.put("m", str2);
            jSONArray.put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            com.baidu.sofire.b.a();
            String a2 = com.baidu.sofire.b.f.a(PN, sb2, jSONArray2, str3, str4, false);
            String str5 = a2;
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
            applicationInfo.theme = optJSONObject.optInt(Info.kBaiduTimeKey);
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
                        activityInfo.theme = jSONObject2.optInt(Info.kBaiduTimeKey);
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
            com.baidu.sofire.b.d.a(th);
            return null;
        }
    }

    private static boolean a(ApkInfo apkInfo, String str) {
        try {
            String str2 = str;
            com.baidu.sofire.b.a();
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
            com.baidu.sofire.f.a(Application.class, PN, application);
            a(application, PN);
            application.onCreate();
            return true;
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.b();
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [805=4, 813=5, 816=4, 817=4, 819=4, 820=4] */
    private void a(com.baidu.sofire.core.ApkInfo r19, java.lang.String r20, java.lang.String r21, boolean r22) throws java.lang.Throwable {
        /*
            r18 = this;
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            r7 = 0
            if (r22 != 0) goto L27
            r0 = r19
            java.lang.String r1 = r0.dexPath
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L27
            java.io.File r1 = new java.io.File
            r0 = r19
            java.lang.String r2 = r0.dexPath
            r1.<init>(r2)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L27
            boolean r1 = r1.isFile()
            if (r1 != 0) goto L28
        L27:
            r7 = 1
        L28:
            java.lang.String r3 = ""
            r0 = r19
            java.lang.String r1 = r0.versionName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L43
            r0 = r19
            java.lang.String r1 = r0.versionName
            java.lang.String r2 = "."
            java.lang.String r3 = ""
            java.lang.String r3 = r1.replace(r2, r3)
        L43:
            r9 = 0
            r2 = 0
            r8 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            if (r7 != 0) goto L54
            r0 = r19
            java.lang.String r1 = r0.dexPath
            r6.append(r1)
        L54:
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r1]
            java.util.zip.ZipFile r11 = new java.util.zip.ZipFile     // Catch: java.io.FileNotFoundException -> L366 java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r0 = r19
            java.lang.String r1 = r0.pkgPath     // Catch: java.io.FileNotFoundException -> L366 java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r11.<init>(r1)     // Catch: java.io.FileNotFoundException -> L366 java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
        L61:
            java.util.Enumeration r12 = r11.entries()     // Catch: java.lang.Throwable -> L5bc java.io.EOFException -> L5de java.util.zip.ZipException -> L5f7
        L65:
            boolean r1 = r12.hasMoreElements()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r1 == 0) goto L541
            java.lang.Object r1 = r12.nextElement()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r13 = r1.getName()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r9 = "lib/"
            boolean r9 = r13.startsWith(r9)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r9 == 0) goto L61b
            boolean r9 = r1.isDirectory()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r9 != 0) goto L61b
            java.lang.String r14 = android.os.Build.CPU_ABI     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r9 = 0
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L47a
            r15 = 8
            if (r10 < r15) goto L8f
            java.lang.String r9 = android.os.Build.CPU_ABI2     // Catch: java.lang.Throwable -> L47a
        L8f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r15 = "e: "
            r10.<init>(r15)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.StringBuilder r10 = r10.append(r13)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r10.toString()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            com.baidu.sofire.b.a()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            boolean r10 = r13.contains(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r10 != 0) goto Ld4
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r10 != 0) goto Lb3
            boolean r10 = r13.contains(r9)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r10 != 0) goto Ld4
        Lb3:
            java.lang.String r10 = "armeabi"
            boolean r10 = r13.contains(r10)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r10 == 0) goto L65
            java.lang.String r10 = "armeabi-v7a"
            boolean r10 = r10.equalsIgnoreCase(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r10 != 0) goto Ld4
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r10 != 0) goto L65
            java.lang.String r10 = "armeabi-v7a"
            boolean r9 = r10.equalsIgnoreCase(r9)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            if (r9 == 0) goto L65
        Ld4:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r9.<init>()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r0 = r20
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r10 = 3
            java.lang.String r10 = r13.substring(r10)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r14 = ".so"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r15.<init>()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.StringBuilder r15 = r15.append(r3)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r16 = ".so"
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r15 = r15.toString()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r10 = r10.replace(r14, r15)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r10 = r9.toString()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r14 = "l="
            r9.<init>(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r0 = r20
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r14 = ", n="
            java.lang.StringBuilder r9 = r9.append(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.StringBuilder r9 = r9.append(r13)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r14 = ", f="
            java.lang.StringBuilder r9 = r9.append(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r9.toString()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            com.baidu.sofire.b.a()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r9 = 0
            r14 = 47
            int r14 = r10.lastIndexOf(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.lang.String r9 = r10.substring(r9, r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r14 = 47
            int r14 = r9.lastIndexOf(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            int r14 = r14 + 1
            java.lang.String r14 = r9.substring(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r4.add(r14)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            bU(r9)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.io.File r9 = new java.io.File     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r9.<init>(r10)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            r9.delete()     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.io.InputStream r9 = r11.getInputStream(r1)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
        L15f:
            int r8 = r9.read(r5)     // Catch: java.util.zip.ZipException -> L16a java.lang.Throwable -> L5bf java.io.EOFException -> L5e2
            if (r8 <= 0) goto L485
            r14 = 0
            r2.write(r5, r14, r8)     // Catch: java.util.zip.ZipException -> L16a java.lang.Throwable -> L5bf java.io.EOFException -> L5e2
            goto L15f
        L16a:
            r1 = move-exception
            r8 = r2
            r10 = r11
        L16d:
            r1 = r19
            r2 = r20
            a(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5d9
            if (r10 == 0) goto L179
            r10.close()
        L179:
            if (r9 == 0) goto L17e
            r9.close()
        L17e:
            if (r8 == 0) goto L183
            r8.close()
        L183:
            java.lang.String r1 = ""
            java.lang.String r2 = android.os.Build.CPU_ABI
            boolean r2 = r4.contains(r2)
            if (r2 == 0) goto L577
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r0 = r20
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = android.os.Build.CPU_ABI
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r3 = r1.toString()
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L550
            r5 = 8
            if (r2 < r5) goto L1d5
            java.lang.String r2 = android.os.Build.CPU_ABI2     // Catch: java.lang.Throwable -> L550
            boolean r2 = r4.contains(r2)     // Catch: java.lang.Throwable -> L550
            if (r2 == 0) goto L1d5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L550
            r2.<init>()     // Catch: java.lang.Throwable -> L550
            r0 = r20
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L550
            java.lang.String r5 = "/"
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Throwable -> L550
            java.lang.String r5 = android.os.Build.CPU_ABI2     // Catch: java.lang.Throwable -> L550
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Throwable -> L550
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L550
        L1d5:
            if (r1 == 0) goto L556
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ":"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = ":"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "java.library.path"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
        L201:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L256
            java.lang.String r2 = "armeabi-v7a"
            java.lang.String r3 = android.os.Build.CPU_ABI
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L21b
            java.lang.String r2 = "armeabi"
            boolean r2 = r4.contains(r2)
            if (r2 != 0) goto L235
        L21b:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 8
            if (r2 < r3) goto L256
            java.lang.String r2 = "armeabi-v7a"
            java.lang.String r3 = android.os.Build.CPU_ABI2
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L256
            java.lang.String r2 = "armeabi"
            boolean r2 = r4.contains(r2)
            if (r2 == 0) goto L256
        L235:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r0 = r20
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = "/armeabi:"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "java.library.path"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
        L256:
            r0 = r19
            r0.libPath = r1
            java.lang.String r2 = r6.toString()
            r0 = r19
            r0.dexPath = r2
            dalvik.system.PathClassLoader r2 = new dalvik.system.PathClassLoader
            r0 = r19
            android.content.Context r3 = r0.hostContext
            java.lang.String r3 = r3.getPackageResourcePath()
            java.lang.Class r4 = r18.getClass()
            java.lang.ClassLoader r4 = r4.getClassLoader()
            r2.<init>(r3, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r1)
            r3.toString()
            com.baidu.sofire.b.a()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r6)
            r3.toString()
            com.baidu.sofire.b.a()
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L2e5
            java.lang.String r4 = "apkDex"
            r0 = r21
            r3.<init>(r0, r4)     // Catch: java.lang.Throwable -> L2e5
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L2e5
            com.baidu.sofire.b.d.b(r3)     // Catch: java.lang.Throwable -> L2e5
            bU(r3)     // Catch: java.lang.Throwable -> L2e5
            com.baidu.sofire.core.d r4 = new com.baidu.sofire.core.d     // Catch: java.lang.Throwable -> L2e5
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L2e5
            r4.<init>(r5, r3, r1, r2)     // Catch: java.lang.Throwable -> L2e5
            r0 = r19
            r0.classLoader = r4     // Catch: java.lang.Throwable -> L2e5
            r0 = r19
            java.lang.ClassLoader r3 = r0.classLoader     // Catch: java.lang.Throwable -> L2e5
            java.lang.String r4 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.Class r3 = r3.loadClass(r4)     // Catch: java.lang.Throwable -> L2e5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e5
            r4.<init>()     // Catch: java.lang.Throwable -> L2e5
            java.lang.StringBuilder r4 = r4.append(r3)     // Catch: java.lang.Throwable -> L2e5
            r4.toString()     // Catch: java.lang.Throwable -> L2e5
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L2e5
            if (r3 == 0) goto L2dc
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L2e5
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L2e5
            if (r3 == 0) goto L5bb
        L2dc:
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Throwable -> L2e5
            java.lang.String r4 = "class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L2e5
            throw r3     // Catch: java.lang.Throwable -> L2e5
        L2e5:
            r3 = move-exception
            com.baidu.sofire.b.a()
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L339
            java.lang.String r4 = "dexDex"
            r0 = r21
            r3.<init>(r0, r4)     // Catch: java.lang.Throwable -> L339
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L339
            com.baidu.sofire.b.d.b(r3)     // Catch: java.lang.Throwable -> L339
            bU(r3)     // Catch: java.lang.Throwable -> L339
            com.baidu.sofire.core.d r4 = new com.baidu.sofire.core.d     // Catch: java.lang.Throwable -> L339
            r0 = r19
            java.lang.String r5 = r0.pkgPath     // Catch: java.lang.Throwable -> L339
            r4.<init>(r5, r3, r1, r2)     // Catch: java.lang.Throwable -> L339
            r0 = r19
            r0.classLoader = r4     // Catch: java.lang.Throwable -> L339
            r0 = r19
            java.lang.ClassLoader r1 = r0.classLoader     // Catch: java.lang.Throwable -> L339
            java.lang.String r2 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.Throwable -> L339
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L339
            r2.<init>()     // Catch: java.lang.Throwable -> L339
            java.lang.StringBuilder r2 = r2.append(r1)     // Catch: java.lang.Throwable -> L339
            r2.toString()     // Catch: java.lang.Throwable -> L339
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L339
            if (r1 == 0) goto L330
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L339
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L339
            if (r1 == 0) goto L5bb
        L330:
            java.lang.Exception r1 = new java.lang.Exception     // Catch: java.lang.Throwable -> L339
            java.lang.String r2 = "class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L339
            throw r1     // Catch: java.lang.Throwable -> L339
        L339:
            r1 = move-exception
            com.baidu.sofire.b.a()
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "can't load EngineImpl by both dexFile:"
            r2.<init>(r3)
            java.lang.String r3 = r6.toString()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " and ZipFile:"
            java.lang.StringBuilder r2 = r2.append(r3)
            r0 = r19
            java.lang.String r3 = r0.pkgPath
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L366:
            r1 = move-exception
            java.lang.String r10 = r1.getMessage()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.io.File r1 = new java.io.File     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r0 = r19
            android.content.Context r11 = r0.hostContext     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.io.File r11 = r11.getFilesDir()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r12 = ".b"
            r1.<init>(r11, r12)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            boolean r11 = r1.exists()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            if (r11 != 0) goto L3a0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r1.<init>()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r1 = r1.append(r10)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r10 = "--backupDir not exists"
            java.lang.StringBuilder r1 = r1.append(r10)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.io.FileNotFoundException r10 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r10.<init>(r1)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            throw r10     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
        L39b:
            r1 = move-exception
            r10 = r9
            r9 = r2
            goto L16d
        L3a0:
            java.io.File r11 = new java.io.File     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r12.<init>()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r0 = r19
            int r13 = r0.key     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r13 = "-"
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r0 = r19
            java.lang.String r13 = r0.versionName     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r12 = r12.toString()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r11.<init>(r1, r12)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            boolean r1 = r11.exists()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            if (r1 != 0) goto L400
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r1.<init>()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r1 = r1.append(r10)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r10 = "--backupFile not exists"
            java.lang.StringBuilder r1 = r1.append(r10)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.io.FileNotFoundException r10 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r10.<init>(r1)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            throw r10     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
        L3e5:
            r1 = move-exception
            r11 = r9
            r9 = r2
        L3e8:
            r1 = r19
            r2 = r20
            a(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5d5
            if (r11 == 0) goto L3f4
            r11.close()
        L3f4:
            if (r9 == 0) goto L3f9
            r9.close()
        L3f9:
            if (r8 == 0) goto L183
            r8.close()
            goto L183
        L400:
            java.io.File r1 = new java.io.File     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r0 = r19
            java.lang.String r12 = r0.pkgPath     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r1.<init>(r12)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            com.baidu.sofire.b.d.a(r11, r1)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r0 = r19
            java.lang.String r12 = r0.pkgPath     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r13 = 1
            com.baidu.sofire.b.d.a(r12, r13)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            com.baidu.sofire.c.a(r1)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            com.baidu.sofire.c.a(r1, r11)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            boolean r1 = r1.exists()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            if (r1 == 0) goto L460
            java.util.zip.ZipFile r11 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L42b
            r0 = r19
            java.lang.String r1 = r0.pkgPath     // Catch: java.lang.Throwable -> L42b
            r11.<init>(r1)     // Catch: java.lang.Throwable -> L42b
            goto L61
        L42b:
            r1 = move-exception
            java.io.FileNotFoundException r11 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r12.<init>()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r10 = r12.append(r10)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r12 = "--"
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r1 = r1.getMessage()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r1 = r10.append(r1)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r1 = r1.toString()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r11.<init>(r1)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            throw r11     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
        L44e:
            r1 = move-exception
            r11 = r9
        L450:
            if (r11 == 0) goto L455
            r11.close()
        L455:
            if (r2 == 0) goto L45a
            r2.close()
        L45a:
            if (r8 == 0) goto L45f
            r8.close()
        L45f:
            throw r1
        L460:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r11.<init>()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.StringBuilder r10 = r11.append(r10)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r11 = "--file not exists after copy"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            java.lang.String r10 = r10.toString()     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            r1.<init>(r10)     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
            throw r1     // Catch: java.util.zip.ZipException -> L39b java.io.EOFException -> L3e5 java.lang.Throwable -> L44e
        L47a:
            r10 = move-exception
            com.baidu.sofire.b.d.a(r10)     // Catch: java.util.zip.ZipException -> L480 java.lang.Throwable -> L5bc java.io.EOFException -> L5f0
            goto L8f
        L480:
            r1 = move-exception
            r9 = r2
            r10 = r11
            goto L16d
        L485:
            r8 = 1
            com.baidu.sofire.b.d.a(r10, r8)     // Catch: java.util.zip.ZipException -> L16a java.lang.Throwable -> L5bf java.io.EOFException -> L5e2
            r8 = r9
        L48a:
            r10 = 0
            java.lang.String r9 = ".dex"
            boolean r9 = r13.endsWith(r9)     // Catch: java.lang.Throwable -> L60c
            if (r9 == 0) goto L53a
            boolean r9 = r1.isDirectory()     // Catch: java.lang.Throwable -> L60c
            if (r9 != 0) goto L53a
            if (r7 == 0) goto L53a
            r0 = r19
            java.lang.String r13 = r0.dataDir     // Catch: java.lang.Throwable -> L60c
            bU(r13)     // Catch: java.lang.Throwable -> L60c
            java.io.File r9 = new java.io.File     // Catch: java.lang.Throwable -> L60c
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60c
            r14.<init>()     // Catch: java.lang.Throwable -> L60c
            r0 = r19
            int r15 = r0.key     // Catch: java.lang.Throwable -> L60c
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch: java.lang.Throwable -> L60c
            java.lang.String r15 = "-"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch: java.lang.Throwable -> L60c
            r0 = r19
            java.lang.String r15 = r0.versionName     // Catch: java.lang.Throwable -> L60c
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch: java.lang.Throwable -> L60c
            java.lang.String r15 = ".dex"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch: java.lang.Throwable -> L60c
            java.lang.String r14 = r14.toString()     // Catch: java.lang.Throwable -> L60c
            r9.<init>(r13, r14)     // Catch: java.lang.Throwable -> L60c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L612
            java.lang.String r13 = "e: "
            r10.<init>(r13)     // Catch: java.lang.Throwable -> L612
            java.lang.String r13 = r9.getAbsolutePath()     // Catch: java.lang.Throwable -> L612
            java.lang.StringBuilder r10 = r10.append(r13)     // Catch: java.lang.Throwable -> L612
            r10.toString()     // Catch: java.lang.Throwable -> L612
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L612
            java.io.InputStream r8 = r11.getInputStream(r1)     // Catch: java.lang.Throwable -> L612
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L612
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L612
        L4ee:
            int r2 = r8.read(r5)     // Catch: java.lang.Throwable -> L4f9
            if (r2 <= 0) goto L522
            r10 = 0
            r1.write(r5, r10, r2)     // Catch: java.lang.Throwable -> L4f9
            goto L4ee
        L4f9:
            r2 = move-exception
            r17 = r2
            r2 = r9
            r9 = r8
            r8 = r1
            r1 = r17
        L501:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
            r10.<init>()     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
            java.lang.StringBuilder r1 = r10.append(r1)     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
            r1.toString()     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
            if (r2 == 0) goto L51f
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
            if (r1 == 0) goto L51f
            r2.delete()     // Catch: java.lang.Throwable -> L5d5 java.io.EOFException -> L5f4 java.util.zip.ZipException -> L608
        L51f:
            r2 = r9
            goto L65
        L522:
            r1.close()     // Catch: java.lang.Throwable -> L4f9
            if (r8 == 0) goto L52a
            r8.close()     // Catch: java.lang.Throwable -> L4f9
        L52a:
            java.lang.String r2 = r9.getAbsolutePath()     // Catch: java.lang.Throwable -> L4f9
            r6.append(r2)     // Catch: java.lang.Throwable -> L4f9
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L4f9
            r10 = 1
            com.baidu.sofire.b.d.a(r2, r10)     // Catch: java.lang.Throwable -> L4f9
            r2 = r1
        L53a:
            r17 = r2
            r2 = r8
            r8 = r17
            goto L65
        L541:
            r11.close()
            if (r2 == 0) goto L549
            r2.close()
        L549:
            if (r8 == 0) goto L183
            r8.close()
            goto L183
        L550:
            r2 = move-exception
            com.baidu.sofire.b.d.a(r2)
            goto L1d5
        L556:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r2 = ":"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "java.library.path"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            goto L201
        L577:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L5b5
            r3 = 8
            if (r2 < r3) goto L201
            java.lang.String r2 = android.os.Build.CPU_ABI2     // Catch: java.lang.Throwable -> L5b5
            boolean r2 = r4.contains(r2)     // Catch: java.lang.Throwable -> L5b5
            if (r2 == 0) goto L201
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b5
            r2.<init>()     // Catch: java.lang.Throwable -> L5b5
            r0 = r20
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L5b5
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L5b5
            java.lang.String r3 = android.os.Build.CPU_ABI2     // Catch: java.lang.Throwable -> L5b5
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L5b5
            java.lang.String r3 = ":"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L5b5
            java.lang.String r3 = "java.library.path"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch: java.lang.Throwable -> L5b5
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L5b5
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L5b5
            goto L201
        L5b5:
            r2 = move-exception
            com.baidu.sofire.b.d.a(r2)
            goto L201
        L5bb:
            return
        L5bc:
            r1 = move-exception
            goto L450
        L5bf:
            r1 = move-exception
            r8 = r2
            r2 = r9
            goto L450
        L5c4:
            r1 = move-exception
            r17 = r2
            r2 = r8
            r8 = r17
            goto L450
        L5cc:
            r2 = move-exception
            r17 = r2
            r2 = r8
            r8 = r1
            r1 = r17
            goto L450
        L5d5:
            r1 = move-exception
            r2 = r9
            goto L450
        L5d9:
            r1 = move-exception
            r2 = r9
            r11 = r10
            goto L450
        L5de:
            r1 = move-exception
            r9 = r2
            goto L3e8
        L5e2:
            r1 = move-exception
            r8 = r2
            goto L3e8
        L5e6:
            r1 = move-exception
            r9 = r8
            r8 = r2
            goto L3e8
        L5eb:
            r2 = move-exception
            r9 = r8
            r8 = r1
            goto L3e8
        L5f0:
            r1 = move-exception
            r9 = r2
            goto L3e8
        L5f4:
            r1 = move-exception
            goto L3e8
        L5f7:
            r1 = move-exception
            r9 = r2
            r10 = r11
            goto L16d
        L5fc:
            r1 = move-exception
            r9 = r8
            r10 = r11
            r8 = r2
            goto L16d
        L602:
            r2 = move-exception
            r9 = r8
            r10 = r11
            r8 = r1
            goto L16d
        L608:
            r1 = move-exception
            r10 = r11
            goto L16d
        L60c:
            r1 = move-exception
            r9 = r8
            r8 = r2
            r2 = r10
            goto L501
        L612:
            r1 = move-exception
            r17 = r9
            r9 = r8
            r8 = r2
            r2 = r17
            goto L501
        L61b:
            r17 = r8
            r8 = r2
            r2 = r17
            goto L48a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.e.a(com.baidu.sofire.core.ApkInfo, java.lang.String, java.lang.String, boolean):void");
    }

    public final boolean a(String str) {
        ApkInfo apkInfo = this.g.get(str);
        if (apkInfo != null) {
            this.g.remove(str);
            this.h.remove(apkInfo.packageName);
            com.baidu.sofire.b.d.b(apkInfo.dataDir);
            if (PN != null) {
                com.baidu.sofire.b.d.b(PN.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0035: INVOKE  (r1v5 int A[REMOVE]) = 
      (wrap: java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> : 0x0033: IGET  (r1v4 java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> A[REMOVE]) = (r3v0 'this' com.baidu.sofire.core.e A[IMMUTABLE_TYPE, THIS]) com.baidu.sofire.core.e.g java.util.Map)
     type: INTERFACE call: java.util.Map.size():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x004a: INVOKE  (r1v7 int A[REMOVE]) = 
      (wrap: java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> : 0x0048: IGET  (r1v6 java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> A[REMOVE]) = (r3v0 'this' com.baidu.sofire.core.e A[IMMUTABLE_TYPE, THIS]) com.baidu.sofire.core.e.h java.util.Map)
     type: INTERFACE call: java.util.Map.size():int)] */
    public final boolean b(String str) {
        ApkInfo apkInfo = this.h.get(str);
        if (apkInfo != null) {
            this.g.remove(apkInfo.pkgPath);
            this.h.remove(str);
            com.baidu.sofire.b.d.b(apkInfo.dataDir);
            if (PN != null) {
                com.baidu.sofire.b.d.b(PN.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            new StringBuilder().append(this.g.size()).toString();
            com.baidu.sofire.b.a();
            new StringBuilder().append(this.h.size()).toString();
            com.baidu.sofire.b.a();
            return true;
        }
        return false;
    }

    public final ApkInfo bQ(String str) {
        try {
            return this.g.get(str);
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return null;
        }
    }

    public final ApkInfo bT(String str) {
        try {
            return this.h.get(str);
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return null;
        }
    }

    public final String e(String str) {
        ApkInfo apkInfo = this.h.get(str);
        if (apkInfo == null) {
            return null;
        }
        return apkInfo.pkgPath;
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
                com.baidu.sofire.b.d.a(th);
            }
        }
    }

    private static boolean bU(String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1096=4] */
    /* JADX WARN: Can't wrap try/catch for region: R(10:5|(1:96)(7:9|10|11|(1:13)|14|(3:21|(3:22|23|(1:25)(1:26))|27)|60)|28|29|30|(8:35|36|37|(3:38|39|(1:41)(1:42))|43|(1:45)|46|47)|72|58|59|60) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f4, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01f5, code lost:
        r2 = r0;
        r0 = r1;
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(ApkInfo apkInfo, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) throws IOException {
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
                if (!name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) || nextEntry.isDirectory()) {
                    fileOutputStream = fileOutputStream3;
                } else {
                    String str3 = name;
                    com.baidu.sofire.b.a();
                    String str4 = Build.CPU_ABI;
                    String str5 = Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null;
                    String str6 = "e: " + name;
                    com.baidu.sofire.b.a();
                    if (name.contains(str4) || ((!TextUtils.isEmpty(str5) && name.contains(str5)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str4) || (!TextUtils.isEmpty(str5) && "armeabi-v7a".equalsIgnoreCase(str5)))))) {
                        String str7 = str + name.substring(3).replace(PluginInstallerService.APK_LIB_SUFFIX, str2 + PluginInstallerService.APK_LIB_SUFFIX);
                        String str8 = "l=" + str + ", n=" + name + ", f=" + str7;
                        com.baidu.sofire.b.a();
                        String substring = str7.substring(0, str7.lastIndexOf(47));
                        hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                        bU(substring);
                        File file2 = new File(str7);
                        file2.delete();
                        file2.createNewFile();
                        fileOutputStream = new FileOutputStream(str7);
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
                        com.baidu.sofire.b.d.a(str7, true);
                    }
                }
                if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                    String str9 = apkInfo.dataDir;
                    bU(str9);
                    File file3 = new File(str9, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".dex");
                    try {
                        String str10 = file3.getAbsolutePath();
                        com.baidu.sofire.b.a();
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
                                    String str11 = th.getMessage();
                                    com.baidu.sofire.b.a();
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
                        com.baidu.sofire.b.d.a(sb.toString(), true);
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
