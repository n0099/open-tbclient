package com.baidu.android.imsdk.chatmessage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface IChatRoomEnterListener extends IMListener {
    public static final String AT_ALL = "all";
    public static final String AT_USER = "user";

    void onResult(int i, String str, ChatRoomInfo chatRoomInfo);

    /* loaded from: classes.dex */
    public static class AtUserInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String atBdUk;
        public String atCharacter;
        public String atCharacterName;
        public String atName;
        public String atPortrait;
        public String atPosition;
        public String atType;
        public String atVip;

        public AtUserInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "AtUserInfo{atBdUk='" + this.atBdUk + "', atType='" + this.atType + "', atName='" + this.atName + "', atCharacter='" + this.atCharacter + "', atCharacterName='" + this.atCharacterName + "', atPortrait='" + this.atPortrait + "', atPosition='" + this.atPosition + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ChatRoomInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long roomId;
        public RoomInfo roomInfo;
        public UserInfo userInfo;

        public ChatRoomInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.roomInfo = new RoomInfo();
            this.userInfo = new UserInfo();
        }

        public String toJsonString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("room_type", this.roomInfo.roomType);
                    jSONObject2.put("room_id", this.roomId);
                    jSONObject2.put(DpStatConstants.KEY_ROOM_NAME, this.roomInfo.roomName);
                    jSONObject2.put("room_image", this.roomInfo.roomImage);
                    jSONObject2.put("room_notice", this.roomInfo.roomNotice);
                    jSONObject2.put("user_count", this.roomInfo.userCount);
                    jSONObject2.put("state", this.roomInfo.state);
                    jSONObject2.put("chat_mcast_id", this.roomInfo.chatMcastId);
                    jSONObject2.put("resource_id", this.roomInfo.resourceId);
                    jSONObject2.put("ext", this.roomInfo.ext);
                    jSONObject.put("room_info", jSONObject2.toString());
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("character", this.userInfo.character);
                    jSONObject3.put("character_name", this.userInfo.characterName);
                    jSONObject3.put("name", this.userInfo.name);
                    jSONObject3.put("portrait", this.userInfo.portrait);
                    jSONObject.put(SourceConstant.SOURCE_USER_INFO, jSONObject3.toString());
                } catch (Exception e) {
                    LogUtils.e("IChatRoomEnterListener", e.getMessage());
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("ChatRoomInfo{roomId=");
                sb.append(this.roomId);
                sb.append(", roomInfo=");
                RoomInfo roomInfo = this.roomInfo;
                if (roomInfo != null) {
                    str = roomInfo.toString();
                } else {
                    str = "roomInfo is null";
                }
                sb.append(str);
                sb.append(", userInfo=");
                UserInfo userInfo = this.userInfo;
                if (userInfo != null) {
                    str2 = userInfo.toString();
                } else {
                    str2 = "userInfo is null";
                }
                sb.append(str2);
                sb.append('}');
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ReMsgInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bdUk;
        public String content;
        public String ext;
        public String msgId;
        public String msgKey;
        public String msgType;
        public String nickName;
        public String url;

        public ReMsgInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "ReMsgInfo{bdUk='" + this.bdUk + "', msgType='" + this.msgType + "', nickName='" + this.nickName + "', url='" + this.url + "', ext='" + this.ext + "', content='" + this.content + "', msgId='" + this.msgId + "', msgKey='" + this.msgKey + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class RoomInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long appId;
        public long chatMcastId;
        public String ext;
        public String resourceId;
        public String roomImage;
        public String roomName;
        public String roomNotice;
        public int roomType;
        public int state;
        public int userCount;

        public RoomInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "RoomInfo{appId=" + this.appId + ", roomType=" + this.roomType + ", roomName='" + this.roomName + "', roomImage='" + this.roomImage + "', roomNotice='" + this.roomNotice + "', userCount=" + this.userCount + ", state=" + this.state + ", chatMcastId=" + this.chatMcastId + ", resourceId='" + this.resourceId + "', ext='" + this.ext + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class TaskInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long originMsgId;
        public String originMsgKey;
        public String taskErrorMsg;
        public String taskId;
        public int taskProgress;
        public int taskResult;
        public int taskState;
        public int taskType;

        public TaskInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "TaskInfo{taskId='" + this.taskId + "', taskType='" + this.taskType + "', taskState='" + this.taskState + "', taskResult='" + this.taskResult + "', taskErrorMsg='" + this.taskErrorMsg + "', originMsgId='" + this.originMsgId + "', originMsgKey='" + this.originMsgKey + "', taskProgress='" + this.taskProgress + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class UserInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long character;
        public String characterName;
        public String name;
        public String portrait;

        public UserInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "UserInfo{character=" + this.character + ", characterName='" + this.characterName + "', name='" + this.name + "', portrait='" + this.portrait + "'}";
            }
            return (String) invokeV.objValue;
        }
    }
}
