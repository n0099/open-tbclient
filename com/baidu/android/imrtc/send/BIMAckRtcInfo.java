package com.baidu.android.imrtc.send;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMAckRtcInfo extends BIMRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMAckRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAckSeqId;
    public int mAppState;
    public long mImUK;
    public int mSyncAction;

    public BIMAckRtcInfo() {
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

    public long getAckSeqId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAckSeqId;
        }
        return invokeV.longValue;
    }

    public long getImUK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImUK;
        }
        return invokeV.longValue;
    }

    public int getSyncAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSyncAction;
        }
        return invokeV.intValue;
    }

    public int getmAppState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAppState;
        }
        return invokeV.intValue;
    }

    public BIMAckRtcInfo(BIMRtcInfo bIMRtcInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bIMRtcInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public void setAckSeqId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.mAckSeqId = j;
        }
    }

    public void setImUK(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.mImUK = j;
        }
    }

    public void setSyncAction(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mSyncAction = i;
        }
    }

    public void setmAppState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mAppState = i;
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str, str2)) == null) {
            BIMAckRtcInfo bIMAckRtcInfo = new BIMAckRtcInfo(super.toRtcInfo(i, str, str2));
            try {
                JSONObject jSONObject = new JSONObject(str2);
                bIMAckRtcInfo.setAckSeqId(jSONObject.optLong("ack_seqid"));
                bIMAckRtcInfo.setSyncAction(jSONObject.optInt("ack_action"));
                bIMAckRtcInfo.setImUK(jSONObject.optLong("uk"));
                bIMAckRtcInfo.setmAppState(jSONObject.optInt("app_stats"));
            } catch (Exception e) {
                LogUtils.e(TAG, "BIMAckRtcInfo toRtcInfo Exception ", e);
            }
            return bIMAckRtcInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
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
            } catch (Exception e) {
                LogUtils.e(TAG, "BIMAckRtcInfo Exception ", e);
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
            return "BIMAckRtcInfo{" + super.toString() + ", mAckSeqId='" + this.mAckSeqId + "', mSyncAction=" + this.mSyncAction + ", mImUK=" + this.mImUK + '}';
        }
        return (String) invokeV.objValue;
    }
}
