package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SmartMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SmartMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public Commodity[] mCommodity;
    public String mDetailurl;
    public String mFirstColor;
    public String mFirstName;
    public String mIcon;
    public String mImageDetail;
    public String mKeywords;
    public String mName;
    public String mRemarkColor;
    public String mRemarkName;
    public String mShema;
    public String mTitle;
    public long mTopicId;
    public String mTopicName;
    public String mValuationTxt;
    public String mValuationUrl;

    /* loaded from: classes6.dex */
    public static class Commodity implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<Commodity> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mColor;
        public String mName;
        public String mValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1612735102, "Lcom/baidu/android/imsdk/chatmessage/messages/SmartMsg$Commodity;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1612735102, "Lcom/baidu/android/imsdk/chatmessage/messages/SmartMsg$Commodity;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<Commodity>() { // from class: com.baidu.android.imsdk.chatmessage.messages.SmartMsg.Commodity.1
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
                public Commodity createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new Commodity(parcel) : (Commodity) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Commodity[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new Commodity[i2] : (Commodity[]) invokeI.objValue;
                }
            };
        }

        public Commodity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public String getColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mColor : (String) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mName : (String) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mValue : (String) invokeV.objValue;
        }

        public void setColor(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mColor = str;
            }
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.mName = str;
            }
        }

        public void setValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mValue = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i2) == null) {
                parcel.writeString(this.mName);
                parcel.writeString(this.mValue);
                parcel.writeString(this.mColor);
            }
        }

        public Commodity(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mName = parcel.readString();
            this.mValue = parcel.readString();
            this.mColor = parcel.readString();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1051159609, "Lcom/baidu/android/imsdk/chatmessage/messages/SmartMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1051159609, "Lcom/baidu/android/imsdk/chatmessage/messages/SmartMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<SmartMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.SmartMsg.1
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
            public SmartMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SmartMsg(parcel) : (SmartMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SmartMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SmartMsg[i2] : (SmartMsg[]) invokeI.objValue;
            }
        };
    }

    public SmartMsg() {
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
        setMsgType(21);
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

    public Commodity[] getCommodity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCommodity : (Commodity[]) invokeV.objValue;
    }

    public String getDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDetailurl : (String) invokeV.objValue;
    }

    public String getFirstColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFirstColor : (String) invokeV.objValue;
    }

    public String getFirstName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFirstName : (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIcon : (String) invokeV.objValue;
    }

    public String getImageDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mImageDetail : (String) invokeV.objValue;
    }

    public String getKeywords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mKeywords : (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !TextUtils.isEmpty(this.mTitle) ? this.mTitle : "" : (String) invokeV.objValue;
    }

    public String getRemarkColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mRemarkColor : (String) invokeV.objValue;
    }

    public String getRemarkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRemarkName : (String) invokeV.objValue;
    }

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mShema : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public long getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mTopicId : invokeV.longValue;
    }

    public String getTopicName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mTopicName : (String) invokeV.objValue;
    }

    public String getValuationTxt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mValuationTxt : (String) invokeV.objValue;
    }

    public String getValuationUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mValuationUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                String optString = jSONObject.optString("title");
                this.mTitle = optString;
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                this.mName = jSONObject.optString("name");
                this.mIcon = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                this.mDetailurl = jSONObject.optString("detail_url");
                this.mShema = jSONObject.optString("schema");
                JSONObject optJSONObject = jSONObject.optJSONObject("first");
                if (optJSONObject != null) {
                    this.mFirstName = optJSONObject.optString("value");
                    this.mFirstColor = optJSONObject.optString("color");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("remark");
                if (optJSONObject2 != null) {
                    this.mRemarkName = optJSONObject2.optString("value");
                    this.mRemarkColor = optJSONObject2.optString("color");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
                if (optJSONArray != null) {
                    this.mKeywords = optJSONArray.toString();
                    int length = optJSONArray.length();
                    if (length > 0) {
                        this.mCommodity = new Commodity[length];
                    }
                    LogUtils.d("TempletMsg", "size is " + length);
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        Commodity commodity = new Commodity();
                        commodity.setName(jSONObject2.getString("name"));
                        commodity.setValue(jSONObject2.optString("value", ""));
                        commodity.setColor(jSONObject2.optString("color", "#000000"));
                        this.mCommodity[i2] = commodity;
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("image");
                if (optJSONObject3 != null) {
                    this.mImageDetail = optJSONObject3.toString();
                }
                this.mValuationUrl = jSONObject.optString("operation_url");
                this.mValuationTxt = jSONObject.optString("operation_name");
                this.mTopicId = jSONObject.optLong("topic_id");
                this.mTopicName = jSONObject.optString(IntentConfig.TOPIC_NAME);
                return true;
            } catch (JSONException e2) {
                LogUtils.e("SmartMsg", "parseJsonString JSONException", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mIcon = str;
        }
    }

    public boolean setJsonContent(String str, String str2, String str3, String str4, String str5, Commodity[] commodityArr, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{str, str2, str3, str4, str5, commodityArr, str6})) == null) {
            if (TextUtils.isEmpty(str) || str2 == null || str4 == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("title", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("value", str2);
                jSONObject2.put("color", str3);
                jSONObject.put("first", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("value", str4);
                jSONObject3.put("color", str5);
                jSONObject.put("remark", jSONObject3);
                if (commodityArr != null && commodityArr.length > 0) {
                    for (Commodity commodity : commodityArr) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("name", commodity.getName());
                        jSONObject4.put("color", commodity.getColor());
                        jSONObject4.put("value", commodity.getValue());
                        jSONArray.put(jSONObject4);
                    }
                }
                jSONObject.put("keywords", jSONArray);
                jSONObject.put("detail_url", str6);
                return setMsgContent(jSONObject.toString());
            } catch (Exception unused) {
                LogUtils.e("SmartMsg", "content error!");
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void setTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.mTopicId = j;
        }
    }

    public void setTopicName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mTopicName = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mName);
            parcel.writeString(this.mIcon);
            parcel.writeString(this.mDetailurl);
            parcel.writeString(this.mShema);
            parcel.writeString(this.mFirstName);
            parcel.writeString(this.mFirstColor);
            parcel.writeString(this.mRemarkName);
            parcel.writeString(this.mRemarkColor);
            Commodity[] commodityArr = this.mCommodity;
            int length = commodityArr != null ? commodityArr.length : 0;
            parcel.writeInt(length);
            if (length > 0) {
                parcel.writeTypedArray(this.mCommodity, i2);
            }
            parcel.writeString(this.mValuationUrl);
            parcel.writeString(this.mValuationTxt);
            parcel.writeLong(this.mTopicId);
            parcel.writeString(this.mTopicName);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartMsg(Parcel parcel) {
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
        this.mTitle = parcel.readString();
        this.mName = parcel.readString();
        this.mIcon = parcel.readString();
        this.mDetailurl = parcel.readString();
        this.mShema = parcel.readString();
        this.mFirstName = parcel.readString();
        this.mFirstColor = parcel.readString();
        this.mRemarkName = parcel.readString();
        this.mRemarkColor = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            Commodity[] commodityArr = new Commodity[readInt];
            this.mCommodity = commodityArr;
            parcel.readTypedArray(commodityArr, Commodity.CREATOR);
        }
        this.mValuationUrl = parcel.readString();
        this.mValuationTxt = parcel.readString();
        this.mTopicId = parcel.readLong();
        this.mTopicName = parcel.readString();
    }
}
