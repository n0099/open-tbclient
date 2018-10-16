package com.baidu.ar.util;

import android.net.http.Headers;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.UploadFileAction;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class HttpUtils {
    private static final String a = UUID.randomUUID().toString();

    private static File a(File file) {
        return new File(file.getAbsolutePath() + ".tmp" + System.currentTimeMillis());
    }

    private static StringBuffer a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    stringBuffer.append("--");
                    stringBuffer.append(a);
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + SystemInfoUtil.LINE_END);
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), IoUtils.UTF_8));
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    private static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public static boolean downloadFile(String str, File file) {
        return downloadFile(str, file, null);
    }

    public static boolean downloadFile(String str, File file, IoUtils.Operation operation) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2 = null;
        File a2 = a(file);
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    inputStream2 = httpURLConnection3.getInputStream();
                } catch (Throwable th) {
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection3;
                    th = th;
                }
                try {
                    int contentLength = httpURLConnection3.getContentLength();
                    IoUtils.copyStream(inputStream2, a2, contentLength, operation);
                    if (contentLength != a2.length()) {
                        IoUtils.closeQuietly(inputStream2);
                        a(httpURLConnection3);
                        return false;
                    }
                    FileUtils.deleteFileIfExist(file);
                    boolean renameTo = a2.renameTo(file);
                    IoUtils.closeQuietly(inputStream2);
                    a(httpURLConnection3);
                    return renameTo;
                } catch (Throwable th2) {
                    inputStream = inputStream2;
                    httpURLConnection2 = httpURLConnection3;
                    th = th2;
                    IoUtils.closeQuietly(inputStream);
                    a(httpURLConnection2);
                    throw th;
                }
            } catch (IOException e) {
                httpURLConnection = httpURLConnection3;
                e = e;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(null);
                    a(httpURLConnection);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    IoUtils.closeQuietly(inputStream);
                    a(httpURLConnection2);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static int getLength(String str) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = 0;
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection2 = 10000;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            httpURLConnection.setConnectTimeout(10000);
            int contentLength = httpURLConnection.getContentLength();
            a(httpURLConnection);
            return contentLength;
        } catch (IOException e2) {
            httpURLConnection3 = httpURLConnection;
            e = e2;
            e.printStackTrace();
            a(httpURLConnection3);
            return 0;
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            a((HttpURLConnection) httpURLConnection2);
            throw th;
        }
    }

    public static String getUrlAsString(String str) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                inputStream = httpURLConnection3.getInputStream();
            } catch (IOException e) {
                inputStream = null;
                e = e;
                httpURLConnection = httpURLConnection3;
            } catch (Throwable th) {
                inputStream = null;
                httpURLConnection2 = httpURLConnection3;
                th = th;
            }
            try {
                String loadContent = IoUtils.loadContent(inputStream);
                IoUtils.closeQuietly(inputStream);
                a(httpURLConnection3);
                return loadContent;
            } catch (IOException e2) {
                httpURLConnection = httpURLConnection3;
                e = e2;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(inputStream);
                    a(httpURLConnection);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    IoUtils.closeQuietly(inputStream);
                    a(httpURLConnection2);
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection2 = httpURLConnection3;
                th = th3;
                IoUtils.closeQuietly(inputStream);
                a(httpURLConnection2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public static String post(String str, String str2) {
        PrintWriter printWriter;
        InputStream inputStream = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                httpURLConnection.setRequestProperty("charset", IoUtils.UTF_8);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setReadTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
                httpURLConnection.setConnectTimeout(30000);
                if (str2 == null || str2.trim().equals("")) {
                    printWriter = null;
                } else {
                    printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                    try {
                        printWriter.print(str2);
                        printWriter.flush();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        IoUtils.closeQuietly(printWriter);
                        IoUtils.closeQuietly(inputStream);
                        return "";
                    }
                }
                inputStream = httpURLConnection.getInputStream();
                String loadContent = IoUtils.loadContent(inputStream);
                IoUtils.closeQuietly(printWriter);
                IoUtils.closeQuietly(inputStream);
                return loadContent;
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly(null);
                IoUtils.closeQuietly(null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            printWriter = null;
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeQuietly(null);
            IoUtils.closeQuietly(null);
            throw th;
        }
    }

    public static String postRequest(String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        OutputStream outputStream3 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setConnectTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
                httpURLConnection3.setReadTimeout(30000);
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection3.setRequestProperty("Content-Type", "application/json");
                outputStream2 = httpURLConnection3.getOutputStream();
                try {
                    outputStream2.write(str2.getBytes(StandardCharsets.UTF_8));
                    outputStream2.flush();
                    inputStream = httpURLConnection3.getInputStream();
                } catch (IOException e) {
                    httpURLConnection2 = httpURLConnection3;
                    e = e;
                    outputStream = outputStream2;
                    inputStream2 = null;
                } catch (Throwable th) {
                    inputStream = null;
                    outputStream3 = outputStream2;
                    httpURLConnection = httpURLConnection3;
                    th = th;
                }
            } catch (IOException e2) {
                inputStream2 = null;
                httpURLConnection2 = httpURLConnection3;
                e = e2;
                outputStream = null;
            } catch (Throwable th2) {
                inputStream = null;
                httpURLConnection = httpURLConnection3;
                th = th2;
            }
            try {
                String loadContent = IoUtils.loadContent(inputStream);
                a(httpURLConnection3);
                IoUtils.closeQuietly(outputStream2);
                IoUtils.closeQuietly(inputStream);
                return loadContent;
            } catch (IOException e3) {
                outputStream = outputStream2;
                inputStream2 = inputStream;
                httpURLConnection2 = httpURLConnection3;
                e = e3;
                try {
                    e.printStackTrace();
                    a(httpURLConnection2);
                    IoUtils.closeQuietly(outputStream);
                    IoUtils.closeQuietly(inputStream2);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream3 = outputStream;
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream2;
                    a(httpURLConnection);
                    IoUtils.closeQuietly(outputStream3);
                    IoUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                httpURLConnection = httpURLConnection3;
                th = th4;
                outputStream3 = outputStream2;
                a(httpURLConnection);
                IoUtils.closeQuietly(outputStream3);
                IoUtils.closeQuietly(inputStream);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            outputStream = null;
            inputStream2 = null;
            httpURLConnection2 = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x016b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    public static String uploadFile(String str, HashMap hashMap, byte[] bArr) {
        DataOutputStream dataOutputStream;
        String str2;
        ?? r2 = UploadFileAction.PARAMS_UPLOADFILE_CONTENT_TYPE;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Charset", IoUtils.UTF_8);
                httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty("Content-Type", UploadFileAction.PARAMS_UPLOADFILE_CONTENT_TYPE + ";boundary=" + a);
                if (bArr != null) {
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        dataOutputStream.write(a(hashMap).toString().getBytes(StandardCharsets.UTF_8));
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("--");
                        stringBuffer.append(a);
                        stringBuffer.append(SystemInfoUtil.LINE_END);
                        stringBuffer.append("Content-Disposition: form-data; name=\"image\"; filename=\"" + (System.currentTimeMillis() + ".jpg") + "\"" + SystemInfoUtil.LINE_END);
                        stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8\r\n");
                        stringBuffer.append(SystemInfoUtil.LINE_END);
                        dataOutputStream.write(stringBuffer.toString().getBytes());
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = byteArrayInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            dataOutputStream.write(bArr2, 0, read);
                        }
                        byteArrayInputStream.close();
                        dataOutputStream.write(SystemInfoUtil.LINE_END.getBytes());
                        dataOutputStream.write(("--" + a + "--" + SystemInfoUtil.LINE_END).getBytes());
                        dataOutputStream.flush();
                        str2 = httpURLConnection.getResponseCode() == 200 ? IoUtils.loadContent(httpURLConnection.getInputStream()) : null;
                    } catch (MalformedURLException e) {
                        e = e;
                        e.printStackTrace();
                        IoUtils.closeQuietly(dataOutputStream);
                        IoUtils.closeQuietly(null);
                        return null;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        IoUtils.closeQuietly(dataOutputStream);
                        IoUtils.closeQuietly(null);
                        return null;
                    }
                } else {
                    str2 = null;
                    dataOutputStream = null;
                }
                IoUtils.closeQuietly(dataOutputStream);
                IoUtils.closeQuietly(null);
                return str2;
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly(r2);
                IoUtils.closeQuietly(null);
                throw th;
            }
        } catch (MalformedURLException e3) {
            e = e3;
            dataOutputStream = null;
        } catch (IOException e4) {
            e = e4;
            dataOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            IoUtils.closeQuietly(r2);
            IoUtils.closeQuietly(null);
            throw th;
        }
    }
}
