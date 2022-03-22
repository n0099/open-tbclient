package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HttpClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean isHttpsEnable = true;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpURLConnection a;

    /* renamed from: b  reason: collision with root package name */
    public String f26102b;

    /* renamed from: c  reason: collision with root package name */
    public String f26103c;

    /* renamed from: d  reason: collision with root package name */
    public int f26104d;

    /* renamed from: e  reason: collision with root package name */
    public int f26105e;

    /* renamed from: f  reason: collision with root package name */
    public String f26106f;

    /* renamed from: g  reason: collision with root package name */
    public ProtoResultCallback f26107g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class HttpStateError {
        public static final /* synthetic */ HttpStateError[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HttpStateError INNER_ERROR;
        public static final HttpStateError NETWORK_ERROR;
        public static final HttpStateError NO_ERROR;
        public static final HttpStateError REQUEST_ERROR;
        public static final HttpStateError SERVER_ERROR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1080808687, "Lcom/baidu/mapapi/http/HttpClient$HttpStateError;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1080808687, "Lcom/baidu/mapapi/http/HttpClient$HttpStateError;");
                    return;
                }
            }
            NO_ERROR = new HttpStateError("NO_ERROR", 0);
            NETWORK_ERROR = new HttpStateError("NETWORK_ERROR", 1);
            INNER_ERROR = new HttpStateError("INNER_ERROR", 2);
            REQUEST_ERROR = new HttpStateError("REQUEST_ERROR", 3);
            HttpStateError httpStateError = new HttpStateError("SERVER_ERROR", 4);
            SERVER_ERROR = httpStateError;
            $VALUES = new HttpStateError[]{NO_ERROR, NETWORK_ERROR, INNER_ERROR, REQUEST_ERROR, httpStateError};
        }

        public HttpStateError(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static HttpStateError valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HttpStateError) Enum.valueOf(HttpStateError.class, str) : (HttpStateError) invokeL.objValue;
        }

        public static HttpStateError[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HttpStateError[]) $VALUES.clone() : (HttpStateError[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class ProtoResultCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ProtoResultCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void onFailed(HttpStateError httpStateError);

        public abstract void onSuccess(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1564195044, "Lcom/baidu/mapapi/http/HttpClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1564195044, "Lcom/baidu/mapapi/http/HttpClient;");
        }
    }

    public HttpClient(String str, ProtoResultCallback protoResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, protoResultCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26102b = null;
        this.f26103c = null;
        this.f26106f = str;
        this.f26107g = protoResultCallback;
    }

    private HttpURLConnection a() {
        HttpsURLConnection httpsURLConnection;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                URL url = new URL(this.f26102b);
                if (isHttpsEnable) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection2.setHostnameVerifier(new b(this));
                    httpsURLConnection = httpsURLConnection2;
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpsURLConnection.setRequestMethod(this.f26106f);
                httpsURLConnection.setDoOutput(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setConnectTimeout(this.f26104d);
                httpsURLConnection.setReadTimeout(this.f26105e);
                return httpsURLConnection;
            } catch (Exception e2) {
                Log.e("HttpClient", "url connect failed");
                if (Logger.debugEnable()) {
                    e2.printStackTrace();
                    return null;
                }
                Logger.logW("HttpClient", e2.getMessage());
                return null;
            }
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    private void a(String str) {
        int permissionCheck;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                    int i = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                    if ((i == 105 || i == 106) && (permissionCheck = PermissionCheck.permissionCheck()) != 0) {
                        Log.e("HttpClient", "permissionCheck result is: " + permissionCheck);
                    }
                }
            } catch (JSONException e2) {
                Log.e("HttpClient", "Parse json happened exception");
                e2.printStackTrace();
            }
        }
    }

    public static String getAuthToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? i.f26917d : (String) invokeV.objValue;
    }

    public static String getPhoneInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? i.c() : (String) invokeV.objValue;
    }

    public boolean checkNetwork() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isAvailable();
            } catch (Exception e2) {
                if (Logger.debugEnable()) {
                    e2.printStackTrace();
                } else {
                    Logger.logW("HttpClient", e2.getMessage());
                }
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0091 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.StringBuilder] */
    public void request(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        Exception e2;
        ?? r1;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
            return;
        }
        this.f26102b = str;
        if (!checkNetwork()) {
            this.f26107g.onFailed(HttpStateError.NETWORK_ERROR);
            return;
        }
        HttpURLConnection a = a();
        this.a = a;
        if (a == null) {
            Log.e("HttpClient", "url connection failed");
            this.f26107g.onFailed(HttpStateError.INNER_ERROR);
        } else if (TextUtils.isEmpty(this.f26102b)) {
            this.f26107g.onFailed(HttpStateError.REQUEST_ERROR);
        } else {
            try {
                this.a.connect();
                try {
                    try {
                        r1 = this.a.getResponseCode();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        if (200 != r1) {
                            Log.e("HttpClient", "responseCode is: " + r1);
                            HttpStateError httpStateError = r1 >= 500 ? HttpStateError.SERVER_ERROR : r1 >= 400 ? HttpStateError.REQUEST_ERROR : HttpStateError.INNER_ERROR;
                            if (Logger.debugEnable()) {
                                Logger.logW("HttpClient", this.a.getErrorStream().toString());
                            } else {
                                Logger.logW("HttpClient", "Get response from server failed, http response code=" + r1 + ", error=" + httpStateError);
                            }
                            this.f26107g.onFailed(httpStateError);
                            if (this.a != null) {
                                this.a.disconnect();
                                return;
                            }
                            return;
                        }
                        r1 = this.a.getInputStream();
                        bufferedReader2 = new BufferedReader(new InputStreamReader((InputStream) r1, "UTF-8"));
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                int read = bufferedReader2.read();
                                if (read == -1) {
                                    break;
                                }
                                stringBuffer.append((char) read);
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            this.f26103c = stringBuffer2;
                            a(stringBuffer2);
                            if (r1 != 0) {
                                bufferedReader2.close();
                                r1.close();
                            }
                            if (this.a != null) {
                                this.a.disconnect();
                            }
                            this.f26107g.onSuccess(this.f26103c);
                        } catch (Exception e3) {
                            e2 = e3;
                            if (Logger.debugEnable()) {
                                e2.printStackTrace();
                            } else {
                                Logger.logW("HttpClient", e2.getMessage());
                            }
                            Log.e("HttpClient", "Catch exception. INNER_ERROR", e2);
                            this.f26107g.onFailed(HttpStateError.INNER_ERROR);
                            if (r1 != 0 && bufferedReader2 != null) {
                                bufferedReader2.close();
                                r1.close();
                            }
                            if (this.a != null) {
                                this.a.disconnect();
                            }
                        }
                    } catch (Exception e4) {
                        bufferedReader2 = null;
                        e2 = e4;
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                        inputStream = r1;
                        if (inputStream != null && bufferedReader != null) {
                            bufferedReader.close();
                            inputStream.close();
                        }
                        if (this.a != null) {
                            this.a.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    bufferedReader2 = null;
                    e2 = e5;
                    r1 = 0;
                } catch (Throwable th4) {
                    bufferedReader = null;
                    th = th4;
                    inputStream = null;
                }
            } catch (Exception e6) {
                if (Logger.debugEnable()) {
                    e6.printStackTrace();
                } else {
                    Logger.logW("HttpClient", e6.getMessage());
                }
                Log.e("HttpClient", "Catch connection exception, INNER_ERROR", e6);
                this.f26107g.onFailed(HttpStateError.INNER_ERROR);
            }
        }
    }

    public void setMaxTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f26104d = i;
        }
    }

    public void setReadTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f26105e = i;
        }
    }
}
