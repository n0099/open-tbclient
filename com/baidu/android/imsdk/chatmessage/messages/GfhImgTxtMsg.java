package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GfhImgTxtMsg extends GfhBaseMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<GfhImgTxtMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public GfhImage image;
    public String subText;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035075060, "Lcom/baidu/android/imsdk/chatmessage/messages/GfhImgTxtMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035075060, "Lcom/baidu/android/imsdk/chatmessage/messages/GfhImgTxtMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GfhImgTxtMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GfhImgTxtMsg.1
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
            public GfhImgTxtMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new GfhImgTxtMsg(parcel);
                }
                return (GfhImgTxtMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GfhImgTxtMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new GfhImgTxtMsg[i];
                }
                return (GfhImgTxtMsg[]) invokeI.objValue;
            }
        };
    }

    public GfhImgTxtMsg() {
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
        setMsgType(50);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GfhImgTxtMsg(Parcel parcel) {
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
        this.subText = parcel.readString();
        this.image = (GfhImage) parcel.readParcelable(GfhImage.class.getClassLoader());
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.GfhBaseMsg
    public void parseSpecificJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null) {
            this.subText = jSONObject.optString("sub_text");
            JSONObject optJSONObject = jSONObject.optJSONObject("images");
            if (optJSONObject != null) {
                GfhImage gfhImage = new GfhImage();
                this.image = gfhImage;
                gfhImage.url = optJSONObject.optString("url");
                this.image.thumbnail = optJSONObject.optString("thumbnail");
                this.image.width = optJSONObject.optInt("w");
                this.image.height = optJSONObject.optInt("h");
                this.image.title = optJSONObject.optString("title");
                this.image.subTitle = optJSONObject.optString("sub_title");
            }
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.GfhBaseMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.subText);
            parcel.writeParcelable(this.image, i);
        }
    }
}
