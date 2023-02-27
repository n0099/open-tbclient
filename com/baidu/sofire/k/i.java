package com.baidu.sofire.k;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public boolean d;

    public i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.a = context;
    }

    public final InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) throws IOException, NetworkErrorException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, httpURLConnection)) == null) {
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    if (bArr == null) {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            String contentEncoding = httpURLConnection.getContentEncoding();
                            if (!TextUtils.isEmpty(contentEncoding) && "gzip".equalsIgnoreCase(contentEncoding)) {
                                this.d = true;
                            } else {
                                this.d = false;
                            }
                            return inputStream;
                        }
                        throw new NetworkErrorException(String.valueOf(responseCode));
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.flush();
                        int responseCode2 = httpURLConnection.getResponseCode();
                        if (responseCode2 == 200) {
                            InputStream inputStream2 = httpURLConnection.getInputStream();
                            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                                this.d = true;
                            } else {
                                this.d = false;
                            }
                            try {
                                bufferedOutputStream2.close();
                            } catch (Throwable unused) {
                            }
                            return inputStream2;
                        }
                        throw new NetworkErrorException(String.valueOf(responseCode2));
                    } catch (NetworkErrorException e) {
                        throw e;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable unused2) {
                        int i = com.baidu.sofire.a.b.a;
                        throw new IOException();
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            } catch (NetworkErrorException e3) {
                throw e3;
            } catch (IOException e4) {
                throw e4;
            } catch (Throwable unused4) {
            }
        } else {
            return (InputStream) invokeLL.objValue;
        }
    }

    public final String a(InputStream inputStream) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            if (inputStream != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (byteArray != null) {
                    if (this.d) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        byte[] bArr2 = new byte[2048];
                        while (true) {
                            int read2 = gZIPInputStream.read(bArr2, 0, 2048);
                            if (read2 == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read2);
                        }
                        gZIPInputStream.close();
                        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        byteArrayInputStream.close();
                        byteArray = byteArray2;
                    }
                    if (byteArray != null) {
                        return new String(byteArray);
                    }
                    throw new IOException();
                }
                throw new IOException("responseBytes");
            }
            throw new IOException("InputStream");
        }
        return (String) invokeL.objValue;
    }

    public String a(String str) throws IOException, InterruptedException, NetworkErrorException {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            com.baidu.sofire.a.a.b();
            try {
                if (q.a(this.a)) {
                    InputStream inputStream = null;
                    try {
                        this.b = "GET";
                        this.c = str;
                        httpURLConnection = a();
                        try {
                            inputStream = a((byte[]) null, httpURLConnection);
                            String a = a(inputStream);
                            inputStream.close();
                            httpURLConnection.disconnect();
                            return a;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = null;
                    }
                } else {
                    throw new NetworkErrorException("Not allow background connect.");
                }
            } finally {
                com.baidu.sofire.a.a.a();
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public String a(String str, byte[] bArr) throws IOException, InterruptedException, NetworkErrorException {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bArr)) == null) {
            com.baidu.sofire.a.a.b();
            try {
                if (q.a(this.a)) {
                    this.b = "POST";
                    this.c = str;
                    InputStream inputStream = null;
                    try {
                        httpURLConnection = a();
                        try {
                            inputStream = a(bArr, httpURLConnection);
                            String a = a(inputStream);
                            inputStream.close();
                            httpURLConnection.disconnect();
                            return a;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = null;
                    }
                } else {
                    throw new NetworkErrorException("Not allow background connect.");
                }
            } finally {
                com.baidu.sofire.a.a.a();
            }
        } else {
            return (String) invokeLL.objValue;
        }
    }

    public final HttpURLConnection a() throws IOException {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                if (!this.b.equals("POST") && !this.b.equals("GET")) {
                    this.b = "POST";
                }
                URL url = new URL(this.c);
                String str = null;
                int i = 80;
                if (!b.l(this.a)) {
                    if (Build.VERSION.SDK_INT >= 13) {
                        str = System.getProperties().getProperty("http.proxyHost");
                        String property = System.getProperties().getProperty("http.proxyPort");
                        if (!TextUtils.isEmpty(property)) {
                            try {
                                i = Integer.parseInt(property);
                            } catch (Throwable unused) {
                                i = -1;
                            }
                        }
                        i = -1;
                    } else {
                        str = Proxy.getHost(this.a);
                        i = Proxy.getPort(this.a);
                    }
                }
                if (str != null && i > 0) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                if ("https".equals(url.getProtocol())) {
                    try {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    } catch (Throwable unused2) {
                        int i2 = com.baidu.sofire.a.b.a;
                    }
                }
                httpURLConnection.setRequestMethod(this.b);
                httpURLConnection.setDoInput(true);
                if ("POST".equals(this.b)) {
                    httpURLConnection.setDoOutput(true);
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setConnectTimeout(120000);
                httpURLConnection.setReadTimeout(120000);
                String str2 = b.o(this.a)[0];
                httpURLConnection.setRequestProperty("User-Agent", "eos/" + str2 + "/" + v.a(this.a) + "/3.6.0.4");
                httpURLConnection.setRequestProperty("Pragma", "no-cache");
                httpURLConnection.setRequestProperty("Accept", "*/*");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
                httpURLConnection.setRequestProperty("x-device-id", j.a(d.a(this.a)));
                return httpURLConnection;
            }
            throw new IllegalArgumentException();
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    public final boolean a(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, inputStream, file)) == null) {
            if (this.d) {
                try {
                    inputStream = new GZIPInputStream(inputStream);
                } catch (IOException unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
            }
            if (inputStream == null) {
                return false;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable unused2) {
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                }
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused3) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
                return true;
            } catch (Throwable unused4) {
                try {
                    int i3 = com.baidu.sofire.a.b.a;
                    return false;
                } finally {
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused5) {
                            int i4 = com.baidu.sofire.a.b.a;
                        }
                    }
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean a(String str, File file) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, file)) == null) {
            com.baidu.sofire.a.a.b();
            try {
                if (!b.k(this.a)) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (!q.a(this.a)) {
                    return false;
                }
                InputStream inputStream = null;
                try {
                    this.b = "GET";
                    this.c = str;
                    httpURLConnection = a();
                } catch (Throwable unused) {
                    httpURLConnection = null;
                }
                try {
                    if (b.k(this.a)) {
                        try {
                            InputStream inputStream2 = httpURLConnection.getInputStream();
                            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                                this.d = true;
                            } else {
                                this.d = false;
                            }
                            inputStream = inputStream2;
                        } catch (IOException unused2) {
                            int i = com.baidu.sofire.a.b.a;
                        }
                    }
                    boolean a = a(inputStream, file);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    httpURLConnection.disconnect();
                    return a;
                } catch (Throwable unused3) {
                    int i2 = com.baidu.sofire.a.b.a;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                }
            } finally {
                com.baidu.sofire.a.a.a();
            }
        }
        return invokeLL.booleanValue;
    }
}
