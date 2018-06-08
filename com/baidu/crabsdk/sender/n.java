package com.baidu.crabsdk.sender;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public final class n {
    public static boolean Ty = false;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0117: ARRAY_LENGTH  (r4v8 int A[REMOVE]) = (r9v0 byte[]))] */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ec A[Catch: Exception -> 0x01a9, TryCatch #4 {Exception -> 0x01a9, blocks: (B:20:0x00e7, B:22:0x00ec, B:24:0x00f1, B:26:0x00f6), top: B:86:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f1 A[Catch: Exception -> 0x01a9, TryCatch #4 {Exception -> 0x01a9, blocks: (B:20:0x00e7, B:22:0x00ec, B:24:0x00f1, B:26:0x00f6), top: B:86:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f6 A[Catch: Exception -> 0x01a9, TRY_LEAVE, TryCatch #4 {Exception -> 0x01a9, blocks: (B:20:0x00e7, B:22:0x00ec, B:24:0x00f1, B:26:0x00f6), top: B:86:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0172 A[Catch: Exception -> 0x01af, TryCatch #1 {Exception -> 0x01af, blocks: (B:38:0x016d, B:40:0x0172, B:42:0x0177, B:44:0x017c), top: B:84:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0177 A[Catch: Exception -> 0x01af, TryCatch #1 {Exception -> 0x01af, blocks: (B:38:0x016d, B:40:0x0172, B:42:0x0177, B:44:0x017c), top: B:84:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017c A[Catch: Exception -> 0x01af, TRY_LEAVE, TryCatch #1 {Exception -> 0x01af, blocks: (B:38:0x016d, B:40:0x0172, B:42:0x0177, B:44:0x017c), top: B:84:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, byte[] bArr, String str2, String str3) {
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        InputStreamReader inputStreamReader;
        DataOutputStream dataOutputStream2;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        BufferedReader bufferedReader3 = null;
        com.baidu.crabsdk.c.a.cd("上传文件大小：" + (bArr.length / 1024) + "KB");
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestProperty(HTTP.CONTENT_ENCODING, "gzip");
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection2.setRequestProperty("EncryptType", "RSA-AES");
                com.baidu.crabsdk.c.a.cd("*** filename =  ***" + str3);
                if (str2.equals("Block")) {
                    com.baidu.crabsdk.c.a.cd("*** apiType == Block ***");
                    httpURLConnection2.setRequestProperty("EncryptData", str3);
                    httpURLConnection2.setRequestProperty(HTTP.USER_AGENT, d.a(str2, (String) null));
                } else if (str2.equals("NDK")) {
                    com.baidu.crabsdk.c.a.cd("*** apiType == NDK ***");
                    httpURLConnection2.setRequestProperty("EncryptData", str3);
                    httpURLConnection2.setRequestProperty(HTTP.CONTENT_LEN, new StringBuilder().append(bArr.length).toString());
                    httpURLConnection2.setRequestProperty(HTTP.USER_AGENT, d.a(str2, (String) null));
                } else {
                    com.baidu.crabsdk.c.a.cd("*** apiType != Block ***");
                    httpURLConnection2.setRequestProperty("EncryptData", e.k("key_" + str3));
                    httpURLConnection2.setRequestProperty(HTTP.USER_AGENT, d.a(str2, e.i(str3)));
                }
                httpURLConnection2.setConnectTimeout(3000);
                httpURLConnection2.setReadTimeout(3000);
                dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                try {
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    StringBuffer stringBuffer = new StringBuffer();
                    if (httpURLConnection2.getResponseCode() == 200) {
                        Ty = true;
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
                                        e.printStackTrace();
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                return "";
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
                                            return "";
                                        }
                                        return "";
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
                        e.printStackTrace();
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

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7 A[Catch: Exception -> 0x00ab, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ab, blocks: (B:28:0x00a2, B:30:0x00a7), top: B:44:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void pq() {
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        r2 = null;
        DataOutputStream dataOutputStream2 = null;
        try {
            String pl = d.pl();
            com.baidu.crabsdk.c.a.cd("sync json is " + pl);
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(com.baidu.crabsdk.a.c()).openConnection();
            try {
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setInstanceFollowRedirects(true);
                httpURLConnection3.setRequestProperty(HTTP.USER_AGENT, d.a("sync", (String) null));
                httpURLConnection3.setConnectTimeout(3000);
                httpURLConnection3.setReadTimeout(3000);
                dataOutputStream = new DataOutputStream(httpURLConnection3.getOutputStream());
            } catch (Exception e) {
                httpURLConnection = httpURLConnection3;
                e = e;
            } catch (Throwable th) {
                dataOutputStream = null;
                httpURLConnection2 = httpURLConnection3;
                th = th;
            }
            try {
                dataOutputStream.writeBytes(pl);
                dataOutputStream.flush();
                dataOutputStream.close();
                if (httpURLConnection3.getResponseCode() == 200) {
                    com.baidu.crabsdk.b.m.clear();
                    com.baidu.crabsdk.c.a.cb("#### ^@^ sync ok!");
                }
                httpURLConnection3.disconnect();
                try {
                    dataOutputStream.close();
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                dataOutputStream2 = dataOutputStream;
                e = e3;
                httpURLConnection = httpURLConnection3;
                try {
                    e.printStackTrace();
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    httpURLConnection2 = httpURLConnection;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection2 = httpURLConnection3;
                th = th3;
                if (dataOutputStream != null) {
                }
                if (httpURLConnection2 != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
        }
    }
}
