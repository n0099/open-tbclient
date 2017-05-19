package com.baidu.sapi2;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.d;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.e;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.f;
import com.baidu.sapi2.utils.g;
import com.baidu.sapi2.utils.h;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiCache {
    private static final Map<String, SoftReference<String>> a = new ConcurrentHashMap();
    private static final List<String> b = new ArrayList();
    private static final List<String> c = new ArrayList();
    private static Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(d.a.C0028a c0028a);

        void a(d.a.C0028a c0028a, String str);
    }

    private SapiCache() {
    }

    static void a(String str, String str2) {
        a.put(str, new SoftReference<>(str2));
    }

    static void a(String str) {
        a.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        return b(context, c(str));
    }

    static String b(final Context context, String str) {
        e();
        if (c.a(context).k().j().a()) {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                d.a.C0028a c2 = c(context, str);
                if (c2 != null) {
                    a(c2, new a() { // from class: com.baidu.sapi2.SapiCache.1
                        @Override // com.baidu.sapi2.SapiCache.a
                        public void a(d.a.C0028a c0028a, String str2) {
                            SapiCache.a(c0028a.a, str2);
                        }

                        @Override // com.baidu.sapi2.SapiCache.a
                        public void a(d.a.C0028a c0028a) {
                            SapiCache.a(context, c0028a);
                        }
                    });
                    return b(str);
                }
                return d(context, str);
            }
            return b2;
        }
        return null;
    }

    static String b(String str) {
        if (a.containsKey(str) && a.get(str) != null) {
            String str2 = a.get(str).get();
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d.a.C0028a c(Context context, String str) {
        for (d.a.C0028a c0028a : c.a(context).k().j().b()) {
            if (c0028a.a.equals(str)) {
                return c0028a;
            }
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        d = context.getApplicationContext();
        a();
        b();
    }

    static void a() {
        d.a j = c.a(d).k().j();
        if (j.a()) {
            for (d.a.C0028a c0028a : j.b()) {
                b.add(c0028a.a);
            }
            c.addAll(b);
            for (d.a.C0028a c0028a2 : j.b()) {
                a(c0028a2, new a() { // from class: com.baidu.sapi2.SapiCache.2
                    @Override // com.baidu.sapi2.SapiCache.a
                    public void a(d.a.C0028a c0028a3, String str) {
                        SapiCache.a(c0028a3.a, str);
                    }

                    @Override // com.baidu.sapi2.SapiCache.a
                    public void a(d.a.C0028a c0028a3) {
                        SapiCache.a(SapiCache.d, c0028a3);
                    }
                });
            }
        }
    }

    static void a(d.a.C0028a c0028a, a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException(a.class.getName() + "can't be null");
        }
        String c2 = d.a.C0028a.c(c0028a.a);
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), c2).exists()) {
                String d2 = d(c2);
                if (MD5Util.toMd5(d2.getBytes(), false).equals(c0028a.c)) {
                    aVar.a(c0028a, d2);
                } else {
                    aVar.a(c0028a);
                }
            } else {
                aVar.a(c0028a);
            }
        } catch (Throwable th) {
            aVar.a(c0028a);
        }
    }

    static void a(Context context, d.a.C0028a c0028a) {
        String a2 = d.a.C0028a.a(c0028a.a);
        if (new File(context.getFilesDir(), a2).exists()) {
            try {
                a(c0028a.a, e(context, a2));
                return;
            } catch (Throwable th) {
                d(context, c0028a.a);
                return;
            }
        }
        d(context, c0028a.a);
    }

    static String d(Context context, String str) {
        try {
            a(str, f(context, d.a.C0028a.b(str)));
            return b(context, str);
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        Uri parse;
        String str2 = parse.getHost() + (Uri.parse(str).getPort() == -1 ? "" : ":" + parse.getPort()) + parse.getPath();
        if (!str2.endsWith(".html")) {
            return str2 + ".html";
        }
        return str2;
    }

    static void b() {
        if (SapiUtils.hasActiveNetwork(d)) {
            try {
                RequestParams c2 = c();
                String b2 = e.b(f.B);
                if (!TextUtils.isEmpty(b2)) {
                    StatService.a("dvif_interface", Collections.singletonMap("di", b2), false);
                }
                c2.put("cdnversion", String.valueOf((int) (System.currentTimeMillis() / ReportUserInfoModel.TIME_INTERVAL)));
                new AsyncHttpClient().get(d, d(), c2, new JsonHttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiCache.3
                    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
                    public void onSuccess(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            SapiCache.a(jSONObject);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                        super.onFailure(th, str);
                        StatService.a("sslerr_config", Collections.singletonMap("na_err_code", "0"), false);
                    }
                });
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    static void a(JSONObject jSONObject) {
        d k = c.a(d).k();
        h.a().c(new g(new AnonymousClass4(d.a(jSONObject), k)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.SapiCache$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass4 implements Runnable {
        final /* synthetic */ d a;
        final /* synthetic */ d b;

        AnonymousClass4(d dVar, d dVar2) {
            this.a = dVar;
            this.b = dVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a j = this.a.j();
            final d.a j2 = this.b.j();
            c.a(SapiCache.d).a(this.a);
            c.a(SapiCache.d).a(SapiAccountManager.getInstance().getSession(), false);
            SapiCache.c.clear();
            if (j.a()) {
                for (d.a.C0028a c0028a : j.b()) {
                    SapiCache.c.add(c0028a.a);
                }
                for (final d.a.C0028a c0028a2 : j.b()) {
                    d.a.C0028a c0028a3 = null;
                    for (d.a.C0028a c0028a4 : this.b.j().b()) {
                        if (!c0028a4.a.equals(c0028a2.a)) {
                            c0028a4 = c0028a3;
                        }
                        c0028a3 = c0028a4;
                    }
                    if (!SapiCache.a(c0028a2, c0028a3)) {
                        c.a(SapiCache.d).a(this.a);
                        SapiCache.a(c0028a2, new a() { // from class: com.baidu.sapi2.SapiCache.4.2
                            @Override // com.baidu.sapi2.SapiCache.a
                            public void a(d.a.C0028a c0028a5, String str) {
                            }

                            @Override // com.baidu.sapi2.SapiCache.a
                            public void a(d.a.C0028a c0028a5) {
                                String a = d.a.C0028a.a(c0028a5.a);
                                String c = d.a.C0028a.c(c0028a5.a);
                                if (new File(SapiCache.d.getFilesDir(), a).exists()) {
                                    try {
                                        String e = SapiCache.e(SapiCache.d, a);
                                        if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.d)) {
                                            SapiCache.a(c, e.getBytes());
                                        }
                                    } catch (Throwable th) {
                                        L.e(th);
                                    }
                                }
                            }
                        });
                    } else {
                        SapiCache.a(c0028a2, new a() { // from class: com.baidu.sapi2.SapiCache.4.1
                            @Override // com.baidu.sapi2.SapiCache.a
                            public void a(d.a.C0028a c0028a5, String str) {
                                c.a(SapiCache.d).a(AnonymousClass4.this.a);
                                if (!TextUtils.isEmpty(c0028a2.a) && !TextUtils.isEmpty(str)) {
                                    SapiCache.a(c0028a2.a, str);
                                    SapiCache.a(SapiCache.d, d.a.C0028a.a(c0028a2.a), str.getBytes());
                                }
                            }

                            @Override // com.baidu.sapi2.SapiCache.a
                            public void a(d.a.C0028a c0028a5) {
                                new AsyncHttpClient().get(SapiCache.d, c0028a2.b, SapiCache.c(), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiCache.4.1.1
                                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                    public void onSuccess(String str) {
                                        SapiCache.a(str, c0028a2, AnonymousClass4.this.a);
                                    }

                                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                    public void onFailure(Throwable th, String str) {
                                        AnonymousClass4.this.a.a(j2);
                                        c.a(SapiCache.d).a(AnonymousClass4.this.a);
                                    }
                                });
                            }
                        });
                    }
                }
            }
        }
    }

    static void a(final String str, final d.a.C0028a c0028a, final d dVar) {
        h.a().c(new g(new Runnable() { // from class: com.baidu.sapi2.SapiCache.5
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(d.a.C0028a.this.a) && !TextUtils.isEmpty(str) && d.a.C0028a.this.c.equals(MD5Util.toMd5(str.getBytes(), false))) {
                    c.a(SapiCache.d).a(dVar);
                    SapiCache.a(d.a.C0028a.this.a, str);
                    SapiCache.a(SapiCache.d, d.a.C0028a.a(d.a.C0028a.this.a), str.getBytes());
                    if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.d)) {
                        SapiCache.a(d.a.C0028a.c(d.a.C0028a.this.a), str.getBytes());
                    }
                }
            }
        }));
    }

    static synchronized RequestParams c() {
        RequestParams requestParams;
        synchronized (SapiCache.class) {
            requestParams = new RequestParams();
            requestParams.put("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl);
            requestParams.put("sdk_version", SapiAccountManager.VERSION_NAME);
            requestParams.put("app_version", SapiUtils.getVersionName(d));
        }
        return requestParams;
    }

    static boolean a(d.a.C0028a c0028a, d.a.C0028a c0028a2) {
        return !TextUtils.isEmpty(c0028a.c) && (c0028a2 == null || !c0028a.c.equals(c0028a2.c));
    }

    static String d() {
        return !SapiAccountManager.getInstance().getSapiConfiguration().environment.equals(Domain.DOMAIN_ONLINE) ? SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigUrl() + f.B : SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + f.C;
    }

    static void e() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : b) {
            if (!c.contains(str)) {
                arrayList.add(str);
                a(str);
            }
        }
        for (String str2 : arrayList) {
            if (b.contains(str2)) {
                b.remove(str2);
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [552=4] */
    static void a(android.content.Context r3, java.lang.String r4, byte[] r5) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r0 = r3.openFileOutput(r4, r1)     // Catch: java.lang.Throwable -> Lf
            r0.write(r5)     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto Le
            r0.close()     // Catch: java.lang.Throwable -> L22
        Le:
            return
        Lf:
            r1 = move-exception
            if (r0 == 0) goto Le
            r0.close()     // Catch: java.lang.Throwable -> L16
            goto Le
        L16:
            r0 = move-exception
            goto Le
        L18:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1c:
            if (r1 == 0) goto L21
            r1.close()     // Catch: java.lang.Throwable -> L24
        L21:
            throw r0
        L22:
            r0 = move-exception
            goto Le
        L24:
            r1 = move-exception
            goto L21
        L26:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiCache.a(android.content.Context, java.lang.String, byte[]):void");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [585=4] */
    static void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory(), str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        L.e(th);
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (Throwable th2) {
                                L.e(th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th4) {
                                L.e(th4);
                            }
                        }
                        throw th3;
                    }
                }
            } else {
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    L.e(th5);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    static String d(String str) throws IOException {
        return a(new FileInputStream(new File(Environment.getExternalStorageDirectory(), str)));
    }

    static String e(Context context, String str) throws IOException {
        return a(context.openFileInput(str));
    }

    static String f(Context context, String str) throws IOException {
        return a(context.getAssets().open(str));
    }

    static String a(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return new String(bArr);
        } finally {
            inputStream.close();
        }
    }
}
