package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hg;
import com.baidu.tieba.sg;
import com.baidu.tieba.zf;
import com.baidu.tieba.zx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class ThirdStatisticHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Map<String, String> COOKIE_CACHE_MAP;
    public static final int MAX_DIRECT_TIMES = 3;
    public static final int REQUEST_COST_URL_TYPE = 2;
    public static final int REQUEST_SHOW_URL_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface ThirdStatisticCallback {
        void onFailed(String str);

        void onSuccess(String str);
    }

    /* loaded from: classes4.dex */
    public static class ThirdStatisticAsyncTask extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ThirdStatisticCallback callback;
        public String requestUrl;

        public ThirdStatisticAsyncTask(String str, ThirdStatisticCallback thirdStatisticCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, thirdStatisticCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.requestUrl = str;
            this.callback = thirdStatisticCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                int i = 0;
                if (strArr != null && strArr.length != 0) {
                    try {
                        zf g = new hg().g(strArr[0], 3, 30000, 3000);
                        if (g != null) {
                            i = g.b;
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    return Integer.valueOf(i);
                }
                return 0;
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                super.onPostExecute((ThirdStatisticAsyncTask) num);
                if (this.callback == null) {
                    return;
                }
                if (num.intValue() == 200) {
                    this.callback.onSuccess(this.requestUrl);
                } else {
                    this.callback.onFailed(this.requestUrl);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class TiePlusStaticTask extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mRequestType;
        public String mRequestUrl;
        public String mTid;
        public ThirdStatisticCallback mTiePlusStatisCallback;

        public TiePlusStaticTask(String str, int i, ThirdStatisticCallback thirdStatisticCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), thirdStatisticCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTid = str;
            this.mRequestType = i;
            this.mTiePlusStatisCallback = thirdStatisticCallback;
        }

        private String getAllCookies(Map<String, List<String>> map) {
            InterceptResult invokeL;
            List<String> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, map)) == null) {
                if (map == null || (list = map.get("Set-Cookie")) == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    sb.append(str);
                    if (!str.endsWith(ParamableElem.DIVIDE_PARAM)) {
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        private HttpURLConnection getConnection(URL url, int i, int i2, String str) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{url, Integer.valueOf(i), Integer.valueOf(i2), str})) == null) {
                if (url == null) {
                    return null;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i2);
                httpURLConnection.setRequestProperty("User-Agent", zx5.b());
                httpURLConnection.addRequestProperty("Cookie", str);
                return httpURLConnection;
            }
            return (HttpURLConnection) invokeCommon.objValue;
        }

        private String getFinalCookie(HttpURLConnection httpURLConnection, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, httpURLConnection, str)) == null) {
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
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    sb.append(str);
                }
                return sb.toString();
            }
            return (String) invokeLL.objValue;
        }

        private void requestResultCallback(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
                if (i == 200) {
                    ThirdStatisticCallback thirdStatisticCallback = this.mTiePlusStatisCallback;
                    if (thirdStatisticCallback != null) {
                        thirdStatisticCallback.onSuccess(this.mRequestUrl);
                        return;
                    }
                    return;
                }
                ThirdStatisticCallback thirdStatisticCallback2 = this.mTiePlusStatisCallback;
                if (thirdStatisticCallback2 != null) {
                    thirdStatisticCallback2.onFailed(this.mRequestUrl);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                super.onPostExecute((TiePlusStaticTask) num);
                requestResultCallback(num.intValue());
            }
        }

        private void requestStatistic(int i, String str) {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65541, this, i, str) == null) {
                int i2 = this.mRequestType;
                if (i2 == 2) {
                    statisticItem = new StatisticItem(CommonStatisticKey.KEY_TIE_PLUS_CPC_REQUEST_COST_URL);
                } else if (i2 == 1) {
                    statisticItem = new StatisticItem(CommonStatisticKey.KEY_TIE_PLUS_CPC_REQUEST_SHOW_URL);
                } else {
                    statisticItem = null;
                }
                if (statisticItem != null) {
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.addParam("tid", this.mTid);
                    statisticItem.addParam("num", i);
                    statisticItem.addParam("code", str);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                URL url = null;
                if (strArr == null || strArr.length == 0) {
                    return null;
                }
                String str = "BAIDUID=" + TbSingleton.getInstance().getBaiduIdForAnti();
                this.mRequestUrl = strArr[0];
                HttpURLConnection httpURLConnection = null;
                int i = 0;
                for (int i2 = 0; i2 < 3; i2++) {
                    if (url == null) {
                        try {
                            try {
                                url = new URL(strArr[0]);
                            } catch (Exception e) {
                                requestStatistic(i2 + 1, e.getMessage());
                                BdLog.e(e);
                            }
                        } finally {
                            sg.f(httpURLConnection);
                        }
                    }
                    if (i != 200) {
                        if (i != 302 && i != 301 && i != 303) {
                            if (url != null) {
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                String host = url.getHost();
                                String str2 = (String) ThirdStatisticHelper.COOKIE_CACHE_MAP.get(host);
                                httpURLConnection = getConnection(url, 3000, 3000, str);
                                httpURLConnection.connect();
                                String allCookies = getAllCookies(httpURLConnection.getHeaderFields());
                                if (!StringUtils.isNull(allCookies)) {
                                    ThirdStatisticHelper.COOKIE_CACHE_MAP.put(host, allCookies);
                                }
                                i = httpURLConnection.getResponseCode();
                                requestStatistic(i2 + 1, String.valueOf(i));
                                sg.f(httpURLConnection);
                            }
                        } else if (httpURLConnection != null) {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (!StringUtils.isNull(headerField)) {
                                if (headerField.startsWith("/")) {
                                    headerField = url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() + headerField;
                                }
                                String finalCookie = getFinalCookie(httpURLConnection, str);
                                httpURLConnection.disconnect();
                                httpURLConnection = getConnection(new URL(headerField), 3000, 3000, finalCookie);
                                httpURLConnection.connect();
                                i = httpURLConnection.getResponseCode();
                                requestStatistic(i2 + 1, String.valueOf(i));
                                sg.f(httpURLConnection);
                            }
                        }
                    }
                }
                return Integer.valueOf(i);
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
        COOKIE_CACHE_MAP = new HashMap();
    }

    public ThirdStatisticHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void sendReq(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            sendReq(str, null);
        }
    }

    public static void sendReq(String str, ThirdStatisticCallback thirdStatisticCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, thirdStatisticCallback) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String replaceAll = str.replaceAll("_TIME_", valueOf);
        new ThirdStatisticAsyncTask(replaceAll, thirdStatisticCallback).execute(UrlUtils.appendParam(replaceAll, "TIME", valueOf));
    }

    public static void sendTiePlusReq(String str, String str2, int i, ThirdStatisticCallback thirdStatisticCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65541, null, str, str2, i, thirdStatisticCallback) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        new TiePlusStaticTask(str2, i, thirdStatisticCallback).execute(str);
    }
}
