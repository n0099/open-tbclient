package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
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
/* loaded from: classes3.dex */
public class BonusNoImgMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<BonusNoImgMsg> CREATOR;
    public static final String TAG = "BonusNoImgMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public String mDescription;
    public String mDiscountCondition;
    public int mDiscountType;
    public String mDiscountValue;
    public String mIdentity;
    public String mOperationText;
    public String mSkipAddr;
    public int mSkipType;
    public String mSource;
    public String mText;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1438862887, "Lcom/baidu/android/imsdk/chatmessage/messages/BonusNoImgMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1438862887, "Lcom/baidu/android/imsdk/chatmessage/messages/BonusNoImgMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<BonusNoImgMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.BonusNoImgMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BonusNoImgMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new BonusNoImgMsg(parcel) : (BonusNoImgMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BonusNoImgMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new BonusNoImgMsg[i2] : (BonusNoImgMsg[]) invokeI.objValue;
            }
        };
    }

    public BonusNoImgMsg() {
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
        this.mText = "";
        this.mSource = "";
        this.mIdentity = "";
        this.mDescription = "";
        this.mDiscountType = 0;
        this.mDiscountValue = "";
        this.mDiscountCondition = "";
        this.mOperationText = "";
        this.mSkipType = 0;
        this.mSkipAddr = "";
        setMsgType(35);
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDescription : (String) invokeV.objValue;
    }

    public String getDiscountCondition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDiscountCondition : (String) invokeV.objValue;
    }

    public int getDiscountType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDiscountType : invokeV.intValue;
    }

    public String getDiscountValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDiscountValue : (String) invokeV.objValue;
    }

    public String getIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIdentity : (String) invokeV.objValue;
    }

    public String getOperationText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mOperationText : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? IMConstants.BONUS_MSG_RECOMMEND_DESC : (String) invokeV.objValue;
    }

    public String getSkipAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSkipAddr : (String) invokeV.objValue;
    }

    public int getSkipType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSkipType : invokeV.intValue;
    }

    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSource : (String) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mText : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                LogUtils.d(TAG, "parse BonusNoImgMsg msg " + getJsonContent());
                this.mText = jSONObject.optString("text");
                JSONObject jSONObject2 = jSONObject.getJSONObject("ext");
                this.mSource = jSONObject2.getString("source");
                this.mIdentity = jSONObject2.getString("identity");
                this.mDescription = jSONObject2.getString("description");
                this.mDiscountType = jSONObject2.getInt("discount_type");
                this.mDiscountCondition = jSONObject2.getString("discount_condition");
                this.mDiscountValue = jSONObject2.getString("discount_value");
                this.mOperationText = jSONObject2.getString("operation_text");
                this.mSkipType = jSONObject2.getInt("skip_type");
                this.mSkipAddr = jSONObject2.getString("skip_addr");
                return true;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "parseJsonString JSONException", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mDescription = str;
        }
    }

    public void setDiscountCondition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mDiscountCondition = str;
        }
    }

    public void setDiscountType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mDiscountType = i2;
        }
    }

    public void setDiscountValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mDiscountValue = str;
        }
    }

    public void setIdentity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mIdentity = str;
        }
    }

    public void setOperationText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mOperationText = str;
        }
    }

    public void setSkipAddr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mSkipAddr = str;
        }
    }

    public void setSkipType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mSkipType = i2;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mSource = str;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mText = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.mText);
            parcel.writeString(this.mSource);
            parcel.writeString(this.mIdentity);
            parcel.writeString(this.mDescription);
            parcel.writeInt(this.mDiscountType);
            parcel.writeString(this.mDiscountValue);
            parcel.writeString(this.mDiscountCondition);
            parcel.writeString(this.mOperationText);
            parcel.writeInt(this.mSkipType);
            parcel.writeString(this.mSkipAddr);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BonusNoImgMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mText = "";
        this.mSource = "";
        this.mIdentity = "";
        this.mDescription = "";
        this.mDiscountType = 0;
        this.mDiscountValue = "";
        this.mDiscountCondition = "";
        this.mOperationText = "";
        this.mSkipType = 0;
        this.mSkipAddr = "";
        this.mText = parcel.readString();
        this.mSource = parcel.readString();
        this.mIdentity = parcel.readString();
        this.mDescription = parcel.readString();
        this.mDiscountType = parcel.readInt();
        this.mDiscountValue = parcel.readString();
        this.mDiscountCondition = parcel.readString();
        this.mOperationText = parcel.readString();
        this.mSkipType = parcel.readInt();
        this.mSkipAddr = parcel.readString();
    }
}
