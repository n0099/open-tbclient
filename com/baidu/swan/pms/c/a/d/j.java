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
    private e cBD;
    private T cBE;
    private AtomicBoolean cBF;
    private f<T> cBO;

    public j(f<T> fVar) {
        this.cBO = fVar;
        this.cBD = fVar.cBD;
        this.cBE = fVar.cBE;
        this.cBF = fVar.cBF;
    }

    public void aui() {
        if (!this.cBF.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.cBD.cBB = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.cBO.atF()) {
                this.cBD.cBB = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.cBD.cBC.downloadUrl);
                this.cBO.atZ();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int g = g(response, code);
                    if (this.cBD.cBB.errorNo != g) {
                        this.cBD.cBB = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + g + "!=" + this.cBD.cBB.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.cBD.cBB = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.d.c.closeSafely(response);
                }
            }
        }
    }

    private int g(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.cBD.cBC.downloadUrl + "response code:" + response.code());
        }
        this.cBD.cBB = null;
        if (i < 200 || i > 300) {
            this.cBD.cBB = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.cBD.cBB.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.cBD.cBC.currentSize + ",totalBytes:" + this.cBD.cBC.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.cBD.cBC.size) {
                this.cBD.cBB = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.f.c.z(",file length not match:server=", "" + this.cBD.cBC.size, "local=", "" + contentLength));
                return this.cBD.cBB.errorNo;
            } else if (!this.cBO.bj(this.cBD.cBC.size)) {
                this.cBD.cBB = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.cBD.cBB.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.cBD.cBB = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.cBD.cBB.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    this.cBD.cBB = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.cBD.cBB.errorNo;
                }
            }
        }
        if (this.cBD.cBB == null) {
            this.cBD.cBB = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.cBD.cBB.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [245=5, 246=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.cBO.cBG;
        try {
            T t = this.cBE;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a = cVar.a(t, source, this.cBO.bxt, j);
            if (a.errorNo == 2302) {
                if (!a(Channels.newInputStream(source), new FileOutputStream(this.cBO.bxt), j) || !qv(this.cBD.cBC.filePath)) {
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
                this.cBD.cBB = a;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.d.c.closeSafely(source);
                }
                return false;
            } else {
                this.cBD.cBC.currentSize = j;
                this.cBO.aua();
                boolean qv = qv(this.cBD.cBC.filePath);
                if (source == null || !source.isOpen()) {
                    return qv;
                }
                com.baidu.swan.d.c.closeSafely(source);
                return qv;
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
        while (!this.cBF.get() && i != -1) {
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
                this.cBD.cBC.currentSize = j2;
                this.cBO.aua();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.cBF.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean qu(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.cBD.cBB = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.z("local file save failed:", str)));
            return false;
        } else if (file.length() != this.cBD.cBC.size) {
            this.cBD.cBB = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.f.c.z(",file length not match:server=", "" + this.cBD.cBC.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean qv(String str) {
        if (qu(str)) {
            String str2 = this.cBD.cBC.md5 != null ? this.cBD.cBC.md5 : null;
            String md5 = str != null ? com.baidu.swan.pms.f.a.toMd5(new File(str), true) : null;
            if (str2 == null || md5 == null) {
                this.cBD.cBB = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.c.z("server:", str2, ",local", md5)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(md5)) {
                return true;
            }
            this.cBD.cBB = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.f.c.z("server:", upperCase, ",local", md5));
            return false;
        }
        return false;
    }
}
