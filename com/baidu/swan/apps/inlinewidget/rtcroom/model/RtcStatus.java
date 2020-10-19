package com.baidu.swan.apps.inlinewidget.rtcroom.model;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.mapapi.SDKInitializer;
/* loaded from: classes10.dex */
public enum RtcStatus {
    UNKNOWN(-1, RomUtils.UNKNOWN),
    LOCAL_JOIN(1001, "LOCAL_JOIN"),
    REMOTE_USER_JOIN(1002, "REMOTE_USER_JOIN"),
    REMOTE_USER_LEAVE(1003, "REMOTE_USER_LEAVE"),
    REMOTE_STREAM_ADD(2001, "REMOTE_STREAM_ADD"),
    REMOTE_STREAM_REMOVE(2002, "REMOTE_STREAM_REMOVE"),
    ACTIVITY_IS_NULL(com.baidu.sapi2.share.b.h, "login fail : execute fail"),
    INIT_RTC_SDK_FAIL(com.baidu.sapi2.share.b.h, "login fail : init rtc sdk fail"),
    SO_DOWNLOAD_FAILED(com.baidu.sapi2.share.b.h, "login fail : so download failed"),
    SO_LOADING_FAILED(com.baidu.sapi2.share.b.h, "login fail : so load failed"),
    LOGIN_ERROR(com.baidu.sapi2.share.b.h, "login fail : error"),
    LOGIN_TIMEOUT(com.baidu.sapi2.share.b.h, "login fail : timeout"),
    ROOM_ALREADY_EXIST(20002, "ROOM_ALREADY_EXIST"),
    DEVICE_IS_NOT_SUPPORTED(20003, "DEVICE_IS_NOT_SUPPORTED"),
    ROOM_CONNECTION_LOST(30001, "ROOM_CONNECTION_LOST"),
    MEDIA_CONNECTION_LOST(30002, "MEDIA_CONNECTION_LOST"),
    INIT_CAPTURE_FAIL(40001, "OPEN_CAMERA_FAIL"),
    SET_REMOTE_SURFACE_ERROR(40002, "REMOTE_ITEM_ALREADY_PLAYING"),
    PUBLISH_FAILED(40003, "PUBLISH_FAIL"),
    AUTHORIZE_ERR_INTERNAL_ERROR(10001, "internal error"),
    AUTHORIZE_ERR_NETWORK_ERROR(10002, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR),
    AUTHORIZE_ERR_USER_DENY(10003, "user deny"),
    AUTHORIZE_ERR_USER_NOT_LOGIN(10004, "user not logged in"),
    AUTHORIZE_ERR_NO_DATA(10006, "no data"),
    AUTHORIZE_ERR_SYSTEM_DENY(10005, "system deny"),
    AUTHORIZE_TYPE_CAMERA_DENY(10005, "authorize camera failed : system deny"),
    AUTHORIZE_TYPE_RECORD_DENY(10005, "authorize recorder failed : system deny"),
    AUTHORIZE_TYPE_CAMERA_RECORD_DENY(10005, "authorize camera and recorder failed : system deny"),
    AUTHORIZE_TYPE_IGNORE(10001, "internal error"),
    AUTHORIZE_TYPE_GRANT(10009, "AUTHORIZE_TYPE_GRANT");
    
    private static final long serialVersionUID = 1;
    private int mCode;
    private String mMsg;

    RtcStatus(int i, String str) {
        this.mCode = i;
        this.mMsg = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "code:" + this.mCode + ",msg:" + this.mMsg;
    }
}
