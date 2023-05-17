package com.baidu.sapi2.utils;

import android.util.Base64;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
/* loaded from: classes3.dex */
public class GetTplStokenStat implements NoProguard {
    public static final String AUTO_STATISTIC = "auto_statistic";
    public static final String KEY_GET_STOKEN = "key_get_stoken";
    public static final String KEY_GET_STOKEN_RESULT_CODE = "get_stoken_result_code";
    public static final String KEY_GET_STOKEN_RESULT_MSG = "get_stoken_result_msg";
    public static final String KEY_GET_STOKEN_TIME_CONSUMING = "get_stoken_time_consuming";

    public static String getEventTypeBase64Value(String str) {
        return "{eventType:" + str + "}";
    }

    public static void sendRequest(HttpHashMapWrap httpHashMapWrap) {
        new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, httpHashMapWrap, null, null, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.utils.GetTplStokenStat.1
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
            }
        });
    }

    public static void onEventAutoStat(String str, String str2, String str3) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("auto_statistic", Base64.encodeToString(getEventTypeBase64Value(KEY_GET_STOKEN).getBytes(), 0));
        httpHashMapWrap.put("source", "native");
        httpHashMapWrap.put("data_source", CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT);
        httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put(KEY_GET_STOKEN_RESULT_CODE, str2);
        httpHashMapWrap.put(KEY_GET_STOKEN_RESULT_MSG, str3);
        httpHashMapWrap.put(KEY_GET_STOKEN_TIME_CONSUMING, str);
        try {
            sendRequest(httpHashMapWrap);
        } catch (Exception unused) {
        }
    }
}
