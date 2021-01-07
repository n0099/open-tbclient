package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.m;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class DpSessionDatasUploader {
    @Keep
    public static final String SAILOR_MONITOR = "sailor_monitor";

    /* renamed from: a  reason: collision with root package name */
    private static DpSessionDatasUploader f1876a;

    /* renamed from: b  reason: collision with root package name */
    private d f1877b = new d();
    private d c = new d("live_show_session");

    private DpSessionDatasUploader() {
    }

    private void a() {
        if (this.f1877b != null) {
            this.f1877b.a();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i) {
        String a2 = a(str2, i);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue("enable_session_gzip", true);
        byte[] a3 = a(str.getBytes(), cfgBoolValue);
        if (a3 == null && cfgBoolValue) {
            a3 = a(str.getBytes(), false);
            cfgBoolValue = false;
        }
        if (a(m.a(a3), a2, cfgBoolValue)) {
            a();
        } else {
            a(Base64.encode(m.a(a(str.getBytes(), false)), 2), i);
        }
    }

    private void a(byte[] bArr, int i) {
        if (i == 24) {
            if (this.c != null) {
                this.c.a(bArr);
            }
        } else if (this.f1877b != null) {
            this.f1877b.a(bArr);
        }
    }

    private static byte[] a(byte[] bArr, boolean z) {
        if (z) {
            try {
                return m.b(bArr);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return Base64.encode(bArr, 2);
    }

    @Keep
    public static synchronized DpSessionDatasUploader getInstance() {
        DpSessionDatasUploader dpSessionDatasUploader;
        synchronized (DpSessionDatasUploader.class) {
            if (f1876a == null) {
                f1876a = new DpSessionDatasUploader();
            }
            dpSessionDatasUploader = f1876a;
        }
        return dpSessionDatasUploader;
    }

    public String a(String str, int i) {
        String c = com.baidu.cyberplayer.sdk.c.a().c();
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        String str2 = c + str;
        return i == 24 ? str2 + "&upload_type=tieba_live" : str2;
    }

    public void a(Context context) {
        if (context == null || this.f1877b == null || this.c == null) {
            return;
        }
        this.f1877b.a(context);
        this.c.a(context);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00cc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x0031 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011d  */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr, String str, boolean z) {
        Throwable th;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        Exception e;
        Error e2;
        OutputStream outputStream2;
        int responseCode;
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        OutputStream outputStream3 = " isGzipCompressed:";
        CyberLog.d("SessionDatasUploader", "sendStatisticsDataToServer called uploadUrl:" + str + " isGzipCompressed:" + z);
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection2.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
                    if (z) {
                        httpURLConnection2.setRequestProperty("Content-Type", "application/x-gzip");
                    }
                    outputStream2 = httpURLConnection2.getOutputStream();
                    try {
                        try {
                            outputStream2.write(bArr);
                            outputStream2.flush();
                            responseCode = httpURLConnection2.getResponseCode();
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            outputStream = outputStream2;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (Error e5) {
                        e2 = e5;
                        httpURLConnection = httpURLConnection2;
                        outputStream3 = outputStream2;
                    } catch (Exception e6) {
                        e = e6;
                        httpURLConnection = httpURLConnection2;
                        outputStream3 = outputStream2;
                    }
                } catch (Error e7) {
                    e2 = e7;
                    outputStream3 = 0;
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e8) {
                    e = e8;
                    outputStream3 = null;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                }
                try {
                    CyberLog.d("SessionDatasUploader", "upload response : " + responseCode);
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                            i = responseCode;
                        } catch (Exception e10) {
                            i = responseCode;
                        }
                    } else {
                        i = responseCode;
                    }
                } catch (Error e11) {
                    e2 = e11;
                    httpURLConnection = httpURLConnection2;
                    i = responseCode;
                    outputStream3 = outputStream2;
                    CyberLog.e("SessionDatasUploader", "upload error " + e2);
                    if (outputStream3 != 0) {
                        try {
                            outputStream3.close();
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e13) {
                        }
                    }
                    if (i == 200) {
                    }
                } catch (Exception e14) {
                    e = e14;
                    httpURLConnection = httpURLConnection2;
                    i = responseCode;
                    outputStream3 = outputStream2;
                    CyberLog.e("SessionDatasUploader", "upload error " + e);
                    if (outputStream3 != null) {
                        try {
                            outputStream3.close();
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e16) {
                        }
                    }
                    if (i == 200) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream = outputStream3;
            }
        } catch (Error e17) {
            e2 = e17;
            outputStream3 = 0;
            httpURLConnection = null;
        } catch (Exception e18) {
            e = e18;
            outputStream3 = null;
            httpURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            httpURLConnection = null;
        }
        return i == 200;
    }

    @Keep
    public void upload(final String str, final String str2) {
        if (com.baidu.cyberplayer.sdk.c.a().b()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.1
                @Override // java.lang.Runnable
                public void run() {
                    DpSessionDatasUploader.this.a(str, str2, 1);
                }
            });
        }
    }

    @Keep
    public void upload(final String str, final String str2, final int i) {
        if (com.baidu.cyberplayer.sdk.c.a().b()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i != 24) {
                        DpSessionDatasUploader.this.a(str, str2, 1);
                        return;
                    }
                    DpSessionDatasUploader.this.a(str, str2, 24);
                    DpSessionDatasUploader.this.a(str, str2, 1);
                }
            });
        }
    }
}
