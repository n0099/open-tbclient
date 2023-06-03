package com.baidu.searchbox.yy.gameassist;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b/\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0002\"\u0016\u0010\u0006\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0002\"\u0016\u0010\u0007\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0002\"\u0016\u0010\b\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0002\"\u0016\u0010\t\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0002\"\u0016\u0010\n\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0002\"\u0016\u0010\u000b\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0002\"\u0016\u0010\f\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0002\"\u0016\u0010\r\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0002\"\u0016\u0010\u000e\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0002\"\u0016\u0010\u000f\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0002\"\u0016\u0010\u0010\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0002\"\u0016\u0010\u0011\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0002\"\u0016\u0010\u0012\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0002\"\u0016\u0010\u0013\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0002\"\u0016\u0010\u0014\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0002\"\u0016\u0010\u0015\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0002\"\u0016\u0010\u0016\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0002\"\u0016\u0010\u0017\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0002\"\u0016\u0010\u0018\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0002\"\u0016\u0010\u0019\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0002\"\u0016\u0010\u001a\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0002\"\u0016\u0010\u001b\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0002\"\u0016\u0010\u001c\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0002\"\u0016\u0010\u001d\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0002\"\u0016\u0010\u001e\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0002\"\u0016\u0010\u001f\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0002\"\u0016\u0010 \u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0002\"\u0016\u0010!\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0002\"\u0016\u0010\"\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0002\"\u0016\u0010#\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0002\"\u0016\u0010$\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0002\"\u0016\u0010%\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0002\"\"\u0010&\u001a\u00020\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0002\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\"\u0016\u0010+\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\u0002\"\u0016\u0010,\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\u0002\"\u0016\u0010-\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010\u0002\"\u0016\u0010.\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\u0002¨\u0006/"}, d2 = {"", "KEY_CALLBACK_TYPE", "Ljava/lang/String;", "KEY_CONTENT", "KEY_CONTINUATION_HASH", "KEY_DISK_NEW_STATE", "KEY_DISK_OLD_STATE", "KEY_DISK_QUOTA", "KEY_EXT", "KEY_ICONURL", "KEY_LINKURL", "KEY_METHOD", "KEY_NORMAL_RESULT", "KEY_PROGRESS", "KEY_REQUEST_PERMISSIONS", "KEY_RESULT_ERROR_REASON", "KEY_TITLE", "METHOD_CLEAR_ALL_CACHE", "METHOD_DISK_CLEAR_CACHE_CHANGE", "METHOD_GET_ACCESSTOKEN", "METHOD_GET_LOCATION", "METHOD_MODIFY_PWD_PAGE", "METHOD_PRELOAD_BZ", "METHOD_PRELOAD_BZ_RETURN", "METHOD_REAL_NAME_PAGE", "METHOD_REQUEST_FLOAT_WINDOW", "METHOD_REQUEST_PERMISSIONS", "METHOD_START_SHARE", "PROCESS_NAME", "RESULT_ERROR", "RESULT_GET_ACCESSTOKEN_TOKEN", "RESULT_GRANTED", "RESULT_IN_PROGRESS", "RESULT_LOCATION_INFO", "RESULT_MODIFY_PWD_MSG", "RESULT_REAL_NAME_STATUS_CODE", "RESULT_SHARE_MSG", "RESULT_SUCCESS", "SUB_PROCESS_PROVIDER", "getSUB_PROCESS_PROVIDER", "()Ljava/lang/String;", "setSUB_PROCESS_PROVIDER", "(Ljava/lang/String;)V", "TYPE_CALLBACK_CANCEL", "TYPE_CALLBACK_COMPLETE", "TYPE_CALLBACK_ERROR", "TYPE_CALLBACK_ITEMCLICKED", "lib-gameassist-host_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class GameAssistConstKt {
    public static final String KEY_CALLBACK_TYPE = "callbackType";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_CONTINUATION_HASH = "continuation_hash";
    public static final String KEY_DISK_NEW_STATE = "newState";
    public static final String KEY_DISK_OLD_STATE = "oldState";
    public static final String KEY_DISK_QUOTA = "quota";
    public static final String KEY_EXT = "ext";
    public static final String KEY_ICONURL = "iconUrl";
    public static final String KEY_LINKURL = "linkUrl";
    public static final String KEY_METHOD = "method";
    public static final String KEY_NORMAL_RESULT = "normal_result";
    public static final String KEY_PROGRESS = "preload_progress";
    public static final String KEY_REQUEST_PERMISSIONS = "permissions";
    public static final String KEY_RESULT_ERROR_REASON = "errorReason";
    public static final String KEY_TITLE = "title";
    public static final String METHOD_CLEAR_ALL_CACHE = "clearLiveResourceSize";
    public static final String METHOD_DISK_CLEAR_CACHE_CHANGE = "onDiskClearCacheChange";
    public static final String METHOD_GET_ACCESSTOKEN = "getAccessToken";
    public static final String METHOD_GET_LOCATION = "getLocation";
    public static final String METHOD_MODIFY_PWD_PAGE = "openModifyPwd";
    public static final String METHOD_PRELOAD_BZ = "preloadBZ";
    public static final String METHOD_PRELOAD_BZ_RETURN = "preloadBZResult";
    public static final String METHOD_REAL_NAME_PAGE = "openRealNamePage";
    public static final String METHOD_REQUEST_FLOAT_WINDOW = "requestFloatWindow";
    public static final String METHOD_REQUEST_PERMISSIONS = "requestPermission";
    public static final String METHOD_START_SHARE = "startShare";
    public static final String PROCESS_NAME = "gameassist";
    public static final String RESULT_ERROR = "error";
    public static final String RESULT_GET_ACCESSTOKEN_TOKEN = "accesstoken";
    public static final String RESULT_GRANTED = "isGrant";
    public static final String RESULT_IN_PROGRESS = "InProgress";
    public static final String RESULT_LOCATION_INFO = "locationInfo";
    public static final String RESULT_MODIFY_PWD_MSG = "resultMsg";
    public static final String RESULT_REAL_NAME_STATUS_CODE = "statusCode";
    public static final String RESULT_SHARE_MSG = "msg";
    public static final String RESULT_SUCCESS = "success";
    public static String SUB_PROCESS_PROVIDER = DownloadConstants.LOCAL_DATA_URI_PREFIX + ((AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE())).getPackageName() + ".GameAssistProvider";
    public static final String TYPE_CALLBACK_CANCEL = "onCancel";
    public static final String TYPE_CALLBACK_COMPLETE = "onComplete";
    public static final String TYPE_CALLBACK_ERROR = "onError";
    public static final String TYPE_CALLBACK_ITEMCLICKED = "onItemClicked";

    public static final String getSUB_PROCESS_PROVIDER() {
        return SUB_PROCESS_PROVIDER;
    }

    public static final void setSUB_PROCESS_PROVIDER(String str) {
        SUB_PROCESS_PROVIDER = str;
    }
}
