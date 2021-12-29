package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.a;
import c.a.s0.e1.w0;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class ThirdStatisticHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_DIRECT_TIMES = 3;
    public static final Map<String, String> cookieCacheMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.tbadk.core.util.ThirdStatisticHelper$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class ThirdStatisticAsyncTask extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ThirdStatisticAsyncTask() {
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

        public /* synthetic */ ThirdStatisticAsyncTask(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            Throwable th;
            HttpURLConnection httpURLConnection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length == 0) {
                    return null;
                }
                try {
                    httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    try {
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(3000);
                            httpURLConnection.setReadTimeout(3000);
                            httpURLConnection.connect();
                            httpURLConnection.getResponseCode();
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e);
                            a.e(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        a.e(httpURLConnection);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = null;
                    a.e(httpURLConnection);
                    throw th;
                }
                a.e(httpURLConnection);
                return null;
            }
            return (Integer) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class TiePlusStaticTask extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TiePlusStaticTask() {
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

        private String getAllCookies(Map<String, List<String>> map) {
            InterceptResult invokeL;
            List<String> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, map)) == null) {
                if (map == null || (list = map.get("Set-Cookie")) == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    sb.append(str);
                    if (!str.endsWith(";")) {
                        sb.append(";");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        private HttpURLConnection getConnection(URL url, int i2, int i3, String str) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{url, Integer.valueOf(i2), Integer.valueOf(i3), str})) == null) {
                if (url == null) {
                    return null;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i3);
                httpURLConnection.setRequestProperty("User-Agent", w0.b());
                httpURLConnection.addRequestProperty("Cookie", str);
                return httpURLConnection;
            }
            return (HttpURLConnection) invokeCommon.objValue;
        }

        private String getFinalCookie(HttpURLConnection httpURLConnection, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, httpURLConnection, str)) == null) {
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                if (headerFields == null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                String allCookies = getAllCookies(headerFields);
                if (!StringUtils.isNull(allCookies)) {
                    sb.append(allCookies);
                }
                if (str != null) {
                    sb.append(";");
                    sb.append(str);
                }
                return sb.toString();
            }
            return (String) invokeLL.objValue;
        }

        public /* synthetic */ TiePlusStaticTask(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            HttpURLConnection httpURLConnection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                HttpURLConnection httpURLConnection2 = null;
                if (strArr == null || strArr.length == 0) {
                    return null;
                }
                String str = "BAIDUID=" + TbSingleton.getInstance().getBaiduIdForAnti();
                try {
                    URL url = new URL(strArr[0]);
                    String host = url.getHost();
                    String str2 = (String) ThirdStatisticHelper.cookieCacheMap.get(host);
                    httpURLConnection = getConnection(url, 3000, 3000, str);
                    try {
                        try {
                            httpURLConnection.connect();
                            String allCookies = getAllCookies(httpURLConnection.getHeaderFields());
                            if (!StringUtils.isNull(allCookies)) {
                                ThirdStatisticHelper.cookieCacheMap.put(host, allCookies);
                            }
                            int responseCode = httpURLConnection.getResponseCode();
                            for (int i2 = 0; i2 < 3 && ((responseCode < 200 || responseCode >= 300) && (responseCode == 302 || responseCode == 301 || responseCode == 303)); i2++) {
                                String headerField = httpURLConnection.getHeaderField("Location");
                                if (StringUtils.isNull(headerField)) {
                                    break;
                                }
                                if (headerField.startsWith("/")) {
                                    headerField = url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() + headerField;
                                }
                                String finalCookie = getFinalCookie(httpURLConnection, str);
                                httpURLConnection.disconnect();
                                httpURLConnection = getConnection(new URL(headerField), 3000, 3000, finalCookie);
                                httpURLConnection.connect();
                                responseCode = httpURLConnection.getResponseCode();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e);
                            a.e(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                        a.e(httpURLConnection2);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (Throwable th2) {
                    th = th2;
                    a.e(httpURLConnection2);
                    throw th;
                }
                a.e(httpURLConnection);
                return null;
            }
            return (Integer) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1442365316, "Lcom/baidu/tbadk/core/util/ThirdStatisticHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1442365316, "Lcom/baidu/tbadk/core/util/ThirdStatisticHelper;");
                return;
            }
        }
        cookieCacheMap = new HashMap();
    }

    public ThirdStatisticHelper() {
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

    public static void sendReq(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        new ThirdStatisticAsyncTask(null).execute(str + "&TIME=" + System.currentTimeMillis());
    }

    public static void sendTiePlusReq(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        new TiePlusStaticTask(null).execute(str);
    }
}
