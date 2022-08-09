package com.baidu.down.loopj.android.request.handler;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.UrlDNSInfo;
import com.baidu.down.common.intercepter.ResponseInfo;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.loopj.android.http.exp.HandlerRetryException;
import com.baidu.down.loopj.android.http.exp.URLDNSException;
import com.baidu.down.loopj.android.urlconnection.ProxyURLConnection;
import com.baidu.down.loopj.android.urlconnection.UrlConnectionRetryHandler;
import com.baidu.down.retry.RetryRequestInfo;
import com.baidu.down.statistic.ThreadSpeedStat;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes2.dex */
public class UrlConnectionRequestHandler implements ICommonRequestHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "UrlConnectionRequestHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream inputStream;
    public ProxyURLConnection mAsyncUrlConnection;
    public Map<String, String> mBackUpRequestHeader;
    public String mBackUpURL;
    public boolean mConvertDomainNameToIp;
    public UrlDNSInfo mDomainNameAndIpInfo;
    public Map<String, String> mRequestHeader;
    public boolean mTlsCertSkip;
    public String mURL;
    public HttpURLConnection mURLConnectionRequest;
    public UrlConnectionRetryHandler mURLConnectionRetryHandler;

    public UrlConnectionRequestHandler(ProxyURLConnection proxyURLConnection, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {proxyURLConnection, str, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTlsCertSkip = false;
        this.mConvertDomainNameToIp = false;
        this.mURL = str;
        this.mAsyncUrlConnection = proxyURLConnection;
        this.mRequestHeader = map;
        this.mURLConnectionRetryHandler = proxyURLConnection.getRetryHandler();
    }

    @SuppressLint({"LongLogTag"})
    private String convertUrlDomainNameToIp(String str) throws URLDNSException {
        InterceptResult invokeL;
        String str2;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        if (!isConvertUrlDomainNameToIp()) {
            this.mConvertDomainNameToIp = false;
            return str;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String host = new URI(str).getHost();
            InetAddress[] allByName = InetAddress.getAllByName(host);
            if (allByName != null && allByName.length != 0 && !TextUtils.isEmpty(host)) {
                if (!host.equalsIgnoreCase(allByName[0].getHostAddress())) {
                    str2 = str.replace(host, allByName[0].getHostAddress());
                    try {
                        new URL(str2);
                        try {
                            Utils.removeMapKeyIgnoreCase(this.mRequestHeader, "Host");
                            this.mRequestHeader.put("Host", host);
                            UrlDNSInfo urlDNSInfo = new UrlDNSInfo();
                            this.mDomainNameAndIpInfo = urlDNSInfo;
                            urlDNSInfo.host = host;
                            urlDNSInfo.ip = allByName[0].getHostAddress();
                            this.mDomainNameAndIpInfo.dnsTime = System.currentTimeMillis() - currentTimeMillis;
                            this.mConvertDomainNameToIp = true;
                            return str2;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            this.mConvertDomainNameToIp = false;
                            return str2;
                        }
                    } catch (MalformedURLException e3) {
                        e3.printStackTrace();
                        this.mConvertDomainNameToIp = false;
                        return str;
                    }
                }
                this.mConvertDomainNameToIp = false;
                return str;
            }
            throw new URLDNSException("Dns failed");
        } catch (Exception e4) {
            str2 = str;
            e = e4;
        }
    }

    private boolean isConvertUrlDomainNameToIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isGzip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? str != null && str.contains("gzip") : invokeL.booleanValue;
    }

    private void requestConnect(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (this.mAsyncUrlConnection.usingDNSProxy()) {
                try {
                    this.mRequestHeader.put("Host", new URI(str).getHost());
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            if (this.mTlsCertSkip && URLUtil.isHttpsUrl(str)) {
                this.mURLConnectionRequest = this.mAsyncUrlConnection.getHttpURLConnection(str, this.mRequestHeader, true);
            } else if (this.mConvertDomainNameToIp && URLUtil.isHttpsUrl(str)) {
                this.mURLConnectionRequest = this.mAsyncUrlConnection.getHttpURLConnection(str, this.mRequestHeader, false, true);
            } else {
                this.mURLConnectionRequest = this.mAsyncUrlConnection.getHttpURLConnection(str, this.mRequestHeader, true, true);
            }
            this.mURLConnectionRequest.connect();
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void cancelRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public boolean cloneRequest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.mURL = str;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void closeConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void closeInputStream() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.inputStream != null) {
                    this.inputStream.close();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mURLConnectionRequest.getContentLength() : invokeV.longValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public int getHttpStatus() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (isHttpRequestNull()) {
                return 0;
            }
            return this.mURLConnectionRequest.getResponseCode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public InputStream getInputStream() throws IllegalStateException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (isGzip(this.mURLConnectionRequest.getContentEncoding())) {
                this.inputStream = new GZIPInputStream(this.mURLConnectionRequest.getInputStream());
            } else {
                this.inputStream = this.mURLConnectionRequest.getInputStream();
            }
            return this.inputStream;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public ResponseInfo getResponseInfo() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!isHttpRequestNull()) {
                ResponseInfo responseInfo = new ResponseInfo(this.mURLConnectionRequest.getRequestMethod(), this.mURL, this.mURLConnectionRequest.getResponseCode());
                for (String str : this.mRequestHeader.keySet()) {
                    responseInfo.requestHeaders.put(str, this.mRequestHeader.get(str));
                }
                Map<String, List<String>> headerFields = this.mURLConnectionRequest.getHeaderFields();
                for (String str2 : headerFields.keySet()) {
                    if (str2 == null) {
                        responseInfo.responseHeaders.put(StringUtil.NULL_STRING, headerFields.get(str2).get(0));
                    } else {
                        responseInfo.responseHeaders.put(str2, headerFields.get(str2).get(0));
                    }
                }
                return responseInfo;
            }
            return new ResponseInfo("", "", 0);
        }
        return (ResponseInfo) invokeV.objValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mURL : (String) invokeV.objValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public boolean isHttpRequestNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mURLConnectionRequest == null : invokeV.booleanValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public boolean onContainsRequestHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.mRequestHeader.containsKey(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void onExeHttpConnect(BinaryHttpResponseHandler binaryHttpResponseHandler, ThreadSpeedStat threadSpeedStat, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048587, this, binaryHttpResponseHandler, threadSpeedStat, z) == null) {
            String str = this.mURL;
            if (Build.VERSION.SDK_INT < 21 && z) {
                str = Utils.getURLEncoderString(str);
            }
            String convertUrlDomainNameToIp = convertUrlDomainNameToIp(str);
            requestConnect(convertUrlDomainNameToIp);
            if (getHttpStatus() > 207 && this.mAsyncUrlConnection.usingDNSProxy()) {
                this.mURLConnectionRequest.disconnect();
                this.mAsyncUrlConnection.setUsingDNSProxy(false);
                requestConnect(convertUrlDomainNameToIp);
            }
            if (!this.mConvertDomainNameToIp) {
                if (threadSpeedStat != null) {
                    threadSpeedStat.url = this.mURLConnectionRequest.getURL().toString();
                    threadSpeedStat.ip = "";
                    threadSpeedStat.dt = 0L;
                    onSetRequestHeader(ThreadSpeedStat.CLIENT_REQUEST_ID_HEADER_NAME, threadSpeedStat.cqid);
                    return;
                }
                return;
            }
            binaryHttpResponseHandler.saveDomainNameAndIpInfo(this.mDomainNameAndIpInfo);
            if (threadSpeedStat != null) {
                UrlDNSInfo urlDNSInfo = this.mDomainNameAndIpInfo;
                threadSpeedStat.ip = urlDNSInfo.ip;
                threadSpeedStat.dt = urlDNSInfo.dnsTime;
                threadSpeedStat.url = this.mURLConnectionRequest.getURL().toString();
                onSetRequestHeader(ThreadSpeedStat.CLIENT_REQUEST_ID_HEADER_NAME, threadSpeedStat.cqid);
            }
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public String onGetHttpHeader(boolean z) throws IOException {
        InterceptResult invokeZ;
        Map<String, List<String>> headerFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (isHttpRequestNull()) {
                sb.append("Uri: null\n");
            } else if (z) {
                sb.append("Uri:" + this.mURLConnectionRequest.getURL().toString() + "\n");
            } else {
                sb.append("Url:" + this.mURLConnectionRequest.getURL().toString() + " " + this.mURLConnectionRequest.getResponseCode() + "\n");
            }
            Map<String, String> map = this.mRequestHeader;
            if (map != null) {
                for (String str : map.keySet()) {
                    sb.append(str + ":" + this.mRequestHeader.get(str) + "\n");
                }
            }
            if (!isHttpRequestNull()) {
                sb.append(this.mURLConnectionRequest.getResponseMessage() + ": \n");
            }
            if (!z && !isHttpRequestNull() && (headerFields = this.mURLConnectionRequest.getHeaderFields()) != null) {
                for (String str2 : headerFields.keySet()) {
                    if (str2 == null) {
                        sb.append(headerFields.get(str2).toString() + "\n");
                    } else {
                        sb.append(str2.toString() + ":" + headerFields.get(str2).toString() + "\n");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeZ.objValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public String onGetRequestHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? this.mRequestHeader.get(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public String onGetResponseHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? !isHttpRequestNull() ? this.mURLConnectionRequest.getHeaderField(str) : "" : (String) invokeL.objValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void onHandleFollowRedirect(HashSet<String> hashSet) throws RedirectException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hashSet) == null) {
            String headerField = this.mURLConnectionRequest.getHeaderField(Headers.LOCATION);
            if (!TextUtils.isEmpty(headerField)) {
                Utils.removeMapKeyIgnoreCase(this.mRequestHeader, "Host");
                if (!hashSet.contains(headerField)) {
                    try {
                        try {
                            URI uri = new URI(headerField);
                            URI uri2 = new URI(this.mURL);
                            if (TextUtils.isEmpty(uri.getHost())) {
                                headerField = this.mURL.replace(uri2.getPath(), headerField).replace(uri2.getQuery(), "");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        cloneRequest(headerField);
                        hashSet.add(headerField);
                        throw new HandlerRetryException("Redirect");
                    } catch (IllegalArgumentException unused) {
                        throw new RedirectException("Invalid uri: " + this.mURLConnectionRequest.getURL());
                    }
                }
                throw new RedirectException("### Redirect circle : " + hashSet);
            }
            throw new RedirectException("### Redirect null Location : " + this.mURLConnectionRequest.getURL());
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void onRemoveRequestHeader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mRequestHeader.remove(str);
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public boolean onRetryRequest(IOException iOException, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, iOException, i, i2)) == null) {
            if (!isHttpRequestNull()) {
                return this.mURLConnectionRetryHandler.retryRequest(iOException, i, this.mURLConnectionRequest.getURL().getHost(), i2);
            }
            return this.mURLConnectionRetryHandler.retryRequest(iOException, i, "", i2);
        }
        return invokeLII.booleanValue;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void onSetRequestHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            this.mRequestHeader.put(str, str2);
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void replaceRequest(RetryRequestInfo retryRequestInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, retryRequestInfo) == null) || this.mBackUpRequestHeader == null) {
            return;
        }
        this.mRequestHeader = new HashMap();
        for (String str : this.mBackUpRequestHeader.keySet()) {
            this.mRequestHeader.put(str, this.mBackUpRequestHeader.get(str));
        }
        this.mURL = retryRequestInfo.url;
        if (retryRequestInfo.header.isEmpty()) {
            return;
        }
        for (String str2 : retryRequestInfo.header.keySet()) {
            if (TextUtils.isEmpty(retryRequestInfo.header.get(str2))) {
                this.mRequestHeader.remove(str2);
            } else {
                this.mRequestHeader.put(str2, retryRequestInfo.header.get(str2));
            }
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void restoreRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Map<String, String> map = this.mBackUpRequestHeader;
            if (map != null) {
                this.mRequestHeader = map;
                this.mBackUpRequestHeader = null;
                this.mURL = this.mBackUpURL;
                this.mBackUpURL = null;
            }
            if (this.mAsyncUrlConnection.usingDNSProxy()) {
                this.mAsyncUrlConnection.setUsingDNSProxy(false);
            }
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void saveRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.mBackUpRequestHeader = this.mRequestHeader;
            this.mBackUpURL = this.mURL;
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void setTlsCertSkip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mTlsCertSkip = z;
        }
    }
}
