package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AdvisoryMultiPicMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<AdvisoryMultiPicMsg> CREATOR;
    public static final String TAG = "AdvisoryMultiPicMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isHide;
    public String mBusinessExt;
    public String mDesc;
    public List<AdvisoryImageItem> mImageList;
    public int mImageNum;
    public long mReceiveBduid;
    public long mSendBduid;
    public String mText;

    /* loaded from: classes.dex */
    public static class AdvisoryImageItem implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<AdvisoryImageItem> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int mHeight;
        public int mIndex;
        public String mThumbnail;
        public String mUrl;
        public int mWidth;

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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065491887, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryMultiPicMsg$AdvisoryImageItem;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1065491887, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryMultiPicMsg$AdvisoryImageItem;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<AdvisoryImageItem>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryMultiPicMsg.AdvisoryImageItem.1
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
                public AdvisoryImageItem createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new AdvisoryImageItem(parcel);
                    }
                    return (AdvisoryImageItem) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public AdvisoryImageItem[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new AdvisoryImageItem[i];
                    }
                    return (AdvisoryImageItem[]) invokeI.objValue;
                }
            };
        }

        public AdvisoryImageItem() {
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

        public int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mHeight;
            }
            return invokeV.intValue;
        }

        public int getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mIndex;
            }
            return invokeV.intValue;
        }

        public String getThumbnail() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mThumbnail;
            }
            return (String) invokeV.objValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mUrl;
            }
            return (String) invokeV.objValue;
        }

        public int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mWidth;
            }
            return invokeV.intValue;
        }

        public AdvisoryImageItem(Parcel parcel) {
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
            this.mIndex = parcel.readInt();
            this.mUrl = parcel.readString();
            this.mThumbnail = parcel.readString();
            this.mWidth = parcel.readInt();
            this.mHeight = parcel.readInt();
        }

        public void setHeight(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.mHeight = i;
            }
        }

        public void setIndex(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.mIndex = i;
            }
        }

        public void setThumbnail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.mThumbnail = str;
            }
        }

        public void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.mUrl = str;
            }
        }

        public void setWidth(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                this.mWidth = i;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i) == null) {
                parcel.writeInt(this.mIndex);
                parcel.writeString(this.mUrl);
                parcel.writeString(this.mThumbnail);
                parcel.writeInt(this.mWidth);
                parcel.writeInt(this.mHeight);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-598462112, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryMultiPicMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-598462112, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryMultiPicMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryMultiPicMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryMultiPicMsg.1
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
            public AdvisoryMultiPicMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryMultiPicMsg(parcel);
                }
                return (AdvisoryMultiPicMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryMultiPicMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryMultiPicMsg[i];
                }
                return (AdvisoryMultiPicMsg[]) invokeI.objValue;
            }
        };
    }

    public AdvisoryMultiPicMsg() {
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
        setMsgType(43);
    }

    public String getBusinessExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBusinessExt;
        }
        return (String) invokeV.objValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDesc;
        }
        return (String) invokeV.objValue;
    }

    public List<AdvisoryImageItem> getImageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mImageList;
        }
        return (List) invokeV.objValue;
    }

    public int getImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mImageNum;
        }
        return invokeV.intValue;
    }

    public long getReceiveBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mReceiveBduid;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mText;
        }
        return (String) invokeV.objValue;
    }

    public long getSendBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mSendBduid;
        }
        return invokeV.longValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mText;
        }
        return (String) invokeV.objValue;
    }

    public boolean isHide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isHide;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvisoryMultiPicMsg(Parcel parcel) {
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
        this.mSendBduid = parcel.readLong();
        this.mReceiveBduid = parcel.readLong();
        this.mText = parcel.readString();
        this.mDesc = parcel.readString();
        this.mBusinessExt = parcel.readString();
        this.mImageNum = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!TextUtils.isEmpty(this.mjsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mjsonContent);
                    this.mSendBduid = jSONObject.optLong("buid");
                    this.mReceiveBduid = jSONObject.optLong("tobuid");
                    this.mBusinessExt = jSONObject.optString("business_ext");
                    this.mText = jSONObject.optString("text");
                    this.mDesc = jSONObject.optString("desc");
                    this.mImageNum = jSONObject.optInt("image_num");
                    JSONArray optJSONArray = jSONObject.optJSONArray("images");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.mImageList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            AdvisoryImageItem advisoryImageItem = new AdvisoryImageItem();
                            advisoryImageItem.setIndex(jSONObject2.optInt("index"));
                            advisoryImageItem.setUrl(jSONObject2.optString("url"));
                            advisoryImageItem.setThumbnail(jSONObject2.optString("thumbnail"));
                            advisoryImageItem.setWidth(jSONObject2.optInt("w"));
                            advisoryImageItem.setHeight(jSONObject2.optInt("h"));
                            this.mImageList.add(advisoryImageItem);
                        }
                    }
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
        if (interceptable == null || interceptable.invokeLI(1048586, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.mSendBduid);
            parcel.writeLong(this.mReceiveBduid);
            parcel.writeString(this.mText);
            parcel.writeString(this.mDesc);
            parcel.writeString(this.mBusinessExt);
            parcel.writeInt(this.mImageNum);
        }
    }
}
