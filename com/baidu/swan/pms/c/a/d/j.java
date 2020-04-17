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
    private e daO;
    private T daP;
    private AtomicBoolean daQ;
    private f<T> daZ;

    public j(f<T> fVar) {
        this.daZ = fVar;
        this.daO = fVar.daO;
        this.daP = fVar.daP;
        this.daQ = fVar.daQ;
    }

    public void aCw() {
        if (!this.daQ.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.daO.daM = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.daZ.aBS()) {
                this.daO.daM = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.daO.daN.downloadUrl);
                this.daZ.aCm();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int g = g(response, code);
                    if (this.daO.daM.errorNo != g) {
                        this.daO.daM = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + g + "!=" + this.daO.daM.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.daO.daM = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.d.c.closeSafely(response);
                }
            }
        }
    }

    private int g(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.daO.daN.downloadUrl + "response code:" + response.code());
        }
        this.daO.daM = null;
        if (i < 200 || i > 300) {
            this.daO.daM = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.daO.daM.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.daO.daN.currentSize + ",totalBytes:" + this.daO.daN.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.daO.daN.size) {
                this.daO.daM = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.f.c.z(",file length not match:server=", "" + this.daO.daN.size, "local=", "" + contentLength));
                return this.daO.daM.errorNo;
            } else if (!this.daZ.bO(this.daO.daN.size)) {
                this.daO.daM = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.daO.daM.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.daO.daM = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.daO.daM.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    this.daO.daM = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.daO.daM.errorNo;
                }
            }
        }
        if (this.daO.daM == null) {
            this.daO.daM = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.daO.daM.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [245=5, 246=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.daZ.daR;
        try {
            T t = this.daP;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a = cVar.a(t, source, this.daZ.bVK, j);
            if (a.errorNo == 2302) {
                if (!a(Channels.newInputStream(source), new FileOutputStream(this.daZ.bVK), j) || !rH(this.daO.daN.filePath)) {
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
                this.daO.daM = a;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.d.c.closeSafely(source);
                }
                return false;
            } else {
                this.daO.daN.currentSize = j;
                this.daZ.aCn();
                boolean rH = rH(this.daO.daN.filePath);
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
        while (!this.daQ.get() && i != -1) {
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
                this.daO.daN.currentSize = j2;
                this.daZ.aCn();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.daQ.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean rG(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.daO.daM = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.z("local file save failed:", str)));
            return false;
        } else if (file.length() != this.daO.daN.size) {
            this.daO.daM = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.f.c.z(",file length not match:server=", "" + this.daO.daN.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean rH(String str) {
        if (rG(str)) {
            String str2 = this.daO.daN.md5 != null ? this.daO.daN.md5 : null;
            String md5 = str != null ? com.baidu.swan.pms.f.a.toMd5(new File(str), true) : null;
            if (str2 == null || md5 == null) {
                this.daO.daM = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.z("server:", str2, ",local", md5)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(md5)) {
                return true;
            }
            this.daO.daM = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.f.c.z("server:", upperCase, ",local", md5));
            return false;
        }
        return false;
    }
}
