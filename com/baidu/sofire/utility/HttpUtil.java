package com.baidu.sofire.utility;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
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
import javax.net.ssl.SSLSocketFactory;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class HttpUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUF_LEN = 1024;
    public static final int TIMEOUT = 120000;
    public static final String TYPE_GZIP = "gzip";
    public static SSLSocketFactory sslSocketFactory;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] bigBuf;
    public int mConnectTimeout;
    public Context mContext;
    public int mReadTimeout;
    public boolean mUseGZip;
    public String method;
    public String urlStr;

    public HttpUtil(Context context, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bigBuf = new byte[8192];
        this.mConnectTimeout = 120000;
        this.mReadTimeout = 120000;
        this.mUseGZip = false;
        this.mContext = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.net.HttpURLConnection] */
    private HttpURLConnection getConnection() throws IOException {
        InterceptResult invokeV;
        HttpsURLConnection httpsURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (!TextUtils.isEmpty(this.method) && !TextUtils.isEmpty(this.urlStr)) {
                if (!this.method.equals("POST") && !this.method.equals("GET")) {
                    this.method = "POST";
                }
                URL url = new URL(this.urlStr);
                String str = null;
                int i = -1;
                if (CommonMethods.isWifiAvailable(this.mContext)) {
                    i = 0;
                } else if (Build.VERSION.SDK_INT >= 13) {
                    str = System.getProperties().getProperty("http.proxyHost");
                    String property = System.getProperties().getProperty("http.proxyPort");
                    if (!TextUtils.isEmpty(property)) {
                        try {
                            i = Integer.parseInt(property);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    str = Proxy.getHost(this.mContext);
                    i = Proxy.getPort(this.mContext);
                }
                if (str != null && i > 0) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if ("https".equals(url.getProtocol())) {
                    initSSLSocketFactory(httpsURLConnection);
                }
                httpsURLConnection.setRequestMethod(this.method);
                httpsURLConnection.setDoInput(true);
                if ("POST".equals(this.method)) {
                    httpsURLConnection.setDoOutput(true);
                }
                httpsURLConnection.setInstanceFollowRedirects(true);
                httpsURLConnection.setConnectTimeout(this.mConnectTimeout);
                httpsURLConnection.setReadTimeout(this.mReadTimeout);
                String str2 = CommonMethods.selectAppKeyAndSecurityKey(this.mContext)[0];
                httpsURLConnection.setRequestProperty("User-Agent", "eos/" + str2 + "/" + VersionUtil.getVersionName(this.mContext) + "/3.5.9.3");
                httpsURLConnection.setRequestProperty("Pragma", "no-cache");
                httpsURLConnection.setRequestProperty("Accept", "*/*");
                httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                httpsURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
                httpsURLConnection.setRequestProperty("x-device-id", MD5Util.getMD5(DbUtil.getCUID(this.mContext)));
                return httpsURLConnection;
            }
            throw new IllegalArgumentException();
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    private byte[] getResponse(InputStream inputStream) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, inputStream)) != null) {
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

    private void initParameters(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2) == null) {
            this.method = str;
            this.urlStr = str2;
        }
    }

    private void initSSLSocketFactory(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, httpsURLConnection) == null) {
            try {
                httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    private InputStream requestFromServerStream(byte[] bArr, HttpURLConnection httpURLConnection) throws IOException, NetworkErrorException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65543, this, bArr, httpURLConnection)) != null) {
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
                        InputStream inputStream = httpURLConnection.getInputStream();
                        String contentEncoding = httpURLConnection.getContentEncoding();
                        if (!TextUtils.isEmpty(contentEncoding) && "gzip".equalsIgnoreCase(contentEncoding)) {
                            this.mUseGZip = true;
                        } else {
                            this.mUseGZip = false;
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
                            this.mUseGZip = true;
                        } else {
                            this.mUseGZip = false;
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
                } catch (Throwable th) {
                    th = th;
                    CommonMethods.handleNuLException(th);
                    throw new IOException();
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (NetworkErrorException e3) {
            throw e3;
        } catch (IOException e4) {
            throw e4;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean responseToFile(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, this, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (this.mUseGZip) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException e) {
                CommonMethods.handleNuLException(e);
            }
        }
        if (inputStream == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
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
                    } catch (IOException e2) {
                        CommonMethods.handleNuLException(e2);
                        return true;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                CommonMethods.handleNuLException(th);
                return false;
            } finally {
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        CommonMethods.handleNuLException(e3);
                    }
                }
            }
        }
    }

    private String responseToString(InputStream inputStream) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, inputStream)) == null) {
            if (inputStream != null) {
                try {
                    byte[] response = getResponse(inputStream);
                    if (response != null) {
                        if (this.mUseGZip) {
                            response = GZipUtil.decompress(response);
                        }
                        if (response != null) {
                            return new String(response);
                        }
                        throw new IOException();
                    }
                    throw new IOException("responseBytes");
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    throw new IOException();
                }
            }
            throw new IOException("InputStream");
        }
        return (String) invokeL.objValue;
    }

    public boolean downloadFile(String str, File file) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, str, file)) != null) {
            return invokeLL.booleanValue;
        }
        TrafficStatsUtils.setThreadStatsTag();
        try {
            if (!CommonMethods.isNetworkAvailable(this.mContext)) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!PrivacyOperationUtil.allowNetwork(this.mContext)) {
                return false;
            }
            InputStream inputStream = null;
            try {
                initParameters("GET", str);
                httpURLConnection = getConnection();
                try {
                    inputStream = requestFromServerStream(httpURLConnection);
                    boolean responseToFile = responseToFile(inputStream, file);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return responseToFile;
                } catch (Throwable th) {
                    th = th;
                    CommonMethods.handleNuLException(th);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
            }
        } finally {
            TrafficStatsUtils.clearThreadStatsTag();
        }
    }

    public String requestForGet(String str) throws IOException, InterruptedException, NetworkErrorException {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            TrafficStatsUtils.setThreadStatsTag();
            try {
                if (PrivacyOperationUtil.allowNetwork(this.mContext)) {
                    InputStream inputStream = null;
                    try {
                        initParameters("GET", str);
                        httpURLConnection = getConnection();
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = null;
                    }
                    try {
                        inputStream = requestFromServerStream(null, httpURLConnection);
                        String responseToString = responseToString(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return responseToString;
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
                TrafficStatsUtils.clearThreadStatsTag();
            }
        }
        return (String) invokeL.objValue;
    }

    public String requestForPost(String str, byte[] bArr) throws IOException, InterruptedException, NetworkErrorException {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr)) == null) {
            TrafficStatsUtils.setThreadStatsTag();
            try {
                if (PrivacyOperationUtil.allowNetwork(this.mContext)) {
                    initParameters("POST", str);
                    InputStream inputStream = null;
                    try {
                        httpURLConnection = getConnection();
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = null;
                    }
                    try {
                        inputStream = requestFromServerStream(bArr, httpURLConnection);
                        String responseToString = responseToString(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return responseToString;
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
                TrafficStatsUtils.clearThreadStatsTag();
            }
        }
        return (String) invokeLL.objValue;
    }

    public void setConnectTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.mConnectTimeout = i;
        }
    }

    public void setReadTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mReadTimeout = i;
        }
    }

    public HttpUtil(Context context) {
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
        this.bigBuf = new byte[8192];
        this.mConnectTimeout = 120000;
        this.mReadTimeout = 120000;
        this.mUseGZip = false;
        this.mContext = context;
    }

    private InputStream requestFromServerStream(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, httpURLConnection)) == null) {
            if (CommonMethods.isNetworkAvailable(this.mContext) && httpURLConnection != null && httpURLConnection != null) {
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        this.mUseGZip = true;
                    } else {
                        this.mUseGZip = false;
                    }
                    return inputStream;
                } catch (IOException e) {
                    CommonMethods.handleNuLException(e);
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }
}
