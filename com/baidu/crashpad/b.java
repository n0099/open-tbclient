package com.baidu.crashpad;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    private static String h;
    String b;
    String c;
    boolean d;
    private static final BigInteger e = new BigInteger("65537");
    static boolean a = true;
    private static String f = "";
    private static boolean g = true;

    /* loaded from: classes11.dex */
    public static class a implements FilenameFilter {
        String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            if (ZeusLogUploader.CRASH_LOG.equals(this.a) || ZeusLogUploader.RECORD_LOG.equals(this.a)) {
                return str.endsWith(".bdmp");
            }
            if (ZeusLogUploader.VIDEO_LOG.equals(this.a)) {
                return str.endsWith(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            }
            if (ZeusLogUploader.NR_LOG.equals(this.a)) {
                return str.endsWith(".nr");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.crashpad.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class RunnableC0104b implements Runnable {
        String[] a;
        c b;
        boolean c;
        int d;
        StringBuffer e;
        String f;
        String g;
        boolean h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RunnableC0104b(String str, String str2, String str3, boolean z, c cVar) {
            this.d = 0;
            this.e = new StringBuffer("");
            this.a = new String[]{str};
            this.c = true;
            this.b = cVar;
            this.f = str2;
            this.g = str3;
            this.h = z;
        }

        RunnableC0104b(b bVar, File[] fileArr, String str, String str2, boolean z) {
            b.this = bVar;
            this.d = 0;
            this.e = new StringBuffer("");
            this.a = new String[fileArr.length];
            for (int i = 0; i < fileArr.length; i++) {
                this.a[i] = fileArr[i].getPath();
            }
            this.c = true;
            this.b = null;
            this.f = str;
            this.g = str2;
            this.h = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x00a9 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            String[] strArr;
            FileInputStream fileInputStream;
            Exception e;
            boolean z;
            byte[] bArr;
            int i;
            for (String str : this.a) {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        int available = fileInputStream.available();
                        if (this.g == null || this.f.equals(ZeusLogUploader.CRASH_LOG)) {
                            bArr = new byte[available];
                            i = 0;
                        } else {
                            i = this.g.getBytes().length;
                            bArr = new byte[available + i];
                            System.arraycopy(this.g.getBytes(), 0, bArr, 0, this.g.getBytes().length);
                        }
                        do {
                            i += fileInputStream.read(bArr, i, available);
                            available = fileInputStream.available();
                        } while (available > 0);
                        z = b.a(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        z = false;
                    }
                } catch (Exception e3) {
                    fileInputStream = null;
                    e = e3;
                    z = false;
                }
                try {
                    if (this.f.equals(ZeusLogUploader.CRASH_LOG) && z && (bArr = b.a(bArr, bArr.length - 12, false)) == null) {
                        this.d = 8;
                    }
                    byte[] a = b.a(bArr, bArr.length, this.e);
                    if (a == null) {
                        this.d = 1;
                    } else if (!b.a(a, this.f, this.h, str, this.e)) {
                        this.d = 3;
                    } else if (this.c && !b.a(str, this.e)) {
                        this.d = 4;
                    }
                    fileInputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    this.d = 5;
                    com.a.a.a.a.a.a.a.a(e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            com.a.a.a.a.a.a.a.a(e5);
                        }
                    }
                    if (b.g) {
                        this.d = 2;
                    }
                    if (this.b == null) {
                    }
                }
                if (b.g && this.d != 0 && this.f.equals(ZeusLogUploader.CRASH_LOG) && !z && b.c(str) != 6) {
                    this.d = 2;
                }
                if (this.b == null) {
                    this.b.onFinished(str, this.d, this.e.toString());
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void onFinished(String str, int i, String str2);
    }

    public b(String str, boolean z) {
        this.c = str;
        this.d = z;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("CUID").put((Object) null);
        try {
            jSONObject.put("CUID", jSONArray);
        } catch (JSONException e2) {
            com.a.a.a.a.a.a.a.a(e2);
        }
        this.b = jSONObject.toString();
    }

    public static void a(String str) {
        f = str;
    }

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a(String str, String str2) {
        File[] listFiles;
        b bVar = new b(str2, true);
        if (!a || str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles(new a(bVar.c))) == null || listFiles.length == 0) {
            return false;
        }
        Thread thread = new Thread(new RunnableC0104b(bVar, listFiles, bVar.c, bVar.b, bVar.d));
        thread.setName("T7@ZeusLogDir1");
        thread.start();
        return true;
    }

    static boolean a(String str, StringBuffer stringBuffer) {
        if (str == null || str.isEmpty()) {
            stringBuffer.append("Failed to remove empty file:" + str);
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.delete()) {
            Log.i("ZeusLogUploader CRASHPAD", "CRASHPAD  dodelete sucess return true ");
            return true;
        }
        stringBuffer.append("Failed to remove file:" + file.getName());
        return false;
    }

    static /* synthetic */ boolean a(byte[] bArr) {
        return 12 < bArr.length && ZeusLogUploader.ADD_UPLOAD_FILE_FLAG.equals(new String(bArr, bArr.length + (-12), 12));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x020c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x008c */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x010a: ARRAY_LENGTH  (r8v4 int A[REMOVE]) = (r11v0 byte[]))] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v24, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.OutputStream] */
    static boolean a(byte[] bArr, String str, boolean z, String str2, StringBuffer stringBuffer) {
        String str3;
        HttpsURLConnection httpsURLConnection;
        ?? r3;
        boolean z2;
        HttpsURLConnection httpsURLConnection2 = null;
        r4 = 0;
        ?? r4 = 0;
        httpsURLConnection2 = null;
        httpsURLConnection2 = null;
        httpsURLConnection2 = null;
        String substring = str2.substring(str2.lastIndexOf(47) + 1);
        if (bArr == null || substring == null || substring.isEmpty()) {
            if (bArr == null) {
                stringBuffer.append("doUpload Failed, data is null");
            } else if (substring == null) {
                stringBuffer.append("doUpload Failed, filename is null");
            } else if (substring.isEmpty()) {
                stringBuffer.append("doUpload Failed, filename is empty");
            }
            return false;
        }
        str3 = "https://browserkernel.baidu.com/kw?type=engine";
        if (ZwDebugExtra.debugModel()) {
            try {
                if (!f.isEmpty()) {
                    File file = new File(f + "log_server.txt");
                    if (file.exists()) {
                        Log.v("ZeusLogUploader CRASHPAD", "zeusloguploader.java we have log_server.txt");
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        String readLine = bufferedReader.readLine();
                        str3 = readLine != null ? readLine : "https://browserkernel.baidu.com/kw?type=engine";
                        bufferedReader.close();
                    } else {
                        Log.v("ZeusLogUploader CRASHPAD", "no local server url ");
                    }
                }
            } catch (Exception e2) {
                com.a.a.a.a.a.a.a.a(e2);
            }
        }
        byte[] bArr2 = new byte[4096];
        try {
            if (z) {
                URL url = new URL(str3);
                try {
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIICZTCCAc4CAQAwDQYJKoZIhvcNAQEEBQAwezELMAkGA1UEBhMCQ04xCzAJBgNV\nBAgTAkJKMQswCQYDVQQHEwJCSjELMAkGA1UEChMCQkQxCzAJBgNVBAsTAkJEMRYw\nFAYDVQQDEw13d3cuYmFpZHUuY29tMSAwHgYJKoZIhvcNAQkBFhFsaWJpbjAyQGJh\naWR1LmNvbTAeFw0xMjA1MTAwMjMzNTVaFw0xMjA2MDkwMjMzNTVaMHsxCzAJBgNV\nBAYTAkNOMQswCQYDVQQIEwJCSjELMAkGA1UEBxMCQkoxCzAJBgNVBAoTAkJEMQsw\nCQYDVQQLEwJCRDEWMBQGA1UEAxMNd3d3LmJhaWR1LmNvbTEgMB4GCSqGSIb3DQEJ\nARYRbGliaW4wMkBiYWlkdS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGB\nALckGzvn6jcMqYpXrZKuuCYlVJIgN2ETsnvjCtO1va5u3p0EL9CuR5BlHocJadzM\nhTI7rH/nao8mXRIcJ4Q6lOv5TAotcKUv7ri9YZ48smpE3+KXVB+Mjau05OfiYI2h\nqlYy56acRSgyp8Uj65PXL8+gae8Gx+6lq0XOKduolmmNAgMBAAEwDQYJKoZIhvcN\nAQEEBQADgYEAYGPEvv1fc4XySq+9+5jFi4TxlNy9vAWpHOjsmODM9gs5/9PQFG/c\nZc8Fz+T9IVRa8YI0mLuKlApGmvzHxwdWbtBU6AU8ifg1HBA/4VXweiq6fgRfaemd\njgW3PXjbd+OoZ0VI32TvrDErG83OYohQ5CAS2gKHfBXHJvKtmxUSdVE=\n-----END CERTIFICATE-----\n".getBytes()));
                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    keyStore.load(null, null);
                    keyStore.setCertificateEntry("ca", generateCertificate);
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init(keyStore);
                    SSLContext.getInstance("TLS").init(null, trustManagerFactory.getTrustManagers(), null);
                    HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) url.openConnection();
                    try {
                        try {
                            httpsURLConnection3.setDoInput(true);
                            httpsURLConnection3.setDoOutput(true);
                            httpsURLConnection3.setUseCaches(false);
                            httpsURLConnection3.setRequestMethod("POST");
                            httpsURLConnection3.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                            httpsURLConnection3.setRequestProperty("Content-Type", "application/x-gzip");
                            httpsURLConnection3.setRequestProperty("Content-Length", new StringBuilder().append(bArr.length).toString());
                            httpsURLConnection3.setRequestProperty("Content-Disposition", "attchment;filename=" + substring);
                            httpsURLConnection3.setRequestProperty("LogType", str);
                            httpsURLConnection3.setFixedLengthStreamingMode(bArr.length);
                            httpsURLConnection3.connect();
                            r3 = new ByteArrayInputStream(bArr);
                        } catch (Exception e3) {
                            r3 = null;
                            e = e3;
                            httpsURLConnection = httpsURLConnection3;
                        }
                        try {
                            OutputStream outputStream = httpsURLConnection3.getOutputStream();
                            while (true) {
                                int read = r3.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                outputStream.write(bArr2, 0, read);
                            }
                            r3.close();
                            outputStream.flush();
                            outputStream.close();
                            int responseCode = httpsURLConnection3.getResponseCode();
                            Log.i("ZeusLogUploader CRASHPAD", "CRASHPAD finish send the reqeust , responseCode = " + responseCode + ",  mUploadCrashLogFailedEncrypt=" + g);
                            if (responseCode == 200) {
                                stringBuffer.append("Upload Success; The server has responed 200 . ");
                                httpsURLConnection3.disconnect();
                                z2 = true;
                                httpsURLConnection2 = outputStream;
                            } else {
                                stringBuffer.append("doUpload Failed, The server has responsed Code " + responseCode);
                                httpsURLConnection3.disconnect();
                                z2 = false;
                                httpsURLConnection2 = outputStream;
                            }
                        } catch (Exception e4) {
                            httpsURLConnection = httpsURLConnection3;
                            e = e4;
                            try {
                                stringBuffer.append(e.getMessage());
                                com.a.a.a.a.a.a.a.a(e);
                                if (r3 != null) {
                                    try {
                                        r3.close();
                                    } catch (Exception e5) {
                                        Log.d("ZeusLogUploader CRASHPAD", "failed http.");
                                        httpsURLConnection.disconnect();
                                        return false;
                                    }
                                }
                                if (r4 != 0) {
                                    r4.close();
                                }
                                Log.d("ZeusLogUploader CRASHPAD", "failed http.");
                                httpsURLConnection.disconnect();
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                httpsURLConnection2 = httpsURLConnection;
                                httpsURLConnection2.disconnect();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        httpsURLConnection2 = httpsURLConnection3;
                        th = th2;
                        httpsURLConnection2.disconnect();
                        throw th;
                    }
                } catch (Throwable th3) {
                    com.a.a.a.a.a.a.a.a(th3);
                    stringBuffer.append("Upload Failed; " + th3.getMessage());
                    httpsURLConnection2.disconnect();
                    z2 = false;
                }
            } else {
                stringBuffer.append("doUpload Failed, HTTP is never supported!");
                httpsURLConnection2.disconnect();
                z2 = false;
            }
            return z2;
        } catch (Exception e6) {
            e = e6;
            httpsURLConnection = httpsURLConnection2;
            r3 = httpsURLConnection2;
            r4 = httpsURLConnection2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    static byte[] a(byte[] bArr, int i, StringBuffer stringBuffer) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null || i <= 0) {
            stringBuffer.append("doCompress Failed, source is null; ");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[4096];
        try {
            if (i > bArr.length) {
                i = bArr.length;
            }
            byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i);
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                while (true) {
                    try {
                        int read = byteArrayInputStream.read(bArr2);
                        if (read == -1) {
                            byteArrayInputStream.close();
                            gZIPOutputStream.close();
                            return byteArrayOutputStream.toByteArray();
                        }
                        gZIPOutputStream.write(bArr2, 0, read);
                    } catch (Exception e2) {
                        e = e2;
                        com.a.a.a.a.a.a.a.a(e);
                        stringBuffer.append(e.getMessage());
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e3) {
                                com.a.a.a.a.a.a.a.a(e3);
                                return null;
                            }
                        }
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                            return null;
                        }
                        return null;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                gZIPOutputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            gZIPOutputStream = null;
            byteArrayInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] a(byte[] bArr, int i, boolean z) {
        byte[] bArr2 = null;
        if (bArr != null && bArr.length > 0 && i > 0 && h != null) {
            if (i > bArr.length) {
                i = bArr.length;
            }
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr, 0, bArr3, 0, i);
            com.baidu.crashpad.a aVar = new com.baidu.crashpad.a(h);
            if (z) {
                aVar.a();
                bArr2 = new byte[bArr3.length];
                aVar.a(bArr3, bArr3.length, bArr2);
            } else {
                aVar.a();
                bArr2 = new byte[bArr3.length];
                aVar.a(bArr3, bArr3.length, bArr2);
            }
            Log.i("ZeusLogUploader CRASHPAD", z ? "encrypt" : "decrypt upload file run time:  (ms)" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return bArr2;
    }

    public static void b(String str) {
        h = str;
    }

    public static void b(boolean z) {
        g = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[Catch: Exception -> 0x0088, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x0088, blocks: (B:19:0x003a, B:38:0x0068), top: B:81:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(String str) {
        DataInputStream dataInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        DataInputStream dataInputStream2;
        byte[] a2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        FileOutputStream fileOutputStream = null;
        byteArrayOutputStream2 = null;
        int i = 6;
        File file = new File(str);
        if (file.exists()) {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(file));
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Exception e2) {
                                    i = 5;
                                }
                            }
                        }
                        byteArrayOutputStream.close();
                        try {
                            dataInputStream.close();
                        } catch (Exception e3) {
                            i = 5;
                        }
                    } catch (Exception e4) {
                        dataInputStream2 = dataInputStream;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (dataInputStream2 != null) {
                            try {
                                dataInputStream2.close();
                                i = 5;
                            } catch (Exception e6) {
                                i = 5;
                            }
                        } else {
                            i = 5;
                        }
                        a2 = a(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, true);
                        if (a2 != null) {
                        }
                    } catch (Throwable th) {
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        th = th;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e7) {
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e8) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    byteArrayOutputStream = null;
                    dataInputStream2 = dataInputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e10) {
                byteArrayOutputStream = null;
                dataInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
            }
        } else {
            byteArrayOutputStream = null;
        }
        try {
            a2 = a(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, true);
            if (a2 != null) {
                return 5;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str), false);
            try {
                fileOutputStream2.write(a2);
                fileOutputStream2.write(ZeusLogUploader.ADD_UPLOAD_FILE_FLAG.getBytes());
                fileOutputStream2.flush();
                fileOutputStream2.close();
                return i;
            } catch (Exception e11) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return 5;
                    } catch (IOException e12) {
                        com.a.a.a.a.a.a.a.a(e12);
                        return 5;
                    }
                }
                return 5;
            }
        } catch (Exception e13) {
        }
    }
}
