package com.baidu.down.request.taskmanager;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.BasicNameValuePair;
import com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.down.statistic.SpeedStatData;
import com.baidu.down.statistic.TaskSpeedStat;
import com.baidu.down.utils.Base64Utils;
import com.baidu.down.utils.DeviceInfoUtils;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.IdentityManager;
import com.baidu.down.utils.Utils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class TaskNetRequestMng {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "TaskNetRequestMng";
    public static HttpURLExecutorRunnable mHttpURLExecutorRunnable;
    public static boolean mIsRequestConfig;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1585180398, "Lcom/baidu/down/request/taskmanager/TaskNetRequestMng;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1585180398, "Lcom/baidu/down/request/taskmanager/TaskNetRequestMng;");
        }
    }

    public TaskNetRequestMng() {
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

    public static void checkConfigRequest(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = DownPrefUtils.getLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_TIME, 0L);
            long j2 = DownPrefUtils.getLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_INTERVAL, 86400L);
            if (mIsRequestConfig || Math.abs(j - currentTimeMillis) <= j2 * 1000) {
                return;
            }
            mIsRequestConfig = true;
            requestConfigInfo(context, new HttpURLExecutorRunnable.OnWebRequestListener(context) { // from class: com.baidu.down.request.taskmanager.TaskNetRequestMng.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        boolean unused = TaskNetRequestMng.mIsRequestConfig = false;
                    }
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onSuccess(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                        boolean unused = TaskNetRequestMng.mIsRequestConfig = false;
                        if (str == null) {
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("errno") && jSONObject.optInt("errno") == 0 && jSONObject.has("data")) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                String optString = optJSONObject.optString("logUrlPrefix");
                                String optString2 = optJSONObject.optString("infoUrlPrefix");
                                try {
                                    String host = new URL(optString).getHost();
                                    if (TextUtils.isEmpty(new URL(optString2).getHost()) || TextUtils.isEmpty(host)) {
                                        TaskNetRequestMng.restoreDefaultConfig(this.val$context);
                                    } else if (!optJSONObject.has("frequency") || TextUtils.isEmpty(optJSONObject.optString("frequency"))) {
                                        TaskNetRequestMng.restoreDefaultConfig(this.val$context);
                                    } else {
                                        long parseLong = Long.parseLong(optJSONObject.optString("frequency"));
                                        if (parseLong > IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_REQUEST_INTERVAL, IMConstants.FANS_GROUP_INFO_EXPIRED_TIME);
                                        } else {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_REQUEST_INTERVAL, parseLong);
                                        }
                                        if (!TextUtils.isEmpty(optString)) {
                                            DownPrefUtils.setString(this.val$context, DownPrefUtils.PREF_LOG_HOST, optString);
                                        }
                                        if (!TextUtils.isEmpty(optString2)) {
                                            DownPrefUtils.setString(this.val$context, DownPrefUtils.PREF_DOWNLOAD_INFO_HOST, optString2);
                                        }
                                        DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_REQUEST_TIME, System.currentTimeMillis());
                                        String optString3 = optJSONObject.optString("isUploadLog");
                                        if (!TextUtils.isEmpty(optString3)) {
                                            DownPrefUtils.setString(this.val$context, DownPrefUtils.PREF_CONFI_IS_UPLOAD_LOG, optString3);
                                        }
                                        String optString4 = optJSONObject.optString("onSpeedOffsetMin");
                                        if (!TextUtils.isEmpty(optString4)) {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_DOWNLOAD_SPEED_OFFSET_MIN, Long.parseLong(optString4));
                                        }
                                        String optString5 = optJSONObject.optString("onSpeedOffsetMax");
                                        if (!TextUtils.isEmpty(optString5)) {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_DOWNLOAD_SPEED_OFFSET_MAX, Long.parseLong(optString5));
                                        }
                                        String optString6 = optJSONObject.optString("cdnUrlTimeout");
                                        if (!TextUtils.isEmpty(optString6)) {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_CDN_URL_TIMEOUT, Long.parseLong(optString6));
                                        }
                                        String optString7 = optJSONObject.optString("infoUrlTimeout");
                                        if (!TextUtils.isEmpty(optString7)) {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_DOWNINFO_URL_TIMEOUT, Long.parseLong(optString7));
                                        }
                                        String optString8 = optJSONObject.optString("testSpeedDuration");
                                        if (!TextUtils.isEmpty(optString8)) {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_DURATION, Long.parseLong(optString8));
                                        }
                                        String optString9 = optJSONObject.optString("testSpeedDataSize");
                                        if (!TextUtils.isEmpty(optString9)) {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_DATA_SIZE, Long.parseLong(optString9));
                                        }
                                        String optString10 = optJSONObject.optString("testSpeedIpNum");
                                        if (!TextUtils.isEmpty(optString10)) {
                                            DownPrefUtils.setInt(this.val$context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_IP_NUM, Integer.parseInt(optString10));
                                        }
                                        String optString11 = optJSONObject.optString("testSpeedThreshold");
                                        if (!TextUtils.isEmpty(optString11)) {
                                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_THRESHOLD, Long.parseLong(optString11));
                                        }
                                        String optString12 = optJSONObject.optString("infoType");
                                        if (!TextUtils.isEmpty(optString12)) {
                                            DownPrefUtils.setString(this.val$context, DownPrefUtils.PREF_CONFI_IS_INFO_TYPE, optString12);
                                            TaskFacade.getInstance(null).getBinaryTaskMng().setInfoTypeList(this.val$context);
                                        }
                                        String optString13 = optJSONObject.optString("hostType");
                                        if (!TextUtils.isEmpty(optString13)) {
                                            DownPrefUtils.setString(this.val$context, DownPrefUtils.PREF_CONFI_HOST_TYPE, optString13);
                                        }
                                        String optString14 = optJSONObject.optString("httpLibType");
                                        if (TextUtils.isEmpty(optString14)) {
                                            return;
                                        }
                                        DownPrefUtils.setString(this.val$context, DownPrefUtils.PREF_CONFI_HTTP_LIB_TYPE, optString14);
                                    }
                                } catch (MalformedURLException e2) {
                                    e2.printStackTrace();
                                    TaskNetRequestMng.restoreDefaultConfig(this.val$context);
                                }
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            TaskNetRequestMng.restoreDefaultConfig(this.val$context);
                        }
                    }
                }
            });
        }
    }

    public static void requestConfigInfo(Context context, HttpURLExecutorRunnable.OnWebRequestListener onWebRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, onWebRequestListener) == null) {
            HttpURLExecutorRunnable httpURLExecutorRunnable = new HttpURLExecutorRunnable(context, TextUtils.equals(DownPrefUtils.getString(context, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_NAME), DownPrefUtils.HOST_TYPE_IP), IdentityManager.getInstance(context).processCommonParams(com.baidu.down.utils.Constants.CONFIG_URL), null, onWebRequestListener);
            mHttpURLExecutorRunnable = httpURLExecutorRunnable;
            httpURLExecutorRunnable.execute();
        }
    }

    public static void requestRemoteConfig(Context context, String str, String str2, HttpURLExecutorRunnable.OnWebRequestListener onWebRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2, onWebRequestListener) == null) {
            requestRemoteConfig(context, str2, null, null, str, true, null, null, onWebRequestListener);
        }
    }

    public static void restoreDefaultConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_TIME, System.currentTimeMillis());
            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_INTERVAL, 86400L);
        }
    }

    public static void sendSpeedStat(Context context, TaskSpeedStat taskSpeedStat, ConfigSpeedStat configSpeedStat, boolean z) {
        String buildSpeedStat;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, taskSpeedStat, configSpeedStat, Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList();
            if (z) {
                buildSpeedStat = SpeedStatData.buildSpeedReqCfg(context, configSpeedStat.cfgVersion);
            } else {
                buildSpeedStat = SpeedStatData.buildSpeedStat(context, taskSpeedStat, configSpeedStat);
            }
            if (TextUtils.isEmpty(buildSpeedStat)) {
                return;
            }
            String encode = Base64Utils.encode(Utils.getEncodedValue(buildSpeedStat.toString()).getBytes());
            if (encode != null) {
                arrayList.add(new BasicNameValuePair("data", new String(encode)));
            }
            HttpURLExecutorRunnable httpURLExecutorRunnable = new HttpURLExecutorRunnable(context, TextUtils.equals(DownPrefUtils.getString(context, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_NAME), DownPrefUtils.HOST_TYPE_IP), com.baidu.down.utils.Constants.SPEED_STAT_URL_DEFAULT, arrayList, new HttpURLExecutorRunnable.OnWebRequestListener(context) { // from class: com.baidu.down.request.taskmanager.TaskNetRequestMng.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onSuccess(String str) {
                    ConfigSpeedStat parseSpeedConfig;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.optInt("error_code") == 0) {
                            if (!TextUtils.isEmpty(jSONObject.optString("data", "")) && (parseSpeedConfig = SpeedStatData.parseSpeedConfig(this.val$context, jSONObject.optString("data", ""))) != null) {
                                TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().mConfigSpeedStat = parseSpeedConfig;
                            }
                            DownPrefUtils.setLong(this.val$context, DownPrefUtils.PREF_SPEED_CONFIG_ACQUIRE_TIME_KEY, System.currentTimeMillis());
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }, 1);
            mHttpURLExecutorRunnable = httpURLExecutorRunnable;
            httpURLExecutorRunnable.setRequestType("POST");
            mHttpURLExecutorRunnable.execute();
        }
    }

    public static void requestRemoteConfig(Context context, String str, String str2, String str3, String str4, boolean z, String str5, String str6, HttpURLExecutorRunnable.OnWebRequestListener onWebRequestListener) {
        String str7;
        String encode;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, str2, str3, str4, Boolean.valueOf(z), str5, str6, onWebRequestListener}) == null) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("type", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("f", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("tj", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("download_inner", str4);
                }
                if (z) {
                    jSONObject.put("dyneed", "1");
                } else {
                    jSONObject.put("dyneed", "0");
                }
                if (!TextUtils.isEmpty(str6)) {
                    jSONObject.put("size", str6);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("from", "as");
                jSONObject2.put("sdk_ver", com.baidu.down.utils.Constants.SDK_VER);
                try {
                    jSONObject2.put("domain", new URL(str4).getHost());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    jSONObject2.put("domain", com.baidu.down.utils.Constants.DOMAIN_VALUE);
                }
                jSONObject.put("dyreq", jSONObject2);
                jSONObject.put("cut", DeviceInfoUtils.getCut());
                jSONObject.put("cc", DeviceInfoUtils.getCpuCoresWithCache(context) + "");
                jSONObject.put("cf", DeviceInfoUtils.getCpuFreqWithCache(context) + "");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            if (!TextUtils.isEmpty(jSONObject.toString()) && (encode = Base64Utils.encode(Utils.getEncodedValue(jSONObject.toString()).getBytes())) != null) {
                arrayList.add(new BasicNameValuePair("data", encode));
            }
            String processCommonParams = IdentityManager.getInstance(context).processCommonParams(DownPrefUtils.getString(context, DownPrefUtils.PREF_DOWNLOAD_INFO_HOST, com.baidu.down.utils.Constants.PREF_DOWNLOAD_INFO_HOST_DEFAULT));
            if (!TextUtils.isEmpty(str5)) {
                processCommonParams = processCommonParams + "&" + str5;
            }
            String encodedValue = Utils.getEncodedValue(Utils.getCurrentNetWorkApn(context));
            if (!TextUtils.isEmpty(encodedValue)) {
                processCommonParams = processCommonParams + "&apn=" + Base64Utils.encode(encodedValue.getBytes());
            }
            if (Utils.getWifiOr2gOr3G(context).equals("WF")) {
                processCommonParams = processCommonParams + "&wfl=" + Utils.getWifiLevel(context);
            }
            if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
                str7 = processCommonParams + "&wap=1";
            } else {
                str7 = processCommonParams + "&wap=0";
            }
            HttpURLExecutorRunnable httpURLExecutorRunnable = new HttpURLExecutorRunnable(context, TextUtils.equals(DownPrefUtils.getString(context, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_NAME), DownPrefUtils.HOST_TYPE_IP), str7, arrayList, onWebRequestListener);
            mHttpURLExecutorRunnable = httpURLExecutorRunnable;
            httpURLExecutorRunnable.setRequestType("POST");
            mHttpURLExecutorRunnable.execute();
        }
    }
}
