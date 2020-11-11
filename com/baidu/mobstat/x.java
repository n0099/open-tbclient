package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.bt;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.webkit.internal.ETAG;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.jar.JarFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static volatile DexClassLoader f2633a;
    private static volatile boolean b = false;

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        DexClassLoader a2 = a(context);
        if (a2 == null) {
            return null;
        }
        return a2.loadClass(str);
    }

    private static synchronized DexClassLoader a(Context context) {
        DexClassLoader dexClassLoader = null;
        synchronized (x.class) {
            if (f2633a != null) {
                dexClassLoader = f2633a;
            } else {
                File fileStreamPath = context.getFileStreamPath(".remote.jar");
                if (fileStreamPath == null || fileStreamPath.isFile()) {
                    if (!b(context, fileStreamPath.getAbsolutePath())) {
                        bb.c().a("remote jar version lower than min limit, need delete");
                        if (fileStreamPath.isFile()) {
                            fileStreamPath.delete();
                        }
                    } else if (!c(context, fileStreamPath.getAbsolutePath())) {
                        bb.c().a("remote jar md5 is not right, need delete");
                        if (fileStreamPath.isFile()) {
                            fileStreamPath.delete();
                        }
                    } else {
                        try {
                            f2633a = new DexClassLoader(fileStreamPath.getAbsolutePath(), context.getDir("outdex", 0).getAbsolutePath(), null, context.getClassLoader());
                        } catch (Exception e) {
                            bb.c().a(e);
                        }
                        dexClassLoader = f2633a;
                    }
                }
            }
        }
        return dexClassLoader;
    }

    private static boolean b(Context context, String str) {
        int i;
        String b2 = b(str);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        try {
            i = Integer.valueOf(b2).intValue();
        } catch (Exception e) {
            bb.c().b(e);
            i = 0;
        }
        return i >= 4;
    }

    public static synchronized void a(Context context, com.baidu.mobstat.a aVar) {
        synchronized (x.class) {
            if (!b) {
                if (!bw.q(context)) {
                    bb.c().a("isWifiAvailable = false, will not to update");
                } else if (!aVar.a(context)) {
                    bb.c().a("check time, will not to update");
                } else {
                    bb.c().a("can start update config");
                    new a(context, aVar).start();
                    b = true;
                }
            }
        }
    }

    private static boolean c(Context context, String str) {
        String a2 = bt.b.a(new File(str));
        bb.c().a("remote.jar local file digest value digest = " + a2);
        if (TextUtils.isEmpty(a2)) {
            bb.c().a("remote.jar local file digest value fail");
            return false;
        }
        String b2 = b(str);
        bb.c().a("remote.jar local file digest value version = " + b2);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        String d = d(context, b2);
        bb.c().a("remote.jar config digest value remoteJarMd5 = " + d);
        if (TextUtils.isEmpty(d)) {
            bb.c().a("remote.jar config digest value lost");
            return false;
        }
        return a2.equals(d);
    }

    private static String d(Context context, String str) {
        return y.a(context).c(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    bb.c().b("file size: " + file.length());
                }
                jarFile = new JarFile(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            String value = jarFile.getManifest().getMainAttributes().getValue("Plugin-Version");
            if (jarFile != null) {
                try {
                    jarFile.close();
                    return value;
                } catch (Exception e2) {
                    return value;
                }
            }
            return value;
        } catch (Exception e3) {
            e = e3;
            jarFile2 = jarFile;
            bb.c().a(e);
            bb.c().a("baidu remote sdk is not ready" + str);
            if (jarFile2 != null) {
                try {
                    jarFile2.close();
                } catch (Exception e4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            jarFile2 = jarFile;
            if (jarFile2 != null) {
                try {
                    jarFile2.close();
                } catch (Exception e5) {
                }
            }
            throw th;
        }
    }

    /* loaded from: classes17.dex */
    static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Context f2634a;
        private com.baidu.mobstat.a b;

        public a(Context context, com.baidu.mobstat.a aVar) {
            this.f2634a = context;
            this.b = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                int i = aa.f2517a ? 3 : 10;
                bb.c().a("start version check in " + i + "s");
                sleep(i * 1000);
                a();
                a(this.f2634a);
            } catch (Exception e) {
                bb.c().a(e);
            }
            boolean unused = x.b = false;
        }

        private void a(Context context) {
            this.b.a(context, System.currentTimeMillis());
        }

        private synchronized void a() throws Exception {
            FileOutputStream fileOutputStream = null;
            synchronized (this) {
                bb.c().a("start get config and download jar");
                Context context = this.f2634a;
                com.baidu.mobstat.a aVar = this.b;
                String b = b(context);
                bb.c().c("update req url is:" + b);
                HttpURLConnection d = bo.d(context, b);
                d.connect();
                String headerField = d.getHeaderField("X-CONFIG");
                bb.c().a("config is: " + headerField);
                String headerField2 = d.getHeaderField("X-SIGN");
                bb.c().a("sign is: " + headerField2);
                int responseCode = d.getResponseCode();
                bb.c().a("update response code is: " + responseCode);
                int contentLength = d.getContentLength();
                bb.c().a("update response content length is: " + contentLength);
                if (responseCode == 200 && contentLength > 0) {
                    try {
                        fileOutputStream = context.openFileOutput(".remote.jar", 0);
                        if (bu.a(d.getInputStream(), fileOutputStream)) {
                            bb.c().a("save remote jar success");
                        }
                        bu.a(fileOutputStream);
                    } catch (IOException e) {
                        bb.c().b(e);
                        bu.a(fileOutputStream);
                    }
                }
                DexClassLoader unused = x.f2633a = null;
                u.a();
                if (!TextUtils.isEmpty(headerField)) {
                    aVar.a(context, headerField);
                }
                if (!TextUtils.isEmpty(headerField2)) {
                    aVar.b(context, headerField2);
                }
                d.disconnect();
                bb.c().a("finish get config and download jar");
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private String b(Context context) {
            String str;
            File fileStreamPath;
            File fileStreamPath2 = context.getFileStreamPath(".remote.jar");
            if (fileStreamPath2 != null && fileStreamPath2.exists() && (fileStreamPath = context.getFileStreamPath(".remote.jar")) != null) {
                str = x.b(fileStreamPath.getAbsolutePath());
                bb.c().a("startDownload remote jar file version = " + str);
            }
            str = SoUtils.SO_EVENT_ID_DEFAULT;
            ArrayList<Pair> arrayList = new ArrayList();
            arrayList.add(new Pair("dynamicVersion", "" + str));
            arrayList.add(new Pair("packageName", bw.t(context)));
            arrayList.add(new Pair("appVersion", bw.g(context)));
            arrayList.add(new Pair("cuid", bw.a(context)));
            arrayList.add(new Pair("platform", "Android"));
            arrayList.add(new Pair("m", android.os.Build.MODEL));
            arrayList.add(new Pair("s", Build.VERSION.SDK_INT + ""));
            arrayList.add(new Pair(Config.OS, Build.VERSION.RELEASE));
            arrayList.add(new Pair("i", SoUtils.SO_EVENT_ID_DEFAULT));
            StringBuilder sb = new StringBuilder();
            for (Pair pair : arrayList) {
                try {
                    String encode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                    String encode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(encode + ETAG.EQUAL + encode2);
                    } else {
                        sb.append(ETAG.ITEM_SEPARATOR + encode + ETAG.EQUAL + encode2);
                    }
                } catch (Exception e) {
                }
            }
            return aa.c + "?" + sb.toString();
        }
    }
}
