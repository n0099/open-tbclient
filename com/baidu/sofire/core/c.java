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
/* loaded from: classes3.dex */
public final class c implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public static Context f5210b;
    private static c e;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sofire.e f5211a;
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
                    d.f5218a = this.f.a();
                }
                if (str.equals("xyus")) {
                    this.f5211a.l();
                    com.baidu.sofire.b.a();
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
        }
    }

    private c(Context context) {
        com.baidu.sofire.b.a();
        f5210b = context.getApplicationContext();
        this.h = com.baidu.sofire.c.a.a(f5210b);
        this.f5211a = new com.baidu.sofire.e(f5210b);
        this.f = new com.baidu.sofire.g(f5210b);
        com.baidu.sofire.g gVar = this.f;
        if (gVar.f5249a == null) {
            return;
        }
        gVar.f5249a.registerOnSharedPreferenceChangeListener(this);
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
            com.baidu.sofire.i.e.n(f5210b);
            this.f5211a.a(true);
            JSONObject o = com.baidu.sofire.i.e.o(f5210b);
            com.baidu.sofire.i.e.d(f5210b);
            new StringBuilder().append(this.d);
            com.baidu.sofire.b.a();
            com.baidu.sofire.e eVar = this.f5211a;
            eVar.c.putString("ssv", "3.4.4.1");
            eVar.c.commit();
            Report.getInstance(f5210b).n();
            for (ApkInfo apkInfo : this.h.a()) {
                try {
                    str = f5210b.getFilesDir().getCanonicalPath();
                } catch (IOException e2) {
                    com.baidu.sofire.i.e.a();
                    str = null;
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/." + apkInfo.key;
                    com.baidu.sofire.i.e.d(apkInfo.dataDir + "/lib");
                }
            }
            this.h.d();
            com.baidu.sofire.b.a();
            new StringBuilder().append(this.f5211a.a());
            com.baidu.sofire.b.a();
            if (!this.f5211a.a()) {
                com.baidu.sofire.e eVar2 = this.f5211a;
                eVar2.c.putBoolean("iio", true);
                eVar2.c.commit();
            } else {
                com.baidu.sofire.c.a aVar = this.h;
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", (Integer) 0);
                aVar.c.update("pgn", contentValues, "n=-1", null);
            }
            new U(f5210b, 1, false, o).start();
        }
    }

    public final void c() {
        try {
            List<ApkInfo> a2 = this.h.a();
            new StringBuilder("all=").append(a2);
            com.baidu.sofire.b.a();
            final List<Integer> r = this.f5211a.r();
            List<Integer> q = this.f5211a.q();
            for (int i = 0; i < q.size(); i++) {
                if (!r.contains(q.get(i))) {
                    r.add(q.get(i));
                }
            }
            Collections.sort(a2, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.core.c.1
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
            for (ApkInfo apkInfo : a2) {
                f a3 = f.a();
                if ((a3 != null ? a3.d(apkInfo.packageName) : null) == null) {
                    boolean z = true;
                    if (this.h.g(apkInfo.key) == 3) {
                        com.baidu.sofire.b.a();
                        z = false;
                    }
                    if (this.f5211a.c() && z) {
                        File file = new File(f5210b.getFilesDir(), ".b");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(apkInfo.pkgPath);
                        File file3 = new File(file, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                        if (!com.baidu.sofire.i.e.a(file3)) {
                            com.baidu.sofire.i.e.a(file2, file3);
                        }
                        com.baidu.sofire.c.a(f5210b, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(f5210b.getFilesDir(), ".b");
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
            if (!this.f5211a.t() && jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("6");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.f5211a.s();
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
    private void a(int r9, java.lang.String r10, java.lang.String r11, android.content.pm.PackageInfo r12) {
        /*
            r8 = this;
            r3 = 0
            r1 = 0
            r4 = 1
            com.baidu.sofire.c.a r0 = r8.h     // Catch: java.lang.Throwable -> L100
            com.baidu.sofire.core.ApkInfo r0 = r0.a(r9)     // Catch: java.lang.Throwable -> L100
            if (r0 == 0) goto L1c
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> L100
            boolean r0 = com.baidu.sofire.i.e.b(r10, r0)     // Catch: java.lang.Throwable -> L100
            if (r0 != 0) goto L14
        L13:
            return
        L14:
            com.baidu.sofire.c.a r0 = r8.h     // Catch: java.lang.Throwable -> Lfa
            com.baidu.sofire.core.ApkInfo r0 = r0.a(r9)     // Catch: java.lang.Throwable -> Lfa
            if (r0 != 0) goto La7
        L1c:
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L24b
            if (r0 != 0) goto L260
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L24b
            android.content.Context r0 = com.baidu.sofire.core.c.f5210b     // Catch: java.lang.Throwable -> L24b
            java.io.File r0 = r0.getFilesDir()     // Catch: java.lang.Throwable -> L24b
            java.lang.String r5 = ".tmp"
            r2.<init>(r0, r5)     // Catch: java.lang.Throwable -> L24b
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L24b
            if (r0 != 0) goto L39
            r2.mkdir()     // Catch: java.lang.Throwable -> L24b
        L39:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L24b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24b
            r5.<init>()     // Catch: java.lang.Throwable -> L24b
            java.lang.StringBuilder r5 = r5.append(r9)     // Catch: java.lang.Throwable -> L24b
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L24b
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L24b
            java.lang.String r6 = ".zip"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L24b
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L24b
            r0.<init>(r2, r5)     // Catch: java.lang.Throwable -> L24b
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L251
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L251
            android.content.Context r5 = com.baidu.sofire.core.c.f5210b     // Catch: java.lang.Throwable -> L256
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L256
            java.lang.String r6 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L256
            java.io.InputStream r1 = r5.open(r6)     // Catch: java.lang.Throwable -> L256
            r5 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L80
        L74:
            int r6 = r1.read(r5)     // Catch: java.lang.Throwable -> L80
            r7 = -1
            if (r6 == r7) goto L106
            r7 = 0
            r2.write(r5, r7, r6)     // Catch: java.lang.Throwable -> L80
            goto L74
        L80:
            r3 = move-exception
            r3 = r1
        L82:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L249
            if (r0 == 0) goto L215
            boolean r1 = r0.exists()     // Catch: java.lang.Throwable -> L249
            if (r1 == 0) goto L215
            com.baidu.sofire.c.a(r0)     // Catch: java.lang.Throwable -> L249
            com.baidu.sofire.c.a r1 = r8.h     // Catch: java.lang.Throwable -> L249
            r1.h(r9)     // Catch: java.lang.Throwable -> L249
            r0.delete()     // Catch: java.lang.Throwable -> L249
            if (r3 == 0) goto L9d
            r3.close()     // Catch: java.io.IOException -> L23a
        L9d:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> La4
            goto L13
        La4:
            r0 = move-exception
            goto L13
        La7:
            com.baidu.sofire.c.a r2 = r8.h     // Catch: java.lang.Throwable -> Lfa
            r2.h(r9)     // Catch: java.lang.Throwable -> Lfa
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r0 = r0.pkgPath     // Catch: java.lang.Throwable -> Lfa
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfa
            r0.<init>()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r5 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r5 = ", e="
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.lang.Throwable -> Lfa
            boolean r5 = r2.exists()     // Catch: java.lang.Throwable -> Lfa
            r0.append(r5)     // Catch: java.lang.Throwable -> Lfa
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> Lfa
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> Lfa
            if (r0 == 0) goto L1c
            com.baidu.sofire.c.a(r2)     // Catch: java.lang.Throwable -> Lfa
            boolean r0 = r2.delete()     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfa
            r5.<init>()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r5 = " s="
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Throwable -> Lfa
            r2.append(r0)     // Catch: java.lang.Throwable -> Lfa
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> Lfa
            goto L1c
        Lfa:
            r0 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L100
            goto L1c
        L100:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L1c
        L106:
            r2.flush()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6 = 1
            com.baidu.sofire.i.e.a(r5, r6)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = com.baidu.sofire.i.p.a(r0)     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L11d
            boolean r6 = r5.equalsIgnoreCase(r11)     // Catch: java.lang.Throwable -> L80
            if (r6 != 0) goto L12d
        L11d:
            r0.delete()     // Catch: java.lang.Throwable -> L80
            if (r1 == 0) goto L125
            r1.close()     // Catch: java.io.IOException -> L232
        L125:
            r2.close()     // Catch: java.io.IOException -> L12a
            goto L13
        L12a:
            r0 = move-exception
            goto L13
        L12d:
            com.baidu.sofire.core.ApkInfo r6 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            r6.<init>(r9, r10, r7)     // Catch: java.lang.Throwable -> L80
            r6.apkMD5 = r5     // Catch: java.lang.Throwable -> L80
            r5 = 1
            r6.priority = r5     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a r5 = r8.h     // Catch: java.lang.Throwable -> L80
            r5.a(r6)     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a r5 = r8.h     // Catch: java.lang.Throwable -> L80
            int r5 = r5.g(r9)     // Catch: java.lang.Throwable -> L80
            r6 = 3
            if (r5 != r6) goto L25d
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L80
        L14c:
            com.baidu.sofire.e r4 = r8.f5211a     // Catch: java.lang.Throwable -> L80
            boolean r4 = r4.c()     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L1b8
            if (r3 == 0) goto L1b8
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L80
            android.content.Context r4 = com.baidu.sofire.core.c.f5210b     // Catch: java.lang.Throwable -> L80
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = ".b"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L80
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L80
            if (r4 != 0) goto L16d
            r3.mkdir()     // Catch: java.lang.Throwable -> L80
        L16d:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r9)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L80
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            boolean r3 = com.baidu.sofire.i.e.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L193
            com.baidu.sofire.i.e.a(r0, r4)     // Catch: java.lang.Throwable -> L80
        L193:
            android.content.Context r3 = com.baidu.sofire.core.c.f5210b     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.c.a(r3, r9, r0, r4)     // Catch: java.lang.Throwable -> L80
            r3 = r1
        L199:
            com.baidu.sofire.c.a r1 = r8.h     // Catch: java.lang.Throwable -> L25a
            com.baidu.sofire.core.ApkInfo r1 = r1.a(r9)     // Catch: java.lang.Throwable -> L25a
            if (r1 == 0) goto L1a9
            java.lang.String r1 = r1.pkgPath     // Catch: java.lang.Throwable -> L25a
            boolean r1 = com.baidu.sofire.i.e.c(r1)     // Catch: java.lang.Throwable -> L25a
            if (r1 != 0) goto L1f7
        L1a9:
            if (r3 == 0) goto L1ae
            r3.close()     // Catch: java.io.IOException -> L235
        L1ae:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L1b5
            goto L13
        L1b5:
            r0 = move-exception
            goto L13
        L1b8:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L80
            android.content.Context r4 = com.baidu.sofire.core.c.f5210b     // Catch: java.lang.Throwable -> L80
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = ".b"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L80
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L80
            if (r4 == 0) goto L1f5
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r5.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r9)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "-"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L80
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            boolean r3 = com.baidu.sofire.i.e.a(r4)     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto L1f5
            com.baidu.sofire.c.a(r4)     // Catch: java.lang.Throwable -> L80
            r4.delete()     // Catch: java.lang.Throwable -> L80
        L1f5:
            r3 = r1
            goto L199
        L1f7:
            boolean r1 = r8.a(r9, r10, r12)     // Catch: java.lang.Throwable -> L25a
            if (r1 == 0) goto L206
            java.util.List<java.lang.Integer> r1 = com.baidu.sofire.core.c.c     // Catch: java.lang.Throwable -> L25a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L25a
            r1.add(r4)     // Catch: java.lang.Throwable -> L25a
        L206:
            if (r3 == 0) goto L20b
            r3.close()     // Catch: java.io.IOException -> L238
        L20b:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L212
            goto L13
        L212:
            r0 = move-exception
            goto L13
        L215:
            if (r3 == 0) goto L21a
            r3.close()     // Catch: java.io.IOException -> L23d
        L21a:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L221
            goto L13
        L221:
            r0 = move-exception
            goto L13
        L224:
            r0 = move-exception
            r2 = r1
            r3 = r1
        L227:
            if (r3 == 0) goto L22c
            r3.close()     // Catch: java.io.IOException -> L23f
        L22c:
            if (r2 == 0) goto L231
            r2.close()     // Catch: java.io.IOException -> L241
        L231:
            throw r0
        L232:
            r0 = move-exception
            goto L125
        L235:
            r0 = move-exception
            goto L1ae
        L238:
            r0 = move-exception
            goto L20b
        L23a:
            r0 = move-exception
            goto L9d
        L23d:
            r0 = move-exception
            goto L21a
        L23f:
            r1 = move-exception
            goto L22c
        L241:
            r1 = move-exception
            goto L231
        L243:
            r0 = move-exception
            r3 = r1
            goto L227
        L246:
            r0 = move-exception
            r3 = r1
            goto L227
        L249:
            r0 = move-exception
            goto L227
        L24b:
            r0 = move-exception
            r0 = r1
            r2 = r1
            r3 = r1
            goto L82
        L251:
            r2 = move-exception
            r2 = r1
            r3 = r1
            goto L82
        L256:
            r3 = move-exception
            r3 = r1
            goto L82
        L25a:
            r1 = move-exception
            goto L82
        L25d:
            r3 = r4
            goto L14c
        L260:
            r0 = r1
            r2 = r1
            r3 = r1
            goto L199
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
                ApkInfo a2 = this.h.a(i);
                if (a2 == null) {
                    com.baidu.sofire.b.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", String.valueOf(i));
                    hashMap.put("2", str);
                    if (!z) {
                        com.baidu.sofire.i.e.a(f5210b, "1003105", hashMap);
                    }
                    z2 = false;
                } else {
                    File file = new File(a2.pkgPath);
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
                            com.baidu.sofire.i.e.a(f5210b, "1003105", hashMap2);
                        }
                        z2 = false;
                    } else {
                        if (packageInfo != null) {
                            a2.cloudPkgInfo = packageInfo;
                        }
                        f a3 = f.a(f5210b.getApplicationContext());
                        com.baidu.sofire.b.a();
                        if (!a3.a(a2, false)) {
                            this.h.f(i);
                            a3.a(a2.pkgPath);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("0", 4);
                            hashMap3.put("1", String.valueOf(i));
                            hashMap3.put("2", str);
                            if (!z) {
                                com.baidu.sofire.i.e.a(f5210b, "1003105", hashMap3);
                            }
                            com.baidu.sofire.b.a();
                            z2 = false;
                        } else {
                            com.baidu.sofire.b.a();
                            String[] g2 = com.baidu.sofire.i.e.g(f5210b);
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
                            ApkInfo c2 = a3.c(a2.pkgPath);
                            e eVar = (e) c2.classLoader;
                            Class<?> a4 = eVar.a("com.baidu.sofire.engine.EngineImpl");
                            if (a4 == null) {
                                com.baidu.sofire.b.a();
                                Class<?> a5 = eVar.a(FieldUtil.TYPE_STRING);
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("0", 9);
                                hashMap4.put("1", String.valueOf(i));
                                hashMap4.put("2", str);
                                hashMap4.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a5).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                                if (!z) {
                                    com.baidu.sofire.i.e.a(f5210b, "1003105", hashMap4);
                                }
                                this.h.f(i);
                                z2 = false;
                            } else {
                                Object invoke = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, f5210b);
                                new StringBuilder("ai=").append(invoke);
                                com.baidu.sofire.b.a();
                                com.baidu.sofire.i.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str3, str2);
                                if (!((Boolean) com.baidu.sofire.i.e.a(invoke, OneKeyLoginSdkCall.l, new Class[]{Integer.TYPE, Boolean.TYPE}, 0, true)).booleanValue()) {
                                    HashMap hashMap5 = new HashMap();
                                    hashMap5.put("0", 6);
                                    hashMap5.put("1", String.valueOf(i));
                                    hashMap5.put("2", str);
                                    if (!z) {
                                        com.baidu.sofire.i.e.a(f5210b, "1003105", hashMap5);
                                    }
                                    this.h.f(i);
                                    a3.a(c2.pkgPath);
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
                                        com.baidu.sofire.i.e.a(f5210b, "1003105", hashMap6);
                                    }
                                    com.baidu.sofire.i.e.c(f5210b);
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x003b: IGET  (r4v40 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0137: IGET  (r4v38 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01d5: IGET  (r7v8 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02e8: IGET  (r4v23 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0349: IGET  (r5v1 int A[REMOVE]) = (r12v0 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0449: IGET  (r4v18 int A[REMOVE]) = (r12v1 com.baidu.sofire.core.ApkInfo) com.baidu.sofire.core.ApkInfo.key int)] */
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
                com.baidu.sofire.i.e.a(f5210b, "1003106", hashMap);
                return false;
            }
            if (!this.h.b(apkInfo.key)) {
                this.h.a(apkInfo);
            }
            f a2 = f.a(f5210b.getApplicationContext());
            this.h.a(apkInfo.key, 1);
            c(apkInfo.packageName);
            if (!a2.a(apkInfo, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                hashMap2.put("1", new StringBuilder().append(apkInfo.key).toString());
                hashMap2.put("2", apkInfo.versionName);
                com.baidu.sofire.i.e.a(f5210b, "1003106", hashMap2);
                com.baidu.sofire.b.a();
                com.baidu.sofire.c.a(file);
                file.delete();
                a(apkInfo.key, apkInfo.versionName, true, (PackageInfo) null);
                this.h.a(apkInfo.key, 0);
                return false;
            }
            String[] g2 = com.baidu.sofire.i.e.g(f5210b);
            if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                str2 = g2[0];
                str3 = g2[1];
            } else {
                str2 = com.baidu.sofire.i.e.e;
                str3 = com.baidu.sofire.i.e.f;
            }
            ApkInfo c2 = a2.c(apkInfo.pkgPath);
            if (c2 == null) {
                return false;
            }
            e eVar = (e) c2.classLoader;
            Class<?> a3 = eVar.a("com.baidu.sofire.engine.EngineImpl");
            if (a3 == null) {
                com.baidu.sofire.b.a();
                Class<?> a4 = eVar.a(FieldUtil.TYPE_STRING);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 6);
                hashMap3.put("1", new StringBuilder().append(c2.key).toString());
                hashMap3.put("2", c2.versionName);
                hashMap3.put("3", Base64.encodeToString(("classloader=" + eVar + ",StringClass=" + a4).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.i.e.a(f5210b, "1003106", hashMap3);
                com.baidu.sofire.c.a(file);
                file.delete();
                this.h.a(c2.key, 0);
                return false;
            }
            Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f5210b);
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
                com.baidu.sofire.i.e.a(f5210b, "1003106", hashMap4);
                return false;
            }
            if (c2.isMem) {
                com.baidu.sofire.c.a(file);
                file.delete();
                com.baidu.sofire.i.e.d(c2.dataDir);
                if (f.f5230b != null) {
                    f.f5230b.add(Integer.valueOf(c2.key));
                }
            }
            com.baidu.sofire.b.a();
            try {
                ApkInfo a5 = this.h.a(c2.key);
                new StringBuilder().append(a5);
                com.baidu.sofire.b.a();
                File file2 = (a5 == null || a5.versionName.equals(c2.versionName)) ? null : new File(a5.pkgPath);
                c2.initStatus = 1;
                c2.apkParseSuc = 1;
                long a6 = this.h.a(c2);
                if (a6 > 0 && file2 != null && file2.exists()) {
                    com.baidu.sofire.c.a(file2);
                    new StringBuilder().append(file2.delete());
                    com.baidu.sofire.b.a();
                }
                new StringBuilder().append(a6).append(", c=").append(this.h.a(c2.key, 0));
                com.baidu.sofire.b.a();
                com.baidu.sofire.i.e.c(f5210b);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("0", 0);
                hashMap5.put("1", new StringBuilder().append(c2.key).toString());
                hashMap5.put("2", c2.versionName);
                com.baidu.sofire.i.e.a(f5210b, "1003106", hashMap5);
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
                com.baidu.sofire.i.e.a(f5210b, "1003106", hashMap6);
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
            com.baidu.sofire.i.e.a(f5210b, "1003136", hashMap);
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
                hashMap.put("3", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                        com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                        com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                        com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                        com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                        com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                    com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
                    return;
                } catch (Throwable th7) {
                    return;
                }
            }
            if (!this.d) {
                a(3);
                b();
            }
            f a2 = f.a(f5210b.getApplicationContext());
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
                    if (a2.d(apkInfo.packageName) == null) {
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
                    com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
                    return;
                } catch (Throwable th8) {
                    return;
                }
            }
            Class<?> a3 = ((e) a2.d(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
            Object a4 = com.baidu.sofire.i.e.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f5210b), str, clsArr, objArr);
            try {
                new StringBuilder().append(a4);
                com.baidu.sofire.b.a();
            } catch (Throwable th9) {
                com.baidu.sofire.i.e.a();
            }
            if (callback != null) {
                callback.onEnd(a4);
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
        com.baidu.sofire.i.e.a(f5210b, "1003136", hashMap);
        try {
            if (TextUtils.isEmpty(str)) {
                hashMap.put("3", "1");
                com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                                com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
                                return pair;
                            } catch (Throwable th) {
                                return pair;
                            }
                        } else if (!this.d) {
                            try {
                                Pair<Integer, Object> pair2 = new Pair<>(3, null);
                                try {
                                    hashMap.put("3", Integer.toString(3));
                                    com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                                        com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
                                    } catch (Throwable th4) {
                                    }
                                }
                                throw th;
                            }
                        } else {
                            f a2 = f.a();
                            if (a2 == null) {
                                Pair<Integer, Object> pair3 = new Pair<>(3, null);
                                try {
                                    hashMap.put("3", Integer.toString(4));
                                    com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
                                    return pair3;
                                } catch (Throwable th5) {
                                    return pair3;
                                }
                            }
                            ApkInfo a3 = this.h.a(i);
                            if (!((a3 == null || a2.d(a3.packageName) == null) ? false : true)) {
                                Pair<Integer, Object> pair4 = new Pair<>(4, null);
                                try {
                                    hashMap.put("3", Integer.toString(5));
                                    com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
                                    return pair4;
                                } catch (Throwable th6) {
                                    return pair4;
                                }
                            }
                            Class<?> a4 = ((e) a2.d(a3.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                            Object a5 = com.baidu.sofire.i.e.a(a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, f5210b), str, clsArr, objArr);
                            try {
                                new StringBuilder().append(a5);
                                com.baidu.sofire.b.a();
                            } catch (Throwable th7) {
                                com.baidu.sofire.i.e.a();
                            }
                            return new Pair<>(0, a5);
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
                        com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                        com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                    com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
                    com.baidu.sofire.i.e.a(f5210b, "1003141", hashMap);
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
        f a2;
        ApkInfo d;
        new StringBuilder().append(str);
        com.baidu.sofire.b.a();
        try {
            if (!TextUtils.isEmpty(str) && (a2 = f.a()) != null && (d = a2.d(str)) != null) {
                Class<?> a3 = ((e) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, f5210b);
                if (invoke != null) {
                    new StringBuilder().append(com.baidu.sofire.i.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                    com.baidu.sofire.b.a();
                    a2.b(str);
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
                            final f a2 = f.a(c.f5210b.getApplicationContext());
                            new StringBuilder().append(str).append(", h=").append(a2);
                            com.baidu.sofire.b.a();
                            if (a2 != null) {
                                final File file = new File(c.f5210b.getFilesDir(), ".b");
                                final ApkInfo d = a2.d(str);
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
                                            com.baidu.sofire.i.e.d(c.f5210b.getFilesDir().getCanonicalPath() + "/." + b2.key);
                                            com.baidu.sofire.i.e.d(c.f5210b.getFileStreamPath(b2.packageName).getAbsolutePath());
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
                                Class<?> a3 = ((e) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, c.f5210b);
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
                                            ApkInfo d2 = a2.d(str);
                                            if (d2 != null && d2.versionName != null && d2.versionName.equals(d.versionName)) {
                                                a2.b(str);
                                                c.this.h.a(str);
                                                com.baidu.sofire.i.e.c(c.f5210b);
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
                                    a2.b(str);
                                    c.this.h.a(str);
                                    com.baidu.sofire.i.e.c(c.f5210b);
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
        return a(f5210b, str);
    }

    private boolean a(Context context, String str) {
        try {
            f a2 = f.a(context);
            if (a2 == null) {
                return false;
            }
            if (a2.d(str) != null) {
                return true;
            }
            if (this.h == null) {
                this.h = com.baidu.sofire.c.a.a(f5210b);
            }
            ApkInfo b2 = this.h.b(str);
            new StringBuilder("push::").append(b2);
            com.baidu.sofire.b.a();
            if (b2 != null) {
                if (this.f5211a.c()) {
                    File file = new File(f5210b.getFilesDir(), ".b");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(b2.pkgPath);
                    File file3 = new File(file, b2.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + b2.versionName);
                    if (!com.baidu.sofire.i.e.a(file3)) {
                        com.baidu.sofire.i.e.a(file2, file3);
                    }
                    com.baidu.sofire.c.a(f5210b, b2.key, file2, file3);
                }
                if (a(b2.key, b2.versionName, null)) {
                    return true;
                }
            }
            return a2.d(str) != null;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return false;
        }
    }
}
