package com.baidu.cyberplayer.sdk.downloader;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class Downloader {
    public static final int DEFAULT_CONNECT_TIMEOUT = 8000;
    public static final int DEFAULT_READ_TIMEOUT = 15000;
    public static final int DOWNLOAD_BUF_SIZE = 51200;
    public static final String KEY_IS_ASYN = "is-asyn";
    public static final String KEY_QUERY = "query";
    public static final String KEY_SAVE_FILE_FOLDER = "file-folder";
    public static final String KEY_SAVE_FILE_NAME = "file-name";
    public static final String KEY_URL = "url";
    public static final String TAG = "Downloader";

    /* loaded from: classes3.dex */
    public interface IDownloadListener {
        void onDownloadFail(String str, long j, String str2);

        void onDownloadStart(String str, long j);

        void onDownloadSuccess(String str, long j);

        void onDownloading(String str, long j, long j2);
    }

    public static String addParamToQuery(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            str = str + "?";
        }
        if (str.endsWith("?")) {
            return str + str2;
        }
        return str + "&" + str2;
    }

    public static void startDownload(HashMap<String, String> hashMap, final IDownloadListener iDownloadListener) {
        final String str = hashMap.get("url");
        String str2 = hashMap.get(KEY_SAVE_FILE_FOLDER);
        String str3 = hashMap.get(KEY_SAVE_FILE_NAME);
        if (str != null && str2 != null && str3 != null) {
            Utils.makeSureFolderExists(str2);
            final String str4 = str2 + File.separator + str3;
            String str5 = hashMap.get(KEY_IS_ASYN);
            if (!TextUtils.isEmpty(str5) && str5.equals("0")) {
                downloadFile(str, str4, iDownloadListener);
            } else {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.downloader.Downloader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Downloader.downloadFile(str, str4, iDownloadListener);
                    }
                });
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0060 -> B:37:0x0063). Please submit an issue!!! */
    public static void downloadFile(String str, String str2, IDownloadListener iDownloadListener) {
        FileOutputStream fileOutputStream;
        CyberLog.d(TAG, "download url: " + str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            long downloadInner = downloadInner(str, fileOutputStream, iDownloadListener);
            if (iDownloadListener != null) {
                iDownloadListener.onDownloadSuccess(str, downloadInner);
            }
            fileOutputStream.close();
        } catch (Exception e3) {
            fileOutputStream2 = fileOutputStream;
            e = e3;
            if (iDownloadListener != null) {
                iDownloadListener.onDownloadFail(str, 0L, e.toString());
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static long downloadInner(String str, OutputStream outputStream, IDownloadListener iDownloadListener) throws Exception {
        Throwable th;
        HttpURLConnection httpURLConnection;
        int i;
        byte[] bArr;
        long currentTimeMillis = System.currentTimeMillis();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            InputStream inputStream = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200 && responseCode != 206) {
                        throw new RuntimeException("error responsecode:" + responseCode);
                    }
                    long contentLength = httpURLConnection.getContentLength();
                    if (contentLength > 0) {
                        if (iDownloadListener != null) {
                            iDownloadListener.onDownloadStart(str, contentLength);
                        }
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr2 = new byte[DOWNLOAD_BUF_SIZE];
                            int i2 = 0;
                            int i3 = 0;
                            while (true) {
                                int read = inputStream2.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                int i4 = i3 + read;
                                outputStream.write(bArr2, i2, read);
                                if (iDownloadListener != null) {
                                    i = i4;
                                    bArr = bArr2;
                                    iDownloadListener.onDownloading(str, i4, contentLength);
                                } else {
                                    i = i4;
                                    bArr = bArr2;
                                }
                                bArr2 = bArr;
                                i3 = i;
                                i2 = 0;
                            }
                            CyberLog.d(TAG, "download finished. use time=" + (System.currentTimeMillis() - currentTimeMillis));
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e) {
                                    CyberLog.d(TAG, "disconnect Exception:" + e.toString());
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return contentLength;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e2) {
                                    CyberLog.d(TAG, "disconnect Exception:" + e2.toString());
                                    throw th;
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    throw new RuntimeException("error file_size:" + contentLength);
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
            }
        } else {
            throw new RuntimeException("Unable to execute downloads on the UI thread.");
        }
    }

    public static long startDownload(String str, String str2) throws Exception {
        CyberLog.d(TAG, " downlaodUrl:" + str);
        CyberLog.d(TAG, " saveDirectory:" + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            CyberLog.d(TAG, "download url: " + str);
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    long downloadInner = downloadInner(str, fileOutputStream2, null);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return downloadInner;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return -1L;
        }
    }

    public static byte[] startDownload(HashMap<String, String> hashMap) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str = hashMap.get("url");
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                downloadInner(str, byteArrayOutputStream, null);
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception unused) {
                CyberLog.w(TAG, "download failed. IOException");
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            }
        } catch (Exception unused2) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            throw th;
        }
        return bArr;
    }
}
