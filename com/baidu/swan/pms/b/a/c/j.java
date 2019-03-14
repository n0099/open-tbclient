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
    private AtomicBoolean bmA;
    private f bmJ;
    private T bmt;
    private e bmy;

    public j(f<T> fVar) {
        this.bmJ = fVar;
        this.bmy = fVar.bmy;
        this.bmt = fVar.bmt;
        this.bmA = fVar.bmA;
    }

    public void Se() {
        if (this.bmA.get()) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "stopped:" + this.bmy.bmx.downloadUrl);
            }
            this.bmJ.RZ();
        } else if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.bmy.bmw = new com.baidu.swan.pms.model.b(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        } else if (!this.bmJ.Sc()) {
            this.bmy.bmw = new com.baidu.swan.pms.model.b(2204, "download : path not writable");
        } else {
            GetRequest.GetRequestBuilder url = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(this.bmy.bmx.downloadUrl);
            this.bmJ.RX();
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int d = d(response, code);
                    if (this.bmy.bmw.errorNo != d) {
                        this.bmy.bmw = new com.baidu.swan.pms.model.b(PushConstants.ONTIME_NOTIFICATION, "download : network error");
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d + "!=" + this.bmy.bmw.errorNo + " HTTP-Code:" + code);
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
                    this.bmy.bmw = new com.baidu.swan.pms.model.b(PushConstants.ONTIME_NOTIFICATION, "download : network error");
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
            Log.d("PMSTaskProcessor", "download " + this.bmy.bmx.downloadUrl + "response code:" + response.code());
        }
        this.bmy.bmw = null;
        if (i < 200 || i > 300) {
            this.bmy.bmw = new com.baidu.swan.pms.model.b(2104, "metadata : network error. http code=");
            return this.bmy.bmw.errorNo;
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength = body.contentLength();
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSTaskProcessor", "currentSize:" + this.bmy.bmx.currentSize + ",totalBytes:" + this.bmy.bmx.size + ",Content-Length:" + contentLength);
            }
            if (contentLength > 0 && contentLength != this.bmy.bmx.size) {
                this.bmy.bmw = new com.baidu.swan.pms.model.b(2104, com.baidu.swan.pms.d.c.o(",file length not match:server=", "" + this.bmy.bmx.size, "local=", "" + contentLength));
                return this.bmy.bmw.errorNo;
            } else if (!this.bmJ.T(this.bmy.bmx.size)) {
                this.bmy.bmw = new com.baidu.swan.pms.model.b(2205, "download : no space error");
                return this.bmy.bmw.errorNo;
            } else {
                try {
                    if (a(body, contentLength)) {
                        this.bmy.bmw = new com.baidu.swan.pms.model.b(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
                        return this.bmy.bmw.errorNo;
                    }
                } catch (IOException e) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        e.printStackTrace();
                    }
                    this.bmy.bmw = new com.baidu.swan.pms.model.b(2206, "download : disk write error");
                    return this.bmy.bmw.errorNo;
                }
            }
        }
        if (this.bmy.bmw == null) {
            this.bmy.bmw = new com.baidu.swan.pms.model.b(PushConstants.ONTIME_NOTIFICATION, "download : network error");
        }
        return this.bmy.bmw.errorNo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [243=4] */
    private boolean a(ResponseBody responseBody, long j) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        boolean z = false;
        try {
            InputStream byteStream = responseBody.byteStream();
            try {
                fileOutputStream = new FileOutputStream(this.bmJ.bmz, false);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                inputStream = byteStream;
            }
            try {
                if (a(byteStream, fileOutputStream, j) && jo(this.bmy.bmx.filePath)) {
                    this.bmy.bmw = new com.baidu.swan.pms.model.b(PushConstants.EXPIRE_NOTIFICATION, "download : package download success");
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
        while (!this.bmA.get() && i != -1) {
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
                this.bmy.bmx.currentSize = j2;
                this.bmJ.RY();
            }
        }
        return j2 == j;
    }

    private boolean jn(String str) {
        File file = new File(str);
        if (!file.exists()) {
            this.bmy.bmw = new com.baidu.swan.pms.model.b(2208, String.format("download file not found:%s", com.baidu.swan.pms.d.c.o("local file save failed:", str)));
            return false;
        } else if (file.length() != this.bmy.bmx.size) {
            this.bmy.bmw = new com.baidu.swan.pms.model.b(PushConstants.DELAY_NOTIFICATION, String.format("download : package MD5 verify failed.", com.baidu.swan.pms.d.c.o(",file length not match:server=", "" + this.bmy.bmx.size, "local=", "" + file.length())));
            return false;
        } else {
            return true;
        }
    }

    private boolean jo(String str) {
        if (jn(str)) {
            String str2 = this.bmy.bmx.md5 != null ? this.bmy.bmx.md5 : null;
            String c = str != null ? com.baidu.swan.pms.d.b.c(new File(str), true) : null;
            if (str2 == null || c == null) {
                this.bmy.bmw = new com.baidu.swan.pms.model.b(2208, String.format("download file not found:%s", com.baidu.swan.pms.d.c.o("server:", str2, ",local", c)));
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(c)) {
                return true;
            }
            this.bmy.bmw = new com.baidu.swan.pms.model.b(PushConstants.DELAY_NOTIFICATION, "download : package MD5 verify failed." + com.baidu.swan.pms.d.c.o("server:", upperCase, ",local", c));
            return false;
        }
        return false;
    }
}
