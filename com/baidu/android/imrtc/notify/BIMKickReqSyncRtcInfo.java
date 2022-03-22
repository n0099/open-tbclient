package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.send.BIMUser;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BIMKickReqSyncRtcInfo extends BIMSyncRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMKickReqSyncRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public BIMUser mKickUser;
    public BIMUser mKickedUser;

    public BIMKickReqSyncRtcInfo() {
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
        this.mKickUser = null;
        this.mKickedUser = null;
    }

    public BIMUser getBIMKickUsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mKickUser : (BIMUser) invokeV.objValue;
    }

    public BIMUser getBIMKickedUsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mKickedUser : (BIMUser) invokeV.objValue;
    }

    public void setBIMKickUser(@NonNull BIMUser bIMUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bIMUser) == null) {
            this.mKickUser = bIMUser;
        }
    }

    public void setBIMKickedUser(@NonNull BIMUser bIMUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bIMUser) == null) {
            this.mKickedUser = bIMUser;
        }
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mKickUser.appId);
                jSONObject2.put("uk", this.mKickUser.uk);
                jSONObject2.put("cuid", this.mKickUser.cuid);
                jSONObject2.put("third_userid", IMJni.transBDUID(this.mKickUser.thirdUserId));
                jSONObject2.put("app_version", this.mKickUser.appVersion);
                jSONObject.put("kick_user", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("appid", this.mKickedUser.appId);
                jSONObject3.put("uk", this.mKickedUser.uk);
                jSONObject3.put("cuid", this.mKickedUser.cuid);
                jSONObject3.put("third_userid", IMJni.transBDUID(this.mKickedUser.thirdUserId));
                jSONObject3.put("app_version", this.mKickedUser.appVersion);
                jSONObject.put("kicked_user", jSONObject3);
                LogUtils.d(TAG, "BIMKickReqSyncRtcInfo :" + jSONObject.toString());
                return jSONObject.toString();
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMKickReqSyncRtcInfo Exception ", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "BIMKickReqSyncRtcInfo{" + super.toString() + ", kickUser: uk:" + this.mKickUser.uk + ", appId: " + this.mKickUser.appId + ", cuid:" + this.mKickUser.cuid + ", thirdId: " + this.mKickUser.thirdUserId + ", kickUser: uk:" + this.mKickedUser.uk + ", appId: " + this.mKickedUser.appId + ", cuid:" + this.mKickedUser.cuid + ", thirdId: " + this.mKickedUser.thirdUserId + '}';
        }
        return (String) invokeV.objValue;
    }
}
