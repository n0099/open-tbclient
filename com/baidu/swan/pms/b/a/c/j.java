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
    private T bLG;
    private e bLL;
    private AtomicBoolean bLM;
    private f<T> bLU;

    public j(f<T> fVar) {
        this.bLU = fVar;
        this.bLL = fVar.bLL;
        this.bLG = fVar.bLG;
        this.bLM = fVar.bLM;
    }

    public void abA() {
        if (this.bLM.get()) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "stopped:" + this.bLL.bLK.downloadUrl);
            }
            this.bLU.abv();
        } else if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.bLL.bLJ = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        } else if (!this.bLU.aby()) {
            this.bLL.bLJ = new com.baidu.swan.pms.model.a(2204, "download : path not writable");
        } else {
            GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.bLL.bLK.downloadUrl);
            this.bLU.abt();
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int e = e(response, code);
                    if (this.bLL.bLJ.errorNo != e) {
                        this.bLL.bLJ = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + e + "!=" + this.bLL.bLJ.errorNo + " HTTP-Code:" + code);
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
                    this.bLL.bLJ = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
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
            Log.d("PMSTaskProcessor", "download " + this.bLL.bLK.downloadUrl + "response code:" + response.code());
        }
        this.bLL.bLJ = null;
        if (i < 200 || i > 300) {
            this.bLL.bLJ = new com.baidu.swan.pms.model.a(2104, "metadata : network error. http code=");
            return this.bLL.bLJ.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.bLL.bLK.currentSize + ",totalBytes:" + this.bLL.bLK.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.bLL.bLK.size) {
                this.bLL.bLJ = new com.baidu.swan.pms.model.a(2209, com.baidu.swan.pms.e.c.m(",file length not match:server=", "" + this.bLL.bLK.size, "local=", "" + contentLength));
                return this.bLL.bLJ.errorNo;
            } else if (!this.bLU.ay(this.bLL.bLK.size)) {
                this.bLL.bLJ = new com.baidu.swan.pms.model.a(2205, "download : no space error");
                return this.bLL.bLJ.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.bLL.bLJ = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.bLL.bLJ.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        e.printStackTrace();
                    }
                    this.bLL.bLJ = new com.baidu.swan.pms.model.a(2206, "download : disk write error");
                    return this.bLL.bLJ.errorNo;
                }
            }
        }
        if (this.bLL.bLJ == null) {
            this.bLL.bLJ = new com.baidu.swan.pms.model.a(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.bLL.bLJ.errorNo;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        BufferedSource bufferedSource = null;
        c<T> cVar = this.bLU.bLN;
        try {
            T t = this.bLG;
            bufferedSource = responseBody.source();
            if (cVar.a(t, bufferedSource, this.bLU.aRE, j)) {
                this.bLL.bLK.currentSize = j;
                this.bLU.abu();
                long currentTimeMillis = System.currentTimeMillis();
                boolean kZ = kZ(this.bLL.bLK.filePath);
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.i("PMSTaskProcessor", "performDownload checkMD5Cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (kZ) {
                    this.bLL.bLJ = new com.baidu.swan.pms.model.a(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
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
            this.bLL.bLJ = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.e.c.m("local file save failed:", str)));
            return false;
        } else if (file.length() != this.bLL.bLK.size) {
            this.bLL.bLJ = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.e.c.m(",file length not match:server=", "" + this.bLL.bLK.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean kZ(String str) {
        new File(str);
        if (kY(str)) {
            String str2 = this.bLL.bLK.md5 != null ? this.bLL.bLK.md5 : null;
            String b = str != null ? com.baidu.swan.pms.e.b.b(new File(str), true) : null;
            if (str2 == null || b == null) {
                this.bLL.bLJ = new com.baidu.swan.pms.model.a(2208, String.format("download file not found:%s", com.baidu.swan.pms.e.c.m("server:", str2, ",local", b)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b)) {
                return true;
            }
            this.bLL.bLJ = new com.baidu.swan.pms.model.a(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.e.c.m("server:", upperCase, ",local", b));
            return false;
        }
        return false;
    }
}
