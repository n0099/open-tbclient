package com.baidu.crashpad;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public final class ZeusLogUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADD_UPLOAD_FILE_FLAG = "uploadfailed";
    public static final int BUFF_SIZE = 4096;
    public static final String CRASH_IMEI = "imei";
    public static final String CRASH_IS_NATIVE = "is_native";
    public static final String CRASH_LOG = "crashlog";
    public static final String CRASH_SIGNAL = "signal";
    public static final String CRASH_TIME = "time_crash";
    public static final String NR_LOG = "nrlog";
    public static final String RECORD_LOG = "recordlog";
    public static final String TAG = "ZeusLogUploader CRASHPAD";
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
    public static final BigInteger exponent;
    public static String mEncryptKey;
    public static boolean mUploadCrashLogFailedEncrypt;
    public static boolean sIsEnabled;
    public static String sSDCardDir;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCuid;
    public String mType;
    public boolean mUseHttps;

    /* loaded from: classes10.dex */
    public static class LogFilter implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mLogType;

        public LogFilter(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLogType = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                if (!"crashlog".equals(this.mLogType) && !"recordlog".equals(this.mLogType)) {
                    if ("videolog".equals(this.mLogType)) {
                        return str.endsWith(".log");
                    }
                    if ("nrlog".equals(this.mLogType)) {
                        return str.endsWith(".nr");
                    }
                    return false;
                }
                return str.endsWith(".bdmp");
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface OnFinishedListener {
        void onFinished(String str, int i2, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(230180679, "Lcom/baidu/crashpad/ZeusLogUploader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(230180679, "Lcom/baidu/crashpad/ZeusLogUploader;");
                return;
            }
        }
        exponent = new BigInteger("65537");
        sIsEnabled = true;
        sSDCardDir = "";
        mUploadCrashLogFailedEncrypt = true;
    }

    public ZeusLogUploader(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mType = str;
        this.mUseHttps = z;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(SearchJsBridge.CUID).put(str2);
        try {
            jSONObject.put(SearchJsBridge.CUID, jSONArray);
        } catch (JSONException unused) {
        }
        this.mCuid = jSONObject.toString();
    }

    public static boolean UploadLogDirectory(String str, String str2, boolean z, OnFinishedListener onFinishedListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, Boolean.valueOf(z), onFinishedListener})) == null) ? new ZeusLogUploader(str2, null, true).uploadLogDirectory(str, z, onFinishedListener) : invokeCommon.booleanValue;
    }

    public static boolean UploadLogFile(String str, String str2, boolean z, OnFinishedListener onFinishedListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Boolean.valueOf(z), onFinishedListener})) == null) ? new ZeusLogUploader(str2, null, true).uploadLogFile(str, z, onFinishedListener) : invokeCommon.booleanValue;
    }

    public static byte[] doCompress(byte[] bArr, int i2, StringBuffer stringBuffer) {
        InterceptResult invokeLIL;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(65543, null, bArr, i2, stringBuffer)) != null) {
            return (byte[]) invokeLIL.objValue;
        }
        if (bArr != null && i2 > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[4096];
            try {
                if (i2 > bArr.length) {
                    i2 = bArr.length;
                }
                byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i2);
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    while (true) {
                        try {
                            int read = byteArrayInputStream.read(bArr2);
                            if (read != -1) {
                                gZIPOutputStream2.write(bArr2, 0, read);
                            } else {
                                byteArrayInputStream.close();
                                gZIPOutputStream2.close();
                                return byteArrayOutputStream.toByteArray();
                            }
                        } catch (Exception e2) {
                            gZIPOutputStream = gZIPOutputStream2;
                            e = e2;
                            stringBuffer.append(e.getMessage());
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (Exception unused) {
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
        } else {
            stringBuffer.append("doCompress Failed, source is null; ");
            return null;
        }
    }

    public static boolean doDelete(String str, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, stringBuffer)) == null) {
            if (str != null && !str.isEmpty()) {
                File file = new File(str);
                if (file.isFile() && file.delete()) {
                    return true;
                }
                stringBuffer.append("Failed to remove file:" + file.getName());
                return false;
            }
            stringBuffer.append("Failed to remove empty file:" + str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] doEncryptUploadFailedFile(byte[] bArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (bArr == null || bArr.length <= 0 || i2 <= 0 || mEncryptKey == null) {
                return null;
            }
            if (i2 > bArr.length) {
                i2 = bArr.length;
            }
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            RC4 rc4 = new RC4(mEncryptKey);
            byte[] encrypt = z ? rc4.encrypt(bArr2) : rc4.decrypt(bArr2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (z) {
                return encrypt;
            }
            String str = "decrypt upload file run time:  (ms)" + (currentTimeMillis2 - currentTimeMillis);
            return encrypt;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static boolean doUpload(byte[] bArr, String str, boolean z, String str2, StringBuffer stringBuffer) {
        InterceptResult invokeCommon;
        String str3;
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{bArr, str, Boolean.valueOf(z), str2, stringBuffer})) != null) {
            return invokeCommon.booleanValue;
        }
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
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        String readLine = bufferedReader.readLine();
                        str3 = readLine != null ? readLine : "https://browserkernel.baidu.com/kw?type=engine";
                        bufferedReader.close();
                    }
                }
            } catch (Exception unused) {
            }
        }
        byte[] bArr2 = new byte[4096];
        HttpsURLConnection httpsURLConnection2 = null;
        r4 = null;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            if (z) {
                URL url = new URL(str3);
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIICZTCCAc4CAQAwDQYJKoZIhvcNAQEEBQAwezELMAkGA1UEBhMCQ04xCzAJBgNV\nBAgTAkJKMQswCQYDVQQHEwJCSjELMAkGA1UEChMCQkQxCzAJBgNVBAsTAkJEMRYw\nFAYDVQQDEw13d3cuYmFpZHUuY29tMSAwHgYJKoZIhvcNAQkBFhFsaWJpbjAyQGJh\naWR1LmNvbTAeFw0xMjA1MTAwMjMzNTVaFw0xMjA2MDkwMjMzNTVaMHsxCzAJBgNV\nBAYTAkNOMQswCQYDVQQIEwJCSjELMAkGA1UEBxMCQkoxCzAJBgNVBAoTAkJEMQsw\nCQYDVQQLEwJCRDEWMBQGA1UEAxMNd3d3LmJhaWR1LmNvbTEgMB4GCSqGSIb3DQEJ\nARYRbGliaW4wMkBiYWlkdS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGB\nALckGzvn6jcMqYpXrZKuuCYlVJIgN2ETsnvjCtO1va5u3p0EL9CuR5BlHocJadzM\nhTI7rH/nao8mXRIcJ4Q6lOv5TAotcKUv7ri9YZ48smpE3+KXVB+Mjau05OfiYI2h\nqlYy56acRSgyp8Uj65PXL8+gae8Gx+6lq0XOKduolmmNAgMBAAEwDQYJKoZIhvcN\nAQEEBQADgYEAYGPEvv1fc4XySq+9+5jFi4TxlNy9vAWpHOjsmODM9gs5/9PQFG/c\nZc8Fz+T9IVRa8YI0mLuKlApGmvzHxwdWbtBU6AU8ifg1HBA/4VXweiq6fgRfaemd\njgW3PXjbd+OoZ0VI32TvrDErG83OYohQ5CAS2gKHfBXHJvKtmxUSdVE=\n-----END CERTIFICATE-----\n".getBytes()));
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setCertificateEntry(ConstantHelper.LOG_CATE, generateCertificate);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                SSLContext.getInstance("TLS").init(null, trustManagerFactory.getTrustManagers(), null);
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    try {
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                        httpsURLConnection.setRequestProperty("Content-Type", "application/x-gzip");
                        httpsURLConnection.setRequestProperty("Content-Length", "" + bArr.length);
                        httpsURLConnection.setRequestProperty("Content-Disposition", "attchment;filename=" + substring);
                        httpsURLConnection.setRequestProperty("LogType", str);
                        httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
                        httpsURLConnection.connect();
                        byteArrayInputStream = new ByteArrayInputStream(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        outputStream = null;
                    }
                    try {
                        OutputStream outputStream2 = httpsURLConnection.getOutputStream();
                        while (true) {
                            int read = byteArrayInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            outputStream2.write(bArr2, 0, read);
                        }
                        byteArrayInputStream.close();
                        outputStream2.flush();
                        outputStream2.close();
                        int responseCode = httpsURLConnection.getResponseCode();
                        String str4 = "CRASHPAD finish send the reqeust , responseCode = " + responseCode + ",  mUploadCrashLogFailedEncrypt=" + mUploadCrashLogFailedEncrypt;
                        if (responseCode == 200) {
                            stringBuffer.append("Upload Success; The server has responed 200 . ");
                            httpsURLConnection.disconnect();
                            return true;
                        }
                        stringBuffer.append("doUpload Failed, The server has responsed Code " + responseCode);
                        httpsURLConnection.disconnect();
                        return false;
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayInputStream2 = byteArrayInputStream;
                        outputStream = null;
                        stringBuffer.append(e.getMessage());
                        if (byteArrayInputStream2 != null) {
                            try {
                                byteArrayInputStream2.close();
                            } catch (Exception unused2) {
                                httpsURLConnection.disconnect();
                                return false;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        httpsURLConnection.disconnect();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.disconnect();
                    throw th;
                }
            }
            stringBuffer.append("doUpload Failed, HTTP is never supported!");
            httpsURLConnection2.disconnect();
            return false;
        } catch (Exception e4) {
            e = e4;
            outputStream = null;
            httpsURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void setBDSdcradDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            sSDCardDir = str;
        }
    }

    public static void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            sIsEnabled = z;
        }
    }

    public static void setEncryptKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            mEncryptKey = str;
        }
    }

    public static void setUploadCrashLogFailedEncrypt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            mUploadCrashLogFailedEncrypt = z;
        }
    }

    public static boolean uploadFileEncryptJudge(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bArr)) == null) ? 12 < bArr.length && "uploadfailed".equals(new String(bArr, bArr.length - 12, 12)) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0015 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0077 A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #7 {Exception -> 0x009a, blocks: (B:46:0x0067, B:49:0x0077), top: B:75:0x0067 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int encryptUploadFailedFile(String str, boolean z) {
        InterceptResult invokeLZ;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] doEncryptUploadFailedFile;
        DataInputStream dataInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) != null) {
            return invokeLZ.intValue;
        }
        int i2 = z ? 6 : 7;
        File file = new File(str);
        ?? exists = file.exists();
        FileOutputStream fileOutputStream = null;
        r4 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (exists != 0) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                    } catch (Exception unused) {
                        exists = 0;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception unused2) {
                    dataInputStream = null;
                    exists = 0;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = dataInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Exception unused3) {
                                i2 = 5;
                            }
                        }
                    }
                    byteArrayOutputStream2.close();
                    dataInputStream.close();
                    byteArrayOutputStream = byteArrayOutputStream2;
                } catch (Exception unused4) {
                    exists = byteArrayOutputStream2;
                    if (exists != 0) {
                        try {
                            exists.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    i2 = 5;
                    byteArrayOutputStream = exists;
                    doEncryptUploadFailedFile = doEncryptUploadFailedFile(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, z);
                    if (doEncryptUploadFailedFile != null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.close();
                        } catch (Exception unused6) {
                        }
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
            }
        } catch (Exception unused8) {
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
                return i2;
            } catch (Exception unused9) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return 5;
                    } catch (IOException unused10) {
                        return 5;
                    }
                }
                return 5;
            }
        } catch (Exception unused11) {
        }
    }

    public boolean uploadLogDirectory(String str, boolean z, OnFinishedListener onFinishedListener) {
        InterceptResult invokeCommon;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), onFinishedListener})) == null) {
            if (sIsEnabled && str != null && !str.isEmpty()) {
                File file = new File(str);
                if (file.exists() && (listFiles = file.listFiles(new LogFilter(this.mType))) != null && listFiles.length != 0) {
                    Thread thread = new Thread(new MyRunner(this, listFiles, this.mType, this.mCuid, this.mUseHttps, z, onFinishedListener));
                    thread.setName("T7@ZeusLogDir1");
                    thread.start();
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean uploadLogFile(String str, boolean z, OnFinishedListener onFinishedListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), onFinishedListener})) == null) {
            if (!sIsEnabled || str == null || str.isEmpty() || !new File(str).exists()) {
                return false;
            }
            Thread thread = new Thread(new MyRunner(this, str, this.mType, this.mCuid, this.mUseHttps, z, onFinishedListener));
            thread.setName("T7@ZeusLogFile1");
            thread.start();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    /* loaded from: classes10.dex */
    public class MyRunner implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String cuid;
        public boolean deletAfterUpload;
        public String[] files;
        public OnFinishedListener listener;
        public String logType;
        public StringBuffer msg;
        public int status;
        public final /* synthetic */ ZeusLogUploader this$0;
        public boolean useHttps;

        public MyRunner(ZeusLogUploader zeusLogUploader, String str, String str2, String str3, boolean z, boolean z2, OnFinishedListener onFinishedListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zeusLogUploader, str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), onFinishedListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = zeusLogUploader;
            this.status = 0;
            this.msg = new StringBuffer("");
            this.files = new String[]{str};
            this.deletAfterUpload = z2;
            this.listener = onFinishedListener;
            this.logType = str2;
            this.cuid = str3;
            this.useHttps = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00da A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String[] strArr;
            boolean z;
            boolean z2;
            OnFinishedListener onFinishedListener;
            byte[] bArr;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (String str : this.files) {
                    FileInputStream fileInputStream = null;
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(str);
                        try {
                            int available = fileInputStream2.available();
                            if (this.cuid != null && !this.logType.equals("crashlog")) {
                                i2 = this.cuid.getBytes().length;
                                bArr = new byte[available + i2];
                                System.arraycopy(this.cuid.getBytes(), 0, bArr, 0, this.cuid.getBytes().length);
                            } else {
                                bArr = new byte[available];
                                i2 = 0;
                            }
                            do {
                                i2 += fileInputStream2.read(bArr, i2, available);
                                available = fileInputStream2.available();
                            } while (available > 0);
                            z2 = ZeusLogUploader.uploadFileEncryptJudge(bArr);
                        } catch (Exception unused) {
                            fileInputStream = fileInputStream2;
                            z = false;
                            this.status = 5;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            z2 = z;
                            if (ZeusLogUploader.mUploadCrashLogFailedEncrypt) {
                                this.status = 2;
                            }
                            onFinishedListener = this.listener;
                            if (onFinishedListener != null) {
                            }
                        }
                        try {
                            if (this.logType.equals("crashlog") && z2 && (bArr = this.this$0.doEncryptUploadFailedFile(bArr, bArr.length - 12, false)) == null) {
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
                            fileInputStream2.close();
                        } catch (Exception unused3) {
                            z = z2;
                            fileInputStream = fileInputStream2;
                            this.status = 5;
                            if (fileInputStream != null) {
                            }
                            z2 = z;
                            if (ZeusLogUploader.mUploadCrashLogFailedEncrypt) {
                            }
                            onFinishedListener = this.listener;
                            if (onFinishedListener != null) {
                            }
                        }
                    } catch (Exception unused4) {
                    }
                    if (ZeusLogUploader.mUploadCrashLogFailedEncrypt && this.status != 0 && this.logType.equals("crashlog") && !z2 && this.this$0.encryptUploadFailedFile(str, true) != 6) {
                        this.status = 2;
                    }
                    onFinishedListener = this.listener;
                    if (onFinishedListener != null) {
                        onFinishedListener.onFinished(str, this.status, this.msg.toString());
                    }
                }
            }
        }

        public MyRunner(ZeusLogUploader zeusLogUploader, File[] fileArr, String str, String str2, boolean z, boolean z2, OnFinishedListener onFinishedListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zeusLogUploader, fileArr, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), onFinishedListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = zeusLogUploader;
            this.status = 0;
            this.msg = new StringBuffer("");
            this.files = new String[fileArr.length];
            for (int i4 = 0; i4 < fileArr.length; i4++) {
                this.files[i4] = fileArr[i4].getPath();
            }
            this.deletAfterUpload = z2;
            this.listener = onFinishedListener;
            this.logType = str;
            this.cuid = str2;
            this.useHttps = z;
        }
    }
}
