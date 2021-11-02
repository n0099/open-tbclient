package com.baidu.swan.apps.inlinewidget.rtcroom.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class RtcStatus {
    public static final /* synthetic */ RtcStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final RtcStatus ACTIVITY_IS_NULL;
    public static final RtcStatus AUTHORIZE_ERR_INTERNAL_ERROR;
    public static final RtcStatus AUTHORIZE_ERR_NETWORK_ERROR;
    public static final RtcStatus AUTHORIZE_ERR_NO_DATA;
    public static final RtcStatus AUTHORIZE_ERR_SYSTEM_DENY;
    public static final RtcStatus AUTHORIZE_ERR_USER_DENY;
    public static final RtcStatus AUTHORIZE_ERR_USER_NOT_LOGIN;
    public static final RtcStatus AUTHORIZE_TYPE_CAMERA_DENY;
    public static final RtcStatus AUTHORIZE_TYPE_CAMERA_RECORD_DENY;
    public static final RtcStatus AUTHORIZE_TYPE_GRANT;
    public static final RtcStatus AUTHORIZE_TYPE_IGNORE;
    public static final RtcStatus AUTHORIZE_TYPE_RECORD_DENY;
    public static final RtcStatus DEVICE_IS_NOT_SUPPORTED;
    public static final RtcStatus INIT_CAPTURE_FAIL;
    public static final RtcStatus INIT_RTC_SDK_FAIL;
    public static final RtcStatus LOCAL_JOIN;
    public static final RtcStatus LOGIN_ERROR;
    public static final RtcStatus LOGIN_TIMEOUT;
    public static final RtcStatus MEDIA_CONNECTION_LOST;
    public static final RtcStatus PUBLISH_FAILED;
    public static final RtcStatus REMOTE_STREAM_ADD;
    public static final RtcStatus REMOTE_STREAM_REMOVE;
    public static final RtcStatus REMOTE_USER_JOIN;
    public static final RtcStatus REMOTE_USER_KICKOUT;
    public static final RtcStatus REMOTE_USER_LEAVE;
    public static final RtcStatus ROOM_ALREADY_EXIST;
    public static final RtcStatus ROOM_CONNECTION_LOST;
    public static final RtcStatus SET_REMOTE_SURFACE_ERROR;
    public static final RtcStatus SO_DOWNLOAD_FAILED;
    public static final RtcStatus SO_LOADING_FAILED;
    public static final RtcStatus UNKNOWN;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCode;
    public String mMsg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1369989862, "Lcom/baidu/swan/apps/inlinewidget/rtcroom/model/RtcStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1369989862, "Lcom/baidu/swan/apps/inlinewidget/rtcroom/model/RtcStatus;");
                return;
            }
        }
        UNKNOWN = new RtcStatus(RomUtils.UNKNOWN, 0, -1, RomUtils.UNKNOWN);
        LOCAL_JOIN = new RtcStatus("LOCAL_JOIN", 1, 1001, "LOCAL_JOIN");
        REMOTE_USER_JOIN = new RtcStatus("REMOTE_USER_JOIN", 2, 1002, "REMOTE_USER_JOIN");
        REMOTE_USER_LEAVE = new RtcStatus("REMOTE_USER_LEAVE", 3, 1003, "REMOTE_USER_LEAVE");
        REMOTE_USER_KICKOUT = new RtcStatus("REMOTE_USER_KICKOUT", 4, 1004, "REMOTE_USER_KICKOUT");
        REMOTE_STREAM_ADD = new RtcStatus("REMOTE_STREAM_ADD", 5, 2001, "REMOTE_STREAM_ADD");
        REMOTE_STREAM_REMOVE = new RtcStatus("REMOTE_STREAM_REMOVE", 6, 2002, "REMOTE_STREAM_REMOVE");
        ACTIVITY_IS_NULL = new RtcStatus("ACTIVITY_IS_NULL", 7, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, "login fail : execute fail");
        INIT_RTC_SDK_FAIL = new RtcStatus("INIT_RTC_SDK_FAIL", 8, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, "login fail : init rtc sdk fail");
        SO_DOWNLOAD_FAILED = new RtcStatus("SO_DOWNLOAD_FAILED", 9, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, "login fail : so download failed");
        SO_LOADING_FAILED = new RtcStatus("SO_LOADING_FAILED", 10, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, "login fail : so load failed");
        LOGIN_ERROR = new RtcStatus("LOGIN_ERROR", 11, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, "login fail : error");
        LOGIN_TIMEOUT = new RtcStatus("LOGIN_TIMEOUT", 12, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, "login fail : timeout");
        ROOM_ALREADY_EXIST = new RtcStatus("ROOM_ALREADY_EXIST", 13, 20002, "ROOM_ALREADY_EXIST");
        DEVICE_IS_NOT_SUPPORTED = new RtcStatus("DEVICE_IS_NOT_SUPPORTED", 14, 20003, "DEVICE_IS_NOT_SUPPORTED");
        ROOM_CONNECTION_LOST = new RtcStatus("ROOM_CONNECTION_LOST", 15, 30001, "ROOM_CONNECTION_LOST");
        MEDIA_CONNECTION_LOST = new RtcStatus("MEDIA_CONNECTION_LOST", 16, 30002, "MEDIA_CONNECTION_LOST");
        INIT_CAPTURE_FAIL = new RtcStatus("INIT_CAPTURE_FAIL", 17, 40001, "OPEN_CAMERA_FAIL");
        SET_REMOTE_SURFACE_ERROR = new RtcStatus("SET_REMOTE_SURFACE_ERROR", 18, 40002, "REMOTE_ITEM_ALREADY_PLAYING");
        PUBLISH_FAILED = new RtcStatus("PUBLISH_FAILED", 19, 40003, "PUBLISH_FAIL");
        AUTHORIZE_ERR_INTERNAL_ERROR = new RtcStatus("AUTHORIZE_ERR_INTERNAL_ERROR", 20, 10001, "internal error");
        AUTHORIZE_ERR_NETWORK_ERROR = new RtcStatus("AUTHORIZE_ERR_NETWORK_ERROR", 21, 10002, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        AUTHORIZE_ERR_USER_DENY = new RtcStatus("AUTHORIZE_ERR_USER_DENY", 22, 10003, "user deny");
        AUTHORIZE_ERR_USER_NOT_LOGIN = new RtcStatus("AUTHORIZE_ERR_USER_NOT_LOGIN", 23, 10004, "user not logged in");
        AUTHORIZE_ERR_NO_DATA = new RtcStatus("AUTHORIZE_ERR_NO_DATA", 24, 10006, "no data");
        AUTHORIZE_ERR_SYSTEM_DENY = new RtcStatus("AUTHORIZE_ERR_SYSTEM_DENY", 25, 10005, "system deny");
        AUTHORIZE_TYPE_CAMERA_DENY = new RtcStatus("AUTHORIZE_TYPE_CAMERA_DENY", 26, 10005, "authorize camera failed : system deny");
        AUTHORIZE_TYPE_RECORD_DENY = new RtcStatus("AUTHORIZE_TYPE_RECORD_DENY", 27, 10005, "authorize recorder failed : system deny");
        AUTHORIZE_TYPE_CAMERA_RECORD_DENY = new RtcStatus("AUTHORIZE_TYPE_CAMERA_RECORD_DENY", 28, 10005, "authorize camera and recorder failed : system deny");
        AUTHORIZE_TYPE_IGNORE = new RtcStatus("AUTHORIZE_TYPE_IGNORE", 29, 10001, "internal error");
        RtcStatus rtcStatus = new RtcStatus("AUTHORIZE_TYPE_GRANT", 30, 10009, "AUTHORIZE_TYPE_GRANT");
        AUTHORIZE_TYPE_GRANT = rtcStatus;
        $VALUES = new RtcStatus[]{UNKNOWN, LOCAL_JOIN, REMOTE_USER_JOIN, REMOTE_USER_LEAVE, REMOTE_USER_KICKOUT, REMOTE_STREAM_ADD, REMOTE_STREAM_REMOVE, ACTIVITY_IS_NULL, INIT_RTC_SDK_FAIL, SO_DOWNLOAD_FAILED, SO_LOADING_FAILED, LOGIN_ERROR, LOGIN_TIMEOUT, ROOM_ALREADY_EXIST, DEVICE_IS_NOT_SUPPORTED, ROOM_CONNECTION_LOST, MEDIA_CONNECTION_LOST, INIT_CAPTURE_FAIL, SET_REMOTE_SURFACE_ERROR, PUBLISH_FAILED, AUTHORIZE_ERR_INTERNAL_ERROR, AUTHORIZE_ERR_NETWORK_ERROR, AUTHORIZE_ERR_USER_DENY, AUTHORIZE_ERR_USER_NOT_LOGIN, AUTHORIZE_ERR_NO_DATA, AUTHORIZE_ERR_SYSTEM_DENY, AUTHORIZE_TYPE_CAMERA_DENY, AUTHORIZE_TYPE_RECORD_DENY, AUTHORIZE_TYPE_CAMERA_RECORD_DENY, AUTHORIZE_TYPE_IGNORE, rtcStatus};
    }

    public RtcStatus(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCode = i3;
        this.mMsg = str2;
    }

    public static RtcStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RtcStatus) Enum.valueOf(RtcStatus.class, str) : (RtcStatus) invokeL.objValue;
    }

    public static RtcStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RtcStatus[]) $VALUES.clone() : (RtcStatus[]) invokeV.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCode : invokeV.intValue;
    }

    public String getMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMsg : (String) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "code:" + this.mCode + ",msg:" + this.mMsg;
        }
        return (String) invokeV.objValue;
    }
}
