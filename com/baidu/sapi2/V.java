package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.X;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class V {
    private static final Map<String, SoftReference<String>> a = new ConcurrentHashMap();
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();
    private Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void a(X.a.C0227a c0227a);

        void a(X.a.C0227a c0227a, String str);
    }

    String c(String str) {
        if (a.containsKey(str) && a.get(str) != null) {
            String str2 = a.get(str).get();
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return null;
    }

    void d(String str) {
        a.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(Context context, String str) {
        if (SapiContext.getInstance().getBoolean(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, false)) {
            return a(context, a(str));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(4)
    public String d(Context context, String str) throws IOException {
        return com.baidu.sapi2.utils.a.b(context.getApplicationInfo().dataDir + File.separator + com.baidu.fsg.face.base.b.c.g + File.separator + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        a.put(str, new SoftReference<>(str2));
    }

    String a(Context context, String str) {
        a();
        if (SapiContext.getInstance().getSapiOptions().e().c()) {
            String c = c(str);
            if (TextUtils.isEmpty(c)) {
                X.a.C0227a c2 = c(context, str);
                if (c2 != null) {
                    a(c2, new O(this, context));
                }
                return c(str);
            }
            return c;
        }
        return null;
    }

    void b(X x) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String str = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + "/static/appsapi/conf/android-conf.txt";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("If-None-Match", SapiContext.getInstance().getString(SapiContext.KEY_CONFIG_FILE_ETAG));
        try {
            new HttpClientWrap().get(str, httpHashMapWrap, hashMap, (List<HttpCookie>) null, (String) null, 0, new Q(this, true, x));
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X.a.C0227a c(Context context, String str) {
        for (X.a.C0227a c0227a : SapiContext.getInstance().getSapiOptions().e().a()) {
            if (c0227a.a.equals(str)) {
                return c0227a;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(X x) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        SapiAccountManager.getInstance().preFetchStoken(SapiContext.getInstance().getCurrentAccount(), false);
        new FaceLoginService().syncFaceLoginUID(this.d, null);
        a(x.Y);
        if (sapiConfiguration.syncOneKeyLoginInfo) {
            new com.baidu.sapi2.outsdk.c().a(sapiConfiguration, com.baidu.sapi2.outsdk.c.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        if (TextUtils.isEmpty(deviceInfo)) {
            return;
        }
        com.baidu.sapi2.utils.t.a("dvif_interface", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        this.d = context.getApplicationContext();
        X sapiOptions = SapiContext.getInstance().getSapiOptions();
        a(sapiOptions);
        b(sapiOptions);
    }

    String b(String str) throws IOException {
        return com.baidu.sapi2.utils.a.b(new File(Environment.getExternalStorageDirectory(), str).getAbsolutePath());
    }

    void a(X x) {
        X.a e = x.e();
        if (e.c()) {
            for (X.a.C0227a c0227a : e.a()) {
                this.b.add(c0227a.a);
            }
            this.c.addAll(this.b);
            for (X.a.C0227a c0227a2 : e.a()) {
                a(c0227a2, new P(this));
            }
        }
    }

    void a(X.a.C0227a c0227a, a aVar) {
        if (aVar != null) {
            String b = X.a.C0227a.b(c0227a.a);
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), b).exists()) {
                    String b2 = b(b);
                    if (SecurityUtil.md5(b2.getBytes(), false).equals(c0227a.c)) {
                        aVar.a(c0227a, b2);
                    } else {
                        aVar.a(c0227a);
                    }
                } else {
                    aVar.a(c0227a);
                }
                return;
            } catch (Throwable th) {
                aVar.a(c0227a);
                return;
            }
        }
        throw new IllegalArgumentException(a.class.getName() + "can't be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, X.a.C0227a c0227a) {
        String c = X.a.C0227a.c(c0227a.a);
        if (new File(context.getFilesDir(), c).exists()) {
            try {
                a(c0227a.a, d(context, c));
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        Uri parse;
        String str2 = parse.getHost() + (Uri.parse(str).getPort() == -1 ? "" : ":" + parse.getPort()) + parse.getPath();
        return !str2.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION) ? str2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION : str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, X x) {
        X.a.C0227a c0227a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            X a2 = X.a(jSONObject);
            SapiContext.getInstance().setSapiOptions(a2);
            SapiContext.getInstance().setPkgSigns(X.d.a(jSONObject));
            X.a e = a2.e();
            X.a e2 = x.e();
            c(a2);
            this.c.clear();
            if (e.c()) {
                for (X.a.C0227a c0227a2 : e.a()) {
                    this.c.add(c0227a2.a);
                }
                for (X.a.C0227a c0227a3 : e.a()) {
                    X.a.C0227a c0227a4 = null;
                    Iterator<X.a.C0227a> it = e2.a().iterator();
                    while (true) {
                        c0227a = c0227a4;
                        if (!it.hasNext()) {
                            break;
                        }
                        c0227a4 = it.next();
                        if (!c0227a4.a.equals(c0227a3.a)) {
                            c0227a4 = c0227a;
                        }
                    }
                    if (a(c0227a3, c0227a)) {
                        a(c0227a3, new T(this, c0227a3, a2, e2));
                    } else {
                        SapiContext.getInstance().put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, true);
                        a(c0227a3, new U(this));
                    }
                }
            }
        } catch (JSONException e3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, X.a.C0227a c0227a) {
        if (TextUtils.isEmpty(c0227a.a) || TextUtils.isEmpty(str) || !c0227a.c.equals(SecurityUtil.md5(str.getBytes(), false))) {
            return;
        }
        a(c0227a.a, str);
        a(this.d, X.a.C0227a.c(c0227a.a), str.getBytes());
        if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.d)) {
            a(X.a.C0227a.b(c0227a.a), str.getBytes());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x006b */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.lang.Process */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z) {
        Process process;
        Exception e;
        if (z) {
            String packageDirExecutePer = SapiContext.getInstance().getPackageDirExecutePer();
            if (!TextUtils.isEmpty(packageDirExecutePer)) {
                Process process2 = 0;
                try {
                    try {
                        process = Runtime.getRuntime().exec("chmod " + packageDirExecutePer + " " + this.d.getApplicationInfo().dataDir);
                        try {
                            if (process.waitFor() == 0) {
                                SapiContext.getInstance().setPackageDirExecutePer("");
                            }
                            if (process == null) {
                                return;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            Log.e(e);
                            if (process == null) {
                                return;
                            }
                            process.destroy();
                        }
                    } catch (Throwable th) {
                        process2 = packageDirExecutePer;
                        th = th;
                        if (process2 != 0) {
                            process2.destroy();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    process = null;
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                    if (process2 != 0) {
                    }
                    throw th;
                }
                process.destroy();
            }
        }
    }

    boolean a(X.a.C0227a c0227a, X.a.C0227a c0227a2) {
        return !TextUtils.isEmpty(c0227a.c) && (c0227a2 == null || !c0227a.c.equals(c0227a2.c));
    }

    void a() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : this.b) {
            if (!this.c.contains(str)) {
                arrayList.add(str);
                d(str);
            }
        }
        for (String str2 : arrayList) {
            if (this.b.contains(str2)) {
                this.b.remove(str2);
            }
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    void a(android.content.Context r6, java.lang.String r7, byte[] r8) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r1 = r6.openFileOutput(r7, r1)     // Catch: java.lang.Throwable -> L2a
            r1.write(r8)     // Catch: java.lang.Throwable -> L1a
            com.baidu.sapi2.SapiContext r0 = com.baidu.sapi2.SapiContext.getInstance()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "login_page_is_cached"
            r3 = 1
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L19
        L16:
            r1.close()     // Catch: java.lang.Throwable -> L2c
        L19:
            return
        L1a:
            r0 = move-exception
            r0 = r1
        L1c:
            if (r0 == 0) goto L19
            r1 = r0
            goto L16
        L20:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L24:
            if (r1 == 0) goto L29
            r1.close()     // Catch: java.lang.Throwable -> L2e
        L29:
            throw r0
        L2a:
            r1 = move-exception
            goto L1c
        L2c:
            r0 = move-exception
            goto L19
        L2e:
            r1 = move-exception
            goto L29
        L30:
            r0 = move-exception
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.V.a(android.content.Context, java.lang.String, byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                com.baidu.sapi2.utils.a.a(new File(Environment.getExternalStorageDirectory(), str), bArr, false);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }
}
