package com.baidu.searchbox.bddownload.core.connection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.bddownload.IRedirectHandler;
import com.baidu.searchbox.bddownload.RedirectUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class DownloadUrlConnection implements DownloadConnection, DownloadConnection.Connected {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DownloadUrlConnection";
    public transient /* synthetic */ FieldHolder $fh;
    public Configuration configuration;
    public URLConnection connection;
    public IRedirectHandler redirectHandler;
    public URL url;

    /* loaded from: classes7.dex */
    public static class Configuration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer connectTimeout;
        public Proxy proxy;
        public Integer readTimeout;

        public Configuration() {
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

        public Configuration connectTimeout(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.connectTimeout = Integer.valueOf(i2);
                return this;
            }
            return (Configuration) invokeI.objValue;
        }

        public Configuration proxy(Proxy proxy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, proxy)) == null) {
                this.proxy = proxy;
                return this;
            }
            return (Configuration) invokeL.objValue;
        }

        public Configuration readTimeout(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.readTimeout = Integer.valueOf(i2);
                return this;
            }
            return (Configuration) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class Factory implements DownloadConnection.Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Configuration configuration;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Factory() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((Configuration) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public DownloadConnection create(URL url) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) ? new DownloadUrlConnection(url, this.configuration) : (DownloadConnection) invokeL.objValue;
        }

        public Factory(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {configuration};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Util.d(DownloadUrlConnection.TAG, "Factory ");
            this.configuration = configuration;
        }

        @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Factory
        public DownloadConnection create(String str) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new DownloadUrlConnection(str, this.configuration) : (DownloadConnection) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class RedirectHandler implements IRedirectHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String redirectLocation;

        public RedirectHandler() {
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

        @Override // com.baidu.searchbox.bddownload.IRedirectHandler
        @Nullable
        public String getRedirectLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.redirectLocation : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.bddownload.IRedirectHandler
        public void handleRedirect(DownloadConnection downloadConnection, DownloadConnection.Connected connected, Map<String, List<String>> map) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadConnection, connected, map) == null) {
                DownloadUrlConnection downloadUrlConnection = (DownloadUrlConnection) downloadConnection;
                int i2 = 0;
                for (int responseCode = connected.getResponseCode(); RedirectUtil.isRedirect(responseCode); responseCode = downloadUrlConnection.getResponseCode()) {
                    downloadUrlConnection.release();
                    i2++;
                    if (i2 <= 10) {
                        this.redirectLocation = RedirectUtil.getRedirectedUrl(connected, responseCode);
                        downloadUrlConnection.url = new URL(this.redirectLocation);
                        downloadUrlConnection.configUrlConnection();
                        Util.addRequestHeaderFields(map, downloadUrlConnection);
                        downloadUrlConnection.connection.connect();
                    } else {
                        throw new ProtocolException("Too many redirect requests: " + i2);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadUrlConnection(URLConnection uRLConnection) {
        this(uRLConnection, new RedirectHandler());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uRLConnection};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URLConnection) objArr2[0], (IRedirectHandler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.connection.addRequestProperty(str, str2);
        }
    }

    public void configUrlConnection() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Util.d(TAG, "config connection for " + this.url);
            Configuration configuration = this.configuration;
            if (configuration != null && configuration.proxy != null) {
                this.connection = this.url.openConnection(this.configuration.proxy);
            } else {
                this.connection = this.url.openConnection();
            }
            Configuration configuration2 = this.configuration;
            if (configuration2 != null) {
                if (configuration2.readTimeout != null) {
                    this.connection.setReadTimeout(this.configuration.readTimeout.intValue());
                }
                if (this.configuration.connectTimeout != null) {
                    this.connection.setConnectTimeout(this.configuration.connectTimeout.intValue());
                }
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public DownloadConnection.Connected execute() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, List<String>> requestProperties = getRequestProperties();
            this.connection.connect();
            this.redirectHandler.handleRedirect(this, this, requestProperties);
            return this;
        }
        return (DownloadConnection.Connected) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.connection.getInputStream() : (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public String getRedirectLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.redirectHandler.getRedirectLocation() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.connection.getRequestProperties() : (Map) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.connection.getRequestProperty(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            URLConnection uRLConnection = this.connection;
            if (uRLConnection instanceof HttpURLConnection) {
                return ((HttpURLConnection) uRLConnection).getResponseCode();
            }
            Util.d(TAG, "getResponseCode " + this.url);
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public String getResponseHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.connection.getHeaderField(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public Map<String, List<String>> getResponseHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.connection.getHeaderFields() : (Map) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                InputStream inputStream = this.connection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public boolean setRequestMethod(@NonNull String str) throws ProtocolException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            URLConnection uRLConnection = this.connection;
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).setRequestMethod(str);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public DownloadUrlConnection(URLConnection uRLConnection, IRedirectHandler iRedirectHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uRLConnection, iRedirectHandler};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.connection = uRLConnection;
        this.url = uRLConnection.getURL();
        this.redirectHandler = iRedirectHandler;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadUrlConnection(String str, Configuration configuration) throws IOException {
        this(new URL(str), configuration);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, configuration};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URL) objArr2[0], (Configuration) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadUrlConnection(URL url, Configuration configuration) throws IOException {
        this(url, configuration, new RedirectHandler());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, configuration};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URL) objArr2[0], (Configuration) objArr2[1], (IRedirectHandler) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public DownloadUrlConnection(URL url, Configuration configuration, IRedirectHandler iRedirectHandler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, configuration, iRedirectHandler};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.configuration = configuration;
        this.url = url;
        this.redirectHandler = iRedirectHandler;
        configUrlConnection();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadUrlConnection(String str) throws IOException {
        this(str, (Configuration) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Configuration) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
