package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaBroadcastGiftToastData extends rw4 implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<AlaBroadcastGiftToastData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public long gift_id;
    public String gift_name;
    public long live_id;
    public long msg_id;
    public String receiver;
    public String sender;
    public String sender_portrait;
    public String thumbnail_url;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<AlaBroadcastGiftToastData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AlaBroadcastGiftToastData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new AlaBroadcastGiftToastData(parcel);
            }
            return (AlaBroadcastGiftToastData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new AlaBroadcastGiftToastData[i];
            }
            return (AlaBroadcastGiftToastData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1381826531, "Lcom/baidu/tbadk/core/data/AlaBroadcastGiftToastData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1381826531, "Lcom/baidu/tbadk/core/data/AlaBroadcastGiftToastData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public AlaBroadcastGiftToastData() {
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

    public AlaBroadcastGiftToastData(Parcel parcel) {
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
        this.live_id = parcel.readLong();
        this.sender = parcel.readString();
        this.receiver = parcel.readString();
        this.gift_id = parcel.readLong();
        this.gift_name = parcel.readString();
        this.msg_id = parcel.readLong();
        this.sender_portrait = parcel.readString();
        this.thumbnail_url = parcel.readString();
    }

    @Override // com.baidu.tieba.rw4
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.live_id = jSONObject.optLong("live_id", 0L);
        this.sender = jSONObject.optString("sender");
        this.sender_portrait = jSONObject.optString("sender_portrait");
        this.receiver = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
        this.gift_id = jSONObject.optLong("gift_id", 0L);
        this.gift_name = jSONObject.optString("gift_name");
        this.msg_id = jSONObject.optLong("msg_id", 0L);
        this.thumbnail_url = jSONObject.optString("gift_url");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeLong(this.live_id);
            parcel.writeString(this.sender);
            parcel.writeString(this.receiver);
            parcel.writeLong(this.gift_id);
            parcel.writeString(this.gift_name);
            parcel.writeLong(this.msg_id);
            parcel.writeString(this.sender_portrait);
            parcel.writeString(this.thumbnail_url);
        }
    }
}
