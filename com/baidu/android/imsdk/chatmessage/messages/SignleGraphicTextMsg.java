package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SignleGraphicTextMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<SignleGraphicTextMsg> CREATOR;
    public static final int GRAPH = 0;
    public static final int VIDEO_1SHARE = 1;
    public static final int VIDEO_2SHARE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String mArticleUrl;
    public String mCommandUrl;
    public String mCover;
    public String mCovers;
    public String mDigest;
    public boolean mShare;
    public int mSubType;
    public String mTitle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1191438499, "Lcom/baidu/android/imsdk/chatmessage/messages/SignleGraphicTextMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1191438499, "Lcom/baidu/android/imsdk/chatmessage/messages/SignleGraphicTextMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<SignleGraphicTextMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg.1
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
            public SignleGraphicTextMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SignleGraphicTextMsg(parcel) : (SignleGraphicTextMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SignleGraphicTextMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SignleGraphicTextMsg[i2] : (SignleGraphicTextMsg[]) invokeI.objValue;
            }
        };
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String getArticleUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mArticleUrl : (String) invokeV.objValue;
    }

    public String getCommandUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCommandUrl : (String) invokeV.objValue;
    }

    public String getCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCover : (String) invokeV.objValue;
    }

    public String getCovers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCovers : (String) invokeV.objValue;
    }

    public String getDigest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDigest : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getTitle() : (String) invokeV.objValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSubType : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public boolean isShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mShare : invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                LogUtils.d("", "parse signleGraph msg " + getJsonContent());
                this.mTitle = jSONObject.getString("title");
                this.mDigest = jSONObject.optString(LightappBusinessClient.MTD_DIGEST, "");
                this.mCover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "");
                this.mArticleUrl = jSONObject.getString("article_url");
                if (jSONObject.has("sti_type")) {
                    this.mShare = true;
                    this.mCovers = jSONObject.optString("sti_cover1");
                    this.mSubType = jSONObject.optInt("sti_type");
                }
                String optString = jSONObject.optString("sti_cmd_ard");
                this.mCommandUrl = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.mCommandUrl = jSONObject.optString("sti_command");
                    return true;
                }
                return true;
            } catch (JSONException e2) {
                LogUtils.e("SignleGraphicTextMsg", "parseJsonString JSONException", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setArticleUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mArticleUrl = str;
        }
    }

    public void setCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mCover = str;
        }
    }

    public void setDigest(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mDigest = str;
        }
    }

    public boolean setJsonContent(String str, String str2, String str3, String str4, String str5, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i2)})) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(LightappBusinessClient.MTD_DIGEST) || TextUtils.isEmpty(str4)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", str);
                jSONObject.put(LightappBusinessClient.MTD_DIGEST, str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("article_url", str4);
                }
                jSONObject.put("sti_cover1", str5);
                jSONObject.put("sti_type", i2);
                return setMsgContent(jSONObject.toString());
            } catch (Exception unused) {
                LogUtils.e("SignleGraphicTextMsg", "content error!");
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void setSubType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mSubType = i2;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mTitle = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mDigest);
            parcel.writeString(this.mCover);
            parcel.writeString(this.mArticleUrl);
            parcel.writeString(this.mCovers);
            parcel.writeInt(this.mSubType);
            parcel.writeString(this.mCommandUrl);
        }
    }

    public SignleGraphicTextMsg() {
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
        this.mShare = false;
        setMsgType(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignleGraphicTextMsg(Parcel parcel) {
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
        this.mShare = false;
        this.mTitle = parcel.readString();
        this.mDigest = parcel.readString();
        this.mCover = parcel.readString();
        this.mArticleUrl = parcel.readString();
        this.mCovers = parcel.readString();
        this.mSubType = parcel.readInt();
        this.mCommandUrl = parcel.readString();
    }
}
