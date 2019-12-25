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
/* loaded from: classes9.dex */
public class j<T> {
    private f<T> cxD;
    private e cxs;
    private T cxt;
    private AtomicBoolean cxu;

    public j(f<T> fVar) {
        this.cxD = fVar;
        this.cxs = fVar.cxs;
        this.cxt = fVar.cxt;
        this.cxu = fVar.cxu;
    }

    public void arz() {
        if (!this.cxu.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.cxs.cxq = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.cxD.aqW()) {
                this.cxs.cxq = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.cxs.cxr.downloadUrl);
                this.cxD.arq();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int g = g(response, code);
                    if (this.cxs.cxq.errorNo != g) {
                        this.cxs.cxq = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + g + "!=" + this.cxs.cxq.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.cxs.cxq = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.d.c.closeSafely(response);
                }
            }
        }
    }

    private int g(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.cxs.cxr.downloadUrl + "response code:" + response.code());
        }
        this.cxs.cxq = null;
        if (i < 200 || i > 300) {
            this.cxs.cxq = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.cxs.cxq.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.cxs.cxr.currentSize + ",totalBytes:" + this.cxs.cxr.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.cxs.cxr.size) {
                this.cxs.cxq = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.f.c.v(",file length not match:server=", "" + this.cxs.cxr.size, "local=", "" + contentLength));
                return this.cxs.cxq.errorNo;
            } else if (!this.cxD.bc(this.cxs.cxr.size)) {
                this.cxs.cxq = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.cxs.cxq.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.cxs.cxq = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.cxs.cxq.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    this.cxs.cxq = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.cxs.cxq.errorNo;
                }
            }
        }
        if (this.cxs.cxq == null) {
            this.cxs.cxq = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.cxs.cxq.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [245=5, 246=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.cxD.cxv;
        try {
            T t = this.cxt;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a = cVar.a(t, source, this.cxD.bst, j);
            if (a.errorNo == 2302) {
                if (!a(Channels.newInputStream(source), new FileOutputStream(this.cxD.bst), j) || !qd(this.cxs.cxr.filePath)) {
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
                this.cxs.cxq = a;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.d.c.closeSafely(source);
                }
                return false;
            } else {
                this.cxs.cxr.currentSize = j;
                this.cxD.arr();
                boolean qd = qd(this.cxs.cxr.filePath);
                if (source == null || !source.isOpen()) {
                    return qd;
                }
                com.baidu.swan.d.c.closeSafely(source);
                return qd;
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
        while (!this.cxu.get() && i != -1) {
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
                this.cxs.cxr.currentSize = j2;
                this.cxD.arr();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.cxu.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean qc(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.cxs.cxq = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.v("local file save failed:", str)));
            return false;
        } else if (file.length() != this.cxs.cxr.size) {
            this.cxs.cxq = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.f.c.v(",file length not match:server=", "" + this.cxs.cxr.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean qd(String str) {
        if (qc(str)) {
            String str2 = this.cxs.cxr.md5 != null ? this.cxs.cxr.md5 : null;
            String md5 = str != null ? com.baidu.swan.pms.f.a.toMd5(new File(str), true) : null;
            if (str2 == null || md5 == null) {
                this.cxs.cxq = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.v("server:", str2, ",local", md5)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(md5)) {
                return true;
            }
            this.cxs.cxq = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.f.c.v("server:", upperCase, ",local", md5));
            return false;
        }
        return false;
    }
}
