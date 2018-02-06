package com.baidu.ar.resloader.utils;

import android.net.http.Headers;
import com.baidu.ar.resloader.utils.IoUtils;
import com.baidu.ar.util.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class HttpUtils {
    private static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public static boolean downloadFile(String str, File file) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2 = null;
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
                    IoUtils.copyStream(inputStream2, file);
                    IoUtils.closeQuietly(inputStream2);
                    a(httpURLConnection3);
                    return true;
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
                    HttpURLConnection httpURLConnection4 = httpURLConnection;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection4;
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

    public static boolean downloadFile(String str, File file, IoUtils.Operation operation) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    inputStream2 = httpURLConnection3.getInputStream();
                } catch (IOException e) {
                    httpURLConnection = httpURLConnection3;
                    e = e;
                    try {
                        e.printStackTrace();
                        IoUtils.closeQuietly(null);
                        a(httpURLConnection);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        HttpURLConnection httpURLConnection4 = httpURLConnection;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection4;
                        IoUtils.closeQuietly(inputStream);
                        a(httpURLConnection2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                inputStream = null;
                httpURLConnection2 = httpURLConnection3;
                th = th2;
            }
            try {
                IoUtils.copyStream(inputStream2, file, httpURLConnection3.getContentLength(), operation);
                IoUtils.closeQuietly(inputStream2);
                a(httpURLConnection3);
                return true;
            } catch (Throwable th3) {
                inputStream = inputStream2;
                httpURLConnection2 = httpURLConnection3;
                th = th3;
                IoUtils.closeQuietly(inputStream);
                a(httpURLConnection2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4 A[Catch: IOException -> 0x00b8, TRY_LEAVE, TryCatch #2 {IOException -> 0x00b8, blocks: (B:27:0x00af, B:29:0x00b4), top: B:57:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6 A[Catch: IOException -> 0x00ca, TRY_LEAVE, TryCatch #0 {IOException -> 0x00ca, blocks: (B:36:0x00c1, B:38:0x00c6), top: B:55:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String post(String str, String str2) {
        PrintWriter printWriter;
        PrintWriter printWriter2;
        Exception e;
        String str3;
        BufferedReader bufferedReader = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            httpURLConnection.setRequestProperty("charset", "utf-8");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(Constants.HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setConnectTimeout(30000);
            if (str2 == null || str2.trim().equals("")) {
                printWriter = null;
            } else {
                printWriter2 = new PrintWriter(httpURLConnection.getOutputStream());
                try {
                    try {
                        printWriter2.print(str2);
                        printWriter2.flush();
                        printWriter = printWriter2;
                    } catch (Exception e2) {
                        str3 = "";
                        e = e2;
                        e.printStackTrace();
                        if (printWriter2 != null) {
                            try {
                                printWriter2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str3;
                    }
                } catch (Throwable th) {
                    th = th;
                    printWriter = printWriter2;
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                str3 = "";
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str3 = str3 + readLine;
                    } catch (Exception e5) {
                        e = e5;
                        bufferedReader = bufferedReader2;
                        printWriter2 = printWriter;
                        e.printStackTrace();
                        if (printWriter2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        return str3;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (printWriter != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                if (printWriter != null) {
                    try {
                        printWriter.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
            } catch (Exception e7) {
                printWriter2 = printWriter;
                e = e7;
                str3 = "";
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e8) {
            printWriter2 = null;
            e = e8;
            str3 = "";
        } catch (Throwable th4) {
            th = th4;
            printWriter = null;
        }
        return str3;
    }
}
