package com.baidu.mapsdkplatform.comapi.synchronization.c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f42425b = true;

    /* renamed from: c  reason: collision with root package name */
    public static final String f42426c = "c";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f42427a;

    /* renamed from: d  reason: collision with root package name */
    public String f42428d;

    /* renamed from: e  reason: collision with root package name */
    public String f42429e;

    /* renamed from: f  reason: collision with root package name */
    public int f42430f;

    /* renamed from: g  reason: collision with root package name */
    public int f42431g;

    /* renamed from: h  reason: collision with root package name */
    public String f42432h;

    /* renamed from: i  reason: collision with root package name */
    public e f42433i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f42434a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f42435b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f42436c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f42437d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f42438e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ a[] f42439f;
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
            f42434a = new a(com.alipay.security.mobile.module.http.model.c.p, 0);
            f42435b = new a("NETWORK_ERROR", 1);
            f42436c = new a("INNER_ERROR", 2);
            f42437d = new a("REQUEST_ERROR", 3);
            a aVar = new a("SERVER_ERROR", 4);
            f42438e = aVar;
            f42439f = new a[]{f42434a, f42435b, f42436c, f42437d, aVar};
        }

        public a(String str, int i2) {
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

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f42439f.clone() : (a[]) invokeV.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42428d = null;
        this.f42429e = null;
        this.f42432h = str;
        this.f42433i = eVar;
    }

    private void a(InputStream inputStream, BufferedReader bufferedReader, HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, inputStream, bufferedReader, httpURLConnection) == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, "IOException happened when release res", e2);
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
                String str = f42426c;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "responseCode is: " + responseCode);
                if (200 != responseCode) {
                    a(httpURLConnection, responseCode);
                } else {
                    b(httpURLConnection);
                }
            } catch (IOException unused) {
                httpURLConnection.disconnect();
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42426c, "Catch connection exception, INNER_ERROR");
                this.f42433i.a(a.f42436c);
            }
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, httpURLConnection, i2) == null) {
            a aVar = a.f42434a;
            a aVar2 = i2 >= 500 ? a.f42438e : i2 >= 400 ? a.f42437d : a.f42436c;
            InputStream errorStream = httpURLConnection.getErrorStream();
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, errorStream.toString());
            String str = f42426c;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "Response error, response code = " + i2 + ", error = " + aVar2);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (IOException e2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, "IOException caught", e2);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.f42433i.a(aVar2);
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isAvailable();
            } catch (Exception e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, "Exception happened when check network", e2);
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private HttpURLConnection b() {
        HttpsURLConnection httpsURLConnection;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            try {
                URL url = new URL(this.f42428d);
                if (f42425b) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection2.setHostnameVerifier(new d(this));
                    httpsURLConnection = httpsURLConnection2;
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpsURLConnection.setRequestMethod(this.f42432h);
                httpsURLConnection.setDoOutput(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setConnectTimeout(this.f42430f);
                httpsURLConnection.setReadTimeout(this.f42431g);
                return httpsURLConnection;
            } catch (Exception e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, "url connect failed", e2);
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
        IOException e2;
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
        } catch (IOException e3) {
            bufferedReader2 = null;
            e2 = e3;
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
                        this.f42429e = stringBuffer2;
                        c(stringBuffer2);
                        a(inputStream, bufferedReader2, httpURLConnection);
                        this.f42433i.a(this.f42429e);
                        return;
                    }
                    stringBuffer.append((char) read);
                }
            } catch (IOException e4) {
                e2 = e4;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, "Catch exception. INNER_ERROR", e2);
                this.f42433i.a(a.f42436c);
                a(inputStream, bufferedReader2, httpURLConnection);
            }
        } catch (IOException e5) {
            bufferedReader2 = null;
            e2 = e5;
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
            if (TextUtils.isEmpty(str) || this.f42433i == null) {
                String str2 = f42426c;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "RequestUrl or ResultCallback is null. RequestUrl = " + str + "; ResultCallback is: " + this.f42433i);
                this.f42433i.a(a.f42437d);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, str) == null) && d(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42426c, "Permission check failed, try again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                String str2 = f42426c;
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
                    int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                    if (106 == i2 || 105 == i2) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, "Permission check failed due token");
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (JSONException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, "Parse json happened exception", e2);
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
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42426c, "Permission check error due other");
                    return true;
                }
                return false;
            } catch (JSONException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42426c, "Parse json happened exception", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f42431g = i2;
        }
    }

    public void a(String str) {
        e eVar;
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && b(str)) {
            this.f42428d = str;
            String str2 = f42426c;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "mRequestUrl is: " + this.f42428d);
            if (a()) {
                HttpURLConnection b2 = b();
                this.f42427a = b2;
                if (b2 != null) {
                    a(b2);
                    return;
                }
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42426c, "url connection failed");
                eVar = this.f42433i;
                aVar = a.f42436c;
            } else {
                eVar = this.f42433i;
                aVar = a.f42435b;
            }
            eVar.a(aVar);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f42430f = i2;
        }
    }
}
