package com.baidu.mobads.container.bridge;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public enum CommandType {
    DOWNLOAD_PERMISSION_CLICK("setPermissionActionUrl"),
    DOWNLOAD_PRIVACY_CLICK("setPrivacyActionUrl"),
    HANDLE_PLAY_CLICK("handlePlayClick"),
    GET_ID_FROME_NATIVE("getIdFromNative"),
    SET_ACTION_URL("setActionUrl") { // from class: com.baidu.mobads.container.bridge.CommandType.1
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    GET_CONFS("getConfs"),
    ON_INITED("onInited"),
    GET_ADVIEW_STATE("getAdViewState"),
    PRINT_LOG("printLog"),
    SET_APP_TIP("setAppTip"),
    PAUSE_DOWNLOAD("pauseDownload"),
    GET_DOWNLOAD_STATUS("getDownloadStatus"),
    INSTALL_APP("installApp") { // from class: com.baidu.mobads.container.bridge.CommandType.2
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    GET_APP_STATUS("getAppStatus"),
    OPEN_APP("openApp") { // from class: com.baidu.mobads.container.bridge.CommandType.3
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    GET_WIFI_SCANS("getWifiScans"),
    GET_VERSION_CODE_BY_PKG("getVersionCodeByPkg"),
    GET_INSTALLED("getInstalled"),
    GET_RECENT_DIFF("getRecentDiff"),
    GET_RECENT_ALL("getRecentAll"),
    GET_CURRENT_APP("getCurrentApp"),
    GET_SYS_INSTALLED("getSysInstalled"),
    CONFIRM("confirm") { // from class: com.baidu.mobads.container.bridge.CommandType.4
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    ON_AD_FALED("onAdFailed"),
    ON_AD_SHOW("onAdShow"),
    ON_AD_SWITCH("onAdSwitch"),
    SET_VISIBILITY("setVisibility"),
    GET_ACTIVE_TYPE("getActiveType"),
    ON_INTERSTITIAL_PRELOAD_END("onInterstitialPreloadEnd"),
    ON_AD_PLAY_END("onAdPlayEnd"),
    PLAY_VIDEO_FOR_INTERSTITIAL("playVideoForInterstitial"),
    CLOSE(IntentConfig.CLOSE),
    EXPAND("expand") { // from class: com.baidu.mobads.container.bridge.CommandType.5
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    USE_CUSTOM_CLOSE("useCustomClose"),
    OPEN("open") { // from class: com.baidu.mobads.container.bridge.CommandType.6
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    RESIZE("resize") { // from class: com.baidu.mobads.container.bridge.CommandType.7
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO("playVideo") { // from class: com.baidu.mobads.container.bridge.CommandType.8
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    STORE_PICTURE("storePicture") { // from class: com.baidu.mobads.container.bridge.CommandType.9
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    CREATE_CALENDAR_EVENT("createCalendarEvent") { // from class: com.baidu.mobads.container.bridge.CommandType.10
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    PLAY_GAME("playGame") { // from class: com.baidu.mobads.container.bridge.CommandType.11
        @Override // com.baidu.mobads.container.bridge.CommandType
        public boolean requiresClick(PlacementType placementType) {
            return true;
        }
    },
    UNSPECIFIED("");
    
    public final String mJavascriptString;

    public static CommandType fromJavascriptString(String str) {
        CommandType[] values;
        for (CommandType commandType : values()) {
            if (commandType.mJavascriptString.equals(str)) {
                return commandType;
            }
        }
        return UNSPECIFIED;
    }

    public boolean requiresClick(PlacementType placementType) {
        return false;
    }

    public String toJavascriptString() {
        return this.mJavascriptString;
    }

    CommandType(String str) {
        this.mJavascriptString = str;
    }
}
