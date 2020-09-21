package com.baidu.sofire.core;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.util.FieldUtil;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.rp.Report;
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
/* loaded from: classes12.dex */
public final class c implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static Context b;
    private static c e;
    public com.baidu.sofire.e a;
    private volatile boolean d = false;
    private com.baidu.sofire.g f;
    private com.baidu.sofire.c.a h;
    private static int g = 0;
    public static List<Integer> c = new ArrayList();

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            try {
                if (str.equals("xytk")) {
                    com.baidu.sofire.b.a();
                    d.a = this.f.a();
                }
                if (str.equals("xyus")) {
                    this.a.l();
                    com.baidu.sofire.b.a();
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
        }
    }

    private c(Context context) {
        com.baidu.sofire.b.a();
        b = context.getApplicationContext();
        this.h = com.baidu.sofire.c.a.a(b);
        this.a = new com.baidu.sofire.e(b);
        this.f = new com.baidu.sofire.g(b);
        com.baidu.sofire.g gVar = this.f;
        if (gVar.a == null) {
            return;
        }
        gVar.a.registerOnSharedPreferenceChangeListener(this);
    }

    public static c a() {
        return e;
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (e == null) {
                e = new c(context.getApplicationContext());
            }
            cVar = e;
        }
        return cVar;
    }

    public final synchronized void b() {
        String str;
        if (!this.d) {
            this.d = true;
            com.baidu.sofire.i.e.n(b);
            this.a.a(true);
            JSONObject o = com.baidu.sofire.i.e.o(b);
            com.baidu.sofire.i.e.d(b);
            new StringBuilder().append(this.d);
            com.baidu.sofire.b.a();
            com.baidu.sofire.e eVar = this.a;
            eVar.c.putString("ssv", "3.4.4.1");
            eVar.c.commit();
            Report.getInstance(b).n();
            for (ApkInfo apkInfo : this.h.a()) {
                try {
                    str = b.getFilesDir().getCanonicalPath();
                } catch (IOException e2) {
                    str = null;
                    com.baidu.sofire.i.e.a();
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/." + apkInfo.key;
                    com.baidu.sofire.i.e.d(apkInfo.dataDir + "/lib");
                }
            }
            this.h.d();
            com.baidu.sofire.b.a();
            new StringBuilder().append(this.a.a());
            com.baidu.sofire.b.a();
            if (!this.a.a()) {
                com.baidu.sofire.e eVar2 = this.a;
                eVar2.c.putBoolean("iio", true);
                eVar2.c.commit();
            } else {
                com.baidu.sofire.c.a aVar = this.h;
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", (Integer) 0);
                aVar.c.update("pgn", contentValues, "n=-1", null);
            }
            new U(b, 1, false, o).start();
        }
    }

    public final void c() {
        try {
            List<ApkInfo> a = this.h.a();
            new StringBuilder("all=").append(a);
            com.baidu.sofire.b.a();
            final List<Integer> r = this.a.r();
            List<Integer> q = this.a.q();
            for (int i = 0; i < q.size(); i++) {
                if (!r.contains(q.get(i))) {
                    r.add(q.get(i));
                }
            }
            Collections.sort(a, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.core.c.1
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
                            int indexOf = (r == null || !r.contains(Integer.valueOf(apkInfo3.key))) ? -1 : r.indexOf(Integer.valueOf(apkInfo3.key));
                            int indexOf2 = (r == null || !r.contains(Integer.valueOf(apkInfo4.key))) ? -1 : r.indexOf(Integer.valueOf(apkInfo4.key));
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
                f a2 = f.a();
                if ((a2 != null ? a2.d(apkInfo.packageName) : null) == null) {
                    boolean z = true;
                    if (this.h.g(apkInfo.key) == 3) {
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
                        if (!com.baidu.sofire.i.e.a(file3)) {
                            com.baidu.sofire.i.e.a(file2, file3);
                        }
                        com.baidu.sofire.c.a(b, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(b.getFilesDir(), ".b");
                        if (file4.exists()) {
                            File file5 = new File(file4, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                            if (com.baidu.sofire.i.e.a(file5)) {
                                com.baidu.sofire.c.a(file5);
                                new StringBuilder().append(file5.getAbsolutePath()).append(" s=").append(file5.delete());
                                com.baidu.sofire.b.a();
                            }
                        }
                    }
                    a(apkInfo.key, apkInfo.versionName, null);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    public final void a(JSONObject jSONObject) {
        ApkInfo apkInfo;
        try {
            if (!this.a.t() && jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("6");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.a.s();
                }
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        int optInt = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                        int optInt2 = optJSONObject.optInt("l");
                        if (optInt == 1) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("detail");
                            PackageInfo packageInfo = new PackageInfo();
                            packageInfo.packageName = optJSONObject2.optString("p");
                            packageInfo.versionName = optJSONObject2.optString("v");
                            ApplicationInfo applicationInfo = new ApplicationInfo();
                            applicationInfo.className = optJSONObject2.optString("n");
                            if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(".")) {
                                applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                            }
                            applicationInfo.theme = optJSONObject2.optInt("t");
                            packageInfo.applicationInfo = applicationInfo;
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("a");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
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
                            if (com.baidu.sofire.i.e.h != null && (apkInfo = com.baidu.sofire.i.e.h.get(Integer.valueOf(optInt2))) != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                                a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                            }
                        }
                    }
                    if (com.baidu.sofire.i.e.h != null) {
                        com.baidu.sofire.i.e.h.clear();
                        com.baidu.sofire.i.e.h = null;
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [513=7, 515=6, 519=5, 521=6] */
    private void a(int r10, java.lang.String r11, java.lang.String r12, android.content.pm.PackageInfo r13) {
        /*
            r9 = this;
            r3 = 0
            r0 = 0
            r4 = 1
            com.baidu.sofire.c.a r1 = r9.h     // Catch: java.lang.Throwable -> L103
            com.baidu.sofire.core.ApkInfo r1 = r1.a(r10)     // Catch: java.lang.Throwable -> L103
            if (r1 == 0) goto L1c
            java.lang.String r1 = r1.versionName     // Catch: java.lang.Throwable -> L103
            boolean r1 = com.baidu.sofire.i.e.b(r11, r1)     // Catch: java.lang.Throwable -> L103
            if (r1 != 0) goto L14
        L13:
            return
        L14:
            com.baidu.sofire.c.a r1 = r9.h     // Catch: java.lang.Throwable -> Lfd
            com.baidu.sofire.core.ApkInfo r1 = r1.a(r10)     // Catch: java.lang.Throwable -> Lfd
            if (r1 != 0) goto Laa
        L1c:
            boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L25d
            if (r1 != 0) goto L276
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L25d
            android.content.Context r1 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L25d
            java.io.File r1 = r1.getFilesDir()     // Catch: java.lang.Throwable -> L25d
            java.lang.String r5 = ".tmp"
            r2.<init>(r1, r5)     // Catch: java.lang.Throwable -> L25d
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L25d
            if (r1 != 0) goto L39
            r2.mkdir()     // Catch: java.lang.Throwable -> L25d
        L39:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L25d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L25d
            r5.<init>()     // Catch: java.lang.Throwable -> L25d
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L25d
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L25d
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L25d
            java.lang.String r6 = ".zip"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L25d
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L25d
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L25d
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L262
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L262
            android.content.Context r5 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L269
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L269
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L269
            java.io.InputStream r0 = r5.open(r6)     // Catch: java.lang.Throwable -> L269
            r5 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L80
        L74:
            int r6 = r0.read(r5)     // Catch: java.lang.Throwable -> L80
            r7 = -1
            if (r6 == r7) goto L109
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
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L258
            if (r0 == 0) goto L21e
            boolean r3 = r0.exists()     // Catch: java.lang.Throwable -> L258
            if (r3 == 0) goto L21e
            com.baidu.sofire.c.a(r0)     // Catch: java.lang.Throwable -> L258
            com.baidu.sofire.c.a r3 = r9.h     // Catch: java.lang.Throwable -> L258
            r3.h(r10)     // Catch: java.lang.Throwable -> L258
            r0.delete()     // Catch: java.lang.Throwable -> L258
            if (r2 == 0) goto La0
            r2.close()     // Catch: java.io.IOException -> L245
        La0:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> La7
            goto L13
        La7:
            r0 = move-exception
            goto L13
        Laa:
            com.baidu.sofire.c.a r2 = r9.h     // Catch: java.lang.Throwable -> Lfd
            r2.h(r10)     // Catch: java.lang.Throwable -> Lfd
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lfd
            java.lang.String r1 = r1.pkgPath     // Catch: java.lang.Throwable -> Lfd
            r2.<init>(r1)     // Catch: java.lang.Throwable -> Lfd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfd
            r1.<init>()     // Catch: java.lang.Throwable -> Lfd
            java.lang.String r5 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Lfd
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Throwable -> Lfd
            java.lang.String r5 = ", e="
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Throwable -> Lfd
            boolean r5 = r2.exists()     // Catch: java.lang.Throwable -> Lfd
            r1.append(r5)     // Catch: java.lang.Throwable -> Lfd
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> Lfd
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> Lfd
            if (r1 == 0) goto L1c
            com.baidu.sofire.c.a(r2)     // Catch: java.lang.Throwable -> Lfd
            boolean r1 = r2.delete()     // Catch: java.lang.Throwable -> Lfd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfd
            r5.<init>()     // Catch: java.lang.Throwable -> Lfd
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Lfd
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch: java.lang.Throwable -> Lfd
            java.lang.String r5 = " s="
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Throwable -> Lfd
            r2.append(r1)     // Catch: java.lang.Throwable -> Lfd
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> Lfd
            goto L1c
        Lfd:
            r1 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L103
            goto L1c
        L103:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L1c
        L109:
            r2.flush()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6 = 1
            com.baidu.sofire.i.e.a(r5, r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = com.baidu.sofire.i.p.a(r1)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L120
            boolean r6 = r5.equalsIgnoreCase(r12)     // Catch: java.lang.Throwable -> L80
            if (r6 != 0) goto L130
        L120:
            r1.delete()     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L128
            r0.close()     // Catch: java.io.IOException -> L23d
        L128:
            r2.close()     // Catch: java.io.IOException -> L12d
            goto L13
        L12d:
            r0 = move-exception
            goto L13
        L130:
            com.baidu.sofire.core.ApkInfo r6 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6.<init>(r10, r11, r7)     // Catch: java.lang.Throwable -> L80
            r6.apkMD5 = r5     // Catch: java.lang.Throwable -> L80
            r5 = 1
            r6.priority = r5     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a r5 = r9.h     // Catch: java.lang.Throwable -> L80
            r5.a(r6)     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a r5 = r9.h     // Catch: java.lang.Throwable -> L80
            int r5 = r5.g(r10)     // Catch: java.lang.Throwable -> L80
            r6 = 3
            if (r5 != r6) goto L273
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L80
        L14f:
            com.baidu.sofire.e r4 = r9.a     // Catch: java.lang.Throwable -> L80
            boolean r4 = r4.c()     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L1be
            if (r3 == 0) goto L1be
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L80
            android.content.Context r4 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L80
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = ".b"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L80
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L80
            if (r4 != 0) goto L170
            r3.mkdir()     // Catch: java.lang.Throwable -> L80
        L170:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L80
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            boolean r3 = com.baidu.sofire.i.e.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L196
            com.baidu.sofire.i.e.a(r1, r4)     // Catch: java.lang.Throwable -> L80
        L196:
            android.content.Context r3 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a(r3, r10, r1, r4)     // Catch: java.lang.Throwable -> L80
            r8 = r1
            r1 = r2
            r2 = r0
            r0 = r8
        L19f:
            com.baidu.sofire.c.a r3 = r9.h     // Catch: java.lang.Throwable -> L270
            com.baidu.sofire.core.ApkInfo r3 = r3.a(r10)     // Catch: java.lang.Throwable -> L270
            if (r3 == 0) goto L1af
            java.lang.String r3 = r3.pkgPath     // Catch: java.lang.Throwable -> L270
            boolean r3 = com.baidu.sofire.i.e.c(r3)     // Catch: java.lang.Throwable -> L270
            if (r3 != 0) goto L200
        L1af:
            if (r2 == 0) goto L1b4
            r2.close()     // Catch: java.io.IOException -> L240
        L1b4:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> L1bb
            goto L13
        L1bb:
            r0 = move-exception
            goto L13
        L1be:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L80
            android.content.Context r4 = com.baidu.sofire.core.c.b     // Catch: java.lang.Throwable -> L80
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = ".b"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L80
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L1fb
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L80
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            boolean r3 = com.baidu.sofire.i.e.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto L1fb
            com.baidu.sofire.c.a(r4)     // Catch: java.lang.Throwable -> L80
            r4.delete()     // Catch: java.lang.Throwable -> L80
        L1fb:
            r8 = r1
            r1 = r2
            r2 = r0
            r0 = r8
            goto L19f
        L200:
            boolean r3 = r9.a(r10, r11, r13)     // Catch: java.lang.Throwable -> L270
            if (r3 == 0) goto L20f
            java.util.List<java.lang.Integer> r3 = com.baidu.sofire.core.c.c     // Catch: java.lang.Throwable -> L270
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L270
            r3.add(r4)     // Catch: java.lang.Throwable -> L270
        L20f:
            if (r2 == 0) goto L214
            r2.close()     // Catch: java.io.IOException -> L243
        L214:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> L21b
            goto L13
        L21b:
            r0 = move-exception
            goto L13
        L21e:
            if (r2 == 0) goto L223
            r2.close()     // Catch: java.io.IOException -> L248
        L223:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> L22a
            goto L13
        L22a:
            r0 = move-exception
            goto L13
        L22d:
            r1 = move-exception
            r2 = r0
            r8 = r1
            r1 = r0
            r0 = r8
        L232:
            if (r1 == 0) goto L237
            r1.close()     // Catch: java.io.IOException -> L24a
        L237:
            if (r2 == 0) goto L23c
            r2.close()     // Catch: java.io.IOException -> L24c
        L23c:
            throw r0
        L23d:
            r0 = move-exception
            goto L128
        L240:
            r0 = move-exception
            goto L1b4
        L243:
            r0 = move-exception
            goto L214
        L245:
            r0 = move-exception
            goto La0
        L248:
            r0 = move-exception
            goto L223
        L24a:
            r1 = move-exception
            goto L237
        L24c:
            r1 = move-exception
            goto L23c
        L24e:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L232
        L253:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L232
        L258:
            r0 = move-exception
            r8 = r1
            r1 = r2
            r2 = r8
            goto L232
        L25d:
            r1 = move-exception
            r1 = r0
            r2 = r0
            goto L85
        L262:
            r2 = move-exception
            r2 = r0
            r8 = r0
            r0 = r1
            r1 = r8
            goto L85
        L269:
            r3 = move-exception
            r8 = r1
            r1 = r2
            r2 = r0
            r0 = r8
            goto L85
        L270:
            r3 = move-exception
            goto L85
        L273:
            r3 = r4
            goto L14f
        L276:
            r1 = r0
            r2 = r0
            goto L19f
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
            com.baidu.sofire.b.a();
            if (z && this.h.c(i) != 1) {
                z2 = false;
            } else {
                ApkInfo a = this.h.a(i);
                if (a == null) {
                    com.baidu.sofire.b.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", String.valueOf(i));
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.i.e.a(b, "1003105", hashMap);
                    }
                    z2 = false;
                } else {
                    File file = new File(a.pkgPath);
                    file.getAbsolutePath();
                    com.baidu.sofire.b.a();
                    if (!com.baidu.sofire.i.e.a(file)) {
                        com.baidu.sofire.b.a();
                        this.h.f(i);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("0", 3);
                        hashMap2.put("1", String.valueOf(i));
                        hashMap2.put("2", str);
                        if (!z) {
                            com.baidu.sofire.i.e.a(b, "1003105", hashMap2);
                        }
                        z2 = false;
                    } else {
                        if (packageInfo != null) {
                            a.cloudPkgInfo = packageInfo;
                        }
                        f a2 = f.a(b.getApplicationContext());
                        com.baidu.sofire.b.a();
                        if (!a2.a(a, false)) {
                            this.h.f(i);
                            a2.a(a.pkgPath);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("0", 4);
                            hashMap3.put("1", String.valueOf(i));
                            hashMap3.put("2", str);
                            if (!z) {
                                com.baidu.sofire.i.e.a(b, "1003105", hashMap3);
                            }
                            com.baidu.sofire.b.a();
                            z2 = false;
                        } else {
                            com.baidu.sofire.b.a();
                            String[] g2 = com.baidu.sofire.i.e.g(b);
                            if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                                String str4 = g2[0];
                                str2 = g2[1];
                                str3 = str4;
                            } else {
                                String str5 = com.baidu.sofire.i.e.e;
                                str2 = com.baidu.sofire.i.e.f;
                                str3 = str5;
                            }
                            new StringBuilder("ak=").append(str3).append(", sk=").append(str2);
                            com.baidu.sofire.b.a();
                            ApkInfo c2 = a2.c(a.pkgPath);
                            e eVar = (e) c2.classLoader;
                            Class<?> a3 = eVar.a("com.baidu.sofire.engine.EngineImpl");
                            if (a3 == null) {
                                com.baidu.sofire.b.a();
                                Class<?> a4 = eVar.a(FieldUtil.TYPE_STRING);
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("0", 9);
                                hashMap4.put("1", String.valueOf(i));
                                hashMap4.put("2", str);
                                hashMap4.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a4).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                if (!z) {
                                    com.baidu.sofire.i.e.a(b, "1003105", hashMap4);
                                }
                                this.h.f(i);
                                z2 = false;
                            } else {
                                Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, b);
                                new StringBuilder("ai=").append(invoke);
                                com.baidu.sofire.b.a();
                                com.baidu.sofire.i.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str2);
                                if (!((Boolean) com.baidu.sofire.i.e.a(invoke, OneKeyLoginSdkCall.l, new Class[]{Integer.TYPE, Boolean.TYPE}, 0, true)).booleanValue()) {
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put("0", 6);
                                    hashMap5.put("1", String.valueOf(i));
                                    hashMap5.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.i.e.a(b, "1003105", hashMap5);
                                    }
                                    this.h.f(i);
                                    a2.a(c2.pkgPath);
                                    com.baidu.sofire.b.a();
                                    z2 = false;
                                } else {
                                    c2.initStatus = 1;
                                    c2.apkParseSuc = 1;
                                    this.h.a(c2);
                                    com.baidu.sofire.b.a();
                                    int g3 = this.h.g(c2.key);
                                    new StringBuilder().append(c2.key).append(" ").append(g3);
                                    com.baidu.sofire.b.a();
                                    if (g3 < 3 && g3 != -1) {
                                        this.h.b(c2.key, g3 + 1);
                                    }
                                    HashMap hashMap6 = new HashMap();
                                    hashMap6.put("0", 0);
                                    hashMap6.put("1", Integer.valueOf(i));
                                    hashMap6.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.i.e.a(b, "1003105", hashMap6);
                                    }
                                    com.baidu.sofire.i.e.c(b);
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            z2 = false;
        }
        return z2;
    }

    public final void a(String str, String str2) {
        try {
            this.h.a(str);
            File file = new File(str2);
            new StringBuilder("f=").append(file.getAbsolutePath()).append(", e=").append(file.exists());
            com.baidu.sofire.b.a();
            if (file.exists()) {
                com.baidu.sofire.c.a(file);
                new StringBuilder().append(file.getAbsolutePath()).append(" s=").append(file.delete());
                com.baidu.sofire.b.a();
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x003b: IGET  (r4v41 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0137: IGET  (r4v39 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01d7: IGET  (r7v8 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02ea: IGET  (r4v24 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x034b: IGET  (r5v1 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x044b: IGET  (r4v19 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    public final boolean a(ApkInfo apkInfo, String str) {
        String str2;
        String str3;
        new StringBuilder().append(apkInfo);
        com.baidu.sofire.b.a();
        if (apkInfo == null) {
            return false;
        }
        File file = new File(apkInfo.pkgPath);
        try {
            if (!com.baidu.sofire.i.e.a(file)) {
                com.baidu.sofire.b.a();
                HashMap hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap.put("2", apkInfo.versionName);
                hashMap.put("3", Base64.encodeToString(("nowTime:" + System.currentTimeMillis() + ", nowFileInfo: path=" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length() + " - " + str).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.i.e.a(b, "1003106", hashMap);
                return false;
            }
            if (!this.h.b(apkInfo.key)) {
                this.h.a(apkInfo);
            }
            f a = f.a(b.getApplicationContext());
            this.h.a(apkInfo.key, 1);
            c(apkInfo.packageName);
            if (!a.a(apkInfo, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                hashMap2.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap2.put("2", apkInfo.versionName);
                com.baidu.sofire.i.e.a(b, "1003106", hashMap2);
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.h.a(apkInfo.key, 0);
                return false;
            }
            String[] g2 = com.baidu.sofire.i.e.g(b);
            if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                str2 = g2[0];
                str3 = g2[1];
            } else {
                str2 = com.baidu.sofire.i.e.e;
                str3 = com.baidu.sofire.i.e.f;
            }
            ApkInfo c2 = a.c(apkInfo.pkgPath);
            if (c2 == null) {
                return false;
            }
            e eVar = (e) c2.classLoader;
            Class<?> a2 = eVar.a("com.baidu.sofire.engine.EngineImpl");
            if (a2 == null) {
                com.baidu.sofire.b.a();
                Class<?> a3 = eVar.a(FieldUtil.TYPE_STRING);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 6);
                hashMap3.put("1", new StringBuilder().append(c2.key).toString());
                hashMap3.put("2", c2.versionName);
                hashMap3.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a3).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.i.e.a(b, "1003106", hashMap3);
                com.baidu.sofire.c.a(file);
                file.delete();
                this.h.a(c2.key, 0);
                return false;
            }
            Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, b);
            com.baidu.sofire.i.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
            if (!((Boolean) com.baidu.sofire.i.e.a(invoke, OneKeyLoginSdkCall.l, new Class[]{Integer.TYPE, Boolean.TYPE}, 0, true)).booleanValue()) {
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                c(c2.packageName);
                file.delete();
                a(c2.key, c2.versionName, true, (PackageInfo) null);
                this.h.a(c2.key, 0);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("0", 4);
                hashMap4.put("1", new StringBuilder().append(c2.key).toString());
                hashMap4.put("2", c2.versionName);
                com.baidu.sofire.i.e.a(b, "1003106", hashMap4);
                return false;
            }
            if (c2.isMem) {
                com.baidu.sofire.c.a(file);
                file.delete();
                com.baidu.sofire.i.e.d(c2.dataDir);
                if (f.b != null) {
                    f.b.add(Integer.valueOf(c2.key));
                }
            }
            com.baidu.sofire.b.a();
            try {
                ApkInfo a4 = this.h.a(c2.key);
                new StringBuilder().append(a4);
                com.baidu.sofire.b.a();
                File file2 = (a4 == null || a4.versionName.equals(c2.versionName)) ? null : new File(a4.pkgPath);
                c2.initStatus = 1;
                c2.apkParseSuc = 1;
                long a5 = this.h.a(c2);
                if (a5 > 0 && file2 != null && file2.exists()) {
                    com.baidu.sofire.c.a(file2);
                    new StringBuilder().append(file2.delete());
                    com.baidu.sofire.b.a();
                }
                new StringBuilder().append(a5).append(", c=").append(this.h.a(c2.key, 0));
                com.baidu.sofire.b.a();
                com.baidu.sofire.i.e.c(b);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("0", 0);
                hashMap5.put("1", new StringBuilder().append(c2.key).toString());
                hashMap5.put("2", c2.versionName);
                com.baidu.sofire.i.e.a(b, "1003106", hashMap5);
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
            return true;
        } catch (Throwable th2) {
            try {
                th2.getMessage();
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                c(apkInfo.packageName);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.h.a(apkInfo.key, 0);
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 5);
                hashMap6.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap6.put("2", apkInfo.versionName);
                hashMap6.put("3", Base64.encodeToString(com.baidu.sofire.b.a(th2).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.i.e.a(b, "1003106", hashMap6);
            } catch (Throwable th3) {
                com.baidu.sofire.i.e.a();
            }
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1180=8, 1181=8, 1187=5] */
    public final void a(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            com.baidu.sofire.i.e.a(b, "1003136", hashMap);
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
                hashMap.put("3", "11");
                com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                return;
            }
            if (callback != null) {
                try {
                    callback.onBegin(new Object[0]);
                } catch (IllegalAccessException e2) {
                    e2.getMessage();
                    com.baidu.sofire.b.c();
                    if (callback != null) {
                        callback.onError(2);
                    }
                    try {
                        hashMap.put("3", Integer.toString(16));
                        com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                } catch (IllegalArgumentException e3) {
                    e3.getMessage();
                    com.baidu.sofire.b.c();
                    if (callback != null) {
                        callback.onError(2);
                    }
                    try {
                        hashMap.put("3", Integer.toString(17));
                        com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                        return;
                    } catch (Throwable th2) {
                        return;
                    }
                } catch (NoSuchMethodException e4) {
                    e4.getMessage();
                    com.baidu.sofire.b.c();
                    if (callback != null) {
                        callback.onError(2);
                    }
                    try {
                        hashMap.put("3", Integer.toString(14));
                        com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                        return;
                    } catch (Throwable th3) {
                        return;
                    }
                } catch (InvocationTargetException e5) {
                    e5.getMessage();
                    com.baidu.sofire.b.c();
                    if (callback != null) {
                        callback.onError(2);
                    }
                    try {
                        hashMap.put("3", Integer.toString(15));
                        com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                        return;
                    } catch (Throwable th4) {
                        return;
                    }
                } catch (Throwable th5) {
                    th5.getMessage();
                    com.baidu.sofire.b.c();
                    if (callback != null) {
                        callback.onError(3);
                    }
                    try {
                        hashMap.put("3", Integer.toString(18));
                        com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                        return;
                    } catch (Throwable th6) {
                        return;
                    }
                }
            }
            boolean d = this.h.d(i);
            com.baidu.sofire.b.a();
            if (d) {
                long currentTimeMillis = System.currentTimeMillis();
                while (this.h.d(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                    com.baidu.sofire.b.a();
                    SystemClock.sleep(300L);
                }
            }
            com.baidu.sofire.b.a();
            if (this.h.d(i)) {
                if (callback != null) {
                    callback.onError(3);
                }
                try {
                    hashMap.put("3", Integer.toString(12));
                    com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                    return;
                } catch (Throwable th7) {
                    return;
                }
            }
            if (!this.d) {
                a(3);
                b();
            }
            f a = f.a(b.getApplicationContext());
            boolean z = false;
            ApkInfo apkInfo = null;
            long currentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - currentTimeMillis2 > 120000) {
                    break;
                }
                com.baidu.sofire.b.a();
                apkInfo = this.h.a(i);
                if (apkInfo != null) {
                    if (a.d(apkInfo.packageName) == null) {
                        if (apkInfo.initStatus == -1) {
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                SystemClock.sleep(1000L);
            }
            if (!z) {
                if (callback != null) {
                    callback.onError(4);
                }
                try {
                    hashMap.put("3", Integer.toString(13));
                    com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                    return;
                } catch (Throwable th8) {
                    return;
                }
            }
            Class<?> a2 = ((e) a.d(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
            Object a3 = com.baidu.sofire.i.e.a(a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, b), str, clsArr, objArr);
            try {
                new StringBuilder().append(a3);
                com.baidu.sofire.b.a();
            } catch (Throwable th9) {
                com.baidu.sofire.i.e.a();
            }
            if (callback != null) {
                callback.onEnd(a3);
            }
        } catch (Throwable th10) {
            com.baidu.sofire.i.e.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1288=10, 1289=10] */
    public final Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        int i2 = 2;
        new StringBuilder().append(str);
        com.baidu.sofire.b.a();
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.toString(i));
        hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
        hashMap.put("2", "1");
        com.baidu.sofire.i.e.a(b, "1003136", hashMap);
        try {
            if (TextUtils.isEmpty(str)) {
                hashMap.put("3", "1");
                com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                return new Pair<>(1, null);
            }
            try {
                try {
                    try {
                        boolean d = this.h.d(i);
                        new StringBuilder().append(d);
                        com.baidu.sofire.b.a();
                        if (d) {
                            Pair<Integer, Object> pair = new Pair<>(3, null);
                            try {
                                hashMap.put("3", Integer.toString(2));
                                com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                                return pair;
                            } catch (Throwable th) {
                                return pair;
                            }
                        } else if (!this.d) {
                            try {
                                Pair<Integer, Object> pair2 = new Pair<>(3, null);
                                try {
                                    hashMap.put("3", Integer.toString(3));
                                    com.baidu.sofire.i.e.a(b, "1003141", hashMap);
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
                                        com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                                    } catch (Throwable th4) {
                                    }
                                }
                                throw th;
                            }
                        } else {
                            f a = f.a();
                            if (a == null) {
                                Pair<Integer, Object> pair3 = new Pair<>(3, null);
                                try {
                                    hashMap.put("3", Integer.toString(4));
                                    com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                                    return pair3;
                                } catch (Throwable th5) {
                                    return pair3;
                                }
                            }
                            ApkInfo a2 = this.h.a(i);
                            if (!((a2 == null || a.d(a2.packageName) == null) ? false : true)) {
                                Pair<Integer, Object> pair4 = new Pair<>(4, null);
                                try {
                                    hashMap.put("3", Integer.toString(5));
                                    com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                                    return pair4;
                                } catch (Throwable th6) {
                                    return pair4;
                                }
                            }
                            Class<?> a3 = ((e) a.d(a2.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                            Object a4 = com.baidu.sofire.i.e.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, b), str, clsArr, objArr);
                            try {
                                new StringBuilder().append(a4);
                                com.baidu.sofire.b.a();
                            } catch (Throwable th7) {
                                com.baidu.sofire.i.e.a();
                            }
                            return new Pair<>(0, a4);
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        i2 = 0;
                    }
                } catch (IllegalAccessException e2) {
                    e2.getMessage();
                    com.baidu.sofire.b.c();
                    Pair<Integer, Object> pair5 = new Pair<>(2, null);
                    try {
                        hashMap.put("3", Integer.toString(8));
                        com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                        return pair5;
                    } catch (Throwable th9) {
                        return pair5;
                    }
                } catch (InvocationTargetException e3) {
                    e3.getMessage();
                    com.baidu.sofire.b.c();
                    Pair<Integer, Object> pair6 = new Pair<>(2, null);
                    try {
                        hashMap.put("3", Integer.toString(7));
                        com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                        return pair6;
                    } catch (Throwable th10) {
                        return pair6;
                    }
                }
            } catch (IllegalArgumentException e4) {
                e4.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair7 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(9));
                    com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                    return pair7;
                } catch (Throwable th11) {
                    return pair7;
                }
            } catch (NoSuchMethodException e5) {
                e5.getMessage();
                com.baidu.sofire.b.c();
                Pair<Integer, Object> pair8 = new Pair<>(2, null);
                try {
                    hashMap.put("3", Integer.toString(6));
                    com.baidu.sofire.i.e.a(b, "1003141", hashMap);
                    return pair8;
                } catch (Throwable th12) {
                    return pair8;
                }
            }
        } catch (Throwable th13) {
            th = th13;
        }
    }

    private static void c(String str) {
        f a;
        ApkInfo d;
        new StringBuilder().append(str);
        com.baidu.sofire.b.a();
        try {
            if (!TextUtils.isEmpty(str) && (a = f.a()) != null && (d = a.d(str)) != null) {
                Class<?> a2 = ((e) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, b);
                if (invoke != null) {
                    new StringBuilder().append(com.baidu.sofire.i.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                    com.baidu.sofire.b.a();
                    a.b(str);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.c();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.sofire.core.c$2] */
    public final void a(final String str) {
        try {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            new Thread() { // from class: com.baidu.sofire.core.c.2
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    super.run();
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            final f a = f.a(c.b.getApplicationContext());
                            new StringBuilder().append(str).append(", h=").append(a);
                            com.baidu.sofire.b.a();
                            if (a != null) {
                                final File file = new File(c.b.getFilesDir(), ".b");
                                final ApkInfo d = a.d(str);
                                new StringBuilder().append(str).append(", i=").append(d);
                                com.baidu.sofire.b.a();
                                if (d == null) {
                                    ApkInfo b2 = c.this.h.b(str);
                                    if (b2 != null) {
                                        c.this.a(str, b2.pkgPath);
                                        if (file.exists()) {
                                            File file2 = new File(file, b2.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + b2.versionName);
                                            if (com.baidu.sofire.i.e.a(file2)) {
                                                new StringBuilder().append(file2.getAbsolutePath()).append(" s=").append(file2.delete());
                                                com.baidu.sofire.b.a();
                                            }
                                        }
                                        if (b2 != null) {
                                            com.baidu.sofire.i.e.d(c.b.getFilesDir().getCanonicalPath() + "/." + b2.key);
                                            com.baidu.sofire.i.e.d(c.b.getFileStreamPath(b2.packageName).getAbsolutePath());
                                        }
                                        String sb = new StringBuilder(str).reverse().toString();
                                        ApkInfo b3 = c.this.h.b(sb);
                                        if (b3 != null) {
                                            c.this.a(sb, b3.pkgPath);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                Class<?> a2 = ((e) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                Object invoke = a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, c.b);
                                new StringBuilder().append(str).append(", i=").append(invoke);
                                com.baidu.sofire.b.a();
                                if (invoke != null) {
                                    new StringBuilder("t:").append(System.currentTimeMillis());
                                    com.baidu.sofire.b.a();
                                    new Timer().schedule(new TimerTask() { // from class: com.baidu.sofire.core.c.2.1
                                        @Override // java.util.TimerTask, java.lang.Runnable
                                        public final void run() {
                                            new StringBuilder().append(System.currentTimeMillis());
                                            com.baidu.sofire.b.a();
                                            ApkInfo d2 = a.d(str);
                                            if (d2 != null && d2.versionName != null && d2.versionName.equals(d.versionName)) {
                                                a.b(str);
                                                c.this.h.a(str);
                                                com.baidu.sofire.i.e.c(c.b);
                                                File file3 = new File(d.pkgPath);
                                                new StringBuilder("f=").append(file3.getAbsolutePath()).append(", e=").append(file3.exists());
                                                com.baidu.sofire.b.a();
                                                if (file3.exists()) {
                                                    com.baidu.sofire.c.a(file3);
                                                    new StringBuilder("d: ").append(file3.getAbsolutePath()).append(" s=").append(file3.delete());
                                                    com.baidu.sofire.b.a();
                                                }
                                                if (file.exists()) {
                                                    File file4 = new File(file, d.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + d.versionName);
                                                    if (com.baidu.sofire.i.e.a(file4)) {
                                                        new StringBuilder().append(file4.getAbsolutePath()).append(" s=").append(file4.delete());
                                                        com.baidu.sofire.b.a();
                                                    }
                                                }
                                                String sb2 = new StringBuilder(str).reverse().toString();
                                                ApkInfo b4 = c.this.h.b(sb2);
                                                if (b4 != null) {
                                                    c.this.a(sb2, b4.pkgPath);
                                                }
                                            }
                                        }
                                    }, 600000L);
                                    new StringBuilder().append(str).append("object=").append(com.baidu.sofire.i.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                                    com.baidu.sofire.b.a();
                                    a.b(str);
                                    c.this.h.a(str);
                                    com.baidu.sofire.i.e.c(c.b);
                                    File file3 = new File(d.pkgPath);
                                    new StringBuilder("f=").append(file3.getAbsolutePath()).append(", e=").append(file3.exists());
                                    com.baidu.sofire.b.a();
                                    if (file3.exists()) {
                                        com.baidu.sofire.c.a(file3);
                                        new StringBuilder("d: ").append(file3.getAbsolutePath()).append(" s=").append(file3.delete());
                                        com.baidu.sofire.b.a();
                                    }
                                    if (file.exists()) {
                                        File file4 = new File(file, d.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + d.versionName);
                                        if (com.baidu.sofire.i.e.a(file4)) {
                                            new StringBuilder().append(file4.getAbsolutePath()).append(" s=").append(file4.delete());
                                            com.baidu.sofire.b.a();
                                        }
                                    }
                                    String sb2 = new StringBuilder(str).reverse().toString();
                                    ApkInfo b4 = c.this.h.b(sb2);
                                    if (b4 != null) {
                                        c.this.a(sb2, b4.pkgPath);
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
            com.baidu.sofire.i.e.a();
        }
    }

    public static void a(int i) {
        if (g == 0) {
            g = i;
        }
    }

    public final boolean b(String str) {
        this.h.d();
        this.d = true;
        return a(b, str);
    }

    private boolean a(Context context, String str) {
        try {
            f a = f.a(context);
            if (a == null) {
                return false;
            }
            if (a.d(str) != null) {
                return true;
            }
            if (this.h == null) {
                this.h = com.baidu.sofire.c.a.a(b);
            }
            ApkInfo b2 = this.h.b(str);
            new StringBuilder("push::").append(b2);
            com.baidu.sofire.b.a();
            if (b2 != null) {
                if (this.a.c()) {
                    File file = new File(b.getFilesDir(), ".b");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(b2.pkgPath);
                    File file3 = new File(file, b2.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + b2.versionName);
                    if (!com.baidu.sofire.i.e.a(file3)) {
                        com.baidu.sofire.i.e.a(file2, file3);
                    }
                    com.baidu.sofire.c.a(b, b2.key, file2, file3);
                }
                if (a(b2.key, b2.versionName, null)) {
                    return true;
                }
            }
            return a.d(str) != null;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return false;
        }
    }
}
