package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class BOSTokenRequest {
    public static final String ACCEPT = "accept";
    public static final String ACCEPT_VALUE = "application/json";
    public static final String CHARSET = "Charset";
    public static final String CHARSET_VALUE = "UTF-8";
    public static final int CONNECT_TIMEOUT = 30000;
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_TYPE = "Content-type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
    public static final String POST_METHOD = "POST";
    public static final int READ_TIMEOUT = 30000;

    /* JADX DEBUG: Multi-variable search result rejected for r7v13, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static STSInfo getBosStsInfo(@NonNull String str) {
        Closeable closeable;
        HttpURLConnection httpURLConnection;
        Closeable closeable2;
        OutputStream outputStream;
        StringBuilder sb = new StringBuilder();
        OutputStream outputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(UploadUrlProvider.getInstance().getUploadUrl()).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty(CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("Content-type", "application/json");
                httpURLConnection.setRequestProperty(ACCEPT, "application/json");
                String createRequest = ContentUtil.createRequest(str);
                if (createRequest != null && !TextUtils.isEmpty(createRequest)) {
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(createRequest.getBytes("UTF-8").length));
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(createRequest.getBytes());
                        outputStream.flush();
                    } catch (IOException unused) {
                        closeable2 = null;
                        Closeables.closeSafely(outputStream);
                        Closeables.closeSafely(closeable2);
                        if (httpURLConnection != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        outputStream2 = outputStream;
                        closeable = null;
                        Closeables.closeSafely(outputStream2);
                        Closeables.closeSafely(closeable);
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (IOException unused2) {
                            closeable2 = bufferedReader;
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(closeable2);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        } catch (Throwable th2) {
                            outputStream2 = outputStream;
                            closeable = bufferedReader;
                            th = th2;
                            Closeables.closeSafely(outputStream2);
                            Closeables.closeSafely(closeable);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    outputStream2 = bufferedReader;
                }
                Closeables.closeSafely(outputStream);
                Closeables.closeSafely(outputStream2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return ContentUtil.createSTSFromResponse(sb.toString());
            } catch (IOException unused3) {
                closeable2 = null;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
            }
        } catch (IOException unused4) {
            closeable2 = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            httpURLConnection = null;
        }
    }
}
