package com.baidu.android.imsdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.request.IMGetTokenByCuidRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ConnectTimeoutException;
@SuppressLint({"TrulyRandom"})
/* loaded from: classes.dex */
public class HttpHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_JSON = "application/json";
    public static final String COOKIE_KEY = "Cookie";
    public static final int ERROR_EXCEPTION = -10;
    public static final int GET = 1;
    public static final int POST = 16;
    public static final int PUT = 256;
    public static final String TAG = "HttpHelper";
    public static Context mContext;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Request {
        int getConnectTimeout();

        String getContentType();

        Map<String, String> getHeaders();

        String getHost();

        String getMethod();

        int getReadTimeout();

        byte[] getRequestParameter() throws NoSuchAlgorithmException;

        boolean shouldAbort();
    }

    /* loaded from: classes.dex */
    public interface ResponseHandler {
        void onFailure(int i2, byte[] bArr, Throwable th);

        void onSuccess(int i2, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public static class ResponseResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mErrorCode;
        public String mErrorMsg;

        public ResponseResult() {
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

        public int getErrorCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mErrorCode : invokeV.intValue;
        }

        public String getErrorMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mErrorMsg : (String) invokeV.objValue;
        }

        public void setErrorCode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.mErrorCode = i2;
            }
        }

        public void setErrorMsg(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.mErrorMsg = str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class Result {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int errorCode;
        public InputStream inputStream;
        public OutputStream outputStream;
        public final /* synthetic */ HttpHelper this$0;
        public HttpURLConnection urlConnection;

        public Result(HttpHelper httpHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpHelper;
            this.inputStream = null;
            this.outputStream = null;
            this.urlConnection = null;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2130868608, "Lcom/baidu/android/imsdk/utils/HttpHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2130868608, "Lcom/baidu/android/imsdk/utils/HttpHelper;");
        }
    }

    public HttpHelper() {
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpURLConnection createConnection(int i2, String str, byte[] bArr, Map<String, String> map, int i3, int i4) throws SocketTimeoutException, ConnectTimeoutException, MalformedURLException, IOException {
        InterceptResult invokeCommon;
        String str2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), str, bArr, map, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if ((i2 & 1) != 0) {
                if (bArr != null && bArr.length > 0) {
                    str2 = str + "?" + new String(bArr);
                    LogUtils.d(TAG, "requestUrl:" + str2);
                    httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    if (httpURLConnection == null) {
                        LogUtils.e(TAG, "HttpURLConnection is null");
                    }
                    setConnectionHeader(str, httpURLConnection, map);
                    setConnectionParametersForRequest(httpURLConnection, i2, bArr, false, i3, i4);
                    return httpURLConnection;
                }
            } else if (bArr != null && bArr.length > 0) {
                LogUtils.d(TAG, "requestparamter:" + new String(bArr, "utf-8"));
            }
            str2 = str;
            LogUtils.d(TAG, "requestUrl:" + str2);
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            if (httpURLConnection == null) {
            }
            setConnectionHeader(str, httpURLConnection, map);
            setConnectionParametersForRequest(httpURLConnection, i2, bArr, false, i3, i4);
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeCommon.objValue;
    }

    public static void dealResonsResult(int i2, InputStream inputStream, ResponseHandler responseHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, null, i2, inputStream, responseHandler) == null) {
            byte[] dealResonsResult = dealResonsResult(inputStream);
            String str = new String(dealResonsResult);
            String str2 = TAG;
            LogUtils.d(str2, "request response : " + str);
            if (dealResonsResult != null && dealResonsResult.length != 0) {
                responseHandler.onSuccess(i2, dealResonsResult);
            } else {
                responseHandler.onFailure(-10, "IOException for inputStream".getBytes(), new IOException("IOException for inputStream"));
            }
        }
    }

    public static void executor(Context context, Request request, ResponseHandler responseHandler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, request, responseHandler) == null) || responseHandler == null) {
            return;
        }
        if (context != null && request != null && !TextUtils.isEmpty(request.getHost())) {
            if (Utility.getRestApiDisable() && !(request instanceof IMGetTokenByCuidRequest)) {
                responseHandler.onFailure(1011, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR.getBytes(), null);
                return;
            } else if (request.shouldAbort()) {
                return;
            } else {
                if (mContext == null) {
                    mContext = context.getApplicationContext();
                }
                TaskManager.getInstance(context).submitForNetWork(new Runnable(request, responseHandler) { // from class: com.baidu.android.imsdk.utils.HttpHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ResponseHandler val$handler;
                    public final /* synthetic */ Request val$request;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {request, responseHandler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$request = request;
                        this.val$handler = responseHandler;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (!this.val$request.getMethod().equals("GET") && !this.val$request.getMethod().equals("POST") && !this.val$request.getMethod().equals(HttpPut.METHOD_NAME)) {
                                    this.val$handler.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
                                }
                                if (this.val$request.getMethod().equals("GET")) {
                                    i2 = 1;
                                } else {
                                    i2 = this.val$request.getMethod().equals("POST") ? 16 : 256;
                                }
                                HttpExecutor.getInstance().execute(i2, this.val$request.getHost(), this.val$request.getRequestParameter(), this.val$request.getHeaders(), this.val$request.getContentType(), this.val$handler);
                            } catch (Exception e2) {
                                LogUtils.e(HttpHelper.TAG, "Http Unknown exception :", e2);
                                this.val$handler.onFailure(-1003, "Http Unknown exception".getBytes(), e2);
                            }
                        }
                    }
                });
                return;
            }
        }
        responseHandler.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
    }

    public static void setConnectionHeader(String str, HttpURLConnection httpURLConnection, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, str, httpURLConnection, map) == null) || map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                if (entry.getKey().equalsIgnoreCase("Cookie")) {
                    CookieManager.getInstance().setCookie(str, entry.getValue());
                    httpURLConnection.setRequestProperty(entry.getKey(), CookieManager.getInstance().getCookie(str));
                } else {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, int i2, byte[] bArr, boolean z, int i3, int i4) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{httpURLConnection, Integer.valueOf(i2), bArr, Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(i3);
            if (z) {
                httpURLConnection.setRequestProperty(Headers.CONTENT_ENCODING, AsyncHttpClient.ENCODING_GZIP);
            }
            httpURLConnection.setReadTimeout(i4);
            if (i2 == 1) {
                httpURLConnection.setRequestMethod("GET");
            } else if (i2 != 16) {
                if (i2 == 256) {
                    if (bArr == null || bArr.length <= 0) {
                        return;
                    }
                    httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                    httpURLConnection.setDoOutput(true);
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.close();
                    return;
                }
                throw new IllegalStateException("Unknown method type.");
            } else if (bArr == null || bArr.length <= 0) {
            } else {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                if (z) {
                    LogUtils.d(TAG, "This is statistic, compress data");
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(dataOutputStream2);
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.close();
                    return;
                }
                dataOutputStream2.write(bArr);
                dataOutputStream2.close();
            }
        }
    }

    public static byte[] dealResonsResult(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                            return byteArray;
                        } catch (IOException e2) {
                            LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e2);
                            return byteArray;
                        }
                    }
                } catch (IOException e3) {
                    LogUtils.e(LogUtils.TAG, "HttpHelper IOException for inputStream", e3);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e4);
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e5);
                }
                throw th;
            }
        }
    }

    public static void executor(int i2, String str, byte[] bArr, Map<String, String> map, int i3, int i4, ResponseHandler responseHandler) throws SocketTimeoutException, ConnectTimeoutException, MalformedURLException, IOException {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Integer.valueOf(i2), str, bArr, map, Integer.valueOf(i3), Integer.valueOf(i4), responseHandler}) != null) {
            return;
        }
        InputStream inputStream = null;
        try {
            httpURLConnection = createConnection(i2, str, bArr, map, i3, i4);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != -1) {
                    if (httpURLConnection.getResponseCode() != 200) {
                        LogUtils.d(TAG, "createConnection responsecode:" + responseCode);
                        responseHandler.onFailure(responseCode, "http response error".getBytes(), null);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    dealResonsResult(responseCode, inputStream2, responseHandler);
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
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
    }
}
