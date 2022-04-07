package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
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
public class BIMKickResponseRtcInfo extends BIMKickRequestRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMKickResponseRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public int mKickedStatus;

    public BIMKickResponseRtcInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mKickedStatus = 0;
    }

    public int getBIMKickedStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mKickedStatus : invokeV.intValue;
    }

    public void setBIMKickedStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.mKickedStatus = i;
        }
    }

    @Override // com.baidu.android.imrtc.send.BIMKickRequestRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2)) == null) {
            BIMKickResponseRtcInfo bIMKickResponseRtcInfo = new BIMKickResponseRtcInfo(super.toRtcInfo(i, str, str2));
            try {
                bIMKickResponseRtcInfo.setBIMKickedStatus(new JSONObject(str2).optInt("status"));
            } catch (Exception e) {
                LogUtils.e(TAG, "BIMKickResponseRtcInfo toRtcInfo Exception ", e);
            }
            return bIMKickResponseRtcInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.send.BIMKickRequestRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
                jSONObject.put("status", this.mKickedStatus);
                LogUtils.d(TAG, "BIMKickResponseRtcInfo :" + jSONObject.toString());
                return jSONObject.toString();
            } catch (Exception e) {
                LogUtils.e(TAG, "BIMKickResponseRtcInfo Exception ", e);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.send.BIMKickRequestRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "BIMKickResponseRtcInfo{" + super.toString() + ", status" + this.mKickedStatus + '}';
        }
        return (String) invokeV.objValue;
    }

    public BIMKickResponseRtcInfo(BIMRtcInfo bIMRtcInfo) {
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
        this.mKickedStatus = 0;
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }
}
