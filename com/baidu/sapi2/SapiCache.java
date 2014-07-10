package com.baidu.sapi2;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiCache {
    private static final AsyncHttpClient a = new AsyncHttpClient();
    private static final Map<String, SoftReference<String>> b = new ConcurrentHashMap();
    private static final List<String> c = new ArrayList();
    private static final List<String> d = new ArrayList();
    private static Context e;

    /* loaded from: classes.dex */
    public interface CacheEventListener {
        void onUpdated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface LoadModuleEventListener {
        void onFailure(b.a.C0007a c0007a);

        void onSuccess(b.a.C0007a c0007a, String str);
    }

    private SapiCache() {
    }

    static void a(String str, String str2) {
        b.put(str, new SoftReference<>(str2));
    }

    static void a(String str) {
        b.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        return b(context, c(str));
    }

    static String b(final Context context, String str) {
        d();
        if (d.a(context).j().d().a()) {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                b.a.C0007a c2 = c(context, str);
                if (c2 != null) {
                    a(c2, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.1
                        @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                        public void onSuccess(b.a.C0007a c0007a, String str2) {
                            SapiCache.a(c0007a.a, str2);
                        }

                        @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                        public void onFailure(b.a.C0007a c0007a) {
                            SapiCache.a(context, c0007a);
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
        if (b.containsKey(str) && b.get(str) != null) {
            String str2 = b.get(str).get();
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return null;
    }

    static b.a.C0007a c(Context context, String str) {
        for (b.a.C0007a c0007a : d.a(context).j().d().b()) {
            if (c0007a.a.equals(str)) {
                return c0007a;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        e = context;
        a();
        syncCache();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.sapi2.SapiCache$2] */
    static void a() {
        final b.a d2 = d.a(e).j().d();
        if (d2.a()) {
            for (b.a.C0007a c0007a : d2.b()) {
                c.add(c0007a.a);
            }
            d.addAll(c);
            new AsyncTask<Void, Void, Void>() { // from class: com.baidu.sapi2.SapiCache.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public Void doInBackground(Void... voidArr) {
                    for (b.a.C0007a c0007a2 : b.a.this.b()) {
                        SapiCache.a(c0007a2, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.2.1
                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onSuccess(b.a.C0007a c0007a3, String str) {
                                SapiCache.a(c0007a3.a, str);
                            }

                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onFailure(b.a.C0007a c0007a3) {
                                SapiCache.a(SapiCache.e, c0007a3);
                            }
                        });
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    static void a(b.a.C0007a c0007a, LoadModuleEventListener loadModuleEventListener) {
        if (loadModuleEventListener == null) {
            throw new IllegalArgumentException(LoadModuleEventListener.class.getName() + "can't be null");
        }
        String c2 = b.a.C0007a.c(c0007a.a);
        if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), c2).exists()) {
            try {
                String d2 = d(c2);
                if (MD5Util.toMd5(d2.getBytes(), false).equals(c0007a.c.c)) {
                    loadModuleEventListener.onSuccess(c0007a, d2);
                } else {
                    loadModuleEventListener.onFailure(c0007a);
                }
                return;
            } catch (Throwable th) {
                loadModuleEventListener.onFailure(c0007a);
                return;
            }
        }
        loadModuleEventListener.onFailure(c0007a);
    }

    static void a(Context context, b.a.C0007a c0007a) {
        String a2 = b.a.C0007a.a(c0007a.a);
        if (new File(context.getFilesDir(), a2).exists()) {
            try {
                a(c0007a.a, e(context, a2));
                return;
            } catch (Throwable th) {
                d(context, c0007a.a);
                return;
            }
        }
        d(context, c0007a.a);
    }

    static String d(Context context, String str) {
        try {
            a(str, f(context, b.a.C0007a.b(str)));
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

    public static void syncCache(final CacheEventListener cacheEventListener) {
        Handler handler = new Handler() { // from class: com.baidu.sapi2.SapiCache.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1001 && CacheEventListener.this != null) {
                    CacheEventListener.this.onUpdated();
                }
            }
        };
        if (!SapiUtils.hasActiveNetwork(e)) {
            if (cacheEventListener != null) {
                cacheEventListener.onUpdated();
                return;
            }
            return;
        }
        RequestParams b2 = b();
        b2.put("cdnversion", String.valueOf((int) (System.currentTimeMillis() / 90000.0d)));
        a.get(e, c(), b2, new AnonymousClass4(handler, cacheEventListener));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.SapiCache$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass4 extends JsonHttpResponseHandler {
        final /* synthetic */ Handler a;
        final /* synthetic */ CacheEventListener b;

        AnonymousClass4(Handler handler, CacheEventListener cacheEventListener) {
            this.a = handler;
            this.b = cacheEventListener;
        }

        @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
        public void onSuccess(JSONObject jSONObject) {
            if (jSONObject != null) {
                b j = d.a(SapiCache.e).j();
                b a = b.a(jSONObject);
                b.a d = a.d();
                d.a(SapiCache.e).a(a);
                com.baidu.sapi2.share.b.d();
                SapiCache.d.clear();
                if (d.a()) {
                    for (b.a.C0007a c0007a : d.b()) {
                        SapiCache.d.add(c0007a.a);
                    }
                    int[] iArr = {0};
                    for (b.a.C0007a c0007a2 : d.b()) {
                        b.a.C0007a c0007a3 = null;
                        for (b.a.C0007a c0007a4 : j.d().b()) {
                            if (!c0007a4.a.equals(c0007a2.a)) {
                                c0007a4 = c0007a3;
                            }
                            c0007a3 = c0007a4;
                        }
                        SapiCache.a.get(SapiCache.e, c0007a2.b, SapiCache.b(), new AnonymousClass1(c0007a2, c0007a3, a, d, iArr));
                    }
                } else if (this.b != null) {
                    this.b.onUpdated();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.sapi2.SapiCache$4$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 extends JsonHttpResponseHandler {
            final /* synthetic */ b.a.C0007a a;
            final /* synthetic */ b.a.C0007a b;
            final /* synthetic */ b c;
            final /* synthetic */ b.a d;
            final /* synthetic */ int[] e;

            AnonymousClass1(b.a.C0007a c0007a, b.a.C0007a c0007a2, b bVar, b.a aVar, int[] iArr) {
                this.a = c0007a;
                this.b = c0007a2;
                this.c = bVar;
                this.d = aVar;
                this.e = iArr;
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.sapi2.SapiCache$4$1$2] */
            @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
            public void onSuccess(JSONObject jSONObject) {
                this.a.c = b.a.C0007a.C0008a.a(jSONObject);
                if (!SapiCache.a(this.a, this.b)) {
                    d.a(SapiCache.e).a(this.c);
                    SapiCache.a(this.d, this.e, AnonymousClass4.this.a);
                    new AsyncTask<Void, Void, Void>() { // from class: com.baidu.sapi2.SapiCache.4.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public Void doInBackground(Void... voidArr) {
                            SapiCache.a(AnonymousClass1.this.a, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.4.1.2.1
                                @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                                public void onSuccess(b.a.C0007a c0007a, String str) {
                                }

                                @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                                public void onFailure(b.a.C0007a c0007a) {
                                    String a = b.a.C0007a.a(c0007a.a);
                                    String c = b.a.C0007a.c(c0007a.a);
                                    if (new File(SapiCache.e.getFilesDir(), a).exists()) {
                                        try {
                                            SapiCache.a(c, SapiCache.e(SapiCache.e, a).getBytes());
                                        } catch (Throwable th) {
                                            L.e(th);
                                        }
                                    }
                                }
                            });
                            return null;
                        }
                    }.execute(new Void[0]);
                    return;
                }
                new Thread(new RunnableC00021()).start();
            }

            /* renamed from: com.baidu.sapi2.SapiCache$4$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC00021 implements Runnable {
                RunnableC00021() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SapiCache.a(AnonymousClass1.this.a, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.4.1.1.1
                        @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                        public void onSuccess(b.a.C0007a c0007a, String str) {
                            d.a(SapiCache.e).a(AnonymousClass1.this.c);
                            if (!TextUtils.isEmpty(AnonymousClass1.this.a.a) && !TextUtils.isEmpty(str)) {
                                SapiCache.a(AnonymousClass1.this.a.a, str);
                                SapiCache.a(SapiCache.e, b.a.C0007a.a(AnonymousClass1.this.a.a), str.getBytes());
                            }
                            SapiCache.a(AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass4.this.a);
                        }

                        @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                        public void onFailure(b.a.C0007a c0007a) {
                            Looper.prepare();
                            SapiCache.a.get(SapiCache.e, AnonymousClass1.this.a.c.a, SapiCache.b(), new HttpResponseHandler() { // from class: com.baidu.sapi2.SapiCache.4.1.1.1.1
                                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                public void onSuccess(String str) {
                                    if (!TextUtils.isEmpty(AnonymousClass1.this.a.a) && !TextUtils.isEmpty(str) && AnonymousClass1.this.a.c.c.equals(MD5Util.toMd5(str.getBytes(), false))) {
                                        d.a(SapiCache.e).a(AnonymousClass1.this.c);
                                        SapiCache.a(AnonymousClass1.this.a.a, str);
                                        SapiCache.a(SapiCache.e, b.a.C0007a.a(AnonymousClass1.this.a.a), str.getBytes());
                                        SapiCache.a(b.a.C0007a.c(AnonymousClass1.this.a.a), str.getBytes());
                                    }
                                    SapiCache.a(AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass4.this.a);
                                }

                                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                public void onFailure(Throwable th, String str) {
                                    SapiCache.a(AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass4.this.a);
                                }
                            });
                            Looper.loop();
                        }
                    });
                }
            }
        }

        @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
        public void onFailure(Throwable th, JSONObject jSONObject) {
            if (this.b != null) {
                this.b.onUpdated();
            }
        }
    }

    public static void syncCache() {
        syncCache(null);
    }

    static synchronized RequestParams b() {
        RequestParams requestParams;
        synchronized (SapiCache.class) {
            requestParams = new RequestParams();
            requestParams.put("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl);
            requestParams.put("sdk_version", SapiAccountManager.VERSION_NAME);
            requestParams.put("app_version", SapiUtils.getVersionName(e));
        }
        return requestParams;
    }

    static synchronized void a(b.a aVar, int[] iArr, Handler handler) {
        synchronized (SapiCache.class) {
            iArr[0] = iArr[0] + 1;
            if (iArr[0] == aVar.b().size()) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 1001;
                handler.sendMessage(obtainMessage);
            }
        }
    }

    static boolean a(b.a.C0007a c0007a, b.a.C0007a c0007a2) {
        return c0007a.c.b > 0 && (c0007a2 == null || c0007a.c.b != c0007a2.c.b);
    }

    static String c() {
        return SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigUrl() + e.u;
    }

    static void d() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : c) {
            if (!d.contains(str)) {
                arrayList.add(str);
                a(str);
            }
        }
        for (String str2 : arrayList) {
            if (c.contains(str2)) {
                c.remove(str2);
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [561=4] */
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [592=4] */
    static void a(java.lang.String r4, byte[] r5) {
        /*
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3e
            r0 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L3f
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L3f
            r2.<init>(r1, r4)     // Catch: java.lang.Throwable -> L3f
            java.io.File r1 = r2.getParentFile()     // Catch: java.lang.Throwable -> L3f
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L3f
            if (r1 != 0) goto L28
            java.io.File r1 = r2.getParentFile()     // Catch: java.lang.Throwable -> L3f
            r1.mkdirs()     // Catch: java.lang.Throwable -> L3f
        L28:
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L3f
            if (r1 != 0) goto L31
            r2.createNewFile()     // Catch: java.lang.Throwable -> L3f
        L31:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3f
            r1.write(r5)     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L3e
            r1.close()     // Catch: java.lang.Throwable -> L52
        L3e:
            return
        L3f:
            r1 = move-exception
        L40:
            if (r0 == 0) goto L3e
            r0.close()     // Catch: java.lang.Throwable -> L46
            goto L3e
        L46:
            r0 = move-exception
            goto L3e
        L48:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L4c:
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.lang.Throwable -> L54
        L51:
            throw r0
        L52:
            r0 = move-exception
            goto L3e
        L54:
            r1 = move-exception
            goto L51
        L56:
            r0 = move-exception
            goto L4c
        L58:
            r0 = move-exception
            r0 = r1
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiCache.a(java.lang.String, byte[]):void");
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
