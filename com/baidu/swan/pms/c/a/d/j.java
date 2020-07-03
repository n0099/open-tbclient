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
    private e dqP;
    private T dqQ;
    private AtomicBoolean dqR;
    private f<T> dra;

    public j(f<T> fVar) {
        this.dra = fVar;
        this.dqP = fVar.dqP;
        this.dqQ = fVar.dqQ;
        this.dqR = fVar.dqR;
    }

    public void aHS() {
        if (!this.dqR.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.dqP.dqN = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.dra.aHl()) {
                this.dqP.dqN = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = com.baidu.swan.c.c.a.aGD().getRequest().url(this.dqP.dqO.downloadUrl);
                this.dra.aHI();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int f = f(response, code);
                    if (this.dqP.dqN.errorNo != f) {
                        this.dqP.dqN = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + f + "!=" + this.dqP.dqN.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.dqP.dqN = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.e.d.closeSafely(response);
                }
            }
        }
    }

    private int f(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.dqP.dqO.downloadUrl + "response code:" + response.code());
        }
        this.dqP.dqN = null;
        if (i < 200 || i > 300) {
            this.dqP.dqN = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.dqP.dqN.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.dqP.dqO.currentSize + ",totalBytes:" + this.dqP.dqO.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.dqP.dqO.size) {
                this.dqP.dqN = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.f.c.z(",file length not match:server=", "" + this.dqP.dqO.size, "local=", "" + contentLength));
                return this.dqP.dqN.errorNo;
            } else if (!this.dra.bM(this.dqP.dqO.size)) {
                this.dqP.dqN = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.dqP.dqN.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.dqP.dqN = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.dqP.dqN.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    this.dqP.dqN = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.dqP.dqN.errorNo;
                }
            }
        }
        if (this.dqP.dqN == null) {
            this.dqP.dqN = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.dqP.dqN.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [245=5, 246=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.dra.dqS;
        try {
            T t = this.dqQ;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a = cVar.a(t, source, this.dra.ckZ, j);
            if (a.errorNo == 2302) {
                if (!a(Channels.newInputStream(source), new FileOutputStream(this.dra.ckZ), j) || !tu(this.dqP.dqO.filePath)) {
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
                this.dqP.dqN = a;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.e.d.closeSafely(source);
                }
                return false;
            } else {
                this.dqP.dqO.currentSize = j;
                this.dra.aHJ();
                boolean tu = tu(this.dqP.dqO.filePath);
                if (source == null || !source.isOpen()) {
                    return tu;
                }
                com.baidu.swan.e.d.closeSafely(source);
                return tu;
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
        while (!this.dqR.get() && i != -1) {
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
                this.dqP.dqO.currentSize = j2;
                this.dra.aHJ();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.dqR.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean tt(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.dqP.dqN = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.z("local file save failed:", str)));
            return false;
        } else if (file.length() != this.dqP.dqO.size) {
            this.dqP.dqN = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.f.c.z(",file length not match:server=", "" + this.dqP.dqO.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean tu(String str) {
        if (tt(str)) {
            String str2 = this.dqP.dqO.md5 != null ? this.dqP.dqO.md5 : null;
            String md5 = str != null ? com.baidu.swan.pms.f.a.toMd5(new File(str), true) : null;
            if (str2 == null || md5 == null) {
                this.dqP.dqN = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.z("server:", str2, ",local", md5)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(md5)) {
                return true;
            }
            this.dqP.dqN = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.f.c.z("server:", upperCase, ",local", md5));
            return false;
        }
        return false;
    }
}
