package com.baidu.searchbox.http.okurlconnection;

import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;
/* loaded from: classes2.dex */
public final class OkHttpsURLConnection extends DelegatingHttpsURLConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpURLConnection delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpsURLConnection(OkHttpURLConnection okHttpURLConnection) {
        super(okHttpURLConnection);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpURLConnection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((HttpURLConnection) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delegate = okHttpURLConnection;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OkHttpsURLConnection(URL url, OkHttpClient okHttpClient) {
        this(new OkHttpURLConnection(url, okHttpClient));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, okHttpClient};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((OkHttpURLConnection) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OkHttpsURLConnection(URL url, OkHttpClient okHttpClient, URLFilter uRLFilter) {
        this(new OkHttpURLConnection(url, okHttpClient, uRLFilter));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, okHttpClient, uRLFilter};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((OkHttpURLConnection) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void addRequestProperty(String str, String str2) {
        super.addRequestProperty(str, str2);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getHeaderFieldDate(String str, long j) {
        return super.getHeaderFieldDate(str, j);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getHeaderFieldInt(String str, int i) {
        return super.getHeaderFieldInt(str, i);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    @RequiresApi(api = 24)
    public /* bridge */ /* synthetic */ long getHeaderFieldLong(String str, long j) {
        return super.getHeaderFieldLong(str, j);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setRequestProperty(String str, String str2) {
        super.setRequestProperty(str, str2);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void connect() throws IOException {
        super.connect();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void disconnect() {
        super.disconnect();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getAllowUserInteraction() {
        return super.getAllowUserInteraction();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ String getCipherSuite() {
        return super.getCipherSuite();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getConnectTimeout() {
        return super.getConnectTimeout();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Object getContent() throws IOException {
        return super.getContent();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getContentEncoding() {
        return super.getContentEncoding();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getContentLength() {
        return super.getContentLength();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    @RequiresApi(api = 24)
    public /* bridge */ /* synthetic */ long getContentLengthLong() {
        return super.getContentLengthLong();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getContentType() {
        return super.getContentType();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getDate() {
        return super.getDate();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDefaultUseCaches() {
        return super.getDefaultUseCaches();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDoInput() {
        return super.getDoInput();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDoOutput() {
        return super.getDoOutput();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ InputStream getErrorStream() {
        return super.getErrorStream();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getExpiration() {
        return super.getExpiration();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Map getHeaderFields() {
        return super.getHeaderFields();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.delegate.client.hostnameVerifier();
        }
        return (HostnameVerifier) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getIfModifiedSince() {
        return super.getIfModifiedSince();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ InputStream getInputStream() throws IOException {
        return super.getInputStream();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ boolean getInstanceFollowRedirects() {
        return super.getInstanceFollowRedirects();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getLastModified() {
        return super.getLastModified();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ Certificate[] getLocalCertificates() {
        return super.getLocalCertificates();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ Principal getLocalPrincipal() {
        return super.getLocalPrincipal();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ OutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return super.getPeerPrincipal();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Permission getPermission() throws IOException {
        return super.getPermission();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getReadTimeout() {
        return super.getReadTimeout();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ String getRequestMethod() {
        return super.getRequestMethod();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Map getRequestProperties() {
        return super.getRequestProperties();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ int getResponseCode() throws IOException {
        return super.getResponseCode();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ String getResponseMessage() throws IOException {
        return super.getResponseMessage();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.delegate.client.sslSocketFactory();
        }
        return (SSLSocketFactory) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return super.getServerCertificates();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ URL getURL() {
        return super.getURL();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getUseCaches() {
        return super.getUseCaches();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection
    public Handshake handshake() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            OkHttpURLConnection okHttpURLConnection = this.delegate;
            if (okHttpURLConnection.call != null) {
                return okHttpURLConnection.handshake;
            }
            throw new IllegalStateException("Connection has not yet been established");
        }
        return (Handshake) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ boolean usingProxy() {
        return super.usingProxy();
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Object getContent(Class[] clsArr) throws IOException {
        return super.getContent(clsArr);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getHeaderField(int i) {
        return super.getHeaderField(i);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getHeaderFieldKey(int i) {
        return super.getHeaderFieldKey(i);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getRequestProperty(String str) {
        return super.getRequestProperty(str);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setAllowUserInteraction(boolean z) {
        super.setAllowUserInteraction(z);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setChunkedStreamingMode(int i) {
        super.setChunkedStreamingMode(i);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setConnectTimeout(int i) {
        super.setConnectTimeout(i);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDefaultUseCaches(boolean z) {
        super.setDefaultUseCaches(z);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDoInput(boolean z) {
        super.setDoInput(z);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDoOutput(boolean z) {
        super.setDoOutput(z);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setFixedLengthStreamingMode(int i) {
        super.setFixedLengthStreamingMode(i);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, hostnameVerifier) == null) {
            OkHttpURLConnection okHttpURLConnection = this.delegate;
            okHttpURLConnection.client = okHttpURLConnection.client.newBuilder().hostnameVerifier(hostnameVerifier).build();
        }
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setInstanceFollowRedirects(boolean z) {
        super.setInstanceFollowRedirects(z);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setReadTimeout(int i) {
        super.setReadTimeout(i);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setRequestMethod(String str) throws ProtocolException {
        super.setRequestMethod(str);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, sSLSocketFactory) == null) {
            if (sSLSocketFactory != null) {
                OkHttpURLConnection okHttpURLConnection = this.delegate;
                okHttpURLConnection.client = okHttpURLConnection.client.newBuilder().sslSocketFactory(sSLSocketFactory).build();
                return;
            }
            throw new IllegalArgumentException("sslSocketFactory == null");
        }
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setUseCaches(boolean z) {
        super.setUseCaches(z);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getHeaderField(String str) {
        return super.getHeaderField(str);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    @RequiresApi(api = 19)
    public /* bridge */ /* synthetic */ void setFixedLengthStreamingMode(long j) {
        super.setFixedLengthStreamingMode(j);
    }
}
