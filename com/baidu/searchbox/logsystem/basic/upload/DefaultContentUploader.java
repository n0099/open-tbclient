package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DefaultContentUploader extends BaseContentUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONNECT_TIMEOUT = 30000;
    public static final boolean DEBUG;
    public static final String POST_METHOD = "POST";
    public static final int READ_TIMEOUT = 30000;
    public static final String TAG = "LSStrategy";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1353331422, "Lcom/baidu/searchbox/logsystem/basic/upload/DefaultContentUploader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1353331422, "Lcom/baidu/searchbox/logsystem/basic/upload/DefaultContentUploader;");
                return;
            }
        }
        DEBUG = LLog.sDebug;
    }

    public DefaultContentUploader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x0006 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0133 A[Catch: all -> 0x0154, TryCatch #9 {all -> 0x0154, blocks: (B:81:0x012f, B:83:0x0133, B:86:0x013b, B:88:0x013f), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013f A[Catch: all -> 0x0154, TRY_LEAVE, TryCatch #9 {all -> 0x0154, blocks: (B:81:0x012f, B:83:0x0133, B:86:0x013b, B:88:0x013f), top: B:102:0x0006 }] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ResponseEntity uploadDataRequestSync(@NonNull String str, @NonNull File file, @Nullable Map<String, String> map) {
        InterceptResult invokeLLL;
        InputStream inputStream;
        FileInputStream fileInputStream;
        InputStream inputStream2;
        OutputStream outputStream;
        InputStream inputStream3;
        OutputStream outputStream2;
        InputStream inputStream4;
        InputStream inputStream5;
        OutputStream outputStream3;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream4;
        InputStream inputStream6;
        OutputStream outputStream5;
        InputStream inputStream7;
        OutputStream outputStream6;
        InputStream errorStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, file, map)) == null) {
            boolean z = false;
            FileInputStream fileInputStream2 = null;
            r1 = null;
            fileInputStream2 = null;
            fileInputStream2 = null;
            Closeable closeable = null;
            try {
                try {
                    if (DEBUG) {
                        String str2 = "DefaultContentUploader.uploadDataRequestSync=" + str;
                    }
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setConnectTimeout(30000);
                    if (map != 0) {
                        for (String str3 : map.keySet()) {
                            httpURLConnection.setRequestProperty(str3, (String) map.get(str3));
                        }
                    }
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.connect();
                    fileInputStream = new FileInputStream((File) file);
                    try {
                        outputStream6 = httpURLConnection.getOutputStream();
                    } catch (MalformedURLException e2) {
                        e = e2;
                        outputStream5 = null;
                        inputStream7 = null;
                    } catch (IOException e3) {
                        e = e3;
                        outputStream4 = null;
                        inputStream6 = null;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = null;
                        inputStream2 = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    outputStream3 = file;
                    inputStream5 = map;
                }
            } catch (MalformedURLException e4) {
                e = e4;
                outputStream2 = null;
                inputStream4 = null;
                inputStream2 = null;
            } catch (IOException e5) {
                e = e5;
                outputStream = null;
                inputStream3 = null;
                inputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                fileInputStream = null;
                inputStream2 = null;
            }
            try {
                byte[] bArr = new byte[8096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream6.write(bArr, 0, read);
                }
                outputStream6.flush();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                if (errorStream != null) {
                    try {
                        inputStream2 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read2 = errorStream.read(bArr);
                                if (read2 == -1) {
                                    break;
                                }
                                inputStream2.write(bArr, 0, read2);
                            } catch (MalformedURLException e6) {
                                e = e6;
                                fileInputStream2 = fileInputStream;
                                MalformedURLException malformedURLException = e;
                                inputStream4 = errorStream;
                                e = malformedURLException;
                                outputStream2 = outputStream6;
                                file = outputStream2;
                                map = inputStream4;
                                if (DEBUG) {
                                }
                                Closeables.closeSafely((Closeable) file);
                                Closeables.closeSafely(fileInputStream2);
                                Closeables.closeSafely(inputStream2);
                                Closeables.closeSafely((Closeable) map);
                                return new ResponseEntity(z);
                            } catch (IOException e7) {
                                e = e7;
                                fileInputStream2 = fileInputStream;
                                IOException iOException = e;
                                inputStream3 = errorStream;
                                e = iOException;
                                outputStream = outputStream6;
                                file = outputStream;
                                map = inputStream3;
                                if (DEBUG) {
                                }
                                Closeables.closeSafely((Closeable) file);
                                Closeables.closeSafely(fileInputStream2);
                                Closeables.closeSafely(inputStream2);
                                Closeables.closeSafely((Closeable) map);
                                return new ResponseEntity(z);
                            } catch (Throwable th4) {
                                th = th4;
                                closeable = outputStream6;
                                Throwable th5 = th;
                                inputStream = errorStream;
                                th = th5;
                                Closeables.closeSafely(closeable);
                                Closeables.closeSafely(fileInputStream);
                                Closeables.closeSafely(inputStream2);
                                Closeables.closeSafely(inputStream);
                                throw th;
                            }
                        }
                        inputStream2.flush();
                    } catch (MalformedURLException e8) {
                        e = e8;
                        inputStream2 = null;
                        fileInputStream2 = fileInputStream;
                        MalformedURLException malformedURLException2 = e;
                        inputStream4 = errorStream;
                        e = malformedURLException2;
                        outputStream2 = outputStream6;
                        file = outputStream2;
                        map = inputStream4;
                        if (DEBUG) {
                            Log.getStackTraceString(e);
                            file = outputStream2;
                            map = inputStream4;
                        }
                        Closeables.closeSafely((Closeable) file);
                        Closeables.closeSafely(fileInputStream2);
                        Closeables.closeSafely(inputStream2);
                        Closeables.closeSafely((Closeable) map);
                        return new ResponseEntity(z);
                    } catch (IOException e9) {
                        e = e9;
                        inputStream2 = null;
                        fileInputStream2 = fileInputStream;
                        IOException iOException2 = e;
                        inputStream3 = errorStream;
                        e = iOException2;
                        outputStream = outputStream6;
                        file = outputStream;
                        map = inputStream3;
                        if (DEBUG) {
                            Log.getStackTraceString(e);
                            file = outputStream;
                            map = inputStream3;
                        }
                        Closeables.closeSafely((Closeable) file);
                        Closeables.closeSafely(fileInputStream2);
                        Closeables.closeSafely(inputStream2);
                        Closeables.closeSafely((Closeable) map);
                        return new ResponseEntity(z);
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream2 = null;
                        closeable = outputStream6;
                        Throwable th52 = th;
                        inputStream = errorStream;
                        th = th52;
                        Closeables.closeSafely(closeable);
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(inputStream2);
                        Closeables.closeSafely(inputStream);
                        throw th;
                    }
                } else {
                    inputStream2 = null;
                }
                String byteArrayOutputStream = inputStream2 != null ? inputStream2.toString("utf-8") : null;
                if (responseCode == 200 && !TextUtils.isEmpty(byteArrayOutputStream)) {
                    try {
                        if (new JSONObject(byteArrayOutputStream).optInt("error", -1) == 0) {
                            z = true;
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
                if (DEBUG) {
                    String str4 = "DefaultContentUploader: success = " + z + ", resultStr= " + byteArrayOutputStream;
                }
                ResponseEntity responseEntity = new ResponseEntity(z, byteArrayOutputStream);
                Closeables.closeSafely(outputStream6);
                Closeables.closeSafely(fileInputStream);
                Closeables.closeSafely((Closeable) inputStream2);
                Closeables.closeSafely(errorStream);
                return responseEntity;
            } catch (MalformedURLException e11) {
                e = e11;
                inputStream7 = null;
                outputStream5 = outputStream6;
                inputStream2 = inputStream7;
                fileInputStream2 = fileInputStream;
                outputStream2 = outputStream5;
                inputStream4 = inputStream7;
                file = outputStream2;
                map = inputStream4;
                if (DEBUG) {
                }
                Closeables.closeSafely((Closeable) file);
                Closeables.closeSafely(fileInputStream2);
                Closeables.closeSafely(inputStream2);
                Closeables.closeSafely((Closeable) map);
                return new ResponseEntity(z);
            } catch (IOException e12) {
                e = e12;
                inputStream6 = null;
                outputStream4 = outputStream6;
                inputStream2 = inputStream6;
                fileInputStream2 = fileInputStream;
                outputStream = outputStream4;
                inputStream3 = inputStream6;
                file = outputStream;
                map = inputStream3;
                if (DEBUG) {
                }
                Closeables.closeSafely((Closeable) file);
                Closeables.closeSafely(fileInputStream2);
                Closeables.closeSafely(inputStream2);
                Closeables.closeSafely((Closeable) map);
                return new ResponseEntity(z);
            } catch (Throwable th7) {
                th = th7;
                inputStream5 = null;
                inputStream2 = null;
                outputStream3 = outputStream6;
                closeable = outputStream3;
                inputStream = inputStream5;
                Closeables.closeSafely(closeable);
                Closeables.closeSafely(fileInputStream);
                Closeables.closeSafely(inputStream2);
                Closeables.closeSafely(inputStream);
                throw th;
            }
        }
        return (ResponseEntity) invokeLLL.objValue;
    }
}
