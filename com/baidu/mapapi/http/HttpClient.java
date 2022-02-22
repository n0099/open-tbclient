package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
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
/* loaded from: classes10.dex */
public class HttpClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean isHttpsEnable = true;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpURLConnection a;

    /* renamed from: b  reason: collision with root package name */
    public String f35425b;

    /* renamed from: c  reason: collision with root package name */
    public String f35426c;

    /* renamed from: d  reason: collision with root package name */
    public int f35427d;

    /* renamed from: e  reason: collision with root package name */
    public int f35428e;

    /* renamed from: f  reason: collision with root package name */
    public String f35429f;

    /* renamed from: g  reason: collision with root package name */
    public ProtoResultCallback f35430g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

        public HttpStateError(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes10.dex */
    public static abstract class ProtoResultCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ProtoResultCallback() {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35425b = null;
        this.f35426c = null;
        this.f35429f = str;
        this.f35430g = protoResultCallback;
    }

    private HttpURLConnection a() {
        HttpsURLConnection httpsURLConnection;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                URL url = new URL(this.f35425b);
                if (isHttpsEnable) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection2.setHostnameVerifier(new b(this));
                    httpsURLConnection = httpsURLConnection2;
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpsURLConnection.setRequestMethod(this.f35429f);
                httpsURLConnection.setDoOutput(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setConnectTimeout(this.f35427d);
                httpsURLConnection.setReadTimeout(this.f35428e);
                return httpsURLConnection;
            } catch (Exception e2) {
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
                    int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                    if ((i2 == 105 || i2 == 106) && (permissionCheck = PermissionCheck.permissionCheck()) != 0) {
                        String str2 = "permissionCheck result is: " + permissionCheck;
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String getAuthToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? i.f36336d : (String) invokeV.objValue;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x008b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x012f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013e A[Catch: Exception -> 0x0144, TryCatch #4 {Exception -> 0x0144, blocks: (B:16:0x0036, B:28:0x0074, B:29:0x007a, B:31:0x007e, B:70:0x011f, B:71:0x0125, B:73:0x0129, B:78:0x0134, B:79:0x013a, B:81:0x013e, B:82:0x0143, B:55:0x00f0, B:57:0x00f4), top: B:95:0x0036 }] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void request(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        ?? r1;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
            return;
        }
        this.f35425b = str;
        if (!checkNetwork()) {
            this.f35430g.onFailed(HttpStateError.NETWORK_ERROR);
            return;
        }
        HttpURLConnection a = a();
        this.a = a;
        if (a == null) {
            this.f35430g.onFailed(HttpStateError.INNER_ERROR);
        } else if (TextUtils.isEmpty(this.f35425b)) {
            this.f35430g.onFailed(HttpStateError.REQUEST_ERROR);
        } else {
            try {
                this.a.connect();
                try {
                    r1 = this.a.getResponseCode();
                } catch (Exception e3) {
                    bufferedReader = null;
                    e2 = e3;
                    r1 = 0;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                    r1 = 0;
                }
                try {
                    if (200 != r1) {
                        String str2 = "responseCode is: " + r1;
                        HttpStateError httpStateError = r1 >= 500 ? HttpStateError.SERVER_ERROR : r1 >= 400 ? HttpStateError.REQUEST_ERROR : HttpStateError.INNER_ERROR;
                        if (Logger.debugEnable()) {
                            Logger.logW("HttpClient", this.a.getErrorStream().toString());
                        } else {
                            Logger.logW("HttpClient", "Get response from server failed, http response code=" + r1 + ", error=" + httpStateError);
                        }
                        this.f35430g.onFailed(httpStateError);
                        if (this.a != null) {
                            this.a.disconnect();
                            return;
                        }
                        return;
                    }
                    r1 = this.a.getInputStream();
                    bufferedReader = new BufferedReader(new InputStreamReader((InputStream) r1, "UTF-8"));
                    try {
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                int read = bufferedReader.read();
                                if (read == -1) {
                                    break;
                                }
                                stringBuffer.append((char) read);
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            this.f35426c = stringBuffer2;
                            a(stringBuffer2);
                            if (r1 != 0) {
                                bufferedReader.close();
                                r1.close();
                            }
                            if (this.a != null) {
                                this.a.disconnect();
                            }
                            this.f35430g.onSuccess(this.f35426c);
                        } catch (Exception e4) {
                            e2 = e4;
                            if (Logger.debugEnable()) {
                                e2.printStackTrace();
                            } else {
                                Logger.logW("HttpClient", e2.getMessage());
                            }
                            this.f35430g.onFailed(HttpStateError.INNER_ERROR);
                            if (r1 != 0 && bufferedReader != null) {
                                bufferedReader.close();
                                r1.close();
                            }
                            if (this.a != null) {
                                this.a.disconnect();
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (r1 != 0 && bufferedReader != null) {
                            bufferedReader.close();
                            r1.close();
                        }
                        if (this.a != null) {
                            this.a.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    bufferedReader = null;
                    e2 = e5;
                } catch (Throwable th4) {
                    bufferedReader = null;
                    th = th4;
                    if (r1 != 0) {
                        bufferedReader.close();
                        r1.close();
                    }
                    if (this.a != null) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                if (Logger.debugEnable()) {
                    e6.printStackTrace();
                } else {
                    Logger.logW("HttpClient", e6.getMessage());
                }
                this.f35430g.onFailed(HttpStateError.INNER_ERROR);
            }
        }
    }

    public void setMaxTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f35427d = i2;
        }
    }

    public void setReadTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f35428e = i2;
        }
    }
}
