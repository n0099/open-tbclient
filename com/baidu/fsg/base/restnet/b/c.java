package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.utils.LogUtil;
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
/* loaded from: classes10.dex */
public class c implements com.baidu.fsg.base.restnet.rest.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "appcache";

    /* renamed from: b  reason: collision with root package name */
    public static final int f33932b = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f33933c;

    /* renamed from: d  reason: collision with root package name */
    public String f33934d;

    /* renamed from: e  reason: collision with root package name */
    public e f33935e;

    /* renamed from: f  reason: collision with root package name */
    public URLConnection f33936f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33937g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33938h;

    public c(Context context, String str, boolean z) {
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
        this.f33938h = false;
        this.f33933c = context.getApplicationContext();
        this.f33934d = str;
        this.f33938h = z;
    }

    private com.baidu.fsg.base.restnet.rest.e a(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, url)) == null) {
            URL url2 = new URL(a(url.toString()));
            URLConnection openConnection = url2.openConnection();
            this.f33936f = openConnection;
            a(openConnection);
            return a(url2, this.f33936f, "GET");
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

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            e eVar = this.f33935e;
            if (eVar != null) {
                String f2 = eVar.f();
                if (TextUtils.isEmpty(f2)) {
                    return str;
                }
                if (str.contains("?")) {
                    return str + "&" + f2;
                }
                return str + "?" + f2;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            try {
                Class.forName("android.net.http.HttpResponseCache").getMethod(IntentConfig.CLOSE, new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r4.f33935e.d() > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r4.f33935e.d() > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        r1 = r4.f33935e.d();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, uRLConnection) == null) {
            int i2 = 30000;
            if (this.f33937g) {
                uRLConnection.setConnectTimeout(this.f33935e.d() > 0 ? this.f33935e.d() : 30000);
            } else {
                uRLConnection.setConnectTimeout(this.f33935e.d() > 0 ? this.f33935e.d() : 30000);
            }
            uRLConnection.setReadTimeout(i2);
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            } else {
                System.setProperty("http.keepAlive", "true");
                System.setProperty("http.maxConnections ", String.valueOf(10));
                System.setProperty("sun.net.http.errorstream.enableBuffering", "true");
            }
            if (d()) {
                uRLConnection.setRequestProperty("User-Agent", "");
                uRLConnection.setRequestProperty("Accept-Encoding", "");
            } else {
                uRLConnection.setRequestProperty("User-Agent", this.f33934d);
                for (Map.Entry<String, List<String>> entry : this.f33935e.a().entrySet()) {
                    uRLConnection.setRequestProperty(entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()).get(0));
                }
                if (this.f33938h) {
                    c();
                }
            }
            if (!(this.f33936f instanceof HttpsURLConnection) || com.baidu.fsg.base.c.b().a()) {
                return;
            }
            b();
        }
    }

    private com.baidu.fsg.base.restnet.rest.e b(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, url)) == null) {
            URLConnection openConnection = url.openConnection();
            this.f33936f = openConnection;
            a(openConnection);
            b(this.f33936f);
            return a(url, this.f33936f, "POST");
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ((HttpsURLConnection) this.f33936f).setHostnameVerifier(new b(this));
        }
    }

    private void b(URLConnection uRLConnection) {
        e eVar;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, uRLConnection) == null) || (eVar = this.f33935e) == null) {
            return;
        }
        String f2 = eVar.f();
        RestMultipartEntity e2 = this.f33935e.e();
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        if (e2 != null) {
            ((HttpURLConnection) uRLConnection).setFixedLengthStreamingMode((int) e2.getContentLength());
            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + e2.getBoundary());
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                try {
                    dataOutputStream = new DataOutputStream(uRLConnection.getOutputStream());
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeBytes(f2);
                if (e2 != null) {
                    e2.writeTo(dataOutputStream);
                }
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (IOException e4) {
                e = e4;
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
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                File file = new File(this.f33933c.getDir("appcache", 0), "com/baidu/fsg/base/restnet/http");
                Class.forName("android.net.http.HttpResponseCache").getMethod("install", File.class, Long.TYPE).invoke(null, file, 10485760L);
            } catch (Exception unused) {
            }
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.f33935e != null) {
                RestRequestCallbacker.IRestRequestCallback requestCallback = RestRequestCallbacker.getRequestCallback();
                String c2 = this.f33935e.c();
                return (TextUtils.isEmpty(c2) || requestCallback == null || !requestCallback.isSpecialUrl(c2)) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public com.baidu.fsg.base.restnet.rest.e a(com.baidu.fsg.base.restnet.rest.d dVar) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            this.f33935e = (e) dVar;
            URL url = new URL(dVar.getUrl());
            LogUtil.v("apollon_rest", "con url: " + url + ", host: " + dVar.a().getFirst("Host"));
            if (this.f33935e.h()) {
                return b(url);
            }
            if (this.f33935e.g()) {
                return a(url);
            }
            return null;
        }
        return (com.baidu.fsg.base.restnet.rest.e) invokeL.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            URLConnection uRLConnection = this.f33936f;
            if (uRLConnection != null) {
                if (uRLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) uRLConnection).disconnect();
                } else if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
                this.f33936f = null;
            }
            if (this.f33938h) {
                a();
            }
        }
    }
}
