package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class AdvisoryResponderIntroMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<AdvisoryResponderIntroMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public String backGroundImg;
    public List<Pair<String, String>> badges;
    public int couponNum;
    public String domains;
    public int followStatus;
    public int helpCount;
    public String homeScheme;
    public String leftBusinessText;
    public String leftBusinessTextColor;
    public List<String> leftImages;
    public String name;
    public String orderReplierCardTip;
    public int price;
    public String qualification;
    public String rightBusinessText;
    public String rightBusinessTextColor;
    public int showSubsidy;
    public String signature;
    public String targetAid;
    public String uk1;
    public String uk2;
    public int userType;
    public String vTypeImg;
    public double valueScore;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1766012697, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryResponderIntroMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1766012697, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryResponderIntroMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryResponderIntroMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryResponderIntroMsg.1
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
            public AdvisoryResponderIntroMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryResponderIntroMsg(parcel);
                }
                return (AdvisoryResponderIntroMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryResponderIntroMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryResponderIntroMsg[i];
                }
                return (AdvisoryResponderIntroMsg[]) invokeI.objValue;
            }
        };
    }

    public String getBackGroundImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.backGroundImg;
        }
        return (String) invokeV.objValue;
    }

    public String getLeftBusinessText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.leftBusinessText;
        }
        return (String) invokeV.objValue;
    }

    public String getLeftBusinessTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.leftBusinessTextColor;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getLeftImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.leftImages;
        }
        return (List) invokeV.objValue;
    }

    public String getRightBusinessText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.rightBusinessText;
        }
        return (String) invokeV.objValue;
    }

    public String getRightBusinessTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.rightBusinessTextColor;
        }
        return (String) invokeV.objValue;
    }

    public String getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.signature;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvisoryResponderIntroMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = parcel.readString();
        this.homeScheme = parcel.readString();
        this.avatar = parcel.readString();
        this.helpCount = parcel.readInt();
        this.qualification = parcel.readString();
        this.domains = parcel.readString();
        this.signature = parcel.readString();
        this.vTypeImg = parcel.readString();
        this.userType = parcel.readInt();
        this.showSubsidy = parcel.readInt();
        this.price = parcel.readInt();
        this.couponNum = parcel.readInt();
        this.valueScore = parcel.readDouble();
        this.orderReplierCardTip = parcel.readString();
        this.targetAid = parcel.readString();
        this.uk1 = parcel.readString();
        this.uk2 = parcel.readString();
        parcel.readList(this.badges, AdvisoryResponderIntroMsg.class.getClassLoader());
        this.followStatus = parcel.readInt();
        parcel.readList(this.leftImages, String.class.getClassLoader());
        this.leftBusinessText = parcel.readString();
        this.leftBusinessTextColor = parcel.readString();
        this.rightBusinessText = parcel.readString();
        this.rightBusinessTextColor = parcel.readString();
        this.backGroundImg = parcel.readString();
    }

    public AdvisoryResponderIntroMsg(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, int i3, int i4, int i5, double d, String str7, String str8, String str9, String str10, List<Pair<String, String>> list, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i), str4, str5, str6, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Double.valueOf(d), str7, str8, str9, str10, list, Integer.valueOf(i6)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setMsgType(2020);
        this.name = str;
        this.homeScheme = str2;
        this.avatar = str3;
        this.helpCount = i;
        this.qualification = str4;
        this.domains = str5;
        this.vTypeImg = str6;
        this.userType = i2;
        this.showSubsidy = i3;
        this.price = i4;
        this.couponNum = i5;
        this.valueScore = d;
        this.orderReplierCardTip = str7;
        this.targetAid = str8;
        this.uk1 = str9;
        this.uk2 = str10;
        this.badges = list;
        this.followStatus = i6;
    }

    public void setBackGroundImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.backGroundImg = str;
        }
    }

    public void setLeftBusinessText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.leftBusinessText = str;
        }
    }

    public void setLeftBusinessTextColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.leftBusinessTextColor = str;
        }
    }

    public void setLeftImages(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.leftImages = list;
        }
    }

    public void setRightBusinessText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.rightBusinessText = str;
        }
    }

    public void setRightBusinessTextColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.rightBusinessTextColor = str;
        }
    }

    public void setSignature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.signature = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.name);
            parcel.writeString(this.homeScheme);
            parcel.writeString(this.avatar);
            parcel.writeInt(this.helpCount);
            parcel.writeString(this.qualification);
            parcel.writeString(this.domains);
            parcel.writeString(this.signature);
            parcel.writeString(this.vTypeImg);
            parcel.writeInt(this.userType);
            parcel.writeInt(this.showSubsidy);
            parcel.writeInt(this.price);
            parcel.writeInt(this.couponNum);
            parcel.writeDouble(this.valueScore);
            parcel.writeString(this.orderReplierCardTip);
            parcel.writeString(this.targetAid);
            parcel.writeString(this.uk1);
            parcel.writeString(this.uk2);
            parcel.writeList(this.badges);
            parcel.writeInt(this.followStatus);
            parcel.writeList(this.leftImages);
            parcel.writeString(this.leftBusinessText);
            parcel.writeString(this.leftBusinessTextColor);
            parcel.writeString(this.rightBusinessText);
            parcel.writeString(this.rightBusinessTextColor);
            parcel.writeString(this.backGroundImg);
        }
    }
}
