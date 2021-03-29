package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.bt;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.swan.games.utils.so.SoUtils;
import com.tencent.connect.common.Constants;
import dalvik.system.DexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.jar.JarFile;
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static volatile DexClassLoader f9264a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f9265b = false;

    /* loaded from: classes2.dex */
    public static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public Context f9266a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobstat.a f9267b;

        public a(Context context, com.baidu.mobstat.a aVar) {
            this.f9266a = context;
            this.f9267b = aVar;
        }

        private void a(Context context) {
            this.f9267b.a(context, System.currentTimeMillis());
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
            if (android.text.TextUtils.isEmpty(r1) == false) goto L9;
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
                bb c2 = bb.c();
                c2.a("startDownload remote jar file version = " + str);
            }
            str = SoUtils.SO_EVENT_ID_DEFAULT;
            ArrayList<Pair> arrayList = new ArrayList();
            arrayList.add(new Pair("dynamicVersion", "" + str));
            arrayList.add(new Pair(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, bw.t(context)));
            arrayList.add(new Pair("appVersion", bw.g(context)));
            arrayList.add(new Pair("cuid", bw.a(context)));
            arrayList.add(new Pair(Constants.PARAM_PLATFORM, "Android"));
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
                        sb.append(encode + "=" + encode2);
                    } else {
                        sb.append("&" + encode + "=" + encode2);
                    }
                } catch (Exception unused) {
                }
            }
            return aa.f8874c + "?" + sb.toString();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                int i = aa.f8872a ? 3 : 10;
                bb c2 = bb.c();
                c2.a("start version check in " + i + "s");
                Thread.sleep((long) (i * 1000));
                a();
                a(this.f9266a);
            } catch (Exception e2) {
                bb.c().a(e2);
            }
            boolean unused = x.f9265b = false;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x00cd */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00ad */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00ed A[Catch: all -> 0x0107, TryCatch #4 {, blocks: (B:3:0x0001, B:32:0x00f9, B:4:0x002f, B:12:0x00c9, B:24:0x00dd, B:25:0x00e0, B:26:0x00e1, B:28:0x00ed, B:29:0x00f0, B:31:0x00f6), top: B:45:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00f6 A[Catch: all -> 0x0107, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:32:0x00f9, B:4:0x002f, B:12:0x00c9, B:24:0x00dd, B:25:0x00e0, B:26:0x00e1, B:28:0x00ed, B:29:0x00f0, B:31:0x00f6), top: B:45:0x0001 }] */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v4, types: [int] */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.StringBuilder] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private synchronized void a() throws Exception {
            FileOutputStream fileOutputStream;
            bb.c().a("start get config and download jar");
            Context context = this.f9266a;
            com.baidu.mobstat.a aVar = this.f9267b;
            String b2 = b(context);
            bb.c().c("update req url is:" + b2);
            HttpURLConnection d2 = bo.d(context, b2);
            d2.connect();
            String headerField = d2.getHeaderField("X-CONFIG");
            bb.c().a("config is: " + headerField);
            String headerField2 = d2.getHeaderField("X-SIGN");
            bb.c().a("sign is: " + headerField2);
            ?? responseCode = d2.getResponseCode();
            bb.c().a("update response code is: " + responseCode);
            int contentLength = d2.getContentLength();
            bb.c().a("update response content length is: " + contentLength);
            Closeable closeable = null;
            if (responseCode == 200) {
                try {
                    if (contentLength > 0) {
                        try {
                            fileOutputStream = context.openFileOutput(".remote.jar", 0);
                            try {
                                boolean a2 = bu.a(d2.getInputStream(), fileOutputStream);
                                responseCode = fileOutputStream;
                                if (a2) {
                                    bb.c().a("save remote jar success");
                                    responseCode = fileOutputStream;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                bb.c().b(e);
                                responseCode = fileOutputStream;
                                bu.a(responseCode);
                                DexClassLoader unused = x.f9264a = null;
                                u.a();
                                if (!TextUtils.isEmpty(headerField)) {
                                }
                                if (!TextUtils.isEmpty(headerField2)) {
                                }
                                d2.disconnect();
                                bb.c().a("finish get config and download jar");
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            bu.a(closeable);
                            throw th;
                        }
                        bu.a(responseCode);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable = responseCode;
                }
            }
            DexClassLoader unused2 = x.f9264a = null;
            u.a();
            if (!TextUtils.isEmpty(headerField)) {
                aVar.a(context, headerField);
            }
            if (!TextUtils.isEmpty(headerField2)) {
                aVar.b(context, headerField2);
            }
            d2.disconnect();
            bb.c().a("finish get config and download jar");
        }
    }

    public static boolean b(Context context, String str) {
        int i;
        String b2 = b(str);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        try {
            i = Integer.valueOf(b2).intValue();
        } catch (Exception e2) {
            bb.c().b(e2);
            i = 0;
        }
        return i >= 4;
    }

    public static boolean c(Context context, String str) {
        String a2 = bt.b.a(new File(str));
        bb c2 = bb.c();
        c2.a("remote.jar local file digest value digest = " + a2);
        if (TextUtils.isEmpty(a2)) {
            bb.c().a("remote.jar local file digest value fail");
            return false;
        }
        String b2 = b(str);
        bb c3 = bb.c();
        c3.a("remote.jar local file digest value version = " + b2);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        String d2 = d(context, b2);
        bb c4 = bb.c();
        c4.a("remote.jar config digest value remoteJarMd5 = " + d2);
        if (TextUtils.isEmpty(d2)) {
            bb.c().a("remote.jar config digest value lost");
            return false;
        }
        return a2.equals(d2);
    }

    public static String d(Context context, String str) {
        return y.a(context).c(str);
    }

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        DexClassLoader a2 = a(context);
        if (a2 == null) {
            return null;
        }
        return a2.loadClass(str);
    }

    public static String b(String str) {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    bb c2 = bb.c();
                    c2.b("file size: " + file.length());
                }
                jarFile = new JarFile(str);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String value = jarFile.getManifest().getMainAttributes().getValue("Plugin-Version");
            try {
                jarFile.close();
            } catch (Exception unused) {
            }
            return value;
        } catch (Exception e3) {
            e = e3;
            jarFile2 = jarFile;
            bb.c().a(e);
            bb c3 = bb.c();
            c3.a("baidu remote sdk is not ready" + str);
            if (jarFile2 != null) {
                try {
                    jarFile2.close();
                    return "";
                } catch (Exception unused2) {
                    return "";
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            jarFile2 = jarFile;
            if (jarFile2 != null) {
                try {
                    jarFile2.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    public static synchronized DexClassLoader a(Context context) {
        synchronized (x.class) {
            if (f9264a != null) {
                return f9264a;
            }
            File fileStreamPath = context.getFileStreamPath(".remote.jar");
            if (fileStreamPath == null || fileStreamPath.isFile()) {
                if (!b(context, fileStreamPath.getAbsolutePath())) {
                    bb.c().a("remote jar version lower than min limit, need delete");
                    if (fileStreamPath.isFile()) {
                        fileStreamPath.delete();
                    }
                    return null;
                } else if (!c(context, fileStreamPath.getAbsolutePath())) {
                    bb.c().a("remote jar md5 is not right, need delete");
                    if (fileStreamPath.isFile()) {
                        fileStreamPath.delete();
                    }
                    return null;
                } else {
                    try {
                        f9264a = new DexClassLoader(fileStreamPath.getAbsolutePath(), context.getDir("outdex", 0).getAbsolutePath(), null, context.getClassLoader());
                    } catch (Exception e2) {
                        bb.c().a(e2);
                    }
                    return f9264a;
                }
            }
            return null;
        }
    }

    public static synchronized void a(Context context, com.baidu.mobstat.a aVar) {
        synchronized (x.class) {
            if (f9265b) {
                return;
            }
            if (!bw.q(context)) {
                bb.c().a("isWifiAvailable = false, will not to update");
            } else if (!aVar.a(context)) {
                bb.c().a("check time, will not to update");
            } else {
                bb.c().a("can start update config");
                new a(context, aVar).start();
                f9265b = true;
            }
        }
    }
}
