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
public class AdvisoryServiceEndMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<AdvisoryServiceEndMsg> CREATOR;
    public static final String TAG = "AdvisoryServiceNotify";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isHide;
    public String mAnswerTips;
    public int mAnswerTipsType;
    public String mBusinessExt;
    public int mReasonCode;
    public String mUserTips;
    public int mUserTipsType;
    public int orderType;
    public String replyerUid;
    public int source;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "咨询服务已结束，欢迎再次咨询" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(956899829, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryServiceEndMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(956899829, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryServiceEndMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryServiceEndMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryServiceEndMsg.1
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
            public AdvisoryServiceEndMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryServiceEndMsg(parcel);
                }
                return (AdvisoryServiceEndMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryServiceEndMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryServiceEndMsg[i];
                }
                return (AdvisoryServiceEndMsg[]) invokeI.objValue;
            }
        };
    }

    public AdvisoryServiceEndMsg() {
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
        this.isHide = false;
        setMsgType(45);
    }

    public String getAnswerTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAnswerTips;
        }
        return (String) invokeV.objValue;
    }

    public int getAnswerTipsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAnswerTipsType;
        }
        return invokeV.intValue;
    }

    public String getBusinessExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBusinessExt;
        }
        return (String) invokeV.objValue;
    }

    public int getReasonCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mReasonCode;
        }
        return invokeV.intValue;
    }

    public String getUserTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mUserTips;
        }
        return (String) invokeV.objValue;
    }

    public int getUserTipsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mUserTipsType;
        }
        return invokeV.intValue;
    }

    public boolean isHide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.isHide;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvisoryServiceEndMsg(Parcel parcel) {
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
        this.isHide = false;
        this.mBusinessExt = parcel.readString();
        this.mUserTips = parcel.readString();
        this.mAnswerTips = parcel.readString();
        this.mReasonCode = parcel.readInt();
        this.mUserTipsType = parcel.readInt();
        this.mAnswerTipsType = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!TextUtils.isEmpty(this.mjsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mjsonContent);
                    this.mBusinessExt = jSONObject.optString("business_ext");
                    this.mReasonCode = jSONObject.optInt("reason_code");
                    this.mUserTips = jSONObject.optString("user_tips");
                    this.mUserTipsType = jSONObject.optInt("tips_type");
                    this.mAnswerTips = jSONObject.optString("b_tips");
                    this.mAnswerTipsType = jSONObject.optInt("b_tips_type");
                    if (new JSONObject(this.mBusinessExt).optInt("isHide", 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.isHide = z;
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
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mBusinessExt);
            parcel.writeString(this.mUserTips);
            parcel.writeString(this.mAnswerTips);
            parcel.writeInt(this.mReasonCode);
            parcel.writeInt(this.mUserTipsType);
            parcel.writeInt(this.mUserTipsType);
        }
    }
}
