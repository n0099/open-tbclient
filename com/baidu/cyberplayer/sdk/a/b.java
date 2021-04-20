package com.baidu.cyberplayer.sdk.a;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.n;
import com.baidu.mobads.container.components.downloader.OAdRemoteApkDownloader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
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
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("Unable to execute downloads on the UI thread.");
        }
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
                    throw new RuntimeException("url that you conneted has error ...");
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
                        CyberLog.d(OAdRemoteApkDownloader.TAG, "download finished. use time=" + (System.currentTimeMillis() - currentTimeMillis));
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e2) {
                                CyberLog.d(OAdRemoteApkDownloader.TAG, "disconnect Exception:" + e2.toString());
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
                            } catch (Exception e3) {
                                CyberLog.d(OAdRemoteApkDownloader.TAG, "disconnect Exception:" + e3.toString());
                                throw th;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                throw new RuntimeException("the file that you start has a wrong size ... ");
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
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
        } catch (IOException e2) {
            e2.printStackTrace();
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
                CyberLog.w(OAdRemoteApkDownloader.TAG, "download failed. IOException");
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
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
        return bArr;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x004b -> B:35:0x004e). Please submit an issue!!! */
    public static void b(String str, String str2, a aVar) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            long a2 = a(str2, fileOutputStream, aVar);
            if (aVar != null) {
                aVar.b(str2, a2);
            }
            fileOutputStream.close();
        } catch (Exception e4) {
            fileOutputStream2 = fileOutputStream;
            e = e4;
            if (aVar != null) {
                aVar.a(str2, 0L, e.toString());
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            fileOutputStream2 = fileOutputStream;
            th = th2;
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
