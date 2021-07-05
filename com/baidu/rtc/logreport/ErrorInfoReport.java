package com.baidu.rtc.logreport;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.rtc.CommonDefine;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ErrorInfoReport {
    public static /* synthetic */ Interceptable $ic;
    public static ErrorInfoReport instance;
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public String clientIp;
    public int code;
    public String device;
    public String env;
    public String message;
    public long publisherHandleId;
    public long roomId;
    public Map<BigInteger, String> serverIpMap;
    public long sessionId;
    public long userId;
    public long value;
    public String version;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ErrorCode {
        public static final /* synthetic */ ErrorCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ErrorCode ANCHOR_LIVE_INTRERRUPT;
        public static final ErrorCode ANCHOR_LIVE_PUBLISH_FAIL;
        public static final ErrorCode AUDIO_SENDING_MEDIA_FAILED;
        public static final ErrorCode AUDIO_STUCK;
        public static final ErrorCode BAD_END_TO_END_DELAY;
        public static final ErrorCode BAD_FIRST_FRAME_TIME;
        public static final ErrorCode ENTER_FAILED;
        public static final ErrorCode ENTER_TIMEOUT;
        public static final ErrorCode HANG_UP;
        public static final ErrorCode KEEPALIVE_TIMEOUT;
        public static final ErrorCode LOGIN_ERROR;
        public static final ErrorCode LOGIN_TIMEOUT;
        public static final ErrorCode MEDIA_CHANNEL_CONNECTION_LOST;
        public static final ErrorCode OTHER_ERROR;
        public static final ErrorCode PEERCONNECTION_CREATE_ERROR;
        public static final ErrorCode ROOM_LIVE_INTRERRUPT;
        public static final ErrorCode ROOM_LIVE_PUBLISH_FAIL;
        public static final ErrorCode SET_EXTERNAL_SURFACE_ERROR;
        public static final ErrorCode SIGNAL_CHANNEL_CONNECTION_LOST;
        public static final ErrorCode SO_LATER_DOWNLOADING_FAIL;
        public static final ErrorCode SO_LATER_LOADING_FAIL;
        public static final ErrorCode USR_ALREADY_EXIST;
        public static final ErrorCode VIDEO_SENDING_MEDIA_FAILED;
        public static final ErrorCode VIDEO_STUCK;
        public transient /* synthetic */ FieldHolder $fh;
        public int code;
        public String message;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-517688525, "Lcom/baidu/rtc/logreport/ErrorInfoReport$ErrorCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-517688525, "Lcom/baidu/rtc/logreport/ErrorInfoReport$ErrorCode;");
                    return;
                }
            }
            LOGIN_ERROR = new ErrorCode("LOGIN_ERROR", 0, 102, "LOGIN_ERROR");
            LOGIN_TIMEOUT = new ErrorCode("LOGIN_TIMEOUT", 1, 102, "LOGIN_TIMEOUT");
            SIGNAL_CHANNEL_CONNECTION_LOST = new ErrorCode("SIGNAL_CHANNEL_CONNECTION_LOST", 2, 103, "SIGNAL_CHANNEL_CONNECTION_LOST");
            ROOM_LIVE_PUBLISH_FAIL = new ErrorCode("ROOM_LIVE_PUBLISH_FAIL", 3, 117, "ROOM_LIVE_PUBLISH_FAIL");
            ANCHOR_LIVE_PUBLISH_FAIL = new ErrorCode("ANCHOR_LIVE_PUBLISH_FAIL", 4, 117, "ANCHOR_LIVE_PUBLISH_FAIL");
            ROOM_LIVE_INTRERRUPT = new ErrorCode("ROOM_LIVE_INTRERRUPT", 5, 118, "ROOM_LIVE_INTRERRUPT");
            ANCHOR_LIVE_INTRERRUPT = new ErrorCode("ANCHOR_LIVE_INTRERRUPT", 6, 118, "ANCHOR_LIVE_INTRERRUPT");
            VIDEO_SENDING_MEDIA_FAILED = new ErrorCode("VIDEO_SENDING_MEDIA_FAILED", 7, 201, "VIDEO_SENDING_MEDIA_FAILED");
            AUDIO_SENDING_MEDIA_FAILED = new ErrorCode("AUDIO_SENDING_MEDIA_FAILED", 8, 201, "AUDIO_SENDING_MEDIA_FAILED");
            PEERCONNECTION_CREATE_ERROR = new ErrorCode("PEERCONNECTION_CREATE_ERROR", 9, 202, "PEERCONNECTION_CREATE_ERROR");
            MEDIA_CHANNEL_CONNECTION_LOST = new ErrorCode("MEDIA_CHANNEL_CONNECTION_LOST", 10, 203, "MEDIA_CHANNEL_CONNECTION_LOST");
            SO_LATER_DOWNLOADING_FAIL = new ErrorCode("SO_LATER_DOWNLOADING_FAIL", 11, 400, "SO_LATER_DOWNLOADING_FAIL");
            SO_LATER_LOADING_FAIL = new ErrorCode("SO_LATER_LOADING_FAIL", 12, 401, "SO_LATER_LOADING_FAIL");
            KEEPALIVE_TIMEOUT = new ErrorCode("KEEPALIVE_TIMEOUT", 13, 402, "KEEPALIVE_TIMEOUT");
            USR_ALREADY_EXIST = new ErrorCode("USR_ALREADY_EXIST", 14, 436, "USR_ALREADY_EXIST");
            HANG_UP = new ErrorCode("HANG_UP", 15, 440, "HANG_UP");
            SET_EXTERNAL_SURFACE_ERROR = new ErrorCode("SET_EXTERNAL_SURFACE_ERROR", 16, 600, "SET_EXTERNAL_SURFACE_ERROR");
            OTHER_ERROR = new ErrorCode("OTHER_ERROR", 17, 700, "OTHER_ERROR");
            ENTER_FAILED = new ErrorCode(CommonDefine.SLILoginEvent.ENTER_FAILED, 18, 7000, CommonDefine.SLILoginEvent.ENTER_FAILED);
            ENTER_TIMEOUT = new ErrorCode(CommonDefine.SLILoginEvent.ENTER_TIMEOUT, 19, 7000, CommonDefine.SLILoginEvent.ENTER_TIMEOUT);
            AUDIO_STUCK = new ErrorCode("AUDIO_STUCK", 20, ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, "AUDIO_STUCK");
            VIDEO_STUCK = new ErrorCode("VIDEO_STUCK", 21, 7002, "VIDEO_STUCK");
            BAD_END_TO_END_DELAY = new ErrorCode("BAD_END_TO_END_DELAY", 22, 7003, "BAD_END_TO_END_DELAY");
            ErrorCode errorCode = new ErrorCode("BAD_FIRST_FRAME_TIME", 23, 7004, "BAD_FIRST_FRAME_TIME");
            BAD_FIRST_FRAME_TIME = errorCode;
            $VALUES = new ErrorCode[]{LOGIN_ERROR, LOGIN_TIMEOUT, SIGNAL_CHANNEL_CONNECTION_LOST, ROOM_LIVE_PUBLISH_FAIL, ANCHOR_LIVE_PUBLISH_FAIL, ROOM_LIVE_INTRERRUPT, ANCHOR_LIVE_INTRERRUPT, VIDEO_SENDING_MEDIA_FAILED, AUDIO_SENDING_MEDIA_FAILED, PEERCONNECTION_CREATE_ERROR, MEDIA_CHANNEL_CONNECTION_LOST, SO_LATER_DOWNLOADING_FAIL, SO_LATER_LOADING_FAIL, KEEPALIVE_TIMEOUT, USR_ALREADY_EXIST, HANG_UP, SET_EXTERNAL_SURFACE_ERROR, OTHER_ERROR, ENTER_FAILED, ENTER_TIMEOUT, AUDIO_STUCK, VIDEO_STUCK, BAD_END_TO_END_DELAY, errorCode};
        }

        public ErrorCode(String str, int i2, int i3, String str2) {
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
            this.code = i3;
            this.message = str2;
        }

        public static ErrorCode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ErrorCode) Enum.valueOf(ErrorCode.class, str) : (ErrorCode) invokeL.objValue;
        }

        public static ErrorCode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ErrorCode[]) $VALUES.clone() : (ErrorCode[]) invokeV.objValue;
        }

        public int getErrorCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
        }

        public String getMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.message : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2047405916, "Lcom/baidu/rtc/logreport/ErrorInfoReport;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2047405916, "Lcom/baidu/rtc/logreport/ErrorInfoReport;");
        }
    }

    public ErrorInfoReport() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.serverIpMap = new ConcurrentHashMap();
    }

    public static ErrorInfoReport getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (instance == null) {
                instance = new ErrorInfoReport();
            }
            return instance;
        }
        return (ErrorInfoReport) invokeV.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appId : (String) invokeV.objValue;
    }

    public String getClientIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.clientIp : (String) invokeV.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.code : invokeV.intValue;
    }

    public String getDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.device : (String) invokeV.objValue;
    }

    public String getEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.env : (String) invokeV.objValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    public long getPublishHandleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.publisherHandleId : invokeV.longValue;
    }

    public long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.roomId : invokeV.longValue;
    }

    public long getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.sessionId : invokeV.longValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.userId : invokeV.longValue;
    }

    public long getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.value : invokeV.longValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.version : (String) invokeV.objValue;
    }

    public void putServerMap(BigInteger bigInteger, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bigInteger, str) == null) {
            this.serverIpMap.put(bigInteger, str);
        }
    }

    public void reportErrorInfo(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, errorCode) == null) {
            reportErrorInfo(errorCode, -1L, this.serverIpMap.get(BigInteger.valueOf(this.publisherHandleId)), -1L, this.publisherHandleId);
        }
    }

    public void reportErrorInfo(ErrorCode errorCode, long j, String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{errorCode, Long.valueOf(j), str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("env", this.env);
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("version", this.version);
                jSONObject.put("device", RtcLogReport.getDeviceModel());
                jSONObject.put("clientIp", this.clientIp);
                jSONObject.put("serverIp", str);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.roomId);
                jSONObject.put("userId", this.userId);
                if (j2 > 0) {
                    jSONObject.put("feedId", j2);
                }
                jSONObject.put("sessionId", this.sessionId);
                jSONObject.put("handleId", j3);
                jSONObject.put("code", errorCode.getErrorCode());
                jSONObject.put("message", errorCode.getMessage());
                if (j > 0) {
                    jSONObject.put("value", j);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            RtcLogReport.getInstance().report(jSONObject.toString(), 4);
        }
    }

    public void reportErrorInfo(ErrorCode errorCode, long j, BigInteger bigInteger, BigInteger bigInteger2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{errorCode, Long.valueOf(j), bigInteger, bigInteger2}) == null) {
            reportErrorInfo(errorCode, j, this.serverIpMap.containsKey(bigInteger) ? this.serverIpMap.get(bigInteger) : "", bigInteger2.longValue(), bigInteger.longValue());
        }
    }

    public void resetParam() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.env = "";
            this.version = "";
            this.device = "";
            this.clientIp = "";
            this.appId = "";
            this.roomId = -1L;
            this.userId = -1L;
            this.sessionId = -1L;
            this.publisherHandleId = -1L;
            this.code = 700;
            this.message = "";
            this.value = -1L;
            this.serverIpMap.clear();
        }
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.appId = str;
        }
    }

    public void setClientIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.clientIp = str;
        }
    }

    public void setCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.code = i2;
        }
    }

    public void setDevice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.device = str;
        }
    }

    public void setEnv(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.env = str;
        }
    }

    public void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.message = str;
        }
    }

    public void setPublishHandleId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.publisherHandleId = j;
        }
    }

    public void setRoomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.roomId = j;
        }
    }

    public void setSessionId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.sessionId = j;
        }
    }

    public void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            this.userId = j;
        }
    }

    public void setValue(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.value = j;
        }
    }

    public void setVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.version = str;
        }
    }
}
