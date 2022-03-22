package com.baidu.android.imrtc.send;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BIMAnswerRtcInfo extends BIMRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<BIMAnswerRtcInfo> CREATOR;
    public static final String TAG = "IMAnswerRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAnswerDeviceInfo;
    public int mAnswerMediaType;
    public int mAnswerType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(498275401, "Lcom/baidu/android/imrtc/send/BIMAnswerRtcInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(498275401, "Lcom/baidu/android/imrtc/send/BIMAnswerRtcInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<BIMAnswerRtcInfo>() { // from class: com.baidu.android.imrtc.send.BIMAnswerRtcInfo.1
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
            public BIMAnswerRtcInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new BIMAnswerRtcInfo(parcel) : (BIMAnswerRtcInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BIMAnswerRtcInfo[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new BIMAnswerRtcInfo[i] : (BIMAnswerRtcInfo[]) invokeI.objValue;
            }
        };
    }

    public BIMAnswerRtcInfo(BIMRtcInfo bIMRtcInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bIMRtcInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    public String getAnswerDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAnswerDeviceInfo : (String) invokeV.objValue;
    }

    public int getAnswerMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAnswerMediaType : invokeV.intValue;
    }

    public int getAnswerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAnswerType : invokeV.intValue;
    }

    public void setAnswerDeviceInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mAnswerDeviceInfo = str;
        }
    }

    public void setAnswerMediaType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mAnswerMediaType = i;
        }
    }

    public void setAnswerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.mAnswerType = i;
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, str, str2)) == null) {
            BIMAnswerRtcInfo bIMAnswerRtcInfo = new BIMAnswerRtcInfo(super.toRtcInfo(i, str, str2));
            try {
                JSONObject jSONObject = new JSONObject(str2);
                bIMAnswerRtcInfo.setAnswerType(jSONObject.optInt("answer_type"));
                bIMAnswerRtcInfo.setAnswerMediaType(jSONObject.optInt("answer_media_type"));
                bIMAnswerRtcInfo.setAnswerDeviceInfo(jSONObject.optString("answer_device_info"));
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMAnswerRtcInfo toRtcInfo Exception ", e2);
            }
            return bIMAnswerRtcInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
                jSONObject.put("answer_type", this.mAnswerType);
                jSONObject.put("answer_media_type", this.mAnswerMediaType);
                jSONObject.put("answer_device_info", this.mAnswerDeviceInfo);
                return jSONObject.toString();
            } catch (Exception e2) {
                LogUtils.e(TAG, "IMAnswerRtcInfo Exception ", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "BIMAnswerRtcInfo{" + super.toString() + ", mAnswerDeviceInfo='" + this.mAnswerDeviceInfo + "', mAnswerType=" + this.mAnswerType + ", mAnswerMediaType=" + this.mAnswerMediaType + '}';
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mAnswerDeviceInfo);
            parcel.writeInt(this.mAnswerType);
            parcel.writeInt(this.mAnswerMediaType);
        }
    }

    public BIMAnswerRtcInfo() {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BIMAnswerRtcInfo(Parcel parcel) {
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
        this.mAnswerDeviceInfo = parcel.readString();
        this.mAnswerType = parcel.readInt();
        this.mAnswerMediaType = parcel.readInt();
    }
}
