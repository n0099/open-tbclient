package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes6.dex */
public class DefaultContentUploader extends BaseContentUploader {
    private static final int CONNECT_TIMEOUT = 30000;
    private static final boolean DEBUG = LLog.sDebug;
    private static final String POST_METHOD = "POST";
    private static final int READ_TIMEOUT = 30000;
    private static final String TAG = "LSStrategy";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [135=5, 136=4, 137=4, 138=4, 126=4] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065 A[Catch: all -> 0x0174, TRY_LEAVE, TryCatch #8 {all -> 0x0174, blocks: (B:15:0x0061, B:17:0x0065), top: B:92:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0144 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #6 {all -> 0x016f, blocks: (B:33:0x00b8, B:64:0x0140, B:66:0x0144), top: B:91:0x0005 }] */
    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ResponseEntity uploadDataRequestSync(@NonNull String str, @NonNull File file, @Nullable Map<String, String> map) {
        InputStream inputStream;
        FileInputStream fileInputStream;
        boolean z;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2 = null;
        OutputStream outputStream = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
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
                    outputStream = httpURLConnection.getOutputStream();
                    byte[] bArr = new byte[8096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                    }
                    outputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    inputStream = responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                    if (inputStream != null) {
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read2 = inputStream.read(bArr);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read2);
                                } catch (MalformedURLException e) {
                                    e = e;
                                    z = z2;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                    fileInputStream2 = fileInputStream;
                                    try {
                                        if (DEBUG) {
                                        }
                                        Closeables.closeSafely(outputStream);
                                        Closeables.closeSafely(fileInputStream2);
                                        Closeables.closeSafely(byteArrayOutputStream2);
                                        Closeables.closeSafely(inputStream);
                                        return new ResponseEntity(z);
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        Closeables.closeSafely(outputStream);
                                        Closeables.closeSafely(fileInputStream);
                                        Closeables.closeSafely(byteArrayOutputStream2);
                                        Closeables.closeSafely(inputStream);
                                        throw th;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    z = z2;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                    if (DEBUG) {
                                    }
                                    Closeables.closeSafely(outputStream);
                                    Closeables.closeSafely(fileInputStream);
                                    Closeables.closeSafely(byteArrayOutputStream2);
                                    Closeables.closeSafely(inputStream);
                                    return new ResponseEntity(z);
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                    Closeables.closeSafely(outputStream);
                                    Closeables.closeSafely(fileInputStream);
                                    Closeables.closeSafely(byteArrayOutputStream2);
                                    Closeables.closeSafely(inputStream);
                                    throw th;
                                }
                            }
                            byteArrayOutputStream.flush();
                        } catch (MalformedURLException e3) {
                            e = e3;
                            z = false;
                            fileInputStream2 = fileInputStream;
                            if (DEBUG) {
                                Log.d(TAG, Log.getStackTraceString(e));
                            }
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(fileInputStream2);
                            Closeables.closeSafely(byteArrayOutputStream2);
                            Closeables.closeSafely(inputStream);
                            return new ResponseEntity(z);
                        } catch (IOException e4) {
                            e = e4;
                            z = false;
                            if (DEBUG) {
                                Log.d(TAG, Log.getStackTraceString(e));
                            }
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(byteArrayOutputStream2);
                            Closeables.closeSafely(inputStream);
                            return new ResponseEntity(z);
                        }
                    } else {
                        byteArrayOutputStream = null;
                    }
                    String byteArrayOutputStream3 = byteArrayOutputStream != null ? byteArrayOutputStream.toString("utf-8") : null;
                    if (responseCode == 200 && !TextUtils.isEmpty(byteArrayOutputStream3)) {
                        try {
                            z2 = new JSONObject(byteArrayOutputStream3).optInt(BdStatsConstant.StatsType.ERROR, -1) == 0;
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (DEBUG) {
                        Log.d(TAG, "DefaultContentUploader: success = " + z2 + ", resultStr= " + byteArrayOutputStream3);
                    }
                    ResponseEntity responseEntity = new ResponseEntity(z2, byteArrayOutputStream3);
                    Closeables.closeSafely(outputStream);
                    Closeables.closeSafely(fileInputStream);
                    Closeables.closeSafely(byteArrayOutputStream);
                    Closeables.closeSafely(inputStream);
                    return responseEntity;
                } catch (MalformedURLException e6) {
                    e = e6;
                    z = false;
                    inputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (IOException e7) {
                    e = e7;
                    z = false;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (MalformedURLException e8) {
            e = e8;
            z = false;
            inputStream = null;
        } catch (IOException e9) {
            e = e9;
            z = false;
            inputStream = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            fileInputStream = null;
        }
    }
}
