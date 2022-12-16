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
public class AdvisoryUnAssignedAskGuideMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<AdvisoryUnAssignedAskGuideMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String cacheStr;
    public int canClose;
    public String cardSubTitle;
    public String cardTitle;
    public String changeBtnText;
    public String changeScheme;
    public String contentFirstTip;
    public String contentSecondTip;
    public String contentTitle;
    public String ukAsk;
    public String ukReply;

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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1540709959, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryUnAssignedAskGuideMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1540709959, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryUnAssignedAskGuideMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryUnAssignedAskGuideMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryUnAssignedAskGuideMsg.1
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
            public AdvisoryUnAssignedAskGuideMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryUnAssignedAskGuideMsg(parcel);
                }
                return (AdvisoryUnAssignedAskGuideMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryUnAssignedAskGuideMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryUnAssignedAskGuideMsg[i];
                }
                return (AdvisoryUnAssignedAskGuideMsg[]) invokeI.objValue;
            }
        };
    }

    public boolean isCanClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.canClose == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public AdvisoryUnAssignedAskGuideMsg(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, str5, str6, str7, str8, str9};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setMsgType(i);
        this.cardTitle = str;
        this.cardSubTitle = str2;
        this.contentTitle = str3;
        this.contentFirstTip = str4;
        this.contentSecondTip = str5;
        this.changeScheme = str7;
        this.changeBtnText = str6;
        this.ukAsk = str8;
        this.ukReply = str9;
    }

    public AdvisoryUnAssignedAskGuideMsg(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, str5, str6, str7, str8, str9, str10};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setMsgType(i);
        this.cardTitle = str;
        this.cardSubTitle = str2;
        this.contentTitle = str3;
        this.contentFirstTip = str4;
        this.contentSecondTip = str5;
        this.changeScheme = str7;
        this.changeBtnText = str6;
        this.ukAsk = str8;
        this.ukReply = str9;
        this.cacheStr = str10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvisoryUnAssignedAskGuideMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.cardTitle = parcel.readString();
        this.cardSubTitle = parcel.readString();
        this.contentTitle = parcel.readString();
        this.contentFirstTip = parcel.readString();
        this.contentSecondTip = parcel.readString();
        this.changeScheme = parcel.readString();
        this.changeBtnText = parcel.readString();
        this.canClose = parcel.readInt();
        this.ukAsk = parcel.readString();
        this.ukReply = parcel.readString();
    }

    public void setCanClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.canClose = z ? 1 : 0;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.cardTitle);
            parcel.writeString(this.cardSubTitle);
            parcel.writeString(this.contentTitle);
            parcel.writeString(this.contentFirstTip);
            parcel.writeString(this.contentSecondTip);
            parcel.writeString(this.changeScheme);
            parcel.writeString(this.changeBtnText);
            parcel.writeInt(this.canClose);
            parcel.writeString(this.ukAsk);
            parcel.writeString(this.ukReply);
        }
    }
}
