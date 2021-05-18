package com.baidu.crabsdk.lite.sender;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class i {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x0197 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00a3: ARRAY_LENGTH  (r4v2 int A[REMOVE]) = (r8v0 byte[]))] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0185 A[Catch: Exception -> 0x0181, TryCatch #13 {Exception -> 0x0181, blocks: (B:65:0x017d, B:69:0x0185, B:71:0x018a, B:73:0x018f), top: B:98:0x017d }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018a A[Catch: Exception -> 0x0181, TryCatch #13 {Exception -> 0x0181, blocks: (B:65:0x017d, B:69:0x0185, B:71:0x018a, B:73:0x018f), top: B:98:0x017d }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018f A[Catch: Exception -> 0x0181, TRY_LEAVE, TryCatch #13 {Exception -> 0x0181, blocks: (B:65:0x017d, B:69:0x0185, B:71:0x018a, B:73:0x018f), top: B:98:0x017d }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a2 A[Catch: Exception -> 0x019e, TryCatch #6 {Exception -> 0x019e, blocks: (B:79:0x019a, B:83:0x01a2, B:85:0x01a7, B:87:0x01ac), top: B:94:0x019a }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a7 A[Catch: Exception -> 0x019e, TryCatch #6 {Exception -> 0x019e, blocks: (B:79:0x019a, B:83:0x01a2, B:85:0x01a7, B:87:0x01ac), top: B:94:0x019a }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ac A[Catch: Exception -> 0x019e, TRY_LEAVE, TryCatch #6 {Exception -> 0x019e, blocks: (B:79:0x019a, B:83:0x01a2, B:85:0x01a7, B:87:0x01ac), top: B:94:0x019a }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, byte[] bArr, String str3, String str4) {
        HttpURLConnection httpURLConnection;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        URLConnection openConnection;
        String a2;
        com.baidu.crabsdk.lite.b.a.c(str, "上传文件大小：" + (bArr.length / 1024) + "KB");
        DataOutputStream dataOutputStream = null;
        r1 = null;
        r1 = null;
        BufferedReader bufferedReader2 = null;
        dataOutputStream = null;
        try {
            URL url = new URL(str2);
            if (com.baidu.crabsdk.lite.a.l != null) {
                HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4716a.get(str);
                if (hashMap != null) {
                    Object obj = hashMap.get("domain_proxy");
                    openConnection = obj != null ? url.openConnection((Proxy) obj) : url.openConnection();
                } else {
                    openConnection = url.openConnection();
                }
            } else {
                openConnection = url.openConnection();
            }
            httpURLConnection = (HttpURLConnection) openConnection;
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.setRequestProperty("EncryptType", "RSA-AES");
                com.baidu.crabsdk.lite.b.a.c(str, "*** filename =  ***" + str4);
                if (str3.equals("NDK")) {
                    com.baidu.crabsdk.lite.b.a.c(str, "*** apiType == NDK ***");
                    httpURLConnection.setRequestProperty("EncryptData", str4);
                    StringBuilder sb = new StringBuilder();
                    sb.append(bArr.length);
                    httpURLConnection.setRequestProperty("Content-Length", sb.toString());
                    a2 = b.a(str, str3, null);
                } else {
                    com.baidu.crabsdk.lite.b.a.c(str, "*** apiType == " + str3 + "***");
                    StringBuilder sb2 = new StringBuilder("key_");
                    sb2.append(str4);
                    httpURLConnection.setRequestProperty("EncryptData", c.n(str, sb2.toString()));
                    a2 = b.a(str, str3, c.l(str, str4));
                }
                httpURLConnection.setRequestProperty("User-Agent", a2);
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setReadTimeout(3000);
                DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                    StringBuffer stringBuffer = new StringBuffer();
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
                                } catch (Exception unused) {
                                    dataOutputStream = dataOutputStream2;
                                    bufferedReader = bufferedReader;
                                    try {
                                        com.baidu.crabsdk.lite.b.a.d(str, "Upload Data Error!");
                                        if (dataOutputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        if (bufferedReader != 0) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        return "500";
                                    } catch (Throwable th) {
                                        th = th;
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
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
                        } catch (Exception unused2) {
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                        }
                    } else {
                        stringBuffer.append("500");
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
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return stringBuffer2;
                } catch (Exception unused3) {
                    inputStreamReader = null;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Exception unused4) {
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                com.baidu.crabsdk.lite.b.a.d(str, "Upload Data Error!");
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return "500";
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
                return "500";
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
        } catch (Exception unused5) {
            httpURLConnection = null;
            inputStreamReader = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            inputStreamReader = null;
        }
    }
}
