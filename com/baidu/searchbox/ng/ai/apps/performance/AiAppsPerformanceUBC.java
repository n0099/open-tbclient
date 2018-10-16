package com.baidu.searchbox.ng.ai.apps.performance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.ubc.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsPerformanceUBC {
    public static final String ACTION_APS_END_DOWNLOAD = "aps_end_download";
    public static final String ACTION_APS_END_REQ = "aps_end_req";
    public static final String ACTION_APS_START_DOWNLOAD = "aps_start_download";
    public static final String ACTION_APS_START_REQ = "aps_start_req";
    public static final String ACTION_FE_MASTER_FIRST_INIT_DATA = "master_first_init_data";
    public static final String ACTION_FE_SLAVE_FIRST_LOADED = "slave_first_loaded";
    public static final String ACTION_FE_SLAVE_FIRST_RECIEVE_DATA = "slave_first_recieve_data";
    public static final String ACTION_FE_SLAVE_FIRST_RENDERED = "slave_first_rendered";
    public static final String ACTION_FE_SLAVE_JS_PARSED = "slave_js_parsed";
    public static final String ACTION_FIRST_ANIM_END = "first_anim_end";
    public static final String ACTION_FIRST_ANIM_START = "first_anim_start";
    public static final String ACTION_FRAME_START_CREATE = "frame_start_create";
    public static final String ACTION_FRAME_START_END = "frame_start_end";
    public static final String ACTION_LAUNCH_ACTIVITY = "na_launch_activity";
    public static final String ACTION_MASTER_DISPATCH_START = "master_dispatch_start";
    public static final String ACTION_NA_START = "naStart";
    public static final String ACTION_PACKAGE_END_DECRYPT = "package_end_decrypt";
    public static final String ACTION_PACKAGE_END_UNZIP = "package_end_unzip";
    public static final String ACTION_PACKAGE_START_DECRYPT = "package_start_decrypt";
    public static final String ACTION_PACKAGE_START_UNZIP = "package_start_unzip";
    public static final String ACTION_POST_TO_MAIN_END = "na_post_to_main_end";
    public static final String ACTION_POST_TO_MAIN_STRAT = "na_post_to_main_start";
    public static final String ACTION_PRE_CREATE_CHECK = "na_pre_create_check";
    public static final String ACTION_PRE_CREATE_OK = "na_pre_create_ok";
    public static final String ACTION_PRE_LOAD_BLINK_INIT_OK = "na_pre_load_blink_init_ok";
    public static final String ACTION_PRE_LOAD_CHECK = "na_pre_load_check";
    public static final String ACTION_PRE_LOAD_END = "na_pre_load_end";
    public static final String ACTION_PRE_LOAD_MASTER_CREATED = "na_pre_load_master_created";
    public static final String ACTION_PRE_LOAD_MASTER_OK = "na_pre_load_master_ok";
    public static final String ACTION_PRE_LOAD_MASTER_START = "na_pre_load_master_start";
    public static final String ACTION_PRE_LOAD_OK = "na_pre_load_ok";
    public static final String ACTION_PRE_LOAD_SLAVE_CREATED = "na_pre_load_slave_created";
    public static final String ACTION_PRE_LOAD_SLAVE_OK = "na_pre_load_slave_ok";
    public static final String ACTION_PRE_LOAD_SLAVE_START = "na_pre_load_slave_start";
    public static final String ACTION_PRE_LOAD_START = "na_pre_load_start";
    public static final String ACTION_QUERY_DB_ACTIVITY = "na_query_db";
    public static final String ACTION_SECOND_ANIM_END = "second_anim_end";
    public static final String ACTION_SECOND_ANIM_START = "second_anim_start";
    public static final String ACTION_SLAVE_DISPATCH_START = "slave_dispatch_start";
    public static final String AIAPP_BOOT_TYPE_LOAD_LOCAL = "1";
    public static final String AIAPP_BOOT_TYPE_LOAD_REMOTE = "0";
    private static final boolean DEBUG = false;
    public static final String EXTRA_AIAPP_APS_CHECK_END_TIMESTAMP = "aiapp_aps_check_end_timestamp";
    public static final String EXTRA_AIAPP_APS_CHECK_SIGN_END_TIMESTAMP = "aiapp_aps_check_sign_end_timestamp";
    public static final String EXTRA_AIAPP_APS_CHECK_SIGN_START_TIMESTAMP = "aiapp_aps_check_sign_start_timestamp";
    public static final String EXTRA_AIAPP_APS_CHECK_START_TIMESTAMP = "aiapp_aps_check_start_timestamp";
    public static final String EXTRA_AIAPP_APS_DECRYPT_END_TIMESTAMP = "aiapp_aps_decrypt_end_timestamp";
    public static final String EXTRA_AIAPP_APS_DECRYPT_START_TIMESTAMP = "aiapp_aps_decrypt_start_timestamp";
    public static final String EXTRA_AIAPP_APS_DOWNLOAD_END_TIMESTAMP = "aiapp_download_end_timestamp";
    public static final String EXTRA_AIAPP_APS_DOWNLOAD_START_TIMESTAMP = "aiapp_download_start_timestamp";
    public static final String EXTRA_AIAPP_APS_UNZIP_END_TIMESTAMP = "aiapp_aps_unzip_end_timestamp";
    public static final String EXTRA_AIAPP_APS_UNZIP_START_TIMESTAMP = "aiapp_aps_unzip_start_timestamp";
    public static final String EXTRA_AIAPP_LAUNCH_ACTIVITY_TIMESTAMP = "aiapp_launch_activity_timestamp";
    public static final String EXTRA_AIAPP_PRE_CREATE_CHECK_TIMESTAMP = "aiapp_pre_create_check_timestamp";
    public static final String EXTRA_AIAPP_PRE_CREATE_OK_TIMESTAMP = "aiapp_pre_create_ok_timestamp";
    public static final String EXTRA_AIAPP_QUERY_DB_TIMESTAMP = "aiapp_query_db_timestamp";
    public static final String EXTRA_AIAPP_START_TIMESTAMP = "aiapp_start_timestamp";
    private static final String EXT_APPID_KEY = "appid";
    private static final String EXT_MOBILE = "mobile";
    private static final String EXT_NET_KEY = "net";
    private static final String EXT_SWAN_JS_VERSION = "swan";
    public static final String EXT_SWAN_PRELOAD = "preload";
    public static final String ID_PERFORMANCED_FLOW = "670";
    public static final String ID_STABILITY = "671";
    public static final String SOURCE_DEFAULT = "NA";
    public static final String SOURCE_NA = "NA";
    public static final String STABILITY_PAGE_PACKAGE_CONFIG_INVALID = "appjson_config_invalid";
    private static final String TAG = "AiAppsPerformanceUBC";
    public static final String UBC_SWAN_VALUE = "swan";
    private static HybridUbcFlow sFlowSession;
    private static HybridUbcFlow sFlowSessionPreLoad;

    private AiAppsPerformanceUBC() {
    }

    public static void onEvent(Event event) {
        o.i(event.eventId, event.toJSONObject());
    }

    public static synchronized HybridUbcFlow requireSession() {
        HybridUbcFlow hybridUbcFlow;
        synchronized (AiAppsPerformanceUBC.class) {
            if (sFlowSession == null) {
                sFlowSession = new HybridUbcFlow(ID_PERFORMANCED_FLOW).putValue("from", "swan").reporter(new StartupReporter());
            }
            hybridUbcFlow = sFlowSession;
        }
        return hybridUbcFlow;
    }

    public static synchronized void resetSession() {
        synchronized (AiAppsPerformanceUBC.class) {
            sFlowSession = null;
        }
    }

    public static synchronized HybridUbcFlow requireSessionPreload() {
        HybridUbcFlow hybridUbcFlow;
        synchronized (AiAppsPerformanceUBC.class) {
            if (sFlowSessionPreLoad == null) {
                sFlowSessionPreLoad = new HybridUbcFlow(ID_PERFORMANCED_FLOW);
            }
            hybridUbcFlow = sFlowSessionPreLoad;
        }
        return hybridUbcFlow;
    }

    public static synchronized void resetSessionPreload() {
        synchronized (AiAppsPerformanceUBC.class) {
            sFlowSessionPreLoad = null;
        }
    }

    public static synchronized void mergeSession() {
        synchronized (AiAppsPerformanceUBC.class) {
            if (sFlowSessionPreLoad != null) {
                sFlowSessionPreLoad.updateFinalEvents();
                requireSession().record(sFlowSessionPreLoad.mFinalEvents);
                resetSessionPreload();
            }
        }
    }

    public static void recordFromLaunchInfo(AiAppsLaunchInfo aiAppsLaunchInfo) {
        Bundle bundle;
        if (aiAppsLaunchInfo != null && (bundle = aiAppsLaunchInfo.mExtraData) != null) {
            recordFromExtra(bundle, EXTRA_AIAPP_START_TIMESTAMP, ACTION_NA_START);
            recordFromExtra(bundle, EXTRA_AIAPP_APS_CHECK_START_TIMESTAMP, ACTION_APS_START_REQ);
            recordFromExtra(bundle, EXTRA_AIAPP_APS_CHECK_END_TIMESTAMP, ACTION_APS_END_REQ);
            recordFromExtra(bundle, EXTRA_AIAPP_APS_DOWNLOAD_START_TIMESTAMP, ACTION_APS_START_DOWNLOAD);
            recordFromExtra(bundle, EXTRA_AIAPP_APS_UNZIP_START_TIMESTAMP, ACTION_PACKAGE_START_UNZIP);
            recordFromExtra(bundle, EXTRA_AIAPP_APS_UNZIP_END_TIMESTAMP, ACTION_PACKAGE_END_UNZIP);
            recordFromExtra(bundle, EXTRA_AIAPP_APS_DECRYPT_START_TIMESTAMP, ACTION_PACKAGE_START_DECRYPT);
            recordFromExtra(bundle, EXTRA_AIAPP_APS_DECRYPT_END_TIMESTAMP, ACTION_PACKAGE_END_DECRYPT);
            recordFromExtra(bundle, EXTRA_AIAPP_PRE_CREATE_CHECK_TIMESTAMP, ACTION_PRE_CREATE_CHECK);
            recordFromExtra(bundle, EXTRA_AIAPP_PRE_CREATE_OK_TIMESTAMP, ACTION_PRE_CREATE_OK);
            recordFromExtra(bundle, EXTRA_AIAPP_LAUNCH_ACTIVITY_TIMESTAMP, ACTION_LAUNCH_ACTIVITY);
            recordFromExtra(bundle, EXTRA_AIAPP_QUERY_DB_TIMESTAMP, ACTION_QUERY_DB_ACTIVITY);
            String str = recordFromExtra(bundle, EXTRA_AIAPP_APS_DOWNLOAD_END_TIMESTAMP, ACTION_APS_END_DOWNLOAD) ? "0" : "1";
            String str2 = TextUtils.isEmpty(aiAppsLaunchInfo.mLaunchFrom) ? "NA" : aiAppsLaunchInfo.mLaunchFrom;
            HybridUbcFlow requireSession = requireSession();
            requireSession.putValue("from", "swan");
            requireSession.putValue("type", str);
            requireSession.putValue("source", str2);
            requireSession.putExt("appid", aiAppsLaunchInfo.mAppId);
            requireSession.putExt("swan", AiAppsSwanCoreManager.getSwanCoreVersionString(aiAppsLaunchInfo.mSwanCoreVersion));
            requireSession.putExt("mobile", AiAppsRuntime.getAiAppAccountRuntime().getDeviceInfo());
            requireSession.putExt(EXT_NET_KEY, AiAppNetworkUtils.getNetworkType().type);
        }
    }

    private static boolean recordFromExtra(@NonNull Bundle bundle, String str, String str2) {
        long j = bundle.getLong(str, -1L);
        if (j > 0) {
            requireSession().record(new UbcFlowEvent(str2).time(j));
            return true;
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public static class Event extends AiAppsUBCStatistic.AiAppsUBCEvent {
        public static final String EXT_INFO_KEY = "info";
        private static final String EXT_INFO_STACK_TRACE_KEY = "stacktrace";
        private static int MAX_STACK_TRACE_RECORD_ROW_COUNT = 35;
        final String eventId;
        public JSONObject mInfo;
        private boolean mStackTraceEnabled = true;

        public Event(String str) {
            this.eventId = str;
        }

        public Event from(String str) {
            this.mFrom = str;
            return this;
        }

        public Event type(String str) {
            this.mType = str;
            return this;
        }

        public Event page(String str) {
            this.mPage = str;
            return this;
        }

        public Event source(String str) {
            this.mSource = str;
            return this;
        }

        public Event value(String str) {
            this.mValue = str;
            return this;
        }

        public Event appId(String str) {
            this.mAppId = str;
            return this;
        }

        public Event info(JSONObject jSONObject) {
            this.mInfo = jSONObject;
            return this;
        }

        public Event enableStackTrace(boolean z) {
            this.mStackTraceEnabled = z;
            return this;
        }

        public Event infoAdd(String str, String str2) {
            if (str != null && str2 != null) {
                if (this.mInfo == null) {
                    this.mInfo = new JSONObject();
                }
                try {
                    this.mInfo.put(str, str2);
                } catch (JSONException e) {
                }
            }
            return this;
        }

        public Event launchParams(AiAppsLaunchParams aiAppsLaunchParams) {
            if (aiAppsLaunchParams != null) {
                if (!TextUtils.isEmpty(aiAppsLaunchParams.mFrom)) {
                    source(aiAppsLaunchParams.mFrom);
                }
                if (!TextUtils.isEmpty(aiAppsLaunchParams.mAppId)) {
                    appId(aiAppsLaunchParams.mAppId);
                }
            }
            return this;
        }

        public Event launchInfo(AiAppsLaunchInfo aiAppsLaunchInfo) {
            if (aiAppsLaunchInfo != null) {
                if (!TextUtils.isEmpty(aiAppsLaunchInfo.mLaunchFrom)) {
                    source(aiAppsLaunchInfo.mLaunchFrom);
                }
                if (!TextUtils.isEmpty(aiAppsLaunchInfo.mAppId)) {
                    appId(aiAppsLaunchInfo.mAppId);
                }
            }
            return this;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic.AiAppsUBCEvent
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            return super.toJSONObject();
        }

        @Override // com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic.AiAppsUBCEvent
        public JSONObject genExt() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.mInfo != null) {
                    if (this.mStackTraceEnabled) {
                        String stackTrace = AiAppsUtils.getStackTrace(MAX_STACK_TRACE_RECORD_ROW_COUNT);
                        if (!TextUtils.isEmpty(stackTrace)) {
                            this.mInfo.put(EXT_INFO_STACK_TRACE_KEY, stackTrace);
                        }
                    }
                    jSONObject.put("info", this.mInfo);
                }
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }
}
