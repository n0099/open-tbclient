package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GfhCommonMsg extends GfhBaseMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<GfhCommonMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonButton button;
    public GfhImage image;
    public String subText;

    /* loaded from: classes.dex */
    public static class CommonButton implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<CommonButton> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String bgColor;
        public String text;
        public String textColor;
        public String url;

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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1669624195, "Lcom/baidu/android/imsdk/chatmessage/messages/GfhCommonMsg$CommonButton;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1669624195, "Lcom/baidu/android/imsdk/chatmessage/messages/GfhCommonMsg$CommonButton;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<CommonButton>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GfhCommonMsg.CommonButton.1
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
                public CommonButton createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new CommonButton(parcel);
                    }
                    return (CommonButton) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public CommonButton[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new CommonButton[i];
                    }
                    return (CommonButton[]) invokeI.objValue;
                }
            };
        }

        public CommonButton() {
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

        public CommonButton(Parcel parcel) {
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
            this.text = parcel.readString();
            this.url = parcel.readString();
            this.textColor = parcel.readString();
            this.bgColor = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeString(this.text);
                parcel.writeString(this.url);
                parcel.writeString(this.textColor);
                parcel.writeString(this.bgColor);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(915726642, "Lcom/baidu/android/imsdk/chatmessage/messages/GfhCommonMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(915726642, "Lcom/baidu/android/imsdk/chatmessage/messages/GfhCommonMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GfhCommonMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GfhCommonMsg.1
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
            public GfhCommonMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new GfhCommonMsg(parcel);
                }
                return (GfhCommonMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GfhCommonMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new GfhCommonMsg[i];
                }
                return (GfhCommonMsg[]) invokeI.objValue;
            }
        };
    }

    public GfhCommonMsg() {
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
        setMsgType(48);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GfhCommonMsg(Parcel parcel) {
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
        this.button = (CommonButton) parcel.readParcelable(CommonButton.class.getClassLoader());
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
                this.image.width = optJSONObject.optInt(Config.DEVICE_WIDTH);
                this.image.height = optJSONObject.optInt("h");
                this.image.title = optJSONObject.optString("title");
                this.image.subTitle = optJSONObject.optString("sub_title");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(NativeConstants.ID_BUTTON);
            if (optJSONObject2 != null) {
                CommonButton commonButton = new CommonButton();
                this.button = commonButton;
                commonButton.text = optJSONObject2.optString("text");
                this.button.url = optJSONObject2.optString("url");
                this.button.textColor = optJSONObject2.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
                this.button.bgColor = optJSONObject2.optString("bg_color");
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
            parcel.writeParcelable(this.button, i);
        }
    }
}
