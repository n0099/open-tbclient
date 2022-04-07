package com.baidu.mapsdkplatform.comapi.synchronization.c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean b = true;
    public static final String c = "c";
    public transient /* synthetic */ FieldHolder $fh;
    public HttpURLConnection a;
    public String d;
    public String e;
    public int f;
    public int g;
    public String h;
    public e i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final /* synthetic */ a[] f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(750166716, "Lcom/baidu/mapsdkplatform/comapi/synchronization/c/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(750166716, "Lcom/baidu/mapsdkplatform/comapi/synchronization/c/c$a;");
                    return;
                }
            }
            a = new a("SUCCESS", 0);
            b = new a("NETWORK_ERROR", 1);
            c = new a("INNER_ERROR", 2);
            d = new a("REQUEST_ERROR", 3);
            a aVar = new a("SERVER_ERROR", 4);
            e = aVar;
            f = new a[]{a, b, c, d, aVar};
        }

        public a(String str, int i) {
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

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f.clone() : (a[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-879665319, "Lcom/baidu/mapsdkplatform/comapi/synchronization/c/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-879665319, "Lcom/baidu/mapsdkplatform/comapi/synchronization/c/c;");
        }
    }

    public c(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.h = str;
        this.i = eVar;
    }

    private void a(InputStream inputStream, BufferedReader bufferedReader, HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, inputStream, bufferedReader, httpURLConnection) == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "IOException happened when release res", e);
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, httpURLConnection) == null) {
            try {
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                String str = c;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "responseCode is: " + responseCode);
                if (200 != responseCode) {
                    a(httpURLConnection, responseCode);
                } else {
                    b(httpURLConnection);
                }
            } catch (IOException unused) {
                httpURLConnection.disconnect();
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Catch connection exception, INNER_ERROR");
                this.i.a(a.c);
            }
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, httpURLConnection, i) == null) {
            a aVar = a.a;
            a aVar2 = i >= 500 ? a.e : i >= 400 ? a.d : a.c;
            InputStream errorStream = httpURLConnection.getErrorStream();
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, errorStream.toString());
            String str = c;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "Response error, response code = " + i + ", error = " + aVar2);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (IOException e) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "IOException caught", e);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.i.a(aVar2);
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isAvailable();
            } catch (Exception e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Exception happened when check network", e);
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private HttpURLConnection b() {
        HttpsURLConnection httpsURLConnection;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
                URL url = new URL(this.d);
                if (b) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection2.setHostnameVerifier(new d(this));
                    httpsURLConnection = httpsURLConnection2;
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpsURLConnection.setRequestMethod(this.h);
                httpsURLConnection.setDoOutput(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setConnectTimeout(this.f);
                httpsURLConnection.setReadTimeout(this.g);
                return httpsURLConnection;
            } catch (Exception e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "url connect failed", e);
                return null;
            }
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    private void b(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        IOException e;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65543, this, httpURLConnection) != null) {
            return;
        }
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            bufferedReader2 = null;
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            inputStream = null;
        }
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = bufferedReader2.read();
                    if (read == -1) {
                        String stringBuffer2 = stringBuffer.toString();
                        this.e = stringBuffer2;
                        c(stringBuffer2);
                        a(inputStream, bufferedReader2, httpURLConnection);
                        this.i.a(this.e);
                        return;
                    }
                    stringBuffer.append((char) read);
                }
            } catch (IOException e3) {
                e = e3;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Catch exception. INNER_ERROR", e);
                this.i.a(a.c);
                a(inputStream, bufferedReader2, httpURLConnection);
            }
        } catch (IOException e4) {
            bufferedReader2 = null;
            e = e4;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            a(inputStream, bufferedReader, httpURLConnection);
            throw th;
        }
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            if (TextUtils.isEmpty(str) || this.i == null) {
                String str2 = c;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "RequestUrl or ResultCallback is null. RequestUrl = " + str + "; ResultCallback is: " + this.i);
                this.i.a(a.d);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, str) == null) && d(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Permission check failed, try again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                String str2 = c;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "The authorized result is: " + permissionCheck);
            }
        }
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) ? e(str) || f(str) : invokeL.booleanValue;
    }

    private boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                    int i = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                    if (106 == i || 105 == i) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Permission check failed due token");
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (JSONException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Parse json happened exception", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError") && jSONObject.optJSONObject("SDK_InnerError").has("PermissionCheckError")) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Permission check error due other");
                    return true;
                }
                return false;
            } catch (JSONException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Parse json happened exception", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.g = i;
        }
    }

    public void a(String str) {
        e eVar;
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && b(str)) {
            this.d = str;
            String str2 = c;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "mRequestUrl is: " + this.d);
            if (a()) {
                HttpURLConnection b2 = b();
                this.a = b2;
                if (b2 != null) {
                    a(b2);
                    return;
                }
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "url connection failed");
                eVar = this.i;
                aVar = a.c;
            } else {
                eVar = this.i;
                aVar = a.b;
            }
            eVar.a(aVar);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f = i;
        }
    }
}
