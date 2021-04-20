package com.baidu.mobads.container.util;

import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class NetUtils {
    public static final int TIMEOUT_IN_MILLIONS = 5000;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x006c */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:28:0x006e, B:30:0x0073, B:32:0x0078), top: B:40:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078 A[Catch: all -> 0x007b, TRY_LEAVE, TryCatch #2 {all -> 0x007b, blocks: (B:28:0x006e, B:30:0x0073, B:32:0x0078), top: B:40:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String doGet(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                httpURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[128];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byteArrayOutputStream.flush();
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused) {
                                }
                            }
                            byteArrayOutputStream.close();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return byteArrayOutputStream2;
                        } catch (Throwable unused2) {
                            if (inputStream != null) {
                            }
                            if (byteArrayOutputStream != 0) {
                            }
                            if (httpURLConnection != null) {
                            }
                            return null;
                        }
                    } catch (Throwable unused3) {
                        byteArrayOutputStream = 0;
                    }
                } else {
                    throw new RuntimeException(" responseCode is not 200 ... ");
                }
            } catch (Throwable unused4) {
                inputStream = null;
                byteArrayOutputStream = inputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused5) {
                        return null;
                    }
                }
                if (byteArrayOutputStream != 0) {
                    byteArrayOutputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
        } catch (Throwable unused6) {
            httpURLConnection = null;
            inputStream = null;
        }
    }
}
