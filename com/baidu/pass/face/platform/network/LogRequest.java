package com.baidu.pass.face.platform.network;

import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LogRequest extends BaseRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String URL_GET_LOG = "http://face.baidu.com/openapi/v2/stat/sdkdata";
    public transient /* synthetic */ FieldHolder $fh;

    public LogRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:173:0x01c1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0095 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0097 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0099 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x009c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x009f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x00a2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012d A[Catch: IOException -> 0x011f, TRY_LEAVE, TryCatch #34 {IOException -> 0x011f, blocks: (B:93:0x011b, B:97:0x0123, B:99:0x0128, B:101:0x012d), top: B:203:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0146 A[Catch: IOException -> 0x0142, TryCatch #13 {IOException -> 0x0142, blocks: (B:110:0x013e, B:114:0x0146, B:116:0x014b, B:118:0x0150), top: B:196:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014b A[Catch: IOException -> 0x0142, TryCatch #13 {IOException -> 0x0142, blocks: (B:110:0x013e, B:114:0x0146, B:116:0x014b, B:118:0x0150), top: B:196:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150 A[Catch: IOException -> 0x0142, TRY_LEAVE, TryCatch #13 {IOException -> 0x0142, blocks: (B:110:0x013e, B:114:0x0146, B:116:0x014b, B:118:0x0150), top: B:196:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0169 A[Catch: IOException -> 0x0165, TryCatch #28 {IOException -> 0x0165, blocks: (B:127:0x0161, B:131:0x0169, B:133:0x016e, B:135:0x0173), top: B:201:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x016e A[Catch: IOException -> 0x0165, TryCatch #28 {IOException -> 0x0165, blocks: (B:127:0x0161, B:131:0x0169, B:133:0x016e, B:135:0x0173), top: B:201:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0173 A[Catch: IOException -> 0x0165, TRY_LEAVE, TryCatch #28 {IOException -> 0x0165, blocks: (B:127:0x0161, B:131:0x0169, B:133:0x016e, B:135:0x0173), top: B:201:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x018c A[Catch: IOException -> 0x0188, TryCatch #7 {IOException -> 0x0188, blocks: (B:144:0x0184, B:148:0x018c, B:150:0x0191, B:152:0x0196), top: B:192:0x0184 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0191 A[Catch: IOException -> 0x0188, TryCatch #7 {IOException -> 0x0188, blocks: (B:144:0x0184, B:148:0x018c, B:150:0x0191, B:152:0x0196), top: B:192:0x0184 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0196 A[Catch: IOException -> 0x0188, TRY_LEAVE, TryCatch #7 {IOException -> 0x0188, blocks: (B:144:0x0184, B:148:0x018c, B:150:0x0191, B:152:0x0196), top: B:192:0x0184 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01af A[Catch: IOException -> 0x01ab, TryCatch #5 {IOException -> 0x01ab, blocks: (B:161:0x01a7, B:165:0x01af, B:167:0x01b4, B:169:0x01b9), top: B:190:0x01a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01b4 A[Catch: IOException -> 0x01ab, TryCatch #5 {IOException -> 0x01ab, blocks: (B:161:0x01a7, B:165:0x01af, B:167:0x01b4, B:169:0x01b9), top: B:190:0x01a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01b9 A[Catch: IOException -> 0x01ab, TRY_LEAVE, TryCatch #5 {IOException -> 0x01ab, blocks: (B:161:0x01a7, B:165:0x01af, B:167:0x01b4, B:169:0x01b9), top: B:190:0x01a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01cc A[Catch: IOException -> 0x01c8, TryCatch #8 {IOException -> 0x01c8, blocks: (B:175:0x01c4, B:179:0x01cc, B:181:0x01d1, B:183:0x01d6), top: B:194:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01d1 A[Catch: IOException -> 0x01c8, TryCatch #8 {IOException -> 0x01c8, blocks: (B:175:0x01c4, B:179:0x01cc, B:181:0x01d1, B:183:0x01d6), top: B:194:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01d6 A[Catch: IOException -> 0x01c8, TRY_LEAVE, TryCatch #8 {IOException -> 0x01c8, blocks: (B:175:0x01c4, B:179:0x01cc, B:181:0x01d1, B:183:0x01d6), top: B:194:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0123 A[Catch: IOException -> 0x011f, TryCatch #34 {IOException -> 0x011f, blocks: (B:93:0x011b, B:97:0x0123, B:99:0x0128, B:101:0x012d), top: B:203:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0128 A[Catch: IOException -> 0x011f, TryCatch #34 {IOException -> 0x011f, blocks: (B:93:0x011b, B:97:0x0123, B:99:0x0128, B:101:0x012d), top: B:203:0x011b }] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v27, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v44 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void httpUrlConnectionPost(String str) {
        ?? r7;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        ?? r72;
        ?? r73;
        ?? r74;
        ?? r75;
        ?? r76;
        HttpURLConnection httpURLConnection6;
        HttpURLConnection httpURLConnection7;
        HttpURLConnection httpURLConnection8;
        HttpURLConnection httpURLConnection9;
        HttpURLConnection httpURLConnection10;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r7 = 65538;
            if (interceptable.invokeL(65538, null, str) != null) {
                return;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        ByteArrayOutputStream byteArrayOutputStream = null;
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
                        inputStream = str.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            r7 = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    r7.write(bArr, 0, read);
                                } catch (UnsupportedEncodingException e2) {
                                    e = e2;
                                    byteArrayOutputStream = outputStream;
                                    r76 = r7;
                                    httpURLConnection10 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (r76 != 0) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection10 == null) {
                                    }
                                } catch (MalformedURLException e3) {
                                    e = e3;
                                    byteArrayOutputStream = outputStream;
                                    r75 = r7;
                                    httpURLConnection9 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (r75 != 0) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection9 == null) {
                                    }
                                } catch (ProtocolException e4) {
                                    e = e4;
                                    byteArrayOutputStream = outputStream;
                                    r74 = r7;
                                    httpURLConnection8 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (r74 != 0) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection8 == null) {
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    byteArrayOutputStream = outputStream;
                                    r73 = r7;
                                    httpURLConnection7 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (r73 != 0) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection7 == null) {
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    byteArrayOutputStream = outputStream;
                                    r72 = r7;
                                    httpURLConnection6 = str;
                                    e.printStackTrace();
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (r72 != 0) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection6 == null) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = outputStream;
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (r7 != 0) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (str != 0) {
                                    }
                                    throw th;
                                }
                            }
                            stringBuffer.append(new String(r7.toByteArray(), "utf-8"));
                            r7.flush();
                            byteArrayOutputStream = r7;
                        } catch (UnsupportedEncodingException e7) {
                            e = e7;
                            r7 = 0;
                        } catch (MalformedURLException e8) {
                            e = e8;
                            r7 = 0;
                        } catch (ProtocolException e9) {
                            e = e9;
                            r7 = 0;
                        } catch (IOException e10) {
                            e = e10;
                            r7 = 0;
                        } catch (Exception e11) {
                            e = e11;
                            r7 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            r7 = 0;
                        }
                    } else {
                        inputStream = null;
                    }
                    if (outputStream != 0) {
                        try {
                            outputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            return;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (str != 0) {
                        str.disconnect();
                    }
                } catch (UnsupportedEncodingException e13) {
                    e = e13;
                    inputStream = null;
                    r7 = 0;
                } catch (MalformedURLException e14) {
                    e = e14;
                    inputStream = null;
                    r7 = 0;
                } catch (ProtocolException e15) {
                    e = e15;
                    inputStream = null;
                    r7 = 0;
                } catch (IOException e16) {
                    e = e16;
                    inputStream = null;
                    r7 = 0;
                } catch (Exception e17) {
                    e = e17;
                    inputStream = null;
                    r7 = 0;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    r7 = 0;
                }
            } catch (UnsupportedEncodingException e18) {
                e = e18;
                inputStream = null;
                httpURLConnection5 = str;
                r76 = inputStream;
                httpURLConnection10 = httpURLConnection5;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                        return;
                    }
                }
                if (r76 != 0) {
                    r76.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection10 == null) {
                    httpURLConnection10.disconnect();
                }
            } catch (MalformedURLException e20) {
                e = e20;
                inputStream = null;
                httpURLConnection4 = str;
                r75 = inputStream;
                httpURLConnection9 = httpURLConnection4;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e21) {
                        e21.printStackTrace();
                        return;
                    }
                }
                if (r75 != 0) {
                    r75.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection9 == null) {
                    httpURLConnection9.disconnect();
                }
            } catch (ProtocolException e22) {
                e = e22;
                inputStream = null;
                httpURLConnection3 = str;
                r74 = inputStream;
                httpURLConnection8 = httpURLConnection3;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e23) {
                        e23.printStackTrace();
                        return;
                    }
                }
                if (r74 != 0) {
                    r74.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection8 == null) {
                    httpURLConnection8.disconnect();
                }
            } catch (IOException e24) {
                e = e24;
                inputStream = null;
                httpURLConnection2 = str;
                r73 = inputStream;
                httpURLConnection7 = httpURLConnection2;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e25) {
                        e25.printStackTrace();
                        return;
                    }
                }
                if (r73 != 0) {
                    r73.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection7 == null) {
                    httpURLConnection7.disconnect();
                }
            } catch (Exception e26) {
                e = e26;
                inputStream = null;
                httpURLConnection = str;
                r72 = inputStream;
                httpURLConnection6 = httpURLConnection;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                        return;
                    }
                }
                if (r72 != 0) {
                    r72.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection6 == null) {
                    httpURLConnection6.disconnect();
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                str = str;
                r7 = inputStream;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                        throw th;
                    }
                }
                if (r7 != 0) {
                    r7.close();
                }
                if (inputStream != null) {
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
            inputStream = null;
        } catch (MalformedURLException e30) {
            e = e30;
            httpURLConnection4 = null;
            inputStream = null;
        } catch (ProtocolException e31) {
            e = e31;
            httpURLConnection3 = null;
            inputStream = null;
        } catch (IOException e32) {
            e = e32;
            httpURLConnection2 = null;
            inputStream = null;
        } catch (Exception e33) {
            e = e33;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
            str = 0;
            inputStream = null;
        }
    }

    public static void sendLogMessage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        new Thread(new Runnable(str) { // from class: com.baidu.pass.face.platform.network.LogRequest.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$message;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$message = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogRequest.httpUrlConnectionPost(this.val$message);
                }
            }
        }).start();
    }
}
