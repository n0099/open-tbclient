package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.util.TbEnum;
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
public class QuickProductCardMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<QuickProductCardMsg> CREATOR;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppKey;
    public String mCardName;
    public String mDescription;
    public String mImage;
    public String mMsgExt;
    public String mSchema;
    public String mSessionFrom;
    public String mTitle;
    public String mUserIcon;
    public String mUserName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(566703208, "Lcom/baidu/android/imsdk/chatmessage/messages/QuickProductCardMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(566703208, "Lcom/baidu/android/imsdk/chatmessage/messages/QuickProductCardMsg;");
                return;
            }
        }
        TAG = QuickProductCardMsg.class.getSimpleName();
        CREATOR = new Parcelable.Creator<QuickProductCardMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.QuickProductCardMsg.1
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
            public QuickProductCardMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new QuickProductCardMsg(parcel);
                }
                return (QuickProductCardMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QuickProductCardMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new QuickProductCardMsg[i];
                }
                return (QuickProductCardMsg[]) invokeI.objValue;
            }
        };
    }

    public QuickProductCardMsg() {
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
        setMsgType(61);
    }

    public static Parcelable.Creator<QuickProductCardMsg> getCREATOR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return CREATOR;
        }
        return (Parcelable.Creator) invokeV.objValue;
    }

    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAppKey;
        }
        return (String) invokeV.objValue;
    }

    public String getCardName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCardName;
        }
        return (String) invokeV.objValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDescription;
        }
        return (String) invokeV.objValue;
    }

    public String getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImage;
        }
        return (String) invokeV.objValue;
    }

    public String getMsgExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mMsgExt;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "[小程序]" + getTitle();
        }
        return (String) invokeV.objValue;
    }

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mSchema;
        }
        return (String) invokeV.objValue;
    }

    public String getSessionFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mSessionFrom;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getUserIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mUserIcon;
        }
        return (String) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mUserName;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickProductCardMsg(Parcel parcel) {
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
        this.mSessionFrom = parcel.readString();
        this.mDescription = parcel.readString();
        this.mUserIcon = parcel.readString();
        this.mUserName = parcel.readString();
        this.mCardName = parcel.readString();
        this.mTitle = parcel.readString();
        this.mImage = parcel.readString();
        this.mSchema = parcel.readString();
        this.mMsgExt = parcel.readString();
        this.mAppKey = parcel.readString();
    }

    public void buildContentJson(String str) {
        JSONObject optJSONObject;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("appKey");
            setAppKey(optString);
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("productCardProtocol");
            if (optJSONObject2 == null || !optJSONObject2.optBoolean("showMessageCard", false) || (optJSONObject = optJSONObject2.optJSONObject("content")) == null) {
                return;
            }
            String optString2 = optJSONObject.optString("userIcon");
            String optString3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
            String optString4 = optJSONObject.optString("cardName");
            String optString5 = optJSONObject.optString("title");
            String optString6 = optJSONObject.optString("image");
            String optString7 = optJSONObject.optString("schema");
            String optString8 = optJSONObject.optString("msgExt");
            if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("user_icon", optString2);
                jSONObject3.put("user_name", optString3);
                jSONObject3.put("title", optString5);
                jSONObject3.put("image", optString6);
                jSONObject3.put("card_name", optString4);
                jSONObject3.put("schema", optString7);
                try {
                    if (!TextUtils.isEmpty(optString8)) {
                        jSONObject = new JSONObject(optString8);
                    } else {
                        jSONObject = new JSONObject();
                    }
                } catch (JSONException unused) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, optString);
                jSONObject3.put(Constants.EXTRA_BUSINESS_MSG_EXT, jSONObject.toString());
                String str2 = TAG;
                LogUtils.d(str2, "serverContent:" + jSONObject3.toString());
                setMsgContent(jSONObject3.toString());
            }
        } catch (Exception unused2) {
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getMsgContent());
                this.mCardName = jSONObject.optString("card_name");
                this.mUserIcon = jSONObject.optString("user_icon");
                this.mUserName = jSONObject.optString("user_name");
                this.mTitle = jSONObject.optString("title");
                this.mImage = jSONObject.optString("image");
                this.mSchema = jSONObject.optString("schema");
                String optString = jSONObject.optString(Constants.EXTRA_BUSINESS_MSG_EXT);
                this.mMsgExt = optString;
                if (!TextUtils.isEmpty(optString)) {
                    this.mAppKey = new JSONObject(this.mMsgExt).optString(GameGuideConfigInfo.KEY_APP_KEY);
                }
                return true;
            } catch (JSONException e) {
                LogUtils.e(TAG, "parseJsonString", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mAppKey = str;
        }
    }

    public void setCardName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mCardName = str;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mDescription = str;
        }
    }

    public void setImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mImage = str;
        }
    }

    public void setMsgExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mMsgExt = str;
        }
    }

    public void setSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mSchema = str;
        }
    }

    public void setSessionFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mSessionFrom = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mTitle = str;
        }
    }

    public void setUserIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mUserIcon = str;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mUserName = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mSessionFrom);
            parcel.writeString(this.mDescription);
            parcel.writeString(this.mUserIcon);
            parcel.writeString(this.mUserName);
            parcel.writeString(this.mCardName);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mImage);
            parcel.writeString(this.mSchema);
            parcel.writeString(this.mMsgExt);
            parcel.writeString(this.mAppKey);
        }
    }
}
