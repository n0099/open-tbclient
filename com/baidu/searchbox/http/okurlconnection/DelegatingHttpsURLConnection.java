package com.baidu.searchbox.http.okurlconnection;

import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Handshake;
/* loaded from: classes2.dex */
public abstract class DelegatingHttpsURLConnection extends HttpsURLConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpURLConnection delegate;

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract HostnameVerifier getHostnameVerifier();

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract SSLSocketFactory getSSLSocketFactory();

    public abstract Handshake handshake();

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract void setHostnameVerifier(HostnameVerifier hostnameVerifier);

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegatingHttpsURLConnection(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpURLConnection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((URL) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delegate = httpURLConnection;
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.delegate.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048596, this, str, j)) == null) {
            return this.delegate.getHeaderFieldDate(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i)) == null) {
            return this.delegate.getHeaderFieldInt(str, i);
        }
        return invokeLI.intValue;
    }

    @Override // java.net.URLConnection
    @RequiresApi(api = 24)
    public long getHeaderFieldLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048599, this, str, j)) == null) {
            return this.delegate.getHeaderFieldLong(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, str, str2) == null) {
            this.delegate.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((HttpsURLConnection) this).connected = true;
            this.delegate.connect();
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.delegate.disconnect();
        }
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.delegate.getAllowUserInteraction();
        }
        return invokeV.booleanValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Handshake handshake = handshake();
            if (handshake != null) {
                return handshake.cipherSuite().javaName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.delegate.getConnectTimeout();
        }
        return invokeV.intValue;
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.delegate.getContent();
        }
        return invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.delegate.getContentEncoding();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.delegate.getContentLength();
        }
        return invokeV.intValue;
    }

    @Override // java.net.URLConnection
    @RequiresApi(api = 24)
    public long getContentLengthLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.delegate.getContentLengthLong();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.delegate.getContentType();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public long getDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.delegate.getDate();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.delegate.getDefaultUseCaches();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.delegate.getDoInput();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.delegate.getDoOutput();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.delegate.getErrorStream();
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.delegate.getExpiration();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.delegate.getHeaderFields();
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.delegate.getIfModifiedSince();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.delegate.getInputStream();
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.delegate.getInstanceFollowRedirects();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.delegate.getLastModified();
        }
        return invokeV.longValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            Handshake handshake = handshake();
            if (handshake != null) {
                return handshake.localPrincipal();
            }
            return null;
        }
        return (Principal) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.delegate.getOutputStream();
        }
        return (OutputStream) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            Handshake handshake = handshake();
            if (handshake != null) {
                return handshake.peerPrincipal();
            }
            return null;
        }
        return (Principal) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.delegate.getPermission();
        }
        return (Permission) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.delegate.getReadTimeout();
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.delegate.getRequestMethod();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.delegate.getRequestProperties();
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.delegate.getResponseCode();
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.delegate.getResponseMessage();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.delegate.getURL();
        }
        return (URL) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.delegate.getUseCaches();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.delegate.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.delegate.usingProxy();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, clsArr)) == null) {
            return this.delegate.getContent(clsArr);
        }
        return invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            return this.delegate.getHeaderField(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return this.delegate.getHeaderFieldKey(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            return this.delegate.getRequestProperty(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.delegate.setAllowUserInteraction(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.delegate.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.delegate.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.delegate.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.delegate.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.delegate.setDoOutput(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.delegate.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048631, this, j) == null) {
            this.delegate.setIfModifiedSince(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.delegate.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            this.delegate.setReadTimeout(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.delegate.setRequestMethod(str);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.delegate.setUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            return this.delegate.getHeaderField(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection
    @RequiresApi(api = 19)
    public void setFixedLengthStreamingMode(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            this.delegate.setFixedLengthStreamingMode(j);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Handshake handshake = handshake();
            if (handshake == null) {
                return null;
            }
            List<Certificate> localCertificates = handshake.localCertificates();
            if (localCertificates.isEmpty()) {
                return null;
            }
            return (Certificate[]) localCertificates.toArray(new Certificate[localCertificates.size()]);
        }
        return (Certificate[]) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            Handshake handshake = handshake();
            if (handshake == null) {
                return null;
            }
            List<Certificate> peerCertificates = handshake.peerCertificates();
            if (peerCertificates.isEmpty()) {
                return null;
            }
            return (Certificate[]) peerCertificates.toArray(new Certificate[peerCertificates.size()]);
        }
        return (Certificate[]) invokeV.objValue;
    }
}
