package com.baidu.android.imrtc;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BIMRtcInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<BIMRtcInfo> CREATOR;
    public static final String TAG = "IMRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public int mAction;
    public String mCuid;
    public String mObj;
    public String mRtcExt;
    public String mRtcRoomId;
    public long mSeq;
    public String mSource;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(138974002, "Lcom/baidu/android/imrtc/BIMRtcInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(138974002, "Lcom/baidu/android/imrtc/BIMRtcInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<BIMRtcInfo>() { // from class: com.baidu.android.imrtc.BIMRtcInfo.1
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
            public BIMRtcInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new BIMRtcInfo(parcel) : (BIMRtcInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BIMRtcInfo[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new BIMRtcInfo[i2] : (BIMRtcInfo[]) invokeI.objValue;
            }
        };
    }

    public BIMRtcInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRtcExt = "";
        this.mSource = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAction : invokeV.intValue;
    }

    public String getRtcDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCuid : (String) invokeV.objValue;
    }

    public String getRtcExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRtcExt : (String) invokeV.objValue;
    }

    public String getRtcRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRtcRoomId : (String) invokeV.objValue;
    }

    public long getSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSeq : invokeV.longValue;
    }

    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSource : (String) invokeV.objValue;
    }

    public void setAction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mAction = i2;
        }
    }

    public void setRtcDeviceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mCuid = str;
        }
    }

    public void setRtcExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mRtcExt = str;
        }
    }

    public void setRtcRoomId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mRtcRoomId = str;
        }
    }

    public void setSeq(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.mSeq = j2;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mSource = str;
        }
    }

    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048589, this, i2, str, str2)) == null) {
            BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                bIMRtcInfo.setAction(i2);
                bIMRtcInfo.setRtcRoomId(str);
                bIMRtcInfo.setRtcExt(jSONObject.optString("ext"));
                bIMRtcInfo.setRtcDeviceId(jSONObject.optString("rtc_device_id"));
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMRtcInfo toRtcInfo Exception ", e2);
            }
            return bIMRtcInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.mAction != 100) {
                    synchronized (RtcConstants.IM_RTC_SDK_SEQ_ID) {
                        if (RtcConstants.IM_RTC_SDK_SEQ_ID.get() == -1) {
                            RtcConstants.IM_RTC_SDK_SEQ_ID.set(System.currentTimeMillis());
                        } else {
                            RtcConstants.IM_RTC_SDK_SEQ_ID.incrementAndGet();
                        }
                        jSONObject.put("seqid", RtcConstants.IM_RTC_SDK_SEQ_ID.get());
                    }
                    jSONObject.put("ext", this.mRtcExt);
                }
                jSONObject.put("rtc_device_id", this.mCuid);
            } catch (Exception e2) {
                LogUtils.e(TAG, "IMSyncRtcInfo Exception ", e2);
            }
            String jSONObject2 = jSONObject.toString();
            this.mObj = jSONObject2;
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "BIMRtcInfo{mAction=" + this.mAction + ", mRtcRoomId='" + this.mRtcRoomId + ExtendedMessageFormat.QUOTE + ", mSeq=" + this.mSeq + ", mCuid='" + this.mCuid + ExtendedMessageFormat.QUOTE + ", mRtcExt='" + this.mRtcExt + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, parcel, i2) == null) {
            parcel.writeInt(this.mAction);
            parcel.writeString(this.mRtcRoomId);
            parcel.writeLong(this.mSeq);
            parcel.writeString(this.mObj);
            parcel.writeString(this.mSource);
        }
    }

    public BIMRtcInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mRtcExt = "";
        this.mSource = "";
        this.mRtcRoomId = str;
    }

    public BIMRtcInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mRtcExt = "";
        this.mSource = "";
        this.mAction = parcel.readInt();
        this.mRtcRoomId = parcel.readString();
        this.mSeq = parcel.readLong();
        this.mObj = parcel.readString();
        this.mSource = parcel.readString();
    }
}
