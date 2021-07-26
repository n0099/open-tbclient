package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class b implements com.baidu.fsg.base.restnet.rest.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5217a = "appcache";

    /* renamed from: b  reason: collision with root package name */
    public static final int f5218b = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f5219c;

    /* renamed from: d  reason: collision with root package name */
    public String f5220d;

    /* renamed from: e  reason: collision with root package name */
    public e f5221e;

    /* renamed from: f  reason: collision with root package name */
    public URLConnection f5222f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5223g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5224h;

    public b(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5224h = false;
        this.f5219c = context.getApplicationContext();
        this.f5220d = str;
        this.f5224h = z;
    }

    private com.baidu.fsg.base.restnet.rest.e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, url)) == null) {
            URL url2 = new URL(a(url.toString()));
            URLConnection openConnection = url2.openConnection();
            this.f5222f = openConnection;
            a(openConnection);
            return a(url2, this.f5222f, "GET");
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeL.objValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.f5221e != null) {
                RestRequestCallbacker.IRestRequestCallback requestCallback = RestRequestCallbacker.getRequestCallback();
                String k = this.f5221e.k();
                return (TextUtils.isEmpty(k) || requestCallback == null || !requestCallback.isSpecialUrl(k)) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, new File(this.f5219c.getDir("appcache", 0), "com/baidu/fsg/base/restnet/http"), Long.valueOf((long) Config.FULL_TRACE_LOG_LIMIT));
            } catch (Exception unused) {
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod(IntentConfig.CLOSE, new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public com.baidu.fsg.base.restnet.rest.e a(com.baidu.fsg.base.restnet.rest.d dVar) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            this.f5221e = (e) dVar;
            URL url = new URL(dVar.d());
            LogUtil.v("apollon_rest", "con url: " + url + ", host: " + dVar.b().c("Host"));
            if (this.f5221e.i()) {
                return a(url);
            }
            if (this.f5221e.j()) {
                return b(url);
            }
            return null;
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ((HttpsURLConnection) this.f5222f).setHostnameVerifier(new c(this));
        }
    }

    private void b(URLConnection uRLConnection) {
        e eVar;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, uRLConnection) == null) || (eVar = this.f5221e) == null) {
            return;
        }
        String l = eVar.l();
        RestMultipartEntity a2 = this.f5221e.a();
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        if (a2 != null) {
            ((HttpURLConnection) uRLConnection).setFixedLengthStreamingMode((int) a2.getContentLength());
            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + a2.getBoundary());
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                try {
                    dataOutputStream = new DataOutputStream(uRLConnection.getOutputStream());
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeBytes(l);
                if (a2 != null) {
                    a2.writeTo(dataOutputStream);
                }
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (IOException e3) {
                e = e3;
                dataOutputStream2 = dataOutputStream;
                e.printStackTrace();
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            URLConnection uRLConnection = this.f5222f;
            if (uRLConnection != null) {
                if (uRLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) uRLConnection).disconnect();
                } else if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
                this.f5222f = null;
            }
            if (this.f5224h) {
                e();
            }
        }
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, url)) == null) {
            URLConnection openConnection = url.openConnection();
            this.f5222f = openConnection;
            a(openConnection);
            b(this.f5222f);
            return a(url, this.f5222f, "POST");
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeL.objValue;
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url, URLConnection uRLConnection, String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, url, uRLConnection, str)) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            return new f(new BufferedInputStream(uRLConnection.getInputStream()), httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), uRLConnection.getHeaderFields());
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeLLL.objValue;
    }

    private void a(URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, uRLConnection) == null) {
            if (this.f5223g) {
                uRLConnection.setConnectTimeout(this.f5221e.h() > 0 ? this.f5221e.h() : 30000);
                uRLConnection.setReadTimeout(this.f5221e.h() > 0 ? this.f5221e.h() : 30000);
            } else {
                uRLConnection.setConnectTimeout(this.f5221e.h() > 0 ? this.f5221e.h() : 30000);
                uRLConnection.setReadTimeout(this.f5221e.h() > 0 ? this.f5221e.h() : 30000);
            }
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            } else {
                System.setProperty("http.keepAlive", "true");
                System.setProperty("http.maxConnections ", String.valueOf(10));
                System.setProperty("sun.net.http.errorstream.enableBuffering", "true");
            }
            if (c()) {
                uRLConnection.setRequestProperty("User-Agent", "");
                uRLConnection.setRequestProperty("Accept-Encoding", "");
            } else {
                uRLConnection.setRequestProperty("User-Agent", this.f5220d);
                for (Map.Entry<String, List<String>> entry : this.f5221e.b().entrySet()) {
                    uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
                }
                if (this.f5224h) {
                    d();
                }
            }
            if (!(this.f5222f instanceof HttpsURLConnection) || com.baidu.fsg.base.c.a().a()) {
                return;
            }
            b();
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            e eVar = this.f5221e;
            if (eVar != null) {
                String l = eVar.l();
                if (TextUtils.isEmpty(l)) {
                    return str;
                }
                if (str.contains("?")) {
                    return str + "&" + l;
                }
                return str + "?" + l;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
