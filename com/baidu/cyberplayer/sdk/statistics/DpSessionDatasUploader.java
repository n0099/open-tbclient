package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.o;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class DpSessionDatasUploader {
    @Keep
    public static final String SAILOR_MONITOR = "sailor_monitor";
    public static volatile DpSessionDatasUploader a;
    public d b = new d();
    public d c = new d("live_show_session");

    private void a() {
        d dVar = this.b;
        if (dVar != null) {
            dVar.a();
        }
        d dVar2 = this.c;
        if (dVar2 != null) {
            dVar2.a();
        }
    }

    @Keep
    public static DpSessionDatasUploader getInstance() {
        if (a == null) {
            synchronized (DpSessionDatasUploader.class) {
                if (a == null) {
                    a = new DpSessionDatasUploader();
                }
            }
        }
        return a;
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
        if (!a(o.a(a3), a2, cfgBoolValue)) {
            a(Base64.encode(o.a(a(str.getBytes(), false)), 2), i);
        } else {
            a();
        }
    }

    private void a(byte[] bArr, int i) {
        if (i == 24) {
            d dVar = this.c;
            if (dVar != null) {
                dVar.a(bArr);
                return;
            }
            return;
        }
        d dVar2 = this.b;
        if (dVar2 != null) {
            dVar2.a(bArr);
        }
    }

    @Keep
    public void upload(final String str, final String str2) {
        if (com.baidu.cyberplayer.sdk.e.a().b()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.1
                @Override // java.lang.Runnable
                public void run() {
                    DpSessionDatasUploader.this.a(str, str2, 1);
                }
            });
        }
    }

    @Keep
    public void uploadLibInitSession(final String str, final String str2) {
        if (com.baidu.cyberplayer.sdk.e.a().c()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.2
                @Override // java.lang.Runnable
                public void run() {
                    DpSessionDatasUploader.this.a(str, str2, 1);
                }
            });
        }
    }

    public static byte[] a(byte[] bArr, boolean z) {
        if (z) {
            try {
                return o.b(bArr);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return Base64.encode(bArr, 2);
    }

    public String a(String str, int i) {
        String f = com.baidu.cyberplayer.sdk.e.a().f();
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        String str2 = f + str;
        if (i == 24) {
            return str2 + "&upload_type=tieba_live";
        }
        return str2;
    }

    public void a(Context context) {
        d dVar;
        if (context != null && (dVar = this.b) != null && this.c != null) {
            dVar.a(context);
            this.c.a(context);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00dd */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0086, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0088, code lost:
        r10.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr, String str, boolean z) {
        int i;
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CyberLog.d("SessionDatasUploader", "sendStatisticsDataToServer called uploadUrl:" + ((String) str) + " isGzipCompressed:" + z);
        OutputStream outputStream = null;
        i = -1;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
                    if (z) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-gzip");
                    }
                    outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    i = httpURLConnection.getResponseCode();
                    CyberLog.d("SessionDatasUploader", "upload response : " + i);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Error e2) {
                    e = e2;
                    CyberLog.e("SessionDatasUploader", "upload error " + e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    CyberLog.e("SessionDatasUploader", "upload error " + e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (str != 0) {
                    try {
                        str.disconnect();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Error e7) {
            e = e7;
            httpURLConnection = null;
        } catch (Exception e8) {
            e = e8;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            str = 0;
            if (0 != 0) {
            }
            if (str != 0) {
            }
            throw th;
        }
        if (i != 200) {
            return false;
        }
        return true;
    }

    @Keep
    public void upload(final String str, final String str2, final int i) {
        if (com.baidu.cyberplayer.sdk.e.a().b()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!com.baidu.cyberplayer.sdk.e.a().d() || i != 24) {
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
