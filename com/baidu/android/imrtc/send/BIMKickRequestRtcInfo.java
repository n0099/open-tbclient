package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BIMKickRequestRtcInfo extends BIMRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMKickRequestRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public BIMUser mKickUser;
    public BIMUser mKickedUser;

    public BIMKickRequestRtcInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, str, str2)) == null) {
            BIMKickRequestRtcInfo bIMKickRequestRtcInfo = new BIMKickRequestRtcInfo(super.toRtcInfo(i2, str, str2));
            try {
                JSONObject jSONObject = new JSONObject(str2);
                JSONObject optJSONObject = jSONObject.optJSONObject("kick_user");
                if (optJSONObject != null) {
                    BIMUser bIMUser = new BIMUser();
                    bIMUser.appId = optJSONObject.optLong("appid");
                    bIMUser.uk = optJSONObject.optLong("uk");
                    bIMUser.cuid = optJSONObject.optString("cuid");
                    bIMUser.thirdUserId = optJSONObject.optString("third_userid");
                    bIMKickRequestRtcInfo.setBIMKickUser(bIMUser);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("kicked_user");
                if (optJSONObject2 != null) {
                    BIMUser bIMUser2 = new BIMUser();
                    bIMUser2.appId = optJSONObject2.optLong("appid");
                    bIMUser2.uk = optJSONObject2.optLong("uk");
                    bIMUser2.cuid = optJSONObject2.optString("cuid");
                    bIMUser2.thirdUserId = optJSONObject2.optString("third_userid");
                    bIMKickRequestRtcInfo.setBIMKickedUser(bIMUser2);
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMKickRequestRtcInfo toRtcInfo Exception ", e2);
            }
            return bIMKickRequestRtcInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
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
                LogUtils.d(TAG, "BIMKickRequestRtcInfo :" + jSONObject.toString());
                return jSONObject.toString();
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMKickRequestRtcInfo Exception ", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "BIMKickRequestRtcInfo{" + super.toString() + ", kickUser: uk:" + this.mKickUser.uk + ", appId: " + this.mKickUser.appId + ", cuid:" + this.mKickUser.cuid + ", thirdId: " + this.mKickUser.thirdUserId + ", kickUser: uk:" + this.mKickedUser.uk + ", appId: " + this.mKickedUser.appId + ", cuid:" + this.mKickedUser.cuid + ", thirdId: " + this.mKickedUser.thirdUserId + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public BIMKickRequestRtcInfo(BIMRtcInfo bIMRtcInfo) {
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
        this.mKickUser = null;
        this.mKickedUser = null;
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }
}
