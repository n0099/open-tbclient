package com.baidu.android.imrtc.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public class RtcConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_IM_RTC_ACK = 102;
    public static final int ACTION_IM_RTC_ANSWER = 84;
    public static final int ACTION_IM_RTC_ANSWER_SYNC = 85;
    public static final int ACTION_IM_RTC_CANCEL_CALL = 94;
    public static final int ACTION_IM_RTC_CANCEL_CALL_SYNC = 95;
    public static final int ACTION_IM_RTC_CLIENT_REPORT = 110;
    public static final int ACTION_IM_RTC_CLOSE = 88;
    public static final int ACTION_IM_RTC_CLOSE_SYNC = 89;
    public static final int ACTION_IM_RTC_FETCH_ROOM_SIGNALING = 91;
    public static final int ACTION_IM_RTC_FETCH_ROOM_STATE = 90;
    public static final int ACTION_IM_RTC_HANGOUT = 86;
    public static final int ACTION_IM_RTC_HANGOUT_SYNC = 87;
    public static final int ACTION_IM_RTC_HEART_BEAT = 100;
    public static final int ACTION_IM_RTC_INVITE = 80;
    public static final int ACTION_IM_RTC_INVITE_SYNC = 81;
    public static final int ACTION_IM_RTC_JOIN = 92;
    public static final int ACTION_IM_RTC_JOIN_SYNC = 93;
    public static final int ACTION_IM_RTC_KICK_REQUEST = 104;
    public static final int ACTION_IM_RTC_KICK_REQUEST_SYNC = 105;
    public static final int ACTION_IM_RTC_KICK_RESPONSE = 106;
    public static final int ACTION_IM_RTC_KICK_RESPONSE_SYNC = 107;
    public static final int ACTION_IM_RTC_RING = 82;
    public static final int ACTION_IM_RTC_RING_SYNC = 83;
    public static final int ERROR_ACTION_ORDER = -2;
    public static final String EXTRA_RTC_ACTION_ID = "rtc_action_id";
    public static final String EXTRA_RTC_INFO = "rtc_info";
    public static final String EXTRA_RTC_ROOM_ID = "rtc_room_id";
    public static final int IM_RTC_1V1 = 1;
    public static final int IM_RTC_1VN = 2;
    public static final int IM_RTC_ANSWER_ABILITY_NO = 0;
    public static final int IM_RTC_ANSWER_ABILITY_OK = 1;
    public static final int IM_RTC_ANSWER_NO = 2;
    public static final int IM_RTC_ANSWER_OK = 1;
    public static final int IM_RTC_ANSWER_TIMEOUT = 3;
    public static final int IM_RTC_APP_STATE_BACK = 1;
    public static final int IM_RTC_APP_STATE_FRONT = 0;
    public static final int IM_RTC_KICKED_NO = 2;
    public static final int IM_RTC_KICKED_NONE = 0;
    public static final int IM_RTC_KICKED_OK = 1;
    public static final int IM_RTC_MEDIA_AUDIO = 1;
    public static final int IM_RTC_MEDIA_VIDEO = 2;
    public static volatile AtomicLong IM_RTC_SDK_SEQ_ID = null;
    public static volatile long IM_RTC_SERVER_SEQ_ID = 0;
    public static boolean LOG_DEBUG = false;
    public static final int METHOD_IM_RTC_MSG = 230;
    public static final int METHOD_IM_RTC_NOTIFY_MSG = 231;
    public static int RTC_HEART_BEAT_RETRY_TIME = 3;
    public static int RTC_HEART_BEAT_STATUS = 0;
    public static final int RTC_HEART_BEAT_STATUS_IN_ROOM = 1;
    public static final int RTC_HEART_BEAT_STATUS_NOT_IN_ROOM = 0;
    public static long RTC_HEART_BEAT_TIME = 10000;
    public static final int RTC_SERVICE_ID = 5;
    public static volatile long RTC_TRACK_UPLOAD_DURATION = 300000;
    public static final int RTC_VERSION = 103050;
    public static final int SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class RoomEventType {
        public static final /* synthetic */ RoomEventType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RoomEventType CALLEE_RING;
        public static final RoomEventType EXIT_ROOM;
        public static final RoomEventType JOIN_ROOM;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(481768666, "Lcom/baidu/android/imrtc/utils/RtcConstants$RoomEventType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(481768666, "Lcom/baidu/android/imrtc/utils/RtcConstants$RoomEventType;");
                    return;
                }
            }
            JOIN_ROOM = new RoomEventType("JOIN_ROOM", 0, 93);
            EXIT_ROOM = new RoomEventType("EXIT_ROOM", 1, 87);
            RoomEventType roomEventType = new RoomEventType("CALLEE_RING", 2, 83);
            CALLEE_RING = roomEventType;
            $VALUES = new RoomEventType[]{JOIN_ROOM, EXIT_ROOM, roomEventType};
        }

        public RoomEventType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static RoomEventType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RoomEventType) Enum.valueOf(RoomEventType.class, str) : (RoomEventType) invokeL.objValue;
        }

        public static RoomEventType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RoomEventType[]) $VALUES.clone() : (RoomEventType[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(609942991, "Lcom/baidu/android/imrtc/utils/RtcConstants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(609942991, "Lcom/baidu/android/imrtc/utils/RtcConstants;");
                return;
            }
        }
        IM_RTC_SDK_SEQ_ID = new AtomicLong(-1L);
        IM_RTC_SERVER_SEQ_ID = -1L;
    }

    public RtcConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
