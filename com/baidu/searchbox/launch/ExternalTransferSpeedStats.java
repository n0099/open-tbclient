package com.baidu.searchbox.launch;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ExternalTransferSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ABTEST_EXTERNAL_TRANSFER_OPT_KEY = "external_transfer_opt_enable";
    public static final String APPLICATION_CREATE_ID = "external_application_create";
    public static final String BUSINESS_PAGE_CREATE_ID = "external_business_create";
    public static final String BUSINESS_PAGE_UI_READY_ID = "external_business_ui_ready";
    public static final boolean DEBUG;
    public static final long DEFAULT_TIMESTAMP = 0;
    public static final String FEED_PAGE = "feed";
    public static final String FEED_UI_READY_ID = "c_dom_first_screen_paint";
    public static final long MAX_VALID_EXTERNAL_THRESHOLD = 15000;
    public static final String NORMAL_EXTERNAL_TRANSFER_TYPE = "normal";
    public static final String QUICK_EXTERNAL_TRANSFER_TYPE = "quick";
    public static final String SCHEME_DISPATCHER_END_ID = "external_dispatch_end";
    public static final String SCHEME_DISPATCHER_START_ID = "external_dispatch_start";
    public static final String SEARCH_PAGE = "search";
    public static final String SOURCE_FROM_PUSH = "push";
    public static final String SOURCE_FROM_SCHEME = "scheme";
    public static final String SOURCE_FROM_WISE = "wise";
    public static final String SWAN_PAGE = "swan";
    public static final String TAG = "ExternalTransferSpeedStats";
    public static final String UBC_ADDITION_INFO_KEY = "addition_info";
    public static final String UBC_APPLICATION_CREATE_KEY = "begin_time";
    public static final String UBC_DISPATCH_END_KEY = "dispatcher_duration";
    public static final String UBC_DISPATCH_START_KEY = "dispatcher_start_duration";
    public static final String UBC_EXTERNAL_TRANSFER_ID = "1090";
    public static final String UBC_PAGE_DID_SHOW_DURATION_KEY = "duration";
    public static final String UBC_PAGE_WILL_SHOW_DURATION_KEY = "will_show_duration";
    public static JSONObject additionInfos;
    public static String sBusinessPage;
    public static long sBusinessPageCreateTimeStamp;
    public static long sBusinessPageUiReadyTimeStamp;
    public static String sExternalTransferType;
    public static boolean sHasForegroundToBackground;
    public static long sSchemeDispatcherEndTimeStamp;
    public static long sSchemeDispatcherStartTimeStamp;
    public static String sSource;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1155067925, "Lcom/baidu/searchbox/launch/ExternalTransferSpeedStats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1155067925, "Lcom/baidu/searchbox/launch/ExternalTransferSpeedStats;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sSchemeDispatcherStartTimeStamp = 0L;
        sSchemeDispatcherEndTimeStamp = 0L;
        sBusinessPageCreateTimeStamp = 0L;
        sBusinessPageUiReadyTimeStamp = 0L;
        sSource = "";
        sBusinessPage = "";
        sExternalTransferType = "";
        sHasForegroundToBackground = false;
    }

    public ExternalTransferSpeedStats() {
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

    public static synchronized void addEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            synchronized (ExternalTransferSpeedStats.class) {
                addEvent(str, String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static synchronized void endFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (ExternalTransferSpeedStats.class) {
                if (LaunchStatsUtils.isAppCreateTimeValid() && !TextUtils.isEmpty(sSource) && !TextUtils.isEmpty(sBusinessPage)) {
                    if (LaunchStatsUtils.getLaunchType() != 1 && !sHasForegroundToBackground) {
                        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                        if (uBCManager == null) {
                            resetFlow();
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("from", "research");
                            if (sBusinessPageCreateTimeStamp == 0) {
                                jSONObject.put("type", "");
                            } else {
                                long homePageFirstRenderEndTime = LaunchStatsUtils.getHomePageFirstRenderEndTime();
                                if (homePageFirstRenderEndTime != 0 && sBusinessPageCreateTimeStamp - homePageFirstRenderEndTime <= 0) {
                                    jSONObject.put("type", "normal");
                                }
                                jSONObject.put("type", QUICK_EXTERNAL_TRANSFER_TYPE);
                            }
                            jSONObject.put("page", sBusinessPage);
                            jSONObject.put("source", sSource);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("begin_time", LaunchStatsUtils.getAppCreateTime());
                            long appCreateTime = LaunchStatsUtils.getAppCreateTime();
                            if (sSchemeDispatcherStartTimeStamp != 0) {
                                long j = sSchemeDispatcherStartTimeStamp - appCreateTime;
                                if (j > 0 && j < 15000) {
                                    jSONObject2.put(UBC_DISPATCH_START_KEY, j);
                                } else {
                                    jSONObject2.put(UBC_DISPATCH_START_KEY, -1);
                                }
                            } else {
                                jSONObject2.put(UBC_DISPATCH_START_KEY, -1);
                            }
                            if (sSchemeDispatcherEndTimeStamp != 0) {
                                long j2 = sSchemeDispatcherEndTimeStamp - appCreateTime;
                                if (j2 > 0 && j2 < 15000) {
                                    jSONObject2.put(UBC_DISPATCH_END_KEY, j2);
                                } else {
                                    jSONObject2.put(UBC_DISPATCH_END_KEY, -1);
                                }
                            } else {
                                jSONObject2.put(UBC_DISPATCH_END_KEY, -1);
                            }
                            if (sBusinessPageCreateTimeStamp != 0) {
                                long j3 = sBusinessPageCreateTimeStamp - appCreateTime;
                                if (j3 > 0 && j3 < 15000) {
                                    jSONObject2.put(UBC_PAGE_WILL_SHOW_DURATION_KEY, j3);
                                } else {
                                    jSONObject2.put(UBC_PAGE_WILL_SHOW_DURATION_KEY, -1);
                                }
                            } else {
                                jSONObject2.put(UBC_PAGE_WILL_SHOW_DURATION_KEY, -1);
                            }
                            if (sBusinessPageUiReadyTimeStamp != 0) {
                                long j4 = sBusinessPageUiReadyTimeStamp - appCreateTime;
                                if (j4 > 0 && j4 < 15000) {
                                    jSONObject2.put("duration", sBusinessPageUiReadyTimeStamp - LaunchStatsUtils.getAppCreateTime());
                                } else {
                                    jSONObject2.put("duration", -1);
                                }
                            } else {
                                jSONObject2.put("duration", -1);
                            }
                            jSONObject2.put(UBC_ADDITION_INFO_KEY, additionInfos);
                            jSONObject.put("ext", jSONObject2);
                            uBCManager.onEvent(UBC_EXTERNAL_TRANSFER_ID, jSONObject.toString());
                            if (DEBUG) {
                                Log.d(TAG, jSONObject.toString());
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        resetFlow();
                        return;
                    }
                    if (DEBUG) {
                        Log.d(TAG, "hot launch , drop data");
                    }
                    resetFlow();
                    return;
                }
                resetFlow();
            }
        }
    }

    public static String getStatsString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" Source: " + sSource);
            sb.append(" BusinessPage: " + sBusinessPage);
            sb.append(" ExternalTransferType: " + sExternalTransferType);
            sb.append(" AppCreate timeStamp: " + LaunchStatsUtils.getAppCreateTime());
            sb.append(" SchemeDispatchStart timeStamp: " + sSchemeDispatcherStartTimeStamp);
            sb.append(" SchemeDispatchEnd timeStamp: " + sSchemeDispatcherEndTimeStamp);
            sb.append(" BusinessPageCreate timeStamp: " + sBusinessPageCreateTimeStamp);
            sb.append(" BusinessPageUiReady timeStamp: " + sBusinessPageUiReadyTimeStamp);
            sb.append(" AdditionInfos: " + additionInfos);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean isExternalTransferOptEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static JSONObject mergeJson(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONObject, jSONObject2)) == null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.optString(next));
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void resetFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            synchronized (ExternalTransferSpeedStats.class) {
                if (DEBUG) {
                    Log.d(TAG, "resetFlow");
                }
            }
        }
    }

    public static synchronized void setExternalTransferPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            synchronized (ExternalTransferSpeedStats.class) {
                if (LaunchStatsUtils.isAppCreateTimeValid() && !TextUtils.isEmpty(sSource)) {
                    if (FEED_PAGE != str && "search" != str && "swan" != str) {
                        if (DEBUG) {
                            Log.d(TAG, "cannot distinguish the page: " + str);
                        }
                    }
                    sBusinessPage = str;
                    if (DEBUG) {
                        Log.d(TAG, "set external transfer page: " + str);
                    }
                }
            }
        }
    }

    public static synchronized void setExternalTransferSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            synchronized (ExternalTransferSpeedStats.class) {
                if (LaunchStatsUtils.isAppCreateTimeValid()) {
                    if ("push" != str && "wise" != str && "scheme" != str) {
                        if (DEBUG) {
                            Log.d(TAG, "cannot distinguish the source: " + str);
                        }
                    }
                    sSource = str;
                    if (DEBUG) {
                        Log.d(TAG, "set external transfer source: " + str);
                    }
                }
            }
        }
    }

    public static void setForegroundToBackgroundFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            sHasForegroundToBackground = z;
        }
    }

    public static synchronized void setValueWithJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, jSONObject) == null) {
            synchronized (ExternalTransferSpeedStats.class) {
                try {
                    if (additionInfos == null) {
                        additionInfos = jSONObject;
                    } else {
                        mergeJson(additionInfos, jSONObject);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static synchronized void addEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            synchronized (ExternalTransferSpeedStats.class) {
                if (LaunchStatsUtils.isAppCreateTimeValid() && !TextUtils.isEmpty(sSource)) {
                    if (TextUtils.equals(str, SCHEME_DISPATCHER_START_ID) && sSchemeDispatcherStartTimeStamp == 0) {
                        sSchemeDispatcherStartTimeStamp = Long.valueOf(str2).longValue();
                        if (DEBUG) {
                            Log.d(TAG, "set sSchemeDispatcherStartTimeStamp: " + sSchemeDispatcherStartTimeStamp);
                        }
                    } else if (TextUtils.equals(str, SCHEME_DISPATCHER_END_ID) && sSchemeDispatcherEndTimeStamp == 0) {
                        sSchemeDispatcherEndTimeStamp = Long.valueOf(str2).longValue();
                        if (DEBUG) {
                            Log.d(TAG, "set sSchemeDispatcherEndTimeStamp: " + sSchemeDispatcherEndTimeStamp);
                        }
                    } else if (TextUtils.equals(str, BUSINESS_PAGE_CREATE_ID) && sBusinessPageCreateTimeStamp == 0) {
                        sBusinessPageCreateTimeStamp = Long.valueOf(str2).longValue();
                        if (DEBUG) {
                            Log.d(TAG, "set sBusinessPageCreateTimeStamp: " + sBusinessPageCreateTimeStamp);
                        }
                    } else if (TextUtils.equals(str, BUSINESS_PAGE_UI_READY_ID) && sBusinessPageUiReadyTimeStamp == 0) {
                        sBusinessPageUiReadyTimeStamp = Long.valueOf(str2).longValue();
                        if (DEBUG) {
                            Log.d(TAG, "set sBusinessPageUiReadyTimeStamp: " + sBusinessPageUiReadyTimeStamp);
                        }
                    } else if (TextUtils.equals(str, FEED_UI_READY_ID) && sBusinessPage == FEED_PAGE) {
                        sBusinessPageUiReadyTimeStamp = Long.valueOf(str2).longValue();
                    }
                    if (!TextUtils.equals(str, SCHEME_DISPATCHER_START_ID) && !TextUtils.equals(str, SCHEME_DISPATCHER_END_ID) && !TextUtils.equals(str, BUSINESS_PAGE_CREATE_ID) && !TextUtils.equals(str, BUSINESS_PAGE_UI_READY_ID)) {
                        try {
                            if (additionInfos == null) {
                                additionInfos = new JSONObject();
                            }
                            additionInfos.put(str, str2);
                            if (DEBUG) {
                                Log.d(TAG, "set additionInfos: " + additionInfos.toString());
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
