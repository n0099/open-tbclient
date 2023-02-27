package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.logsystem.util.LLog;
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
/* loaded from: classes2.dex */
public class DefaultContentUploader extends BaseContentUploader {
    public static final int CONNECT_TIMEOUT = 30000;
    public static final boolean DEBUG = LLog.sDebug;
    public static final String POST_METHOD = "POST";
    public static final int READ_TIMEOUT = 30000;
    public static final String TAG = "LSStrategy";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:94:0x0004 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013a A[Catch: all -> 0x0163, TryCatch #1 {all -> 0x0163, blocks: (B:79:0x0136, B:81:0x013a, B:84:0x0146, B:86:0x014a), top: B:94:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014a A[Catch: all -> 0x0163, TRY_LEAVE, TryCatch #1 {all -> 0x0163, blocks: (B:79:0x0136, B:81:0x013a, B:84:0x0146, B:86:0x014a), top: B:94:0x0004 }] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r14v37 */
    /* JADX WARN: Type inference failed for: r14v38 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ResponseEntity uploadDataRequestSync(@NonNull String str, @NonNull File file, @Nullable Map<String, String> map) {
        InputStream inputStream;
        FileInputStream fileInputStream;
        InputStream inputStream2;
        OutputStream outputStream;
        InputStream inputStream3;
        OutputStream outputStream2;
        InputStream inputStream4;
        InputStream inputStream5;
        OutputStream outputStream3;
        OutputStream outputStream4;
        InputStream inputStream6;
        OutputStream outputStream5;
        InputStream inputStream7;
        InputStream errorStream;
        boolean z = false;
        FileInputStream fileInputStream2 = null;
        String str2 = null;
        r2 = null;
        fileInputStream2 = null;
        fileInputStream2 = null;
        Closeable closeable = null;
        try {
            try {
                if (DEBUG) {
                    Log.d("LSStrategy", "DefaultContentUploader.uploadDataRequestSync=" + str);
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
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
                    OutputStream outputStream6 = httpURLConnection.getOutputStream();
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
                                    } catch (MalformedURLException e) {
                                        e = e;
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
                                    } catch (IOException e2) {
                                        e = e2;
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
                                    } catch (Throwable th) {
                                        th = th;
                                        closeable = outputStream6;
                                        Throwable th2 = th;
                                        inputStream = errorStream;
                                        th = th2;
                                        Closeables.closeSafely(closeable);
                                        Closeables.closeSafely(fileInputStream);
                                        Closeables.closeSafely(inputStream2);
                                        Closeables.closeSafely(inputStream);
                                        throw th;
                                    }
                                }
                                inputStream2.flush();
                            } catch (MalformedURLException e3) {
                                e = e3;
                                inputStream2 = null;
                                fileInputStream2 = fileInputStream;
                                MalformedURLException malformedURLException2 = e;
                                inputStream4 = errorStream;
                                e = malformedURLException2;
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
                            } catch (IOException e4) {
                                e = e4;
                                inputStream2 = null;
                                fileInputStream2 = fileInputStream;
                                IOException iOException2 = e;
                                inputStream3 = errorStream;
                                e = iOException2;
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
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream2 = null;
                                closeable = outputStream6;
                                Throwable th22 = th;
                                inputStream = errorStream;
                                th = th22;
                                Closeables.closeSafely(closeable);
                                Closeables.closeSafely(fileInputStream);
                                Closeables.closeSafely(inputStream2);
                                Closeables.closeSafely(inputStream);
                                throw th;
                            }
                        } else {
                            inputStream2 = null;
                        }
                        if (inputStream2 != null) {
                            str2 = inputStream2.toString(IMAudioTransRequest.CHARSET);
                        }
                        if (responseCode == 200 && !TextUtils.isEmpty(str2)) {
                            try {
                                if (new JSONObject(str2).optInt("error", -1) == 0) {
                                    z = true;
                                }
                            } catch (JSONException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (DEBUG) {
                            Log.d("LSStrategy", "DefaultContentUploader: success = " + z + ", resultStr= " + str2);
                        }
                        ResponseEntity responseEntity = new ResponseEntity(z, str2);
                        Closeables.closeSafely(outputStream6);
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely((Closeable) inputStream2);
                        Closeables.closeSafely(errorStream);
                        return responseEntity;
                    } catch (MalformedURLException e6) {
                        e = e6;
                        inputStream7 = null;
                        outputStream5 = outputStream6;
                        inputStream2 = inputStream7;
                        fileInputStream2 = fileInputStream;
                        outputStream2 = outputStream5;
                        inputStream4 = inputStream7;
                        file = outputStream2;
                        map = inputStream4;
                        if (DEBUG) {
                            Log.d("LSStrategy", Log.getStackTraceString(e));
                            file = outputStream2;
                            map = inputStream4;
                        }
                        Closeables.closeSafely((Closeable) file);
                        Closeables.closeSafely(fileInputStream2);
                        Closeables.closeSafely(inputStream2);
                        Closeables.closeSafely((Closeable) map);
                        return new ResponseEntity(z);
                    } catch (IOException e7) {
                        e = e7;
                        inputStream6 = null;
                        outputStream4 = outputStream6;
                        inputStream2 = inputStream6;
                        fileInputStream2 = fileInputStream;
                        outputStream = outputStream4;
                        inputStream3 = inputStream6;
                        file = outputStream;
                        map = inputStream3;
                        if (DEBUG) {
                            Log.d("LSStrategy", Log.getStackTraceString(e));
                            file = outputStream;
                            map = inputStream3;
                        }
                        Closeables.closeSafely((Closeable) file);
                        Closeables.closeSafely(fileInputStream2);
                        Closeables.closeSafely(inputStream2);
                        Closeables.closeSafely((Closeable) map);
                        return new ResponseEntity(z);
                    } catch (Throwable th4) {
                        th = th4;
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
                } catch (MalformedURLException e8) {
                    e = e8;
                    outputStream5 = null;
                    inputStream7 = null;
                } catch (IOException e9) {
                    e = e9;
                    outputStream4 = null;
                    inputStream6 = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    inputStream2 = null;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
                outputStream3 = file;
                inputStream5 = map;
            }
        } catch (MalformedURLException e10) {
            e = e10;
            outputStream2 = null;
            inputStream4 = null;
            inputStream2 = null;
        } catch (IOException e11) {
            e = e11;
            outputStream = null;
            inputStream3 = null;
            inputStream2 = null;
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            fileInputStream = null;
            inputStream2 = null;
        }
    }
}
