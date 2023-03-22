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
public class NotifyReplyUpdateMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<NotifyReplyUpdateMsg> CREATOR;
    public static final String TAG = "NotifyReplyUpdateMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int count;
    public long fromUid;
    public long msgId;
    public long msgRepliedMsgId;
    public String msgRepliedStatusDisplayText;
    public int repliedStatus;
    public int replyUpdateMsgCategory;
    public int status;
    public long updateTime;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1959979208, "Lcom/baidu/android/imsdk/chatmessage/messages/NotifyReplyUpdateMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1959979208, "Lcom/baidu/android/imsdk/chatmessage/messages/NotifyReplyUpdateMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<NotifyReplyUpdateMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.NotifyReplyUpdateMsg.1
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
            public NotifyReplyUpdateMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new NotifyReplyUpdateMsg(parcel);
                }
                return (NotifyReplyUpdateMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NotifyReplyUpdateMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new NotifyReplyUpdateMsg[i];
                }
                return (NotifyReplyUpdateMsg[]) invokeI.objValue;
            }
        };
    }

    public NotifyReplyUpdateMsg() {
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
        setNotifyCmd(26);
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.count;
        }
        return invokeV.intValue;
    }

    public long getFromUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.fromUid;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.msgId;
        }
        return invokeV.longValue;
    }

    public String getMsgRepliedStatusDisplayText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.msgRepliedStatusDisplayText;
        }
        return (String) invokeV.objValue;
    }

    public int getReplyUpdateMsgCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.replyUpdateMsgCategory;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.repliedStatus;
        }
        return invokeV.intValue;
    }

    public long getUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.updateTime;
        }
        return invokeV.longValue;
    }

    public NotifyReplyUpdateMsg(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.replyUpdateMsgCategory = parcel.readInt();
        this.count = parcel.readInt();
        this.fromUid = parcel.readLong();
        this.msgId = parcel.readLong();
        this.repliedStatus = parcel.readInt();
        this.status = parcel.readInt();
        this.msgRepliedStatusDisplayText = parcel.readString();
        this.updateTime = parcel.readLong();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                this.replyUpdateMsgCategory = jSONObject.optInt("category");
                this.count = jSONObject.optInt("count");
                this.fromUid = jSONObject.optLong("from_uid");
                this.msgId = jSONObject.optLong("msgid");
                this.status = jSONObject.optInt("status");
                this.repliedStatus = jSONObject.optInt("re_msg_status");
                this.msgRepliedStatusDisplayText = jSONObject.optString("re_msg_status_display_text");
                this.updateTime = jSONObject.optLong("update_time");
                return true;
            } catch (JSONException e) {
                LogUtils.e(TAG, "parse json exception:", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i) == null) {
            parcel.writeInt(this.replyUpdateMsgCategory);
            parcel.writeInt(this.count);
            parcel.writeLong(this.fromUid);
            parcel.writeLong(this.msgId);
            parcel.writeInt(this.repliedStatus);
            parcel.writeInt(this.status);
            parcel.writeString(this.msgRepliedStatusDisplayText);
            parcel.writeLong(this.updateTime);
        }
    }
}
