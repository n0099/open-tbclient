package com.baidu.sofire.utility;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
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
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f10515a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10516b;

    /* renamed from: c  reason: collision with root package name */
    public String f10517c;

    /* renamed from: d  reason: collision with root package name */
    public String f10518d;

    /* renamed from: e  reason: collision with root package name */
    public int f10519e;

    /* renamed from: f  reason: collision with root package name */
    public int f10520f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10521g;

    public m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10515a = new byte[8192];
        this.f10519e = 120000;
        this.f10520f = 120000;
        this.f10521g = false;
        this.f10516b = context;
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2) == null) {
            this.f10517c = str;
            this.f10518d = str2;
        }
    }

    public static byte[] b(InputStream inputStream) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    private HttpURLConnection a() throws IOException {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (!TextUtils.isEmpty(this.f10517c) && !TextUtils.isEmpty(this.f10518d)) {
                if (!this.f10517c.equals("POST") && !this.f10517c.equals("GET")) {
                    this.f10517c = "POST";
                }
                URL url = new URL(this.f10518d);
                String str = null;
                int i2 = -1;
                if (c.e(this.f10516b)) {
                    i2 = 0;
                } else if (Build.VERSION.SDK_INT >= 13) {
                    str = System.getProperties().getProperty("http.proxyHost");
                    String property = System.getProperties().getProperty("http.proxyPort");
                    if (!TextUtils.isEmpty(property)) {
                        try {
                            i2 = Integer.parseInt(property);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    str = Proxy.getHost(this.f10516b);
                    i2 = Proxy.getPort(this.f10516b);
                }
                if (str != null && i2 > 0) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2)));
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                if ("https".equals(url.getProtocol())) {
                    try {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    } catch (Throwable unused2) {
                        c.a();
                    }
                }
                httpURLConnection.setRequestMethod(this.f10517c);
                httpURLConnection.setDoInput(true);
                if ("POST".equals(this.f10517c)) {
                    httpURLConnection.setDoOutput(true);
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setConnectTimeout(this.f10519e);
                httpURLConnection.setReadTimeout(this.f10520f);
                String str2 = c.g(this.f10516b)[0];
                httpURLConnection.setRequestProperty("User-Agent", "eos/" + str2 + "/" + z.a(this.f10516b) + "/3.5.8.7");
                httpURLConnection.setRequestProperty("Pragma", "no-cache");
                httpURLConnection.setRequestProperty("Accept", "*/*");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
                httpURLConnection.setRequestProperty("x-device-id", o.a(e.b(this.f10516b)));
                return httpURLConnection;
            }
            throw new IllegalArgumentException();
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) throws IOException, NetworkErrorException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, this, bArr, httpURLConnection)) != null) {
            return (InputStream) invokeLL.objValue;
        }
        BufferedOutputStream bufferedOutputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            try {
                if (bArr == null) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String contentEncoding = httpURLConnection.getContentEncoding();
                        if (!TextUtils.isEmpty(contentEncoding) && AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(contentEncoding)) {
                            this.f10521g = true;
                        } else {
                            this.f10521g = false;
                        }
                        return httpURLConnection.getInputStream();
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode));
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    int responseCode2 = httpURLConnection.getResponseCode();
                    if (responseCode2 == 200) {
                        if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                            this.f10521g = true;
                        } else {
                            this.f10521g = false;
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable unused) {
                        }
                        return inputStream;
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode2));
                } catch (NetworkErrorException e2) {
                    throw e2;
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable unused2) {
                    c.a();
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
        } catch (NetworkErrorException e4) {
            throw e4;
        } catch (IOException e5) {
            throw e5;
        } catch (Throwable unused4) {
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, httpURLConnection)) == null) {
            if (c.f(this.f10516b) && httpURLConnection != null && httpURLConnection != null) {
                try {
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        this.f10521g = true;
                    } else {
                        this.f10521g = false;
                    }
                    return httpURLConnection.getInputStream();
                } catch (IOException unused) {
                    c.a();
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    private String a(InputStream inputStream) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, inputStream)) == null) {
            if (inputStream != null) {
                byte[] b2 = b(inputStream);
                if (b2 != null) {
                    if (this.f10521g) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b2);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        i.a(byteArrayInputStream, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                        b2 = byteArray;
                    }
                    if (b2 != null) {
                        return new String(b2);
                    }
                    throw new IOException();
                }
                throw new IOException("responseBytes");
            }
            throw new IOException("InputStream");
        }
        return (String) invokeL.objValue;
    }

    public final String a(String str, byte[] bArr) throws IOException, InterruptedException, NetworkErrorException {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bArr)) == null) {
            y.a();
            try {
                if (s.m(this.f10516b)) {
                    a("POST", str);
                    InputStream inputStream = null;
                    try {
                        httpURLConnection = a();
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = null;
                    }
                    try {
                        inputStream = a(bArr, httpURLConnection);
                        String a2 = a(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return a2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                throw new NetworkErrorException("Not allow background connect.");
            } finally {
                y.b();
            }
        }
        return (String) invokeLL.objValue;
    }

    public final boolean a(String str, File file) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            y.a();
            try {
                if (c.f(this.f10516b)) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    if (s.m(this.f10516b)) {
                        InputStream inputStream = null;
                        try {
                            a("GET", str);
                            httpURLConnection = a();
                        } catch (Throwable unused) {
                            httpURLConnection = null;
                        }
                        try {
                            inputStream = a(httpURLConnection);
                            boolean a2 = a(inputStream, file);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return a2;
                        } catch (Throwable unused2) {
                            c.a();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return false;
                        }
                    }
                    return false;
                }
                return false;
            } finally {
                y.b();
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean a(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (this.f10521g) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
                c.a();
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
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException unused3) {
                        c.a();
                        return true;
                    }
                }
            }
        } catch (Throwable unused4) {
            try {
                c.a();
                return false;
            } finally {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused5) {
                        c.a();
                    }
                }
            }
        }
    }
}
