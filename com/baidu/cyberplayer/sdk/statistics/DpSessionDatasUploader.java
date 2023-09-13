package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberGlobalSetting;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.RC4;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class DpSessionDatasUploader {
    public static final int MAX_FILE_LENGTH = 10485760;
    public static final int PLAY_SESSION_STAGE_TYPE_LIVE_SHOW = 24;
    public static final int PLAY_SESSION_STAGE_TYPE_NORMAL = 1;
    @Keep
    public static final String SAILOR_MONITOR = "sailor_monitor";
    public static final String T7_INIT = "t7_init";
    public static final String TAG = "SessionDatasUploader";
    public static final String UPLOAD_TYPE_LIVE_SHOW_STR = "&upload_type=tieba_live";
    public static volatile DpSessionDatasUploader sInstance;
    public DpStatFileWriter mPlaySessionFileWriter = new DpStatFileWriter();
    public DpStatFileWriter mLiveSessionFileWriter = new DpStatFileWriter(DpStatFileWriter.PLAY_VIDEO_LIVE_SHOW_SESSION);

    private void checkAndUploadLogFile() {
        DpStatFileWriter dpStatFileWriter = this.mPlaySessionFileWriter;
        if (dpStatFileWriter != null) {
            dpStatFileWriter.checkAndUploadLogFile();
        }
        DpStatFileWriter dpStatFileWriter2 = this.mLiveSessionFileWriter;
        if (dpStatFileWriter2 != null) {
            dpStatFileWriter2.checkAndUploadLogFile();
        }
    }

    @Keep
    public static DpSessionDatasUploader getInstance() {
        if (sInstance == null) {
            synchronized (DpSessionDatasUploader.class) {
                if (sInstance == null) {
                    sInstance = new DpSessionDatasUploader();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpload(String str, String str2, int i) {
        String uploadUrl = getUploadUrl(str2, i);
        if (TextUtils.isEmpty(uploadUrl)) {
            return;
        }
        boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SESSION_GZIP, true);
        byte[] encodeUpdataDatas = encodeUpdataDatas(str.getBytes(), cfgBoolValue);
        if (encodeUpdataDatas == null && cfgBoolValue) {
            encodeUpdataDatas = encodeUpdataDatas(str.getBytes(), false);
            cfgBoolValue = false;
        }
        if (!sendStatisticsDataToServer(RC4.kernelEncrypt(encodeUpdataDatas), uploadUrl, cfgBoolValue)) {
            writeStatisticsDataToFile(Base64.encode(RC4.kernelEncrypt(encodeUpdataDatas(str.getBytes(), false)), 2), i);
        } else {
            checkAndUploadLogFile();
        }
    }

    public static byte[] encodeUpdataDatas(byte[] bArr, boolean z) {
        if (z) {
            try {
                return RC4.kernelGzipCompress(bArr);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return Base64.encode(bArr, 2);
    }

    private void writeStatisticsDataToFile(byte[] bArr, int i) {
        if (i == 24) {
            DpStatFileWriter dpStatFileWriter = this.mLiveSessionFileWriter;
            if (dpStatFileWriter != null) {
                dpStatFileWriter.writeStatisticsDataToFile(bArr);
                return;
            }
            return;
        }
        DpStatFileWriter dpStatFileWriter2 = this.mPlaySessionFileWriter;
        if (dpStatFileWriter2 != null) {
            dpStatFileWriter2.writeStatisticsDataToFile(bArr);
        }
    }

    @Keep
    public void upload(final String str, final String str2) {
        if (CyberGlobalSetting.getInstance().isStatisticsUploadEnable()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.1
                @Override // java.lang.Runnable
                public void run() {
                    DpSessionDatasUploader.this.doUpload(str, str2, 1);
                }
            });
        }
    }

    @Keep
    public void uploadLibInitSession(final String str, final String str2) {
        if (CyberGlobalSetting.getInstance().isLibInitSessionUploadEnable()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.2
                @Override // java.lang.Runnable
                public void run() {
                    DpSessionDatasUploader.this.doUpload(str, str2, 1);
                }
            });
        }
    }

    public String getUploadUrl(String str, int i) {
        String statisticsUploadServerUrl = CyberGlobalSetting.getInstance().getStatisticsUploadServerUrl();
        if (TextUtils.isEmpty(statisticsUploadServerUrl)) {
            return null;
        }
        String str2 = statisticsUploadServerUrl + str;
        if (i == 24) {
            return str2 + UPLOAD_TYPE_LIVE_SHOW_STR;
        }
        return str2;
    }

    public void init(Context context) {
        DpStatFileWriter dpStatFileWriter;
        if (context != null && (dpStatFileWriter = this.mPlaySessionFileWriter) != null && this.mLiveSessionFileWriter != null) {
            dpStatFileWriter.init(context);
            this.mLiveSessionFileWriter.init(context);
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
    public boolean sendStatisticsDataToServer(byte[] bArr, String str, boolean z) {
        int i;
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CyberLog.d(TAG, "sendStatisticsDataToServer called uploadUrl:" + ((String) str) + " isGzipCompressed:" + z);
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
                    CyberLog.d(TAG, "upload response : " + i);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Error e2) {
                    e = e2;
                    CyberLog.e(TAG, "upload error " + e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    CyberLog.e(TAG, "upload error " + e);
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
        if (CyberGlobalSetting.getInstance().isStatisticsUploadEnable()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!CyberGlobalSetting.getInstance().isLiveUploadDoubleEnable() || i != 24) {
                        DpSessionDatasUploader.this.doUpload(str, str2, 1);
                        return;
                    }
                    DpSessionDatasUploader.this.doUpload(str, str2, 24);
                    DpSessionDatasUploader.this.doUpload(str, str2, 1);
                }
            });
        }
    }
}
