package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
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
public class DuPaBInfoMsg extends ChatMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String B_ACTION = "action";
    public static final int B_ACTION_ENTER = 1;
    public static final String B_ADDR = "addr";
    public static final String B_IP = "ip";
    public static final String B_LATITUDE = "latitude";
    public static final String B_LONGITUDE = "longitude";
    public static final String B_TIME = "time";
    public static final Parcelable.Creator<DuPaBInfoMsg> CREATOR;
    public static final String TAG = "DuPaBInfoMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int action;
    public String addr;
    public String ip;
    public String latitude;
    public String longitude;
    public long time;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(59105388, "Lcom/baidu/android/imsdk/chatmessage/messages/DuPaBInfoMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(59105388, "Lcom/baidu/android/imsdk/chatmessage/messages/DuPaBInfoMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<DuPaBInfoMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg.1
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
            public DuPaBInfoMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new DuPaBInfoMsg(parcel) : (DuPaBInfoMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DuPaBInfoMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new DuPaBInfoMsg[i2] : (DuPaBInfoMsg[]) invokeI.objValue;
            }
        };
    }

    private String getBInfoContentJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.action == 1) {
                    jSONObject.put(B_ADDR, this.addr);
                    jSONObject.put("time", this.time);
                    jSONObject.put("longitude", this.longitude);
                    jSONObject.put("latitude", this.latitude);
                    jSONObject.put("ip", this.ip);
                }
                jSONObject.put("action", this.action);
            } catch (JSONException e2) {
                LogUtils.e(TAG, "getBInfoContentJson :", e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.addr);
            parcel.writeLong(this.time);
            parcel.writeString(this.longitude);
            parcel.writeString(this.latitude);
            parcel.writeString(this.ip);
            parcel.writeInt(this.action);
        }
    }

    public DuPaBInfoMsg(String str, long j, String str2, String str3, String str4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), str2, str3, str4, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setMsgType(31);
        setCategory(7);
        setChatType(7);
        this.addr = str;
        this.time = j;
        this.longitude = str2;
        this.latitude = str3;
        this.ip = str4;
        this.action = i2;
        setMsgContent(getBInfoContentJson());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DuPaBInfoMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.addr = parcel.readString();
        this.time = parcel.readLong();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.ip = parcel.readString();
        this.action = parcel.readInt();
    }
}
