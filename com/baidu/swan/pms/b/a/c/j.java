package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
/* loaded from: classes2.dex */
public class j<T> {
    private f<T> btC;
    private T bto;
    private e btt;
    private AtomicBoolean btu;

    public j(f<T> fVar) {
        this.btC = fVar;
        this.btt = fVar.btt;
        this.bto = fVar.bto;
        this.btu = fVar.btu;
    }

    public void WJ() {
        if (this.btu.get()) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "stopped:" + this.btt.bts.downloadUrl);
            }
            this.btC.WE();
        } else if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.btt.btr = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        } else if (!this.btC.WH()) {
            this.btt.btr = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
        } else {
            GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.btt.bts.downloadUrl);
            this.btC.WC();
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int e = e(response, code);
                    if (this.btt.btr.errorNo != e) {
                        this.btt.btr = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + e + "!=" + this.btt.btr.errorNo + " HTTP-Code:" + code);
                        }
                    }
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception e2) {
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("PMSTaskProcessor", "close http error." + e2.toString());
                            }
                        }
                    }
                } catch (Exception e3) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.e("PMSTaskProcessor", e3.toString());
                        e3.printStackTrace();
                    }
                    this.btt.btr = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception e4) {
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("PMSTaskProcessor", "close http error." + e4.toString());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (response != null) {
                    try {
                        response.close();
                    } catch (Exception e5) {
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.d("PMSTaskProcessor", "close http error." + e5.toString());
                        }
                    }
                }
                throw th;
            }
        }
    }

    private int e(Response response, int i) {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.btt.bts.downloadUrl + "response code:" + response.code());
        }
        this.btt.btr = null;
        if (i < 200 || i > 300) {
            this.btt.btr = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.btt.btr.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.btt.bts.currentSize + ",totalBytes:" + this.btt.bts.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.btt.bts.size) {
                this.btt.btr = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.e.c.n(",file length not match:server=", "" + this.btt.bts.size, "local=", "" + contentLength));
                return this.btt.btr.errorNo;
            } else if (!this.btC.ag(this.btt.bts.size)) {
                this.btt.btr = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.btt.btr.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.btt.btr = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.btt.btr.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        e.printStackTrace();
                    }
                    this.btt.btr = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.btt.btr.errorNo;
                }
            }
        }
        if (this.btt.btr == null) {
            this.btt.btr = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.btt.btr.errorNo;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.btC.btv;
        try {
            T t = this.bto;
            bufferedSource = responseBody.source();
            if (cVar.a(t, bufferedSource, this.btC.ayi, j)) {
                this.btt.bts.currentSize = j;
                this.btC.WD();
                long currentTimeMillis = System.currentTimeMillis();
                boolean kv = kv(this.btt.bts.filePath);
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.i("PMSTaskProcessor", "performDownload checkMD5Cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (kv) {
                    this.btt.btr = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                    return true;
                }
            }
            if (bufferedSource != null && bufferedSource.isOpen()) {
                bufferedSource.close();
            }
            return false;
        } finally {
            if (bufferedSource != null && bufferedSource.isOpen()) {
                bufferedSource.close();
            }
        }
    }

    private boolean ku(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.btt.btr = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.e.c.n("local file save failed:", str)));
            return false;
        } else if (file.length() != this.btt.bts.size) {
            this.btt.btr = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.e.c.n(",file length not match:server=", "" + this.btt.bts.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean kv(String str) {
        new File(str);
        if (ku(str)) {
            String str2 = this.btt.bts.md5 != null ? this.btt.bts.md5 : null;
            String b = str != null ? com.baidu.swan.pms.e.b.b(new File(str), true) : null;
            if (str2 == null || b == null) {
                this.btt.btr = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.e.c.n("server:", str2, ",local", b)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b)) {
                return true;
            }
            this.btt.btr = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.e.c.n("server:", upperCase, ",local", b));
            return false;
        }
        return false;
    }
}
