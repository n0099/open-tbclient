package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.Closeables;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes16.dex */
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
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static STSInfo getBosStsInfo(String str) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection2;
        BufferedReader bufferedReader2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(UploadUrlProvider.getInstance().getUploadUrl()).openConnection();
            try {
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.setReadTimeout(30000);
                httpURLConnection3.setConnectTimeout(30000);
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setInstanceFollowRedirects(true);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setRequestProperty(CHARSET, "UTF-8");
                httpURLConnection3.setRequestProperty(CONTENT_TYPE, HttpHelper.CONTENT_JSON);
                httpURLConnection3.setRequestProperty("accept", HttpHelper.CONTENT_JSON);
                String createRequest = ContentUtil.createRequest(str);
                if (createRequest == null || TextUtils.isEmpty(createRequest)) {
                    outputStream = null;
                } else {
                    httpURLConnection3.setRequestProperty("Content-Length", String.valueOf(createRequest.getBytes("UTF-8").length));
                    OutputStream outputStream3 = httpURLConnection3.getOutputStream();
                    try {
                        outputStream3.write(createRequest.getBytes());
                        outputStream3.flush();
                        outputStream = outputStream3;
                    } catch (IOException e) {
                        httpURLConnection2 = httpURLConnection3;
                        outputStream2 = outputStream3;
                        bufferedReader = null;
                        Closeables.closeSafely(outputStream2);
                        Closeables.closeSafely(bufferedReader);
                        if (httpURLConnection2 == null) {
                            httpURLConnection2.disconnect();
                            return null;
                        }
                        return null;
                    } catch (Throwable th) {
                        outputStream = outputStream3;
                        httpURLConnection = httpURLConnection3;
                        th = th;
                        Closeables.closeSafely(outputStream);
                        Closeables.closeSafely(bufferedReader2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                try {
                    if (httpURLConnection3.getResponseCode() == 200) {
                        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection3.getInputStream()));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            } catch (IOException e2) {
                                OutputStream outputStream4 = outputStream;
                                httpURLConnection2 = httpURLConnection3;
                                outputStream2 = outputStream4;
                                Closeables.closeSafely(outputStream2);
                                Closeables.closeSafely(bufferedReader);
                                if (httpURLConnection2 == null) {
                                }
                            } catch (Throwable th2) {
                                bufferedReader2 = bufferedReader;
                                httpURLConnection = httpURLConnection3;
                                th = th2;
                                Closeables.closeSafely(outputStream);
                                Closeables.closeSafely(bufferedReader2);
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                        }
                    } else {
                        bufferedReader = null;
                    }
                    Closeables.closeSafely(outputStream);
                    Closeables.closeSafely(bufferedReader);
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    return ContentUtil.createSTSFromResponse(sb.toString());
                } catch (IOException e3) {
                    bufferedReader = null;
                    OutputStream outputStream5 = outputStream;
                    httpURLConnection2 = httpURLConnection3;
                    outputStream2 = outputStream5;
                } catch (Throwable th3) {
                    httpURLConnection = httpURLConnection3;
                    th = th3;
                }
            } catch (IOException e4) {
                bufferedReader = null;
                httpURLConnection2 = httpURLConnection3;
                outputStream2 = null;
            } catch (Throwable th4) {
                outputStream = null;
                httpURLConnection = httpURLConnection3;
                th = th4;
            }
        } catch (IOException e5) {
            bufferedReader = null;
            outputStream2 = null;
            httpURLConnection2 = null;
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            httpURLConnection = null;
        }
    }
}
