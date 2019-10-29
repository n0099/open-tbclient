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
    private e bMC;
    private AtomicBoolean bMD;
    private f<T> bML;
    private T bMx;

    public j(f<T> fVar) {
        this.bML = fVar;
        this.bMC = fVar.bMC;
        this.bMx = fVar.bMx;
        this.bMD = fVar.bMD;
    }

    public void abC() {
        if (this.bMD.get()) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "stopped:" + this.bMC.bMB.downloadUrl);
            }
            this.bML.abx();
        } else if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.bMC.bMA = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        } else if (!this.bML.abA()) {
            this.bMC.bMA = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
        } else {
            GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.bMC.bMB.downloadUrl);
            this.bML.abv();
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int e = e(response, code);
                    if (this.bMC.bMA.errorNo != e) {
                        this.bMC.bMA = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + e + "!=" + this.bMC.bMA.errorNo + " HTTP-Code:" + code);
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
                    this.bMC.bMA = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
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
            Log.d("PMSTaskProcessor", "download " + this.bMC.bMB.downloadUrl + "response code:" + response.code());
        }
        this.bMC.bMA = null;
        if (i < 200 || i > 300) {
            this.bMC.bMA = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.bMC.bMA.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.bMC.bMB.currentSize + ",totalBytes:" + this.bMC.bMB.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.bMC.bMB.size) {
                this.bMC.bMA = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.e.c.m(",file length not match:server=", "" + this.bMC.bMB.size, "local=", "" + contentLength));
                return this.bMC.bMA.errorNo;
            } else if (!this.bML.az(this.bMC.bMB.size)) {
                this.bMC.bMA = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.bMC.bMA.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.bMC.bMA = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.bMC.bMA.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        e.printStackTrace();
                    }
                    this.bMC.bMA = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.bMC.bMA.errorNo;
                }
            }
        }
        if (this.bMC.bMA == null) {
            this.bMC.bMA = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.bMC.bMA.errorNo;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.bML.bME;
        try {
            T t = this.bMx;
            bufferedSource = responseBody.source();
            if (cVar.a(t, bufferedSource, this.bML.aRW, j)) {
                this.bMC.bMB.currentSize = j;
                this.bML.abw();
                long currentTimeMillis = System.currentTimeMillis();
                boolean kZ = kZ(this.bMC.bMB.filePath);
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.i("PMSTaskProcessor", "performDownload checkMD5Cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (kZ) {
                    this.bMC.bMA = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
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

    private boolean kY(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.bMC.bMA = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.e.c.m("local file save failed:", str)));
            return false;
        } else if (file.length() != this.bMC.bMB.size) {
            this.bMC.bMA = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.e.c.m(",file length not match:server=", "" + this.bMC.bMB.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean kZ(String str) {
        new File(str);
        if (kY(str)) {
            String str2 = this.bMC.bMB.md5 != null ? this.bMC.bMB.md5 : null;
            String b = str != null ? com.baidu.swan.pms.e.b.b(new File(str), true) : null;
            if (str2 == null || b == null) {
                this.bMC.bMA = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.e.c.m("server:", str2, ",local", b)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b)) {
                return true;
            }
            this.bMC.bMA = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.e.c.m("server:", upperCase, ",local", b));
            return false;
        }
        return false;
    }
}
