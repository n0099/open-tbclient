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
/* loaded from: classes19.dex */
public class j<T> {
    private e dwH;
    private T dwI;
    private AtomicBoolean dwJ;
    private f<T> dwS;

    public j(f<T> fVar) {
        this.dwS = fVar;
        this.dwH = fVar.dwH;
        this.dwI = fVar.dwI;
        this.dwJ = fVar.dwJ;
    }

    public void aLJ() {
        if (!this.dwJ.get()) {
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                this.dwH.dwF = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
            } else if (!this.dwS.aLc()) {
                this.dwH.dwF = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
            } else {
                GetRequest.GetRequestBuilder url = com.baidu.swan.b.c.a.aKu().getRequest().url(this.dwH.dwG.downloadUrl);
                this.dwS.aLz();
                Response response = null;
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int h = h(response, code);
                    if (this.dwH.dwF.errorNo != h) {
                        this.dwH.dwF = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.d.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + h + "!=" + this.dwH.dwF.errorNo + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.e("PMSTaskProcessor", e.toString());
                        e.printStackTrace();
                    }
                    this.dwH.dwF = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                } finally {
                    com.baidu.swan.d.d.closeSafely(response);
                }
            }
        }
    }

    private int h(Response response, int i) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.dwH.dwG.downloadUrl + "response code:" + response.code());
        }
        this.dwH.dwF = null;
        if (i < 200 || i > 300) {
            this.dwH.dwF = new com.baidu.swan.pms.model.a(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, "metadata : network error. http code=");
            return this.dwH.dwF.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.dwH.dwG.currentSize + ",totalBytes:" + this.dwH.dwG.size + ",Content-Length:" + contentLength);
            }
            if (!this.dwS.cc(this.dwH.dwG.size)) {
                this.dwH.dwF = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.dwH.dwF.errorNo;
            }
            try {
                if (a(body, contentLength)) {
                    this.dwH.dwF = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                    return this.dwH.dwF.errorNo;
                }
            } catch (IOException e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    e.printStackTrace();
                }
                this.dwH.dwF = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                return this.dwH.dwF.errorNo;
            }
        }
        if (this.dwH.dwF == null) {
            this.dwH.dwF = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.dwH.dwF.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=5, 237=5] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.dwS.dwK;
        try {
            T t = this.dwI;
            BufferedSource source = responseBody.source();
            com.baidu.swan.pms.model.a a = cVar.a(t, source, this.dwS.dwf, j);
            if (a.errorNo == 2302) {
                if (a(Channels.newInputStream(source), new FileOutputStream(this.dwS.dwf), j) && ux(this.dwH.dwG.filePath)) {
                    if (source != null && source.isOpen()) {
                        com.baidu.swan.d.d.closeSafely(source);
                    }
                    return true;
                }
                if (source != null && source.isOpen()) {
                    com.baidu.swan.d.d.closeSafely(source);
                }
                return false;
            } else if (a.errorNo != 2300) {
                this.dwH.dwF = a;
                if (source != null && source.isOpen()) {
                    com.baidu.swan.d.d.closeSafely(source);
                }
                return false;
            } else {
                this.dwH.dwG.currentSize = j;
                this.dwS.aLA();
                if (source != null && source.isOpen()) {
                    com.baidu.swan.d.d.closeSafely(source);
                }
                return true;
            }
        } catch (Throwable th) {
            if (0 != 0 && bufferedSource.isOpen()) {
                com.baidu.swan.d.d.closeSafely(null);
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
                com.baidu.swan.d.d.closeSafely(inputStream);
                com.baidu.swan.d.d.closeSafely(outputStream);
                return false;
            }
        } finally {
            com.baidu.swan.d.d.closeSafely(inputStream);
            com.baidu.swan.d.d.closeSafely(outputStream);
        }
    }

    private boolean b(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[32768];
        int i = 0;
        int length = bArr.length;
        long j2 = 0;
        while (!this.dwJ.get() && i != -1) {
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
                this.dwH.dwG.currentSize = j2;
                this.dwS.aLA();
            }
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.dwJ.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    private boolean ux(@NonNull String str) {
        if (!new File(str).exists()) {
            this.dwH.dwF = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.d.A("local file save failed:", str)));
            return false;
        }
        String str2 = this.dwH.dwG.md5;
        String md5 = com.baidu.swan.pms.f.b.toMd5(new File(str), true);
        if (str2 == null || md5 == null) {
            this.dwH.dwF = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.f.d.A("server:", str2, ",local", md5)));
            return false;
        }
        String upperCase = str2.toUpperCase();
        if (upperCase.equals(md5)) {
            return true;
        }
        this.dwH.dwF = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.f.d.A("server:", upperCase, ",local", md5));
        return false;
    }
}
