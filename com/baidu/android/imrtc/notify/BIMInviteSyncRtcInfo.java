package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMInviteSyncRtcInfo extends BIMSyncRtcInfo {
    public static final String TAG = "IMInviteRtcInfo";
    public int mMediaType;
    public String mRtcAppId;
    public String mRtcRoomDes;
    public String mRtcRoomName;
    public String mRtcRoomToken;
    public int mRtcRoomType;
    public long mRtcUserId;

    public String createOpenVideoJson() {
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

    public int getMediaType() {
        return this.mMediaType;
    }

    public String getRtcAppId() {
        return this.mRtcAppId;
    }

    public String getRtcRoomDes() {
        return this.mRtcRoomDes;
    }

    public String getRtcRoomName() {
        return this.mRtcRoomName;
    }

    public String getRtcRoomToken() {
        return this.mRtcRoomToken;
    }

    public int getRtcRoomType() {
        return this.mRtcRoomType;
    }

    public long getRtcUserId() {
        return this.mRtcUserId;
    }

    public void setMediaType(int i2) {
        this.mMediaType = i2;
    }

    public void setRtcAppId(String str) {
        this.mRtcAppId = str;
    }

    public void setRtcRoomDes(String str) {
        this.mRtcRoomDes = str;
    }

    public void setRtcRoomName(String str) {
        this.mRtcRoomName = str;
    }

    public void setRtcRoomToken(String str) {
        this.mRtcRoomToken = str;
    }

    public void setRtcRoomType(int i2) {
        this.mRtcRoomType = i2;
    }

    public void setRtcUserId(long j) {
        this.mRtcUserId = j;
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
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

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMInviteSyncRtcInfo{" + super.toString() + ", mRtcRoomName='" + this.mRtcRoomName + "', mRtcRoomToken='" + this.mRtcRoomToken + "', mRtcRoomDes='" + this.mRtcRoomDes + "', mRtcRoomType=" + this.mRtcRoomType + ", mMediaType=" + this.mMediaType + ", mInitiatorUk=" + this.mInitiatorUk + ", mInviteId=" + this.mInviteId + ", mRtcUserId=" + this.mRtcUserId + ", ext=" + this.mRtcExt + '}';
    }
}
