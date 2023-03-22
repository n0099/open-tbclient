package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupReplyUpdateMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<GroupReplyUpdateMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public long mGroupId;
    public long mMsgId;
    public long mMsgRepliedId;
    public int mMsgRepliedStatus;
    public String mMsgRepliedStatusDisplayText;
    public long mOperator;

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-785701046, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupReplyUpdateMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-785701046, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupReplyUpdateMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GroupReplyUpdateMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupReplyUpdateMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupReplyUpdateMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new GroupReplyUpdateMsg(parcel);
                }
                return (GroupReplyUpdateMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupReplyUpdateMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new GroupReplyUpdateMsg[i];
                }
                return (GroupReplyUpdateMsg[]) invokeI.objValue;
            }
        };
    }

    public GroupReplyUpdateMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setMsgType(1027);
    }

    public long getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mGroupId;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mMsgId;
        }
        return invokeV.longValue;
    }

    public long getMsgRepliedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mMsgRepliedId;
        }
        return invokeV.longValue;
    }

    public int getMsgRepliedStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mMsgRepliedStatus;
        }
        return invokeV.intValue;
    }

    public String getMsgRepliedStatusDisplayText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mMsgRepliedStatusDisplayText;
        }
        return (String) invokeV.objValue;
    }

    public long getOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mOperator;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupReplyUpdateMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mGroupId = parcel.readLong();
        this.mOperator = parcel.readLong();
        this.mMsgId = parcel.readLong();
        this.mMsgRepliedId = parcel.readLong();
        this.mMsgRepliedStatus = parcel.readInt();
        this.mMsgRepliedStatusDisplayText = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getMsgContent());
                this.mGroupId = jSONObject.optLong("group_id");
                this.mOperator = jSONObject.optLong("operator");
                this.mMsgId = jSONObject.optLong("msgid");
                this.mMsgRepliedId = jSONObject.optLong("re_msgid");
                this.mMsgRepliedStatus = jSONObject.optInt("re_msg_status");
                this.mMsgRepliedStatusDisplayText = jSONObject.optString("re_msg_status_display_text");
                return true;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "parseJsonString", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setGroupId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mGroupId = j;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.mGroupId);
            parcel.writeLong(this.mOperator);
            parcel.writeLong(this.mMsgId);
            parcel.writeLong(this.mMsgRepliedId);
            parcel.writeInt(this.mMsgRepliedStatus);
            parcel.writeString(this.mMsgRepliedStatusDisplayText);
        }
    }
}
