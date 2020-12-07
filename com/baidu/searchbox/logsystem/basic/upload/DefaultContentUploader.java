package com.baidu.searchbox.logsystem.basic.upload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.logsystem.util.LLog;
import java.io.ByteArrayOutputStream;
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
/* loaded from: classes15.dex */
public class DefaultContentUploader extends BaseContentUploader {
    private static final int CONNECT_TIMEOUT = 30000;
    private static final boolean DEBUG = LLog.sDebug;
    private static final String POST_METHOD = "POST";
    private static final int READ_TIMEOUT = 30000;
    private static final String TAG = "LSStrategy";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [135=5, 136=4, 137=4, 138=4, 126=4] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[Catch: all -> 0x0181, TRY_LEAVE, TryCatch #0 {all -> 0x0181, blocks: (B:15:0x0065, B:17:0x0069), top: B:95:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151 A[Catch: all -> 0x0178, TRY_LEAVE, TryCatch #12 {all -> 0x0178, blocks: (B:23:0x0092, B:25:0x0098, B:26:0x009a, B:28:0x00a1, B:31:0x00ae, B:33:0x00b9, B:66:0x014d, B:68:0x0151, B:42:0x00d9), top: B:102:0x0005 }] */
    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ResponseEntity uploadDataRequestSync(@NonNull String str, @NonNull File file, @Nullable Map<String, String> map) {
        FileInputStream fileInputStream;
        IOException iOException;
        boolean z;
        MalformedURLException malformedURLException;
        InputStream inputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        OutputStream outputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        InputStream inputStream2 = null;
        boolean z2 = false;
        try {
            try {
                if (DEBUG) {
                    Log.d(TAG, "DefaultContentUploader.uploadDataRequestSync=" + str);
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setConnectTimeout(30000);
                if (map != null) {
                    for (String str2 : map.keySet()) {
                        httpURLConnection.setRequestProperty(str2, map.get(str2));
                    }
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        outputStream2 = httpURLConnection.getOutputStream();
                        try {
                            byte[] bArr = new byte[8096];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                outputStream2.write(bArr, 0, read);
                            }
                            outputStream2.flush();
                            int responseCode = httpURLConnection.getResponseCode();
                            InputStream inputStream3 = responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                            if (inputStream3 != null) {
                                try {
                                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    while (true) {
                                        try {
                                            int read2 = inputStream3.read(bArr);
                                            if (read2 == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream2.write(bArr, 0, read2);
                                        } catch (MalformedURLException e) {
                                            outputStream = outputStream2;
                                            fileInputStream2 = fileInputStream;
                                            InputStream inputStream4 = inputStream3;
                                            malformedURLException = e;
                                            z = z2;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            inputStream = inputStream4;
                                            try {
                                                if (DEBUG) {
                                                }
                                                Closeables.closeSafely(outputStream);
                                                Closeables.closeSafely(fileInputStream2);
                                                Closeables.closeSafely(byteArrayOutputStream);
                                                Closeables.closeSafely(inputStream);
                                                return new ResponseEntity(z);
                                            } catch (Throwable th) {
                                                th = th;
                                                outputStream2 = outputStream;
                                                fileInputStream = fileInputStream2;
                                                inputStream2 = inputStream;
                                                byteArrayOutputStream3 = byteArrayOutputStream;
                                                Closeables.closeSafely(outputStream2);
                                                Closeables.closeSafely(fileInputStream);
                                                Closeables.closeSafely(byteArrayOutputStream3);
                                                Closeables.closeSafely(inputStream2);
                                                throw th;
                                            }
                                        } catch (IOException e2) {
                                            inputStream2 = inputStream3;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            iOException = e2;
                                            z = z2;
                                            if (DEBUG) {
                                            }
                                            Closeables.closeSafely(outputStream2);
                                            Closeables.closeSafely(fileInputStream);
                                            Closeables.closeSafely(byteArrayOutputStream3);
                                            Closeables.closeSafely(inputStream2);
                                            return new ResponseEntity(z);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            inputStream2 = inputStream3;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            Closeables.closeSafely(outputStream2);
                                            Closeables.closeSafely(fileInputStream);
                                            Closeables.closeSafely(byteArrayOutputStream3);
                                            Closeables.closeSafely(inputStream2);
                                            throw th;
                                        }
                                    }
                                    byteArrayOutputStream2.flush();
                                } catch (MalformedURLException e3) {
                                    inputStream = inputStream3;
                                    outputStream = outputStream2;
                                    malformedURLException = e3;
                                    z = false;
                                    byteArrayOutputStream = null;
                                    fileInputStream2 = fileInputStream;
                                    if (DEBUG) {
                                        Log.d(TAG, Log.getStackTraceString(malformedURLException));
                                    }
                                    Closeables.closeSafely(outputStream);
                                    Closeables.closeSafely(fileInputStream2);
                                    Closeables.closeSafely(byteArrayOutputStream);
                                    Closeables.closeSafely(inputStream);
                                    return new ResponseEntity(z);
                                } catch (IOException e4) {
                                    inputStream2 = inputStream3;
                                    iOException = e4;
                                    z = false;
                                    if (DEBUG) {
                                        Log.d(TAG, Log.getStackTraceString(iOException));
                                    }
                                    Closeables.closeSafely(outputStream2);
                                    Closeables.closeSafely(fileInputStream);
                                    Closeables.closeSafely(byteArrayOutputStream3);
                                    Closeables.closeSafely(inputStream2);
                                    return new ResponseEntity(z);
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream2 = inputStream3;
                                    Closeables.closeSafely(outputStream2);
                                    Closeables.closeSafely(fileInputStream);
                                    Closeables.closeSafely(byteArrayOutputStream3);
                                    Closeables.closeSafely(inputStream2);
                                    throw th;
                                }
                            } else {
                                byteArrayOutputStream2 = null;
                            }
                            String byteArrayOutputStream4 = byteArrayOutputStream2 != null ? byteArrayOutputStream2.toString("utf-8") : null;
                            if (responseCode == 200 && !TextUtils.isEmpty(byteArrayOutputStream4)) {
                                try {
                                    z2 = new JSONObject(byteArrayOutputStream4).optInt(BdStatsConstant.StatsType.ERROR, -1) == 0;
                                } catch (JSONException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (DEBUG) {
                                Log.d(TAG, "DefaultContentUploader: success = " + z2 + ", resultStr= " + byteArrayOutputStream4);
                            }
                            ResponseEntity responseEntity = new ResponseEntity(z2, byteArrayOutputStream4);
                            Closeables.closeSafely(outputStream2);
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(byteArrayOutputStream2);
                            Closeables.closeSafely(inputStream3);
                            return responseEntity;
                        } catch (MalformedURLException e6) {
                            malformedURLException = e6;
                            inputStream = null;
                            z = false;
                            outputStream = outputStream2;
                            byteArrayOutputStream = null;
                            fileInputStream2 = fileInputStream;
                        }
                    } catch (IOException e7) {
                        iOException = e7;
                        z = false;
                    }
                } catch (MalformedURLException e8) {
                    malformedURLException = e8;
                    inputStream = null;
                    z = false;
                    outputStream = null;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (MalformedURLException e9) {
            malformedURLException = e9;
            inputStream = null;
            z = false;
            outputStream = null;
            byteArrayOutputStream = null;
            fileInputStream2 = null;
        } catch (IOException e10) {
            iOException = e10;
            fileInputStream = null;
            z = false;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
    }
}
