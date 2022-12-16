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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class AdvisoryEvaluationMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<AdvisoryEvaluationMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int allowRefund;
    public int amount;
    public boolean hasRefund;
    public int isFree;
    public String msg;
    public int orderType;
    public String replyerUid;
    public int role;
    public int source;
    public String star_desc;
    public int star_num;
    public List<String> tags;
    public String targetAid;
    public String uk;

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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(899464267, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryEvaluationMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(899464267, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryEvaluationMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryEvaluationMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryEvaluationMsg.1
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
            public AdvisoryEvaluationMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryEvaluationMsg(parcel);
                }
                return (AdvisoryEvaluationMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryEvaluationMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryEvaluationMsg[i];
                }
                return (AdvisoryEvaluationMsg[]) invokeI.objValue;
            }
        };
    }

    public AdvisoryEvaluationMsg(int i, int i2, String str, String str2, List<String> list, int i3, String str3, int i4, int i5, boolean z, String str4, int i6, int i7, String str5, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, str2, list, Integer.valueOf(i3), str3, Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), str4, Integer.valueOf(i6), Integer.valueOf(i7), str5, Integer.valueOf(i8)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i9 = newInitContext.flag;
            if ((i9 & 1) != 0) {
                int i10 = i9 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tags = new ArrayList();
        setMsgType(i);
        this.star_num = i2;
        this.star_desc = str;
        this.msg = str2;
        this.tags = list;
        this.role = i3;
        this.uk = str3;
        this.amount = i4;
        this.isFree = i5;
        this.hasRefund = z;
        this.targetAid = str4;
        this.source = i6;
        this.orderType = i7;
        this.replyerUid = str5;
        this.allowRefund = i8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvisoryEvaluationMsg(Parcel parcel) {
        super(parcel);
        boolean z;
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
        this.tags = new ArrayList();
        this.star_num = parcel.readInt();
        this.star_desc = parcel.readString();
        this.msg = parcel.readString();
        this.tags = parcel.createStringArrayList();
        this.role = parcel.readInt();
        this.uk = parcel.readString();
        this.amount = parcel.readInt();
        this.isFree = parcel.readInt();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.hasRefund = z;
        this.targetAid = parcel.readString();
        this.source = parcel.readInt();
        this.orderType = parcel.readInt();
        this.replyerUid = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.star_num);
            parcel.writeString(this.star_desc);
            parcel.writeString(this.msg);
            parcel.writeStringList(this.tags);
            parcel.writeInt(this.role);
            parcel.writeString(this.uk);
            parcel.writeInt(this.amount);
            parcel.writeInt(this.isFree);
            parcel.writeByte(this.hasRefund ? (byte) 1 : (byte) 0);
            parcel.writeString(this.targetAid);
            parcel.writeInt(this.source);
            parcel.writeInt(this.orderType);
            parcel.writeString(this.replyerUid);
        }
    }
}
