package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.HttpManager;
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
    private e daT;
    private T daU;
    private AtomicBoolean daV;
    private f<T> dbe;

    public j(f<T> fVar) {
        this.dbe = fVar;
        this.daT = fVar.daT;
        this.daU = fVar.daU;
        this.daV = fVar.daV;
    }

    public void aCw() {
        if (!this.daV.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.daT.daR = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.dbe.aBS()) {
                this.daT.daR = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.daT.daS.downloadUrl);
                this.dbe.aCm();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int g = g(response, code);
                    if (this.daT.daR.errorNo != g) {
                        this.daT.daR = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + g + "!=" + this.daT.daR.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.daT.daR = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.d.c.closeSafely(response);
                }
            }
        }
    }

    private int g(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.daT.daS.downloadUrl + "response code:" + response.code());
        }
        this.daT.daR = null;
        if (i < 200 || i > 300) {
            this.daT.daR = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.daT.daR.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.daT.daS.currentSize + ",totalBytes:" + this.daT.daS.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.daT.daS.size) {
                this.daT.daR = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.f.c.z(",file length not match:server=", "" + this.daT.daS.size, "local=", "" + contentLength));
                return this.daT.daR.errorNo;
            } else if (!this.dbe.bO(this.daT.daS.size)) {
                this.daT.daR = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.daT.daR.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.daT.daR = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.daT.daR.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    this.daT.daR = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.daT.daR.errorNo;
                }
            }
        }
        if (this.daT.daR == null) {
            this.daT.daR = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.daT.daR.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [245=5, 246=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.dbe.daW;
        try {
            T t = this.daU;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a = cVar.a(t, source, this.dbe.bVQ, j);
            if (a.errorNo == 2302) {
                if (!a(Channels.newInputStream(source), new FileOutputStream(this.dbe.bVQ), j) || !rH(this.daT.daS.filePath)) {
                    if (source != null && source.isOpen()) {
                        com.baidu.swan.d.c.closeSafely(source);
                    }
                    return false;
                } else if (source == null || !source.isOpen()) {
                    return true;
                } else {
                    com.baidu.swan.d.c.closeSafely(source);
                    return true;
                }
            } else if (a.errorNo != 2300) {
                this.daT.daR = a;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.d.c.closeSafely(source);
                }
                return false;
            } else {
                this.daT.daS.currentSize = j;
                this.dbe.aCn();
                boolean rH = rH(this.daT.daS.filePath);
                if (source == null || !source.isOpen()) {
                    return rH;
                }
                com.baidu.swan.d.c.closeSafely(source);
                return rH;
            }
        } catch (Throwable th) {
            if (0 != 0 && bufferedSource.isOpen()) {
                com.baidu.swan.d.c.closeSafely(null);
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
                com.baidu.swan.d.c.closeSafely(inputStream);
                com.baidu.swan.d.c.closeSafely(outputStream);
                return false;
            }
        } finally {
            com.baidu.swan.d.c.closeSafely(inputStream);
            com.baidu.swan.d.c.closeSafely(outputStream);
        }
    }

    private boolean b(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[32768];
        int i = 0;
        int length = bArr.length;
        long j2 = 0;
        while (!this.daV.get() && i != -1) {
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
                this.daT.daS.currentSize = j2;
                this.dbe.aCn();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.daV.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean rG(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.daT.daR = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.z("local file save failed:", str)));
            return false;
        } else if (file.length() != this.daT.daS.size) {
            this.daT.daR = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.f.c.z(",file length not match:server=", "" + this.daT.daS.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean rH(String str) {
        if (rG(str)) {
            String str2 = this.daT.daS.md5 != null ? this.daT.daS.md5 : null;
            String md5 = str != null ? com.baidu.swan.pms.f.a.toMd5(new File(str), true) : null;
            if (str2 == null || md5 == null) {
                this.daT.daR = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.z("server:", str2, ",local", md5)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(md5)) {
                return true;
            }
            this.daT.daR = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.f.c.z("server:", upperCase, ",local", md5));
            return false;
        }
        return false;
    }
}
