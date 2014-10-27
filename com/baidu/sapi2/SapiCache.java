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
import com.baidu.sapi2.b;
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
        void a(b.a.C0006a c0006a);

        void a(b.a.C0006a c0006a, String str);
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
        if (com.baidu.sapi2.c.a(context).j().h().a()) {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                b.a.C0006a c2 = c(context, str);
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
        public void a(b.a.C0006a c0006a, String str) {
            SapiCache.a(c0006a.a, str);
        }

        @Override // com.baidu.sapi2.SapiCache.a
        public void a(b.a.C0006a c0006a) {
            SapiCache.a(this.a, c0006a);
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

    static b.a.C0006a c(Context context, String str) {
        for (b.a.C0006a c0006a : com.baidu.sapi2.c.a(context).j().h().b()) {
            if (c0006a.a.equals(str)) {
                return c0006a;
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
        b.a h = com.baidu.sapi2.c.a(d).j().h();
        if (h.a()) {
            for (b.a.C0006a c0006a : h.b()) {
                b.add(c0006a.a);
            }
            c.addAll(b);
            for (b.a.C0006a c0006a2 : h.b()) {
                a(c0006a2, new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c implements a {
        c() {
        }

        @Override // com.baidu.sapi2.SapiCache.a
        public void a(b.a.C0006a c0006a, String str) {
            SapiCache.a(c0006a.a, str);
        }

        @Override // com.baidu.sapi2.SapiCache.a
        public void a(b.a.C0006a c0006a) {
            SapiCache.a(SapiCache.d, c0006a);
        }
    }

    static void a(b.a.C0006a c0006a, a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException(a.class.getName() + "can't be null");
        }
        String c2 = b.a.C0006a.c(c0006a.a);
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), c2).exists()) {
                String d2 = d(c2);
                if (MD5Util.toMd5(d2.getBytes(), false).equals(c0006a.c.c)) {
                    aVar.a(c0006a, d2);
                } else {
                    aVar.a(c0006a);
                }
            } else {
                aVar.a(c0006a);
            }
        } catch (Throwable th) {
            aVar.a(c0006a);
        }
    }

    static void a(Context context, b.a.C0006a c0006a) {
        String a2 = b.a.C0006a.a(c0006a.a);
        if (new File(context.getFilesDir(), a2).exists()) {
            try {
                a(c0006a.a, e(context, a2));
                return;
            } catch (Throwable th) {
                d(context, c0006a.a);
                return;
            }
        }
        d(context, c0006a.a);
    }

    static String d(Context context, String str) {
        try {
            a(str, f(context, b.a.C0006a.b(str)));
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
            RequestParams c2 = c();
            c2.put("cdnversion", String.valueOf((int) (System.currentTimeMillis() / 90000.0d)));
            try {
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
                com.baidu.sapi2.b j = com.baidu.sapi2.c.a(SapiCache.d).j();
                com.baidu.sapi2.b a2 = com.baidu.sapi2.b.a(jSONObject);
                b.a h = a2.h();
                com.baidu.sapi2.c.a(SapiCache.d).a(a2);
                com.baidu.sapi2.share.c.c();
                com.baidu.sapi2.share.c.d();
                SapiCache.c.clear();
                if (h.a()) {
                    for (b.a.C0006a c0006a : h.b()) {
                        SapiCache.c.add(c0006a.a);
                    }
                    for (b.a.C0006a c0006a2 : h.b()) {
                        b.a.C0006a c0006a3 = null;
                        for (b.a.C0006a c0006a4 : j.h().b()) {
                            if (!c0006a4.a.equals(c0006a2.a)) {
                                c0006a4 = c0006a3;
                            }
                            c0006a3 = c0006a4;
                        }
                        new AsyncHttpClient().get(SapiCache.d, c0006a2.b, SapiCache.c(), new a(c0006a2, c0006a3, a2));
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        class a extends JsonHttpResponseHandler {
            final /* synthetic */ b.a.C0006a a;
            final /* synthetic */ b.a.C0006a b;
            final /* synthetic */ com.baidu.sapi2.b c;

            a(b.a.C0006a c0006a, b.a.C0006a c0006a2, com.baidu.sapi2.b bVar) {
                this.a = c0006a;
                this.b = c0006a2;
                this.c = bVar;
            }

            @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
            public void onSuccess(JSONObject jSONObject) {
                this.a.c = b.a.C0006a.C0007a.a(jSONObject);
                if (!SapiCache.a(this.a, this.b)) {
                    com.baidu.sapi2.c.a(SapiCache.d).a(this.c);
                    SapiCache.a(this.a, new C0004b());
                    return;
                }
                SapiCache.a(this.a, new C0002a());
            }

            /* renamed from: com.baidu.sapi2.SapiCache$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0002a implements a {
                C0002a() {
                }

                @Override // com.baidu.sapi2.SapiCache.a
                public void a(b.a.C0006a c0006a, String str) {
                    com.baidu.sapi2.c.a(SapiCache.d).a(a.this.c);
                    if (!TextUtils.isEmpty(a.this.a.a) && !TextUtils.isEmpty(str)) {
                        SapiCache.a(a.this.a.a, str);
                        SapiCache.a(SapiCache.d, b.a.C0006a.a(a.this.a.a), str.getBytes());
                    }
                }

                /* renamed from: com.baidu.sapi2.SapiCache$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class HandlerC0003a extends HttpResponseHandler {
                    HandlerC0003a() {
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(String str) {
                        if (!TextUtils.isEmpty(a.this.a.a) && !TextUtils.isEmpty(str) && a.this.a.c.c.equals(MD5Util.toMd5(str.getBytes(), false))) {
                            com.baidu.sapi2.c.a(SapiCache.d).a(a.this.c);
                            SapiCache.a(a.this.a.a, str);
                            SapiCache.a(SapiCache.d, b.a.C0006a.a(a.this.a.a), str.getBytes());
                            SapiCache.a(b.a.C0006a.c(a.this.a.a), str.getBytes());
                        }
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                    }
                }

                @Override // com.baidu.sapi2.SapiCache.a
                public void a(b.a.C0006a c0006a) {
                    new AsyncHttpClient().get(SapiCache.d, a.this.a.c.a, SapiCache.c(), new HandlerC0003a());
                }
            }

            /* renamed from: com.baidu.sapi2.SapiCache$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0004b implements a {
                C0004b() {
                }

                @Override // com.baidu.sapi2.SapiCache.a
                public void a(b.a.C0006a c0006a, String str) {
                }

                @Override // com.baidu.sapi2.SapiCache.a
                public void a(b.a.C0006a c0006a) {
                    String a = b.a.C0006a.a(c0006a.a);
                    String c = b.a.C0006a.c(c0006a.a);
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

    static boolean a(b.a.C0006a c0006a, b.a.C0006a c0006a2) {
        return c0006a.c.b > 0 && (c0006a2 == null || c0006a.c.b != c0006a2.c.b);
    }

    static String d() {
        return SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigUrl() + e.u;
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [487=4] */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [520=4] */
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
