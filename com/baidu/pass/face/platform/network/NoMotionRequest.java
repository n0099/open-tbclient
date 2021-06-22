package com.baidu.pass.face.platform.network;

import android.os.Handler;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class NoMotionRequest extends BaseRequest {
    public static final String TAG = "NoMotionRequest";
    public static final String URL_POST_NOMOTION_LIVENESS = "http://face.baidu.com/gate/api/userverifydemo";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:109:0x0178 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x009a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:184:0x0220 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x009d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00a0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x00a3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x00a6 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0167 A[Catch: IOException -> 0x0163, TryCatch #36 {IOException -> 0x0163, blocks: (B:98:0x015f, B:102:0x0167, B:104:0x016c, B:106:0x0171), top: B:211:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x016c A[Catch: IOException -> 0x0163, TryCatch #36 {IOException -> 0x0163, blocks: (B:98:0x015f, B:102:0x0167, B:104:0x016c, B:106:0x0171), top: B:211:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0171 A[Catch: IOException -> 0x0163, TRY_LEAVE, TryCatch #36 {IOException -> 0x0163, blocks: (B:98:0x015f, B:102:0x0167, B:104:0x016c, B:106:0x0171), top: B:211:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018f A[Catch: IOException -> 0x018b, TryCatch #33 {IOException -> 0x018b, blocks: (B:116:0x0187, B:120:0x018f, B:122:0x0194, B:124:0x0199), top: B:207:0x0187 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0194 A[Catch: IOException -> 0x018b, TryCatch #33 {IOException -> 0x018b, blocks: (B:116:0x0187, B:120:0x018f, B:122:0x0194, B:124:0x0199), top: B:207:0x0187 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0199 A[Catch: IOException -> 0x018b, TRY_LEAVE, TryCatch #33 {IOException -> 0x018b, blocks: (B:116:0x0187, B:120:0x018f, B:122:0x0194, B:124:0x0199), top: B:207:0x0187 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b8 A[Catch: IOException -> 0x01b4, TryCatch #7 {IOException -> 0x01b4, blocks: (B:134:0x01b0, B:138:0x01b8, B:140:0x01bd, B:142:0x01c2), top: B:201:0x01b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bd A[Catch: IOException -> 0x01b4, TryCatch #7 {IOException -> 0x01b4, blocks: (B:134:0x01b0, B:138:0x01b8, B:140:0x01bd, B:142:0x01c2), top: B:201:0x01b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c2 A[Catch: IOException -> 0x01b4, TRY_LEAVE, TryCatch #7 {IOException -> 0x01b4, blocks: (B:134:0x01b0, B:138:0x01b8, B:140:0x01bd, B:142:0x01c2), top: B:201:0x01b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e1 A[Catch: IOException -> 0x01dd, TryCatch #40 {IOException -> 0x01dd, blocks: (B:152:0x01d9, B:156:0x01e1, B:158:0x01e6, B:160:0x01eb), top: B:213:0x01d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e6 A[Catch: IOException -> 0x01dd, TryCatch #40 {IOException -> 0x01dd, blocks: (B:152:0x01d9, B:156:0x01e1, B:158:0x01e6, B:160:0x01eb), top: B:213:0x01d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01eb A[Catch: IOException -> 0x01dd, TRY_LEAVE, TryCatch #40 {IOException -> 0x01dd, blocks: (B:152:0x01d9, B:156:0x01e1, B:158:0x01e6, B:160:0x01eb), top: B:213:0x01d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020a A[Catch: IOException -> 0x0206, TryCatch #16 {IOException -> 0x0206, blocks: (B:170:0x0202, B:174:0x020a, B:176:0x020f, B:178:0x0214), top: B:205:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020f A[Catch: IOException -> 0x0206, TryCatch #16 {IOException -> 0x0206, blocks: (B:170:0x0202, B:174:0x020a, B:176:0x020f, B:178:0x0214), top: B:205:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0214 A[Catch: IOException -> 0x0206, TRY_LEAVE, TryCatch #16 {IOException -> 0x0206, blocks: (B:170:0x0202, B:174:0x020a, B:176:0x020f, B:178:0x0214), top: B:205:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x022b A[Catch: IOException -> 0x0227, TryCatch #35 {IOException -> 0x0227, blocks: (B:186:0x0223, B:190:0x022b, B:192:0x0230, B:194:0x0235), top: B:209:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0230 A[Catch: IOException -> 0x0227, TryCatch #35 {IOException -> 0x0227, blocks: (B:186:0x0223, B:190:0x022b, B:192:0x0230, B:194:0x0235), top: B:209:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0235 A[Catch: IOException -> 0x0227, TRY_LEAVE, TryCatch #35 {IOException -> 0x0227, blocks: (B:186:0x0223, B:190:0x022b, B:192:0x0230, B:194:0x0235), top: B:209:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0202 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0223 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19, types: [int] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26, types: [int] */
    /* JADX WARN: Type inference failed for: r9v43, types: [int] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void httpUrlConnectionPost(String str, Handler handler) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ?? r7;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e2;
        IOException e3;
        ProtocolException e4;
        MalformedURLException e5;
        UnsupportedEncodingException e6;
        String str2;
        ?? r0 = "8000";
        StringBuilder sb = new StringBuilder("");
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                str2 = "pic_file=" + URLEncoder.encode(str, "UTF-8");
                httpURLConnection = (HttpURLConnection) new URL(URL_POST_NOMOTION_LIVENESS).openConnection();
                try {
                    System.setProperty("sun.net.client.defaultConnectTimeout", "8000");
                    System.setProperty("sun.net.client.defaultReadTimeout", "8000");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.connect();
                    r0 = httpURLConnection.getOutputStream();
                } catch (UnsupportedEncodingException e7) {
                    e = e7;
                    r0 = 0;
                    inputStream = 0;
                } catch (MalformedURLException e8) {
                    e = e8;
                    r0 = 0;
                    inputStream = 0;
                } catch (ProtocolException e9) {
                    e = e9;
                    r0 = 0;
                    inputStream = 0;
                } catch (IOException e10) {
                    e = e10;
                    r0 = 0;
                    inputStream = 0;
                } catch (Exception e11) {
                    e = e11;
                    r0 = 0;
                    inputStream = 0;
                } catch (Throwable th) {
                    th = th;
                    r0 = 0;
                    inputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (UnsupportedEncodingException e12) {
            e = e12;
            r0 = 0;
            httpURLConnection = null;
            inputStream = 0;
        } catch (MalformedURLException e13) {
            e = e13;
            r0 = 0;
            httpURLConnection = null;
            inputStream = 0;
        } catch (ProtocolException e14) {
            e = e14;
            r0 = 0;
            httpURLConnection = null;
            inputStream = 0;
        } catch (IOException e15) {
            e = e15;
            r0 = 0;
            httpURLConnection = null;
            inputStream = 0;
        } catch (Exception e16) {
            e = e16;
            r0 = 0;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            r0 = 0;
            httpURLConnection = null;
            inputStream = null;
        }
        try {
            r0.write(str2.getBytes());
            r0.flush();
            r0.close();
            str = httpURLConnection.getResponseCode();
            if (200 == str) {
                try {
                    inputStream = httpURLConnection.getInputStream();
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
                            } catch (UnsupportedEncodingException e17) {
                                e6 = e17;
                                e6.printStackTrace();
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                        if (handler == null) {
                                            return;
                                        }
                                        Message obtainMessage = handler.obtainMessage(0);
                                        obtainMessage.arg1 = str;
                                        obtainMessage.obj = sb.toString();
                                        handler.sendMessage(obtainMessage);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (inputStream != 0) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (handler == null) {
                                }
                                Message obtainMessage2 = handler.obtainMessage(0);
                                obtainMessage2.arg1 = str;
                                obtainMessage2.obj = sb.toString();
                                handler.sendMessage(obtainMessage2);
                            } catch (MalformedURLException e19) {
                                e5 = e19;
                                e5.printStackTrace();
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException e20) {
                                        e20.printStackTrace();
                                        if (handler == null) {
                                            return;
                                        }
                                        Message obtainMessage22 = handler.obtainMessage(0);
                                        obtainMessage22.arg1 = str;
                                        obtainMessage22.obj = sb.toString();
                                        handler.sendMessage(obtainMessage22);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (inputStream != 0) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (handler == null) {
                                }
                                Message obtainMessage222 = handler.obtainMessage(0);
                                obtainMessage222.arg1 = str;
                                obtainMessage222.obj = sb.toString();
                                handler.sendMessage(obtainMessage222);
                            } catch (ProtocolException e21) {
                                e4 = e21;
                                e4.printStackTrace();
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException e22) {
                                        e22.printStackTrace();
                                        if (handler == null) {
                                            return;
                                        }
                                        Message obtainMessage2222 = handler.obtainMessage(0);
                                        obtainMessage2222.arg1 = str;
                                        obtainMessage2222.obj = sb.toString();
                                        handler.sendMessage(obtainMessage2222);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (inputStream != 0) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (handler == null) {
                                }
                                Message obtainMessage22222 = handler.obtainMessage(0);
                                obtainMessage22222.arg1 = str;
                                obtainMessage22222.obj = sb.toString();
                                handler.sendMessage(obtainMessage22222);
                            } catch (IOException e23) {
                                e3 = e23;
                                e3.printStackTrace();
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException e24) {
                                        e24.printStackTrace();
                                        if (handler == null) {
                                            return;
                                        }
                                        Message obtainMessage222222 = handler.obtainMessage(0);
                                        obtainMessage222222.arg1 = str;
                                        obtainMessage222222.obj = sb.toString();
                                        handler.sendMessage(obtainMessage222222);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (inputStream != 0) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (handler == null) {
                                }
                                Message obtainMessage2222222 = handler.obtainMessage(0);
                                obtainMessage2222222.arg1 = str;
                                obtainMessage2222222.obj = sb.toString();
                                handler.sendMessage(obtainMessage2222222);
                            } catch (Exception e25) {
                                e2 = e25;
                                e2.printStackTrace();
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException e26) {
                                        e26.printStackTrace();
                                        if (handler == null) {
                                            return;
                                        }
                                        Message obtainMessage22222222 = handler.obtainMessage(0);
                                        obtainMessage22222222.arg1 = str;
                                        obtainMessage22222222.obj = sb.toString();
                                        handler.sendMessage(obtainMessage22222222);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (inputStream != 0) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (handler == null) {
                                }
                                Message obtainMessage222222222 = handler.obtainMessage(0);
                                obtainMessage222222222.arg1 = str;
                                obtainMessage222222222.obj = sb.toString();
                                handler.sendMessage(obtainMessage222222222);
                            }
                        }
                        sb.append(new String(byteArrayOutputStream.toByteArray(), "utf-8"));
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    } catch (UnsupportedEncodingException e27) {
                        byteArrayOutputStream = null;
                        e6 = e27;
                    } catch (MalformedURLException e28) {
                        byteArrayOutputStream = null;
                        e5 = e28;
                    } catch (ProtocolException e29) {
                        byteArrayOutputStream = null;
                        e4 = e29;
                    } catch (IOException e30) {
                        byteArrayOutputStream = null;
                        e3 = e30;
                    } catch (Exception e31) {
                        byteArrayOutputStream = null;
                        e2 = e31;
                    } catch (Throwable th4) {
                        r7 = 0;
                        th = th4;
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (IOException e32) {
                                e32.printStackTrace();
                                if (handler != null) {
                                    Message obtainMessage3 = handler.obtainMessage(0);
                                    obtainMessage3.arg1 = str;
                                    obtainMessage3.obj = sb.toString();
                                    handler.sendMessage(obtainMessage3);
                                }
                                throw th;
                            }
                        }
                        if (r7 != 0) {
                            r7.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (handler != null) {
                        }
                        throw th;
                    }
                } catch (UnsupportedEncodingException e33) {
                    byteArrayOutputStream = null;
                    e6 = e33;
                    inputStream = 0;
                } catch (MalformedURLException e34) {
                    byteArrayOutputStream = null;
                    e5 = e34;
                    inputStream = 0;
                } catch (ProtocolException e35) {
                    byteArrayOutputStream = null;
                    e4 = e35;
                    inputStream = 0;
                } catch (IOException e36) {
                    byteArrayOutputStream = null;
                    e3 = e36;
                    inputStream = 0;
                } catch (Exception e37) {
                    byteArrayOutputStream = null;
                    e2 = e37;
                    inputStream = 0;
                } catch (Throwable th5) {
                    r7 = 0;
                    th = th5;
                    inputStream = null;
                }
            } else {
                inputStream = null;
            }
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e38) {
                    e38.printStackTrace();
                }
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (handler == null) {
                return;
            }
        } catch (UnsupportedEncodingException e39) {
            e = e39;
            inputStream = 0;
            r0 = r0;
            byteArrayOutputStream = inputStream;
            e6 = e;
            str = 0;
            e6.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != 0) {
            }
            if (httpURLConnection != null) {
            }
            if (handler == null) {
            }
            Message obtainMessage2222222222 = handler.obtainMessage(0);
            obtainMessage2222222222.arg1 = str;
            obtainMessage2222222222.obj = sb.toString();
            handler.sendMessage(obtainMessage2222222222);
        } catch (MalformedURLException e40) {
            e = e40;
            inputStream = 0;
            r0 = r0;
            byteArrayOutputStream = inputStream;
            e5 = e;
            str = 0;
            e5.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != 0) {
            }
            if (httpURLConnection != null) {
            }
            if (handler == null) {
            }
            Message obtainMessage22222222222 = handler.obtainMessage(0);
            obtainMessage22222222222.arg1 = str;
            obtainMessage22222222222.obj = sb.toString();
            handler.sendMessage(obtainMessage22222222222);
        } catch (ProtocolException e41) {
            e = e41;
            inputStream = 0;
            r0 = r0;
            byteArrayOutputStream = inputStream;
            e4 = e;
            str = 0;
            e4.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != 0) {
            }
            if (httpURLConnection != null) {
            }
            if (handler == null) {
            }
            Message obtainMessage222222222222 = handler.obtainMessage(0);
            obtainMessage222222222222.arg1 = str;
            obtainMessage222222222222.obj = sb.toString();
            handler.sendMessage(obtainMessage222222222222);
        } catch (IOException e42) {
            e = e42;
            inputStream = 0;
            r0 = r0;
            byteArrayOutputStream = inputStream;
            e3 = e;
            str = 0;
            e3.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != 0) {
            }
            if (httpURLConnection != null) {
            }
            if (handler == null) {
            }
            Message obtainMessage2222222222222 = handler.obtainMessage(0);
            obtainMessage2222222222222.arg1 = str;
            obtainMessage2222222222222.obj = sb.toString();
            handler.sendMessage(obtainMessage2222222222222);
        } catch (Exception e43) {
            e = e43;
            inputStream = 0;
            r0 = r0;
            byteArrayOutputStream = inputStream;
            e2 = e;
            str = 0;
            e2.printStackTrace();
            if (r0 != 0) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != 0) {
            }
            if (httpURLConnection != null) {
            }
            if (handler == null) {
            }
            Message obtainMessage22222222222222 = handler.obtainMessage(0);
            obtainMessage22222222222222.arg1 = str;
            obtainMessage22222222222222.obj = sb.toString();
            handler.sendMessage(obtainMessage22222222222222);
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            r0 = r0;
            r7 = inputStream;
            th = th;
            str = 0;
            if (r0 != 0) {
            }
            if (r7 != 0) {
            }
            if (inputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            if (handler != null) {
            }
            throw th;
        }
        Message obtainMessage222222222222222 = handler.obtainMessage(0);
        obtainMessage222222222222222.arg1 = str;
        obtainMessage222222222222222.obj = sb.toString();
        handler.sendMessage(obtainMessage222222222222222);
    }

    public static void sendMessage(final String str, final Handler handler) {
        if (str == null || str.length() <= 0) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.pass.face.platform.network.NoMotionRequest.1
            @Override // java.lang.Runnable
            public void run() {
                NoMotionRequest.httpUrlConnectionPost(str, handler);
            }
        }).start();
    }
}
