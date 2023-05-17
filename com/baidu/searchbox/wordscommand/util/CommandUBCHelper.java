package com.baidu.searchbox.wordscommand.util;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.wordscommand.runtime.WordCommandRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommandUBCHelper {
    public static final String COMMAND_UBC_CONTENT = "share_token_content";
    public static final String COMMAND_UBC_ERROR_TYPE = "share_token_err_type";
    public static final String COMMAND_UBC_ERROR_TYPE_REPEAT = "repeat_error";
    public static final String COMMAND_UBC_ERROR_TYPE_SERVER = "server_error";
    public static final String COMMAND_UBC_LAUNCH_SCHEME = "launch_scheme";
    public static final String COMMAND_UBC_SHARE_TOKEN = "share_token";
    public static final String COMMAND_UBC_SOURCE_FAILED = "scanResultOther";
    public static final String COMMAND_UBC_SOURCE_RECEIVE = "get";
    public static final String COMMAND_UBC_SOURCE_SEND = "post";
    public static final String COMMAND_UBC_SOURCE_SUCCESS = "scanResultShare";
    public static final String COMMAND_UBC_STATISTICS_FROM_VALUE_TOOL = "tool";
    public static final String COMMAND_UBC_STATISTICS_SOURCE_VALUE_CANCEL = "cancel";
    public static final String COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT = "client";
    public static final String COMMAND_UBC_STATISTICS_SOURCE_VALUE_PASTE = "paste";
    public static final String COMMAND_UBC_STATISTICS_SOURCE_VALUE_SERVER = "server";
    public static final String COMMAND_UBC_STATISTICS_SOURCE_VALUE_VIEW = "view";
    public static final String COMMAND_UBC_STATISTICS_TYPE_VALUE_CLICK = "click";
    public static final String COMMAND_UBC_STATISTICS_TYPE_VALUE_REPEAT = "repeat";
    public static final String COMMAND_UBC_STATISTICS_TYPE_VALUE_SHOW = "show";
    public static final String COMMAND_UBC_TIME_END = "share_token_end";
    public static final String COMMAND_UBC_TIME_SERVER_ERROR = "share_token_err_server_end";
    public static final String COMMAND_UBC_TIME_START = "share_token_start";
    public static final String COMMAND_UBC_TYPE_CODESCAN = "codeScan";
    public static final String COMMAND_UBC_TYPE_CODE_LOG = "codelog";
    public static final String COMMAND_UBC_TYPE_COPY = "copy";
    public static final String COMMAND_UBC_TYPE_COUNT = "count";
    public static final String COMMAND_UBC_TYPE_SAVE = "save";
    public static final String COMMAND_UBC_VALUE_FAILED = "failed";
    public static final String COMMAND_UBC_VALUE_FALSE = "false";
    public static final String COMMAND_UBC_VALUE_SUCCESS = "succeed";
    public static final boolean DEBUG = WordCommandRuntime.DEBUG;
    public static final String PICTURE_COMMAND = "899";
    public static final String PICTURE_COMMAND_PARSE = "898";
    public static final String TAG = "WordCommandManager";
    public static final String WORD_COMMAND_BUILD_DIALOG = "620";
    public static final String WORD_COMMAND_PARSE_DIALOG = "621";

    public static void executeWordCommandUbcStatistics(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("from", "tool");
            jSONObject2.putOpt("type", str2);
            jSONObject2.putOpt("source", str3);
            jSONObject2.putOpt("page", str4);
            jSONObject2.putOpt("ext", jSONObject);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                Log.d("WordCommandManager", "WordCommandManager" + e);
            }
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject2.toString());
        if (DEBUG) {
            Log.d("WordCommandManager", "WordCommandManager UBC.onEvent(): " + jSONObject2);
        }
    }

    public static void ubcStatistics(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("from", "tool");
            jSONObject2.putOpt("type", str2);
            jSONObject2.putOpt("source", str3);
            jSONObject2.putOpt("value", str4);
            jSONObject2.putOpt("ext", jSONObject);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                Log.d("WordCommandManager", "WordCommandManager" + e);
            }
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject2.toString());
        if (DEBUG) {
            Log.d("WordCommandManager", "ubcStatistics UBC.onEvent(): " + jSONObject2);
        }
    }

    public static void ubcStatisticsWithValue(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("from", "tool");
            jSONObject.putOpt("type", str2);
            jSONObject.putOpt("source", str3);
            jSONObject.putOpt("page", str4);
            jSONObject.putOpt("value", str5);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                Log.d("WordCommandManager", "WordCommandManager" + e);
            }
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject.toString());
        if (DEBUG) {
            Log.d("WordCommandManager", "WordCommandManager UBC.onEvent(): " + jSONObject);
        }
    }

    public static void ubcEvent(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("type", str2);
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject);
        } catch (Exception unused) {
        }
    }
}
