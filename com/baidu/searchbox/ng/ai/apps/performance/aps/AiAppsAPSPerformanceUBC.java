package com.baidu.searchbox.ng.ai.apps.performance.aps;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.ubc.Flow;
import com.baidu.ubc.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsAPSPerformanceUBC {
    public static final String APS_END_CHECK_SIGN = "na_aps_end_check_sign";
    public static final String APS_END_DOWNLOAD = "na_aps_end_download";
    public static final String APS_END_ICON = "na_aps_end_icon";
    public static final String APS_END_REQ = "na_aps_end_req";
    public static final String APS_START_CHECK_SIGN = "na_aps_start_check_sign";
    public static final String APS_START_DOWNLOAD = "na_aps_start_download";
    public static final String APS_START_ICON = "na_aps_start_icon";
    public static final String APS_START_REQ = "na_aps_start_req";
    private static final boolean DEBUG = false;
    public static final String END_UPDATE_DB = "na_end_update_db";
    private static final String EXT_APP_ID = "appid";
    private static final String EXT_MOBILE = "mobile";
    private static final String EXT_NET = "net";
    private static final String ID = "770";
    public static final String PACKAGE_END_DECRYPT = "na_package_end_decrypt";
    public static final String PACKAGE_END_UNZIP = "na_package_end_unzip";
    public static final String PACKAGE_START_DECRYPT = "na_package_start_decrypt";
    public static final String PACKAGE_START_UNZIP = "na_package_start_unzip";
    public static final String START_UPDATE_DB = "na_start_update_db";
    private static final String TAG = "AiAppsAPSPerformanceUBC";
    public static final String TYPE_MAIN = "main_download";
    public static final String TYPE_MAIN_ASYNC = "main_async_download";
    public static final String TYPE_PRE_DOWNLOAD = "main_pre_download";
    public static List<Pair<String, Pair<String, String>>> mCostReportList;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface APSDownloadType {
    }

    public static void onDownloadMainStatistics(String str, String str2, List<UbcFlowEvent> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            Flow xI = o.xI(ID);
            for (UbcFlowEvent ubcFlowEvent : list) {
                if (ubcFlowEvent != null) {
                    xI.e(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.time());
                }
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("type", str2);
                jSONObject2.put("appid", str);
                jSONObject2.put("mobile", AiAppsRuntime.getAiAppAccountRuntime().getDeviceInfo());
                jSONObject2.put(EXT_NET, AiAppNetworkUtils.getNetworkType().type);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            xI.xD(jSONObject.toString());
            xI.end();
            printCostLogForDebug(str, list, mCostReportList);
        }
    }

    public static UbcFlowEvent generateUBCEventFormBundle(Bundle bundle, String str, String str2) {
        if (bundle != null) {
            long j = bundle.getLong(str, -1L);
            if (j > 0) {
                return new UbcFlowEvent(str2).time(j);
            }
        }
        return null;
    }

    private static void printCostLogForDebug(String str, List<UbcFlowEvent> list, List<Pair<String, Pair<String, String>>> list2) {
    }
}
