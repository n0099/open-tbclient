package com.baidu.down.request.taskmanager;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.down.common.BasicNameValuePair;
import com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.down.statistic.SpeedStatData;
import com.baidu.down.statistic.TaskSpeedStat;
import com.baidu.down.utils.Constants;
import com.baidu.down.utils.DeviceInfoUtils;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.IdentityManager;
import com.baidu.down.utils.Utils;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class TaskNetRequestMng {
    public static final boolean DEBUG = false;
    public static final String TAG = "TaskNetRequestMng";
    private static HttpURLExecutorRunnable mHttpURLExecutorRunnable;
    private static boolean mIsRequestConfig = false;

    private TaskNetRequestMng() {
    }

    public static void requestRemoteConfig(Context context, String str, String str2, HttpURLExecutorRunnable.OnWebRequestListener onWebRequestListener) {
        requestRemoteConfig(context, str2, null, null, str, true, null, null, onWebRequestListener);
    }

    public static void requestRemoteConfig(Context context, String str, String str2, String str3, String str4, boolean z, String str5, String str6, HttpURLExecutorRunnable.OnWebRequestListener onWebRequestListener) {
        String str7;
        String str8;
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
            jSONObject2.put("sdk_ver", Constants.SDK_VER);
            try {
                jSONObject2.put("domain", new URL(str4).getHost());
            } catch (Exception e) {
                e.printStackTrace();
                jSONObject2.put("domain", Constants.DOMAIN_VALUE);
            }
            jSONObject.put("dyreq", jSONObject2);
            jSONObject.put("cut", DeviceInfoUtils.getCut());
            jSONObject.put("cc", DeviceInfoUtils.getCpuCoresWithCache(context) + "");
            jSONObject.put("cf", DeviceInfoUtils.getCpuFreqWithCache(context) + "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(jSONObject.toString())) {
            try {
                str8 = Base64.encode(Utils.getEncodedValue(jSONObject.toString()).getBytes(), "utf-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                str8 = null;
            }
            if (str8 != null) {
                arrayList.add(new BasicNameValuePair("data", str8));
            }
        }
        String processCommonParams = IdentityManager.getInstance(context).processCommonParams(DownPrefUtils.getString(context, DownPrefUtils.PREF_DOWNLOAD_INFO_HOST, Constants.PREF_DOWNLOAD_INFO_HOST_DEFAULT));
        if (!TextUtils.isEmpty(str5)) {
            processCommonParams = processCommonParams + ETAG.ITEM_SEPARATOR + str5;
        }
        String encodedValue = Utils.getEncodedValue(Utils.getCurrentNetWorkApn(context));
        if (!TextUtils.isEmpty(encodedValue)) {
            String str9 = "";
            try {
                str9 = Base64.encode(encodedValue.getBytes(), "utf-8");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
            processCommonParams = processCommonParams + "&apn=" + str9;
        }
        if (Utils.getWifiOr2gOr3G(context).equals("WF")) {
            processCommonParams = processCommonParams + "&wfl=" + Utils.getWifiLevel(context);
        }
        if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
            str7 = processCommonParams + "&wap=1";
        } else {
            str7 = processCommonParams + "&wap=0";
        }
        mHttpURLExecutorRunnable = new HttpURLExecutorRunnable(context, TextUtils.equals(DownPrefUtils.getString(context, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_NAME), DownPrefUtils.HOST_TYPE_IP), str7, arrayList, onWebRequestListener);
        mHttpURLExecutorRunnable.setRequestType("POST");
        mHttpURLExecutorRunnable.execute();
    }

    public static void sendSpeedStat(final Context context, TaskSpeedStat taskSpeedStat, ConfigSpeedStat configSpeedStat, boolean z) {
        String buildSpeedStat;
        String str;
        ArrayList arrayList = new ArrayList();
        if (z) {
            buildSpeedStat = SpeedStatData.buildSpeedReqCfg(context, configSpeedStat.cfgVersion);
        } else {
            buildSpeedStat = SpeedStatData.buildSpeedStat(context, taskSpeedStat, configSpeedStat);
        }
        if (!TextUtils.isEmpty(buildSpeedStat)) {
            try {
                str = Base64.encode(Utils.getEncodedValue(buildSpeedStat.toString()).getBytes(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                str = null;
            }
            if (str != null) {
                arrayList.add(new BasicNameValuePair("data", new String(str)));
            }
            mHttpURLExecutorRunnable = new HttpURLExecutorRunnable(context, TextUtils.equals(DownPrefUtils.getString(context, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_NAME), DownPrefUtils.HOST_TYPE_IP), Constants.SPEED_STAT_URL_DEFAULT, arrayList, new HttpURLExecutorRunnable.OnWebRequestListener() { // from class: com.baidu.down.request.taskmanager.TaskNetRequestMng.1
                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onSuccess(String str2) {
                    ConfigSpeedStat parseSpeedConfig;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (jSONObject.optInt("error_code") == 0) {
                                if (!TextUtils.isEmpty(jSONObject.optString("data", "")) && (parseSpeedConfig = SpeedStatData.parseSpeedConfig(context, jSONObject.optString("data", ""))) != null) {
                                    TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().mConfigSpeedStat = parseSpeedConfig;
                                }
                                DownPrefUtils.setLong(context, DownPrefUtils.PREF_SPEED_CONFIG_ACQUIRE_TIME_KEY, System.currentTimeMillis());
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onFailed() {
                }
            }, 1);
            mHttpURLExecutorRunnable.setRequestType("POST");
            mHttpURLExecutorRunnable.execute();
        }
    }

    private static void requestConfigInfo(Context context, HttpURLExecutorRunnable.OnWebRequestListener onWebRequestListener) {
        mHttpURLExecutorRunnable = new HttpURLExecutorRunnable(context, TextUtils.equals(DownPrefUtils.getString(context, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_NAME), DownPrefUtils.HOST_TYPE_IP), IdentityManager.getInstance(context).processCommonParams(Constants.CONFIG_URL), null, onWebRequestListener);
        mHttpURLExecutorRunnable.execute();
    }

    public static void checkConfigRequest(final Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = DownPrefUtils.getLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_TIME, 0L);
        long j2 = DownPrefUtils.getLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_INTERVAL, 86400L);
        if (!mIsRequestConfig && Math.abs(j - currentTimeMillis) > 1000 * j2) {
            mIsRequestConfig = true;
            requestConfigInfo(context, new HttpURLExecutorRunnable.OnWebRequestListener() { // from class: com.baidu.down.request.taskmanager.TaskNetRequestMng.2
                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onSuccess(String str) {
                    boolean unused = TaskNetRequestMng.mIsRequestConfig = false;
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has(BaseJsonData.TAG_ERRNO) && jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0 && jSONObject.has("data")) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                String optString = optJSONObject.optString("logUrlPrefix");
                                String optString2 = optJSONObject.optString("infoUrlPrefix");
                                try {
                                    String host = new URL(optString).getHost();
                                    if (TextUtils.isEmpty(new URL(optString2).getHost()) || TextUtils.isEmpty(host)) {
                                        TaskNetRequestMng.restoreDefaultConfig(context);
                                    } else if (!optJSONObject.has("frequency") || TextUtils.isEmpty(optJSONObject.optString("frequency"))) {
                                        TaskNetRequestMng.restoreDefaultConfig(context);
                                    } else {
                                        long parseLong = Long.parseLong(optJSONObject.optString("frequency"));
                                        if (parseLong > 604800) {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_INTERVAL, 604800L);
                                        } else {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_INTERVAL, parseLong);
                                        }
                                        if (!TextUtils.isEmpty(optString)) {
                                            DownPrefUtils.setString(context, DownPrefUtils.PREF_LOG_HOST, optString);
                                        }
                                        if (!TextUtils.isEmpty(optString2)) {
                                            DownPrefUtils.setString(context, DownPrefUtils.PREF_DOWNLOAD_INFO_HOST, optString2);
                                        }
                                        DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_TIME, System.currentTimeMillis());
                                        String optString3 = optJSONObject.optString("isUploadLog");
                                        if (!TextUtils.isEmpty(optString3)) {
                                            DownPrefUtils.setString(context, DownPrefUtils.PREF_CONFI_IS_UPLOAD_LOG, optString3);
                                        }
                                        String optString4 = optJSONObject.optString("onSpeedOffsetMin");
                                        if (!TextUtils.isEmpty(optString4)) {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_DOWNLOAD_SPEED_OFFSET_MIN, Long.parseLong(optString4));
                                        }
                                        String optString5 = optJSONObject.optString("onSpeedOffsetMax");
                                        if (!TextUtils.isEmpty(optString5)) {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_DOWNLOAD_SPEED_OFFSET_MAX, Long.parseLong(optString5));
                                        }
                                        String optString6 = optJSONObject.optString("cdnUrlTimeout");
                                        if (!TextUtils.isEmpty(optString6)) {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_CDN_URL_TIMEOUT, Long.parseLong(optString6));
                                        }
                                        String optString7 = optJSONObject.optString("infoUrlTimeout");
                                        if (!TextUtils.isEmpty(optString7)) {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_DOWNINFO_URL_TIMEOUT, Long.parseLong(optString7));
                                        }
                                        String optString8 = optJSONObject.optString("testSpeedDuration");
                                        if (!TextUtils.isEmpty(optString8)) {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_DURATION, Long.parseLong(optString8));
                                        }
                                        String optString9 = optJSONObject.optString("testSpeedDataSize");
                                        if (!TextUtils.isEmpty(optString9)) {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_DATA_SIZE, Long.parseLong(optString9));
                                        }
                                        String optString10 = optJSONObject.optString("testSpeedIpNum");
                                        if (!TextUtils.isEmpty(optString10)) {
                                            DownPrefUtils.setInt(context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_IP_NUM, Integer.parseInt(optString10));
                                        }
                                        String optString11 = optJSONObject.optString("testSpeedThreshold");
                                        if (!TextUtils.isEmpty(optString11)) {
                                            DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_TEST_SPEED_THRESHOLD, Long.parseLong(optString11));
                                        }
                                        String optString12 = optJSONObject.optString("infoType");
                                        if (!TextUtils.isEmpty(optString12)) {
                                            DownPrefUtils.setString(context, DownPrefUtils.PREF_CONFI_IS_INFO_TYPE, optString12);
                                            TaskFacade.getInstance(null).getBinaryTaskMng().setInfoTypeList(context);
                                        }
                                        String optString13 = optJSONObject.optString("hostType");
                                        if (!TextUtils.isEmpty(optString13)) {
                                            DownPrefUtils.setString(context, DownPrefUtils.PREF_CONFI_HOST_TYPE, optString13);
                                        }
                                        String optString14 = optJSONObject.optString("httpLibType");
                                        if (!TextUtils.isEmpty(optString14)) {
                                            DownPrefUtils.setString(context, DownPrefUtils.PREF_CONFI_HTTP_LIB_TYPE, optString14);
                                        }
                                    }
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                    TaskNetRequestMng.restoreDefaultConfig(context);
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            TaskNetRequestMng.restoreDefaultConfig(context);
                        }
                    }
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onFailed() {
                    boolean unused = TaskNetRequestMng.mIsRequestConfig = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void restoreDefaultConfig(Context context) {
        DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_TIME, System.currentTimeMillis());
        DownPrefUtils.setLong(context, DownPrefUtils.PREF_CONFIG_REQUEST_INTERVAL, 86400L);
    }
}
