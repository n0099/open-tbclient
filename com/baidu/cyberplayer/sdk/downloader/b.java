package com.baidu.cyberplayer.sdk.downloader;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.q;
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
public class b {

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, long j);

        void a(String str, long j, long j2);

        void a(String str, long j, String str2);

        void b(String str, long j);
    }

    public static long a(String str, OutputStream outputStream, a aVar) throws Exception {
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
                        if (aVar != null) {
                            aVar.a(str, contentLength);
                        }
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr2 = new byte[51200];
                            int i2 = 0;
                            int i3 = 0;
                            while (true) {
                                int read = inputStream2.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                int i4 = i3 + read;
                                outputStream.write(bArr2, i2, read);
                                if (aVar != null) {
                                    i = i4;
                                    bArr = bArr2;
                                    aVar.a(str, i4, contentLength);
                                } else {
                                    i = i4;
                                    bArr = bArr2;
                                }
                                bArr2 = bArr;
                                i3 = i;
                                i2 = 0;
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
                        } catch (Throwable th2) {
                            th = th2;
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

    public static String a(String str, String str2) {
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

    public static void a(HashMap<String, String> hashMap, final a aVar) {
        final String str = hashMap.get("url");
        String str2 = hashMap.get("file-folder");
        String str3 = hashMap.get("file-name");
        if (str != null && str2 != null && str3 != null) {
            q.b(str2);
            final String str4 = str2 + File.separator + str3;
            String str5 = hashMap.get("is-asyn");
            if (!TextUtils.isEmpty(str5) && str5.equals("0")) {
                b(str, str4, aVar);
            } else {
                CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.downloader.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.b(str, str4, aVar);
                    }
                });
            }
        }
    }

    public static byte[] a(HashMap<String, String> hashMap) {
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
                a(str, byteArrayOutputStream, (a) null);
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception unused) {
                CyberLog.w("Downloader", "download failed. IOException");
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

    public static long b(String str, String str2) throws Exception {
        CyberLog.d("Downloader", " downlaodUrl:" + str);
        CyberLog.d("Downloader", " saveDirectory:" + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            CyberLog.d("Downloader", "download url: " + str);
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    long a2 = a(str, fileOutputStream2, (a) null);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return a2;
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0060 -> B:37:0x0063). Please submit an issue!!! */
    public static void b(String str, String str2, a aVar) {
        FileOutputStream fileOutputStream;
        CyberLog.d("Downloader", "download url: " + str);
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
            long a2 = a(str, fileOutputStream, aVar);
            if (aVar != null) {
                aVar.b(str, a2);
            }
            fileOutputStream.close();
        } catch (Exception e3) {
            fileOutputStream2 = fileOutputStream;
            e = e3;
            if (aVar != null) {
                aVar.a(str, 0L, e.toString());
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
}
