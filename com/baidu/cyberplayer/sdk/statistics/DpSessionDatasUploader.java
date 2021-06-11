package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.n;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public final class DpSessionDatasUploader {
    @Keep
    public static final String SAILOR_MONITOR = "sailor_monitor";

    /* renamed from: a  reason: collision with root package name */
    public static DpSessionDatasUploader f4986a;

    /* renamed from: b  reason: collision with root package name */
    public d f4987b = new d();

    /* renamed from: c  reason: collision with root package name */
    public d f4988c = new d("live_show_session");

    private void a() {
        d dVar = this.f4987b;
        if (dVar != null) {
            dVar.a();
        }
        d dVar2 = this.f4988c;
        if (dVar2 != null) {
            dVar2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i2) {
        String a2 = a(str2, i2);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue("enable_session_gzip", true);
        byte[] a3 = a(str.getBytes(), cfgBoolValue);
        if (a3 == null && cfgBoolValue) {
            a3 = a(str.getBytes(), false);
            cfgBoolValue = false;
        }
        if (a(n.a(a3), a2, cfgBoolValue)) {
            a();
        } else {
            a(Base64.encode(n.a(a(str.getBytes(), false)), 2), i2);
        }
    }

    private void a(byte[] bArr, int i2) {
        d dVar;
        if (i2 == 24) {
            dVar = this.f4988c;
            if (dVar == null) {
                return;
            }
        } else {
            dVar = this.f4987b;
            if (dVar == null) {
                return;
            }
        }
        dVar.a(bArr);
    }

    public static byte[] a(byte[] bArr, boolean z) {
        if (z) {
            try {
                return n.b(bArr);
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return Base64.encode(bArr, 2);
    }

    @Keep
    public static synchronized DpSessionDatasUploader getInstance() {
        DpSessionDatasUploader dpSessionDatasUploader;
        synchronized (DpSessionDatasUploader.class) {
            if (f4986a == null) {
                f4986a = new DpSessionDatasUploader();
            }
            dpSessionDatasUploader = f4986a;
        }
        return dpSessionDatasUploader;
    }

    public String a(String str, int i2) {
        String e2 = com.baidu.cyberplayer.sdk.c.a().e();
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        String str2 = e2 + str;
        if (i2 == 24) {
            return str2 + "&upload_type=tieba_live";
        }
        return str2;
    }

    public void a(Context context) {
        d dVar;
        if (context == null || (dVar = this.f4987b) == null || this.f4988c == null) {
            return;
        }
        dVar.a(context);
        this.f4988c.a(context);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00de */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0087, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0089, code lost:
        r10.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b4, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d5, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr, String str, boolean z) {
        int i2;
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CyberLog.d("SessionDatasUploader", "sendStatisticsDataToServer called uploadUrl:" + ((String) str) + " isGzipCompressed:" + z);
        OutputStream outputStream = null;
        i2 = -1;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                    if (z) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-gzip");
                    }
                    outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    i2 = httpURLConnection.getResponseCode();
                    CyberLog.d("SessionDatasUploader", "upload response : " + i2);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Error e3) {
                    e = e3;
                    CyberLog.e("SessionDatasUploader", "upload error " + e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    CyberLog.e("SessionDatasUploader", "upload error " + e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
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
        } catch (Error e8) {
            e = e8;
            httpURLConnection = null;
        } catch (Exception e9) {
            e = e9;
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
        return i2 == 200;
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
    public void upload(final String str, final String str2, final int i2) {
        if (com.baidu.cyberplayer.sdk.c.a().b()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.2
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.cyberplayer.sdk.c.a().c() && i2 == 24) {
                        DpSessionDatasUploader.this.a(str, str2, 24);
                    }
                    DpSessionDatasUploader.this.a(str, str2, 1);
                }
            });
        }
    }
}
