package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
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
public class RedPackMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBusiLogo;
    public String mBusiName;
    public long mCreateTs;
    public String mRedPacket;
    public String mRedPacketId;
    public String mSendName;
    public String mSendUid;
    public int mType;
    public String mWishText;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1087348024, "Lcom/baidu/android/imsdk/chatmessage/messages/RedPackMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1087348024, "Lcom/baidu/android/imsdk/chatmessage/messages/RedPackMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.RedPackMsg.1
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
            @Override // android.os.Parcelable.Creator
            public RedPackMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new RedPackMsg(parcel);
                }
                return (RedPackMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public RedPackMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new RedPackMsg[i];
                }
                return (RedPackMsg[]) invokeI.objValue;
            }
        };
    }

    public RedPackMsg() {
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
        setMsgType(16);
    }

    public String getBusiLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBusiLogo;
        }
        return (String) invokeV.objValue;
    }

    public String getBusiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBusiName;
        }
        return (String) invokeV.objValue;
    }

    public long getCreateTs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCreateTs;
        }
        return invokeV.longValue;
    }

    public String getRedPacketId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mRedPacketId;
        }
        return (String) invokeV.objValue;
    }

    public String getSendName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mSendName;
        }
        return (String) invokeV.objValue;
    }

    public String getSendUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mSendUid;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public String getWish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mWishText;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedPackMsg(Parcel parcel) {
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
        this.mType = parcel.readInt();
        this.mRedPacketId = parcel.readString();
        this.mSendUid = parcel.readString();
        this.mSendName = parcel.readString();
        this.mBusiLogo = parcel.readString();
        this.mBusiName = parcel.readString();
        this.mWishText = parcel.readString();
        this.mCreateTs = parcel.readLong();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LogUtils.d("", "FDEBUG RedPackMsg getRecommendDescription" + this.mWishText);
            if (!TextUtils.isEmpty(this.mWishText)) {
                return "[百度红包]" + this.mWishText;
            }
            return "[百度红包]恭喜发财,大吉大利！";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                LogUtils.d("", "FDEBUG RedPackMsg" + getJsonContent());
                JSONObject jSONObject = new JSONObject(getJsonContent());
                this.mRedPacketId = jSONObject.getString("redpack_id");
                this.mType = jSONObject.optInt("redpack_type");
                this.mWishText = jSONObject.optString("wish");
                LogUtils.d("", "FDEBUG RedPackMsg" + this.mWishText);
                this.mCreateTs = jSONObject.optLong("redpack_ts");
                this.mSendName = jSONObject.optString("redpack_send_name");
                this.mSendUid = jSONObject.optString("redpack_send_uid");
                this.mBusiName = jSONObject.optString("busi_name");
                this.mBusiLogo = jSONObject.optString("busi_logo");
                return true;
            } catch (JSONException e) {
                LogUtils.e("CouponMsg", "parseJsonString JSONException", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean setJsonContent(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                jSONObject.put("redpack_type", 0);
                jSONObject.put("redpack_id", 0);
                jSONObject.put("redpack_send_uid", str);
                jSONObject.put("redpack_send_name", str2);
                jSONObject.put("wish", "good luck'");
                jSONObject.put("redpack_ts", currentTimeMillis);
                return setMsgContent(jSONObject.toString());
            } catch (Exception unused) {
                LogUtils.e("TempletMsg", "content error!");
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mType);
            parcel.writeString(this.mRedPacketId);
            parcel.writeString(this.mSendUid);
            parcel.writeString(this.mSendName);
            parcel.writeString(this.mBusiLogo);
            parcel.writeString(this.mBusiName);
            parcel.writeString(this.mWishText);
            parcel.writeLong(this.mCreateTs);
        }
    }
}
