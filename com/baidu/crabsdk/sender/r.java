package com.baidu.crabsdk.sender;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes.dex */
public final class r {
    public static String a(String str, byte[] bArr, String str2) {
        if (bArr == null) {
            com.baidu.crabsdk.c.a.d("data is null !!!!");
            return null;
        }
        return c(d(bArr.length, str2, str), bArr);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x01bc */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0097: ARRAY_LENGTH  (r4v2 int A[REMOVE]) = (r9v0 byte[]))] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c8 A[Catch: all -> 0x018c, Exception -> 0x018f, TryCatch #14 {Exception -> 0x018f, all -> 0x018c, blocks: (B:4:0x0027, B:7:0x0069, B:8:0x0078, B:24:0x00f4, B:9:0x007d, B:11:0x0085, B:12:0x00a7, B:19:0x00c0, B:21:0x00c8, B:23:0x00e8, B:22:0x00e5, B:15:0x00b1, B:18:0x00bc), top: B:108:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e5 A[Catch: all -> 0x018c, Exception -> 0x018f, TryCatch #14 {Exception -> 0x018f, all -> 0x018c, blocks: (B:4:0x0027, B:7:0x0069, B:8:0x0078, B:24:0x00f4, B:9:0x007d, B:11:0x0085, B:12:0x00a7, B:19:0x00c0, B:21:0x00c8, B:23:0x00e8, B:22:0x00e5, B:15:0x00b1, B:18:0x00bc), top: B:108:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01aa A[Catch: Exception -> 0x01a6, TryCatch #10 {Exception -> 0x01a6, blocks: (B:74:0x01a2, B:78:0x01aa, B:80:0x01af, B:82:0x01b4), top: B:102:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01af A[Catch: Exception -> 0x01a6, TryCatch #10 {Exception -> 0x01a6, blocks: (B:74:0x01a2, B:78:0x01aa, B:80:0x01af, B:82:0x01b4), top: B:102:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b4 A[Catch: Exception -> 0x01a6, TRY_LEAVE, TryCatch #10 {Exception -> 0x01a6, blocks: (B:74:0x01a2, B:78:0x01aa, B:80:0x01af, B:82:0x01b4), top: B:102:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c7 A[Catch: Exception -> 0x01c3, TryCatch #13 {Exception -> 0x01c3, blocks: (B:88:0x01bf, B:92:0x01c7, B:94:0x01cc, B:96:0x01d1), top: B:106:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cc A[Catch: Exception -> 0x01c3, TryCatch #13 {Exception -> 0x01c3, blocks: (B:88:0x01bf, B:92:0x01c7, B:94:0x01cc, B:96:0x01d1), top: B:106:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d1 A[Catch: Exception -> 0x01c3, TRY_LEAVE, TryCatch #13 {Exception -> 0x01c3, blocks: (B:88:0x01bf, B:92:0x01c7, B:94:0x01cc, B:96:0x01d1), top: B:106:0x01bf }] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, byte[] bArr, String str2, String str3) {
        HttpURLConnection httpURLConnection;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String y;
        String b2;
        DataOutputStream dataOutputStream = null;
        r1 = null;
        r1 = null;
        BufferedReader bufferedReader2 = null;
        dataOutputStream = null;
        try {
            com.baidu.crabsdk.c.a.c("Upload data size is: " + (bArr.length / 1024) + "KB");
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                com.baidu.crabsdk.c.a.c("*** filename =  ***" + str3);
                if (str2.equals("Block")) {
                    com.baidu.crabsdk.c.a.c("*** apiType == Block ***");
                    httpURLConnection.setRequestProperty("EncryptType", "RSA-AES");
                    httpURLConnection.setRequestProperty("EncryptData", str3);
                    b2 = g.b(str2, null);
                } else if (str2.equals("NDK")) {
                    com.baidu.crabsdk.c.a.c("*** apiType == NDK ***");
                    httpURLConnection.setRequestProperty("EncryptType", "RSA-AES");
                    httpURLConnection.setRequestProperty("EncryptData", str3);
                    StringBuilder sb = new StringBuilder();
                    sb.append(bArr.length);
                    httpURLConnection.setRequestProperty("Content-Length", sb.toString());
                    b2 = g.b(str2, null);
                } else {
                    if (!str2.equals("Log")) {
                        if (str2.equals("Traces")) {
                            str2 = "Anr";
                        } else {
                            y = h.y(str3);
                            if (y.startsWith("NoEncrypt_")) {
                                httpURLConnection.setRequestProperty("EncryptType", "RSA-AES");
                            } else {
                                httpURLConnection.setRequestProperty("EncryptType", "RSA-AES2");
                                y = y.substring(10);
                                com.baidu.crabsdk.c.a.c("real rsaAesKey is: " + y);
                            }
                            httpURLConnection.setRequestProperty("EncryptData", y);
                            b2 = g.b(str2, h.w(str3));
                        }
                    }
                    y = str3;
                    if (y.startsWith("NoEncrypt_")) {
                    }
                    httpURLConnection.setRequestProperty("EncryptData", y);
                    b2 = g.b(str2, h.w(str3));
                }
                httpURLConnection.setRequestProperty("User-Agent", b2);
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(8000);
                DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                    StringBuffer stringBuffer = new StringBuffer();
                    com.baidu.crabsdk.c.a.b("response code is " + httpURLConnection.getResponseCode());
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine);
                                    stringBuffer.append("\n");
                                } catch (Exception e2) {
                                    e = e2;
                                    dataOutputStream = dataOutputStream2;
                                    bufferedReader = bufferedReader;
                                    try {
                                        com.baidu.crabsdk.c.a.a("Upload Data Error!", e);
                                        if (dataOutputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        if (bufferedReader != 0) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        return "N/A";
                                    } catch (Throwable th) {
                                        th = th;
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (bufferedReader != 0) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    dataOutputStream = dataOutputStream2;
                                    if (dataOutputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (bufferedReader != 0) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    throw th;
                                }
                            }
                            inputStreamReader.close();
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                        }
                    } else {
                        stringBuffer.append("N/A");
                        inputStreamReader = null;
                    }
                    httpURLConnection.disconnect();
                    String stringBuffer2 = stringBuffer.toString();
                    try {
                        dataOutputStream2.close();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    return stringBuffer2;
                } catch (Exception e6) {
                    e = e6;
                    inputStreamReader = null;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Exception e7) {
                e = e7;
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                com.baidu.crabsdk.c.a.a("Upload Data Error!", e);
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        return "N/A";
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader != 0) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                return "N/A";
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                if (dataOutputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                if (bufferedReader != 0) {
                }
                if (inputStreamReader != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            httpURLConnection = null;
            inputStreamReader = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            inputStreamReader = null;
        }
    }

    public static String c(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            outputStream.close();
            StringBuilder sb = new StringBuilder();
            if (httpURLConnection.getResponseCode() != 200) {
                com.baidu.crabsdk.c.a.c("Failed! ResponseCode == " + httpURLConnection.getResponseCode());
                return "N/A";
            }
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    inputStreamReader.close();
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    return sb.toString();
                }
                sb.append(readLine);
                sb.append("\n");
            }
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("GetResponse Error!", e2);
            return "N/A";
        }
    }

    public static HttpURLConnection d(long j, String str, String str2) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            com.baidu.crabsdk.c.a.b("发送数据的 url is : " + str2);
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            httpURLConnection.setRequestProperty("Encrypt-Data", str);
            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(j));
            httpURLConnection.setRequestProperty("User-Agent", com.baidu.crabsdk.a.f4636d);
            httpURLConnection.setRequestProperty("Encrypt-Type", "2");
            httpURLConnection.setRequestProperty("ver", "v5");
            return httpURLConnection;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection2 = httpURLConnection;
            e.printStackTrace();
            return httpURLConnection2;
        }
    }
}
