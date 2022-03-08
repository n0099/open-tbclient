package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class StatService implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTO_STATISTIC = "auto_statistic";
    public static final String STAT_ENENT_QR_LOGIN_ENTER = "qrlogin_enter";
    public static final String TAG = "StatService";
    public static final Map<String, String> commonParams;
    public static List<String> delayRequestName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(853828778, "Lcom/baidu/sapi2/utils/StatService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(853828778, "Lcom/baidu/sapi2/utils/StatService;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        commonParams = hashMap;
        hashMap.put("pid", "111");
        commonParams.put("type", SmartLaunchStats.UBC_START_LAUNCH_ID);
        commonParams.put("device", Build.MODEL);
        ArrayList arrayList = new ArrayList();
        delayRequestName = arrayList;
        arrayList.add("share_read");
        delayRequestName.add("share_silent_account");
        delayRequestName.add("share_silent_account_success");
        delayRequestName.add("load_login");
        delayRequestName.add("share_account_open");
        delayRequestName.add("pass_sdk_init");
    }

    public StatService() {
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

    public static String getEventTypeBase64Value(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return "{eventType:" + str + "}";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isSearchBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                Class.forName("com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler");
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void onEvent(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.putAll(commonParams);
            httpHashMapWrap.put("name", str);
            httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        httpHashMapWrap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (delayRequestName.contains(str) && isSearchBox()) {
                NetworkRequestScheduler.execute(new Runnable(httpHashMapWrap) { // from class: com.baidu.sapi2.utils.StatService.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HttpHashMapWrap val$params;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {httpHashMapWrap};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$params = httpHashMapWrap;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StatService.sendRequest(this.val$params);
                        }
                    }
                }, "pass_sdk_".concat(str), 60000L, false);
                return;
            }
            sendRequest(httpHashMapWrap);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static void onEventAutoStat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            onEventAutoStat(str, null);
        }
    }

    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, linkedHashMap) == null) {
            onEventAutoStatistic(linkedHashMap, null);
        }
    }

    public static void sendRequest(HttpHashMapWrap httpHashMapWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, httpHashMapWrap) == null) {
            new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, httpHashMapWrap, null, null, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.utils.StatService.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Boolean.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    }
                }
            });
        }
    }

    public static void onEventAutoStat(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, map) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put(AUTO_STATISTIC, Base64.encodeToString(getEventTypeBase64Value(str).getBytes(), 0));
            httpHashMapWrap.putAll(commonParams);
            httpHashMapWrap.put("source", "native");
            httpHashMapWrap.put("data_source", "client");
            httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
            if (map != null) {
                for (String str2 : map.keySet()) {
                    httpHashMapWrap.put(str2, map.get(str2));
                }
            }
            try {
                sendRequest(httpHashMapWrap);
            } catch (Exception unused) {
            }
        }
    }

    @TargetApi(8)
    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, linkedHashMap, map) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (String str : linkedHashMap.keySet()) {
                sb.append(str);
                sb.append(":");
                sb.append(linkedHashMap.get(str));
                sb.append(",");
            }
            int lastIndexOf = sb.lastIndexOf(",");
            if (lastIndexOf > 0) {
                sb = new StringBuilder(sb.substring(0, lastIndexOf));
            }
            sb.append("}");
            Log.d(TAG, "onEventAutoStatistic content=" + sb.toString());
            map.put(AUTO_STATISTIC, Base64.encodeToString(sb.toString().getBytes(), 0));
            map.put("source", "native");
            map.put("data_source", "client");
            onEvent(AUTO_STATISTIC, map);
        }
    }
}
