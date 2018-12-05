package com.baidu.b.a.f.d;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.b.a.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class f implements Runnable {
    private b aaa;
    private File aab;
    private com.baidu.b.a.c.a.a mDynamicFile;
    private AtomicBoolean aac = new AtomicBoolean(false);
    private int mRetryCount = 0;

    public f(com.baidu.b.a.c.a.a aVar, b bVar) {
        this.mDynamicFile = aVar;
        this.aaa = bVar;
    }

    public void aH(boolean z) {
        if (this.aac.get() != z) {
            this.aac.set(z);
        }
    }

    public boolean d(f fVar) {
        return this.mDynamicFile.c(fVar.mDynamicFile);
    }

    public boolean c(com.baidu.b.a.c.a.a aVar) {
        return this.mDynamicFile.c(aVar);
    }

    public com.baidu.b.a.c.a.a rL() {
        return this.mDynamicFile;
    }

    public com.baidu.b.a.b.c.b rM() {
        return this.aaa;
    }

    public void a(b bVar) {
        this.aaa.a(bVar);
    }

    public String getPackageName() {
        if (this.mDynamicFile != null) {
            return this.mDynamicFile.packageName;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof com.baidu.b.a.c.a.a) {
            return c((com.baidu.b.a.c.a.a) obj);
        }
        if (obj instanceof f) {
            return d((f) obj);
        }
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.e("ThunderInfoTask", "comparing unsupport object:" + obj);
        }
        return false;
    }

    public String toString() {
        return "downloadUrl:" + this.mDynamicFile.downloadUrl + ", version:" + this.mDynamicFile.Zn + ",md5:" + this.mDynamicFile.md5 + ",packageName:" + this.mDynamicFile.packageName;
    }

    private boolean rN() {
        try {
            this.aab = new File(this.mDynamicFile.filePath);
            if (!this.aab.exists()) {
                try {
                    this.aab.createNewFile();
                } catch (IOException e) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("ThunderInfoTask", "create local file failed:" + e.toString());
                    }
                    this.aab = null;
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            if (com.baidu.b.a.h.b.isDebug()) {
                Log.e("ThunderInfoTask", "RandomAccessFile error:" + e2.getMessage());
            }
            this.aab = null;
            return false;
        }
    }

    private boolean v(long j) {
        boolean z = false;
        String downloadPath = this.aaa.getDownloadPath();
        if (downloadPath != null) {
            try {
                StatFs statFs = new StatFs(downloadPath);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    Log.d("ThunderInfoTask", "path exception or no space left." + th.toString());
                }
            }
        }
        return z;
    }

    public boolean rO() {
        if (TextUtils.isEmpty(this.mDynamicFile.downloadUrl) || TextUtils.isEmpty(this.mDynamicFile.downloadUrl.trim())) {
            this.mDynamicFile.KC = 2214;
            this.mDynamicFile.errMsg = String.format("download : param error:%s", "downloadUrl");
            this.mDynamicFile.Zm = String.format(a.C0056a.C0057a.Ze, "downloadUrl");
            this.aaa.onDownloadError(new com.baidu.b.a.b.b.a(getPackageName(), this.mDynamicFile.KC, this.mDynamicFile.errMsg, this.mDynamicFile.Zm));
            return true;
        } else if (TextUtils.isEmpty(this.mDynamicFile.md5) || TextUtils.isEmpty(this.mDynamicFile.md5.trim())) {
            this.mDynamicFile.KC = 2214;
            this.mDynamicFile.errMsg = String.format("download : param error:%s", ARResourceKey.HTTP_AR_MD5);
            this.mDynamicFile.Zm = String.format(a.C0056a.C0057a.Ze, ARResourceKey.HTTP_AR_MD5);
            this.aaa.onDownloadError(new com.baidu.b.a.b.b.a(getPackageName(), this.mDynamicFile.KC, this.mDynamicFile.errMsg, this.mDynamicFile.Zm));
            return true;
        } else if (TextUtils.isEmpty(this.mDynamicFile.packageName) || TextUtils.isEmpty(this.mDynamicFile.packageName.trim())) {
            this.mDynamicFile.KC = 2214;
            this.mDynamicFile.errMsg = String.format("download : param error:%s", "packageName");
            this.mDynamicFile.Zm = String.format(a.C0056a.C0057a.Ze, "packageName");
            this.aaa.onDownloadError(new com.baidu.b.a.b.b.a(getPackageName(), this.mDynamicFile.KC, this.mDynamicFile.errMsg, this.mDynamicFile.Zm));
            return true;
        } else {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [318=6] */
    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("ThunderInfoTask", "running:" + this.mDynamicFile.downloadUrl);
        }
        while (this.mDynamicFile.KC != 2200) {
            try {
                rP();
                switch (this.mDynamicFile.KC) {
                    case 2200:
                        if (com.baidu.b.a.h.b.isDebug()) {
                            Log.d("ThunderInfoTask", "download:" + this.mDynamicFile.downloadUrl + " [success]!");
                        }
                        this.aaa.onFileDownloaded(new com.baidu.b.a.b.b.a(getPackageName(), this.mDynamicFile.KC, this.mDynamicFile.errMsg, this.mDynamicFile.Zm), this.mDynamicFile);
                        onSuccess();
                        return;
                    case 2209:
                        this.aaa.onFilePause(new com.baidu.b.a.b.b.a(getPackageName(), this.mDynamicFile.KC, this.mDynamicFile.errMsg, this.mDynamicFile.Zm));
                        return;
                    case 2211:
                        this.aaa.onFileCancel(new com.baidu.b.a.b.b.a(getPackageName(), this.mDynamicFile.KC, this.mDynamicFile.errMsg, this.mDynamicFile.Zm));
                        return;
                    default:
                        if (com.baidu.b.a.h.b.isDebug()) {
                            Log.d("ThunderInfoTask", "download:" + this.mDynamicFile.downloadUrl + " [error]:" + this.mDynamicFile.errMsg);
                        }
                        this.aaa.mRetryCount++;
                        int i = this.mRetryCount + 1;
                        this.mRetryCount = i;
                        if (i >= 3) {
                            bH(3);
                            this.aaa.onDownloadError(new com.baidu.b.a.b.b.a(getPackageName(), this.mDynamicFile.KC, this.mDynamicFile.errMsg, this.mDynamicFile.Zm));
                            onFail();
                            return;
                        }
                        if (com.baidu.b.a.h.b.isDebug()) {
                            Log.d("ThunderInfoTask", "download fail Sleep seconds:" + (this.mRetryCount * 1000));
                        }
                        if (!this.aac.get()) {
                            try {
                                Thread.sleep(this.mRetryCount * 1000);
                                if (this.aaa.getDownloadOptions() == 1 && !com.baidu.b.a.h.e.isWifiNetworkConnected(AppRuntime.getAppContext())) {
                                    this.mDynamicFile.KC = 2207;
                                    this.mDynamicFile.errMsg = "download : network state has changed";
                                    this.mDynamicFile.Zm = a.C0056a.C0057a.YX;
                                }
                            } catch (InterruptedException e) {
                                if (com.baidu.b.a.h.b.isDebug()) {
                                    Log.d("ThunderInfoTask", "download:" + this.mDynamicFile.downloadUrl + " fail. Sleep err:" + e.toString());
                                }
                            }
                            com.baidu.b.a.h.g.sj().a(2215, "download : retry", this.mDynamicFile.channelId, this.mDynamicFile.packageName, this.mDynamicFile.Zn, this.mDynamicFile.downloadUrl, "", 0, this.mRetryCount);
                        }
                        break;
                }
            } catch (Exception e2) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    Log.e("ThunderInfoTask", e2.toString());
                    e2.printStackTrace();
                }
                return;
            } finally {
                d.f(rL());
            }
        }
    }

    private void rP() {
        if (this.aac.get()) {
            bH(12);
            if (com.baidu.b.a.h.b.isDebug()) {
                Log.d("ThunderInfoTask", "stopped:" + this.mDynamicFile.downloadUrl);
            }
            this.mDynamicFile.KC = 2211;
            this.mDynamicFile.errMsg = "download : customer cancel download";
            this.mDynamicFile.Zm = a.C0056a.C0057a.Zb;
        } else if (d.a(rM(), rL()) && (!rN() || this.aab == null)) {
            bH(3);
            this.mDynamicFile.KC = 2205;
            this.mDynamicFile.errMsg = "download : path not writable";
            this.mDynamicFile.Zm = a.C0056a.C0057a.YV;
        } else {
            GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.mDynamicFile.downloadUrl);
            bH(1);
            if (this.mRetryCount == 0) {
                this.aaa.onDownloadStart(this.mDynamicFile.packageName);
            }
            if (!com.baidu.b.a.h.e.isNetworkConnected(AppRuntime.getAppContext())) {
                this.mDynamicFile.KC = 2201;
                this.mDynamicFile.errMsg = "download : network error";
                this.mDynamicFile.Zm = a.C0056a.C0057a.YS;
                return;
            }
            if (this.aaa.getDownloadOptions() == 1) {
                if (!com.baidu.b.a.h.e.isWifiNetworkConnected(AppRuntime.getAppContext())) {
                    this.mDynamicFile.KC = 2213;
                    this.mDynamicFile.errMsg = "download : network limited error";
                    this.mDynamicFile.Zm = a.C0056a.C0057a.Zd;
                    return;
                }
                url.wifiOnly(true);
            }
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int a = a(response, code);
                    if (this.mDynamicFile.KC != a) {
                        if (com.baidu.b.a.h.b.isDebug()) {
                            Log.w("ThunderInfoTask", "mismatch errorCode:" + a + "!=" + this.mDynamicFile.KC + " HTTP-Code:" + code);
                        }
                        this.mDynamicFile.KC = 2201;
                        this.mDynamicFile.errMsg = "download : network error";
                        this.mDynamicFile.Zm = a.C0056a.C0057a.YS;
                    }
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception e) {
                            if (com.baidu.b.a.h.b.isDebug()) {
                                Log.d("ThunderInfoTask", "close http error." + e.toString());
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("ThunderInfoTask", e2.toString());
                        e2.printStackTrace();
                    }
                    this.mDynamicFile.KC = 2201;
                    this.mDynamicFile.errMsg = "download : network error";
                    this.mDynamicFile.Zm = a.C0056a.C0057a.YS;
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception e3) {
                            if (com.baidu.b.a.h.b.isDebug()) {
                                Log.d("ThunderInfoTask", "close http error." + e3.toString());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (response != null) {
                    try {
                        response.close();
                    } catch (Exception e4) {
                        if (com.baidu.b.a.h.b.isDebug()) {
                            Log.d("ThunderInfoTask", "close http error." + e4.toString());
                        }
                    }
                }
                throw th;
            }
        }
    }

    private int a(Response response, int i) {
        FileOutputStream byteArrayOutputStream;
        boolean a;
        if (i < 200 || i > 300) {
            this.mDynamicFile.KC = 2105;
            this.mDynamicFile.errMsg = "metadata : network error. http code=";
            this.mDynamicFile.Zm = a.C0056a.C0057a.YO;
            return 2105;
        }
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("ThunderInfoTask", "download " + this.mDynamicFile.downloadUrl + "response code:" + response.code());
        }
        ResponseBody body = response.body();
        if (body != null && body.contentLength() > 0) {
            long contentLength = body.contentLength();
            this.mDynamicFile.Zw = contentLength;
            boolean a2 = d.a(rM(), rL());
            if (a2 && !v(contentLength)) {
                bH(3);
                this.mDynamicFile.KC = 2206;
                this.mDynamicFile.errMsg = "download : no space error";
                this.mDynamicFile.Zm = a.C0056a.C0057a.YW;
                return 2206;
            }
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                InputStream byteStream = body.byteStream();
                if (a2) {
                    byteArrayOutputStream = new FileOutputStream(this.aab);
                } else {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                }
                if (a(byteStream, byteArrayOutputStream, contentLength)) {
                    if (a2) {
                        a = a(this.aab.getAbsolutePath(), this.mDynamicFile);
                    } else {
                        this.mDynamicFile.fileData = com.baidu.b.a.h.e.d(byteArrayOutputStream);
                        a = a(this.mDynamicFile.fileData, this.mDynamicFile);
                    }
                    if (a) {
                        if (a2) {
                            File rQ = rQ();
                            if (this.aab.renameTo(rQ)) {
                                this.mDynamicFile.filePath = rQ.getAbsolutePath();
                                e.g(this.mDynamicFile);
                            }
                        }
                        bH(10);
                        this.mDynamicFile.KC = 2200;
                        this.mDynamicFile.errMsg = "download : package download success";
                        this.mDynamicFile.Zm = a.C0056a.C0057a.YR;
                        return 2200;
                    }
                    return PushConstants.DELAY_NOTIFICATION;
                } else if (this.aac.get()) {
                    if (this.mDynamicFile.type == 2) {
                        this.mDynamicFile.KC = 2209;
                        this.mDynamicFile.errMsg = "download : customer stop download";
                        this.mDynamicFile.Zm = a.C0056a.C0057a.YZ;
                        return 2209;
                    } else if (this.mDynamicFile.type == 12) {
                        this.mDynamicFile.KC = 2211;
                        this.mDynamicFile.errMsg = "download : customer cancel download";
                        this.mDynamicFile.Zm = a.C0056a.C0057a.Zb;
                        return 2211;
                    } else {
                        String str = "can't read full data from InputStream., readed-length:" + this.mDynamicFile.Zx + " of content-length:" + this.mDynamicFile.Zw;
                        this.mDynamicFile.KC = 2208;
                        this.mDynamicFile.errMsg = "download : disk write error" + com.baidu.b.a.h.e.n(com.baidu.fsg.base.statistics.b.k, str);
                        this.mDynamicFile.Zm = a.C0056a.C0057a.YY;
                        return 2208;
                    }
                }
            } catch (Exception e) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                        if (com.baidu.b.a.h.b.isDebug()) {
                            Log.w("ThunderInfoTask", "close HTTP.is error:" + e2.getMessage());
                        }
                    }
                }
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception e3) {
                        if (com.baidu.b.a.h.b.isDebug()) {
                            Log.w("ThunderInfoTask", "close HTTP.os error:" + e3.getMessage());
                        }
                    }
                }
                this.mDynamicFile.KC = 2208;
                this.mDynamicFile.errMsg = "download : disk write error" + com.baidu.b.a.h.e.n(com.baidu.fsg.base.statistics.b.k, e.getLocalizedMessage());
                this.mDynamicFile.Zm = a.C0056a.C0057a.YY;
                return 2208;
            }
        }
        this.mDynamicFile.KC = 2201;
        this.mDynamicFile.errMsg = "download : network error";
        this.mDynamicFile.Zm = a.C0056a.C0057a.YS;
        return 2201;
    }

    public void onSuccess() {
    }

    public void onFail() {
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        long j2;
        int i;
        int read;
        byte[] bArr = new byte[65536];
        int length = bArr.length;
        int i2 = 0;
        long j3 = 0;
        long j4 = 0;
        while (!this.aac.get() && i2 != -1) {
            if (j > 0) {
                if (j3 >= j) {
                    break;
                } else if (length + j3 > j) {
                    i = (int) (j - j3);
                    read = inputStream.read(bArr, 0, i);
                    if (read <= 0) {
                        outputStream.write(bArr, 0, read);
                        j3 += read;
                        this.mDynamicFile.Zx = j3;
                        if (j3 - j2 > 2097152) {
                            e.a(this.mDynamicFile, j3);
                            j2 = j3;
                        } else {
                            j2 = j2;
                        }
                        try {
                            this.aaa.onFileProgress(this.mDynamicFile.packageName, j3, j);
                            j4 = j2;
                            i2 = read;
                            length = i;
                        } finally {
                            if (j3 > j2) {
                                e.a(this.mDynamicFile, j3);
                            }
                        }
                    } else {
                        i2 = read;
                        length = i;
                    }
                }
            }
            i = length;
            read = inputStream.read(bArr, 0, i);
            if (read <= 0) {
            }
        }
        return j3 == j;
    }

    public boolean bH(int i) {
        if (this.mDynamicFile.type != i) {
            e.a(this.mDynamicFile, i);
            if (i == 2 || i == 3 || i == 10 || i == 11) {
                aH(true);
                return true;
            }
            aH(false);
            return true;
        }
        return false;
    }

    private File rQ() {
        File file = new File(this.aaa.getDownloadPath(), this.mDynamicFile.packageName);
        int i = 1;
        while (file.exists()) {
            file = new File(this.aaa.getDownloadPath(), this.mDynamicFile.packageName + BaseRequestAction.SPLITE + i);
            i++;
        }
        return file;
    }

    public static boolean a(String str, com.baidu.b.a.c.a.a aVar) {
        String str2 = aVar.md5 != null ? aVar.md5 : null;
        String md5 = str != null ? com.baidu.b.a.h.i.toMd5(new File(str), true) : null;
        if (str2 == null || md5 == null) {
            aVar.KC = PushConstants.DELAY_NOTIFICATION;
            aVar.errMsg = "download : package MD5 verify failed." + com.baidu.b.a.h.e.n("server:", str2, ",local", md5);
            aVar.Zm = a.C0056a.C0057a.YT;
            return false;
        }
        String upperCase = str2.toUpperCase();
        if (upperCase.equals(md5)) {
            return true;
        }
        aVar.KC = PushConstants.DELAY_NOTIFICATION;
        aVar.errMsg = "download : package MD5 verify failed." + com.baidu.b.a.h.e.n("server:", upperCase, ",local", md5);
        aVar.Zm = a.C0056a.C0057a.YT;
        return false;
    }

    public static boolean a(byte[] bArr, com.baidu.b.a.c.a.a aVar) {
        String str = aVar.md5 != null ? aVar.md5 : null;
        String md5 = bArr != null ? com.baidu.b.a.h.i.toMd5(bArr, true) : null;
        if (str == null || md5 == null) {
            aVar.KC = PushConstants.DELAY_NOTIFICATION;
            aVar.errMsg = "download : package MD5 verify failed." + com.baidu.b.a.h.e.n("server:", str, ",local", md5);
            aVar.Zm = a.C0056a.C0057a.YT;
            return false;
        }
        String upperCase = str.toUpperCase();
        if (upperCase.equals(md5)) {
            return true;
        }
        aVar.KC = PushConstants.DELAY_NOTIFICATION;
        aVar.errMsg = "download : package MD5 verify failed." + com.baidu.b.a.h.e.n("server:", upperCase, ",local", md5);
        aVar.Zm = a.C0056a.C0057a.YT;
        return false;
    }
}
