package com.baidu.sofire.core;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.rp.Report;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
public class d implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static Context a;
    private static d d;
    private volatile boolean c = false;
    private com.baidu.sofire.e e;
    private com.baidu.sofire.g f;
    private com.baidu.sofire.a.a h;
    private static int g = 0;
    public static List<Integer> b = new ArrayList();

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            try {
                if (str.equals("xytk")) {
                    com.baidu.sofire.b.a("xytk changed!");
                    e.a = this.f.a();
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }

    private d(Context context) {
        com.baidu.sofire.b.a("ForHostApp Constructor");
        a = context.getApplicationContext();
        this.h = com.baidu.sofire.a.a.a(a);
        this.e = new com.baidu.sofire.e(a);
        this.f = new com.baidu.sofire.g(a);
        this.f.a(this);
    }

    public static d a() {
        return d;
    }

    public void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!"3".equals(str) || !"925fc15df8a49bed0b3eca8d2b44cb7b".equals(str2)) {
                    this.e.b(str, str2);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!"3".equals(str) || !"925fc15df8a49bed0b3eca8d2b44cb7b".equals(str2)) {
                    com.baidu.sofire.b.e.a(str, str2);
                    this.e.a(str, str2);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (d == null) {
                d = new d(context.getApplicationContext());
            }
            dVar = d;
        }
        return dVar;
    }

    public void b() {
        a((Callback) null);
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.baidu.sofire.core.d$1] */
    public synchronized void a(final Callback callback) {
        String str;
        com.baidu.sofire.b.e.d(a);
        com.baidu.sofire.b.a("initCalledByHost=" + this.c);
        if (this.c) {
            if (callback != null) {
                callback.onEnd(new Object[0]);
            }
        } else {
            this.c = true;
            this.e.h("3.1.8");
            Report.getInstance(a).n();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            a.registerReceiver(new MyReceiver(), intentFilter);
            for (ApkInfo apkInfo : this.h.b()) {
                try {
                    str = a.getFilesDir().getCanonicalPath();
                } catch (IOException e) {
                    com.baidu.sofire.b.e.a(e);
                    str = null;
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/." + apkInfo.key;
                    com.baidu.sofire.b.e.d(apkInfo.dataDir + "/lib");
                }
            }
            new Thread() { // from class: com.baidu.sofire.core.d.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                        d.this.h.e();
                        com.baidu.sofire.b.a("init Thread run");
                        com.baidu.sofire.b.a("preferences.isInitOnce()=" + d.this.e.b());
                        if (!d.this.e.b()) {
                            d.this.e.a(true);
                        } else {
                            d.this.h.f();
                        }
                        new U(d.a, 1, false).start();
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                    } catch (Throwable th) {
                        com.baidu.sofire.b.e.a(th);
                    }
                }
            }.start();
        }
    }

    public void c() {
        try {
            List<ApkInfo> b2 = this.h.b();
            com.baidu.sofire.b.a("all=" + b2);
            final List<Integer> C = this.e.C();
            List<Integer> B = this.e.B();
            for (int i = 0; i < B.size(); i++) {
                if (!C.contains(B.get(i))) {
                    C.add(B.get(i));
                }
            }
            Collections.sort(b2, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.core.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(ApkInfo apkInfo, ApkInfo apkInfo2) {
                    if (apkInfo.priority != -1 || apkInfo2.priority == -1) {
                        if ((apkInfo.priority == -1 || apkInfo2.priority != -1) && apkInfo.priority >= apkInfo2.priority) {
                            if (apkInfo.priority > apkInfo2.priority) {
                                return 1;
                            }
                            int indexOf = (C == null || !C.contains(Integer.valueOf(apkInfo.key))) ? -1 : C.indexOf(Integer.valueOf(apkInfo.key));
                            int indexOf2 = (C == null || !C.contains(Integer.valueOf(apkInfo2.key))) ? -1 : C.indexOf(Integer.valueOf(apkInfo2.key));
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
            for (ApkInfo apkInfo : b2) {
                g a2 = g.a();
                if ((a2 != null ? a2.d(apkInfo.packageName) : null) == null) {
                    boolean z = true;
                    if (this.h.f(apkInfo.key) == 3) {
                        com.baidu.sofire.b.a("load plugin can remove the backup!used!");
                        z = false;
                    }
                    if (this.e.f() && z) {
                        File file = new File(a.getFilesDir(), ".b");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(apkInfo.pkgPath);
                        File file3 = new File(file, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                        if (!com.baidu.sofire.b.e.a(file3)) {
                            com.baidu.sofire.b.e.a(file2, file3);
                        }
                        com.baidu.sofire.c.a(a, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(a.getFilesDir(), ".b");
                        if (file4.exists()) {
                            File file5 = new File(file4, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                            if (com.baidu.sofire.b.e.a(file5)) {
                                com.baidu.sofire.c.a(file5);
                                com.baidu.sofire.b.a("remove the backup file: " + file5.getAbsolutePath() + " s=" + file5.delete());
                            }
                        }
                    }
                    a(apkInfo.key, apkInfo.versionName, (PackageInfo) null);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public void b(Context context) {
        try {
            if (!this.e.E()) {
                JSONArray jSONArray = new JSONArray(com.baidu.sofire.b.e.a(context, "sofire_local.cfg", "local"));
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
                    String optString3 = optJSONObject.optString(ARResourceKey.HTTP_AR_MD5);
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
                this.e.a(arrayList);
                if (hashMap.size() <= 0) {
                    this.e.c(true);
                    return;
                }
                String str = com.baidu.sofire.b.e.e(a) + "p/1/pio";
                JSONArray jSONArray2 = new JSONArray();
                for (ApkInfo apkInfo2 : hashMap.values()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PushConstants.URI_PACKAGE_NAME, apkInfo2.packageName);
                    jSONObject.put(Config.MODEL, apkInfo2.apkMD5);
                    jSONObject.put("l", apkInfo2.key);
                    jSONObject.put("v", apkInfo2.versionName);
                    jSONArray2.put(jSONObject);
                }
                String jSONArray3 = jSONArray2.toString();
                com.baidu.sofire.b.a(jSONArray3);
                String a2 = com.baidu.sofire.b.h.a(context, str, jSONArray3, false, true, "");
                com.baidu.sofire.b.a("check local:after java decrypt ResponseDataJsonString=" + a2);
                JSONArray jSONArray4 = new JSONArray(a2);
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    this.e.c(true);
                }
                for (int i2 = 0; i2 < jSONArray4.length(); i2++) {
                    JSONObject optJSONObject2 = jSONArray4.optJSONObject(i2);
                    int optInt2 = optJSONObject2.optInt("errno");
                    int optInt3 = optJSONObject2.optInt("l");
                    if (optInt2 == 1) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detail");
                        PackageInfo packageInfo = new PackageInfo();
                        packageInfo.packageName = optJSONObject3.optString("p");
                        packageInfo.versionName = optJSONObject3.optString("v");
                        ApplicationInfo applicationInfo = new ApplicationInfo();
                        applicationInfo.className = optJSONObject3.optString("n");
                        if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(".")) {
                            applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                        }
                        applicationInfo.theme = optJSONObject3.optInt("t");
                        packageInfo.applicationInfo = applicationInfo;
                        JSONArray optJSONArray = optJSONObject3.optJSONArray(Config.APP_VERSION_CODE);
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
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
                                        arrayList2.add(activityInfo);
                                    }
                                }
                            }
                            if (arrayList2.size() > 0) {
                                packageInfo.activities = (ActivityInfo[]) arrayList2.toArray(new ActivityInfo[arrayList2.size()]);
                            }
                        }
                        ApkInfo apkInfo3 = (ApkInfo) hashMap.get(Integer.valueOf(optInt3));
                        if (apkInfo3 != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                            a(apkInfo3.key, apkInfo3.versionName, apkInfo3.apkMD5, packageInfo);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [565=7, 567=6, 571=6, 573=6, 574=6] */
    private void a(int r10, java.lang.String r11, java.lang.String r12, android.content.pm.PackageInfo r13) {
        /*
            r9 = this;
            r4 = 0
            r1 = 0
            r5 = 1
            com.baidu.sofire.a.a r0 = r9.h     // Catch: java.lang.Throwable -> La5
            com.baidu.sofire.core.ApkInfo r0 = r0.a(r10)     // Catch: java.lang.Throwable -> La5
            if (r0 == 0) goto L17
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> La5
            boolean r0 = com.baidu.sofire.b.e.d(r11, r0)     // Catch: java.lang.Throwable -> La5
            if (r0 != 0) goto L14
        L13:
            return
        L14:
            r9.a(r10)     // Catch: java.lang.Throwable -> La5
        L17:
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L1f9
            if (r0 != 0) goto L218
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L1f9
            android.content.Context r2 = com.baidu.sofire.core.d.a     // Catch: java.lang.Throwable -> L1f9
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L1f9
            java.lang.String r3 = ".tmp"
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L1f9
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L1f9
            if (r2 != 0) goto L34
            r0.mkdir()     // Catch: java.lang.Throwable -> L1f9
        L34:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L1f9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f9
            r3.<init>()     // Catch: java.lang.Throwable -> L1f9
            java.lang.StringBuilder r3 = r3.append(r10)     // Catch: java.lang.Throwable -> L1f9
            java.lang.String r6 = "-"
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch: java.lang.Throwable -> L1f9
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch: java.lang.Throwable -> L1f9
            java.lang.String r6 = ".zip"
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch: java.lang.Throwable -> L1f9
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L1f9
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L1f9
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1fe
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L1fe
            android.content.Context r0 = com.baidu.sofire.core.d.a     // Catch: java.lang.Throwable -> L205
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> L205
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L205
            java.io.InputStream r1 = r0.open(r6)     // Catch: java.lang.Throwable -> L205
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L7b
        L6f:
            int r6 = r1.read(r0)     // Catch: java.lang.Throwable -> L7b
            r7 = -1
            if (r6 == r7) goto Lab
            r7 = 0
            r3.write(r0, r7, r6)     // Catch: java.lang.Throwable -> L7b
            goto L6f
        L7b:
            r0 = move-exception
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
        L80:
            com.baidu.sofire.b.e.a(r0)     // Catch: java.lang.Throwable -> L1f5
            if (r1 == 0) goto L1c6
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L1f5
            if (r0 == 0) goto L1c6
            com.baidu.sofire.c.a(r1)     // Catch: java.lang.Throwable -> L1f5
            com.baidu.sofire.a.a r0 = r9.h     // Catch: java.lang.Throwable -> L1f5
            r0.g(r10)     // Catch: java.lang.Throwable -> L1f5
            r1.delete()     // Catch: java.lang.Throwable -> L1f5
            if (r3 == 0) goto L9b
            r3.close()     // Catch: java.io.IOException -> L1ea
        L9b:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> La2
            goto L13
        La2:
            r0 = move-exception
            goto L13
        La5:
            r0 = move-exception
            com.baidu.sofire.b.e.a(r0)
            goto L17
        Lab:
            r3.flush()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L7b
            r6 = 1
            com.baidu.sofire.b.e.a(r0, r6)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = com.baidu.sofire.b.o.a(r2)     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto Lc2
            boolean r6 = r0.equalsIgnoreCase(r12)     // Catch: java.lang.Throwable -> L7b
            if (r6 != 0) goto Ld4
        Lc2:
            r2.delete()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto Lca
            r1.close()     // Catch: java.io.IOException -> L1e2
        Lca:
            if (r3 == 0) goto L13
            r3.close()     // Catch: java.io.IOException -> Ld1
            goto L13
        Ld1:
            r0 = move-exception
            goto L13
        Ld4:
            com.baidu.sofire.core.ApkInfo r6 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L7b
            java.lang.String r7 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L7b
            r6.<init>(r10, r11, r7)     // Catch: java.lang.Throwable -> L7b
            r6.apkMD5 = r0     // Catch: java.lang.Throwable -> L7b
            r0 = 1
            r6.priority = r0     // Catch: java.lang.Throwable -> L7b
            com.baidu.sofire.a.a r0 = r9.h     // Catch: java.lang.Throwable -> L7b
            r0.a(r6)     // Catch: java.lang.Throwable -> L7b
            com.baidu.sofire.a.a r0 = r9.h     // Catch: java.lang.Throwable -> L7b
            int r0 = r0.f(r10)     // Catch: java.lang.Throwable -> L7b
            r6 = 3
            if (r0 != r6) goto L215
            java.lang.String r0 = "local load plugin can remove the backup!"
            com.baidu.sofire.b.a(r0)     // Catch: java.lang.Throwable -> L7b
            r0 = r4
        Lf7:
            com.baidu.sofire.e r4 = r9.e     // Catch: java.lang.Throwable -> L7b
            boolean r4 = r4.f()     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L166
            if (r0 == 0) goto L166
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L7b
            android.content.Context r4 = com.baidu.sofire.core.d.a     // Catch: java.lang.Throwable -> L7b
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = ".b"
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L7b
            boolean r4 = r0.exists()     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L118
            r0.mkdir()     // Catch: java.lang.Throwable -> L7b
        L118:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            r5.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L7b
            r4.<init>(r0, r5)     // Catch: java.lang.Throwable -> L7b
            boolean r0 = com.baidu.sofire.b.e.a(r4)     // Catch: java.lang.Throwable -> L7b
            if (r0 != 0) goto L13e
            com.baidu.sofire.b.e.a(r2, r4)     // Catch: java.lang.Throwable -> L7b
        L13e:
            android.content.Context r0 = com.baidu.sofire.core.d.a     // Catch: java.lang.Throwable -> L7b
            com.baidu.sofire.c.a(r0, r10, r2, r4)     // Catch: java.lang.Throwable -> L7b
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
        L147:
            com.baidu.sofire.a.a r0 = r9.h     // Catch: java.lang.Throwable -> L20c
            com.baidu.sofire.core.ApkInfo r0 = r0.a(r10)     // Catch: java.lang.Throwable -> L20c
            if (r0 == 0) goto L157
            java.lang.String r0 = r0.pkgPath     // Catch: java.lang.Throwable -> L20c
            boolean r0 = com.baidu.sofire.b.e.c(r0)     // Catch: java.lang.Throwable -> L20c
            if (r0 != 0) goto L1a8
        L157:
            if (r3 == 0) goto L15c
            r3.close()     // Catch: java.io.IOException -> L1e5
        L15c:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L163
            goto L13
        L163:
            r0 = move-exception
            goto L13
        L166:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L7b
            android.content.Context r4 = com.baidu.sofire.core.d.a     // Catch: java.lang.Throwable -> L7b
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = ".b"
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L7b
            boolean r4 = r0.exists()     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L20f
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            r5.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L7b
            r4.<init>(r0, r5)     // Catch: java.lang.Throwable -> L7b
            boolean r0 = com.baidu.sofire.b.e.a(r4)     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L20f
            com.baidu.sofire.c.a(r4)     // Catch: java.lang.Throwable -> L7b
            r4.delete()     // Catch: java.lang.Throwable -> L7b
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
            goto L147
        L1a8:
            boolean r0 = r9.a(r10, r11, r13)     // Catch: java.lang.Throwable -> L20c
            if (r0 == 0) goto L1b7
            java.util.List<java.lang.Integer> r0 = com.baidu.sofire.core.d.b     // Catch: java.lang.Throwable -> L20c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L20c
            r0.add(r4)     // Catch: java.lang.Throwable -> L20c
        L1b7:
            if (r3 == 0) goto L1bc
            r3.close()     // Catch: java.io.IOException -> L1e8
        L1bc:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L1c3
            goto L13
        L1c3:
            r0 = move-exception
            goto L13
        L1c6:
            if (r3 == 0) goto L1cb
            r3.close()     // Catch: java.io.IOException -> L1ed
        L1cb:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L1d2
            goto L13
        L1d2:
            r0 = move-exception
            goto L13
        L1d5:
            r0 = move-exception
            r3 = r1
        L1d7:
            if (r1 == 0) goto L1dc
            r1.close()     // Catch: java.io.IOException -> L1ef
        L1dc:
            if (r3 == 0) goto L1e1
            r3.close()     // Catch: java.io.IOException -> L1f1
        L1e1:
            throw r0
        L1e2:
            r0 = move-exception
            goto Lca
        L1e5:
            r0 = move-exception
            goto L15c
        L1e8:
            r0 = move-exception
            goto L1bc
        L1ea:
            r0 = move-exception
            goto L9b
        L1ed:
            r0 = move-exception
            goto L1cb
        L1ef:
            r1 = move-exception
            goto L1dc
        L1f1:
            r1 = move-exception
            goto L1e1
        L1f3:
            r0 = move-exception
            goto L1d7
        L1f5:
            r0 = move-exception
            r1 = r3
            r3 = r2
            goto L1d7
        L1f9:
            r0 = move-exception
            r2 = r1
            r3 = r1
            goto L80
        L1fe:
            r0 = move-exception
            r3 = r1
            r8 = r1
            r1 = r2
            r2 = r8
            goto L80
        L205:
            r0 = move-exception
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
            goto L80
        L20c:
            r0 = move-exception
            goto L80
        L20f:
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
            goto L147
        L215:
            r0 = r5
            goto Lf7
        L218:
            r2 = r1
            r3 = r1
            goto L147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.d.a(int, java.lang.String, java.lang.String, android.content.pm.PackageInfo):void");
    }

    public synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        return a(i, str, (String) null, false, packageInfo);
    }

    private synchronized boolean a(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        boolean z2;
        String str3;
        String str4;
        try {
            com.baidu.sofire.b.a("init in Key=" + i);
            if (z && this.h.c(i) != 1) {
                z2 = false;
            } else {
                ApkInfo a2 = this.h.a(i);
                if (a2 == null) {
                    com.baidu.sofire.b.a("loadedDB.getByID(Key) is null");
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", i + "");
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.b.e.a(a, "1003105", hashMap);
                    }
                    z2 = false;
                } else {
                    File file = new File(a2.pkgPath);
                    com.baidu.sofire.b.a(file.getAbsolutePath());
                    if (!com.baidu.sofire.b.e.a(file)) {
                        com.baidu.sofire.b.a("!new File(apkInfo.pkgPath).exists()");
                        this.h.c(i, -1);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("0", 3);
                        hashMap2.put("1", i + "");
                        hashMap2.put("2", str);
                        if (!z) {
                            com.baidu.sofire.b.e.a(a, "1003105", hashMap2);
                        }
                        z2 = false;
                    } else {
                        if (packageInfo != null) {
                            a2.cloudPkgInfo = packageInfo;
                        }
                        g a3 = g.a(a.getApplicationContext(), true);
                        com.baidu.sofire.b.a("ready to loadAPK");
                        if (!a3.a(a2, z, false)) {
                            this.h.c(i, -1);
                            a3.a(a2.pkgPath);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("0", 4);
                            hashMap3.put("1", i + "");
                            hashMap3.put("2", str);
                            if (!z) {
                                com.baidu.sofire.b.e.a(a, "1003105", hashMap3);
                            }
                            com.baidu.sofire.b.a("!apkHub.syncLoadApk(apkInfo, reuseOld)");
                            z2 = false;
                        } else {
                            com.baidu.sofire.b.a("read keys");
                            String[] h = com.baidu.sofire.b.e.h(a);
                            if (h != null && h.length == 2 && !TextUtils.isEmpty(h[0]) && !TextUtils.isEmpty(h[1])) {
                                str3 = h[0];
                                str4 = h[1];
                            } else {
                                str3 = "3";
                                str4 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                            }
                            com.baidu.sofire.b.a("ak=" + str3 + ", sk=" + str4);
                            ApkInfo c = a3.c(a2.pkgPath);
                            f fVar = (f) c.classLoader;
                            Class<?> a4 = fVar.a("com.baidu.sofire.engine.EngineImpl");
                            if (a4 == null) {
                                com.baidu.sofire.b.a("init failed! Cannot obtain class");
                                Class<?> a5 = fVar.a("java.lang.String");
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("0", 9);
                                hashMap4.put("1", i + "");
                                hashMap4.put("2", str);
                                hashMap4.put("3", Base64.encodeToString(("classloader=" + fVar + ",StringClass=" + a5).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                if (!z) {
                                    com.baidu.sofire.b.e.a(a, "1003105", hashMap4);
                                }
                                this.h.c(i, -1);
                                z2 = false;
                            } else {
                                Object invoke = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, a);
                                com.baidu.sofire.b.a("ai=" + invoke);
                                com.baidu.sofire.b.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str4);
                                if (!((Boolean) com.baidu.sofire.b.e.a(invoke, AiAppsRouteMessage.TYPE_INIT, new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.e.u()))).booleanValue()) {
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put("0", 6);
                                    hashMap5.put("1", i + "");
                                    hashMap5.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.b.e.a(a, "1003105", hashMap5);
                                    }
                                    this.h.c(i, -1);
                                    a3.a(c.pkgPath);
                                    com.baidu.sofire.b.a("!(Boolean) CommonMethods.callMethodOfClass(apkEngineImpl, init, null)");
                                    z2 = false;
                                } else {
                                    c.initStatus = 1;
                                    c.apkParseSuc = 1;
                                    this.h.a(c);
                                    com.baidu.sofire.b.a("initRT SDK SUC");
                                    int f = this.h.f(c.key);
                                    com.baidu.sofire.b.a("plugin now loadStatus :" + c.key + " " + f);
                                    if (f < 3 && f != -1) {
                                        this.h.d(c.key, f + 1);
                                    }
                                    HashMap hashMap6 = new HashMap();
                                    hashMap6.put("0", 0);
                                    hashMap6.put("1", Integer.valueOf(i));
                                    hashMap6.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.b.e.a(a, "1003105", hashMap6);
                                    }
                                    com.baidu.sofire.b.e.c(a);
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            z2 = false;
        }
        return z2;
    }

    public void a(int i) {
        try {
            ApkInfo a2 = this.h.a(i);
            if (a2 != null) {
                this.h.g(i);
                File file = new File(a2.pkgPath);
                com.baidu.sofire.b.a("deleteNotLoadedPlugin file=" + file.getAbsolutePath() + ", e=" + file.exists());
                if (file != null && file.exists()) {
                    com.baidu.sofire.c.a(file);
                    com.baidu.sofire.b.a("" + file.getAbsolutePath() + " s=" + file.delete());
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public void c(String str, String str2) {
        try {
            this.h.a(str);
            File file = new File(str2);
            com.baidu.sofire.b.a("f=" + file.getAbsolutePath() + ", e=" + file.exists());
            if (file != null && file.exists()) {
                com.baidu.sofire.c.a(file);
                com.baidu.sofire.b.a("" + file.getAbsolutePath() + " s=" + file.delete());
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public boolean a(ApkInfo apkInfo, String str, String str2) {
        String str3;
        String str4;
        com.baidu.sofire.b.a("newCloudCome apkInfo=" + apkInfo);
        if (apkInfo == null) {
            return false;
        }
        File file = new File(apkInfo.pkgPath);
        try {
            if (!com.baidu.sofire.b.e.a(file)) {
                com.baidu.sofire.b.a("!file.exists()");
                HashMap hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", apkInfo.key + "");
                hashMap.put("2", apkInfo.versionName);
                hashMap.put("3", Base64.encodeToString(("nowTime:" + System.currentTimeMillis() + ", nowFileInfo: path=" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length() + " - " + str).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.e.a(a, "1003106", hashMap);
                return false;
            }
            if (!this.h.b(apkInfo.key)) {
                this.h.a(apkInfo);
            }
            g a2 = g.a(a.getApplicationContext(), true);
            this.h.b(apkInfo.key, 1);
            a(apkInfo.packageName);
            if (!a2.a(apkInfo, true, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                hashMap2.put("1", apkInfo.key + "");
                hashMap2.put("2", apkInfo.versionName);
                com.baidu.sofire.b.e.a(a, "1003106", hashMap2);
                com.baidu.sofire.b.a("!apkHub.syncLoadApk(newSDKPath, ApkInfo.LOAD_MODE_FULL_APK)");
                com.baidu.sofire.c.a(file);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, str2, true, (PackageInfo) null);
                this.h.b(apkInfo.key, 0);
                return false;
            }
            String[] h = com.baidu.sofire.b.e.h(a);
            if (h != null && h.length == 2 && !TextUtils.isEmpty(h[0]) && !TextUtils.isEmpty(h[1])) {
                str3 = h[0];
                str4 = h[1];
            } else {
                str3 = "3";
                str4 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            ApkInfo c = a2.c(apkInfo.pkgPath);
            if (c == null) {
                return false;
            }
            f fVar = (f) c.classLoader;
            Class<?> a3 = fVar.a("com.baidu.sofire.engine.EngineImpl");
            if (a3 == null) {
                com.baidu.sofire.b.a("cannot load class");
                Class<?> a4 = fVar.a("java.lang.String");
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 6);
                hashMap3.put("1", c.key + "");
                hashMap3.put("2", c.versionName);
                hashMap3.put("3", Base64.encodeToString(("classloader=" + fVar + ",StringClass=" + a4).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.e.a(a, "1003106", hashMap3);
                com.baidu.sofire.c.a(file);
                file.delete();
                this.h.b(c.key, 0);
                return false;
            }
            Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, a);
            com.baidu.sofire.b.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str4);
            if (!((Boolean) com.baidu.sofire.b.e.a(invoke, AiAppsRouteMessage.TYPE_INIT, new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.e.u()))).booleanValue()) {
                com.baidu.sofire.b.a("!(Boolean) CommonMethods.callMethodOfClass(apkEngineImpl, init, null)");
                com.baidu.sofire.c.a(file);
                a(c.packageName);
                file.delete();
                a(c.key, c.versionName, str2, true, (PackageInfo) null);
                this.h.b(c.key, 0);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("0", 4);
                hashMap4.put("1", c.key + "");
                hashMap4.put("2", c.versionName);
                com.baidu.sofire.b.e.a(a, "1003106", hashMap4);
                return false;
            }
            if (c.isMem) {
                com.baidu.sofire.c.a(file);
                file.delete();
                com.baidu.sofire.b.e.d(c.dataDir);
                if (g.a != null) {
                    g.a.add(Integer.valueOf(c.key));
                }
            }
            com.baidu.sofire.b.a("newRTSDKCome finish SUC");
            try {
                ApkInfo a5 = this.h.a(c.key);
                com.baidu.sofire.b.a("old apkinfo=" + a5);
                File file2 = (a5 == null || a5.versionName.equals(c.versionName)) ? null : new File(a5.pkgPath);
                c.initStatus = 1;
                c.apkParseSuc = 1;
                long a6 = this.h.a(c);
                if (a6 > 0 && file2 != null && file2.exists()) {
                    com.baidu.sofire.c.a(file2);
                    com.baidu.sofire.b.a("delete old apk suc=" + file2.delete());
                }
                com.baidu.sofire.b.a("insertOrUpdateRecord =" + a6 + ", c=" + this.h.b(c.key, 0));
                com.baidu.sofire.b.e.c(a);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("0", 0);
                hashMap5.put("1", c.key + "");
                hashMap5.put("2", c.versionName);
                com.baidu.sofire.b.e.a(a, "1003106", hashMap5);
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
            return true;
        } catch (Throwable th2) {
            try {
                com.baidu.sofire.b.a(th2.getMessage());
                com.baidu.sofire.c.a(file);
                a(apkInfo.packageName);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, str2, true, (PackageInfo) null);
                this.h.b(apkInfo.key, 0);
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 5);
                hashMap6.put("1", apkInfo.key + "");
                hashMap6.put("2", apkInfo.versionName);
                hashMap6.put("3", Base64.encodeToString(com.baidu.sofire.b.a(th2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.e.a(a, "1003106", hashMap6);
            } catch (Throwable th3) {
                com.baidu.sofire.b.e.a(th3);
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.baidu.sofire.core.d$3] */
    public void a(final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            com.baidu.sofire.b.a("execEngineImpl methodName=" + str);
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            com.baidu.sofire.b.e.a(a, "1003136", hashMap);
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
            } else {
                new Thread() { // from class: com.baidu.sofire.core.d.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        boolean z;
                        super.run();
                        try {
                            if (callback != null) {
                                callback.onBegin(new Object[0]);
                            }
                            boolean d2 = d.this.h.d(i);
                            com.baidu.sofire.b.a("u=" + d2);
                            if (d2) {
                                long currentTimeMillis = System.currentTimeMillis();
                                while (d.this.h.d(i) && System.currentTimeMillis() - currentTimeMillis < ErrDef.Feature.WEIGHT) {
                                    com.baidu.sofire.b.a("wait for update...");
                                    SystemClock.sleep(300L);
                                }
                            }
                            com.baidu.sofire.b.a("isUpdating=" + d2);
                            if (!d.this.h.d(i)) {
                                if (!d.this.c) {
                                    d.b(3);
                                    d.this.b();
                                }
                                g a2 = g.a(d.a.getApplicationContext(), true);
                                ApkInfo apkInfo = null;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                while (true) {
                                    if (System.currentTimeMillis() - currentTimeMillis2 > 120000) {
                                        z = false;
                                        break;
                                    }
                                    com.baidu.sofire.b.a("waiting...");
                                    apkInfo = d.this.h.a(i);
                                    if (apkInfo != null) {
                                        if (a2.d(apkInfo.packageName) != null) {
                                            z = true;
                                            break;
                                        } else if (apkInfo.initStatus == -1) {
                                            z = false;
                                            break;
                                        }
                                    }
                                    SystemClock.sleep(1000L);
                                }
                                if (!z) {
                                    if (callback != null) {
                                        callback.onError(4);
                                        return;
                                    }
                                    return;
                                }
                                Class<?> a3 = ((f) a2.d(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                Object a4 = com.baidu.sofire.b.e.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, d.a), str, clsArr, objArr);
                                try {
                                    com.baidu.sofire.b.a("CommonMethods.callMethodOfClass result object=" + a4);
                                } catch (Throwable th) {
                                    com.baidu.sofire.b.e.a(th);
                                }
                                if (callback != null) {
                                    callback.onEnd(a4);
                                }
                            } else if (callback != null) {
                                callback.onError(3);
                            }
                        } catch (IllegalAccessException e) {
                            com.baidu.sofire.b.a(e.getMessage(), e);
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (IllegalArgumentException e2) {
                            com.baidu.sofire.b.a(e2.getMessage(), e2);
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (NoSuchMethodException e3) {
                            com.baidu.sofire.b.a(e3.getMessage(), e3);
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (InvocationTargetException e4) {
                            com.baidu.sofire.b.a(e4.getMessage(), e4);
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (Throwable th2) {
                            com.baidu.sofire.b.a(th2.getMessage(), th2);
                            if (callback != null) {
                                callback.onError(3);
                            }
                        }
                    }
                }.start();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        com.baidu.sofire.b.a("execEngineImplSync methodName=" + str);
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.toString(i));
        hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
        hashMap.put("2", "1");
        com.baidu.sofire.b.e.a(a, "1003136", hashMap);
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            boolean d2 = this.h.d(i);
            com.baidu.sofire.b.a("isUpdating=" + d2);
            if (d2) {
                return new Pair<>(3, null);
            }
            if (!this.c) {
                return new Pair<>(3, null);
            }
            g a2 = g.a();
            if (a2 == null) {
                return new Pair<>(3, null);
            }
            ApkInfo a3 = this.h.a(i);
            if (!((a3 == null || a2.d(a3.packageName) == null) ? false : true)) {
                return new Pair<>(4, null);
            }
            Class<?> a4 = ((f) a2.d(a3.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
            Object a5 = com.baidu.sofire.b.e.a(a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, a), str, clsArr, objArr);
            try {
                com.baidu.sofire.b.a("CommonMethods.callMethodOfClass result object=" + a5);
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
            return new Pair<>(0, a5);
        } catch (IllegalAccessException e) {
            com.baidu.sofire.b.a(e.getMessage(), e);
            return new Pair<>(2, null);
        } catch (IllegalArgumentException e2) {
            com.baidu.sofire.b.a(e2.getMessage(), e2);
            return new Pair<>(2, null);
        } catch (NoSuchMethodException e3) {
            com.baidu.sofire.b.a(e3.getMessage(), e3);
            return new Pair<>(2, null);
        } catch (InvocationTargetException e4) {
            com.baidu.sofire.b.a(e4.getMessage(), e4);
            return new Pair<>(2, null);
        } catch (Throwable th2) {
            com.baidu.sofire.b.a(th2.getMessage(), th2);
            return new Pair<>(3, null);
        }
    }

    public void a(String str) {
        g a2;
        ApkInfo d2;
        com.baidu.sofire.b.a("update packageName=" + str);
        try {
            if (!TextUtils.isEmpty(str) && (a2 = g.a()) != null && (d2 = a2.d(str)) != null) {
                Class<?> a3 = ((f) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, a);
                if (invoke != null) {
                    com.baidu.sofire.b.a("CommonMethods.callMethodOfClass result object=" + com.baidu.sofire.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                    a2.b(str);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.a(th.getMessage(), th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.sofire.core.d$4] */
    public void b(final String str) {
        try {
            com.baidu.sofire.b.a("unload packageName=" + str);
            new Thread() { // from class: com.baidu.sofire.core.d.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            final g a2 = g.a(d.a.getApplicationContext(), true);
                            com.baidu.sofire.b.a(str + ", h=" + a2);
                            if (a2 != null) {
                                final ApkInfo d2 = a2.d(str);
                                com.baidu.sofire.b.a(str + ", i=" + d2);
                                if (d2 == null) {
                                    d.this.c(str, d.this.h.c(str).pkgPath);
                                } else {
                                    Class<?> a3 = ((f) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                    Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, d.a);
                                    com.baidu.sofire.b.a(str + ", i=" + invoke);
                                    if (invoke != null) {
                                        com.baidu.sofire.b.a("t:" + System.currentTimeMillis());
                                        new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.core.d.4.1
                                            @Override // java.util.TimerTask, java.lang.Runnable
                                            public void run() {
                                                com.baidu.sofire.b.a("Timer().schedule:" + System.currentTimeMillis());
                                                a2.b(str);
                                                d.this.h.a(str);
                                                com.baidu.sofire.b.e.c(d.a);
                                                File file = new File(d2.pkgPath);
                                                com.baidu.sofire.b.a("f=" + file.getAbsolutePath() + ", e=" + file.exists());
                                                if (file != null && file.exists()) {
                                                    com.baidu.sofire.c.a(file);
                                                    com.baidu.sofire.b.a("d: " + file.getAbsolutePath() + " s=" + file.delete());
                                                }
                                            }
                                        }, KeepJobService.JOB_CHECK_PERIODIC);
                                        com.baidu.sofire.b.a(str + ", CommonMethods.callMethodOfClass result object=" + com.baidu.sofire.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                                        a2.b(str);
                                        d.this.h.a(str);
                                        com.baidu.sofire.b.e.c(d.a);
                                        File file = new File(d2.pkgPath);
                                        com.baidu.sofire.b.a("f=" + file.getAbsolutePath() + ", e=" + file.exists());
                                        if (file != null && file.exists()) {
                                            com.baidu.sofire.c.a(file);
                                            com.baidu.sofire.b.a("d: " + file.getAbsolutePath() + " s=" + file.delete());
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.baidu.sofire.b.a(th.getMessage(), th);
                    }
                }
            }.start();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public static void b(int i) {
        if (g == 0) {
            g = i;
        }
    }
}
