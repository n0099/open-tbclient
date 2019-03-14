package com.baidu.sofire.core;

import android.content.ContentValues;
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
import com.baidu.mobstat.Config;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.rp.Report;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
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
public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static Context b;
    private static d f;
    public com.baidu.sofire.e a;
    com.baidu.sofire.a.a c;
    private volatile boolean e = false;
    private com.baidu.sofire.g g;
    private static int h = 0;
    public static List<Integer> d = new ArrayList();

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            try {
                if (str.equals("xytk")) {
                    com.baidu.sofire.b.a();
                    e.a = this.g.a();
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a();
            }
        }
    }

    private d(Context context) {
        com.baidu.sofire.b.a();
        b = context.getApplicationContext();
        this.c = com.baidu.sofire.a.a.a(b);
        this.a = new com.baidu.sofire.e(b);
        this.g = new com.baidu.sofire.g(b);
        com.baidu.sofire.g gVar = this.g;
        if (gVar.a == null) {
            return;
        }
        gVar.a.registerOnSharedPreferenceChangeListener(this);
    }

    public static d a() {
        return f;
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f == null) {
                f = new d(context.getApplicationContext());
            }
            dVar = f;
        }
        return dVar;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.baidu.sofire.core.d$1] */
    public final synchronized void a(final Callback callback) {
        com.baidu.sofire.b.e.d(b);
        new StringBuilder("initCalledByHost=").append(this.e);
        com.baidu.sofire.b.a();
        if (this.e) {
            if (callback != null) {
                callback.onEnd(new Object[0]);
            }
        } else {
            this.e = true;
            com.baidu.sofire.e eVar = this.a;
            eVar.c.putString("ssv", "3.1.9.3");
            eVar.c.commit();
            Report.getInstance(b).n();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            b.registerReceiver(new MyReceiver(), intentFilter);
            for (ApkInfo apkInfo : this.c.a()) {
                String str = null;
                try {
                    str = b.getFilesDir().getCanonicalPath();
                } catch (IOException e) {
                    com.baidu.sofire.b.e.a();
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/." + apkInfo.key;
                    com.baidu.sofire.b.e.d(apkInfo.dataDir + "/lib");
                }
            }
            new Thread() { // from class: com.baidu.sofire.core.d.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                        d.this.c.d();
                        com.baidu.sofire.b.a();
                        new StringBuilder("preferences.isInitOnce()=").append(d.this.a.a());
                        com.baidu.sofire.b.a();
                        if (!d.this.a.a()) {
                            com.baidu.sofire.e eVar2 = d.this.a;
                            eVar2.c.putBoolean("iio", true);
                            eVar2.c.commit();
                        } else {
                            com.baidu.sofire.a.a aVar = d.this.c;
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("n", (Integer) 0);
                            aVar.c.update("pgn", contentValues, "n=-1", null);
                        }
                        new U(d.b, 1, false).start();
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                    } catch (Throwable th) {
                        com.baidu.sofire.b.e.a();
                    }
                }
            }.start();
        }
    }

    public final void b() {
        try {
            List<ApkInfo> a = this.c.a();
            new StringBuilder("all=").append(a);
            com.baidu.sofire.b.a();
            final List<Integer> q = this.a.q();
            List<Integer> p = this.a.p();
            for (int i = 0; i < p.size(); i++) {
                if (!q.contains(p.get(i))) {
                    q.add(p.get(i));
                }
            }
            Collections.sort(a, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.core.d.2
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
                            int indexOf = (q == null || !q.contains(Integer.valueOf(apkInfo3.key))) ? -1 : q.indexOf(Integer.valueOf(apkInfo3.key));
                            int indexOf2 = (q == null || !q.contains(Integer.valueOf(apkInfo4.key))) ? -1 : q.indexOf(Integer.valueOf(apkInfo4.key));
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
                g a2 = g.a();
                if ((a2 != null ? a2.d(apkInfo.packageName) : null) == null) {
                    boolean z = true;
                    if (this.c.g(apkInfo.key) == 3) {
                        com.baidu.sofire.b.a();
                        z = false;
                    }
                    if (this.a.c() && z) {
                        File file = new File(b.getFilesDir(), ".b");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(apkInfo.pkgPath);
                        File file3 = new File(file, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                        if (!com.baidu.sofire.b.e.a(file3)) {
                            com.baidu.sofire.b.e.a(file2, file3);
                        }
                        com.baidu.sofire.c.a(b, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(b.getFilesDir(), ".b");
                        if (file4.exists()) {
                            File file5 = new File(file4, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                            if (com.baidu.sofire.b.e.a(file5)) {
                                com.baidu.sofire.c.a(file5);
                                new StringBuilder("remove the backup file: ").append(file5.getAbsolutePath()).append(" s=").append(file5.delete());
                                com.baidu.sofire.b.a();
                            }
                        }
                    }
                    a(apkInfo.key, apkInfo.versionName, null);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
    }

    public final void b(Context context) {
        try {
            if (!this.a.a.getBoolean("lpcf", false)) {
                JSONArray jSONArray = new JSONArray(com.baidu.sofire.b.e.a(context, "sofire_local.cfg", RecentlyVisitedForumModel.LOCAL_ACCOUNT));
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
                    String optString3 = optJSONObject.optString("md5");
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
                this.a.a(arrayList);
                if (hashMap.size() <= 0) {
                    this.a.r();
                    return;
                }
                String str = com.baidu.sofire.b.e.b() + "p/1/pio";
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
                com.baidu.sofire.b.a();
                String a = com.baidu.sofire.b.h.a(context, str, jSONArray3);
                com.baidu.sofire.b.a();
                JSONArray jSONArray4 = new JSONArray(a);
                if (jSONArray4.length() > 0) {
                    this.a.r();
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
                                try {
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
                                } catch (Throwable th) {
                                    com.baidu.sofire.b.e.a();
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
        } catch (Throwable th2) {
            com.baidu.sofire.b.e.a();
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [565=7, 567=6, 571=5, 573=6] */
    private void a(int r10, java.lang.String r11, java.lang.String r12, android.content.pm.PackageInfo r13) {
        /*
            r9 = this;
            r3 = 0
            r0 = 0
            r4 = 1
            com.baidu.sofire.a.a r1 = r9.c     // Catch: java.lang.Throwable -> L106
            com.baidu.sofire.core.ApkInfo r1 = r1.a(r10)     // Catch: java.lang.Throwable -> L106
            if (r1 == 0) goto L1c
            java.lang.String r1 = r1.versionName     // Catch: java.lang.Throwable -> L106
            boolean r1 = com.baidu.sofire.b.e.c(r11, r1)     // Catch: java.lang.Throwable -> L106
            if (r1 != 0) goto L14
        L13:
            return
        L14:
            com.baidu.sofire.a.a r1 = r9.c     // Catch: java.lang.Throwable -> L100
            com.baidu.sofire.core.ApkInfo r1 = r1.a(r10)     // Catch: java.lang.Throwable -> L100
            if (r1 != 0) goto Laa
        L1c:
            boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L260
            if (r1 != 0) goto L279
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L260
            android.content.Context r1 = com.baidu.sofire.core.d.b     // Catch: java.lang.Throwable -> L260
            java.io.File r1 = r1.getFilesDir()     // Catch: java.lang.Throwable -> L260
            java.lang.String r5 = ".tmp"
            r2.<init>(r1, r5)     // Catch: java.lang.Throwable -> L260
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L260
            if (r1 != 0) goto L39
            r2.mkdir()     // Catch: java.lang.Throwable -> L260
        L39:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L260
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L260
            r5.<init>()     // Catch: java.lang.Throwable -> L260
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L260
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L260
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L260
            java.lang.String r6 = ".zip"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L260
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L260
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L260
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L265
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L265
            android.content.Context r5 = com.baidu.sofire.core.d.b     // Catch: java.lang.Throwable -> L26c
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L26c
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L26c
            java.io.InputStream r0 = r5.open(r6)     // Catch: java.lang.Throwable -> L26c
            r5 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L80
        L74:
            int r6 = r0.read(r5)     // Catch: java.lang.Throwable -> L80
            r7 = -1
            if (r6 == r7) goto L10c
            r7 = 0
            r2.write(r5, r7, r6)     // Catch: java.lang.Throwable -> L80
            goto L74
        L80:
            r3 = move-exception
            r8 = r1
            r1 = r2
            r2 = r0
            r0 = r8
        L85:
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L25b
            if (r0 == 0) goto L221
            boolean r3 = r0.exists()     // Catch: java.lang.Throwable -> L25b
            if (r3 == 0) goto L221
            com.baidu.sofire.c.a(r0)     // Catch: java.lang.Throwable -> L25b
            com.baidu.sofire.a.a r3 = r9.c     // Catch: java.lang.Throwable -> L25b
            r3.h(r10)     // Catch: java.lang.Throwable -> L25b
            r0.delete()     // Catch: java.lang.Throwable -> L25b
            if (r2 == 0) goto La0
            r2.close()     // Catch: java.io.IOException -> L248
        La0:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> La7
            goto L13
        La7:
            r0 = move-exception
            goto L13
        Laa:
            com.baidu.sofire.a.a r2 = r9.c     // Catch: java.lang.Throwable -> L100
            r2.h(r10)     // Catch: java.lang.Throwable -> L100
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L100
            java.lang.String r1 = r1.pkgPath     // Catch: java.lang.Throwable -> L100
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L100
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L100
            java.lang.String r5 = "deleteNotLoadedPlugin file="
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L100
            java.lang.String r5 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L100
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Throwable -> L100
            java.lang.String r5 = ", e="
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Throwable -> L100
            boolean r5 = r2.exists()     // Catch: java.lang.Throwable -> L100
            r1.append(r5)     // Catch: java.lang.Throwable -> L100
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L100
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L100
            if (r1 == 0) goto L1c
            com.baidu.sofire.c.a(r2)     // Catch: java.lang.Throwable -> L100
            boolean r1 = r2.delete()     // Catch: java.lang.Throwable -> L100
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L100
            r5.<init>()     // Catch: java.lang.Throwable -> L100
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L100
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch: java.lang.Throwable -> L100
            java.lang.String r5 = " s="
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Throwable -> L100
            r2.append(r1)     // Catch: java.lang.Throwable -> L100
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L100
            goto L1c
        L100:
            r1 = move-exception
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L106
            goto L1c
        L106:
            r1 = move-exception
            com.baidu.sofire.b.e.a()
            goto L1c
        L10c:
            r2.flush()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6 = 1
            com.baidu.sofire.b.e.a(r5, r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = com.baidu.sofire.b.o.a(r1)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L123
            boolean r6 = r5.equalsIgnoreCase(r12)     // Catch: java.lang.Throwable -> L80
            if (r6 != 0) goto L133
        L123:
            r1.delete()     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L12b
            r0.close()     // Catch: java.io.IOException -> L240
        L12b:
            r2.close()     // Catch: java.io.IOException -> L130
            goto L13
        L130:
            r0 = move-exception
            goto L13
        L133:
            com.baidu.sofire.core.ApkInfo r6 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6.<init>(r10, r11, r7)     // Catch: java.lang.Throwable -> L80
            r6.apkMD5 = r5     // Catch: java.lang.Throwable -> L80
            r5 = 1
            r6.priority = r5     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.a.a r5 = r9.c     // Catch: java.lang.Throwable -> L80
            r5.a(r6)     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.a.a r5 = r9.c     // Catch: java.lang.Throwable -> L80
            int r5 = r5.g(r10)     // Catch: java.lang.Throwable -> L80
            r6 = 3
            if (r5 != r6) goto L276
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L80
        L152:
            com.baidu.sofire.e r4 = r9.a     // Catch: java.lang.Throwable -> L80
            boolean r4 = r4.c()     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L1c1
            if (r3 == 0) goto L1c1
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L80
            android.content.Context r4 = com.baidu.sofire.core.d.b     // Catch: java.lang.Throwable -> L80
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = ".b"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L80
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L80
            if (r4 != 0) goto L173
            r3.mkdir()     // Catch: java.lang.Throwable -> L80
        L173:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L80
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            boolean r3 = com.baidu.sofire.b.e.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L199
            com.baidu.sofire.b.e.a(r1, r4)     // Catch: java.lang.Throwable -> L80
        L199:
            android.content.Context r3 = com.baidu.sofire.core.d.b     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a(r3, r10, r1, r4)     // Catch: java.lang.Throwable -> L80
            r8 = r1
            r1 = r2
            r2 = r0
            r0 = r8
        L1a2:
            com.baidu.sofire.a.a r3 = r9.c     // Catch: java.lang.Throwable -> L273
            com.baidu.sofire.core.ApkInfo r3 = r3.a(r10)     // Catch: java.lang.Throwable -> L273
            if (r3 == 0) goto L1b2
            java.lang.String r3 = r3.pkgPath     // Catch: java.lang.Throwable -> L273
            boolean r3 = com.baidu.sofire.b.e.c(r3)     // Catch: java.lang.Throwable -> L273
            if (r3 != 0) goto L203
        L1b2:
            if (r2 == 0) goto L1b7
            r2.close()     // Catch: java.io.IOException -> L243
        L1b7:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> L1be
            goto L13
        L1be:
            r0 = move-exception
            goto L13
        L1c1:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L80
            android.content.Context r4 = com.baidu.sofire.core.d.b     // Catch: java.lang.Throwable -> L80
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = ".b"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L80
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L1fe
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L80
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            boolean r3 = com.baidu.sofire.b.e.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto L1fe
            com.baidu.sofire.c.a(r4)     // Catch: java.lang.Throwable -> L80
            r4.delete()     // Catch: java.lang.Throwable -> L80
        L1fe:
            r8 = r1
            r1 = r2
            r2 = r0
            r0 = r8
            goto L1a2
        L203:
            boolean r3 = r9.a(r10, r11, r13)     // Catch: java.lang.Throwable -> L273
            if (r3 == 0) goto L212
            java.util.List<java.lang.Integer> r3 = com.baidu.sofire.core.d.d     // Catch: java.lang.Throwable -> L273
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L273
            r3.add(r4)     // Catch: java.lang.Throwable -> L273
        L212:
            if (r2 == 0) goto L217
            r2.close()     // Catch: java.io.IOException -> L246
        L217:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> L21e
            goto L13
        L21e:
            r0 = move-exception
            goto L13
        L221:
            if (r2 == 0) goto L226
            r2.close()     // Catch: java.io.IOException -> L24b
        L226:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> L22d
            goto L13
        L22d:
            r0 = move-exception
            goto L13
        L230:
            r1 = move-exception
            r2 = r0
            r8 = r1
            r1 = r0
            r0 = r8
        L235:
            if (r1 == 0) goto L23a
            r1.close()     // Catch: java.io.IOException -> L24d
        L23a:
            if (r2 == 0) goto L23f
            r2.close()     // Catch: java.io.IOException -> L24f
        L23f:
            throw r0
        L240:
            r0 = move-exception
            goto L12b
        L243:
            r0 = move-exception
            goto L1b7
        L246:
            r0 = move-exception
            goto L217
        L248:
            r0 = move-exception
            goto La0
        L24b:
            r0 = move-exception
            goto L226
        L24d:
            r1 = move-exception
            goto L23a
        L24f:
            r1 = move-exception
            goto L23f
        L251:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L235
        L256:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L235
        L25b:
            r0 = move-exception
            r8 = r1
            r1 = r2
            r2 = r8
            goto L235
        L260:
            r1 = move-exception
            r1 = r0
            r2 = r0
            goto L85
        L265:
            r2 = move-exception
            r2 = r0
            r8 = r0
            r0 = r1
            r1 = r8
            goto L85
        L26c:
            r3 = move-exception
            r8 = r1
            r1 = r2
            r2 = r0
            r0 = r8
            goto L85
        L273:
            r3 = move-exception
            goto L85
        L276:
            r3 = r4
            goto L152
        L279:
            r1 = r0
            r2 = r0
            goto L1a2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.d.a(int, java.lang.String, java.lang.String, android.content.pm.PackageInfo):void");
    }

    public final synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        return a(i, str, false, packageInfo);
    }

    private synchronized boolean a(int i, String str, boolean z, PackageInfo packageInfo) {
        boolean z2;
        String str2;
        String str3;
        try {
            com.baidu.sofire.b.a();
            if (z && this.c.c(i) != 1) {
                z2 = false;
            } else {
                ApkInfo a = this.c.a(i);
                if (a == null) {
                    com.baidu.sofire.b.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", String.valueOf(i));
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.b.e.a(b, "1003105", hashMap);
                    }
                    z2 = false;
                } else {
                    File file = new File(a.pkgPath);
                    file.getAbsolutePath();
                    com.baidu.sofire.b.a();
                    if (!com.baidu.sofire.b.e.a(file)) {
                        com.baidu.sofire.b.a();
                        this.c.f(i);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("0", 3);
                        hashMap2.put("1", String.valueOf(i));
                        hashMap2.put("2", str);
                        if (!z) {
                            com.baidu.sofire.b.e.a(b, "1003105", hashMap2);
                        }
                        z2 = false;
                    } else {
                        if (packageInfo != null) {
                            a.cloudPkgInfo = packageInfo;
                        }
                        g a2 = g.a(b.getApplicationContext());
                        com.baidu.sofire.b.a();
                        if (!a2.a(a, false)) {
                            this.c.f(i);
                            a2.a(a.pkgPath);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("0", 4);
                            hashMap3.put("1", String.valueOf(i));
                            hashMap3.put("2", str);
                            if (!z) {
                                com.baidu.sofire.b.e.a(b, "1003105", hashMap3);
                            }
                            com.baidu.sofire.b.a();
                            z2 = false;
                        } else {
                            com.baidu.sofire.b.a();
                            String[] g = com.baidu.sofire.b.e.g(b);
                            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                                String str4 = g[0];
                                str2 = g[1];
                                str3 = str4;
                            } else {
                                str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                                str3 = "3";
                            }
                            new StringBuilder("ak=").append(str3).append(", sk=").append(str2);
                            com.baidu.sofire.b.a();
                            ApkInfo c = a2.c(a.pkgPath);
                            f fVar = (f) c.classLoader;
                            Class<?> a3 = fVar.a("com.baidu.sofire.engine.EngineImpl");
                            if (a3 == null) {
                                com.baidu.sofire.b.a();
                                Class<?> a4 = fVar.a("java.lang.String");
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("0", 9);
                                hashMap4.put("1", String.valueOf(i));
                                hashMap4.put("2", str);
                                hashMap4.put("3", Base64.encodeToString(("classloader=" + fVar + ",StringClass=" + a4).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                if (!z) {
                                    com.baidu.sofire.b.e.a(b, "1003105", hashMap4);
                                }
                                this.c.f(i);
                                z2 = false;
                            } else {
                                Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, b);
                                new StringBuilder("ai=").append(invoke);
                                com.baidu.sofire.b.a();
                                com.baidu.sofire.b.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str2);
                                if (!((Boolean) com.baidu.sofire.b.e.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.a.n()))).booleanValue()) {
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put("0", 6);
                                    hashMap5.put("1", String.valueOf(i));
                                    hashMap5.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.b.e.a(b, "1003105", hashMap5);
                                    }
                                    this.c.f(i);
                                    a2.a(c.pkgPath);
                                    com.baidu.sofire.b.a();
                                    z2 = false;
                                } else {
                                    c.initStatus = 1;
                                    c.apkParseSuc = 1;
                                    this.c.a(c);
                                    com.baidu.sofire.b.a();
                                    int g2 = this.c.g(c.key);
                                    new StringBuilder("plugin now loadStatus :").append(c.key).append(" ").append(g2);
                                    com.baidu.sofire.b.a();
                                    if (g2 < 3 && g2 != -1) {
                                        this.c.b(c.key, g2 + 1);
                                    }
                                    HashMap hashMap6 = new HashMap();
                                    hashMap6.put("0", 0);
                                    hashMap6.put("1", Integer.valueOf(i));
                                    hashMap6.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.b.e.a(b, "1003105", hashMap6);
                                    }
                                    com.baidu.sofire.b.e.c(b);
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            z2 = false;
        }
        return z2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x003e: IGET  (r4v43 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x013a: IGET  (r4v41 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01dc: IGET  (r7v8 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02f4: IGET  (r4v26 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0355: IGET  (r5v1 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0452: IGET  (r4v21 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    public final boolean a(ApkInfo apkInfo, String str) {
        String str2;
        String str3;
        new StringBuilder("newCloudCome apkInfo=").append(apkInfo);
        com.baidu.sofire.b.a();
        if (apkInfo == null) {
            return false;
        }
        File file = new File(apkInfo.pkgPath);
        try {
            if (!com.baidu.sofire.b.e.a(file)) {
                com.baidu.sofire.b.a();
                HashMap hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap.put("2", apkInfo.versionName);
                hashMap.put("3", Base64.encodeToString(("nowTime:" + System.currentTimeMillis() + ", nowFileInfo: path=" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length() + " - " + str).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.e.a(b, "1003106", hashMap);
                return false;
            }
            if (!this.c.b(apkInfo.key)) {
                this.c.a(apkInfo);
            }
            g a = g.a(b.getApplicationContext());
            this.c.a(apkInfo.key, 1);
            b(apkInfo.packageName);
            if (!a.a(apkInfo, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                hashMap2.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap2.put("2", apkInfo.versionName);
                com.baidu.sofire.b.e.a(b, "1003106", hashMap2);
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.c.a(apkInfo.key, 0);
                return false;
            }
            String[] g = com.baidu.sofire.b.e.g(b);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1])) {
                str2 = g[0];
                str3 = g[1];
            } else {
                str2 = "3";
                str3 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            ApkInfo c = a.c(apkInfo.pkgPath);
            if (c == null) {
                return false;
            }
            f fVar = (f) c.classLoader;
            Class<?> a2 = fVar.a("com.baidu.sofire.engine.EngineImpl");
            if (a2 == null) {
                com.baidu.sofire.b.a();
                Class<?> a3 = fVar.a("java.lang.String");
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 6);
                hashMap3.put("1", new StringBuilder().append(c.key).toString());
                hashMap3.put("2", c.versionName);
                hashMap3.put("3", Base64.encodeToString(("classloader=" + fVar + ",StringClass=" + a3).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.e.a(b, "1003106", hashMap3);
                com.baidu.sofire.c.a(file);
                file.delete();
                this.c.a(c.key, 0);
                return false;
            }
            Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, b);
            com.baidu.sofire.b.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
            if (!((Boolean) com.baidu.sofire.b.e.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.a.n()))).booleanValue()) {
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                b(c.packageName);
                file.delete();
                a(c.key, c.versionName, true, (PackageInfo) null);
                this.c.a(c.key, 0);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("0", 4);
                hashMap4.put("1", new StringBuilder().append(c.key).toString());
                hashMap4.put("2", c.versionName);
                com.baidu.sofire.b.e.a(b, "1003106", hashMap4);
                return false;
            }
            if (c.isMem) {
                com.baidu.sofire.c.a(file);
                file.delete();
                com.baidu.sofire.b.e.d(c.dataDir);
                if (g.b != null) {
                    g.b.add(Integer.valueOf(c.key));
                }
            }
            com.baidu.sofire.b.a();
            try {
                ApkInfo a4 = this.c.a(c.key);
                new StringBuilder("old apkinfo=").append(a4);
                com.baidu.sofire.b.a();
                File file2 = (a4 == null || a4.versionName.equals(c.versionName)) ? null : new File(a4.pkgPath);
                c.initStatus = 1;
                c.apkParseSuc = 1;
                long a5 = this.c.a(c);
                if (a5 > 0 && file2 != null && file2.exists()) {
                    com.baidu.sofire.c.a(file2);
                    file2.delete();
                    com.baidu.sofire.b.a();
                }
                new StringBuilder("insertOrUpdateRecord =").append(a5).append(", c=").append(this.c.a(c.key, 0));
                com.baidu.sofire.b.a();
                com.baidu.sofire.b.e.c(b);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("0", 0);
                hashMap5.put("1", new StringBuilder().append(c.key).toString());
                hashMap5.put("2", c.versionName);
                com.baidu.sofire.b.e.a(b, "1003106", hashMap5);
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a();
            }
            return true;
        } catch (Throwable th2) {
            try {
                th2.getMessage();
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                b(apkInfo.packageName);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.c.a(apkInfo.key, 0);
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 5);
                hashMap6.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap6.put("2", apkInfo.versionName);
                hashMap6.put("3", Base64.encodeToString(com.baidu.sofire.b.a(th2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.e.a(b, "1003106", hashMap6);
            } catch (Throwable th3) {
                com.baidu.sofire.b.e.a();
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.sofire.core.d$3] */
    public final void a(final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            com.baidu.sofire.b.a();
            final HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            com.baidu.sofire.b.e.a(b, "1003136", hashMap);
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
                hashMap.put("3", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                return;
            }
            new Thread() { // from class: com.baidu.sofire.core.d.3
                /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1237=8, 1238=8, 1244=6] */
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    boolean z = true;
                    int i2 = 0;
                    super.run();
                    try {
                        try {
                            try {
                                try {
                                    if (callback != null) {
                                        callback.onBegin(new Object[0]);
                                    }
                                    boolean d2 = d.this.c.d(i);
                                    com.baidu.sofire.b.a();
                                    if (d2) {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        while (d.this.c.d(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                                            com.baidu.sofire.b.a();
                                            SystemClock.sleep(300L);
                                        }
                                    }
                                    com.baidu.sofire.b.a();
                                    if (d.this.c.d(i)) {
                                        try {
                                            if (callback != null) {
                                                callback.onError(3);
                                            }
                                            try {
                                                hashMap.put("3", Integer.toString(12));
                                                com.baidu.sofire.b.e.a(d.b, "1003141", hashMap);
                                                return;
                                            } catch (Throwable th) {
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            i2 = 12;
                                            if (i2 != 0) {
                                                try {
                                                    hashMap.put("3", Integer.toString(i2));
                                                    com.baidu.sofire.b.e.a(d.b, "1003141", hashMap);
                                                } catch (Throwable th3) {
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    if (!d.this.e) {
                                        d.a(3);
                                        d.this.a((Callback) null);
                                    }
                                    g a = g.a(d.b.getApplicationContext());
                                    ApkInfo apkInfo = null;
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    while (System.currentTimeMillis() - currentTimeMillis2 <= 120000) {
                                        com.baidu.sofire.b.a();
                                        apkInfo = d.this.c.a(i);
                                        if (apkInfo != null) {
                                            if (a.d(apkInfo.packageName) != null) {
                                                break;
                                            } else if (apkInfo.initStatus == -1) {
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
                                            com.baidu.sofire.b.e.a(d.b, "1003141", hashMap);
                                            return;
                                        } catch (Throwable th4) {
                                            return;
                                        }
                                    }
                                    Class<?> a2 = ((f) a.d(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                    Object a3 = com.baidu.sofire.b.e.a(a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, d.b), str, clsArr, objArr);
                                    try {
                                        new StringBuilder("CommonMethods.callMethodOfClass result object=").append(a3);
                                        com.baidu.sofire.b.a();
                                    } catch (Throwable th5) {
                                        com.baidu.sofire.b.e.a();
                                    }
                                    if (callback != null) {
                                        callback.onEnd(a3);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } catch (IllegalAccessException e) {
                                e.getMessage();
                                com.baidu.sofire.b.c();
                                if (callback != null) {
                                    callback.onError(2);
                                }
                                try {
                                    hashMap.put("3", Integer.toString(16));
                                    com.baidu.sofire.b.e.a(d.b, "1003141", hashMap);
                                } catch (Throwable th7) {
                                }
                            }
                        } catch (NoSuchMethodException e2) {
                            e2.getMessage();
                            com.baidu.sofire.b.c();
                            if (callback != null) {
                                callback.onError(2);
                            }
                            try {
                                hashMap.put("3", Integer.toString(14));
                                com.baidu.sofire.b.e.a(d.b, "1003141", hashMap);
                            } catch (Throwable th8) {
                            }
                        }
                    } catch (IllegalArgumentException e3) {
                        e3.getMessage();
                        com.baidu.sofire.b.c();
                        if (callback != null) {
                            callback.onError(2);
                        }
                        try {
                            hashMap.put("3", Integer.toString(17));
                            com.baidu.sofire.b.e.a(d.b, "1003141", hashMap);
                        } catch (Throwable th9) {
                        }
                    } catch (InvocationTargetException e4) {
                        e4.getMessage();
                        com.baidu.sofire.b.c();
                        if (callback != null) {
                            callback.onError(2);
                        }
                        try {
                            hashMap.put("3", Integer.toString(15));
                            com.baidu.sofire.b.e.a(d.b, "1003141", hashMap);
                        } catch (Throwable th10) {
                        }
                    }
                }
            }.start();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1347=10, 1348=10] */
    public final Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        int i2 = 2;
        com.baidu.sofire.b.a();
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.toString(i));
        hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
        hashMap.put("2", "1");
        com.baidu.sofire.b.e.a(b, "1003136", hashMap);
        try {
            if (TextUtils.isEmpty(str)) {
                hashMap.put("3", "1");
                com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                return new Pair<>(1, null);
            }
            try {
                try {
                    try {
                        try {
                            boolean d2 = this.c.d(i);
                            com.baidu.sofire.b.a();
                            if (d2) {
                                Pair<Integer, Object> pair = new Pair<>(3, null);
                                try {
                                    hashMap.put("3", Integer.toString(2));
                                    com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                                    return pair;
                                } catch (Throwable th) {
                                    return pair;
                                }
                            } else if (!this.e) {
                                try {
                                    Pair<Integer, Object> pair2 = new Pair<>(3, null);
                                    try {
                                        hashMap.put("3", Integer.toString(3));
                                        com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                                        return pair2;
                                    } catch (Throwable th2) {
                                        return pair2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    i2 = 3;
                                    if (i2 != 0) {
                                        try {
                                            hashMap.put("3", Integer.toString(i2));
                                            com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                                        } catch (Throwable th4) {
                                        }
                                    }
                                    throw th;
                                }
                            } else {
                                g a = g.a();
                                if (a == null) {
                                    Pair<Integer, Object> pair3 = new Pair<>(3, null);
                                    try {
                                        hashMap.put("3", Integer.toString(4));
                                        com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                                        return pair3;
                                    } catch (Throwable th5) {
                                        return pair3;
                                    }
                                }
                                ApkInfo a2 = this.c.a(i);
                                if (!((a2 == null || a.d(a2.packageName) == null) ? false : true)) {
                                    Pair<Integer, Object> pair4 = new Pair<>(4, null);
                                    try {
                                        hashMap.put("3", Integer.toString(5));
                                        com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                                        return pair4;
                                    } catch (Throwable th6) {
                                        return pair4;
                                    }
                                }
                                Class<?> a3 = ((f) a.d(a2.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                Object a4 = com.baidu.sofire.b.e.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, b), str, clsArr, objArr);
                                try {
                                    new StringBuilder("CommonMethods.callMethodOfClass result object=").append(a4);
                                    com.baidu.sofire.b.a();
                                } catch (Throwable th7) {
                                    com.baidu.sofire.b.e.a();
                                }
                                return new Pair<>(0, a4);
                            }
                        } catch (IllegalAccessException e) {
                            e.getMessage();
                            com.baidu.sofire.b.c();
                            Pair<Integer, Object> pair5 = new Pair<>(2, null);
                            try {
                                hashMap.put("3", Integer.toString(8));
                                com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                                return pair5;
                            } catch (Throwable th8) {
                                return pair5;
                            }
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        i2 = 0;
                    }
                } catch (IllegalArgumentException e2) {
                    e2.getMessage();
                    com.baidu.sofire.b.c();
                    Pair<Integer, Object> pair6 = new Pair<>(2, null);
                    try {
                        hashMap.put("3", Integer.toString(9));
                        com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                        return pair6;
                    } catch (Throwable th10) {
                        return pair6;
                    }
                } catch (InvocationTargetException e3) {
                    e3.getMessage();
                    com.baidu.sofire.b.c();
                    Pair<Integer, Object> pair7 = new Pair<>(2, null);
                    try {
                        hashMap.put("3", Integer.toString(7));
                        com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                        return pair7;
                    } catch (Throwable th11) {
                        return pair7;
                    }
                }
            } catch (NoSuchMethodException e4) {
                e4.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair8 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(6));
                    com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                    return pair8;
                } catch (Throwable th12) {
                    return pair8;
                }
            } catch (Throwable th13) {
                th13.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair9 = new Pair<>(3, null);
                try {
                    hashMap.put("3", Integer.toString(10));
                    com.baidu.sofire.b.e.a(b, "1003141", hashMap);
                    return pair9;
                } catch (Throwable th14) {
                    return pair9;
                }
            }
        } catch (Throwable th15) {
            th = th15;
        }
    }

    private static void b(String str) {
        g a;
        ApkInfo d2;
        com.baidu.sofire.b.a();
        try {
            if (!TextUtils.isEmpty(str) && (a = g.a()) != null && (d2 = a.d(str)) != null) {
                Class<?> a2 = ((f) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, b);
                if (invoke != null) {
                    new StringBuilder("CommonMethods.callMethodOfClass result object=").append(com.baidu.sofire.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                    com.baidu.sofire.b.a();
                    a.b(str);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.c();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.sofire.core.d$4] */
    public final void a(final String str) {
        try {
            com.baidu.sofire.b.a();
            new Thread() { // from class: com.baidu.sofire.core.d.4
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    super.run();
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            final g a = g.a(d.b.getApplicationContext());
                            new StringBuilder().append(str).append(", h=").append(a);
                            com.baidu.sofire.b.a();
                            if (a != null) {
                                final ApkInfo d2 = a.d(str);
                                new StringBuilder().append(str).append(", i=").append(d2);
                                com.baidu.sofire.b.a();
                                if (d2 == null) {
                                    ApkInfo c = d.this.c.c(str);
                                    d dVar = d.this;
                                    String str2 = str;
                                    String str3 = c.pkgPath;
                                    dVar.c.a(str2);
                                    File file = new File(str3);
                                    new StringBuilder("f=").append(file.getAbsolutePath()).append(", e=").append(file.exists());
                                    com.baidu.sofire.b.a();
                                    if (file.exists()) {
                                        com.baidu.sofire.c.a(file);
                                        new StringBuilder().append(file.getAbsolutePath()).append(" s=").append(file.delete());
                                        com.baidu.sofire.b.a();
                                    }
                                } else {
                                    Class<?> a2 = ((f) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                    Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, d.b);
                                    new StringBuilder().append(str).append(", i=").append(invoke);
                                    com.baidu.sofire.b.a();
                                    if (invoke != null) {
                                        new StringBuilder("t:").append(System.currentTimeMillis());
                                        com.baidu.sofire.b.a();
                                        new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.core.d.4.1
                                            @Override // java.util.TimerTask, java.lang.Runnable
                                            public final void run() {
                                                new StringBuilder("Timer().schedule:").append(System.currentTimeMillis());
                                                com.baidu.sofire.b.a();
                                                a.b(str);
                                                d.this.c.a(str);
                                                com.baidu.sofire.b.e.c(d.b);
                                                File file2 = new File(d2.pkgPath);
                                                new StringBuilder("f=").append(file2.getAbsolutePath()).append(", e=").append(file2.exists());
                                                com.baidu.sofire.b.a();
                                                if (file2.exists()) {
                                                    com.baidu.sofire.c.a(file2);
                                                    new StringBuilder("d: ").append(file2.getAbsolutePath()).append(" s=").append(file2.delete());
                                                    com.baidu.sofire.b.a();
                                                }
                                            }
                                        }, KeepJobService.JOB_CHECK_PERIODIC);
                                        new StringBuilder().append(str).append(", CommonMethods.callMethodOfClass result object=").append(com.baidu.sofire.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                                        com.baidu.sofire.b.a();
                                        a.b(str);
                                        d.this.c.a(str);
                                        com.baidu.sofire.b.e.c(d.b);
                                        File file2 = new File(d2.pkgPath);
                                        new StringBuilder("f=").append(file2.getAbsolutePath()).append(", e=").append(file2.exists());
                                        com.baidu.sofire.b.a();
                                        if (file2.exists()) {
                                            com.baidu.sofire.c.a(file2);
                                            new StringBuilder("d: ").append(file2.getAbsolutePath()).append(" s=").append(file2.delete());
                                            com.baidu.sofire.b.a();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                        com.baidu.sofire.b.c();
                    }
                }
            }.start();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
    }

    public static void a(int i) {
        if (h == 0) {
            h = i;
        }
    }
}
