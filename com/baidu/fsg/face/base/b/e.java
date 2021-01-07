package com.baidu.fsg.face.base.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.security.MD5Util;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.downloadmanager.ApollonDownloadManager;
import com.baidu.fsg.base.downloadmanager.DownloadItemInfo;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.b.c;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.base.d.k;
import com.baidu.fsg.face.base.d.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f2118a = "UpdateSo";

    /* renamed from: b  reason: collision with root package name */
    protected Context f2119b;
    private b c;
    private CountDownLatch d;
    private c e;
    private c f;
    private b.a g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void a(c.a aVar);

        void a(c.a aVar, byte[] bArr);
    }

    public void a(Context context, int i) {
        this.f2119b = context;
        this.g = com.baidu.fsg.face.base.b.b.a(i);
        if ("UpdateSo".equals(f2118a)) {
            f2118a = "UpdateSo-" + this.g.f2112a;
        }
        this.c = new b();
        this.d = new CountDownLatch(1);
        l.a().c(new k(new Runnable() { // from class: com.baidu.fsg.face.base.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                String rimSoDownLoad = BdWalletUtils.getRimSoDownLoad(e.this.f2119b);
                if (!TextUtils.isEmpty(rimSoDownLoad)) {
                    e.this.a(rimSoDownLoad);
                }
                try {
                    e.this.d.await();
                    com.baidu.fsg.face.base.d.d.b(e.f2118a, "begin stat service");
                    e.this.c.b();
                } catch (InterruptedException e) {
                    com.baidu.fsg.face.base.d.d.d(e.f2118a, e);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        l.a().c(new k(new Runnable() { // from class: com.baidu.fsg.face.base.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.e = c.a(new JSONObject(str), e.this.g);
                    e.this.f = com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a);
                    if (!TextUtils.isEmpty(e.this.f.n)) {
                        e.this.g.f2113b = e.this.g.f2113b.compareTo(e.this.f.n) < 0 ? e.this.f.n : e.this.g.f2113b;
                    }
                    com.baidu.fsg.face.base.d.d.d(e.f2118a, "asyncDistributeConf() newOptions:" + e.this.e.a());
                    com.baidu.fsg.face.base.d.d.d(e.f2118a, "asyncDistributeConf() oldOptions:" + e.this.f.a());
                    e.this.f.q = e.this.e.q;
                    e.this.f.r = e.this.e.r;
                    com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                    e.this.c.l = true;
                    e.this.c.k = e.this.e.n;
                    if (!e.this.e.q || !e.this.e.r) {
                        e.this.c.r = false;
                        e.this.c.n = false;
                        e.this.d.countDown();
                        e.this.f.p = true;
                        com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                        return;
                    }
                    e.this.c.r = true;
                    e.this.a(e.this.f);
                    int i = e.this.e.s;
                    e.this.e.s = e.this.f.s;
                    if (!e.this.a(i, e.this.f)) {
                        e.this.c.o = false;
                        e.this.c.n = false;
                        e.this.d.countDown();
                        e.this.f.p = true;
                        com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                        return;
                    }
                    e.this.c.o = true;
                    if (e.this.g.f2113b.compareTo(e.this.e.n) < 0) {
                        if (e.this.a(e.this.e.o, e.this.f.o)) {
                            e.this.g.f2113b = e.this.e.n;
                            e.this.b(e.this.e);
                            e.this.c.n = true;
                            return;
                        }
                        e.this.a(e.this.e.o);
                        e.this.c.n = false;
                        e.this.d.countDown();
                        return;
                    }
                    e.this.c.n = false;
                    e.this.d.countDown();
                    e.this.f.p = true;
                    com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                } catch (JSONException e) {
                    com.baidu.fsg.face.base.d.d.d(e.f2118a, e);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar.o == null) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            cVar.s = random.nextInt(100);
            com.baidu.fsg.face.base.b.b.a(this.f2119b).a(this.f2119b, this.g.f2112a, cVar);
        }
        com.baidu.fsg.face.base.d.d.b(f2118a, "current gray = " + cVar.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, c cVar) {
        return 100 == this.e.s || cVar.s < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final c cVar) {
        a(cVar.o, new a() { // from class: com.baidu.fsg.face.base.b.e.3
            @Override // com.baidu.fsg.face.base.b.e.a
            public void a(c.a aVar, byte[] bArr) {
                boolean a2 = e.this.a(e.this.f2119b, com.baidu.fsg.face.base.b.b.c(e.this.f2119b, e.this.g), bArr);
                if (!a2) {
                    e.this.c(cVar);
                } else {
                    e.this.c.p = false;
                    e.this.a(com.baidu.fsg.face.base.b.b.c(e.this.f2119b, e.this.g), com.baidu.fsg.face.base.b.b.a(e.this.f2119b, e.this.g));
                    cVar.p = false;
                    com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, cVar);
                }
                com.baidu.fsg.face.base.d.d.d(e.f2118a, "loadFileFromExternal writeFileSuccess:" + a2);
            }

            @Override // com.baidu.fsg.face.base.b.e.a
            public void a(c.a aVar) {
                e.this.c(cVar);
            }
        }, com.baidu.fsg.face.base.b.b.a(this.g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(c cVar) {
        this.c.p = true;
        String[] strArr = {"application/octet-stream", "*/*", "application/apk", "application/vnd.android.package-archive", "application/zip"};
        com.baidu.fsg.face.base.d.d.d(f2118a, "loadFileFromExternal onFailure distributedSdk uri:" + cVar.o.f2117b);
        final String str = System.currentTimeMillis() + "";
        final long doDownload = ApollonDownloadManager.getInstance(this.f2119b).doDownload(Environment.DIRECTORY_DOWNLOADS, str + "", cVar.o.f2117b, false, false, false, ".zip");
        LogUtil.i(f2118a, "start load engineso file");
        final boolean[] zArr = {false};
        if (doDownload != -1) {
            ApollonDownloadManager.getInstance(this.f2119b).registerObserver(this.f2119b, doDownload, new ApollonDownloadManager.DownloadListener() { // from class: com.baidu.fsg.face.base.b.e.4
                /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [313=4] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x021d  */
                /* JADX WARN: Removed duplicated region for block: B:45:0x022b  */
                /* JADX WARN: Removed duplicated region for block: B:55:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onChanged(DownloadItemInfo downloadItemInfo) {
                    FileInputStream fileInputStream;
                    File file;
                    if (downloadItemInfo.getDownloadState() != 8) {
                        return;
                    }
                    ApollonDownloadManager.getInstance(e.this.f2119b).unregisterObserver(e.this.f2119b, doDownload, this);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        fileInputStream = new FileInputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str + ".zip");
                        try {
                            try {
                                byte[] bArr = new byte[com.baidu.fsg.base.statistics.b.c];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                e.this.a(byteArrayOutputStream.toByteArray());
                                File file2 = new File(str);
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (zArr[0]) {
                                    return;
                                }
                                com.baidu.fsg.face.base.d.d.d(e.f2118a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                e.this.f.p = true;
                                com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                                e.this.c.m = false;
                                e.this.c.q = "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState();
                                e.this.d.countDown();
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                com.baidu.fsg.face.base.d.d.d(e.f2118a, "distributeFileDownload() onFailure" + e.toString());
                                e.this.f.p = true;
                                com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                                e.this.c.m = false;
                                e.this.c.q = Log.getStackTraceString(e);
                                e.this.d.countDown();
                                File file3 = new File(str);
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (zArr[0]) {
                                    return;
                                }
                                com.baidu.fsg.face.base.d.d.d(e.f2118a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                e.this.f.p = true;
                                com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                                e.this.c.m = false;
                                e.this.c.q = "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState();
                                e.this.d.countDown();
                            }
                        } catch (Throwable th) {
                            th = th;
                            file = new File(str);
                            if (file.exists()) {
                                file.delete();
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (!zArr[0]) {
                                com.baidu.fsg.face.base.d.d.d(e.f2118a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                e.this.f.p = true;
                                com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                                e.this.c.m = false;
                                e.this.c.q = "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState();
                                e.this.d.countDown();
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        file = new File(str);
                        if (file.exists()) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (!zArr[0]) {
                        }
                        throw th;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final byte[] bArr) {
        l.a().c(new k(new Runnable() { // from class: com.baidu.fsg.face.base.b.e.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.fsg.face.base.d.d.d(e.f2118a, "distributeFileDownload() onSuccess" + e.this.e.o.f2117b + ",:" + com.baidu.fsg.face.base.b.b.c(e.this.f2119b, e.this.g));
                    String md5 = MD5Util.toMd5(bArr, false);
                    String localDecryptProxy = RimArmor.getInstance().localDecryptProxy(e.this.e.o.c);
                    if (localDecryptProxy == null || !localDecryptProxy.equals(md5)) {
                        e.this.f.p = true;
                        com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                        e.this.c.m = false;
                        e.this.c.q = "localMd5 is not equals onlineMd5";
                        e.this.d.countDown();
                        return;
                    }
                    if (e.this.a(e.this.f2119b, com.baidu.fsg.face.base.b.b.c(e.this.f2119b, e.this.g), bArr)) {
                        e.this.a(com.baidu.fsg.face.base.b.b.c(e.this.f2119b, e.this.g), com.baidu.fsg.face.base.b.b.a(e.this.f2119b, e.this.g));
                        e.this.e.p = false;
                        com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.e);
                    } else {
                        e.this.f.p = true;
                        com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                        e.this.c.m = false;
                        e.this.c.q = "zip file write internal fail";
                        e.this.d.countDown();
                    }
                    if (e.a("android.permission.WRITE_EXTERNAL_STORAGE", e.this.f2119b)) {
                        String a2 = com.baidu.fsg.face.base.b.b.a(e.this.g);
                        if (g.a(a2)) {
                            g.b(a2);
                        }
                        e.this.a(a2, bArr);
                    }
                } catch (Exception e) {
                    com.baidu.fsg.face.base.d.d.d(e.f2118a, "distributeFileDownload() Exception " + e.toString());
                    e.this.f.p = true;
                    com.baidu.fsg.face.base.b.b.a(e.this.f2119b).a(e.this.f2119b, e.this.g.f2112a, e.this.f);
                    e.this.c.m = false;
                    e.this.c.q = Log.getStackTraceString(e);
                    e.this.d.countDown();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        a(aVar, new a() { // from class: com.baidu.fsg.face.base.b.e.6
            @Override // com.baidu.fsg.face.base.b.e.a
            public void a(c.a aVar2, byte[] bArr) {
                com.baidu.fsg.face.base.d.d.d(e.f2118a, "copyInternalFileToExternal(), loadFileFromExternal distributed success");
            }

            @Override // com.baidu.fsg.face.base.b.e.a
            public void a(c.a aVar2) {
                String c = com.baidu.fsg.face.base.b.b.c(e.this.f2119b, e.this.g);
                String a2 = com.baidu.fsg.face.base.b.b.a(e.this.g);
                com.baidu.fsg.face.base.d.d.d(e.f2118a, "asyncDistributeConf(), loadFileFromExternal failure internalFile:" + c);
                if (g.a(c)) {
                    byte[] b2 = e.this.b(c);
                    if (e.a("android.permission.WRITE_EXTERNAL_STORAGE", e.this.f2119b)) {
                        if (g.a(a2)) {
                            g.b(a2);
                        }
                        e.this.a(a2, b2);
                    }
                }
            }
        }, com.baidu.fsg.face.base.b.b.a(this.g));
    }

    private void a(c.a aVar, a aVar2, String str) {
        if (aVar2 == null) {
            throw new IllegalArgumentException(a.class.getName() + "can't be null");
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), str).exists()) {
                byte[] c = c(str);
                String md5 = MD5Util.toMd5(c, false);
                String localDecryptProxy = RimArmor.getInstance().localDecryptProxy(aVar.c);
                if (localDecryptProxy != null && localDecryptProxy.equals(md5)) {
                    aVar2.a(aVar, c);
                } else {
                    aVar2.a(aVar);
                }
            } else {
                aVar2.a(aVar);
            }
        } catch (Throwable th) {
            com.baidu.fsg.face.base.d.d.d(f2118a, "loadFileFromExternal() Throwable" + th.toString());
            aVar2.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] b(String str) {
        try {
            return a(new FileInputStream(new File(str)));
        } catch (IOException e) {
            com.baidu.fsg.face.base.d.d.d(f2118a, e);
            return null;
        }
    }

    private byte[] c(String str) throws IOException {
        return a(new FileInputStream(new File(Environment.getExternalStorageDirectory(), str)));
    }

    private byte[] a(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, byte[] bArr) {
        if (g.a(str)) {
            g.b(str);
        }
        File file = new File(str);
        try {
            return g.b(file) && g.a(file, bArr);
        } catch (IOException e) {
            com.baidu.fsg.face.base.d.d.d(f2118a, e);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [549=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr) {
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
                        com.baidu.fsg.face.base.d.d.d(f2118a, th);
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (Throwable th2) {
                                com.baidu.fsg.face.base.d.d.d(f2118a, th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th4) {
                                com.baidu.fsg.face.base.d.d.d(f2118a, th4);
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
                    com.baidu.fsg.face.base.d.d.d(f2118a, th5);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @TargetApi(23)
    public static boolean a(String str, Context context) {
        if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
            return Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c.a aVar, c.a aVar2) {
        return aVar2 == null || aVar == null || TextUtils.isEmpty(aVar2.c) || !aVar.c.equals(aVar2.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [647=5, 648=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        String name;
        ZipInputStream zipInputStream = null;
        this.c.m = true;
        this.d.countDown();
        com.baidu.fsg.face.base.d.d.b(f2118a, "thread name unZipApkSoToLibDir = " + Thread.currentThread().getName());
        com.baidu.fsg.face.base.d.d.a(f2118a, "unZipApkSoToLibDir(), zipFilePath:" + str + ",libDir:" + str2);
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                BufferedOutputStream bufferedOutputStream2 = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        try {
                            bArr = new byte[4096];
                            name = nextEntry.getName();
                            com.baidu.fsg.face.base.d.d.d(f2118a, "unZipApkSoToLibDir() entryName," + name);
                        } catch (Exception e) {
                            e = e;
                            bufferedOutputStream = bufferedOutputStream2;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (name.endsWith(PluginInstallerService.APK_LIB_SUFFIX)) {
                            String str3 = name.substring(name.lastIndexOf("/") + 1, name.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) + PluginInstallerService.APK_LIB_SUFFIX;
                            com.baidu.fsg.face.base.d.d.a(f2118a, "unZipApkSoToLibDir(),fileName2:" + str3);
                            File file = new File(str2 + File.separator + str3);
                            if (file.exists()) {
                                file.delete();
                            }
                            File file2 = new File(file.getParent());
                            com.baidu.fsg.face.base.d.d.a(f2118a, "unZipApkSoToLibDir()entryFile" + file.toString() + "entryDir" + file2.toString());
                            if (!file2.exists()) {
                                com.baidu.fsg.face.base.d.d.a(f2118a, "unZipApkSoToLibDir() not exists");
                                file2.mkdirs();
                            }
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                            while (true) {
                                try {
                                    try {
                                        int read = zipInputStream2.read(bArr, 0, 4096);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        bufferedOutputStream2 = bufferedOutputStream;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    if (bufferedOutputStream2 != null) {
                                        bufferedOutputStream2.close();
                                    }
                                    throw th;
                                }
                            }
                            bufferedOutputStream.flush();
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            bufferedOutputStream2 = bufferedOutputStream;
                        } else if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        zipInputStream = zipInputStream2;
                        com.baidu.fsg.face.base.d.d.d(f2118a, e);
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                                return;
                            } catch (IOException e4) {
                                com.baidu.fsg.face.base.d.d.d(f2118a, e4);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        zipInputStream = zipInputStream2;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (IOException e5) {
                                com.baidu.fsg.face.base.d.d.d(f2118a, e5);
                            }
                        }
                        throw th;
                    }
                }
                if (zipInputStream2 != null) {
                    try {
                        zipInputStream2.close();
                    } catch (IOException e6) {
                        com.baidu.fsg.face.base.d.d.d(f2118a, e6);
                    }
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public static final String f2130a = "dl_so_zip_version";
        private static final String c = "dl_so_modle_name";
        private static final String d = "dl_so_get_config_success";
        private static final String e = "dl_so_zip_file_success";
        private static final String f = "dl_so_need_update";
        private static final String g = "dl_so_update_from_net";
        private static final String h = "dl_so_exception_info";
        private static final String i = "dl_so_meet_gray";
        private static final String j = "dl_so_zip_enable";
        private String k;
        private boolean l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        private String q;
        private boolean r;

        private b() {
        }

        private Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put(c, e.this.g.f2112a);
            hashMap.put(f2130a, this.k);
            hashMap.put(d, this.l ? "1" : "-1");
            if (this.l) {
                hashMap.put(j, this.r ? "1" : "-1");
                hashMap.put(f, this.n ? "1" : "-1");
            }
            if (this.r) {
                hashMap.put(i, this.o ? "1" : "-1");
            }
            if (this.n) {
                hashMap.put(g, this.p ? "1" : "-1");
                hashMap.put(e, this.m ? "1" : "-1");
            }
            hashMap.put(h, this.q);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            for (Map.Entry<String, String> entry : a().entrySet()) {
                RimStatisticsUtil.onEventWithValue(entry.getKey(), entry.getValue());
            }
            RimStatisticsUtil.getInstance().triggerSending();
        }
    }
}
