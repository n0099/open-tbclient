package com.baidu.sofire.core;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.rp.Report;
import com.baidu.tbadk.TbConfig;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
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
    private static c PF;
    private com.baidu.sofire.e PG;
    private com.baidu.sofire.a.a PH;
    private volatile boolean b = false;
    private Context e;
    private static int f = 0;
    public static List<Integer> a = new ArrayList();

    private c(Context context) {
        com.baidu.sofire.b.a();
        this.e = context;
        this.PH = com.baidu.sofire.a.a.an(context);
        this.PG = new com.baidu.sofire.e(context);
    }

    public static c nj() {
        return PF;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.sofire.b.d.a(str, str2);
            com.baidu.sofire.e eVar = this.PG;
            eVar.PS.putString("svi", str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
            eVar.PS.commit();
        }
    }

    public static synchronized c ap(Context context) {
        c cVar;
        synchronized (c.class) {
            String str = "i=" + PF;
            com.baidu.sofire.b.a();
            if (PF == null) {
                PF = new c(context.getApplicationContext());
            }
            cVar = PF;
        }
        return cVar;
    }

    public final void b() {
        a((Callback) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00db A[Catch: Throwable -> 0x018e, TryCatch #0 {Throwable -> 0x018e, blocks: (B:4:0x000a, B:6:0x000f, B:8:0x0013, B:10:0x001c, B:12:0x0025, B:13:0x002b, B:15:0x0041, B:17:0x0047, B:24:0x00cc, B:26:0x00db, B:28:0x00e1, B:29:0x00e6, B:31:0x00ec, B:33:0x00f8, B:35:0x012a, B:41:0x0140, B:42:0x0144, B:48:0x0150, B:50:0x018a, B:39:0x0139), top: B:61:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0150 A[Catch: Throwable -> 0x018e, TryCatch #0 {Throwable -> 0x018e, blocks: (B:4:0x000a, B:6:0x000f, B:8:0x0013, B:10:0x001c, B:12:0x0025, B:13:0x002b, B:15:0x0041, B:17:0x0047, B:24:0x00cc, B:26:0x00db, B:28:0x00e1, B:29:0x00e6, B:31:0x00ec, B:33:0x00f8, B:35:0x012a, B:41:0x0140, B:42:0x0144, B:48:0x0150, B:50:0x018a, B:39:0x0139), top: B:61:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, String[] strArr) {
        String str;
        String str2;
        int i;
        int i2;
        List<JobInfo> allPendingJobs;
        boolean z;
        boolean z2;
        int i3;
        String a2;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                com.baidu.sofire.b.a();
                if (strArr != null && strArr.length == 2 && !TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                    str = strArr[0];
                    str2 = strArr[1];
                } else {
                    str = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                    str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                int i4 = eVar.a.getInt("jobinv_t", SubsamplingScaleImageView.ORIENTATION_180);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    String str3 = com.baidu.sofire.b.d.a() + "plugin/v1/settings";
                    String str4 = str3;
                    com.baidu.sofire.b.a();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a", "b");
                        a2 = com.baidu.sofire.b.f.a(context, str3, jSONObject.toString(), str, str2, true);
                        String str5 = "--" + a2;
                        com.baidu.sofire.b.a();
                    } catch (Throwable th) {
                        th = th;
                        i3 = -1;
                    }
                    if (a2 != null) {
                        i = new JSONObject(a2).optInt("t1");
                        try {
                            String str6 = "Job-" + Integer.toString(i);
                            com.baidu.sofire.b.a();
                            eVar.PS.putInt("jobinv_t", i);
                            eVar.PS.commit();
                        } catch (Throwable th2) {
                            i3 = i;
                            th = th2;
                            com.baidu.sofire.b.d.a(th);
                            i = i3;
                            if (i == -1) {
                            }
                            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
                            allPendingJobs = jobScheduler.getAllPendingJobs();
                            if (allPendingJobs != null) {
                            }
                            z = true;
                            if (i2 == 0) {
                            }
                            if (z) {
                            }
                        }
                        i2 = i == -1 ? i4 : i;
                        JobScheduler jobScheduler2 = (JobScheduler) context.getSystemService("jobscheduler");
                        allPendingJobs = jobScheduler2.getAllPendingJobs();
                        if (allPendingJobs != null || allPendingJobs.size() <= 0) {
                            z = true;
                        } else {
                            boolean z3 = true;
                            for (JobInfo jobInfo : allPendingJobs) {
                                if (jobInfo.getId() == 7) {
                                    String str7 = "interval " + (jobInfo.getIntervalMillis() / 60000) + ": " + i2;
                                    com.baidu.sofire.b.a();
                                    if (jobInfo.getIntervalMillis() == i2 * 60 * 1000) {
                                        com.baidu.sofire.b.a();
                                        z3 = false;
                                    } else {
                                        if (i2 == 0) {
                                            com.baidu.sofire.b.a();
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        jobScheduler2.cancel(0);
                                    }
                                } else {
                                    z2 = z3;
                                }
                                z3 = z2;
                            }
                            z = z3;
                        }
                        if (i2 == 0) {
                            z = false;
                        }
                        if (z) {
                            String str8 = Integer.toString(i2);
                            com.baidu.sofire.b.a();
                            JobInfo.Builder builder = new JobInfo.Builder(7, new ComponentName(context, com.baidu.sofire.a.class));
                            builder.setPeriodic(i2 * 60 * 1000);
                            builder.setPersisted(true);
                            builder.setRequiredNetworkType(1);
                            if (jobScheduler2.schedule(builder.build()) == 0) {
                                com.baidu.sofire.b.a();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                i = -1;
                if (i == -1) {
                }
                JobScheduler jobScheduler22 = (JobScheduler) context.getSystemService("jobscheduler");
                allPendingJobs = jobScheduler22.getAllPendingJobs();
                if (allPendingJobs != null) {
                }
                z = true;
                if (i2 == 0) {
                }
                if (z) {
                }
            } catch (Throwable th3) {
                com.baidu.sofire.b.d.a(th3);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x0032: IGET  (r2v1 boolean A[REMOVE]) = (r4v0 'this' com.baidu.sofire.core.c A[IMMUTABLE_TYPE, THIS]) com.baidu.sofire.core.c.b boolean)] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.baidu.sofire.core.c$1] */
    public final synchronized void a(final Callback callback) {
        String str;
        String[] e = com.baidu.sofire.b.d.e(this.e);
        if (e == null || e.length != 2 || TextUtils.isEmpty(e[0]) || TextUtils.isEmpty(e[1])) {
            a(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, "925fc15df8a49bed0b3eca8d2b44cb7b");
        }
        com.baidu.sofire.b.d.b(this.e);
        new StringBuilder().append(this.b).toString();
        com.baidu.sofire.b.a();
        if (this.b) {
            if (callback != null) {
                callback.onEnd(new Object[0]);
            }
        } else {
            a(this.e, e);
            this.b = true;
            com.baidu.sofire.e eVar = this.PG;
            eVar.PS.putString("ssv", "2.0.8");
            eVar.PS.commit();
            Report.getInstance(this.e).n();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            this.e.registerReceiver(new MyReceiver(), intentFilter);
            com.baidu.sofire.b.b.a(this.e);
            for (ApkInfo apkInfo : this.PH.a()) {
                try {
                    str = this.e.getFilesDir().getCanonicalPath();
                } catch (IOException e2) {
                    com.baidu.sofire.b.d.a(e2);
                    str = null;
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/." + apkInfo.key;
                    com.baidu.sofire.b.d.b(apkInfo.dataDir + "/lib");
                }
            }
            new Thread() { // from class: com.baidu.sofire.core.c.1
                /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x0020: INVOKE  (r1v3 boolean A[REMOVE]) = 
                  (wrap: android.content.SharedPreferences : 0x001a: IGET  (r1v2 android.content.SharedPreferences A[REMOVE]) = 
                  (wrap: com.baidu.sofire.e : 0x0016: IGET  (r1v1 com.baidu.sofire.e A[REMOVE]) = 
                  (wrap: com.baidu.sofire.core.c : 0x0014: IGET  (r1v0 com.baidu.sofire.core.c A[REMOVE]) = (r5v0 'this' com.baidu.sofire.core.c$1 A[IMMUTABLE_TYPE, THIS]) com.baidu.sofire.core.c.1.PI com.baidu.sofire.core.c)
                 com.baidu.sofire.core.c.PG com.baidu.sofire.e)
                 com.baidu.sofire.e.a android.content.SharedPreferences)
                  ("iio")
                  false
                 type: INTERFACE call: android.content.SharedPreferences.getBoolean(java.lang.String, boolean):boolean)] */
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                        c.this.PH.d();
                        com.baidu.sofire.b.a();
                        new StringBuilder().append(c.this.PG.a.getBoolean("iio", false)).toString();
                        com.baidu.sofire.b.a();
                        if (!c.this.PG.a.getBoolean("iio", false)) {
                            com.baidu.sofire.e eVar2 = c.this.PG;
                            eVar2.PS.putBoolean("iio", true);
                            eVar2.PS.commit();
                        } else {
                            com.baidu.sofire.a.a aVar = c.this.PH;
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("n", (Integer) 0);
                            aVar.Pv.update("pgn", contentValues, "n=-1", null);
                        }
                        new U(c.this.e, 1, false).start();
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                    } catch (Throwable th) {
                        com.baidu.sofire.b.d.a(th);
                    }
                }
            }.start();
        }
    }

    public final void c() {
        List<ApkInfo> a2 = this.PH.a();
        String str = "all=" + a2;
        com.baidu.sofire.b.a();
        final List<Integer> c = this.PG.c();
        List<Integer> b = this.PG.b();
        for (int i = 0; i < b.size(); i++) {
            if (!c.contains(b.get(i))) {
                c.add(b.get(i));
            }
        }
        Collections.sort(a2, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.core.c.2
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
        for (ApkInfo apkInfo : a2) {
            e nk = e.nk();
            if ((nk != null ? nk.bS(apkInfo.packageName) : null) == null) {
                if (this.PG.a.getBoolean("bka", true)) {
                    File file = new File(this.e.getFilesDir(), ".b");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(apkInfo.pkgPath);
                    File file3 = new File(file, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                    if (!com.baidu.sofire.b.d.n(file3)) {
                        com.baidu.sofire.b.d.a(file2, file3);
                    }
                    com.baidu.sofire.c.a(file2, file3);
                }
                a(apkInfo.key, apkInfo.versionName, null);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v25 com.baidu.sofire.core.ApkInfo)] */
    public final void b(Context context) {
        String str;
        String str2;
        try {
            if (!this.PG.a.getBoolean("lpcf", false)) {
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
                this.PG.a(arrayList);
                if (hashMap.size() <= 0) {
                    com.baidu.sofire.e eVar = this.PG;
                    eVar.PS.putBoolean("lpcf", true);
                    eVar.PS.commit();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                Context context2 = this.e;
                String sb2 = sb.append(com.baidu.sofire.b.d.a()).append("plugin/v1/plugins/info").toString();
                String[] e = com.baidu.sofire.b.d.e(context);
                if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                    str = e[0];
                    str2 = e[1];
                } else {
                    str = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                    str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                }
                JSONArray jSONArray2 = new JSONArray();
                for (ApkInfo apkInfo2 : hashMap.values()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pk", apkInfo2.packageName);
                    jSONObject.put("m", apkInfo2.apkMD5);
                    jSONObject.put("l", apkInfo2.key);
                    jSONObject.put("v", apkInfo2.versionName);
                    jSONArray2.put(jSONObject);
                }
                String jSONArray3 = jSONArray2.toString();
                com.baidu.sofire.b.a();
                String a2 = com.baidu.sofire.b.f.a(context, sb2, jSONArray3, str, str2, false);
                String str3 = a2;
                com.baidu.sofire.b.a();
                JSONArray jSONArray4 = new JSONArray(a2);
                if (jSONArray4.length() > 0) {
                    com.baidu.sofire.e eVar2 = this.PG;
                    eVar2.PS.putBoolean("lpcf", true);
                    eVar2.PS.commit();
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
                                    if (!TextUtils.isEmpty(activityInfo.name) && activityInfo.name.startsWith(".")) {
                                        activityInfo.name = packageInfo.packageName + activityInfo.name;
                                    }
                                    activityInfo.packageName = packageInfo.packageName;
                                    activityInfo.theme = jSONObject2.optInt(Info.kBaiduTimeKey);
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
                        new StringBuilder().append(apkInfo3).toString();
                        com.baidu.sofire.b.a();
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [598=7, 600=6, 601=5, 605=6, 607=5, 608=6] */
    private void a(int r9, java.lang.String r10, java.lang.String r11, android.content.pm.PackageInfo r12) {
        /*
            r8 = this;
            r1 = 0
            com.baidu.sofire.a.a r0 = r8.PH     // Catch: java.lang.Throwable -> L107
            com.baidu.sofire.core.ApkInfo r0 = r0.aW(r9)     // Catch: java.lang.Throwable -> L107
            if (r0 == 0) goto L73
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> L107
            boolean r0 = com.baidu.sofire.b.d.c(r10, r0)     // Catch: java.lang.Throwable -> L107
            if (r0 != 0) goto L12
        L11:
            return
        L12:
            com.baidu.sofire.a.a r0 = r8.PH     // Catch: java.lang.Throwable -> L107
            com.baidu.sofire.core.ApkInfo r0 = r0.aW(r9)     // Catch: java.lang.Throwable -> L107
            if (r0 == 0) goto L73
            com.baidu.sofire.a.a r2 = r8.PH     // Catch: java.lang.Throwable -> L107
            r2.g(r9)     // Catch: java.lang.Throwable -> L107
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L107
            java.lang.String r0 = r0.pkgPath     // Catch: java.lang.Throwable -> L107
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L107
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L107
            r0.<init>()     // Catch: java.lang.Throwable -> L107
            java.lang.String r3 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L107
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L107
            java.lang.String r3 = ", e="
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L107
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L107
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L107
            r0.toString()     // Catch: java.lang.Throwable -> L107
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L107
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L107
            if (r0 == 0) goto L73
            com.baidu.sofire.c.a(r2)     // Catch: java.lang.Throwable -> L107
            boolean r0 = r2.delete()     // Catch: java.lang.Throwable -> L107
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L107
            r3.<init>()     // Catch: java.lang.Throwable -> L107
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L107
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch: java.lang.Throwable -> L107
            java.lang.String r3 = " s="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L107
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L107
            r0.toString()     // Catch: java.lang.Throwable -> L107
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L107
        L73:
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L268
            if (r0 != 0) goto L27e
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L268
            android.content.Context r2 = r8.e     // Catch: java.lang.Throwable -> L268
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L268
            java.lang.String r3 = ".tmp"
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L268
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L268
            if (r2 != 0) goto L90
            r0.mkdir()     // Catch: java.lang.Throwable -> L268
        L90:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L268
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L268
            r3.<init>()     // Catch: java.lang.Throwable -> L268
            java.lang.StringBuilder r3 = r3.append(r9)     // Catch: java.lang.Throwable -> L268
            java.lang.String r4 = "-"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L268
            java.lang.StringBuilder r3 = r3.append(r10)     // Catch: java.lang.Throwable -> L268
            java.lang.String r4 = ".zip"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L268
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L268
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L268
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L26d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L26d
            android.content.Context r0 = r8.e     // Catch: java.lang.Throwable -> L274
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> L274
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L274
            java.io.InputStream r1 = r0.open(r4)     // Catch: java.lang.Throwable -> L274
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> Ld7
        Lcb:
            int r4 = r1.read(r0)     // Catch: java.lang.Throwable -> Ld7
            r5 = -1
            if (r4 == r5) goto L10d
            r5 = 0
            r3.write(r0, r5, r4)     // Catch: java.lang.Throwable -> Ld7
            goto Lcb
        Ld7:
            r0 = move-exception
            r7 = r2
            r2 = r3
            r3 = r1
            r1 = r7
        Ldc:
            com.baidu.sofire.b.d.a(r0)     // Catch: java.lang.Throwable -> L264
            if (r1 == 0) goto L228
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L264
            if (r0 == 0) goto L228
            com.baidu.sofire.c.a(r1)     // Catch: java.lang.Throwable -> L264
            com.baidu.sofire.a.a r0 = r8.PH     // Catch: java.lang.Throwable -> L264
            r0.g(r9)     // Catch: java.lang.Throwable -> L264
            r1.delete()     // Catch: java.lang.Throwable -> L264
            if (r3 == 0) goto Lf7
            r3.close()     // Catch: java.io.IOException -> L21f
        Lf7:
            if (r2 == 0) goto L11
            r2.close()     // Catch: java.io.IOException -> Lfe
            goto L11
        Lfe:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L11
        L107:
            r0 = move-exception
            com.baidu.sofire.b.d.a(r0)
            goto L73
        L10d:
            r3.flush()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r0 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Ld7
            r4 = 1
            com.baidu.sofire.b.d.a(r0, r4)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r4 = "f: "
            r0.<init>(r4)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r4 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r4 = ", l="
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Throwable -> Ld7
            long r4 = r2.length()     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Throwable -> Ld7
            r0.toString()     // Catch: java.lang.Throwable -> Ld7
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r0 = com.baidu.sofire.b.j.a(r2)     // Catch: java.lang.Throwable -> Ld7
            if (r0 == 0) goto L149
            boolean r4 = r0.equalsIgnoreCase(r11)     // Catch: java.lang.Throwable -> Ld7
            if (r4 != 0) goto L167
        L149:
            r2.delete()     // Catch: java.lang.Throwable -> Ld7
            if (r1 == 0) goto L151
            r1.close()     // Catch: java.io.IOException -> L15f
        L151:
            r3.close()     // Catch: java.io.IOException -> L156
            goto L11
        L156:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L11
        L15f:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L151
        L167:
            com.baidu.sofire.core.ApkInfo r4 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r5 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Ld7
            r4.<init>(r9, r10, r5)     // Catch: java.lang.Throwable -> Ld7
            r4.apkMD5 = r0     // Catch: java.lang.Throwable -> Ld7
            r0 = 1
            r4.priority = r0     // Catch: java.lang.Throwable -> Ld7
            com.baidu.sofire.a.a r0 = r8.PH     // Catch: java.lang.Throwable -> Ld7
            r0.a(r4)     // Catch: java.lang.Throwable -> Ld7
            com.baidu.sofire.e r0 = r8.PG     // Catch: java.lang.Throwable -> Ld7
            android.content.SharedPreferences r0 = r0.a     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r4 = "bka"
            r5 = 1
            boolean r0 = r0.getBoolean(r4, r5)     // Catch: java.lang.Throwable -> Ld7
            if (r0 == 0) goto L1c2
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> Ld7
            android.content.Context r4 = r8.e     // Catch: java.lang.Throwable -> Ld7
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r5 = ".b"
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> Ld7
            boolean r4 = r0.exists()     // Catch: java.lang.Throwable -> Ld7
            if (r4 != 0) goto L19f
            r0.mkdir()     // Catch: java.lang.Throwable -> Ld7
        L19f:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            r5.<init>()     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r5 = r5.append(r9)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Ld7
            r4.<init>(r0, r5)     // Catch: java.lang.Throwable -> Ld7
            com.baidu.sofire.b.d.a(r2, r4)     // Catch: java.lang.Throwable -> Ld7
            com.baidu.sofire.c.a(r2, r4)     // Catch: java.lang.Throwable -> Ld7
        L1c2:
            r7 = r2
            r2 = r3
            r3 = r1
            r1 = r7
        L1c6:
            com.baidu.sofire.a.a r0 = r8.PH     // Catch: java.lang.Throwable -> L27b
            com.baidu.sofire.core.ApkInfo r0 = r0.aW(r9)     // Catch: java.lang.Throwable -> L27b
            if (r0 == 0) goto L1d6
            java.lang.String r0 = r0.pkgPath     // Catch: java.lang.Throwable -> L27b
            boolean r0 = com.baidu.sofire.b.d.a(r0)     // Catch: java.lang.Throwable -> L27b
            if (r0 != 0) goto L1f3
        L1d6:
            if (r3 == 0) goto L1db
            r3.close()     // Catch: java.io.IOException -> L1eb
        L1db:
            if (r2 == 0) goto L11
            r2.close()     // Catch: java.io.IOException -> L1e2
            goto L11
        L1e2:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L11
        L1eb:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L1db
        L1f3:
            boolean r0 = r8.a(r9, r10, r12)     // Catch: java.lang.Throwable -> L27b
            if (r0 == 0) goto L202
            java.util.List<java.lang.Integer> r0 = com.baidu.sofire.core.c.a     // Catch: java.lang.Throwable -> L27b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L27b
            r0.add(r4)     // Catch: java.lang.Throwable -> L27b
        L202:
            if (r3 == 0) goto L207
            r3.close()     // Catch: java.io.IOException -> L217
        L207:
            if (r2 == 0) goto L11
            r2.close()     // Catch: java.io.IOException -> L20e
            goto L11
        L20e:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L11
        L217:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L207
        L21f:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto Lf7
        L228:
            if (r3 == 0) goto L22d
            r3.close()     // Catch: java.io.IOException -> L23d
        L22d:
            if (r2 == 0) goto L11
            r2.close()     // Catch: java.io.IOException -> L234
            goto L11
        L234:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L11
        L23d:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L22d
        L245:
            r0 = move-exception
            r3 = r1
        L247:
            if (r1 == 0) goto L24c
            r1.close()     // Catch: java.io.IOException -> L252
        L24c:
            if (r3 == 0) goto L251
            r3.close()     // Catch: java.io.IOException -> L25a
        L251:
            throw r0
        L252:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.b()
            goto L24c
        L25a:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.b()
            goto L251
        L262:
            r0 = move-exception
            goto L247
        L264:
            r0 = move-exception
            r1 = r3
            r3 = r2
            goto L247
        L268:
            r0 = move-exception
            r2 = r1
            r3 = r1
            goto Ldc
        L26d:
            r0 = move-exception
            r3 = r1
            r7 = r1
            r1 = r2
            r2 = r7
            goto Ldc
        L274:
            r0 = move-exception
            r7 = r2
            r2 = r3
            r3 = r1
            r1 = r7
            goto Ldc
        L27b:
            r0 = move-exception
            goto Ldc
        L27e:
            r2 = r1
            r3 = r1
            goto L1c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.c.a(int, java.lang.String, java.lang.String, android.content.pm.PackageInfo):void");
    }

    public final synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        return a(i, str, false, packageInfo);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r11v0 int)] */
    private synchronized boolean a(int i, String str, boolean z, PackageInfo packageInfo) {
        String str2;
        String str3;
        boolean z2;
        new StringBuilder().append(i).toString();
        com.baidu.sofire.b.a();
        if (z && this.PH.c(i) != 1) {
            z2 = false;
        } else {
            ApkInfo aW = this.PH.aW(i);
            if (aW == null) {
                com.baidu.sofire.b.a();
                HashMap hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", new StringBuilder().append(i).toString());
                hashMap.put("2", str);
                if (!z) {
                    com.baidu.sofire.b.d.a(this.e, "1003105", hashMap);
                }
                z2 = false;
            } else {
                File file = new File(aW.pkgPath);
                file.getAbsolutePath();
                com.baidu.sofire.b.a();
                if (!com.baidu.sofire.b.d.n(file)) {
                    com.baidu.sofire.b.a();
                    this.PH.f(i);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", 3);
                    hashMap2.put("1", new StringBuilder().append(i).toString());
                    hashMap2.put("2", str);
                    if (!z) {
                        com.baidu.sofire.b.d.a(this.e, "1003105", hashMap2);
                    }
                    z2 = false;
                } else {
                    if (packageInfo != null) {
                        aW.cloudPkgInfo = packageInfo;
                    }
                    e aq = e.aq(this.e.getApplicationContext());
                    com.baidu.sofire.b.a();
                    if (!aq.a(aW, false)) {
                        this.PH.f(i);
                        aq.a(aW.pkgPath);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("0", 4);
                        hashMap3.put("1", new StringBuilder().append(i).toString());
                        hashMap3.put("2", str);
                        if (!z) {
                            com.baidu.sofire.b.d.a(this.e, "1003105", hashMap3);
                        }
                        com.baidu.sofire.b.a();
                        z2 = false;
                    } else {
                        com.baidu.sofire.b.a();
                        String[] e = com.baidu.sofire.b.d.e(this.e);
                        if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                            String str4 = e[0];
                            str2 = e[1];
                            str3 = str4;
                        } else {
                            str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                            str3 = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                        }
                        String str5 = "ak=" + str3 + ", sk=" + str2;
                        com.baidu.sofire.b.a();
                        ApkInfo bP = aq.bP(aW.pkgPath);
                        d dVar = (d) bP.classLoader;
                        Class<?> bR = dVar.bR("com.baidu.sofire.engine.EngineImpl");
                        if (bR == null) {
                            com.baidu.sofire.b.a();
                            Class<?> bR2 = dVar.bR("java.lang.String");
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("0", 9);
                            hashMap4.put("1", new StringBuilder().append(i).toString());
                            hashMap4.put("2", str);
                            hashMap4.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, Base64.encodeToString(("classloader=" + dVar + ",StringClass=" + bR2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                            if (!z) {
                                com.baidu.sofire.b.d.a(this.e, "1003105", hashMap4);
                            }
                            this.PH.f(i);
                            z2 = false;
                        } else {
                            Object invoke = bR.getDeclaredMethod("getInstance", Context.class).invoke(bR, this.e);
                            String str6 = "ai=" + invoke;
                            com.baidu.sofire.b.a();
                            try {
                                com.baidu.sofire.b.d.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str2);
                            } catch (Throwable th) {
                                com.baidu.sofire.b.d.a(th);
                            }
                            if (!((Boolean) com.baidu.sofire.b.d.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(bP.runStatus), Boolean.valueOf(this.PG.a.getBoolean("hac", false)))).booleanValue()) {
                                HashMap hashMap5 = new HashMap();
                                hashMap5.put("0", 6);
                                hashMap5.put("1", new StringBuilder().append(i).toString());
                                hashMap5.put("2", str);
                                if (!z) {
                                    com.baidu.sofire.b.d.a(this.e, "1003105", hashMap5);
                                }
                                this.PH.f(i);
                                aq.a(bP.pkgPath);
                                com.baidu.sofire.b.a();
                                z2 = false;
                            } else {
                                bP.initStatus = 1;
                                bP.apkParseSuc = 1;
                                this.PH.a(bP);
                                com.baidu.sofire.b.a();
                                HashMap hashMap6 = new HashMap();
                                hashMap6.put("0", 0);
                                hashMap6.put("1", Integer.valueOf(i));
                                hashMap6.put("2", str);
                                if (!z) {
                                    com.baidu.sofire.b.d.a(this.e, "1003105", hashMap6);
                                }
                                com.baidu.sofire.b.d.a(this.e);
                                z2 = true;
                            }
                        }
                    }
                }
            }
        }
        return z2;
    }

    public final void b(String str, String str2) {
        this.PH.a(str);
        File file = new File(str2);
        String str3 = "f=" + file.getAbsolutePath() + ", e=" + file.exists();
        com.baidu.sofire.b.a();
        if (file.exists()) {
            com.baidu.sofire.c.a(file);
            r0 = file.getAbsolutePath() + " s=" + file.delete();
            com.baidu.sofire.b.a();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r13v0 com.baidu.sofire.core.ApkInfo)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v2 com.baidu.sofire.core.ApkInfo)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x0416: INVOKE  (r0v48 boolean A[REMOVE]) = (r0v42 java.io.File) type: VIRTUAL call: java.io.File.delete():boolean)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x003f: IGET  (r4v42 int A[REMOVE]) = (r13v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x013b: IGET  (r4v40 int A[REMOVE]) = (r13v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01dd: IGET  (r7v4 int A[REMOVE]) = (r13v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02fc: IGET  (r4v25 int A[REMOVE]) = (r13v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x035d: IGET  (r5v1 int A[REMOVE]) = (r13v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0469: IGET  (r4v20 int A[REMOVE]) = (r13v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    public final boolean a(ApkInfo apkInfo, String str) {
        String str2;
        String str3;
        new StringBuilder().append(apkInfo).toString();
        com.baidu.sofire.b.a();
        if (apkInfo == null) {
            return false;
        }
        File file = new File(apkInfo.pkgPath);
        try {
            if (!com.baidu.sofire.b.d.n(file)) {
                com.baidu.sofire.b.a();
                HashMap hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap.put("2", apkInfo.versionName);
                hashMap.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, Base64.encodeToString(("nowTime:" + System.currentTimeMillis() + ", nowFileInfo: path=" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length() + " - " + str).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.d.a(this.e, "1003106", hashMap);
                return false;
            }
            if (!this.PH.b(apkInfo.key)) {
                this.PH.a(apkInfo);
            }
            e aq = e.aq(this.e.getApplicationContext());
            this.PH.a(apkInfo.key, 1);
            b(apkInfo.packageName);
            if (!aq.a(apkInfo, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                hashMap2.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap2.put("2", apkInfo.versionName);
                com.baidu.sofire.b.d.a(this.e, "1003106", hashMap2);
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.PH.a(apkInfo.key, 0);
                return false;
            }
            String[] e = com.baidu.sofire.b.d.e(this.e);
            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                str2 = e[0];
                str3 = e[1];
            } else {
                str2 = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                str3 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            ApkInfo bP = aq.bP(apkInfo.pkgPath);
            if (bP == null) {
                return false;
            }
            d dVar = (d) bP.classLoader;
            Class<?> bR = dVar.bR("com.baidu.sofire.engine.EngineImpl");
            if (bR == null) {
                com.baidu.sofire.b.a();
                Class<?> bR2 = dVar.bR("java.lang.String");
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 6);
                hashMap3.put("1", new StringBuilder().append(bP.key).toString());
                hashMap3.put("2", bP.versionName);
                hashMap3.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, Base64.encodeToString(("classloader=" + dVar + ",StringClass=" + bR2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.d.a(this.e, "1003106", hashMap3);
                com.baidu.sofire.c.a(file);
                file.delete();
                this.PH.a(bP.key, 0);
                return false;
            }
            Object invoke = bR.getDeclaredMethod("getInstance", Context.class).invoke(bR, this.e);
            com.baidu.sofire.b.d.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
            if (!((Boolean) com.baidu.sofire.b.d.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(bP.runStatus), Boolean.valueOf(this.PG.a.getBoolean("hac", false)))).booleanValue()) {
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                b(bP.packageName);
                file.delete();
                a(bP.key, bP.versionName, true, (PackageInfo) null);
                this.PH.a(bP.key, 0);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("0", 4);
                hashMap4.put("1", new StringBuilder().append(bP.key).toString());
                hashMap4.put("2", bP.versionName);
                com.baidu.sofire.b.d.a(this.e, "1003106", hashMap4);
                return false;
            }
            if (bP.isMem) {
                com.baidu.sofire.c.a(file);
                file.delete();
                com.baidu.sofire.b.d.b(bP.dataDir);
                if (e.a != null) {
                    e.a.add(Integer.valueOf(bP.key));
                }
            }
            com.baidu.sofire.b.a();
            try {
                ApkInfo aW = this.PH.aW(bP.key);
                new StringBuilder().append(aW).toString();
                com.baidu.sofire.b.a();
                File file2 = (aW == null || aW.versionName.equals(bP.versionName)) ? null : new File(aW.pkgPath);
                bP.initStatus = 1;
                bP.apkParseSuc = 1;
                long a2 = this.PH.a(bP);
                if (a2 > 0 && file2 != null && file2.exists()) {
                    com.baidu.sofire.c.a(file2);
                    new StringBuilder().append(file2.delete()).toString();
                    com.baidu.sofire.b.a();
                }
                String str4 = a2 + ", c=" + this.PH.a(bP.key, 0);
                com.baidu.sofire.b.a();
                com.baidu.sofire.b.d.a(this.e);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("0", 0);
                hashMap5.put("1", new StringBuilder().append(bP.key).toString());
                hashMap5.put("2", bP.versionName);
                com.baidu.sofire.b.d.a(this.e, "1003106", hashMap5);
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
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
                this.PH.a(apkInfo.key, 0);
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 5);
                hashMap6.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap6.put("2", apkInfo.versionName);
                hashMap6.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, Base64.encodeToString(com.baidu.sofire.b.a(th2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.b.d.a(this.e, "1003106", hashMap6);
            } catch (Throwable th3) {
                com.baidu.sofire.b.d.a(th3);
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.sofire.core.c$3] */
    public final void a(final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            String str2 = str;
            com.baidu.sofire.b.a();
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
            } else {
                new Thread() { // from class: com.baidu.sofire.core.c.3
                    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v16 java.lang.Object)] */
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        ApkInfo apkInfo;
                        boolean z;
                        super.run();
                        try {
                            if (callback != null) {
                                callback.onBegin(new Object[0]);
                            }
                            boolean aX = c.this.PH.aX(i);
                            String str3 = "u=" + aX;
                            com.baidu.sofire.b.a();
                            if (aX) {
                                long currentTimeMillis = System.currentTimeMillis();
                                while (c.this.PH.aX(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                                    com.baidu.sofire.b.a();
                                    SystemClock.sleep(300L);
                                }
                            }
                            String str4 = "isUpdating=" + aX;
                            com.baidu.sofire.b.a();
                            if (!c.this.PH.aX(i)) {
                                if (!c.this.b) {
                                    c.a(3);
                                    c.this.b();
                                }
                                e aq = e.aq(c.this.e.getApplicationContext());
                                ApkInfo apkInfo2 = null;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                while (System.currentTimeMillis() - currentTimeMillis2 <= 120000) {
                                    com.baidu.sofire.b.a();
                                    apkInfo2 = c.this.PH.aW(i);
                                    if (apkInfo2 != null) {
                                        if (aq.bS(apkInfo2.packageName) == null) {
                                            if (apkInfo2.initStatus == -1) {
                                                break;
                                            }
                                        } else {
                                            apkInfo = apkInfo2;
                                            z = true;
                                            break;
                                        }
                                    }
                                    SystemClock.sleep(1000L);
                                }
                                apkInfo = apkInfo2;
                                z = false;
                                if (!z) {
                                    if (callback != null) {
                                        callback.onError(4);
                                        return;
                                    }
                                    return;
                                }
                                Class<?> bR = ((d) aq.bS(apkInfo.packageName).classLoader).bR("com.baidu.sofire.engine.EngineImpl");
                                Object a2 = com.baidu.sofire.b.d.a(bR.getDeclaredMethod("getInstance", Context.class).invoke(bR, c.this.e), str, clsArr, objArr);
                                try {
                                    new StringBuilder().append(a2).toString();
                                    com.baidu.sofire.b.a();
                                } catch (Throwable th) {
                                    com.baidu.sofire.b.d.a(th);
                                }
                                if (callback != null) {
                                    callback.onEnd(a2);
                                }
                            } else if (callback != null) {
                                callback.onError(3);
                            }
                        } catch (IllegalAccessException e) {
                            e.getMessage();
                            com.baidu.sofire.b.b();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (IllegalArgumentException e2) {
                            e2.getMessage();
                            com.baidu.sofire.b.b();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (NoSuchMethodException e3) {
                            e3.getMessage();
                            com.baidu.sofire.b.b();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (InvocationTargetException e4) {
                            e4.getMessage();
                            com.baidu.sofire.b.b();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (Throwable th2) {
                            th2.getMessage();
                            com.baidu.sofire.b.b();
                            if (callback != null) {
                                callback.onError(3);
                            }
                        }
                    }
                }.start();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v9 java.lang.Object)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v4 boolean)] */
    public final Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        boolean z = false;
        String str2 = str;
        com.baidu.sofire.b.a();
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            boolean aX = this.PH.aX(i);
            new StringBuilder().append(aX).toString();
            com.baidu.sofire.b.a();
            if (aX) {
                return new Pair<>(3, null);
            }
            if (!this.b) {
                return new Pair<>(3, null);
            }
            e nk = e.nk();
            if (nk == null) {
                return new Pair<>(3, null);
            }
            ApkInfo aW = this.PH.aW(i);
            if (aW != null && nk.bS(aW.packageName) != null) {
                z = true;
            }
            if (!z) {
                return new Pair<>(4, null);
            }
            Class<?> bR = ((d) nk.bS(aW.packageName).classLoader).bR("com.baidu.sofire.engine.EngineImpl");
            Object a2 = com.baidu.sofire.b.d.a(bR.getDeclaredMethod("getInstance", Context.class).invoke(bR, this.e), str, clsArr, objArr);
            try {
                new StringBuilder().append(a2).toString();
                com.baidu.sofire.b.a();
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
            }
            return new Pair<>(0, a2);
        } catch (IllegalAccessException e) {
            e.getMessage();
            com.baidu.sofire.b.b();
            return new Pair<>(2, null);
        } catch (IllegalArgumentException e2) {
            e2.getMessage();
            com.baidu.sofire.b.b();
            return new Pair<>(2, null);
        } catch (NoSuchMethodException e3) {
            e3.getMessage();
            com.baidu.sofire.b.b();
            return new Pair<>(2, null);
        } catch (InvocationTargetException e4) {
            e4.getMessage();
            com.baidu.sofire.b.b();
            return new Pair<>(2, null);
        } catch (Throwable th2) {
            th2.getMessage();
            com.baidu.sofire.b.b();
            return new Pair<>(3, null);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0051: INVOKE  (r0v9 java.lang.Object A[REMOVE]) = 
      (r0v8 java.lang.Object)
      ("unload")
      (null java.lang.Class[])
      (wrap: java.lang.Object[] : 0x004f: NEW_ARRAY  (r4v3 java.lang.Object[] A[REMOVE]) = (0 int) type: java.lang.Object[])
     type: STATIC call: com.baidu.sofire.b.d.a(java.lang.Object, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object)] */
    private void b(String str) {
        e nk;
        ApkInfo bS;
        String str2 = str;
        com.baidu.sofire.b.a();
        try {
            if (!TextUtils.isEmpty(str) && (nk = e.nk()) != null && (bS = nk.bS(str)) != null) {
                Class<?> bR = ((d) bS.classLoader).bR("com.baidu.sofire.engine.EngineImpl");
                Object invoke = bR.getDeclaredMethod("getInstance", Context.class).invoke(bR, this.e);
                if (invoke != null) {
                    new StringBuilder().append(com.baidu.sofire.b.d.a(invoke, "unload", null, new Object[0])).toString();
                    com.baidu.sofire.b.a();
                    nk.b(str);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.b();
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.sofire.core.c$4] */
    public final void a(final String str) {
        try {
            String str2 = str;
            com.baidu.sofire.b.a();
            new Thread() { // from class: com.baidu.sofire.core.c.4
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    super.run();
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            final e aq = e.aq(c.this.e.getApplicationContext());
                            r0 = str + ", h=" + aq;
                            com.baidu.sofire.b.a();
                            if (aq != null) {
                                final ApkInfo bS = aq.bS(str);
                                r0 = str + ", i=" + bS;
                                com.baidu.sofire.b.a();
                                if (bS == null) {
                                    c.this.b(str, c.this.PH.bP(str).pkgPath);
                                } else {
                                    Class<?> bR = ((d) bS.classLoader).bR("com.baidu.sofire.engine.EngineImpl");
                                    Object invoke = bR.getDeclaredMethod("getInstance", Context.class).invoke(bR, c.this.e);
                                    r0 = str + ", i=" + invoke;
                                    com.baidu.sofire.b.a();
                                    if (invoke != null) {
                                        r0 = "t:" + System.currentTimeMillis();
                                        com.baidu.sofire.b.a();
                                        new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.core.c.4.1
                                            /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0005: INVOKE  (r2v0 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
                                            @Override // java.util.TimerTask, java.lang.Runnable
                                            public final void run() {
                                                new StringBuilder().append(System.currentTimeMillis()).toString();
                                                com.baidu.sofire.b.a();
                                                aq.b(str);
                                                c.this.PH.a(str);
                                                File file = new File(bS.pkgPath);
                                                String str3 = "f=" + file.getAbsolutePath() + ", e=" + file.exists();
                                                com.baidu.sofire.b.a();
                                                if (file.exists()) {
                                                    com.baidu.sofire.c.a(file);
                                                    r0 = "d: " + file.getAbsolutePath() + " s=" + file.delete();
                                                    com.baidu.sofire.b.a();
                                                }
                                            }
                                        }, 600000L);
                                        String str3 = str + ", CommonMethods.callMethodOfClass result object=" + com.baidu.sofire.b.d.a(invoke, "unload", null, new Object[0]);
                                        com.baidu.sofire.b.a();
                                        aq.b(str);
                                        c.this.PH.a(str);
                                        File file = new File(bS.pkgPath);
                                        String str4 = "f=" + file.getAbsolutePath() + ", e=" + file.exists();
                                        com.baidu.sofire.b.a();
                                        if (file.exists()) {
                                            com.baidu.sofire.c.a(file);
                                            String str5 = "d: " + file.getAbsolutePath() + " s=" + file.delete();
                                            com.baidu.sofire.b.a();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                        com.baidu.sofire.b.b();
                    }
                }
            }.start();
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    public static void a(int i) {
        if (f == 0) {
            f = i;
        }
    }
}
