package com.baidu.sofire.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.BaiduLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HttpCetificateUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpCetificateUtil:";
    public transient /* synthetic */ FieldHolder $fh;

    public HttpCetificateUtil() {
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

    public static JSONArray getHttpCetificate(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                String hostArray = SdkFacePrivateConfig.getInstance(context).getHostArray();
                if (TextUtils.isEmpty(hostArray)) {
                    BaiduLog.logD("HttpCetificateUtil:urls is empty");
                    return new JSONArray();
                }
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(hostArray);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    String optString = jSONArray2.optString(i);
                    String httpCetificateViaUrlConnection = getHttpCetificateViaUrlConnection(context, optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString);
                    jSONObject.put("mp", httpCetificateViaUrlConnection);
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return new JSONArray();
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static String getHttpCetificateViaUrlConnection(Context context, String str) {
        InterceptResult invokeLL;
        URL url;
        String str2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
                url = new URL(str);
                int i = 0;
                if (CommonMethods.isWifiAvailable(context)) {
                    str2 = null;
                } else if (Build.VERSION.SDK_INT >= 13) {
                    str2 = System.getProperties().getProperty("http.proxyHost");
                    String property = System.getProperties().getProperty("http.proxyPort");
                    i = TextUtils.isEmpty(property) ? -1 : Integer.parseInt(property);
                } else {
                    String host = Proxy.getHost(context);
                    i = Proxy.getPort(context);
                    str2 = host;
                }
                if (str2 != null && i > 0) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str2, i)));
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpURLConnection2 = httpURLConnection;
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.connect();
            } catch (Throwable th) {
                try {
                    CommonMethods.handleNuLException(th);
                    if (httpURLConnection2 == null) {
                        return "";
                    }
                } finally {
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
            }
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                return markPinning((HttpsURLConnection) httpURLConnection2);
            }
            if (httpURLConnection2 == null) {
                return "";
            }
            httpURLConnection2.disconnect();
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static int getNetWorkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (PermissionChecker.checkPermissions(context, new String[]{"android.permission.ACCESS_NETWORK_STATE"})) {
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
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String markPinning(HttpsURLConnection httpsURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpsURLConnection)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
                BaiduLog.logD("HttpCetificateUtil:certs.length=" + serverCertificates.length);
                String str = "";
                for (Certificate certificate : serverCertificates) {
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    sb.append(x509Certificate.toString());
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                    if (encoded != null) {
                        String encodeToString = Base64.encodeToString(encoded, 0);
                        str = str + MD5Util.getMD5(encodeToString.replace("\n", "").replace("\r", ""));
                    }
                    str = str + ParamableElem.DIVIDE_PARAM;
                }
                if (TextUtils.isEmpty(str)) {
                    BaiduLog.logD("HttpCetificateUtil:ping is empty");
                    return "";
                }
                String substring = str.substring(0, str.length() - 1);
                BaiduLog.logD("HttpCetificateUtil:pingurl==" + httpsURLConnection.getURL().toString() + ";pingkey==" + substring);
                return substring;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
