package com.baidu.crabsdk.sender;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class q {
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x014a: ARRAY_LENGTH  (r4v9 int A[REMOVE]) = (r9v0 byte[]))] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010f A[Catch: Exception -> 0x011e, TryCatch #5 {Exception -> 0x011e, blocks: (B:26:0x010a, B:28:0x010f, B:30:0x0114, B:32:0x0119), top: B:93:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0114 A[Catch: Exception -> 0x011e, TryCatch #5 {Exception -> 0x011e, blocks: (B:26:0x010a, B:28:0x010f, B:30:0x0114, B:32:0x0119), top: B:93:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0119 A[Catch: Exception -> 0x011e, TRY_LEAVE, TryCatch #5 {Exception -> 0x011e, blocks: (B:26:0x010a, B:28:0x010f, B:30:0x0114, B:32:0x0119), top: B:93:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c0 A[Catch: Exception -> 0x0208, TryCatch #9 {Exception -> 0x0208, blocks: (B:49:0x01bb, B:51:0x01c0, B:53:0x01c5, B:55:0x01ca), top: B:95:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c5 A[Catch: Exception -> 0x0208, TryCatch #9 {Exception -> 0x0208, blocks: (B:49:0x01bb, B:51:0x01c0, B:53:0x01c5, B:55:0x01ca), top: B:95:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ca A[Catch: Exception -> 0x0208, TRY_LEAVE, TryCatch #9 {Exception -> 0x0208, blocks: (B:49:0x01bb, B:51:0x01c0, B:53:0x01c5, B:55:0x01ca), top: B:95:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, byte[] bArr, String str2, String str3) {
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader2;
        HttpURLConnection httpURLConnection2;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        if (bArr == null || bArr.length == 0) {
            com.baidu.crabsdk.c.a.w("Data is empty!");
            return "500";
        }
        com.baidu.crabsdk.c.a.v("Upload data size is: " + (bArr.length / 1024) + "KB");
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setRequestProperty(HTTP.CONTENT_ENCODING, "gzip");
                httpURLConnection3.setInstanceFollowRedirects(true);
                httpURLConnection3.setRequestProperty("Content-Type", "application/octet-stream");
                com.baidu.crabsdk.c.a.v("*** filename =  ***" + str3);
                if (str2.equals("Block")) {
                    com.baidu.crabsdk.c.a.v("*** apiType == Block ***");
                    httpURLConnection3.setRequestProperty("EncryptType", "RSA-AES");
                    httpURLConnection3.setRequestProperty("EncryptData", str3);
                    httpURLConnection3.setRequestProperty(HTTP.USER_AGENT, g.a(str2, (String) null));
                } else if (str2.equals("NDK")) {
                    com.baidu.crabsdk.c.a.v("*** apiType == NDK ***");
                    httpURLConnection3.setRequestProperty("EncryptType", "RSA-AES");
                    httpURLConnection3.setRequestProperty("EncryptData", str3);
                    httpURLConnection3.setRequestProperty(HTTP.CONTENT_LEN, new StringBuilder().append(bArr.length).toString());
                    httpURLConnection3.setRequestProperty(HTTP.USER_AGENT, g.a(str2, (String) null));
                } else {
                    com.baidu.crabsdk.c.a.v("*** apiType != Block ***");
                    String bG = h.bG(str3);
                    if (bG.startsWith("NoEncrypt_")) {
                        httpURLConnection3.setRequestProperty("EncryptType", "RSA-AES2");
                        bG = bG.substring(10);
                        com.baidu.crabsdk.c.a.v("real rsaAesKey is: " + bG);
                    } else {
                        httpURLConnection3.setRequestProperty("EncryptType", "RSA-AES");
                    }
                    httpURLConnection3.setRequestProperty("EncryptData", bG);
                    httpURLConnection3.setRequestProperty(HTTP.USER_AGENT, g.a(str2, h.bF(str3)));
                }
                httpURLConnection3.setConnectTimeout(3000);
                httpURLConnection3.setReadTimeout(3000);
                dataOutputStream = new DataOutputStream(httpURLConnection3.getOutputStream());
                try {
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    StringBuffer stringBuffer = new StringBuffer();
                    com.baidu.crabsdk.c.a.bu("response code is " + httpURLConnection3.getResponseCode());
                    if (httpURLConnection3.getResponseCode() == 200) {
                        inputStreamReader = new InputStreamReader(httpURLConnection3.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine).append("\n");
                                } catch (Exception e) {
                                    inputStreamReader2 = inputStreamReader;
                                    bufferedReader2 = bufferedReader;
                                    httpURLConnection2 = httpURLConnection3;
                                    try {
                                        com.baidu.crabsdk.c.a.w("Upload Data Error!");
                                        if (dataOutputStream != null) {
                                        }
                                        if (httpURLConnection2 != null) {
                                        }
                                        if (bufferedReader2 != null) {
                                        }
                                        if (inputStreamReader2 == null) {
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        BufferedReader bufferedReader3 = bufferedReader2;
                                        httpURLConnection = httpURLConnection2;
                                        bufferedReader = bufferedReader3;
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
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader2 != null) {
                                            inputStreamReader2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    inputStreamReader2 = inputStreamReader;
                                    httpURLConnection = httpURLConnection3;
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
                            inputStreamReader.close();
                            bufferedReader.close();
                        } catch (Exception e3) {
                            httpURLConnection2 = httpURLConnection3;
                            inputStreamReader2 = inputStreamReader;
                            bufferedReader2 = null;
                            com.baidu.crabsdk.c.a.w("Upload Data Error!");
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    return "500";
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (inputStreamReader2 == null) {
                                inputStreamReader2.close();
                                return "500";
                            }
                            return "500";
                        } catch (Throwable th3) {
                            bufferedReader = null;
                            inputStreamReader2 = inputStreamReader;
                            httpURLConnection = httpURLConnection3;
                            th = th3;
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
                    } else {
                        stringBuffer.append("500");
                        inputStreamReader = null;
                        bufferedReader = null;
                    }
                    httpURLConnection3.disconnect();
                    String stringBuffer2 = stringBuffer.toString();
                    try {
                        dataOutputStream.close();
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    return stringBuffer2;
                } catch (Exception e6) {
                    bufferedReader2 = null;
                    httpURLConnection2 = httpURLConnection3;
                } catch (Throwable th4) {
                    bufferedReader = null;
                    httpURLConnection = httpURLConnection3;
                    th = th4;
                }
            } catch (Exception e7) {
                bufferedReader2 = null;
                httpURLConnection2 = httpURLConnection3;
                dataOutputStream = null;
            } catch (Throwable th5) {
                bufferedReader = null;
                dataOutputStream = null;
                th = th5;
                httpURLConnection = httpURLConnection3;
            }
        } catch (Exception e8) {
            bufferedReader2 = null;
            httpURLConnection2 = null;
            dataOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
            httpURLConnection = null;
            dataOutputStream = null;
        }
    }
}
