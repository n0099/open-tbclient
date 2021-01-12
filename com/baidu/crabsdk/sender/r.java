package com.baidu.crabsdk.sender;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes14.dex */
public final class r {
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0132: ARRAY_LENGTH  (r4v9 int A[REMOVE]) = (r8v0 byte[]))] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fe A[Catch: Exception -> 0x0203, TryCatch #12 {Exception -> 0x0203, blocks: (B:20:0x00f9, B:22:0x00fe, B:24:0x0103, B:26:0x0108), top: B:98:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0103 A[Catch: Exception -> 0x0203, TryCatch #12 {Exception -> 0x0203, blocks: (B:20:0x00f9, B:22:0x00fe, B:24:0x0103, B:26:0x0108), top: B:98:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0108 A[Catch: Exception -> 0x0203, TRY_LEAVE, TryCatch #12 {Exception -> 0x0203, blocks: (B:20:0x00f9, B:22:0x00fe, B:24:0x0103, B:26:0x0108), top: B:98:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a8 A[Catch: Exception -> 0x0209, TryCatch #4 {Exception -> 0x0209, blocks: (B:44:0x01a3, B:46:0x01a8, B:48:0x01ad, B:50:0x01b2), top: B:94:0x01a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ad A[Catch: Exception -> 0x0209, TryCatch #4 {Exception -> 0x0209, blocks: (B:44:0x01a3, B:46:0x01a8, B:48:0x01ad, B:50:0x01b2), top: B:94:0x01a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b2 A[Catch: Exception -> 0x0209, TRY_LEAVE, TryCatch #4 {Exception -> 0x0209, blocks: (B:44:0x01a3, B:46:0x01a8, B:48:0x01ad, B:50:0x01b2), top: B:94:0x01a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, byte[] bArr, String str2, String str3) {
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        Exception e;
        String p;
        try {
            com.baidu.crabsdk.c.a.v("Upload data size is: " + (bArr.length / 1024) + "KB");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestProperty("Content-Encoding", "gzip");
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setRequestProperty("Content-Type", "application/octet-stream");
                com.baidu.crabsdk.c.a.v("*** filename =  ***" + str3);
                if (str2.equals("Block")) {
                    com.baidu.crabsdk.c.a.v("*** apiType == Block ***");
                    httpURLConnection2.setRequestProperty("EncryptType", "RSA-AES");
                    httpURLConnection2.setRequestProperty("EncryptData", str3);
                    httpURLConnection2.setRequestProperty("User-Agent", g.a(str2, (String) null));
                } else if (str2.equals("NDK")) {
                    com.baidu.crabsdk.c.a.v("*** apiType == NDK ***");
                    httpURLConnection2.setRequestProperty("EncryptType", "RSA-AES");
                    httpURLConnection2.setRequestProperty("EncryptData", str3);
                    httpURLConnection2.setRequestProperty("Content-Length", new StringBuilder().append(bArr.length).toString());
                    httpURLConnection2.setRequestProperty("User-Agent", g.a(str2, (String) null));
                } else {
                    if (str2.equals("Log")) {
                        p = str3;
                    } else if (str2.equals("Traces")) {
                        str2 = "Anr";
                        p = str3;
                    } else {
                        p = h.p(str3);
                    }
                    if (p.startsWith("NoEncrypt_")) {
                        httpURLConnection2.setRequestProperty("EncryptType", "RSA-AES2");
                        p = p.substring(10);
                        com.baidu.crabsdk.c.a.v("real rsaAesKey is: " + p);
                    } else {
                        httpURLConnection2.setRequestProperty("EncryptType", "RSA-AES");
                    }
                    httpURLConnection2.setRequestProperty("EncryptData", p);
                    httpURLConnection2.setRequestProperty("User-Agent", g.a(str2, h.dD(str3)));
                }
                httpURLConnection2.setConnectTimeout(8000);
                httpURLConnection2.setReadTimeout(8000);
                dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                try {
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    StringBuffer stringBuffer = new StringBuffer();
                    com.baidu.crabsdk.c.a.ds("response code is " + httpURLConnection2.getResponseCode());
                    if (httpURLConnection2.getResponseCode() == 200) {
                        inputStreamReader = new InputStreamReader(httpURLConnection2.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine).append("\n");
                                } catch (Exception e2) {
                                    e = e2;
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        com.baidu.crabsdk.c.a.a("Upload Data Error!", e);
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                return "N/A";
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader == null) {
                                            inputStreamReader.close();
                                            return "N/A";
                                        }
                                        return "N/A";
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    httpURLConnection = httpURLConnection2;
                                    if (dataOutputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    throw th;
                                }
                            }
                            inputStreamReader.close();
                            bufferedReader.close();
                        } catch (Exception e5) {
                            e = e5;
                            bufferedReader = null;
                            httpURLConnection = httpURLConnection2;
                            com.baidu.crabsdk.c.a.a("Upload Data Error!", e);
                            if (dataOutputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader == null) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = null;
                            httpURLConnection = httpURLConnection2;
                            if (dataOutputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            throw th;
                        }
                    } else {
                        stringBuffer.append("N/A");
                        inputStreamReader = null;
                        bufferedReader = null;
                    }
                    httpURLConnection2.disconnect();
                    String stringBuffer2 = stringBuffer.toString();
                    try {
                        dataOutputStream.close();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    return stringBuffer2;
                } catch (Exception e7) {
                    e = e7;
                    inputStreamReader = null;
                    bufferedReader = null;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = null;
                    bufferedReader = null;
                    httpURLConnection = httpURLConnection2;
                }
            } catch (Exception e8) {
                e = e8;
                inputStreamReader = null;
                bufferedReader = null;
                httpURLConnection = httpURLConnection2;
                dataOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                inputStreamReader = null;
                bufferedReader = null;
                httpURLConnection = httpURLConnection2;
                dataOutputStream = null;
            }
        } catch (Exception e9) {
            e = e9;
            inputStreamReader = null;
            bufferedReader = null;
            httpURLConnection = null;
            dataOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            inputStreamReader = null;
            bufferedReader = null;
            httpURLConnection = null;
            dataOutputStream = null;
        }
    }

    public static String b(String str, byte[] bArr, String str2) {
        if (bArr == null) {
            com.baidu.crabsdk.c.a.w("data is null !!!!");
            return null;
        }
        return b(b(bArr.length, str2, str), bArr);
    }

    private static String b(HttpURLConnection httpURLConnection, byte[] bArr) {
        StringBuilder sb;
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            outputStream.close();
            sb = new StringBuilder();
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("GetResponse Error!", e);
        }
        if (httpURLConnection.getResponseCode() != 200) {
            com.baidu.crabsdk.c.a.v("Failed! ResponseCode == " + httpURLConnection.getResponseCode());
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
            sb.append(readLine).append("\n");
        }
    }

    private static HttpURLConnection b(long j, String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            com.baidu.crabsdk.c.a.ds("发送数据的 url is : " + str2);
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                httpURLConnection.setReadTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                httpURLConnection.setRequestProperty("Encrypt-Data", str);
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(j));
                httpURLConnection.setRequestProperty("User-Agent", com.baidu.crabsdk.a.d);
                httpURLConnection.setRequestProperty("Encrypt-Type", "2");
                httpURLConnection.setRequestProperty("ver", "v5");
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return httpURLConnection;
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = null;
        }
        return httpURLConnection;
    }
}
