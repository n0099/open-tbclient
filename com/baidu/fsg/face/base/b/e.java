package com.baidu.fsg.face.base.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
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
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f5506a = "UpdateSo";

    /* renamed from: b  reason: collision with root package name */
    public Context f5507b;

    /* renamed from: c  reason: collision with root package name */
    public b f5508c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f5509d;

    /* renamed from: e  reason: collision with root package name */
    public c f5510e;

    /* renamed from: f  reason: collision with root package name */
    public c f5511f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f5512g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(c.a aVar);

        void a(c.a aVar, byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public static final String f5525a = "dl_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f5526c = "dl_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f5527d = "dl_so_get_config_success";

        /* renamed from: e  reason: collision with root package name */
        public static final String f5528e = "dl_so_zip_file_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f5529f = "dl_so_need_update";

        /* renamed from: g  reason: collision with root package name */
        public static final String f5530g = "dl_so_update_from_net";

        /* renamed from: h  reason: collision with root package name */
        public static final String f5531h = "dl_so_exception_info";

        /* renamed from: i  reason: collision with root package name */
        public static final String f5532i = "dl_so_meet_gray";
        public static final String j = "dl_so_zip_enable";
        public String k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public String q;
        public boolean r;

        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            for (Map.Entry<String, String> entry : a().entrySet()) {
                RimStatisticsUtil.onEventWithValue(entry.getKey(), entry.getValue());
            }
            RimStatisticsUtil.getInstance().triggerSending();
        }

        private Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put(f5526c, e.this.f5512g.f5487a);
            hashMap.put(f5525a, this.k);
            hashMap.put(f5527d, this.l ? "1" : "-1");
            if (this.l) {
                hashMap.put(j, this.r ? "1" : "-1");
                hashMap.put(f5529f, this.n ? "1" : "-1");
            }
            if (this.r) {
                hashMap.put(f5532i, this.o ? "1" : "-1");
            }
            if (this.n) {
                hashMap.put(f5530g, this.p ? "1" : "-1");
                hashMap.put(f5528e, this.m ? "1" : "-1");
            }
            hashMap.put(f5531h, this.q);
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(c cVar) {
        this.f5508c.p = true;
        com.baidu.fsg.face.base.d.d.d(f5506a, "loadFileFromExternal onFailure distributedSdk uri:" + cVar.o.f5504b);
        final String str = System.currentTimeMillis() + "";
        final long doDownload = ApollonDownloadManager.getInstance(this.f5507b).doDownload(Environment.DIRECTORY_DOWNLOADS, str + "", cVar.o.f5504b, false, false, false, ".zip");
        LogUtil.i(f5506a, "start load engineso file");
        final boolean[] zArr = {false};
        if (doDownload != -1) {
            ApollonDownloadManager.getInstance(this.f5507b).registerObserver(this.f5507b, doDownload, new ApollonDownloadManager.DownloadListener() { // from class: com.baidu.fsg.face.base.b.e.4
                /* JADX WARN: Removed duplicated region for block: B:44:0x01e2  */
                /* JADX WARN: Removed duplicated region for block: B:52:0x01f5  */
                /* JADX WARN: Removed duplicated region for block: B:62:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onChanged(DownloadItemInfo downloadItemInfo) {
                    Throwable th;
                    FileInputStream fileInputStream;
                    IOException e2;
                    File file;
                    b bVar;
                    StringBuilder sb;
                    if (downloadItemInfo.getDownloadState() == 8) {
                        ApollonDownloadManager.getInstance(e.this.f5507b).unregisterObserver(e.this.f5507b, doDownload, this);
                        InputStream inputStream = null;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            try {
                                fileInputStream = new FileInputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str + ".zip");
                                try {
                                    byte[] bArr = new byte[51200];
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
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                } catch (IOException e4) {
                                    e2 = e4;
                                    e2.printStackTrace();
                                    com.baidu.fsg.face.base.d.d.d(e.f5506a, "distributeFileDownload() onFailure" + e2.toString());
                                    e.this.f5511f.p = true;
                                    com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a, e.this.f5511f);
                                    e.this.f5508c.m = false;
                                    e.this.f5508c.q = Log.getStackTraceString(e2);
                                    e.this.f5509d.countDown();
                                    File file3 = new File(str);
                                    if (file3.exists()) {
                                        file3.delete();
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (zArr[0]) {
                                        return;
                                    }
                                    com.baidu.fsg.face.base.d.d.d(e.f5506a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                    e.this.f5511f.p = true;
                                    com.baidu.fsg.face.base.b.b a2 = com.baidu.fsg.face.base.b.b.a(e.this.f5507b);
                                    e eVar = e.this;
                                    a2.a(eVar.f5507b, eVar.f5512g.f5487a, e.this.f5511f);
                                    e.this.f5508c.m = false;
                                    bVar = e.this.f5508c;
                                    sb = new StringBuilder();
                                    sb.append("distributeFileDownload() onFailure");
                                    sb.append(downloadItemInfo.getDownloadState());
                                    bVar.q = sb.toString();
                                    e.this.f5509d.countDown();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                file = new File(str);
                                if (file.exists()) {
                                    file.delete();
                                }
                                if (0 != 0) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (!zArr[0]) {
                                    com.baidu.fsg.face.base.d.d.d(e.f5506a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                    e.this.f5511f.p = true;
                                    com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(e.this.f5507b);
                                    e eVar2 = e.this;
                                    a3.a(eVar2.f5507b, eVar2.f5512g.f5487a, e.this.f5511f);
                                    e.this.f5508c.m = false;
                                    e.this.f5508c.q = "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState();
                                    e.this.f5509d.countDown();
                                }
                                throw th;
                            }
                        } catch (IOException e7) {
                            fileInputStream = null;
                            e2 = e7;
                        } catch (Throwable th3) {
                            th = th3;
                            file = new File(str);
                            if (file.exists()) {
                            }
                            if (0 != 0) {
                            }
                            if (!zArr[0]) {
                            }
                            throw th;
                        }
                        if (zArr[0]) {
                            return;
                        }
                        com.baidu.fsg.face.base.d.d.d(e.f5506a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                        e.this.f5511f.p = true;
                        com.baidu.fsg.face.base.b.b a4 = com.baidu.fsg.face.base.b.b.a(e.this.f5507b);
                        e eVar3 = e.this;
                        a4.a(eVar3.f5507b, eVar3.f5512g.f5487a, e.this.f5511f);
                        e.this.f5508c.m = false;
                        bVar = e.this.f5508c;
                        sb = new StringBuilder();
                        sb.append("distributeFileDownload() onFailure");
                        sb.append(downloadItemInfo.getDownloadState());
                        bVar.q = sb.toString();
                        e.this.f5509d.countDown();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final c cVar) {
        a(cVar.o, new a() { // from class: com.baidu.fsg.face.base.b.e.3
            @Override // com.baidu.fsg.face.base.b.e.a
            public void a(c.a aVar, byte[] bArr) {
                e eVar = e.this;
                Context context = eVar.f5507b;
                boolean a2 = eVar.a(context, com.baidu.fsg.face.base.b.b.c(context, eVar.f5512g), bArr);
                if (a2) {
                    e.this.f5508c.p = false;
                    e eVar2 = e.this;
                    String c2 = com.baidu.fsg.face.base.b.b.c(eVar2.f5507b, eVar2.f5512g);
                    e eVar3 = e.this;
                    eVar2.a(c2, com.baidu.fsg.face.base.b.b.a(eVar3.f5507b, eVar3.f5512g));
                    cVar.p = false;
                    com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(e.this.f5507b);
                    e eVar4 = e.this;
                    a3.a(eVar4.f5507b, eVar4.f5512g.f5487a, cVar);
                } else {
                    e.this.c(cVar);
                }
                String str = e.f5506a;
                com.baidu.fsg.face.base.d.d.d(str, "loadFileFromExternal writeFileSuccess:" + a2);
            }

            @Override // com.baidu.fsg.face.base.b.e.a
            public void a(c.a aVar) {
                e.this.c(cVar);
            }
        }, com.baidu.fsg.face.base.b.b.a(this.f5512g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] b(String str) {
        try {
            return a(new FileInputStream(new File(str)));
        } catch (IOException e2) {
            com.baidu.fsg.face.base.d.d.d(f5506a, e2);
            return null;
        }
    }

    private byte[] c(String str) throws IOException {
        return a(new FileInputStream(new File(Environment.getExternalStorageDirectory(), str)));
    }

    public void a(Context context, int i2) {
        this.f5507b = context;
        this.f5512g = com.baidu.fsg.face.base.b.b.a(i2);
        if ("UpdateSo".equals(f5506a)) {
            f5506a = "UpdateSo-" + this.f5512g.f5487a;
        }
        this.f5508c = new b();
        this.f5509d = new CountDownLatch(1);
        l.a().c(new k(new Runnable() { // from class: com.baidu.fsg.face.base.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                String rimSoDownLoad = BdWalletUtils.getRimSoDownLoad(e.this.f5507b);
                if (!TextUtils.isEmpty(rimSoDownLoad)) {
                    e.this.a(rimSoDownLoad);
                }
                try {
                    e.this.f5509d.await();
                    com.baidu.fsg.face.base.d.d.b(e.f5506a, "begin stat service");
                    e.this.f5508c.b();
                } catch (InterruptedException e2) {
                    com.baidu.fsg.face.base.d.d.d(e.f5506a, e2);
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
                    e.this.f5510e = c.a(new JSONObject(str), e.this.f5512g);
                    e.this.f5511f = com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a);
                    if (!TextUtils.isEmpty(e.this.f5511f.n)) {
                        e.this.f5512g.f5488b = e.this.f5512g.f5488b.compareTo(e.this.f5511f.n) < 0 ? e.this.f5511f.n : e.this.f5512g.f5488b;
                    }
                    String str2 = e.f5506a;
                    com.baidu.fsg.face.base.d.d.d(str2, "asyncDistributeConf() newOptions:" + e.this.f5510e.a());
                    String str3 = e.f5506a;
                    com.baidu.fsg.face.base.d.d.d(str3, "asyncDistributeConf() oldOptions:" + e.this.f5511f.a());
                    e.this.f5511f.q = e.this.f5510e.q;
                    e.this.f5511f.r = e.this.f5510e.r;
                    com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a, e.this.f5511f);
                    e.this.f5508c.l = true;
                    e.this.f5508c.k = e.this.f5510e.n;
                    if (e.this.f5510e.q && e.this.f5510e.r) {
                        e.this.f5508c.r = true;
                        e.this.a(e.this.f5511f);
                        int i2 = e.this.f5510e.s;
                        e.this.f5510e.s = e.this.f5511f.s;
                        if (!e.this.a(i2, e.this.f5511f)) {
                            e.this.f5508c.o = false;
                            e.this.f5508c.n = false;
                            e.this.f5509d.countDown();
                            e.this.f5511f.p = true;
                            com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a, e.this.f5511f);
                            return;
                        }
                        e.this.f5508c.o = true;
                        if (e.this.f5512g.f5488b.compareTo(e.this.f5510e.n) >= 0) {
                            e.this.f5508c.n = false;
                            e.this.f5509d.countDown();
                            e.this.f5511f.p = true;
                            com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a, e.this.f5511f);
                            return;
                        } else if (e.this.a(e.this.f5510e.o, e.this.f5511f.o)) {
                            e.this.f5512g.f5488b = e.this.f5510e.n;
                            e.this.b(e.this.f5510e);
                            e.this.f5508c.n = true;
                            return;
                        } else {
                            e.this.a(e.this.f5510e.o);
                            e.this.f5508c.n = false;
                            e.this.f5509d.countDown();
                            return;
                        }
                    }
                    e.this.f5508c.r = false;
                    e.this.f5508c.n = false;
                    e.this.f5509d.countDown();
                    e.this.f5511f.p = true;
                    com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a, e.this.f5511f);
                } catch (JSONException e2) {
                    com.baidu.fsg.face.base.d.d.d(e.f5506a, e2);
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
            com.baidu.fsg.face.base.b.b.a(this.f5507b).a(this.f5507b, this.f5512g.f5487a, cVar);
        }
        String str = f5506a;
        com.baidu.fsg.face.base.d.d.b(str, "current gray = " + cVar.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, c cVar) {
        return 100 == this.f5510e.s || cVar.s < i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final byte[] bArr) {
        l.a().c(new k(new Runnable() { // from class: com.baidu.fsg.face.base.b.e.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str = e.f5506a;
                    com.baidu.fsg.face.base.d.d.d(str, "distributeFileDownload() onSuccess" + e.this.f5510e.o.f5504b + ",:" + com.baidu.fsg.face.base.b.b.c(e.this.f5507b, e.this.f5512g));
                    String md5 = MD5Util.toMd5(bArr, false);
                    String localDecryptProxy = RimArmor.getInstance().localDecryptProxy(e.this.f5510e.o.f5505c);
                    if (localDecryptProxy == null || !localDecryptProxy.equals(md5)) {
                        e.this.f5511f.p = true;
                        com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a, e.this.f5511f);
                        e.this.f5508c.m = false;
                        e.this.f5508c.q = "localMd5 is not equals onlineMd5";
                        e.this.f5509d.countDown();
                        return;
                    }
                    if (!e.this.a(e.this.f5507b, com.baidu.fsg.face.base.b.b.c(e.this.f5507b, e.this.f5512g), bArr)) {
                        e.this.f5511f.p = true;
                        com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a, e.this.f5511f);
                        e.this.f5508c.m = false;
                        e.this.f5508c.q = "zip file write internal fail";
                        e.this.f5509d.countDown();
                    } else {
                        e.this.a(com.baidu.fsg.face.base.b.b.c(e.this.f5507b, e.this.f5512g), com.baidu.fsg.face.base.b.b.a(e.this.f5507b, e.this.f5512g));
                        e.this.f5510e.p = false;
                        com.baidu.fsg.face.base.b.b.a(e.this.f5507b).a(e.this.f5507b, e.this.f5512g.f5487a, e.this.f5510e);
                    }
                    if (e.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, e.this.f5507b)) {
                        String a2 = com.baidu.fsg.face.base.b.b.a(e.this.f5512g);
                        if (g.a(a2)) {
                            g.b(a2);
                        }
                        e.this.a(a2, bArr);
                    }
                } catch (Exception e2) {
                    String str2 = e.f5506a;
                    com.baidu.fsg.face.base.d.d.d(str2, "distributeFileDownload() Exception " + e2.toString());
                    e.this.f5511f.p = true;
                    com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(e.this.f5507b);
                    e eVar = e.this;
                    a3.a(eVar.f5507b, eVar.f5512g.f5487a, e.this.f5511f);
                    e.this.f5508c.m = false;
                    e.this.f5508c.q = Log.getStackTraceString(e2);
                    e.this.f5509d.countDown();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        a(aVar, new a() { // from class: com.baidu.fsg.face.base.b.e.6
            @Override // com.baidu.fsg.face.base.b.e.a
            public void a(c.a aVar2, byte[] bArr) {
                com.baidu.fsg.face.base.d.d.d(e.f5506a, "copyInternalFileToExternal(), loadFileFromExternal distributed success");
            }

            @Override // com.baidu.fsg.face.base.b.e.a
            public void a(c.a aVar2) {
                e eVar = e.this;
                String c2 = com.baidu.fsg.face.base.b.b.c(eVar.f5507b, eVar.f5512g);
                String a2 = com.baidu.fsg.face.base.b.b.a(e.this.f5512g);
                String str = e.f5506a;
                com.baidu.fsg.face.base.d.d.d(str, "asyncDistributeConf(), loadFileFromExternal failure internalFile:" + c2);
                if (g.a(c2)) {
                    byte[] b2 = e.this.b(c2);
                    if (e.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, e.this.f5507b)) {
                        if (g.a(a2)) {
                            g.b(a2);
                        }
                        e.this.a(a2, b2);
                    }
                }
            }
        }, com.baidu.fsg.face.base.b.b.a(this.f5512g));
    }

    private void a(c.a aVar, a aVar2, String str) {
        if (aVar2 != null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), str).exists()) {
                    byte[] c2 = c(str);
                    String md5 = MD5Util.toMd5(c2, false);
                    String localDecryptProxy = RimArmor.getInstance().localDecryptProxy(aVar.f5505c);
                    if (localDecryptProxy != null && localDecryptProxy.equals(md5)) {
                        aVar2.a(aVar, c2);
                    } else {
                        aVar2.a(aVar);
                    }
                } else {
                    aVar2.a(aVar);
                }
                return;
            } catch (Throwable th) {
                String str2 = f5506a;
                com.baidu.fsg.face.base.d.d.d(str2, "loadFileFromExternal() Throwable" + th.toString());
                aVar2.a(aVar);
                return;
            }
        }
        throw new IllegalArgumentException(a.class.getName() + "can't be null");
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
        } catch (IOException e2) {
            com.baidu.fsg.face.base.d.d.d(f5506a, e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory(), str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    try {
                        com.baidu.fsg.face.base.d.d.d(f5506a, th);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable th2) {
                                com.baidu.fsg.face.base.d.d.d(f5506a, th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                com.baidu.fsg.face.base.d.d.d(f5506a, th4);
                            }
                        }
                        throw th3;
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    com.baidu.fsg.face.base.d.d.d(f5506a, th5);
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
        return aVar2 == null || aVar == null || TextUtils.isEmpty(aVar2.f5505c) || !aVar.f5505c.equals(aVar2.f5505c);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0163 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0165 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0095 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:0x0064 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.io.BufferedOutputStream */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19 */
    public void a(String str, String str2) {
        byte[] bArr;
        String name;
        this.f5508c.m = true;
        this.f5509d.countDown();
        com.baidu.fsg.face.base.d.d.b(f5506a, "thread name unZipApkSoToLibDir = " + Thread.currentThread().getName());
        com.baidu.fsg.face.base.d.d.a(f5506a, "unZipApkSoToLibDir(), zipFilePath:" + str + ",libDir:" + str2);
        BufferedOutputStream bufferedOutputStream = 0;
        try {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            try {
                                try {
                                    bArr = new byte[4096];
                                    name = nextEntry.getName();
                                    com.baidu.fsg.face.base.d.d.d(f5506a, "unZipApkSoToLibDir() entryName," + name);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            if (name.endsWith(".so")) {
                                int lastIndexOf = name.lastIndexOf("_");
                                String str3 = name.substring(name.lastIndexOf("/") + 1, lastIndexOf) + ".so";
                                com.baidu.fsg.face.base.d.d.a(f5506a, "unZipApkSoToLibDir(),fileName2:" + str3);
                                File file = new File(str2 + File.separator + str3);
                                if (file.exists()) {
                                    file.delete();
                                }
                                File file2 = new File(file.getParent());
                                com.baidu.fsg.face.base.d.d.a(f5506a, "unZipApkSoToLibDir()entryFile" + file.toString() + "entryDir" + file2.toString());
                                if (!file2.exists()) {
                                    com.baidu.fsg.face.base.d.d.a(f5506a, "unZipApkSoToLibDir() not exists");
                                    file2.mkdirs();
                                }
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file), 4096);
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr, 0, 4096);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    } catch (Exception e3) {
                                        e = e3;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        e.printStackTrace();
                                        if (bufferedOutputStream != 0) {
                                            bufferedOutputStream.close();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (bufferedOutputStream != 0) {
                                            bufferedOutputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                                bufferedOutputStream2.flush();
                                bufferedOutputStream2.close();
                                bufferedOutputStream = bufferedOutputStream2;
                            } else if (bufferedOutputStream != 0) {
                                bufferedOutputStream.close();
                            }
                        } else {
                            try {
                                zipInputStream.close();
                                return;
                            } catch (IOException e4) {
                                com.baidu.fsg.face.base.d.d.d(f5506a, e4);
                                return;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedOutputStream = zipInputStream;
                        com.baidu.fsg.face.base.d.d.d(f5506a, e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                                return;
                            } catch (IOException e6) {
                                com.baidu.fsg.face.base.d.d.d(f5506a, e6);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = zipInputStream;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e7) {
                                com.baidu.fsg.face.base.d.d.d(f5506a, e7);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
