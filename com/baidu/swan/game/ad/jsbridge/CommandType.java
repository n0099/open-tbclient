package com.baidu.swan.game.ad.jsbridge;

import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
/* loaded from: classes4.dex */
public enum CommandType {
    ACTION_URL("setActionUrl"),
    GET_CONFS("getConfs"),
    PRINT_LOG("printLog"),
    PAUSE_DOWNLOAD("pauseDownload"),
    GET_DOWNLOAD_STATUS("getDownloadStatus"),
    INSTALL_APP("installApp"),
    GET_APP_STATUS("getAppStatus"),
    OPEN_APP("openApp"),
    BANNER_VIEW(SpeedStatsUtils.UBC_VALUE_BANNER),
    DOWNLOAD_PERMISSION_CLICK("setPermissionActionUrl"),
    DOWNLOAD_PRIVACY_CLICK("setPrivacyActionUrl"),
    UNSPECIFIED("");
    
    public final String mJavascriptString;

    CommandType(String str) {
        this.mJavascriptString = str;
    }

    public static CommandType fromJavascriptString(String str) {
        CommandType[] values;
        for (CommandType commandType : values()) {
            if (commandType.mJavascriptString.equals(str)) {
                return commandType;
            }
        }
        return UNSPECIFIED;
    }

    public String toJavascriptString() {
        return this.mJavascriptString;
    }
}
