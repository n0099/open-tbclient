package com.baidu.sapi2;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.a.h;
import com.baidu.sapi2.a.i;
import com.baidu.sapi2.b;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiCache {
    private static final String a = "<link href=\"\" type=text/css rel=stylesheet id=product-skin>";
    private static final String b = "file:///android_asset";
    private static final com.baidu.sapi2.a.a c = new com.baidu.sapi2.a.a();
    private static final Map<String, SoftReference<String>> d = new ConcurrentHashMap();
    private static final List<String> e = new ArrayList();
    private static final List<String> f = new ArrayList();
    private static Context g;

    /* loaded from: classes.dex */
    public interface CacheEventListener {
        void onUpdated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface LoadModuleEventListener {
        void onFailure(b.a.C0010a c0010a);

        void onSuccess(b.a.C0010a c0010a, String str);
    }

    private SapiCache() {
    }

    static void a(String str, String str2) {
        d.put(str, new SoftReference<>(str2));
    }

    static void a(String str) {
        d.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        return e(b(context, b(str)));
    }

    static String b(Context context, String str) {
        d();
        if (d.a(context).e().b().a()) {
            if (d.containsKey(str) && d.get(str) != null && d.get(str).get() != null) {
                return d.get(str).get();
            }
            return c(context, str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        g = context;
        a();
        syncCache();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.sapi2.SapiCache$1] */
    static void a() {
        final b.a b2 = d.a(g).e().b();
        if (b2.a()) {
            for (b.a.C0010a c0010a : b2.b()) {
                e.add(c0010a.a);
            }
            f.addAll(e);
            new AsyncTask<Void, Void, Void>() { // from class: com.baidu.sapi2.SapiCache.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public Void doInBackground(Void... voidArr) {
                    for (b.a.C0010a c0010a2 : b.a.this.b()) {
                        SapiCache.a(c0010a2, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.1.1
                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onSuccess(b.a.C0010a c0010a3, String str) {
                                SapiCache.a(c0010a3.a, str);
                            }

                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onFailure(b.a.C0010a c0010a3) {
                                SapiCache.a(SapiCache.g, c0010a3);
                            }
                        });
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    static void a(b.a.C0010a c0010a, LoadModuleEventListener loadModuleEventListener) {
        if (loadModuleEventListener == null) {
            throw new IllegalArgumentException(LoadModuleEventListener.class.getName() + "can't be null");
        }
        String c2 = b.a.C0010a.c(c0010a.a);
        if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), c2).exists()) {
            try {
                String d2 = d(c2);
                if (com.baidu.sapi2.utils.b.d.a(d2).equals(c0010a.c.c)) {
                    loadModuleEventListener.onSuccess(c0010a, d2);
                } else {
                    loadModuleEventListener.onFailure(c0010a);
                }
                return;
            } catch (IOException e2) {
                loadModuleEventListener.onFailure(c0010a);
                return;
            }
        }
        loadModuleEventListener.onFailure(c0010a);
    }

    static void a(Context context, b.a.C0010a c0010a) {
        String a2 = b.a.C0010a.a(c0010a.a);
        if (new File(context.getFilesDir(), a2).exists()) {
            try {
                a(c0010a.a, d(context, a2));
                return;
            } catch (IOException e2) {
                c(context, c0010a.a);
                return;
            }
        }
        c(context, c0010a.a);
    }

    static String c(Context context, String str) {
        try {
            a(str, e(context, b.a.C0010a.b(str)));
            return b(context, str);
        } catch (IOException e2) {
            return null;
        }
    }

    static String b(String str) {
        Uri parse;
        String str2 = parse.getHost() + (Uri.parse(str).getPort() == -1 ? "" : ":" + parse.getPort()) + parse.getPath();
        if (!str2.endsWith(".html")) {
            return str2 + ".html";
        }
        return str2;
    }

    public static void syncCache(final CacheEventListener cacheEventListener) {
        Handler handler = new Handler() { // from class: com.baidu.sapi2.SapiCache.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1001 && CacheEventListener.this != null) {
                    CacheEventListener.this.onUpdated();
                }
            }
        };
        if (!SapiUtils.hasActiveNetwork(g)) {
            if (cacheEventListener != null) {
                cacheEventListener.onUpdated();
                return;
            }
            return;
        }
        c.a(g, c() + String.valueOf(new Date().getTime() / 60000), new AnonymousClass3(handler, cacheEventListener));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.SapiCache$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass3 extends h {
        final /* synthetic */ Handler a;
        final /* synthetic */ CacheEventListener b;

        AnonymousClass3(Handler handler, CacheEventListener cacheEventListener) {
            this.a = handler;
            this.b = cacheEventListener;
        }

        @Override // com.baidu.sapi2.a.h
        public void onSuccess(JSONObject jSONObject) {
            b e = d.a(SapiCache.g).e();
            b a = b.a(jSONObject);
            b.a b = a.b();
            d.a(SapiCache.g).a(a);
            SapiCache.f.clear();
            if (b.a()) {
                for (b.a.C0010a c0010a : b.b()) {
                    SapiCache.f.add(c0010a.a);
                }
                int[] iArr = {0};
                for (b.a.C0010a c0010a2 : b.b()) {
                    b.a.C0010a c0010a3 = null;
                    for (b.a.C0010a c0010a4 : e.b().b()) {
                        if (!c0010a4.a.equals(c0010a2.a)) {
                            c0010a4 = c0010a3;
                        }
                        c0010a3 = c0010a4;
                    }
                    com.baidu.sapi2.a.b bVar = new com.baidu.sapi2.a.b();
                    for (NameValuePair nameValuePair : SapiCache.b()) {
                        bVar.a(nameValuePair.getName(), nameValuePair.getValue());
                    }
                    bVar.a("module_id", c0010a2.a);
                    bVar.a("module_version", String.valueOf(c0010a3 == null ? 0L : c0010a3.c.b));
                    SapiCache.c.b(SapiCache.g, c0010a2.b, bVar, new AnonymousClass1(c0010a2, c0010a3, a, b, iArr));
                }
            } else if (this.b != null) {
                this.b.onUpdated();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.sapi2.SapiCache$3$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 extends h {
            final /* synthetic */ b.a.C0010a a;
            final /* synthetic */ b.a.C0010a b;
            final /* synthetic */ b c;
            final /* synthetic */ b.a d;
            final /* synthetic */ int[] e;

            AnonymousClass1(b.a.C0010a c0010a, b.a.C0010a c0010a2, b bVar, b.a aVar, int[] iArr) {
                this.a = c0010a;
                this.b = c0010a2;
                this.c = bVar;
                this.d = aVar;
                this.e = iArr;
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.sapi2.SapiCache$3$1$2] */
            @Override // com.baidu.sapi2.a.h
            public void onSuccess(JSONObject jSONObject) {
                this.a.c = b.a.C0010a.C0011a.a(jSONObject);
                if (!SapiCache.a(this.a, this.b)) {
                    d.a(SapiCache.g).a(this.c);
                    SapiCache.a(this.d, this.e, AnonymousClass3.this.a);
                    new AsyncTask<Void, Void, Void>() { // from class: com.baidu.sapi2.SapiCache.3.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public Void doInBackground(Void... voidArr) {
                            SapiCache.a(AnonymousClass1.this.a, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.3.1.2.1
                                @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                                public void onSuccess(b.a.C0010a c0010a, String str) {
                                }

                                @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                                public void onFailure(b.a.C0010a c0010a) {
                                    String a = b.a.C0010a.a(c0010a.a);
                                    String c = b.a.C0010a.c(c0010a.a);
                                    if (new File(SapiCache.g.getFilesDir(), a).exists()) {
                                        try {
                                            SapiCache.a(c, SapiCache.d(SapiCache.g, a).getBytes());
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
                new Thread(new RunnableC00041()).start();
            }

            /* renamed from: com.baidu.sapi2.SapiCache$3$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC00041 implements Runnable {
                RunnableC00041() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SapiCache.a(AnonymousClass1.this.a, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.3.1.1.1
                        @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                        public void onSuccess(b.a.C0010a c0010a, String str) {
                            d.a(SapiCache.g).a(AnonymousClass1.this.c);
                            if (!TextUtils.isEmpty(AnonymousClass1.this.a.a) && !TextUtils.isEmpty(str)) {
                                SapiCache.a(AnonymousClass1.this.a.a, str);
                                SapiCache.a(SapiCache.g, b.a.C0010a.a(AnonymousClass1.this.a.a), str.getBytes());
                            }
                            SapiCache.a(AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass3.this.a);
                        }

                        @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                        public void onFailure(b.a.C0010a c0010a) {
                            final long currentTimeMillis = System.currentTimeMillis();
                            SapiCache.c.a(SapiCache.g, AnonymousClass1.this.a.c.a, new i() { // from class: com.baidu.sapi2.SapiCache.3.1.1.1.1
                                @Override // com.baidu.sapi2.a.i
                                public void onSuccess(String str) {
                                    if (!TextUtils.isEmpty(AnonymousClass1.this.a.a) && !TextUtils.isEmpty(str) && AnonymousClass1.this.a.c.c.equals(com.baidu.sapi2.utils.b.d.a(str))) {
                                        d.a(SapiCache.g).a(AnonymousClass1.this.c);
                                        SapiCache.a(AnonymousClass1.this.a.a, str);
                                        SapiCache.a(SapiCache.g, b.a.C0010a.a(AnonymousClass1.this.a.a), str.getBytes());
                                        SapiCache.a(b.a.C0010a.c(AnonymousClass1.this.a.a), str.getBytes());
                                    }
                                    SapiCache.a(AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass3.this.a);
                                    com.baidu.sapi2.utils.a.a.a().a("cache_" + SapiCache.c(AnonymousClass1.this.a.a) + "_" + String.valueOf(AnonymousClass1.this.b == null ? 0L : AnonymousClass1.this.b.c.b) + "_" + String.valueOf(AnonymousClass1.this.a.c.b), 0L, 0L, System.currentTimeMillis() - currentTimeMillis, 0L, 0L, 0L, 0, 0L);
                                }

                                @Override // com.baidu.sapi2.a.i
                                public void onFailure(Throwable th, String str) {
                                    SapiCache.a(AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass3.this.a);
                                    com.baidu.sapi2.utils.a.a.a().a("cache_" + SapiCache.c(AnonymousClass1.this.a.a) + "_" + String.valueOf(AnonymousClass1.this.b == null ? 0L : AnonymousClass1.this.b.c.b) + "_" + String.valueOf(AnonymousClass1.this.a.c.b), 0L, 0L, System.currentTimeMillis() - currentTimeMillis, 0L, 0L, 0L, 0, 1L);
                                }
                            });
                        }
                    });
                }
            }
        }

        @Override // com.baidu.sapi2.a.h
        public void onFailure(Throwable th, JSONObject jSONObject) {
            if (this.b != null) {
                this.b.onUpdated();
            }
        }
    }

    public static void syncCache() {
        syncCache(null);
    }

    static List<NameValuePair> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl));
        arrayList.add(new BasicNameValuePair("os_type", SocialConstants.ANDROID_CLIENT_TYPE));
        arrayList.add(new BasicNameValuePair("os_version", f.a()));
        arrayList.add(new BasicNameValuePair("brand_name", f.b()));
        arrayList.add(new BasicNameValuePair("brand_mode", f.c()));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_CUID, SapiAccountManager.getInstance().getSapiConfiguration().clientId));
        arrayList.add(new BasicNameValuePair("sapi_version_name", SapiAccountManager.VERSION_NAME));
        arrayList.add(new BasicNameValuePair("sapi_version_code", "11"));
        return arrayList;
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

    static String c(String str) {
        String[] split = str.split("/");
        return split.length > 0 ? split[split.length - 1] : "";
    }

    static boolean a(b.a.C0010a c0010a, b.a.C0010a c0010a2) {
        return c0010a.c.b > 0 && (c0010a2 == null || c0010a.c.b != c0010a2.c.b);
    }

    static String c() {
        return SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigUrl() + com.baidu.sapi2.utils.h.n;
    }

    static void d() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : e) {
            if (!f.contains(str)) {
                arrayList.add(str);
                a(str);
            }
        }
        for (String str2 : arrayList) {
            e.remove(str2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [567=4] */
    static void a(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable th;
        OutputStream outputStream = null;
        try {
            try {
                FileOutputStream openFileOutput = context.openFileOutput(str, 0);
                try {
                    openFileOutput.write(bArr);
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Throwable th2) {
                    fileOutputStream = openFileOutput;
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
            }
        } catch (IOException e4) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [598=4] */
    static void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
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
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
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

    static String d(Context context, String str) {
        FileInputStream openFileInput = context.openFileInput(str);
        try {
            byte[] bArr = new byte[openFileInput.available()];
            openFileInput.read(bArr);
            return new String(bArr);
        } finally {
            openFileInput.close();
        }
    }

    static String e(Context context, String str) {
        InputStream open = context.getAssets().open(str);
        try {
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            return new String(bArr);
        } finally {
            open.close();
        }
    }

    static String e(String str) {
        String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2) && str2.startsWith(b)) {
                return str.replace(a, "<link type=\"text/css\" rel=\"stylesheet\" href=\"" + str2 + "\">");
            }
            return str.replace(a, "");
        }
        return str;
    }
}
