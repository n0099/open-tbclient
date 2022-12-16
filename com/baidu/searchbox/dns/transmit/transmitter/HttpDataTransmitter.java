package com.baidu.searchbox.dns.transmit.transmitter;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.dns.transmit.transmitter.exception.RetryException;
import com.baidu.searchbox.dns.transmit.transmitter.exception.StopRequestException;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public abstract class HttpDataTransmitter<T> implements HttpTransmitter<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHARSET = "UTF-8";
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    public static final int RETRY_DELAY = 5000;
    public static final int RETRY_MAX_TIMES = 2;
    public static final int SUCCESS_CODE = 200;
    public static final int TIMEOUT = 30000;
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android %s) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsCancel;
    public int maxRetryTimes;
    public int retryTimes;

    public int getMaxRetryTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public abstract Map<String, Object> getParameters();

    public abstract String getUrl();

    public abstract void handleException(Exception exc);

    public abstract void handleServerError(int i);

    public boolean isHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNoRetryServerError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? 403 == i || 404 == i : invokeI.booleanValue;
    }

    public abstract T parseResult(String str);

    public abstract void postHandleConnection(HttpURLConnection httpURLConnection) throws RetryException;

    public HttpDataTransmitter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.retryTimes = 0;
        this.mIsCancel = false;
        this.maxRetryTimes = getMaxRetryTimes();
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpTransmitter
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mIsCancel = true;
        }
    }

    private T transmitData() throws RetryException, StopRequestException {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (!this.mIsCancel) {
                HttpURLConnection httpURLConnection2 = null;
                String url = getUrl();
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " sendRequest url:" + url);
                }
                try {
                    if (!TextUtils.isEmpty(url)) {
                        try {
                            if (!isHttps()) {
                                httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                            } else {
                                httpURLConnection = (HttpsURLConnection) new URL(url).openConnection();
                            }
                            httpURLConnection2 = httpURLConnection;
                            httpURLConnection2.setRequestProperty("Charsert", "UTF-8");
                            httpURLConnection2.setConnectTimeout(30000);
                            httpURLConnection2.setReadTimeout(30000);
                            processExtraConnection(httpURLConnection2);
                            httpURLConnection2.connect();
                            postHandleConnection(httpURLConnection2);
                            handleResponseCode(httpURLConnection2);
                            return parseResult(handleResponseEntity(httpURLConnection2));
                        } catch (Exception e) {
                            throw new RetryException(e.getMessage());
                        }
                    }
                    throw new StopRequestException(ExceptionMessage.URL_EMPTY);
                } finally {
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
            }
            throw new StopRequestException(10002, ExceptionMessage.CANCEL);
        }
        return (T) invokeV.objValue;
    }

    public String buildParametersString(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String obj = entry.getValue().toString();
                try {
                    sb.append(entry.getKey() + "=" + URLEncoder.encode(obj, "UTF-8"));
                    sb.append("&");
                } catch (UnsupportedEncodingException unused) {
                    return null;
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void doRetry(RetryException retryException) throws StopRequestException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, retryException) == null) {
            int i = this.retryTimes + 1;
            this.retryTimes = i;
            if (i <= this.maxRetryTimes) {
                SystemClock.sleep(5000L);
            } else if (retryException.getFailStatus() == 10001) {
                throw new StopRequestException(retryException.getFailStatus(), retryException.getDetailErrorCode(), " retry count reach fail ");
            } else {
                throw new StopRequestException(" retry count reach fail ");
            }
        }
    }

    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            String str = Build.VERSION.RELEASE;
            if (str.length() > 0) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append("1.0");
            }
            if ("REL".equals(Build.VERSION.CODENAME)) {
                String str2 = Build.MODEL;
                if (str2.length() > 0) {
                    stringBuffer.append("; ");
                    stringBuffer.append(str2);
                }
            }
            String str3 = Build.ID;
            if (str3.length() > 0) {
                stringBuffer.append(" Build/");
                stringBuffer.append(str3);
            }
            return String.format(USER_AGENT, stringBuffer);
        }
        return (String) invokeV.objValue;
    }

    public void handleResponseCode(HttpURLConnection httpURLConnection) throws RetryException, StopRequestException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpURLConnection) == null) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    String str = " http response error -> " + responseCode;
                    if (isNoRetryServerError(responseCode)) {
                        throw new StopRequestException(10001, responseCode, str);
                    }
                    throw new RetryException(10001, responseCode, str);
                }
            } catch (IOException e) {
                throw new RetryException(e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x005d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.HttpURLConnection, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String handleResponseEntity(HttpURLConnection httpURLConnection) throws RetryException, StopRequestException {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, httpURLConnection)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    String contentEncoding = httpURLConnection.getContentEncoding();
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    try {
                        httpURLConnection = inputStream2;
                        if (!TextUtils.isEmpty(contentEncoding)) {
                            httpURLConnection = inputStream2;
                            if (contentEncoding.equals("gzip")) {
                                httpURLConnection = new GZIPInputStream(inputStream2);
                            }
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader((InputStream) httpURLConnection, IMAudioTransRequest.CHARSET));
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(new String(readLine.getBytes(IMAudioTransRequest.CHARSET), IMAudioTransRequest.CHARSET));
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (httpURLConnection != 0) {
                        try {
                            httpURLConnection.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return stringBuffer2;
                } catch (Exception e4) {
                    e = e4;
                    throw new StopRequestException(e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = httpURLConnection;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public void processExtraConnection(HttpURLConnection httpURLConnection) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, httpURLConnection) == null) {
            httpURLConnection.setRequestProperty("Content-Type", CONTENT_TYPE);
            httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpTransmitter
    public T sendRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.retryTimes = 0;
            while (this.retryTimes <= this.maxRetryTimes) {
                try {
                    try {
                        return transmitData();
                    } catch (RetryException e) {
                        doRetry(e);
                    }
                } catch (StopRequestException e2) {
                    if (e2.getFailStatus() == 10001) {
                        handleServerError(e2.getDetailErrorCode());
                        return null;
                    }
                    handleException(e2);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeV.objValue;
    }
}
