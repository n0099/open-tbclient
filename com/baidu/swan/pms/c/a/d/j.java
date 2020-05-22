package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
/* loaded from: classes11.dex */
public class j<T> {
    private e dme;
    private T dmf;
    private AtomicBoolean dmg;
    private f<T> dmp;

    public j(f<T> fVar) {
        this.dmp = fVar;
        this.dme = fVar.dme;
        this.dmf = fVar.dmf;
        this.dmg = fVar.dmg;
    }

    public void aGM() {
        if (!this.dmg.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.dme.dmc = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.dmp.aGf()) {
                this.dme.dmc = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = com.baidu.swan.c.c.a.aFx().getRequest().url(this.dme.dmd.downloadUrl);
                this.dmp.aGC();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int f = f(response, code);
                    if (this.dme.dmc.errorNo != f) {
                        this.dme.dmc = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + f + "!=" + this.dme.dmc.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.dme.dmc = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.e.d.closeSafely(response);
                }
            }
        }
    }

    private int f(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.dme.dmd.downloadUrl + "response code:" + response.code());
        }
        this.dme.dmc = null;
        if (i < 200 || i > 300) {
            this.dme.dmc = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.dme.dmc.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.dme.dmd.currentSize + ",totalBytes:" + this.dme.dmd.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.dme.dmd.size) {
                this.dme.dmc = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.f.c.A(",file length not match:server=", "" + this.dme.dmd.size, "local=", "" + contentLength));
                return this.dme.dmc.errorNo;
            } else if (!this.dmp.bM(this.dme.dmd.size)) {
                this.dme.dmc = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.dme.dmc.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.dme.dmc = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.dme.dmc.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    this.dme.dmc = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.dme.dmc.errorNo;
                }
            }
        }
        if (this.dme.dmc == null) {
            this.dme.dmc = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.dme.dmc.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [245=5, 246=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.dmp.dmh;
        try {
            T t = this.dmf;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a = cVar.a(t, source, this.dmp.cgl, j);
            if (a.errorNo == 2302) {
                if (!a(Channels.newInputStream(source), new FileOutputStream(this.dmp.cgl), j) || !tm(this.dme.dmd.filePath)) {
                    if (source != null && source.isOpen()) {
                        com.baidu.swan.e.d.closeSafely(source);
                    }
                    return false;
                } else if (source == null || !source.isOpen()) {
                    return true;
                } else {
                    com.baidu.swan.e.d.closeSafely(source);
                    return true;
                }
            } else if (a.errorNo != 2300) {
                this.dme.dmc = a;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.e.d.closeSafely(source);
                }
                return false;
            } else {
                this.dme.dmd.currentSize = j;
                this.dmp.aGD();
                boolean tm = tm(this.dme.dmd.filePath);
                if (source == null || !source.isOpen()) {
                    return tm;
                }
                com.baidu.swan.e.d.closeSafely(source);
                return tm;
            }
        } catch (Throwable th) {
            if (0 != 0 && bufferedSource.isOpen()) {
                com.baidu.swan.e.d.closeSafely(null);
            }
            throw th;
        }
    }

    private boolean a(InputStream inputStream, OutputStream outputStream, long j) {
        try {
            try {
                return b(inputStream, outputStream, j);
            } catch (IOException e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskProcessor", "safeCopyStream: " + e.getMessage());
                }
                com.baidu.swan.e.d.closeSafely(inputStream);
                com.baidu.swan.e.d.closeSafely(outputStream);
                return false;
            }
        } finally {
            com.baidu.swan.e.d.closeSafely(inputStream);
            com.baidu.swan.e.d.closeSafely(outputStream);
        }
    }

    private boolean b(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[32768];
        int i = 0;
        int length = bArr.length;
        long j2 = 0;
        while (!this.dmg.get() && i != -1) {
            if (j > 0) {
                if (j2 >= j) {
                    break;
                } else if (length + j2 > j) {
                    length = (int) (j - j2);
                }
            }
            i = inputStream.read(bArr, 0, length);
            if (i > 0) {
                outputStream.write(bArr, 0, i);
                j2 += i;
                this.dme.dmd.currentSize = j2;
                this.dmp.aGD();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.dmg.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean tl(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.dme.dmc = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.A("local file save failed:", str)));
            return false;
        } else if (file.length() != this.dme.dmd.size) {
            this.dme.dmc = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.f.c.A(",file length not match:server=", "" + this.dme.dmd.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean tm(String str) {
        if (tl(str)) {
            String str2 = this.dme.dmd.md5 != null ? this.dme.dmd.md5 : null;
            String md5 = str != null ? com.baidu.swan.pms.f.a.toMd5(new File(str), true) : null;
            if (str2 == null || md5 == null) {
                this.dme.dmc = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.A("server:", str2, ",local", md5)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(md5)) {
                return true;
            }
            this.dme.dmc = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.f.c.A("server:", upperCase, ",local", md5));
            return false;
        }
        return false;
    }
}
