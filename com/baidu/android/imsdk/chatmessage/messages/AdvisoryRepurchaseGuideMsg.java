package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AdvisoryRepurchaseGuideMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<AdvisoryRepurchaseGuideMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String askMe;
    public String askMeScheme;
    public String askOther;
    public String askOtherScheme;
    public String avatarUrl;
    public String cardSubTitle;
    public String cardTitle;
    public String domains;
    public int helpCount;
    public String name;
    public String qualification;
    public String ukAsk;
    public String ukReply;
    public int userType;
    public String vTypeImg;
    public double valueScore;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1511297837, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryRepurchaseGuideMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1511297837, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryRepurchaseGuideMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryRepurchaseGuideMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryRepurchaseGuideMsg.1
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
            public AdvisoryRepurchaseGuideMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryRepurchaseGuideMsg(parcel);
                }
                return (AdvisoryRepurchaseGuideMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryRepurchaseGuideMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryRepurchaseGuideMsg[i];
                }
                return (AdvisoryRepurchaseGuideMsg[]) invokeI.objValue;
            }
        };
    }

    public AdvisoryRepurchaseGuideMsg(int i, int i2, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, double d, String str8, String str9, String str10, String str11, String str12, String str13) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4, Integer.valueOf(i3), str5, str6, str7, Double.valueOf(d), str8, str9, str10, str11, str12, str13};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setMsgType(i);
        this.userType = i2;
        this.cardTitle = str;
        this.cardSubTitle = str2;
        this.name = str3;
        this.avatarUrl = str4;
        this.helpCount = i3;
        this.qualification = str5;
        this.domains = str6;
        this.vTypeImg = str7;
        this.valueScore = d;
        this.askMe = str8;
        this.askMeScheme = str9;
        this.askOther = str10;
        this.askOtherScheme = str11;
        this.ukAsk = str12;
        this.ukReply = str13;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvisoryRepurchaseGuideMsg(Parcel parcel) {
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
        this.userType = parcel.readInt();
        this.cardTitle = parcel.readString();
        this.cardSubTitle = parcel.readString();
        this.name = parcel.readString();
        this.avatarUrl = parcel.readString();
        this.helpCount = parcel.readInt();
        this.qualification = parcel.readString();
        this.domains = parcel.readString();
        this.vTypeImg = parcel.readString();
        this.valueScore = parcel.readDouble();
        this.askMe = parcel.readString();
        this.askMeScheme = parcel.readString();
        this.askOther = parcel.readString();
        this.askOtherScheme = parcel.readString();
        this.ukAsk = parcel.readString();
        this.ukReply = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.userType);
            parcel.writeString(this.cardTitle);
            parcel.writeString(this.cardSubTitle);
            parcel.writeString(this.name);
            parcel.writeString(this.avatarUrl);
            parcel.writeInt(this.helpCount);
            parcel.writeString(this.qualification);
            parcel.writeString(this.domains);
            parcel.writeString(this.vTypeImg);
            parcel.writeDouble(this.valueScore);
            parcel.writeString(this.askMe);
            parcel.writeString(this.askMeScheme);
            parcel.writeString(this.askOther);
            parcel.writeString(this.askOtherScheme);
            parcel.writeString(this.ukAsk);
            parcel.writeString(this.ukReply);
        }
    }
}
