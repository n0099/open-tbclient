package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMSettings;
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
public class RedNotifyMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<RedNotifyMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public long mGrabTime;
    public int mIsLast;
    public String mLogoUrl;
    public String mOrderId;
    public String mReceiveName;
    public String mReceveId;
    public String mSendId;
    public String mSendName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1897380168, "Lcom/baidu/android/imsdk/chatmessage/messages/RedNotifyMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1897380168, "Lcom/baidu/android/imsdk/chatmessage/messages/RedNotifyMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<RedNotifyMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.RedNotifyMsg.1
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
            public RedNotifyMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new RedNotifyMsg(parcel);
                }
                return (RedNotifyMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RedNotifyMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new RedNotifyMsg[i];
                }
                return (RedNotifyMsg[]) invokeI.objValue;
            }
        };
    }

    public RedNotifyMsg() {
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
        setMsgType(2010);
    }

    public long getGrabTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mGrabTime;
        }
        return invokeV.longValue;
    }

    public String getLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mLogoUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mOrderId;
        }
        return (String) invokeV.objValue;
    }

    public String getReceveId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mReceveId;
        }
        return (String) invokeV.objValue;
    }

    public String getRecvName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mReceiveName;
        }
        return (String) invokeV.objValue;
    }

    public String getSendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mSendId;
        }
        return (String) invokeV.objValue;
    }

    public String getSendName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mSendName;
        }
        return (String) invokeV.objValue;
    }

    public int isLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mIsLast;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedNotifyMsg(Parcel parcel) {
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
        this.mOrderId = parcel.readString();
        this.mSendId = parcel.readString();
        this.mSendName = parcel.readString();
        this.mReceveId = parcel.readString();
        this.mReceiveName = parcel.readString();
        this.mIsLast = parcel.readInt();
        this.mGrabTime = parcel.readLong();
        this.mLogoUrl = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String uid = AccountManager.getUid(IMSettings.getsContext());
            LogUtils.d("", "FDEBUG" + uid + " " + this.mReceveId + " " + this.mSendId);
            if (this.mReceveId.equals(uid)) {
                if (this.mSendId.equals(uid)) {
                    return "你领取了自己的红包";
                }
                return "你领取了" + this.mSendName + "的红包";
            } else if (this.mSendId.equals(uid)) {
                if (this.mIsLast == 1 && getCategory() == 1) {
                    return this.mReceiveName + "领取了你的红包，你的红包已被领完";
                }
                return this.mReceiveName + "领取了你的红包";
            } else if (this.mSendId.equals(this.mReceveId)) {
                return this.mReceiveName + "领取了自己的红包";
            } else {
                return this.mReceiveName + "领取了" + this.mSendName + "的红包";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LogUtils.d("", "FDEBUG parseJsonString");
            try {
                JSONObject jSONObject = new JSONObject(getMsgContent());
                this.mOrderId = jSONObject.optString("redpack_id");
                this.mSendId = jSONObject.optString("redpack_send_uid");
                this.mSendName = jSONObject.optString("redpack_send_name");
                this.mReceveId = jSONObject.optString("redpack_recv_uid");
                this.mReceiveName = jSONObject.optString("redpack_recv_name");
                this.mIsLast = jSONObject.optInt("last");
                this.mGrabTime = jSONObject.optLong("redpack_get_ts");
                this.mLogoUrl = jSONObject.optString("logo");
                return true;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "parseJsonString", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mOrderId);
            parcel.writeString(this.mSendId);
            parcel.writeString(this.mSendName);
            parcel.writeString(this.mReceveId);
            parcel.writeString(this.mReceiveName);
            parcel.writeInt(this.mIsLast);
            parcel.writeLong(this.mGrabTime);
            parcel.writeString(this.mLogoUrl);
        }
    }
}
