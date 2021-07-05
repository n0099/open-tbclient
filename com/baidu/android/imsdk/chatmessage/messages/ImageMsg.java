package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class ImageMsg extends RichMediaMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ImageMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int mHeight;
    public String mThumbUrl;
    public int mWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485257639, "Lcom/baidu/android/imsdk/chatmessage/messages/ImageMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-485257639, "Lcom/baidu/android/imsdk/chatmessage/messages/ImageMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<ImageMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ImageMsg.1
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
            public ImageMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new ImageMsg(parcel) : (ImageMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ImageMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new ImageMsg[i2] : (ImageMsg[]) invokeI.objValue;
            }
        };
    }

    public ImageMsg() {
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
        this.mThumbUrl = null;
        this.mWidth = 0;
        this.mHeight = 0;
        setMsgType(1);
    }

    private String getImgContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("thumbnail", this.mThumbUrl);
                if (this.mWidth > 0 && this.mHeight > 0) {
                    jSONObject.put("w", this.mWidth);
                    jSONObject.put("h", this.mHeight);
                }
                return jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "getImgContent JSONObject", e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHeight : invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "[图片]" : (String) invokeV.objValue;
    }

    public String getThumbUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mThumbUrl : (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mWidth : invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.mjsonContent)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.mjsonContent);
                this.mRemoteUrl = jSONObject.optString("url");
                this.mThumbUrl = jSONObject.optString("thumbnail");
                this.mWidth = jSONObject.optInt("w", 0);
                this.mHeight = jSONObject.optInt("h", 0);
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setContent(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, str, i2, i3) == null) {
            this.mWidth = i2;
            this.mHeight = i3;
            setMsgContent(getImgContent(str));
        }
    }

    public void setImgWH(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.mWidth = i2;
            this.mHeight = i3;
        }
    }

    public void setThumbUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mThumbUrl = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.mHeight);
            parcel.writeInt(this.mWidth);
            parcel.writeString(this.mThumbUrl);
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            setMsgContent(getImgContent(str));
        }
    }

    public ImageMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mThumbUrl = null;
        this.mWidth = 0;
        this.mHeight = 0;
        setMsgType(1);
        setLocalUrl(str);
    }

    public ImageMsg(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65540, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65540, newInitContext);
                return;
            }
        }
        this.mThumbUrl = null;
        this.mWidth = 0;
        this.mHeight = 0;
        setMsgType(1);
        setLocalUrl(str);
        this.mWidth = i2;
        this.mHeight = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageMsg(Parcel parcel) {
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
        this.mThumbUrl = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mThumbUrl = parcel.readString();
    }
}
