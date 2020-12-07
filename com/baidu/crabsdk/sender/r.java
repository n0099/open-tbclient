package com.baidu.crabsdk.sender;

import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes8.dex */
public final class r {
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0137: ARRAY_LENGTH  (r4v10 int A[REMOVE]) = (r9v0 byte[]))] */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0103 A[Catch: Exception -> 0x0209, TryCatch #6 {Exception -> 0x0209, blocks: (B:20:0x00fe, B:22:0x0103, B:24:0x0108, B:26:0x010d), top: B:99:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0108 A[Catch: Exception -> 0x0209, TryCatch #6 {Exception -> 0x0209, blocks: (B:20:0x00fe, B:22:0x0103, B:24:0x0108, B:26:0x010d), top: B:99:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010d A[Catch: Exception -> 0x0209, TRY_LEAVE, TryCatch #6 {Exception -> 0x0209, blocks: (B:20:0x00fe, B:22:0x0103, B:24:0x0108, B:26:0x010d), top: B:99:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ad A[Catch: Exception -> 0x020f, TryCatch #1 {Exception -> 0x020f, blocks: (B:44:0x01a8, B:46:0x01ad, B:48:0x01b2, B:50:0x01b7), top: B:97:0x01a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b2 A[Catch: Exception -> 0x020f, TryCatch #1 {Exception -> 0x020f, blocks: (B:44:0x01a8, B:46:0x01ad, B:48:0x01b2, B:50:0x01b7), top: B:97:0x01a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b7 A[Catch: Exception -> 0x020f, TRY_LEAVE, TryCatch #1 {Exception -> 0x020f, blocks: (B:44:0x01a8, B:46:0x01ad, B:48:0x01b2, B:50:0x01b7), top: B:97:0x01a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, byte[] bArr, String str2, String str3) {
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        InputStreamReader inputStreamReader;
        DataOutputStream dataOutputStream2;
        String p;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        BufferedReader bufferedReader3 = null;
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
                    httpURLConnection2.setRequestProperty("User-Agent", g.a(str2, h.dR(str3)));
                }
                httpURLConnection2.setConnectTimeout(CoolPraiseGuideLottieView.ANIM_DURATION);
                httpURLConnection2.setReadTimeout(CoolPraiseGuideLottieView.ANIM_DURATION);
                dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                try {
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    StringBuffer stringBuffer = new StringBuffer();
                    com.baidu.crabsdk.c.a.dE("response code is " + httpURLConnection2.getResponseCode());
                    if (httpURLConnection2.getResponseCode() == 200) {
                        InputStreamReader inputStreamReader3 = new InputStreamReader(httpURLConnection2.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader3);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine).append("\n");
                                } catch (Exception e) {
                                    bufferedReader3 = bufferedReader;
                                    dataOutputStream2 = dataOutputStream;
                                    inputStreamReader = inputStreamReader3;
                                    httpURLConnection = httpURLConnection2;
                                    e = e;
                                    try {
                                        com.baidu.crabsdk.c.a.a("Upload Data Error!", e);
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                return "N/A";
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (bufferedReader3 != null) {
                                            bufferedReader3.close();
                                        }
                                        if (inputStreamReader == null) {
                                            inputStreamReader.close();
                                            return "N/A";
                                        }
                                        return "N/A";
                                    } catch (Throwable th) {
                                        th = th;
                                        dataOutputStream = dataOutputStream2;
                                        bufferedReader = bufferedReader3;
                                        inputStreamReader2 = inputStreamReader;
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
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader2 != null) {
                                            inputStreamReader2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    inputStreamReader2 = inputStreamReader3;
                                    httpURLConnection = httpURLConnection2;
                                    th = th2;
                                    if (dataOutputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader2 != null) {
                                    }
                                    throw th;
                                }
                            }
                            inputStreamReader3.close();
                            bufferedReader.close();
                            inputStreamReader2 = inputStreamReader3;
                            bufferedReader2 = bufferedReader;
                        } catch (Exception e4) {
                            dataOutputStream2 = dataOutputStream;
                            httpURLConnection = httpURLConnection2;
                            e = e4;
                            inputStreamReader = inputStreamReader3;
                        } catch (Throwable th3) {
                            bufferedReader = null;
                            inputStreamReader2 = inputStreamReader3;
                            httpURLConnection = httpURLConnection2;
                            th = th3;
                        }
                    } else {
                        stringBuffer.append("N/A");
                        bufferedReader2 = null;
                    }
                    try {
                        httpURLConnection2.disconnect();
                        String stringBuffer2 = stringBuffer.toString();
                        try {
                            dataOutputStream.close();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        return stringBuffer2;
                    } catch (Exception e6) {
                        dataOutputStream2 = dataOutputStream;
                        InputStreamReader inputStreamReader4 = inputStreamReader2;
                        bufferedReader3 = bufferedReader2;
                        httpURLConnection = httpURLConnection2;
                        e = e6;
                        inputStreamReader = inputStreamReader4;
                        com.baidu.crabsdk.c.a.a("Upload Data Error!", e);
                        if (dataOutputStream2 != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (bufferedReader3 != null) {
                        }
                        if (inputStreamReader == null) {
                        }
                    } catch (Throwable th4) {
                        bufferedReader = bufferedReader2;
                        httpURLConnection = httpURLConnection2;
                        th = th4;
                        if (dataOutputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    httpURLConnection = httpURLConnection2;
                    dataOutputStream2 = dataOutputStream;
                    e = e7;
                    inputStreamReader = null;
                } catch (Throwable th5) {
                    bufferedReader = null;
                    httpURLConnection = httpURLConnection2;
                    th = th5;
                }
            } catch (Exception e8) {
                httpURLConnection = httpURLConnection2;
                dataOutputStream2 = null;
                e = e8;
                inputStreamReader = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                httpURLConnection = httpURLConnection2;
                dataOutputStream = null;
                th = th6;
            }
        } catch (Exception e9) {
            e = e9;
            inputStreamReader = null;
            httpURLConnection = null;
            dataOutputStream2 = null;
        } catch (Throwable th7) {
            th = th7;
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
        Exception e;
        try {
            com.baidu.crabsdk.c.a.dE("发送数据的 url is : " + str2);
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                httpURLConnection.setRequestProperty("Encrypt-Data", str);
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(j));
                httpURLConnection.setRequestProperty("User-Agent", com.baidu.crabsdk.a.d);
                httpURLConnection.setRequestProperty("Encrypt-Type", "2");
                httpURLConnection.setRequestProperty("ver", "v5");
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return httpURLConnection;
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            e = e3;
        }
        return httpURLConnection;
    }
}
