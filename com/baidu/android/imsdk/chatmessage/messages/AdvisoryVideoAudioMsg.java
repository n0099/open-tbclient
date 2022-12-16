package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
public class AdvisoryVideoAudioMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<AdvisoryVideoAudioMsg> CREATOR;
    public static final String TAG = "AdvisoryVideoAudioMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAnswerTips;
    public String mBusinessExt;
    public String mDesc;
    public int mIsFirst;
    public int mNum;
    public String mPrice;
    public String mProductTime;
    public String mProductUrl;
    public long mReceiveBduid;
    public long mSendBduid;
    public String mTitle;
    public String mTotalDesc;
    public String mTotalPrice;
    public int mTotalTime;
    public String mUserTips;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(812669354, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryVideoAudioMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(812669354, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryVideoAudioMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryVideoAudioMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryVideoAudioMsg.1
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
            public AdvisoryVideoAudioMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryVideoAudioMsg(parcel);
                }
                return (AdvisoryVideoAudioMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryVideoAudioMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryVideoAudioMsg[i];
                }
                return (AdvisoryVideoAudioMsg[]) invokeI.objValue;
            }
        };
    }

    public AdvisoryVideoAudioMsg() {
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
        setMsgType(44);
    }

    public String getAnswerTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAnswerTips;
        }
        return (String) invokeV.objValue;
    }

    public String getBusinessExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBusinessExt;
        }
        return (String) invokeV.objValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDesc;
        }
        return (String) invokeV.objValue;
    }

    public int getIsFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mIsFirst;
        }
        return invokeV.intValue;
    }

    public int getNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mNum;
        }
        return invokeV.intValue;
    }

    public String getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPrice;
        }
        return (String) invokeV.objValue;
    }

    public String getProductTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mProductTime;
        }
        return (String) invokeV.objValue;
    }

    public String getProductUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mProductUrl;
        }
        return (String) invokeV.objValue;
    }

    public long getReceiveBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mReceiveBduid;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public long getSendBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mSendBduid;
        }
        return invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getTotalDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mTotalDesc;
        }
        return (String) invokeV.objValue;
    }

    public String getTotalPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mTotalPrice;
        }
        return (String) invokeV.objValue;
    }

    public int getTotalTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mTotalTime;
        }
        return invokeV.intValue;
    }

    public String getUserTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mUserTips;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvisoryVideoAudioMsg(Parcel parcel) {
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
        this.mSendBduid = parcel.readLong();
        this.mReceiveBduid = parcel.readLong();
        this.mBusinessExt = parcel.readString();
        this.mTitle = parcel.readString();
        this.mProductUrl = parcel.readString();
        this.mIsFirst = parcel.readInt();
        this.mDesc = parcel.readString();
        this.mPrice = parcel.readString();
        this.mNum = parcel.readInt();
        this.mProductTime = parcel.readString();
        this.mTotalTime = parcel.readInt();
        this.mTotalDesc = parcel.readString();
        this.mTotalPrice = parcel.readString();
        this.mUserTips = parcel.readString();
        this.mAnswerTips = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!TextUtils.isEmpty(this.mjsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mjsonContent);
                    this.mSendBduid = jSONObject.optLong("buid");
                    this.mReceiveBduid = jSONObject.optLong("tobuid");
                    this.mBusinessExt = jSONObject.optString("business_ext");
                    this.mTitle = jSONObject.optString("title");
                    this.mProductUrl = jSONObject.optString("product_url");
                    this.mIsFirst = jSONObject.optInt("is_first");
                    this.mDesc = jSONObject.optString("desc");
                    this.mPrice = jSONObject.optString("price");
                    this.mNum = jSONObject.optInt("num");
                    this.mProductTime = jSONObject.optString("product_time");
                    this.mTotalTime = jSONObject.optInt("total_time");
                    this.mTotalDesc = jSONObject.optString("total_desc");
                    this.mTotalPrice = jSONObject.optString("total_price");
                    this.mUserTips = jSONObject.optString("tips");
                    this.mAnswerTips = jSONObject.optString("b_tips");
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.mSendBduid);
            parcel.writeLong(this.mReceiveBduid);
            parcel.writeString(this.mBusinessExt);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mProductUrl);
            parcel.writeInt(this.mIsFirst);
            parcel.writeString(this.mDesc);
            parcel.writeString(this.mPrice);
            parcel.writeInt(this.mNum);
            parcel.writeString(this.mProductTime);
            parcel.writeInt(this.mTotalTime);
            parcel.writeString(this.mTotalDesc);
            parcel.writeString(this.mTotalPrice);
            parcel.writeString(this.mUserTips);
            parcel.writeString(this.mAnswerTips);
        }
    }
}
