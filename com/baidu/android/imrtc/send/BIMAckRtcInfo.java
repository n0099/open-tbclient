package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BIMAckRtcInfo extends BIMRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMAckRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAckSeqId;
    public int mAppState;
    public long mImUK;
    public int mSyncAction;

    public BIMAckRtcInfo(BIMRtcInfo bIMRtcInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bIMRtcInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    public long getAckSeqId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAckSeqId : invokeV.longValue;
    }

    public long getImUK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mImUK : invokeV.longValue;
    }

    public int getSyncAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSyncAction : invokeV.intValue;
    }

    public int getmAppState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppState : invokeV.intValue;
    }

    public void setAckSeqId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.mAckSeqId = j2;
        }
    }

    public void setImUK(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.mImUK = j2;
        }
    }

    public void setSyncAction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mSyncAction = i2;
        }
    }

    public void setmAppState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mAppState = i2;
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str, str2)) == null) {
            BIMAckRtcInfo bIMAckRtcInfo = new BIMAckRtcInfo(super.toRtcInfo(i2, str, str2));
            try {
                JSONObject jSONObject = new JSONObject(str2);
                bIMAckRtcInfo.setAckSeqId(jSONObject.optLong("ack_seqid"));
                bIMAckRtcInfo.setSyncAction(jSONObject.optInt("ack_action"));
                bIMAckRtcInfo.setImUK(jSONObject.optLong("uk"));
                bIMAckRtcInfo.setmAppState(jSONObject.optInt("app_stats"));
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMAckRtcInfo toRtcInfo Exception ", e2);
            }
            return bIMAckRtcInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
                jSONObject.put("ack_seqid", this.mAckSeqId);
                jSONObject.put("ack_action", this.mSyncAction);
                jSONObject.put("uk", this.mImUK);
                jSONObject.put("app_stats", this.mAppState);
                return jSONObject.toString();
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMAckRtcInfo Exception ", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "BIMAckRtcInfo{" + super.toString() + ", mAckSeqId='" + this.mAckSeqId + ExtendedMessageFormat.QUOTE + ", mSyncAction=" + this.mSyncAction + ", mImUK=" + this.mImUK + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public BIMAckRtcInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
