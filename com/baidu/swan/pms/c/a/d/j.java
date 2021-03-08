package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
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
/* loaded from: classes3.dex */
public class j<T> {
    private e ewe;
    private T ewf;
    private AtomicBoolean ewg;
    private f<T> ewp;

    public j(f<T> fVar) {
        this.ewp = fVar;
        this.ewe = fVar.ewe;
        this.ewf = fVar.ewf;
        this.ewg = fVar.ewg;
    }

    public void bdl() {
        if (!this.ewg.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.ewe.ewc = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.ewp.bdf()) {
                this.ewe.ewc = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = com.baidu.swan.a.c.a.bca().getRequest().url(this.ewe.ewd.downloadUrl);
                this.ewp.bdb();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int g = g(response, code);
                    if (this.ewe.ewc.errorNo != g) {
                        this.ewe.ewc = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + g + "!=" + this.ewe.ewc.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.ewe.ewc = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.c.d.closeSafely(response);
                }
            }
        }
    }

    private int g(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.ewe.ewd.downloadUrl + "response code:" + response.code());
        }
        this.ewe.ewc = null;
        if (i < 200 || i > 300) {
            this.ewe.ewc = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, "metadata : network error. http code=");
            return this.ewe.ewc.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.ewe.ewd.currentSize + ",totalBytes:" + this.ewe.ewd.size + ",Content-Length:" + contentLength);
            }
            if (!this.ewp.dv(this.ewe.ewd.size)) {
                this.ewe.ewc = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.ewe.ewc.errorNo;
            }
            try {
                if (a(body, contentLength)) {
                    this.ewe.ewc = new com.baidu.swan.pms.model.a(2200, "download : package download success");
                    return this.ewe.ewc.errorNo;
                }
            } catch (IOException e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    e.printStackTrace();
                }
                this.ewe.ewc = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                return this.ewe.ewc.errorNo;
            }
        }
        if (this.ewe.ewc == null) {
            this.ewe.ewc = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.ewe.ewc.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=5, 237=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.ewp.ewh;
        try {
            T t = this.ewf;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a2 = cVar.a(t, source, this.ewp.cma, j);
            if (a2.errorNo == 2302) {
                if (a(Channels.newInputStream(source), new FileOutputStream(this.ewp.cma), j) && yj(this.ewe.ewd.filePath)) {
                    if (source != null && source.isOpen()) {
                        com.baidu.swan.c.d.closeSafely(source);
                    }
                    return true;
                }
                if (source != null && source.isOpen()) {
                    com.baidu.swan.c.d.closeSafely(source);
                }
                return false;
            } else if (a2.errorNo != 2300) {
                this.ewe.ewc = a2;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.c.d.closeSafely(source);
                }
                return false;
            } else {
                this.ewe.ewd.currentSize = j;
                this.ewp.bdc();
                if (source != null && source.isOpen()) {
                    com.baidu.swan.c.d.closeSafely(source);
                }
                return true;
            }
        } catch (Throwable th) {
            if (0 != 0 && bufferedSource.isOpen()) {
                com.baidu.swan.c.d.closeSafely(null);
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
                com.baidu.swan.c.d.closeSafely(inputStream);
                com.baidu.swan.c.d.closeSafely(outputStream);
                return false;
            }
        } finally {
            com.baidu.swan.c.d.closeSafely(inputStream);
            com.baidu.swan.c.d.closeSafely(outputStream);
        }
    }

    private boolean b(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[32768];
        int length = bArr.length;
        long j2 = 0;
        int i = 0;
        while (!this.ewg.get() && i != -1) {
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
                this.ewe.ewd.currentSize = j2;
                this.ewp.bdc();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.ewg.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean yj(@NonNull String str) {
        if (!new File(str).exists()) {
            this.ewe.ewc = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.utils.d.K("local file save failed:", str)));
            return false;
        }
        String str2 = this.ewe.ewd.md5;
        String e = com.baidu.swan.pms.utils.b.e(new File(str), true);
        if (str2 == null || e == null) {
            this.ewe.ewc = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.utils.d.K("server:", str2, ",local", e)));
            return false;
        }
        String upperCase = str2.toUpperCase();
        if (upperCase.equals(e)) {
            return true;
        }
        this.ewe.ewc = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.utils.d.K("server:", upperCase, ",local", e));
        return false;
    }
}
