package com.baidu.sofire.core;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.mobstat.Config;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.b.h;
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
public final class c implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static Context b;
    private static c f;
    public com.baidu.sofire.e a;
    com.baidu.sofire.a.a c;
    private volatile boolean e = false;
    private com.baidu.sofire.g g;
    private static int h = 0;
    public static List<Integer> d = new ArrayList();

    private c(Context context) {
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

    public static c a() {
        return f;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            try {
                if (str.equals("xytk")) {
                    com.baidu.sofire.b.e.e = this.g.a.getString("xytk", "");
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            new StringBuilder("i=").append(f);
            if (f == null) {
                f = new c(context.getApplicationContext());
            }
            cVar = f;
        }
        return cVar;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.baidu.sofire.core.c$1] */
    public final synchronized void a(final Callback callback) {
        String str;
        com.baidu.sofire.b.e.b(b);
        new StringBuilder().append(this.e);
        if (this.e) {
            if (callback != null) {
                callback.onEnd(new Object[0]);
            }
        } else {
            this.e = true;
            com.baidu.sofire.e eVar = this.a;
            eVar.c.putString("ssv", "3.1.3.2");
            eVar.c.commit();
            Report.getInstance(b).n();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            b.registerReceiver(new MyReceiver(), intentFilter);
            com.baidu.sofire.b.b.a(b);
            for (ApkInfo apkInfo : this.c.a()) {
                try {
                    str = b.getFilesDir().getCanonicalPath();
                } catch (IOException e) {
                    com.baidu.sofire.b.e.a(e);
                    str = null;
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/." + apkInfo.key;
                    com.baidu.sofire.b.e.b(apkInfo.dataDir + "/lib");
                }
            }
            new Thread() { // from class: com.baidu.sofire.core.c.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                        c.this.c.d();
                        new StringBuilder().append(c.this.a.a.getBoolean("iio", false));
                        if (!c.this.a.a.getBoolean("iio", false)) {
                            com.baidu.sofire.e eVar2 = c.this.a;
                            eVar2.c.putBoolean("iio", true);
                            eVar2.c.commit();
                        } else {
                            com.baidu.sofire.a.a aVar = c.this.c;
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("n", (Integer) 0);
                            aVar.c.update("pgn", contentValues, "n=-1", null);
                        }
                        new U(c.b, 1, false).start();
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

    public final void b() {
        try {
            List<ApkInfo> a = this.c.a();
            new StringBuilder("all=").append(a);
            final List<Integer> c = this.a.c();
            List<Integer> b2 = this.a.b();
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
                e a2 = e.a();
                if ((a2 != null ? a2.d(apkInfo.packageName) : null) == null) {
                    boolean z = this.c.g(apkInfo.key) != 3;
                    if (this.a.a.getBoolean("bka", true) && z) {
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
                                new StringBuilder().append(file5.getAbsolutePath()).append(" s=").append(file5.delete());
                            }
                        }
                    }
                    a(apkInfo.key, apkInfo.versionName, null);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
                this.a.a(arrayList);
                if (hashMap.size() <= 0) {
                    com.baidu.sofire.e eVar = this.a;
                    eVar.c.putBoolean("lpcf", true);
                    eVar.c.commit();
                    return;
                }
                String str = com.baidu.sofire.b.e.a() + "p/1/pio";
                JSONArray jSONArray2 = new JSONArray();
                for (ApkInfo apkInfo2 : hashMap.values()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PushConstants.URI_PACKAGE_NAME, apkInfo2.packageName);
                    jSONObject.put(Config.MODEL, apkInfo2.apkMD5);
                    jSONObject.put("l", apkInfo2.key);
                    jSONObject.put("v", apkInfo2.versionName);
                    jSONArray2.put(jSONObject);
                }
                String a = h.a(context, str, jSONArray2.toString(), false, false);
                new StringBuilder().append(a);
                JSONArray jSONArray3 = new JSONArray(a);
                if (jSONArray3.length() > 0) {
                    com.baidu.sofire.e eVar2 = this.a;
                    eVar2.c.putBoolean("lpcf", true);
                    eVar2.c.commit();
                }
                for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                    JSONObject optJSONObject2 = jSONArray3.optJSONObject(i2);
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
                        new StringBuilder().append(apkInfo3);
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [572=7, 574=6, 576=5, 579=5, 581=6, 583=6] */
    private void a(int r10, java.lang.String r11, java.lang.String r12, android.content.pm.PackageInfo r13) {
        /*
            r9 = this;
            r4 = 0
            r1 = 0
            r5 = 1
            com.baidu.sofire.a.a r0 = r9.c     // Catch: java.lang.Throwable -> L100
            com.baidu.sofire.core.ApkInfo r0 = r0.a(r10)     // Catch: java.lang.Throwable -> L100
            if (r0 == 0) goto L1c
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> L100
            boolean r0 = com.baidu.sofire.b.e.c(r11, r0)     // Catch: java.lang.Throwable -> L100
            if (r0 != 0) goto L14
        L13:
            return
        L14:
            com.baidu.sofire.a.a r0 = r9.c     // Catch: java.lang.Throwable -> Lfa
            com.baidu.sofire.core.ApkInfo r0 = r0.a(r10)     // Catch: java.lang.Throwable -> Lfa
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
            com.baidu.sofire.b.e.a(r0)     // Catch: java.lang.Throwable -> L2a3
            if (r1 == 0) goto L273
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L2a3
            if (r0 == 0) goto L273
            com.baidu.sofire.c.a(r1)     // Catch: java.lang.Throwable -> L2a3
            com.baidu.sofire.a.a r0 = r9.c     // Catch: java.lang.Throwable -> L2a3
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
            com.baidu.sofire.a.a r2 = r9.c     // Catch: java.lang.Throwable -> Lfa
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
            com.baidu.sofire.b.e.a(r0)     // Catch: java.lang.Throwable -> L100
            goto L1c
        L100:
            r0 = move-exception
            com.baidu.sofire.b.e.a(r0)
            goto L1c
        L106:
            r3.flush()     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6 = 1
            com.baidu.sofire.b.e.a(r0, r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "f: "
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = ", l="
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch: java.lang.Throwable -> L80
            long r6 = r2.length()     // Catch: java.lang.Throwable -> L80
            r0.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = com.baidu.sofire.b.n.a(r2)     // Catch: java.lang.Throwable -> L80
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
            com.baidu.sofire.a.a r0 = r9.c     // Catch: java.lang.Throwable -> L80
            r0.a(r6)     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.a.a r0 = r9.c     // Catch: java.lang.Throwable -> L80
            int r0 = r0.g(r10)     // Catch: java.lang.Throwable -> L80
            r6 = 3
            if (r0 != r6) goto L2bd
            r0 = r4
        L170:
            com.baidu.sofire.e r4 = r9.a     // Catch: java.lang.Throwable -> L80
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
            boolean r0 = com.baidu.sofire.b.e.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r0 != 0) goto L1bd
            com.baidu.sofire.b.e.a(r2, r4)     // Catch: java.lang.Throwable -> L80
        L1bd:
            android.content.Context r0 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a(r0, r10, r2, r4)     // Catch: java.lang.Throwable -> L80
            r8 = r2
            r2 = r3
            r3 = r1
            r1 = r8
        L1c6:
            com.baidu.sofire.a.a r0 = r9.c     // Catch: java.lang.Throwable -> L2ba
            com.baidu.sofire.core.ApkInfo r0 = r0.a(r10)     // Catch: java.lang.Throwable -> L2ba
            if (r0 == 0) goto L1d6
            java.lang.String r0 = r0.pkgPath     // Catch: java.lang.Throwable -> L2ba
            boolean r0 = com.baidu.sofire.b.e.a(r0)     // Catch: java.lang.Throwable -> L2ba
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
            boolean r0 = com.baidu.sofire.b.e.a(r4)     // Catch: java.lang.Throwable -> L80
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
            if (z && this.c.c(i) != 1) {
                z2 = false;
            } else {
                ApkInfo a = this.c.a(i);
                if (a == null) {
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
                    if (!com.baidu.sofire.b.e.a(file)) {
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
                        e a2 = e.a(b.getApplicationContext());
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
                            z2 = false;
                        } else {
                            String[] e = com.baidu.sofire.b.e.e(b);
                            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                                String str4 = e[0];
                                str2 = e[1];
                                str3 = str4;
                            } else {
                                str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                                str3 = "3";
                            }
                            new StringBuilder("ak=").append(str3).append(", sk=").append(str2);
                            ApkInfo c = a2.c(a.pkgPath);
                            d dVar = (d) c.classLoader;
                            Class<?> a3 = dVar.a("com.baidu.sofire.engine.EngineImpl");
                            if (a3 == null) {
                                Class<?> a4 = dVar.a("java.lang.String");
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("0", 9);
                                hashMap4.put("1", String.valueOf(i));
                                hashMap4.put("2", str);
                                hashMap4.put("3", Base64.encodeToString(("classloader=" + dVar + ",StringClass=" + a4).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                if (!z) {
                                    com.baidu.sofire.b.e.a(b, "1003105", hashMap4);
                                }
                                this.c.f(i);
                                z2 = false;
                            } else {
                                Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, b);
                                new StringBuilder("ai=").append(invoke);
                                com.baidu.sofire.b.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str2);
                                if (!((Boolean) com.baidu.sofire.b.e.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.a.a.getBoolean("hac", false)))).booleanValue()) {
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put("0", 6);
                                    hashMap5.put("1", String.valueOf(i));
                                    hashMap5.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.b.e.a(b, "1003105", hashMap5);
                                    }
                                    this.c.f(i);
                                    a2.a(c.pkgPath);
                                    z2 = false;
                                } else {
                                    c.initStatus = 1;
                                    c.apkParseSuc = 1;
                                    this.c.a(c);
                                    int g = this.c.g(c.key);
                                    new StringBuilder("plugin now loadStatus :").append(c.key).append(" ").append(g);
                                    if (g < 3 && g != -1) {
                                        this.c.b(c.key, g + 1);
                                    }
                                    HashMap hashMap6 = new HashMap();
                                    hashMap6.put("0", 0);
                                    hashMap6.put("1", Integer.valueOf(i));
                                    hashMap6.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.b.e.a(b, "1003105", hashMap6);
                                    }
                                    com.baidu.sofire.b.e.a(b);
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
            if (!com.baidu.sofire.b.e.a(file)) {
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
            e a = e.a(b.getApplicationContext());
            this.c.a(apkInfo.key, 1);
            a(apkInfo.packageName);
            if (!a.a(apkInfo, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                hashMap2.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap2.put("2", apkInfo.versionName);
                com.baidu.sofire.b.e.a(b, "1003106", hashMap2);
                com.baidu.sofire.c.a(file);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.c.a(apkInfo.key, 0);
                return false;
            }
            String[] e = com.baidu.sofire.b.e.e(b);
            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                str2 = e[0];
                str3 = e[1];
            } else {
                str2 = "3";
                str3 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            ApkInfo c = a.c(apkInfo.pkgPath);
            if (c == null) {
                return false;
            }
            d dVar = (d) c.classLoader;
            Class<?> a2 = dVar.a("com.baidu.sofire.engine.EngineImpl");
            if (a2 == null) {
                Class<?> a3 = dVar.a("java.lang.String");
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 6);
                hashMap3.put("1", new StringBuilder().append(c.key).toString());
                hashMap3.put("2", c.versionName);
                hashMap3.put("3", Base64.encodeToString(("classloader=" + dVar + ",StringClass=" + a3).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.e.a(b, "1003106", hashMap3);
                com.baidu.sofire.c.a(file);
                file.delete();
                this.c.a(c.key, 0);
                return false;
            }
            Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, b);
            com.baidu.sofire.b.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
            if (!((Boolean) com.baidu.sofire.b.e.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.a.a.getBoolean("hac", false)))).booleanValue()) {
                com.baidu.sofire.c.a(file);
                a(c.packageName);
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
                com.baidu.sofire.b.e.b(c.dataDir);
                if (e.b != null) {
                    e.b.add(Integer.valueOf(c.key));
                }
            }
            try {
                ApkInfo a4 = this.c.a(c.key);
                new StringBuilder().append(a4);
                File file2 = (a4 == null || a4.versionName.equals(c.versionName)) ? null : new File(a4.pkgPath);
                c.initStatus = 1;
                c.apkParseSuc = 1;
                long a5 = this.c.a(c);
                if (a5 > 0 && file2 != null && file2.exists()) {
                    com.baidu.sofire.c.a(file2);
                    new StringBuilder().append(file2.delete());
                }
                new StringBuilder().append(a5).append(", c=").append(this.c.a(c.key, 0));
                com.baidu.sofire.b.e.a(b);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("0", 0);
                hashMap5.put("1", new StringBuilder().append(c.key).toString());
                hashMap5.put("2", c.versionName);
                com.baidu.sofire.b.e.a(b, "1003106", hashMap5);
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
            return true;
        } catch (Throwable th2) {
            try {
                th2.getMessage();
                com.baidu.sofire.c.a(file);
                a(apkInfo.packageName);
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
                com.baidu.sofire.b.e.a(th3);
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
        com.baidu.sofire.b.e.a(b, "1003136", hashMap);
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            boolean d2 = this.c.d(i);
            new StringBuilder().append(d2);
            if (d2) {
                return new Pair<>(3, null);
            }
            if (!this.e) {
                return new Pair<>(3, null);
            }
            e a = e.a();
            if (a == null) {
                return new Pair<>(3, null);
            }
            ApkInfo a2 = this.c.a(i);
            if (!((a2 == null || a.d(a2.packageName) == null) ? false : true)) {
                return new Pair<>(4, null);
            }
            Class<?> a3 = ((d) a.d(a2.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
            Object a4 = com.baidu.sofire.b.e.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, b), str, clsArr, objArr);
            try {
                new StringBuilder().append(a4);
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
            return new Pair<>(0, a4);
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
        e a;
        ApkInfo d2;
        new StringBuilder().append(str);
        try {
            if (!TextUtils.isEmpty(str) && (a = e.a()) != null && (d2 = a.d(str)) != null) {
                Class<?> a2 = ((d) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, b);
                if (invoke != null) {
                    new StringBuilder().append(com.baidu.sofire.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                    a.b(str);
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
                    final e a = e.a(c.b.getApplicationContext());
                    new StringBuilder().append(this.a).append(", h=").append(a);
                    if (a != null) {
                        final ApkInfo d = a.d(this.a);
                        new StringBuilder().append(this.a).append(", i=").append(d);
                        if (d == null) {
                            ApkInfo c = c.this.c.c(this.a);
                            c cVar = c.this;
                            String str = this.a;
                            String str2 = c.pkgPath;
                            cVar.c.a(str);
                            File file = new File(str2);
                            new StringBuilder("f=").append(file.getAbsolutePath()).append(", e=").append(file.exists());
                            if (file.exists()) {
                                com.baidu.sofire.c.a(file);
                                new StringBuilder().append(file.getAbsolutePath()).append(" s=").append(file.delete());
                            }
                        } else {
                            Class<?> a2 = ((d) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                            Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, c.b);
                            new StringBuilder().append(this.a).append(", i=").append(invoke);
                            if (invoke != null) {
                                new StringBuilder("t:").append(System.currentTimeMillis());
                                new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.core.c.4.1
                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public final void run() {
                                        new StringBuilder().append(System.currentTimeMillis());
                                        a.b(AnonymousClass4.this.a);
                                        c.this.c.a(AnonymousClass4.this.a);
                                        File file2 = new File(d.pkgPath);
                                        new StringBuilder("f=").append(file2.getAbsolutePath()).append(", e=").append(file2.exists());
                                        if (file2.exists()) {
                                            com.baidu.sofire.c.a(file2);
                                            new StringBuilder("d: ").append(file2.getAbsolutePath()).append(" s=").append(file2.delete());
                                        }
                                    }
                                }, KeepJobService.JOB_CHECK_PERIODIC);
                                new StringBuilder().append(this.a).append(", CommonMethods.callMethodOfClass result object=").append(com.baidu.sofire.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                                a.b(this.a);
                                c.this.c.a(this.a);
                                File file2 = new File(d.pkgPath);
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
        if (h == 0) {
            h = i;
        }
    }
}
