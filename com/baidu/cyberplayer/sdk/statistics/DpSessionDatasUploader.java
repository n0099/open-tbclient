package com.baidu.cyberplayer.sdk.statistics;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.k;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public final class DpSessionDatasUploader {
    @Keep
    public static final String SAILOR_MONITOR = "sailor_monitor";
    private static DpSessionDatasUploader a;

    private DpSessionDatasUploader() {
    }

    private static String a() {
        String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
        return TextUtils.isEmpty(cfgValue) ? "https://browserkernel.baidu.com/kw?r_en=true&type=" : cfgValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, boolean z) {
        if (z) {
            try {
                return k.b(bArr);
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
            if (a == null) {
                a = new DpSessionDatasUploader();
            }
            dpSessionDatasUploader = a;
        }
        return dpSessionDatasUploader;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        int i = -1;
        String str2 = a2 + str;
        CyberLog.d("SessionDatasUploader", "sendStatisticsDataToServer called uploadUrl:" + str2 + " isGzipCompressed:" + z);
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str2).openConnection();
            try {
                try {
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.setRequestMethod("POST");
                    httpURLConnection3.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection3.setRequestProperty("Cache-Control", "no-cache");
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
                        } catch (IOException e2) {
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
                            } catch (IOException e5) {
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
                            try {
                                outputStream3.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e8) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Error e9) {
                httpURLConnection = httpURLConnection3;
                e = e9;
                try {
                    CyberLog.e("SessionDatasUploader", "upload error " + e);
                    if (0 != 0) {
                        try {
                            outputStream3.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e11) {
                        }
                    }
                    if (i == 200) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream3 != null) {
                    }
                    if (httpURLConnection != null) {
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
        boolean z = true;
        if ((CyberCfgManager.getInstance().a() || !CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_session_log", true)) ? false : false) {
            CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue("enable_session_gzip", true);
                    CyberLog.d("SessionDatasUploader", "SessionGZip:" + cfgBoolValue);
                    byte[] b = DpSessionDatasUploader.b(str.getBytes(), cfgBoolValue);
                    if (b == null && cfgBoolValue) {
                        b = DpSessionDatasUploader.b(str.getBytes(), false);
                        cfgBoolValue = false;
                    }
                    if (DpSessionDatasUploader.this.a(k.a(b), str2, cfgBoolValue)) {
                        d.a().b();
                        return;
                    }
                    d.a().a(Base64.encode(k.a(DpSessionDatasUploader.b(str.getBytes(), false)), 2));
                }
            });
        }
    }
}
