package com.baidu.android.imrtc.msg;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMSyncRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.Utility;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class BIMRtcNotifyMsg {
    private static final String TAG = "IMRtcNotifyMsg";

    public static BIMRtcInfo parseJson(Context context, @NonNull JSONObject jSONObject) {
        BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo;
        try {
            if (context == null) {
                LogUtils.e(TAG, "parseJson context == null ");
                bIMInviteSyncRtcInfo = null;
            } else {
                LogUtils.d(TAG, "parseJson :" + jSONObject.toString());
                int optInt = jSONObject.optInt("method");
                int optInt2 = jSONObject.optInt("action");
                String optString = jSONObject.optString(RtcConstants.EXTRA_RTC_ROOM_ID);
                Utility.setRtcRoomId(context, optString);
                if (optInt == 231) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(RtcConstants.EXTRA_RTC_INFO, ""));
                    long optLong = jSONObject2.optLong(BdStatsConstant.SubType.SEQID);
                    long optLong2 = jSONObject2.optLong("uk");
                    String optString2 = jSONObject2.optString("rtc_device_id");
                    int optInt3 = jSONObject2.optInt("invite_id");
                    String optString3 = jSONObject2.optString("ext");
                    if (optInt2 == 81) {
                        String optString4 = jSONObject2.optString("rtc_appid");
                        Utility.setRtcAppId(context, optString4);
                        String optString5 = jSONObject2.optString("rtc_room_name");
                        Utility.setRtcRoomName(context, optString5);
                        String optString6 = jSONObject2.optString("rtc_room_token");
                        Utility.setRtcRoomToken(context, optString6);
                        String optString7 = jSONObject2.optString("rtc_room_desc");
                        Utility.setRtcRoomDes(context, optString7);
                        int optInt4 = jSONObject2.optInt("rtc_room_type");
                        int optInt5 = jSONObject2.optInt("media_type");
                        long optLong3 = jSONObject2.optLong("rtc_userid");
                        Utility.setRtcUserId(context, optLong3);
                        BIMInviteSyncRtcInfo bIMInviteSyncRtcInfo2 = new BIMInviteSyncRtcInfo();
                        bIMInviteSyncRtcInfo2.setAction(optInt2);
                        bIMInviteSyncRtcInfo2.setSeq(optLong);
                        bIMInviteSyncRtcInfo2.setRtcRoomId(optString);
                        bIMInviteSyncRtcInfo2.setRtcRoomName(optString5);
                        bIMInviteSyncRtcInfo2.setRtcRoomDes(optString7);
                        bIMInviteSyncRtcInfo2.setRtcRoomToken(optString6);
                        bIMInviteSyncRtcInfo2.setRtcAppId(optString4);
                        bIMInviteSyncRtcInfo2.setRtcRoomType(optInt4);
                        bIMInviteSyncRtcInfo2.setMediaType(optInt5);
                        bIMInviteSyncRtcInfo2.setInitiatorUk(optLong2);
                        bIMInviteSyncRtcInfo2.setInviteId(optInt3);
                        bIMInviteSyncRtcInfo2.setRtcDeviceId(optString2);
                        bIMInviteSyncRtcInfo2.setRtcUserId(optLong3);
                        bIMInviteSyncRtcInfo2.setRtcExt(optString3);
                        bIMInviteSyncRtcInfo = bIMInviteSyncRtcInfo2;
                    } else {
                        BIMSyncRtcInfo bIMSyncRtcInfo = new BIMSyncRtcInfo();
                        bIMSyncRtcInfo.setAction(optInt2);
                        bIMSyncRtcInfo.setSeq(optLong);
                        bIMSyncRtcInfo.setRtcRoomId(optString);
                        bIMSyncRtcInfo.setInitiatorUk(optLong2);
                        bIMSyncRtcInfo.setInviteId(optInt3);
                        bIMSyncRtcInfo.setRtcDeviceId(optString2);
                        bIMSyncRtcInfo.setRtcExt(optString3);
                        bIMInviteSyncRtcInfo = bIMSyncRtcInfo;
                        if (optInt2 == 85) {
                            bIMSyncRtcInfo.setAnswerType(jSONObject2.optInt("answer_type", -1));
                            bIMInviteSyncRtcInfo = bIMSyncRtcInfo;
                        }
                    }
                } else {
                    bIMInviteSyncRtcInfo = null;
                }
            }
            return bIMInviteSyncRtcInfo;
        } catch (Exception e) {
            LogUtils.e(TAG, "parseJson exception：", e);
            return null;
        }
    }
}
