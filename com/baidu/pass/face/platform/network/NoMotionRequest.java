package com.baidu.pass.face.platform.network;

import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
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
import java.net.URLEncoder;
/* loaded from: classes11.dex */
public class NoMotionRequest extends BaseRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NoMotionRequest";
    public static final String URL_POST_NOMOTION_LIVENESS = "http://face.baidu.com/gate/api/userverifydemo";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(746496574, "Lcom/baidu/pass/face/platform/network/NoMotionRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(746496574, "Lcom/baidu/pass/face/platform/network/NoMotionRequest;");
        }
    }

    public NoMotionRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:111:0x017c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:186:0x0224 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x009e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x00a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x00a7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x00aa */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x016b A[Catch: IOException -> 0x0167, TryCatch #34 {IOException -> 0x0167, blocks: (B:100:0x0163, B:104:0x016b, B:106:0x0170, B:108:0x0175), top: B:216:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0170 A[Catch: IOException -> 0x0167, TryCatch #34 {IOException -> 0x0167, blocks: (B:100:0x0163, B:104:0x016b, B:106:0x0170, B:108:0x0175), top: B:216:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0175 A[Catch: IOException -> 0x0167, TRY_LEAVE, TryCatch #34 {IOException -> 0x0167, blocks: (B:100:0x0163, B:104:0x016b, B:106:0x0170, B:108:0x0175), top: B:216:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0193 A[Catch: IOException -> 0x018f, TryCatch #29 {IOException -> 0x018f, blocks: (B:118:0x018b, B:122:0x0193, B:124:0x0198, B:126:0x019d), top: B:214:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0198 A[Catch: IOException -> 0x018f, TryCatch #29 {IOException -> 0x018f, blocks: (B:118:0x018b, B:122:0x0193, B:124:0x0198, B:126:0x019d), top: B:214:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019d A[Catch: IOException -> 0x018f, TRY_LEAVE, TryCatch #29 {IOException -> 0x018f, blocks: (B:118:0x018b, B:122:0x0193, B:124:0x0198, B:126:0x019d), top: B:214:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bc A[Catch: IOException -> 0x01b8, TryCatch #3 {IOException -> 0x01b8, blocks: (B:136:0x01b4, B:140:0x01bc, B:142:0x01c1, B:144:0x01c6), top: B:205:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c1 A[Catch: IOException -> 0x01b8, TryCatch #3 {IOException -> 0x01b8, blocks: (B:136:0x01b4, B:140:0x01bc, B:142:0x01c1, B:144:0x01c6), top: B:205:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c6 A[Catch: IOException -> 0x01b8, TRY_LEAVE, TryCatch #3 {IOException -> 0x01b8, blocks: (B:136:0x01b4, B:140:0x01bc, B:142:0x01c1, B:144:0x01c6), top: B:205:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e5 A[Catch: IOException -> 0x01e1, TryCatch #38 {IOException -> 0x01e1, blocks: (B:154:0x01dd, B:158:0x01e5, B:160:0x01ea, B:162:0x01ef), top: B:218:0x01dd }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea A[Catch: IOException -> 0x01e1, TryCatch #38 {IOException -> 0x01e1, blocks: (B:154:0x01dd, B:158:0x01e5, B:160:0x01ea, B:162:0x01ef), top: B:218:0x01dd }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ef A[Catch: IOException -> 0x01e1, TRY_LEAVE, TryCatch #38 {IOException -> 0x01e1, blocks: (B:154:0x01dd, B:158:0x01e5, B:160:0x01ea, B:162:0x01ef), top: B:218:0x01dd }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020e A[Catch: IOException -> 0x020a, TryCatch #16 {IOException -> 0x020a, blocks: (B:172:0x0206, B:176:0x020e, B:178:0x0213, B:180:0x0218), top: B:212:0x0206 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0213 A[Catch: IOException -> 0x020a, TryCatch #16 {IOException -> 0x020a, blocks: (B:172:0x0206, B:176:0x020e, B:178:0x0213, B:180:0x0218), top: B:212:0x0206 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0218 A[Catch: IOException -> 0x020a, TRY_LEAVE, TryCatch #16 {IOException -> 0x020a, blocks: (B:172:0x0206, B:176:0x020e, B:178:0x0213, B:180:0x0218), top: B:212:0x0206 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x022f A[Catch: IOException -> 0x022b, TryCatch #12 {IOException -> 0x022b, blocks: (B:188:0x0227, B:192:0x022f, B:194:0x0234, B:196:0x0239), top: B:210:0x0227 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0234 A[Catch: IOException -> 0x022b, TryCatch #12 {IOException -> 0x022b, blocks: (B:188:0x0227, B:192:0x022f, B:194:0x0234, B:196:0x0239), top: B:210:0x0227 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0239 A[Catch: IOException -> 0x022b, TRY_LEAVE, TryCatch #12 {IOException -> 0x022b, blocks: (B:188:0x0227, B:192:0x022f, B:194:0x0234, B:196:0x0239), top: B:210:0x0227 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0227 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
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
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, java.lang.String] */
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
        ?? r7;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e2;
        IOException e3;
        ProtocolException e4;
        MalformedURLException e5;
        UnsupportedEncodingException e6;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r7 = 65539;
            if (interceptable.invokeLL(65539, null, str, handler) != null) {
                return;
            }
        }
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

    public static void sendMessage(String str, Handler handler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, handler) == null) || str == null || str.length() <= 0) {
            return;
        }
        new Thread(new Runnable(str, handler) { // from class: com.baidu.pass.face.platform.network.NoMotionRequest.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$image;
            public final /* synthetic */ Handler val$uiHandler;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, handler};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$image = str;
                this.val$uiHandler = handler;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    NoMotionRequest.httpUrlConnectionPost(this.val$image, this.val$uiHandler);
                }
            }
        }).start();
    }
}
