package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.Closeables;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes5.dex */
public class BOSTokenRequest {
    private static final String ACCEPT = "accept";
    private static final String ACCEPT_VALUE = "application/json";
    private static final String CHARSET = "Charset";
    private static final String CHARSET_VALUE = "UTF-8";
    private static final int CONNECT_TIMEOUT = 30000;
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_TYPE = "Content-type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String POST_METHOD = "POST";
    private static final int READ_TIMEOUT = 30000;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static STSInfo getBosStsInfo(@NonNull String str) {
        Throwable th;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader2;
        HttpURLConnection httpURLConnection2;
        StringBuilder sb = new StringBuilder();
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(UploadUrlProvider.getInstance().getUploadUrl()).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setConnectTimeout(30000);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestProperty(CHARSET, "UTF-8");
                httpURLConnection2.setRequestProperty(CONTENT_TYPE, HttpHelper.CONTENT_JSON);
                httpURLConnection2.setRequestProperty("accept", HttpHelper.CONTENT_JSON);
                String createRequest = ContentUtil.createRequest(str);
                if (createRequest == null || TextUtils.isEmpty(createRequest)) {
                    outputStream = null;
                } else {
                    httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(createRequest.getBytes("UTF-8").length));
                    outputStream = httpURLConnection2.getOutputStream();
                    try {
                        outputStream.write(createRequest.getBytes());
                        outputStream.flush();
                    } catch (IOException e) {
                        bufferedReader2 = null;
                        Closeables.closeSafely(outputStream);
                        Closeables.closeSafely(bufferedReader2);
                        if (httpURLConnection2 == null) {
                            httpURLConnection2.disconnect();
                            return null;
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection2;
                        Closeables.closeSafely(outputStream);
                        Closeables.closeSafely(bufferedReader);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (IOException e2) {
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(bufferedReader2);
                            if (httpURLConnection2 == null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                            httpURLConnection = httpURLConnection2;
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(bufferedReader);
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    bufferedReader2 = null;
                }
                Closeables.closeSafely(outputStream);
                Closeables.closeSafely(bufferedReader2);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return ContentUtil.createSTSFromResponse(sb.toString());
            } catch (IOException e3) {
                bufferedReader2 = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
            }
        } catch (IOException e4) {
            bufferedReader2 = null;
            outputStream = null;
            httpURLConnection2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            outputStream = null;
            httpURLConnection = null;
        }
    }
}
