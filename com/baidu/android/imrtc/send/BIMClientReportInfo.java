package com.baidu.android.imrtc.send;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BIMClientReportInfo extends BIMRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<BIMClientReportInfo> CREATOR;
    public static final String TAG = "BIMClientReportInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public long mEvent;
    public String mExtInfo;
    public String mMethod;
    public String mRtcType;
    public String mUk;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1564443569, "Lcom/baidu/android/imrtc/send/BIMClientReportInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1564443569, "Lcom/baidu/android/imrtc/send/BIMClientReportInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<BIMClientReportInfo>() { // from class: com.baidu.android.imrtc.send.BIMClientReportInfo.1
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
            public BIMClientReportInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new BIMClientReportInfo(parcel) : (BIMClientReportInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BIMClientReportInfo[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new BIMClientReportInfo[i2] : (BIMClientReportInfo[]) invokeI.objValue;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BIMClientReportInfo(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mRtcType = parcel.readString();
        this.mMethod = parcel.readString();
        this.mUk = parcel.readString();
        this.mEvent = parcel.readLong();
        this.mRtcExt = parcel.readString();
    }

    public long getEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mEvent : invokeV.longValue;
    }

    public String getExtInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mExtInfo : (String) invokeV.objValue;
    }

    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMethod : (String) invokeV.objValue;
    }

    public String getRtcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRtcType : (String) invokeV.objValue;
    }

    public String getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUk : (String) invokeV.objValue;
    }

    public void setEvent(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.mEvent = j2;
        }
    }

    public void setExtInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mExtInfo = str;
        }
    }

    public void setMethod(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mMethod = str;
        }
    }

    public void setRtcType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mRtcType = str;
        }
    }

    public void setUk(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mUk = str;
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, str, str2)) == null) {
            BIMClientReportInfo bIMClientReportInfo = new BIMClientReportInfo(super.toRtcInfo(i2, str, str2));
            try {
                JSONObject jSONObject = new JSONObject(str2);
                bIMClientReportInfo.setMethod(jSONObject.optString("method"));
                bIMClientReportInfo.setUk(jSONObject.optString("uk"));
                bIMClientReportInfo.setExtInfo(jSONObject.optString(ARConfigKey.EXTRA_INFO));
                bIMClientReportInfo.setRtcType(jSONObject.optString("rtc_type"));
                bIMClientReportInfo.setEvent(jSONObject.optLong("event"));
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMAnswerRtcInfo toRtcInfo Exception ", e2);
            }
            return bIMClientReportInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rtc_type", this.mRtcType);
                jSONObject2.put("method", this.mMethod);
                jSONObject2.put("uk", this.mUk);
                jSONObject2.put("event", this.mEvent);
                jSONObject2.put(ARConfigKey.EXTRA_INFO, this.mExtInfo);
                jSONObject.put("rtc_quality_info", jSONObject2);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "BIMClientReportInfo{mRtcType='" + this.mRtcType + ExtendedMessageFormat.QUOTE + ", mMethod='" + this.mMethod + ExtendedMessageFormat.QUOTE + ", mUk='" + this.mUk + ExtendedMessageFormat.QUOTE + ", mEvent=" + this.mEvent + ", mExtInfo='" + this.mExtInfo + ExtendedMessageFormat.QUOTE + ", mRtcExt='" + this.mRtcExt + ExtendedMessageFormat.QUOTE + ", mSource='" + this.mSource + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.mRtcType);
            parcel.writeString(this.mMethod);
            parcel.writeString(this.mUk);
            parcel.writeLong(this.mEvent);
            parcel.writeString(this.mRtcExt);
        }
    }

    public BIMClientReportInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public BIMClientReportInfo(BIMRtcInfo bIMRtcInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bIMRtcInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
