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
/* loaded from: classes15.dex */
public class HttpRequest {
    private static final String TAG = HttpRequest.class.getSimpleName();

    public static String request(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return "";
        }
        return httpUrlConnectionPost(str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=7, 87=7, 89=7, 90=7, 92=7, 93=7, 95=7, 96=7, 98=7, 99=7] */
    private static String httpUrlConnectionPost(String str, String str2) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        Exception e;
        IOException e2;
        ProtocolException e3;
        MalformedURLException e4;
        UnsupportedEncodingException e5;
        StringBuilder sb = new StringBuilder("");
        try {
            try {
                String str3 = "data=" + URLEncoder.encode(str2, "UTF-8");
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    System.setProperty("sun.net.client.defaultConnectTimeout", WbAuthConstants.AUTH_FAILED_NOT_INSTALL_CODE);
                    System.setProperty("sun.net.client.defaultReadTimeout", WbAuthConstants.AUTH_FAILED_NOT_INSTALL_CODE);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection2.connect();
                    outputStream = httpURLConnection2.getOutputStream();
                    try {
                        outputStream.write(str3.getBytes());
                        outputStream.flush();
                        outputStream.close();
                        if (200 == httpURLConnection2.getResponseCode()) {
                            inputStream = httpURLConnection2.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } catch (UnsupportedEncodingException e6) {
                                        e5 = e6;
                                        httpURLConnection = httpURLConnection2;
                                        e5.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e7) {
                                                e7.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (MalformedURLException e8) {
                                        e4 = e8;
                                        httpURLConnection = httpURLConnection2;
                                        e4.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (ProtocolException e10) {
                                        e3 = e10;
                                        httpURLConnection = httpURLConnection2;
                                        e3.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e11) {
                                                e11.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (IOException e12) {
                                        e2 = e12;
                                        httpURLConnection = httpURLConnection2;
                                        e2.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e13) {
                                                e13.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (Exception e14) {
                                        e = e14;
                                        httpURLConnection = httpURLConnection2;
                                        e.printStackTrace();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e15) {
                                                e15.printStackTrace();
                                                return sb.toString();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return sb.toString();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        httpURLConnection = httpURLConnection2;
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e16) {
                                                e16.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th;
                                    }
                                }
                                sb.append(new String(byteArrayOutputStream.toByteArray(), "utf-8"));
                                byteArrayOutputStream.flush();
                            } catch (UnsupportedEncodingException e17) {
                                e5 = e17;
                                byteArrayOutputStream = null;
                                httpURLConnection = httpURLConnection2;
                            } catch (MalformedURLException e18) {
                                e4 = e18;
                                byteArrayOutputStream = null;
                                httpURLConnection = httpURLConnection2;
                            } catch (ProtocolException e19) {
                                e3 = e19;
                                byteArrayOutputStream = null;
                                httpURLConnection = httpURLConnection2;
                            } catch (IOException e20) {
                                e2 = e20;
                                byteArrayOutputStream = null;
                                httpURLConnection = httpURLConnection2;
                            } catch (Exception e21) {
                                e = e21;
                                byteArrayOutputStream = null;
                                httpURLConnection = httpURLConnection2;
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream = null;
                                httpURLConnection = httpURLConnection2;
                            }
                        } else {
                            byteArrayOutputStream = null;
                            inputStream = null;
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (UnsupportedEncodingException e23) {
                        e5 = e23;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpURLConnection = httpURLConnection2;
                    } catch (MalformedURLException e24) {
                        e4 = e24;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpURLConnection = httpURLConnection2;
                    } catch (ProtocolException e25) {
                        e3 = e25;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpURLConnection = httpURLConnection2;
                    } catch (IOException e26) {
                        e2 = e26;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpURLConnection = httpURLConnection2;
                    } catch (Exception e27) {
                        e = e27;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpURLConnection = httpURLConnection2;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpURLConnection = httpURLConnection2;
                    }
                } catch (UnsupportedEncodingException e28) {
                    e5 = e28;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                } catch (MalformedURLException e29) {
                    e4 = e29;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                } catch (ProtocolException e30) {
                    e3 = e30;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                } catch (IOException e31) {
                    e2 = e31;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e32) {
                    e = e32;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (UnsupportedEncodingException e33) {
            e5 = e33;
            byteArrayOutputStream = null;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (MalformedURLException e34) {
            e4 = e34;
            byteArrayOutputStream = null;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (ProtocolException e35) {
            e3 = e35;
            byteArrayOutputStream = null;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (IOException e36) {
            e2 = e36;
            byteArrayOutputStream = null;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (Exception e37) {
            e = e37;
            byteArrayOutputStream = null;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        }
        return sb.toString();
    }
}
