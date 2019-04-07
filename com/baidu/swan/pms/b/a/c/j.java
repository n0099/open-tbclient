package com.baidu.swan.pms.b.a.c;

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
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class j<T> {
    private e bmB;
    private AtomicBoolean bmD;
    private f bmM;
    private T bmw;

    public j(f<T> fVar) {
        this.bmM = fVar;
        this.bmB = fVar.bmB;
        this.bmw = fVar.bmw;
        this.bmD = fVar.bmD;
    }

    public void Sc() {
        if (this.bmD.get()) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "stopped:" + this.bmB.bmA.downloadUrl);
            }
            this.bmM.RX();
        } else if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.bmB.bmz = new com.baidu.swan.pms.model.b(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        } else if (!this.bmM.Sa()) {
            this.bmB.bmz = new com.baidu.swan.pms.model.b(2204, "download : path not writable");
        } else {
            GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.bmB.bmA.downloadUrl);
            this.bmM.RV();
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int d = d(response, code);
                    if (this.bmB.bmz.errorNo != d) {
                        this.bmB.bmz = new com.baidu.swan.pms.model.b(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d + "!=" + this.bmB.bmz.errorNo + " HTTP-Code:" + code);
                        }
                    }
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception e) {
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("PMSTaskProcessor", "close http error." + e.toString());
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.e("PMSTaskProcessor", e2.toString());
                        e2.printStackTrace();
                    }
                    this.bmB.bmz = new com.baidu.swan.pms.model.b(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception e3) {
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("PMSTaskProcessor", "close http error." + e3.toString());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (response != null) {
                    try {
                        response.close();
                    } catch (Exception e4) {
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.d("PMSTaskProcessor", "close http error." + e4.toString());
                        }
                    }
                }
                throw th;
            }
        }
    }

    private int d(Response response, int i) {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("PMSTaskProcessor", "download " + this.bmB.bmA.downloadUrl + "response code:" + response.code());
        }
        this.bmB.bmz = null;
        if (i < 200 || i > 300) {
            this.bmB.bmz = new com.baidu.swan.pms.model.b(2104, "metadata : network error. http code=");
            return this.bmB.bmz.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.bmB.bmA.currentSize + ",totalBytes:" + this.bmB.bmA.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.bmB.bmA.size) {
                this.bmB.bmz = new com.baidu.swan.pms.model.b(2104, com.baidu.swan.pms.d.c.o(",file length not match:server=", "" + this.bmB.bmA.size, "local=", "" + contentLength));
                return this.bmB.bmz.errorNo;
            } else if (!this.bmM.T(this.bmB.bmA.size)) {
                this.bmB.bmz = new com.baidu.swan.pms.model.b(2205, "download : no space error");
                return this.bmB.bmz.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.bmB.bmz = new com.baidu.swan.pms.model.b(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.bmB.bmz.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        e.printStackTrace();
                    }
                    this.bmB.bmz = new com.baidu.swan.pms.model.b(2206, "download : disk write error");
                    return this.bmB.bmz.errorNo;
                }
            }
        }
        if (this.bmB.bmz == null) {
            this.bmB.bmz = new com.baidu.swan.pms.model.b(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.bmB.bmz.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [243=4] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        boolean z = false;
        try {
            InputStream byteStream = responseBody.byteStream();
            try {
                fileOutputStream = new FileOutputStream(this.bmM.bmC, false);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                inputStream = byteStream;
            }
            try {
                if (a(byteStream, fileOutputStream, j) && jp(this.bmB.bmA.filePath)) {
                    this.bmB.bmz = new com.baidu.swan.pms.model.b(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                    z = true;
                    if (byteStream != null) {
                        try {
                            byteStream.close();
                        } catch (Exception e) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                } else {
                    if (byteStream != null) {
                        try {
                            byteStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                inputStream = byteStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e6) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[262144];
        int i = 0;
        int length = bArr.length;
        long j2 = 0;
        while (!this.bmD.get() && i != -1) {
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
                this.bmB.bmA.currentSize = j2;
                this.bmM.RW();
            }
        }
        return j2 == j;
    }

    private boolean jo(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.bmB.bmz = new com.baidu.swan.pms.model.b(2208, String.format("download file not found:%s", com.baidu.swan.pms.d.c.o("local file save failed:", str)));
            return false;
        } else if (file.length() != this.bmB.bmA.size) {
            this.bmB.bmz = new com.baidu.swan.pms.model.b(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.d.c.o(",file length not match:server=", "" + this.bmB.bmA.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean jp(String str) {
        if (jo(str)) {
            String str2 = this.bmB.bmA.md5 != null ? this.bmB.bmA.md5 : null;
            String c = str != null ? com.baidu.swan.pms.d.b.c(new File(str), true) : null;
            if (str2 == null || c == null) {
                this.bmB.bmz = new com.baidu.swan.pms.model.b(2208, String.format("download file not found:%s", com.baidu.swan.pms.d.c.o("server:", str2, ",local", c)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(c)) {
                return true;
            }
            this.bmB.bmz = new com.baidu.swan.pms.model.b(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.d.c.o("server:", upperCase, ",local", c));
            return false;
        }
        return false;
    }
}
