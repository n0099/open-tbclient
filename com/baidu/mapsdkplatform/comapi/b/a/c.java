package com.baidu.mapsdkplatform.comapi.b.a;

import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.mapsdkplatform.comapi.util.i;
import com.baidu.mapsdkplatform.comjni.util.JNIHandler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.zip.GZIPOutputStream;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f40016a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f40017b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f40018c = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Context f40019d;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f40020a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1179817916, "Lcom/baidu/mapsdkplatform/comapi/b/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1179817916, "Lcom/baidu/mapsdkplatform/comapi/b/a/c$a;");
                    return;
                }
            }
            f40020a = new c();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(363238489, "Lcom/baidu/mapsdkplatform/comapi/b/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(363238489, "Lcom/baidu/mapsdkplatform/comapi/b/a/c;");
        }
    }

    public c() {
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

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f40020a : (c) invokeV.objValue;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, inputStream, outputStream) != null) {
            return;
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                try {
                    outputStream.close();
                    inputStream.close();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            gZIPOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File[] fileArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, fileArr) == null) {
            int length = fileArr.length;
            for (int i2 = 0; i2 < length - 10; i2++) {
                int i3 = i2 + 10;
                if (fileArr[i3] != null && fileArr[i3].exists()) {
                    fileArr[i3].delete();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:105:0x010e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00e4 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a(File file) {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, this, file)) != null) {
            return invokeL.booleanValue;
        }
        synchronized (this) {
            OutputStream outputStream = null;
            BufferedReader bufferedReader4 = null;
            OutputStream outputStream2 = null;
            try {
                httpURLConnection = g();
                if (httpURLConnection == null) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                }
                try {
                    httpURLConnection.connect();
                    OutputStream outputStream3 = httpURLConnection.getOutputStream();
                    try {
                        outputStream3.write(a(b(file).toString().getBytes()));
                        outputStream3.write(a(("--bd_map_sdk_cc" + Part.CRLF + "Content-Disposition: form-data; name=\"file\"; filename=\"c.txt\"\r\n" + Part.CRLF).getBytes()));
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        outputStream3.write(a(byteArrayOutputStream.toByteArray()));
                        dataInputStream.close();
                        byteArrayOutputStream.close();
                        outputStream3.write(a("\r\n--bd_map_sdk_cc--\r\n".getBytes()));
                        outputStream3.flush();
                        if (httpURLConnection.getResponseCode() == 200) {
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream));
                                try {
                                    try {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        while (true) {
                                            int read2 = bufferedReader3.read();
                                            if (read2 == -1) {
                                                break;
                                            }
                                            stringBuffer.append((char) read2);
                                        }
                                        try {
                                            JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                                            if (jSONObject.has("status") && jSONObject.getInt("status") == 0 && file.exists()) {
                                                file.delete();
                                            }
                                        } catch (Exception unused2) {
                                        }
                                        bufferedReader4 = bufferedReader3;
                                    } catch (Exception unused3) {
                                        outputStream2 = outputStream3;
                                        bufferedReader2 = bufferedReader3;
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                            } catch (Exception unused4) {
                                            }
                                        }
                                        if (inputStream != null && bufferedReader2 != 0) {
                                            try {
                                                inputStream.close();
                                                bufferedReader2.close();
                                            } catch (Exception unused5) {
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Exception unused6) {
                                            }
                                        }
                                        return false;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    outputStream = outputStream3;
                                    bufferedReader = bufferedReader3;
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused7) {
                                        }
                                    }
                                    if (inputStream != null && bufferedReader != 0) {
                                        try {
                                            inputStream.close();
                                            bufferedReader.close();
                                        } catch (Exception unused8) {
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Exception unused9) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception unused10) {
                                bufferedReader3 = null;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader3 = null;
                            }
                        } else {
                            inputStream = null;
                        }
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (Exception unused11) {
                            }
                        }
                        if (inputStream != null && bufferedReader4 != null) {
                            try {
                                inputStream.close();
                                bufferedReader4.close();
                            } catch (Exception unused12) {
                            }
                        }
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused13) {
                            }
                        }
                        return true;
                    } catch (Exception unused14) {
                        inputStream = null;
                        bufferedReader3 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        bufferedReader3 = null;
                    }
                } catch (Exception unused15) {
                    inputStream = null;
                    bufferedReader2 = inputStream;
                    if (outputStream2 != null) {
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        bufferedReader2.close();
                    }
                    if (httpURLConnection != null) {
                    }
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    bufferedReader = inputStream;
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        bufferedReader.close();
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception unused16) {
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                inputStream = null;
            }
        }
    }

    private byte[] a(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, bArr)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            a(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    private StringBuilder b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, file)) == null) {
            String[] split = file.getName().substring(0, file.getName().length() - 4).split("_");
            StringBuilder sb = new StringBuilder();
            sb.append("--bd_map_sdk_cc");
            sb.append(Part.CRLF);
            sb.append("Content-Disposition: form-data; name=\"phoneinfo\"\r\n");
            sb.append(Part.CRLF);
            sb.append(URLDecoder.decode(SyncSysInfo.getPhoneInfo() + "&abi=" + f40018c));
            sb.append(Part.CRLF);
            sb.append("--bd_map_sdk_cc");
            sb.append(Part.CRLF);
            if (split[0] != null && !split[0].isEmpty()) {
                sb.append("Content-Disposition: form-data; name=\"packname\"\r\n");
                sb.append(Part.CRLF);
                sb.append(split[0]);
                sb.append(Part.CRLF);
                sb.append("--bd_map_sdk_cc");
                sb.append(Part.CRLF);
            }
            if (split[1] != null && !split[1].isEmpty()) {
                sb.append("Content-Disposition: form-data; name=\"version\"\r\n");
                sb.append(Part.CRLF);
                sb.append(split[1]);
                sb.append(Part.CRLF);
                sb.append("--bd_map_sdk_cc");
                sb.append(Part.CRLF);
            }
            if (split[2] != null && !split[2].isEmpty()) {
                sb.append("Content-Disposition: form-data; name=\"timestamp\"\r\n");
                sb.append(Part.CRLF);
                sb.append(split[2]);
                sb.append(Part.CRLF);
                sb.append("--bd_map_sdk_cc");
                sb.append(Part.CRLF);
            }
            sb.append("Content-Disposition: form-data; name=\"os\"\r\n");
            sb.append(Part.CRLF);
            sb.append("android");
            sb.append(Part.CRLF);
            sb.append("--bd_map_sdk_cc");
            sb.append(Part.CRLF);
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || h.a().b() == null) {
            return;
        }
        String b2 = h.a().b().b();
        if (b2.isEmpty()) {
            return;
        }
        String str = b2 + File.separator + "crash";
        File file = new File(str);
        if (file.exists() || file.mkdir()) {
            f40016a = str;
        } else {
            f40016a = b2;
        }
    }

    private void e() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (str = f40016a) == null || str.isEmpty() || (str2 = f40017b) == null || str2.isEmpty()) {
            return;
        }
        String str3 = f40016a + File.separator + f40017b;
        com.baidu.mapsdkplatform.comapi.b.a.a.a().a(str3);
        JNIHandler.registerNativeHandler(str3);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && NetworkUtil.isNetworkAvailable(this.f40019d)) {
            new Thread(new d(this)).start();
        }
    }

    private HttpURLConnection g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.map.baidu.com/lbs_sdkcc/report").openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=bd_map_sdk_cc");
                httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
                httpURLConnection.setConnectTimeout(10000);
                return httpURLConnection;
            } catch (Exception unused) {
                return null;
            }
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            f40018c = strArr[0];
        }
        this.f40019d = context;
        String n = i.n();
        if (n.isEmpty()) {
            return;
        }
        if (n.contains("_")) {
            n = n.replaceAll("_", "");
        }
        f40017b = n + "_" + i.i() + "_";
        d();
        e();
        f();
    }
}
