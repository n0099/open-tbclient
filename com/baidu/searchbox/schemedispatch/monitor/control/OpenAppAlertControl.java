package com.baidu.searchbox.schemedispatch.monitor.control;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.schemedispatch.monitor.bean.AlertConfiguration;
import com.baidu.searchbox.utils.SchemeSpUtil;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OpenAppAlertControl {
    public static final String ALERT_CONTROL_KEY = "alert_control_key";
    public static final int ALERT_CONTROL_OFF = 0;
    public static final int ALERT_CONTROL_ON = 1;
    public static final int CONTROL_VALIDITY_PERIOD_DEFAULT = 7;
    public static final String CONTROL_VALIDITY_PERIOD_KEY = "control_validity_period_key";
    public static final int SELECT_EFFECTIVE_TIME_DEFAULT = 24;
    public static final String SELECT_EFFECTIVE_TIME_KEY = "select_effective_time_key";
    public static final int SELECT_TIMES_DEFAULT = 2;
    public static final String SELECT_TIMES_KEY = "select_times_key";
    public static final String TAG = "OpenAppAlertControl";
    public static final long days = 86400000;
    public static final long hours = 3600000;
    public static int mAlertControlSwitch;
    public static long mControlValidityPeriod;
    public static long mSelectEffectiveTime;
    public static int mSelectTimes;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final Gson mGson = new Gson();

    static {
        initRule();
    }

    public static boolean isSwitchOn() {
        if (mAlertControlSwitch == 1) {
            return true;
        }
        return false;
    }

    public static boolean addRule(String str, List<AlertConfiguration> list, String str2) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && list != null && !TextUtils.isEmpty(str2)) {
            String scheme = getScheme(str);
            if (!isInList(scheme, list)) {
                createRule(scheme, list);
            } else {
                z = updateRule(scheme, list);
            }
            saveRuleList(str2, list);
        }
        return z;
    }

    public static boolean checkRule(String str, List<AlertConfiguration> list, String str2) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2)) {
            String scheme = getScheme(str);
            for (AlertConfiguration alertConfiguration : list) {
                if (TextUtils.equals(scheme, alertConfiguration.scheme)) {
                    long j = alertConfiguration.startTime;
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    if (currentTimeMillis < 0 || j <= 0) {
                        break;
                    }
                    long j2 = mControlValidityPeriod;
                    if (currentTimeMillis <= j2) {
                        return true;
                    }
                    if (currentTimeMillis > j2) {
                        alertConfiguration.startTime = 0L;
                        saveRuleList(str2, list);
                    }
                }
            }
        }
        return false;
    }

    public static boolean compare(String[] strArr, String[] strArr2) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.addAll(Arrays.asList(strArr));
        hashSet2.addAll(Arrays.asList(strArr2));
        if (hashSet.size() != hashSet2.size()) {
            return false;
        }
        int size = hashSet.size();
        hashSet.addAll(Arrays.asList(strArr2));
        if (size != hashSet.size()) {
            return false;
        }
        return true;
    }

    public static void createRule(String str, List<AlertConfiguration> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            AlertConfiguration alertConfiguration = new AlertConfiguration();
            alertConfiguration.scheme = str;
            alertConfiguration.addTime(System.currentTimeMillis());
            list.add(alertConfiguration);
        }
    }

    public static void saveRuleList(String str, List<AlertConfiguration> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            FileUtils.cache(AppRuntime.getAppContext(), str, mGson.toJson(list), 0);
        }
    }

    public static boolean updateRule(String str, List<AlertConfiguration> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            for (AlertConfiguration alertConfiguration : list) {
                if (TextUtils.equals(str, alertConfiguration.scheme)) {
                    return alertConfiguration.addTime(System.currentTimeMillis());
                }
            }
        }
        return false;
    }

    public static String getScheme(String str) {
        int indexOf = str.indexOf("?");
        if (indexOf > 0 && indexOf < str.length()) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static void initRule() {
        mAlertControlSwitch = SchemeSpUtil.getInstance().getInt(ALERT_CONTROL_KEY, 0);
        mSelectEffectiveTime = SchemeSpUtil.getInstance().getLong(SELECT_EFFECTIVE_TIME_KEY, 24L);
        mSelectTimes = SchemeSpUtil.getInstance().getInt(SELECT_TIMES_KEY, 2);
        mControlValidityPeriod = SchemeSpUtil.getInstance().getLong(CONTROL_VALIDITY_PERIOD_KEY, 7L);
    }

    public static boolean isInList(String str, List<AlertConfiguration> list) {
        String str2;
        String str3;
        String str4;
        String str5;
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("#");
        if (indexOf >= str.length()) {
            indexOf = 0;
        }
        if (indexOf2 >= str.length()) {
            indexOf2 = 0;
        }
        if (indexOf2 > 0 && indexOf2 < indexOf) {
            indexOf = 0;
        }
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (indexOf2 > 0) {
                String substring2 = str.substring(indexOf + 1, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                str3 = substring2;
                str2 = substring3;
            } else {
                str3 = str.substring(indexOf + 1);
                str2 = null;
            }
            str = substring;
        } else if (indexOf2 > 0) {
            String substring4 = str.substring(0, indexOf2);
            String substring5 = str.substring(indexOf2 + 1);
            str3 = null;
            str2 = substring5;
            str = substring4;
        } else {
            str2 = null;
            str3 = null;
        }
        for (AlertConfiguration alertConfiguration : list) {
            String str6 = alertConfiguration.scheme;
            int indexOf3 = str6.indexOf("?");
            int indexOf4 = str6.indexOf("#");
            if (indexOf3 >= str6.length()) {
                indexOf3 = 0;
            }
            if (indexOf4 >= str6.length()) {
                indexOf4 = 0;
            }
            if (indexOf4 > 0 && indexOf4 < indexOf3) {
                indexOf3 = 0;
            }
            if (indexOf3 > 0) {
                String substring6 = str6.substring(0, indexOf3);
                if (indexOf4 > 0) {
                    String substring7 = str6.substring(indexOf3 + 1, indexOf4);
                    String substring8 = str6.substring(indexOf4 + 1);
                    str5 = substring7;
                    str4 = substring8;
                    str6 = substring6;
                } else {
                    str5 = str6.substring(indexOf3 + 1);
                    str6 = substring6;
                    str4 = null;
                }
            } else if (indexOf4 > 0) {
                String substring9 = str6.substring(0, indexOf4);
                String substring10 = str6.substring(indexOf4 + 1);
                str5 = null;
                str4 = substring10;
                str6 = substring9;
            } else {
                str4 = null;
                str5 = null;
            }
            if (str.startsWith(str6)) {
                if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4)) {
                    return true;
                }
                if (TextUtils.isEmpty(str5) || (!TextUtils.isEmpty(str3) && compare(str3.split("&"), str5.split("&")))) {
                    if (TextUtils.equals(str2, str4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void removeRule(String str, List<AlertConfiguration> list, String str2) {
        if (!TextUtils.isEmpty(str) && list != null && !TextUtils.isEmpty(str2)) {
            String scheme = getScheme(str);
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                AlertConfiguration alertConfiguration = list.get(i);
                if (TextUtils.equals(scheme, alertConfiguration.scheme)) {
                    list.remove(alertConfiguration);
                    z = true;
                }
            }
            if (z) {
                saveRuleList(str2, list);
            }
        }
    }

    public static boolean saveConfiguration(JSONObject jSONObject) {
        if (jSONObject == null) {
            if (DEBUG) {
                Log.d(TAG, "No data send");
            }
            return false;
        }
        try {
            String optString = jSONObject.optString("switch");
            String optString2 = jSONObject.optString("pre_ttl");
            String optString3 = jSONObject.optString("times");
            String optString4 = jSONObject.optString("valid_ttl");
            if (!TextUtils.isEmpty(optString)) {
                mAlertControlSwitch = Integer.parseInt(optString);
                SchemeSpUtil.getInstance().putInt(ALERT_CONTROL_KEY, mAlertControlSwitch);
            }
            if (!TextUtils.isEmpty(optString2)) {
                mSelectEffectiveTime = Integer.parseInt(optString2) * 3600000;
                SchemeSpUtil.getInstance().putLong(SELECT_EFFECTIVE_TIME_KEY, mSelectEffectiveTime);
            }
            if (!TextUtils.isEmpty(optString3)) {
                mSelectTimes = Integer.parseInt(optString3);
                SchemeSpUtil.getInstance().putInt(SELECT_TIMES_KEY, mSelectTimes);
            }
            if (!TextUtils.isEmpty(optString4)) {
                mControlValidityPeriod = Integer.parseInt(optString4) * 86400000;
                SchemeSpUtil.getInstance().putLong(CONTROL_VALIDITY_PERIOD_KEY, mControlValidityPeriod);
                return true;
            }
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                Log.e(TAG, "Data parse exception");
            }
            return false;
        }
    }
}
