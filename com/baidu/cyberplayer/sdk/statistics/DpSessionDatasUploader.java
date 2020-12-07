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
/* loaded from: classes17.dex */
public final class DpSessionDatasUploader {
    @Keep
    public static final String SAILOR_MONITOR = "sailor_monitor";

    /* renamed from: a  reason: collision with root package name */
    private static DpSessionDatasUploader f1429a;
    private d b = new d();
    private d c = new d("live_show_session");

    private DpSessionDatasUploader() {
    }

    private void a() {
        if (this.b != null) {
            this.b.a();
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
        } else if (this.b != null) {
            this.b.a(bArr);
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
            if (f1429a == null) {
                f1429a = new DpSessionDatasUploader();
            }
            dpSessionDatasUploader = f1429a;
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
        if (context == null || this.b == null || this.c == null) {
            return;
        }
        this.b.a(context);
        this.c.a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr, String str, boolean z) {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        OutputStream outputStream3 = null;
        outputStream3 = null;
        outputStream3 = null;
        HttpURLConnection httpURLConnection2 = null;
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CyberLog.d("SessionDatasUploader", "sendStatisticsDataToServer called uploadUrl:" + str + " isGzipCompressed:" + z);
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.setRequestMethod("POST");
                    httpURLConnection3.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection3.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
                    if (z) {
                        httpURLConnection3.setRequestProperty("Content-Type", "application/x-gzip");
                    }
                    outputStream2 = httpURLConnection3.getOutputStream();
                } catch (Exception e) {
                    outputStream = null;
                    httpURLConnection2 = httpURLConnection3;
                    e = e;
                }
                try {
                    outputStream2.write(bArr);
                    outputStream2.flush();
                    i = httpURLConnection3.getResponseCode();
                    CyberLog.d("SessionDatasUploader", "upload response : " + i);
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (httpURLConnection3 != null) {
                        try {
                            httpURLConnection3.disconnect();
                        } catch (Exception e3) {
                        }
                    }
                } catch (Exception e4) {
                    outputStream = outputStream2;
                    httpURLConnection2 = httpURLConnection3;
                    e = e4;
                    try {
                        CyberLog.e("SessionDatasUploader", "upload error " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception e6) {
                            }
                        }
                        if (i == 200) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        OutputStream outputStream4 = outputStream;
                        httpURLConnection = httpURLConnection2;
                        outputStream3 = outputStream4;
                        if (outputStream3 != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
            } catch (Error e7) {
                httpURLConnection = httpURLConnection3;
                e = e7;
                try {
                    CyberLog.e("SessionDatasUploader", "upload error " + e);
                    if (0 != 0) {
                        try {
                            outputStream3.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e9) {
                        }
                    }
                    if (i == 200) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream3 != null) {
                        try {
                            outputStream3.close();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e11) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection = httpURLConnection3;
                th = th3;
                if (outputStream3 != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Error e12) {
            e = e12;
            httpURLConnection = null;
        } catch (Exception e13) {
            e = e13;
            outputStream = null;
        } catch (Throwable th4) {
            th = th4;
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
