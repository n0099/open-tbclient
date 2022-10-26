package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.mobstat.Config;
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
/* loaded from: classes.dex */
public class SmartMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator CREATOR;
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

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes.dex */
    public class Commodity implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mColor;
        public String mName;
        public String mValue;

        @Override // android.os.Parcelable
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
            CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.SmartMsg.Commodity.1
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
                public Commodity createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Commodity(parcel);
                    }
                    return (Commodity) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Commodity[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Commodity[i];
                    }
                    return (Commodity[]) invokeI.objValue;
                }
            };
        }

        public Commodity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public String getColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mColor;
            }
            return (String) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mName;
            }
            return (String) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mValue;
            }
            return (String) invokeV.objValue;
        }

        public Commodity(Parcel parcel) {
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
            this.mName = parcel.readString();
            this.mValue = parcel.readString();
            this.mColor = parcel.readString();
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
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
                parcel.writeString(this.mName);
                parcel.writeString(this.mValue);
                parcel.writeString(this.mColor);
            }
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
        CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.SmartMsg.1
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
            public SmartMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new SmartMsg(parcel);
                }
                return (SmartMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SmartMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new SmartMsg[i];
                }
                return (SmartMsg[]) invokeI.objValue;
            }
        };
    }

    public SmartMsg() {
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
        setMsgType(21);
    }

    public Commodity[] getCommodity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCommodity;
        }
        return (Commodity[]) invokeV.objValue;
    }

    public String getDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDetailurl;
        }
        return (String) invokeV.objValue;
    }

    public String getFirstColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mFirstColor;
        }
        return (String) invokeV.objValue;
    }

    public String getFirstName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mFirstName;
        }
        return (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mIcon;
        }
        return (String) invokeV.objValue;
    }

    public String getImageDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImageDetail;
        }
        return (String) invokeV.objValue;
    }

    public String getKeywords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mKeywords;
        }
        return (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!TextUtils.isEmpty(this.mTitle)) {
                return this.mTitle;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getRemarkColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mRemarkColor;
        }
        return (String) invokeV.objValue;
    }

    public String getRemarkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mRemarkName;
        }
        return (String) invokeV.objValue;
    }

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mShema;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public long getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mTopicId;
        }
        return invokeV.longValue;
    }

    public String getTopicName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mTopicName;
        }
        return (String) invokeV.objValue;
    }

    public String getValuationTxt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mValuationTxt;
        }
        return (String) invokeV.objValue;
    }

    public String getValuationUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mValuationUrl;
        }
        return (String) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                JSONObject optJSONObject = jSONObject.optJSONObject(Config.TRACE_VISIT_FIRST);
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
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        Commodity commodity = new Commodity();
                        commodity.setName(jSONObject2.getString("name"));
                        commodity.setValue(jSONObject2.optString("value", ""));
                        commodity.setColor(jSONObject2.optString("color", "#000000"));
                        this.mCommodity[i] = commodity;
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
            } catch (JSONException e) {
                LogUtils.e("SmartMsg", "parseJsonString JSONException", e);
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
                jSONObject.put(Config.TRACE_VISIT_FIRST, jSONObject2);
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

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
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
            if (commodityArr != null) {
                i2 = commodityArr.length;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (i2 > 0) {
                parcel.writeTypedArray(this.mCommodity, i);
            }
            parcel.writeString(this.mValuationUrl);
            parcel.writeString(this.mValuationTxt);
            parcel.writeLong(this.mTopicId);
            parcel.writeString(this.mTopicName);
        }
    }
}
