package com.baidu.swan.pms.c.a.d;

import android.support.annotation.NonNull;
import android.util.Log;
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
/* loaded from: classes14.dex */
public class j<T> {
    private e dFK;
    private T dFL;
    private AtomicBoolean dFN;
    private f<T> dFW;

    public j(f<T> fVar) {
        this.dFW = fVar;
        this.dFK = fVar.dFK;
        this.dFL = fVar.dFL;
        this.dFN = fVar.dFN;
    }

    public void aUi() {
        if (!this.dFN.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.dFK.dFI = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.dFW.aUc()) {
                this.dFK.dFI = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = com.baidu.swan.a.c.a.aSW().getRequest().url(this.dFK.dFJ.downloadUrl);
                this.dFW.aTY();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int g = g(response, code);
                    if (this.dFK.dFI.errorNo != g) {
                        this.dFK.dFI = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + g + "!=" + this.dFK.dFI.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.dFK.dFI = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.c.d.closeSafely(response);
                }
            }
        }
    }

    private int g(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.dFK.dFJ.downloadUrl + "response code:" + response.code());
        }
        this.dFK.dFI = null;
        if (i < 200 || i > 300) {
            this.dFK.dFI = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, "metadata : network error. http code=");
            return this.dFK.dFI.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.dFK.dFJ.currentSize + ",totalBytes:" + this.dFK.dFJ.size + ",Content-Length:" + contentLength);
            }
            if (!this.dFW.ci(this.dFK.dFJ.size)) {
                this.dFK.dFI = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.dFK.dFI.errorNo;
            }
            try {
                if (a(body, contentLength)) {
                    this.dFK.dFI = new com.baidu.swan.pms.model.a(2200, "download : package download success");
                    return this.dFK.dFI.errorNo;
                }
            } catch (IOException e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    e.printStackTrace();
                }
                this.dFK.dFI = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                return this.dFK.dFI.errorNo;
            }
        }
        if (this.dFK.dFI == null) {
            this.dFK.dFI = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.dFK.dFI.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=5, 237=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.dFW.dFO;
        try {
            T t = this.dFL;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a = cVar.a(t, source, this.dFW.dFM, j);
            if (a.errorNo == 2302) {
                if (a(Channels.newInputStream(source), new FileOutputStream(this.dFW.dFM), j) && wG(this.dFK.dFJ.filePath)) {
                    if (source != null && source.isOpen()) {
                        com.baidu.swan.c.d.closeSafely(source);
                    }
                    return true;
                }
                if (source != null && source.isOpen()) {
                    com.baidu.swan.c.d.closeSafely(source);
                }
                return false;
            } else if (a.errorNo != 2300) {
                this.dFK.dFI = a;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.c.d.closeSafely(source);
                }
                return false;
            } else {
                this.dFK.dFJ.currentSize = j;
                this.dFW.aTZ();
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
        int i = 0;
        int length = bArr.length;
        long j2 = 0;
        while (!this.dFN.get() && i != -1) {
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
                this.dFK.dFJ.currentSize = j2;
                this.dFW.aTZ();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.dFN.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean wG(@NonNull String str) {
        if (!new File(str).exists()) {
            this.dFK.dFI = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.utils.d.B("local file save failed:", str)));
            return false;
        }
        String str2 = this.dFK.dFJ.md5;
        String md5 = com.baidu.swan.pms.utils.b.toMd5(new File(str), true);
        if (str2 == null || md5 == null) {
            this.dFK.dFI = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.utils.d.B("server:", str2, ",local", md5)));
            return false;
        }
        String upperCase = str2.toUpperCase();
        if (upperCase.equals(md5)) {
            return true;
        }
        this.dFK.dFI = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.utils.d.B("server:", upperCase, ",local", md5));
        return false;
    }
}
