package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.bz;
import com.tencent.connect.common.Constants;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.jar.JarFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ae {
    private static volatile DexClassLoader a;
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
        synchronized (ae.class) {
            if (a != null) {
                dexClassLoader = a;
            } else {
                File fileStreamPath = context.getFileStreamPath(".remote.jar");
                if (fileStreamPath == null || fileStreamPath.isFile()) {
                    if (!b(context, fileStreamPath.getAbsolutePath())) {
                        bi.c().a("remote jar version lower than min limit, need delete");
                        if (fileStreamPath.isFile()) {
                            fileStreamPath.delete();
                        }
                    } else if (!c(context, fileStreamPath.getAbsolutePath())) {
                        bi.c().a("remote jar md5 is not right, need delete");
                        if (fileStreamPath.isFile()) {
                            fileStreamPath.delete();
                        }
                    } else {
                        try {
                            a = new DexClassLoader(fileStreamPath.getAbsolutePath(), context.getDir("outdex", 0).getAbsolutePath(), null, context.getClassLoader());
                        } catch (Exception e) {
                            bi.c().a(e);
                        }
                        dexClassLoader = a;
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
            bi.c().b(e);
            i = 0;
        }
        return i >= 4;
    }

    public static synchronized void a(Context context, h hVar) {
        synchronized (ae.class) {
            if (!b) {
                if (!cc.q(context)) {
                    bi.c().a("isWifiAvailable = false, will not to update");
                } else if (!hVar.a(context)) {
                    bi.c().a("check time, will not to update");
                } else {
                    bi.c().a("can start update config");
                    new a(context, hVar).start();
                    b = true;
                }
            }
        }
    }

    private static boolean c(Context context, String str) {
        String a2 = bz.b.a(new File(str));
        bi.c().a("remote.jar local file digest value digest = " + a2);
        if (TextUtils.isEmpty(a2)) {
            bi.c().a("remote.jar local file digest value fail");
            return false;
        }
        String b2 = b(str);
        bi.c().a("remote.jar local file digest value version = " + b2);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        String d = d(context, b2);
        bi.c().a("remote.jar config digest value remoteJarMd5 = " + d);
        if (TextUtils.isEmpty(d)) {
            bi.c().a("remote.jar config digest value lost");
            return false;
        }
        return a2.equals(d);
    }

    private static String d(Context context, String str) {
        return af.a(context).c(str);
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
                    bi.c().b("file size: " + file.length());
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
            bi.c().a(e);
            bi.c().a("baidu remote sdk is not ready" + str);
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

    /* loaded from: classes3.dex */
    static class a extends Thread {
        private Context a;
        private h b;

        public a(Context context, h hVar) {
            this.a = context;
            this.b = hVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                int i = ah.a ? 3 : 10;
                bi.c().a("start version check in " + i + "s");
                sleep(i * 1000);
                a();
                a(this.a);
            } catch (Exception e) {
                bi.c().a(e);
            }
            boolean unused = ae.b = false;
        }

        private void a(Context context) {
            this.b.a(context, System.currentTimeMillis());
        }

        private synchronized void a() throws Exception {
            FileOutputStream fileOutputStream = null;
            synchronized (this) {
                bi.c().a("start get config and download jar");
                Context context = this.a;
                h hVar = this.b;
                String b = b(context);
                bi.c().c("update req url is:" + b);
                HttpURLConnection d = bv.d(context, b);
                d.connect();
                String headerField = d.getHeaderField("X-CONFIG");
                bi.c().a("config is: " + headerField);
                String headerField2 = d.getHeaderField("X-SIGN");
                bi.c().a("sign is: " + headerField2);
                int responseCode = d.getResponseCode();
                bi.c().a("update response code is: " + responseCode);
                int contentLength = d.getContentLength();
                bi.c().a("update response content length is: " + contentLength);
                if (responseCode == 200 && contentLength > 0) {
                    try {
                        fileOutputStream = context.openFileOutput(".remote.jar", 0);
                        if (ca.a(d.getInputStream(), fileOutputStream)) {
                            bi.c().a("save remote jar success");
                        }
                        ca.a(fileOutputStream);
                    } catch (IOException e) {
                        bi.c().b(e);
                        ca.a(fileOutputStream);
                    }
                }
                DexClassLoader unused = ae.a = null;
                ab.a();
                if (!TextUtils.isEmpty(headerField)) {
                    hVar.a(context, headerField);
                }
                if (!TextUtils.isEmpty(headerField2)) {
                    hVar.b(context, headerField2);
                }
                d.disconnect();
                bi.c().a("finish get config and download jar");
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
                str = ae.b(fileStreamPath.getAbsolutePath());
                bi.c().a("startDownload remote jar file version = " + str);
            }
            str = Constants.VIA_REPORT_TYPE_START_WAP;
            ArrayList<Pair> arrayList = new ArrayList();
            arrayList.add(new Pair("dynamicVersion", "" + str));
            arrayList.add(new Pair("packageName", cc.t(context)));
            arrayList.add(new Pair("appVersion", cc.g(context)));
            arrayList.add(new Pair("cuid", cc.a(context)));
            arrayList.add(new Pair("platform", "Android"));
            arrayList.add(new Pair(Config.MODEL, android.os.Build.MODEL));
            arrayList.add(new Pair("s", Build.VERSION.SDK_INT + ""));
            arrayList.add(new Pair(Config.OS, Build.VERSION.RELEASE));
            arrayList.add(new Pair("i", Constants.VIA_REPORT_TYPE_START_WAP));
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
                } catch (Exception e) {
                }
            }
            return ah.c + "?" + sb.toString();
        }
    }
}
