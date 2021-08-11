package com.baidu.mobads.container.util;

import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class NetUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TIMEOUT_IN_MILLIONS = 5000;
    public transient /* synthetic */ FieldHolder $fh;

    public NetUtils() {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0070 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077 A[Catch: all -> 0x007f, TryCatch #5 {all -> 0x007f, blocks: (B:30:0x0072, B:32:0x0077, B:34:0x007c), top: B:52:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #5 {all -> 0x007f, blocks: (B:30:0x0072, B:32:0x0077, B:34:0x007c), top: B:52:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String doGet(String str) {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                httpURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[128];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byteArrayOutputStream.flush();
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused) {
                                }
                            }
                            byteArrayOutputStream.close();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return byteArrayOutputStream2;
                        } catch (Throwable unused2) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused3) {
                                    return null;
                                }
                            }
                            if (byteArrayOutputStream != 0) {
                                byteArrayOutputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        }
                    } catch (Throwable unused4) {
                        byteArrayOutputStream = 0;
                    }
                } else {
                    throw new RuntimeException(" responseCode is not 200 ... ");
                }
            } catch (Throwable unused5) {
                inputStream = null;
                byteArrayOutputStream = inputStream;
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != 0) {
                }
                if (httpURLConnection != null) {
                }
                return null;
            }
        } catch (Throwable unused6) {
            httpURLConnection = null;
            inputStream = null;
        }
    }
}
