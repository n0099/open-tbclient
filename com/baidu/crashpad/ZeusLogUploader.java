package com.baidu.crashpad;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
/* loaded from: classes3.dex */
public final class ZeusLogUploader {
    public static final String ADD_UPLOAD_FILE_FLAG = "uploadfailed";
    private static final int BUFF_SIZE = 4096;
    private static final String CRASH_IMEI = "imei";
    private static final String CRASH_IS_NATIVE = "is_native";
    public static final String CRASH_LOG = "crashlog";
    private static final String CRASH_SIGNAL = "signal";
    private static final String CRASH_TIME = "time_crash";
    public static final String NR_LOG = "nrlog";
    public static final String RECORD_LOG = "recordlog";
    private static final String TAG = "ZeusLogUploader CRASHPAD";
    public static final int UploadStatus_CompressFailed = 1;
    public static final int UploadStatus_DecryptFailed = 8;
    public static final int UploadStatus_DecryptSuccess = 7;
    public static final int UploadStatus_DeletedFailed = 4;
    public static final int UploadStatus_EncryptFailed = 2;
    public static final int UploadStatus_EncryptSuccess = 6;
    public static final int UploadStatus_ExceptionHappended = 5;
    public static final int UploadStatus_Success = 0;
    public static final int UploadStatus_UploadFailed = 3;
    public static final String VIDEO_LOG = "videolog";
    private static String mEncryptKey;
    private String mCuid;
    private String mType;
    private boolean mUseHttps;
    private static final BigInteger exponent = new BigInteger("65537");
    private static boolean sIsEnabled = true;
    private static String sSDCardDir = "";
    private static boolean mUploadCrashLogFailedEncrypt = true;

    /* loaded from: classes3.dex */
    public interface OnFinishedListener {
        void onFinished(String str, int i, String str2);
    }

    public static void setEnabled(boolean z) {
        sIsEnabled = z;
    }

    public static void setBDSdcradDir(String str) {
        sSDCardDir = str;
    }

    /* loaded from: classes3.dex */
    public static class LogFilter implements FilenameFilter {
        String mLogType;

        LogFilter(String str) {
            this.mLogType = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if ("crashlog".equals(this.mLogType) || "recordlog".equals(this.mLogType)) {
                return str.endsWith(".bdmp");
            }
            if ("videolog".equals(this.mLogType)) {
                return str.endsWith(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            }
            if ("nrlog".equals(this.mLogType)) {
                return str.endsWith(".nr");
            }
            return false;
        }
    }

    public ZeusLogUploader(String str, String str2, boolean z) {
        this.mType = str;
        this.mUseHttps = z;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("CUID").put(str2);
        try {
            jSONObject.put("CUID", jSONArray);
        } catch (JSONException e) {
            Log.e(TAG, "", e);
        }
        this.mCuid = jSONObject.toString();
    }

    public boolean uploadLogFile(String str, boolean z, OnFinishedListener onFinishedListener) {
        if (!sIsEnabled || str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(str);
        if (file == null || !file.exists()) {
            return false;
        }
        Thread thread = new Thread(new MyRunner(str, this.mType, this.mCuid, this.mUseHttps, z, onFinishedListener));
        if (thread == null) {
            return false;
        }
        thread.setName("T7@ZeusLogFile1");
        thread.start();
        return true;
    }

    public boolean uploadLogDirectory(String str, boolean z, OnFinishedListener onFinishedListener) {
        if (!sIsEnabled || str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(str);
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles(new LogFilter(this.mType));
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        Thread thread = new Thread(new MyRunner(this, listFiles, this.mType, this.mCuid, this.mUseHttps, z, onFinishedListener));
        if (thread == null) {
            return false;
        }
        thread.setName("T7@ZeusLogDir1");
        thread.start();
        return true;
    }

    public static boolean UploadLogFile(String str, String str2, boolean z, OnFinishedListener onFinishedListener) {
        return new ZeusLogUploader(str2, null, true).uploadLogFile(str, z, onFinishedListener);
    }

    public static boolean UploadLogDirectory(String str, String str2, boolean z, OnFinishedListener onFinishedListener) {
        return new ZeusLogUploader(str2, null, true).uploadLogDirectory(str, z, onFinishedListener);
    }

    public static void setUploadCrashLogFailedEncrypt(boolean z) {
        mUploadCrashLogFailedEncrypt = z;
    }

    public static void setEncryptKey(String str) {
        mEncryptKey = str;
    }

    static byte[] doCompress(byte[] bArr, int i, StringBuffer stringBuffer) {
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
                        if (read != -1) {
                            gZIPOutputStream.write(bArr2, 0, read);
                        } else {
                            byteArrayInputStream.close();
                            gZIPOutputStream.close();
                            return byteArrayOutputStream.toByteArray();
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.e(TAG, "", e);
                        stringBuffer.append(e.getMessage());
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e2) {
                                Log.e(TAG, "", e2);
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
            } catch (Exception e3) {
                e = e3;
                gZIPOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            gZIPOutputStream = null;
            byteArrayInputStream = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [422=6] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x008c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v9 */
    static boolean doUpload(byte[] bArr, String str, boolean z, String str2, StringBuffer stringBuffer) {
        String str3;
        Throwable th;
        Exception e;
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        ByteArrayInputStream byteArrayInputStream;
        boolean z2;
        HttpsURLConnection httpsURLConnection2 = null;
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
                if (!sSDCardDir.isEmpty()) {
                    File file = new File(sSDCardDir + "log_server.txt");
                    if (file.exists()) {
                        Log.v(TAG, "zeusloguploader.java we have log_server.txt");
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        String readLine = bufferedReader.readLine();
                        str3 = readLine != null ? readLine : "https://browserkernel.baidu.com/kw?type=engine";
                        bufferedReader.close();
                    } else {
                        Log.v(TAG, "no local server url ");
                    }
                }
            } catch (Exception e2) {
                Log.e(TAG, "", e2);
            }
        }
        byte[] bArr2 = new byte[4096];
        try {
            if (z) {
                URL url = new URL(str3);
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
                        httpsURLConnection3.setRequestProperty("Content-Length", "" + bArr.length);
                        httpsURLConnection3.setRequestProperty("Content-Disposition", "attchment;filename=" + substring);
                        httpsURLConnection3.setRequestProperty("LogType", str);
                        httpsURLConnection3.setFixedLengthStreamingMode(bArr.length);
                        httpsURLConnection3.connect();
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                        try {
                            OutputStream outputStream2 = httpsURLConnection3.getOutputStream();
                            while (true) {
                                try {
                                    int read = byteArrayInputStream2.read(bArr2);
                                    if (read == -1) {
                                        break;
                                    }
                                    outputStream2.write(bArr2, 0, read);
                                } catch (Exception e3) {
                                    e = e3;
                                    httpsURLConnection = httpsURLConnection3;
                                    outputStream = outputStream2;
                                    byteArrayInputStream = byteArrayInputStream2;
                                    try {
                                        stringBuffer.append(e.getMessage());
                                        Log.e(TAG, "", e);
                                        if (byteArrayInputStream != null) {
                                            try {
                                                byteArrayInputStream.close();
                                            } catch (Exception e4) {
                                                Log.d(TAG, "failed http.");
                                                httpsURLConnection.disconnect();
                                                return false;
                                            }
                                        }
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        Log.d(TAG, "failed http.");
                                        httpsURLConnection.disconnect();
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        httpsURLConnection2 = httpsURLConnection;
                                        httpsURLConnection2.disconnect();
                                        throw th;
                                    }
                                }
                            }
                            byteArrayInputStream2.close();
                            outputStream2.flush();
                            outputStream2.close();
                            int responseCode = httpsURLConnection3.getResponseCode();
                            Log.i(TAG, "CRASHPAD finish send the reqeust , responseCode = " + responseCode + ",  mUploadCrashLogFailedEncrypt=" + mUploadCrashLogFailedEncrypt);
                            if (responseCode == 200) {
                                stringBuffer.append("Upload Success; The server has responed 200 . ");
                                httpsURLConnection3.disconnect();
                                z2 = true;
                                httpsURLConnection2 = outputStream2;
                            } else {
                                stringBuffer.append("doUpload Failed, The server has responsed Code " + responseCode);
                                httpsURLConnection3.disconnect();
                                z2 = false;
                                httpsURLConnection2 = outputStream2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            httpsURLConnection = httpsURLConnection3;
                            outputStream = null;
                            byteArrayInputStream = byteArrayInputStream2;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        httpsURLConnection = httpsURLConnection3;
                        outputStream = null;
                        byteArrayInputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpsURLConnection2 = httpsURLConnection3;
                    httpsURLConnection2.disconnect();
                    throw th;
                }
            } else {
                stringBuffer.append("doUpload Failed, HTTP is never supported!");
                httpsURLConnection2.disconnect();
                z2 = false;
            }
            return z2;
        } catch (Exception e7) {
            e = e7;
            httpsURLConnection = httpsURLConnection2;
            outputStream = httpsURLConnection2;
            byteArrayInputStream = httpsURLConnection2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    static boolean doDelete(String str, StringBuffer stringBuffer) {
        if (str == null || str.isEmpty()) {
            stringBuffer.append("Failed to remove empty file:" + str);
            return false;
        }
        File file = new File(str);
        if (file != null && file.isFile() && file.delete()) {
            Log.i(TAG, "CRASHPAD  dodelete sucess return true ");
            return true;
        }
        stringBuffer.append("Failed to remove file:" + file.getName());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean uploadFileEncryptJudge(byte[] bArr) {
        int length = "uploadfailed".length();
        return length < bArr.length && "uploadfailed".equals(new String(bArr, bArr.length - length, length));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [477=4, 491=4] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0075 A[Catch: Exception -> 0x0097, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0097, blocks: (B:24:0x003f, B:46:0x0075), top: B:85:0x003f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int encryptUploadFailedFile(String str, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        byte[] doEncryptUploadFailedFile;
        DataInputStream dataInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileOutputStream fileOutputStream = null;
        int i2 = z ? 6 : 7;
        File file = new File(str);
        if (file == null || !file.exists()) {
            byteArrayOutputStream = null;
            i = i2;
        } else {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(file));
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e) {
                                i2 = 5;
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                                i = i2;
                            } catch (Exception e2) {
                                i = 5;
                            }
                        } else {
                            i = i2;
                        }
                    } catch (Exception e3) {
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                                byteArrayOutputStream = byteArrayOutputStream2;
                                i = 5;
                            } catch (Exception e5) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                                i = 5;
                            }
                        } else {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            i = 5;
                        }
                        doEncryptUploadFailedFile = doEncryptUploadFailedFile(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, z);
                        if (doEncryptUploadFailedFile != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e7) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    byteArrayOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e9) {
                byteArrayOutputStream2 = null;
                dataInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                dataInputStream = null;
            }
        }
        try {
            doEncryptUploadFailedFile = doEncryptUploadFailedFile(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, z);
            if (doEncryptUploadFailedFile != null) {
                return 5;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str), false);
            try {
                fileOutputStream2.write(doEncryptUploadFailedFile);
                if (z) {
                    fileOutputStream2.write("uploadfailed".getBytes());
                }
                fileOutputStream2.flush();
                fileOutputStream2.close();
                return i;
            } catch (Exception e10) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return 5;
                    } catch (IOException e11) {
                        Log.e(TAG, "", e11);
                        return 5;
                    }
                }
                return 5;
            }
        } catch (Exception e12) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] doEncryptUploadFailedFile(byte[] bArr, int i, boolean z) {
        byte[] bArr2 = null;
        if (bArr != null && bArr.length > 0 && i > 0 && mEncryptKey != null) {
            if (i > bArr.length) {
                i = bArr.length;
            }
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr, 0, bArr3, 0, i);
            RC4 rc4 = new RC4(mEncryptKey);
            bArr2 = z ? rc4.encrypt(bArr3) : rc4.decrypt(bArr3);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (z) {
            }
            Log.i(TAG, z ? "encrypt" : "decrypt upload file run time:  (ms)" + (currentTimeMillis2 - currentTimeMillis));
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class MyRunner implements Runnable {
        String cuid;
        boolean deletAfterUpload;
        String[] files;
        OnFinishedListener listener;
        String logType;
        boolean useHttps;
        int status = 0;
        StringBuffer msg = new StringBuffer("");

        MyRunner(String str, String str2, String str3, boolean z, boolean z2, OnFinishedListener onFinishedListener) {
            this.files = new String[]{str};
            this.deletAfterUpload = z2;
            this.listener = onFinishedListener;
            this.logType = str2;
            this.cuid = str3;
            this.useHttps = z;
        }

        MyRunner(ZeusLogUploader zeusLogUploader, File[] fileArr, String str, String str2, boolean z, boolean z2, OnFinishedListener onFinishedListener) {
            ZeusLogUploader.this = zeusLogUploader;
            this.files = new String[fileArr.length];
            for (int i = 0; i < fileArr.length; i++) {
                this.files[i] = fileArr[i].getPath();
            }
            this.deletAfterUpload = z2;
            this.listener = onFinishedListener;
            this.logType = str;
            this.cuid = str2;
            this.useHttps = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x00b5 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String[] strArr;
            boolean z;
            FileInputStream fileInputStream;
            byte[] bArr;
            int i;
            for (String str : this.files) {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        int available = fileInputStream.available();
                        if (this.cuid != null && !this.logType.equals("crashlog")) {
                            i = this.cuid.getBytes().length;
                            bArr = new byte[available + i];
                            System.arraycopy(this.cuid.getBytes(), 0, bArr, 0, this.cuid.getBytes().length);
                        } else {
                            bArr = new byte[available];
                            i = 0;
                        }
                        do {
                            i += fileInputStream.read(bArr, i, available);
                            available = fileInputStream.available();
                        } while (available > 0);
                        z = ZeusLogUploader.uploadFileEncryptJudge(bArr);
                        try {
                            if (this.logType.equals("crashlog") && z && (bArr = ZeusLogUploader.this.doEncryptUploadFailedFile(bArr, bArr.length - "uploadfailed".length(), false)) == null) {
                                this.status = 8;
                            }
                            byte[] doCompress = ZeusLogUploader.doCompress(bArr, bArr.length, this.msg);
                            if (doCompress == null) {
                                this.status = 1;
                            } else if (!ZeusLogUploader.doUpload(doCompress, this.logType, this.useHttps, str, this.msg)) {
                                this.status = 3;
                            } else if (this.deletAfterUpload && !ZeusLogUploader.doDelete(str, this.msg)) {
                                this.status = 4;
                            }
                            fileInputStream.close();
                        } catch (Exception e) {
                            e = e;
                            this.status = 5;
                            Log.e(ZeusLogUploader.TAG, "", e);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e2) {
                                    Log.e(ZeusLogUploader.TAG, "", e2);
                                }
                            }
                            if (ZeusLogUploader.mUploadCrashLogFailedEncrypt) {
                                this.status = 2;
                            }
                            if (this.listener == null) {
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        z = false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                    fileInputStream = null;
                }
                if (ZeusLogUploader.mUploadCrashLogFailedEncrypt && this.status != 0 && this.logType.equals("crashlog") && !z && ZeusLogUploader.this.encryptUploadFailedFile(str, true) != 6) {
                    this.status = 2;
                }
                if (this.listener == null) {
                    this.listener.onFinished(str, this.status, this.msg.toString());
                }
            }
        }
    }
}
