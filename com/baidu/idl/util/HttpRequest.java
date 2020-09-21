package com.baidu.idl.util;

import com.sina.weibo.sdk.utils.WbAuthConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
/* loaded from: classes25.dex */
public class HttpRequest {
    private static final String TAG = HttpRequest.class.getSimpleName();

    public static String request(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return "";
        }
        return httpUrlConnectionPost(str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=7, 87=7, 89=7, 90=7, 92=7, 93=7, 95=7, 96=7, 98=7, 99=7] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x017b A[Catch: IOException -> 0x0189, TryCatch #7 {IOException -> 0x0189, blocks: (B:100:0x0176, B:102:0x017b, B:104:0x0180, B:106:0x0185), top: B:168:0x0176 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0180 A[Catch: IOException -> 0x0189, TryCatch #7 {IOException -> 0x0189, blocks: (B:100:0x0176, B:102:0x017b, B:104:0x0180, B:106:0x0185), top: B:168:0x0176 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0185 A[Catch: IOException -> 0x0189, TRY_LEAVE, TryCatch #7 {IOException -> 0x0189, blocks: (B:100:0x0176, B:102:0x017b, B:104:0x0180, B:106:0x0185), top: B:168:0x0176 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String httpUrlConnectionPost(String str, String str2) {
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection2;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        r3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        r3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        InputStream inputStream2 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        byteArrayOutputStream3 = null;
        StringBuilder sb = new StringBuilder("");
        try {
            try {
                String str3 = "data=" + URLEncoder.encode(str2, "UTF-8");
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    System.setProperty("sun.net.client.defaultConnectTimeout", WbAuthConstants.AUTH_FAILED_NOT_INSTALL_CODE);
                    System.setProperty("sun.net.client.defaultReadTimeout", WbAuthConstants.AUTH_FAILED_NOT_INSTALL_CODE);
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.setDoInput(true);
                    httpURLConnection3.setRequestMethod("POST");
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.setInstanceFollowRedirects(true);
                    httpURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection3.connect();
                    outputStream = httpURLConnection3.getOutputStream();
                    try {
                        outputStream.write(str3.getBytes());
                        outputStream.flush();
                        outputStream.close();
                        if (200 == httpURLConnection3.getResponseCode()) {
                            inputStream = httpURLConnection3.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    } catch (UnsupportedEncodingException e) {
                                        byteArrayOutputStream3 = byteArrayOutputStream2;
                                        httpURLConnection = httpURLConnection3;
                                        e = e;
                                        e.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream3 != null) {
                                            byteArrayOutputStream3.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (MalformedURLException e3) {
                                        inputStream2 = inputStream;
                                        httpURLConnection2 = httpURLConnection3;
                                        e = e3;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        outputStream2 = outputStream;
                                        try {
                                            e.printStackTrace();
                                            if (outputStream2 != null) {
                                                try {
                                                    outputStream2.close();
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                            }
                                            return sb.toString();
                                        } catch (Throwable th) {
                                            th = th;
                                            outputStream = outputStream2;
                                            InputStream inputStream3 = inputStream2;
                                            byteArrayOutputStream3 = byteArrayOutputStream;
                                            httpURLConnection = httpURLConnection2;
                                            inputStream = inputStream3;
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (IOException e5) {
                                                    e5.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (byteArrayOutputStream3 != null) {
                                                byteArrayOutputStream3.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (ProtocolException e6) {
                                        byteArrayOutputStream3 = byteArrayOutputStream2;
                                        httpURLConnection = httpURLConnection3;
                                        e = e6;
                                        e.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e7) {
                                                e7.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream3 != null) {
                                            byteArrayOutputStream3.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (IOException e8) {
                                        byteArrayOutputStream3 = byteArrayOutputStream2;
                                        httpURLConnection = httpURLConnection3;
                                        e = e8;
                                        e.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream3 != null) {
                                            byteArrayOutputStream3.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (Exception e10) {
                                        byteArrayOutputStream3 = byteArrayOutputStream2;
                                        httpURLConnection = httpURLConnection3;
                                        e = e10;
                                        e.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e11) {
                                                e11.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream3 != null) {
                                            byteArrayOutputStream3.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (Throwable th2) {
                                        byteArrayOutputStream3 = byteArrayOutputStream2;
                                        httpURLConnection = httpURLConnection3;
                                        th = th2;
                                        if (outputStream != null) {
                                        }
                                        if (byteArrayOutputStream3 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                }
                                sb.append(new String(byteArrayOutputStream2.toByteArray(), "utf-8"));
                                byteArrayOutputStream2.flush();
                            } catch (UnsupportedEncodingException e12) {
                                httpURLConnection = httpURLConnection3;
                                e = e12;
                            } catch (MalformedURLException e13) {
                                outputStream2 = outputStream;
                                inputStream2 = inputStream;
                                httpURLConnection2 = httpURLConnection3;
                                e = e13;
                                byteArrayOutputStream = null;
                            } catch (ProtocolException e14) {
                                httpURLConnection = httpURLConnection3;
                                e = e14;
                            } catch (IOException e15) {
                                httpURLConnection = httpURLConnection3;
                                e = e15;
                            } catch (Exception e16) {
                                httpURLConnection = httpURLConnection3;
                                e = e16;
                            } catch (Throwable th3) {
                                httpURLConnection = httpURLConnection3;
                                th = th3;
                            }
                        } else {
                            byteArrayOutputStream2 = null;
                            inputStream = null;
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                    } catch (UnsupportedEncodingException e18) {
                        inputStream = null;
                        httpURLConnection = httpURLConnection3;
                        e = e18;
                    } catch (MalformedURLException e19) {
                        outputStream2 = outputStream;
                        httpURLConnection2 = httpURLConnection3;
                        e = e19;
                        byteArrayOutputStream = null;
                    } catch (ProtocolException e20) {
                        inputStream = null;
                        httpURLConnection = httpURLConnection3;
                        e = e20;
                    } catch (IOException e21) {
                        inputStream = null;
                        httpURLConnection = httpURLConnection3;
                        e = e21;
                    } catch (Exception e22) {
                        inputStream = null;
                        httpURLConnection = httpURLConnection3;
                        e = e22;
                    } catch (Throwable th4) {
                        inputStream = null;
                        httpURLConnection = httpURLConnection3;
                        th = th4;
                    }
                } catch (UnsupportedEncodingException e23) {
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection3;
                    e = e23;
                } catch (MalformedURLException e24) {
                    outputStream2 = null;
                    httpURLConnection2 = httpURLConnection3;
                    e = e24;
                    byteArrayOutputStream = null;
                } catch (ProtocolException e25) {
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection3;
                    e = e25;
                } catch (IOException e26) {
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection3;
                    e = e26;
                } catch (Exception e27) {
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection3;
                    e = e27;
                } catch (Throwable th5) {
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection3;
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (UnsupportedEncodingException e28) {
            e = e28;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (MalformedURLException e29) {
            e = e29;
            byteArrayOutputStream = null;
            outputStream2 = null;
            httpURLConnection2 = null;
        } catch (ProtocolException e30) {
            e = e30;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (IOException e31) {
            e = e31;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (Exception e32) {
            e = e32;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        }
        return sb.toString();
    }
}
