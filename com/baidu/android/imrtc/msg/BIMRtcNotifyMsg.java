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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BIMRtcNotifyMsg {
    private static final String TAG = "IMRtcNotifyMsg";

    public static BIMRtcInfo parseJson(Context context, @NonNull JSONObject jSONObject) {
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
            if (optInt == 231) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(RtcConstants.EXTRA_RTC_INFO, ""));
                long optLong = jSONObject2.optLong(BdStatsConstant.SubType.SEQID);
                long optLong2 = jSONObject2.optLong("uk");
                String optString2 = jSONObject2.optString("rtc_device_id");
                int optInt3 = jSONObject2.optInt("invite_id");
                String optString3 = jSONObject2.optString("ext");
                if (optInt2 == 81) {
                    String optString4 = jSONObject2.optString("rtc_appid");
                    RtcUtility.setRtcAppId(context, optString4);
                    String optString5 = jSONObject2.optString("rtc_room_name");
                    RtcUtility.setRtcRoomName(context, optString5);
                    String optString6 = jSONObject2.optString("rtc_room_token");
                    RtcUtility.setRtcRoomToken(context, optString6);
                    String optString7 = jSONObject2.optString("rtc_room_desc");
                    RtcUtility.setRtcRoomDes(context, optString7);
                    int optInt4 = jSONObject2.optInt("rtc_room_type");
                    int optInt5 = jSONObject2.optInt("media_type");
                    long optLong3 = jSONObject2.optLong("rtc_userid");
                    RtcUtility.setRtcUserId(context, optLong3);
                    BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo = new BIMInviteSyncRtcInfo();
                    bIMInviteSyncRtcInfo.setAction(optInt2);
                    bIMInviteSyncRtcInfo.setSeq(optLong);
                    bIMInviteSyncRtcInfo.setRtcRoomId(optString);
                    bIMInviteSyncRtcInfo.setRtcRoomName(optString5);
                    bIMInviteSyncRtcInfo.setRtcRoomDes(optString7);
                    bIMInviteSyncRtcInfo.setRtcRoomToken(optString6);
                    bIMInviteSyncRtcInfo.setRtcAppId(optString4);
                    bIMInviteSyncRtcInfo.setRtcRoomType(optInt4);
                    bIMInviteSyncRtcInfo.setMediaType(optInt5);
                    bIMInviteSyncRtcInfo.setInitiatorUk(optLong2);
                    bIMInviteSyncRtcInfo.setInviteId(optInt3);
                    bIMInviteSyncRtcInfo.setRtcDeviceId(optString2);
                    bIMInviteSyncRtcInfo.setRtcUserId(optLong3);
                    bIMInviteSyncRtcInfo.setRtcExt(optString3);
                    return bIMInviteSyncRtcInfo;
                } else if (optInt2 == 105 || optInt2 == 107) {
                    BIMKickReqSyncRtcInfo bIMKickReqSyncRtcInfo = new BIMKickReqSyncRtcInfo();
                    if (optInt2 == 107) {
                        BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo = new BIMKickResSyncRtcInfo();
                        bIMKickResSyncRtcInfo.setBIMKickedStatus(jSONObject2.optInt("status"));
                        bIMKickReqSyncRtcInfo = bIMKickResSyncRtcInfo;
                    }
                    bIMKickReqSyncRtcInfo.setAction(optInt2);
                    bIMKickReqSyncRtcInfo.setSeq(optLong);
                    bIMKickReqSyncRtcInfo.setRtcRoomId(optString);
                    bIMKickReqSyncRtcInfo.setRtcDeviceId(optString2);
                    bIMKickReqSyncRtcInfo.setRtcExt(optString3);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("kick_user");
                    if (optJSONObject != null) {
                        BIMUser bIMUser = new BIMUser();
                        bIMUser.appId = optJSONObject.optLong("appid");
                        bIMUser.uk = optJSONObject.optLong("uk");
                        bIMUser.cuid = optJSONObject.optString("cuid");
                        bIMUser.thirdUserId = optJSONObject.optString("third_userid");
                        bIMUser.appVersion = optJSONObject.optString("app_version");
                        bIMKickReqSyncRtcInfo.setBIMKickUser(bIMUser);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("kicked_user");
                    if (optJSONObject2 != null) {
                        BIMUser bIMUser2 = new BIMUser();
                        bIMUser2.appId = optJSONObject2.optLong("appid");
                        bIMUser2.uk = optJSONObject2.optLong("uk");
                        bIMUser2.cuid = optJSONObject2.optString("cuid");
                        bIMUser2.thirdUserId = optJSONObject2.optString("third_userid");
                        bIMUser2.appVersion = optJSONObject2.optString("app_version");
                        bIMKickReqSyncRtcInfo.setBIMKickedUser(bIMUser2);
                        return bIMKickReqSyncRtcInfo;
                    }
                    return bIMKickReqSyncRtcInfo;
                } else {
                    BIMSyncRtcInfo bIMSyncRtcInfo = new BIMSyncRtcInfo();
                    bIMSyncRtcInfo.setAction(optInt2);
                    bIMSyncRtcInfo.setSeq(optLong);
                    bIMSyncRtcInfo.setRtcRoomId(optString);
                    bIMSyncRtcInfo.setInitiatorUk(optLong2);
                    bIMSyncRtcInfo.setInviteId(optInt3);
                    bIMSyncRtcInfo.setRtcDeviceId(optString2);
                    bIMSyncRtcInfo.setRtcExt(optString3);
                    if (optInt2 == 85) {
                        bIMSyncRtcInfo.setAnswerType(jSONObject2.optInt("answer_type", -1));
                        return bIMSyncRtcInfo;
                    }
                    return bIMSyncRtcInfo;
                }
            }
            return null;
        } catch (Exception e) {
            LogUtils.e(TAG, "parseJson exception：", e);
            return null;
        }
    }
}
