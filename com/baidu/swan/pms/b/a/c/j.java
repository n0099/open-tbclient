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
    private T btM;
    private e btR;
    private AtomicBoolean btS;
    private f<T> bua;

    public j(f<T> fVar) {
        this.bua = fVar;
        this.btR = fVar.btR;
        this.btM = fVar.btM;
        this.btS = fVar.btS;
    }

    public void WN() {
        if (this.btS.get()) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "stopped:" + this.btR.btQ.downloadUrl);
            }
            this.bua.WI();
        } else if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.btR.btP = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        } else if (!this.bua.WL()) {
            this.btR.btP = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
        } else {
            GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.btR.btQ.downloadUrl);
            this.bua.WG();
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int e = e(response, code);
                    if (this.btR.btP.errorNo != e) {
                        this.btR.btP = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + e + "!=" + this.btR.btP.errorNo + " HTTP-Code:" + code);
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
                    this.btR.btP = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
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
            Log.d("PMSTaskProcessor", "download " + this.btR.btQ.downloadUrl + "response code:" + response.code());
        }
        this.btR.btP = null;
        if (i < 200 || i > 300) {
            this.btR.btP = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.btR.btP.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.btR.btQ.currentSize + ",totalBytes:" + this.btR.btQ.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.btR.btQ.size) {
                this.btR.btP = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.e.c.n(",file length not match:server=", "" + this.btR.btQ.size, "local=", "" + contentLength));
                return this.btR.btP.errorNo;
            } else if (!this.bua.ag(this.btR.btQ.size)) {
                this.btR.btP = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.btR.btP.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.btR.btP = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.btR.btP.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        e.printStackTrace();
                    }
                    this.btR.btP = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.btR.btP.errorNo;
                }
            }
        }
        if (this.btR.btP == null) {
            this.btR.btP = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.btR.btP.errorNo;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.bua.btT;
        try {
            T t = this.btM;
            bufferedSource = responseBody.source();
            if (cVar.a(t, bufferedSource, this.bua.ayG, j)) {
                this.btR.btQ.currentSize = j;
                this.bua.WH();
                long currentTimeMillis = System.currentTimeMillis();
                boolean kx = kx(this.btR.btQ.filePath);
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.i("PMSTaskProcessor", "performDownload checkMD5Cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (kx) {
                    this.btR.btP = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
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

    private boolean kw(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.btR.btP = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.e.c.n("local file save failed:", str)));
            return false;
        } else if (file.length() != this.btR.btQ.size) {
            this.btR.btP = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.e.c.n(",file length not match:server=", "" + this.btR.btQ.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean kx(String str) {
        new File(str);
        if (kw(str)) {
            String str2 = this.btR.btQ.md5 != null ? this.btR.btQ.md5 : null;
            String b = str != null ? com.baidu.swan.pms.e.b.b(new File(str), true) : null;
            if (str2 == null || b == null) {
                this.btR.btP = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.e.c.n("server:", str2, ",local", b)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b)) {
                return true;
            }
            this.btR.btP = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.e.c.n("server:", upperCase, ",local", b));
            return false;
        }
        return false;
    }
}
