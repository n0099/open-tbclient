package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class BIMInviteSyncRtcInfo extends BIMSyncRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMInviteRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public int mMediaType;
    public String mRtcAppId;
    public String mRtcRoomDes;
    public String mRtcRoomName;
    public String mRtcRoomToken;
    public int mRtcRoomType;
    public long mRtcUserId;

    public BIMInviteSyncRtcInfo() {
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

    public String createOpenVideoJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject(this.mRtcExt);
                String optString = jSONObject2.optString("inviter_name");
                String optString2 = jSONObject2.optString("inviter_avatar");
                JSONObject jSONObject3 = new JSONObject(jSONObject2.getJSONObject("push_info").getString("ext"));
                jSONObject.put("inviter_name", optString);
                jSONObject.put("inviter_avatar", optString2);
                jSONObject.put("media_type", this.mMediaType);
                jSONObject.put("room_id", getRtcRoomId());
                jSONObject.put("inviter_passuk", jSONObject3.optString("inviter_passuk"));
                jSONObject.put(TiebaStatic.Params.RESOURCE_ID, jSONObject3.optString(TiebaStatic.Params.RESOURCE_ID));
                jSONObject.put("session_type", jSONObject3.optInt("session_type"));
                jSONObject.put("inviter_imuk", this.mInitiatorUk);
            } catch (Exception e2) {
                LogUtils.d("IMInviteRtcInfo", e2.getMessage());
            }
            LogUtils.d("IMInviteRtcInfo", "info = " + jSONObject.toString());
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public int getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMediaType : invokeV.intValue;
    }

    public String getRtcAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRtcAppId : (String) invokeV.objValue;
    }

    public String getRtcRoomDes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRtcRoomDes : (String) invokeV.objValue;
    }

    public String getRtcRoomName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRtcRoomName : (String) invokeV.objValue;
    }

    public String getRtcRoomToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRtcRoomToken : (String) invokeV.objValue;
    }

    public int getRtcRoomType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRtcRoomType : invokeV.intValue;
    }

    public long getRtcUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRtcUserId : invokeV.longValue;
    }

    public void setMediaType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mMediaType = i2;
        }
    }

    public void setRtcAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mRtcAppId = str;
        }
    }

    public void setRtcRoomDes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mRtcRoomDes = str;
        }
    }

    public void setRtcRoomName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mRtcRoomName = str;
        }
    }

    public void setRtcRoomToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mRtcRoomToken = str;
        }
    }

    public void setRtcRoomType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mRtcRoomType = i2;
        }
    }

    public void setRtcUserId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            this.mRtcUserId = j2;
        }
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(RtcUtility.KEY_RTC_ROOM_NAME, this.mRtcRoomName);
                jSONObject.put(RtcUtility.KEY_RTC_ROOM_TOKEN, this.mRtcRoomToken);
                jSONObject.put("rtc_room_desc", this.mRtcRoomDes);
                jSONObject.put("rtc_room_type", this.mRtcRoomType);
                jSONObject.put("media_type", this.mMediaType);
                jSONObject.put("uk", this.mInitiatorUk);
                jSONObject.put("invite_id", this.mInviteId);
                jSONObject.put("rtc_userid", this.mRtcUserId);
                jSONObject.put("ext", this.mRtcExt);
                return jSONObject.toString();
            } catch (Exception e2) {
                LogUtils.e("IMInviteRtcInfo", "IMInviteRtcInfo Exception ", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "BIMInviteSyncRtcInfo{" + super.toString() + ", mRtcRoomName='" + this.mRtcRoomName + ExtendedMessageFormat.QUOTE + ", mRtcRoomToken='" + this.mRtcRoomToken + ExtendedMessageFormat.QUOTE + ", mRtcRoomDes='" + this.mRtcRoomDes + ExtendedMessageFormat.QUOTE + ", mRtcRoomType=" + this.mRtcRoomType + ", mMediaType=" + this.mMediaType + ", mInitiatorUk=" + this.mInitiatorUk + ", mInviteId=" + this.mInviteId + ", mRtcUserId=" + this.mRtcUserId + ", ext=" + this.mRtcExt + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
