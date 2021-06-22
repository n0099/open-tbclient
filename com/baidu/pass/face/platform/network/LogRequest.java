package com.baidu.pass.face.platform.network;

import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LogRequest extends BaseRequest {
    public static final String URL_GET_LOG = "http://face.baidu.com/openapi/v2/stat/sdkdata";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0093 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:171:0x01bf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0095 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0097 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x009a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x009d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00a0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0144 A[Catch: IOException -> 0x0140, TryCatch #12 {IOException -> 0x0140, blocks: (B:108:0x013c, B:112:0x0144, B:114:0x0149, B:116:0x014e), top: B:189:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0149 A[Catch: IOException -> 0x0140, TryCatch #12 {IOException -> 0x0140, blocks: (B:108:0x013c, B:112:0x0144, B:114:0x0149, B:116:0x014e), top: B:189:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014e A[Catch: IOException -> 0x0140, TRY_LEAVE, TryCatch #12 {IOException -> 0x0140, blocks: (B:108:0x013c, B:112:0x0144, B:114:0x0149, B:116:0x014e), top: B:189:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0167 A[Catch: IOException -> 0x0163, TryCatch #31 {IOException -> 0x0163, blocks: (B:125:0x015f, B:129:0x0167, B:131:0x016c, B:133:0x0171), top: B:196:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x016c A[Catch: IOException -> 0x0163, TryCatch #31 {IOException -> 0x0163, blocks: (B:125:0x015f, B:129:0x0167, B:131:0x016c, B:133:0x0171), top: B:196:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0171 A[Catch: IOException -> 0x0163, TRY_LEAVE, TryCatch #31 {IOException -> 0x0163, blocks: (B:125:0x015f, B:129:0x0167, B:131:0x016c, B:133:0x0171), top: B:196:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x018a A[Catch: IOException -> 0x0186, TryCatch #8 {IOException -> 0x0186, blocks: (B:142:0x0182, B:146:0x018a, B:148:0x018f, B:150:0x0194), top: B:185:0x0182 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x018f A[Catch: IOException -> 0x0186, TryCatch #8 {IOException -> 0x0186, blocks: (B:142:0x0182, B:146:0x018a, B:148:0x018f, B:150:0x0194), top: B:185:0x0182 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0194 A[Catch: IOException -> 0x0186, TRY_LEAVE, TryCatch #8 {IOException -> 0x0186, blocks: (B:142:0x0182, B:146:0x018a, B:148:0x018f, B:150:0x0194), top: B:185:0x0182 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ad A[Catch: IOException -> 0x01a9, TryCatch #27 {IOException -> 0x01a9, blocks: (B:159:0x01a5, B:163:0x01ad, B:165:0x01b2, B:167:0x01b7), top: B:194:0x01a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01b2 A[Catch: IOException -> 0x01a9, TryCatch #27 {IOException -> 0x01a9, blocks: (B:159:0x01a5, B:163:0x01ad, B:165:0x01b2, B:167:0x01b7), top: B:194:0x01a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01b7 A[Catch: IOException -> 0x01a9, TRY_LEAVE, TryCatch #27 {IOException -> 0x01a9, blocks: (B:159:0x01a5, B:163:0x01ad, B:165:0x01b2, B:167:0x01b7), top: B:194:0x01a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01ca A[Catch: IOException -> 0x01c6, TryCatch #9 {IOException -> 0x01c6, blocks: (B:173:0x01c2, B:177:0x01ca, B:179:0x01cf, B:181:0x01d4), top: B:187:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01cf A[Catch: IOException -> 0x01c6, TryCatch #9 {IOException -> 0x01c6, blocks: (B:173:0x01c2, B:177:0x01ca, B:179:0x01cf, B:181:0x01d4), top: B:187:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01d4 A[Catch: IOException -> 0x01c6, TRY_LEAVE, TryCatch #9 {IOException -> 0x01c6, blocks: (B:173:0x01c2, B:177:0x01ca, B:179:0x01cf, B:181:0x01d4), top: B:187:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0121 A[Catch: IOException -> 0x011d, TryCatch #33 {IOException -> 0x011d, blocks: (B:91:0x0119, B:95:0x0121, B:97:0x0126, B:99:0x012b), top: B:198:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126 A[Catch: IOException -> 0x011d, TryCatch #33 {IOException -> 0x011d, blocks: (B:91:0x0119, B:95:0x0121, B:97:0x0126, B:99:0x012b), top: B:198:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012b A[Catch: IOException -> 0x011d, TRY_LEAVE, TryCatch #33 {IOException -> 0x011d, blocks: (B:91:0x0119, B:95:0x0121, B:97:0x0126, B:99:0x012b), top: B:198:0x0119 }] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v27, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v44 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void httpUrlConnectionPost(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpURLConnection httpURLConnection2;
        ByteArrayOutputStream byteArrayOutputStream3;
        HttpURLConnection httpURLConnection3;
        ByteArrayOutputStream byteArrayOutputStream4;
        HttpURLConnection httpURLConnection4;
        ByteArrayOutputStream byteArrayOutputStream5;
        HttpURLConnection httpURLConnection5;
        ByteArrayOutputStream byteArrayOutputStream6;
        ByteArrayOutputStream byteArrayOutputStream7;
        InputStream inputStream;
        HttpURLConnection httpURLConnection6;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection7;
        InputStream inputStream3;
        HttpURLConnection httpURLConnection8;
        InputStream inputStream4;
        HttpURLConnection httpURLConnection9;
        InputStream inputStream5;
        HttpURLConnection httpURLConnection10;
        InputStream inputStream6;
        JSONObject jSONObject;
        InputStream inputStream7;
        InputStream inputStream8;
        StringBuffer stringBuffer = new StringBuffer();
        ByteArrayOutputStream byteArrayOutputStream8 = null;
        try {
            try {
                jSONObject = new JSONObject((String) str);
                str = (HttpURLConnection) new URL(URL_GET_LOG).openConnection();
            } catch (Throwable th) {
                th = th;
            }
            try {
                System.setProperty("sun.net.client.defaultConnectTimeout", "8000");
                System.setProperty("sun.net.client.defaultReadTimeout", "8000");
                str.setDoOutput(true);
                str.setDoInput(true);
                str.setRequestMethod("GET");
                str.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                str.setUseCaches(false);
                str.setInstanceFollowRedirects(true);
                str.setRequestProperty("contentType", "application/json");
                str.connect();
                ?? outputStream = str.getOutputStream();
                try {
                    outputStream.write(jSONObject.toString().getBytes("utf-8"));
                    outputStream.flush();
                    outputStream.close();
                    if (200 == str.getResponseCode()) {
                        inputStream7 = str.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            byteArrayOutputStream7 = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read = inputStream7.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream7.write(bArr, 0, read);
                                } catch (UnsupportedEncodingException e2) {
                                    e = e2;
                                    byteArrayOutputStream8 = outputStream;
                                    inputStream6 = inputStream7;
                                    httpURLConnection10 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream8 != null) {
                                    }
                                    if (byteArrayOutputStream7 != null) {
                                    }
                                    if (inputStream6 != 0) {
                                    }
                                    if (httpURLConnection10 == null) {
                                    }
                                } catch (MalformedURLException e3) {
                                    e = e3;
                                    byteArrayOutputStream8 = outputStream;
                                    inputStream5 = inputStream7;
                                    httpURLConnection9 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream8 != null) {
                                    }
                                    if (byteArrayOutputStream7 != null) {
                                    }
                                    if (inputStream5 != 0) {
                                    }
                                    if (httpURLConnection9 == null) {
                                    }
                                } catch (ProtocolException e4) {
                                    e = e4;
                                    byteArrayOutputStream8 = outputStream;
                                    inputStream4 = inputStream7;
                                    httpURLConnection8 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream8 != null) {
                                    }
                                    if (byteArrayOutputStream7 != null) {
                                    }
                                    if (inputStream4 != 0) {
                                    }
                                    if (httpURLConnection8 == null) {
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    byteArrayOutputStream8 = outputStream;
                                    inputStream3 = inputStream7;
                                    httpURLConnection7 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream8 != null) {
                                    }
                                    if (byteArrayOutputStream7 != null) {
                                    }
                                    if (inputStream3 != 0) {
                                    }
                                    if (httpURLConnection7 == null) {
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    byteArrayOutputStream8 = outputStream;
                                    inputStream2 = inputStream7;
                                    httpURLConnection6 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream8 != null) {
                                    }
                                    if (byteArrayOutputStream7 != null) {
                                    }
                                    if (inputStream2 != 0) {
                                    }
                                    if (httpURLConnection6 == null) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream8 = outputStream;
                                    inputStream = inputStream7;
                                    if (byteArrayOutputStream8 != null) {
                                    }
                                    if (byteArrayOutputStream7 != null) {
                                    }
                                    if (inputStream != 0) {
                                    }
                                    if (str != 0) {
                                    }
                                    throw th;
                                }
                            }
                            stringBuffer.append(new String(byteArrayOutputStream7.toByteArray(), "utf-8"));
                            byteArrayOutputStream7.flush();
                            byteArrayOutputStream8 = byteArrayOutputStream7;
                            inputStream8 = inputStream7;
                        } catch (UnsupportedEncodingException e7) {
                            e = e7;
                            byteArrayOutputStream7 = null;
                        } catch (MalformedURLException e8) {
                            e = e8;
                            byteArrayOutputStream7 = null;
                        } catch (ProtocolException e9) {
                            e = e9;
                            byteArrayOutputStream7 = null;
                        } catch (IOException e10) {
                            e = e10;
                            byteArrayOutputStream7 = null;
                        } catch (Exception e11) {
                            e = e11;
                            byteArrayOutputStream7 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream7 = null;
                        }
                    } else {
                        inputStream8 = null;
                    }
                    if (outputStream != 0) {
                        try {
                            outputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            return;
                        }
                    }
                    if (byteArrayOutputStream8 != null) {
                        byteArrayOutputStream8.close();
                    }
                    if (inputStream8 != null) {
                        inputStream8.close();
                    }
                    if (str != 0) {
                        str.disconnect();
                    }
                } catch (UnsupportedEncodingException e13) {
                    e = e13;
                    inputStream7 = null;
                    byteArrayOutputStream7 = null;
                } catch (MalformedURLException e14) {
                    e = e14;
                    inputStream7 = null;
                    byteArrayOutputStream7 = null;
                } catch (ProtocolException e15) {
                    e = e15;
                    inputStream7 = null;
                    byteArrayOutputStream7 = null;
                } catch (IOException e16) {
                    e = e16;
                    inputStream7 = null;
                    byteArrayOutputStream7 = null;
                } catch (Exception e17) {
                    e = e17;
                    inputStream7 = null;
                    byteArrayOutputStream7 = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream7 = null;
                    byteArrayOutputStream7 = null;
                }
            } catch (UnsupportedEncodingException e18) {
                e = e18;
                byteArrayOutputStream6 = null;
                httpURLConnection5 = str;
                byteArrayOutputStream7 = byteArrayOutputStream6;
                inputStream6 = byteArrayOutputStream6;
                httpURLConnection10 = httpURLConnection5;
                e.printStackTrace();
                if (byteArrayOutputStream8 != null) {
                    try {
                        byteArrayOutputStream8.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                        return;
                    }
                }
                if (byteArrayOutputStream7 != null) {
                    byteArrayOutputStream7.close();
                }
                if (inputStream6 != 0) {
                    inputStream6.close();
                }
                if (httpURLConnection10 == null) {
                    httpURLConnection10.disconnect();
                }
            } catch (MalformedURLException e20) {
                e = e20;
                byteArrayOutputStream5 = null;
                httpURLConnection4 = str;
                byteArrayOutputStream7 = byteArrayOutputStream5;
                inputStream5 = byteArrayOutputStream5;
                httpURLConnection9 = httpURLConnection4;
                e.printStackTrace();
                if (byteArrayOutputStream8 != null) {
                    try {
                        byteArrayOutputStream8.close();
                    } catch (IOException e21) {
                        e21.printStackTrace();
                        return;
                    }
                }
                if (byteArrayOutputStream7 != null) {
                    byteArrayOutputStream7.close();
                }
                if (inputStream5 != 0) {
                    inputStream5.close();
                }
                if (httpURLConnection9 == null) {
                    httpURLConnection9.disconnect();
                }
            } catch (ProtocolException e22) {
                e = e22;
                byteArrayOutputStream4 = null;
                httpURLConnection3 = str;
                byteArrayOutputStream7 = byteArrayOutputStream4;
                inputStream4 = byteArrayOutputStream4;
                httpURLConnection8 = httpURLConnection3;
                e.printStackTrace();
                if (byteArrayOutputStream8 != null) {
                    try {
                        byteArrayOutputStream8.close();
                    } catch (IOException e23) {
                        e23.printStackTrace();
                        return;
                    }
                }
                if (byteArrayOutputStream7 != null) {
                    byteArrayOutputStream7.close();
                }
                if (inputStream4 != 0) {
                    inputStream4.close();
                }
                if (httpURLConnection8 == null) {
                    httpURLConnection8.disconnect();
                }
            } catch (IOException e24) {
                e = e24;
                byteArrayOutputStream3 = null;
                httpURLConnection2 = str;
                byteArrayOutputStream7 = byteArrayOutputStream3;
                inputStream3 = byteArrayOutputStream3;
                httpURLConnection7 = httpURLConnection2;
                e.printStackTrace();
                if (byteArrayOutputStream8 != null) {
                    try {
                        byteArrayOutputStream8.close();
                    } catch (IOException e25) {
                        e25.printStackTrace();
                        return;
                    }
                }
                if (byteArrayOutputStream7 != null) {
                    byteArrayOutputStream7.close();
                }
                if (inputStream3 != 0) {
                    inputStream3.close();
                }
                if (httpURLConnection7 == null) {
                    httpURLConnection7.disconnect();
                }
            } catch (Exception e26) {
                e = e26;
                byteArrayOutputStream2 = null;
                httpURLConnection = str;
                byteArrayOutputStream7 = byteArrayOutputStream2;
                inputStream2 = byteArrayOutputStream2;
                httpURLConnection6 = httpURLConnection;
                e.printStackTrace();
                if (byteArrayOutputStream8 != null) {
                    try {
                        byteArrayOutputStream8.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                        return;
                    }
                }
                if (byteArrayOutputStream7 != null) {
                    byteArrayOutputStream7.close();
                }
                if (inputStream2 != 0) {
                    inputStream2.close();
                }
                if (httpURLConnection6 == null) {
                    httpURLConnection6.disconnect();
                }
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                str = str;
                byteArrayOutputStream7 = byteArrayOutputStream;
                inputStream = byteArrayOutputStream;
                if (byteArrayOutputStream8 != null) {
                    try {
                        byteArrayOutputStream8.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                        throw th;
                    }
                }
                if (byteArrayOutputStream7 != null) {
                    byteArrayOutputStream7.close();
                }
                if (inputStream != 0) {
                    inputStream.close();
                }
                if (str != 0) {
                    str.disconnect();
                }
                throw th;
            }
        } catch (UnsupportedEncodingException e29) {
            e = e29;
            httpURLConnection5 = null;
            byteArrayOutputStream6 = null;
        } catch (MalformedURLException e30) {
            e = e30;
            httpURLConnection4 = null;
            byteArrayOutputStream5 = null;
        } catch (ProtocolException e31) {
            e = e31;
            httpURLConnection3 = null;
            byteArrayOutputStream4 = null;
        } catch (IOException e32) {
            e = e32;
            httpURLConnection2 = null;
            byteArrayOutputStream3 = null;
        } catch (Exception e33) {
            e = e33;
            httpURLConnection = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            str = 0;
            byteArrayOutputStream = null;
        }
    }

    public static void sendLogMessage(final String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.pass.face.platform.network.LogRequest.1
            @Override // java.lang.Runnable
            public void run() {
                LogRequest.httpUrlConnectionPost(str);
            }
        }).start();
    }
}
