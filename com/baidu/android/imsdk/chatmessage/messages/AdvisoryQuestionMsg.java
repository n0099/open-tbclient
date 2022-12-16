package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
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
public class AdvisoryQuestionMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<AdvisoryQuestionMsg> CREATOR;
    public static final String TAG = "AdvisoryQuestionMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public Object mAdvisoryBusinessExt;
    public String mBusinessExt;
    public String mCardId;
    public long mChangeVersion;
    public String mClueId;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1691684149, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryQuestionMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1691684149, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryQuestionMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryQuestionMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryQuestionMsg.1
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
            public AdvisoryQuestionMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryQuestionMsg(parcel);
                }
                return (AdvisoryQuestionMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryQuestionMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryQuestionMsg[i];
                }
                return (AdvisoryQuestionMsg[]) invokeI.objValue;
            }
        };
    }

    public AdvisoryQuestionMsg() {
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
        setMsgType(56);
    }

    public Object getAdvisoryBusinessExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAdvisoryBusinessExt;
        }
        return invokeV.objValue;
    }

    public String getBusinessExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBusinessExt;
        }
        return (String) invokeV.objValue;
    }

    public String getCardId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCardId;
        }
        return (String) invokeV.objValue;
    }

    public long getChangeVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mChangeVersion;
        }
        return invokeV.longValue;
    }

    public String getClueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mClueId;
        }
        return (String) invokeV.objValue;
    }

    public AdvisoryQuestionMsg(Parcel parcel) {
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
        this.mBusinessExt = parcel.readString();
        this.mCardId = parcel.readString();
        this.mClueId = parcel.readString();
        this.mChangeVersion = parcel.readLong();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String jsonContent = getJsonContent();
            if (!TextUtils.isEmpty(jsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(jsonContent);
                    this.mBusinessExt = jSONObject.optString("business_ext");
                    this.mCardId = jSONObject.optString(PersonalCardDetailActivityConfig.CARD_ID);
                    this.mClueId = jSONObject.optString("clue_id");
                    this.mChangeVersion = jSONObject.optLong("version");
                    return true;
                } catch (JSONException e) {
                    LogUtils.e(TAG, "parse json err!", e);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setAdvisoryBusinessExt(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.mAdvisoryBusinessExt = obj;
        }
    }

    public void setBusinessExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mBusinessExt = str;
        }
    }

    public void setCardId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mCardId = str;
        }
    }

    public void setChangeVersion(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.mChangeVersion = j;
        }
    }

    public void setClueId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mClueId = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mBusinessExt);
            parcel.writeString(this.mCardId);
            parcel.writeString(this.mClueId);
            parcel.writeLong(this.mChangeVersion);
        }
    }
}
