package com.baidu.sofire.core;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.rp.Report;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    private static c aGy;
    public static Context b;
    com.baidu.sofire.a.a aGA;
    public com.baidu.sofire.e aGz;
    private volatile boolean e = false;
    private static int g = 0;
    public static List<Integer> d = new ArrayList();

    private c(Context context) {
        b = context.getApplicationContext();
        this.aGA = com.baidu.sofire.a.a.ay(b);
        this.aGz = new com.baidu.sofire.e(b);
    }

    public static c vE() {
        return aGy;
    }

    public final void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                com.baidu.sofire.e eVar = this.aGz;
                eVar.c.putString("svi", str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
                eVar.c.commit();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    public static synchronized c aC(Context context) {
        c cVar;
        synchronized (c.class) {
            new StringBuilder("i=").append(aGy);
            if (aGy == null) {
                aGy = new c(context.getApplicationContext());
            }
            cVar = aGy;
        }
        return cVar;
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [com.baidu.sofire.core.c$1] */
    public final synchronized void a(final Callback callback) {
        String str;
        try {
            String[] az = com.baidu.sofire.b.d.az(b);
            if (az == null || az.length != 2 || TextUtils.isEmpty(az[0]) || TextUtils.isEmpty(az[1])) {
                com.baidu.sofire.b.d.e(b);
            }
            Context context = b;
            try {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                String str2 = com.baidu.sofire.b.d.a() + "plugin/v1/settings";
                new StringBuilder().append(str2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", "b");
                JSONObject jSONObject2 = new JSONObject(com.baidu.sofire.b.g.a(context, str2, jSONObject.toString(), true, false, ""));
                int optInt = jSONObject2.optInt("app");
                new StringBuilder("App-").append(Integer.toString(optInt));
                eVar.c.putInt("appinv_t", optInt);
                eVar.c.commit();
                int optInt2 = jSONObject2.optInt("js");
                new StringBuilder("JS-").append(Integer.toString(optInt2));
                eVar.c.putInt("appinv_js", optInt2);
                eVar.c.commit();
                int optInt3 = jSONObject2.optInt("a", 1);
                new StringBuilder("get key-").append(Integer.toString(optInt3));
                eVar.c.putInt("appinv_ky", optInt3);
                eVar.c.commit();
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
            }
            com.baidu.sofire.b.d.b(b);
            new StringBuilder().append(this.e);
            if (this.e) {
                if (callback != null) {
                    callback.onEnd(new Object[0]);
                }
            } else {
                this.e = true;
                com.baidu.sofire.e eVar2 = this.aGz;
                eVar2.c.putString("ssv", "3.1.0");
                eVar2.c.commit();
                Report.getInstance(b).n();
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addDataScheme("package");
                b.registerReceiver(new MyReceiver(), intentFilter);
                com.baidu.sofire.b.b.a(b);
                for (ApkInfo apkInfo : this.aGA.a()) {
                    try {
                        str = b.getFilesDir().getCanonicalPath();
                    } catch (IOException e) {
                        com.baidu.sofire.b.d.a(e);
                        str = null;
                    }
                    if (str != null) {
                        apkInfo.dataDir = str + "/." + apkInfo.key;
                        com.baidu.sofire.b.d.b(apkInfo.dataDir + "/lib");
                    }
                }
                new Thread() { // from class: com.baidu.sofire.core.c.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            super.run();
                            c.this.aGA.d();
                            new StringBuilder().append(c.this.aGz.a.getBoolean("iio", false));
                            if (!c.this.aGz.a.getBoolean("iio", false)) {
                                com.baidu.sofire.e eVar3 = c.this.aGz;
                                eVar3.c.putBoolean("iio", true);
                                eVar3.c.commit();
                            } else {
                                com.baidu.sofire.a.a aVar = c.this.aGA;
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("n", (Integer) 0);
                                aVar.aGm.update("pgn", contentValues, "n=-1", null);
                            }
                            new U(c.b, 1, false).start();
                            if (callback != null) {
                                callback.onEnd(new Object[0]);
                            }
                        } catch (Throwable th2) {
                            com.baidu.sofire.b.d.a(th2);
                        }
                    }
                }.start();
            }
        }
    }

    public final void b() {
        try {
            List<ApkInfo> a = this.aGA.a();
            new StringBuilder("all=").append(a);
            final List<Integer> c = this.aGz.c();
            List<Integer> b2 = this.aGz.b();
            for (int i = 0; i < b2.size(); i++) {
                if (!c.contains(b2.get(i))) {
                    c.add(b2.get(i));
                }
            }
            Collections.sort(a, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.core.c.2
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ApkInfo apkInfo, ApkInfo apkInfo2) {
                    ApkInfo apkInfo3 = apkInfo;
                    ApkInfo apkInfo4 = apkInfo2;
                    if (apkInfo3.priority != -1 || apkInfo4.priority == -1) {
                        if ((apkInfo3.priority == -1 || apkInfo4.priority != -1) && apkInfo3.priority >= apkInfo4.priority) {
                            if (apkInfo3.priority > apkInfo4.priority) {
                                return 1;
                            }
                            int indexOf = (c == null || !c.contains(Integer.valueOf(apkInfo3.key))) ? -1 : c.indexOf(Integer.valueOf(apkInfo3.key));
                            int indexOf2 = (c == null || !c.contains(Integer.valueOf(apkInfo4.key))) ? -1 : c.indexOf(Integer.valueOf(apkInfo4.key));
                            if (indexOf == -1 || indexOf2 != -1) {
                                if ((indexOf != -1 || indexOf2 == -1) && indexOf <= indexOf2) {
                                    return indexOf >= indexOf2 ? 0 : -1;
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
                e vF = e.vF();
                if ((vF != null ? vF.cm(apkInfo.packageName) : null) == null) {
                    boolean z = this.aGA.dZ(apkInfo.key) != 3;
                    if (this.aGz.a.getBoolean("bka", true) && z) {
                        File file = new File(b.getFilesDir(), ".b");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(apkInfo.pkgPath);
                        File file3 = new File(file, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                        if (!com.baidu.sofire.b.d.a(file3)) {
                            com.baidu.sofire.b.d.a(file2, file3);
                        }
                        com.baidu.sofire.c.a(b, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(b.getFilesDir(), ".b");
                        if (file4.exists()) {
                            File file5 = new File(file4, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                            if (com.baidu.sofire.b.d.a(file5)) {
                                com.baidu.sofire.c.a(file5);
                                new StringBuilder().append(file5.getAbsolutePath()).append(" s=").append(file5.delete());
                            }
                        }
                    }
                    a(apkInfo.key, apkInfo.versionName, null);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    public final void b(Context context) {
        try {
            if (!this.aGz.a.getBoolean("lpcf", false)) {
                JSONArray jSONArray = new JSONArray(com.baidu.sofire.b.d.a(context, "sofire_local.cfg", "local"));
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("pkgname");
                    String optString2 = optJSONObject.optString("version");
                    int optInt = optJSONObject.optInt("id");
                    if (optInt > 0) {
                        arrayList.add(Integer.valueOf(optInt));
                    }
                    String optString3 = optJSONObject.optString(com.baidu.ar.util.Constants.HTTP_AR_MD5);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && optInt > 0) {
                        String lowerCase = optString3.toLowerCase();
                        ApkInfo apkInfo = new ApkInfo();
                        apkInfo.packageName = optString;
                        apkInfo.versionName = optString2;
                        apkInfo.key = optInt;
                        apkInfo.apkMD5 = lowerCase;
                        hashMap.put(Integer.valueOf(optInt), apkInfo);
                    }
                }
                this.aGz.a(arrayList);
                if (hashMap.size() <= 0) {
                    com.baidu.sofire.e eVar = this.aGz;
                    eVar.c.putBoolean("lpcf", true);
                    eVar.c.commit();
                    return;
                }
                String str = com.baidu.sofire.b.d.a() + "plugin/v1/plugins/info";
                JSONArray jSONArray2 = new JSONArray();
                for (ApkInfo apkInfo2 : hashMap.values()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PushConstants.URI_PACKAGE_NAME, apkInfo2.packageName);
                    jSONObject.put("m", apkInfo2.apkMD5);
                    jSONObject.put(NotifyType.LIGHTS, apkInfo2.key);
                    jSONObject.put(NotifyType.VIBRATE, apkInfo2.versionName);
                    jSONArray2.put(jSONObject);
                }
                String a = com.baidu.sofire.b.g.a(context, str, jSONArray2.toString(), false, false, "");
                new StringBuilder().append(a);
                JSONArray jSONArray3 = new JSONArray(a);
                if (jSONArray3.length() > 0) {
                    com.baidu.sofire.e eVar2 = this.aGz;
                    eVar2.c.putBoolean("lpcf", true);
                    eVar2.c.commit();
                }
                for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                    JSONObject optJSONObject2 = jSONArray3.optJSONObject(i2);
                    int optInt2 = optJSONObject2.optInt("errno");
                    int optInt3 = optJSONObject2.optInt(NotifyType.LIGHTS);
                    if (optInt2 == 1) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detail");
                        PackageInfo packageInfo = new PackageInfo();
                        packageInfo.packageName = optJSONObject3.optString("p");
                        packageInfo.versionName = optJSONObject3.optString(NotifyType.VIBRATE);
                        ApplicationInfo applicationInfo = new ApplicationInfo();
                        applicationInfo.className = optJSONObject3.optString("n");
                        if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(com.baidu.ar.util.Constants.DOT)) {
                            applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                        }
                        applicationInfo.theme = optJSONObject3.optInt(Info.kBaiduTimeKey);
                        packageInfo.applicationInfo = applicationInfo;
                        JSONArray optJSONArray = optJSONObject3.optJSONArray("a");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                if (jSONObject2 != null) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.name = jSONObject2.optString("n");
                                    if (!TextUtils.isEmpty(activityInfo.name) && activityInfo.name.startsWith(com.baidu.ar.util.Constants.DOT)) {
                                        activityInfo.name = packageInfo.packageName + activityInfo.name;
                                    }
                                    activityInfo.packageName = packageInfo.packageName;
                                    activityInfo.theme = jSONObject2.optInt(Info.kBaiduTimeKey);
                                    activityInfo.labelRes = jSONObject2.optInt(NotifyType.LIGHTS);
                                    if (!TextUtils.isEmpty(activityInfo.name)) {
                                        arrayList2.add(activityInfo);
                                    }
                                }
                            }
                            if (arrayList2.size() > 0) {
                                packageInfo.activities = (ActivityInfo[]) arrayList2.toArray(new ActivityInfo[arrayList2.size()]);
                            }
                        }
                        ApkInfo apkInfo3 = (ApkInfo) hashMap.get(Integer.valueOf(optInt3));
                        new StringBuilder().append(apkInfo3);
                        if (apkInfo3 != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                            a(apkInfo3.key, apkInfo3.versionName, apkInfo3.apkMD5, packageInfo);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [583=7, 585=6, 587=5, 590=5, 592=6, 594=6] */
    private void a(int r10, java.lang.String r11, java.lang.String r12, android.content.pm.PackageInfo r13) {
        /*
            r9 = this;
            r4 = 0
            r1 = 0
            r5 = 1
            com.baidu.sofire.a.a r0 = r9.aGA     // Catch: java.lang.Throwable -> L100
            com.baidu.sofire.core.ApkInfo r0 = r0.dW(r10)     // Catch: java.lang.Throwable -> L100
            if (r0 == 0) goto L1c
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> L100
            boolean r0 = com.baidu.sofire.b.d.c(r11, r0)     // Catch: java.lang.Throwable -> L100
            if (r0 != 0) goto L14
        L13:
            return
        L14:
            com.baidu.sofire.a.a r0 = r9.aGA     // Catch: java.lang.Throwable -> Lfa
            com.baidu.sofire.core.ApkInfo r0 = r0.dW(r10)     // Catch: java.lang.Throwable -> Lfa
            if (r0 != 0) goto Lad
        L1c:
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L2a7
            if (r0 != 0) goto L2c0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L2a7
            android.content.Context r2 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L2a7
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L2a7
            java.lang.String r3 = ".tmp"
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L2a7
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L2a7
            if (r2 != 0) goto L39
            r0.mkdir()     // Catch: java.lang.Throwable -> L2a7
        L39:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L2a7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a7
            r3.<init>()     // Catch: java.lang.Throwable -> L2a7
            java.lang.StringBuilder r3 = r3.append(r10)     // Catch: java.lang.Throwable -> L2a7
            java.lang.String r6 = "-"
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch: java.lang.Throwable -> L2a7
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch: java.lang.Throwable -> L2a7
            java.lang.String r6 = ".zip"
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch: java.lang.Throwable -> L2a7
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L2a7
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L2a7
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2ac
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2ac
            android.content.Context r0 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L2b3
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> L2b3
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L2b3
            java.io.InputStream r1 = r0.open(r6)     // Catch: java.lang.Throwable -> L2b3
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L80
        L74:
            int r6 = r1.read(r0)     // Catch: java.lang.Throwable -> L80
            r7 = -1
            if (r6 == r7) goto L106
            r7 = 0
            r3.write(r0, r7, r6)     // Catch: java.lang.Throwable -> L80
            goto L74
        L80:
            r0 = move-exception
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
        L85:
            com.baidu.sofire.b.d.a(r0)     // Catch: java.lang.Throwable -> L2a3
            if (r1 == 0) goto L273
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L2a3
            if (r0 == 0) goto L273
            com.baidu.sofire.c.a(r1)     // Catch: java.lang.Throwable -> L2a3
            com.baidu.sofire.a.a r0 = r9.aGA     // Catch: java.lang.Throwable -> L2a3
            r0.h(r10)     // Catch: java.lang.Throwable -> L2a3
            r1.delete()     // Catch: java.lang.Throwable -> L2a3
            if (r3 == 0) goto La0
            r3.close()     // Catch: java.io.IOException -> L26d
        La0:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> La7
            goto L13
        La7:
            r0 = move-exception
            r0.getMessage()
            goto L13
        Lad:
            com.baidu.sofire.a.a r2 = r9.aGA     // Catch: java.lang.Throwable -> Lfa
            r2.h(r10)     // Catch: java.lang.Throwable -> Lfa
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r0 = r0.pkgPath     // Catch: java.lang.Throwable -> Lfa
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfa
            r0.<init>()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r3 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r3 = ", e="
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lfa
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> Lfa
            r0.append(r3)     // Catch: java.lang.Throwable -> Lfa
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> Lfa
            if (r0 == 0) goto L1c
            com.baidu.sofire.c.a(r2)     // Catch: java.lang.Throwable -> Lfa
            boolean r0 = r2.delete()     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfa
            r3.<init>()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r3 = " s="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lfa
            r2.append(r0)     // Catch: java.lang.Throwable -> Lfa
            goto L1c
        Lfa:
            r0 = move-exception
            com.baidu.sofire.b.d.a(r0)     // Catch: java.lang.Throwable -> L100
            goto L1c
        L100:
            r0 = move-exception
            com.baidu.sofire.b.d.a(r0)
            goto L1c
        L106:
            r3.flush()     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6 = 1
            com.baidu.sofire.b.d.a(r0, r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "f: "
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = ", l="
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch: java.lang.Throwable -> L80
            long r6 = r2.length()     // Catch: java.lang.Throwable -> L80
            r0.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = com.baidu.sofire.b.l.a(r2)     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L13b
            boolean r6 = r0.equalsIgnoreCase(r12)     // Catch: java.lang.Throwable -> L80
            if (r6 != 0) goto L153
        L13b:
            r2.delete()     // Catch: java.lang.Throwable -> L80
            if (r1 == 0) goto L143
            r1.close()     // Catch: java.io.IOException -> L14e
        L143:
            r3.close()     // Catch: java.io.IOException -> L148
            goto L13
        L148:
            r0 = move-exception
            r0.getMessage()
            goto L13
        L14e:
            r0 = move-exception
            r0.getMessage()
            goto L143
        L153:
            com.baidu.sofire.core.ApkInfo r6 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6.<init>(r10, r11, r7)     // Catch: java.lang.Throwable -> L80
            r6.apkMD5 = r0     // Catch: java.lang.Throwable -> L80
            r0 = 1
            r6.priority = r0     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.a.a r0 = r9.aGA     // Catch: java.lang.Throwable -> L80
            r0.a(r6)     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.a.a r0 = r9.aGA     // Catch: java.lang.Throwable -> L80
            int r0 = r0.dZ(r10)     // Catch: java.lang.Throwable -> L80
            r6 = 3
            if (r0 != r6) goto L2bd
            r0 = r4
        L170:
            com.baidu.sofire.e r4 = r9.aGz     // Catch: java.lang.Throwable -> L80
            android.content.SharedPreferences r4 = r4.a     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = "bka"
            r6 = 1
            boolean r4 = r4.getBoolean(r5, r6)     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L1e8
            if (r0 == 0) goto L1e8
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L80
            android.content.Context r4 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L80
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = ".b"
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L80
            boolean r4 = r0.exists()     // Catch: java.lang.Throwable -> L80
            if (r4 != 0) goto L197
            r0.mkdir()     // Catch: java.lang.Throwable -> L80
        L197:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L80
            r4.<init>(r0, r5)     // Catch: java.lang.Throwable -> L80
            boolean r0 = com.baidu.sofire.b.d.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r0 != 0) goto L1bd
            com.baidu.sofire.b.d.a(r2, r4)     // Catch: java.lang.Throwable -> L80
        L1bd:
            android.content.Context r0 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a(r0, r10, r2, r4)     // Catch: java.lang.Throwable -> L80
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
        L1c6:
            com.baidu.sofire.a.a r0 = r9.aGA     // Catch: java.lang.Throwable -> L2ba
            com.baidu.sofire.core.ApkInfo r0 = r0.dW(r10)     // Catch: java.lang.Throwable -> L2ba
            if (r0 == 0) goto L1d6
            java.lang.String r0 = r0.pkgPath     // Catch: java.lang.Throwable -> L2ba
            boolean r0 = com.baidu.sofire.b.d.a(r0)     // Catch: java.lang.Throwable -> L2ba
            if (r0 != 0) goto L247
        L1d6:
            if (r3 == 0) goto L1db
            r3.close()     // Catch: java.io.IOException -> L242
        L1db:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L1e2
            goto L13
        L1e2:
            r0 = move-exception
            r0.getMessage()
            goto L13
        L1e8:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L80
            android.content.Context r4 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L80
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = ".b"
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L80
            boolean r4 = r0.exists()     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L23d
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L80
            r4.<init>(r0, r5)     // Catch: java.lang.Throwable -> L80
            boolean r0 = com.baidu.sofire.b.d.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L23d
            com.baidu.sofire.c.a(r4)     // Catch: java.lang.Throwable -> L80
            boolean r0 = r4.delete()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = " s="
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L80
            r4.append(r0)     // Catch: java.lang.Throwable -> L80
        L23d:
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
            goto L1c6
        L242:
            r0 = move-exception
            r0.getMessage()
            goto L1db
        L247:
            boolean r0 = r9.a(r10, r11, r13)     // Catch: java.lang.Throwable -> L2ba
            if (r0 == 0) goto L256
            java.util.List<java.lang.Integer> r0 = com.baidu.sofire.core.c.d     // Catch: java.lang.Throwable -> L2ba
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L2ba
            r0.add(r4)     // Catch: java.lang.Throwable -> L2ba
        L256:
            if (r3 == 0) goto L25b
            r3.close()     // Catch: java.io.IOException -> L268
        L25b:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L262
            goto L13
        L262:
            r0 = move-exception
            r0.getMessage()
            goto L13
        L268:
            r0 = move-exception
            r0.getMessage()
            goto L25b
        L26d:
            r0 = move-exception
            r0.getMessage()
            goto La0
        L273:
            if (r3 == 0) goto L278
            r3.close()     // Catch: java.io.IOException -> L285
        L278:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L27f
            goto L13
        L27f:
            r0 = move-exception
            r0.getMessage()
            goto L13
        L285:
            r0 = move-exception
            r0.getMessage()
            goto L278
        L28a:
            r0 = move-exception
            r3 = r1
        L28c:
            if (r1 == 0) goto L291
            r1.close()     // Catch: java.io.IOException -> L297
        L291:
            if (r3 == 0) goto L296
            r3.close()     // Catch: java.io.IOException -> L29c
        L296:
            throw r0
        L297:
            r1 = move-exception
            r1.getMessage()
            goto L291
        L29c:
            r1 = move-exception
            r1.getMessage()
            goto L296
        L2a1:
            r0 = move-exception
            goto L28c
        L2a3:
            r0 = move-exception
            r1 = r3
            r3 = r2
            goto L28c
        L2a7:
            r0 = move-exception
            r2 = r1
            r3 = r1
            goto L85
        L2ac:
            r0 = move-exception
            r3 = r1
            r8 = r1
            r1 = r2
            r2 = r8
            goto L85
        L2b3:
            r0 = move-exception
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
            goto L85
        L2ba:
            r0 = move-exception
            goto L85
        L2bd:
            r0 = r5
            goto L170
        L2c0:
            r2 = r1
            r3 = r1
            goto L1c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.c.a(int, java.lang.String, java.lang.String, android.content.pm.PackageInfo):void");
    }

    public final synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        return a(i, str, false, packageInfo);
    }

    private synchronized boolean a(int i, String str, boolean z, PackageInfo packageInfo) {
        boolean z2;
        String str2;
        String str3;
        try {
            new StringBuilder().append(i);
            if (z && this.aGA.c(i) != 1) {
                z2 = false;
            } else {
                ApkInfo dW = this.aGA.dW(i);
                if (dW == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", String.valueOf(i));
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.b.d.a(b, "1003105", hashMap);
                    }
                    z2 = false;
                } else {
                    File file = new File(dW.pkgPath);
                    file.getAbsolutePath();
                    if (!com.baidu.sofire.b.d.a(file)) {
                        this.aGA.f(i);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("0", 3);
                        hashMap2.put("1", String.valueOf(i));
                        hashMap2.put("2", str);
                        if (!z) {
                            com.baidu.sofire.b.d.a(b, "1003105", hashMap2);
                        }
                        z2 = false;
                    } else {
                        if (packageInfo != null) {
                            dW.cloudPkgInfo = packageInfo;
                        }
                        e aD = e.aD(b.getApplicationContext());
                        if (!aD.a(dW, false)) {
                            this.aGA.f(i);
                            aD.a(dW.pkgPath);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("0", 4);
                            hashMap3.put("1", String.valueOf(i));
                            hashMap3.put("2", str);
                            if (!z) {
                                com.baidu.sofire.b.d.a(b, "1003105", hashMap3);
                            }
                            z2 = false;
                        } else {
                            String[] e = com.baidu.sofire.b.d.e(b);
                            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                                String str4 = e[0];
                                str2 = e[1];
                                str3 = str4;
                            } else {
                                str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                                str3 = "3";
                            }
                            new StringBuilder("ak=").append(str3).append(", sk=").append(str2);
                            ApkInfo ci = aD.ci(dW.pkgPath);
                            d dVar = (d) ci.classLoader;
                            Class<?> cl = dVar.cl("com.baidu.sofire.engine.EngineImpl");
                            if (cl == null) {
                                Class<?> cl2 = dVar.cl("java.lang.String");
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("0", 9);
                                hashMap4.put("1", String.valueOf(i));
                                hashMap4.put("2", str);
                                hashMap4.put("3", Base64.encodeToString(("classloader=" + dVar + ",StringClass=" + cl2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                if (!z) {
                                    com.baidu.sofire.b.d.a(b, "1003105", hashMap4);
                                }
                                this.aGA.f(i);
                                z2 = false;
                            } else {
                                Object invoke = cl.getDeclaredMethod("getInstance", Context.class).invoke(cl, b);
                                new StringBuilder("ai=").append(invoke);
                                com.baidu.sofire.b.d.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str2);
                                if (!((Boolean) com.baidu.sofire.b.d.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.aGz.a.getBoolean("hac", false)))).booleanValue()) {
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put("0", 6);
                                    hashMap5.put("1", String.valueOf(i));
                                    hashMap5.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.b.d.a(b, "1003105", hashMap5);
                                    }
                                    this.aGA.f(i);
                                    aD.a(ci.pkgPath);
                                    z2 = false;
                                } else {
                                    ci.initStatus = 1;
                                    ci.apkParseSuc = 1;
                                    this.aGA.a(ci);
                                    int dZ = this.aGA.dZ(ci.key);
                                    new StringBuilder("plugin now loadStatus :").append(ci.key).append(" ").append(dZ);
                                    if (dZ < 3 && dZ != -1) {
                                        this.aGA.b(ci.key, dZ + 1);
                                    }
                                    HashMap hashMap6 = new HashMap();
                                    hashMap6.put("0", 0);
                                    hashMap6.put("1", Integer.valueOf(i));
                                    hashMap6.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.b.d.a(b, "1003105", hashMap6);
                                    }
                                    com.baidu.sofire.b.d.a(b);
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            z2 = false;
        }
        return z2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0035: IGET  (r4v42 int A[REMOVE]) = (r13v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0131: IGET  (r4v40 int A[REMOVE]) = (r13v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01cd: IGET  (r7v4 int A[REMOVE]) = (r13v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02e8: IGET  (r4v25 int A[REMOVE]) = (r13v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0346: IGET  (r5v1 int A[REMOVE]) = (r13v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x043a: IGET  (r4v20 int A[REMOVE]) = (r13v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    public final boolean a(ApkInfo apkInfo, String str) {
        String str2;
        String str3;
        new StringBuilder().append(apkInfo);
        if (apkInfo == null) {
            return false;
        }
        File file = new File(apkInfo.pkgPath);
        try {
            if (!com.baidu.sofire.b.d.a(file)) {
                HashMap hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap.put("2", apkInfo.versionName);
                hashMap.put("3", Base64.encodeToString(("nowTime:" + System.currentTimeMillis() + ", nowFileInfo: path=" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length() + " - " + str).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.d.a(b, "1003106", hashMap);
                return false;
            }
            if (!this.aGA.b(apkInfo.key)) {
                this.aGA.a(apkInfo);
            }
            e aD = e.aD(b.getApplicationContext());
            this.aGA.a(apkInfo.key, 1);
            a(apkInfo.packageName);
            if (!aD.a(apkInfo, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                hashMap2.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap2.put("2", apkInfo.versionName);
                com.baidu.sofire.b.d.a(b, "1003106", hashMap2);
                com.baidu.sofire.c.a(file);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.aGA.a(apkInfo.key, 0);
                return false;
            }
            String[] e = com.baidu.sofire.b.d.e(b);
            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                str2 = e[0];
                str3 = e[1];
            } else {
                str2 = "3";
                str3 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            ApkInfo ci = aD.ci(apkInfo.pkgPath);
            if (ci == null) {
                return false;
            }
            d dVar = (d) ci.classLoader;
            Class<?> cl = dVar.cl("com.baidu.sofire.engine.EngineImpl");
            if (cl == null) {
                Class<?> cl2 = dVar.cl("java.lang.String");
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 6);
                hashMap3.put("1", new StringBuilder().append(ci.key).toString());
                hashMap3.put("2", ci.versionName);
                hashMap3.put("3", Base64.encodeToString(("classloader=" + dVar + ",StringClass=" + cl2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.d.a(b, "1003106", hashMap3);
                com.baidu.sofire.c.a(file);
                file.delete();
                this.aGA.a(ci.key, 0);
                return false;
            }
            Object invoke = cl.getDeclaredMethod("getInstance", Context.class).invoke(cl, b);
            com.baidu.sofire.b.d.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
            if (!((Boolean) com.baidu.sofire.b.d.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.aGz.a.getBoolean("hac", false)))).booleanValue()) {
                com.baidu.sofire.c.a(file);
                a(ci.packageName);
                file.delete();
                a(ci.key, ci.versionName, true, (PackageInfo) null);
                this.aGA.a(ci.key, 0);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("0", 4);
                hashMap4.put("1", new StringBuilder().append(ci.key).toString());
                hashMap4.put("2", ci.versionName);
                com.baidu.sofire.b.d.a(b, "1003106", hashMap4);
                return false;
            }
            if (ci.isMem) {
                com.baidu.sofire.c.a(file);
                file.delete();
                com.baidu.sofire.b.d.b(ci.dataDir);
                if (e.b != null) {
                    e.b.add(Integer.valueOf(ci.key));
                }
            }
            try {
                ApkInfo dW = this.aGA.dW(ci.key);
                new StringBuilder().append(dW);
                File file2 = (dW == null || dW.versionName.equals(ci.versionName)) ? null : new File(dW.pkgPath);
                ci.initStatus = 1;
                ci.apkParseSuc = 1;
                long a = this.aGA.a(ci);
                if (a > 0 && file2 != null && file2.exists()) {
                    com.baidu.sofire.c.a(file2);
                    new StringBuilder().append(file2.delete());
                }
                new StringBuilder().append(a).append(", c=").append(this.aGA.a(ci.key, 0));
                com.baidu.sofire.b.d.a(b);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("0", 0);
                hashMap5.put("1", new StringBuilder().append(ci.key).toString());
                hashMap5.put("2", ci.versionName);
                com.baidu.sofire.b.d.a(b, "1003106", hashMap5);
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
            }
            return true;
        } catch (Throwable th2) {
            try {
                th2.getMessage();
                com.baidu.sofire.c.a(file);
                a(apkInfo.packageName);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.aGA.a(apkInfo.key, 0);
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 5);
                hashMap6.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap6.put("2", apkInfo.versionName);
                hashMap6.put("3", Base64.encodeToString(com.baidu.sofire.b.a(th2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.d.a(b, "1003106", hashMap6);
            } catch (Throwable th3) {
                com.baidu.sofire.b.d.a(th3);
            }
            return false;
        }
    }

    public final Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        new StringBuilder().append(str);
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.toString(i));
        hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
        hashMap.put("2", "1");
        com.baidu.sofire.b.d.a(b, "1003136", hashMap);
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            boolean dX = this.aGA.dX(i);
            new StringBuilder().append(dX);
            if (dX) {
                return new Pair<>(3, null);
            }
            if (!this.e) {
                return new Pair<>(3, null);
            }
            e vF = e.vF();
            if (vF == null) {
                return new Pair<>(3, null);
            }
            ApkInfo dW = this.aGA.dW(i);
            if (!((dW == null || vF.cm(dW.packageName) == null) ? false : true)) {
                return new Pair<>(4, null);
            }
            Class<?> cl = ((d) vF.cm(dW.packageName).classLoader).cl("com.baidu.sofire.engine.EngineImpl");
            Object a = com.baidu.sofire.b.d.a(cl.getDeclaredMethod("getInstance", Context.class).invoke(cl, b), str, clsArr, objArr);
            try {
                new StringBuilder().append(a);
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
            }
            return new Pair<>(0, a);
        } catch (IllegalAccessException e) {
            e.getMessage();
            return new Pair<>(2, null);
        } catch (IllegalArgumentException e2) {
            e2.getMessage();
            return new Pair<>(2, null);
        } catch (NoSuchMethodException e3) {
            e3.getMessage();
            return new Pair<>(2, null);
        } catch (InvocationTargetException e4) {
            e4.getMessage();
            return new Pair<>(2, null);
        } catch (Throwable th2) {
            th2.getMessage();
            return new Pair<>(3, null);
        }
    }

    private static void a(String str) {
        e vF;
        ApkInfo cm;
        new StringBuilder().append(str);
        try {
            if (!TextUtils.isEmpty(str) && (vF = e.vF()) != null && (cm = vF.cm(str)) != null) {
                Class<?> cl = ((d) cm.classLoader).cl("com.baidu.sofire.engine.EngineImpl");
                Object invoke = cl.getDeclaredMethod("getInstance", Context.class).invoke(cl, b);
                if (invoke != null) {
                    new StringBuilder().append(com.baidu.sofire.b.d.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                    vF.b(str);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* renamed from: com.baidu.sofire.core.c$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass4 extends Thread {
        final /* synthetic */ String a;

        public AnonymousClass4(String str) {
            this.a = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                if (!TextUtils.isEmpty(this.a)) {
                    final e aD = e.aD(c.b.getApplicationContext());
                    new StringBuilder().append(this.a).append(", h=").append(aD);
                    if (aD != null) {
                        final ApkInfo cm = aD.cm(this.a);
                        new StringBuilder().append(this.a).append(", i=").append(cm);
                        if (cm == null) {
                            ApkInfo ci = c.this.aGA.ci(this.a);
                            c cVar = c.this;
                            String str = this.a;
                            String str2 = ci.pkgPath;
                            cVar.aGA.a(str);
                            File file = new File(str2);
                            new StringBuilder("f=").append(file.getAbsolutePath()).append(", e=").append(file.exists());
                            if (file.exists()) {
                                com.baidu.sofire.c.a(file);
                                new StringBuilder().append(file.getAbsolutePath()).append(" s=").append(file.delete());
                            }
                        } else {
                            Class<?> cl = ((d) cm.classLoader).cl("com.baidu.sofire.engine.EngineImpl");
                            Object invoke = cl.getDeclaredMethod("getInstance", Context.class).invoke(cl, c.b);
                            new StringBuilder().append(this.a).append(", i=").append(invoke);
                            if (invoke != null) {
                                new StringBuilder("t:").append(System.currentTimeMillis());
                                new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.core.c.4.1
                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public final void run() {
                                        new StringBuilder().append(System.currentTimeMillis());
                                        aD.b(AnonymousClass4.this.a);
                                        c.this.aGA.a(AnonymousClass4.this.a);
                                        File file2 = new File(cm.pkgPath);
                                        new StringBuilder("f=").append(file2.getAbsolutePath()).append(", e=").append(file2.exists());
                                        if (file2.exists()) {
                                            com.baidu.sofire.c.a(file2);
                                            new StringBuilder("d: ").append(file2.getAbsolutePath()).append(" s=").append(file2.delete());
                                        }
                                    }
                                }, 600000L);
                                new StringBuilder().append(this.a).append(", CommonMethods.callMethodOfClass result object=").append(com.baidu.sofire.b.d.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                                aD.b(this.a);
                                c.this.aGA.a(this.a);
                                File file2 = new File(cm.pkgPath);
                                new StringBuilder("f=").append(file2.getAbsolutePath()).append(", e=").append(file2.exists());
                                if (file2.exists()) {
                                    com.baidu.sofire.c.a(file2);
                                    new StringBuilder("d: ").append(file2.getAbsolutePath()).append(" s=").append(file2.delete());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public static void a(int i) {
        if (g == 0) {
            g = i;
        }
    }

    public final boolean c() {
        this.aGA.d();
        this.e = true;
        return c(b);
    }

    private boolean c(Context context) {
        try {
            e aD = e.aD(context);
            if (aD == null) {
                return false;
            }
            if (aD.cm("com.baidu.sofire.x18") != null) {
                return true;
            }
            if (this.aGA == null) {
                this.aGA = com.baidu.sofire.a.a.ay(b);
            }
            ApkInfo ci = this.aGA.ci("com.baidu.sofire.x18");
            new StringBuilder("push::").append(ci);
            if (ci != null) {
                if (this.aGz.a.getBoolean("bka", true)) {
                    File file = new File(b.getFilesDir(), ".b");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(ci.pkgPath);
                    File file3 = new File(file, ci.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ci.versionName);
                    if (!com.baidu.sofire.b.d.a(file3)) {
                        com.baidu.sofire.b.d.a(file2, file3);
                    }
                    com.baidu.sofire.c.a(b, ci.key, file2, file3);
                }
                if (a(ci.key, ci.versionName, null)) {
                    return true;
                }
            }
            return aD.cm("com.baidu.sofire.x18") != null;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }
}
