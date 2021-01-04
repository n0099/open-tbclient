package com.baidu.cyberplayer.sdk.a;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, long j);

        void a(String str, long j, long j2);

        void a(String str, long j, String str2);

        void b(String str, long j);
    }

    private static long a(String str, OutputStream outputStream, a aVar) throws Exception {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        long currentTimeMillis = System.currentTimeMillis();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("Unable to execute downloads on the UI thread.");
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200 || responseCode == 206) {
                    long contentLength = httpURLConnection.getContentLength();
                    if (contentLength <= 0) {
                        throw new RuntimeException("the file that you start has a wrong size ... ");
                    }
                    if (aVar != null) {
                        aVar.a(str, contentLength);
                    }
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[com.baidu.fsg.base.statistics.b.c];
                        int i = 0;
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            int i2 = i + read;
                            outputStream.write(bArr, 0, read);
                            if (aVar != null) {
                                aVar.a(str, i2, contentLength);
                                i = i2;
                            } else {
                                i = i2;
                            }
                        }
                        CyberLog.d("Downloader", "download finished. use time=" + (System.currentTimeMillis() - currentTimeMillis));
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e) {
                                CyberLog.d("Downloader", "disconnect Exception:" + e.toString());
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return contentLength;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e2) {
                                CyberLog.d("Downloader", "disconnect Exception:" + e2.toString());
                                throw th;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                throw new RuntimeException("url that you conneted has error ...");
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            httpURLConnection = null;
        }
    }

    public static void a(HashMap<String, String> hashMap, final a aVar) {
        final String str = hashMap.get("url");
        String str2 = hashMap.get("file-folder");
        String str3 = hashMap.get("file-name");
        if (str == null || str2 == null || str3 == null) {
            return;
        }
        n.b(str2);
        final String str4 = str2 + File.separator + str3;
        String str5 = hashMap.get("is-asyn");
        if (TextUtils.isEmpty(str5) || !str5.equals("0")) {
            CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.b(str4, str, aVar);
                }
            });
        } else {
            b(str4, str, aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(HashMap<String, String> hashMap) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr;
        String str = hashMap.get("url");
        if (str == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Exception e) {
            byteArrayOutputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            a(str, byteArrayOutputStream, (a) null);
            bArr = byteArrayOutputStream.toByteArray();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                CyberLog.w("Downloader", "download failed. IOException");
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                        bArr = null;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        bArr = null;
                    }
                } else {
                    bArr = null;
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2, a aVar) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            long a2 = a(str2, fileOutputStream, aVar);
            if (aVar != null) {
                aVar.b(str2, a2);
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            if (aVar != null) {
                aVar.a(str2, 0L, e.toString());
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
