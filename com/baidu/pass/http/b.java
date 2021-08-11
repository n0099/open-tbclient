package com.baidu.pass.http;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.http.MultipartHashMap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f44013a = "HttpStack";

    /* renamed from: b  reason: collision with root package name */
    public static final String f44014b = "Set-Cookie";

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f44015c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f44016d = "User-Agent";

    /* renamed from: e  reason: collision with root package name */
    public static final int f44017e = 15000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f44018f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44019g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-727620336, "Lcom/baidu/pass/http/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-727620336, "Lcom/baidu/pass/http/b;");
                return;
            }
        }
        f44015c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44018f = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";
        this.f44019g = false;
    }

    private HttpURLConnection b(PassHttpParamDTO passHttpParamDTO) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, passHttpParamDTO)) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(passHttpParamDTO.url).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        if (r2 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
        if (r2 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PassHttpClientRequest passHttpClientRequest) throws IOException, IllegalArgumentException {
        HttpURLConnection a2;
        byte[] bArr;
        HttpResponseHandler httpResponseHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, passHttpClientRequest) == null) || passHttpClientRequest == null || passHttpClientRequest.cancelRequest) {
            return;
        }
        a();
        int i2 = a.f44012a[passHttpClientRequest.method.ordinal()];
        OutputStream outputStream = null;
        if (i2 == 1) {
            a2 = a(passHttpClientRequest.paramDTO);
            bArr = null;
        } else if (i2 == 2) {
            a2 = b(passHttpClientRequest.paramDTO);
            bArr = a(a2, passHttpClientRequest.paramDTO);
        } else {
            throw new IllegalArgumentException(passHttpClientRequest.method + " method not support");
        }
        a(a2, passHttpClientRequest.paramDTO.connectTimeout);
        a(a2, passHttpClientRequest.paramDTO.userAgent);
        a(a2, passHttpClientRequest.paramDTO.headers);
        d.b(passHttpClientRequest.context, a2, passHttpClientRequest.paramDTO);
        if (bArr != null) {
            try {
                outputStream = a2.getOutputStream();
                if (outputStream != null) {
                    outputStream.write(bArr);
                    outputStream.flush();
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        InputStream inputStream = a2.getInputStream();
        int responseCode = a2.getResponseCode();
        HashMap<String, String> a3 = a(a2);
        byte[] a4 = a(inputStream);
        try {
            inputStream.close();
        } catch (Exception unused3) {
        }
        d.a(passHttpClientRequest.context, a2, passHttpClientRequest.paramDTO);
        if (passHttpClientRequest.cancelRequest || (httpResponseHandler = passHttpClientRequest.responseHandler) == null) {
            return;
        }
        httpResponseHandler.b(responseCode, a3, a4);
    }

    private void a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, this, httpURLConnection, hashMap) == null) || hashMap == null) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpURLConnection, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        httpURLConnection.setRequestProperty("User-Agent", str);
    }

    private void a(HttpURLConnection httpURLConnection, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, httpURLConnection, i2) == null) {
            httpURLConnection.setConnectTimeout(i2 == 0 ? 15000 : i2);
            if (i2 == 0) {
                i2 = 15000;
            }
            httpURLConnection.setReadTimeout(i2);
        }
    }

    private byte[] a(HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, httpURLConnection, passHttpParamDTO)) == null) {
            HttpHashMap httpHashMap = passHttpParamDTO.paramsMap;
            if (httpHashMap instanceof MultipartHashMap) {
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.f44018f);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                HttpHashMap httpHashMap2 = passHttpParamDTO.paramsMap;
                if (httpHashMap2 != null) {
                    for (Map.Entry entry : httpHashMap2.getMap().entrySet()) {
                        if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                            a(byteArrayOutputStream, URLEncoder.encode((String) entry.getKey(), "UTF-8"), URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                        }
                    }
                }
                MultipartHashMap.a aVar = ((MultipartHashMap) passHttpParamDTO.paramsMap).fileWrapper;
                a(byteArrayOutputStream, aVar.f43999a, aVar.f44000b, aVar.f44002d, aVar.f44001c);
                a(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } else if (httpHashMap instanceof HttpHashMap) {
                return a(httpHashMap).getBytes("UTF-8");
            } else {
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    private HttpURLConnection a(PassHttpParamDTO passHttpParamDTO) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, passHttpParamDTO)) == null) {
            String a2 = a(passHttpParamDTO.paramsMap);
            if (!TextUtils.isEmpty(a2)) {
                passHttpParamDTO.url += "?" + a2;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(passHttpParamDTO.url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setUseCaches(false);
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    private byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, inputStream)) == null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    return null;
                }
            }
            bufferedOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                bufferedOutputStream.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            try {
                bufferedInputStream.close();
                return byteArray;
            } catch (IOException e8) {
                e8.printStackTrace();
                return byteArray;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private HashMap<String, String> a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, httpURLConnection)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            int size = httpURLConnection.getHeaderFields().size();
            for (int i2 = 0; i2 < size; i2++) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
                String headerField = httpURLConnection.getHeaderField(i2);
                if ("Set-Cookie".equals(headerFieldKey) && !TextUtils.isEmpty(headerField) && headerField.contains("=")) {
                    headerFieldKey = headerField.substring(0, headerField.indexOf("="));
                }
                hashMap.put(headerFieldKey, headerField);
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i2 = 0; i2 < 30; i2++) {
                char[] cArr = f44015c;
                sb.append(cArr[random.nextInt(cArr.length)]);
            }
            this.f44018f = sb.toString();
        }
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, byteArrayOutputStream) == null) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i2 = 0; i2 < 30; i2++) {
                char[] cArr = f44015c;
                sb.append(cArr[random.nextInt(cArr.length)]);
            }
            byte[] bytes = ("\r\n--" + this.f44018f + Part.CRLF).getBytes();
            if (!this.f44019g) {
                this.f44019g = true;
                byteArrayOutputStream.write(("--" + this.f44018f + Part.CRLF).getBytes());
                return;
            }
            byteArrayOutputStream.write(bytes);
        }
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, byteArrayOutputStream, str, str2) == null) {
            a(byteArrayOutputStream);
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            byteArrayOutputStream.write(str2.getBytes());
        }
    }

    private ByteArrayOutputStream a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2, InputStream inputStream, String str3) throws IOException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, this, byteArrayOutputStream, str, str2, inputStream, str3)) == null) {
            try {
                try {
                    a(byteArrayOutputStream);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Content-Disposition: form-data; name=\"");
                    sb.append(str);
                    sb.append("\"; filename=\"");
                    sb.append(str2);
                    sb.append("\"\r\n");
                    byteArrayOutputStream.write(sb.toString().getBytes());
                    if (str3 != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(Part.CONTENT_TYPE);
                        sb2.append(str3);
                        sb2.append("\r\n\r\n");
                        byteArrayOutputStream.write(sb2.toString().getBytes());
                    } else {
                        byteArrayOutputStream.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                    }
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return byteArrayOutputStream;
                } catch (IOException e3) {
                    throw e3;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        return (ByteArrayOutputStream) invokeLLLLL.objValue;
    }

    private String a(HttpHashMap httpHashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, httpHashMap)) == null) {
            StringBuilder sb = new StringBuilder();
            if (httpHashMap != null && httpHashMap.getMap() != null) {
                for (Map.Entry entry : httpHashMap.getMap().entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        try {
                            sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                            sb.append("=");
                            sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                            sb.append("&");
                        } catch (UnsupportedEncodingException e2) {
                            e.a(e2.getMessage());
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(sb)) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
