package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
public class AdvisoryExtensionMsgExtra implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<AdvisoryExtensionMsgExtra> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String aid;
    public String businessExt;
    public int hideInList;
    public int rounds;
    public int subType;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1189455070, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryExtensionMsgExtra;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1189455070, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryExtensionMsgExtra;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryExtensionMsgExtra>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryExtensionMsgExtra.1
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
            public AdvisoryExtensionMsgExtra createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryExtensionMsgExtra(parcel);
                }
                return (AdvisoryExtensionMsgExtra) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryExtensionMsgExtra[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryExtensionMsgExtra[i];
                }
                return (AdvisoryExtensionMsgExtra[]) invokeI.objValue;
            }
        };
    }

    public AdvisoryExtensionMsgExtra() {
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

    public String getAid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.aid;
        }
        return (String) invokeV.objValue;
    }

    public String getFullBusinessExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.businessExt;
        }
        return (String) invokeV.objValue;
    }

    public int getHideInList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.hideInList;
        }
        return invokeV.intValue;
    }

    public int getRounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.rounds;
        }
        return invokeV.intValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.subType;
        }
        return invokeV.intValue;
    }

    public AdvisoryExtensionMsgExtra(Parcel parcel) {
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
        this.subType = parcel.readInt();
        this.hideInList = parcel.readInt();
        this.aid = parcel.readString();
        this.businessExt = parcel.readString();
    }

    public static AdvisoryExtensionMsgExtra parseAdvisoryExtensionMsgExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            AdvisoryExtensionMsgExtra advisoryExtensionMsgExtra = new AdvisoryExtensionMsgExtra();
            try {
                if (TextUtils.isEmpty(str)) {
                    return advisoryExtensionMsgExtra;
                }
                JSONObject jSONObject = new JSONObject(str);
                advisoryExtensionMsgExtra.setSubType(jSONObject.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                advisoryExtensionMsgExtra.setAid(jSONObject.optString("aid"));
                advisoryExtensionMsgExtra.setHideInList(jSONObject.optInt("hideInList"));
                advisoryExtensionMsgExtra.setRounds(jSONObject.optInt(AdvisoryMsgBusinessExtra.ROUNDS_KEY));
                advisoryExtensionMsgExtra.setBusinessExt(str);
                return advisoryExtensionMsgExtra;
            } catch (JSONException e) {
                e.printStackTrace();
                return advisoryExtensionMsgExtra;
            }
        }
        return (AdvisoryExtensionMsgExtra) invokeL.objValue;
    }

    private void setBusinessExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            this.businessExt = str;
        }
    }

    public void setAid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.aid = str;
        }
    }

    public void setHideInList(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.hideInList = i;
        }
    }

    public void setRounds(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.rounds = i;
        }
    }

    public void setSubType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.subType = i;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, parcel, i) == null) {
            parcel.writeInt(this.subType);
            parcel.writeInt(this.hideInList);
            parcel.writeString(this.aid);
            parcel.writeString(this.businessExt);
        }
    }
}
