package com.baidu.sapi2;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.c;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
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
        void a(c.a.C0026a c0026a);

        void a(c.a.C0026a c0026a, String str);
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

    static String b(Context context, String str) {
        e();
        if (com.baidu.sapi2.d.a(context).j().g().a()) {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                c.a.C0026a c2 = c(context, str);
                if (c2 != null) {
                    a(c2, new d(context));
                    return b(str);
                }
                return d(context, str);
            }
            return b2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d implements a {
        final /* synthetic */ Context a;

        d(Context context) {
            this.a = context;
        }

        @Override // com.baidu.sapi2.SapiCache.a
        public void a(c.a.C0026a c0026a, String str) {
            SapiCache.a(c0026a.a, str);
        }

        @Override // com.baidu.sapi2.SapiCache.a
        public void a(c.a.C0026a c0026a) {
            SapiCache.a(this.a, c0026a);
        }
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

    static c.a.C0026a c(Context context, String str) {
        for (c.a.C0026a c0026a : com.baidu.sapi2.d.a(context).j().g().b()) {
            if (c0026a.a.equals(str)) {
                return c0026a;
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
        SapiAccountManager.getInstance().getAccountService().p();
    }

    static void a() {
        c.a g = com.baidu.sapi2.d.a(d).j().g();
        if (g.a()) {
            for (c.a.C0026a c0026a : g.b()) {
                b.add(c0026a.a);
            }
            c.addAll(b);
            for (c.a.C0026a c0026a2 : g.b()) {
                a(c0026a2, new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c implements a {
        c() {
        }

        @Override // com.baidu.sapi2.SapiCache.a
        public void a(c.a.C0026a c0026a, String str) {
            SapiCache.a(c0026a.a, str);
        }

        @Override // com.baidu.sapi2.SapiCache.a
        public void a(c.a.C0026a c0026a) {
            SapiCache.a(SapiCache.d, c0026a);
        }
    }

    static void a(c.a.C0026a c0026a, a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException(a.class.getName() + "can't be null");
        }
        String c2 = c.a.C0026a.c(c0026a.a);
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), c2).exists()) {
                String d2 = d(c2);
                if (MD5Util.toMd5(d2.getBytes(), false).equals(c0026a.c.c)) {
                    aVar.a(c0026a, d2);
                } else {
                    aVar.a(c0026a);
                }
            } else {
                aVar.a(c0026a);
            }
        } catch (Throwable th) {
            aVar.a(c0026a);
        }
    }

    static void a(Context context, c.a.C0026a c0026a) {
        String a2 = c.a.C0026a.a(c0026a.a);
        if (new File(context.getFilesDir(), a2).exists()) {
            try {
                a(c0026a.a, e(context, a2));
                return;
            } catch (Throwable th) {
                d(context, c0026a.a);
                return;
            }
        }
        d(context, c0026a.a);
    }

    static String d(Context context, String str) {
        try {
            a(str, f(context, c.a.C0026a.b(str)));
            return b(context, str);
        } catch (Throwable th) {
            return null;
        }
    }

    static String c(String str) {
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
                if (!TextUtils.isEmpty(e.b(com.baidu.sapi2.utils.d.z))) {
                    c2.put("di", e.b(com.baidu.sapi2.utils.d.z));
                }
                c2.put("cdnversion", String.valueOf((int) (System.currentTimeMillis() / 300000)));
                new AsyncHttpClient().get(d, d(), c2, new b());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b extends JsonHttpResponseHandler {
        b() {
        }

        @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
        public void onSuccess(JSONObject jSONObject) {
            if (jSONObject != null) {
                com.baidu.sapi2.c j = com.baidu.sapi2.d.a(SapiCache.d).j();
                com.baidu.sapi2.c a2 = com.baidu.sapi2.c.a(jSONObject);
                c.a g = a2.g();
                com.baidu.sapi2.d.a(SapiCache.d).a(a2);
                com.baidu.sapi2.share.b.b();
                SapiCache.c.clear();
                if (g.a()) {
                    for (c.a.C0026a c0026a : g.b()) {
                        SapiCache.c.add(c0026a.a);
                    }
                    for (c.a.C0026a c0026a2 : g.b()) {
                        c.a.C0026a c0026a3 = null;
                        for (c.a.C0026a c0026a4 : j.g().b()) {
                            if (!c0026a4.a.equals(c0026a2.a)) {
                                c0026a4 = c0026a3;
                            }
                            c0026a3 = c0026a4;
                        }
                        new AsyncHttpClient().get(SapiCache.d, c0026a2.b, SapiCache.c(), new a(c0026a2, c0026a3, a2));
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        class a extends JsonHttpResponseHandler {
            final /* synthetic */ c.a.C0026a a;
            final /* synthetic */ c.a.C0026a b;
            final /* synthetic */ com.baidu.sapi2.c c;

            a(c.a.C0026a c0026a, c.a.C0026a c0026a2, com.baidu.sapi2.c cVar) {
                this.a = c0026a;
                this.b = c0026a2;
                this.c = cVar;
            }

            @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
            public void onSuccess(JSONObject jSONObject) {
                this.a.c = c.a.C0026a.C0027a.a(jSONObject);
                if (!SapiCache.a(this.a, this.b)) {
                    com.baidu.sapi2.d.a(SapiCache.d).a(this.c);
                    SapiCache.a(this.a, new C0019b());
                    return;
                }
                SapiCache.a(this.a, new C0017a());
            }

            /* renamed from: com.baidu.sapi2.SapiCache$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0017a implements a {
                C0017a() {
                }

                @Override // com.baidu.sapi2.SapiCache.a
                public void a(c.a.C0026a c0026a, String str) {
                    com.baidu.sapi2.d.a(SapiCache.d).a(a.this.c);
                    if (!TextUtils.isEmpty(a.this.a.a) && !TextUtils.isEmpty(str)) {
                        SapiCache.a(a.this.a.a, str);
                        SapiCache.a(SapiCache.d, c.a.C0026a.a(a.this.a.a), str.getBytes());
                    }
                }

                /* renamed from: com.baidu.sapi2.SapiCache$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class HandlerC0018a extends HttpResponseHandler {
                    HandlerC0018a() {
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(String str) {
                        if (!TextUtils.isEmpty(a.this.a.a) && !TextUtils.isEmpty(str) && a.this.a.c.c.equals(MD5Util.toMd5(str.getBytes(), false))) {
                            com.baidu.sapi2.d.a(SapiCache.d).a(a.this.c);
                            SapiCache.a(a.this.a.a, str);
                            SapiCache.a(SapiCache.d, c.a.C0026a.a(a.this.a.a), str.getBytes());
                            SapiCache.a(c.a.C0026a.c(a.this.a.a), str.getBytes());
                        }
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                    }
                }

                @Override // com.baidu.sapi2.SapiCache.a
                public void a(c.a.C0026a c0026a) {
                    new AsyncHttpClient().get(SapiCache.d, a.this.a.c.a, SapiCache.c(), new HandlerC0018a());
                }
            }

            /* renamed from: com.baidu.sapi2.SapiCache$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0019b implements a {
                C0019b() {
                }

                @Override // com.baidu.sapi2.SapiCache.a
                public void a(c.a.C0026a c0026a, String str) {
                }

                @Override // com.baidu.sapi2.SapiCache.a
                public void a(c.a.C0026a c0026a) {
                    String a = c.a.C0026a.a(c0026a.a);
                    String c = c.a.C0026a.c(c0026a.a);
                    if (new File(SapiCache.d.getFilesDir(), a).exists()) {
                        try {
                            SapiCache.a(c, SapiCache.e(SapiCache.d, a).getBytes());
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }
            }
        }
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

    static boolean a(c.a.C0026a c0026a, c.a.C0026a c0026a2) {
        return c0026a.c.b > 0 && (c0026a2 == null || c0026a.c.b != c0026a2.c.b);
    }

    static String d() {
        return SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigUrl() + com.baidu.sapi2.utils.d.z;
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [494=4] */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [527=4] */
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

    static String d(String str) {
        FileInputStream fileInputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory(), str));
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            return new String(bArr);
        } finally {
            fileInputStream.close();
        }
    }

    static String e(Context context, String str) {
        FileInputStream openFileInput = context.openFileInput(str);
        try {
            byte[] bArr = new byte[openFileInput.available()];
            openFileInput.read(bArr);
            return new String(bArr);
        } finally {
            openFileInput.close();
        }
    }

    static String f(Context context, String str) {
        InputStream open = context.getAssets().open(str);
        try {
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            return new String(bArr);
        } finally {
            open.close();
        }
    }
}
