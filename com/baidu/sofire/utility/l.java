package com.baidu.sofire.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONArray a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                String string = w.a(context).f45252a.getString("lt_sha", "");
                if (TextUtils.isEmpty(string)) {
                    com.baidu.sofire.b.a();
                    return new JSONArray();
                }
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    String optString = jSONArray2.optString(i2);
                    String a2 = a(context, optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString);
                    jSONObject.put("mp", a2);
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            } catch (Throwable unused) {
                c.a();
                return new JSONArray();
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (r.a(context, new String[]{DefaultConnectivityMonitorFactory.NETWORK_PERMISSION})) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (Build.VERSION.SDK_INT > 20) {
                        for (Network network : connectivityManager.getAllNetworks()) {
                            if (connectivityManager.getNetworkCapabilities(network).hasTransport(4)) {
                                return 17;
                            }
                        }
                    } else {
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(17);
                        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                            return 17;
                        }
                    }
                    if (TextUtils.isEmpty(System.getProperties().getProperty("http.proxyHost"))) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null) {
                            return -1;
                        }
                        return activeNetworkInfo.getType();
                    }
                    return 16;
                }
            } catch (Throwable unused) {
                c.a();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String a(HttpsURLConnection httpsURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, httpsURLConnection)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
                new StringBuilder("HttpCetificateUtil:certs.length=").append(serverCertificates.length);
                com.baidu.sofire.b.a();
                String str = "";
                for (Certificate certificate : serverCertificates) {
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    sb.append(x509Certificate.toString());
                    sb.append(";");
                    byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                    if (encoded != null) {
                        String encodeToString = Base64.encodeToString(encoded, 0);
                        str = str + o.a(encodeToString.replace(StringUtils.LF, "").replace(StringUtils.CR, ""));
                    }
                    str = str + ";";
                }
                if (TextUtils.isEmpty(str)) {
                    com.baidu.sofire.b.a();
                    return "";
                }
                String substring = str.substring(0, str.length() - 1);
                StringBuilder sb2 = new StringBuilder("HttpCetificateUtil:pingurl==");
                sb2.append(httpsURLConnection.getURL().toString());
                sb2.append(";pingkey==");
                sb2.append(substring);
                com.baidu.sofire.b.a();
                return substring;
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        URL url;
        String str2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    url = new URL(str);
                    int i2 = 0;
                    if (c.e(context)) {
                        str2 = null;
                    } else if (Build.VERSION.SDK_INT >= 13) {
                        str2 = System.getProperties().getProperty("http.proxyHost");
                        String property = System.getProperties().getProperty("http.proxyPort");
                        i2 = TextUtils.isEmpty(property) ? -1 : Integer.parseInt(property);
                    } else {
                        String host = Proxy.getHost(context);
                        i2 = Proxy.getPort(context);
                        str2 = host;
                    }
                    if (str2 != null && i2 > 0) {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str2, i2)));
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                    }
                    httpURLConnection2 = httpURLConnection;
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.connect();
                } finally {
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
            } catch (Throwable unused) {
                c.a();
                if (httpURLConnection2 == null) {
                    return "";
                }
            }
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                return a((HttpsURLConnection) httpURLConnection2);
            }
            if (httpURLConnection2 == null) {
                return "";
            }
            httpURLConnection2.disconnect();
            return "";
        }
        return (String) invokeLL.objValue;
    }
}
