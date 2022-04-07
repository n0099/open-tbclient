package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMKickResSyncRtcInfo extends BIMKickReqSyncRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMKickResSyncRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public int mKickedStatus;

    public BIMKickResSyncRtcInfo() {
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

    @Override // com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo, com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
                jSONObject.put("status", this.mKickedStatus);
                LogUtils.d(TAG, "BIMKickResSyncRtcInfo :" + jSONObject.toString());
                return jSONObject.toString();
            } catch (Exception e) {
                LogUtils.e(TAG, "BIMKickResSyncRtcInfo Exception ", e);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo, com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "BIMKickResSyncRtcInfo{" + super.toString() + ", status" + this.mKickedStatus + '}';
        }
        return (String) invokeV.objValue;
    }
}
