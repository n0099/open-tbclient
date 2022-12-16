package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.chatmessage.request.RequestContants;
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
public class MessageClueUpateMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MessageClueUpateMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public long mChangeMsgid;
    public int mChangedMsgCategory;
    public long mContacterPauid;
    public long mFromUid;
    public int mStatus;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1526119923, "Lcom/baidu/android/imsdk/chatmessage/messages/MessageClueUpateMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1526119923, "Lcom/baidu/android/imsdk/chatmessage/messages/MessageClueUpateMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<MessageClueUpateMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.MessageClueUpateMsg.1
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
            public MessageClueUpateMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new MessageClueUpateMsg(parcel);
                }
                return (MessageClueUpateMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MessageClueUpateMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new MessageClueUpateMsg[i];
                }
                return (MessageClueUpateMsg[]) invokeI.objValue;
            }
        };
    }

    public long getChangeMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mChangeMsgid;
        }
        return invokeV.longValue;
    }

    public int getChangedMsgCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mChangedMsgCategory;
        }
        return invokeV.intValue;
    }

    public long getChangedMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mChangeMsgid;
        }
        return invokeV.longValue;
    }

    public long getContacterPauid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mContacterPauid;
        }
        return invokeV.longValue;
    }

    public long getFromUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mFromUid;
        }
        return invokeV.longValue;
    }

    public MessageClueUpateMsg() {
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
        this.mChangeMsgid = -1L;
        this.mChangedMsgCategory = 0;
        this.mFromUid = 0L;
        this.mStatus = -1;
        this.mContacterPauid = 0L;
        setNotifyCmd(24);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageClueUpateMsg(Parcel parcel) {
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
        this.mChangeMsgid = -1L;
        this.mChangedMsgCategory = 0;
        this.mFromUid = 0L;
        this.mStatus = -1;
        this.mContacterPauid = 0L;
        this.mChangeMsgid = parcel.readLong();
        this.mChangedMsgCategory = parcel.readInt();
        this.mFromUid = parcel.readLong();
        this.mContacterPauid = parcel.readLong();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                this.mChangedMsgCategory = jSONObject.optInt("category");
                this.mFromUid = jSONObject.optLong("from_uid");
                this.mChangeMsgid = jSONObject.optLong("msgid");
                this.mStatus = jSONObject.optInt("status");
                this.mContacterPauid = jSONObject.optLong(RequestContants.EXTRA_CONTACTER_PA_UID, 0L);
                return true;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "JSONException", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.mChangeMsgid);
            parcel.writeInt(this.mChangedMsgCategory);
            parcel.writeLong(this.mFromUid);
            parcel.writeLong(this.mContacterPauid);
        }
    }
}
