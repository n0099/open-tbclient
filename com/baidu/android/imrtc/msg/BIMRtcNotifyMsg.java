package com.baidu.android.imrtc.msg;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickResSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMSyncRtcInfo;
import com.baidu.android.imrtc.send.BIMUser;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BIMRtcNotifyMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMRtcNotifyMsg";
    public transient /* synthetic */ FieldHolder $fh;

    public BIMRtcNotifyMsg() {
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

    public static BIMRtcInfo parseJson(Context context, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, context, jSONObject)) != null) {
            return (BIMRtcInfo) invokeLL.objValue;
        }
        try {
            if (context == null) {
                LogUtils.e(TAG, "parseJson context == null ");
                return null;
            }
            LogUtils.d(TAG, "parseJson :" + jSONObject.toString());
            int optInt = jSONObject.optInt("method");
            int optInt2 = jSONObject.optInt("action");
            String optString = jSONObject.optString("rtc_room_id");
            RtcUtility.setRtcRoomId(context, optString);
            String optString2 = jSONObject.optString("source");
            if (optInt == 231) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(RtcConstants.EXTRA_RTC_INFO, ""));
                long optLong = jSONObject2.optLong("seqid");
                long optLong2 = jSONObject2.optLong("uk");
                String optString3 = jSONObject2.optString("rtc_device_id");
                int optInt3 = jSONObject2.optInt("invite_id");
                String optString4 = jSONObject2.optString("ext");
                try {
                    if (optInt2 == 81) {
                        String optString5 = jSONObject2.optString("rtc_appid");
                        RtcUtility.setRtcAppId(context, optString5);
                        String optString6 = jSONObject2.optString(RtcUtility.KEY_RTC_ROOM_NAME);
                        RtcUtility.setRtcRoomName(context, optString6);
                        String optString7 = jSONObject2.optString(RtcUtility.KEY_RTC_ROOM_TOKEN);
                        RtcUtility.setRtcRoomToken(context, optString7);
                        String optString8 = jSONObject2.optString("rtc_room_desc");
                        RtcUtility.setRtcRoomDes(context, optString8);
                        int optInt4 = jSONObject2.optInt("rtc_room_type");
                        int optInt5 = jSONObject2.optInt("media_type");
                        long optLong3 = jSONObject2.optLong("rtc_userid");
                        RtcUtility.setRtcUserId(context, optLong3);
                        BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = new BIMInviteSyncRtcInfo();
                        bIMInviteSyncRtcInfo.setAction(optInt2);
                        bIMInviteSyncRtcInfo.setSeq(optLong);
                        bIMInviteSyncRtcInfo.setRtcRoomId(optString);
                        bIMInviteSyncRtcInfo.setRtcRoomName(optString6);
                        bIMInviteSyncRtcInfo.setRtcRoomDes(optString8);
                        bIMInviteSyncRtcInfo.setRtcRoomToken(optString7);
                        bIMInviteSyncRtcInfo.setRtcAppId(optString5);
                        bIMInviteSyncRtcInfo.setRtcRoomType(optInt4);
                        bIMInviteSyncRtcInfo.setMediaType(optInt5);
                        bIMInviteSyncRtcInfo.setInitiatorUk(optLong2);
                        bIMInviteSyncRtcInfo.setInviteId(optInt3);
                        bIMInviteSyncRtcInfo.setRtcDeviceId(optString3);
                        bIMInviteSyncRtcInfo.setRtcUserId(optLong3);
                        bIMInviteSyncRtcInfo.setSource(optString2);
                        bIMInviteSyncRtcInfo.setRtcExt(optString4);
                        return bIMInviteSyncRtcInfo;
                    }
                    if (optInt2 != 105 && optInt2 != 107) {
                        BIMSyncRtcInfo bIMSyncRtcInfo = new BIMSyncRtcInfo();
                        bIMSyncRtcInfo.setAction(optInt2);
                        bIMSyncRtcInfo.setSeq(optLong);
                        bIMSyncRtcInfo.setRtcRoomId(optString);
                        bIMSyncRtcInfo.setInitiatorUk(optLong2);
                        bIMSyncRtcInfo.setInviteId(optInt3);
                        bIMSyncRtcInfo.setRtcDeviceId(optString3);
                        bIMSyncRtcInfo.setSource(optString2);
                        bIMSyncRtcInfo.setRtcExt(optString4);
                        if (optInt2 == 85) {
                            bIMSyncRtcInfo.setAnswerType(jSONObject2.optInt("answer_type", -1));
                        }
                        return bIMSyncRtcInfo;
                    }
                    BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo = new BIMKickReqSyncRtcInfo();
                    if (optInt2 == 107) {
                        BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo2 = new BIMKickResSyncRtcInfo();
                        bIMKickResSyncRtcInfo2.setBIMKickedStatus(jSONObject2.optInt("status"));
                        bIMKickResSyncRtcInfo = bIMKickResSyncRtcInfo2;
                    }
                    bIMKickResSyncRtcInfo.setAction(optInt2);
                    bIMKickResSyncRtcInfo.setSeq(optLong);
                    bIMKickResSyncRtcInfo.setRtcRoomId(optString);
                    bIMKickResSyncRtcInfo.setRtcDeviceId(optString3);
                    bIMKickResSyncRtcInfo.setSource(optString2);
                    bIMKickResSyncRtcInfo.setRtcExt(optString4);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("kick_user");
                    if (optJSONObject != null) {
                        BIMUser bIMUser = new BIMUser();
                        bIMUser.appId = optJSONObject.optLong("appid");
                        bIMUser.uk = optJSONObject.optLong("uk");
                        bIMUser.cuid = optJSONObject.optString("cuid");
                        bIMUser.thirdUserId = optJSONObject.optString("third_userid");
                        bIMUser.appVersion = optJSONObject.optString("app_version");
                        bIMKickResSyncRtcInfo.setBIMKickUser(bIMUser);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("kicked_user");
                    if (optJSONObject2 != null) {
                        BIMUser bIMUser2 = new BIMUser();
                        bIMUser2.appId = optJSONObject2.optLong("appid");
                        bIMUser2.uk = optJSONObject2.optLong("uk");
                        bIMUser2.cuid = optJSONObject2.optString("cuid");
                        bIMUser2.thirdUserId = optJSONObject2.optString("third_userid");
                        bIMUser2.appVersion = optJSONObject2.optString("app_version");
                        bIMKickResSyncRtcInfo.setBIMKickedUser(bIMUser2);
                    }
                    return bIMKickResSyncRtcInfo;
                } catch (Exception e2) {
                    e = e2;
                    LogUtils.e(TAG, "parseJson exception：", e);
                    return null;
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }
}
